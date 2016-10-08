package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PttSilkAndChangeVoiceSoData
  extends XmlData
{
  @saveInSP(a=true, b=true)
  public boolean amrV5So;
  @saveInSP(a=true, b=true)
  public boolean amrV7So;
  @saveInSP(a=true, b=true)
  public boolean amrV8So;
  @saveInSP(a=true, b=true)
  public boolean mipsSo;
  @saveInSP(a=true, b=true)
  public String version;
  @saveInSP(a=true, b=true)
  public boolean x86So;
  
  public PttSilkAndChangeVoiceSoData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.version = "";
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.ptt.so.658";
  }
  
  public String getStrResName()
  {
    return "qq.android.ptt.so.658";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\PttSilkAndChangeVoiceSoData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */