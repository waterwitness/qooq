package com.tencent.bitapp.pre.binder.client;

import android.content.res.AssetManager;
import com.facebook.common.logging.FLog;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl.NativeModulesReactCallback;
import com.facebook.react.bridge.MemoryPressure;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableType;
import com.facebook.soloader.SoLoader;
import com.tencent.bitapp.pre.binder.server.Java2JniImpl;
import com.tencent.bitapp.pre.binder.server.Java2JniImpl.ReactCallbackCall;
import com.tencent.bitapp.pre.binder.server.proxy.jni.JavaScriptExecutor;
import com.tencent.bitapp.pre.binder.server.proxy.jni.ReadableNativeArray;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class Java2jniClientSameProcess
  implements IJava2jniClient, Java2JniImpl.ReactCallbackCall
{
  static final String TAG = Java2jniClientSameProcess.class.getSimpleName();
  Map<String, String> initParams = null;
  WeakReference<CatalystInstance> mCIRef;
  JavaScriptExecutor mJSExecutor;
  Java2JniImpl mJava2Jni;
  
  public void addInitParams(String paramString1, String paramString2)
  {
    this.initParams.put(paramString1, paramString2);
  }
  
  public void init()
  {
    if (this.mJava2Jni == null)
    {
      this.mJava2Jni = new Java2JniImpl(this.mJSExecutor, this);
      setSoLoadPath();
      if (this.initParams != null)
      {
        if (FLog.isLoggable(3)) {
          FLog.d(TAG, "initParams size: " + this.initParams.size());
        }
        Iterator localIterator = this.initParams.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          setGlobalvariable((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      if (FLog.isLoggable(3)) {
        FLog.d(TAG, "initParams is null");
      }
    }
  }
  
  public boolean isInvalidView(int paramInt)
  {
    return true;
  }
  
  public void reactBridgeCallfunction(int paramInt1, int paramInt2, Object[] paramArrayOfObject, String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Java2JniClient reactBridgeCallfunction tracingName : " + paramString);
    }
    init();
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeCallfunctionReal(paramInt1, paramInt2, Arguments.fromJavaArgs(paramArrayOfObject));
        return;
      }
      catch (Exception paramArrayOfObject)
      {
        do
        {
          paramArrayOfObject.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d(TAG, "Java2JniClient reactBridgeCallfunction exception: " + paramArrayOfObject.getMessage());
        return;
      }
    }
    FLog.d(TAG, "Java2JniClient mJava2Jni is null");
  }
  
  public void reactBridgeDestory()
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Java2JniClient reactBridgeDestory");
    }
    if (this.mJava2Jni != null) {}
    for (;;)
    {
      try
      {
        this.mJava2Jni.reactBridgeDestoryReal();
      }
      catch (Exception localException1)
      {
        try
        {
          this.mJava2Jni.onDestroy();
          this.mJava2Jni = null;
          this.initParams.clear();
          this.mJSExecutor = null;
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          if (!FLog.isLoggable(3)) {
            continue;
          }
          FLog.d(TAG, "Java2JniClient reactBridgeDestory exception: " + localException1.getMessage());
          continue;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
      }
      if (FLog.isLoggable(3)) {
        FLog.d(TAG, "Java2JniClient mJava2Jni is null");
      }
    }
  }
  
  public void reactBridgeExecuteJSScript(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Java2JniClient reactBridgeExecuteJSScript: " + paramString);
    }
    init();
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeExecuteJSScriptReal(paramString);
        return;
      }
      catch (Exception paramString)
      {
        do
        {
          paramString.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d(TAG, "Java2JniClient reactBridgeExecuteJSScript exception: " + paramString.getMessage());
        return;
      }
    }
    FLog.d(TAG, "Java2JniClient mJava2Jni is null");
  }
  
  public void reactBridgeHandleMemoryPressure(MemoryPressure paramMemoryPressure)
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Java2JniClient reactBridgeHandleMemoryPressure");
    }
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeHandleMemoryPressureReal(paramMemoryPressure.toString());
        return;
      }
      catch (Exception paramMemoryPressure)
      {
        do
        {
          paramMemoryPressure.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d(TAG, "Java2JniClient reactBridgeHandleMemoryPressure exception: " + paramMemoryPressure.getMessage());
        return;
      }
    }
    FLog.d(TAG, "Java2JniClient mJava2Jni is null");
  }
  
  public void reactBridgeInvokeCallback(int paramInt, Object[] paramArrayOfObject)
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Java2JniClient reactBridgeInvokeCallback");
    }
    init();
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeInvokeCallbackReal(paramInt, Arguments.fromJavaArgs(paramArrayOfObject));
        return;
      }
      catch (Exception paramArrayOfObject)
      {
        do
        {
          paramArrayOfObject.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d(TAG, "Java2JniClient reactBridgeInvokeCallback exception: " + paramArrayOfObject.getMessage());
        return;
      }
    }
    FLog.d(TAG, "Java2JniClient mJava2Jni is null");
  }
  
  public void reactBridgeLoadScriptFromAssets(AssetManager paramAssetManager, String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Java2JniClient reactBridgeLoadScriptFromAssets");
    }
    init();
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.loadScriptFromAssets(paramAssetManager, paramString);
        return;
      }
      catch (Exception paramAssetManager)
      {
        do
        {
          paramAssetManager.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d(TAG, "Java2JniClient reactBridgeLoadScriptFromAssets exception: " + paramAssetManager.getMessage());
        return;
      }
    }
    FLog.d(TAG, "Java2JniClient mJava2Jni is null");
  }
  
  public void reactBridgeLoadScriptFromFile(String[] paramArrayOfString, @Nullable String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Java2JniClient reactBridgeLoadScriptFromFile");
    }
    init();
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeLoadScriptFromFileReal(paramArrayOfString, paramString);
        return;
      }
      catch (Exception paramArrayOfString)
      {
        do
        {
          paramArrayOfString.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d(TAG, "Java2JniClient reactBridgeLoadScriptFromFile exception: " + paramArrayOfString.getMessage());
        return;
      }
    }
    FLog.d(TAG, "Java2JniClient mJava2Jni is null");
  }
  
  public void reactCallbackCall(int paramInt1, int paramInt2, ReadableNativeArray paramReadableNativeArray)
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "reactCallbackCall moduleId: " + paramInt1 + " | methodId: " + paramInt2);
    }
    Object localObject2;
    if (paramReadableNativeArray != null)
    {
      localObject1 = new StringBuilder(200);
      ((StringBuilder)localObject1).append("reactCallbackCall ");
      int j = paramReadableNativeArray.size();
      int i = 0;
      if (i < j)
      {
        ((StringBuilder)localObject1).append(", [").append(i).append(",");
        localObject2 = paramReadableNativeArray.getType(i);
        if (localObject2 == ReadableType.Array) {
          ((StringBuilder)localObject1).append(paramReadableNativeArray.getArray(i));
        }
        for (;;)
        {
          ((StringBuilder)localObject1).append("]");
          i += 1;
          break;
          if (localObject2 == ReadableType.Boolean) {
            ((StringBuilder)localObject1).append(paramReadableNativeArray.getBoolean(i));
          } else if (localObject2 == ReadableType.Double) {
            ((StringBuilder)localObject1).append(paramReadableNativeArray.getDouble(i));
          } else if (localObject2 == ReadableType.Map) {
            ((StringBuilder)localObject1).append(paramReadableNativeArray.getMap(i));
          } else if (localObject2 == ReadableType.Null) {
            ((StringBuilder)localObject1).append("null");
          } else if (localObject2 == ReadableType.Number) {
            ((StringBuilder)localObject1).append(paramReadableNativeArray.getDouble(i));
          } else if (localObject2 == ReadableType.String) {
            ((StringBuilder)localObject1).append(paramReadableNativeArray.getString(i));
          }
        }
      }
      if (FLog.isLoggable(3)) {
        FLog.d(TAG, ((StringBuilder)localObject1).toString());
      }
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ReactInstanceManager.mReactInstanceManager.getCurrentReactContext();
      if (localObject2 != null) {
        localObject1 = ((ReactContext)localObject2).getCatalystInstance();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        WeakReference localWeakReference = this.mCIRef;
        localObject2 = localObject1;
        if (localWeakReference != null) {
          localObject2 = (CatalystInstance)localWeakReference.get();
        }
      }
      if (localObject2 != null)
      {
        ((CatalystInstance)localObject2).getNativeModulesReactCallback().call(paramInt1, paramInt2, paramReadableNativeArray);
        return;
      }
      if (FLog.isLoggable(6))
      {
        FLog.e(TAG, "reactCallbackCall CatalystInstance is null");
        return;
      }
    }
    catch (Exception paramReadableNativeArray)
    {
      paramReadableNativeArray.printStackTrace();
    }
  }
  
  public void reactCallbackonBatchComplete()
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Jni2JavaStub onBatchComplete mListener");
    }
    try
    {
      ReactInstanceManager.mReactInstanceManager.getCurrentReactContext().getCatalystInstance().getNativeModulesReactCallback().onBatchComplete();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void setGlobalvariable(String paramString1, String paramString2)
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Java2JniClient setGlobalvariable propertyName: " + paramString1 + " | jsonEncodedArgument: " + paramString2);
    }
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeSetGlobalvariableReal(paramString1, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        do
        {
          paramString1.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d(TAG, "Java2JniClient setGlobalvariable exception: " + paramString1.getMessage());
        return;
      }
    }
    FLog.d(TAG, "Java2JniClient mJava2Jni is null");
  }
  
  public void setJavaScriptExecutor(CatalystInstance paramCatalystInstance, JavaScriptExecutor paramJavaScriptExecutor)
  {
    this.mJSExecutor = paramJavaScriptExecutor;
    if (paramCatalystInstance != null)
    {
      this.mCIRef = new WeakReference(paramCatalystInstance);
      return;
    }
    this.mCIRef = null;
  }
  
  public void setLastViewId(int paramInt) {}
  
  protected void setSoLoadPath()
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "Java2JniClient setSoLoadPath");
    }
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        String[] arrayOfString2 = new String[SoLoader.extSoSource.size()];
        String[] arrayOfString1 = arrayOfString2;
        if (SoLoader.extSoSource.size() > 0) {
          arrayOfString1 = (String[])SoLoader.extSoSource.toArray(arrayOfString2);
        }
        if (FLog.isLoggable(3)) {
          FLog.d(TAG, "Java2JniClient setSoLoadPath SoLoader.extSoSource: " + SoLoader.extSoSource);
        }
        this.mJava2Jni.setSoLoadPathReal(arrayOfString1);
        return;
      }
      catch (Exception localException)
      {
        do
        {
          localException.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d(TAG, "Java2JniClient setGlobalvariable exception: " + localException.getMessage());
        return;
      }
    }
    FLog.d(TAG, "Java2JniClient mJava2Jni is null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\client\Java2jniClientSameProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */