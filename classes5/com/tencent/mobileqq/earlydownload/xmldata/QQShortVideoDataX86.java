package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQShortVideoDataX86
  extends XmlData
{
  @saveInSP(a=true, b=true)
  public int VideoVersion;
  @saveInSP(a=true, b=false)
  public String other_MD5;
  
  public QQShortVideoDataX86()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.native.short.video.x86";
  }
  
  public String getStrResName()
  {
    return "qq.android.native.short.video.x86";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\QQShortVideoDataX86.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */