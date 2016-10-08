package com.tencent.mobileqq.qcall;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import uaf;
import uag;
import uah;
import uai;

public class QCallProxy
  extends BaseProxy
{
  private static final String jdField_a_of_type_JavaLangString = QCallProxy.class.getSimpleName();
  private static final int jdField_b_of_type_Int = 100;
  private static final int c = 90;
  private int jdField_a_of_type_Int = 20;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final List jdField_a_of_type_JavaUtilList = new ArrayList(20);
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QCallProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private int a(String paramString)
  {
    paramString = paramString.split("[^0-9]");
    int k = -1;
    for (;;)
    {
      try
      {
        int m = paramString.length;
        i = 0;
        j = k;
        if (i < m)
        {
          String str = paramString[i];
          if ((str == null) || (str.length() <= 0)) {
            continue;
          }
          j = Integer.parseInt(str);
        }
      }
      catch (Exception paramString)
      {
        int i;
        int j = k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(jdField_a_of_type_JavaLangString, 2, paramString.getMessage(), paramString);
      }
      return j;
      i += 1;
    }
    return -1;
  }
  
  private Cursor a(String paramString)
  {
    Object localObject = null;
    paramString = MsgProxyUtils.a(paramString);
    paramString = "select name from sqlite_master where (type='table') and (name like 'qc/_%/_" + paramString + "' escape '/') and (name not like 'qc/_" + 3000 + "/_" + paramString + "' escape '/') and (name not like 'qc/_" + 8 + "/_" + paramString + "' escape '/') order by name;";
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b().a(paramString, null);
      return paramString;
    }
    catch (Exception localException)
    {
      do
      {
        paramString = (String)localObject;
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, localException.getMessage(), localException);
    }
    return null;
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  private Object a(String arg1, int paramInt)
  {
    String str = a(???, paramInt);
    if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new Object());
      }
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
  
  private String a(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().concat("_").concat(paramString);
    if (paramInt != 3000)
    {
      paramString = str;
      if (paramInt != 8) {}
    }
    else
    {
      paramString = str.concat(String.valueOf(paramInt));
    }
    return paramString;
  }
  
  private ArrayList a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new uag(this));
    SparseIntArray localSparseIntArray = new SparseIntArray();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      QCallRecord localQCallRecord1 = (QCallRecord)localIterator.next();
      if ((localQCallRecord1 != null) && (localQCallRecord1.type != QCallRecord.TYPE_DATE))
      {
        if (localSparseIntArray.get(localQCallRecord1.getDate(), -1) == -1)
        {
          QCallRecord localQCallRecord2 = new QCallRecord(QCallRecord.TYPE_DATE);
          localQCallRecord2.time = localQCallRecord1.time;
          localArrayList.add(localQCallRecord2);
          localSparseIntArray.put(localQCallRecord1.getDate(), 0);
        }
        localArrayList.add(localQCallRecord1);
      }
    }
    paramList.clear();
    return localArrayList;
  }
  
  private void a(QCallRecent paramQCallRecent, boolean paramBoolean)
  {
    if ((paramQCallRecent == null) || (paramQCallRecent.uin == null) || (paramQCallRecent.uin.length() < 2)) {
      Utils.a(jdField_a_of_type_JavaLangString);
    }
    while ((paramQCallRecent == null) || (paramQCallRecent.uin == null) || (paramQCallRecent.uin.length() < 2)) {
      return;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    Object localObject2 = paramQCallRecent;
    for (;;)
    {
      try
      {
        Object localObject1;
        int j;
        if (paramQCallRecent.type != 1)
        {
          localObject2 = paramQCallRecent;
          if (paramQCallRecent.type != 3000)
          {
            localObject2 = paramQCallRecent;
            if (paramQCallRecent.type != 8)
            {
              localObject2 = new ArrayList();
              localObject1 = MsgProxyUtils.q;
              j = localObject1.length;
              i = 0;
              if (i < j)
              {
                int k = localObject1[i];
                if (k == paramQCallRecent.type) {
                  break label798;
                }
                QCallRecent localQCallRecent = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.remove(b(paramQCallRecent.uin, k));
                if (localQCallRecent == null) {
                  break label798;
                }
                ((ArrayList)localObject2).add(localQCallRecent);
                break label798;
              }
              j = ((ArrayList)localObject2).size();
              localObject1 = paramQCallRecent;
              if (j > 0)
              {
                if (paramQCallRecent.getStatus() != 1000) {
                  break label792;
                }
                localObject1 = (QCallRecent)((ArrayList)localObject2).get(0);
                this.jdField_a_of_type_JavaUtilList.remove(localObject1);
                ((QCallRecent)localObject1).type = paramQCallRecent.type;
                ((QCallRecent)localObject1).troopUin = paramQCallRecent.troopUin;
                ((QCallRecent)localObject1).displayName = paramQCallRecent.displayName;
                ((QCallRecent)localObject1).lastCallTime = paramQCallRecent.lastCallTime;
                ((QCallRecent)localObject1).lastCallMsg = paramQCallRecent.lastCallMsg;
                ((QCallRecent)localObject1).sendFlag = paramQCallRecent.sendFlag;
                ((QCallRecent)localObject1).isVideo = paramQCallRecent.isVideo;
                ((QCallRecent)localObject1).missedCallCount = paramQCallRecent.missedCallCount;
                ((QCallRecent)localObject1).isLastCallRealMissed = paramQCallRecent.isLastCallRealMissed;
                i = 1;
                paramQCallRecent = (QCallRecent)localObject1;
                localObject1 = paramQCallRecent;
                if (i < j)
                {
                  localObject1 = (QCallRecent)((ArrayList)localObject2).get(i);
                  this.jdField_a_of_type_JavaUtilList.remove(localObject1);
                  a((QCallRecent)localObject1);
                  i += 1;
                  continue;
                }
              }
              boolean bool = ((QCallRecent)localObject1).isMissedCall();
              localObject2 = localObject1;
              if (!bool) {}
            }
          }
        }
        try
        {
          l = Long.valueOf(((QCallRecent)localObject1).uin).longValue();
          localObject2 = localObject1;
          if (l != -1L)
          {
            paramQCallRecent = new ArrayList();
            paramQCallRecent.add(new Pair(Long.valueOf(l), Long.valueOf(((QCallRecent)localObject1).lastCallTime)));
            ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("c2c_processor")).b(paramQCallRecent);
            localObject2 = localObject1;
          }
          paramQCallRecent = this.jdField_a_of_type_JavaUtilMap.keySet();
          localObject1 = new String[paramQCallRecent.size()];
          paramQCallRecent.toArray((Object[])localObject1);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRecentCall before put:" + Arrays.toString((Object[])localObject1));
          }
          this.jdField_a_of_type_JavaUtilMap.put(b(((QCallRecent)localObject2).uin, ((QCallRecent)localObject2).type), localObject2);
          paramQCallRecent = this.jdField_a_of_type_JavaUtilMap.keySet();
          localObject1 = new String[paramQCallRecent.size()];
          paramQCallRecent.toArray((Object[])localObject1);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRecentCall after put:" + Arrays.toString((Object[])localObject1));
          }
          this.jdField_a_of_type_JavaUtilList.remove(localObject2);
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            paramQCallRecent = (QCallRecent)this.jdField_a_of_type_JavaUtilList.get(i);
            if (((QCallRecent)localObject2).lastCallTime > paramQCallRecent.lastCallTime)
            {
              this.jdField_a_of_type_JavaUtilList.add(i, localObject2);
              i = 1;
              if (i == 0) {
                this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), localObject2);
              }
              if (!paramBoolean) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "insertOrUpdateRecentCallToDB uin: " + ((QCallRecent)localObject2).uin + ",callstatus:" + ((QCallRecent)localObject2).state);
              }
              b((QCallRecent)localObject2);
              return;
            }
          }
        }
        catch (Exception paramQCallRecent)
        {
          long l = -1L;
          continue;
          i += 1;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label792:
      int i = 0;
      continue;
      label798:
      i += 1;
    }
  }
  
  private boolean a(QCallRecord paramQCallRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramQCallRecord.friendUin, paramQCallRecord.uinType, paramQCallRecord.getTableName(), paramQCallRecord, 5, null);
    return true;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if ((paramInt == 3000) || (paramInt == 8)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, QCallRecord.getTableName(paramString, paramInt), null, null, 2, null);
    }
    for (;;)
    {
      return true;
      Cursor localCursor = a(paramString);
      if (localCursor != null)
      {
        paramInt = localCursor.getColumnIndex("name");
        while (localCursor.moveToNext())
        {
          String str = SecurityUtile.b(localCursor.getString(paramInt));
          int i = a(str);
          if (i != -1) {
            this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, i, str, null, null, 2, null);
          }
        }
        localCursor.close();
      }
    }
  }
  
  private String b(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  private List b(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {}
    do
    {
      return null;
      if ((paramInt == 3000) || (paramInt == 8))
      {
        paramString = QCallRecord.getTableName(paramString, paramInt);
        paramInt = localSQLiteDatabase.a(paramString);
        if (paramInt > this.jdField_a_of_type_Int) {
          localSQLiteDatabase.a(String.format("delete from %s where time in (select time from %s order by time limit %s)", new Object[] { paramString, paramString, Integer.valueOf(paramInt - this.jdField_a_of_type_Int) }));
        }
        paramString = "select * from " + paramString + " order by time asc";
        return a().a(QCallRecord.class, paramString, null);
      }
      paramString = a(paramString);
    } while (paramString == null);
    ArrayList localArrayList = new ArrayList();
    paramInt = paramString.getColumnIndex("name");
    while (paramString.moveToNext())
    {
      Object localObject = SecurityUtile.b(paramString.getString(paramInt));
      int i = localSQLiteDatabase.a((String)localObject);
      if (i > 0)
      {
        if (i > this.jdField_a_of_type_Int) {
          localSQLiteDatabase.a(String.format("delete from %s where time in (select time from %s order by time limit %s)", new Object[] { localObject, localObject, Integer.valueOf(i - this.jdField_a_of_type_Int) }));
        }
        localObject = "select * from " + (String)localObject + " order by time asc";
        localObject = a().a(QCallRecord.class, (String)localObject, null);
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
        Collections.sort(localArrayList, new uah(this));
      }
    }
    paramString.close();
    return localArrayList;
  }
  
  private boolean b(QCallRecord paramQCallRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramQCallRecord.friendUin, paramQCallRecord.uinType, paramQCallRecord.getTableName(), paramQCallRecord, 3, null);
    return true;
  }
  
  private boolean c(QCallRecord paramQCallRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramQCallRecord.friendUin, paramQCallRecord.uinType, paramQCallRecord.getTableName(), paramQCallRecord, 4, null);
    return true;
  }
  
  public QCallRecent a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      QCallRecent localQCallRecent2 = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.get(b(paramString, paramInt));
      QCallRecent localQCallRecent1 = localQCallRecent2;
      if (localQCallRecent2 == null)
      {
        localQCallRecent1 = new QCallRecent();
        localQCallRecent1.uin = paramString;
        localQCallRecent1.type = paramInt;
        localQCallRecent1.displayName = localQCallRecent1.uin;
      }
      return localQCallRecent1;
    }
  }
  
  public List a()
  {
    return a(null);
  }
  
  public List a(QCallProxy.QueryRecentCallsListener arg1)
  {
    ThreadManager.a(new uai(this, ???), 5, null, false);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        QCallRecent localQCallRecent = (QCallRecent)localIterator.next();
        if ((localQCallRecent == null) || (localQCallRecent.uin == null) || (localQCallRecent.uin.length() < 2)) {
          Utils.a(jdField_a_of_type_JavaLangString);
        }
        if ((localQCallRecent != null) && (localQCallRecent.uin != null) && (localQCallRecent.uin.length() >= 2)) {
          localArrayList.add(localQCallRecent);
        }
      }
    }
    return localList;
  }
  
  public List a(String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    Object localObject1 = a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    label243:
    for (;;)
    {
      try
      {
        Object localObject2 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if (localObject2 != null) {
          return (List)localObject2;
        }
        paramString = b(paramString, paramInt);
        if (paramString != null) {
          break label243;
        }
        paramString = new ArrayList();
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder().append("getListRecord ThreadName:").append(Thread.currentThread().getName()).append(" getListRecord (DB) records size:");
          if (paramString != null)
          {
            paramInt = paramString.size();
            QLog.d((String)localObject2, 2, paramInt);
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getListRecord" + paramString);
          }
        }
        else
        {
          paramString = a(paramString);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
          return paramString;
        }
      }
      finally {}
      paramInt = 0;
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (!this.jdField_a_of_type_Boolean) {
          ThreadManager.a(new uaf(this), 5, null, true);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, localException.getMessage(), localException);
        }
      }
    }
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramQCallRecent);
      this.jdField_a_of_type_JavaUtilMap.remove(b(paramQCallRecent.uin, paramQCallRecent.type));
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 5, null);
      return;
    }
  }
  
  public void a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord == null) {
      return;
    }
    for (;;)
    {
      synchronized (a(paramQCallRecord.friendUin, paramQCallRecord.uinType))
      {
        String str1 = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
        List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
        if (localList == null)
        {
          localList = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
          localList.add(paramQCallRecord);
          if (QLog.isColorLevel())
          {
            String str2 = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder().append("insertRecord ThreadName:").append(Thread.currentThread().getName()).append(" insertRecord records size:");
            if (localList != null)
            {
              i = localList.size();
              QLog.d(str2, 2, i);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, a(localList));
            b(paramQCallRecord);
            return;
          }
          int i = 0;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = a(paramString, paramInt);
    localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    if (localObject != null) {
      ((List)localObject).clear();
    }
    a(paramString, paramInt);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (!a(paramString1, paramInt1).equals(a(paramString2, paramInt2)))
    {
      Object localObject = a(paramString1, paramInt1);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          QCallRecord localQCallRecord = (QCallRecord)((Iterator)localObject).next();
          localQCallRecord.friendUin = paramString2;
          localQCallRecord.uinType = paramInt2;
          a(localQCallRecord);
        }
        a(paramString1, paramInt1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putBoolean("Conversation_call_prompt_flag", false);
    localEditor.commit();
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public QCallRecent b(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.get(b(paramString, paramInt));
      return paramString;
    }
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    e();
    c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 3, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 4, null);
  }
  
  public void b(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord == null) {
      return;
    }
    label204:
    label209:
    for (;;)
    {
      synchronized (a(paramQCallRecord.friendUin, paramQCallRecord.uinType))
      {
        Object localObject1 = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
        List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        if (localList == null) {
          break label204;
        }
        Object localObject3 = localList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = (QCallRecord)((Iterator)localObject3).next();
          if (((QCallRecord)localObject1).uniseq != paramQCallRecord.uniseq) {
            continue;
          }
          ((QCallRecord)localObject1).talkTime = paramQCallRecord.talkTime;
          paramQCallRecord = (QCallRecord)localObject1;
          if (!QLog.isColorLevel()) {
            break label209;
          }
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder().append("updateRecord ThreadName:").append(Thread.currentThread().getName()).append(" updateRecord records size:");
          if (localList != null)
          {
            i = localList.size();
            QLog.d((String)localObject1, 2, i);
            break label209;
            if (paramQCallRecord == null) {
              break;
            }
            c(paramQCallRecord);
            return;
          }
          int i = 0;
        }
      }
      paramQCallRecord = null;
      continue;
      paramQCallRecord = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void c(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, false);
  }
  
  public void c(QCallRecord paramQCallRecord)
  {
    synchronized (a(paramQCallRecord.friendUin, paramQCallRecord.uinType))
    {
      String str = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localList != null)
      {
        localList.remove(paramQCallRecord);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, a(localList));
      }
      a(paramQCallRecord);
      return;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "recentDoInit ====start====");
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("Conversation_call_prompt_flag", true);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    List localList1 = localEntityManager.a(QCallRecent.class, false, null, null, null, null, "lastCallTime desc", null);
    List localList2 = this.jdField_a_of_type_JavaUtilList;
    if (localList1 != null)
    {
      Object localObject3;
      Iterator localIterator;
      for (;;)
      {
        Object localObject4;
        long l1;
        boolean bool;
        Object localObject1;
        try
        {
          if (localList1.size() <= 0) {
            break label468;
          }
          localObject4 = localList1;
          if (localList1.size() > 100)
          {
            l1 = System.currentTimeMillis();
            localObject3 = localList1;
          }
        }
        finally {}
        try
        {
          bool = localEntityManager.b("delete from" + "recent_call" + " where lastCallTime < " + ((QCallRecent)localList1.get(90)).lastCallTime + ";");
          localObject1 = localList1;
          if (bool)
          {
            localObject3 = localList1;
            localObject1 = new ArrayList(localList1.subList(0, 90));
          }
          localObject4 = localObject1;
          localObject3 = localObject1;
          if (QLog.isColorLevel())
          {
            localObject3 = localObject1;
            long l2 = System.currentTimeMillis();
            localObject3 = localObject1;
            QLog.d(jdField_a_of_type_JavaLangString, 2, "doInit cache data > 100 isOk = " + bool + ",time:" + (l2 - l1));
            localObject4 = localObject1;
          }
        }
        catch (Exception localException)
        {
          localObject4 = localObject3;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 4, localException.getMessage(), localException);
          localObject4 = localObject3;
          continue;
          localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      localObject1 = ((List)localObject4).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (QCallRecent)((Iterator)localObject1).next();
        if ((((QCallRecent)localObject3).state == 5) || (((QCallRecent)localObject3).state == 6) || (((QCallRecent)localObject3).state == 7) || (((QCallRecent)localObject3).state == 1)) {
          ((QCallRecent)localObject3).state = 0;
        }
        if ((((QCallRecent)localObject3).uin != null) && (((QCallRecent)localObject3).uin.length() >= 2)) {
          this.jdField_a_of_type_JavaUtilList.add(localObject3);
        }
      }
      while (localIterator.hasNext())
      {
        localObject3 = (QCallRecent)localIterator.next();
        this.jdField_a_of_type_JavaUtilMap.put(b(((QCallRecent)localObject3).uin, ((QCallRecent)localObject3).type), localObject3);
      }
    }
    label468:
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, this.jdField_a_of_type_JavaUtilList.toString());
    }
    localEntityManager.a();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "recentDoInit ====end====");
    }
  }
  
  public void d(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, true);
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\QCallProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */