package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hfw;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WebCgiWhiteListManager
{
  public static final String a = "cgi_whiteList";
  public static final String b = "cgi_whiteList.json";
  public static final String c = "sp_cgi_whitelist";
  public static final String d = "whitelist_config_json";
  public static final String e = "whitelist_config_json_url";
  private static final String f = "WebCgiWhiteListManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public WebCgiWhiteListManager(Context paramContext, AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebCgiWhiteListManager", 2, "CGIWhiteListCheckUpdate downloadWhiteListConfigJson CGIWhiteListConfigTempFile is exist :" + paramFile.exists());
    }
    if (paramFile.exists())
    {
      Object localObject = new FileInputStream(paramFile);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = ((InputStream)localObject).read(arrayOfByte, 0, 4096);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      ((InputStream)localObject).close();
      try
      {
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localByteArrayOutputStream.close();
          return;
        }
        paramFile.renameTo(new File((String)localObject));
        paramFile = new String(localByteArrayOutputStream.toByteArray(), "utf-8");
        if ((paramFile != null) && (paramFile.length() > 0)) {
          this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_cgi_whitelist", 4).edit().putString("whitelist_config_json", paramFile).commit();
        }
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("WebCgiWhiteListManager", 2, "CGIWhiteListCheckUpdate parseDownLoadDataFromFile error" + paramFile.getMessage());
          }
        }
      }
      localByteArrayOutputStream.close();
      return;
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    File localFile = this.jdField_a_of_type_AndroidContentContext.getDir("cgi_whiteList", 0);
    return localFile.getAbsolutePath() + File.separator + "cgi_whiteList.json" + "6.5.5";
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    ThreadManager.a(new hfw(this, paramString1, paramString2), 8, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\WebCgiWhiteListManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */