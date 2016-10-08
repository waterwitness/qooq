package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uin,uniseq")
public class MultiMsgNick
  extends Entity
{
  public String nick;
  public String uin;
  public long uniseq;
  
  public MultiMsgNick()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\multimsg\MultiMsgNick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */