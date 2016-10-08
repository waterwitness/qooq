package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkSoLoader;
import com.tencent.mobileqq.earlydownload.xmldata.ArkSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArkSoDownloadHandler
  extends EarlyHandler
{
  public static final String a = "QArkSoDownloadHandler";
  public static boolean a = false;
  private static final String b = "qq.android.ark.so";
  private static boolean e;
  private static String jdField_f_of_type_JavaLangString = "";
  private static boolean jdField_f_of_type_Boolean;
  private static boolean g;
  private static boolean h;
  private static boolean i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArkSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super(b(), paramQQAppInterface);
  }
  
  public static String b()
  {
    if (jdField_f_of_type_JavaLangString.equals("")) {
      jdField_f_of_type_JavaLangString = String.format("%s_%s.%s", new Object[] { "qq.android.ark.so", ArkAppCenter.a(), ArkAppCenter.c() });
    }
    return jdField_f_of_type_JavaLangString;
  }
  
  public static boolean d()
  {
    boolean bool = false;
    if (jdField_f_of_type_Boolean) {
      bool = e;
    }
    for (;;)
    {
      return bool;
      jdField_f_of_type_Boolean = true;
      e = false;
      try
      {
        Object localObject = new File(ArkSoLoader.a() + "/arkversion");
        if (((File)localObject).exists())
        {
          localObject = new BufferedReader(new FileReader((File)localObject)).readLine();
          if ((localObject != null) && (((String)localObject).equals(b()))) {
            e = true;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    if ((!e) && (QLog.isColorLevel())) {
      QLog.d("QArkSoDownloadHandler", 2, "lib unsupport: " + b());
    }
    return e;
  }
  
  public Class a()
  {
    return ArkSoData.class;
  }
  
  public String a()
  {
    return "QArkSoDownloadHandler";
  }
  
  public void a()
  {
    if (g) {}
    File localFile1;
    do
    {
      return;
      g = true;
      localFile1 = new File(ArkSoLoader.a() + "/needarmv5");
    } while (localFile1.exists());
    i = true;
    h = false;
    try
    {
      File localFile2 = localFile1.getParentFile();
      if (!localFile2.exists()) {
        localFile2.mkdirs();
      }
      localFile1.createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QArkSoDownloadHandler", 2, "download success: " + paramString);
    }
    try
    {
      FileUtils.a(paramString, ArkSoLoader.a(), false);
      jdField_f_of_type_Boolean = false;
      d();
      ArkSoLoader.a = true;
      a = false;
      super.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QArkSoDownloadHandler", 2, "uncompressZip failed: " + localException.getMessage());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((a().loadState == 2) || (a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QArkSoDownloadHandler", 2, "is in downloading");
      }
      return;
    }
    a = true;
    super.a(paramBoolean);
  }
  
  public void b(XmlData paramXmlData)
  {
    if (paramXmlData == null) {
      return;
    }
    super.b(paramXmlData);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean d_()
  {
    if (i) {
      return h;
    }
    h = new File(ArkSoLoader.a() + "/needarmv5").exists();
    i = true;
    return h;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\ArkSoDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */