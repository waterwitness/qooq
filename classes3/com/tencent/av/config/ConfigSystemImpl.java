package com.tencent.av.config;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.camera.config.CameraConfigParser;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ggx;
import ggz;
import ghb;

public class ConfigSystemImpl
{
  static byte A = 0;
  static byte B = 0;
  static byte C = 0;
  static byte D = 1;
  static byte E = 0;
  static byte F = 1;
  static byte G = 1;
  static byte H = 0;
  public static final byte a = 0;
  static int jdField_a_of_type_Int = 0;
  static final String jdField_a_of_type_JavaLangString = "ConfigSystem";
  static volatile boolean jdField_a_of_type_Boolean = false;
  public static final byte b = 1;
  static int jdField_b_of_type_Int = 0;
  static volatile boolean jdField_b_of_type_Boolean = false;
  public static final byte c = 2;
  static int jdField_c_of_type_Int = 0;
  static boolean jdField_c_of_type_Boolean = false;
  public static final byte d = 3;
  public static final int d = 12;
  static byte e;
  static byte f;
  static byte g;
  static byte h;
  static byte i;
  static byte j;
  static byte k;
  static byte l;
  static byte m;
  static byte n;
  static byte o;
  static byte p;
  static byte q;
  static byte r;
  static byte s;
  static byte t;
  static byte u;
  static byte v;
  static byte w;
  static byte x;
  static byte y;
  static byte z;
  Context jdField_a_of_type_AndroidContentContext = null;
  ConfigPBProtocol jdField_a_of_type_ComTencentAvConfigConfigPBProtocol = null;
  VcSystemInfo jdField_a_of_type_ComTencentAvCoreVcSystemInfo = null;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  String jdField_b_of_type_JavaLangString = null;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    e = 0;
    f = 0;
    g = 0;
    h = 0;
    i = 0;
    j = 0;
    k = 0;
    l = 0;
    m = 0;
    n = 0;
    jdField_a_of_type_Int = 1;
    p = 0;
    q = 0;
    r = 0;
    s = 0;
    t = 0;
    u = 0;
    v = 0;
    w = 0;
    x = 0;
    y = 0;
    jdField_b_of_type_Int = 1;
    A = 0;
    B = 0;
    C = 1;
    jdField_c_of_type_Int = -1;
  }
  
  public ConfigSystemImpl(String paramString, Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo = new VcSystemInfo();
    VcSystemInfo.a();
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol = new ConfigPBProtocol();
  }
  
  static byte a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, byte paramByte, boolean paramBoolean4)
  {
    if (!jdField_a_of_type_Boolean) {}
    label59:
    label71:
    do
    {
      do
      {
        try
        {
          if (!jdField_a_of_type_Boolean)
          {
            a(paramContext);
            jdField_a_of_type_Boolean = true;
          }
          byte b1 = 0;
          if (!paramBoolean3) {
            break label71;
          }
          if (!paramBoolean2) {
            break label59;
          }
          if (paramBoolean1)
          {
            b1 = p;
            return b1;
          }
        }
        finally {}
        return e;
        if (paramBoolean1) {
          return q;
        }
        return f;
        if (paramBoolean4)
        {
          if (paramBoolean1) {
            return z;
          }
          return o;
        }
        if (!paramBoolean2) {
          break;
        }
        if (paramByte == 0)
        {
          if (paramBoolean1) {
            return r;
          }
          return g;
        }
        if (paramByte == 1)
        {
          if (paramBoolean1) {
            return s;
          }
          return h;
        }
        if (paramByte == 2)
        {
          if (paramBoolean1) {
            return t;
          }
          return i;
        }
      } while (paramByte != 3);
      if (paramBoolean1) {
        return u;
      }
      return j;
      if (paramByte == 0)
      {
        if (paramBoolean1) {
          return v;
        }
        return k;
      }
      if (paramByte == 1)
      {
        if (paramBoolean1) {
          return w;
        }
        return l;
      }
      if (paramByte == 2)
      {
        if (paramBoolean1) {
          return x;
        }
        return m;
      }
    } while (paramByte != 3);
    if (paramBoolean1) {
      return y;
    }
    return n;
  }
  
  public static int a(Context paramContext)
  {
    if (jdField_c_of_type_Int >= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "system sensor value:" + jdField_c_of_type_Int);
      }
      return jdField_c_of_type_Int;
    }
    try
    {
      jdField_c_of_type_Int = Integer.parseInt(PhoneStatusTools.a(paramContext, "ro.qq.camera.sensor"));
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        jdField_c_of_type_Int = 0;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "read system sensor property fail", paramContext);
        }
        if (jdField_c_of_type_Int < 0) {
          jdField_c_of_type_Int = 0;
        }
      }
    }
    finally
    {
      if (jdField_c_of_type_Int >= 0) {
        break label113;
      }
      jdField_c_of_type_Int = 0;
    }
    return jdField_c_of_type_Int;
  }
  
  public static int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, true, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if ((!paramBoolean3) || (jdField_b_of_type_Boolean)) {
      return i1;
    }
    return a(paramContext);
  }
  
  static void a(Context paramContext)
  {
    Object localObject = null;
    ConfigInfo localConfigInfo = ConfigInfo.instance();
    if (localConfigInfo != null) {
      localObject = localConfigInfo.getSharpConfigPayloadFromFile();
    }
    boolean bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new CameraConfigParser((String)localObject);
      jdField_b_of_type_Boolean = ((CameraConfigParser)localObject).b();
      if (jdField_b_of_type_Boolean)
      {
        e = ((CameraConfigParser)localObject).a;
        f = ((CameraConfigParser)localObject).jdField_b_of_type_Byte;
        g = ((CameraConfigParser)localObject).c;
        h = ((CameraConfigParser)localObject).jdField_d_of_type_Byte;
        i = ((CameraConfigParser)localObject).e;
        j = ((CameraConfigParser)localObject).f;
        k = ((CameraConfigParser)localObject).g;
        l = ((CameraConfigParser)localObject).h;
        m = ((CameraConfigParser)localObject).i;
        n = ((CameraConfigParser)localObject).j;
        o = ((CameraConfigParser)localObject).k;
        jdField_a_of_type_Int = ((CameraConfigParser)localObject).jdField_b_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "angle_local_front: " + e + ", angle_local_background: " + f + ", angle_remote_front_0: " + g + ", angle_remote_front_90: " + h + ", angle_remote_front_180: " + i + ", angle_remote_front_270: " + j + ", angle_remote_background_0: " + k + ", angle_remote_background_90: " + l + ", angle_remote_background_180: " + m + ", angle_remote_background_270: " + n + ", angle_sensor: " + o + ", angle_mini_sdk:" + jdField_a_of_type_Int);
        }
      }
      bool2 = ((CameraConfigParser)localObject).d();
      bool1 = bool2;
      if (bool2)
      {
        p = ((CameraConfigParser)localObject).l;
        q = ((CameraConfigParser)localObject).m;
        r = ((CameraConfigParser)localObject).n;
        s = ((CameraConfigParser)localObject).o;
        t = ((CameraConfigParser)localObject).p;
        u = ((CameraConfigParser)localObject).q;
        v = ((CameraConfigParser)localObject).r;
        w = ((CameraConfigParser)localObject).s;
        x = ((CameraConfigParser)localObject).t;
        y = ((CameraConfigParser)localObject).u;
        z = ((CameraConfigParser)localObject).v;
        jdField_b_of_type_Int = ((CameraConfigParser)localObject).jdField_d_of_type_Int;
        bool1 = bool2;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "angle_landscape_local_front: " + p + ", angle_landscape_local_back: " + q + ", angle_landscape_remote_front_0: " + r + ", angle_landscape_remote_front_90: " + s + ", angle_landscape_remote_front_180: " + t + ", angle_landscape_remote_front_270: " + u + ", angle_landscape_remote_back_0: " + v + ", angle_landscape_remote_back_90: " + w + ", angle_landscape_remote_back_180: " + x + ", angle_landscape_remote_back_270: " + y + ", angle_landscape_sensor: " + z + ", angle_landscape_mini_sdk:" + jdField_b_of_type_Int);
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (jdField_b_of_type_Boolean) {
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "using new camera angle config");
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ConfigSystem", 2, "using old camera angle config");
              }
              if ((bool1) && (QLog.isColorLevel())) {
                QLog.d("ConfigSystem", 2, "using new camera angle landscape config");
              }
              paramContext = Common.a(paramContext, "VideoConfigInfo");
            } while (paramContext == null);
            localObject = new ConfigPBProtocol();
          } while (((ConfigPBProtocol)localObject).a(paramContext) != 0);
          paramContext = ((ConfigPBProtocol)localObject).a();
        } while (paramContext == null);
        e = paramContext.jdField_a_of_type_Ggx.a;
        f = paramContext.jdField_a_of_type_Ggx.a;
        g = paramContext.jdField_a_of_type_Ggx.c;
        h = paramContext.jdField_a_of_type_Ggx.e;
        i = paramContext.jdField_a_of_type_Ggx.g;
        j = paramContext.jdField_a_of_type_Ggx.i;
        k = paramContext.jdField_a_of_type_Ggx.jdField_d_of_type_Byte;
        l = paramContext.jdField_a_of_type_Ggx.f;
        m = paramContext.jdField_a_of_type_Ggx.h;
        n = paramContext.jdField_a_of_type_Ggx.j;
        A = paramContext.jdField_a_of_type_Ggx.k;
        B = paramContext.jdField_a_of_type_Ggx.l;
      } while (!QLog.isColorLevel());
      QLog.d("ConfigSystem", 2, "angle_local_front: " + e + ", angle_local_background: " + f + ", angle_remote_front_0: " + g + ", angle_remote_front_90: " + h + ", angle_remote_front_180: " + i + ", angle_remote_front_270: " + j + ", angle_remote_background_0: " + k + ", angle_remote_background_90: " + l + ", angle_remote_background_180: " + m + ", angle_remote_background_270: " + n);
      return;
    }
  }
  
  static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "updateAVSwitchTypeTLV");
    }
    Object localObject = null;
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = Common.a(paramContext, "VideoConfigInfo");
    }
    if (arrayOfByte == null)
    {
      paramContext = (Context)localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ConfigSystem", 2, "not have config file");
        paramContext = (Context)localObject;
      }
      if (paramContext == null) {
        break label196;
      }
      C = paramContext.a;
      D = paramContext.e;
      E = paramContext.f;
      F = paramContext.g;
      G = paramContext.h;
      H = paramContext.i;
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "WL_DEBUG dAudioHowlingEnable = " + H);
      }
    }
    label196:
    while (!QLog.isColorLevel())
    {
      return;
      paramContext = new ConfigPBProtocol();
      if (paramContext.a(arrayOfByte) != 0)
      {
        paramContext = (Context)localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ConfigSystem", 2, "unPack TLV video config err");
        paramContext = (Context)localObject;
        break;
      }
      paramArrayOfByte = paramContext.a();
      paramContext = (Context)localObject;
      if (paramArrayOfByte == null) {
        break;
      }
      paramContext = paramArrayOfByte.jdField_a_of_type_Ghb;
      break;
    }
    QLog.d("ConfigSystem", 2, "updateAVSwitchTypeTLV info == null");
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "isDAudioEnable:" + C);
    }
    return C == 1;
  }
  
  public static boolean a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "WL_DEBUG isNeedStartVideoProcess");
    }
    if (paramArrayOfByte != null)
    {
      paramString = new ConfigSystemImpl(paramString, paramContext);
      paramString.a(paramArrayOfByte);
      paramString.a();
      return paramString.a();
    }
    return false;
  }
  
  public static byte[] a(long paramLong, String paramString, Context paramContext)
  {
    TraeConfigUpdate.a().a("request", -1);
    return new ConfigSystemImpl(paramString, paramContext).a(paramLong);
  }
  
  public static int[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      ConfigPBProtocol localConfigPBProtocol;
      do
      {
        return null;
        localConfigPBProtocol = new ConfigPBProtocol();
        if (localConfigPBProtocol.a(paramArrayOfByte) == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConfigSystem", 2, "unPack PB err");
      return null;
      paramArrayOfByte = localConfigPBProtocol.a();
    } while ((paramArrayOfByte == null) || (!paramArrayOfByte.jdField_a_of_type_Ggz.jdField_a_of_type_Boolean));
    return new int[] { paramArrayOfByte.jdField_a_of_type_Ggz.jdField_a_of_type_Int, paramArrayOfByte.jdField_a_of_type_Ggz.jdField_b_of_type_Int, paramArrayOfByte.jdField_a_of_type_Ggz.jdField_c_of_type_Int, paramArrayOfByte.jdField_a_of_type_Ggz.jdField_d_of_type_Int, paramArrayOfByte.jdField_a_of_type_Ggz.jdField_e_of_type_Int, paramArrayOfByte.jdField_a_of_type_Ggz.f, paramArrayOfByte.jdField_a_of_type_Ggz.g, paramArrayOfByte.jdField_a_of_type_Ggz.h, paramArrayOfByte.jdField_a_of_type_Ggz.i, paramArrayOfByte.jdField_a_of_type_Ggz.j, paramArrayOfByte.jdField_a_of_type_Ggz.k, paramArrayOfByte.jdField_a_of_type_Ggz.l };
  }
  
  public static int b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, false, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if (paramBoolean3)
    {
      if (!jdField_b_of_type_Boolean) {
        break label41;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "server config enabled");
      }
    }
    return i1;
    label41:
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "server config disabled");
    }
    return a(paramContext);
  }
  
  public static String b(Context paramContext)
  {
    paramContext = Common.a(paramContext, "VideoConfigInfo");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "getHWCodecTestPayload not have config file");
      }
      return "";
    }
    ConfigPBProtocol localConfigPBProtocol = new ConfigPBProtocol();
    if (localConfigPBProtocol.a(paramContext) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "getHWCodecTestPayload unPack TLV video config err");
      }
      return "";
    }
    paramContext = localConfigPBProtocol.a();
    if (paramContext != null) {
      return paramContext.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static boolean b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "isDPSTNEnable:" + D);
    }
    return D == 1;
  }
  
  public static int c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "getPstnLevel --> isPstnEnable = " + D + " isPstnLevelHigh = " + E + " isPstnLevelMiddle = " + F);
    }
    if (D != 1) {}
    do
    {
      return 0;
      if (E == 1) {
        return 1;
      }
      if (F == 1) {
        return 2;
      }
      if ((E == 0) && (F == 0)) {
        return 3;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConfigSystem", 2, "getPstnLevel --> Error Can not get the right level");
    return 0;
  }
  
  public static boolean c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "isSupportSmallScreen --> " + G);
    }
    return G == 1;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool = true;
    if (!jdField_c_of_type_Boolean) {
      a(paramContext, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "isAudioHowlingEnable --> " + H);
    }
    if (H == 1) {
      bool = false;
    }
    return bool;
  }
  
  public String a(Context paramContext)
  {
    return a(Common.a(paramContext, "VideoConfigInfo"));
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "getSharpConfigPayload not have config file");
      }
      return "";
    }
    ConfigPBProtocol localConfigPBProtocol = new ConfigPBProtocol();
    if (localConfigPBProtocol.a(paramArrayOfByte) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "getSharpConfigPayload unPack TLV video config err");
      }
      return "";
    }
    paramArrayOfByte = localConfigPBProtocol.a();
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "WL_DEBUG WriteConfigInfoToFile");
    }
    String str1;
    String str2;
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile commit!");
      }
      Common.a(this.jdField_a_of_type_AndroidContentContext, "VideoConfigInfo", this.jdField_a_of_type_ArrayOfByte);
      C = 1;
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ArrayOfByte);
      str1 = a(this.jdField_a_of_type_ArrayOfByte);
      if ((str1 != null) && (str1.length() > 0))
      {
        str2 = str1.substring(0, 1);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile SharpConfigPayload: " + str1 + " sharpConfigType: " + str2);
        }
        if (!str2.equals("0")) {
          break label185;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile SharpConfigPayload clear");
        }
        Common.a(this.jdField_a_of_type_AndroidContentContext, "SharpConfigPayload", "".getBytes());
      }
    }
    label185:
    do
    {
      return;
      if (str2.equals("1"))
      {
        str1 = str1.substring(2);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile SharpConfigPayload payload: " + str1);
        }
        Common.a(this.jdField_a_of_type_AndroidContentContext, "SharpConfigPayload", str1.getBytes());
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"));
        return;
      }
    } while ((!str2.equals("2")) || (!QLog.isColorLevel()));
    QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile SharpConfigPayload url");
  }
  
  void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public byte[] a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol;
    localObject.getClass();
    localObject = new ConfigPBProtocol.TerminalInfo((ConfigPBProtocol)localObject);
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_a_of_type_Int = 201;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.d();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_c_of_type_Int = VcSystemInfo.f();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_d_of_type_Int = VcSystemInfo.e();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_e_of_type_Int = ((int)(VcSystemInfo.c() / 1000L));
    ((ConfigPBProtocol.TerminalInfo)localObject).f = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).g = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).h = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).i = this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.o;
    ((ConfigPBProtocol.TerminalInfo)localObject).j = this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.p;
    ((ConfigPBProtocol.TerminalInfo)localObject).k = 22;
    ((ConfigPBProtocol.TerminalInfo)localObject).l = b(this.jdField_a_of_type_AndroidContentContext);
    ((ConfigPBProtocol.TerminalInfo)localObject).m = 37;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_b_of_type_JavaLangString = ("android_" + Build.VERSION.RELEASE);
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_c_of_type_JavaLangString = VcSystemInfo.b();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_d_of_type_JavaLangString = Build.VERSION.INCREMENTAL;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_e_of_type_JavaLangString = Common.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol.a(paramLong, (ConfigPBProtocol.TerminalInfo)localObject);
    return this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol.a();
  }
  
  public int b(Context paramContext)
  {
    int i1 = 0;
    paramContext = Common.a(paramContext, "SharpConfigPayload");
    if (paramContext != null)
    {
      String str = new String(paramContext);
      i1 = str.indexOf('|');
      paramContext = str.substring(0, i1);
      str = str.substring(i1 + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "GetSharpConfigPayloadFromFile get version: " + paramContext + ". payload: " + str);
      }
      i1 = Integer.parseInt(paramContext);
    }
    return i1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\config\ConfigSystemImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */