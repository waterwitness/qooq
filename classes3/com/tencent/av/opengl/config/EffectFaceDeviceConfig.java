package com.tencent.av.opengl.config;

import android.text.TextUtils;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.av.config.ConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class EffectFaceDeviceConfig
  extends ConfigBaseParser
{
  private static EffectFaceDeviceConfig jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig;
  static final String jdField_a_of_type_JavaLangString = "EffectFaceDeviceConfig";
  public static final String b = "EffectFaceDeviceConfig/";
  public static final String c = "EffectFaceDeviceConfig/isClose";
  public static final String d = "EffectFaceDeviceConfig/width";
  public static final String e = "EffectFaceDeviceConfig/level";
  public static final String f = "EffectFaceDeviceConfig/versionname";
  public int a;
  public String g;
  
  public EffectFaceDeviceConfig(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static EffectFaceDeviceConfig a()
  {
    if (jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig != null) {
      return jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig;
    }
    try
    {
      Object localObject = ConfigInfo.instance().getSharpConfigPayloadFromFile();
      if (QLog.isColorLevel()) {
        QLog.i("EffectFaceDeviceConfig", 2, "EffectFaceDeviceConfig useEffectFace: mData: " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig = new EffectFaceDeviceConfig((String)localObject);
        if (jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig.a()) {}
        localObject = jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig;
        return (EffectFaceDeviceConfig)localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean a()
  {
    try
    {
      this.jdField_a_of_type_Int = a("EffectFaceDeviceConfig/isClose", 0);
      this.g = a("EffectFaceDeviceConfig/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("EffectFaceDeviceConfig", 2, "EffectFaceDeviceConfig useEffectFace: isClose: " + this.jdField_a_of_type_Int + " versionName: " + this.g);
      }
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\config\EffectFaceDeviceConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */