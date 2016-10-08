package com.tencent.qidian.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class QidianPAForWpa
  extends Entity
{
  public String kfuin;
  @unique
  public String puin;
  
  public QidianPAForWpa()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.puin = "";
    this.kfuin = "";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\data\QidianPAForWpa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */