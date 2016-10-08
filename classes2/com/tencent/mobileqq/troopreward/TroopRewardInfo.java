package com.tencent.mobileqq.troopreward;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class TroopRewardInfo
  implements Serializable
{
  public static final int STATUS_CLOSED = 1;
  public static final int STATUS_EXPIRED = 5;
  public static final int STATUS_FORBIDDEN = 40;
  public static final int STATUS_HIT = 2;
  public static final int STATUS_NOT_PAID = 22;
  public static final int STATUS_OK = 0;
  public static final int STATUS_PAYING = 20;
  public static final int STATUS_PUNISHING = 41;
  public static final int STATUS_TRANSCODE_FAIL = 4;
  public static final int STATUS_TRANSCODING = 3;
  public static final int STATUS_UNKNOW = 100;
  public static final int TYPE_IMG = 1;
  public static final int TYPE_VIDEO = 2;
  public String blurPicUrl;
  public String clearPicUrl;
  public String cookie;
  public String msg;
  public String ownerUin;
  public int payMemberNum;
  public int privilege;
  public int punishLeftTime;
  public String punishWarningInfo;
  public int rewardFee;
  public String rewardId;
  public int shootscreenPunishTime;
  public int status;
  public String troopUin;
  public int type;
  public String vid;
  public int videoDuration;
  
  public TroopRewardInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
    this.punishWarningInfo = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:" + this.rewardId + ",");
    localStringBuilder.append("troopUin:" + this.troopUin + ",");
    localStringBuilder.append("ownerUin:" + this.ownerUin + ",");
    localStringBuilder.append("status:" + this.status + ",");
    localStringBuilder.append("privilege:" + this.privilege + ",");
    localStringBuilder.append("type:" + this.type + ",");
    localStringBuilder.append("Fee:" + this.rewardFee + ",");
    localStringBuilder.append("payNum:" + this.payMemberNum + ",");
    localStringBuilder.append("Duration:" + this.videoDuration + ",");
    localStringBuilder.append("punishLeftTime:" + this.punishLeftTime + ",");
    localStringBuilder.append("warningInfo:" + this.punishWarningInfo + ",");
    localStringBuilder.append("ssPunishTime:" + this.shootscreenPunishTime + ",");
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("blurUrl:" + this.blurPicUrl + ",");
      localStringBuilder.append("clearUrl:" + this.clearPicUrl + ",");
      localStringBuilder.append("vid:" + this.vid + ",");
      localStringBuilder.append("cookie:" + this.cookie + ",");
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopreward\TroopRewardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */