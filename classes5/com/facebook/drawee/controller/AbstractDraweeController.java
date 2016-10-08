package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaser.Releasable;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.gestures.GestureDetector.ClickListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractDraweeController<T, INFO>
  implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener
{
  private static final Class<?> TAG = AbstractDraweeController.class;
  private Object mCallerContext;
  @Nullable
  private ControllerListener<INFO> mControllerListener;
  @Nullable
  private Drawable mControllerOverlay;
  @Nullable
  private DataSource<T> mDataSource;
  private final DeferredReleaser mDeferredReleaser;
  @Nullable
  private Drawable mDrawable;
  private final DraweeEventTracker mEventTracker = new DraweeEventTracker();
  @Nullable
  private T mFetchedImage;
  @Nullable
  private GestureDetector mGestureDetector;
  private boolean mHasFetchFailed;
  private String mId;
  private boolean mIsAttached;
  private boolean mIsRequestSubmitted;
  private boolean mRetainImageOnFailure;
  @Nullable
  private RetryManager mRetryManager;
  @Nullable
  private SettableDraweeHierarchy mSettableDraweeHierarchy;
  private final Executor mUiThreadImmediateExecutor;
  
  public AbstractDraweeController(DeferredReleaser paramDeferredReleaser, Executor paramExecutor, String paramString, Object paramObject)
  {
    this.mDeferredReleaser = paramDeferredReleaser;
    this.mUiThreadImmediateExecutor = paramExecutor;
    init(paramString, paramObject);
  }
  
  private void init(String paramString, Object paramObject)
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
    if (this.mDeferredReleaser != null) {
      this.mDeferredReleaser.cancelDeferredRelease(this);
    }
    this.mIsAttached = false;
    releaseFetch();
    this.mRetainImageOnFailure = false;
    if (this.mRetryManager != null) {
      this.mRetryManager.init();
    }
    if (this.mGestureDetector != null)
    {
      this.mGestureDetector.init();
      this.mGestureDetector.setClickListener(this);
    }
    if ((this.mControllerListener instanceof InternalForwardingListener)) {
      ((InternalForwardingListener)this.mControllerListener).clearListeners();
    }
    for (;;)
    {
      if (this.mSettableDraweeHierarchy != null)
      {
        this.mSettableDraweeHierarchy.reset();
        this.mSettableDraweeHierarchy.setControllerOverlay(null);
        this.mSettableDraweeHierarchy = null;
      }
      this.mControllerOverlay = null;
      if (FLog.isLoggable(2)) {
        FLog.v(TAG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, paramString);
      }
      this.mId = paramString;
      this.mCallerContext = paramObject;
      return;
      this.mControllerListener = null;
    }
  }
  
  private boolean isExpectedDataSource(String paramString, DataSource<T> paramDataSource)
  {
    return (paramString.equals(this.mId)) && (paramDataSource == this.mDataSource) && (this.mIsRequestSubmitted);
  }
  
  private void logMessageAndFailure(String paramString, Throwable paramThrowable)
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramString, paramThrowable);
    }
  }
  
  private void logMessageAndImage(String paramString, T paramT)
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: %s: image: %s %x", new Object[] { Integer.valueOf(System.identityHashCode(this)), this.mId, paramString, getImageClass(paramT), Integer.valueOf(getImageHash(paramT)) });
    }
  }
  
  private void onFailureInternal(String paramString, DataSource<T> paramDataSource, Throwable paramThrowable, boolean paramBoolean)
  {
    if (!isExpectedDataSource(paramString, paramDataSource))
    {
      logMessageAndFailure("ignore_old_datasource @ onFailure", paramThrowable);
      paramDataSource.close();
      return;
    }
    paramDataSource = this.mEventTracker;
    if (paramBoolean)
    {
      paramString = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE;
      paramDataSource.recordEvent(paramString);
      if (!paramBoolean) {
        break label149;
      }
      logMessageAndFailure("final_failed @ onFailure", paramThrowable);
      this.mDataSource = null;
      this.mHasFetchFailed = true;
      if ((!this.mRetainImageOnFailure) || (this.mDrawable == null)) {
        break label116;
      }
      this.mSettableDraweeHierarchy.setImage(this.mDrawable, 1.0F, true);
    }
    for (;;)
    {
      getControllerListener().onFailure(this.mId, paramThrowable);
      return;
      paramString = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT;
      break;
      label116:
      if (shouldRetryOnTap()) {
        this.mSettableDraweeHierarchy.setRetry(paramThrowable);
      } else {
        this.mSettableDraweeHierarchy.setFailure(paramThrowable);
      }
    }
    label149:
    logMessageAndFailure("intermediate_failed @ onFailure", paramThrowable);
    getControllerListener().onIntermediateImageFailed(this.mId, paramThrowable);
  }
  
  private void onNewResultInternal(String paramString, DataSource<T> paramDataSource, @Nullable T paramT, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!isExpectedDataSource(paramString, paramDataSource))
    {
      logMessageAndImage("ignore_old_datasource @ onNewResult", paramT);
      releaseImage(paramT);
      paramDataSource.close();
      return;
    }
    localObject2 = this.mEventTracker;
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = DraweeEventTracker.Event.ON_DATASOURCE_RESULT;
      label46:
      ((DraweeEventTracker)localObject2).recordEvent((DraweeEventTracker.Event)localObject1);
    }
    for (;;)
    {
      try
      {
        localObject1 = createDrawable(paramT);
        paramDataSource = this.mFetchedImage;
        localObject2 = this.mDrawable;
        this.mFetchedImage = paramT;
        this.mDrawable = ((Drawable)localObject1);
        if (!paramBoolean1) {}
      }
      catch (Exception localException)
      {
        logMessageAndImage("drawable_failed @ onNewResult", paramT);
        releaseImage(paramT);
        onFailureInternal(paramString, paramDataSource, localException, paramBoolean1);
        return;
      }
      try
      {
        logMessageAndImage("set_final_result @ onNewResult", paramT);
        this.mDataSource = null;
        this.mSettableDraweeHierarchy.setImage((Drawable)localObject1, 1.0F, paramBoolean2);
        getControllerListener().onFinalImageSet(paramString, getImageInfo(paramT), getAnimatable());
        return;
      }
      finally
      {
        if ((localObject2 == null) || (localObject2 == localException)) {
          break label268;
        }
        releaseDrawable((Drawable)localObject2);
        if ((paramDataSource == null) || (paramDataSource == paramT)) {
          break label290;
        }
        logMessageAndImage("release_previous_result @ onNewResult", paramDataSource);
        releaseImage(paramDataSource);
      }
      localObject1 = DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT;
      break label46;
      logMessageAndImage("set_intermediate_result @ onNewResult", paramT);
      this.mSettableDraweeHierarchy.setImage(localException, paramFloat, paramBoolean2);
      getControllerListener().onIntermediateImageSet(paramString, getImageInfo(paramT));
    }
  }
  
  private void onProgressUpdateInternal(String paramString, DataSource<T> paramDataSource, float paramFloat, boolean paramBoolean)
  {
    if (!isExpectedDataSource(paramString, paramDataSource))
    {
      logMessageAndFailure("ignore_old_datasource @ onProgress", null);
      paramDataSource.close();
    }
    while (paramBoolean) {
      return;
    }
    this.mSettableDraweeHierarchy.setProgress(paramFloat, false);
  }
  
  private void releaseFetch()
  {
    boolean bool = this.mIsRequestSubmitted;
    this.mIsRequestSubmitted = false;
    this.mHasFetchFailed = false;
    if (this.mDataSource != null)
    {
      this.mDataSource.close();
      this.mDataSource = null;
    }
    if (this.mDrawable != null) {
      releaseDrawable(this.mDrawable);
    }
    this.mDrawable = null;
    if (this.mFetchedImage != null)
    {
      logMessageAndImage("release", this.mFetchedImage);
      releaseImage(this.mFetchedImage);
      this.mFetchedImage = null;
    }
    if (bool) {
      getControllerListener().onRelease(this.mId);
    }
  }
  
  private boolean shouldRetryOnTap()
  {
    return (this.mHasFetchFailed) && (this.mRetryManager != null) && (this.mRetryManager.shouldRetryOnTap());
  }
  
  public void addControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    Preconditions.checkNotNull(paramControllerListener);
    if ((this.mControllerListener instanceof InternalForwardingListener))
    {
      ((InternalForwardingListener)this.mControllerListener).addListener(paramControllerListener);
      return;
    }
    if (this.mControllerListener != null)
    {
      this.mControllerListener = InternalForwardingListener.createInternal(this.mControllerListener, paramControllerListener);
      return;
    }
    this.mControllerListener = paramControllerListener;
  }
  
  protected abstract Drawable createDrawable(T paramT);
  
  @Nullable
  public Animatable getAnimatable()
  {
    if ((this.mDrawable instanceof Animatable)) {
      return (Animatable)this.mDrawable;
    }
    return null;
  }
  
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  protected ControllerListener<INFO> getControllerListener()
  {
    if (this.mControllerListener == null) {
      return BaseControllerListener.getNoOpListener();
    }
    return this.mControllerListener;
  }
  
  @Nullable
  protected Drawable getControllerOverlay()
  {
    return this.mControllerOverlay;
  }
  
  protected abstract DataSource<T> getDataSource();
  
  @Nullable
  protected GestureDetector getGestureDetector()
  {
    return this.mGestureDetector;
  }
  
  @Nullable
  public DraweeHierarchy getHierarchy()
  {
    return this.mSettableDraweeHierarchy;
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  protected String getImageClass(@Nullable T paramT)
  {
    if (paramT != null) {
      return paramT.getClass().getSimpleName();
    }
    return "<null>";
  }
  
  protected int getImageHash(@Nullable T paramT)
  {
    return System.identityHashCode(paramT);
  }
  
  @Nullable
  protected abstract INFO getImageInfo(T paramT);
  
  @Nullable
  protected RetryManager getRetryManager()
  {
    return this.mRetryManager;
  }
  
  protected void initialize(String paramString, Object paramObject)
  {
    init(paramString, paramObject);
  }
  
  public void onAttach()
  {
    Class localClass;
    int i;
    String str2;
    if (FLog.isLoggable(2))
    {
      localClass = TAG;
      i = System.identityHashCode(this);
      str2 = this.mId;
      if (!this.mIsRequestSubmitted) {
        break label90;
      }
    }
    label90:
    for (String str1 = "request already submitted";; str1 = "request needs submit")
    {
      FLog.v(localClass, "controller %x %s: onAttach: %s", Integer.valueOf(i), str2, str1);
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
      Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
      this.mDeferredReleaser.cancelDeferredRelease(this);
      this.mIsAttached = true;
      if (!this.mIsRequestSubmitted) {
        submitRequest();
      }
      return;
    }
  }
  
  public boolean onClick()
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
    }
    if (shouldRetryOnTap())
    {
      this.mRetryManager.notifyTapToRetry();
      this.mSettableDraweeHierarchy.reset();
      submitRequest();
      return true;
    }
    return false;
  }
  
  public void onDetach()
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
    }
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
    this.mIsAttached = false;
    this.mDeferredReleaser.scheduleDeferredRelease(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramMotionEvent);
    }
    if (this.mGestureDetector == null) {}
    while ((!this.mGestureDetector.isCapturingGesture()) && (!shouldHandleGesture())) {
      return false;
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void release()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
    if (this.mRetryManager != null) {
      this.mRetryManager.reset();
    }
    if (this.mGestureDetector != null) {
      this.mGestureDetector.reset();
    }
    if (this.mSettableDraweeHierarchy != null) {
      this.mSettableDraweeHierarchy.reset();
    }
    releaseFetch();
  }
  
  protected abstract void releaseDrawable(@Nullable Drawable paramDrawable);
  
  protected abstract void releaseImage(@Nullable T paramT);
  
  public void removeControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    Preconditions.checkNotNull(paramControllerListener);
    if ((this.mControllerListener instanceof InternalForwardingListener)) {
      ((InternalForwardingListener)this.mControllerListener).removeListener(paramControllerListener);
    }
    while (this.mControllerListener != paramControllerListener) {
      return;
    }
    this.mControllerListener = null;
  }
  
  protected void setControllerOverlay(@Nullable Drawable paramDrawable)
  {
    this.mControllerOverlay = paramDrawable;
    if (this.mSettableDraweeHierarchy != null) {
      this.mSettableDraweeHierarchy.setControllerOverlay(this.mControllerOverlay);
    }
  }
  
  protected void setGestureDetector(@Nullable GestureDetector paramGestureDetector)
  {
    this.mGestureDetector = paramGestureDetector;
    if (this.mGestureDetector != null) {
      this.mGestureDetector.setClickListener(this);
    }
  }
  
  public void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy)
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramDraweeHierarchy);
    }
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    if (paramDraweeHierarchy != null) {}
    for (DraweeEventTracker.Event localEvent = DraweeEventTracker.Event.ON_SET_HIERARCHY;; localEvent = DraweeEventTracker.Event.ON_CLEAR_HIERARCHY)
    {
      localDraweeEventTracker.recordEvent(localEvent);
      if (this.mIsRequestSubmitted)
      {
        this.mDeferredReleaser.cancelDeferredRelease(this);
        release();
      }
      if (this.mSettableDraweeHierarchy != null)
      {
        this.mSettableDraweeHierarchy.setControllerOverlay(null);
        this.mSettableDraweeHierarchy = null;
      }
      if (paramDraweeHierarchy != null)
      {
        Preconditions.checkArgument(paramDraweeHierarchy instanceof SettableDraweeHierarchy);
        this.mSettableDraweeHierarchy = ((SettableDraweeHierarchy)paramDraweeHierarchy);
        this.mSettableDraweeHierarchy.setControllerOverlay(this.mControllerOverlay);
      }
      return;
    }
  }
  
  protected void setRetainImageOnFailure(boolean paramBoolean)
  {
    this.mRetainImageOnFailure = paramBoolean;
  }
  
  protected void setRetryManager(@Nullable RetryManager paramRetryManager)
  {
    this.mRetryManager = paramRetryManager;
  }
  
  protected boolean shouldHandleGesture()
  {
    return shouldRetryOnTap();
  }
  
  protected void submitRequest()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
    getControllerListener().onSubmit(this.mId, this.mCallerContext);
    this.mSettableDraweeHierarchy.setProgress(0.0F, true);
    this.mIsRequestSubmitted = true;
    this.mHasFetchFailed = false;
    this.mDataSource = getDataSource();
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mDataSource)));
    }
    BaseDataSubscriber local1 = new BaseDataSubscriber()
    {
      public void onFailureImpl(DataSource<T> paramAnonymousDataSource)
      {
        AbstractDraweeController.this.onFailureInternal(this.val$id, paramAnonymousDataSource, paramAnonymousDataSource.getFailureCause(), true);
      }
      
      public void onNewResultImpl(DataSource<T> paramAnonymousDataSource)
      {
        boolean bool = paramAnonymousDataSource.isFinished();
        float f = paramAnonymousDataSource.getProgress();
        Object localObject = paramAnonymousDataSource.getResult();
        if (localObject != null) {
          AbstractDraweeController.this.onNewResultInternal(this.val$id, paramAnonymousDataSource, localObject, f, bool, this.val$wasImmediate);
        }
        while (!bool) {
          return;
        }
        AbstractDraweeController.this.onFailureInternal(this.val$id, paramAnonymousDataSource, new NullPointerException(), true);
      }
      
      public void onProgressUpdate(DataSource<T> paramAnonymousDataSource)
      {
        boolean bool = paramAnonymousDataSource.isFinished();
        float f = paramAnonymousDataSource.getProgress();
        AbstractDraweeController.this.onProgressUpdateInternal(this.val$id, paramAnonymousDataSource, f, bool);
      }
    };
    this.mDataSource.subscribe(local1, this.mUiThreadImmediateExecutor);
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).add("events", this.mEventTracker.toString()).toString();
  }
  
  private static class InternalForwardingListener<INFO>
    extends ForwardingControllerListener<INFO>
  {
    public static <INFO> InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> paramControllerListener1, ControllerListener<? super INFO> paramControllerListener2)
    {
      InternalForwardingListener localInternalForwardingListener = new InternalForwardingListener();
      localInternalForwardingListener.addListener(paramControllerListener1);
      localInternalForwardingListener.addListener(paramControllerListener2);
      return localInternalForwardingListener;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\controller\AbstractDraweeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */