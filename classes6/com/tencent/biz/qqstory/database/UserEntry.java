package com.tencent.biz.qqstory.database;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class UserEntry
  extends Entity
  implements Copyable
{
  public String headUrl;
  public boolean isVip;
  public String nickName;
  public String remark;
  public String symbolUrl;
  @unique
  public long uid;
  public String unionId;
  
  public UserEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String getUserSelection(long paramLong)
  {
    return "uid='" + paramLong + "'";
  }
  
  public static String getUserSelectionByUnionId()
  {
    return "unionId=?";
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof UserEntry))
    {
      paramObject = (UserEntry)paramObject;
      this.uid = ((UserEntry)paramObject).uid;
      this.unionId = ((UserEntry)paramObject).unionId;
      this.nickName = ((UserEntry)paramObject).nickName;
      this.headUrl = ((UserEntry)paramObject).headUrl;
      this.remark = ((UserEntry)paramObject).remark;
      this.isVip = ((UserEntry)paramObject).isVip;
      this.symbolUrl = ((UserEntry)paramObject).symbolUrl;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\UserEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */