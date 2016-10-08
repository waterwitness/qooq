package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.earlydownload.handler.ArkSoDownloadHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArkSoData
  extends XmlData
{
  public ArkSoData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_" + ArkSoDownloadHandler.b();
  }
  
  public String getStrResName()
  {
    return ArkSoDownloadHandler.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\ArkSoData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */