package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class XmlDataV7aVersion
  extends XmlData
{
  @saveInSP(a=true, b=true)
  public int VideoVersion;
  @saveInSP(a=true, b=true)
  public String v7a_MD5;
  
  public XmlDataV7aVersion()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\XmlDataV7aVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */