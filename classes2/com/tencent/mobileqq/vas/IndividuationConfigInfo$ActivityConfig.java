package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class IndividuationConfigInfo$ActivityConfig
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public IndividuationConfigInfo$ActivityConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActivityConfig: ").append("id=").append(this.a).append(";").append("iconUrl=").append(this.b).append(";").append("name=").append(this.c).append(";").append("description=").append(this.d).append(";").append("linkUrl=").append(this.e).append(";").append("cornerMarkLevel=").append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividuationConfigInfo$ActivityConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */