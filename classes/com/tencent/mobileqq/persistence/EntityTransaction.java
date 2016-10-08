package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EntityTransaction
{
  private static final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private final SQLiteOpenHelper jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  EntityTransaction(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper = paramSQLiteOpenHelper;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b();
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.e();
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = null;
      if (((ReentrantLock)jdField_a_of_type_JavaUtilConcurrentLocksLock).isHeldByCurrentThread()) {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException = localException;
      } while (!((ReentrantLock)jdField_a_of_type_JavaUtilConcurrentLocksLock).isHeldByCurrentThread());
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      return;
    }
    finally
    {
      localObject = finally;
      if (((ReentrantLock)jdField_a_of_type_JavaUtilConcurrentLocksLock).isHeldByCurrentThread()) {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      throw ((Throwable)localObject);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.f();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\EntityTransaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */