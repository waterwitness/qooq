package com.tencent.av.opengl.config;

import android.text.TextUtils;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.av.config.ConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class RendererConfig
  extends ConfigBaseParser
{
  static final String a = "RendererConfig";
  public static final String b = "OpenGLBlowUp/";
  public static final String c = "OpenGLBlowUp/IsOpen";
  public static final String d = "OpenGLBlowUp/width";
  public static final String e = "OpenGLBlowUp/level";
  public static final String f = "OpenGLBlowUp/versionname";
  public int a;
  public int b;
  public int c;
  public String g;
  
  public RendererConfig(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static RendererConfig a()
  {
    Object localObject = ConfigInfo.instance().getSharpConfigPayloadFromFile();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new RendererConfig((String)localObject);
      if (((RendererConfig)localObject).a()) {}
      return (RendererConfig)localObject;
    }
    return null;
  }
  
  public boolean a()
  {
    try
    {
      this.a = a("OpenGLBlowUp/IsOpen", 0);
      this.b = a("OpenGLBlowUp/width", 0);
      this.c = a("OpenGLBlowUp/level", 0);
      this.g = a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.a + " width: " + this.b + " level: " + this.c + " versionName: " + this.g);
      }
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\config\RendererConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */