package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class ApolloActionData
  extends Entity
  implements Serializable
{
  @unique
  public int actionId;
  public String actionName;
  public String anmiName;
  @notColumn
  public String atNickName;
  public String boy1;
  public String bubbleText;
  public int feeType;
  public boolean hasSound;
  public int icon;
  @notColumn
  public String inputText;
  public int isShow;
  public long limitEnd;
  public int limitFree;
  public long limitStart;
  public String peerUin;
  public int personNum;
  public int sessionType;
  public int status;
  public String textImg;
  public String url;
  public long version;
  public String vibrate;
  public int vipLevel;
  
  public ApolloActionData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ApolloActionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */