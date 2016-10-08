package com.tencent.mobileqq.app.message;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.commonsdk.util.LargerInteger;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.app.fms.FullMessageSearchTask;
import com.tencent.mobileqq.app.fms.MessageSearchUtils;
import com.tencent.mobileqq.app.fms.SearchStrategy;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.MsgCacheStrategyParam;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import qls;

public class MsgProxy
  extends BaseProxy
{
  public static final int a = -1;
  static final String jdField_a_of_type_JavaLangString = "Q.msg.MsgProxy";
  public static final int b = 1;
  public static final int c = 2;
  protected MessageRecordEntityManager a;
  private Object jdField_a_of_type_JavaLangObject;
  
  public MsgProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private int a(String paramString, int paramInt)
  {
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      List localList = d(paramString, paramInt);
      int i = 0;
      if (localList != null)
      {
        i = localList.size();
        localList.clear();
      }
      if (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(a(paramString, paramInt))) {
        MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().remove(a(paramString, paramInt));
      }
      return i;
    }
  }
  
  private int a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      paramString = d(paramString, paramInt);
      paramInt = 0;
      if (paramString != null)
      {
        paramInt = paramString.size();
        Object localObject2 = new ArrayList();
        ((List)localObject2).addAll(paramString);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord.time >= paramLong1) && (localMessageRecord.time <= paramLong2) && (MsgProxyUtils.f(localMessageRecord.msgtype))) {
            paramString.remove(localMessageRecord);
          }
        }
      }
    }
    c();
    return paramInt;
  }
  
  private QQMessageFacade.Message a(String paramString, EntityManager paramEntityManager, int paramInt1, int paramInt2)
  {
    if (a(paramString, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramEntityManager);
    }
    int i;
    String str;
    if ((paramString.startsWith("mr_discusssion")) || (paramString.startsWith("mr_troop")))
    {
      i = 1;
      boolean bool = paramString.endsWith("_New");
      str = "select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype " + MsgProxyUtils.a() + " and m.longMsgId='%d' and m.issend='%d' order by %s limit 1";
      if (!bool) {
        break label177;
      }
      if (i == 0) {
        break label171;
      }
      paramEntityManager = "longMsgIndex asc , shmsgseq desc , _id desc";
    }
    for (;;)
    {
      paramString = String.format(str, new Object[] { paramString, paramString, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramEntityManager });
      paramString = a().a(QQMessageFacade.Message.class, paramString, null);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label183;
      }
      return (QQMessageFacade.Message)paramString.get(0);
      i = 0;
      break;
      label171:
      paramEntityManager = "longMsgIndex asc , time desc , _id desc";
      continue;
      label177:
      paramEntityManager = "_id desc";
    }
    label183:
    return null;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean)
  {
    if (paramMessageRecord1 == null) {}
    do
    {
      do
      {
        do
        {
          return paramMessageRecord2;
          if (!MsgProxyUtils.a(paramMessageRecord1, paramMessageRecord2)) {
            break;
          }
        } while (paramMessageRecord1.longMsgIndex > paramMessageRecord2.longMsgIndex);
        return paramMessageRecord1;
        if (!paramBoolean) {
          break;
        }
      } while (paramMessageRecord2.shmsgseq > paramMessageRecord1.shmsgseq);
      return paramMessageRecord1;
    } while (paramMessageRecord2.time > paramMessageRecord1.time);
    return paramMessageRecord1;
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      if (localHashSet.contains(((MessageRecord)paramList.get(i)).senderuin)) {
        localArrayList.add(paramList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(((MessageRecord)paramList.get(i)).senderuin);
      }
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  public static List a(List paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.time >= paramLong) {
        localArrayList.add(localMessageRecord);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject2;
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      localObject2 = d(paramString, paramInt);
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        return;
      }
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (!localMessageRecord.isread) {
          localMessageRecord.isread = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "setMsgRead " + ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).getBaseInfoString());
    }
    paramString = f(paramString, paramInt);
    if ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (MessageRecord)paramString.next();
      if (!((MessageRecord)localObject2).isread) {
        ((MessageRecord)localObject2).isread = true;
      }
    }
  }
  
  private boolean a()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        Iterator localIterator = MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().keySet().iterator();
        Object localObject1 = null;
        if (!localIterator.hasNext()) {
          break label413;
        }
        String str = (String)localIterator.next();
        if (((str != null) && (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().keySet().contains(str))) || ((str != null) && (MsgProxyUtils.b(str)))) {
          continue;
        }
        if (str != null)
        {
          List localList = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(str);
          localObject5 = str;
          localObject6 = localList;
          if (localList != null)
          {
            localObject5 = str;
            localObject6 = localList;
            if (localList.size() > 0)
            {
              localObject5 = (MessageRecord)localList.get(0);
              if (a(((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop, true)) {
                continue;
              }
              localObject5 = str;
              localObject6 = localList;
              if (localObject1 == null) {
                break label397;
              }
              if (((List)localObject1).size() == 0)
              {
                localObject5 = str;
                localObject6 = localList;
                break label397;
              }
              if ((localList == null) || (localList.size() <= 0)) {
                break label405;
              }
              localObject5 = str;
              localObject6 = localList;
              if (((MessageRecord)localList.get(localList.size() - 1)).time < ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time) {
                break label397;
              }
              break label405;
            }
          }
          if (localObject5 != null)
          {
            MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().remove(localObject5);
            if (QLog.isColorLevel())
            {
              if ((localObject6 == null) || (((List)localObject6).size() <= 0)) {
                continue;
              }
              l = ((MessageRecord)((List)localObject6).get(((List)localObject6).size() - 1)).time;
              QLog.d("Q.msg.MsgProxy", 2, new Object[] { "MsgPool.getPoolInstance().getMsgPool().remove:", localObject5, ",time=", Long.valueOf(l) });
            }
          }
          return true;
          long l = 0L;
          continue;
          localObject4 = localObject5;
        }
      }
      finally {}
      label397:
      Object localObject3;
      for (;;)
      {
        localObject3 = localObject6;
        break;
        label405:
        localObject5 = localObject4;
        localObject6 = localObject3;
      }
      label413:
      Object localObject5 = localObject4;
      Object localObject6 = localObject3;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1) || (paramInt == 1026);
  }
  
  private void b(String paramString, int paramInt)
  {
    if (d(paramString, paramInt).size() == 0)
    {
      if (a(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().remove(a(paramString, paramInt));
      b(paramString, paramInt, g(paramString, paramInt));
    }
  }
  
  /* Error */
  private void b(String paramString, int paramInt, List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 44	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   9: invokestatic 49	com/tencent/mobileqq/app/message/MsgPool:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/message/MsgPool;
    //   12: invokevirtual 259	com/tencent/mobileqq/app/message/MsgPool:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   15: invokevirtual 298	java/util/concurrent/ConcurrentHashMap:size	()I
    //   18: istore 5
    //   20: getstatic 301	com/tencent/mobileqq/app/message/MsgProxyUtils:a	[Ljava/lang/String;
    //   23: arraylength
    //   24: istore 6
    //   26: getstatic 303	com/tencent/mobileqq/app/message/MsgProxyUtils:b	[Ljava/lang/String;
    //   29: arraylength
    //   30: istore 7
    //   32: iload 5
    //   34: iload 6
    //   36: bipush 40
    //   38: iadd
    //   39: iload 7
    //   41: iadd
    //   42: if_icmple +45 -> 87
    //   45: iconst_0
    //   46: istore 9
    //   48: aload_0
    //   49: invokespecial 305	com/tencent/mobileqq/app/message/MsgProxy:a	()Z
    //   52: istore 8
    //   54: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +30 -> 87
    //   60: ldc 10
    //   62: iconst_2
    //   63: new 152	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 307
    //   73: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: iload 8
    //   78: invokevirtual 310	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   81: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_0
    //   88: getfield 38	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   91: invokevirtual 44	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   94: invokestatic 49	com/tencent/mobileqq/app/message/MsgPool:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/message/MsgPool;
    //   97: invokevirtual 259	com/tencent/mobileqq/app/message/MsgPool:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   100: aload_0
    //   101: aload_1
    //   102: iload_2
    //   103: invokevirtual 71	com/tencent/mobileqq/app/message/MsgProxy:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   106: aload_3
    //   107: invokevirtual 314	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: astore 4
    //   116: iload 9
    //   118: istore 8
    //   120: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq -69 -> 54
    //   126: ldc 10
    //   128: iconst_2
    //   129: ldc_w 316
    //   132: aload 4
    //   134: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: iload 9
    //   139: istore 8
    //   141: goto -87 -> 54
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	MsgProxy
    //   0	149	1	paramString	String
    //   0	149	2	paramInt	int
    //   0	149	3	paramList	List
    //   114	19	4	localException	Exception
    //   18	25	5	i	int
    //   24	15	6	j	int
    //   30	12	7	k	int
    //   52	88	8	bool1	boolean
    //   46	92	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   48	54	114	java/lang/Exception
    //   2	32	144	finally
    //   48	54	144	finally
    //   54	87	144	finally
    //   87	111	144	finally
    //   120	137	144	finally
  }
  
  private void b(List paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.versionCode > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "proxy addSync id=" + localMessageRecord.vipBubbleID);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(localMessageRecord.frienduin, localMessageRecord.istroop, MessageRecord.getTableName(localMessageRecord.frienduin, localMessageRecord.istroop), localMessageRecord, 0, paramProxyListener);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
  }
  
  private List c(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    String str1;
    String str2;
    if (paramInt2 > 0)
    {
      str1 = "limit " + paramInt2;
      str2 = "select * from " + MessageRecord.getTableName(paramString1, paramInt1) + " where time<%d %s order by time desc, _id desc %s";
      if (paramString2 != null) {
        break label272;
      }
    }
    label272:
    for (paramString2 = "";; paramString2 = "and " + paramString2)
    {
      paramString2 = String.format(str2, new Object[] { Long.valueOf(paramLong), paramString2, str1 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      paramString2 = a().a(paramString2, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramString2 != null) {
        Collections.reverse(paramString2);
      }
      if (paramString2 == null) {
        break label298;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      str1 = "";
      break;
    }
    label298:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  private MessageRecord g(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt);
    List localList = null;
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject3 = d(paramString, paramInt);
        localObject1 = localList;
        if (localObject3 != null)
        {
          Iterator localIterator = ((List)localObject3).iterator();
          localObject1 = localList;
          if (localIterator.hasNext())
          {
            localObject1 = (MessageRecord)localIterator.next();
            if (((MessageRecord)localObject1).getId() != paramLong) {
              continue;
            }
            ((List)localObject3).remove(localObject1);
          }
        }
        localList = f(paramString, paramInt);
        if (localList != null)
        {
          localObject3 = localList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramString = (MessageRecord)((Iterator)localObject3).next();
            if (paramString.getId() != paramLong) {
              continue;
            }
            localList.remove(paramString);
            return paramString;
          }
        }
      }
      finally {}
      paramString = (String)localObject1;
    }
  }
  
  protected int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(AppConstants.aE, paramInt))
      {
        Object localObject2 = d(AppConstants.aE, 4001);
        if (localObject2 != null)
        {
          int k = ((List)localObject2).size() - 1;
          i = j;
          j = k;
          if (j >= 0)
          {
            if (((MessageRecord)((List)localObject2).get(j)).msgtype == paramInt)
            {
              ((List)localObject2).remove(j);
              i += 1;
            }
          }
          else {
            a(String.valueOf(AppConstants.aE), 4001, MessageRecord.getTableName(String.valueOf(AppConstants.aE), 4001), "msgtype=?", new String[] { String.valueOf(paramInt) }, null);
          }
        }
        else
        {
          if ((localObject2 != null) && (((List)localObject2).size() == 0) && (GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            RecentUser localRecentUser = ((RecentUserProxy)localObject2).a(AppConstants.aC, 9000);
            if (localRecentUser != null) {
              ((RecentUserProxy)localObject2).b(localRecentUser);
            }
          }
          return i;
        }
      }
      j -= 1;
    }
  }
  
  protected int a(int paramInt, QQMessageFacade.Message paramMessage)
  {
    int i = 0;
    String str = String.valueOf(AppConstants.aE);
    label311:
    label314:
    for (;;)
    {
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(str, 4001))
      {
        localObject2 = d(str, 4001);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          return 0;
        }
        localObject2 = ((List)localObject2).iterator();
        MessageRecord localMessageRecord;
        if (((Iterator)localObject2).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "setRecommendMsgReaded " + localMessageRecord.getBaseInfoString());
          }
          if ((localMessageRecord.msgtype != paramInt) || (localMessageRecord.isread)) {
            break label311;
          }
          localMessageRecord.isread = true;
          i += 1;
          break label314;
        }
        localObject2 = f(str, 4001);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            if ((localMessageRecord.msgtype != paramInt) || (localMessageRecord.isread)) {
              continue;
            }
            localMessageRecord.isread = true;
          }
        }
      }
      Object localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isread", Boolean.valueOf(true));
      a(str, 4001, paramMessage.versionCode, (ContentValues)localObject2, "msgtype=? and isread=?", new String[] { String.valueOf(paramInt), "0" }, null);
      return i;
    }
  }
  
  protected int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "--->deleteC2CMsgByMessageRecord : peerUin:" + paramMessageRecord.frienduin + " type:" + paramMessageRecord.istroop + " uniseq:" + paramMessageRecord.uniseq + " mr:" + paramMessageRecord + " dbid:" + paramMessageRecord.getId());
    }
    if (paramBoolean)
    {
      g(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getId());
      label111:
      long l = paramMessageRecord.getId();
      if (l <= 0L) {
        break label189;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      if (paramMessageRecord.isread) {
        break label242;
      }
      return 2;
      d(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      break label111;
      label189:
      if (paramMessageRecord.uniseq == 0L) {
        break;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop), "uniseq=?", new String[] { String.valueOf(paramMessageRecord.uniseq) }, null);
    }
    label242:
    b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    return 1;
  }
  
  protected int a(String paramString, int paramInt, long paramLong)
  {
    String str = MessageRecord.getTableName(paramString, paramInt);
    boolean bool = a(paramInt);
    Object localObject2;
    if (bool)
    {
      ??? = "shmsgseq desc , _id desc";
      if (!bool) {
        break label191;
      }
      localObject2 = "shmsgseq";
      localObject2 = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, localObject2, Long.valueOf(paramLong), str, localObject2, Long.valueOf(paramLong), ??? });
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaLangObject)
      {
        if (a(paramString, paramInt, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
        }
        localObject2 = a().a(QQMessageFacade.Message.class, (String)localObject2, null);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          i = ((QQMessageFacade.Message)((List)localObject2).get(0)).unReadNum;
          paramInt = b(paramString, paramInt, paramLong);
          return i + paramInt;
          ??? = "time desc , _id desc";
          break;
          label191:
          localObject2 = "time";
        }
      }
      int i = 0;
    }
  }
  
  protected int a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    String str = "time>=? and time<=? and msgtype " + MsgProxyUtils.c();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramLong1);
    arrayOfString[1] = String.valueOf(paramLong2);
    int i = a(paramString, paramInt, paramLong1, paramLong2);
    if (paramBoolean)
    {
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), str, arrayOfString, null);
      a(paramString, paramInt, MessageRecord.getOldTableName(paramString, paramInt), str, arrayOfString, null);
    }
    return i;
  }
  
  protected int a(String paramString, int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    int i = 0;
    String str1 = null;
    String str2 = MessageRecord.getTableName(paramString, paramInt);
    paramString = str1;
    if (MsgProxyUtils.c(paramInt))
    {
      paramString = a();
      str1 = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 ) " + "and ( (time >= ? and time < ?) or (time = ? and longMsgIndex <= ? and _id <= ?))";
      long l1 = paramMessageRecord.time;
      long l2 = paramMessageRecord.time;
      paramInt = paramMessageRecord.longMsgIndex;
      long l3 = paramMessageRecord.getId();
      paramString = paramString.a(false, str2, new String[] { "_id" }, str1, new String[] { String.valueOf(paramLong), String.valueOf(l1), String.valueOf(l2), String.valueOf(paramInt), String.valueOf(l3) }, null, null, null, null);
    }
    paramInt = i;
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
  }
  
  protected int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 0;
    String str1 = null;
    String str2 = MessageRecord.getTableName(paramString, paramInt);
    paramString = str1;
    if (MsgProxyUtils.c(paramInt))
    {
      paramString = a();
      str1 = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 ) " + "and ( time < ? or (time = ? and longMsgIndex <= ? and _id <= ?))";
      long l1 = paramMessageRecord.time;
      long l2 = paramMessageRecord.time;
      paramInt = paramMessageRecord.longMsgIndex;
      long l3 = paramMessageRecord.getId();
      paramString = paramString.a(false, str2, new String[] { "_id" }, str1, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(paramInt), String.valueOf(l3) }, null, null, null, null);
    }
    paramInt = i;
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
  }
  
  protected int a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = a(paramString, paramInt);
    if (paramBoolean)
    {
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), null, null, null);
      a(paramString, paramInt, MessageRecord.getOldTableName(paramString, paramInt), null, null, null);
    }
    return i;
  }
  
  protected int a(List paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int i = paramList.size();
    Object localObject1 = (MessageRecord)paramList.get(paramList.size() - 1);
    String str = ((MessageRecord)localObject1).frienduin;
    int j = ((MessageRecord)localObject1).istroop;
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (paramBoolean)
      {
        g(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getId());
        label124:
        if (localMessageRecord.getId() <= 0L) {
          break label176;
        }
        ((List)localObject2).add(String.valueOf(localMessageRecord.getId()));
      }
      for (;;)
      {
        break;
        d(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        break label124;
        label176:
        if (localMessageRecord.uniseq != 0L) {
          ((List)localObject1).add(String.valueOf(localMessageRecord.uniseq));
        } else {
          i -= 1;
        }
      }
    }
    if (((List)localObject2).size() > 100)
    {
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        a(str, j, MessageRecord.getTableName(str, j), "_id=?", new String[] { localObject2 }, null);
      }
    }
    int k;
    if (((List)localObject2).size() != 0)
    {
      k = ((List)localObject2).size();
      paramList = new String[k];
      Arrays.fill(paramList, "?");
      paramList = Arrays.toString(paramList);
      paramList = "_id IN (" + paramList.substring(1, paramList.length() - 1) + ")";
      a(str, j, MessageRecord.getTableName(str, j), paramList, (String[])((List)localObject2).toArray(new String[k]), null);
    }
    if (((List)localObject1).size() > 100)
    {
      paramList = ((List)localObject1).iterator();
      while (paramList.hasNext())
      {
        localObject1 = (String)paramList.next();
        a(str, j, MessageRecord.getTableName(str, j), "uniseq=?", new String[] { localObject1 }, null);
      }
    }
    if (((List)localObject1).size() != 0)
    {
      k = ((List)localObject1).size();
      paramList = new String[k];
      Arrays.fill(paramList, "?");
      paramList = Arrays.toString(paramList);
      paramList = "uniseq IN (" + paramList.substring(1, paramList.length() - 1) + ")";
      a(str, j, MessageRecord.getTableName(str, j), paramList, (String[])((List)localObject1).toArray(new String[k]), null);
    }
    b(str, j);
    return i;
  }
  
  @Deprecated
  public Cursor a(String paramString, int paramInt)
  {
    int j = 0;
    List localList = b(paramString, paramInt);
    if (paramString.equals(String.valueOf(AppConstants.aq)))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add(localList.get(localList.size() - i - 1));
        i += 1;
      }
      new ArrayList();
      paramString = a(paramString, paramInt, Integer.MAX_VALUE);
      if (paramString != null)
      {
        paramInt = j;
        while (paramInt < paramString.size())
        {
          localArrayList.add(paramString.get(paramString.size() - paramInt - 1));
          paramInt += 1;
        }
      }
      return new qls(this, localArrayList);
    }
    return new qls(this, (List)((ArrayList)localList).clone());
  }
  
  @Deprecated
  protected Cursor a(List paramList)
  {
    return new qls(this, paramList);
  }
  
  public FullMessageSearchResult.SearchResultItem a(String paramString1, int paramInt1, String paramString2, int paramInt2, FullMessageSearchTask paramFullMessageSearchTask)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      if (a(paramString1, paramInt1, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
      }
      long l1 = NetConnInfoCenter.getServerTime();
      long l2 = SearchStrategy.jdField_a_of_type_Long;
      Object localObject = MessageRecord.getTableName(paramString1, paramInt1);
      localObject = a().a(false, (String)localObject, null, "msgtype in (?,?,?) AND time>=?", new String[] { String.valueOf(64536), String.valueOf(64501), String.valueOf(63525), String.valueOf(60527), String.valueOf(l1 - l2) }, null, null, "time desc, longMsgIndex desc", String.valueOf(paramInt2));
      try
      {
        paramString2 = MessageSearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager, (Cursor)localObject, paramString1, paramInt1, paramString2, paramFullMessageSearchTask);
        paramString1 = paramString2;
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
        return paramString2;
      }
      catch (Exception paramString1)
      {
        paramString1 = paramString1;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
        return null;
      }
      finally
      {
        paramString1 = finally;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
        throw paramString1;
      }
    }
  }
  
  protected QQMessageFacade.Message a(String paramString, EntityManager paramEntityManager)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaLangObject)
      {
        if (a(paramString, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramEntityManager);
        }
        if (paramString.startsWith("mr_discusssion")) {
          break label355;
        }
        if (!paramString.startsWith("mr_troop")) {
          break label361;
        }
        break label355;
        boolean bool2 = paramString.endsWith("_New");
        localObject1 = new StringBuilder(1024);
        ((StringBuilder)localObject1).append("select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype ");
        ((StringBuilder)localObject1).append(MsgProxyUtils.a());
        ((StringBuilder)localObject1).append(" order by %s limit 1");
        Object localObject3 = ((StringBuilder)localObject1).toString();
        if (!bool2) {
          break label374;
        }
        if (!bool1) {
          break label367;
        }
        localObject1 = "shmsgseq desc , _id desc";
        localObject1 = String.format((String)localObject3, new Object[] { paramString, paramString, paramString, localObject1 });
        localObject1 = a().a(QQMessageFacade.Message.class, (String)localObject1, null);
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label350;
        }
        localObject1 = (QQMessageFacade.Message)((List)localObject1).get(0);
        if ((!((QQMessageFacade.Message)localObject1).isLongMsg()) || (((QQMessageFacade.Message)localObject1).longMsgIndex <= 0)) {
          break label345;
        }
        paramEntityManager = a(paramString, paramEntityManager, ((QQMessageFacade.Message)localObject1).longMsgId, ((QQMessageFacade.Message)localObject1).issend);
        paramString = a(paramString);
        if ((paramString == null) || (paramString.size() <= 0)) {
          break label340;
        }
        int i;
        if (paramEntityManager == null)
        {
          i = 0;
          paramString = paramString.iterator();
          localObject1 = paramEntityManager;
          if (paramString.hasNext())
          {
            localObject3 = (MessageRecord)paramString.next();
            if (!((MessageRecord)localObject3).isread) {
              break label380;
            }
            j = 0;
            localObject1 = a((MessageRecord)localObject1, (MessageRecord)localObject3, bool1);
            i = j + i;
            continue;
          }
        }
        else
        {
          i = paramEntityManager.unReadNum;
          continue;
        }
        if (paramEntityManager == null)
        {
          paramString = new QQMessageFacade.Message();
          MessageRecord.copyMessageRecordBaseField(paramString, (MessageRecord)localObject1);
          paramString.unReadNum = i;
          return paramString;
        }
      }
      paramString = paramEntityManager;
      continue;
      label340:
      paramString = paramEntityManager;
      continue;
      label345:
      paramEntityManager = (EntityManager)localObject1;
      continue;
      label350:
      paramEntityManager = null;
      continue;
      label355:
      boolean bool1 = true;
      continue;
      label361:
      bool1 = false;
      continue;
      label367:
      Object localObject1 = "time desc , _id desc";
      continue;
      label374:
      localObject1 = "_id desc";
      continue;
      label380:
      int j = 1;
    }
  }
  
  protected ChatHistorySearchData a(Cursor paramCursor, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramCursor == null) || (paramCursor.getCount() == 0) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    String str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
    int j = paramSessionInfo.jdField_a_of_type_Int;
    String str2 = paramString.toLowerCase(Locale.US);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramString = new HashSet();
    a(paramSessionInfo, str1, j, paramString);
    HashSet localHashSet = new HashSet();
    paramString = paramString.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      str1 = (String)paramString.next();
      if (str1 != null)
      {
        localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, str1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), str1);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).toLowerCase(Locale.US).contains(str2))) {
          localHashSet.add(str1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getSearchResult, keyuins = " + localHashSet.toString());
    }
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    if (!paramCursor.isAfterLast())
    {
      paramString = a(paramCursor, paramSessionInfo, j);
      if ((TextUtils.isEmpty(paramString)) || (!localHashSet.contains(paramString))) {
        break label468;
      }
    }
    label465:
    label468:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
        str1 = "";
        paramString = str1;
        if (localObject != null) {
          paramString = str1;
        }
      }
      for (;;)
      {
        try
        {
          if (localObject.length > 0) {
            paramString = new String((byte[])localObject, "utf-8");
          }
          if (!paramString.toLowerCase(Locale.US).contains(str2)) {
            break label465;
          }
          i = 1;
          if (i != 0)
          {
            if (localArrayList1.size() >= 50) {
              continue;
            }
            paramString = (MessageRecord)a().a(MessageRecord.class, null, paramCursor);
            if (paramString != null) {
              localArrayList1.add(paramString);
            }
          }
          paramCursor.moveToNext();
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramString = "";
          continue;
          localArrayList2.add(Integer.valueOf(paramCursor.getInt(0)));
          continue;
        }
        if (localArrayList1.size() > 0)
        {
          paramCursor = new ChatHistorySearchData();
          paramCursor.mSearchData1 = localArrayList1;
          paramCursor.mSearchData2 = localArrayList2;
          return paramCursor;
        }
        return null;
      }
    }
  }
  
  protected ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSessionInfo != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label35;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      return (ChatHistorySearchData)localObject1;
      label35:
      localObject1 = MessageRecord.getTableName(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      Cursor localCursor = a().a(false, (String)localObject1, null, "msgtype = ?", new String[] { String.valueOf(64536) }, null, null, "time desc, longMsgIndex desc", null);
      try
      {
        paramSessionInfo = a(localCursor, paramSessionInfo, paramString);
        localObject1 = paramSessionInfo;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        return paramSessionInfo;
      }
      catch (Exception paramSessionInfo)
      {
        paramSessionInfo = paramSessionInfo;
        localObject1 = localObject2;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        return null;
      }
      finally
      {
        paramSessionInfo = finally;
        if (localCursor != null) {
          localCursor.close();
        }
        throw paramSessionInfo;
      }
    }
  }
  
  protected MessageRecord a(MessageRecord paramMessageRecord, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.msgtype = paramInt;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.msgtype = paramInt;
      localContentValues = new ContentValues();
      localContentValues.put("msgtype", Integer.valueOf(paramInt));
      if (localMessageRecord == null) {
        break label180;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label137;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : updateMessageType : set fail !");
      break;
      label137:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      continue;
      label180:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  protected MessageRecord a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.isValid = paramBoolean1;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.isValid = paramBoolean1;
      localContentValues = new ContentValues();
      localContentValues.put("isValid", Boolean.valueOf(paramBoolean1));
      if (localMessageRecord == null) {
        break label196;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label153;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      label116:
      if ((localMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)localMessageRecord).reParse();
      }
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : setMessageIsValidFlag : set fail !");
      break;
      label153:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      break label116;
      label196:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  protected MessageRecord a(String paramString, int paramInt)
  {
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      paramString = d(paramString, paramInt);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        paramString = (MessageRecord)paramString.get(paramString.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "getLastMsgFromList mr = " + paramString.getBaseInfoString());
        }
        return paramString;
      }
      return null;
    }
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord2 = null;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Iterator localIterator = b(paramString, paramInt).iterator();
    MessageRecord localMessageRecord1;
    do
    {
      localMessageRecord1 = localMessageRecord2;
      if (!localIterator.hasNext()) {
        break;
      }
      localMessageRecord1 = (MessageRecord)localIterator.next();
    } while (localMessageRecord1.uniseq != paramLong);
    if (localMessageRecord1 == null)
    {
      paramString = e(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localMessageRecord2 = (MessageRecord)paramString.next();
          if (localMessageRecord2.uniseq == paramLong) {
            return localMessageRecord2;
          }
        }
      }
    }
    return localMessageRecord1;
  }
  
  protected MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt1, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extraflag", Integer.valueOf(paramInt2));
    localContentValues.put("sendFailCode", Integer.valueOf(paramInt3));
    if (localMessageRecord != null)
    {
      localMessageRecord.extraflag = paramInt2;
      localMessageRecord.sendFailCode = paramInt3;
      if (localMessageRecord.getId() > 0L) {
        a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      }
    }
    a(paramString, paramInt1, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    if (localMessageRecord != null)
    {
      localMessageRecord.time = paramLong2;
      int i = localMessageRecord.versionCode;
      if ((localMessageRecord.extraflag == 32772) || (localMessageRecord.extraflag == 32768))
      {
        localMessageRecord.extraflag = 0;
        localMessageRecord.sendFailCode = 0;
      }
      e(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
      if (localMessageRecord.msgtype == 63531) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.uniseq, localMessageRecord.frienduin, localMessageRecord.istroop, paramLong2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "update msgTime set msg =" + localMessageRecord.getBaseInfoString());
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time", Long.valueOf(paramLong2));
    if ((localMessageRecord != null) && (localMessageRecord.extraflag == 0))
    {
      localContentValues.put("extraflag", Integer.valueOf(0));
      localContentValues.put("sendFailCode", Integer.valueOf(0));
    }
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    if (localMessageRecord != null)
    {
      localMessageRecord.time = paramLong2;
      localMessageRecord.shmsgseq = paramLong3;
      e(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time", Long.valueOf(paramLong2));
    localContentValues.put("shmsgseq", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if ((localMessageRecord == null) || (localMessageRecord.versionCode > 0)) {}
    try
    {
      localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
      localMessageRecord.msg = paramString2;
      localMessageRecord.msgData = paramString2.getBytes();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentByUniseq: set msg =" + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        label149:
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
      }
      for (;;)
      {
        return localMessageRecord;
        localContentValues.put("msg", paramString2);
        break;
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        break label149;
        try
        {
          localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
          a(paramString1, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        }
        catch (UnsupportedEncodingException paramString2)
        {
          for (;;) {}
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
  }
  
  protected MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    try
    {
      localObject = MessageRecord.class.getDeclaredField(paramString2);
      localClass = ((Field)localObject).getType();
      ((Field)localObject).setAccessible(true);
      if (localMessageRecord != null) {
        ((Field)localObject).set(localMessageRecord, paramObject);
      }
      if (Modifier.isStatic(((Field)localObject).getModifiers())) {
        break label476;
      }
      if (((Field)localObject).isAnnotationPresent(notColumn.class)) {
        return localMessageRecord;
      }
      localObject = new ContentValues();
      if (localClass != Long.TYPE) {
        break label189;
      }
      ((ContentValues)localObject).put(paramString2, (Long)paramObject);
    }
    catch (Exception paramString1)
    {
      Object localObject;
      for (;;)
      {
        Class localClass;
        paramString1.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq error! ", paramString1);
        return localMessageRecord;
        label189:
        if (localClass == Integer.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Integer)paramObject);
        }
        else if (localClass == String.class)
        {
          ((ContentValues)localObject).put(paramString2, (String)paramObject);
        }
        else if (localClass == Byte.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Byte)paramObject);
        }
        else if (localClass == byte[].class)
        {
          ((ContentValues)localObject).put(paramString2, (byte[])paramObject);
        }
        else if (localClass == Short.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Short)paramObject);
        }
        else if (localClass == Boolean.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Boolean)paramObject);
        }
        else if (localClass == Float.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Float)paramObject);
        }
        else if (localClass == Double.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Double)paramObject);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq fieldType error! " + localClass.getClass().getSimpleName());
          continue;
          a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
        }
      }
      a(paramString1, paramInt, 3, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    }
    if (localMessageRecord != null) {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        if (!(localMessageRecord instanceof ChatMessage)) {
          break label476;
        }
        ((ChatMessage)localMessageRecord).reParse();
        return localMessageRecord;
      }
    }
    label476:
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    if (a(paramString1, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString2 = String.format("select * from " + MessageRecord.getTableName(paramString1, paramInt) + " where time=%d and senderuin=%s", new Object[] { Long.valueOf(paramLong), paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMsgByConstraints: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt);
    }
    paramString1 = a().a(paramString2, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (MessageRecord)paramString1.next();
        if (paramString2.msg.equals(paramString3)) {
          return paramString2;
        }
      }
    }
    return null;
  }
  
  protected MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt1, paramLong1);
    if (localMessageRecord != null)
    {
      paramString3 = TransfileUtile.b(localMessageRecord.msg, paramString2, paramString3, paramLong2, paramInt2);
      localMessageRecord.msg = paramString3;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentToForward: set msg =" + localMessageRecord.getBaseInfoString());
      }
      paramString2 = new ContentValues();
      if ((localMessageRecord.versionCode <= 0) || (paramString3 == null)) {
        break label174;
      }
    }
    try
    {
      paramString2.put("msgData", paramString3.getBytes("UTF-8"));
      if (localMessageRecord.getId() > 0L) {
        a(paramString1, paramInt1, localMessageRecord.versionCode, paramString2, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        label174:
        paramString2.put("msg", paramString3);
        break;
        a(paramString1, paramInt1, localMessageRecord.versionCode, paramString2, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      }
    }
    catch (UnsupportedEncodingException paramString3)
    {
      for (;;) {}
    }
  }
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if (paramArrayOfByte != null) {
      localContentValues.put("msgData", paramArrayOfByte);
    }
    if (localMessageRecord != null)
    {
      localMessageRecord.msgData = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContent: set msg =" + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L) {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
      }
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null) || (paramString1.length() == 0)) {
      return null;
    }
    paramString1 = c(paramString1, paramInt);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString1.next();
        if (((localMessageRecord instanceof MessageForTroopFile)) && (paramString2.equals(((MessageForTroopFile)localMessageRecord).url))) {
          return localMessageRecord;
        }
      }
    }
    return null;
  }
  
  protected MessageRecordEntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createMessageRecordEntityManager());
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
    }
  }
  
  protected String a(Cursor paramCursor, SessionInfo paramSessionInfo, int paramInt)
  {
    paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
    if (MsgUtils.a(paramCursor.getInt(paramCursor.getColumnIndex("issend")))) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    return paramSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(String paramString, int paramInt)
  {
    return MsgProxyUtils.a(paramString, paramInt);
  }
  
  protected List a(String paramString)
  {
    ArrayList localArrayList;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
      localArrayList = new ArrayList();
      localObject = ((Vector)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgQueueItem localMsgQueueItem = (MsgQueueItem)((Iterator)localObject).next();
        if ((localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof MessageRecord))
        {
          MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
          if ((TextUtils.equals(paramString, localMsgQueueItem.b)) && (localMsgQueueItem.i == 0)) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue tableName=", paramString, ", size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public List a(String paramString, int paramInt)
  {
    return a(b(paramString, paramInt));
  }
  
  protected List a(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = String.format("select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ( select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from " + MessageRecord.getOldTableName(paramString, paramInt1) + " order by _id desc limit " + paramInt2 + " ) order by _id asc", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: sqlStr=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    localObject = a().a((String)localObject, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return (List)localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  protected List a(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAllMessages uin " + paramString + " , type = " + paramInt1 + " , customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = e(paramString, paramInt1);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAllMessages from AIO CACHE FAIL！ ");
      }
      localObject1 = b(paramString, paramInt1);
    }
    for (;;)
    {
      long l1 = Long.MAX_VALUE;
      long l4 = Long.MAX_VALUE;
      HashSet localHashSet = new HashSet();
      int i;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        i = 0;
        while (i < paramArrayOfInt.length)
        {
          localHashSet.add(Integer.valueOf(paramArrayOfInt[i]));
          i += 1;
        }
      }
      long l3;
      long l2;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if ((((List)localObject1).size() >= paramInt2) && (localHashSet.isEmpty()))
        {
          localArrayList.addAll(((List)localObject1).subList(((List)localObject1).size() - paramInt2, ((List)localObject1).size()));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
          }
          return localArrayList;
        }
        l3 = l1;
        Object localObject2;
        if (a(paramInt1))
        {
          localObject2 = ((List)localObject1).iterator();
          for (;;)
          {
            l3 = l1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            if (localMessageRecord.shmsgseq < l1) {
              l1 = localMessageRecord.shmsgseq;
            }
          }
        }
        localObject1 = ((List)localObject1).iterator();
        i = 3;
        l2 = Long.MAX_VALUE;
        l1 = l4;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((!a(paramInt1)) || (((MessageRecord)localObject2).versionCode != 3) || (((MessageRecord)localObject2).shmsgseq != l3) || (l3 == 0L)) {
            for (;;)
            {
              int j;
              long l5;
              if (!localHashSet.contains(Integer.valueOf(((MessageRecord)localObject2).msgtype)))
              {
                j = i;
                l5 = l1;
                l4 = l2;
                if (!localHashSet.isEmpty()) {}
              }
              else
              {
                j = i;
                if (((MessageRecord)localObject2).versionCode < i) {
                  j = ((MessageRecord)localObject2).versionCode;
                }
                l4 = l2;
                if (((MessageRecord)localObject2).getId() > 0L)
                {
                  l4 = l2;
                  if (((MessageRecord)localObject2).getId() < l2) {
                    l4 = ((MessageRecord)localObject2).getId();
                  }
                }
                l2 = l1;
                if (((MessageRecord)localObject2).time < l1) {
                  l2 = ((MessageRecord)localObject2).time;
                }
                localArrayList.add(localObject2);
                l5 = l2;
              }
              i = j;
              l1 = l5;
              l2 = l4;
            }
          }
        }
        if (localArrayList.size() >= paramInt2) {
          return localArrayList.subList(localArrayList.size() - paramInt2, localArrayList.size());
        }
        l4 = l3;
        l3 = l1;
      }
      for (l1 = l4;; l1 = Long.MAX_VALUE)
      {
        if (a(paramInt1)) {
          localArrayList.addAll(0, a(paramString, paramInt1, l2, i, l1, paramInt2 - localArrayList.size(), paramArrayOfInt));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
          }
          return localArrayList;
          localArrayList.addAll(0, a(paramString, paramInt1, l2, i, l3, paramInt2 - localArrayList.size(), paramArrayOfInt));
        }
        l3 = Long.MAX_VALUE;
        i = 3;
        l2 = Long.MAX_VALUE;
      }
    }
  }
  
  protected List a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgListAndJumpTo peerUin: " + paramString + " type: " + paramInt + " , from = " + paramLong);
    }
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      if (a(paramInt))
      {
        localList = c(paramString, paramInt, paramLong, 2147483647L);
        Object localObject1 = localList;
        if (localList == null) {
          localObject1 = new ArrayList();
        }
        MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().put(a(paramString, paramInt), localObject1);
        return (List)localObject1;
      }
      List localList = d(paramString, paramInt, paramLong, 2147483647L);
    }
  }
  
  protected List a(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryTimedMessageDBUnion, peerUin = " + paramString1 + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",whrere = " + paramString2);
    }
    paramString2 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString1, paramInt1), MessageRecord.getTableName(paramString1, paramInt1), paramLong1, paramInt2, paramLong2, paramInt3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(), paramString2);
    if (paramString2 != null)
    {
      if (a(paramString1, paramInt1, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      paramString1 = a().a(paramString2.toString(), null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("QQMessageFacade", 2, paramString2.toString());
      }
      if (paramString1 != null)
      {
        Collections.reverse(paramString1);
        paramString2 = paramString1.iterator();
        while (paramString2.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramString2.next();
          if (QLog.isColorLevel()) {
            QLog.i("QQMessageFacade", 2, "queryTimedMessageDBUnion " + localMessageRecord.time + ", " + localMessageRecord.getId() + ", " + localMessageRecord.getLogColorContent());
          }
        }
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryC2CMessageFromDB_UnionTables, peerUin = " + paramString + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    Object localObject2 = null;
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    }
    Object localObject1 = localObject2;
    if (paramArrayOfInt != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfInt.length > 0)
      {
        localObject1 = new StringBuilder(" and msgtype in ( ");
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
          ((StringBuilder)localObject1).append(paramArrayOfInt[i]);
          if (i < paramArrayOfInt.length - 1) {
            ((StringBuilder)localObject1).append(" , ");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).append(") ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramArrayOfInt = a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, (String)localObject1);
    paramString = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  protected List a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + paramString1 + ",type=" + paramInt1 + ",seq=" + paramLong + ",count=" + paramInt2);
    }
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    }
    boolean bool = a(paramInt1);
    if (MessageDBUtils.a(MessageRecord.getTableName(paramString1, paramInt1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b()))
    {
      if (bool) {}
      for (paramString1 = b(paramString1, paramInt1, paramLong, paramInt2, paramString2); paramString1 != null; paramString1 = c(paramString1, paramInt1, paramLong, paramInt2, paramString2)) {
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  protected List a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.shmsgseq == paramLong1) && (localMessageRecord.msgUid == paramLong2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      paramString = e(paramString, paramInt, paramLong1, paramLong2);
      if ((paramString != null) && (!paramString.isEmpty())) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
  }
  
  public List a(String paramString, int paramInt, long paramLong, Map paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter,  peerUin = " + paramString + ", type " + paramInt + ", seq = " + paramLong + ", filterMsgSet.size = " + ((Map)localObject1).size() + ",filterMsgSet = " + ((Map)localObject1).keySet());
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=?";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter " + paramString);
    }
    paramMap = a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramMap = paramMap.a(paramString, new String[] { String.valueOf(paramLong) }, (QQAppInterface)localObject2);
    if (paramMap == null) {
      return new ArrayList();
    }
    paramString = new ArrayList();
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      localObject2 = (MessageRecord)paramMap.next();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "filter msg , seq = " + ((MessageRecord)localObject2).shmsgseq + " ,id = " + ((MessageRecord)localObject2).getId() + ",uniseq=" + ((MessageRecord)localObject2).uniseq);
      }
      if ((!((Map)localObject1).containsKey("id&" + ((MessageRecord)localObject2).getId() + "&" + ((MessageRecord)localObject2).shmsgseq)) && (!((Map)localObject1).containsKey("uniseq&" + ((MessageRecord)localObject2).uniseq + "&" + ((MessageRecord)localObject2).shmsgseq))) {
        paramString.add(localObject2);
      }
    }
    return paramString;
  }
  
  protected List a(String paramString, int paramInt, List paramList)
  {
    if ((paramList == null) || (paramString == null) || (paramString.length() == 0) || (paramList.size() == 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (i < paramList.size())
      {
        localMessageRecord = a(paramString, paramInt, ((Long)paramList.get(i)).longValue());
        if (localMessageRecord != null) {}
      }
      else
      {
        if (i < paramList.size() - 1) {
          localArrayList.addAll(b(paramString, paramInt, paramList.subList(i, paramList.size())));
        }
        return localArrayList;
      }
      localArrayList.add(localMessageRecord);
      i += 1;
    }
  }
  
  protected List a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList peerUin: " + paramString + " type: " + paramInt + " , autoInit = " + paramBoolean1);
    }
    label488:
    label501:
    label514:
    label557:
    label598:
    for (;;)
    {
      Object localObject2;
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        localObject1 = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt));
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break label557;
        }
        if (!paramBoolean1) {
          break label514;
        }
        localObject2 = d(paramString, paramInt);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label501;
        }
        localObject1 = new ArrayList();
        if ((paramInt != 0) && (paramInt != 1000) && (paramInt != 1004)) {
          break label488;
        }
        if (((List)localObject2).size() > 15)
        {
          ((List)localObject1).addAll(((List)localObject2).subList(((List)localObject2).size() - 15, ((List)localObject2).size()));
          if ((((List)localObject2).size() > 15) && (MsgProxyUtils.a(paramString, paramInt, (List)localObject1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList : pull more long msg");
            }
            ((List)localObject1).clear();
            if (((List)localObject2).size() > 30) {
              ((List)localObject1).addAll(((List)localObject2).subList(((List)localObject2).size() - 30, ((List)localObject2).size()));
            }
          }
          else
          {
            localObject2 = a((List)localObject1, ((Long)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString).first).longValue());
            if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
              break label598;
            }
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "continuedList :" + ((List)localObject2).size());
            }
            MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().put(a(paramString, paramInt), localObject2);
            return (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt));
          }
        }
        else
        {
          ((List)localObject1).addAll((Collection)localObject2);
        }
      }
      ((List)localObject1).addAll((Collection)localObject2);
      continue;
      ((List)localObject1).addAll((Collection)localObject2);
      continue;
      Object localObject1 = a(paramString, paramInt, 15);
      continue;
      MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().remove(a(paramString, paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "MsgPool.getPoolInstance().getAioMsgPool().remove");
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList from aiopool size = " + ((List)localObject1).size());
      }
    }
  }
  
  public List a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = e(paramString, paramInt);
    paramString = new HashSet();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        paramString.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
    }
    long l;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (paramString.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
        }
        return localArrayList;
      }
      paramArrayOfInt = ((List)localObject).iterator();
      l = Long.MAX_VALUE;
      if (paramArrayOfInt.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayOfInt.next();
        if (localMessageRecord.shmsgseq >= l) {
          break label282;
        }
        l = localMessageRecord.shmsgseq;
      }
    }
    label282:
    for (;;)
    {
      break;
      paramArrayOfInt = ((List)localObject).iterator();
      while (paramArrayOfInt.hasNext())
      {
        localObject = (MessageRecord)paramArrayOfInt.next();
        if (((!a(paramInt)) || (((MessageRecord)localObject).versionCode != 3) || (((MessageRecord)localObject).shmsgseq != l) || (l == 0L)) && ((paramString.contains(Integer.valueOf(((MessageRecord)localObject).msgtype))) || (paramString.isEmpty()))) {
          localArrayList.add(localObject);
        }
      }
      return localArrayList;
    }
  }
  
  protected void a() {}
  
  protected void a(SessionInfo paramSessionInfo, String paramString, int paramInt, Set paramSet)
  {
    paramSet.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramSet.add(paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramInt2 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt1, MessageRecord.getTableName(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt1, MessageRecord.getOldTableName(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    if (a(paramInt)) {}
    String str2;
    String str3;
    for (String str1 = "shmsgseq";; str1 = "time")
    {
      str2 = String.valueOf(paramLong);
      str3 = MessageRecord.getTableName(paramString, paramInt);
      if ((!MsgProxyUtils.a(paramInt)) || (MsgProxyUtils.d() == null)) {
        break;
      }
      a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=? and " + MsgProxyUtils.d(), new Object[] { str1 }), new String[] { "0", str2 }, null);
      return;
    }
    a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=?", new Object[] { str1 }), new String[] { "0", str2 }, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong, List paramList)
  {
    int j = 0;
    Object localObject2 = a(paramString, paramInt);
    for (;;)
    {
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        if (!MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().containsKey(localObject2)) {
          break label360;
        }
        localObject2 = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(localObject2);
        i = 0;
        if (i >= ((List)localObject2).size()) {
          break label364;
        }
        Object localObject3 = (MessageRecord)((List)localObject2).get(i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "find cache " + ((MessageRecord)localObject3).getBaseInfoString());
        }
        if (((MessageRecord)localObject3).uniseq != paramLong) {
          break label370;
        }
        if ((i > 0) && (i < ((List)localObject2).size()))
        {
          localObject3 = new ArrayList();
          if (j < i)
          {
            MessageRecord localMessageRecord = (MessageRecord)((List)localObject2).get(j);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "removeList " + localMessageRecord.getBaseInfoString());
            }
            ((List)localObject3).add(localMessageRecord);
            j += 1;
            continue;
          }
          ((List)localObject2).removeAll((Collection)localObject3);
          ((List)localObject3).clear();
          ((List)localObject2).addAll(0, paramList);
          if (((List)localObject2).size() > 40)
          {
            i = ((List)localObject2).size() - 40;
            if (i > 0)
            {
              ((List)localObject2).remove(0);
              i -= 1;
              continue;
            }
          }
        }
        else
        {
          if (i != 0) {
            continue;
          }
          ((List)localObject2).addAll(0, paramList);
        }
      }
      b(paramString, paramInt, (List)localObject2);
      label360:
      return;
      label364:
      int i = 0;
      continue;
      label370:
      i += 1;
    }
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      List localList = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
      if (localList != null)
      {
        MsgProxyUtils.a(localList, paramMessageRecord, true);
        if (localList.size() > 40) {
          localList.remove(0);
        }
        b(paramString, paramInt, localList);
      }
      return;
    }
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener)
  {
    if (paramMessageRecord.versionCode > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), paramMessageRecord, 0, paramProxyListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((MsgProxyUtils.m(paramMessageRecord.msgtype)) && (!MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {}
    while (!paramBoolean2) {
      return;
    }
    if (paramBoolean1)
    {
      a(paramString, paramInt, paramMessageRecord, paramProxyListener);
      return;
    }
    a(paramString, paramInt, paramMessageRecord, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "insertToList " + paramMessageRecord.getBaseInfoString());
    }
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = d(paramString, paramInt);
        Object localObject2 = a(paramString, paramInt);
        MsgProxyUtils.a((List)localObject1, paramMessageRecord, true);
        if ((((List)localObject1).size() > 40) && (!MsgProxyUtils.a(paramString))) {
          ((List)localObject1).remove(0);
        }
        if ((MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(localObject2)) && (paramBoolean))
        {
          localObject2 = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(localObject2);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ArrayList();
          }
          if (!paramString.equals(AppConstants.aq)) {
            break;
          }
          ((List)localObject1).add(0, paramMessageRecord);
        }
        return;
        QLog.d("Q.msg.MsgProxy", 1, "insertToList " + paramMessageRecord.getUserLogString());
      }
      ((List)localObject1).add(paramMessageRecord);
    }
  }
  
  protected void a(String paramString, int paramInt, Entity paramEntity, ProxyListener paramProxyListener)
  {
    if (((paramEntity instanceof MessageRecord)) && (((MessageRecord)paramEntity).versionCode > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), paramEntity, 0, paramProxyListener);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    List localList;
    ArrayList localArrayList;
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString1, paramInt))
    {
      localList = d(paramString1, paramInt);
      localArrayList = new ArrayList();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((localMessageRecord.senderuin != null) && (localMessageRecord.selfuin != null) && (localMessageRecord.senderuin.equals(paramString2)) && (localMessageRecord.selfuin.equals(paramString3))) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    localList.removeAll(localArrayList);
    localArrayList.clear();
    a(paramString1, paramInt, MessageRecord.getTableName(paramString1, paramInt), "senderuin=? and selfuin=?", new String[] { paramString2, paramString3 }, null);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramString3, paramArrayOfString, 2, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, List paramList)
  {
    label217:
    label221:
    for (;;)
    {
      Object localObject1;
      List localList;
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        if (!MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(a(paramString, paramInt))) {
          break label217;
        }
        localObject1 = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt));
        if (localObject1 != null) {
          break label221;
        }
        localObject1 = new ArrayList();
        localList = MsgProxyUtils.a((List)localObject1, paramList);
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          Object localObject3 = (MessageRecord)localIterator.next();
          if (!(localObject3 instanceof MessageForPoke)) {
            continue;
          }
          localObject3 = (MessageForPoke)localObject3;
          if (((MessageForPoke)localObject3).isPlayed) {
            continue;
          }
          ((MessageForPoke)localObject3).setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      if (PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString)) {
        BaseMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList, localList, true, false);
      }
      ((List)localObject1).addAll(0, localList);
      paramList.clear();
      paramList.addAll(localList);
      return;
    }
  }
  
  public void a(List paramList, ProxyListener paramProxyListener)
  {
    b(MsgProxyUtils.a(paramList), paramProxyListener);
  }
  
  protected boolean a(int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    if (a(paramInt)) {
      if (paramLong < paramMessageRecord.shmsgseq) {}
    }
    while (paramLong >= paramMessageRecord.time)
    {
      return true;
      return false;
    }
    return false;
  }
  
  boolean a(String paramString, int paramInt)
  {
    return (paramString.length() >= 6) && ((paramInt == 0) || (a(paramInt)));
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a())
      {
        Vector localVector2 = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
        i = 0;
        if (i < localVector2.size())
        {
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localVector2.get(i);
          if ((MsgProxyUtils.a(localMsgQueueItem.jdField_a_of_type_JavaLangString, paramString, localMsgQueueItem.h, paramInt)) && ((localMsgQueueItem.i == 1) || (localMsgQueueItem.i == 2) || ((paramBoolean) && (localMsgQueueItem.i == 0))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, new Object[] { "needTransSaveToDatabase uin=", paramString, ", type=", LargerInteger.valueOf(paramInt), ", hasInsertAction=", Boolean.valueOf(paramBoolean), ",result=true" });
            }
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      i += 1;
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a())
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().iterator();
      while (localIterator.hasNext())
      {
        MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
        if (TextUtils.isEmpty(localMsgQueueItem.b)) {
          return true;
        }
        if ((paramString.equals(localMsgQueueItem.b)) && ((localMsgQueueItem.i == 1) || (localMsgQueueItem.i == 2) || ((paramBoolean) && (localMsgQueueItem.i == 0))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, new Object[] { "needTransSaveToDatabase tableName=", paramString, ", hasInsertAction=", Boolean.valueOf(paramBoolean), ",result=true" });
          }
          return true;
        }
      }
      return false;
    }
  }
  
  protected int b(String paramString, int paramInt, long paramLong)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a())
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().iterator();
        if (localIterator.hasNext())
        {
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
          if ((localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof MessageRecord))
          {
            MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
            if ((MsgProxyUtils.a(localMessageRecord.frienduin, paramString, localMessageRecord.istroop, paramInt)) && (localMsgQueueItem.i == 0) && (localMessageRecord.time > paramLong) && (!localMessageRecord.isread) && (!localMessageRecord.isSend())) {
              i += 1;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getUnreadCountFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt), ", lastRead=", Integer.valueOf(i) });
          }
          return i;
        }
      }
    }
  }
  
  @Deprecated
  public Cursor b(String paramString, int paramInt)
  {
    return a(a(b(paramString, paramInt)));
  }
  
  protected MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0))
    {
      localObject2 = null;
      return (MessageRecord)localObject2;
    }
    Object localObject1 = c(paramString, paramInt);
    if (localObject1 != null)
    {
      localObject2 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MessageRecord)((Iterator)localObject2).next();
      } while (((MessageRecord)localObject1).uniseq != paramLong);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      paramString = c(paramString, paramInt, paramLong);
      localObject2 = localObject1;
      if (paramString == null) {
        break;
      }
      localObject2 = localObject1;
      if (paramString.isEmpty()) {
        break;
      }
      return (MessageRecord)paramString.get(0);
      localObject1 = null;
    }
  }
  
  protected MessageRecord b(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLastMsgForMessageTabFromDB, peerUin = " + paramString1 + ", type " + paramInt);
    }
    if (a(paramString1, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    if (a(paramInt))
    {
      localStringBuilder = new StringBuilder().append("select * from ").append(MessageRecord.getTableName(paramString1, paramInt)).append(" where isValid=1 and msgtype ").append(MsgProxyUtils.a()).append(" ");
      if (paramString2 != null) {}
      for (paramString1 = "and " + paramString2;; paramString1 = "")
      {
        paramString1 = paramString1 + " order by shmsgseq desc , _id desc limit 1";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "queryLastTABSupportMessageFromDB : sqlStr:" + paramString1);
        }
        paramString1 = a().a(paramString1, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((paramString1 != null) && (paramString1.size() >= 1)) {
          break;
        }
        return null;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("select * from ").append(MessageRecord.getTableName(paramString1, paramInt)).append(" where isValid=1 and msgtype ").append(MsgProxyUtils.a()).append(" ");
    if (paramString2 != null) {}
    for (paramString1 = "and " + paramString2;; paramString1 = "")
    {
      paramString1 = paramString1 + " order by time desc , _id desc limit 1";
      break;
    }
    return (MessageRecord)paramString1.get(0);
  }
  
  protected String b(String paramString, int paramInt)
  {
    if (MsgProxyUtils.a(paramString)) {
      return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " order by time desc , _id desc";
    }
    if (MsgProxyUtils.c(paramInt)) {
      return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where _id in (select _id from " + MessageRecord.getTableName(paramString, paramInt) + " order by time desc limit " + 40 + ")" + " order by time desc, _id desc";
    }
    return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " order by _id desc limit " + 40;
  }
  
  public List b(String paramString, int paramInt)
  {
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      paramString = d(paramString, paramInt);
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  protected List b(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = String.format("select * from " + MessageRecord.getTableName(paramString, paramInt1) + " where isValid=1 and msgtype != ? order by shmsgseq desc , _id desc limit ?", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: sql=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    MessageRecordEntityManager localMessageRecordEntityManager = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = localMessageRecordEntityManager.a((String)localObject, new String[] { String.valueOf(63530), String.valueOf(paramInt2) }, localQQAppInterface);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return (List)localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  protected List b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUidFromDB, peerUin[" + FileManagerUtil.e(paramString) + "] type[" + paramInt + "] msgUid[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUidFromDB Warning! msgUid==0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where msguid=?";
    MessageRecordEntityManager localMessageRecordEntityManager = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = localMessageRecordEntityManager.a(paramString, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  protected List b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = "select * from " + MessageRecord.getTableName(paramString1, paramInt1) + " where shmsgseq<=? and shmsgseq>? %s order by shmsgseq asc";
    long l;
    if (paramString2 == null)
    {
      paramString2 = "";
      paramString2 = String.format((String)localObject, new Object[] { paramString2 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      if (paramInt2 > 0) {
        break label274;
      }
      l = 0L;
    }
    for (;;)
    {
      localObject = a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramString2 = ((MessageRecordEntityManager)localObject).a(paramString2, new String[] { String.valueOf(paramLong), String.valueOf(l) }, localQQAppInterface);
      if (paramString2 == null) {
        break label298;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      paramString2 = "and " + paramString2;
      break;
      label274:
      if (paramLong > paramInt2) {
        l = paramLong - paramInt2;
      } else {
        l = 0L;
      }
    }
    label298:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public List b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq, peerUin = " + paramString + ", type " + paramInt + ",beginSeq = " + paramLong1 + ",endSeq = " + paramLong2);
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + paramString);
    }
    Object localObject = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((MessageRecordEntityManager)localObject).a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, localQQAppInterface);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  protected List b(String paramString, int paramInt, List paramList)
  {
    int j = 0;
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("queryMessagesByMsgUniseqFromDB, peerUin[").append(FileManagerUtil.e(paramString)).append("] type[").append(paramInt).append("] uniseqList[");
      if (paramList == null)
      {
        i = 0;
        QLog.d("Q.msg.MsgProxy", 2, i + "]");
      }
    }
    else
    {
      if ((paramList != null) && (paramList.size() != 0)) {
        break label125;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
      }
      paramString = new ArrayList();
    }
    label125:
    do
    {
      return paramString;
      i = paramList.size();
      break;
      if (a(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      localObject = new String[paramList.size()];
      StringBuilder localStringBuilder = new StringBuilder("(");
      i = j;
      while (i < paramList.size())
      {
        localObject[i] = String.valueOf(((Long)paramList.get(i)).longValue());
        localStringBuilder.append("?");
        if (i < paramList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append(")");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, uniseq list=" + localStringBuilder.toString());
      }
      paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where uniseq in " + localStringBuilder.toString();
      paramList = a().a(paramString, (String[])localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = paramList;
    } while (paramList != null);
    return new ArrayList();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a();
    }
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2;
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      localObject2 = d(paramString, paramInt);
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        return;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if ((!localMessageRecord.isread) && (a(paramInt, paramLong, localMessageRecord)) && ((!MsgProxyUtils.a(paramInt)) || (!MsgProxyUtils.l(localMessageRecord.msgtype)))) {
          localMessageRecord.isread = true;
        }
      }
    }
    paramString = f(paramString, paramInt);
    if ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (MessageRecord)paramString.next();
      if ((!((MessageRecord)localObject2).isread) && (a(paramInt, paramLong, (MessageRecord)localObject2)) && ((!MsgProxyUtils.a(paramInt)) || (!MsgProxyUtils.l(((MessageRecord)localObject2).msgtype)))) {
        ((MessageRecord)localObject2).isread = true;
      }
    }
  }
  
  protected void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramString, paramInt);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    String str;
    if ((paramInt == 1001) && (paramMessageRecord.msgtype != 64533) && (paramMessageRecord.msgtype != 64505) && (paramMessageRecord.msgtype != 64504) && (paramMessageRecord.msgtype != 201)) {
      if (paramMessageRecord.versionCode > 0)
      {
        str = MessageRecord.getTableName(String.valueOf(AppConstants.ar), 1001);
        a(paramString, paramInt, str, localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      }
    }
    for (;;)
    {
      a(paramString, paramInt, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
      return;
      str = MessageRecord.getOldTableName(String.valueOf(AppConstants.ar), 1001);
      break;
      if (paramInt == 1009) {
        a(paramString, paramInt, MessageRecord.getTableName(AppConstants.ag, 1009), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      } else if (paramInt == 1010) {
        a(paramString, paramInt, MessageRecord.getTableName(AppConstants.aH, 1010), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      } else if ((paramInt == 0) && (TextUtils.equals(paramString, AppConstants.av))) {
        a(paramString, paramInt, MessageRecord.getTableName(AppConstants.av, 0), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      }
    }
  }
  
  protected int c(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = d(paramString, paramInt, paramLong);
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("--->removeSingleMsg : peerUin:").append(paramString).append(" type:").append(paramInt).append(" uniseq:").append(paramLong).append(" mr:").append(localMessageRecord).append(" dbid:");
      if (localMessageRecord != null)
      {
        localObject = Long.valueOf(localMessageRecord.getId());
        QLog.d("Q.msg.MsgProxy", 2, localObject);
      }
    }
    else
    {
      if (localMessageRecord == null) {
        break label213;
      }
      long l = localMessageRecord.getId();
      if (l == -1L) {
        break label182;
      }
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      b(localMessageRecord.frienduin, localMessageRecord.istroop);
      if (!localMessageRecord.isread) {
        break label211;
      }
      return 1;
      localObject = "mr is null.";
      break;
      label182:
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    }
    label211:
    return 2;
    label213:
    a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return 1;
  }
  
  protected MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.shmsgseq == paramLong) && (!MsgProxyUtils.a(localMessageRecord))) {
          return localMessageRecord;
        }
      }
    }
    return f(paramString, paramInt, paramLong);
  }
  
  protected List c(String paramString, int paramInt)
  {
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      paramString = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  protected List c(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, peerUin[" + FileManagerUtil.e(paramString) + "] type[" + paramInt + "] uniseq[" + paramLong + "]");
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
      }
      paramString = new ArrayList();
    }
    Object localObject;
    do
    {
      return paramString;
      if (a(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where uniseq=?";
      localObject = a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = ((MessageRecordEntityManager)localObject).a(paramString, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
      paramString = (String)localObject;
    } while (localObject != null);
    return new ArrayList();
  }
  
  public List c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromSeqRange, peerUin = " + paramString + ", type " + paramInt + ",beginSeq = " + paramLong1 + ",endSeq = " + paramLong2);
    }
    Object localObject1 = b(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).shmsgseq >= paramLong1) && (((MessageRecord)localObject2).shmsgseq <= paramLong2)) {
          localArrayList.add(localObject2);
        }
      }
    }
    if ((localArrayList.size() > 0) && (((MessageRecord)localArrayList.get(0)).shmsgseq == paramLong1)) {
      return localArrayList;
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    localObject1 = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + (String)localObject1);
    }
    if (localArrayList.size() > 0) {
      paramLong2 = ((MessageRecord)localArrayList.get(0)).shmsgseq;
    }
    paramLong1 = Math.min(paramLong1, paramLong2);
    if (localArrayList != null)
    {
      localObject2 = localArrayList.iterator();
      do
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label379;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if (((MessageRecord)localObject3).shmsgseq != paramLong2) {
            break;
          }
          ((Iterator)localObject2).remove();
        }
      } while (((MessageRecord)localObject3).shmsgseq <= paramLong2);
    }
    label379:
    Object localObject2 = a();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject1 = ((MessageRecordEntityManager)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, (QQAppInterface)localObject3);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessageFromTimeRange, peerUin = ").append(paramString).append(", type ").append(paramInt).append(",queryBeginSeq = ").append(paramLong1).append(",queryEndSeq = ").append(paramLong2).append(",resultSize=");
      if (localObject1 != null) {
        break label522;
      }
    }
    label522:
    for (paramInt = 0;; paramInt = ((List)localObject1).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject1 != null) {
        localArrayList.addAll(0, (Collection)localObject1);
      }
      return localArrayList;
    }
  }
  
  /* Error */
  protected List c(String paramString, int paramInt, List paramList)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 4
    //   3: aload_3
    //   4: invokeinterface 62 1 0
    //   9: bipush 50
    //   11: if_icmple +14 -> 25
    //   14: aload_3
    //   15: iconst_0
    //   16: bipush 50
    //   18: invokeinterface 987 3 0
    //   23: astore 4
    //   25: aload_1
    //   26: iload_2
    //   27: invokestatic 337	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   30: astore_1
    //   31: iconst_1
    //   32: anewarray 139	java/lang/String
    //   35: astore_3
    //   36: new 84	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 85	java/util/ArrayList:<init>	()V
    //   43: astore 5
    //   45: aload 4
    //   47: invokeinterface 93 1 0
    //   52: astore 6
    //   54: aload 6
    //   56: invokeinterface 99 1 0
    //   61: ifeq +110 -> 171
    //   64: aload_3
    //   65: iconst_0
    //   66: aload 6
    //   68: invokeinterface 103 1 0
    //   73: checkcast 170	java/lang/Integer
    //   76: invokevirtual 1411	java/lang/Integer:intValue	()I
    //   79: invokestatic 389	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   82: aastore
    //   83: aload_0
    //   84: invokevirtual 181	com/tencent/mobileqq/app/message/MsgProxy:a	()Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   87: iconst_0
    //   88: aload_1
    //   89: aconst_null
    //   90: ldc_w 1413
    //   93: aload_3
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: invokevirtual 513	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore 4
    //   103: aload 5
    //   105: aload_0
    //   106: invokevirtual 181	com/tencent/mobileqq/app/message/MsgProxy:a	()Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   109: ldc 105
    //   111: aconst_null
    //   112: aload 4
    //   114: invokevirtual 697	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/mobileqq/persistence/Entity;
    //   117: checkcast 105	com/tencent/mobileqq/data/MessageRecord
    //   120: invokevirtual 698	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: aload 4
    //   126: ifnull -72 -> 54
    //   129: aload 4
    //   131: invokeinterface 521 1 0
    //   136: goto -82 -> 54
    //   139: astore 7
    //   141: aload 4
    //   143: ifnull -89 -> 54
    //   146: aload 4
    //   148: invokeinterface 521 1 0
    //   153: goto -99 -> 54
    //   156: astore_1
    //   157: aload 4
    //   159: ifnull +10 -> 169
    //   162: aload 4
    //   164: invokeinterface 521 1 0
    //   169: aload_1
    //   170: athrow
    //   171: aload 5
    //   173: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	MsgProxy
    //   0	174	1	paramString	String
    //   0	174	2	paramInt	int
    //   0	174	3	paramList	List
    //   1	162	4	localObject	Object
    //   43	129	5	localArrayList	ArrayList
    //   52	15	6	localIterator	Iterator
    //   139	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   103	124	139	java/lang/Exception
    //   103	124	156	finally
  }
  
  protected void c()
  {
    try
    {
      MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().clear();
      ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124)).d = null;
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "delAIOMsg ");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void c(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.uniseq != 0L)) {}
    do
    {
      return;
      if (paramMessageRecord.getId() > 0L)
      {
        paramMessageRecord.createMessageUniseq();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("uniseq", Long.valueOf(paramMessageRecord.uniseq));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "updateUniseqByID: set msg =" + paramMessageRecord.getBaseInfoString());
        }
        a(paramString, paramInt, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.MsgProxy", 2, "updateUniseqByID ERROR: _id<0 !");
  }
  
  protected MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt);
    List localList = null;
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject3 = d(paramString, paramInt);
        localObject1 = localList;
        if (localObject3 != null)
        {
          Iterator localIterator = ((List)localObject3).iterator();
          localObject1 = localList;
          if (localIterator.hasNext())
          {
            localObject1 = (MessageRecord)localIterator.next();
            if (((MessageRecord)localObject1).uniseq != paramLong) {
              continue;
            }
            ((List)localObject3).remove(localObject1);
          }
        }
        localList = f(paramString, paramInt);
        if (localList != null)
        {
          localObject3 = localList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramString = (MessageRecord)((Iterator)localObject3).next();
            if (paramString.uniseq != paramLong) {
              continue;
            }
            localList.remove(paramString);
            return paramString;
          }
        }
      }
      finally {}
      paramString = (String)localObject1;
    }
  }
  
  protected List d(String paramString, int paramInt)
  {
    for (boolean bool = true;; bool = false) {
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        Object localObject2 = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          long l = System.nanoTime();
          localObject1 = g(paramString, paramInt);
          b(paramString, paramInt, (List)localObject1);
          if (StartupTracker.a())
          {
            if (MessageCache.a == null) {
              MessageCache.a = new MessageCache.MsgCacheStrategyParam();
            }
            MessageCache.a.jdField_a_of_type_JavaLangString = paramString;
            MessageCache.a.jdField_a_of_type_Boolean = false;
            localObject2 = MessageCache.a;
            if (((List)localObject1).isEmpty()) {
              continue;
            }
            ((MessageCache.MsgCacheStrategyParam)localObject2).b = bool;
            MessageCache.a.jdField_a_of_type_Long = ((System.nanoTime() - l) / 1000000L);
          }
        }
        else
        {
          if ((localObject1 != null) && (QLog.isColorLevel())) {
            QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgList uin ", paramString, " , type = ", Integer.valueOf(paramInt), " itemList size=", Integer.valueOf(((List)localObject1).size()) });
          }
          return (List)localObject1;
        }
        MessageCache.a = null;
      }
    }
  }
  
  public List d(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange, peerUin = " + paramString + ", type " + paramInt + ",beginTime = " + paramLong1 + ",endTime = " + paramLong2);
    }
    Object localObject1 = b(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).time >= paramLong1) && (((MessageRecord)localObject2).time <= paramLong2)) {
          localArrayList.add(localObject2);
        }
      }
    }
    if ((localArrayList.size() > 0) && (((MessageRecord)localArrayList.get(0)).time == paramLong1)) {
      return localArrayList;
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    localObject1 = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where time>=? and time<=? order by time asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange " + (String)localObject1);
    }
    if (localArrayList.size() > 0) {
      paramLong2 = ((MessageRecord)localArrayList.get(0)).time;
    }
    paramLong1 = Math.min(paramLong1, paramLong2);
    if (localArrayList != null)
    {
      localObject2 = localArrayList.iterator();
      do
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label379;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if (((MessageRecord)localObject3).time != paramLong2) {
            break;
          }
          ((Iterator)localObject2).remove();
        }
      } while (((MessageRecord)localObject3).time <= paramLong2);
    }
    label379:
    Object localObject2 = a();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject1 = ((MessageRecordEntityManager)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, (QQAppInterface)localObject3);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessageFromTimeRange, peerUin = ").append(paramString).append(", type ").append(paramInt).append(",queryBeginTime = ").append(paramLong1).append(",queryEndTime = ").append(paramLong2).append(",resultSize=");
      if (localObject1 != null) {
        break label522;
      }
    }
    label522:
    for (paramInt = 0;; paramInt = ((List)localObject1).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject1 != null) {
        localArrayList.addAll(0, (Collection)localObject1);
      }
      return localArrayList;
    }
  }
  
  protected void d()
  {
    MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().clear();
    MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().clear();
  }
  
  protected MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    for (;;)
    {
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        List localList = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            paramString = (MessageRecord)localIterator.next();
            if (paramString.uniseq != paramLong) {
              continue;
            }
            localList.remove(paramString);
            return paramString;
          }
        }
      }
      paramString = null;
    }
  }
  
  public List e(String paramString, int paramInt)
  {
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      paramString = f(paramString, paramInt);
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  protected List e(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + FileManagerUtil.e(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong1 + "] msgUid[" + paramLong2 + "]");
    }
    if (((paramLong1 == 0L) || (paramLong2 == 0L)) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=? and msgUid=?";
    MessageRecordEntityManager localMessageRecordEntityManager = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = localMessageRecordEntityManager.a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, localQQAppInterface);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  /* Error */
  protected void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 130	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager	Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   4: invokevirtual 341	com/tencent/mobileqq/app/proxy/ProxyManager:c	()V
    //   7: aload_0
    //   8: getfield 130	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager	Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   11: invokevirtual 1481	com/tencent/mobileqq/app/proxy/ProxyManager:d	()V
    //   14: aload_0
    //   15: invokevirtual 181	com/tencent/mobileqq/app/message/MsgProxy:a	()Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   18: invokevirtual 1484	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 38	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 1486	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   30: astore 6
    //   32: aload 6
    //   34: invokevirtual 1491	com/tencent/mobileqq/app/SQLiteDatabase:b	()[Ljava/lang/String;
    //   37: astore 7
    //   39: aload 7
    //   41: ifnonnull +4 -> 45
    //   44: return
    //   45: aconst_null
    //   46: astore_1
    //   47: iconst_0
    //   48: istore 10
    //   50: iload 10
    //   52: aload 7
    //   54: arraylength
    //   55: if_icmpge -11 -> 44
    //   58: aload 7
    //   60: iload 10
    //   62: aaload
    //   63: astore 8
    //   65: aconst_null
    //   66: astore_2
    //   67: aload 8
    //   69: ldc_w 1493
    //   72: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   75: ifeq +42 -> 117
    //   78: new 152	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 1495
    //   88: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 8
    //   93: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc_w 1497
    //   99: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 8
    //   104: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 550
    //   110: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_2
    //   117: aload_1
    //   118: astore_3
    //   119: aload_2
    //   120: ifnull +384 -> 504
    //   123: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +30 -> 156
    //   129: ldc_w 353
    //   132: iconst_2
    //   133: new 152	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 1499
    //   143: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_2
    //   147: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aconst_null
    //   157: astore_3
    //   158: aload 6
    //   160: aload_2
    //   161: aconst_null
    //   162: invokevirtual 1502	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   165: astore_2
    //   166: aload_1
    //   167: astore 4
    //   169: aload_2
    //   170: ifnull +253 -> 423
    //   173: aload_1
    //   174: astore 4
    //   176: aload_2
    //   177: astore_3
    //   178: aload_2
    //   179: invokeinterface 518 1 0
    //   184: ifle +239 -> 423
    //   187: aload_2
    //   188: astore_3
    //   189: aload_2
    //   190: invokeinterface 672 1 0
    //   195: pop
    //   196: aload_2
    //   197: astore_3
    //   198: aload_2
    //   199: aload_2
    //   200: ldc_w 1504
    //   203: invokeinterface 1507 2 0
    //   208: invokeinterface 1511 2 0
    //   213: lstore 15
    //   215: aload_2
    //   216: astore_3
    //   217: aload_2
    //   218: aload_2
    //   219: ldc_w 1512
    //   222: invokeinterface 1507 2 0
    //   227: invokeinterface 925 2 0
    //   232: astore 9
    //   234: aload_2
    //   235: astore_3
    //   236: aload_2
    //   237: aload_2
    //   238: ldc_w 1513
    //   241: invokeinterface 1507 2 0
    //   246: invokeinterface 707 2 0
    //   251: istore 11
    //   253: aload_2
    //   254: astore_3
    //   255: aload_2
    //   256: aload_2
    //   257: ldc_w 926
    //   260: invokeinterface 1507 2 0
    //   265: invokeinterface 707 2 0
    //   270: istore 12
    //   272: lload 15
    //   274: lstore 13
    //   276: aload_2
    //   277: astore_3
    //   278: iload 11
    //   280: invokestatic 473	com/tencent/mobileqq/app/message/MsgProxy:a	(I)Z
    //   283: ifne +21 -> 304
    //   286: lload 15
    //   288: lstore 13
    //   290: iload 12
    //   292: iconst_1
    //   293: if_icmpne +11 -> 304
    //   296: lload 15
    //   298: ldc2_w 1514
    //   301: ladd
    //   302: lstore 13
    //   304: aload_2
    //   305: astore_3
    //   306: aload_0
    //   307: getfield 38	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   310: invokevirtual 1131	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   313: aload 9
    //   315: iload 11
    //   317: lload 13
    //   319: invokevirtual 1517	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;IJ)V
    //   322: aload_1
    //   323: astore 4
    //   325: aload_2
    //   326: astore_3
    //   327: getstatic 1520	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_Boolean	Z
    //   330: ifeq +93 -> 423
    //   333: aload_1
    //   334: astore 4
    //   336: aload_2
    //   337: astore_3
    //   338: aload_0
    //   339: getfield 38	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   342: invokestatic 1525	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   345: ifeq +78 -> 423
    //   348: aload_1
    //   349: astore 4
    //   351: aload_2
    //   352: astore_3
    //   353: aload_0
    //   354: getfield 38	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   357: invokestatic 1527	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   360: ifeq +63 -> 423
    //   363: aload_2
    //   364: astore_3
    //   365: new 1529	com/tencent/mobileqq/data/fts/FTSMessage
    //   368: dup
    //   369: invokespecial 1530	com/tencent/mobileqq/data/fts/FTSMessage:<init>	()V
    //   372: astore 4
    //   374: aload_2
    //   375: astore_3
    //   376: aload 4
    //   378: iconst_1
    //   379: putfield 1533	com/tencent/mobileqq/data/fts/FTSMessage:mType	I
    //   382: aload_2
    //   383: astore_3
    //   384: aload 4
    //   386: ldc_w 1535
    //   389: putfield 1538	com/tencent/mobileqq/data/fts/FTSMessage:mContent	Ljava/lang/String;
    //   392: aload_2
    //   393: astore_3
    //   394: aload 4
    //   396: ldc2_w 1539
    //   399: putfield 1543	com/tencent/mobileqq/data/fts/FTSMessage:mOId	J
    //   402: aload_2
    //   403: astore_3
    //   404: aload 4
    //   406: aload 9
    //   408: invokestatic 1547	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   411: putfield 1550	com/tencent/mobileqq/data/fts/FTSMessage:uin	J
    //   414: aload_2
    //   415: astore_3
    //   416: aload 4
    //   418: iload 11
    //   420: putfield 1551	com/tencent/mobileqq/data/fts/FTSMessage:istroop	I
    //   423: aload 4
    //   425: astore_1
    //   426: aload_2
    //   427: ifnull +12 -> 439
    //   430: aload_2
    //   431: invokeinterface 521 1 0
    //   436: aload 4
    //   438: astore_1
    //   439: aload 5
    //   441: ifnull +8 -> 449
    //   444: aload 5
    //   446: invokevirtual 1554	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   449: aload 6
    //   451: aload 8
    //   453: aconst_null
    //   454: aconst_null
    //   455: invokevirtual 1557	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   458: pop
    //   459: aload_1
    //   460: ifnull +20 -> 480
    //   463: aload_1
    //   464: invokevirtual 1560	com/tencent/mobileqq/data/fts/FTSMessage:deleteOpt	()V
    //   467: aload_1
    //   468: invokestatic 1565	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/fts/FTSMessage;)Lcom/tencent/mobileqq/data/FTSMessageSync;
    //   471: astore_2
    //   472: aload_0
    //   473: invokevirtual 181	com/tencent/mobileqq/app/message/MsgProxy:a	()Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   476: aload_2
    //   477: invokevirtual 1568	com/tencent/mobileqq/persistence/MessageRecordEntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   480: aload 5
    //   482: ifnull +8 -> 490
    //   485: aload 5
    //   487: invokevirtual 1569	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   490: aload_1
    //   491: astore_3
    //   492: aload 5
    //   494: ifnull +10 -> 504
    //   497: aload 5
    //   499: invokevirtual 1571	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   502: aload_1
    //   503: astore_3
    //   504: iload 10
    //   506: iconst_1
    //   507: iadd
    //   508: istore 10
    //   510: aload_3
    //   511: astore_1
    //   512: goto -462 -> 50
    //   515: astore_3
    //   516: aload 4
    //   518: astore_1
    //   519: aload_3
    //   520: invokevirtual 704	java/lang/Exception:printStackTrace	()V
    //   523: aload_2
    //   524: ifnull +92 -> 616
    //   527: aload_2
    //   528: invokeinterface 521 1 0
    //   533: goto -94 -> 439
    //   536: astore_1
    //   537: aload_3
    //   538: ifnull +9 -> 547
    //   541: aload_3
    //   542: invokeinterface 521 1 0
    //   547: aload_1
    //   548: athrow
    //   549: astore_2
    //   550: aload_2
    //   551: invokevirtual 704	java/lang/Exception:printStackTrace	()V
    //   554: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +13 -> 570
    //   560: ldc 10
    //   562: iconst_2
    //   563: ldc_w 1573
    //   566: aload_2
    //   567: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   570: aload_1
    //   571: astore_3
    //   572: aload 5
    //   574: ifnull -70 -> 504
    //   577: aload 5
    //   579: invokevirtual 1571	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   582: aload_1
    //   583: astore_3
    //   584: goto -80 -> 504
    //   587: astore_1
    //   588: aload 5
    //   590: ifnull +8 -> 598
    //   593: aload 5
    //   595: invokevirtual 1571	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   598: aload_1
    //   599: athrow
    //   600: astore_1
    //   601: aload_2
    //   602: astore_3
    //   603: goto -66 -> 537
    //   606: astore_3
    //   607: aconst_null
    //   608: astore_2
    //   609: goto -90 -> 519
    //   612: astore_3
    //   613: goto -94 -> 519
    //   616: goto -177 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	MsgProxy
    //   46	473	1	localObject1	Object
    //   536	47	1	localObject2	Object
    //   587	12	1	localObject3	Object
    //   600	1	1	localObject4	Object
    //   66	462	2	localObject5	Object
    //   549	53	2	localException1	Exception
    //   608	1	2	localObject6	Object
    //   118	393	3	localObject7	Object
    //   515	27	3	localException2	Exception
    //   571	32	3	localObject8	Object
    //   606	1	3	localException3	Exception
    //   612	1	3	localException4	Exception
    //   167	350	4	localObject9	Object
    //   21	573	5	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   30	420	6	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   37	22	7	arrayOfString	String[]
    //   63	389	8	str1	String
    //   232	175	9	str2	String
    //   48	461	10	i	int
    //   251	168	11	j	int
    //   270	24	12	k	int
    //   274	44	13	l1	long
    //   213	84	15	l2	long
    // Exception table:
    //   from	to	target	type
    //   376	382	515	java/lang/Exception
    //   384	392	515	java/lang/Exception
    //   394	402	515	java/lang/Exception
    //   404	414	515	java/lang/Exception
    //   416	423	515	java/lang/Exception
    //   158	166	536	finally
    //   178	187	536	finally
    //   189	196	536	finally
    //   198	215	536	finally
    //   217	234	536	finally
    //   236	253	536	finally
    //   255	272	536	finally
    //   278	286	536	finally
    //   306	322	536	finally
    //   327	333	536	finally
    //   338	348	536	finally
    //   353	363	536	finally
    //   365	374	536	finally
    //   376	382	536	finally
    //   384	392	536	finally
    //   394	402	536	finally
    //   404	414	536	finally
    //   416	423	536	finally
    //   444	449	549	java/lang/Exception
    //   449	459	549	java/lang/Exception
    //   463	480	549	java/lang/Exception
    //   485	490	549	java/lang/Exception
    //   444	449	587	finally
    //   449	459	587	finally
    //   463	480	587	finally
    //   485	490	587	finally
    //   550	570	587	finally
    //   519	523	600	finally
    //   158	166	606	java/lang/Exception
    //   178	187	612	java/lang/Exception
    //   189	196	612	java/lang/Exception
    //   198	215	612	java/lang/Exception
    //   217	234	612	java/lang/Exception
    //   236	253	612	java/lang/Exception
    //   255	272	612	java/lang/Exception
    //   278	286	612	java/lang/Exception
    //   306	322	612	java/lang/Exception
    //   327	333	612	java/lang/Exception
    //   338	348	612	java/lang/Exception
    //   353	363	612	java/lang/Exception
    //   365	374	612	java/lang/Exception
  }
  
  protected MessageRecord f(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop, peerUin[" + FileManagerUtil.e(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop Warning! shmsgseq == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=? and msgtype " + MsgProxyUtils.c();
    MessageRecordEntityManager localMessageRecordEntityManager = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = localMessageRecordEntityManager.a(paramString, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
    if ((paramString != null) && (paramString.size() > 0)) {
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
  
  protected List f(String paramString, int paramInt)
  {
    return a(paramString, paramInt, false, false);
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager);
    }
  }
  
  List g(String paramString, int paramInt)
  {
    Object localObject1;
    long l;
    String str;
    boolean bool;
    synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      localObject1 = (List)MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "init from cache, uin=" + paramString);
        }
        return (List)localObject1;
      }
      l = System.currentTimeMillis();
      str = b(paramString, paramInt);
      bool = a(paramString, paramInt, false);
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
      }
      List localList = h(paramString, paramInt);
      System.nanoTime();
      Object localObject2 = a().a(str, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject2 != null)
      {
        int j = ((List)localObject2).size() / 2;
        paramInt = ((List)localObject2).size();
        int i = 0;
        paramInt -= 1;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject1 = (MessageRecord)((List)localObject2).get(i);
          ((List)localObject2).set(i, ((List)localObject2).get(paramInt));
          ((List)localObject2).set(paramInt, localObject1);
          i += 1;
          paramInt -= 1;
        }
      }
      localObject1 = new ArrayList();
      localObject2 = MsgProxyUtils.a((List)localObject1, localList).iterator();
      if (((Iterator)localObject2).hasNext()) {
        MsgProxyUtils.a((List)localObject1, (MessageRecord)((Iterator)localObject2).next(), true);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "init from db, uin=", paramString, ", isSaveToDatabase=", Boolean.valueOf(bool), ", cost=", Long.valueOf(System.currentTimeMillis() - l), " sqlStr = ", str, " size =", Integer.valueOf(((List)localObject1).size()) });
    }
    return (List)localObject1;
  }
  
  protected List h(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
      localArrayList = new ArrayList();
      localObject = ((Vector)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgQueueItem localMsgQueueItem = (MsgQueueItem)((Iterator)localObject).next();
        if ((localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof MessageRecord))
        {
          MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
          if ((MsgProxyUtils.a(localMessageRecord.frienduin, paramString, localMessageRecord.istroop, paramInt)) && (localMsgQueueItem.i == 0)) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt), ", size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\MsgProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */