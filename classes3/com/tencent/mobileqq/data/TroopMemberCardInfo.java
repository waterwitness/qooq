package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="troopuin,memberuin")
public class TroopMemberCardInfo
  extends Entity
{
  public int charm;
  public String email;
  public String job;
  public String level;
  public String memberuin;
  public String memo;
  public String name;
  public String nick;
  public byte sex;
  public String tel;
  public int torchFlag;
  public String troopuin;
  
  public TroopMemberCardInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sex = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\TroopMemberCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */