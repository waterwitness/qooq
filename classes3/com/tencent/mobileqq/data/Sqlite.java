package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class Sqlite
  extends Entity
{
  public String tbl_name;
  
  public Sqlite()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getTableName()
  {
    return "Sqlite_master";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\Sqlite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */