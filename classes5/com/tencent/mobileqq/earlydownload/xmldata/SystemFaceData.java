package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SystemFaceData
  extends XmlData
{
  public SystemFaceData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.system.face.gifv4";
  }
  
  public String getStrResName()
  {
    return "qq.android.system.face.gifv4";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\SystemFaceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */