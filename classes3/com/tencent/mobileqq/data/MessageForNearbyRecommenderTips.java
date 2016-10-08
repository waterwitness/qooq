package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForNearbyRecommenderTips
  extends ChatMessage
{
  public boolean readFlag;
  public String strBrief;
  public long uRecommendTime;
  
  public MessageForNearbyRecommenderTips()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strBrief = "";
  }
  
  protected void doParse()
  {
    try
    {
      MessageForNearbyRecommenderTips.NearbyRecommenderInfo localNearbyRecommenderInfo = (MessageForNearbyRecommenderTips.NearbyRecommenderInfo)MessagePkgUtils.a(this.msgData);
      if (localNearbyRecommenderInfo != null)
      {
        this.uRecommendTime = localNearbyRecommenderInfo.uRecommendTime;
        this.readFlag = localNearbyRecommenderInfo.readFlag;
        this.strBrief = localNearbyRecommenderInfo.strBrief;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    MessageForNearbyRecommenderTips.NearbyRecommenderInfo localNearbyRecommenderInfo = new MessageForNearbyRecommenderTips.NearbyRecommenderInfo();
    localNearbyRecommenderInfo.uRecommendTime = this.uRecommendTime;
    localNearbyRecommenderInfo.readFlag = this.readFlag;
    localNearbyRecommenderInfo.strBrief = this.strBrief;
    try
    {
      this.msgData = MessagePkgUtils.a(localNearbyRecommenderInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForNearbyRecommenderTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */