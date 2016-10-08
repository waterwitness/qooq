package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawable.base.DrawableWithCaches;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimatedDrawable
  extends Drawable
  implements AnimatableDrawable, DrawableWithCaches
{
  private static final int NO_FRAME = -1;
  private static final int POLL_FOR_RENDERED_FRAME_MS = 5;
  private static final Class<?> TAG = AnimatedDrawable.class;
  private static final long WATCH_DOG_TIMER_MIN_TIMEOUT_MS = 1000L;
  private static final long WATCH_DOG_TIMER_POLL_INTERVAL_MS = 2000L;
  private AnimatedDrawableCachingBackend mAnimatedDrawableBackend;
  private final AnimatedDrawableDiagnostics mAnimatedDrawableDiagnostics;
  private boolean mApplyTransformation;
  private final Rect mDstRect = new Rect();
  private final int mDurationMs;
  private final int mFrameCount;
  private boolean mHaveWatchdogScheduled;
  private final Runnable mInvalidateTask = new Runnable()
  {
    public void run()
    {
      FLog.v(AnimatedDrawable.TAG, "(%s) Invalidate Task", AnimatedDrawable.this.mLogId);
      AnimatedDrawable.this.mInvalidateTaskScheduled = false;
      AnimatedDrawable.this.doInvalidateSelf();
    }
  };
  private boolean mInvalidateTaskScheduled;
  private boolean mIsRunning;
  private CloseableReference<Bitmap> mLastDrawnFrame;
  private int mLastDrawnFrameMonotonicNumber = -1;
  private int mLastDrawnFrameNumber = -1;
  private long mLastInvalidateTimeMs = -1L;
  private volatile String mLogId;
  private final MonotonicClock mMonotonicClock;
  private final Runnable mNextFrameTask = new Runnable()
  {
    public void run()
    {
      FLog.v(AnimatedDrawable.TAG, "(%s) Next Frame Task", AnimatedDrawable.this.mLogId);
      AnimatedDrawable.this.onNextFrame();
    }
  };
  private long mNextFrameTaskMs = -1L;
  private final Paint mPaint = new Paint(6);
  private int mPendingRenderedFrameMonotonicNumber;
  private int mPendingRenderedFrameNumber;
  private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;
  private int mScheduledFrameMonotonicNumber;
  private int mScheduledFrameNumber;
  private final Runnable mStartTask = new Runnable()
  {
    public void run()
    {
      AnimatedDrawable.this.onStart();
    }
  };
  private long mStartTimeMs;
  private float mSx = 1.0F;
  private float mSy = 1.0F;
  private final int mTotalLoops;
  private final Paint mTransparentPaint;
  private boolean mWaitingForDraw;
  private final Runnable mWatchdogTask = new Runnable()
  {
    public void run()
    {
      FLog.v(AnimatedDrawable.TAG, "(%s) Watchdog Task", AnimatedDrawable.this.mLogId);
      AnimatedDrawable.this.doWatchdogCheck();
    }
  };
  
  public AnimatedDrawable(ScheduledExecutorService paramScheduledExecutorService, AnimatedDrawableCachingBackend paramAnimatedDrawableCachingBackend, AnimatedDrawableDiagnostics paramAnimatedDrawableDiagnostics, MonotonicClock paramMonotonicClock)
  {
    this.mScheduledExecutorServiceForUiThread = paramScheduledExecutorService;
    this.mAnimatedDrawableBackend = paramAnimatedDrawableCachingBackend;
    this.mAnimatedDrawableDiagnostics = paramAnimatedDrawableDiagnostics;
    this.mMonotonicClock = paramMonotonicClock;
    this.mDurationMs = this.mAnimatedDrawableBackend.getDurationMs();
    this.mFrameCount = this.mAnimatedDrawableBackend.getFrameCount();
    this.mAnimatedDrawableDiagnostics.setBackend(this.mAnimatedDrawableBackend);
    this.mTotalLoops = this.mAnimatedDrawableBackend.getLoopCount();
    this.mTransparentPaint = new Paint();
    this.mTransparentPaint.setColor(0);
    this.mTransparentPaint.setStyle(Paint.Style.FILL);
    resetToPreviewFrame();
  }
  
  private void computeAndScheduleNextFrame(boolean paramBoolean)
  {
    if (this.mDurationMs == 0) {}
    long l;
    int j;
    int k;
    int i;
    label126:
    do
    {
      do
      {
        return;
        l = this.mMonotonicClock.now();
        j = (int)((l - this.mStartTimeMs) / this.mDurationMs);
      } while ((this.mTotalLoops > 0) && (j >= this.mTotalLoops));
      k = (int)((l - this.mStartTimeMs) % this.mDurationMs);
      int m = this.mAnimatedDrawableBackend.getFrameForTimestampMs(k);
      if (this.mScheduledFrameNumber != m) {}
      for (i = 1;; i = 0)
      {
        this.mScheduledFrameNumber = m;
        this.mScheduledFrameMonotonicNumber = (this.mFrameCount * j + m);
        if (!paramBoolean) {
          break;
        }
        if (i == 0) {
          break label126;
        }
        doInvalidateSelf();
        return;
      }
      i = this.mAnimatedDrawableBackend.getTimestampMsForFrame(this.mScheduledFrameNumber) + this.mAnimatedDrawableBackend.getDurationMsForFrame(this.mScheduledFrameNumber) - k;
      j = this.mScheduledFrameNumber;
      k = this.mFrameCount;
      l += i;
    } while ((this.mNextFrameTaskMs != -1L) && (this.mNextFrameTaskMs <= l));
    FLog.v(TAG, "(%s) Next frame (%d) in %d ms", this.mLogId, Integer.valueOf((j + 1) % k), Integer.valueOf(i));
    unscheduleSelf(this.mNextFrameTask);
    scheduleSelf(this.mNextFrameTask, l);
    this.mNextFrameTaskMs = l;
  }
  
  private void doInvalidateSelf()
  {
    this.mWaitingForDraw = true;
    this.mLastInvalidateTimeMs = this.mMonotonicClock.now();
    invalidateSelf();
  }
  
  private void doWatchdogCheck()
  {
    this.mHaveWatchdogScheduled = false;
    if (!this.mIsRunning) {
      return;
    }
    long l = this.mMonotonicClock.now();
    int i;
    if ((this.mWaitingForDraw) && (l - this.mLastInvalidateTimeMs > 1000L))
    {
      i = 1;
      if ((this.mNextFrameTaskMs == -1L) || (l - this.mNextFrameTaskMs <= 1000L)) {
        break label93;
      }
    }
    label93:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        break label98;
      }
      dropCaches();
      doInvalidateSelf();
      return;
      i = 0;
      break;
    }
    label98:
    this.mScheduledExecutorServiceForUiThread.schedule(this.mWatchdogTask, 2000L, TimeUnit.MILLISECONDS);
    this.mHaveWatchdogScheduled = true;
  }
  
  private void onNextFrame()
  {
    this.mNextFrameTaskMs = -1L;
    if (!this.mIsRunning) {}
    while (this.mDurationMs == 0) {
      return;
    }
    this.mAnimatedDrawableDiagnostics.onNextFrameMethodBegin();
    try
    {
      computeAndScheduleNextFrame(true);
      return;
    }
    finally
    {
      this.mAnimatedDrawableDiagnostics.onNextFrameMethodEnd();
    }
  }
  
  private void onStart()
  {
    if (!this.mIsRunning) {
      return;
    }
    this.mAnimatedDrawableDiagnostics.onStartMethodBegin();
    try
    {
      this.mStartTimeMs = this.mMonotonicClock.now();
      this.mScheduledFrameNumber = 0;
      this.mScheduledFrameMonotonicNumber = 0;
      long l = this.mStartTimeMs + this.mAnimatedDrawableBackend.getDurationMsForFrame(0);
      scheduleSelf(this.mNextFrameTask, l);
      this.mNextFrameTaskMs = l;
      doInvalidateSelf();
      return;
    }
    finally
    {
      this.mAnimatedDrawableDiagnostics.onStartMethodEnd();
    }
  }
  
  private boolean renderFrame(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    CloseableReference localCloseableReference = this.mAnimatedDrawableBackend.getBitmapForFrame(paramInt1);
    if (localCloseableReference != null)
    {
      paramCanvas.drawBitmap((Bitmap)localCloseableReference.get(), 0.0F, 0.0F, this.mPaint);
      if (this.mLastDrawnFrame != null) {
        this.mLastDrawnFrame.close();
      }
      if ((this.mIsRunning) && (paramInt2 > this.mLastDrawnFrameMonotonicNumber))
      {
        int i = paramInt2 - this.mLastDrawnFrameMonotonicNumber - 1;
        this.mAnimatedDrawableDiagnostics.incrementDrawnFrames(1);
        this.mAnimatedDrawableDiagnostics.incrementDroppedFrames(i);
        if (i > 0) {
          FLog.v(TAG, "(%s) Dropped %d frames", this.mLogId, Integer.valueOf(i));
        }
      }
      this.mLastDrawnFrame = localCloseableReference;
      this.mLastDrawnFrameNumber = paramInt1;
      this.mLastDrawnFrameMonotonicNumber = paramInt2;
      FLog.v(TAG, "(%s) Drew frame %d", this.mLogId, Integer.valueOf(paramInt1));
      return true;
    }
    return false;
  }
  
  private void resetToPreviewFrame()
  {
    this.mScheduledFrameNumber = this.mAnimatedDrawableBackend.getFrameForPreview();
    this.mScheduledFrameMonotonicNumber = this.mScheduledFrameNumber;
    this.mPendingRenderedFrameNumber = -1;
    this.mPendingRenderedFrameMonotonicNumber = -1;
  }
  
  private void scheduleInvalidatePoll()
  {
    if (this.mInvalidateTaskScheduled) {
      return;
    }
    this.mInvalidateTaskScheduled = true;
    scheduleSelf(this.mInvalidateTask, 5L);
  }
  
  public ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener()
  {
    new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AnimatedDrawable.this.setLevel(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    };
  }
  
  public ValueAnimator createValueAnimator()
  {
    int i = this.mAnimatedDrawableBackend.getLoopCount();
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { 0, this.mDurationMs });
    localValueAnimator.setDuration(this.mDurationMs);
    if (i != 0) {}
    for (;;)
    {
      localValueAnimator.setRepeatCount(i);
      localValueAnimator.setRepeatMode(1);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.addUpdateListener(createAnimatorUpdateListener());
      return localValueAnimator;
      i = -1;
    }
  }
  
  public ValueAnimator createValueAnimator(int paramInt)
  {
    ValueAnimator localValueAnimator = createValueAnimator();
    localValueAnimator.setRepeatCount(Math.max(paramInt / this.mAnimatedDrawableBackend.getDurationMs(), 1));
    return localValueAnimator;
  }
  
  public boolean didLastDrawRender()
  {
    return this.mLastDrawnFrame != null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mAnimatedDrawableDiagnostics.onDrawMethodBegin();
    for (;;)
    {
      boolean bool2;
      try
      {
        this.mWaitingForDraw = false;
        if ((this.mIsRunning) && (!this.mHaveWatchdogScheduled))
        {
          this.mScheduledExecutorServiceForUiThread.schedule(this.mWatchdogTask, 2000L, TimeUnit.MILLISECONDS);
          this.mHaveWatchdogScheduled = true;
        }
        Object localObject;
        if (this.mApplyTransformation)
        {
          this.mDstRect.set(getBounds());
          if (!this.mDstRect.isEmpty())
          {
            localObject = this.mAnimatedDrawableBackend.forNewBounds(this.mDstRect);
            if (localObject != this.mAnimatedDrawableBackend)
            {
              this.mAnimatedDrawableBackend.dropCaches();
              this.mAnimatedDrawableBackend = ((AnimatedDrawableCachingBackend)localObject);
              this.mAnimatedDrawableDiagnostics.setBackend((AnimatedDrawableCachingBackend)localObject);
            }
            this.mSx = (this.mDstRect.width() / this.mAnimatedDrawableBackend.getRenderedWidth());
            this.mSy = (this.mDstRect.height() / this.mAnimatedDrawableBackend.getRenderedHeight());
            this.mApplyTransformation = false;
          }
        }
        boolean bool3 = this.mDstRect.isEmpty();
        if (bool3) {
          return;
        }
        paramCanvas.save();
        paramCanvas.scale(this.mSx, this.mSy);
        bool2 = false;
        if (this.mPendingRenderedFrameNumber != -1)
        {
          bool3 = renderFrame(paramCanvas, this.mPendingRenderedFrameNumber, this.mPendingRenderedFrameMonotonicNumber);
          bool2 = false | bool3;
          if (bool3)
          {
            FLog.v(TAG, "(%s) Rendered pending frame %d", this.mLogId, Integer.valueOf(this.mPendingRenderedFrameNumber));
            this.mPendingRenderedFrameNumber = -1;
            this.mPendingRenderedFrameMonotonicNumber = -1;
          }
        }
        else
        {
          bool1 = bool2;
          if (this.mPendingRenderedFrameNumber == -1)
          {
            if (this.mIsRunning) {
              computeAndScheduleNextFrame(false);
            }
            bool3 = renderFrame(paramCanvas, this.mScheduledFrameNumber, this.mScheduledFrameMonotonicNumber);
            bool2 |= bool3;
            if (!bool3) {
              break label605;
            }
            FLog.v(TAG, "(%s) Rendered current frame %d", this.mLogId, Integer.valueOf(this.mScheduledFrameNumber));
            bool1 = bool2;
            if (this.mIsRunning)
            {
              computeAndScheduleNextFrame(true);
              bool1 = bool2;
            }
          }
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (this.mLastDrawnFrame != null)
            {
              paramCanvas.drawBitmap((Bitmap)this.mLastDrawnFrame.get(), 0.0F, 0.0F, this.mPaint);
              bool2 = true;
              FLog.v(TAG, "(%s) Rendered last known frame %d", this.mLogId, Integer.valueOf(this.mLastDrawnFrameNumber));
            }
          }
          bool1 = bool2;
          if (!bool2)
          {
            localObject = this.mAnimatedDrawableBackend.getPreviewBitmap();
            bool1 = bool2;
            if (localObject != null)
            {
              paramCanvas.drawBitmap((Bitmap)((CloseableReference)localObject).get(), 0.0F, 0.0F, this.mPaint);
              ((CloseableReference)localObject).close();
              FLog.v(TAG, "(%s) Rendered preview frame", this.mLogId);
              bool1 = true;
            }
          }
          if (!bool1)
          {
            paramCanvas.drawRect(0.0F, 0.0F, this.mDstRect.width(), this.mDstRect.height(), this.mTransparentPaint);
            FLog.v(TAG, "(%s) Failed to draw a frame", this.mLogId);
          }
          paramCanvas.restore();
          this.mAnimatedDrawableDiagnostics.drawDebugOverlay(paramCanvas, this.mDstRect);
          return;
        }
        FLog.v(TAG, "(%s) Trying again later for pending %d", this.mLogId, Integer.valueOf(this.mPendingRenderedFrameNumber));
        scheduleInvalidatePoll();
        continue;
        FLog.v(TAG, "(%s) Trying again later for current %d", this.mLogId, Integer.valueOf(this.mScheduledFrameNumber));
      }
      finally
      {
        this.mAnimatedDrawableDiagnostics.onDrawMethodEnd();
      }
      label605:
      this.mPendingRenderedFrameNumber = this.mScheduledFrameNumber;
      this.mPendingRenderedFrameMonotonicNumber = this.mScheduledFrameMonotonicNumber;
      scheduleInvalidatePoll();
      boolean bool1 = bool2;
    }
  }
  
  public void dropCaches()
  {
    FLog.v(TAG, "(%s) Dropping caches", this.mLogId);
    if (this.mLastDrawnFrame != null)
    {
      this.mLastDrawnFrame.close();
      this.mLastDrawnFrame = null;
      this.mLastDrawnFrameNumber = -1;
      this.mLastDrawnFrameMonotonicNumber = -1;
    }
    this.mAnimatedDrawableBackend.dropCaches();
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.mLastDrawnFrame != null)
    {
      this.mLastDrawnFrame.close();
      this.mLastDrawnFrame = null;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.mAnimatedDrawableBackend.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mAnimatedDrawableBackend.getWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @VisibleForTesting
  int getScheduledFrameNumber()
  {
    return this.mScheduledFrameNumber;
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  @VisibleForTesting
  boolean isWaitingForDraw()
  {
    return this.mWaitingForDraw;
  }
  
  @VisibleForTesting
  boolean isWaitingForNextFrame()
  {
    return this.mNextFrameTaskMs != -1L;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyTransformation = true;
    if (this.mLastDrawnFrame != null)
    {
      this.mLastDrawnFrame.close();
      this.mLastDrawnFrame = null;
    }
    this.mLastDrawnFrameNumber = -1;
    this.mLastDrawnFrameMonotonicNumber = -1;
    this.mAnimatedDrawableBackend.dropCaches();
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.mIsRunning) {}
    do
    {
      return false;
      paramInt = this.mAnimatedDrawableBackend.getFrameForTimestampMs(paramInt);
    } while (paramInt == this.mScheduledFrameNumber);
    try
    {
      this.mScheduledFrameNumber = paramInt;
      this.mScheduledFrameMonotonicNumber = paramInt;
      doInvalidateSelf();
      return true;
    }
    catch (IllegalStateException localIllegalStateException) {}
    return false;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    doInvalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    doInvalidateSelf();
  }
  
  public void setLogId(String paramString)
  {
    this.mLogId = paramString;
  }
  
  public void start()
  {
    if ((this.mDurationMs == 0) || (this.mFrameCount <= 1)) {
      return;
    }
    this.mIsRunning = true;
    scheduleSelf(this.mStartTask, this.mMonotonicClock.now());
  }
  
  public void stop()
  {
    this.mIsRunning = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */