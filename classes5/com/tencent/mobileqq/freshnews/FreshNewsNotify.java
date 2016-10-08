package com.tencent.mobileqq.freshnews;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class FreshNewsNotify
  extends Entity
{
  @notColumn
  public static final int READ_TYPE_READ = 0;
  @notColumn
  public static final int READ_TYPE_UNREAD = 1;
  public long cancelEventId;
  public String commentFeedId;
  public String commentId;
  public String commentRichTextString;
  @unique
  public long eventId;
  public String eventTips;
  public int eventType;
  public String feedId;
  public long feedPublishTime;
  public String imageUrl;
  public int readType;
  public int time;
  public int userAge;
  public int userCharmLevel;
  public int userGender;
  public String userNickName;
  public long userTinyId;
  public String userVipInfo;
  
  public FreshNewsNotify()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.feedId = "";
    this.imageUrl = "";
    this.readType = 1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */