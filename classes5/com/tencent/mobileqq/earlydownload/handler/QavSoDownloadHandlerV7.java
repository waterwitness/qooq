package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoDataV7;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QavSoDownloadHandlerV7
  extends QavSoDownloadHandlerBase
{
  public static final String a = "qq.android.qav.sov7";
  
  public QavSoDownloadHandlerV7(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.sov7", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QavSoDownloadHandlerV7(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
  }
  
  public Class a()
  {
    return QavSoDataV7.class;
  }
  
  public boolean d_()
  {
    return VcSystemInfo.f() > 2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\QavSoDownloadHandlerV7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */