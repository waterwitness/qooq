package com.tencent.mobileqq.camera.adapter;

import android.content.SharedPreferences;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CameraAttrs
{
  public static final String A = "int_backCamRotate0";
  public static final String B = "int_backCamRotate90";
  public static final String C = "int_backCamRotate180";
  public static final String D = "int_backCamRotate270";
  public static final String E = "int_frontExifRotate0";
  public static final String F = "int_frontExifRotate90";
  public static final String G = "int_frontExifRotate180";
  public static final String H = "int_frontExifRotate270";
  public static final String I = "int_backExifRotate0";
  public static final String J = "int_backExifRotate90";
  public static final String K = "int_backExifRotate180";
  public static final String L = "int_backExifRotate270";
  public static final String M = "frontCamFlipH";
  public static final String N = "autoFocusAfterPreview";
  private static final String O = "Q.camera.adapter.CameraAttrs";
  private static final String Q = "encrypt_phone_attrs_config.dat";
  private static final String R = "phone_attrs_config.xml";
  private static CameraAttrs a;
  public static final String a = "pref_qcamera_disable";
  public static final int b = 16;
  public static final String b = "xml_version";
  public static final int c = -1;
  public static final String c = "is_need_parse_xml";
  public static final int d = 0;
  public static final int e = 90;
  public static final int f = 180;
  public static final String f = "sysCameraOn";
  public static final int g = 270;
  public static final String g = "str_sysMinVersion";
  public static final String h = "str_sysMaxVersion";
  public static final String i = "disableCameraSDK";
  public static final String j = "readCamNumException";
  public static final String k = "disableFrontCamera";
  public static final String l = "beBlurredPreviewAfterTakePic";
  public static final String m = "beBlurredPicAfterTakePic";
  public static final String n = "disableBackFlashMode";
  public static final String o = "frontFlashModeException";
  public static final String p = "frontFlashNoAuto";
  public static final String q = "backFlashModeException";
  public static final String r = "backFlashNoOn";
  public static final String s = "backFlashNoAuto";
  public static final String t = "disableFocusMode";
  public static boolean t = false;
  public static final String u = "disableAutoFocusDouble";
  public static final String v = "disableFocusModeContinuousPicture";
  public static final String w = "int_frontCamRotate0";
  public static final String x = "int_frontCamRotate90";
  public static final String y = "int_frontCamRotate180";
  public static final String z = "int_frontCamRotate270";
  private String P;
  public int a;
  public final boolean a;
  public boolean b;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public boolean f;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public int j;
  public boolean j;
  public int k;
  public boolean k;
  public int l;
  public boolean l;
  public int m;
  public boolean m;
  public int n;
  public boolean n;
  public int o;
  public boolean o;
  public int p;
  public boolean p;
  public int q;
  public boolean q;
  public int r;
  public boolean r;
  public int s;
  public boolean s;
  public int t;
  public int u;
  public int v;
  public int w;
  
  private CameraAttrs()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = -1;
    this.jdField_n_of_type_Int = -1;
    this.jdField_o_of_type_Int = -1;
    this.jdField_p_of_type_Int = -1;
    this.jdField_q_of_type_Int = -1;
    this.jdField_r_of_type_Int = -1;
    this.jdField_s_of_type_Int = -1;
    this.jdField_t_of_type_Int = -1;
    this.u = -1;
    this.v = -1;
    this.w = -1;
  }
  
  public static CameraAttrs a()
  {
    if (jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraAttrs == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraAttrs == null) {
        jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraAttrs = new CameraAttrs();
      }
      return jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraAttrs;
    }
    finally {}
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs start-------------------------------------------------------------");
    }
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "CameraAttrs qcameraConfigVersion = " + this.jdField_a_of_type_Int);
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "CameraAttrs disableCameraSDK = " + this.c);
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "CameraAttrs autoFocusAfterPreview = " + this.jdField_s_of_type_Boolean);
    if (QLog.isColorLevel())
    {
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs sysCameraOnKey = " + this.b);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs str_sysMinVersionKey = " + this.jdField_d_of_type_JavaLangString);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs str_sysMaxVersionKey = " + this.e);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs readCamNumException = " + this.jdField_d_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableFrontCamera = " + this.f);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs beBlurredPreviewAfterTakePic = " + this.g);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs beBlurredPicAfterTakePic = " + this.jdField_h_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableBackFlashMode = " + this.jdField_i_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs frontFlashModeException = " + this.jdField_j_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs backFlashModeException = " + this.jdField_l_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs backFlashNoOn = " + this.jdField_m_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs backFlashNoAuto = " + this.jdField_n_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs frontFlashNoAuto = " + this.jdField_k_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableFocusMode = " + this.jdField_o_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableFocusModeContinuousPicture = " + this.jdField_q_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableAutoFocusDouble = " + this.jdField_p_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontCamRotate0 = " + this.jdField_h_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontCamRotate90 = " + this.jdField_i_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontCamRotate180 = " + this.jdField_j_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontCamRotate270 = " + this.jdField_k_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backCamRotate0 = " + this.jdField_l_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backCamRotate90 = " + this.jdField_m_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backCamRotate180 = " + this.jdField_n_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backCamRotate270 = " + this.jdField_o_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontExifRotate0 = " + this.jdField_p_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontExifRotate90 = " + this.jdField_q_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontExifRotate180 = " + this.jdField_r_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontExifRotate270 = " + this.jdField_s_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backExifRotate0 = " + this.jdField_t_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backExifRotate90 = " + this.u);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backExifRotate180 = " + this.v);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backExifRotate270 = " + this.w);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs frontCamFlipH = " + this.jdField_r_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs autoFocusAfterPreview = " + this.jdField_s_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs end-------------------------------------------------------------\n");
    }
  }
  
  private void b(SharedPreferences paramSharedPreferences)
  {
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "[loadValueFromPref] + BEGIN");
    this.jdField_a_of_type_Int = paramSharedPreferences.getInt("qcamera_conf_version", 0);
    this.b = paramSharedPreferences.getBoolean("sysCameraOn", false);
    this.jdField_d_of_type_JavaLangString = paramSharedPreferences.getString("str_sysMinVersion", "1.0.0");
    this.e = paramSharedPreferences.getString("str_sysMaxVersion", "1000.0.0");
    this.c = paramSharedPreferences.getBoolean("disableCameraSDK", true);
    this.jdField_d_of_type_Boolean = paramSharedPreferences.getBoolean("readCamNumException", false);
    this.f = paramSharedPreferences.getBoolean("disableFrontCamera", false);
    this.g = paramSharedPreferences.getBoolean("beBlurredPreviewAfterTakePic", false);
    this.jdField_h_of_type_Boolean = paramSharedPreferences.getBoolean("beBlurredPicAfterTakePic", false);
    this.jdField_i_of_type_Boolean = paramSharedPreferences.getBoolean("disableBackFlashMode", false);
    this.jdField_l_of_type_Boolean = paramSharedPreferences.getBoolean("backFlashModeException", false);
    this.jdField_j_of_type_Boolean = paramSharedPreferences.getBoolean("frontFlashModeException", false);
    this.jdField_m_of_type_Boolean = paramSharedPreferences.getBoolean("backFlashNoOn", false);
    this.jdField_n_of_type_Boolean = paramSharedPreferences.getBoolean("backFlashNoAuto", false);
    this.jdField_k_of_type_Boolean = paramSharedPreferences.getBoolean("frontFlashNoAuto", false);
    this.jdField_o_of_type_Boolean = paramSharedPreferences.getBoolean("disableFocusMode", false);
    this.jdField_q_of_type_Boolean = paramSharedPreferences.getBoolean("disableFocusModeContinuousPicture", false);
    this.jdField_p_of_type_Boolean = paramSharedPreferences.getBoolean("disableAutoFocusDouble", false);
    this.jdField_h_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate0", -1);
    this.jdField_i_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate90", -1);
    this.jdField_j_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate180", -1);
    this.jdField_k_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate270", -1);
    this.jdField_l_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate0", -1);
    this.jdField_m_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate90", -1);
    this.jdField_n_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate180", -1);
    this.jdField_o_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate270", -1);
    this.jdField_p_of_type_Int = paramSharedPreferences.getInt("int_frontExifRotate0", -1);
    this.jdField_q_of_type_Int = paramSharedPreferences.getInt("int_frontExifRotate90", -1);
    this.jdField_r_of_type_Int = paramSharedPreferences.getInt("int_frontExifRotate180", -1);
    this.jdField_s_of_type_Int = paramSharedPreferences.getInt("int_frontExifRotate270", -1);
    this.jdField_t_of_type_Int = paramSharedPreferences.getInt("int_backExifRotate0", -1);
    this.u = paramSharedPreferences.getInt("int_backExifRotate90", -1);
    this.v = paramSharedPreferences.getInt("int_backExifRotate180", -1);
    this.w = paramSharedPreferences.getInt("int_backExifRotate270", -1);
    this.jdField_r_of_type_Boolean = paramSharedPreferences.getBoolean("frontCamFlipH", false);
    this.jdField_s_of_type_Boolean = paramSharedPreferences.getBoolean("autoFocusAfterPreview", false);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "[loadValueFromPref] + END");
    }
  }
  
  public void a(SharedPreferences paramSharedPreferences)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + BEGIN");
    }
    if (paramSharedPreferences.getInt("qcamera_conf_version", 0) != this.jdField_a_of_type_Int) {
      b(paramSharedPreferences);
    }
    a();
    jdField_t_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + END");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\adapter\CameraAttrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */