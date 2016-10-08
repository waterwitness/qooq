package com.facebook.react.bridge;

import com.fasterxml.jackson.core.JsonGenerator;
import com.tencent.bitapp.pre.binder.server.proxy.jni.ReadableNativeArray;
import java.io.IOException;
import java.util.Map;

public abstract interface NativeModule
{
  public abstract boolean canOverrideExistingModule();
  
  public abstract Map<String, NativeMethod> getMethods();
  
  public abstract String getName();
  
  public abstract void initialize();
  
  public abstract void onCatalystInstanceDestroy();
  
  public abstract void writeConstantsField(JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public static abstract interface NativeMethod
  {
    public abstract String getType();
    
    public abstract void invoke(CatalystInstance paramCatalystInstance, ReadableNativeArray paramReadableNativeArray);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\NativeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */