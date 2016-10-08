package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.FriendAnniver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.manager.Manager;
import pxs;
import pxt;

public class FriendAnniverManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "FriendAnniverManager";
  private static final String jdField_b_of_type_JavaLangString = "key_get_mayknow_timestamp";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FriendAnniver jdField_a_of_type_ComTencentMobileqqDataFriendAnniver;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Handler jdField_b_of_type_AndroidOsHandler;
  
  public FriendAnniverManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getPreferences();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b());
    this.b = new Handler(Looper.getMainLooper());
    c();
  }
  
  private void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.bd, 0, true, false);
    MessageRecord localMessageRecord = MessageRecordFactory.a(64536);
    localMessageRecord.msgtype = 64536;
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localMessageRecord.frienduin = AppConstants.bd;
    localMessageRecord.senderuin = AppConstants.bd;
    localMessageRecord.istroop = 0;
    localMessageRecord.msg = paramString;
    localMessageRecord.time = paramLong;
    ((ChatMessage)localMessageRecord).parse();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a("handleGetSystemMsgResp", true, 1, true, false);
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.d("FriendAnniverManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new pxs(this));
  }
  
  public FriendAnniver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver;
  }
  
  public void a()
  {
    try
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver.isReed = true;
          a(this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendAnniverManager", 2, "markFriendAnniverReaded | e : ", localException);
      }
    }
  }
  
  /* Error */
  public void a(FriendAnniver paramFriendAnniver, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/mobileqq/app/FriendAnniverManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ldc -39
    //   6: ldc -37
    //   8: ldc -37
    //   10: ldc -35
    //   12: ldc -35
    //   14: iconst_0
    //   15: iconst_0
    //   16: ldc -37
    //   18: ldc -37
    //   20: ldc -37
    //   22: ldc -37
    //   24: invokestatic 226	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   27: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +28 -> 58
    //   33: ldc 10
    //   35: iconst_2
    //   36: new 174	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   43: ldc -28
    //   45: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: lload_2
    //   49: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: ldc 10
    //   60: monitorenter
    //   61: aload_1
    //   62: invokestatic 237	java/lang/System:currentTimeMillis	()J
    //   65: ldc2_w 238
    //   68: ldiv
    //   69: putfield 242	com/tencent/mobileqq/data/FriendAnniver:timestamp	J
    //   72: aload_0
    //   73: aload_1
    //   74: putfield 77	com/tencent/mobileqq/app/FriendAnniverManager:jdField_a_of_type_ComTencentMobileqqDataFriendAnniver	Lcom/tencent/mobileqq/data/FriendAnniver;
    //   77: ldc 10
    //   79: monitorexit
    //   80: aload_0
    //   81: getfield 50	com/tencent/mobileqq/app/FriendAnniverManager:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   84: invokeinterface 248 1 0
    //   89: ldc 13
    //   91: lload_2
    //   92: invokeinterface 254 4 0
    //   97: invokeinterface 257 1 0
    //   102: pop
    //   103: aload_0
    //   104: getfield 44	com/tencent/mobileqq/app/FriendAnniverManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   107: invokevirtual 260	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   110: astore 4
    //   112: aload 4
    //   114: invokevirtual 264	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   117: aload_0
    //   118: getfield 44	com/tencent/mobileqq/app/FriendAnniverManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   121: ldc_w 266
    //   124: invokevirtual 269	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   127: pop
    //   128: aload_0
    //   129: aload_1
    //   130: invokespecial 209	com/tencent/mobileqq/app/FriendAnniverManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   133: pop
    //   134: aload 4
    //   136: invokevirtual 270	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   139: aload 4
    //   141: invokevirtual 272	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   144: aload_0
    //   145: new 274	com/tencent/mobileqq/newfriend/FriendAnniverMessage
    //   148: dup
    //   149: aload_1
    //   150: invokespecial 277	com/tencent/mobileqq/newfriend/FriendAnniverMessage:<init>	(Lcom/tencent/mobileqq/data/FriendAnniver;)V
    //   153: aload_0
    //   154: getfield 31	com/tencent/mobileqq/app/FriendAnniverManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   157: invokevirtual 280	com/tencent/mobileqq/newfriend/FriendAnniverMessage:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   160: aload_1
    //   161: getfield 242	com/tencent/mobileqq/data/FriendAnniver:timestamp	J
    //   164: invokespecial 282	com/tencent/mobileqq/app/FriendAnniverManager:a	(Ljava/lang/String;J)V
    //   167: return
    //   168: astore_1
    //   169: ldc 10
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    //   174: astore 5
    //   176: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +30 -> 209
    //   182: ldc 10
    //   184: iconst_2
    //   185: new 174	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 284
    //   195: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 5
    //   200: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload 4
    //   211: invokevirtual 272	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   214: aload_0
    //   215: new 274	com/tencent/mobileqq/newfriend/FriendAnniverMessage
    //   218: dup
    //   219: aload_1
    //   220: invokespecial 277	com/tencent/mobileqq/newfriend/FriendAnniverMessage:<init>	(Lcom/tencent/mobileqq/data/FriendAnniver;)V
    //   223: aload_0
    //   224: getfield 31	com/tencent/mobileqq/app/FriendAnniverManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   227: invokevirtual 280	com/tencent/mobileqq/newfriend/FriendAnniverMessage:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   230: aload_1
    //   231: getfield 242	com/tencent/mobileqq/data/FriendAnniver:timestamp	J
    //   234: invokespecial 282	com/tencent/mobileqq/app/FriendAnniverManager:a	(Ljava/lang/String;J)V
    //   237: return
    //   238: astore 5
    //   240: aload 4
    //   242: invokevirtual 272	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   245: aload_0
    //   246: new 274	com/tencent/mobileqq/newfriend/FriendAnniverMessage
    //   249: dup
    //   250: aload_1
    //   251: invokespecial 277	com/tencent/mobileqq/newfriend/FriendAnniverMessage:<init>	(Lcom/tencent/mobileqq/data/FriendAnniver;)V
    //   254: aload_0
    //   255: getfield 31	com/tencent/mobileqq/app/FriendAnniverManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   258: invokevirtual 280	com/tencent/mobileqq/newfriend/FriendAnniverMessage:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   261: aload_1
    //   262: getfield 242	com/tencent/mobileqq/data/FriendAnniver:timestamp	J
    //   265: invokespecial 282	com/tencent/mobileqq/app/FriendAnniverManager:a	(Ljava/lang/String;J)V
    //   268: aload 5
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	FriendAnniverManager
    //   0	271	1	paramFriendAnniver	FriendAnniver
    //   0	271	2	paramLong	long
    //   110	131	4	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   174	25	5	localException	Exception
    //   238	31	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   61	80	168	finally
    //   169	172	168	finally
    //   112	139	174	java/lang/Exception
    //   112	139	238	finally
    //   176	209	238	finally
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver == null) {
      return false;
    }
    if (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver.uin)) {
      return false;
    }
    try
    {
      long l1 = this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver.timestamp;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Object localObject = localSimpleDateFormat.format(Long.valueOf(l1 * 1000L));
      String str = null;
      if (QLog.isColorLevel()) {
        QLog.d("FriendAnniverManager", 2, "needAddFriendAnniver|curTimeStr : " + (String)localObject);
      }
      localObject = ((String)localObject).split(" ");
      if (localObject.length > 1) {
        str = localObject[0] + " 23:59:59";
      }
      if (str != null)
      {
        l1 = localSimpleDateFormat.parse(str).getTime();
        long l2 = System.currentTimeMillis();
        if (l1 > l2) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_get_mayknow_timestamp", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("FriendAnniverManager", 2, "getFriendAnniverInfoRemote|curTime = " + l1 + ", reqTime = " + l2);
    }
    if (l1 >= l2)
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).e();
      return;
    }
    l1 = Math.abs(l2 - l1);
    this.b.postDelayed(new pxt(this), l1);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.b.removeCallbacksAndMessages(null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FriendAnniverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */