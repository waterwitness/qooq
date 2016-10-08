package com.tencent.mobileqq.earlydownload.handler;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.WebpSoData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class WebpSoDownloadHandler
  extends EarlyHandler
{
  public static final String a = "QWebpSoDownloadHandler";
  public static final String b = "qq.android.pic.webp.so";
  QQAppInterface b;
  
  public WebpSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.pic.webp.so", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = null;
    this.b = paramQQAppInterface;
  }
  
  public WebpSoDownloadHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
    this.b = null;
    this.b = paramQQAppInterface;
  }
  
  public Class a()
  {
    return WebpSoData.class;
  }
  
  public String a()
  {
    return "QWebpSoDownloadDuration";
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWebpSoDownloadHandler", 2, "onDownload success: " + paramString);
      }
      String str = WebpSoLoader.a(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty(str)) {
        FileUtils.a(paramString, str, false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QWebpSoDownloadHandler", 2, localException.getMessage());
        }
      }
    }
    super.a(paramString);
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\WebpSoDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */