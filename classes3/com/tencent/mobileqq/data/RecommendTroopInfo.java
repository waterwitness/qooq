package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class RecommendTroopInfo
  extends Entity
  implements Cloneable
{
  public int authType;
  public int classId;
  public String classText;
  public String code;
  public int curMemberNum;
  public int faceId;
  public String faceUrl;
  public String fingerMemo;
  public int flagExt;
  public int hotDegree;
  public boolean isSameCity;
  public boolean isTroopAllow;
  public boolean isTroopFull;
  public boolean isTroopIn;
  public int level;
  public String location;
  public int maxMemberNum;
  public String name;
  public short option;
  public String ownerUin;
  public String tag;
  @unique
  public String uin;
  
  public RecommendTroopInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.maxMemberNum = 5;
  }
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d("RecommendTroop", 2, "RecommendTroopInfo clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RecommendTroopInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */