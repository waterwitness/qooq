package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.AbilityUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.manager.Manager;
import uaa;
import uab;
import uac;
import uad;
import uae;

public class QCallFacade
  extends Observable
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = QCallFacade.class.getSimpleName();
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new uab(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new uaa(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QCallFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
  }
  
  private long a(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface.a();
    return localBaseApplication.getSharedPreferences("voice_tab_time", 0).getLong(paramQQAppInterface, 0L);
  }
  
  private QCallRecent a(MessageForVideo paramMessageForVideo)
  {
    int i = 1;
    Object localObject = paramMessageForVideo.frienduin;
    long l = paramMessageForVideo.time;
    QCallRecent localQCallRecent = a().a((String)localObject, paramMessageForVideo.istroop);
    localQCallRecent.uin = ((String)localObject);
    localQCallRecent.type = paramMessageForVideo.istroop;
    localQCallRecent.sendFlag = paramMessageForVideo.issend;
    localQCallRecent.lastCallMsg = MsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMessageForVideo.text);
    if (l > localQCallRecent.lastCallTime)
    {
      localQCallRecent.lastCallTime = l;
      localQCallRecent.isSystemCall = 0;
    }
    if ((localQCallRecent.type == 1000) || (localQCallRecent.type == 1020) || (localQCallRecent.type == 1004)) {
      localQCallRecent.troopUin = paramMessageForVideo.senderuin;
    }
    localQCallRecent.missedCallCount = c(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
    localObject = paramMessageForVideo.msg;
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 3)) {
        break label221;
      }
      if (!"1".equals(localObject[3])) {
        break label215;
      }
    }
    label215:
    label221:
    for (localQCallRecent.isVideo = i;; localQCallRecent.isVideo = 1)
    {
      localQCallRecent.isLastCallRealMissed = a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      localQCallRecent.callType = a(paramMessageForVideo, localQCallRecent.type);
      return localQCallRecent;
      i = 0;
      break;
    }
  }
  
  private QCallRecord a(MessageForVideo paramMessageForVideo)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getMessageToCallRecord message is null");
      }
      return null;
    }
    QCallRecord localQCallRecord = new QCallRecord();
    localQCallRecord.friendUin = paramMessageForVideo.frienduin;
    localQCallRecord.time = paramMessageForVideo.time;
    localQCallRecord.uinType = paramMessageForVideo.istroop;
    localQCallRecord.senderuin = paramMessageForVideo.senderuin;
    localQCallRecord.issend = paramMessageForVideo.issend;
    localQCallRecord.uniseq = paramMessageForVideo.uniseq;
    if ((localQCallRecord.uinType == 1000) || (localQCallRecord.uinType == 1020) || (localQCallRecord.uinType == 1004)) {
      localQCallRecord.troopUin = paramMessageForVideo.senderuin;
    }
    Object localObject = paramMessageForVideo.msg;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getMessageToCallRecord message's msg is null");
      }
      return null;
    }
    String[] arrayOfString = ((String)localObject).split("\\|");
    int i;
    label185:
    String str;
    if ((arrayOfString != null) && (arrayOfString.length > 3)) {
      if ("1".equals(arrayOfString[3]))
      {
        i = 1;
        localQCallRecord.isVideo = i;
        if (arrayOfString.length <= 3) {
          break label519;
        }
        str = arrayOfString[0].trim();
      }
    }
    try
    {
      localQCallRecord.state = Integer.parseInt(arrayOfString[1]);
      paramMessageForVideo = str;
    }
    catch (Exception paramMessageForVideo)
    {
      for (;;)
      {
        label213:
        if ((localObject != null) && (((String)localObject).length() > 0) && (((String)localObject).charAt(0) == '\026'))
        {
          paramMessageForVideo = str;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg is " + (String)localObject);
            paramMessageForVideo = str;
          }
        }
        else
        {
          localQCallRecord.state = 5;
          paramMessageForVideo = str;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg byte " + Utils.a((String)localObject));
            paramMessageForVideo = str;
          }
        }
      }
    }
    if (((localQCallRecord.state == 0) || (localQCallRecord.state == 2) || (localQCallRecord.state == 24) || (localQCallRecord.state == 46) || (localQCallRecord.state == 47) || (localQCallRecord.state == 48) || (localQCallRecord.state == 59) || (localQCallRecord.state == 9) || (localQCallRecord.state == 15)) && (paramMessageForVideo != null))
    {
      paramMessageForVideo = paramMessageForVideo.split(" ");
      if (paramMessageForVideo != null)
      {
        if (paramMessageForVideo.length <= 1) {
          break label531;
        }
        localQCallRecord.talkTime = paramMessageForVideo[1];
      }
    }
    label319:
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder().append("getMessageToCallRecord:");
      if (localQCallRecord == null) {
        break label579;
      }
    }
    label519:
    label531:
    label579:
    for (paramMessageForVideo = localQCallRecord.toString();; paramMessageForVideo = "")
    {
      QLog.d(str, 2, paramMessageForVideo);
      return localQCallRecord;
      i = 0;
      break;
      localQCallRecord.isVideo = 1;
      break label185;
      paramMessageForVideo = "";
      localQCallRecord.state = 5;
      break label213;
      if (paramMessageForVideo.length != 1) {
        break label319;
      }
      if ((2 == localQCallRecord.state) || (24 == localQCallRecord.state))
      {
        localQCallRecord.state = 12;
        break label319;
      }
      if (localQCallRecord.state != 0) {
        break label319;
      }
      localQCallRecord.state = 12;
      break label319;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      BaseApplication localBaseApplication = paramQQAppInterface.a();
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface == null) {
        return null;
      }
      paramQQAppInterface = localBaseApplication.getSharedPreferences("call_time_use_up", 0).getString(paramQQAppInterface + "_wording", null);
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface) {}
    return null;
  }
  
  private void a(int paramInt)
  {
    setChanged();
    notifyObservers(Integer.valueOf(paramInt));
    if (a().a())
    {
      setChanged();
      notifyObservers(Boolean.valueOf(true));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences("voice_tab_time", 0);
    if (!paramQQAppInterface.getBoolean("audio_tips_state", false)) {
      paramQQAppInterface.edit().putLong("login_success_time", paramLong).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    try
    {
      BaseApplication localBaseApplication = paramQQAppInterface.a();
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface == null) {
        return;
      }
      localBaseApplication.getSharedPreferences("call_time_use_up", 0).edit().putBoolean(paramQQAppInterface + "_show_flag", paramBoolean).putString(paramQQAppInterface + "_wording", paramString).commit();
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      BaseApplication localBaseApplication = paramQQAppInterface.a();
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface == null) {
        return false;
      }
      boolean bool = localBaseApplication.getSharedPreferences("call_time_use_up", 0).getBoolean(paramQQAppInterface + "_show_flag", false);
      return bool;
    }
    catch (Exception paramQQAppInterface) {}
    return false;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsRealMissed friendUin:" + paramString + ",uinType:" + paramInt);
    }
    paramString = b(paramString, paramInt);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsRealMissed CallRecord count 0");
        bool2 = bool1;
      }
      return bool2;
    }
    paramInt = 0;
    for (;;)
    {
      bool1 = bool2;
      if (paramInt < paramString.size())
      {
        QCallRecord localQCallRecord = (QCallRecord)paramString.get(paramInt);
        if ((localQCallRecord == null) || (localQCallRecord.type != QCallRecord.TYPE_REALRECORD)) {
          break label200;
        }
        if (!localQCallRecord.isMissCall())
        {
          bool1 = bool2;
          if (localQCallRecord.state != 1) {}
        }
        else
        {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsRealMissed ret:" + bool1);
      return bool1;
      label200:
      paramInt += 1;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
  }
  
  private void b(QCallRecent paramQCallRecent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRecentCall, " + paramQCallRecent);
    }
    a().d(paramQCallRecent);
    if ((MsgProxyUtils.c(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  private int c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getNewestMissCallCount friendUin:" + paramString + ",uinType:" + paramInt);
    }
    paramString = b(paramString, paramInt);
    int i;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getNewestMissCallCount count 0");
      }
      i = 0;
    }
    do
    {
      return i;
      i = 0;
      int j;
      for (paramInt = 0; i < paramString.size(); paramInt = j)
      {
        QCallRecord localQCallRecord = (QCallRecord)paramString.get(i);
        j = paramInt;
        if (localQCallRecord != null)
        {
          j = paramInt;
          if (localQCallRecord.type == QCallRecord.TYPE_REALRECORD)
          {
            if (!localQCallRecord.isMissCall()) {
              break;
            }
            j = paramInt + 1;
          }
        }
        i += 1;
      }
      i = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getNewestMissCallCount count:" + paramInt);
    return paramInt;
  }
  
  private void c(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("voice_tab_time", 0).edit().putLong("merge_data_time", paramLong).commit();
  }
  
  private void c(QCallRecent paramQCallRecent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "save " + paramQCallRecent);
    }
    a().c(paramQCallRecent);
    if ((MsgProxyUtils.c(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  public int a()
  {
    Object localObject = a().a();
    if (localObject == null) {
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((List)localObject).iterator();
    int i = 0;
    long l1;
    label68:
    int j;
    if (((Iterator)localObject).hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        if (localQCallRecent.lastCallTime <= l1) {
          break label124;
        }
        if (!localQCallRecent.isMissedCall()) {
          break label116;
        }
        j = a(localQCallRecent.uin, localQCallRecent.type, l1);
        label101:
        i = j + i;
      }
    }
    label116:
    label124:
    for (;;)
    {
      break;
      l1 = l2;
      break label68;
      j = 0;
      break label101;
      return i;
    }
  }
  
  public int a(MessageRecord paramMessageRecord, int paramInt)
  {
    int i = 0;
    if (paramMessageRecord.msgtype == 63490) {
      i = 2;
    }
    while ((paramMessageRecord.msgtype != 63510) && (!MsgProxyUtils.c(paramInt))) {
      return i;
    }
    return 1;
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = 0;
    paramString = a().b(paramString, paramInt);
    paramInt = i;
    if (paramString != null) {
      paramInt = paramString.state;
    }
    return paramInt;
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    int j = 0;
    int i = 0;
    if (paramString == null)
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getMissCallRecordCount-->Wrong friendUin or UinType.uinType=" + paramInt + " time=" + paramLong);
        j = i;
      }
      return j;
    }
    paramString = a().a(paramString, paramInt);
    i = 0;
    paramInt = j;
    for (;;)
    {
      j = paramInt;
      try
      {
        if (i >= paramString.size()) {
          break;
        }
        QCallRecord localQCallRecord = (QCallRecord)paramString.get(i);
        if (localQCallRecord.type == QCallRecord.TYPE_DATE) {
          break label192;
        }
        j = paramInt;
        if (!localQCallRecord.isMissCall()) {
          break;
        }
        long l = localQCallRecord.time;
        if (l <= paramLong) {
          break label192;
        }
        paramInt += 1;
      }
      catch (Exception paramString)
      {
        j = paramInt;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getMissCallRecordCount:" + paramString);
      return paramInt;
      label192:
      i += 1;
    }
  }
  
  public QCallRecent a(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public QCallProxy a()
  {
    b();
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = a().a();
    if (localObject1 == null) {
      return "";
    }
    int j = 0;
    int i = 0;
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QCallRecord localQCallRecord1 = null;
    localObject1 = ((List)localObject1).iterator();
    int k;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
      long l1;
      if (((QCallRecent)localObject2).readTime > l2) {
        l1 = ((QCallRecent)localObject2).readTime;
      }
      for (;;)
      {
        if ((((QCallRecent)localObject2).lastCallTime > l1) && (((QCallRecent)localObject2).isMissedCall()))
        {
          k = i + 1;
          if (((QCallRecent)localObject2).uin == null)
          {
            i = k;
            break;
            l1 = l2;
            continue;
          }
          localObject2 = a().a(((QCallRecent)localObject2).uin, ((QCallRecent)localObject2).type);
          int m = 0;
          i = j;
          if (m >= ((List)localObject2).size()) {
            break label470;
          }
          QCallRecord localQCallRecord2 = (QCallRecord)((List)localObject2).get(m);
          if (localQCallRecord2.type == QCallRecord.TYPE_DATE) {}
          for (;;)
          {
            label195:
            m += 1;
            break;
            if (!localQCallRecord2.isMissCall()) {
              break label470;
            }
            if (localQCallRecord2.time <= l1) {
              break label467;
            }
            if (i != 0) {
              break label464;
            }
            localQCallRecord1 = (QCallRecord)((List)localObject2).get(m);
            label241:
            i += 1;
          }
        }
      }
      k = i;
      i = j;
    }
    label464:
    label467:
    label470:
    for (j = k;; j = k)
    {
      k = j;
      j = i;
      i = k;
      break;
      localObject1 = new StringBuilder();
      if ((j == 1) || (i == 1)) {
        if (paramBoolean) {
          if (paramString != null) {
            ((StringBuilder)localObject1).append(paramString).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363252));
          }
        }
      }
      for (;;)
      {
        return ((StringBuilder)localObject1).toString();
        if ((localQCallRecord1 != null) && (localQCallRecord1.isVideo()))
        {
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363239));
        }
        else
        {
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363245));
          continue;
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363255, new Object[] { "" + i, "" + j }));
        }
      }
      break label241;
      break label195;
    }
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().a();
    if (localObject == null) {
      return localArrayList;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)localIterator.next();
      long l1;
      label77:
      int i;
      label126:
      QCallRecord localQCallRecord;
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        if ((localQCallRecent.lastCallTime <= l1) || (!localQCallRecent.isMissedCall()) || (localQCallRecent.uin == null)) {
          break label177;
        }
        List localList = a().a(localQCallRecent.uin, localQCallRecent.type);
        i = 0;
        if (i < localList.size())
        {
          localQCallRecord = (QCallRecord)localList.get(i);
          if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
            break label179;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label126;
        break;
        l1 = l2;
        break label77;
        label177:
        break;
        label179:
        if (!localQCallRecord.isMissCall()) {
          break;
        }
        if (localQCallRecord.time > l1)
        {
          if (localQCallRecent.type != 3000) {
            break label283;
          }
          localObject = MessageRecordFactory.a(63520);
          ((MessageRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363348);
          ((MessageRecord)localObject).frienduin = localQCallRecent.troopUin;
          ((MessageRecord)localObject).msgtype = 63520;
          ((MessageRecord)localObject).senderuin = "";
          ((MessageRecord)localObject).istroop = localQCallRecent.type;
          ((MessageRecord)localObject).time = localQCallRecord.time;
          localArrayList.add(localObject);
        }
      }
      label283:
      localObject = MessageRecordFactory.a(63527);
      ((MessageRecord)localObject).frienduin = localQCallRecent.uin;
      ((MessageRecord)localObject).msgtype = 63527;
      if (localQCallRecord.isVideo()) {}
      for (((MessageRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363346);; ((MessageRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363347))
      {
        ((MessageRecord)localObject).senderuin = localQCallRecord.senderuin;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "getMissCallMessageRecordList = list size" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public List a()
  {
    return a(null);
  }
  
  public List a(QCallProxy.QueryRecentCallsListener paramQueryRecentCallsListener)
  {
    if (((PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142)).a() == 0)
    {
      Object localObject = new uae(this, paramQueryRecentCallsListener);
      paramQueryRecentCallsListener = new ArrayList();
      localObject = a().a((QCallProxy.QueryRecentCallsListener)localObject);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
          if (localQCallRecent.type == 3000)
          {
            if ((TextUtils.isEmpty(localQCallRecent.pstnInfo)) || ((!TextUtils.isEmpty(localQCallRecent.pstnInfo)) && (localQCallRecent.pstnInfo.equals("[]")))) {
              paramQueryRecentCallsListener.add(localQCallRecent);
            }
          }
          else if (localQCallRecent.callType != 2) {
            paramQueryRecentCallsListener.add(localQCallRecent);
          }
        }
      }
      return paramQueryRecentCallsListener;
    }
    return a().a(paramQueryRecentCallsListener);
  }
  
  public List a(String paramString, int paramInt)
  {
    if (((PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142)).a() == 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramString = b(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          QCallRecord localQCallRecord = (QCallRecord)paramString.next();
          if (localQCallRecord.state != 59) {
            localArrayList.add(localQCallRecord);
          }
        }
      }
      return localArrayList;
    }
    return b(paramString, paramInt);
  }
  
  public void a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
    if ((localList == null) || (localList.size() < 1)) {
      return;
    }
    QQMessageFacade localQQMessageFacade = (QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (RecentUser)localList.get(i);
      if (!AbilityUtils.a(((RecentUser)localObject).type)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = localQQMessageFacade.a(((RecentUser)localObject).uin, ((RecentUser)localObject).type, new int[] { 63527 });
        if ((localObject != null) && (((List)localObject).size() >= 1) && (((MessageRecord)((List)localObject).get(0)).istroop != 1))
        {
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < ((List)localObject).size())
          {
            if ((((List)localObject).get(j) instanceof MessageForVideo))
            {
              MessageForVideo localMessageForVideo = (MessageForVideo)((List)localObject).get(j);
              localMessageForVideo.parse();
              localArrayList.add(localMessageForVideo);
              a(localMessageForVideo, false);
            }
            j += 1;
          }
          if (localArrayList.size() >= 1) {
            a((MessageForVideo)localArrayList.get(localArrayList.size() - 1));
          }
        }
      }
    }
    c(System.currentTimeMillis());
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addQCallRecentAndCallRecord issend=" + paramInt + ", discussId=" + paramLong + ", senderUin=" + paramString);
    }
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).friendUin = String.valueOf(paramLong);
    ((QCallRecord)localObject).issend = paramInt;
    ((QCallRecord)localObject).isVideo = 0;
    ((QCallRecord)localObject).time = MessageCache.a();
    ((QCallRecord)localObject).type = QCallRecord.TYPE_REALRECORD;
    if (paramInt == 1)
    {
      ((QCallRecord)localObject).state = 4;
      ((QCallRecord)localObject).uinType = 3000;
      a().a((QCallRecord)localObject);
      localObject = a().a(String.valueOf(paramLong), 3000);
      ((QCallRecent)localObject).uin = String.valueOf(paramLong);
      ((QCallRecent)localObject).lastCallTime = MessageCache.a();
      ((QCallRecent)localObject).type = 3000;
      ((QCallRecent)localObject).sendFlag = paramInt;
      ((QCallRecent)localObject).troopUin = String.valueOf(paramLong);
      ((QCallRecent)localObject).memberCount = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, paramLong);
      ((QCallRecent)localObject).missedCallCount = c(String.valueOf(paramLong), 3000);
      if (paramInt != 1) {
        break label273;
      }
    }
    label273:
    for (((QCallRecent)localObject).state = 4;; ((QCallRecent)localObject).state = 3)
    {
      ((QCallRecent)localObject).senderUin = paramString;
      ((QCallRecent)localObject).isLastCallRealMissed = a(String.valueOf(paramLong), 3000);
      ((QCallRecent)localObject).isSystemCall = 0;
      b((QCallRecent)localObject);
      return;
      ((QCallRecord)localObject).state = 3;
      break;
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addQCallRecent issend = " + paramInt + ", discussId = " + paramLong + ", senderUin = " + paramString1 + ", pstnUserInfo = " + paramString2);
    }
    QCallRecent localQCallRecent = a().a(String.valueOf(paramLong), 3000);
    localQCallRecent.uin = String.valueOf(paramLong);
    localQCallRecent.lastCallTime = MessageCache.a();
    localQCallRecent.type = 3000;
    localQCallRecent.sendFlag = paramInt;
    localQCallRecent.troopUin = String.valueOf(paramLong);
    localQCallRecent.memberCount = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, paramLong);
    localQCallRecent.missedCallCount = c(String.valueOf(paramLong), 3000);
    if (localQCallRecent.state != 1) {
      if (paramInt != 1) {
        break label217;
      }
    }
    label217:
    for (localQCallRecent.state = 4;; localQCallRecent.state = 0)
    {
      localQCallRecent.pstnInfo = paramString2;
      localQCallRecent.senderUin = paramString1;
      localQCallRecent.isLastCallRealMissed = a(String.valueOf(paramLong), 3000);
      localQCallRecent.isSystemCall = 0;
      b(localQCallRecent);
      return;
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateDissCall-->discussid=" + paramLong1 + " friendUin=" + paramLong2 + " b=" + paramBoolean1 + " time=" + paramLong3 + " isSend=" + paramBoolean2);
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    while ((((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(String.valueOf(paramLong1)) == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(paramLong2)))) {
      return;
    }
    QCallRecent localQCallRecent = a().a(String.valueOf(paramLong1), 3000);
    localQCallRecent.lastCallTime = MessageCache.a();
    if (paramBoolean1)
    {
      localQCallRecent.state = 1;
      b(localQCallRecent);
      return;
    }
    localQCallRecent.state = 3;
    localQCallRecent.time = paramLong3;
    if (paramLong3 > 0L)
    {
      localQCallRecord = new QCallRecord();
      localQCallRecord.friendUin = String.valueOf(paramLong1);
      localQCallRecord.isVideo = 0;
      localQCallRecord.time = MessageCache.a();
      localQCallRecord.talkTime = String.valueOf(paramLong3);
      localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
      localQCallRecord.uinType = 3000;
      if (paramBoolean3)
      {
        localQCallRecord.state = 59;
        if (paramBoolean2) {
          localQCallRecord.issend = 1;
        }
      }
      for (;;)
      {
        a().a(localQCallRecord);
        break;
        localQCallRecord.issend = 0;
        continue;
        if (paramBoolean2)
        {
          localQCallRecord.state = 4;
          localQCallRecord.issend = 1;
        }
        else
        {
          localQCallRecord.state = 3;
          localQCallRecord.issend = 0;
        }
      }
    }
    QCallRecord localQCallRecord = new QCallRecord();
    localQCallRecord.friendUin = String.valueOf(paramLong1);
    localQCallRecord.issend = 1;
    localQCallRecord.isVideo = 0;
    localQCallRecord.time = MessageCache.a();
    localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
    if (paramBoolean3) {}
    for (localQCallRecord.state = 59;; localQCallRecord.state = 4)
    {
      localQCallRecord.uinType = 3000;
      a().a(localQCallRecord);
      break;
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo)
  {
    paramMessageForVideo.parse();
    paramMessageForVideo = a(paramMessageForVideo);
    b(paramMessageForVideo);
    if ((paramMessageForVideo != null) && (paramMessageForVideo.type == 3000))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramMessageForVideo.isSend()) {}
      for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004067", "0X8004067", 0, 0, paramMessageForVideo, "", "", "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMessageForVideo.isSend()) {}
    for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Msg_tab", "Call_history_count", 0, 0, paramMessageForVideo, "", "", "");
      return;
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo, boolean paramBoolean)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "insertCallRecord updateRecentMissedCallCount: msg is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "insertCallRecord updateRecentMissedCallCount:" + paramBoolean + ", msg :" + paramMessageForVideo.toString());
    }
    Object localObject = a(paramMessageForVideo);
    a().a((QCallRecord)localObject);
    if (paramBoolean)
    {
      localObject = a().b(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      if (localObject != null)
      {
        ((QCallRecent)localObject).missedCallCount = c(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "insertCallRecord QCallRecent update MissCallCount" + ((QCallRecent)localObject).missedCallCount);
        }
        ((QCallRecent)localObject).isLastCallRealMissed = a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        b((QCallRecent)localObject);
      }
    }
    setChanged();
    notifyObservers(b(paramMessageForVideo.frienduin, paramMessageForVideo.istroop));
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent == null) {
      return;
    }
    a().a(paramQCallRecent);
    a(-1);
  }
  
  public void a(String paramString)
  {
    b(paramString, 0);
    b(paramString, 1000);
    b(paramString, 1020);
    b(paramString, 1004);
    b(paramString, 1024);
    b(paramString, 8);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = a().b(paramString, paramInt);
    if (paramString == null) {
      return;
    }
    paramString.readTime = MessageCache.a();
    b(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, 0, 0, null, paramInt2);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("updateDoubleCallStatus, peerUin[%s], uinType[%s], extraType[%s], bindType[%s], bindId[%s], status[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2, Integer.valueOf(paramInt4) }));
    }
    if ((paramInt1 == 1011) || (paramInt1 == 2800) || (paramInt1 == -1)) {}
    do
    {
      FriendsManager localFriendsManager;
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        if (paramInt1 != 0) {
          break;
        }
        localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      } while ((localFriendsManager != null) && (!localFriendsManager.b(paramString1)));
    } while ((paramString1 == null) || ((paramInt1 == 3000) && (((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString1) == null)));
    paramString1 = a().a(paramString1, paramInt1);
    if ((paramInt4 == 6) || (paramInt4 == 5) || (paramString1.isMissedCall())) {
      paramString1.lastCallTime = MessageCache.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateDoubleCallStatus lastCallTime = " + paramString1.lastCallTime);
    }
    paramString1.state = paramInt4;
    paramString1.extraType = paramInt2;
    paramString1.bindId = paramString2;
    paramString1.bindType = paramInt3;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1.callType = 1;
    }
    if (paramInt4 == 0)
    {
      b(paramString1);
      return;
    }
    c(paramString1);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    QCallProxy localQCallProxy = a();
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).uinType = paramInt1;
    ((QCallRecord)localObject).state = 58;
    ((QCallRecord)localObject).contactId = paramInt2;
    ((QCallRecord)localObject).friendUin = paramString1;
    ((QCallRecord)localObject).time = paramLong;
    localQCallProxy.a((QCallRecord)localObject);
    localObject = localQCallProxy.a(paramString1, paramInt1);
    ((QCallRecent)localObject).uin = paramString1;
    ((QCallRecent)localObject).type = paramInt1;
    if (paramLong > ((QCallRecent)localObject).lastCallTime) {
      ((QCallRecent)localObject).lastCallTime = paramLong;
    }
    ((QCallRecent)localObject).contactId = paramInt2;
    ((QCallRecent)localObject).isSystemCall = 1;
    ((QCallRecent)localObject).sendFlag = 1;
    ((QCallRecent)localObject).phoneNumber = paramString2;
    localQCallProxy.d((QCallRecent)localObject);
    notifyObservers(b(paramString1, paramInt1));
    setChanged();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a().a(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, byte[] paramArrayOfByte, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateLightalkSig ,peerUin :" + paramString1 + ", sig = " + paramArrayOfByte + ", fromMobile = " + paramString2);
    }
    HexUtil.a(jdField_a_of_type_JavaLangString, paramArrayOfByte);
    paramString1 = a().a(paramString1, paramInt);
    paramString1.lightalkSig = paramArrayOfByte;
    paramString1.phoneNumber = paramString2;
    b(paramString1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addMissCallMsg 2 discussId=" + paramString1 + ", senderUin=" + paramString2);
    }
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).friendUin = String.valueOf(paramString1);
    ((QCallRecord)localObject).issend = 0;
    ((QCallRecord)localObject).isVideo = 0;
    ((QCallRecord)localObject).time = MessageCache.a();
    ((QCallRecord)localObject).type = QCallRecord.TYPE_REALRECORD;
    ((QCallRecord)localObject).state = 2;
    ((QCallRecord)localObject).uinType = 3000;
    a().a((QCallRecord)localObject);
    localObject = a().a(String.valueOf(paramString1), 3000);
    ((QCallRecent)localObject).uin = String.valueOf(paramString1);
    ((QCallRecent)localObject).lastCallTime = MessageCache.a();
    ((QCallRecent)localObject).type = 3000;
    ((QCallRecent)localObject).sendFlag = 0;
    ((QCallRecent)localObject).troopUin = String.valueOf(paramString1);
    ((QCallRecent)localObject).memberCount = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, Long.parseLong(paramString1));
    ((QCallRecent)localObject).state = 2;
    ((QCallRecent)localObject).missedCallCount = c(paramString1, 3000);
    ((QCallRecent)localObject).senderUin = paramString2;
    ((QCallRecent)localObject).isLastCallRealMissed = a(paramString1, 3000);
    ((QCallRecent)localObject).isSystemCall = 0;
    b((QCallRecent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new uac(this));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool2 = true;
    if ((paramString1 == null) || (paramString2 == null))
    {
      if (QLog.isColorLevel())
      {
        paramString3 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("isDiscussId==null");
        if (paramString1 != null) {
          break label80;
        }
        bool1 = true;
        paramString1 = localStringBuilder.append(bool1).append(" isPeerUin==null");
        if (paramString2 != null) {
          break label86;
        }
      }
      label80:
      label86:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        QLog.e(paramString3, 2, bool1);
        return;
        bool1 = false;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addMissCallMsg discussId=" + paramString1 + ", peerUin=" + paramString2 + ", senderUin=" + paramString3);
    }
    paramString2 = new QCallRecord();
    paramString2.friendUin = String.valueOf(paramString1);
    paramString2.issend = 0;
    paramString2.isVideo = 0;
    paramString2.time = MessageCache.a();
    paramString2.type = QCallRecord.TYPE_REALRECORD;
    paramString2.state = paramInt;
    paramString2.uinType = 3000;
    a().a(paramString2);
    paramString2 = a().a(String.valueOf(paramString1), 3000);
    paramString2.uin = String.valueOf(paramString1);
    paramString2.lastCallTime = MessageCache.a();
    paramString2.type = 3000;
    paramString2.sendFlag = 0;
    paramString2.troopUin = String.valueOf(paramString1);
    paramString2.memberCount = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, Long.parseLong(paramString1));
    paramString2.state = paramInt;
    paramString2.missedCallCount = c(paramString1, 3000);
    paramString2.senderUin = paramString3;
    paramString2.isLastCallRealMissed = a(paramString1, 3000);
    paramString2.isSystemCall = 0;
    b(paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong, String paramString5)
  {
    QCallProxy localQCallProxy = a();
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).uinType = paramInt;
    ((QCallRecord)localObject).state = 58;
    ((QCallRecord)localObject).contactId = -1;
    ((QCallRecord)localObject).friendUin = paramString1;
    ((QCallRecord)localObject).time = paramLong;
    localQCallProxy.a((QCallRecord)localObject);
    localObject = localQCallProxy.a(paramString1, paramInt);
    ((QCallRecent)localObject).uin = paramString1;
    ((QCallRecent)localObject).type = paramInt;
    if (paramLong > ((QCallRecent)localObject).lastCallTime) {
      ((QCallRecent)localObject).lastCallTime = paramLong;
    }
    ((QCallRecent)localObject).contactId = -1;
    ((QCallRecent)localObject).isSystemCall = 1;
    ((QCallRecent)localObject).sendFlag = 1;
    ((QCallRecent)localObject).phoneNumber = paramString5;
    ((QCallRecent)localObject).businessName = paramString2;
    ((QCallRecent)localObject).businessLogo = paramString3;
    ((QCallRecent)localObject).businessSeId = paramString4;
    localQCallProxy.d((QCallRecent)localObject);
    notifyObservers(b(paramString1, paramInt));
    setChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    a().a(paramBoolean);
  }
  
  public boolean a()
  {
    return a().a();
  }
  
  public int b()
  {
    Object localObject1 = a().a();
    if (localObject1 == null) {
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    long l1;
    label69:
    int j;
    int i;
    label116:
    QCallRecord localQCallRecord;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
        if (((QCallRecent)localObject2).readTime > l2)
        {
          l1 = ((QCallRecent)localObject2).readTime;
          if ((((QCallRecent)localObject2).lastCallTime <= l1) || (!((QCallRecent)localObject2).isMissedCall()) || (((QCallRecent)localObject2).uin == null)) {
            break label167;
          }
          localObject2 = a().a(((QCallRecent)localObject2).uin, ((QCallRecent)localObject2).type);
          j = 0;
          i = k;
          k = i;
          if (j >= ((List)localObject2).size()) {
            continue;
          }
          localQCallRecord = (QCallRecord)((List)localObject2).get(j);
          if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
            break label169;
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label116;
      l1 = l2;
      break label69;
      label167:
      break;
      label169:
      k = i;
      if (!localQCallRecord.isMissCall()) {
        break;
      }
      if (localQCallRecord.time > l1)
      {
        i += 1;
        continue;
        return k;
      }
    }
  }
  
  public int b(String paramString, int paramInt)
  {
    Object localObject1 = a().a();
    if (localObject1 == null) {
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    long l1;
    label93:
    int j;
    int i;
    label138:
    QCallRecord localQCallRecord;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
        if ((paramString.equals(((QCallRecent)localObject2).uin)) && (paramInt == ((QCallRecent)localObject2).type)) {
          if (((QCallRecent)localObject2).readTime > l2)
          {
            l1 = ((QCallRecent)localObject2).readTime;
            if ((((QCallRecent)localObject2).lastCallTime <= l1) || (!((QCallRecent)localObject2).isMissedCall()) || (((QCallRecent)localObject2).uin == null)) {
              break label193;
            }
            localObject2 = a().a(paramString, paramInt);
            j = 0;
            i = k;
            k = i;
            if (j >= ((List)localObject2).size()) {
              continue;
            }
            localQCallRecord = (QCallRecord)((List)localObject2).get(j);
            if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
              break label195;
            }
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label138;
      l1 = l2;
      break label93;
      label193:
      break;
      label195:
      k = i;
      if (!localQCallRecord.isMissCall()) {
        break;
      }
      if (localQCallRecord.time > l1)
      {
        i += 1;
        continue;
        return k;
      }
    }
  }
  
  public List b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    return a().a(paramString, paramInt);
  }
  
  public void b(long paramLong)
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localBaseApplication.getSharedPreferences("voice_tab_time", 0).edit().putLong(str, paramLong).commit();
  }
  
  public void b(MessageForVideo paramMessageForVideo)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateCallRecord: msg is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateCallRecord:, msg :" + paramMessageForVideo.toString());
    }
    QCallRecord localQCallRecord = a(paramMessageForVideo);
    a().b(localQCallRecord);
    setChanged();
    notifyObservers(b(paramMessageForVideo.frienduin, paramMessageForVideo.istroop));
  }
  
  public void b(String paramString)
  {
    int k = 0;
    Object localObject2 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    int i;
    label52:
    int j;
    if (localObject2 == null)
    {
      localObject2 = null;
      if (localObject2 != null)
      {
        if (TextUtils.isEmpty(((PhoneContact)localObject2).uin)) {
          break label143;
        }
        i = 1;
        if ((i == 0) || (((PhoneContact)localObject2).uin.equals("0"))) {
          break label149;
        }
        j = 1;
        label73:
        if ((j != 0) && (localObject1 != null)) {
          break label155;
        }
        localObject1 = null;
        label84:
        if ((localObject1 == null) || (!((Friends)localObject1).isFriend())) {
          break label167;
        }
        j = 1;
        label98:
        if (j == 0) {
          break label173;
        }
        localObject1 = ((PhoneContact)localObject2).uin;
        i = k;
      }
    }
    for (;;)
    {
      long l = MessageCache.a();
      a((String)localObject1, i, ((PhoneContact)localObject2).contactID, l, paramString);
      return;
      localObject2 = ((PhoneContactManager)localObject2).c(paramString);
      break;
      label143:
      i = 0;
      break label52;
      label149:
      j = 0;
      break label73;
      label155:
      localObject1 = ((FriendsManager)localObject1).c(((PhoneContact)localObject2).uin);
      break label84;
      label167:
      j = 0;
      break label98;
      label173:
      if (i != 0)
      {
        localObject1 = ((PhoneContact)localObject2).mobileCode;
        i = 1006;
      }
      else
      {
        localObject1 = ((PhoneContact)localObject2).mobileNo;
        i = 56938;
      }
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QCallRecent localQCallRecent = a().b(paramString, paramInt);
    if (localQCallRecent != null) {
      a(localQCallRecent);
    }
    c(paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new uad(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("voice_tab_time", 0).edit().putBoolean("audio_tips_state", paramBoolean).commit();
  }
  
  public int c()
  {
    Object localObject = a().a();
    if (localObject == null) {
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((List)localObject).iterator();
    int i = 0;
    long l1;
    if (((Iterator)localObject).hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        label68:
        if ((localQCallRecent.lastCallTime <= l1) || (!localQCallRecent.isMissedCall())) {
          break label101;
        }
        i += 1;
      }
    }
    label101:
    for (;;)
    {
      break;
      l1 = l2;
      break label68;
      return i;
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clearAllRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    a().a(paramString, paramInt);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    deleteObservers();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\QCallFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */