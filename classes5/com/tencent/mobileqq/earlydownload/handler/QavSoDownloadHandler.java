package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QavSoDownloadHandler
  extends QavSoDownloadHandlerBase
{
  public static final String a = "qq.android.qav.so";
  
  public QavSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.so", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QavSoDownloadHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
  }
  
  public Class a()
  {
    return QavSoData.class;
  }
  
  public boolean d_()
  {
    return VcSystemInfo.f() <= 2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\QavSoDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */