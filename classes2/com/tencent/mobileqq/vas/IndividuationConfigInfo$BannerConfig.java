package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class IndividuationConfigInfo$BannerConfig
{
  public String a;
  public String b;
  public String c;
  
  public IndividuationConfigInfo$BannerConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BannerConfig: ").append("backgroudImgUrl=").append(this.a).append(";").append("cornerMarkLevel=").append(this.b).append(";").append("linkUrl=").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividuationConfigInfo$BannerConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */