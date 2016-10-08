package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQDingdongSoundData
  extends XmlData
{
  @saveInSP(a=false, b=true)
  public boolean autoDownload;
  
  public QQDingdongSoundData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.dingdong.ring";
  }
  
  public String getStrResName()
  {
    return "qq.android.dingdong.ring";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\QQDingdongSoundData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */