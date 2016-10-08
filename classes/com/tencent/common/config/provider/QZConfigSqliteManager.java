package com.tencent.common.config.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QZConfigSqliteManager
  implements QZoneConfigConst
{
  private static final String z = "QZConfigSqliteManager";
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private QZoneConfigSQLiteHelper jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper;
  private SQLiteDatabase b;
  
  public QZConfigSqliteManager(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper = new QZoneConfigSQLiteHelper(paramContext, "config_db", null, 9);
  }
  
  public int a()
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_cookie", null, null);
      a();
    }
    return i;
  }
  
  /* Error */
  public int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: invokevirtual 39	com/tencent/common/config/provider/QZConfigSqliteManager:a	()Z
    //   7: ifeq +117 -> 124
    //   10: aload_2
    //   11: arraylength
    //   12: istore 4
    //   14: aload_0
    //   15: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   18: invokevirtual 57	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   21: aload_2
    //   22: arraylength
    //   23: istore 6
    //   25: iconst_0
    //   26: istore 5
    //   28: iload 5
    //   30: iload 6
    //   32: if_icmpge +110 -> 142
    //   35: aload_2
    //   36: iload 5
    //   38: aaload
    //   39: astore_3
    //   40: aload_0
    //   41: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   44: ldc 59
    //   46: ldc 61
    //   48: aload_3
    //   49: invokevirtual 65	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   52: lconst_0
    //   53: lcmp
    //   54: ifgt +73 -> 127
    //   57: new 54	android/database/SQLException
    //   60: dup
    //   61: new 67	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   68: ldc 70
    //   70: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 84	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: astore_1
    //   85: ldc 10
    //   87: iconst_1
    //   88: new 67	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   95: ldc 86
    //   97: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 89	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   104: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   117: invokevirtual 98	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   120: aload_0
    //   121: invokevirtual 51	com/tencent/common/config/provider/QZConfigSqliteManager:a	()V
    //   124: iload 4
    //   126: ireturn
    //   127: iload 5
    //   129: iconst_1
    //   130: iadd
    //   131: istore 5
    //   133: iload 4
    //   135: iconst_1
    //   136: iadd
    //   137: istore 4
    //   139: goto -111 -> 28
    //   142: aload_0
    //   143: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   146: invokevirtual 101	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   149: aload_0
    //   150: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   153: invokevirtual 98	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   156: goto -36 -> 120
    //   159: astore_1
    //   160: aload_0
    //   161: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   164: invokevirtual 98	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: goto -85 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	QZConfigSqliteManager
    //   0	173	1	paramUri	Uri
    //   0	173	2	paramArrayOfContentValues	ContentValues[]
    //   39	10	3	localContentValues	ContentValues
    //   1	137	4	i	int
    //   26	106	5	j	int
    //   23	10	6	k	int
    // Exception table:
    //   from	to	target	type
    //   40	84	84	android/database/SQLException
    //   142	149	84	android/database/SQLException
    //   14	25	159	finally
    //   40	84	159	finally
    //   85	113	159	finally
    //   142	149	159	finally
    //   14	25	169	android/database/SQLException
  }
  
  public int a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_configs", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor a(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_cookie", paramArrayOfString, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_navigator_bar", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_configs", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(jdField_a_of_type_AndroidNetUri, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public void a() {}
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {
        break label53;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper.getWritableDatabase();
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
        }
      }
    }
  }
  
  public int b()
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_check_time", null, null);
      a();
    }
    return i;
  }
  
  public int b(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_isp_config", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor b(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_check_time", paramArrayOfString, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_configs", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_navigator_bar", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(g, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {
        break label53;
      }
    }
    try
    {
      this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper.getReadableDatabase();
      if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
        }
      }
    }
  }
  
  public int c()
  {
    int i = 0;
    if (a()) {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_update", null, null);
    }
    return i;
  }
  
  public int c(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_navigator_bar", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor c(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_update", paramArrayOfString, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_isp_config", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_isp_config", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(e, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null;
  }
  
  public int d()
  {
    return 0 + a() + a(null, null) + c() + b() + b(null, null) + c(null, null);
  }
  
  public Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_cookie", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(jdField_b_of_type_AndroidNetUri, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_check_time", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(f, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_update", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(c, l);
      a();
      return paramUri;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\config\provider\QZConfigSqliteManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */