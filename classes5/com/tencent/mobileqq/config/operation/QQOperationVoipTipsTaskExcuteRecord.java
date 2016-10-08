package com.tencent.mobileqq.config.operation;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="taskid,uin,uinType")
public class QQOperationVoipTipsTaskExcuteRecord
  extends Entity
{
  public int count;
  public int taskid;
  public long time;
  public int tipType;
  public String uin;
  public int uinType;
  
  public QQOperationVoipTipsTaskExcuteRecord()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.uin = "0";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\operation\QQOperationVoipTipsTaskExcuteRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */