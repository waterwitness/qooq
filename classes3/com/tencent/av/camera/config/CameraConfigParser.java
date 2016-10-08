package com.tencent.av.camera.config;

import android.os.Build.VERSION;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CameraConfigParser
  extends ConfigBaseParser
{
  public static String A;
  public static String B;
  public static String C;
  public static String D;
  public static String E;
  public static String F;
  public static String G;
  public static String H;
  public static String I;
  public static String J;
  public static String K;
  public static String L;
  public static String M;
  public static String N;
  public static String O;
  private static final String R = "CameraConfigParser";
  public static final String a = "sharp/camera_angle/";
  public static final String b = "sharp/camera_angle_landscape/";
  public static final String c = "enable";
  public static final String d = "local/";
  public static final String e = "remote/";
  public static final String f = "front/";
  public static final String g = "back/";
  public static final String h = "sensor";
  public static final String i = "mini_sdk";
  public static final String j = "front";
  public static final String k = "back";
  public static final String l = "0";
  public static final String m = "90";
  public static final String n = "180";
  public static final String o = "270";
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  public byte a;
  public int a;
  public byte b;
  public int b;
  public byte c;
  public int c;
  public byte d;
  public int d;
  public byte e;
  public byte f;
  public byte g;
  public byte h;
  public byte i;
  public byte j;
  public byte k;
  public byte l;
  public byte m;
  public byte n;
  public byte o;
  public byte p;
  public byte q;
  public byte r;
  public byte s;
  public byte t;
  public byte u;
  public byte v;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    StringBuilder localStringBuilder = new StringBuilder();
    jdField_p_of_type_JavaLangString = "sharp/camera_angle/" + "enable";
    localStringBuilder.setLength(0);
    jdField_q_of_type_JavaLangString = "sharp/camera_angle/" + "local/" + "front";
    localStringBuilder.setLength(0);
    jdField_r_of_type_JavaLangString = "sharp/camera_angle/" + "local/" + "back";
    localStringBuilder.setLength(0);
    jdField_s_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "front/" + "0";
    localStringBuilder.setLength(0);
    jdField_t_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "front/" + "90";
    localStringBuilder.setLength(0);
    jdField_u_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "front/" + "180";
    localStringBuilder.setLength(0);
    jdField_v_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "front/" + "270";
    localStringBuilder.setLength(0);
    w = "sharp/camera_angle/" + "remote/" + "back/" + "0";
    localStringBuilder.setLength(0);
    x = "sharp/camera_angle/" + "remote/" + "back/" + "90";
    localStringBuilder.setLength(0);
    y = "sharp/camera_angle/" + "remote/" + "back/" + "180";
    localStringBuilder.setLength(0);
    z = "sharp/camera_angle/" + "remote/" + "back/" + "270";
    localStringBuilder.setLength(0);
    A = "sharp/camera_angle/" + "sensor";
    localStringBuilder.setLength(0);
    B = "sharp/camera_angle/" + "mini_sdk";
    localStringBuilder.setLength(0);
    C = "sharp/camera_angle_landscape/" + "enable";
    localStringBuilder.setLength(0);
    D = "sharp/camera_angle_landscape/" + "local/" + "front";
    localStringBuilder.setLength(0);
    E = "sharp/camera_angle_landscape/" + "local/" + "back";
    localStringBuilder.setLength(0);
    F = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "0";
    localStringBuilder.setLength(0);
    G = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "90";
    localStringBuilder.setLength(0);
    H = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "180";
    localStringBuilder.setLength(0);
    I = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "270";
    localStringBuilder.setLength(0);
    J = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "0";
    localStringBuilder.setLength(0);
    K = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "90";
    localStringBuilder.setLength(0);
    L = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "180";
    localStringBuilder.setLength(0);
    M = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "270";
    localStringBuilder.setLength(0);
    N = "sharp/camera_angle_landscape/" + "sensor";
    localStringBuilder.setLength(0);
    O = "sharp/camera_angle_landscape/" + "mini_sdk";
    localStringBuilder.setLength(0);
  }
  
  public CameraConfigParser(String paramString)
  {
    super(paramString);
  }
  
  private byte a(int paramInt)
  {
    if ((paramInt < -128) || (paramInt > 127)) {
      throw new IllegalArgumentException(paramInt + " out of the range of byte");
    }
    return (byte)paramInt;
  }
  
  public boolean a()
  {
    return a(jdField_p_of_type_JavaLangString, this.jdField_a_of_type_Int) >= 1;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    if (a()) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Int = a(B, this.jdField_b_of_type_Int);
        if (Build.VERSION.SDK_INT < this.jdField_b_of_type_Int) {
          continue;
        }
        this.jdField_a_of_type_Byte = a(a(jdField_q_of_type_JavaLangString, this.jdField_a_of_type_Byte));
        this.jdField_b_of_type_Byte = a(a(jdField_r_of_type_JavaLangString, this.jdField_b_of_type_Byte));
        this.jdField_c_of_type_Byte = a(a(jdField_s_of_type_JavaLangString, this.jdField_c_of_type_Byte));
        this.jdField_d_of_type_Byte = a(a(jdField_t_of_type_JavaLangString, this.jdField_d_of_type_Byte));
        this.e = a(a(jdField_u_of_type_JavaLangString, this.e));
        this.f = a(a(jdField_v_of_type_JavaLangString, this.f));
        this.g = a(a(w, this.g));
        this.h = a(a(x, this.h));
        this.i = a(a(y, this.i));
        this.j = a(a(z, this.j));
        this.k = a(a(A, this.k));
        bool1 = true;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CameraConfigParser", 2, "parse camera angle config error, reset data.", localException);
        this.jdField_a_of_type_Byte = 0;
        this.jdField_b_of_type_Byte = 0;
        this.jdField_c_of_type_Byte = 0;
        this.jdField_d_of_type_Byte = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.jdField_b_of_type_Int = 0;
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraConfigParser", 2, "value_local_front:" + this.jdField_a_of_type_Byte + ", value_local_back:" + this.jdField_b_of_type_Byte + ", value_remote_front_0:" + this.jdField_c_of_type_Byte + ", value_remote_front_90:" + this.jdField_d_of_type_Byte + ", value_remote_front_180:" + this.e + ", value_remote_front_270:" + this.f + ", value_remote_back_0:" + this.g + ", value_remote_back_90:" + this.h + ", value_remote_back_180:" + this.i + ", value_remote_back_270:" + this.j + ", value_sensor:" + this.k + ", value_minisdk:" + this.jdField_b_of_type_Int);
      }
      return bool1;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CameraConfigParser", 2, "ignore camera angle config: sdk version not in range, miniSdk:" + this.jdField_b_of_type_Int);
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CameraConfigParser", 2, "camera angle config disable, return");
          bool1 = bool2;
        }
      }
    }
  }
  
  public boolean c()
  {
    return a(C, this.jdField_c_of_type_Int) >= 1;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    if (c()) {}
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_Int = a(O, this.jdField_d_of_type_Int);
        if (Build.VERSION.SDK_INT < this.jdField_d_of_type_Int) {
          continue;
        }
        this.l = a(a(D, this.l));
        this.m = a(a(E, this.m));
        this.n = a(a(F, this.n));
        this.o = a(a(G, this.o));
        this.jdField_p_of_type_Byte = a(a(H, this.jdField_p_of_type_Byte));
        this.jdField_q_of_type_Byte = a(a(I, this.jdField_q_of_type_Byte));
        this.jdField_r_of_type_Byte = a(a(J, this.jdField_r_of_type_Byte));
        this.jdField_s_of_type_Byte = a(a(K, this.jdField_s_of_type_Byte));
        this.jdField_t_of_type_Byte = a(a(L, this.jdField_t_of_type_Byte));
        this.jdField_u_of_type_Byte = a(a(M, this.jdField_u_of_type_Byte));
        this.jdField_v_of_type_Byte = a(a(N, this.jdField_v_of_type_Byte));
        bool1 = true;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CameraConfigParser", 2, "parse camera landscape angle config error, reset data.", localException);
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.jdField_p_of_type_Byte = 0;
        this.jdField_q_of_type_Byte = 0;
        this.jdField_r_of_type_Byte = 0;
        this.jdField_s_of_type_Byte = 0;
        this.jdField_t_of_type_Byte = 0;
        this.jdField_u_of_type_Byte = 0;
        this.jdField_v_of_type_Byte = 0;
        this.jdField_d_of_type_Int = 0;
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraConfigParser", 2, "value_landscape_local_front:" + this.l + ", value_landscape_local_back:" + this.m + ", value_landscape_remote_front_0:" + this.n + ", value_landscape_remote_front_90:" + this.o + ", value_landscape_remote_front_180:" + this.jdField_p_of_type_Byte + ", value_landscape_remote_front_270:" + this.jdField_q_of_type_Byte + ", value_landscape_remote_back_0:" + this.jdField_r_of_type_Byte + ", value_landscape_remote_back_90:" + this.jdField_s_of_type_Byte + ", value_landscape_remote_back_180:" + this.jdField_t_of_type_Byte + ", value_landscape_remote_back_270:" + this.jdField_u_of_type_Byte + ", value_landscape_sensor:" + this.jdField_v_of_type_Byte + ", value_landscape_minisdk:" + this.jdField_d_of_type_Int);
      }
      return bool1;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CameraConfigParser", 2, "ignore camera landscape angle config: sdk version not in range, miniSdk:" + this.jdField_d_of_type_Int);
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CameraConfigParser", 2, "camera landscape angle config disable");
          bool1 = bool2;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\camera\config\CameraConfigParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */