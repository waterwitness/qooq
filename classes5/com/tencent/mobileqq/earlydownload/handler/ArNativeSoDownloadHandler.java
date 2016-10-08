package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArNativeSoLoader;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.ArNativeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ArNativeSoDownloadHandler
  extends EarlyHandler
{
  public static final String a = "ArConfig_NativeSoDownloadHandler";
  public static final String b = "qq.android.ar.native.so";
  
  public ArNativeSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.native.so", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Class a()
  {
    return ArNativeSoData.class;
  }
  
  public String a()
  {
    return "ArConfig_NativeSoDownloadHandler";
  }
  
  public void a(String paramString)
  {
    int i = ArNativeSoLoader.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_NativeSoDownloadHandler", 2, "download success: " + paramString + ",result=" + i);
    }
    if (i == 0) {
      BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0).edit().putInt("ar_native_so_version", a()).commit();
    }
    for (;;)
    {
      super.a(paramString);
      return;
      a().loadState = 0;
      a().Version = 0;
      EarlyDataFactory.a(a(), new String[0]);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((a() != null) && (a().loadState == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_NativeSoDownloadHandler", 2, "is in downloading");
      }
      return;
    }
    super.a(paramBoolean);
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\ArNativeSoDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */