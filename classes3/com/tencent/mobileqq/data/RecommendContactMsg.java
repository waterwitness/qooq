package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.notColumn;

public class RecommendContactMsg
{
  public static final int STATUS_EMPTY = 0;
  public static final int STATUS_FRIEND = 2;
  public static final int STATUS_REQUESTED = 1;
  public String contactName;
  public short faceid;
  @notColumn
  public int friendStatus;
  public int groupId;
  public boolean isRead;
  public String mobileCode;
  public String mobileNo;
  public String nationCode;
  public String nickName;
  public long originBinder;
  public String source;
  public long timeStamp;
  public String uin;
  public long uniseq;
  
  public RecommendContactMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.groupId = -1;
    this.source = "";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RecommendContactMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */