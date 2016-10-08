package com.tencent.open.business.viareport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;

public class ReportSqliteHelper
  extends SQLiteOpenHelper
{
  protected static final int a = 2;
  protected static ReportSqliteHelper a;
  public static final String a = "open_report.db";
  public static final String b = "table_new_data";
  public static final String c = "table_old_data";
  protected String d;
  protected String e;
  
  protected ReportSqliteHelper(Context paramContext)
  {
    super(paramContext, "open_report.db", null, 2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = "CREATE TABLE IF NOT EXISTS table_new_data( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
    this.e = "CREATE TABLE IF NOT EXISTS table_old_data( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
  }
  
  public static ReportSqliteHelper a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new ReportSqliteHelper(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    LogUtility.b("opensdk", "sql1:" + this.d);
    LogUtility.b("opensdk", "sql2:" + this.e);
    paramSQLiteDatabase.execSQL(this.d);
    paramSQLiteDatabase.execSQL(this.e);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_new_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_old_data");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_new_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_old_data");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\viareport\ReportSqliteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */