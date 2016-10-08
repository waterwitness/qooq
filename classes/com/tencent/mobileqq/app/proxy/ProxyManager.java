package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationProxy;
import com.tencent.mobileqq.app.message.MsgProxyContainer;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportControllerImpl.ReportProxyAdapter;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import cooperation.qlink.QlinkReliableReport.ReliableReportProxy;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;
import qnm;
import qnn;

public class ProxyManager
  implements Manager
{
  static final int jdField_a_of_type_Int = 10000;
  private static final String jdField_a_of_type_JavaLangString = "Q.msg.MsgProxy";
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { QCallProxy.class };
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private DBDelayManager jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager;
  private ConversationProxy jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy;
  private MsgProxyContainer jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer;
  private MultiMsgProxy jdField_a_of_type_ComTencentMobileqqAppMessageMultiMsgProxy;
  private DataLineMsgProxy jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
  private MpfileTaskProxy jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy;
  private RecentUserProxy jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
  private FileManagerProxy jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy;
  private UniformDownloadBPTransProxy jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy;
  private QCallProxy jdField_a_of_type_ComTencentMobileqqQcallQCallProxy;
  private ReportControllerImpl.ReportProxyAdapter jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter;
  private QlinkReliableReport.ReliableReportProxy jdField_a_of_type_CooperationQlinkQlinkReliableReport$ReliableReportProxy;
  public Object a;
  private Thread jdField_a_of_type_JavaLangThread;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public final Vector a;
  public volatile boolean a;
  private BaseProxy[] jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy;
  private DataLineMsgProxy jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ReadInJoyHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager = paramQQAppInterface.a().a();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer = new MsgProxyContainer(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMultiMsgProxy = new MultiMsgProxy(paramQQAppInterface, this);
    this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy = new DataLineMsgPcProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy = new DataLineMsgIpadProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy = new MpfileTaskProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy = new FileManagerProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy = new UniformDownloadBPTransProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter = new ReportControllerImpl.ReportProxyAdapter(paramQQAppInterface, this);
    this.jdField_a_of_type_CooperationQlinkQlinkReliableReport$ReliableReportProxy = new QlinkReliableReport.ReliableReportProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy = new ConversationProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = new RecentUserProxy(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy = new QCallProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy = new BaseProxy[] { this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer, this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy, this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy, this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter, this.jdField_a_of_type_CooperationQlinkQlinkReliableReport$ReliableReportProxy, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy, this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy, this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy };
    this.jdField_a_of_type_JavaLangThread = new Thread(new qnn(this));
    this.jdField_a_of_type_Boolean = false;
  }
  
  private SQLiteDatabase a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ProxyObserver)localIterator.next()).a(paramInt);
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    int i;
    if (!this.jdField_b_of_type_Boolean)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
      if (i != 0) {
        break label84;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L)
      {
        this.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "isSaveDBAtOnce timeout30s isSaveDBAtOnceFlag:" + this.jdField_b_of_type_Boolean);
        }
      }
      bool1 = false;
    }
    label84:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (i != 1);
      this.jdField_b_of_type_Boolean = true;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MsgProxy", 2, "isSaveDBAtOnce unActionLoginB isSaveDBAtOnceFlag:" + this.jdField_b_of_type_Boolean);
    return true;
  }
  
  private boolean a(BaseProxy paramBaseProxy)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      try
      {
        if (i < jdField_a_of_type_ArrayOfJavaLangClass.length)
        {
          Class localClass1 = paramBaseProxy.getClass();
          Class localClass2 = jdField_a_of_type_ArrayOfJavaLangClass[i];
          if (localClass1 == localClass2) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  private void g()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy.length) && (!this.jdField_a_of_type_Boolean)) {
          if (a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i]))
          {
            this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i]);
          }
          else
          {
            TraceUtils.a("i." + this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i]);
            long l = System.currentTimeMillis();
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i].a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i].getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
            }
            TraceUtils.a();
          }
        }
      }
      finally {}
      return;
      i += 1;
    }
  }
  
  public ConversationProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy;
  }
  
  public MsgProxyContainer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer;
  }
  
  public MultiMsgProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageMultiMsgProxy;
  }
  
  public DataLineMsgProxy a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a();
      return this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a();
      return this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a();
    return this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
  }
  
  public MpfileTaskProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy;
  }
  
  public RecentUserProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
  }
  
  public FileManagerProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy;
  }
  
  public UniformDownloadBPTransProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy;
  }
  
  public QCallProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy;
  }
  
  public ReportControllerImpl.ReportProxyAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter;
  }
  
  public Vector a()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          boolean bool = this.jdField_a_of_type_JavaUtilSet.isEmpty();
          if (!bool) {}
        }
        else
        {
          return;
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        if (localIterator.hasNext())
        {
          BaseProxy localBaseProxy = (BaseProxy)localIterator.next();
          TraceUtils.a("i." + localBaseProxy);
          long l = System.currentTimeMillis();
          localBaseProxy.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localBaseProxy.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
          }
          TraceUtils.a();
        }
        else
        {
          this.jdField_a_of_type_JavaUtilSet.clear();
        }
      }
      finally {}
    }
  }
  
  public void a(ProxyObserver paramProxyObserver)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramProxyObserver)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramProxyObserver);
    }
  }
  
  public void a(EntityManager paramEntityManager)
  {
    Object localObject4;
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "transSaveToDatabase writeRunable msgQueue size:" + this.jdField_a_of_type_JavaUtilVector.size());
        }
        if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {
          return;
        }
        localObject4 = (List)this.jdField_a_of_type_JavaUtilVector.clone();
        this.jdField_a_of_type_JavaUtilVector.clear();
        if (localObject4 != null)
        {
          if (this.c)
          {
            if ((!FTSDBManager.jdField_a_of_type_Boolean) || (!SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
              break label575;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
              this.c = false;
            }
          }
          localObject2 = null;
          ??? = null;
        }
      }
    }
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      MsgQueueItem localMsgQueueItem;
      String str;
      ProxyListener localProxyListener;
      try
      {
        localEntityTransaction = paramEntityManager.a();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.a();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localObject4 = ((List)localObject4).iterator();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (!((Iterator)localObject4).hasNext()) {
          break label1149;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localMsgQueueItem = (MsgQueueItem)((Iterator)localObject4).next();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        str = localMsgQueueItem.b;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener = localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (QLog.isColorLevel())
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          if ((localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof MessageRecord))
          {
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            QLog.d("Q.msg.MsgProxy", 2, "writeRunable QueueItem.action: " + localMsgQueueItem.i + ",mr=" + localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
          }
        }
        else
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          switch (localMsgQueueItem.i)
          {
          case 0: 
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            paramEntityManager.b(localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
            if (localProxyListener != null)
            {
              ??? = localEntityTransaction;
              localObject2 = localEntityTransaction;
              localProxyListener.a(str);
            }
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            if (!FTSDBManager.jdField_a_of_type_Boolean) {
              continue;
            }
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            if (!SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              continue;
            }
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            if (!SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              continue;
            }
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity, paramEntityManager);
            continue;
          }
        }
      }
      catch (Exception paramEntityManager)
      {
        localObject2 = ???;
        paramEntityManager.printStackTrace();
        localObject2 = ???;
        a(1001);
        localObject2 = ???;
        if (QLog.isColorLevel())
        {
          localObject2 = ???;
          QLog.w("Q.msg.MsgProxy", 2, "writeRunable write exception: " + paramEntityManager.getMessage());
        }
        if (??? != null) {
          ((EntityTransaction)???).b();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
        return;
        paramEntityManager = finally;
        throw paramEntityManager;
        paramEntityManager = finally;
        throw paramEntityManager;
        label575:
        this.c = false;
        break;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        QLog.d("Q.msg.MsgProxy", 2, "writeRunable QueueItem.action: " + localMsgQueueItem.i + ",uin=" + localMsgQueueItem.jdField_a_of_type_JavaLangString + ",value=" + localMsgQueueItem.jdField_a_of_type_AndroidContentContentValues);
        continue;
      }
      finally
      {
        if (localObject2 != null) {
          ((EntityTransaction)localObject2).b();
        }
      }
      ??? = localEntityTransaction;
      localObject2 = localEntityTransaction;
      paramEntityManager.b(localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
      if (localProxyListener != null)
      {
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener.a(str);
        continue;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (FTSDBManager.jdField_a_of_type_Boolean)
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          if (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            if (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
            {
              ??? = localEntityTransaction;
              localObject2 = localEntityTransaction;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localMsgQueueItem, paramEntityManager);
            }
          }
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (QLog.isColorLevel())
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          QLog.d("StatusPush", 2, "ProxyManager batch save uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + " : " + str);
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        SQLiteDatabase localSQLiteDatabase = a();
        if (localSQLiteDatabase != null)
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          int i = localSQLiteDatabase.a(str, localMsgQueueItem.jdField_a_of_type_AndroidContentContentValues, localMsgQueueItem.c, localMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString);
          if (localProxyListener != null)
          {
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            localProxyListener.a(str, i);
            continue;
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            paramEntityManager.a(localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
            if (localProxyListener != null)
            {
              ??? = localEntityTransaction;
              localObject2 = localEntityTransaction;
              localProxyListener.a(str, 1);
              continue;
              ??? = localEntityTransaction;
              localObject2 = localEntityTransaction;
              if (FTSDBManager.jdField_a_of_type_Boolean)
              {
                ??? = localEntityTransaction;
                localObject2 = localEntityTransaction;
                if (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
                {
                  ??? = localEntityTransaction;
                  localObject2 = localEntityTransaction;
                  if (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
                  {
                    ??? = localEntityTransaction;
                    localObject2 = localEntityTransaction;
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(localMsgQueueItem, paramEntityManager);
                  }
                }
              }
              ??? = localEntityTransaction;
              localObject2 = localEntityTransaction;
              i = a().a(str, localMsgQueueItem.c, localMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString);
              if (localProxyListener != null)
              {
                ??? = localEntityTransaction;
                localObject2 = localEntityTransaction;
                localProxyListener.b(str, i);
                continue;
                ??? = localEntityTransaction;
                localObject2 = localEntityTransaction;
                paramEntityManager.b(localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
                if (localProxyListener != null)
                {
                  ??? = localEntityTransaction;
                  localObject2 = localEntityTransaction;
                  localProxyListener.b(str, 1);
                  continue;
                  ??? = localEntityTransaction;
                  localObject2 = localEntityTransaction;
                  i = a().a(str, localMsgQueueItem.c, localMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString);
                  if (localProxyListener != null)
                  {
                    ??? = localEntityTransaction;
                    localObject2 = localEntityTransaction;
                    localProxyListener.b(str, i);
                    continue;
                    label1149:
                    ??? = localEntityTransaction;
                    localObject2 = localEntityTransaction;
                    localEntityTransaction.c();
                    ??? = localEntityTransaction;
                    localObject2 = localEntityTransaction;
                    a(1000);
                    if (localEntityTransaction != null) {
                      localEntityTransaction.b();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(String arg1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    paramContentValues = new MsgQueueItem(???, paramInt1, paramString2, paramContentValues, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        try
        {
          this.jdField_a_of_type_JavaUtilVector.add(paramContentValues);
          if (this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
            }
            e();
            return;
          }
        }
        catch (OutOfMemoryError paramContentValues)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue oom, " + paramString2);
            }
          }
        }
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
    }
    e();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    d(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
      }
      e();
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
    }
    e();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    a(paramString1, paramInt1, paramString2, null, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangThread != null) && (this.jdField_a_of_type_JavaLangThread.getState() == Thread.State.NEW))
    {
      g();
      this.jdField_a_of_type_JavaLangThread.setName("QQ_DB");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  public void b(ProxyObserver paramProxyObserver)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramProxyObserver)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramProxyObserver);
    }
  }
  
  public void b(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    d(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    e();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "transSaveToDatabase");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).createEntityManager();
    a(localEntityManager);
    localEntityManager.a();
  }
  
  public void c(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    d(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
      }
      e();
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.clear();
      return;
    }
  }
  
  public void d(String arg1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    paramEntity = new MsgQueueItem(???, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    if ((QLog.isColorLevel()) && ((paramEntity.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof MessageRecord))) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueueDonotNotify QueueItem.action: " + paramEntity.i + ",mr=" + paramEntity.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
    }
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramEntity);
        return;
      }
      catch (OutOfMemoryError paramEntity)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue oom, " + paramString2);
          }
        }
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.c();
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.notify();
      return;
    }
  }
  
  public void f()
  {
    a(2000);
  }
  
  public void onDestroy()
  {
    int j = 0;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().onDestroy();
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.a(new qnm(this), 8, null, false);
      int i = j;
      if (this.jdField_a_of_type_JavaUtilVector != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (this.jdField_a_of_type_JavaUtilVector != null) {
          this.jdField_a_of_type_JavaUtilVector.notify();
        }
        i = j;
        if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i].b();
          i += 1;
        }
      }
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\ProxyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */