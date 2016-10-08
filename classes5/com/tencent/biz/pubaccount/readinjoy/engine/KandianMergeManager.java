package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import hxn;
import hxo;
import hxp;
import hxq;
import hxr;
import hxs;
import hxt;
import hxu;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class KandianMergeManager
  implements Manager
{
  public static final int a = -1;
  public static final String a = "KandianMergeManager";
  public static final int b = 0;
  public static final String b = "kandian_push_msg_xml";
  public static final int c = 1;
  public static final String c = "kandian_push_msg_time";
  public static final int d = 1;
  public static final String d = "subscribe_push_msg_time";
  public static final int e = 2;
  public static final String e = "subscribe_push_msg_uin";
  public static final int f = 3;
  public static final String f = "subscribe_push_msg_xml";
  public static final int g = 0;
  public static final String g = "subscribe_push_msg_status";
  public static final int h = 1;
  public static final String h = "subscribe_push_msg_msgtype";
  public static final int i = 2;
  public static final String i = "kandian_push_from";
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = -1;
  public static final int m = 0;
  public static final int n = 1;
  public long a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Long jdField_a_of_type_JavaLangLong;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  public long b;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong;
  private AtomicInteger c;
  private AtomicInteger d;
  private String j;
  private String k;
  private String l;
  
  public KandianMergeManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.j = "";
    this.c = new AtomicInteger(-1);
    this.d = new AtomicInteger(-1);
    e();
  }
  
  public static int a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return -1;
      } while (((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.ba)));
      if ((paramMessageRecord.extInt == 1) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.ba))) {
        return 0;
      }
      if ((paramMessageRecord.extInt == 2) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.ba))) {
        return 1;
      }
      if (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.aZ)) {
        return 0;
      }
    } while ((paramMessageRecord.istroop != 1008) || (!ServiceAccountFolderManager.c(paramQQAppInterface, paramMessageRecord.frienduin)));
    return 1;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {}
    while ((!paramBoolean) && ((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.msg, paramString1))) {
      return null;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(64536);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = 64536;
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(64536);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.ba;
    paramMessageRecord.senderuin = AppConstants.ba;
    paramMessageRecord.istroop = 7220;
    paramMessageRecord.msg = paramString1;
    for (;;)
    {
      try
      {
        paramMessageRecord.time = Long.parseLong(paramString2);
        if (paramInt == 0)
        {
          paramMessageRecord.extInt = 3;
          paramMessageRecord.extLong = 0;
          return;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      if (paramInt == 1) {
        paramMessageRecord.extInt = 4;
      } else {
        paramMessageRecord.extInt = 0;
      }
    }
  }
  
  private void e()
  {
    int i2 = 0;
    Object localObject1 = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    Object localObject2 = ((SharedPreferences)localObject1).getString("kandian_push_msg_xml", "");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    int i1;
    try
    {
      localObject2 = StructMsgFactory.a(PkgTools.a((String)localObject2));
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mArticleIds))
      {
        String[] arrayOfString = ((AbsStructMsg)localObject2).mArticleIds.split("\\|");
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        i1 = 0;
        while (i1 < arrayOfString.length)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(arrayOfString[i1]));
          i1 += 1;
        }
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mAlgorithmIds)) {
        this.jdField_a_of_type_Long = Long.parseLong(localObject2.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mStrategyIds)) {
        this.jdField_b_of_type_Long = Long.parseLong(localObject2.mStrategyIds.split("\\|")[0]);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      l1 = ((SharedPreferences)localObject1).getLong("kandian_push_msg_time", 0L);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l1);
    }
    catch (Exception localException)
    {
      label400:
      label409:
      do
      {
        for (;;)
        {
          long l1;
          int i3;
          localException.printStackTrace();
          continue;
          i1 += 1;
        }
      } while (TextUtils.isEmpty(((AbsStructMsg)localObject1).mArticleIds));
      localObject1 = ((AbsStructMsg)localObject1).mArticleIds.split("\\|");
      i2 = localObject1.length;
      i1 = 0;
    }
    this.k = "";
    this.l = "";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
    l1 = ((SharedPreferences)localObject1).getLong("subscribe_push_msg_time", 0L);
    if (l1 >= 0L)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l1);
      this.j = ((SharedPreferences)localObject1).getString("subscribe_push_msg_uin", "");
      this.c.set(((SharedPreferences)localObject1).getInt("subscribe_push_msg_status", -1));
      this.d.set(((SharedPreferences)localObject1).getInt("subscribe_push_msg_msgtype", -1));
      if (this.c.get() != 3) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      }
      localObject1 = ((SharedPreferences)localObject1).getString("subscribe_push_msg_xml", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = StructMsgFactory.a(PkgTools.a((String)localObject1));
        if (localObject1 != null)
        {
          this.k = ((AbsStructMsg)localObject1).mMsgBrief;
          if (TextUtils.isEmpty(((AbsStructMsg)localObject1).mInnerUniqIds)) {
            break label409;
          }
          localObject1 = ((AbsStructMsg)localObject1).mInnerUniqIds.split("\\|");
          i3 = localObject1.length;
          i1 = i2;
          if (i1 < i3)
          {
            localObject2 = localObject1[i1];
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label400;
            }
            this.l = ((String)localObject2);
          }
        }
      }
    }
    for (;;)
    {
      return;
      while (i1 < i2)
      {
        CharSequence localCharSequence = localObject1[i1];
        if (!TextUtils.isEmpty(localCharSequence))
        {
          this.jdField_a_of_type_JavaLangLong = Long.valueOf(localCharSequence);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return 0;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    }
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return -1;
      if (!TextUtils.isEmpty(paramMessageRecord.extStr)) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord.extStr);
          if (paramMessageRecord.has("kandian_push_from"))
          {
            int i1 = Integer.parseInt(paramMessageRecord.getString("kandian_push_from"));
            return i1;
          }
        }
        catch (Exception paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  public Pair a()
  {
    if ((!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.c.get() != 3)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.c.get() == 2))) {}
    do
    {
      return null;
      b(2);
      QLog.d("KandianMergeManager", 1, "mSubscribePushMsgTitle : " + ReadInJoyUtils.c(this.k) + " mSubscribePushMsgArticleID : " + this.jdField_a_of_type_JavaLangLong + " mInnerUniqId : " + this.l + " seedUIN :  " + this.j + ", isInterestedAccount : " + PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.j, this.d.get()));
    } while ((TextUtils.isEmpty(this.k)) || ((TextUtils.isEmpty(this.l)) && (this.jdField_a_of_type_JavaLangLong.longValue() == -1L)));
    if ((ReadInJoyHelper.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(this.l))) {
      return new Pair(this.l, this.k);
    }
    return new Pair(this.jdField_a_of_type_JavaLangLong, this.k);
  }
  
  public MessageRecord a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ba, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i1 = ((List)localObject).size() - 1;
      if (i1 >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i1);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4)) {}
        while ((!localMessageRecord.isValid) || (MsgProxyUtils.g(localMessageRecord.msgtype)))
        {
          i1 -= 1;
          break;
        }
      }
    }
    for (;;)
    {
      localObject = localMessageRecord;
      if (localMessageRecord == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ba, 7220, "extInt=1 OR extInt=3");
      }
      return (MessageRecord)localObject;
      localMessageRecord = null;
    }
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while (((paramMessageRecord.extInt == 1) && (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || (!a(paramMessageRecord))) {
      return null;
    }
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localQQMessageFacade != null) {}
    for (MessageRecord localMessageRecord = localQQMessageFacade.a(AppConstants.ba, 7220);; localMessageRecord = null)
    {
      String str2;
      String str1;
      if ((localMessageRecord != null) && (paramMessageRecord.extInt == 2) && (localMessageRecord.extInt == 2) && (!localMessageRecord.isread)) {
        if (QLog.isColorLevel())
        {
          str2 = "lastMr_info 【" + "msg: " + ReadInJoyUtils.c(localMessageRecord.msg) + ", msguid : " + localMessageRecord.msgUid;
          str1 = str2;
          if ((localMessageRecord instanceof MessageForStructing))
          {
            localMessageForStructing = (MessageForStructing)localMessageRecord;
            localMessageForStructing.parse();
            str1 = str2;
            if (localMessageForStructing.structingMsg != null) {
              str1 = str2 + ", title : " + ReadInJoyUtils.c(localMessageForStructing.structingMsg.mMsgBrief) + " 】";
            }
          }
          str2 = "newMr_info 【" + "msg: " + ReadInJoyUtils.c(paramMessageRecord.msg) + ", senderUin : " + paramMessageRecord.senderuin + " , msguid : " + paramMessageRecord.msgUid;
          if (!(paramMessageRecord instanceof MessageForStructing)) {
            break label496;
          }
          MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
          localMessageForStructing.parse();
          if (localMessageForStructing.structingMsg == null) {
            break label496;
          }
          str2 = str2 + ", title : " + ReadInJoyUtils.c(localMessageForStructing.structingMsg.mMsgBrief) + " 】";
        }
      }
      label496:
      for (;;)
      {
        QLog.i("KandianMergeManager", 2, "subscribe push msg cover ! \n" + str1 + "\n" + str2);
        localQQMessageFacade.a(localMessageRecord, false);
        localMessageRecord = MessageRecordFactory.a(paramMessageRecord.msgtype);
        MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
        localMessageRecord.frienduin = AppConstants.ba;
        localMessageRecord.istroop = 7220;
        int i1 = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (i1 == 0)
        {
          localMessageRecord.extInt = 1;
          b(localMessageRecord, 0);
        }
        while (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localMessageRecord.extLong = 1;
          return localMessageRecord;
          if (i1 == 1) {
            localMessageRecord.extInt = 2;
          } else {
            localMessageRecord.extInt = 0;
          }
        }
        localMessageRecord.extLong |= 0x2;
        return localMessageRecord;
      }
    }
  }
  
  public MessageRecord a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(63525);
    localMessageForStructing.istroop = 7220;
    localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
    localMessageForStructing.frienduin = AppConstants.ba;
    localMessageForStructing.senderuin = AppConstants.aZ;
    localMessageForStructing.time = ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localMessageForStructing.isread = false;
    localMessageForStructing.issend = 0;
    localMessageForStructing.extInt = 1;
    localMessageForStructing.extLong = 1;
    localMessageForStructing.structingMsg = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing.istroop, Long.valueOf(localMessageForStructing.senderuin).longValue(), paramString.getBytes(), 0);
    if (localMessageForStructing.structingMsg == null) {
      return null;
    }
    localMessageForStructing.msg = localMessageForStructing.structingMsg.mMsgBrief;
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    b(localMessageForStructing, 1);
    if (!a(localMessageForStructing)) {
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
    return localMessageForStructing;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
      return localArrayList;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_Long));
      localArrayList.add(Long.valueOf(this.jdField_b_of_type_Long));
    }
    QLog.i("KandianMergeManager", 1, "getKandianArticleIdsWhenRefreshKandian: " + localArrayList.toString());
    c();
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
      if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.j, this.d.get())) {
        b();
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      localObject1 = TroopBarAssistantManager.a();
      if (localObject1 != null) {
        ((TroopBarAssistantManager)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (i1 != 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ba, 7220);
        if (localObject1 == null) {
          break label229;
        }
        if ((((MessageRecord)localObject1).extInt != 1) && (((MessageRecord)localObject1).extInt != 3)) {
          break;
        }
      }
      return;
      b(3);
    }
    long l1 = ((MessageRecord)localObject1).time;
    label111:
    Object localObject1 = a();
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131362982);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131362982);
      }
      localObject1 = a((String)localObject2, String.valueOf(l1), 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : last msg is interested account,replace by kandian. " + ((MessageRecord)localObject1).msg);
      return;
      label229:
      l1 = NetConnInfoCenter.getServerTime();
      break label111;
      if ((((MessageRecord)localObject1).extInt == 1) && ((localObject1 instanceof MessageForStructing)))
      {
        localObject2 = (MessageForStructing)localObject1;
        ((MessageForStructing)localObject2).parse();
        if (((MessageForStructing)localObject2).structingMsg == null) {
          localObject1 = ((MessageRecord)localObject1).msg;
        } else {
          localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
        }
      }
      else
      {
        localObject1 = ((MessageRecord)localObject1).msg;
      }
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0);
    b();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (((TextUtils.equals(paramMessageRecord.frienduin, AppConstants.aZ)) && (paramMessageRecord.istroop == 1008)) || ((TextUtils.equals(paramMessageRecord.frienduin, AppConstants.ba)) && (paramMessageRecord.istroop == 7220))) {
      paramInt = 1;
    }
    for (;;)
    {
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ba, 7220);
      if ((paramInt == 0) || (paramMessageRecord == null) || (paramMessageRecord.isread)) {
        break;
      }
      paramMessageRecord.isread = true;
      ThreadManager.a(new hxo(this, paramMessageRecord), 10, null, false);
      return;
      if ((paramMessageRecord.istroop == 1008) && (ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (TextUtils.equals(paramString, this.j))
      {
        b();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ba, 7220);
        if ((localMessageRecord != null) && (localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, paramString)))
        {
          paramString = a();
          if (paramString != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || ((paramInt != 0) && (paramInt != 1))) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      do
      {
        return;
      } while (paramInt == 1);
      localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (localQQMessageFacade == null);
    ThreadManager.a(new hxn(this, localQQMessageFacade, paramString1, paramString2, paramInt, paramBoolean), 10, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ReadInJoyUtils.a(localQQAppInterface, paramBoolean);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    int i1 = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i1 == 0) {
      return c(paramMessageRecord);
    }
    if (i1 == 1) {
      return b(paramMessageRecord);
    }
    return false;
  }
  
  public MessageRecord b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ba, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i1 = ((List)localObject).size() - 1;
      if (i1 >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i1);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4) || (localMessageRecord.extInt == 3)) {}
        while ((!localMessageRecord.isValid) || (MsgProxyUtils.g(localMessageRecord.msgtype)))
        {
          i1 -= 1;
          break;
        }
      }
    }
    for (;;)
    {
      localObject = localMessageRecord;
      if (localMessageRecord == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ba, 7220, "extInt=1");
      }
      return (MessageRecord)localObject;
      localMessageRecord = null;
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      this.j = "";
      this.c.set(-1);
      ThreadManager.b().post(new hxr(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 3) {}
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.c.set(paramInt);
      ThreadManager.b().post(new hxq(this, paramInt));
      return;
    }
    finally {}
  }
  
  public void b(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramMessageRecord.extStr))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("kandian_push_from", paramInt);
        paramMessageRecord.extStr = localJSONObject.toString();
        return;
      }
    }
    catch (JSONException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      return;
    }
    JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
    localJSONObject.put("kandian_push_from", paramInt);
    paramMessageRecord.extStr = localJSONObject.toString();
  }
  
  public void b(boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.ba, 7220);
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      localObject = new RecentUser();
      ((RecentUser)localObject).uin = AppConstants.ba;
      ((RecentUser)localObject).type = 7220;
    }
    if (paramBoolean) {}
    for (((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);; ((RecentUser)localObject).showUpTime = 0L)
    {
      localRecentUserProxy.a((RecentUser)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    do
    {
      return false;
      QLog.d("KandianMergeManager", 1, "SubUnread : " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", SubStatus : " + this.c.get() + ", mSubTitle : " + ReadInJoyUtils.c(this.k) + ", KDUnread : " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) || (this.c.get() != 1)) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.c.get() != 3) || ((!ReadInJoyHelper.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (PublicAccountUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.j)))));
    return true;
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      int i1;
      try
      {
        long l1 = paramMessageRecord.time;
        String str = paramMessageRecord.senderuin;
        int i2 = paramMessageRecord.msgtype;
        Object localObject2 = "";
        if (l1 > this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
        {
          this.k = "";
          this.l = "";
          this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
          if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramMessageRecord.msgtype))
          {
            bool = true;
            localObject1 = "";
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l1);
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
            this.j = str;
            this.c.set(1);
            this.d.set(i2);
            ThreadManager.b().post(new hxp(this, l1, str, 1, (String)localObject1, i2));
            if (QLog.isColorLevel()) {
              QLog.d("KandianMergeManager", 2, "subscribe push, title : " + this.k + ", id : " + this.jdField_a_of_type_JavaLangLong + ", msguid : " + paramMessageRecord.msgUid + ", isInterestedAccount : " + bool);
            }
            bool = true;
            return bool;
          }
          if ((paramMessageRecord instanceof MessageForStructing))
          {
            Object localObject3 = (MessageForStructing)paramMessageRecord;
            ((MessageForStructing)localObject3).parse();
            if (((MessageForStructing)localObject3).structingMsg != null)
            {
              localObject1 = PkgTools.b(((MessageForStructing)localObject3).structingMsg.getBytes());
              this.k = ((MessageForStructing)localObject3).structingMsg.mMsgBrief;
              int i3;
              if (!TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mInnerUniqIds))
              {
                localObject2 = ((MessageForStructing)localObject3).structingMsg.mInnerUniqIds.split("\\|");
                i3 = localObject2.length;
                i1 = 0;
                if (i1 >= i3) {
                  break label450;
                }
                localObject3 = localObject2[i1];
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label456;
                }
                this.l = ((String)localObject3);
                break label450;
              }
              localObject2 = localObject1;
              if (!TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mArticleIds))
              {
                localObject3 = ((MessageForStructing)localObject3).structingMsg.mArticleIds.split("\\|");
                i3 = localObject3.length;
                i1 = 0;
                localObject2 = localObject1;
                if (i1 < i3)
                {
                  localObject2 = localObject3[i1];
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    break label465;
                  }
                  this.jdField_a_of_type_JavaLangLong = Long.valueOf((String)localObject2);
                  break label450;
                }
              }
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("KandianMergeManager", 2, "parse subscribe push struct msg fail !");
            }
            bool = false;
            localObject1 = "";
            continue;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        Object localObject1 = localObject2;
      }
      finally {}
      label450:
      boolean bool = false;
      continue;
      label456:
      i1 += 1;
      continue;
      label465:
      i1 += 1;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      ThreadManager.b().post(new hxt(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean c()
  {
    return !ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          Object localObject = (MessageForStructing)paramMessageRecord;
          ((MessageForStructing)localObject).parse();
          if (((MessageForStructing)localObject).structingMsg == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("KandianMergeManager", 2, "kandian push msg : struct msg body is null");
            }
            bool = false;
            return bool;
          }
          localObject = PkgTools.b(((MessageForStructing)paramMessageRecord).structingMsg.getBytes());
          long l1 = paramMessageRecord.time;
          if (paramMessageRecord.time > this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
          {
            if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds))
            {
              String[] arrayOfString = ((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds.split("\\|");
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              if (i1 < arrayOfString.length)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(arrayOfString[i1]));
                i1 += 1;
                continue;
              }
            }
            if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds)) {
              this.jdField_a_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds.split("\\|")[0]);
            }
            if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds)) {
              this.jdField_b_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds.split("\\|")[0]);
            }
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramMessageRecord.time);
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
            ThreadManager.b().post(new hxs(this, (String)localObject, l1));
            if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.c.get() != 2))
            {
              b(2);
              if (!QLog.isColorLevel()) {
                break label393;
              }
              QLog.d("KandianMergeManager", 2, "kandian push, ids: " + this.jdField_a_of_type_JavaUtilArrayList + ", msgUid : " + paramMessageRecord.msgUid);
              break label393;
            }
            if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.c.get() != 3)) {
              continue;
            }
            b();
            continue;
          }
        }
        bool = false;
      }
      finally {}
      continue;
      label393:
      boolean bool = true;
    }
  }
  
  public void d()
  {
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    String str;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      str = AppConstants.ba;
    }
    for (int i1 = 7220;; i1 = 1008)
    {
      if ((localConversationFacade != null) && (localConversationFacade.a(str, i1) > 0)) {
        ThreadManager.a(new hxu(this, str, i1), 8, null, false);
      }
      return;
      str = AppConstants.aZ;
    }
  }
  
  public boolean d()
  {
    RecentUser localRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(AppConstants.ba, 7220);
    if (localRecentUser == null) {}
    while (localRecentUser.showUpTime == 0L) {
      return false;
    }
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\engine\KandianMergeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */