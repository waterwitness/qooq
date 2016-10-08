package com.facebook.imagepipeline.animated.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

public class AnimatedDrawableDiagnosticsImpl
  implements AnimatedDrawableDiagnostics
{
  private static final Class<?> TAG = AnimatedDrawableDiagnostics.class;
  private AnimatedDrawableCachingBackend mAnimatedDrawableBackend;
  private final AnimatedDrawableUtil mAnimatedDrawableUtil;
  private final TextPaint mDebugTextPaint;
  private final DisplayMetrics mDisplayMetrics;
  private final RollingStat mDrawnFrames;
  private final RollingStat mDroppedFramesStat;
  private long mLastTimeStamp;
  private final StringBuilder sbTemp;
  
  public AnimatedDrawableDiagnosticsImpl(AnimatedDrawableUtil paramAnimatedDrawableUtil, DisplayMetrics paramDisplayMetrics)
  {
    this.mAnimatedDrawableUtil = paramAnimatedDrawableUtil;
    this.mDisplayMetrics = paramDisplayMetrics;
    this.mDroppedFramesStat = new RollingStat();
    this.mDrawnFrames = new RollingStat();
    this.sbTemp = new StringBuilder();
    this.mDebugTextPaint = new TextPaint();
    this.mDebugTextPaint.setColor(-16776961);
    this.mDebugTextPaint.setTextSize(convertDpToPx(14));
  }
  
  private int convertDpToPx(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, this.mDisplayMetrics);
  }
  
  public void drawDebugOverlay(Canvas paramCanvas, Rect paramRect)
  {
    int i = this.mDroppedFramesStat.getSum(10);
    int m = this.mDrawnFrames.getSum(10);
    int i2 = m + i;
    i = convertDpToPx(10);
    int j = i;
    int n = convertDpToPx(20);
    int i1 = convertDpToPx(5);
    int k = j;
    if (i2 > 0)
    {
      k = m * 100 / i2;
      this.sbTemp.setLength(0);
      this.sbTemp.append(k);
      this.sbTemp.append("%");
      paramCanvas.drawText(this.sbTemp, 0, this.sbTemp.length(), j, n, this.mDebugTextPaint);
      k = (int)(j + this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length())) + i1;
    }
    j = this.mAnimatedDrawableBackend.getMemoryUsage();
    this.sbTemp.setLength(0);
    this.mAnimatedDrawableUtil.appendMemoryString(this.sbTemp, j);
    float f = this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length());
    m = k;
    j = n;
    if (k + f > paramRect.width())
    {
      k = i;
      j = (int)(n + (this.mDebugTextPaint.getTextSize() + i1));
      m = k;
    }
    paramCanvas.drawText(this.sbTemp, 0, this.sbTemp.length(), m, j, this.mDebugTextPaint);
    n = (int)(m + f) + i1;
    this.sbTemp.setLength(0);
    this.mAnimatedDrawableBackend.appendDebugOptionString(this.sbTemp);
    f = this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length());
    m = n;
    k = j;
    if (n + f > paramRect.width())
    {
      k = (int)(j + (this.mDebugTextPaint.getTextSize() + i1));
      m = i;
    }
    paramCanvas.drawText(this.sbTemp, 0, this.sbTemp.length(), m, k, this.mDebugTextPaint);
  }
  
  public void incrementDrawnFrames(int paramInt)
  {
    this.mDrawnFrames.incrementStats(paramInt);
  }
  
  public void incrementDroppedFrames(int paramInt)
  {
    this.mDroppedFramesStat.incrementStats(paramInt);
    if (paramInt > 0) {
      FLog.v(TAG, "Dropped %d frames", Integer.valueOf(paramInt));
    }
  }
  
  public void onDrawMethodBegin()
  {
    this.mLastTimeStamp = SystemClock.elapsedRealtime();
  }
  
  public void onDrawMethodEnd()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.mLastTimeStamp;
    FLog.v(TAG, "draw took %d", Long.valueOf(l1 - l2));
  }
  
  public void onNextFrameMethodBegin()
  {
    this.mLastTimeStamp = SystemClock.elapsedRealtime();
  }
  
  public void onNextFrameMethodEnd()
  {
    long l = SystemClock.elapsedRealtime() - this.mLastTimeStamp;
    if (l > 3L) {
      FLog.v(TAG, "onNextFrame took %d", Long.valueOf(l));
    }
  }
  
  public void onStartMethodBegin()
  {
    this.mLastTimeStamp = SystemClock.elapsedRealtime();
  }
  
  public void onStartMethodEnd()
  {
    long l = SystemClock.elapsedRealtime() - this.mLastTimeStamp;
    if (l > 3L) {
      FLog.v(TAG, "onStart took %d", Long.valueOf(l));
    }
  }
  
  public void setBackend(AnimatedDrawableCachingBackend paramAnimatedDrawableCachingBackend)
  {
    this.mAnimatedDrawableBackend = paramAnimatedDrawableCachingBackend;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\impl\AnimatedDrawableDiagnosticsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */