package com.tencent.ark;

import android.graphics.Bitmap;
import java.util.Map;

public class ark
{
  public static final int APP_MINVER_HIGHER = 3;
  public static final int APP_TARGETVER_LOWER = 2;
  public static final int APP_VER_ERROR = 0;
  public static final int APP_VER_MATCH = 1;
  public static final String ARKMETADATA_JSON = "json";
  public static final String ARKMETADATA_XML = "xml";
  public static final int VariantType_Bool = 2;
  public static final int VariantType_Double = 4;
  public static final int VariantType_Int32 = 3;
  public static final int VariantType_None = 0;
  public static final int VariantType_Null = 1;
  public static final int VariantType_Object = 6;
  public static final int VariantType_String = 5;
  
  public static final native int arkCheckAppVersion(String paramString);
  
  public static final int arkGetMinPlatformVersion()
  {
    return 2;
  }
  
  public static final native float arkGetPixelScale();
  
  public static final int arkGetPlatformBuildNumber()
  {
    return 69073;
  }
  
  public static final int arkGetPlatformVersion()
  {
    return 5;
  }
  
  public static final native void arkHTTPSetDefaultHttpProxy(String paramString, int paramInt);
  
  public static final native int arkHTTPSetDownloadDirectory(String paramString);
  
  public static final native int arkHTTPShutdown();
  
  public static final native int arkHTTPStartup();
  
  public static final native boolean arkModuleRegCallbackWrapper(long paramLong, ModuleCallbackWrapper paramModuleCallbackWrapper);
  
  public static final native boolean arkNotify(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static final native void arkSetPixelScale(float paramFloat);
  
  public static final native void arkSetStoragePath(String paramString);
  
  public static class Application
    extends ark.NativeObject
  {
    public Application(long paramLong)
    {
      super();
    }
  }
  
  public static abstract interface ApplicationCallback
  {
    public abstract void AppCreate(String paramString, ark.Application paramApplication);
    
    public abstract void AppDestroy(String paramString, ark.Application paramApplication);
  }
  
  public static class ArgumentsWrapper
    extends ark.NativeObject
  {
    public ArgumentsWrapper(long paramLong)
    {
      super();
    }
    
    public static native ArgumentsWrapper Create();
    
    private static native void _DeletePtr(long paramLong);
    
    public native void AddArgument(ark.VariantWrapper paramVariantWrapper);
    
    public void DeletePtr()
    {
      if (this.mNative != 0L)
      {
        _DeletePtr(this.mNative);
        this.mNative = 0L;
      }
    }
    
    public native ark.VariantWrapper GetArgument(long paramLong);
    
    public native long GetCount();
    
    protected void finalize()
      throws Throwable
    {
      DeletePtr();
      super.finalize();
    }
  }
  
  public static class Container
    extends ark.NativeObject
  {
    public Container()
    {
      super();
    }
    
    private static final native void delete_Container(long paramLong);
    
    private static final native long new_Container();
    
    public native boolean ActivateRootView();
    
    public native boolean AttachBitmap(Bitmap paramBitmap);
    
    public native boolean CreateRootView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ark.ApplicationCallback paramApplicationCallback);
    
    public native boolean DeactivateRootView();
    
    public void DeletePtr()
    {
      delete_Container(this.mNative);
      this.mNative = 0L;
    }
    
    public native void DetachBitmap(Bitmap paramBitmap);
    
    public native long GetScriptEngine();
    
    public native void MouseClick(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
    
    public native void MouseDown(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
    
    public native void MouseMove(int paramInt1, int paramInt2, long paramLong);
    
    public native void MouseUp(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
    
    public native boolean Paint(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public native void SetContainerCallback(ark.ContainerCallback paramContainerCallback);
    
    public native void SetID(String paramString);
    
    public native void SetMetadata(String paramString1, String paramString2);
    
    public native void SetSize(int paramInt1, int paramInt2);
    
    protected void finalize()
      throws Throwable
    {
      DeletePtr();
      super.finalize();
    }
  }
  
  public static abstract interface ContainerCallback
  {
    public abstract void RegisterModules(long paramLong, String paramString);
    
    public abstract void SyncRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void Update(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface ModuleCallbackWrapper
  {
    public abstract void Destruct();
    
    public abstract String GetTypeName();
    
    public abstract boolean HasMenthod(String paramString);
    
    public abstract boolean Invoke(String paramString, ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper);
  }
  
  public static class NativeObject
  {
    protected long mNative;
    
    public NativeObject(long paramLong)
    {
      this.mNative = paramLong;
    }
  }
  
  public static abstract interface RuntimeClassCallbackWrapper
  {
    public abstract boolean Destruct();
    
    public abstract boolean HasMethod(String paramString);
    
    public abstract boolean Invoke(String paramString, ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper);
  }
  
  public static class VariantWrapper
    extends ark.NativeObject
  {
    public VariantWrapper(long paramLong)
    {
      super();
    }
    
    private static native void _DeletePtr(long paramLong);
    
    public native VariantWrapper Copy();
    
    public native VariantWrapper Create();
    
    public native boolean CreateObject(String paramString, ark.RuntimeClassCallbackWrapper paramRuntimeClassCallbackWrapper);
    
    public void DeletePtr()
    {
      if (this.mNative != 0L)
      {
        _DeletePtr(this.mNative);
        this.mNative = 0L;
      }
    }
    
    public native boolean GetBool();
    
    public native double GetDouble();
    
    public native int GetInt();
    
    public native String GetString();
    
    public native String GetTableAsJsonString();
    
    public native int GetType();
    
    public native boolean Invoke(String paramString, ark.ArgumentsWrapper paramArgumentsWrapper, VariantWrapper paramVariantWrapper);
    
    public native boolean InvokeDefault(ark.ArgumentsWrapper paramArgumentsWrapper, VariantWrapper paramVariantWrapper);
    
    public native boolean IsArray();
    
    public native boolean IsFunction();
    
    public native boolean IsString();
    
    public native boolean IsUserObject();
    
    public native void Reset();
    
    public native boolean SetBool(boolean paramBoolean);
    
    public native boolean SetDouble(double paramDouble);
    
    public native boolean SetInt(int paramInt);
    
    public native boolean SetMap(Map<String, String> paramMap);
    
    public native boolean SetNull();
    
    public native boolean SetString(String paramString);
    
    public native boolean SetTableAsJsonString(String paramString);
    
    protected void finalize()
      throws Throwable
    {
      DeletePtr();
      super.finalize();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ark\ark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */