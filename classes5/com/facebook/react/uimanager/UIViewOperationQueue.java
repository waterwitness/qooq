package com.facebook.react.uimanager;

import com.facebook.react.animation.Animation;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class UIViewOperationQueue
{
  private final AnimationRegistry mAnimationRegistry;
  private final Object mDispatchRunnablesLock = new Object();
  private final DispatchUIFrameCallback mDispatchUIFrameCallback;
  @GuardedBy("mDispatchRunnablesLock")
  private final ArrayList<Runnable> mDispatchUIRunnables = new ArrayList();
  private final int[] mMeasureBuffer = new int[4];
  protected final NativeViewHierarchyManager mNativeViewHierarchyManager;
  private ArrayList<UIOperation> mOperations = new ArrayList();
  private final ReactApplicationContext mReactApplicationContext;
  @Nullable
  private NotThreadSafeViewHierarchyUpdateDebugListener mViewHierarchyUpdateDebugListener;
  
  public UIViewOperationQueue(ReactApplicationContext paramReactApplicationContext, NativeViewHierarchyManager paramNativeViewHierarchyManager)
  {
    this.mNativeViewHierarchyManager = paramNativeViewHierarchyManager;
    this.mAnimationRegistry = paramNativeViewHierarchyManager.getAnimationRegistry();
    this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(paramReactApplicationContext, null);
    this.mReactApplicationContext = paramReactApplicationContext;
  }
  
  public void addRootView(final int paramInt, final SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout, final ThemedReactContext paramThemedReactContext)
  {
    if (UiThreadUtil.isOnUiThread())
    {
      this.mNativeViewHierarchyManager.addRootView(paramInt, paramSizeMonitoringFrameLayout, paramThemedReactContext);
      return;
    }
    final Semaphore localSemaphore = new Semaphore(0);
    this.mReactApplicationContext.runOnUiQueueThread(new Runnable()
    {
      public void run()
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.addRootView(paramInt, paramSizeMonitoringFrameLayout, paramThemedReactContext);
        localSemaphore.release();
      }
    });
    try
    {
      SoftAssertions.assertCondition(localSemaphore.tryAcquire(5000L, TimeUnit.MILLISECONDS), "Timed out adding root view");
      return;
    }
    catch (InterruptedException paramSizeMonitoringFrameLayout)
    {
      throw new RuntimeException(paramSizeMonitoringFrameLayout);
    }
  }
  
  void dispatchViewUpdates(final int paramInt)
  {
    final ArrayList localArrayList;
    if (this.mOperations.isEmpty()) {
      localArrayList = null;
    }
    for (;;)
    {
      if (localArrayList != null) {
        this.mOperations = new ArrayList();
      }
      if (this.mViewHierarchyUpdateDebugListener != null) {
        this.mViewHierarchyUpdateDebugListener.onViewHierarchyUpdateEnqueued();
      }
      synchronized (this.mDispatchRunnablesLock)
      {
        this.mDispatchUIRunnables.add(new Runnable()
        {
          public void run()
          {
            SystraceMessage.beginSection(0L, "DispatchUI").arg("BatchId", paramInt).flush();
            try
            {
              if (localArrayList != null)
              {
                int i = 0;
                while (i < localArrayList.size())
                {
                  ((UIViewOperationQueue.UIOperation)localArrayList.get(i)).execute();
                  i += 1;
                }
              }
              if (UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener != null) {
                UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener.onViewHierarchyUpdateFinished();
              }
              return;
            }
            finally
            {
              Systrace.endSection(0L);
            }
          }
        });
        return;
        localArrayList = this.mOperations;
      }
    }
  }
  
  public void enqueueAddAnimation(int paramInt1, int paramInt2, Callback paramCallback)
  {
    this.mOperations.add(new AddAnimationOperation(paramInt1, paramInt2, paramCallback, null));
  }
  
  public void enqueueClearJSResponder()
  {
    this.mOperations.add(new ChangeJSResponderOperation(0, 0, true, false));
  }
  
  public void enqueueConfigureLayoutAnimation(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    this.mOperations.add(new ConfigureLayoutAnimationOperation(paramReadableMap, null));
  }
  
  public void enqueueCreateView(ThemedReactContext paramThemedReactContext, int paramInt, String paramString, @Nullable CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    this.mOperations.add(new CreateViewOperation(paramThemedReactContext, paramInt, paramString, paramCatalystStylesDiffMap));
  }
  
  public void enqueueDispatchCommand(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    this.mOperations.add(new DispatchCommandOperation(paramInt1, paramInt2, paramReadableArray));
  }
  
  public void enqueueFindTargetForTouch(int paramInt, float paramFloat1, float paramFloat2, Callback paramCallback)
  {
    this.mOperations.add(new FindTargetForTouchOperation(paramInt, paramFloat1, paramFloat2, paramCallback, null));
  }
  
  public void enqueueManageChildren(int paramInt, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, @Nullable int[] paramArrayOfInt2)
  {
    this.mOperations.add(new ManageChildrenOperation(paramInt, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
  }
  
  public void enqueueMeasure(int paramInt, Callback paramCallback)
  {
    this.mOperations.add(new MeasureOperation(paramInt, paramCallback, null));
  }
  
  public void enqueueRegisterAnimation(Animation paramAnimation)
  {
    this.mOperations.add(new RegisterAnimationOperation(paramAnimation, null));
  }
  
  public void enqueueRemoveAnimation(int paramInt)
  {
    this.mOperations.add(new RemoveAnimationOperation(paramInt, null));
  }
  
  public void enqueueRemoveRootView(int paramInt)
  {
    this.mOperations.add(new RemoveRootViewOperation(paramInt));
  }
  
  public void enqueueSendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    this.mOperations.add(new SendAccessibilityEvent(paramInt1, paramInt2, null));
  }
  
  public void enqueueSetJSResponder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mOperations.add(new ChangeJSResponderOperation(paramInt1, paramInt2, false, paramBoolean));
  }
  
  public void enqueueSetLayoutAnimationEnabled(boolean paramBoolean)
  {
    this.mOperations.add(new SetLayoutAnimationEnabledOperation(paramBoolean, null));
  }
  
  public void enqueueShowPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    this.mOperations.add(new ShowPopupMenuOperation(paramInt, paramReadableArray, paramCallback2));
  }
  
  protected void enqueueUIOperation(UIOperation paramUIOperation)
  {
    this.mOperations.add(paramUIOperation);
  }
  
  public void enqueueUpdateExtraData(int paramInt, Object paramObject)
  {
    this.mOperations.add(new UpdateViewExtraData(paramInt, paramObject));
  }
  
  public void enqueueUpdateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mOperations.add(new UpdateLayoutOperation(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void enqueueUpdateProperties(int paramInt, String paramString, CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    this.mOperations.add(new UpdatePropertiesOperation(paramInt, paramCatalystStylesDiffMap, null));
  }
  
  public boolean isEmpty()
  {
    return this.mOperations.isEmpty();
  }
  
  void pauseFrameCallback()
  {
    ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
  }
  
  void resumeFrameCallback()
  {
    ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
  }
  
  public void setViewHierarchyUpdateDebugListener(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener paramNotThreadSafeViewHierarchyUpdateDebugListener)
  {
    this.mViewHierarchyUpdateDebugListener = paramNotThreadSafeViewHierarchyUpdateDebugListener;
  }
  
  private class AddAnimationOperation
    extends UIViewOperationQueue.AnimationOperation
  {
    private final int mReactTag;
    private final Callback mSuccessCallback;
    
    private AddAnimationOperation(int paramInt1, int paramInt2, Callback paramCallback)
    {
      super();
      this.mReactTag = paramInt1;
      this.mSuccessCallback = paramCallback;
    }
    
    public void execute()
    {
      Animation localAnimation = UIViewOperationQueue.this.mAnimationRegistry.getAnimation(this.mAnimationID);
      if (localAnimation != null)
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.startAnimationForNativeView(this.mReactTag, localAnimation, this.mSuccessCallback);
        return;
      }
      throw new IllegalViewOperationException("Animation with id " + this.mAnimationID + " was not found");
    }
  }
  
  private static abstract class AnimationOperation
    implements UIViewOperationQueue.UIOperation
  {
    protected final int mAnimationID;
    
    public AnimationOperation(int paramInt)
    {
      this.mAnimationID = paramInt;
    }
  }
  
  private final class ChangeJSResponderOperation
    extends UIViewOperationQueue.ViewOperation
  {
    private final boolean mBlockNativeResponder;
    private final boolean mClearResponder;
    private final int mInitialTag;
    
    public ChangeJSResponderOperation(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramInt1);
      this.mInitialTag = paramInt2;
      this.mClearResponder = paramBoolean1;
      this.mBlockNativeResponder = paramBoolean2;
    }
    
    public void execute()
    {
      if (!this.mClearResponder)
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.setJSResponder(this.mTag, this.mInitialTag, this.mBlockNativeResponder);
        return;
      }
      UIViewOperationQueue.this.mNativeViewHierarchyManager.clearJSResponder();
    }
  }
  
  private class ConfigureLayoutAnimationOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final ReadableMap mConfig;
    
    private ConfigureLayoutAnimationOperation(ReadableMap paramReadableMap)
    {
      this.mConfig = paramReadableMap;
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.configureLayoutAnimation(this.mConfig);
    }
  }
  
  private final class CreateViewOperation
    extends UIViewOperationQueue.ViewOperation
  {
    private final String mClassName;
    @Nullable
    private final CatalystStylesDiffMap mInitialProps;
    private final ThemedReactContext mThemedContext;
    
    public CreateViewOperation(ThemedReactContext paramThemedReactContext, int paramInt, @Nullable String paramString, CatalystStylesDiffMap paramCatalystStylesDiffMap)
    {
      super(paramInt);
      this.mThemedContext = paramThemedReactContext;
      this.mClassName = paramString;
      this.mInitialProps = paramCatalystStylesDiffMap;
      Systrace.startAsyncFlow(0L, "createView", this.mTag);
    }
    
    public void execute()
    {
      Systrace.endAsyncFlow(0L, "createView", this.mTag);
      UIViewOperationQueue.this.mNativeViewHierarchyManager.createView(this.mThemedContext, this.mTag, this.mClassName, this.mInitialProps);
    }
  }
  
  private final class DispatchCommandOperation
    extends UIViewOperationQueue.ViewOperation
  {
    @Nullable
    private final ReadableArray mArgs;
    private final int mCommand;
    
    public DispatchCommandOperation(int paramInt1, @Nullable int paramInt2, ReadableArray paramReadableArray)
    {
      super(paramInt1);
      this.mCommand = paramInt2;
      this.mArgs = paramReadableArray;
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
    }
  }
  
  private class DispatchUIFrameCallback
    extends GuardedChoreographerFrameCallback
  {
    private DispatchUIFrameCallback(ReactContext paramReactContext)
    {
      super();
    }
    
    public void doFrameGuarded(long paramLong)
    {
      Object localObject1 = UIViewOperationQueue.this.mDispatchRunnablesLock;
      int i = 0;
      try
      {
        while (i < UIViewOperationQueue.this.mDispatchUIRunnables.size())
        {
          ((Runnable)UIViewOperationQueue.this.mDispatchUIRunnables.get(i)).run();
          i += 1;
        }
        UIViewOperationQueue.this.mDispatchUIRunnables.clear();
        UIViewOperationQueue.this.mNativeViewHierarchyManager.clearLayoutAnimation();
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this);
        return;
      }
      finally {}
    }
  }
  
  private final class FindTargetForTouchOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final Callback mCallback;
    private final int mReactTag;
    private final float mTargetX;
    private final float mTargetY;
    
    private FindTargetForTouchOperation(int paramInt, float paramFloat1, float paramFloat2, Callback paramCallback)
    {
      this.mReactTag = paramInt;
      this.mTargetX = paramFloat1;
      this.mTargetY = paramFloat2;
      this.mCallback = paramCallback;
    }
    
    public void execute()
    {
      float f1;
      float f2;
      int i;
      try
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
        f1 = UIViewOperationQueue.this.mMeasureBuffer[0];
        f2 = UIViewOperationQueue.this.mMeasureBuffer[1];
        i = UIViewOperationQueue.this.mNativeViewHierarchyManager.findTargetTagForTouch(this.mReactTag, this.mTargetX, this.mTargetY);
        if (i == -1) {
          return;
        }
      }
      catch (IllegalViewOperationException localIllegalViewOperationException1)
      {
        this.mCallback.invoke(new Object[0]);
        return;
      }
      try
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(i, UIViewOperationQueue.this.mMeasureBuffer);
        f1 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[0] - f1);
        f2 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[1] - f2);
        float f3 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[2]);
        float f4 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[3]);
        this.mCallback.invoke(new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
        return;
      }
      catch (IllegalViewOperationException localIllegalViewOperationException2)
      {
        this.mCallback.invoke(new Object[0]);
      }
    }
  }
  
  private final class ManageChildrenOperation
    extends UIViewOperationQueue.ViewOperation
  {
    @Nullable
    private final int[] mIndicesToRemove;
    @Nullable
    private final int[] mTagsToDelete;
    @Nullable
    private final ViewAtIndex[] mViewsToAdd;
    
    public ManageChildrenOperation(@Nullable int paramInt, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, int[] paramArrayOfInt2)
    {
      super(paramInt);
      this.mIndicesToRemove = paramArrayOfInt1;
      this.mViewsToAdd = paramArrayOfViewAtIndex;
      this.mTagsToDelete = paramArrayOfInt2;
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.manageChildren(this.mTag, this.mIndicesToRemove, this.mViewsToAdd, this.mTagsToDelete);
    }
  }
  
  private final class MeasureOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final Callback mCallback;
    private final int mReactTag;
    
    private MeasureOperation(int paramInt, Callback paramCallback)
    {
      this.mReactTag = paramInt;
      this.mCallback = paramCallback;
    }
    
    public void execute()
    {
      try
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
        float f1 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[0]);
        float f2 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[1]);
        float f3 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[2]);
        float f4 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[3]);
        this.mCallback.invoke(new Object[] { Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
        return;
      }
      catch (NoSuchNativeViewException localNoSuchNativeViewException)
      {
        this.mCallback.invoke(new Object[0]);
      }
    }
  }
  
  private class RegisterAnimationOperation
    extends UIViewOperationQueue.AnimationOperation
  {
    private final Animation mAnimation;
    
    private RegisterAnimationOperation(Animation paramAnimation)
    {
      super();
      this.mAnimation = paramAnimation;
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mAnimationRegistry.registerAnimation(this.mAnimation);
    }
  }
  
  private final class RemoveAnimationOperation
    extends UIViewOperationQueue.AnimationOperation
  {
    private RemoveAnimationOperation(int paramInt)
    {
      super();
    }
    
    public void execute()
    {
      Animation localAnimation = UIViewOperationQueue.this.mAnimationRegistry.getAnimation(this.mAnimationID);
      if (localAnimation != null) {
        localAnimation.cancel();
      }
    }
  }
  
  private final class RemoveRootViewOperation
    extends UIViewOperationQueue.ViewOperation
  {
    public RemoveRootViewOperation(int paramInt)
    {
      super(paramInt);
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.removeRootView(this.mTag);
    }
  }
  
  private final class SendAccessibilityEvent
    extends UIViewOperationQueue.ViewOperation
  {
    private final int mEventType;
    
    private SendAccessibilityEvent(int paramInt1, int paramInt2)
    {
      super(paramInt1);
      this.mEventType = paramInt2;
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.sendAccessibilityEvent(this.mTag, this.mEventType);
    }
  }
  
  private class SetLayoutAnimationEnabledOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final boolean mEnabled;
    
    private SetLayoutAnimationEnabledOperation(boolean paramBoolean)
    {
      this.mEnabled = paramBoolean;
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.setLayoutAnimationEnabled(this.mEnabled);
    }
  }
  
  private final class ShowPopupMenuOperation
    extends UIViewOperationQueue.ViewOperation
  {
    private final ReadableArray mItems;
    private final Callback mSuccess;
    
    public ShowPopupMenuOperation(int paramInt, ReadableArray paramReadableArray, Callback paramCallback)
    {
      super(paramInt);
      this.mItems = paramReadableArray;
      this.mSuccess = paramCallback;
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.showPopupMenu(this.mTag, this.mItems, this.mSuccess);
    }
  }
  
  protected static abstract interface UIOperation
  {
    public abstract void execute();
  }
  
  private final class UpdateLayoutOperation
    extends UIViewOperationQueue.ViewOperation
  {
    private final int mHeight;
    private final int mParentTag;
    private final int mWidth;
    private final int mX;
    private final int mY;
    
    public UpdateLayoutOperation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      super(paramInt2);
      this.mParentTag = paramInt1;
      this.mX = paramInt3;
      this.mY = paramInt4;
      this.mWidth = paramInt5;
      this.mHeight = paramInt6;
      Systrace.startAsyncFlow(0L, "updateLayout", this.mTag);
    }
    
    public void execute()
    {
      Systrace.endAsyncFlow(0L, "updateLayout", this.mTag);
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateLayout(this.mParentTag, this.mTag, this.mX, this.mY, this.mWidth, this.mHeight);
    }
  }
  
  private final class UpdatePropertiesOperation
    extends UIViewOperationQueue.ViewOperation
  {
    private final CatalystStylesDiffMap mProps;
    
    private UpdatePropertiesOperation(int paramInt, CatalystStylesDiffMap paramCatalystStylesDiffMap)
    {
      super(paramInt);
      this.mProps = paramCatalystStylesDiffMap;
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateProperties(this.mTag, this.mProps);
    }
  }
  
  private final class UpdateViewExtraData
    extends UIViewOperationQueue.ViewOperation
  {
    private final Object mExtraData;
    
    public UpdateViewExtraData(int paramInt, Object paramObject)
    {
      super(paramInt);
      this.mExtraData = paramObject;
    }
    
    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateViewExtraData(this.mTag, this.mExtraData);
    }
  }
  
  private abstract class ViewOperation
    implements UIViewOperationQueue.UIOperation
  {
    public int mTag;
    
    public ViewOperation(int paramInt)
    {
      this.mTag = paramInt;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\UIViewOperationQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */