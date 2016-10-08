package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class CameraCompatibleList
{
  public static String A;
  public static String B;
  static String C;
  static String D;
  static String E;
  static String F;
  static String G;
  static String H;
  static String I;
  static String J;
  static String K;
  static String L;
  static String M;
  static String N;
  static String O;
  static String P;
  static String Q;
  static String R;
  static String S;
  static String T;
  static String U;
  static String V;
  static String W;
  static String X;
  static String Y;
  static String Z;
  public static String a;
  private static Hashtable jdField_a_of_type_JavaUtilHashtable;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  static String aa;
  static String ab;
  static String ac;
  static String ad;
  private static final String ae = "CameraCompatibleList";
  private static final String af = "camera_compatible_list";
  private static final String ag = "YuLong;Coolpad Y75;19|YuLong;Coolpad Y76;19|YuLong;Coolpad K1-NT;19|YuLong;Coolpad SK1-01;19|YuLong;ivvi SK1-02;19|YuLong;Coolpad 5956;19|YuLong;Coolpad Y80D;19|YuLong;Coolpad 8297-C00;19";
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
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
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "NOT_FOCUS_MODEL";
    b = "NOT_CALLBACK_WHEN_SCREENOFF_MODEL";
    c = "NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL";
    d = "NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL_2";
    e = "PREVIEW_ORIENTATION_270_OF_FRONT_MODEL";
    f = "PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2";
    g = "PREVIEW_ORIENTATION_270_OF_BACK_MODEL";
    h = "NOT_TAKE_PICTURE_MODEL";
    i = "PREVIEW_DATA_LENGTH_ERR_MODEL";
    j = "NEED_ROTATION_INFO_90_MODEL";
    k = "NEED_ROTATION_INFO_MODEL";
    l = "PREVIEW_DATA_LENGTH_MIN_640X480_MODLE";
    m = "GL_CHOOSER_CONFIG_MODEL";
    n = "ENCODE_ERROR_NOT_SUPPORT_PTV";
    o = "HW_PRE_SEND_NOT_SUPPORT_MODEL";
    p = "HARDWARE_PRIVILEGE_ERROR_MODEL";
    q = "HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL";
    r = "HW_HARDENCODE_NOT_SUPPORT_MODEL";
    s = "PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE";
    t = "IO_RW_VERY_SLOW_MODLE";
    u = "NO_QUALCOMM_CPU_IS_VERY_SLOW_PHONE";
    v = "BLACK_EGL_MAKECURRENT_ERR_3009";
    w = "BLACK_NOT_SUPPORT_FILTER_PHONE";
    x = "CONST_HEIGHT_MAP_CLIP_WIDTH_POSITIVE_OFFSET_OF_FRONT_CAMERA";
    y = "CAMERA_OPEN_BLOCK_CHOOSE_PERMITTED_MODEL";
    z = "BLACK_OPENGL_ES20_NEED_FLUSH";
    A = "HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL_NOSDK";
    B = "WHITE_LIST_FILTER_HIGH_FPS_PHONE";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    C = "GT-I8262D|SCH-I879|SCH-I829";
    D = "M040|GT-N7102|GT-N7108|HTC_7060|OPPO_R1S|SM-G9250|HUAWEI NXT-TL00|DOOV L5|Lenovo A5860|Nexus 6P|R827T|VIE-AL10";
    E = "M351";
    F = "Meizu;M351;17";
    G = "Nexus 6|Lenovo K860|Nexus 6P|Lenovo A3000-H";
    H = "ZTE;U9180;18;JLS36C|motorola;Moto X Pro;21;LXG22.67-7.1";
    I = "Nexus 5X";
    J = "HTC T329t";
    K = "ZTE-T U880|Coolpad 5219|K-Touch S2";
    L = "M040";
    M = "Mi-4c|MI NOTE Pro";
    N = "samsung;SM-G5108Q;19;KTU84P";
    O = "OPPO;R7c;19|OPPO;A51kc;22|OPPO;OPPO A51kc;22|OPPO;3007;19|OPPO;OPPO 3007;19|OPPO;A31;19|OPPO;OPPO A31;19|OPPO;R7Plusm;22|OPPO;OPPO R7Plusm;22|OPPO;A51;22|OPPO;OPPO A51;22|OPPO;R7sm;22|OPPO;OPPO R7sm;22|OPPO;A53;22|OPPO;OPPO A53;22|OPPO;A53m;22|OPPO;OPPO A53m;22|OPPO;A33;22|OPPO;OPPO A33;22|OPPO;R7sPlus;22|OPPO;OPPO R7sPlus;22|OPPO;A35;22|OPPO;OPPO A35;22|OPPO;A11;19|OPPO;OPPO A11;19|OPPO;R7;19|OPPO;OPPO R7;19|OPPO;R8107;19|OPPO;OPPO R8107;19|OPPO;1107;19|OPPO;OPPO 1107;19|OPPO;R8007;18|OPPO;OPPO R8007;18|OPPO;R8207;19|OPPO;OPPO R8207;19|OPPO;R7007;18|OPPO;OPPO R7007;18|OPPO;N5110;18|OPPO;OPPO N5110;18|OPPO;A33m;22|OPPO;OPPO A33m;22|OPPO;A33t;22|OPPO;OPPO A33t;22|OPPO;N5117;18|OPPO;OPPO N5117;18|ONEPLUS;A0001;22|OnePlus;ONE E1001;22|OnePlus;ONE E1003;22";
    P = "Coolpad 8675|Coolpad 8675-HD|SM-G900|H30-U10|MB855|HUAWEI G730-T00|lPHONE 6";
    Q = "GiONEE;E3T;17";
    R = "Xiaomi;MI 2A;16|meizu;M356;18|meizu;MX4;19|Meizu;m1 note;19";
    S = "BBK;vivo X5L;19|HTC;HTC ONE X;15";
    T = "LGE;Nexus 5";
    U = "Xiaomi;MI 2S";
    V = "asus;ASUS_T00F;21";
    W = "Meizu;MX4 Pro;21";
    X = "htc;HTC T329t;16|htc;HTC T528t;15";
    Y = "Xiaomi;MI 2S";
    Z = "HUAWEI;HUAWEI GRA-CL10";
    aa = "samsung;GT-I8558|samsung;SM-G3818|Lenovo;Lenovo A828t|XiaoMi;HM 2A|OPPO;OPPO R823T|OPPO;R823T|Meizu;M355|samsung;SM-G3812|Meizu;m1 note|OPPO;U707T|OPPO;OPPO U707T|samsung;GT-I9502";
    ab = "";
    ac = "samsung;17;JDQ39";
    ad = "LGE;Nexus 5";
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    }
    jdField_a_of_type_JavaUtilHashtable.put(jdField_a_of_type_JavaLangString, C);
    jdField_a_of_type_JavaUtilHashtable.put(b, D);
    jdField_a_of_type_JavaUtilHashtable.put(c, E);
    jdField_a_of_type_JavaUtilHashtable.put(d, F);
    jdField_a_of_type_JavaUtilHashtable.put(e, G);
    jdField_a_of_type_JavaUtilHashtable.put(f, H);
    jdField_a_of_type_JavaUtilHashtable.put(g, I);
    jdField_a_of_type_JavaUtilHashtable.put(h, J);
    jdField_a_of_type_JavaUtilHashtable.put(i, K);
    jdField_a_of_type_JavaUtilHashtable.put(j, L);
    jdField_a_of_type_JavaUtilHashtable.put(k, M);
    jdField_a_of_type_JavaUtilHashtable.put(l, O);
    jdField_a_of_type_JavaUtilHashtable.put(m, P);
    jdField_a_of_type_JavaUtilHashtable.put(n, Q);
    jdField_a_of_type_JavaUtilHashtable.put(o, U);
    jdField_a_of_type_JavaUtilHashtable.put(p, R);
    jdField_a_of_type_JavaUtilHashtable.put(q, S);
    jdField_a_of_type_JavaUtilHashtable.put(r, V);
    jdField_a_of_type_JavaUtilHashtable.put(y, W);
    jdField_a_of_type_JavaUtilHashtable.put(s, X);
    jdField_a_of_type_JavaUtilHashtable.put(t, Y);
    jdField_a_of_type_JavaUtilHashtable.put(u, Z);
    jdField_a_of_type_JavaUtilHashtable.put(v, ab);
    jdField_a_of_type_JavaUtilHashtable.put(w, aa);
    jdField_a_of_type_JavaUtilHashtable.put(x, N);
    jdField_a_of_type_JavaUtilHashtable.put(z, ac);
    jdField_a_of_type_JavaUtilHashtable.put(A, T);
    jdField_a_of_type_JavaUtilHashtable.put(B, ad);
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "local config has been inited");
    }
  }
  
  private static void a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true) {
      return;
    }
    String str = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("camera_compatible_list", "");
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "initCompatibleList() sp jsonString=" + str);
    }
    if (!TextUtils.isEmpty(str)) {
      a(str, false);
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "updateCompatibleList() input jsonString=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    }
    Object localObject;
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        localObject = new JSONObject(paramString);
        Iterator localIterator = ((JSONObject)localObject).keys();
        if (!localIterator.hasNext()) {
          break label219;
        }
        str1 = (String)localIterator.next();
        str2 = (String)((JSONObject)localObject).get(str1);
        String str3 = (String)jdField_a_of_type_JavaUtilHashtable.get(str1);
        if ((!jdField_a_of_type_JavaUtilHashtable.containsKey(str1)) || (str3 == null)) {
          break label205;
        }
        jdField_a_of_type_JavaUtilHashtable.put(str1, str3 + "|" + str2);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramString) {}
      QLog.d("CameraCompatibleList", 2, "updateCompatibleList json ERROR, msg=" + paramString.getMessage());
      return;
      label205:
      jdField_a_of_type_JavaUtilHashtable.put(str1, str2);
    }
    label219:
    if (paramBoolean)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
      ((SharedPreferences.Editor)localObject).putString("camera_compatible_list", paramString);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "updateCompatibleList() result=" + jdField_a_of_type_JavaUtilHashtable.toString());
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public static boolean a()
  {
    return a(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT, "YuLong;Coolpad Y75;19|YuLong;Coolpad Y76;19|YuLong;Coolpad K1-NT;19|YuLong;Coolpad SK1-01;19|YuLong;ivvi SK1-02;19|YuLong;Coolpad 5956;19|YuLong;Coolpad Y80D;19|YuLong;Coolpad 8297-C00;19");
  }
  
  public static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProductFeature key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    return a(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT, (String)jdField_a_of_type_JavaUtilHashtable.get(paramString));
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      return false;
      paramString2 = paramString2.split("\\|");
      if (paramString2 != null)
      {
        int i2 = paramString2.length;
        int i1 = 0;
        while (i1 < i2)
        {
          if (paramString2[i1].equalsIgnoreCase(paramString1)) {
            return true;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProductFeatureRom key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    return a(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT + ";" + Build.ID, (String)jdField_a_of_type_JavaUtilHashtable.get(paramString));
  }
  
  public static boolean c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProductFeatureRom key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    return a(Build.MANUFACTURER + ";" + Build.VERSION.SDK_INT + ";" + Build.ID, (String)jdField_a_of_type_JavaUtilHashtable.get(paramString));
  }
  
  public static boolean d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProduct key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    paramString = (String)jdField_a_of_type_JavaUtilHashtable.get(paramString);
    return a(Build.MODEL, paramString);
  }
  
  public static boolean e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProduct key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    return a(Build.MANUFACTURER + ";" + Build.MODEL, (String)jdField_a_of_type_JavaUtilHashtable.get(paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\CameraCompatibleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */