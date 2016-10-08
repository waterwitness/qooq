package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class VIPDonateMsg
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public String brief;
  public String footer;
  public String jumpUrl;
  public String subTitle;
  public String title;
  
  public VIPDonateMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "VIPDonateMsg [title=" + this.title + ", subTitle=" + this.subTitle + ", footer=" + this.footer + ", jumpUrl=" + this.jumpUrl + ", brief=" + this.brief + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\VIPDonateMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */