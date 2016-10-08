package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PushRecommend
  extends MayKnowRecommend
{
  public static final int MAX_SAVE_FROM_PUSH = 3;
  public static final int MAX_SAVE_LOCAL = 80;
  public boolean isReaded;
  public long timestamp;
  
  public PushRecommend()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static PushRecommend copyRecommend(MayKnowRecommend paramMayKnowRecommend, long paramLong)
  {
    PushRecommend localPushRecommend = new PushRecommend();
    localPushRecommend.uin = paramMayKnowRecommend.uin;
    localPushRecommend.nick = paramMayKnowRecommend.nick;
    localPushRecommend.remark = paramMayKnowRecommend.remark;
    localPushRecommend.age = paramMayKnowRecommend.age;
    localPushRecommend.country = paramMayKnowRecommend.country;
    localPushRecommend.province = paramMayKnowRecommend.province;
    localPushRecommend.city = paramMayKnowRecommend.city;
    localPushRecommend.gender = paramMayKnowRecommend.gender;
    localPushRecommend.friendStatus = paramMayKnowRecommend.friendStatus;
    localPushRecommend.category = paramMayKnowRecommend.category;
    localPushRecommend.algBuffer = paramMayKnowRecommend.algBuffer;
    localPushRecommend.hasQZoneUpdate = paramMayKnowRecommend.hasQZoneUpdate;
    localPushRecommend.recommendReason = paramMayKnowRecommend.recommendReason;
    localPushRecommend.richSingature = paramMayKnowRecommend.richSingature;
    localPushRecommend.timestamp = paramLong;
    return localPushRecommend;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\PushRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */