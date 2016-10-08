package com.tencent.av.mediacodec;

import android.content.res.Resources;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.mediacodec.config.CodecConfigParser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class DeviceCheck
  implements Runnable
{
  public static final String a = "DeviceCheck";
  int jdField_a_of_type_Int;
  Resources jdField_a_of_type_AndroidContentResResources;
  Thread jdField_a_of_type_JavaLangThread;
  
  public DeviceCheck(Resources paramResources)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return false;
      if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
        return d();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
        return d();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI NOTE LTE")) && (Build.PRODUCT.equalsIgnoreCase("virgo"))) {
        return d();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("asus")) && (Build.MODEL.equalsIgnoreCase("ASUS_Z00ADA")) && (Build.PRODUCT.equalsIgnoreCase("CN_Z00A"))) {
        return d();
      }
    } while ((!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (!Build.MODEL.equalsIgnoreCase("MI 4W")) || (!Build.PRODUCT.equalsIgnoreCase("cancro_wc_lte")));
    return d();
  }
  
  static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 4")) && (Build.PRODUCT.equalsIgnoreCase("occam")) && (Build.VERSION.SDK_INT >= 21)) {
      bool1 = c();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 5")) && (Build.PRODUCT.equalsIgnoreCase("hammerhead"))) {
              return c();
            }
            if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500")) && (Build.VERSION.SDK_INT > 18)) {
              return c();
            }
            if ((!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (!Build.MODEL.equalsIgnoreCase("MI 3"))) {
              break;
            }
            bool1 = bool2;
          } while (Build.PRODUCT.equalsIgnoreCase("pisces"));
          if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("LG-D802"))) {
            return c();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("MX4 Pro"))) {
            return c();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("M353")) && (Build.PRODUCT.equalsIgnoreCase("meizu_mx3"))) {
            return c();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("m1 note")) && (Build.PRODUCT.equalsIgnoreCase("m1 note"))) {
            return c();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9005")) && (Build.VERSION.SDK_INT > 18)) {
            return true;
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9006V")) && (Build.VERSION.SDK_INT > 18)) {
            return c();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("smartisan")) && (Build.MODEL.equalsIgnoreCase("SM705")) && (Build.PRODUCT.equalsIgnoreCase("msm8974sfo_lte"))) {
            return c();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
            return c();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("HM 1SC")) && (Build.PRODUCT.equalsIgnoreCase("armani"))) {
            return c();
          }
          bool1 = bool2;
        } while (!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"));
        bool1 = bool2;
      } while (!Build.MODEL.equalsIgnoreCase("HM NOTE 1TD"));
      bool1 = bool2;
    } while (!Build.PRODUCT.equalsIgnoreCase("Icsh92_wet_tdd"));
    return false;
  }
  
  static boolean b(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    List localList = AndroidCodec.a(AndroidCodec.a);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      int j;
      if (i < localList.size())
      {
        localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)localList.get(i), AndroidCodec.a);
        j = 0;
      }
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (a(localCodecCapabilities.colorFormats[j]))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public static boolean d()
  {
    boolean bool2 = false;
    List localList = AndroidCodec.b(AndroidCodec.a);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      int j;
      if (i < localList.size())
      {
        localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)localList.get(i), AndroidCodec.a);
        j = 0;
      }
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (b(localCodecCapabilities.colorFormats[j]))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public static boolean e()
  {
    if (f()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
        } while (Build.VERSION.SDK_INT < 21);
        localObject = ConfigInfo.instance();
      } while (localObject == null);
      localObject = ((ConfigInfo)localObject).getSharpConfigPayloadFromFile();
      if (QLog.isColorLevel()) {
        QLog.d("DeviceCheck", 2, "isSupportAsyncAPI sharpConfigPayload:\n" + (String)localObject);
      }
      localObject = new CodecConfigParser((String)localObject);
    } while ((!((CodecConfigParser)localObject).b()) || (!((CodecConfigParser)localObject).a(2)) || (!((CodecConfigParser)localObject).a()) || (!((CodecConfigParser)localObject).a(1)));
    if (QLog.isColorLevel()) {
      QLog.d("DeviceCheck", 2, "SUPPORT Async API");
    }
    return true;
  }
  
  public static boolean f()
  {
    return false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\mediacodec\DeviceCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */