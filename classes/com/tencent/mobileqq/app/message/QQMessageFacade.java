package com.tencent.mobileqq.app.message;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import qmd;
import qme;
import qmf;
import qmg;
import qmh;
import qmi;

public class QQMessageFacade
  extends Observable
  implements Manager
{
  public static final int a = 1;
  public static final String a = "dataline_manager_ipad";
  public static final boolean a = true;
  public static final int b = 2;
  public static final String b = "dataline_manager_pc";
  public static final int c = 3;
  public static final String c = "notification";
  public static final int d = 4;
  public static final int e = 2;
  private static final String jdField_e_of_type_JavaLangString = "table_last_clip_time";
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  private static final int m = 5000;
  private static final int n = 90;
  private static final int o = 8;
  public Handler a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseMessageManager jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private QQMessageFacade.Message jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private Object jdField_a_of_type_JavaLangObject;
  private final List jdField_a_of_type_JavaUtilList;
  public final Map a;
  public final ConcurrentHashMap a;
  public final AtomicInteger a;
  private BaseMessageManager jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  public Map b;
  public final ConcurrentHashMap b;
  private volatile boolean jdField_b_of_type_Boolean;
  private BaseMessageManager jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private Map jdField_c_of_type_JavaUtilMap;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  private BaseMessageManager jdField_d_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private String jdField_d_of_type_JavaLangString;
  private BaseMessageManager jdField_e_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private final String f;
  private int l;
  private volatile int p;
  
  public QQMessageFacade(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.l = -1;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.p = -1;
    this.jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.f = "Q.msg.QQMessageFacade";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(paramQQAppInterface);
    a();
  }
  
  private int a(int paramInt)
  {
    int i3 = 0;
    int i1 = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    int i2 = i1;
    if (localObject != null)
    {
      if (((Set)localObject).isEmpty()) {
        i2 = i1;
      }
    }
    else {
      return i2;
    }
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("getUnreadMsgsNum type=" + paramInt + "{");; localStringBuilder = null)
    {
      localObject = ((Set)localObject).iterator();
      i1 = i3;
      label93:
      while (((Iterator)localObject).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
        if ((localConversationInfo != null) && (localConversationInfo.uin != null) && (!AppConstants.aC.equals(localConversationInfo.uin)) && (!TextUtils.equals(AppConstants.aZ, localConversationInfo.uin)) && (!TextUtils.equals(AppConstants.ba, localConversationInfo.uin)) && ((localConversationInfo.type != 1008) || (!ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localConversationInfo.uin))) && ((!TextUtils.equals(AppConstants.aJ, localConversationInfo.uin)) || (!ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))))
        {
          i2 = a(localConversationInfo.type).a(paramInt, localConversationInfo);
          if ((QLog.isColorLevel()) && (localStringBuilder != null) && (i2 > 0)) {
            localStringBuilder.append("[" + localConversationInfo.uin + "," + localConversationInfo.type + "," + i2 + "]");
          }
          if ((localConversationInfo.type != 1008) || (i2 <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(localConversationInfo.uin, 1008) <= 0)) {
            break label407;
          }
          i2 -= 1;
        }
      }
      label407:
      for (;;)
      {
        i1 = i2 + i1;
        break label93;
        i2 = i1;
        if (!QLog.isColorLevel()) {
          break;
        }
        i2 = i1;
        if (localStringBuilder == null) {
          break;
        }
        i2 = i1;
        if (i1 <= 0) {
          break;
        }
        localStringBuilder.append("}");
        QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
        return i1;
      }
    }
  }
  
  private int a(List paramList, QQMessageFacade.Message paramMessage)
  {
    int i2;
    if ((paramList == null) || (paramMessage == null))
    {
      i2 = -1;
      return i2;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramList.size()) {
        break label54;
      }
      i2 = i1;
      if (a((QQMessageFacade.Message)paramList.get(i1), paramMessage)) {
        break;
      }
      i1 += 1;
    }
    label54:
    return -1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    long l1 = 0L;
    if ((paramInt == 1) || (paramInt == 3000))
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(paramString, paramInt);
      l1 = localMessage.shmsgseq;
      if (localMessage.isLongMsg())
      {
        paramQQAppInterface = paramQQAppInterface.a().b(paramString, paramInt);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
          l1 = Math.max(l1, ((MessageRecord)paramQQAppInterface.get(paramQQAppInterface.size() - 1)).shmsgseq);
        }
      }
    }
    else
    {
      return l1;
    }
    return l1;
  }
  
  private MsgProxy a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
  }
  
  private QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    return a(paramInt).a(paramString, paramInt, paramEntityManager);
  }
  
  /* Error */
  private void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 135	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   7: invokevirtual 317	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   10: iconst_1
    //   11: invokevirtual 322	com/tencent/mobileqq/app/proxy/RecentUserProxy:a	(Z)Ljava/util/List;
    //   14: invokeinterface 323 1 0
    //   19: astore_3
    //   20: iconst_0
    //   21: istore 7
    //   23: iconst_0
    //   24: istore 8
    //   26: aload_3
    //   27: invokeinterface 186 1 0
    //   32: ifeq +434 -> 466
    //   35: aload_3
    //   36: invokeinterface 190 1 0
    //   41: checkcast 325	com/tencent/mobileqq/data/RecentUser
    //   44: astore 4
    //   46: iload 8
    //   48: iconst_1
    //   49: iadd
    //   50: istore 11
    //   52: iload 7
    //   54: istore 10
    //   56: iload 11
    //   58: istore 9
    //   60: aload 4
    //   62: getfield 328	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   65: lload_1
    //   66: lcmp
    //   67: ifle +388 -> 455
    //   70: aload 4
    //   72: getfield 329	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   75: getstatic 332	com/tencent/mobileqq/app/AppConstants:am	Ljava/lang/String;
    //   78: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +105 -> 186
    //   84: invokestatic 337	com/tencent/mobileqq/managers/TroopAssistantManager:a	()Lcom/tencent/mobileqq/managers/TroopAssistantManager;
    //   87: aload_0
    //   88: getfield 102	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   91: invokevirtual 340	com/tencent/mobileqq/managers/TroopAssistantManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   94: invokeinterface 323 1 0
    //   99: astore 4
    //   101: iload 11
    //   103: iconst_1
    //   104: isub
    //   105: istore 8
    //   107: aload 4
    //   109: invokeinterface 186 1 0
    //   114: ifeq +69 -> 183
    //   117: aload 4
    //   119: invokeinterface 190 1 0
    //   124: checkcast 342	com/tencent/mobileqq/data/TroopAssistantData
    //   127: astore 5
    //   129: iload 8
    //   131: iconst_1
    //   132: iadd
    //   133: istore 9
    //   135: iload 9
    //   137: istore 8
    //   139: aload 5
    //   141: getfield 343	com/tencent/mobileqq/data/TroopAssistantData:lastmsgtime	J
    //   144: lload_1
    //   145: lcmp
    //   146: ifle -39 -> 107
    //   149: iload 7
    //   151: iconst_1
    //   152: iadd
    //   153: istore 7
    //   155: aload_0
    //   156: getfield 76	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   159: aload 5
    //   161: getfield 346	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   164: iconst_1
    //   165: invokestatic 350	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   168: iconst_1
    //   169: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: invokevirtual 360	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: iload 9
    //   178: istore 8
    //   180: goto -73 -> 107
    //   183: goto -157 -> 26
    //   186: aload 4
    //   188: getfield 329	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   191: aload 4
    //   193: getfield 361	com/tencent/mobileqq/data/RecentUser:type	I
    //   196: invokestatic 366	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   199: ifeq +117 -> 316
    //   202: iload 11
    //   204: iconst_1
    //   205: isub
    //   206: istore 8
    //   208: aload_0
    //   209: aload 4
    //   211: getfield 329	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   214: aload 4
    //   216: getfield 361	com/tencent/mobileqq/data/RecentUser:type	I
    //   219: invokevirtual 293	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;I)Ljava/util/List;
    //   222: invokeinterface 323 1 0
    //   227: astore 4
    //   229: aload 4
    //   231: invokeinterface 186 1 0
    //   236: ifeq +77 -> 313
    //   239: aload 4
    //   241: invokeinterface 190 1 0
    //   246: checkcast 295	com/tencent/mobileqq/data/MessageRecord
    //   249: astore 5
    //   251: iload 8
    //   253: iconst_1
    //   254: iadd
    //   255: istore 9
    //   257: iload 9
    //   259: istore 8
    //   261: aload 5
    //   263: getfield 369	com/tencent/mobileqq/data/MessageRecord:time	J
    //   266: lload_1
    //   267: lcmp
    //   268: ifle -39 -> 229
    //   271: iload 7
    //   273: iconst_1
    //   274: iadd
    //   275: istore 7
    //   277: aload_0
    //   278: getfield 76	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   281: aload 5
    //   283: getfield 372	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   286: aload 5
    //   288: getfield 375	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   291: invokestatic 350	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   294: aload 5
    //   296: getfield 375	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   299: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   302: invokevirtual 360	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: pop
    //   306: iload 9
    //   308: istore 8
    //   310: goto -81 -> 229
    //   313: goto -130 -> 183
    //   316: iload 7
    //   318: istore 8
    //   320: aload 4
    //   322: getfield 329	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   325: invokestatic 380	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   328: invokevirtual 384	java/lang/Long:longValue	()J
    //   331: ldc2_w 385
    //   334: lcmp
    //   335: ifle +49 -> 384
    //   338: iload 7
    //   340: iconst_1
    //   341: iadd
    //   342: istore 7
    //   344: iload 7
    //   346: istore 8
    //   348: aload_0
    //   349: getfield 76	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   352: aload 4
    //   354: getfield 329	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   357: aload 4
    //   359: getfield 361	com/tencent/mobileqq/data/RecentUser:type	I
    //   362: invokestatic 350	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   365: aload 4
    //   367: getfield 361	com/tencent/mobileqq/data/RecentUser:type	I
    //   370: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   373: invokevirtual 360	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: pop
    //   377: iload 11
    //   379: istore 8
    //   381: goto -198 -> 183
    //   384: iload 11
    //   386: iconst_1
    //   387: isub
    //   388: istore 8
    //   390: goto -9 -> 381
    //   393: astore 4
    //   395: iload 11
    //   397: iconst_1
    //   398: isub
    //   399: istore 7
    //   401: aload 4
    //   403: invokevirtual 389	java/lang/NumberFormatException:printStackTrace	()V
    //   406: iload 8
    //   408: istore 10
    //   410: iload 7
    //   412: istore 9
    //   414: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +38 -> 455
    //   420: ldc 87
    //   422: iconst_2
    //   423: new 158	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   430: ldc_w 391
    //   433: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 4
    //   438: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: iload 7
    //   449: istore 9
    //   451: iload 8
    //   453: istore 10
    //   455: iload 10
    //   457: istore 7
    //   459: iload 9
    //   461: istore 8
    //   463: goto -280 -> 183
    //   466: iload 7
    //   468: iload 8
    //   470: if_icmpne +164 -> 634
    //   473: aload_0
    //   474: getfield 76	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   477: invokevirtual 397	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   480: astore 5
    //   482: aload_0
    //   483: getfield 102	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   486: invokevirtual 400	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   489: astore_3
    //   490: aload_3
    //   491: ldc_w 402
    //   494: aconst_null
    //   495: invokevirtual 407	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   498: astore 4
    //   500: aload 4
    //   502: ifnull +133 -> 635
    //   505: aload 4
    //   507: astore_3
    //   508: aload 4
    //   510: invokeinterface 412 1 0
    //   515: ifeq +120 -> 635
    //   518: aload 4
    //   520: astore_3
    //   521: aload 4
    //   523: iconst_0
    //   524: invokeinterface 416 2 0
    //   529: invokestatic 421	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   532: astore 6
    //   534: aload 4
    //   536: astore_3
    //   537: aload 5
    //   539: aload 6
    //   541: invokeinterface 424 2 0
    //   546: ifne -41 -> 505
    //   549: aload 4
    //   551: astore_3
    //   552: aload_0
    //   553: getfield 76	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   556: aload 6
    //   558: aload 6
    //   560: invokestatic 428	com/tencent/mobileqq/data/MessageRecord:getTypeByTableName	(Ljava/lang/String;)I
    //   563: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   566: invokevirtual 360	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   569: pop
    //   570: goto -65 -> 505
    //   573: astore 5
    //   575: aload 4
    //   577: astore_3
    //   578: aload 5
    //   580: invokevirtual 429	java/lang/Exception:printStackTrace	()V
    //   583: aload 4
    //   585: astore_3
    //   586: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   589: ifeq +33 -> 622
    //   592: aload 4
    //   594: astore_3
    //   595: ldc 87
    //   597: iconst_2
    //   598: new 158	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   605: ldc_w 391
    //   608: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 5
    //   613: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   616: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: aload 4
    //   624: ifnull +10 -> 634
    //   627: aload 4
    //   629: invokeinterface 432 1 0
    //   634: return
    //   635: aload 4
    //   637: ifnull -3 -> 634
    //   640: aload 4
    //   642: invokeinterface 432 1 0
    //   647: return
    //   648: astore 4
    //   650: aconst_null
    //   651: astore_3
    //   652: aload_3
    //   653: ifnull +9 -> 662
    //   656: aload_3
    //   657: invokeinterface 432 1 0
    //   662: aload 4
    //   664: athrow
    //   665: astore 4
    //   667: goto -15 -> 652
    //   670: astore 5
    //   672: aconst_null
    //   673: astore 4
    //   675: goto -100 -> 575
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	QQMessageFacade
    //   0	678	1	paramLong	long
    //   19	638	3	localObject1	Object
    //   44	322	4	localObject2	Object
    //   393	44	4	localNumberFormatException	NumberFormatException
    //   498	143	4	localCursor	Cursor
    //   648	15	4	localObject3	Object
    //   665	1	4	localObject4	Object
    //   673	1	4	localObject5	Object
    //   127	411	5	localObject6	Object
    //   573	39	5	localException1	Exception
    //   670	1	5	localException2	Exception
    //   532	27	6	str	String
    //   21	450	7	i1	int
    //   24	447	8	i2	int
    //   58	402	9	i3	int
    //   54	402	10	i4	int
    //   50	349	11	i5	int
    // Exception table:
    //   from	to	target	type
    //   320	338	393	java/lang/NumberFormatException
    //   348	377	393	java/lang/NumberFormatException
    //   508	518	573	java/lang/Exception
    //   521	534	573	java/lang/Exception
    //   537	549	573	java/lang/Exception
    //   552	570	573	java/lang/Exception
    //   490	500	648	finally
    //   508	518	665	finally
    //   521	534	665	finally
    //   537	549	665	finally
    //   552	570	665	finally
    //   578	583	665	finally
    //   586	592	665	finally
    //   595	622	665	finally
    //   490	500	670	java/lang/Exception
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord)
  {
    paramString = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
    if (!AnonymousChatHelper.a(paramMessageRecord))
    {
      int i1 = paramString.g();
      paramMessageRecord.vipBubbleID = SVIPHandler.a(paramString.e(), i1);
      paramMessageRecord.vipBubbleDiyTextId = i1;
    }
  }
  
  private void a(List paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    if (QLog.isColorLevel())
    {
      if (paramList == null)
      {
        i1 = 0;
        a(String.format("addMultiMessagesInner size = %s, sync = %s, saveToDB = %s, needUpdateUnread = %s, needAddAIO = %s ", new Object[] { Integer.valueOf(i1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }), null);
      }
    }
    else {
      if ((paramList != null) && (!paramList.isEmpty())) {
        break label97;
      }
    }
    for (;;)
    {
      return;
      i1 = paramList.size();
      break;
      label97:
      Object localObject1 = new BaseMessageManager.AddMessageContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      long l2 = paramList.size();
      Object localObject2 = paramList.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        a(((MessageRecord)localObject3).istroop).a((MessageRecord)localObject3, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, (BaseMessageManager.AddMessageContext)localObject1);
      }
      paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).e.keySet().iterator();
      while (paramEntityManager.hasNext())
      {
        localObject2 = (String)paramEntityManager.next();
        localObject2 = ((List)((BaseMessageManager.AddMessageContext)localObject1).e.get(localObject2)).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          TroopBarAssistantManager.a().a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      ((BaseMessageManager.AddMessageContext)localObject1).e.clear();
      paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).f.keySet().iterator();
      while (paramEntityManager.hasNext())
      {
        localObject3 = (String)paramEntityManager.next();
        localObject2 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
        localObject3 = ((List)((BaseMessageManager.AddMessageContext)localObject1).f.get(localObject3)).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((EcShopAssistantManager)localObject2).a((MessageRecord)((Iterator)localObject3).next(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      ((BaseMessageManager.AddMessageContext)localObject1).f.clear();
      paramEntityManager = a();
      int i2;
      if (paramEntityManager != null)
      {
        i2 = 0;
        if (paramEntityManager.istroop == 1)
        {
          localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(paramEntityManager.frienduin);
          i1 = i2;
          if (localObject2 != null)
          {
            i1 = i2;
            if (((MessageInfo)localObject2).b() == paramEntityManager.shmsgseq) {
              i1 = ((MessageInfo)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramEntityManager.frienduin);
            }
          }
          paramEntityManager.bizType = i1;
        }
      }
      else
      {
        localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label759;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        localObject3 = (RecentUser)((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject3);
        try
        {
          HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject3);
          RecentUtil.a((RecentUser)localObject3, this);
          ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.a((RecentUser)localObject3);
          if (paramEntityManager == null) {
            continue;
          }
          if (paramEntityManager.istroop != 3000) {
            break label742;
          }
          ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(((RecentUser)localObject3).uin + "&" + 3000);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner --> Catch Exception .Info = " + localException);
          continue;
          i1 = i2;
          if (paramEntityManager.istroop != 3000) {
            break;
          }
          localObject2 = ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(paramEntityManager.frienduin + "&" + 3000);
          i1 = i2;
          if (localObject2 == null) {
            break;
          }
          i1 = i2;
          if (((MessageInfo)localObject2).b() != paramEntityManager.shmsgseq) {
            break;
          }
          i1 = ((MessageInfo)localObject2).a();
          break;
          label742:
          ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(localException.uin);
        }
      }
      label759:
      paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (paramEntityManager.hasNext())
      {
        localObject2 = (String)paramEntityManager.next();
        TroopAssistantManager.a().a((MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).jdField_b_of_type_JavaUtilMap.get(localObject2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (paramBoolean3) {
        ((BaseMessageManager.AddMessageContext)localObject1).jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade.a(paramList);
      }
      paramEntityManager = ((BaseMessageManager.AddMessageContext)localObject1).jdField_c_of_type_JavaUtilMap.keySet().iterator();
      while (paramEntityManager.hasNext())
      {
        localObject2 = (String)paramEntityManager.next();
        localObject2 = (MessageRecord)((BaseMessageManager.AddMessageContext)localObject1).jdField_c_of_type_JavaUtilMap.get(localObject2);
        localObject2 = a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
        a((QQMessageFacade.Message)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "addMessage decodeMsg uin = " + ((QQMessageFacade.Message)localObject2).frienduin + " , type = " + ((QQMessageFacade.Message)localObject2).istroop + " ,msgType:" + ((QQMessageFacade.Message)localObject2).msgtype + ", con = " + ((QQMessageFacade.Message)localObject2).getLogColorContent());
        }
      }
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l1, l2);
      paramEntityManager = ServiceAccountFolderManager.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (MessageRecord)paramList.next();
        paramEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1);
      }
    }
  }
  
  private boolean a(QQMessageFacade.Message paramMessage1, QQMessageFacade.Message paramMessage2)
  {
    return a(paramMessage1.frienduin, paramMessage2.frienduin);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return (paramString1 == null) && (paramString2 == null);
  }
  
  private boolean a(List paramList, QQMessageFacade.Message paramMessage)
  {
    if ((paramList == null) || (paramMessage == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a((QQMessageFacade.Message)paramList.next(), paramMessage)) {
        return true;
      }
    }
    return false;
  }
  
  private String b(String paramString, int paramInt)
  {
    return MsgProxyUtils.a(paramString, paramInt);
  }
  
  private void b(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.a(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopAssistantData)((Iterator)localObject).next()).troopUin, 1, paramEntityManager);
      }
    }
  }
  
  private MessageRecord c(String paramString, int paramInt)
  {
    paramString = MsgProxyUtils.b(a(paramInt).b(paramString, paramInt));
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (MessageRecord)paramString.get(paramString.size() - 1);
    }
    return null;
  }
  
  private void d(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(AppConstants.ag)) && (paramMessage.istroop == 1009))
    {
      paramMessage.unReadNum = 0;
      Object localObject = a(paramMessage.istroop).a(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          int i1 = paramMessage.unReadNum;
          paramMessage.unReadNum = (a(paramMessage.istroop).a(localMessageRecord.senderuin, localMessageRecord.istroop, 0L) + i1);
        }
        localEntityManager.a();
      }
    }
  }
  
  private void h(String paramString, int paramInt)
  {
    Object localObject = a(paramInt).a(paramString, paramInt);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (MsgProxyUtils.c(localMessageRecord.senderuin))
        {
          h(localMessageRecord.senderuin, localMessageRecord.istroop);
        }
        else if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(localMessageRecord.senderuin))
        {
          a().a(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          a(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          QQMessageFacade.Message localMessage = a(localMessageRecord.senderuin, paramInt);
          RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          RecentUser localRecentUser = localRecentUserProxy.a(localMessage.frienduin, localMessage.istroop);
          localRecentUser.lastmsgtime = localMessage.time;
          RecentUtil.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localRecentUserProxy.a(localRecentUser);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshMsgBox uin=" + paramString + ",type=" + paramInt + ",move " + localMessageRecord.senderuin + " from box to recentlist");
          }
          setChanged();
          notifyObservers(localRecentUser);
        }
      }
    }
  }
  
  private void n()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((QQMessageFacade.Message)localIterator.next()).counter = 0;
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public int a()
  {
    return this.l;
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, true);
  }
  
  public int a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, 0, paramLong1, paramLong2, false);
  }
  
  public int a(String paramString, int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramLong, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public long a(String paramString)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString, 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i1;
    if (localList != null)
    {
      i1 = localList.size() - 1;
      localObject1 = localObject2;
      if (i1 >= 0)
      {
        localObject1 = (MessageRecord)localList.get(i1);
        if (!((MessageRecord)localObject1).senderuin.equals(paramString)) {
          break label178;
        }
        if (!QLog.isColorLevel()) {
          break label200;
        }
        QLog.i("vip", 2, "getLastC2CBubleID find in cache");
      }
    }
    label152:
    label178:
    label200:
    for (;;)
    {
      if (localObject1 == null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramString, 0, Long.MAX_VALUE, 1, String.format("issend<>%d and issend<>%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2) }));
        if ((paramString != null) && (!paramString.isEmpty()))
        {
          paramString = (MessageRecord)paramString.get(0);
          localObject1 = paramString;
          if (QLog.isColorLevel())
          {
            QLog.d("vip", 2, "getLastC2CBubleID find in db");
            localObject1 = paramString;
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          return 0L;
          i1 -= 1;
          break;
        }
        return ((MessageRecord)localObject1).vipBubbleID;
        paramString = (String)localObject1;
        break label152;
      }
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    List localList = a(paramInt).b(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty())) {
      return MessageCache.a();
    }
    if ((a()) && (a().equals(paramString)) && (a() == paramInt)) {
      return ((MessageRecord)localList.get(localList.size() - 1)).time;
    }
    paramInt = localList.size() - 1;
    while (paramInt >= 0)
    {
      if (((MessageRecord)localList.get(paramInt)).isread) {
        return ((MessageRecord)localList.get(paramInt)).time;
      }
      paramInt -= 1;
    }
    return Math.max(((MessageRecord)localList.get(0)).time - 1L, 0L);
  }
  
  public long a(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString1, 0);
    int i1;
    MessageRecord localMessageRecord;
    if (paramString1 != null)
    {
      i1 = paramString1.size() - 1;
      if (i1 >= 0)
      {
        localMessageRecord = (MessageRecord)paramString1.get(i1);
        if (localMessageRecord.senderuin.equals(paramString2))
        {
          paramString1 = localMessageRecord;
          if (QLog.isColorLevel()) {
            QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          }
        }
      }
    }
    for (paramString1 = localMessageRecord;; paramString1 = null)
    {
      if (paramString1 == null)
      {
        return 0L;
        i1 -= 1;
        break;
      }
      return paramString1.vipBubbleID;
    }
  }
  
  public BaseMessageManager a(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
          this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new TroopMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
      }
    }
    if (paramInt == 3000)
    {
      if (this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
          this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new DiscMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
      }
    }
    if (paramInt == 7000)
    {
      if (this.jdField_d_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_d_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
          this.jdField_d_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new SubMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_d_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
      }
    }
    if (paramInt == 1026)
    {
      if (this.e == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.e == null) {
          this.e = new HCTopicMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.e;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new C2CMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
    }
  }
  
  public C2CMessageManager a()
  {
    return (C2CMessageManager)a(0);
  }
  
  public ConversationFacade a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public DatalineMessageManager a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (String str = "dataline_manager_pc";; str = "dataline_manager_ipad") {
      return (DatalineMessageManager)a(str);
    }
  }
  
  public DiscMessageManager a()
  {
    return (DiscMessageManager)a(3000);
  }
  
  public IMessageManager a(String paramString)
  {
    if (this.jdField_c_of_type_JavaUtilMap == null) {
      return null;
    }
    if (!this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.jdField_c_of_type_JavaUtilMap)
      {
        if (this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {
          break label114;
        }
        if ("dataline_manager_pc".equals(paramString))
        {
          localObject = new DatalineMessagePcManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          if (localObject != null) {
            break label102;
          }
          return null;
        }
      }
      if ("dataline_manager_ipad".equals(paramString))
      {
        localObject = new DatalineMessageIpadManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        continue;
        label102:
        this.jdField_c_of_type_JavaUtilMap.put(paramString, localObject);
        label114:
        return (IMessageManager)this.jdField_c_of_type_JavaUtilMap.get(paramString);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public QQMessageFacade.Message a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = new QQMessageFacade.Message();
      return paramString;
    }
    System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder("Case:");
    String str1 = b(paramString, paramInt);
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject;
    if (localMessage != null)
    {
      localObject = localMessage;
      if (localMessage.isCacheValid) {}
    }
    else
    {
      if (this.p != 0) {
        break label152;
      }
      localObject = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject).frienduin = paramString;
      ((QQMessageFacade.Message)localObject).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
      localStringBuilder.append("All-In");
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
      if (!MsgProxyUtils.a(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop)) {
        break;
      }
      ((QQMessageFacade.Message)localObject).istroop = MsgProxyUtils.a(((QQMessageFacade.Message)localObject).istroop);
      return (QQMessageFacade.Message)localObject;
      label152:
      if (!this.jdField_b_of_type_Boolean)
      {
        localObject = localMessage;
        if (localMessage == null)
        {
          localObject = new QQMessageFacade.Message();
          ((QQMessageFacade.Message)localObject).frienduin = paramString;
          ((QQMessageFacade.Message)localObject).istroop = paramInt;
          ((QQMessageFacade.Message)localObject).isCacheValid = false;
          this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
        }
        localStringBuilder.append("Not-Finish-Yet");
      }
      else
      {
        localObject = MessageRecord.getTableName(paramString, paramInt);
        String str2 = MessageRecord.getOldTableName(paramString, paramInt);
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if ((!localEntityManager.d((String)localObject)) && (!localEntityManager.d(str2))) {
          break label325;
        }
        localMessage = a(paramString, paramInt, localEntityManager);
        localStringBuilder.append("Check-DB");
        localObject = localMessage;
        if (localMessage == null)
        {
          localObject = new QQMessageFacade.Message();
          ((QQMessageFacade.Message)localObject).frienduin = paramString;
          ((QQMessageFacade.Message)localObject).istroop = paramInt;
          this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
        }
        localEntityManager.a();
      }
    }
    label325:
    if (localMessage == null)
    {
      localObject = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject).frienduin = paramString;
      ((QQMessageFacade.Message)localObject).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject = localMessage;
    }
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    return a(paramSessionInfo.jdField_a_of_type_Int).a(paramSessionInfo, paramString);
  }
  
  public ChatHistorySearchData a(String paramString, int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = a(paramInt).c(paramString, paramInt, paramList);
    return localChatHistorySearchData;
  }
  
  public DraftSummaryInfo a(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return null;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.longMsgIndex == 0) {}
    List localList;
    do
    {
      return paramMessageRecord;
      localList = a(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    } while ((localList == null) || (localList.isEmpty()));
    int i1 = localList.size() - 1;
    if (i1 >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i1);
      if (MsgProxyUtils.a(localMessageRecord, paramMessageRecord))
      {
        if (localMessageRecord.longMsgIndex == 0) {
          return localMessageRecord;
        }
        if (localMessageRecord.longMsgIndex < paramMessageRecord.longMsgIndex) {
          paramMessageRecord = localMessageRecord;
        }
      }
      for (;;)
      {
        i1 -= 1;
        break;
      }
    }
    return paramMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      int i1 = ((List)localObject1).size() - 1;
      Object localObject2;
      if (i1 >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i1);
        if ((((MessageRecord)localObject2).isValid) && (!MsgProxyUtils.g(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
      for (localObject1 = a((MessageRecord)localObject2);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramInt).b(paramString, paramInt, null);
        }
        return (MessageRecord)localObject2;
        i1 -= 1;
        break;
      }
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).a(paramString, paramInt, paramLong);
  }
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    return a(paramInt1).a(paramString1, paramInt1, paramLong1, paramString2, paramString3, paramLong2, paramInt2);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    MsgProxy localMsgProxy = a(paramInt);
    if ((localMsgProxy instanceof TroopAndDiscMsgProxy)) {
      return ((TroopAndDiscMsgProxy)localMsgProxy).a(paramString, paramInt, paramMessageRecord);
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List paramList)
  {
    MsgProxy localMsgProxy = a(paramInt);
    if ((localMsgProxy instanceof TroopAndDiscMsgProxy)) {
      return ((TroopAndDiscMsgProxy)localMsgProxy).a(paramString, paramInt, paramMessageRecord, paramList);
    }
    return null;
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramInt).a(paramString1, paramInt, paramString2);
  }
  
  public TroopMessageManager a()
  {
    return (TroopMessageManager)a(1);
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public String a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    a(localMessage);
    paramMessageRecord = new MsgSummary();
    MsgUtils.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramContext).toString();
  }
  
  public String a(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return null;
  }
  
  public List a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      List localList2 = (List)((ArrayList)this.jdField_a_of_type_JavaUtilList).clone();
      return localList2;
    }
  }
  
  public List a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  public List a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, null);
  }
  
  public List a(String paramString, int paramInt, long paramLong)
  {
    int i2 = 0;
    paramString = a(paramInt).a(paramString, paramInt, paramLong);
    ChatMessage localChatMessage;
    if ((paramInt == 7100) || (paramInt == 1001))
    {
      if (paramString == null) {}
      for (int i1 = 0;; i1 = paramString.size())
      {
        i1 -= 1;
        while (i1 >= 0)
        {
          localChatMessage = (ChatMessage)paramString.get(i1);
          if ((localChatMessage != null) && (((paramInt == 7100) && (MessageUtils.a(localChatMessage.msgtype))) || ((paramInt == 1001) && (localChatMessage.msgtype == 61525)))) {
            paramString.remove(localChatMessage);
          }
          i1 -= 1;
        }
      }
    }
    if (paramInt == 1008)
    {
      if (paramString == null)
      {
        paramInt = i2;
        paramInt -= 1;
        label148:
        if (paramInt < 0) {
          break label288;
        }
        localChatMessage = (ChatMessage)paramString.get(paramInt);
        if (localChatMessage != null) {
          break label186;
        }
      }
      label186:
      label260:
      label286:
      for (;;)
      {
        paramInt -= 1;
        break label148;
        paramInt = paramString.size();
        break;
        if (PAWeatherItemBuilder.a(localChatMessage.senderuin))
        {
          if (!(localChatMessage instanceof MessageForText)) {
            break label260;
          }
          if (!((MessageForText)localChatMessage).msg.startsWith(" ")) {
            paramString.remove(localChatMessage);
          }
        }
        for (;;)
        {
          if ((localChatMessage.msgtype != 60528) || (!ArkAppCenter.b())) {
            break label286;
          }
          paramString.remove(localChatMessage);
          break;
          if ((!(localChatMessage instanceof MessageForArkApp)) && (!(localChatMessage instanceof MessageForStructing))) {
            paramString.remove(localChatMessage);
          }
        }
      }
    }
    try
    {
      label288:
      Collections.sort(paramString, new qmg(this));
      return paramString;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.msg.QQMessageFacade", 2, "Collections sort exception ! ", localException);
    }
    return paramString;
  }
  
  public List a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3)
  {
    return a(paramInt1).a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public List a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List a(String paramString, int paramInt, List paramList)
  {
    return a(paramInt).a(paramString, paramInt, paramList);
  }
  
  public List a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return a(paramInt).a(paramString, paramInt, 5000, paramArrayOfInt);
  }
  
  public List a(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public ConcurrentHashMap a()
  {
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public msg_svc.PbMsgReadedReportReq a(String paramString, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq;
    Object localObject2;
    Object localObject1;
    label156:
    Object localObject3;
    if (MsgProxyUtils.a(paramString, paramInt))
    {
      d(paramString, paramInt);
      List localList = b(paramString, paramInt);
      if (localList == null) {
        return null;
      }
      localStringBuilder = new StringBuilder();
      paramString = null;
      localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      paramInt = localList.size() - 1;
      if (paramInt >= 0)
      {
        localObject2 = (MessageRecord)localList.get(paramInt);
        if (localObject2 == null) {
          localObject1 = paramString;
        }
        do
        {
          do
          {
            paramInt -= 1;
            paramString = (String)localObject1;
            break;
            if (!MsgProxyUtils.c(((MessageRecord)localObject2).senderuin)) {
              break label291;
            }
            localObject2 = b(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
            localObject1 = paramString;
          } while (localObject2 == null);
          localObject1 = paramString;
        } while (((List)localObject2).isEmpty());
        localObject2 = ((List)localObject2).iterator();
        do
        {
          localObject1 = paramString;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
        } while (localObject3 == null);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop) <= 0) {
          break label557;
        }
        a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop, false, paramBoolean);
        localObject1 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).peer_uin.set(Long.valueOf(((MessageRecord)localObject3).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).last_read_time.set((int)((MessageRecord)localObject3).time);
        if (paramString != null) {
          break label554;
        }
        paramString = new msg_svc.PbC2CReadedReportReq();
        label279:
        paramString.pair_info.add((MessageMicro)localObject1);
      }
    }
    label291:
    label554:
    label557:
    for (;;)
    {
      break label156;
      localObject1 = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {
        break;
      }
      a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, false, paramBoolean);
      localObject3 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).peer_uin.set(Long.valueOf(((MessageRecord)localObject2).senderuin).longValue());
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).last_read_time.set((int)((MessageRecord)localObject2).time);
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = new msg_svc.PbC2CReadedReportReq();
      }
      ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject3);
      localStringBuilder.append("{MSGBOX:").append(((MessageRecord)localObject2).senderuin).append("}");
      break;
      if (paramString != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        if (localObject1 != null) {
          paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        localPbMsgReadedReportReq.c2c_read_report.set(paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_LBS>setLbsFriendReaded: " + localStringBuilder.toString());
          long l2 = System.currentTimeMillis();
          QLog.d("Q.msg_box", 2, "setBoxMsgReaded[cost:" + (l2 - l1) + "]");
        }
        return localPbMsgReadedReportReq;
      }
      return null;
      break label279;
    }
  }
  
  public msg_svc.PbMsgReadedReportReq a(boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = null;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    Iterator localIterator = ((Set)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    label185:
    label251:
    Object localObject5;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject3 = (ConversationInfo)localIterator.next();
        if ((ConversationFacade.a((ConversationInfo)localObject3) > 0) && (a().b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))) {
          if (MsgProxyUtils.a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))
          {
            localObject3 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            if (localObject3 == null) {
              continue;
            }
            int i1 = ((List)localObject3).size();
            i1 -= 1;
            if (i1 >= 0)
            {
              localObject4 = (MessageRecord)((List)localObject3).get(i1);
              if (localObject4 == null) {
                localObject2 = localObject1;
              }
              do
              {
                do
                {
                  do
                  {
                    i1 -= 1;
                    localObject1 = localObject2;
                    break;
                    if (!MsgProxyUtils.c(((MessageRecord)localObject4).senderuin)) {
                      break label353;
                    }
                    localObject4 = b(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
                    localObject2 = localObject1;
                  } while (localObject4 == null);
                  localObject2 = localObject1;
                } while (((List)localObject4).isEmpty());
                localObject4 = ((List)localObject4).iterator();
                localObject2 = localObject1;
              } while (!((Iterator)localObject4).hasNext());
              localObject5 = (MessageRecord)((Iterator)localObject4).next();
              a(((MessageRecord)localObject5).senderuin, ((MessageRecord)localObject5).istroop, true, paramBoolean);
              localObject2 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).peer_uin.set(Long.valueOf(((MessageRecord)localObject5).senderuin).longValue());
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).last_read_time.set((int)((MessageRecord)localObject5).time);
              if (localObject1 != null) {
                break label1134;
              }
              localObject1 = new msg_svc.PbC2CReadedReportReq();
            }
          }
        }
      }
    }
    label353:
    label682:
    label1131:
    label1134:
    for (;;)
    {
      ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject2);
      break label251;
      a(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop, true, paramBoolean);
      localObject5 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject5).peer_uin.set(Long.valueOf(((MessageRecord)localObject4).senderuin).longValue());
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject5).last_read_time.set((int)((MessageRecord)localObject4).time);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new msg_svc.PbC2CReadedReportReq();
      }
      ((msg_svc.PbC2CReadedReportReq)localObject2).pair_info.add((MessageMicro)localObject5);
      localStringBuilder.append("{MSGBOX:").append(((MessageRecord)localObject4).frienduin).append("}");
      break label185;
      break;
      if (7000 == ((ConversationInfo)localObject3).type)
      {
        if (AppConstants.ah.equals(((ConversationInfo)localObject3).uin)) {
          break;
        }
        localObject2 = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if (localObject2 == null) {
          break;
        }
        ((SubAccountManager)localObject2).b(((ConversationInfo)localObject3).uin);
        localObject2 = ((SubAccountManager)localObject2).a(((ConversationInfo)localObject3).uin);
        if (localObject2 == null) {
          break;
        }
        localObject3 = new msg_svc.PbBindUinMsgReadedConfirmReq();
        ((msg_svc.PbBindUinMsgReadedConfirmReq)localObject3).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
        localPbMsgReadedReportReq.bind_uin_read_report.set((MessageMicro)localObject3);
        localStringBuilder.append("{SUBUIN}");
        break;
      }
      if ((!paramBoolean) && (((ConversationInfo)localObject3).type == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin))) {
        break;
      }
      long l1;
      if ((1006 == ((ConversationInfo)localObject3).type) || ((MsgProxyUtils.c(((ConversationInfo)localObject3).type)) && (Long.valueOf(((ConversationInfo)localObject3).uin).longValue() > 10000L)))
      {
        a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
        l1 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
        if (l1 == -1L)
        {
          if (localObject1 != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
            if (localObject2 != null) {
              ((msg_svc.PbC2CReadedReportReq)localObject1).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
            }
            localPbMsgReadedReportReq.c2c_read_report.set((MessageMicro)localObject1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_All>setAllReaded: " + localStringBuilder.toString());
          }
          return localPbMsgReadedReportReq;
        }
        localObject4 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        localObject2 = ((ConversationInfo)localObject3).uin;
        if (1006 == ((ConversationInfo)localObject3).type) {
          localObject2 = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin);
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).peer_uin.set(Long.valueOf((String)localObject2).longValue());
        localStringBuilder.append("{C2C:").append(Long.valueOf((String)localObject2)).append(((ConversationInfo)localObject3).type).append("}");
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).last_read_time.set((int)l1);
        if (localObject1 != null) {
          break label1131;
        }
        localObject1 = new msg_svc.PbC2CReadedReportReq();
      }
      for (;;)
      {
        ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject4);
        break;
        if (3000 == ((ConversationInfo)localObject3).type)
        {
          a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
          l1 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          if (l1 == -1L) {
            break label682;
          }
          localObject2 = new msg_svc.PbDiscussReadedReportReq();
          ((msg_svc.PbDiscussReadedReportReq)localObject2).conf_uin.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
          ((msg_svc.PbDiscussReadedReportReq)localObject2).last_read_seq.set(l1);
          localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject2);
          break;
        }
        if ((1 != ((ConversationInfo)localObject3).type) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))) {
          break;
        }
        a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
        HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin);
        l1 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
        if (l1 == -1L) {
          break label682;
        }
        if (!((ConversationInfo)localObject3).uin.matches("^\\d+$")) {
          break;
        }
        localObject2 = new msg_svc.PbGroupReadedReportReq();
        ((msg_svc.PbGroupReadedReportReq)localObject2).group_code.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
        ((msg_svc.PbGroupReadedReportReq)localObject2).last_read_seq.set(l1);
        localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject2);
        break;
      }
    }
  }
  
  public void a()
  {
    ThreadManager.a(new qmd(this), 10, null, false);
  }
  
  public void a(int paramInt)
  {
    String str = String.valueOf(AppConstants.aE);
    if (a().a(str, 4001) <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
    }
    do
    {
      return;
      QQMessageFacade.Message localMessage = a(str, 4001);
      paramInt = a(4001).a(paramInt, localMessage);
      a().c(str, 4001, -paramInt);
    } while (paramInt == 0);
    setChanged();
    notifyObservers(a(str, 4001));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i2 = 0;
    if ((paramInt == 0) && (this.jdField_b_of_type_Boolean)) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i1;
    if (this.p == -1)
    {
      if (localEntityManager.d(ConversationInfo.getConversationInfoTableName()))
      {
        i1 = 1;
        this.p = i1;
      }
    }
    else
    {
      localObject = ((RecentUserProxy)localObject).a(true);
      i1 = i2;
      if (localObject == null) {
        break label358;
      }
      i1 = i2;
      if (((List)localObject).size() <= 0) {
        break label358;
      }
      i1 = ((List)localObject).size();
      if (paramInt <= 0) {
        break label414;
      }
      if (i1 <= paramInt) {
        break label299;
      }
      i2 = paramInt;
    }
    for (;;)
    {
      label118:
      int i3 = 0;
      label121:
      if (i3 < i2)
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(i3);
        a(localRecentUser.uin, localRecentUser.type, localEntityManager);
        if ((localRecentUser.type == 1) && (HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, false))) {
          a(localRecentUser.uin, 1026, localEntityManager);
        }
        if (i3 == 8)
        {
          setChanged();
          notifyObservers(new RecentUser());
        }
        if (MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type))
        {
          if (!AppConstants.ar.equals(localRecentUser.uin)) {
            break label306;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.aO, localRecentUser.type)) {
            a(AppConstants.aO, localRecentUser.type, localEntityManager);
          }
        }
        for (;;)
        {
          i3 += 1;
          break label121;
          i1 = 0;
          break;
          label299:
          i2 = i1;
          break label118;
          label306:
          if ((AppConstants.aH.equals(localRecentUser.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.aP, localRecentUser.type))) {
            a(AppConstants.aP, localRecentUser.type, localEntityManager);
          }
        }
      }
      label358:
      if (paramBoolean) {
        b(localEntityManager);
      }
      if ((paramBoolean) || (((List)localObject).size() > 8))
      {
        setChanged();
        notifyObservers(new RecentUser());
      }
      if ((paramInt != 0) && (paramInt < i1)) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      return;
      label414:
      i2 = i1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    ThreadManager.a(new qmi(this, paramQQAppInterface, paramMessageRecord, paramArrayList, paramHongbaoParams), 8, null, false);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    try
    {
      a(paramMessage.istroop).a(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", paramMessage);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!((MessageForShortVideo)localObject1).isSendFromLocal())
      {
        ((TransFileController)localObject2).a(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
        ShortVideoUtils.a((MessageForShortVideo)localObject1);
      }
    }
    else
    {
      if (paramMessageRecord.isSendFromLocal()) {
        break label68;
      }
    }
    for (;;)
    {
      return;
      ((TransFileController)localObject2).b(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      break;
      label68:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject2 = new ArrayList();
      Object localObject3;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        i2 = paramMessageRecord.msgElemList.size();
        i1 = 0;
        while (i1 < i2)
        {
          localObject3 = (MessageRecord)paramMessageRecord.msgElemList.get(i1);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          i1 += 1;
        }
      }
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        paramMessageRecord = (MessageForLongMsg)paramMessageRecord;
        int i3 = paramMessageRecord.longMsgFragmentList.size();
        i1 = 0;
        if (i1 < i3)
        {
          localObject3 = (MessageRecord)paramMessageRecord.longMsgFragmentList.get(i1);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = (MessageForMixedMsg)localObject3;
              int i4 = ((MessageForMixedMsg)localObject3).msgElemList.size();
              i2 = 0;
              while (i2 < i4)
              {
                MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(i2);
                if ((localMessageRecord instanceof MessageForPic)) {
                  ((List)localObject2).add((MessageForPic)localMessageRecord);
                }
                i2 += 1;
              }
            }
          }
        }
      }
      else
      {
        if (!(paramMessageRecord instanceof MessageForPic)) {
          continue;
        }
        ((List)localObject2).add((MessageForPic)paramMessageRecord);
      }
      int i2 = ((List)localObject2).size();
      int i1 = 0;
      while (i1 < i2)
      {
        paramMessageRecord = (MessageForPic)((List)localObject2).get(i1);
        paramMessageRecord = paramMessageRecord.frienduin + paramMessageRecord.uniseq + "_" + paramMessageRecord.subMsgId;
        localObject3 = ((TransFileController)localObject1).a(paramMessageRecord);
        if ((localObject3 != null) && ((localObject3 instanceof BaseTransProcessor)))
        {
          ((BaseTransProcessor)localObject3).j();
          ((TransFileController)localObject1).a(paramMessageRecord);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    a(paramMessageRecord, paramMessageObserver, false);
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.frienduin == null) || (paramMessageRecord.frienduin.length() < 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      b(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
      }
      b(paramMessageRecord, paramMessageObserver, paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, false, true, true, true);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      c(localArrayList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      c(localArrayList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord, true, paramBoolean);
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramRecentUser, false);
    a(paramRecentUser.uin, paramRecentUser.type, true, true);
    if (paramRecentUser.type == 1) {
      HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin);
    }
  }
  
  public void a(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.a(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject).next();
        a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType, paramEntityManager);
      }
    }
    localObject = paramEntityManager.a(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopBarData)((Iterator)localObject).next()).mUin, 1008, paramEntityManager);
      }
    }
  }
  
  public void a(Object paramObject)
  {
    setChanged();
    notifyObservers(paramObject);
  }
  
  public void a(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = (ArrayList)localEntityManager.a(TransFileInfo.class, false, "friendUin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localEntityManager.b((TransFileInfo)paramString.next());
      }
    }
    localEntityManager.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    this.l = paramInt;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    a(paramInt1).a(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramInt).a(paramString, paramInt, paramLong, false);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString, paramInt1, paramLong, 32768, paramInt2);
    paramString = a(paramString, paramInt1);
    if ((paramString != null) && (paramString.uniseq == paramLong))
    {
      paramString.extraflag = 32768;
      paramString.sendFailCode = paramInt2;
      setChanged();
      notifyObservers(paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgExtraFlagByuniseq: peerUin = " + paramString + " type = " + paramInt1 + " uniseq = " + paramLong);
    }
    MessageRecord localMessageRecord = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    a(paramInt1).a(paramString, paramInt1, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateC2CMsgTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " time = " + paramLong2);
    }
    MessageRecord localMessageRecord = a(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
    a(paramInt).a(paramString, paramInt, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateGroupMsgSeqAndTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " shmsgseq = " + paramLong2 + " time = " + paramLong3);
    }
    Object localObject = a(paramInt);
    if ((localObject instanceof TroopAndDiscMsgProxy)) {}
    for (localObject = ((TroopAndDiscMsgProxy)localObject).b(paramString, paramInt, paramLong1, paramLong2, paramLong3);; localObject = null)
    {
      a(paramInt).a(paramString, paramInt, (MessageRecord)localObject, 3);
      a(paramString, paramInt, paramLong2);
      setChanged();
      notifyObservers(localObject);
      if (localObject == null) {}
      do
      {
        return;
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      } while ((!paramString.f()) || ((!paramString.e((MessageRecord)localObject)) && (!paramString.b(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq))));
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "updateGroupMsgSeqAndTimeByUniseq, in revoking cache");
      }
      paramString.f(null);
      a(paramInt).b();
      return;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "loadMoreAIOMessage isChatting = false!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new qme(this, paramInt, paramString, paramLong, paramRefreshMessageContext));
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContent: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 2);
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong + " fieldName = " + paramString2 + " fieldValue = " + paramObject);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2, paramObject);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramInt).a(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentByUniSeq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramArrayOfByte = a(paramInt).a(paramString, paramInt, paramLong, paramArrayOfByte);
    a(paramInt).a(paramString, paramInt, paramArrayOfByte, 2);
  }
  
  public void a(String paramString, int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    List localList = a(paramString, paramInt);
    if (localList == null) {}
    for (int i1 = 0;; i1 = localList.size())
    {
      i1 = 10 - i1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "refreshMessageListHeadByAIOBreak numTroopRefresh = " + paramRefreshMessageContext.h + ", count = " + i1);
      }
      if (i1 <= 0) {
        break;
      }
      paramRefreshMessageContext.h = true;
      a(paramInt).a(paramString, paramInt, i1, paramRefreshMessageContext);
      return;
    }
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.c = paramInt;
    paramRefreshMessageContext.jdField_d_of_type_Int = i1;
    a(paramRefreshMessageContext);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramInt).c(paramString, paramInt, paramMessageRecord);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null) && (paramString2 != null) && (paramString1 != null) && (paramString1.length() >= 5))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = paramString1;
      localDraftTextInfo.type = paramInt;
      localDraftTextInfo.text = paramString2.toString();
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDraftTextInfo);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if (TextUtils.isEmpty(paramString3)) {
        paramLong = 0L;
      }
      for (;;)
      {
        a(paramInt).a(paramString1, paramInt, paramString2, paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.i("notification", 2, "notifyDraftUpdated| " + (System.currentTimeMillis() - l1) + " drafttime = " + paramLong);
        }
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt, List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramString, paramInt, paramList);
      setChanged();
      notifyObservers(paramList.get(0));
    }
  }
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle)
  {
    a(paramInt).a(paramString, paramInt, paramList1, paramList2, paramBundle);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    e(paramString, 1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, paramString1);
    }
  }
  
  public void a(String paramString, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      a("------------" + paramString + "--------------" + paramCollection.size(), "");
      return;
    }
    a("------------" + paramString + "-------------- is null", "");
  }
  
  public void a(ArrayList paramArrayList)
  {
    a(((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int).a(paramArrayList);
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean, bool, true, true);
        paramString.a();
        if ((paramBoolean) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        paramString = MsgProxyUtils.a(paramArrayList);
        if (paramString != null)
        {
          setChanged();
          notifyObservers(paramString);
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if (paramBoolean2)
        {
          paramString = MsgProxyUtils.a(paramArrayList);
          if (paramString != null)
          {
            setChanged();
            notifyObservers(paramString);
          }
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if ((paramBoolean2) || (paramBoolean3))
        {
          paramString = MsgProxyUtils.a(paramArrayList);
          if (paramString != null)
          {
            setChanged();
            notifyObservers(paramString);
          }
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    int i1;
    do
    {
      return;
      i1 = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int;
      a(i1).b(paramArrayList);
    } while ((!paramBoolean) || ((i1 != 1) && (i1 != 3000)));
    paramArrayList = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_JavaLangString;
    a(paramArrayList, i1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList, i1));
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramList, null);
    }
    c(paramList);
  }
  
  public void a(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, true);
      paramString.a();
      paramString = MsgProxyUtils.a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      c(paramList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList.size() != 0) {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramList, true, paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_d_of_type_JavaLangString != null) && (this.l >= 0);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.istroop).uniseq == paramMessageRecord.uniseq;
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, 0);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = b(paramString, paramInt);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      paramString = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString.time > 0L) && (paramString.senderuin != null)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (MsgProxyUtils.m(paramInt2))
    {
      bool1 = bool2;
      if (MsgProxyUtils.g(paramInt2))
      {
        bool1 = bool2;
        if (a(paramInt1).d(paramString, paramInt1, paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, List paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.QQMessageFacade", 2, "refresh C2C autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(b(paramString, paramInt), Boolean.valueOf(true));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(paramString, paramInt);
    } while ((paramString == null) || (paramString.isEmpty()));
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).c();
    }
    a("refresh C2C autopull, size = " + paramString.size(), ", timestamp = " + System.currentTimeMillis());
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    paramBoolean = true;
    boolean bool = true;
    List localList = b(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty()))
    {
      paramBoolean = false;
      return paramBoolean;
    }
    if (localList.size() == 1)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(0);
      if ((localMessageRecord.msgtype == 63530) || (!localMessageRecord.isValid)) {
        return false;
      }
      if (localMessageRecord.shmsgseq > Math.max(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt)) + 1L) {}
      for (;;)
      {
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool + "; cacheList size = " + localList.size() + "; msgseq = " + localMessageRecord.shmsgseq + ", expiredSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString) + ", delLastSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt));
        return bool;
        bool = false;
      }
    }
    if (localList.size() > 1)
    {
      paramString = (MessageRecord)localList.get(localList.size() - 1);
      if ((paramString.msgtype == 63530) || (!paramString.isValid)) {
        return false;
      }
      paramString = MsgProxyUtils.a(localList, false);
      if (paramString.size() < 10) {}
      for (bool = paramBoolean;; bool = false)
      {
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool + "; cacheList size = " + localList.size() + "; continuedList size = " + paramString.size());
        return bool;
      }
    }
    return false;
  }
  
  public int b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (int i1 = 0; localIterator.hasNext(); i1 = ((QQMessageFacade.Message)localIterator.next()).counter + i1) {}
      return i1;
    }
  }
  
  public long b(String paramString, int paramInt)
  {
    long l2 = -1L;
    Object localObject;
    long l1;
    if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      l2 = ((QQMessageFacade.Message)localObject).shmsgseq;
      l1 = l2;
      if (((QQMessageFacade.Message)localObject).isLongMsg())
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (paramString.size() > 0) {
            return Math.max(l2, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
          }
        }
      }
    }
    else
    {
      l1 = l2;
      if (MsgProxyUtils.c(paramInt))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (!paramString.isEmpty())
          {
            paramInt = paramString.size() - 1;
            for (;;)
            {
              l1 = l2;
              if (paramInt < 0) {
                break;
              }
              localObject = (MessageRecord)paramString.get(paramInt);
              if (!MsgUtils.b(((MessageRecord)localObject).issend)) {
                return ((MessageRecord)localObject).time;
              }
              paramInt -= 1;
            }
          }
        }
      }
    }
    return l1;
  }
  
  public QQMessageFacade.Message b(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    String str1 = b(paramString, paramInt);
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject = localMessage;
    EntityManager localEntityManager;
    if (localMessage == null)
    {
      localObject = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if ((!localEntityManager.d((String)localObject)) && (!localEntityManager.d(str2))) {
        break label135;
      }
      paramString = a(paramString, paramInt, localEntityManager);
    }
    for (;;)
    {
      localEntityManager.a();
      localObject = paramString;
      paramString = (String)localObject;
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
      if (!MsgProxyUtils.a(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop)) {
        break;
      }
      ((QQMessageFacade.Message)localObject).istroop = MsgProxyUtils.a(((QQMessageFacade.Message)localObject).istroop);
      return (QQMessageFacade.Message)localObject;
      label135:
      if (localMessage == null)
      {
        localObject = new QQMessageFacade.Message();
        ((QQMessageFacade.Message)localObject).frienduin = paramString;
        ((QQMessageFacade.Message)localObject).istroop = paramInt;
        this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
        paramString = (String)localObject;
      }
      else
      {
        localMessage.isCacheValid = true;
        paramString = localMessage;
      }
    }
  }
  
  public MessageRecord b(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      int i1 = ((List)localObject1).size() - 1;
      Object localObject2;
      if (i1 >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i1);
        if (PublicAccountUtil.a((MessageRecord)localObject2)) {}
        while ((!((MessageRecord)localObject2).isValid) || (MsgProxyUtils.g(((MessageRecord)localObject2).msgtype)))
        {
          i1 -= 1;
          break;
        }
        localObject1 = localObject2;
        if (!((MessageRecord)localObject2).isLongMsg()) {}
      }
      for (localObject1 = a((MessageRecord)localObject2);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramInt).b(paramString, paramInt, null);
        }
        return (MessageRecord)localObject2;
      }
    }
    return null;
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public MessageRecord b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramInt).b(paramString1, paramInt, paramString2);
  }
  
  public String b(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramContext = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(paramContext, paramMessageRecord);
    paramContext.emoRecentMsg = null;
    paramContext.fileType = -1;
    a(paramContext);
    return MsgUtils.a(paramContext.nickName, 0.4F);
  }
  
  public List b(String paramString, int paramInt)
  {
    return a(paramInt).b(paramString, paramInt);
  }
  
  public void b()
  {
    this.jdField_d_of_type_JavaLangString = null;
    this.l = -1;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4001).b(String.valueOf(AppConstants.aE), 4001);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt);
    } while (a(4001).a(paramInt) <= 0);
    setChanged();
    localObject = new RecentUser();
    ((RecentUser)localObject).uin = String.valueOf(AppConstants.aC);
    notifyObservers(localObject);
  }
  
  public void b(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = paramMessage;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      MessageForFile localMessageForFile;
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (a(paramMessageRecord.istroop).a(paramMessageRecord));
        if (paramMessageRecord.msgtype != 63531) {
          break label149;
        }
        localMessageForFile = (MessageForFile)paramMessageRecord;
        localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForFile.uniseq, localMessageForFile.senderuin, localMessageForFile.istroop);
        if (localFileManagerEntity == null) {
          break;
        }
      } while ((!localMessageForFile.isSend()) || ((localFileManagerEntity.status != 1) && (localFileManagerEntity.status != -1) && (localFileManagerEntity.status != 3)));
      if (QLog.isColorLevel()) {
        QLog.d("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, msgForFile");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, localFileManagerEntity, new qmh(this, paramMessageRecord, localFileManagerEntity));
      return;
    } while (!QLog.isColorLevel());
    QLog.e("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, return");
    return;
    label149:
    a(paramMessageRecord.istroop).c(paramMessageRecord);
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    b(paramMessageRecord, paramMessageObserver, false);
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.a(new qmf(this, paramMessageRecord, paramMessageObserver, paramBoolean), 10, null, false);
      return;
    }
    c(paramMessageRecord, paramMessageObserver, paramBoolean);
  }
  
  public void b(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      a(paramMessageRecord.frienduin, paramMessageRecord);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, false, true, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("sendmsg", 2, String.format("addSendMessage key = %d %s %d", new Object[] { Long.valueOf(paramMessageRecord.uniseq), paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramMessageRecord);
      setChanged();
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  /* Error */
  public void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 400	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   7: astore 7
    //   9: aload 7
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload 7
    //   17: aload_1
    //   18: invokevirtual 1636	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)I
    //   21: istore 9
    //   23: iload 9
    //   25: sipush 6000
    //   28: if_icmple -14 -> 14
    //   31: iload 9
    //   33: sipush 5000
    //   36: isub
    //   37: sipush 1000
    //   40: invokestatic 1639	java/lang/Math:max	(II)I
    //   43: istore 9
    //   45: iload_2
    //   46: ifne +364 -> 410
    //   49: ldc_w 1641
    //   52: iconst_3
    //   53: anewarray 82	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_1
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: aload_1
    //   63: aastore
    //   64: dup
    //   65: iconst_2
    //   66: iload 9
    //   68: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: aastore
    //   72: invokestatic 477	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   75: astore_3
    //   76: ldc_w 1643
    //   79: iconst_3
    //   80: anewarray 82	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload_1
    //   90: aastore
    //   91: dup
    //   92: iconst_2
    //   93: iload 9
    //   95: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokestatic 477	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   102: astore 4
    //   104: iload_2
    //   105: ifne +113 -> 218
    //   108: iconst_2
    //   109: anewarray 202	java/lang/String
    //   112: astore 5
    //   114: aload 5
    //   116: iconst_0
    //   117: ldc_w 1644
    //   120: aastore
    //   121: aload 5
    //   123: iconst_1
    //   124: ldc_w 1645
    //   127: aastore
    //   128: aload 7
    //   130: aload_1
    //   131: aload 5
    //   133: aconst_null
    //   134: aconst_null
    //   135: aload 5
    //   137: iconst_0
    //   138: aaload
    //   139: iload 9
    //   141: invokestatic 1647	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   144: invokevirtual 1650	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   147: astore 6
    //   149: aload 6
    //   151: invokeinterface 1653 1 0
    //   156: ifeq +62 -> 218
    //   159: aload 6
    //   161: aload 6
    //   163: aload 5
    //   165: iconst_0
    //   166: aaload
    //   167: invokeinterface 1656 2 0
    //   172: invokeinterface 1660 2 0
    //   177: lstore 10
    //   179: aload 6
    //   181: aload 6
    //   183: aload 5
    //   185: iconst_1
    //   186: aaload
    //   187: invokeinterface 1656 2 0
    //   192: invokeinterface 416 2 0
    //   197: astore 5
    //   199: aload_0
    //   200: getfield 102	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   203: bipush 91
    //   205: invokevirtual 513	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   208: checkcast 1662	com/tencent/mobileqq/app/MessageRoamManager
    //   211: aload 5
    //   213: lload 10
    //   215: invokevirtual 1664	com/tencent/mobileqq/app/MessageRoamManager:a	(Ljava/lang/String;J)V
    //   218: aload_0
    //   219: getfield 102	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   222: invokevirtual 643	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   225: invokevirtual 1667	com/tencent/mobileqq/persistence/EntityManagerFactory:createMessageRecordEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   228: checkcast 1669	com/tencent/mobileqq/persistence/MessageRecordEntityManager
    //   231: astore 5
    //   233: aload 5
    //   235: invokevirtual 1672	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   238: astore 6
    //   240: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   243: lstore 10
    //   245: aload 6
    //   247: ifnull +8 -> 255
    //   250: aload 6
    //   252: invokevirtual 1675	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   255: aload 5
    //   257: aload 4
    //   259: aconst_null
    //   260: aload_0
    //   261: getfield 102	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   264: invokevirtual 1678	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   267: astore 4
    //   269: aload 4
    //   271: ifnull +332 -> 603
    //   274: aload 4
    //   276: invokeinterface 323 1 0
    //   281: astore 4
    //   283: aload 4
    //   285: invokeinterface 186 1 0
    //   290: ifeq +313 -> 603
    //   293: aload 4
    //   295: invokeinterface 190 1 0
    //   300: checkcast 295	com/tencent/mobileqq/data/MessageRecord
    //   303: astore 8
    //   305: aload 8
    //   307: invokevirtual 1681	com/tencent/mobileqq/data/MessageRecord:isSupportFTS	()Z
    //   310: ifeq -27 -> 283
    //   313: aload 8
    //   315: getfield 845	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   318: ifeq -35 -> 283
    //   321: aload 8
    //   323: getfield 846	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   326: sipush 63530
    //   329: if_icmpeq -46 -> 283
    //   332: aload 8
    //   334: invokestatic 1686	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/fts/FTSMessage;
    //   337: astore 8
    //   339: aload 8
    //   341: invokevirtual 1691	com/tencent/mobileqq/data/fts/FTSMessage:deleteOpt	()V
    //   344: aload 5
    //   346: aload 8
    //   348: invokestatic 1694	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/fts/FTSMessage;)Lcom/tencent/mobileqq/data/FTSMessageSync;
    //   351: invokevirtual 1697	com/tencent/mobileqq/persistence/MessageRecordEntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   354: goto -71 -> 283
    //   357: astore_1
    //   358: aload_1
    //   359: invokevirtual 429	java/lang/Exception:printStackTrace	()V
    //   362: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +29 -> 394
    //   368: ldc 87
    //   370: iconst_2
    //   371: new 158	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 1699
    //   381: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: aload 6
    //   396: ifnull +8 -> 404
    //   399: aload 6
    //   401: invokevirtual 1700	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   404: aload 5
    //   406: invokevirtual 1701	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()V
    //   409: return
    //   410: iload_2
    //   411: iconst_1
    //   412: if_icmpeq +17 -> 429
    //   415: iload_2
    //   416: sipush 3000
    //   419: if_icmpeq +10 -> 429
    //   422: iload_2
    //   423: sipush 1026
    //   426: if_icmpne +61 -> 487
    //   429: ldc_w 1703
    //   432: iconst_3
    //   433: anewarray 82	java/lang/Object
    //   436: dup
    //   437: iconst_0
    //   438: aload_1
    //   439: aastore
    //   440: dup
    //   441: iconst_1
    //   442: aload_1
    //   443: aastore
    //   444: dup
    //   445: iconst_2
    //   446: iload 9
    //   448: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   451: aastore
    //   452: invokestatic 477	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   455: astore_3
    //   456: ldc_w 1705
    //   459: iconst_3
    //   460: anewarray 82	java/lang/Object
    //   463: dup
    //   464: iconst_0
    //   465: aload_1
    //   466: aastore
    //   467: dup
    //   468: iconst_1
    //   469: aload_1
    //   470: aastore
    //   471: dup
    //   472: iconst_2
    //   473: iload 9
    //   475: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   478: aastore
    //   479: invokestatic 477	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   482: astore 4
    //   484: goto -380 -> 104
    //   487: ldc_w 1707
    //   490: iconst_3
    //   491: anewarray 82	java/lang/Object
    //   494: dup
    //   495: iconst_0
    //   496: aload_1
    //   497: aastore
    //   498: dup
    //   499: iconst_1
    //   500: aload_1
    //   501: aastore
    //   502: dup
    //   503: iconst_2
    //   504: iload 9
    //   506: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: aastore
    //   510: invokestatic 477	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   513: astore_3
    //   514: ldc_w 1709
    //   517: iconst_3
    //   518: anewarray 82	java/lang/Object
    //   521: dup
    //   522: iconst_0
    //   523: aload_1
    //   524: aastore
    //   525: dup
    //   526: iconst_1
    //   527: aload_1
    //   528: aastore
    //   529: dup
    //   530: iconst_2
    //   531: iload 9
    //   533: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   536: aastore
    //   537: invokestatic 477	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   540: astore 4
    //   542: goto -438 -> 104
    //   545: astore 5
    //   547: aconst_null
    //   548: astore 6
    //   550: aload 6
    //   552: ifnull +10 -> 562
    //   555: aload 6
    //   557: invokeinterface 432 1 0
    //   562: aload 5
    //   564: invokevirtual 429	java/lang/Exception:printStackTrace	()V
    //   567: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq -352 -> 218
    //   573: ldc 87
    //   575: iconst_2
    //   576: new 158	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 1699
    //   586: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload 5
    //   591: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: goto -382 -> 218
    //   603: aload 7
    //   605: aload_3
    //   606: invokevirtual 1710	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   609: pop
    //   610: aload 6
    //   612: ifnull +8 -> 620
    //   615: aload 6
    //   617: invokevirtual 1711	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   620: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +55 -> 678
    //   626: ldc 87
    //   628: iconst_2
    //   629: new 158	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   636: ldc_w 1713
    //   639: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload_1
    //   643: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: ldc_w 942
    //   649: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: iload 9
    //   654: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   657: ldc_w 1715
    //   660: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   666: lload 10
    //   668: lsub
    //   669: invokevirtual 1068	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   672: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: aload 6
    //   680: ifnull +8 -> 688
    //   683: aload 6
    //   685: invokevirtual 1700	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   688: aload 5
    //   690: invokevirtual 1701	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()V
    //   693: return
    //   694: astore_1
    //   695: aload 6
    //   697: ifnull +8 -> 705
    //   700: aload 6
    //   702: invokevirtual 1700	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   705: aload 5
    //   707: invokevirtual 1701	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()V
    //   710: aload_1
    //   711: athrow
    //   712: astore 5
    //   714: goto -164 -> 550
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	QQMessageFacade
    //   0	717	1	paramString	String
    //   0	717	2	paramInt	int
    //   75	531	3	str	String
    //   102	439	4	localObject1	Object
    //   112	293	5	localObject2	Object
    //   545	161	5	localException1	Exception
    //   712	1	5	localException2	Exception
    //   147	554	6	localObject3	Object
    //   7	597	7	localSQLiteDatabase	SQLiteDatabase
    //   303	44	8	localObject4	Object
    //   21	632	9	i1	int
    //   177	490	10	l1	long
    // Exception table:
    //   from	to	target	type
    //   240	245	357	java/lang/Exception
    //   250	255	357	java/lang/Exception
    //   255	269	357	java/lang/Exception
    //   274	283	357	java/lang/Exception
    //   283	354	357	java/lang/Exception
    //   603	610	357	java/lang/Exception
    //   615	620	357	java/lang/Exception
    //   620	678	357	java/lang/Exception
    //   108	114	545	java/lang/Exception
    //   128	149	545	java/lang/Exception
    //   240	245	694	finally
    //   250	255	694	finally
    //   255	269	694	finally
    //   274	283	694	finally
    //   283	354	694	finally
    //   358	394	694	finally
    //   603	610	694	finally
    //   615	620	694	finally
    //   620	678	694	finally
    //   149	218	712	java/lang/Exception
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong, true);
  }
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    int i1 = 1;
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong);
    if (a(paramInt).c(paramString, paramInt, paramLong) == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, localMessageRecord);
    }
    if (!paramBoolean) {}
    label127:
    label132:
    label147:
    do
    {
      for (;;)
      {
        return;
        if (localMessageRecord == null) {
          break label147;
        }
        if ((localMessageRecord instanceof MessageForLongMsg))
        {
          if (!MsgProxyUtils.a(localMessageRecord, a(localMessageRecord.frienduin, localMessageRecord.istroop))) {
            break label127;
          }
          paramInt = i1;
        }
        while (paramInt != 0)
        {
          if (!MsgProxyUtils.s(localMessageRecord.istroop)) {
            break label132;
          }
          a(localMessageRecord.istroop).a(localMessageRecord);
          return;
          paramInt = i1;
          if (!a(localMessageRecord)) {
            paramInt = 0;
          }
        }
      }
      a(localMessageRecord.istroop).b(localMessageRecord);
      return;
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.QQMessageFacade", 2, "removeMsgByUniseq error: message not found. uin=" + paramString + ",type=" + paramInt + ",uniseq=" + paramLong);
  }
  
  public void b(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    e(paramString, 3000);
  }
  
  public void b(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        a(localMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord, null, false, true, true);
      }
    }
    c(paramList);
  }
  
  public void b(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, false);
      paramString.a();
      paramString = MsgProxyUtils.a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      c(paramList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    return c(paramString, paramInt);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).c(paramString, paramInt, paramLong);
  }
  
  public void c()
  {
    a(0).c();
    a(3000).c();
    a(1).c();
    a(1026).c();
  }
  
  public void c(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        QQMessageFacade.Message localMessage = (QQMessageFacade.Message)localIterator.next();
        if (localMessage.istroop == paramInt) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localMessage);
        }
      }
    }
  }
  
  public void c(QQMessageFacade.Message paramMessage)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (a(this.jdField_a_of_type_JavaUtilList, paramMessage))
      {
        this.jdField_a_of_type_JavaUtilList.set(a(this.jdField_a_of_type_JavaUtilList, paramMessage), paramMessage);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramMessage);
    }
  }
  
  public void c(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "sendMessage: mr_uinType:" + paramMessageRecord.istroop + " mr_msgType:" + paramMessageRecord.msgtype);
    }
    try
    {
      if (paramMessageRecord.msgUid == 0L) {
        paramMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
      }
      if ((paramMessageRecord.msgtype == 64536) || (paramMessageRecord.msgtype == 64487)) {
        if (paramMessageRecord.istroop == 1001)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramMessageRecord.frienduin))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForText)paramMessageRecord);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
          return;
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "sendMessage ERROR:" + paramMessageRecord.getMessage(), paramMessageRecord);
        return;
        if (paramMessageRecord.istroop == 1003)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForText)paramMessageRecord);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
        return;
        if ((paramMessageRecord.msgtype == 63525) || (paramMessageRecord.msgtype == 63529) || (paramMessageRecord.msgtype == 60527) || (paramMessageRecord.msgtype == 63534) || (paramMessageRecord.msgtype == 63536) || (paramMessageRecord.msgtype == 63526) || (paramMessageRecord.msgtype == 63516) || (paramMessageRecord.msgtype == 63514) || (paramMessageRecord.msgtype == 63497) || (paramMessageRecord.msgtype == 60528) || (paramMessageRecord.msgtype == 60524) || (paramMessageRecord.msgtype == 64485) || (paramMessageRecord.msgtype == 63485) || (paramMessageRecord.msgtype == 64501)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, paramMessageObserver, paramBoolean);
        }
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    a(paramString, paramInt, true, false);
  }
  
  public void c(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    e(paramString, 0);
  }
  
  public void c(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(8020, true, paramList);
    }
  }
  
  public void c(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, true, false, true, true);
      paramString.a();
      paramString = MsgProxyUtils.a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      c(paramList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean c(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public int d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i1 = 0;
      while (localIterator.hasNext())
      {
        QQMessageFacade.Message localMessage = (QQMessageFacade.Message)localIterator.next();
        if (localMessage.istroop != 1008)
        {
          if (7000 != localMessage.istroop) {
            break label115;
          }
          SubAccountManager localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
          if (localSubAccountManager == null) {
            break label102;
          }
          i2 = localSubAccountManager.c(localMessage.frienduin);
          break label105;
        }
      }
      return i1;
    }
    label102:
    int i2 = 0;
    label105:
    int i1 = i2 + i1;
    for (;;)
    {
      break;
      label115:
      i1 += 1;
    }
  }
  
  public void d()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    boolean bool;
    int i1;
    if (this.p == -1)
    {
      bool = localEntityManager.d(ConversationInfo.getConversationInfoTableName());
      if (bool)
      {
        i1 = 1;
        this.p = i1;
      }
    }
    for (;;)
    {
      localEntityManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache start : Lazy : " + bool);
      }
      long l1 = System.currentTimeMillis();
      if (bool) {
        a(90, true);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache finish : TimeSpend:" + (System.currentTimeMillis() - l1));
        }
        return;
        i1 = 0;
        break;
        e();
      }
      bool = true;
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    a(paramInt).b(paramString, paramInt, false, false);
  }
  
  public boolean d(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(paramString, paramInt);
    }
    return false;
  }
  
  public int e()
  {
    int i2 = a(2);
    if ((i2 != 0) && (QLog.isColorLevel())) {
      QLog.d("Q.msg.QQMessageFacade", 2, "Recent Msg Unread=" + i2);
    }
    int i1 = i2;
    if (a().b(AppConstants.aC, 9000))
    {
      i1 = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((i1 != 0) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.QQMessageFacade", 2, "Recent TroopNotification Unread=" + i1);
      }
      i1 = i2 + i1;
    }
    if (a().b(AppConstants.bb, 7230))
    {
      i2 = ServiceAccountFolderManager.a().b();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "Recent PublicUnread Unread=" + i2);
      }
      i1 += i2;
    }
    for (;;)
    {
      i2 = i1;
      if (a().b(AppConstants.aU, 9003))
      {
        BlessManager localBlessManager = (BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137);
        i2 = i1;
        if (localBlessManager != null) {
          i2 = i1 + localBlessManager.b();
        }
      }
      return i2;
    }
  }
  
  public void e()
  {
    a("refreshCache", "");
    System.currentTimeMillis();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject1 = localEntityManager.a(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    int i2;
    if (localObject1 != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
      boolean bool1 = localEntityManager.d(ConversationInfo.getConversationInfoTableName());
      ConversationFacade localConversationFacade = a();
      StringBuilder localStringBuilder = new StringBuilder(128);
      Iterator localIterator = ((List)localObject1).iterator();
      int i1 = 0;
      boolean bool2;
      Object localObject2;
      label600:
      do
      {
        Object localObject3;
        do
        {
          do
          {
            do
            {
              i2 = i1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (Sqlite)localIterator.next();
              ((Sqlite)localObject3).tbl_name = SecurityUtile.a(((Sqlite)localObject3).tbl_name);
            } while (((Sqlite)localObject3).tbl_name.equals("mr_fileManager"));
            bool2 = ((Sqlite)localObject3).tbl_name.endsWith("_New");
            localObject2 = a(MsgProxyUtils.a(((Sqlite)localObject3).tbl_name)).a(((Sqlite)localObject3).tbl_name, localEntityManager);
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.QQMessageFacade", 4, "getMsgProxy().queryLastMessage = " + localObject2);
            }
          } while ((localObject2 == null) || ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).frienduin == null)));
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
            {
              a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
              localObject2 = a(((QQMessageFacade.Message)localObject2).istroop).a(((Sqlite)localObject3).tbl_name, localEntityManager);
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject2);
                localObject1 = localObject2;
              }
            }
          }
          if (localObject1 == null) {
            break label945;
          }
        } while (((AppConstants.aj.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName()))) || ((AppConstants.ak.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName(1)))));
        if (((!AppConstants.ar.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) == 1001)) || ((!AppConstants.aH.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) == 1010)))
        {
          localObject2 = a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if ((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(((MessageRecord)localObject3).frienduin)) && (!MessageUtils.a(((MessageRecord)localObject3).msgtype)))
              {
                ((QQMessageFacade.Message)localObject1).hasReply = true;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject1 + ",hasReply=" + ((QQMessageFacade.Message)localObject1).hasReply);
                }
              }
            }
          }
        }
        a((QQMessageFacade.Message)localObject1);
        if (!bool1)
        {
          d((QQMessageFacade.Message)localObject1);
          if (localList != null)
          {
            i2 = 0;
            if (i2 < localList.size())
            {
              localObject2 = (RecentUser)localList.get(i2);
              if ((localObject2 == null) || (((RecentUser)localObject2).uin == null) || (!((RecentUser)localObject2).uin.equals(((QQMessageFacade.Message)localObject1).frienduin))) {
                break;
              }
              if ((MsgProxyUtils.s(((QQMessageFacade.Message)localObject1).istroop)) && (a().a(((QQMessageFacade.Message)localObject1).frienduin, MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop))))
              {
                if (((QQMessageFacade.Message)localObject1).istroop != 1009) {
                  a(AppConstants.ag, 1009, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
                if (((QQMessageFacade.Message)localObject1).istroop != 1001) {
                  a(AppConstants.ar, 1001, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
              }
            }
          }
          localStringBuilder.setLength(0);
          localStringBuilder.append("refreshCache message uin = ").append(((QQMessageFacade.Message)localObject1).frienduin).append(", type = ").append(((QQMessageFacade.Message)localObject1).istroop).append(", unread = ").append(((QQMessageFacade.Message)localObject1).unReadNum).append(", time = ").append(((QQMessageFacade.Message)localObject1).time);
          a(localStringBuilder.toString(), "");
        }
        localObject2 = b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      } while ((!bool2) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2)));
      this.jdField_a_of_type_JavaUtilMap.put(localObject2, localObject1);
      i2 = i1 + 1;
      i1 = i2;
      if (!bool1)
      {
        localConversationFacade.b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, ((QQMessageFacade.Message)localObject1).unReadNum);
        i1 = i2;
      }
    }
    label945:
    for (;;)
    {
      break;
      i2 += 1;
      break label600;
      i2 = 0;
      localEntityManager.a();
      MsgAutoMonitorUtil.a().a("MSG_TableNum", i2 + "");
      return;
    }
  }
  
  public void e(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "removeNotification uin" + paramString + ",type:" + paramInt);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Object localObject = null;
    for (;;)
    {
      QQMessageFacade.Message localMessage;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label302;
        }
        localMessage = (QQMessageFacade.Message)localIterator.next();
        if (((paramInt == localMessage.istroop) || ((MsgProxyUtils.c(paramInt)) && (MsgProxyUtils.c(localMessage.istroop)))) && (localMessage.frienduin.equals(paramString)))
        {
          localMessage.counter = 0;
          localIterator.remove();
          bool1 = true;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder().append("removeNotification remove:").append(bool1).append(",preMsg is null");
            if (localObject != null) {
              break label287;
            }
            bool2 = true;
            QLog.d("notification", 2, bool2 + ",iterator.hasNext():" + localIterator.hasNext());
          }
          if (!bool1) {
            break label293;
          }
          if ((localObject != null) || (!localIterator.hasNext())) {
            break label297;
          }
          paramString = (QQMessageFacade.Message)localIterator.next();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString);
          return;
        }
      }
      localObject = localMessage;
      continue;
      label287:
      boolean bool2 = false;
      continue;
      label293:
      return;
      label297:
      paramString = (String)localObject;
      continue;
      label302:
      boolean bool1 = false;
    }
  }
  
  public int f()
  {
    return a(6);
  }
  
  public void f()
  {
    Object localObject1 = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject1 = localSQLiteDatabase.a((String)localObject1, new String[] { "uin", "type" }, null, null, null, null);
    if (localObject1 != null) {}
    try
    {
      ((Cursor)localObject1).moveToFirst();
      int i1 = 0;
      while (i1 < ((Cursor)localObject1).getCount())
      {
        a(((Cursor)localObject1).getString(0), ((Cursor)localObject1).getInt(1), false, true);
        ((Cursor)localObject1).moveToNext();
        i1 += 1;
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      a(0).e();
      a(0).d();
      a(3000).e();
      a(3000).d();
      a(1).e();
      a(1).d();
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
  }
  
  public void f(String paramString, int paramInt)
  {
    paramString = new QQMessageFacade.MessageNotifyParam(paramString, paramInt, 0, null);
    setChanged();
    notifyObservers(paramString);
  }
  
  public int g()
  {
    return a(7);
  }
  
  public void g()
  {
    Object localObject = new RecentUser().getTableName();
    String str1 = new TroopAssistantData().getTableName();
    String str2 = new PubAccountAssistantData().getTableName();
    String str3 = new TroopBarData().getTableName();
    String str4 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.a((String)localObject, null, null);
    localSQLiteDatabase.a(str1, null, null);
    localSQLiteDatabase.a(str2, null, null);
    localSQLiteDatabase.a(str4, null, null);
    localSQLiteDatabase.a(str3, null, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    localObject = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localObject != null)
    {
      ((RecommendTroopManagerImp)localObject).b();
      ((RecommendTroopManagerImp)localObject).a(1);
    }
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c();
  }
  
  public void g(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() < 5)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null) || (paramString == null) || (paramString.length() < 5)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
  }
  
  public int h()
  {
    return a(8);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, true);
  }
  
  public int i()
  {
    return a(9);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, true);
  }
  
  public void j()
  {
    n();
  }
  
  public void k()
  {
    h(AppConstants.ag, 1009);
    h(AppConstants.ar, 1001);
    h(AppConstants.aH, 1010);
  }
  
  /* Error */
  public void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 1972	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: aload_0
    //   8: getfield 102	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 1267	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual 1978	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: astore_1
    //   19: aload_1
    //   20: ldc 26
    //   22: lconst_0
    //   23: invokeinterface 1983 4 0
    //   28: lstore 7
    //   30: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   33: ldc2_w 1984
    //   36: ldiv
    //   37: lload 7
    //   39: lsub
    //   40: ldc2_w 1986
    //   43: lcmp
    //   44: ifge +4 -> 48
    //   47: return
    //   48: aload_0
    //   49: lload 7
    //   51: invokespecial 1989	com/tencent/mobileqq/app/message/QQMessageFacade:a	(J)V
    //   54: new 158	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 1991
    //   61: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: astore_2
    //   65: aload_0
    //   66: getfield 76	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: astore 4
    //   71: aload 4
    //   73: monitorenter
    //   74: new 73	java/util/concurrent/ConcurrentHashMap
    //   77: dup
    //   78: aload_0
    //   79: getfield 76	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   82: invokespecial 1994	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   85: astore_3
    //   86: aload_0
    //   87: getfield 76	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   90: invokevirtual 1995	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   93: aload 4
    //   95: monitorexit
    //   96: aload_3
    //   97: invokevirtual 397	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   100: invokeinterface 181 1 0
    //   105: astore 4
    //   107: aload 4
    //   109: invokeinterface 186 1 0
    //   114: ifeq +109 -> 223
    //   117: aload 4
    //   119: invokeinterface 190 1 0
    //   124: checkcast 202	java/lang/String
    //   127: astore 5
    //   129: aload_3
    //   130: aload 5
    //   132: invokevirtual 1996	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 352	java/lang/Integer
    //   138: invokevirtual 1999	java/lang/Integer:intValue	()I
    //   141: istore 6
    //   143: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +22 -> 168
    //   149: aload_2
    //   150: ldc_w 2001
    //   153: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 5
    //   158: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc_w 2003
    //   164: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_0
    //   169: aload 5
    //   171: iload 6
    //   173: invokevirtual 2004	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;I)V
    //   176: goto -69 -> 107
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 429	java/lang/Exception:printStackTrace	()V
    //   184: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq -140 -> 47
    //   190: ldc 87
    //   192: iconst_2
    //   193: new 158	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 2006
    //   203: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: return
    //   217: astore_1
    //   218: aload 4
    //   220: monitorexit
    //   221: aload_1
    //   222: athrow
    //   223: aload_1
    //   224: invokeinterface 2010 1 0
    //   229: ldc 26
    //   231: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   234: ldc2_w 1984
    //   237: ldiv
    //   238: invokeinterface 2016 4 0
    //   243: invokeinterface 2019 1 0
    //   248: pop
    //   249: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq -205 -> 47
    //   255: ldc 87
    //   257: iconst_2
    //   258: aload_2
    //   259: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	QQMessageFacade
    //   18	2	1	localSharedPreferences	android.content.SharedPreferences
    //   179	28	1	localException	Exception
    //   217	7	1	localObject1	Object
    //   64	195	2	localStringBuilder	StringBuilder
    //   85	45	3	localConcurrentHashMap	ConcurrentHashMap
    //   127	43	5	str	String
    //   141	31	6	i1	int
    //   28	22	7	l1	long
    // Exception table:
    //   from	to	target	type
    //   48	54	179	java/lang/Exception
    //   74	96	217	finally
    //   218	221	217	finally
  }
  
  public void m()
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
    if (localConcurrentHashMap.isEmpty()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "handleRevokeNotifyAfterSyncMsg");
    }
    Iterator localIterator = localConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      ArrayList localArrayList = (ArrayList)localConcurrentHashMap.get(localIterator.next());
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        int i1 = ((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_Int;
        if (i1 == 3000)
        {
          if (((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_JavaLangString) == null) {}
        }
        else
        {
          String str1;
          do
          {
            do
            {
              a(localArrayList, true);
              break;
            } while (i1 != 0);
            RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)localArrayList.get(0);
            String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            String str2 = localRevokeMsgInfo.b;
            str1 = str2;
            if (TextUtils.equals(str3, str2)) {
              str1 = localRevokeMsgInfo.jdField_a_of_type_JavaLangString;
            }
          } while (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).e(str1));
        }
      }
    }
    localConcurrentHashMap.clear();
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l1 = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    MsgAutoMonitorUtil.a().c(System.currentTimeMillis() - l1);
    MsgAutoMonitorUtil.a().c();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a();
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_Boolean = false;
      deleteObservers();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\QQMessageFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */