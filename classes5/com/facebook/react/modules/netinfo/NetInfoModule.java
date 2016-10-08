package com.facebook.react.modules.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.tencent.bitapp.pre.binder.server.proxy.jni.WritableNativeMap;
import fb.support.v4.net.ConnectivityManagerCompat;

public class NetInfoModule
  extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  private static final String CONNECTION_TYPE_NONE = "NONE";
  private static final String CONNECTION_TYPE_UNKNOWN = "UNKNOWN";
  private static final String MISSING_PERMISSION_MESSAGE = "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />";
  private String mConnectivity = "";
  private final ConnectivityBroadcastReceiver mConnectivityBroadcastReceiver;
  private final ConnectivityManager mConnectivityManager;
  private final ConnectivityManagerCompat mConnectivityManagerCompat;
  private boolean mNoNetworkPermission = false;
  
  public NetInfoModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mConnectivityManager = ((ConnectivityManager)paramReactApplicationContext.getSystemService("connectivity"));
    this.mConnectivityManagerCompat = new ConnectivityManagerCompat();
    this.mConnectivityBroadcastReceiver = new ConnectivityBroadcastReceiver(null);
  }
  
  private WritableMap createConnectivityEventMap()
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    localWritableNativeMap.putString("network_info", this.mConnectivity);
    return localWritableNativeMap;
  }
  
  private String getCurrentConnectionType()
  {
    try
    {
      NetworkInfo localNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
      {
        if (ConnectivityManager.isNetworkTypeValid(localNetworkInfo.getType())) {
          return localNetworkInfo.getTypeName().toUpperCase();
        }
        return "UNKNOWN";
      }
    }
    catch (SecurityException localSecurityException)
    {
      this.mNoNetworkPermission = true;
      return "UNKNOWN";
    }
    return "NONE";
  }
  
  private void registerReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    getReactApplicationContext().registerReceiver(this.mConnectivityBroadcastReceiver, localIntentFilter);
  }
  
  private void sendConnectivityChangedEvent()
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("networkStatusDidChange", createConnectivityEventMap());
  }
  
  private void unregisterReceiver()
  {
    try
    {
      getReactApplicationContext().unregisterReceiver(this.mConnectivityBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!FLog.isLoggable(5)) {}
      FLog.w("React", localIllegalArgumentException.getMessage());
    }
  }
  
  private void updateAndSendConnectionType()
  {
    String str = getCurrentConnectionType();
    if (!str.equalsIgnoreCase(this.mConnectivity))
    {
      this.mConnectivity = str;
      sendConnectivityChangedEvent();
    }
  }
  
  @ReactMethod
  public void getCurrentConnectivity(Callback paramCallback1, Callback paramCallback2)
  {
    if (this.mNoNetworkPermission)
    {
      if (paramCallback2 == null)
      {
        if (FLog.isLoggable(6)) {
          FLog.e("React", "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
        }
        return;
      }
      paramCallback2.invoke(new Object[] { "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />" });
      return;
    }
    paramCallback1.invoke(new Object[] { createConnectivityEventMap() });
  }
  
  public String getName()
  {
    return "NetInfo";
  }
  
  public void initialize()
  {
    getReactApplicationContext().addLifecycleEventListener(this);
  }
  
  @ReactMethod
  public void isConnectionMetered(Callback paramCallback)
  {
    if (this.mNoNetworkPermission)
    {
      if (FLog.isLoggable(6)) {
        FLog.e("React", "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
      }
      return;
    }
    ConnectivityManagerCompat localConnectivityManagerCompat = this.mConnectivityManagerCompat;
    paramCallback.invoke(new Object[] { Boolean.valueOf(ConnectivityManagerCompat.isActiveNetworkMetered(this.mConnectivityManager)) });
  }
  
  public void onHostDestroy() {}
  
  public void onHostPause()
  {
    unregisterReceiver();
  }
  
  public void onHostResume()
  {
    registerReceiver();
  }
  
  private class ConnectivityBroadcastReceiver
    extends BroadcastReceiver
  {
    private ConnectivityBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        NetInfoModule.this.updateAndSendConnectionType();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\netinfo\NetInfoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */