package com.tencent.mobileqq.app.proxy.fts;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.TroopMemberUpdateObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.data.fts.FTSTroop;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.FTSDatabaseHelper;
import com.tencent.mobileqq.fts.FTSQueryArgs.Builder;
import com.tencent.mobileqq.fts.FTSQueryArgs.MatchKey;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import qnp;
import qnr;
import qns;

public class FTSTroopOperator
  extends FTSIndexOperator
  implements TroopManager.TroopMemberUpdateObserver
{
  private static final int b = 300;
  public static boolean e = true;
  public static final String t = "TroopCursor";
  private static final String u = "Q.fts.troop.operator";
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private int c;
  private int d;
  private boolean f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FTSTroopOperator(QQAppInterface paramQQAppInterface, FTSSyncHandler paramFTSSyncHandler)
  {
    super(paramQQAppInterface, paramFTSSyncHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getLong("key_check_stamp" + paramQQAppInterface.getAccount() + "_" + paramString, 0L);
  }
  
  private FTSTroop a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    paramString1 = new FTSTroop(paramInt1, paramString1, paramString2, paramString3, paramString4);
    paramString1.preWrite();
    if (paramInt2 == 1) {
      paramString1.insertOpt();
    }
    do
    {
      return paramString1;
      if (paramInt2 == 16)
      {
        paramString1.deleteOpt();
        return paramString1;
      }
    } while (paramInt2 != 17);
    paramString1.upgradeOpt();
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a().getSharedPreferences("fts_sp_file", 0).edit().remove("key_check_stamp" + paramQQAppInterface.getAccount() + "_" + paramString).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface.a().getSharedPreferences("fts_sp_file", 0).edit().putLong("key_check_stamp" + paramQQAppInterface.getAccount() + "_" + paramString, paramLong).commit();
  }
  
  private void c(String paramString)
  {
    if (SQLiteFTSUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
      return;
    }
    ThreadManager.c().post(new qns(this, paramString));
  }
  
  public int a()
  {
    return this.d;
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return null;
  }
  
  public List a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase == null) || (!this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.d()) || (paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    FTSQueryArgs.Builder localBuilder = new FTSQueryArgs.Builder().a(TroopIndex.class).a(new FTSQueryArgs.MatchKey[] { new FTSQueryArgs.MatchKey("TroopIndex", paramString, true) }).a(true);
    if ((SearchUtils.b(paramString)) || (SearchUtils.c(paramString))) {
      localBuilder.a(140);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(localBuilder.a());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onGetTroopMembersFailed troopUin:" + paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onChangeTroopMember troopUin=" + paramString1 + " memberUin=" + paramString2);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FTSTroopSync(3, Long.parseLong(paramString1), Long.parseLong(paramString2)));
    b(localArrayList);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      FTSTroopSync localFTSTroopSync = new FTSTroopSync(1, Long.parseLong((String)paramArrayList.get(i)));
      localArrayList.add(localFTSTroopSync);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)paramArrayList.get(i), l);
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.troop.operator", 2, "onTroopMembersUpdate troopuin = " + localFTSTroopSync.mTroopUin);
      }
      i += 1;
    }
    b(localArrayList);
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    super.a(paramFTSDatatbase, paramFTSDatabase);
    if (!this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(TroopIndex.class)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader = new FTSTroopUpgrader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.f = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "init success");
    }
    this.d = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopIndex");
    return true;
  }
  
  /* Error */
  public boolean a(ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/mobileqq/app/proxy/fts/FTSTroopOperator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 320	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   7: invokevirtual 326	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: aload 5
    //   18: invokevirtual 331	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 4
    //   23: aload 4
    //   25: astore_2
    //   26: aload 4
    //   28: astore_3
    //   29: aload 4
    //   31: invokevirtual 335	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   34: aload 4
    //   36: astore_2
    //   37: aload 4
    //   39: astore_3
    //   40: aload_1
    //   41: invokevirtual 339	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   44: astore_1
    //   45: aload 4
    //   47: astore_2
    //   48: aload 4
    //   50: astore_3
    //   51: aload_1
    //   52: invokeinterface 344 1 0
    //   57: ifeq +76 -> 133
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 5
    //   68: aload_1
    //   69: invokeinterface 348 1 0
    //   74: checkcast 350	com/tencent/mobileqq/persistence/fts/FTSOptSync
    //   77: invokevirtual 353	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   80: goto -35 -> 45
    //   83: astore_1
    //   84: aload_2
    //   85: astore_3
    //   86: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +34 -> 123
    //   92: aload_2
    //   93: astore_3
    //   94: ldc 19
    //   96: iconst_2
    //   97: new 73	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 355
    //   107: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: invokevirtual 358	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 361	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 363	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: aload 4
    //   135: astore_2
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: invokevirtual 365	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   144: aload 4
    //   146: ifnull +8 -> 154
    //   149: aload 4
    //   151: invokevirtual 363	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_1
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 363	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	FTSTroopOperator
    //   0	167	1	paramArrayList	ArrayList
    //   15	121	2	localObject1	Object
    //   13	149	3	localObject2	Object
    //   21	129	4	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	57	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   16	23	83	java/lang/Exception
    //   29	34	83	java/lang/Exception
    //   40	45	83	java/lang/Exception
    //   51	60	83	java/lang/Exception
    //   66	80	83	java/lang/Exception
    //   139	144	83	java/lang/Exception
    //   16	23	156	finally
    //   29	34	156	finally
    //   40	45	156	finally
    //   51	60	156	finally
    //   66	80	156	finally
    //   86	92	156	finally
    //   94	123	156	finally
    //   139	144	156	finally
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onQuitTroop troopUin=" + paramString);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FTSTroopSync(4, Long.parseLong(paramString)));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    b(localArrayList);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onKickoutTroopMember troopUin=" + paramString1 + " memberUin=" + paramString2);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FTSTroopSync(2, Long.parseLong(paramString1), Long.parseLong(paramString2)));
    b(localArrayList);
  }
  
  public void b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.a(new qnr(this, paramArrayList), 8, null, true);
      return;
    }
    a(paramArrayList);
  }
  
  public boolean c()
  {
    if (!this.b)
    {
      do
      {
        for (;;)
        {
          try
          {
            bool1 = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopCursor");
            bool2 = bool1;
            bool2 = bool1;
          }
          catch (Throwable localThrowable1)
          {
            try
            {
              if (QLog.isColorLevel())
              {
                QLog.d("Q.fts.troop.operator", 2, "FTSDatabaseHelper.isTableExist = " + bool1);
                bool2 = bool1;
              }
              if (bool2) {
                break;
              }
              bool1 = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopCursor");
              if (QLog.isColorLevel()) {
                QLog.d("Q.fts.troop.operator", 2, "FTSDatabaseHelper.createCursorTable = " + bool1);
              }
              if (bool1) {
                break;
              }
              return false;
            }
            catch (Throwable localThrowable2)
            {
              boolean bool1;
              boolean bool2;
              int i;
              for (;;) {}
            }
            localThrowable1 = localThrowable1;
            bool1 = false;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("Q.fts.troop.operator", 2, "isCursorTableExist: failure ", localThrowable1);
            bool2 = bool1;
          }
        }
        i = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopCursor");
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "FTSDatabaseHelper.queryCursorTable = " + i);
        }
      } while (i == -1);
      this.jdField_a_of_type_Int = i;
      this.b = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.troop.operator", 2, "readSyncedCursor: syncCursor = " + i);
      }
    }
    return true;
  }
  
  public void e()
  {
    System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i;
    if (this.jdField_a_of_type_Int > 0)
    {
      i = ((SQLiteDatabase)localObject1).a(FTSTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
      if ((QLog.isColorLevel()) && (i > 0)) {
        QLog.d("Q.fts.troop.operator", 2, "delete " + FTSTroopSync.class.getSimpleName() + " row=" + i);
      }
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localObject1 = localEntityManager.a(FTSTroopSync.class, FTSTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, null, null);
    Object localObject2;
    Iterator localIterator;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("transToDatabase list.size=");
      if (localObject1 != null)
      {
        i = ((List)localObject1).size();
        QLog.d("Q.fts.troop.operator", 2, i);
      }
    }
    else if (localObject1 != null)
    {
      localIterator = ((List)localObject1).iterator();
      i = 0;
    }
    label709:
    label762:
    label959:
    label1063:
    for (;;)
    {
      long l1;
      FTSTroopSync localFTSTroopSync;
      ArrayList localArrayList;
      if (localIterator.hasNext())
      {
        localObject1 = (FTSOptSync)localIterator.next();
        l1 = System.currentTimeMillis();
        localFTSTroopSync = (FTSTroopSync)localObject1;
        localArrayList = new ArrayList();
        if (localFTSTroopSync.mOpt != 3) {
          break label762;
        }
        localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin), "", "", 16));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin));
        if (localObject1 == null) {
          break label709;
        }
        localArrayList.add(a(2, ((TroopMemberInfo)localObject1).troopuin, ((TroopMemberInfo)localObject1).memberuin, ((TroopMemberInfo)localObject1).friendnick, ((TroopMemberInfo)localObject1).troopnick, 1));
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "transToDatabase start troopUin:" + localFTSTroopSync.mTroopUin + " entityList size:" + localArrayList.size() + " opt:" + localFTSTroopSync.mOpt);
        }
        int j = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, localArrayList, "TroopCursor", 1);
        if (j != -1) {
          this.jdField_a_of_type_Int = j;
        }
        this.d = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("TroopIndex");
        TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(String.valueOf(localFTSTroopSync.mTroopUin));
        if (localTroopInfo != null)
        {
          List localList = localEntityManager.a(FTSTroopTime.class, FTSTroopTime.class.getSimpleName(), false, "mTroopUin=? ", new String[] { String.valueOf(localFTSTroopSync.mTroopUin) }, null, null, null, null);
          localObject2 = new FTSTroopTime();
          localObject1 = localObject2;
          if (localList != null)
          {
            localObject1 = localObject2;
            if (localList.size() > 0) {
              localObject1 = (FTSTroopTime)localList.get(0);
            }
          }
          ((FTSTroopTime)localObject1).mTroopUin = String.valueOf(localFTSTroopSync.mTroopUin);
          ((FTSTroopTime)localObject1).mTimeStamp = localTroopInfo.mMemberNumSeq;
          localEntityManager.b((Entity)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.troop.operator", 2, "FTSTroopTime  " + ((FTSTroopTime)localObject1).toString());
          }
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "transToDatabase end troopUin=" + localFTSTroopSync.mTroopUin + " totalTime=" + (l2 - l1));
        }
        i = localArrayList.size() + i;
        if ((i <= 300) && (d())) {
          break label1063;
        }
        if (i > 300) {}
        localEntityManager.a();
        return;
        i = 0;
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.fts.troop.operator", 2, "transToDatabase modify member can't find memberuin:" + localFTSTroopSync.mMemberUin + " troopuin:" + localFTSTroopSync.mTroopUin);
          continue;
          if (localFTSTroopSync.mOpt == 4)
          {
            localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), "", "", "", 16));
          }
          else if ((localFTSTroopSync.mOpt == 1) || (localFTSTroopSync.mOpt == 5))
          {
            try
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(String.valueOf(localFTSTroopSync.mTroopUin));
              if (localObject1 == null) {
                break label959;
              }
              localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), "", "", "", 16));
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (TroopMemberInfo)((Iterator)localObject1).next();
                if (Utils.c(((TroopMemberInfo)localObject2).memberuin)) {
                  localArrayList.add(a(2, ((TroopMemberInfo)localObject2).troopuin, ((TroopMemberInfo)localObject2).memberuin, ((TroopMemberInfo)localObject2).friendnick, ((TroopMemberInfo)localObject2).troopnick, 1));
                }
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (Throwable localThrowable) {}
            QLog.e("Q.fts.troop.operator", 2, "transToDatabase failure: ", localThrowable);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("Q.fts.troop.operator", 2, "transToDatabase memberList is null");
            }
          }
          else if (localFTSTroopSync.mOpt == 2)
          {
            localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin), "", "", 16));
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.fts.troop.operator", 2, "transToDatabase unknown opt:" + localFTSTroopSync.toString());
          }
        }
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.post(new qnp(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\fts\FTSTroopOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */