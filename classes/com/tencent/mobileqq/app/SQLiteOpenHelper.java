package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.TableNameCache;

public class SQLiteOpenHelper
{
  public static final boolean a = false;
  private android.database.sqlite.SQLiteOpenHelper jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper;
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private TableNameCache jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache;
  private SQLiteDatabase b;
  
  public SQLiteOpenHelper(android.database.sqlite.SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache = new TableNameCache();
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper = paramSQLiteOpenHelper;
  }
  
  public SQLiteDatabase a()
  {
    try
    {
      localObject1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getWritableDatabase();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) || (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a != localObject1)) {
        this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = new SQLiteDatabase((android.database.sqlite.SQLiteDatabase)localObject1, this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        localException.printStackTrace();
      }
    }
    finally {}
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
    return (SQLiteDatabase)localObject1;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public SQLiteDatabase b()
  {
    try
    {
      localObject1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getReadableDatabase();
      if ((this.b == null) || (this.b.a != localObject1)) {
        this.b = new SQLiteDatabase((android.database.sqlite.SQLiteDatabase)localObject1, this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        localException.printStackTrace();
      }
    }
    finally {}
    localObject1 = this.b;
    return (SQLiteDatabase)localObject1;
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\SQLiteOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */