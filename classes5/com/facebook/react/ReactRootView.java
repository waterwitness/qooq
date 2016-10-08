package com.facebook.react;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.TouchTargetHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchEventType;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

public class ReactRootView
  extends SizeMonitoringFrameLayout
  implements RootView
{
  private boolean mAttachScheduled = false;
  private boolean mChildIsHandlingNativeGesture = false;
  private boolean mIsAttachedToInstance = false;
  private boolean mIsAttachedToWindow = false;
  protected boolean mIsInListView = false;
  @Nullable
  private String mJSModuleName;
  private KeyboardListener mKeyboardListener = new KeyboardListener(this);
  @Nullable
  private Bundle mLaunchOptions;
  @Nullable
  private ReactInstanceManager mReactInstanceManager;
  protected final float[] mTargetCoordinates = new float[2];
  private int mTargetTag = -1;
  private boolean mWasMeasured = false;
  
  public ReactRootView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReactRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReactRootView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void dispatchCancelEvent(MotionEvent paramMotionEvent)
  {
    if (this.mTargetTag == -1) {
      if (FLog.isLoggable(5)) {
        FLog.w("React", "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
      }
    }
    EventDispatcher localEventDispatcher;
    do
    {
      do
      {
        return;
        localEventDispatcher = ((UIManagerModule)this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
        if (localEventDispatcher != null) {
          break;
        }
      } while (!FLog.isLoggable(6));
      FLog.e("Exception", "dispatchCancelEvent but eventDispatcher is null");
      return;
      if (!this.mChildIsHandlingNativeGesture) {
        break;
      }
    } while (!FLog.isLoggable(6));
    FLog.e("Exception", "Expected to not have already sent a cancel for this gesture");
    return;
    ((EventDispatcher)Assertions.assertNotNull(localEventDispatcher)).dispatchEvent(TouchEvent.obtain(this.mTargetTag, SystemClock.uptimeMillis(), TouchEventType.CANCEL, paramMotionEvent, this.mTargetCoordinates[0], this.mTargetCoordinates[1]));
  }
  
  protected void deattachMeasuredRootView()
  {
    this.mIsAttachedToWindow = false;
    if ((this.mReactInstanceManager != null) && (!this.mAttachScheduled))
    {
      this.mReactInstanceManager.detachRootView(this);
      this.mIsAttachedToInstance = false;
      getViewTreeObserver().removeOnGlobalLayoutListener(this.mKeyboardListener);
    }
  }
  
  String getJSModuleName()
  {
    return (String)Assertions.assertNotNull(this.mJSModuleName);
  }
  
  @Nullable
  Bundle getLaunchOptions()
  {
    return this.mLaunchOptions;
  }
  
  protected void handleTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mReactInstanceManager == null) || (!this.mIsAttachedToInstance) || (this.mReactInstanceManager.getCurrentReactContext() == null)) {
      if (FLog.isLoggable(5)) {
        FLog.w("React", "Unable to handle touch in JS as the catalyst instance has not been attached");
      }
    }
    int i;
    do
    {
      EventDispatcher localEventDispatcher;
      do
      {
        do
        {
          return;
          i = paramMotionEvent.getAction() & 0xFF;
          localEventDispatcher = ((UIManagerModule)this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
          if (i == 0)
          {
            if ((this.mTargetTag != -1) && (FLog.isLoggable(6))) {
              FLog.e("React", "Got DOWN touch before receiving UP or CANCEL from last gesture");
            }
            this.mChildIsHandlingNativeGesture = false;
            this.mTargetTag = TouchTargetHelper.findTargetTagAndCoordinatesForTouch(paramMotionEvent.getX(), paramMotionEvent.getY(), this, this.mTargetCoordinates);
            localEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, SystemClock.uptimeMillis(), TouchEventType.START, paramMotionEvent, this.mTargetCoordinates[0], this.mTargetCoordinates[1]));
            return;
          }
        } while (this.mChildIsHandlingNativeGesture);
        if (this.mTargetTag != -1) {
          break;
        }
      } while (!FLog.isLoggable(6));
      FLog.e("React", "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
      return;
      if (i == 1)
      {
        localEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, SystemClock.uptimeMillis(), TouchEventType.END, paramMotionEvent, this.mTargetCoordinates[0], this.mTargetCoordinates[1]));
        this.mTargetTag = -1;
        return;
      }
      if (i == 2)
      {
        localEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, SystemClock.uptimeMillis(), TouchEventType.MOVE, paramMotionEvent, this.mTargetCoordinates[0], this.mTargetCoordinates[1]));
        return;
      }
      if (i == 5)
      {
        localEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, SystemClock.uptimeMillis(), TouchEventType.START, paramMotionEvent, this.mTargetCoordinates[0], this.mTargetCoordinates[1]));
        return;
      }
      if (i == 6)
      {
        localEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, SystemClock.uptimeMillis(), TouchEventType.END, paramMotionEvent, this.mTargetCoordinates[0], this.mTargetCoordinates[1]));
        return;
      }
      if (i == 3)
      {
        dispatchCancelEvent(paramMotionEvent);
        this.mTargetTag = -1;
        return;
      }
    } while (!FLog.isLoggable(5));
    FLog.w("React", "Warning : touch event was ignored. Action=" + i + " Target=" + this.mTargetTag);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mIsAttachedToWindow = true;
    if (this.mReactInstanceManager != null) {
      this.mAttachScheduled = true;
    }
  }
  
  public void onChildStartedNativeGesture(MotionEvent paramMotionEvent)
  {
    if (this.mChildIsHandlingNativeGesture) {
      return;
    }
    dispatchCancelEvent(paramMotionEvent);
    this.mChildIsHandlingNativeGesture = true;
    this.mTargetTag = -1;
  }
  
  protected void onDetachedFromWindow()
  {
    if (!this.mIsInListView)
    {
      super.onDetachedFromWindow();
      deattachMeasuredRootView();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    handleTouchEvent(paramMotionEvent);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View.MeasureSpec.getMode(paramInt1);
    View.MeasureSpec.getMode(paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    this.mWasMeasured = true;
    if ((this.mAttachScheduled) && (this.mReactInstanceManager != null) && (this.mIsAttachedToWindow))
    {
      this.mAttachScheduled = false;
      UiThreadUtil.runOnUiThread(new Runnable()
      {
        public void run()
        {
          ((ReactInstanceManager)Assertions.assertNotNull(ReactRootView.this.mReactInstanceManager)).attachMeasuredRootView(ReactRootView.this);
          ReactRootView.access$102(ReactRootView.this, true);
          ReactRootView.this.getViewTreeObserver().addOnGlobalLayoutListener(ReactRootView.this.mKeyboardListener);
        }
      });
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    handleTouchEvent(paramMotionEvent);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  @VisibleForTesting
  void simulateAttachForTesting()
  {
    this.mIsAttachedToWindow = true;
    this.mIsAttachedToInstance = true;
    this.mWasMeasured = true;
  }
  
  public void startReactApplication(ReactInstanceManager paramReactInstanceManager, String paramString)
  {
    startReactApplication(paramReactInstanceManager, paramString, null);
  }
  
  public void startReactApplication(ReactInstanceManager paramReactInstanceManager, String paramString, @Nullable Bundle paramBundle)
  {
    UiThreadUtil.assertOnUiThread();
    this.mReactInstanceManager = paramReactInstanceManager;
    this.mJSModuleName = paramString;
    this.mLaunchOptions = paramBundle;
    if (!this.mReactInstanceManager.hasStartedCreatingInitialContext()) {
      this.mReactInstanceManager.createReactContextInBackground();
    }
    if ((this.mWasMeasured) && (this.mIsAttachedToWindow))
    {
      this.mReactInstanceManager.attachMeasuredRootView(this);
      this.mIsAttachedToInstance = true;
      getViewTreeObserver().addOnGlobalLayoutListener(this.mKeyboardListener);
      return;
    }
    this.mAttachScheduled = true;
  }
  
  private static class KeyboardListener
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private int mKeyboardHeight = 0;
    private WeakReference<ReactRootView> mReference;
    private final Rect mVisibleViewArea = new Rect();
    
    public KeyboardListener(ReactRootView paramReactRootView)
    {
      this.mReference = new WeakReference(paramReactRootView);
    }
    
    private void sendEvent(String paramString, @Nullable WritableMap paramWritableMap)
    {
      ReactRootView localReactRootView = (ReactRootView)this.mReference.get();
      if (localReactRootView == null) {}
      while ((localReactRootView.mReactInstanceManager == null) || (!localReactRootView.mReactInstanceManager.isScrollIdle())) {
        return;
      }
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)localReactRootView.mReactInstanceManager.getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(paramString, paramWritableMap);
    }
    
    public void onGlobalLayout()
    {
      Object localObject = (ReactRootView)this.mReference.get();
      if (localObject == null) {}
      int i;
      do
      {
        do
        {
          return;
          if ((((ReactRootView)localObject).mReactInstanceManager != null) && (((ReactRootView)localObject).mIsAttachedToInstance) && (((ReactRootView)localObject).mReactInstanceManager.getCurrentReactContext() != null)) {
            break;
          }
        } while (!FLog.isLoggable(5));
        FLog.w("React", "Unable to dispatch keyboard events in JS as the react instance has not been attached");
        return;
        ((ReactRootView)localObject).getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
        i = DisplayMetricsHolder.getDisplayMetrics().heightPixels - this.mVisibleViewArea.bottom;
        if ((this.mKeyboardHeight != i) && (i > 0))
        {
          this.mKeyboardHeight = i;
          localObject = Arguments.createMap();
          WritableMap localWritableMap = Arguments.createMap();
          localWritableMap.putDouble("screenY", PixelUtil.toDIPFromPixel(this.mVisibleViewArea.bottom));
          localWritableMap.putDouble("screenX", PixelUtil.toDIPFromPixel(this.mVisibleViewArea.left));
          localWritableMap.putDouble("width", PixelUtil.toDIPFromPixel(this.mVisibleViewArea.width()));
          localWritableMap.putDouble("height", PixelUtil.toDIPFromPixel(this.mKeyboardHeight));
          ((WritableMap)localObject).putMap("endCoordinates", localWritableMap);
          sendEvent("keyboardDidShow", (WritableMap)localObject);
          return;
        }
      } while ((this.mKeyboardHeight == 0) || (i != 0));
      this.mKeyboardHeight = i;
      sendEvent("keyboardDidHide", null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\ReactRootView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */