package com.tencent.biz.qqstory.settings;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.utils.ChnToSpell;

public class QQStoryUserInfo
  extends Entity
  implements Comparable
{
  public int isAllowed;
  public int isInterested;
  public String mPinying;
  public String nick;
  @unique
  public String uin;
  
  public QQStoryUserInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int compareTo(QQStoryUserInfo paramQQStoryUserInfo)
  {
    if (paramQQStoryUserInfo == null) {}
    while ((this.mPinying == null) && (paramQQStoryUserInfo.mPinying == null)) {
      return 0;
    }
    if ((this.mPinying != null) && (paramQQStoryUserInfo.mPinying == null)) {
      return 1;
    }
    if (this.mPinying == null) {
      return -1;
    }
    return this.mPinying.compareTo(paramQQStoryUserInfo.mPinying);
  }
  
  public boolean equals(Object paramObject)
  {
    QQStoryUserInfo localQQStoryUserInfo = null;
    if ((paramObject instanceof QQStoryUserInfo)) {
      localQQStoryUserInfo = (QQStoryUserInfo)paramObject;
    }
    return (paramObject == this) || ((this.uin != null) && (localQQStoryUserInfo != null) && (this.uin.equals(localQQStoryUserInfo.uin)));
  }
  
  public void setNick(String paramString)
  {
    this.nick = paramString;
    if (paramString != null)
    {
      this.mPinying = ChnToSpell.a(paramString, 1);
      return;
    }
    this.mPinying = "";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\settings\QQStoryUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */