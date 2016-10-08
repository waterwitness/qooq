package com.tencent.mqp.app.dbfs;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class DBHelper$BlobNodeSql
{
  public static final String a = "t_BlobNode";
  public static final String b = "create table t_BlobNode( ID_blob\t\tinteger primary key autoincrement, Content\t\tblob, hash\t\t\tchar(20) , ctime\t\tTIMESTAMP, mtime\t\tTIMESTAMP, atime\t\tTIMESTAMP );";
  public static final String c = " ID_blob=? ";
  public static final String d = "delete from t_BlobNode where ID_blob=? ";
  public static final String e = "DROP TABLE IF EXISTS t_BlobNode";
  
  DBHelper$BlobNodeSql()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\dbfs\DBHelper$BlobNodeSql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */