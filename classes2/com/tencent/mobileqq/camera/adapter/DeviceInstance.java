package com.tencent.mobileqq.camera.adapter;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DeviceInstance
{
  private static final DeviceInstance jdField_a_of_type_ComTencentMobileqqCameraAdapterDeviceInstance = new DeviceInstance();
  public static final String a = "MOTOROLA_Nexus_6";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static final String b = "K-Touch W619";
  private static final String[] b;
  public static final String c = "8150";
  private static String d;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    d = DeviceInstance.class.getSimpleName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "motorola", "mot", "FIH", "Sony Ericsson", "samsung", "HTC", "HUN", "LGE", "alps", "OPPO", "TCL", "LENOVO", "ZTE", "Meizu", "Xiaomi", "HUAWEI", "TIANYU", "sprd", "K-Touch", "YuLong", "CoolPad", "Amazon", "Hisense", "Acer", "GIONEE", "Philips", "asus", "snda.com", "koobee", "AMOI", "Fason", "ainol", "Dell", "dlkjl12389", "haier", "sharp", "BBK", "nubia", "KONKA" };
    b = new String[] { "MOTOROLA", "MOTOROLA", "MOTOROLA", "SONYERICSSON", "SAMSUNG", "HTC", "HTC", "LG", "OPPO", "OPPO", "TCL", "LENOVO", "ZTE", "MEIZU", "XIAOMI", "HUAWEI", "TIANYU", "TIANYU", "TIANYU", "COOLPAD", "COOLPAD", "AMAZON", "HISENSE", "ACER", "JINLI", "PHILIPS", "GOOGLE", "SHENGDA", "KUBI", "XIAXIN", "FANSHANG", "AINUO", "DELL", "DPD", "HAIER", "SHARP", "BBK", "NUBIA", "KONKA" };
  }
  
  private DeviceInstance()
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_a_of_type_ArrayOfJavaLangString[i].toUpperCase(), b[i]);
      i += 1;
    }
    a();
  }
  
  public static DeviceInstance a()
  {
    return jdField_a_of_type_ComTencentMobileqqCameraAdapterDeviceInstance;
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.i(d, 2, "****** DeviceInfo  (+) *****");
      QLog.i(d, 2, "BRAND_KEYS.len = " + jdField_a_of_type_ArrayOfJavaLangString.length);
      QLog.i(d, 2, "BRAND_NAMES.len = " + b.length);
      QLog.i(d, 2, "DeviceTypeName = " + a());
      QLog.i(d, 2, "SubTagName = " + a() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase());
      QLog.i(d, 2, "MODEL = " + Build.MODEL);
      QLog.i(d, 2, "SDK_INT = " + Build.VERSION.SDK_INT);
      QLog.i(d, 2, "BRAND = " + Build.BRAND);
      QLog.i(d, 2, "DEVICE = " + Build.DEVICE);
      QLog.i(d, 2, "DISPLAY = " + Build.DISPLAY);
      QLog.i(d, 2, "HARDWARE = " + Build.HARDWARE);
      QLog.i(d, 2, "MANUFACTURER = " + Build.MANUFACTURER);
      QLog.i(d, 2, "PRODUCT = " + Build.PRODUCT);
      QLog.i(d, 2, "TAGS = " + Build.TAGS);
      QLog.i(d, 2, "USER = " + Build.USER);
      QLog.i(d, 2, "TYPE = " + Build.TYPE);
      QLog.i(d, 2, "****** DeviceInfo (-) *****");
    }
  }
  
  public String a()
  {
    String str;
    if (Build.MODEL.equalsIgnoreCase("K-Touch W619")) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("TIANYU") + " " + Build.MODEL;
    }
    for (;;)
    {
      return str.replace(" ", "_").replace("+", "").replace("(t)", "");
      if ((Build.MODEL.equalsIgnoreCase("8150")) && (Build.BRAND.equalsIgnoreCase("COOLPAD"))) {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("COOLPAD") + " " + Build.MODEL;
      } else {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Build.MANUFACTURER.toUpperCase()) + " " + Build.MODEL;
      }
    }
  }
  
  public String b()
  {
    return a() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\adapter\DeviceInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */