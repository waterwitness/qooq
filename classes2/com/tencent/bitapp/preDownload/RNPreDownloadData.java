package com.tencent.bitapp.preDownload;

import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.earlydownload.xmldata.saveInSP;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RNPreDownloadData
  extends XmlData
{
  @saveInSP(a=false, b=false)
  public boolean isIngoreNet;
  
  public RNPreDownloadData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.reactnative.system.resource";
  }
  
  public String getStrResName()
  {
    return "qq.android.reactnative.system.resource";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\preDownload\RNPreDownloadData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */