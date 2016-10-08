package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PasswdRedBagDBHelper
  extends SQLiteOpenHelper
{
  public static final int a = 1;
  public static final String a = "passwd_red_bag";
  public static final String b = "red_bags";
  public static final String c = "redbag_id";
  public static final String d = "uint64_creator_uin";
  public static final String e = "expire_time";
  public static final String f = "password";
  public static final String g = "authkey";
  public static final String h = "code";
  public static final String i = "source";
  public static final String j = "is_open";
  public static final String k = "is_finish";
  public static final String l = "user_uin";
  public static final String m = "is_overdue";
  public static final String n = "update_times";
  public static final String o = "last_update_time";
  public static final String p = "red_bag_relations";
  
  public PasswdRedBagDBHelper(Context paramContext, String paramString)
  {
    super(paramContext, "passwd_red_bag_" + paramString + ".db", null, 1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS red_bags (redbag_id VARCHAR PRIMARY KEY, uint64_creator_uin VARCHAR, expire_time INTEGER, password VARCHAR, is_open INTEGER, is_finish INTEGER, is_overdue INTEGER);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS red_bag_relations (code VARCHAR, source VARCHAR, redbag_id VARCHAR, authkey VARCHAR );");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_times (code INTEGER, source INTEGER, last_update_time INTEGER, PRIMARY KEY(code,source));");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\PasswdRedBagDBHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */