package com.tencent.bitapp.pre.binder.server;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.tencent.bitapp.pre.binder.aidl.Java2Jni.Stub;
import com.tencent.bitapp.pre.binder.aidl.Jni2Java;
import com.tencent.bitapp.pre.binder.server.proxy.jni.ReadableNativeArray;

public class Java2JniService
  extends Service
  implements Java2JniImpl.ReactCallbackCall
{
  public static final String TAG = "Java2JniService";
  final RemoteCallbackList<Jni2Java> mCallbacks = new RemoteCallbackList();
  Java2JniImpl mProxy;
  
  public Java2JniImpl getProxy()
  {
    if (this.mProxy == null)
    {
      this.mProxy = new Java2JniImpl(null, this);
      this.mProxy.setApplicationContext(getApplicationContext());
    }
    return this.mProxy;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2JniService", "Java2JniService onBind");
    }
    return new Java2JniBinder(null);
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (FLog.isLoggable(3)) {
      FLog.d("Java2JniService", "Java2JniService onDestroy kill self, cross process need kill");
    }
    System.exit(0);
  }
  
  public void reactCallbackCall(int paramInt1, int paramInt2, ReadableNativeArray paramReadableNativeArray)
  {
    synchronized (this.mCallbacks)
    {
      int j = this.mCallbacks.beginBroadcast();
      if (FLog.isLoggable(3)) {
        FLog.d("Java2JniService", "reactCallbackCall len: " + j);
      }
      try
      {
        paramReadableNativeArray = Arguments.toBundle(paramReadableNativeArray);
        int i = 0;
        while (i < j)
        {
          ((Jni2Java)this.mCallbacks.getBroadcastItem(i)).reactCallbackCall(paramInt1, paramInt2, paramReadableNativeArray);
          i += 1;
        }
        paramReadableNativeArray = finally;
      }
      catch (RemoteException paramReadableNativeArray)
      {
        if (FLog.isLoggable(3)) {
          FLog.d("Java2JniService", "callBack RemoteException", paramReadableNativeArray);
        }
        this.mCallbacks.finishBroadcast();
        return;
      }
    }
  }
  
  public void reactCallbackonBatchComplete()
  {
    synchronized (this.mCallbacks)
    {
      int j = this.mCallbacks.beginBroadcast();
      if (FLog.isLoggable(3)) {
        FLog.d("Java2JniService", "reactCallbackCall len: " + j);
      }
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((Jni2Java)this.mCallbacks.getBroadcastItem(i)).reactCallbackonBatchComplete();
            i += 1;
          }
          catch (RemoteException localRemoteException)
          {
            if (FLog.isLoggable(3)) {
              FLog.d("Java2JniService", "callBack RemoteException", localRemoteException);
            }
          }
        }
      }
      this.mCallbacks.finishBroadcast();
      return;
    }
  }
  
  public void registerCallbackReal(Jni2Java paramJni2Java)
    throws RemoteException
  {
    if (paramJni2Java != null)
    {
      this.mCallbacks.register(paramJni2Java);
      if (FLog.isLoggable(3)) {
        FLog.d("Java2JniService", "registerCallback");
      }
    }
  }
  
  public void unregisterCallbackReal(Jni2Java paramJni2Java)
    throws RemoteException
  {
    if (paramJni2Java != null) {
      this.mCallbacks.unregister(paramJni2Java);
    }
  }
  
  private class Java2JniBinder
    extends Java2Jni.Stub
  {
    private Java2JniBinder() {}
    
    public void reactBridgeCallfunction(int paramInt1, int paramInt2, Bundle paramBundle)
      throws RemoteException
    {
      Java2JniService.this.getProxy().reactBridgeCallfunctionReal(paramInt1, paramInt2, Arguments.fromBundle2Array(paramBundle));
    }
    
    public void reactBridgeDestory()
      throws RemoteException
    {
      Java2JniService.this.getProxy().reactBridgeDestoryReal();
    }
    
    public void reactBridgeExecuteJSScript(String paramString)
      throws RemoteException
    {
      Java2JniService.this.getProxy().reactBridgeExecuteJSScriptReal(paramString);
    }
    
    public void reactBridgeHandleMemoryPressure(String paramString)
      throws RemoteException
    {
      Java2JniService.this.getProxy().reactBridgeHandleMemoryPressureReal(paramString);
    }
    
    public void reactBridgeInvokeCallback(int paramInt, Bundle paramBundle)
      throws RemoteException
    {
      Java2JniService.this.getProxy().reactBridgeInvokeCallbackReal(paramInt, Arguments.fromBundle2Array(paramBundle));
    }
    
    public void reactBridgeLoadScriptFromFile(String[] paramArrayOfString, String paramString)
      throws RemoteException
    {
      Java2JniService.this.getProxy().reactBridgeLoadScriptFromFileReal(paramArrayOfString, paramString);
    }
    
    public void reactBridgeSetGlobalvariable(String paramString1, String paramString2)
      throws RemoteException
    {
      Java2JniService.this.getProxy().reactBridgeSetGlobalvariableReal(paramString1, paramString2);
    }
    
    public void registerCallback(Jni2Java paramJni2Java)
      throws RemoteException
    {
      Java2JniService.this.registerCallbackReal(paramJni2Java);
    }
    
    public void setSoLoadPath(String[] paramArrayOfString)
      throws RemoteException
    {
      Java2JniService.this.getProxy().setSoLoadPathReal(paramArrayOfString);
    }
    
    public void unregisterCallback(Jni2Java paramJni2Java)
      throws RemoteException
    {
      Java2JniService.this.unregisterCallbackReal(paramJni2Java);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\Java2JniService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */