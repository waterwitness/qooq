package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SharpPData
  extends XmlData
{
  @saveInSP(a=false, b=true)
  public boolean sharpP_so_avaliable;
  
  public SharpPData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.native.sharpP";
  }
  
  public String getStrResName()
  {
    return "qq.android.native.sharpP";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\SharpPData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */