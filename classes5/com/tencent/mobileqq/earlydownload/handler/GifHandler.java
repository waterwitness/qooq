package com.tencent.mobileqq.earlydownload.handler;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.NativeGifIndex8;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.GifData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class GifHandler
  extends EarlyHandler
{
  static final int jdField_a_of_type_Int = 0;
  static final String jdField_a_of_type_JavaLangString = GifHandler.class.getSimpleName();
  static final int b = 1;
  public static final String b = "qq.android.native.gif";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GifHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.native.gif", paramQQAppInterface);
  }
  
  public Class a()
  {
    return GifData.class;
  }
  
  public String a()
  {
    return "actEarlyNativeGif";
  }
  
  public void a()
  {
    Object localObject = DeviceInfoUtil.m();
    boolean bool;
    if (((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("x86"))) || (Build.CPU_ABI.equalsIgnoreCase("x86")) || (Build.CPU_ABI2.equalsIgnoreCase("x86")) || (Build.CPU_ABI.equalsIgnoreCase("mips")) || (Build.CPU_ABI2.equalsIgnoreCase("mips")))
    {
      if (!QLog.isColorLevel()) {
        break label400;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "cpu info:" + Build.CPU_ABI);
      bool = false;
    }
    for (;;)
    {
      localObject = new GifData();
      ((GifData)localObject).use_new_gif_so = bool;
      EarlyDataFactory.a((XmlData)localObject, new String[] { "use_new_gif_so" });
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "isGifAvail:" + bool);
      }
      return;
      if (("ZTE-T U880".equalsIgnoreCase(Build.MODEL)) || ("ZTE-T U960s".equalsIgnoreCase(Build.MODEL)))
      {
        bool = false;
      }
      else if ("0".equals(DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.gif_decode.name(), "1")))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "in dpc whitelist.");
        }
        bool = false;
      }
      else
      {
        bool = NativeGifIndex8.isGifEngineAvail();
        if (bool) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "GifOptimationIndex8", "LoadSo", 0, 0, "", "", Build.VERSION.RELEASE, "Success,[" + Build.MANUFACTURER + "],[" + Build.MODEL + "]");
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w(jdField_a_of_type_JavaLangString, 2, "soload test.isGifAvail:" + bool);
          }
          break;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "GifOptimationIndex8", "LoadSo", 0, 0, "", "", Build.VERSION.RELEASE, "Failure,[" + Build.MANUFACTURER + "],[" + Build.MODEL + "]");
        }
        label400:
        bool = false;
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDownload success: " + paramString);
      }
      FileUtils.a(paramString, WebpSoLoader.a(BaseApplicationImpl.getContext()), false);
      GifData localGifData = new GifData();
      localGifData.gif_so_is_update = true;
      EarlyDataFactory.a(localGifData, new String[] { "gif_so_is_update" });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.a(paramString);
    a();
  }
  
  public String b()
  {
    String str2 = Build.VERSION.RELEASE.trim();
    Object localObject2 = str2;
    int i;
    if (str2 != null)
    {
      localObject2 = str2;
      if (str2.length() > 2)
      {
        if (str2.length() == 3) {
          break label198;
        }
        i = str2.charAt(0);
        if ((str2.charAt(2) != '4') || (i != 52)) {
          break label183;
        }
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(str2.substring(str2.length() - 1));
        if (i >= 3)
        {
          Object localObject1 = "4.4.4";
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "version: " + (String)localObject1);
            localObject2 = localObject1;
          }
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = ((String)localObject2).replace('.', '_');
          }
          return (String)localObject1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "errMsg:" + localNumberFormatException.getMessage());
        }
        i = 0;
        continue;
        str1 = "4.4.2";
        continue;
      }
      label183:
      String str1 = str2.substring(0, str2.length() - 2);
      continue;
      label198:
      i = str2.charAt(0);
      str1 = str2;
      if (str2.charAt(2) == '4')
      {
        str1 = str2;
        if (i == 52) {
          str1 = "4.4.2";
        }
      }
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func doOnServerResp begins, respData" + paramXmlData);
    }
    if ("0".equals(DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.gif_decode.name(), "1")))
    {
      paramXmlData = new GifData();
      paramXmlData.use_new_gif_so = false;
      EarlyDataFactory.a(paramXmlData, new String[] { "use_new_gif_so" });
      return;
    }
    if ((paramXmlData == null) || (!(paramXmlData instanceof GifData)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func doOnServerResp ends");
      }
      super.b(paramXmlData);
      return;
    }
    GifData localGifData = (GifData)paramXmlData;
    String str = b();
    if ("2_2".equals(str))
    {
      paramXmlData.MD5 = localGifData.m2_2;
      paramXmlData.strResURL_big = localGifData.v2_2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "url:" + paramXmlData.strResURL_big + ",md5:" + paramXmlData.MD5);
      }
      if ((!"invalid".equals(paramXmlData.MD5)) && (!"invalid".equals(paramXmlData.strResURL_big))) {
        break;
      }
      paramXmlData = new GifData();
      paramXmlData.use_new_gif_so = false;
      EarlyDataFactory.a(paramXmlData, new String[] { "use_new_gif_so" });
      return;
      if ("2_3".equals(str))
      {
        paramXmlData.MD5 = localGifData.m2_3;
        paramXmlData.strResURL_big = localGifData.v2_3;
      }
      else if ("4_0".equals(str))
      {
        paramXmlData.MD5 = localGifData.m4_0;
        paramXmlData.strResURL_big = localGifData.v4_0;
      }
      else if ("4_1".equals(str))
      {
        paramXmlData.MD5 = localGifData.m4_1;
        paramXmlData.strResURL_big = localGifData.v4_1;
      }
      else if ("4_2".equals(str))
      {
        paramXmlData.MD5 = localGifData.m4_2;
        paramXmlData.strResURL_big = localGifData.v4_2;
      }
      else if ("4_3".equals(str))
      {
        paramXmlData.MD5 = localGifData.m4_3;
        paramXmlData.strResURL_big = localGifData.v4_3;
      }
      else if ("4_4_2".equals(str))
      {
        paramXmlData.MD5 = localGifData.m4_4_2;
        paramXmlData.strResURL_big = localGifData.v4_4_2;
      }
      else if ("4_4_4".equals(str))
      {
        paramXmlData.MD5 = localGifData.m4_4_4;
        paramXmlData.strResURL_big = localGifData.v4_4_4;
      }
      else if ("5_0".equals(str))
      {
        paramXmlData.MD5 = localGifData.m5_0;
        paramXmlData.strResURL_big = localGifData.v5_0;
      }
      else if ("5_1".equals(str))
      {
        paramXmlData.MD5 = localGifData.m5_1;
        paramXmlData.strResURL_big = localGifData.v5_1;
      }
      else if ("5_2".equals(str))
      {
        paramXmlData.MD5 = localGifData.m5_2;
        paramXmlData.strResURL_big = localGifData.v5_2;
      }
      else if ("5_3".equals(str))
      {
        paramXmlData.MD5 = localGifData.m5_3;
        paramXmlData.strResURL_big = localGifData.v5_3;
      }
      else if ("5_4".equals(str))
      {
        paramXmlData.MD5 = localGifData.m5_4;
        paramXmlData.strResURL_big = localGifData.v5_4;
      }
      else if ("6_0".equals(str))
      {
        paramXmlData.MD5 = localGifData.m6_0;
        paramXmlData.strResURL_big = localGifData.v6_0;
      }
      else if ("6_1".equals(str))
      {
        paramXmlData.MD5 = localGifData.m6_1;
        paramXmlData.strResURL_big = localGifData.v6_1;
      }
    }
    super.b(paramXmlData);
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\GifHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */