package com.facebook.react.uimanager;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import com.facebook.react.animation.Animation;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import com.tencent.bitapp.pre.binder.client.IJava2jniClient;
import com.tencent.bitapp.pre.binder.client.Java2jniClientFactory;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class UIManagerModule
  extends ReactContextBaseJavaModule
  implements OnBatchCompleteListener, LifecycleEventListener
{
  private static final int ROOT_VIEW_TAG_INCREMENT = 10;
  private int mBatchId = 0;
  private final EventDispatcher mEventDispatcher;
  private final Map<String, Object> mModuleConstants;
  private int mNextRootViewTag = 1;
  private WeakReference<ReactContext> mReactContextRef;
  public final UIImplementation mUIImplementation;
  
  public UIManagerModule(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList, UIImplementation paramUIImplementation)
  {
    super(paramReactApplicationContext);
    this.mEventDispatcher = new EventDispatcher(paramReactApplicationContext);
    DisplayMetricsHolder.setDisplayMetrics(paramReactApplicationContext.getResources().getDisplayMetrics());
    this.mModuleConstants = UIManagerModuleConstantsHelper.getStaticConstants(paramReactApplicationContext);
    this.mUIImplementation = paramUIImplementation;
    paramReactApplicationContext.addLifecycleEventListener(this);
    this.mReactContextRef = new WeakReference(paramReactApplicationContext);
  }
  
  private static Map<String, Object> createConstants(DisplayMetrics paramDisplayMetrics, List<ViewManager> paramList)
  {
    Systrace.beginSection(0L, "CreateUIManagerConstants");
    try
    {
      paramDisplayMetrics = UIManagerModuleConstantsHelper.createConstants(paramDisplayMetrics, paramList);
      return paramDisplayMetrics;
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }
  
  public static void onDestroy() {}
  
  private void updateRootNodeSize(int paramInt1, int paramInt2, int paramInt3)
  {
    getReactApplicationContext().assertOnNativeModulesQueueThread();
    this.mUIImplementation.updateRootNodeSize(paramInt1, paramInt2, paramInt3, this.mEventDispatcher);
  }
  
  public void addAnimation(int paramInt1, int paramInt2, Callback paramCallback)
  {
    this.mUIImplementation.addAnimation(paramInt1, paramInt2, paramCallback);
  }
  
  public int addMeasuredRootView(SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout)
  {
    int j = this.mNextRootViewTag;
    this.mNextRootViewTag += 10;
    int i;
    if ((paramSizeMonitoringFrameLayout.getLayoutParams() != null) && (paramSizeMonitoringFrameLayout.getLayoutParams().width > 0) && (paramSizeMonitoringFrameLayout.getLayoutParams().height > 0))
    {
      i = paramSizeMonitoringFrameLayout.getLayoutParams().width;
      int k = paramSizeMonitoringFrameLayout.getLayoutParams().height;
    }
    for (;;)
    {
      ThemedReactContext localThemedReactContext = new ThemedReactContext(getReactApplicationContext(), paramSizeMonitoringFrameLayout.getContext());
      this.mUIImplementation.registerRootView(paramSizeMonitoringFrameLayout, j, i, 0, localThemedReactContext);
      paramSizeMonitoringFrameLayout.setOnSizeChangedListener(new OnSizeChangedListener(this, j));
      return j;
      i = paramSizeMonitoringFrameLayout.getWidth();
      paramSizeMonitoringFrameLayout.getHeight();
    }
  }
  
  @ReactMethod
  public void clearJSResponder()
  {
    this.mUIImplementation.clearJSResponder();
  }
  
  @ReactMethod
  public void configureNextLayoutAnimation(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    this.mUIImplementation.configureNextLayoutAnimation(paramReadableMap, paramCallback1, paramCallback2);
  }
  
  @ReactMethod
  public void createView(int paramInt1, String paramString, int paramInt2, ReadableMap paramReadableMap)
  {
    Java2jniClientFactory.getJava2jniClient().setLastViewId(paramInt1);
    this.mUIImplementation.createView(paramInt1, paramString, paramInt2, paramReadableMap);
  }
  
  @ReactMethod
  public void dispatchViewManagerCommand(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    this.mUIImplementation.dispatchViewManagerCommand(paramInt1, paramInt2, paramReadableArray);
  }
  
  @ReactMethod
  public void findSubviewIn(int paramInt, ReadableArray paramReadableArray, Callback paramCallback)
  {
    this.mUIImplementation.findSubviewIn(paramInt, Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(1))), paramCallback);
  }
  
  public Map<String, Object> getConstants()
  {
    return this.mModuleConstants;
  }
  
  public EventDispatcher getEventDispatcher()
  {
    return this.mEventDispatcher;
  }
  
  public String getName()
  {
    return "RKUIManager";
  }
  
  @ReactMethod
  public void manageChildren(int paramInt, @Nullable ReadableArray paramReadableArray1, @Nullable ReadableArray paramReadableArray2, @Nullable ReadableArray paramReadableArray3, @Nullable ReadableArray paramReadableArray4, @Nullable ReadableArray paramReadableArray5)
  {
    this.mUIImplementation.manageChildren(paramInt, paramReadableArray1, paramReadableArray2, paramReadableArray3, paramReadableArray4, paramReadableArray5);
  }
  
  @ReactMethod
  public void measure(int paramInt, Callback paramCallback)
  {
    this.mUIImplementation.measure(paramInt, paramCallback);
  }
  
  @ReactMethod
  public void measureLayout(int paramInt1, int paramInt2, Callback paramCallback1, Callback paramCallback2)
  {
    this.mUIImplementation.measureLayout(paramInt1, paramInt2, paramCallback1, paramCallback2);
  }
  
  @ReactMethod
  public void measureLayoutRelativeToParent(int paramInt, Callback paramCallback1, Callback paramCallback2)
  {
    this.mUIImplementation.measureLayoutRelativeToParent(paramInt, paramCallback1, paramCallback2);
  }
  
  public void onBatchComplete()
  {
    int i = this.mBatchId;
    this.mBatchId += 1;
    SystraceMessage.beginSection(0L, "onBatchCompleteUI").arg("BatchId", i).flush();
    try
    {
      this.mUIImplementation.dispatchViewUpdates(this.mEventDispatcher, i);
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }
  
  public void onCatalystInstanceDestroy()
  {
    super.onCatalystInstanceDestroy();
    this.mEventDispatcher.onCatalystInstanceDestroyed();
  }
  
  public void onHostDestroy()
  {
    this.mUIImplementation.onHostDestroy();
    ReactContext localReactContext = (ReactContext)this.mReactContextRef.get();
    if (localReactContext != null) {
      localReactContext.removeLifecycleEventListener(this);
    }
  }
  
  public void onHostPause()
  {
    this.mUIImplementation.onHostPause();
  }
  
  public void onHostResume()
  {
    this.mUIImplementation.onHostResume();
  }
  
  public void registerAnimation(Animation paramAnimation)
  {
    this.mUIImplementation.registerAnimation(paramAnimation);
  }
  
  public void removeAnimation(int paramInt1, int paramInt2)
  {
    this.mUIImplementation.removeAnimation(paramInt1, paramInt2);
  }
  
  @ReactMethod
  public void removeRootView(int paramInt)
  {
    this.mUIImplementation.removeRootView(paramInt);
  }
  
  @ReactMethod
  public void removeSubviewsFromContainerWithID(int paramInt)
  {
    this.mUIImplementation.removeSubviewsFromContainerWithID(paramInt);
  }
  
  @ReactMethod
  public void replaceExistingNonRootView(int paramInt1, int paramInt2)
  {
    this.mUIImplementation.replaceExistingNonRootView(paramInt1, paramInt2);
  }
  
  @ReactMethod
  public void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    this.mUIImplementation.sendAccessibilityEvent(paramInt1, paramInt2);
  }
  
  @ReactMethod
  public void setJSResponder(int paramInt, boolean paramBoolean)
  {
    this.mUIImplementation.setJSResponder(paramInt, paramBoolean);
  }
  
  @ReactMethod
  public void setLayoutAnimationEnabledExperimental(boolean paramBoolean)
  {
    this.mUIImplementation.setLayoutAnimationEnabledExperimental(paramBoolean);
  }
  
  public void setViewHierarchyUpdateDebugListener(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener paramNotThreadSafeViewHierarchyUpdateDebugListener)
  {
    this.mUIImplementation.setViewHierarchyUpdateDebugListener(paramNotThreadSafeViewHierarchyUpdateDebugListener);
  }
  
  @ReactMethod
  public void showPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    this.mUIImplementation.showPopupMenu(paramInt, paramReadableArray, paramCallback1, paramCallback2);
  }
  
  @ReactMethod
  public void updateView(int paramInt, String paramString, ReadableMap paramReadableMap)
  {
    this.mUIImplementation.updateView(paramInt, paramString, paramReadableMap);
  }
  
  private static class OnSizeChangedListener
    implements SizeMonitoringFrameLayout.OnSizeChangedListener
  {
    private final WeakReference<UIManagerModule> mReference;
    int mTag = 0;
    
    public OnSizeChangedListener(UIManagerModule paramUIManagerModule, int paramInt)
    {
      this.mReference = new WeakReference(paramUIManagerModule);
      this.mTag = paramInt;
    }
    
    public void onSizeChanged(final int paramInt1, final int paramInt2, int paramInt3, int paramInt4)
    {
      final UIManagerModule localUIManagerModule = (UIManagerModule)this.mReference.get();
      if (localUIManagerModule == null) {
        return;
      }
      localUIManagerModule.getReactApplicationContext().runOnNativeModulesQueueThread(new Runnable()
      {
        public void run()
        {
          localUIManagerModule.updateRootNodeSize(UIManagerModule.OnSizeChangedListener.this.mTag, paramInt1, paramInt2);
        }
      });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\UIManagerModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */