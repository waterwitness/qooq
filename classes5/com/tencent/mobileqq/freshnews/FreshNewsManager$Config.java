package com.tencent.mobileqq.freshnews;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class FreshNewsManager$Config
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String cannotCommentTip;
  public String cannotPublishTip;
  public int minCommentLevel;
  public int minPublishFeedLevel;
  public String publishPageTip;
  
  public FreshNewsManager$Config()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config====>").append("publishPageTip=").append(this.publishPageTip).append("|minPublishFeedLevel=").append(this.minPublishFeedLevel).append("|cannotPublishTip=").append(this.cannotPublishTip).append("|minCommentLevel=").append(this.minCommentLevel).append("|cannotCommentTip=").append(this.cannotCommentTip);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsManager$Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */