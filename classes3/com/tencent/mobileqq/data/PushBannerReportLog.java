package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class PushBannerReportLog
  extends Entity
{
  public String log;
  
  public PushBannerReportLog()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.log = "";
  }
  
  public String getLog()
  {
    return this.log;
  }
  
  public void setLog(String paramString)
  {
    this.log = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\PushBannerReportLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */