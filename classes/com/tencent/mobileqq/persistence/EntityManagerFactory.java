package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class EntityManagerFactory
{
  private static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  private boolean closed;
  private final SQLiteOpenHelper dbHelper;
  
  public EntityManagerFactory(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.dbHelper = build(paramString);
  }
  
  public abstract SQLiteOpenHelper build(String paramString);
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.a();
  }
  
  public EntityManager createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    OGEntityManager localOGEntityManager = new OGEntityManager(this.dbHelper);
    this.closed = false;
    return localOGEntityManager;
  }
  
  public EntityManager createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    MessageRecordEntityManager localMessageRecordEntityManager = new MessageRecordEntityManager(this.dbHelper);
    this.closed = false;
    return localMessageRecordEntityManager;
  }
  
  public boolean isOpen()
  {
    return !this.closed;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\EntityManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */