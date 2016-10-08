package com.tencent.mobileqq.app.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import qlj;

public class ConversationFacade
  extends Observable
  implements Manager
{
  public static final int a = 0;
  public static final String a = "sp_nearby_summary";
  public static final int b = 0;
  public static final String b = "sm";
  public static final String c = "lastuin";
  private static final String e = "date_box_last_read_time";
  private static final String f = "lbs_box_last_read_time";
  private static final String g = "%s_%s_%s";
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject;
  private Set jdField_a_of_type_JavaUtilSet;
  private Set b;
  private final String d;
  
  public ConversationFacade(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = "Q.unread.Facade";
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return Math.max(paramConversationInfo.unreadCount, paramConversationInfo.unreadMark);
  }
  
  private static SharedPreferences a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 1001) {}
    for (String str = "sp_nearby_summary_" + paramQQAppInterface.a(); !TextUtils.isEmpty(str); str = "") {
      return BaseApplicationImpl.a.getSharedPreferences("sp_nearby_summary_" + paramQQAppInterface.a(), 0);
    }
    return null;
  }
  
  private FriendsManager a()
  {
    return (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
  }
  
  private ConversationProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  private MsgProxy a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
  }
  
  private QQMessageFacade a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "lastuin";; str = "sm") {
      return String.format("%s_%s_%s", new Object[] { str, paramString, Integer.valueOf(paramInt) });
    }
  }
  
  private Set a(int paramInt)
  {
    if (paramInt == 1010)
    {
      if (this.jdField_a_of_type_JavaUtilSet == null) {
        this.jdField_a_of_type_JavaUtilSet = a(AppConstants.aP, paramInt, "date_box_last_read_time");
      }
      return this.jdField_a_of_type_JavaUtilSet;
    }
    if (paramInt == 1001)
    {
      if (this.b == null) {
        this.b = a(AppConstants.aO, paramInt, "lbs_box_last_read_time");
      }
      return this.b;
    }
    return null;
  }
  
  private Set a(String paramString1, int paramInt, String paramString2)
  {
    long l1 = 0L;
    if (QLog.isColorLevel())
    {
      l1 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 2, "initSayHelloSet,boxType:" + paramInt + ",startTime:" + l1);
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    HashSet localHashSet = new HashSet();
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString1, paramInt);
    long l2 = localSharedPreferences.getLong(paramString2, 0L);
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (MessageRecord)paramString1.next();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg_box", 4, "lastTime:" + l2 + ",mr.time:" + paramString2.time + ",uin:" + paramString2.senderuin + ",istroop:" + paramString2.istroop);
      }
      if ((a(paramString2.senderuin, paramInt) > 0) && (paramString2.time > l2)) {
        localHashSet.add(paramString2.senderuin);
      }
    }
    if (QLog.isColorLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 2, "initSayHelloSet,endTime:" + l2 + ",costTime:" + (l2 - l1));
    }
    return localHashSet;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1);
  }
  
  private boolean a(MessageRecord paramMessageRecord, Set paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (MsgProxyUtils.a(paramMessageRecord, (MessageRecord)paramSet.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static int b(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadCount;
  }
  
  public static int c(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadMark;
  }
  
  private void d()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ConcurrentHashMap localConcurrentHashMap = MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a();
      if ((localConcurrentHashMap.get(MsgProxyUtils.a(AppConstants.ar, 1001)) == null) || (localConcurrentHashMap.get(MsgProxyUtils.a(AppConstants.ar, 1001)) == null) || (localConcurrentHashMap.get(MsgProxyUtils.a(AppConstants.ar, 1001)) == null))
      {
        ThreadManager.a(new qlj(this), 8, null, false);
        return;
      }
    }
    b(AppConstants.ar, 1001);
    b(AppConstants.ag, 1009);
    b(AppConstants.aH, 1010);
  }
  
  public int a(int paramInt)
  {
    Object localObject;
    int i;
    if (paramInt == 1001)
    {
      localObject = a(paramInt).a(AppConstants.aO, 1001);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label74;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "list is null or list is empty");
      }
      i = 0;
    }
    label74:
    do
    {
      return i;
      localObject = a(paramInt).a(AppConstants.aP, 1010);
      break;
      localObject = ((List)localObject).iterator();
      MessageRecord localMessageRecord;
      for (paramInt = 0; ((Iterator)localObject).hasNext(); paramInt = a(localMessageRecord.senderuin, localMessageRecord.istroop) + paramInt) {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      }
      i = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d("Q.unread.Facade", 2, "nUnreadCount=" + paramInt);
    return paramInt;
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return 0;
    }
    return DatingUtil.a(paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(a().a(paramString, paramInt));
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = a(paramInt1).a(paramString, paramInt1);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "list is null or list is empty");
      }
      paramInt2 = 0;
      return paramInt2;
    }
    label56:
    MessageRecord localMessageRecord;
    if (paramInt2 == 0)
    {
      paramString = paramString.iterator();
      paramInt2 = 0;
      paramInt1 = paramInt2;
      if (!paramString.hasNext()) {
        break label176;
      }
      localMessageRecord = (MessageRecord)paramString.next();
      if (!MsgProxyUtils.c(localMessageRecord)) {
        break label217;
      }
    }
    label122:
    label176:
    label212:
    label217:
    for (paramInt1 = d(localMessageRecord.senderuin, localMessageRecord.istroop) + paramInt2;; paramInt1 = paramInt2)
    {
      paramInt2 = paramInt1;
      break label56;
      if (paramInt2 == 1)
      {
        paramString = paramString.iterator();
        paramInt2 = 0;
        paramInt1 = paramInt2;
        if (!paramString.hasNext()) {
          break label176;
        }
        localMessageRecord = (MessageRecord)paramString.next();
        if (!MsgProxyUtils.c(localMessageRecord)) {
          break label212;
        }
      }
      for (paramInt1 = e(localMessageRecord.senderuin, localMessageRecord.istroop) + paramInt2;; paramInt1 = paramInt2)
      {
        paramInt2 = paramInt1;
        break label122;
        paramInt1 = 0;
        paramInt2 = paramInt1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "nUnreadGiftCount=" + paramInt1);
        return paramInt1;
      }
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!MsgProxyUtils.v(paramInt1))) {}
    for (;;)
    {
      return paramString2;
      SharedPreferences localSharedPreferences = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
      String str;
      if (paramInt1 == 1001)
      {
        if ((paramInt2 < 0) || (paramInt2 > 0)) {
          continue;
        }
        if (AppConstants.ar.equals(paramString1))
        {
          paramString1 = localSharedPreferences.getString(a(AppConstants.ar, paramInt2, true), "");
          str = paramString1;
          if (AppConstants.aO.equals(paramString1)) {
            str = localSharedPreferences.getString(a(AppConstants.aO, paramInt2, true), "");
          }
        }
      }
      while (!TextUtils.isEmpty(str))
      {
        return SecurityUtile.a(localSharedPreferences.getString(a(str, paramInt2, false), paramString2));
        str = paramString1;
        if (AppConstants.aO.equals(paramString1))
        {
          str = localSharedPreferences.getString(a(AppConstants.aO, paramInt2, true), "");
          continue;
          str = null;
        }
      }
    }
  }
  
  public Set a()
  {
    return a().a();
  }
  
  public void a()
  {
    a().c();
    Object localObject2 = a().a();
    Object localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    label290:
    while (((Iterator)localObject2).hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject2).next();
      if (b(localConversationInfo.uin, localConversationInfo.type))
      {
        if (MsgProxyUtils.a(localConversationInfo.uin, localConversationInfo.type)) {
          b(localConversationInfo.uin, localConversationInfo.type);
        }
        if ((QLog.isColorLevel()) && ((a(localConversationInfo) != 0) || (localConversationInfo.unreadGiftCount != 0) || (localConversationInfo.extInt1 != 0))) {
          QLog.d("Q.unread.Facade", 2, "initCache info=" + localConversationInfo.toString());
        }
      }
      for (;;)
      {
        if ((a(localConversationInfo) != 0) || ((localConversationInfo.unreadGiftCount == 0) && (localConversationInfo.extInt1 == 0))) {
          break label290;
        }
        a(localConversationInfo.uin, localConversationInfo.unreadGiftCount, false);
        break;
        if ((MsgProxyUtils.s(localConversationInfo.type)) && (!MsgProxyUtils.a(localConversationInfo.uin, localConversationInfo.type)) && (!a(localConversationInfo.uin, MsgProxyUtils.a(localConversationInfo.type)))) {
          ((Set)localObject1).add(localConversationInfo);
        }
        if ((QLog.isColorLevel()) && ((a(localConversationInfo) != 0) || (localConversationInfo.unreadGiftCount != 0) || (localConversationInfo.extInt1 != 0))) {
          QLog.d("Q.unread.Facade", 2, "initCache [not in recent] info=" + localConversationInfo.toString());
        }
      }
    }
    if (!((Set)localObject1).isEmpty())
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConversationInfo)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "initCache remove info=" + ((ConversationInfo)localObject2).toString());
        }
        a().b(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Set localSet = a(paramInt);
    if (localSet == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localSet.clear();
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
        if (paramInt == 1010)
        {
          ((SharedPreferences)???).edit().putLong("date_box_last_read_time", paramLong).commit();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg_box", 2, "clearNewSayHelloSet,boxType:" + paramInt + ",time:" + paramLong);
          return;
        }
      }
      if (paramInt == 1001) {
        ((SharedPreferences)???).edit().putLong("lbs_box_last_read_time", paramLong).commit();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Set localSet = a(paramInt);
    if ((localSet == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!localSet.contains(paramString)) {
        localSet.add(paramString);
      }
      return;
    }
  }
  
  public void a(ConversationInfo paramConversationInfo, String paramString)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg_box", 2, "updateSummaryLastUin info = " + paramConversationInfo + ", lbsHongbaoLastUin = " + paramString);
    }
    if ((paramConversationInfo == null) || (!MsgProxyUtils.v(paramConversationInfo.type)) || (TextUtils.isEmpty(paramConversationInfo.uin))) {}
    for (;;)
    {
      return;
      SharedPreferences.Editor localEditor = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.type).edit();
      if (paramConversationInfo.type == 1001)
      {
        if ((!AppConstants.aO.equals(paramConversationInfo.uin)) && (!AppConstants.ar.equals(paramConversationInfo.uin))) {
          continue;
        }
        if ((paramConversationInfo.extInt1 <= 0) || (TextUtils.isEmpty(paramString))) {
          localEditor.remove(a(paramConversationInfo.uin, 0, true));
        }
      }
      while (i != 0)
      {
        localEditor.commit();
        return;
        localEditor.putString(a(paramConversationInfo.uin, 0, true), paramString);
        continue;
        i = 0;
      }
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, true);
    a().b(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a().a(paramString, paramInt1, paramInt2);
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnreadFrom uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
    }
    if ((paramInt == 1008) && (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "isTroopBarAccount");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramInt != 1008) || (!TextUtils.equals(paramString, AppConstants.aZ))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.unread.Facade", 2, "NEW_KANDIAN_UIN not unread");
      return;
      if ((paramInt != 1008) || (!ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.unread.Facade", 2, "isServiceAccountFolder not unread");
    return;
    b(paramString, paramInt, paramLong);
    a(paramInt).a(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
    OpenApiManager localOpenApiManager = OpenApiManager.a();
    if (a(paramString, paramInt) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localOpenApiManager.a(paramString, paramInt, bool, paramLong);
      return;
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramInt, paramLong, true, paramBoolean);
  }
  
  protected void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = a().b(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnread uin=" + paramString + ",type" + paramInt + ",unread" + l + " ,lastread" + paramLong + ",needDelMark" + paramBoolean2);
    }
    if (paramBoolean2) {
      a().a(paramString, paramInt, 0);
    }
    a().a(paramString, paramInt, paramLong, 0, 0, 0);
    if (l > 0L)
    {
      if ((MsgProxyUtils.c(paramInt)) && (paramBoolean1)) {
        d();
      }
      QQMessageFacade.Message localMessage = a().a(paramString, paramInt);
      if (localMessage != null) {
        a(paramInt).b(paramString, paramInt, localMessage);
      }
    }
    OpenApiManager.a().a(paramString, paramInt, true, 0L);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int j = 0;
    int i;
    if (paramMessageRecord != null)
    {
      i = a(paramMessageRecord) * -1;
      j = b(paramMessageRecord) * -1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt + ",unreadDiff" + -1 + ",unreadGiftDiff=" + i + ",unreadRedPacketDiff=" + j + ",mr=" + paramMessageRecord);
      }
      a().a(paramString, paramInt, -1, i, j);
      if (MsgProxyUtils.c(paramInt)) {
        d();
      }
      return;
      i = 0;
    }
  }
  
  @Deprecated
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramInt2 = a().b(paramString2, paramInt2);
    int i = a().b(paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "moveBoxToMessageTab innerItemUnread=" + paramInt2 + ", convsItemUnread=" + i);
    }
    b(paramString1, paramInt1);
  }
  
  protected void a(String paramString, int paramInt, List paramList)
  {
    int i = 0;
    Iterator localIterator = paramList.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      int n = a(localMessageRecord) * -1;
      int i1 = b(localMessageRecord) * -1;
      if (localMessageRecord != null)
      {
        int k = j + n;
        int m = i + i1;
        j = k;
        i = m;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt + ",unreadDiff" + -1 + ",unreadGiftDiff=" + n + ",unreadRedPacketDiff=" + i1 + ",mr=" + localMessageRecord);
          j = k;
          i = m;
        }
      }
    }
    a().a(paramString, paramInt, paramList.size(), j, i);
    if (MsgProxyUtils.c(paramInt)) {
      d();
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    a(paramString, paramInt, a().a(paramString, paramInt), paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg_box", 2, "saveMrSummary uin = " + paramString1 + ", istroop = " + paramInt1 + ", summaryType=" + paramInt2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null) || (!MsgProxyUtils.v(paramInt1))) {}
    do
    {
      return;
      str1 = paramString2;
      if (paramInt1 != 1001) {
        break;
      }
    } while ((paramInt2 < 0) || (paramInt2 > 0));
    String str1 = paramString2;
    if (paramInt2 == 0)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131372040);
      str1 = paramString2;
      if (paramString2.indexOf(str2) == 0) {
        str1 = paramString2.substring(str2.length());
      }
    }
    paramString2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1).edit();
    paramString2.putString(a(paramString1, paramInt2, false), SecurityUtile.b(str1));
    paramString2.commit();
  }
  
  public void a(List paramList)
  {
    MessageRecord localMessageRecord = null;
    int i;
    String str;
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "addUnread msg size=" + paramList.size());
      }
      Iterator localIterator = paramList.iterator();
      i = 0;
      paramList = localMessageRecord;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localMessageRecord = (MessageRecord)localIterator.next();
          if ((localMessageRecord.isSendFromLocal()) || (localMessageRecord.isread)) {
            break label422;
          }
          if ((localMessageRecord.msgtype != 63530) || (!(localMessageRecord instanceof MessageForFoldMsg)))
          {
            if (!localMessageRecord.isLongMsg()) {
              break label419;
            }
            str = MsgProxyUtils.a(localMessageRecord);
            if (paramList != null) {
              break label416;
            }
            paramList = new HashSet();
            label130:
            if (MsgProxyUtils.b(localMessageRecord))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord)) || (paramList.contains(str))) {
                continue;
              }
              paramList.add(str);
              label177:
              if (1001 != localMessageRecord.istroop) {
                break label292;
              }
              if (!AppConstants.ar.equals(localMessageRecord.frienduin)) {
                break label264;
              }
              a().a(localMessageRecord.senderuin, 1001, 1, a(localMessageRecord), b(localMessageRecord));
              label225:
              if (!MsgProxyUtils.c(localMessageRecord.istroop)) {
                break label413;
              }
              i = 1;
            }
          }
        }
      }
    }
    label264:
    label292:
    label413:
    label416:
    label419:
    label422:
    for (;;)
    {
      break;
      if (paramList.contains(str)) {
        paramList.remove(str);
      }
      break label177;
      a().a(localMessageRecord.frienduin, 1001, 1, a(localMessageRecord), b(localMessageRecord));
      break label225;
      if (1009 == localMessageRecord.istroop)
      {
        a().a(localMessageRecord.frienduin, 1009, 1, a(localMessageRecord), b(localMessageRecord));
        break label225;
      }
      if ((1008 == localMessageRecord.istroop) && ("1".equals(localMessageRecord.getExtInfoFromExtStr("public_account_msg_unread_flag"))))
      {
        a().a(localMessageRecord.frienduin, localMessageRecord.istroop);
        break label225;
      }
      a().a(localMessageRecord.frienduin, localMessageRecord.istroop, 1, a(localMessageRecord), b(localMessageRecord));
      break label225;
      if (i != 0) {
        d();
      }
      return;
      continue;
      break label130;
      break label177;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanAllUnread needUpdateMsgtable=" + paramBoolean1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      Iterator localIterator = a().a().iterator();
      while (localIterator.hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)localIterator.next();
        if ((a(localConversationInfo) > 0) && (!AppConstants.av.equals(localConversationInfo.uin)) && ((!AppConstants.aJ.equals(localConversationInfo.uin)) || ((AppConstants.aJ.equals(localConversationInfo.uin)) && (!ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))))) {
          a(localConversationInfo.uin, localConversationInfo.type, paramBoolean2);
        }
      }
    }
    a().d();
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramString == null) {}
    label191:
    label192:
    label194:
    label200:
    for (;;)
    {
      return false;
      Object localObject;
      String str;
      if (paramInt == 1009)
      {
        localObject = a(paramInt).a(AppConstants.ag, 1009);
        str = null;
      }
      for (;;)
      {
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label200;
        }
        localObject = ((List)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (paramString.equals(localMessageRecord.senderuin))
          {
            return true;
            if (paramInt == 1001)
            {
              localObject = a(paramInt).a(AppConstants.ar, 1001);
              str = AppConstants.aO;
              continue;
            }
            if (paramInt != 1010) {
              break label194;
            }
            localObject = a(paramInt).a(AppConstants.aH, 1010);
            str = AppConstants.aP;
            continue;
          }
          if ((str == null) || (i != 0) || (!str.equals(localMessageRecord.senderuin))) {
            break label191;
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if (i == 0) {
            break label192;
          }
          return a(paramString, paramInt, str);
        }
        break;
        str = null;
        localObject = null;
      }
    }
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString2 = a(paramInt).a(paramString2, paramInt);
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext()) {
        if (paramString1.equals(((MessageRecord)paramString2.next()).senderuin)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    Set localSet = a(paramInt);
    int i = 0;
    if (localSet != null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      i = localSet.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "getUnreadSayHelloNum,boxType:" + paramInt + ",num:" + i);
      }
      return i;
    }
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while ((paramMessageRecord.isSend()) || (paramMessageRecord.isread) || (!MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))) {
      return 0;
    }
    return 1;
  }
  
  public int b(String paramString, int paramInt)
  {
    return b(a().a(paramString, paramInt));
  }
  
  public void b()
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "printAllGiftConversation info=" + localConversationInfo.toString());
      }
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).a(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    if (MsgProxyUtils.c(paramString))
    {
      c(paramString, paramInt);
      return;
    }
    String str = "";
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j = 0;
    int k = 0;
    label63:
    Object localObject2;
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (MsgProxyUtils.c(((MessageRecord)localObject2).senderuin))
      {
        c(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        m = k;
        label114:
        j += d(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        i += e(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        if ((!TextUtils.isEmpty(str)) || (i <= 0)) {
          break label400;
        }
        str = ((MessageRecord)localObject2).senderuin;
      }
    }
    label225:
    label390:
    label400:
    for (;;)
    {
      k = m;
      break label63;
      m = k;
      if (MsgProxyUtils.c((MessageRecord)localObject2)) {
        break label114;
      }
      m = k + a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
      break label114;
      if (e(paramString, paramInt) != i)
      {
        m = 1;
        if ((a(paramString, paramInt) != k) || (d(paramString, paramInt) != j) || (m != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label390;
          }
        }
      }
      for (long l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((ConversationProxy)localObject2).a(paramString, paramInt, l, k, j, i);
        if ((MsgProxyUtils.v(paramInt)) && (m != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + paramString + ", unread=" + k + ", giftCount=" + j + ", redPacketCount=" + i);
        return;
        m = 0;
        break label225;
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "rewriteUnreadCount uin=" + paramString + ",type" + paramInt1 + ",unread" + paramInt2);
    }
    a().b(paramString, paramInt1, paramInt2);
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (a().b(paramString, paramInt) > 0) {
        a(paramString, paramInt, paramLong, true);
      }
      return;
    }
    ConversationInfo localConversationInfo;
    long l;
    label216:
    int i1;
    if (((a(paramInt)) && (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq <= paramLong)) || ((a(paramInt)) || (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time > paramLong) || (MsgProxyUtils.a(paramInt)) || (MsgProxyUtils.b(paramInt))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "updateLastReadSeq uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
      }
      localConversationInfo = a().a(paramString, paramInt);
      if (localConversationInfo == null) {
        break label1043;
      }
      if (!a(paramInt)) {
        break label1037;
      }
      l = Math.max(paramLong, localConversationInfo.lastread);
      i1 = localConversationInfo.unreadCount;
    }
    for (;;)
    {
      label256:
      int i;
      int j;
      int k;
      Object localObject2;
      label314:
      MessageRecord localMessageRecord;
      if (a(paramInt))
      {
        paramLong = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq - l;
        i = (int)paramLong;
        j = 0;
        k = 0;
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "updateLastReadSeq unread =" + i);
        }
        localObject2 = null;
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label886;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
        if (!a(paramInt)) {
          break label550;
        }
        paramLong = localMessageRecord.shmsgseq;
        label349:
        if (paramLong > l) {
          break label1031;
        }
        if (!localMessageRecord.isLongMsg()) {
          break label593;
        }
        if (localObject1 != null) {
          break label1034;
        }
        localObject1 = new HashMap();
      }
      label550:
      label593:
      label742:
      label853:
      label886:
      label1015:
      label1021:
      label1024:
      label1031:
      label1034:
      for (;;)
      {
        Object localObject3 = MsgProxyUtils.a(localMessageRecord);
        if (((Map)localObject1).containsKey(MsgProxyUtils.a(localMessageRecord)))
        {
          localObject3 = (Set)((Map)localObject1).get(localObject3);
          if ((localObject3 != null) && (!((Set)localObject3).isEmpty()) && (!a(localMessageRecord, (Set)localObject3))) {
            ((Set)localObject3).add(localMessageRecord);
          }
        }
        for (;;)
        {
          localObject3 = localObject2;
          int n = j;
          int m = k;
          Object localObject4;
          if (paramLong > l)
          {
            if (MsgProxyUtils.q(localMessageRecord.msgtype))
            {
              i -= 1;
              break label314;
              if ((a().b(paramString, paramInt) <= 0) && (a().d(paramString, paramInt) <= 0) && (a().e(paramString, paramInt) <= 0)) {
                break;
              }
              a(paramString, paramInt, paramLong, false);
              return;
              paramLong = a(paramInt).a(paramString, paramInt, paramLong);
              break label256;
              paramLong = localMessageRecord.time;
              break label349;
              localObject4 = new HashSet();
              ((Set)localObject4).add(localMessageRecord);
              ((Map)localObject1).put(localObject3, localObject4);
              continue;
              if ((!MsgProxyUtils.l(localMessageRecord.msgtype)) || (localMessageRecord.isread)) {
                break label1031;
              }
              j += a(localMessageRecord);
              k += b(localMessageRecord);
              i += 1;
              continue;
            }
            if ((a(paramInt)) && (UniteGrayTipUtil.a(localMessageRecord)))
            {
              i -= 1;
              break label314;
            }
            if (!localMessageRecord.isLongMsg()) {
              break label1024;
            }
            if ((localObject1 != null) && (((Map)localObject1).containsKey(MsgProxyUtils.a(localMessageRecord))) && (a(localMessageRecord, (Set)((Map)localObject1).get(MsgProxyUtils.a(localMessageRecord)))))
            {
              i -= 1;
              break label314;
            }
            if (localObject2 != null) {
              break label1021;
            }
            localObject2 = new HashSet();
            localObject4 = MsgProxyUtils.a(localMessageRecord);
            if (!MsgProxyUtils.b(localMessageRecord)) {
              break label853;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord))
            {
              i -= 1;
              break label314;
            }
            if (((Set)localObject2).contains(localObject4))
            {
              i -= 1;
              break label314;
            }
            ((Set)localObject2).add(localObject4);
            localObject3 = localObject2;
          }
          for (;;)
          {
            n = j + a(localMessageRecord);
            m = k + b(localMessageRecord);
            localObject2 = localObject3;
            j = n;
            k = m;
            break label314;
            localObject3 = localObject2;
            if (((Set)localObject2).contains(localObject4))
            {
              ((Set)localObject2).remove(localObject4);
              localObject3 = localObject2;
              continue;
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder().append("updateLastReadSeq before=");
                if (localConversationInfo == null) {
                  break label1015;
                }
              }
              for (localObject1 = localConversationInfo.toString();; localObject1 = null)
              {
                QLog.d("Q.unread.Facade", 2, (String)localObject1 + " , end unread=" + i + ", lastread=" + l + ",unreadGift=" + j + ",unreadRedPacket=" + k);
                a().a(paramString, paramInt, l, i, j, k);
                if ((i == i1) || (!MsgProxyUtils.c(paramInt))) {
                  break;
                }
                d();
                return;
              }
              break label742;
              localObject3 = localObject2;
            }
          }
        }
      }
      label1037:
      l = paramLong;
      break label216;
      label1043:
      i1 = 0;
      l = paramLong;
    }
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramString);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramString, paramInt) != null) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (7000 == paramInt);
      bool1 = bool2;
    } while (a(paramInt));
    return b(paramString);
  }
  
  public int c(String paramString, int paramInt)
  {
    return c(a().a(paramString, paramInt));
  }
  
  public void c()
  {
    SharedPreferences localSharedPreferences = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1001);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1001).a(AppConstants.ar, 1001).iterator();
    int i = 0;
    int j = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (MessageRecord)localIterator.next();
      if (localConversationFacade.e(((MessageRecord)localObject).senderuin, 1001) > 0) {
        break label292;
      }
      localObject = a(((MessageRecord)localObject).senderuin, 0, false);
      if (!localSharedPreferences.contains((String)localObject)) {
        break label292;
      }
      localEditor.remove((String)localObject);
      i += 1;
      j = 1;
    }
    label292:
    for (;;)
    {
      break;
      localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1001).a(AppConstants.aO, 1001).iterator();
      while (localIterator.hasNext())
      {
        localObject = (MessageRecord)localIterator.next();
        if (localConversationFacade.e(((MessageRecord)localObject).senderuin, 1001) <= 0)
        {
          localObject = a(((MessageRecord)localObject).senderuin, 0, false);
          if (localSharedPreferences.contains((String)localObject))
          {
            localEditor.remove((String)localObject);
            i += 1;
            j = 1;
          }
        }
      }
      if (j != 0) {
        localEditor.commit();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box", 2, "clearMrSummary2, count=" + i);
      }
      return;
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).a(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    String str = "";
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j = 0;
    int k = 0;
    label49:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      k += a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
      j += d(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
      i += e(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
      if ((i <= 0) || (!TextUtils.isEmpty(str))) {
        break label338;
      }
      str = ((MessageRecord)localObject2).senderuin;
    }
    label163:
    label328:
    label338:
    for (;;)
    {
      break label49;
      int m;
      if (e(paramString, paramInt) != i)
      {
        m = 1;
        if ((a(paramString, paramInt) != k) || (d(paramString, paramInt) != j) || (m != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label328;
          }
        }
      }
      for (long l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((ConversationProxy)localObject2).a(paramString, paramInt, l, k, j, i);
        if ((MsgProxyUtils.v(paramInt)) && (m != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateSayHelloBoxUnreadCount boxUin=" + paramString + ", unread=" + k + ", giftCount=" + j + ", redPacketCount=" + i);
        return;
        m = 0;
        break label163;
      }
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt1 + ",count" + paramInt2);
    }
    a().c(paramString, paramInt1, paramInt2);
    if (MsgProxyUtils.c(paramInt1)) {
      d();
    }
  }
  
  public boolean c(String paramString, int paramInt)
  {
    Object localObject = a(paramInt).a(paramString, paramInt);
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!MsgProxyUtils.c((MessageRecord)((Iterator)localObject).next())) {
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "isAllOneWayConversation boxUin=" + paramString + ", rtn true");
    }
    return true;
  }
  
  public int d(String paramString, int paramInt)
  {
    return a().d(paramString, paramInt);
  }
  
  public int e(String paramString, int paramInt)
  {
    return a().e(paramString, paramInt);
  }
  
  public int f(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public void onDestroy()
  {
    deleteObservers();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\ConversationFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */