package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArNativeSoData
  extends XmlData
{
  public ArNativeSoData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.ar.native.so";
  }
  
  public String getStrResName()
  {
    return "qq.android.ar.native.so";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\ArNativeSoData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */