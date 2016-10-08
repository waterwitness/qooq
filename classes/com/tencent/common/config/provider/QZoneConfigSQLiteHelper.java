package com.tencent.common.config.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QZoneConfigSQLiteHelper
  extends SQLiteOpenHelper
  implements QZoneConfigConst
{
  private static final String A = " CREATE TABLE IF NOT EXISTS qz_configs (main_key text  NOT NULL COLLATE NOCASE,second_key text  NOT NULL COLLATE NOCASE,value String,PRIMARY KEY (main_key,second_key))";
  private static final String B = " CREATE TABLE IF NOT EXISTS qz_cookie (name text PRIMARY KEY NOT NULL,cookie text NOT NULL)";
  private static final String C = " CREATE TABLE IF NOT EXISTS qz_check_time (name text PRIMARY KEY NOT NULL,check_time INTEGER NOT NULL)";
  private static final String D = " CREATE TABLE IF NOT EXISTS qz_update (name text PRIMARY KEY NOT NULL,updatelog text NOT NULL)";
  private static final String E = " CREATE TABLE IF NOT EXISTS qz_isp_config (key text PRIMARY KEY NOT NULL,value text)";
  private static final String F = " CREATE TABLE IF NOT EXISTS qz_navigator_bar (uin text PRIMARY KEY NOT NULL,entraceid INTEGER NOT NULL,entracename text NOT NULL,entraceicon text,entraceaction text,isDefault INTEGER,tabid INTEGER)";
  private static final String z = "QZoneConfigHelper";
  
  public QZoneConfigSQLiteHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_configs (main_key text  NOT NULL COLLATE NOCASE,second_key text  NOT NULL COLLATE NOCASE,value String,PRIMARY KEY (main_key,second_key))");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_cookie (name text PRIMARY KEY NOT NULL,cookie text NOT NULL)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_update (name text PRIMARY KEY NOT NULL,updatelog text NOT NULL)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_isp_config (key text PRIMARY KEY NOT NULL,value text)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_check_time (name text PRIMARY KEY NOT NULL,check_time INTEGER NOT NULL)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_navigator_bar (uin text PRIMARY KEY NOT NULL,entraceid INTEGER NOT NULL,entracename text NOT NULL,entraceicon text,entraceaction text,isDefault INTEGER,tabid INTEGER)");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneConfigHelper", 2, "updating database from version " + paramInt1 + " to " + paramInt2);
    }
    paramSQLiteDatabase.execSQL("drop table if exists qz_configs");
    paramSQLiteDatabase.execSQL("drop table if exists qz_cookie");
    paramSQLiteDatabase.execSQL("drop table if exists qz_update");
    paramSQLiteDatabase.execSQL("drop table if exists qz_isp_config");
    paramSQLiteDatabase.execSQL("drop table if exists qz_check_time");
    paramSQLiteDatabase.execSQL("drop table if exists qz_navigator_bar");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneConfigHelper", 2, "updating database from version " + paramInt1 + " to " + paramInt2);
    }
    paramSQLiteDatabase.execSQL("drop table if exists qz_configs");
    paramSQLiteDatabase.execSQL("drop table if exists qz_cookie");
    paramSQLiteDatabase.execSQL("drop table if exists qz_update");
    paramSQLiteDatabase.execSQL("drop table if exists qz_isp_config");
    paramSQLiteDatabase.execSQL("drop table if exists qz_check_time");
    paramSQLiteDatabase.execSQL("drop table if exists qz_navigator_bar");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\config\provider\QZoneConfigSQLiteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */