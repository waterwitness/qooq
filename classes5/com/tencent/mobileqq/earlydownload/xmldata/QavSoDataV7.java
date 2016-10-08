package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QavSoDataV7
  extends QavSoDataBase
{
  public QavSoDataV7()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.sov7";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.sov7";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\QavSoDataV7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */