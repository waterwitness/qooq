package com.tencent.mqp.app.dbfs;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class DBHelper$PathNodeSql
{
  public static final String a = "t_PathNode";
  public static final String b = "create table t_PathNode( ID_node\t\tinteger primary key autoincrement, ID_parent\tinteger default(-1), ID_blob\t\tinteger default(-1), name\t\t\tvarchar(64));";
  public static final String c = "create index i_pathIndex on t_PathNode (ID_parent, name);";
  public static final String d = " ID_parent=? and name=? ";
  public static final String e = " ID_parent=? ";
  public static final String f = " ID_node=?";
  public static final String g = "delete from t_PathNode where ID_node=? ";
  public static final String h = "DROP TABLE IF EXISTS t_PathNode";
  
  DBHelper$PathNodeSql()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\dbfs\DBHelper$PathNodeSql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */