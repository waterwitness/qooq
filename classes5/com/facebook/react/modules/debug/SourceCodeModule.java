package com.facebook.react.modules.debug;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.tencent.bitapp.pre.binder.server.proxy.jni.WritableNativeMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class SourceCodeModule
  extends BaseJavaModule
{
  private final String mSourceMapUrl;
  private final String mSourceUrl;
  
  public SourceCodeModule(String paramString1, String paramString2)
  {
    this.mSourceMapUrl = paramString2;
    this.mSourceUrl = paramString1;
  }
  
  @Nullable
  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    if (this.mSourceUrl != null) {
      localHashMap.put("scriptURL", this.mSourceUrl);
    }
    return localHashMap;
  }
  
  public String getName()
  {
    return "RKSourceCode";
  }
  
  @ReactMethod
  public void getScriptText(Callback paramCallback1, Callback paramCallback2)
  {
    paramCallback2 = new WritableNativeMap();
    paramCallback2.putString("fullSourceMappingURL", this.mSourceMapUrl);
    paramCallback1.invoke(new Object[] { paramCallback2 });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\debug\SourceCodeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */