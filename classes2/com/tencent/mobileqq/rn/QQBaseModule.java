package com.tencent.mobileqq.rn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import ujv;

public class QQBaseModule
  extends ReactContextBaseJavaModule
{
  static final String BRAND = "Brand";
  static final String MODEL = "Model";
  static final String OS_VERSION = "OSVersion";
  static final String QQ_VERSION = "QQVersion";
  static final String TAG = QQBaseModule.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQBaseModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  static AppInterface getAppInterface()
  {
    AppInterface localAppInterface2 = BaseActivity.sTopActivity.getAppInterface();
    AppInterface localAppInterface1 = localAppInterface2;
    if (localAppInterface2 == null) {
      localAppInterface1 = NearbyRNAppManager.a();
    }
    return localAppInterface1;
  }
  
  private Context getContext()
  {
    Object localObject2 = BaseActivity.sTopActivity;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getReactApplicationContext();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseApplication.getContext();
    }
    return (Context)localObject2;
  }
  
  public static ReactRootView getReactRootView(View paramView)
  {
    if (paramView != null)
    {
      Object localObject1 = null;
      Object localObject2;
      if ((paramView instanceof ReactRootView))
      {
        localObject2 = (ReactRootView)paramView;
        paramView = null;
      }
      for (;;)
      {
        if (paramView != null)
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            break;
          }
        }
        return (ReactRootView)localObject2;
        if ((paramView.getParent() instanceof View))
        {
          paramView = (View)paramView.getParent();
          localObject2 = localObject1;
        }
        else
        {
          paramView = null;
          localObject2 = localObject1;
        }
      }
    }
    return null;
  }
  
  public static QQBaseModule.RNPageListener resolveRNPageListener(ReactApplicationContext paramReactApplicationContext, int paramInt)
  {
    paramReactApplicationContext = resolveView(paramReactApplicationContext, paramInt);
    if (paramReactApplicationContext != null)
    {
      paramReactApplicationContext = getReactRootView(paramReactApplicationContext);
      if (paramReactApplicationContext == null) {}
    }
    for (paramReactApplicationContext = paramReactApplicationContext.getContext();; paramReactApplicationContext = null)
    {
      if ((paramReactApplicationContext instanceof QQBaseModule.RNPageListener)) {}
      for (paramReactApplicationContext = (QQBaseModule.RNPageListener)paramReactApplicationContext;; paramReactApplicationContext = null)
      {
        Object localObject = paramReactApplicationContext;
        if (paramReactApplicationContext == null)
        {
          localObject = paramReactApplicationContext;
          if ((BaseActivity.sTopActivity instanceof QQBaseModule.RNPageListener)) {
            localObject = (QQBaseModule.RNPageListener)BaseActivity.sTopActivity;
          }
        }
        return (QQBaseModule.RNPageListener)localObject;
      }
    }
  }
  
  public static View resolveView(ReactApplicationContext paramReactApplicationContext, int paramInt)
  {
    if ((paramReactApplicationContext == null) || (paramInt < 0)) {
      if (NearbyUtils.a()) {
        NearbyUtils.a(TAG, "resolveView but ReactApplicationContext is null or viewTag < 0", new Object[0]);
      }
    }
    do
    {
      for (;;)
      {
        return null;
        try
        {
          paramReactApplicationContext = (UIManagerModule)paramReactApplicationContext.getNativeModule(UIManagerModule.class);
          if ((paramReactApplicationContext != null) && (paramReactApplicationContext.mUIImplementation != null))
          {
            paramReactApplicationContext = paramReactApplicationContext.mUIImplementation.mNativeViewHierarchyManager;
            if (paramReactApplicationContext != null)
            {
              paramReactApplicationContext = paramReactApplicationContext.getView(paramInt);
              break label156;
            }
            if (!NearbyUtils.a()) {
              break label158;
            }
            NearbyUtils.a(TAG, "resolveView but NativeViewHierarchyManager is null", new Object[0]);
            break label158;
          }
          if (NearbyUtils.a())
          {
            NearbyUtils.a(TAG, "resolveView but UIManagerModule or UIImplementation is null", new Object[0]);
            return null;
          }
        }
        catch (Throwable paramReactApplicationContext)
        {
          paramReactApplicationContext.printStackTrace();
        }
      }
    } while (!NearbyUtils.a());
    NearbyUtils.a(TAG, "resolveView exception: " + paramReactApplicationContext.toString(), new Object[0]);
    return null;
    for (;;)
    {
      label156:
      return paramReactApplicationContext;
      label158:
      paramReactApplicationContext = null;
    }
  }
  
  public static void sendActivityPauseEvent(ReactContext paramReactContext, Object paramObject)
  {
    if (paramReactContext != null) {}
    try
    {
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)paramReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("ActivityOnPause", paramObject);
      return;
    }
    catch (Exception paramReactContext)
    {
      paramReactContext.printStackTrace();
    }
  }
  
  public static void sendActivityResumeEvent(ReactContext paramReactContext, Object paramObject)
  {
    if (paramReactContext != null) {}
    try
    {
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)paramReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("ActivityOnResume", paramObject);
      return;
    }
    catch (Exception paramReactContext)
    {
      paramReactContext.printStackTrace();
    }
  }
  
  @ReactMethod
  public void closeCurRNPage(int paramInt, String paramString, ReadableMap paramReadableMap, Callback paramCallback)
  {
    int i = 0;
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "closeCurRNPage", new Object[] { Integer.valueOf(paramInt), paramString, paramReadableMap, paramCallback });
    }
    paramCallback = resolveRNPageListener(getReactApplicationContext(), paramInt);
    if (paramCallback != null)
    {
      if (!"leftToRight".equalsIgnoreCase(paramString)) {
        break label84;
      }
      i = 2130968587;
      paramInt = 2130968588;
    }
    for (;;)
    {
      paramCallback.a(i, paramInt, paramReadableMap);
      return;
      label84:
      if ("upToBottom".equalsIgnoreCase(paramString))
      {
        i = 2130968592;
        paramInt = 2130968593;
      }
      else if ("fadeIn-fadeOut".equalsIgnoreCase(paramString))
      {
        i = 17432576;
        paramInt = 17432577;
      }
      else
      {
        int j = 0;
        paramInt = i;
        i = j;
      }
    }
  }
  
  @ReactMethod
  public void getAndroidBuild(Callback paramCallback)
  {
    if (paramCallback != null)
    {
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putString("BOARD", Build.BOARD);
      localWritableMap.putString("BOOTLOADER", Build.BOOTLOADER);
      localWritableMap.putString("BRAND", Build.BRAND);
      localWritableMap.putString("DEVICE", Build.DEVICE);
      localWritableMap.putString("DISPLAY", Build.DISPLAY);
      localWritableMap.putString("FINGERPRINT", Build.FINGERPRINT);
      localWritableMap.putString("HARDWARE", Build.HARDWARE);
      localWritableMap.putString("HOST", Build.HOST);
      localWritableMap.putString("ID", Build.ID);
      localWritableMap.putString("MANUFACTURER", Build.MANUFACTURER);
      localWritableMap.putString("MODEL", Build.MODEL);
      localWritableMap.putString("PRODUCT", Build.PRODUCT);
      localWritableMap.putString("TAGS", Build.TAGS);
      localWritableMap.putString("TYPE", Build.TYPE);
      localWritableMap.putString("USER", Build.USER);
      localWritableMap.putDouble("TIME", Build.TIME);
      paramCallback.invoke(new Object[] { localWritableMap });
    }
  }
  
  public Map getConstants()
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    localHashMap.put("OSVersion", Integer.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("Brand", Build.BRAND);
    localHashMap.put("Model", Build.MODEL);
    localHashMap.put("QQVersion", "6.5.5");
    return localHashMap;
  }
  
  public String getName()
  {
    return "QQBaseModule";
  }
  
  @ReactMethod
  public void onPageToShow(int paramInt, String paramString)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "onPageToShow", new Object[] { Integer.valueOf(paramInt) });
    }
    QQBaseModule.RNPageListener localRNPageListener = resolveRNPageListener(getReactApplicationContext(), paramInt);
    if (localRNPageListener != null) {
      localRNPageListener.b(paramString);
    }
  }
  
  @ReactMethod
  public void openNativePage(String paramString1, String paramString2, ReadableMap paramReadableMap)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "openNativePage", new Object[] { paramString1, paramString2, paramReadableMap });
    }
    if ("qqnative".equalsIgnoreCase(paramString1)) {
      paramString1 = getContext();
    }
    do
    {
      do
      {
        try
        {
          paramString1 = JumpParser.a(null, paramString1, paramString2);
          if (paramString1 != null)
          {
            paramString1.a(getAppInterface());
            boolean bool = paramString1.b();
            if (NearbyUtils.b()) {
              NearbyUtils.a(TAG, new Object[] { "openNativePage", Boolean.valueOf(bool) });
            }
            return;
          }
        }
        catch (Exception paramReadableMap)
        {
          do
          {
            for (;;)
            {
              paramString1 = (String)localObject1;
              if (NearbyUtils.b())
              {
                NearbyUtils.a(TAG, new Object[] { "openNativePage", paramString2, paramReadableMap.toString() });
                paramString1 = (String)localObject1;
              }
            }
          } while (!NearbyUtils.b());
          NearbyUtils.a(TAG, new Object[] { "openNativePage", "can not parser action" });
          return;
        }
        if ("sysnative".equalsIgnoreCase(paramString1))
        {
          if ("app-settings:".equals(paramString2)) {
            paramString1 = new Intent("android.settings.SETTINGS");
          }
          for (;;)
          {
            paramString2 = getContext();
            if ((paramString1 == null) || (paramString2 == null)) {
              break;
            }
            if (!(paramString2 instanceof Activity)) {
              paramString1.addFlags(268435456);
            }
            paramString2.startActivity(paramString1);
            return;
            paramString1 = (String)localObject2;
            if ("wireless-settings:".equals(paramString2)) {
              paramString1 = new Intent("android.settings.WIRELESS_SETTINGS");
            }
          }
        }
      } while (!"webview".equalsIgnoreCase(paramString1));
      paramString1 = getContext();
      if ((!TextUtils.isEmpty(paramString2)) && (paramString1 != null))
      {
        paramReadableMap = new Intent(paramString1, QQBrowserActivity.class);
        paramReadableMap.putExtra("url", paramString2);
        paramReadableMap.addFlags(268435456);
        paramString1.startActivity(paramReadableMap);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 4, "gotoWebview url is null");
  }
  
  @ReactMethod
  public void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "report", new Object[] { paramString1, paramString2, paramString5 });
    }
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5))) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "subAction or actionName cannot be null");
      }
    }
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = getAppInterface();
      if (localAppInterface != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 4, "runtime cannot be null");
    return;
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if ((localAppInterface instanceof NearbyAppInterface))
      {
        localAppInterface.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt3, paramString6, paramString7, paramString8, paramString9);
        return;
      }
      localAppInterface.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt3, paramString6, paramString7, paramString8, paramString9);
      return;
    }
  }
  
  @ReactMethod
  public void setImmerseColor(int paramInt, String paramString)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "setImmerseColor", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    QQBaseModule.RNPageListener localRNPageListener = resolveRNPageListener(getReactApplicationContext(), paramInt);
    if (localRNPageListener != null) {
      localRNPageListener.a(paramString);
    }
  }
  
  @ReactMethod
  public void showToast(ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null) {
      return;
    }
    UiThreadUtil.runOnUiThread(new ujv(this, paramReadableMap));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\QQBaseModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */