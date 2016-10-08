package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AppleEmojiData
  extends XmlData
{
  @saveInSP(a=true, b=false)
  public String v7a_MD5;
  
  public AppleEmojiData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.appleemoji";
  }
  
  public String getStrResName()
  {
    return "qq.android.appleemoji";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\AppleEmojiData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */