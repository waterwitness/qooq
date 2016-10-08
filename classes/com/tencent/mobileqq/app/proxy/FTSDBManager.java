package com.tencent.mobileqq.app.proxy;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.proxy.fts.FTSIndexOperator;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator;
import com.tencent.mobileqq.app.proxy.fts.FTSSyncHandler;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.QFTSDatabase;
import com.tencent.mobileqq.fts.logger.QLogger;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import qnh;

public class FTSDBManager
  extends Observable
  implements Manager
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "Q.fts.manager";
  public static volatile boolean a = false;
  public static final int b = 2;
  public static final boolean c = false;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public FTSSyncHandler a;
  private FTSDatabase jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public volatile boolean b;
  private int c = -1;
  private volatile int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
  }
  
  public FTSDBManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQ_FTS_Sync", 3);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler = new FTSSyncHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), new FTSMsgOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), new FTSTroopOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler));
    a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager structure...");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    SQLiteFTSUtils.a(paramQQAppInterface, paramString);
    com.tencent.mobileqq.app.SQLiteDatabase localSQLiteDatabase = new QQEntityManagerFactory(paramString).build(paramString).a();
    localSQLiteDatabase.a("DROP TABLE IF EXISTS msg_upgrade_log;");
    localSQLiteDatabase.a("DROP TABLE IF EXISTS msg_sync_log;");
    localSQLiteDatabase.a("DROP TABLE IF EXISTS " + FTSTroopSync.class.getSimpleName() + ";");
    localSQLiteDatabase.a("DROP TABLE IF EXISTS " + FTSTroopTime.class.getSimpleName() + ";");
    if (!paramBoolean) {
      paramQQAppInterface.a().c();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.manager", 2, "FTS clear...");
      }
      return;
      paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + paramString + "-IndexQQMsg.db");
      if ((paramQQAppInterface.exists()) && (paramQQAppInterface.isFile())) {
        paramQQAppInterface.delete();
      }
    }
  }
  
  private void d()
  {
    SQLiteFTSUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    if ((this.jdField_d_of_type_Boolean) || (QLog.isColorLevel())) {}
    try
    {
      localObject2 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(":memory:", null).rawQuery("select sqlite_version() AS sqlite_version", null);
      for (localObject1 = ""; ((Cursor)localObject2).moveToNext(); localObject1 = (String)localObject1 + ((Cursor)localObject2).getString(0)) {}
      QLog.i("Q.fts.manager", 2, "OS: " + DeviceInfoUtil.e() + ", SQLite3 version: " + (String)localObject1);
      ((Cursor)localObject2).close();
    }
    catch (Exception localException)
    {
      Object localObject2;
      Object localObject1;
      for (;;) {}
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = new FTSDatatbase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    FTSDatabase.a(new QLogger());
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase = new QFTSDatabase();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "-IndexQQMsg.db";
      this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a((String)localObject1);
      SQLiteFTSUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        int i = ((Integer)((Iterator)localObject1).next()).intValue();
        localObject2 = (FTSIndexOperator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        if (!((FTSIndexOperator)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase, this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.manager", 2, new Object[] { "operator init failed = ", localObject2.getClass().getSimpleName() });
          }
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.manager", 2, "init: failure ", localThrowable);
      }
      jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public FTSIndexOperator a(int paramInt)
  {
    return (FTSIndexOperator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public FTSMsgOperator a()
  {
    return (FTSMsgOperator)a(1);
  }
  
  public FTSDatabase a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase;
  }
  
  public FTSDatatbase a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.post(new qnh(this));
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_d_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b()
  {
    if (!this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ((FTSIndexOperator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).d();
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.b) {
      ((FTSIndexOperator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).d();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.d();
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a();
  }
  
  public void onDestroy()
  {
    try
    {
      this.b = true;
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ((FTSIndexOperator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase == null) {
        break label88;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.c();
    label88:
    if (this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager destroy...");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\FTSDBManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */