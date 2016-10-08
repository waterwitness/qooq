package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class JpegSoData
  extends XmlData
{
  @saveInSP(a=true, b=false)
  public String v7a_MD5;
  
  public JpegSoData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.pic.jpeg.so";
  }
  
  public String getStrResName()
  {
    return "qq.android.pic.jpeg.so";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\JpegSoData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */