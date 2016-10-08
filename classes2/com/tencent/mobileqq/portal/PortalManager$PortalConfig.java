package com.tencent.mobileqq.portal;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PortalManager$PortalConfig
  extends PortalManager.TimerConfig
{
  public String actEndWording;
  public String addMsg;
  public String awardImg;
  public String awardMd5;
  public String awardMsg;
  public String awardTitle;
  public String bgImg;
  public String bgMd5;
  public int continuousRecord;
  public String countDownTips;
  public int countGrab;
  public int countTime;
  public String ctfBgImg;
  public String ctfBgMd5;
  public transient int currentCountGrab;
  public String emptyMsg;
  public String grabMsg;
  public String hotAddMsg;
  public String hotImg;
  public String hotMd5;
  public String hotPublicId;
  public String hotTopic;
  public String hotUrl;
  public int id;
  public String leftImg;
  public String leftMd5;
  public int logoType;
  public String nextActTime;
  public String pendantImg;
  public String pendantMd5;
  public String publicId;
  public long realBegin;
  public long realEnd;
  public String rightMsg;
  public int shareBaseLine;
  public long showSharePageTime;
  public String starImg;
  public String starMd5;
  public String topImg;
  public String topMd5;
  public int type;
  public int useFlag;
  public long useTime;
  public String wishingMsg;
  
  public PortalManager$PortalConfig()
  {
    super(null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean isOver(long paramLong)
  {
    return (this.useTime != 0L) && (paramLong > this.useTime + this.countTime);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\PortalManager$PortalConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */