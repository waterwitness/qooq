package com.tencent.mobileqq.managers;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public class QQLSRecentManager
  implements Observer, Manager
{
  public static int a = 0;
  public static long a = 0L;
  public static final String a = "QQLSActivity";
  private static CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  public static boolean a = false;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  public static int b = 0;
  public static long b = 0L;
  public static String b;
  public static volatile boolean b = false;
  public static long c = 0L;
  public static final String c = "param_hasshowedLs";
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g = true;
  public static boolean h;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = null;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_Long = -1L;
  }
  
  public QQLSRecentManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_b_of_type_JavaLangString = Build.MANUFACTURER + "-" + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      d = true;
      return d;
    }
    d = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.lock_screen.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "isPhoneNeedBright need bright before sensor = " + d);
    }
    return d;
  }
  
  public CopyOnWriteArrayList a()
  {
    return jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mDataList clear");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "startQQLs but  app is null ,return");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramQQAppInterface.isLogin()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQLSActivity", 2, "startQQLs but is not login ,return");
        return;
      } while (jdField_b_of_type_JavaLangString.equalsIgnoreCase("HUAWEI-HUAWEI T8833"));
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "needStartQQLS isFromMisscall:" + paramBoolean);
      }
    } while (!b());
    int i;
    if (!paramBoolean)
    {
      Object localObject = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningTasks(1);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label539;
      }
      localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "locking activity:" + ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName());
      }
      localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName();
      if ((!((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) && (!((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) && (!((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        break label526;
      }
      i = 1;
    }
    for (;;)
    {
      label222:
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager.getInstance().isLSalive:" + jdField_b_of_type_Boolean);
      }
      if (paramInt == 1) {}
      for (jdField_c_of_type_Boolean = true;; jdField_c_of_type_Boolean = false)
      {
        if (i != 0) {
          break label537;
        }
        if ((PhoneStatusTools.e(BaseApplicationImpl.a())) || ((jdField_b_of_type_Boolean) && (!paramBoolean)) || (!a(paramQQAppInterface, paramString, paramInt, paramBoolean))) {
          break;
        }
        paramString = new Intent(paramQQAppInterface.a(), QQLSActivity.class);
        paramString.addFlags(67108864);
        paramString.addFlags(268435456);
        paramString.addFlags(262144);
        paramQQAppInterface.a().startActivity(paramString);
        e = true;
        jdField_b_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d("qqls", 2, "need report  LS report needReport=" + g + "hasReport=" + h + "startTimes=" + jdField_b_of_type_Int);
        }
        if ((h) || (jdField_b_of_type_Int <= 2)) {
          break;
        }
        paramString = new HashMap();
        paramString.put("param_hasshowedLs", g + "");
        StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "qqlsReprotTag", true, 0L, 0L, paramString, "");
        if (QLog.isColorLevel()) {
          QLog.d("qqls", 2, "need report  LS report needReport=" + g);
        }
        h = true;
        return;
        label526:
        i = 0;
        break label222;
      }
      label537:
      break;
      label539:
      i = 0;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      RecentBaseData localRecentBaseData;
      int j;
      int i;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        }
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localRecentBaseData = (RecentBaseData)localIterator.next();
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localRecentBaseData.a(), localRecentBaseData.a());
        int k = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.b(localRecentBaseData.a(), localRecentBaseData.a());
        if (localRecentBaseData.a().equals(AppConstants.ar))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ar, localRecentBaseData.a());
          if ((i != 0) || (k != 0)) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
        }
      }
      if (localRecentBaseData.a().equals(AppConstants.an))
      {
        i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).c();
      }
      else if (localRecentBaseData.a().equals(AppConstants.aH))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.aH, localRecentBaseData.a());
      }
      else
      {
        i = j;
        if (localRecentBaseData.a().equals(paramString))
        {
          i = j;
          if (paramInt == localRecentBaseData.a())
          {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
            i = j;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "after removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + Thread.currentThread().getId() + ", uin " + paramString + ", uinType = " + paramInt + ", isFromMisscall = " + paramBoolean);
      }
      if ((!AppConstants.aN.equals(paramString)) && (!AppConstants.aM.equals(paramString))) {
        break label214;
      }
      localObject1 = new RecentUser();
      ((RecentUser)localObject1).uin = paramString;
      ((RecentUser)localObject1).type = paramInt;
      paramQQAppInterface = ConversationDataFactory.a((RecentUser)localObject1, paramQQAppInterface, paramQQAppInterface.a());
      localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (((RecentBaseData)localObject2).a().equals(paramString)) {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        }
      }
    }
    if (paramQQAppInterface != null) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramQQAppInterface);
    }
    return true;
    label214:
    Object localObject1 = paramString;
    int i = paramInt;
    if (!ReadInJoyHelper.a(paramQQAppInterface))
    {
      localObject1 = paramString;
      i = paramInt;
      if (paramInt == 7220)
      {
        localObject1 = paramString;
        i = paramInt;
        if (AppConstants.ba.equals(paramString))
        {
          localObject1 = AppConstants.aZ;
          i = 1008;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "threadId =" + Thread.currentThread().getId());
    }
    Object localObject3 = paramQQAppInterface.a().a();
    Object localObject2 = ((RecentUserProxy)localObject3).a(true, false).iterator();
    label381:
    label389:
    label471:
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      paramString = (RecentUser)((Iterator)localObject2).next();
      if (paramString != null)
      {
        RecentBaseData localRecentBaseData;
        if (TextUtils.isEmpty(paramString.uin))
        {
          paramString = null;
          break label1695;
          break label729;
          localObject2 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localRecentBaseData = (RecentBaseData)((Iterator)localObject2).next();
          } while ((localRecentBaseData.a().equals(AppConstants.aN)) || (localRecentBaseData.a().equals(AppConstants.aM)));
          paramInt = 0;
          if (!localRecentBaseData.a().equals(AppConstants.ar)) {
            break label753;
          }
          paramInt = paramQQAppInterface.a().a(AppConstants.ar, localRecentBaseData.a());
        }
        for (;;)
        {
          if ((localRecentBaseData.a() == 3000) || (localRecentBaseData.a() == 0) || (localRecentBaseData.a() == 8))
          {
            localRecentBaseData.a(paramQQAppInterface, BaseApplication.getContext());
            j = 0;
            if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade != null) {
              j = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.b(localRecentBaseData.a(), localRecentBaseData.a());
            }
            if (!QLog.isColorLevel()) {
              break label1726;
            }
            QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser miscallUnread = " + j);
            break label1726;
          }
          label574:
          if (paramInt != 0) {
            break label1732;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
          break label389;
          if (((paramString != null) && (((String)localObject1).equals(paramString.uin)) && (paramString.type == i)) || ((paramString != null) && (paramString.type == i) && (AppConstants.ar.equals(paramString.uin))) || ((paramString != null) && (paramString.type == i) && (AppConstants.aH.equals(paramString.uin)))) {
            break label1695;
          }
          if ((paramString == null) || (!AppConstants.an.equals(paramString.uin))) {
            break;
          }
          if ((AppConstants.av.equals(localObject1)) || (AppConstants.aX.equals(localObject1))) {
            break label1734;
          }
          if (!AppConstants.bd.equals(localObject1)) {
            break;
          }
          break label1734;
          label729:
          if (((QCallFacade)paramQQAppInterface.getManager(37)).b((String)localObject1, i) != 0) {
            break label381;
          }
          return false;
          label753:
          if (localRecentBaseData.a().equals(AppConstants.an))
          {
            if (((String)localObject1).equals(AppConstants.av)) {
              paramInt = paramQQAppInterface.a().a(AppConstants.av, localRecentBaseData.a());
            } else {
              paramInt = ((NewFriendManager)paramQQAppInterface.getManager(33)).c();
            }
          }
          else if (localRecentBaseData.a().equals(AppConstants.aH))
          {
            paramInt = paramQQAppInterface.a().a(AppConstants.aH, localRecentBaseData.a());
          }
          else
          {
            Object localObject4;
            if (localRecentBaseData.a().equals(AppConstants.aL))
            {
              localObject4 = (DatingProxyManager)paramQQAppInterface.getManager(70);
              if (localObject4 == null) {
                break label1688;
              }
              paramInt = ((DatingProxyManager)localObject4).a().a();
              break label1737;
            }
            if (localRecentBaseData.a().equals(AppConstants.aW))
            {
              localObject4 = (PullActiveManager)paramQQAppInterface.getManager(144);
              if (localObject4 != null) {
                paramInt = ((PullActiveManager)localObject4).a();
              }
            }
            else
            {
              paramInt = paramQQAppInterface.a().a(localRecentBaseData.a(), localRecentBaseData.a());
            }
          }
        }
        j = 0;
        localObject2 = null;
        if (paramString != null) {
          if (paramString.uin.equals(AppConstants.ar))
          {
            paramInt = paramQQAppInterface.a().a(AppConstants.ar, paramString.type);
            paramString = ConversationDataFactory.a(paramString, paramQQAppInterface, paramQQAppInterface.a());
          }
        }
      }
    }
    for (;;)
    {
      label997:
      if ((paramInt > 0) && (paramString != null))
      {
        if ((NewFriendManager.a(paramQQAppInterface, paramString.a())) && (AppConstants.aJ.equals(paramString.a()))) {
          paramString.jdField_b_of_type_JavaLangString = paramQQAppInterface.a().getString(2131371387);
        }
        localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        label1051:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentBaseData)((Iterator)localObject1).next();
          if ((NewFriendManager.a(paramQQAppInterface, ((RecentBaseData)localObject2).a())) && (NewFriendManager.a(paramQQAppInterface, paramString.a()))) {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          }
        }
        else
        {
          label1105:
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        }
        if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0) {
          break label1679;
        }
        return true;
        if (paramString.uin.equals(AppConstants.an))
        {
          if (((String)localObject1).equals(AppConstants.av))
          {
            paramInt = paramQQAppInterface.a().a(AppConstants.av, paramString.type);
            break;
          }
          paramInt = ((NewFriendManager)paramQQAppInterface.getManager(33)).c();
          break;
        }
        if (paramString.uin.equals(AppConstants.aH))
        {
          paramInt = paramQQAppInterface.a().a(AppConstants.aH, paramString.type);
          break;
        }
        paramInt = paramQQAppInterface.a().a(paramString.uin, paramString.type);
        break;
        if (i == 1012)
        {
          paramString = (DatingProxyManager)paramQQAppInterface.getManager(70);
          if (paramString == null) {
            break label1681;
          }
          paramInt = paramString.a().a();
          paramString = paramString.a().a();
          break label1740;
        }
        if (i == 9653)
        {
          paramString = (PullActiveManager)paramQQAppInterface.getManager(144);
          paramInt = paramString.a();
          paramString = paramString.a;
          break label997;
        }
        localObject3 = ((RecentUserProxy)localObject3).a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt = j;
        if (localObject3 == null) {
          break label997;
        }
        ((RecentUser)localObject3).lastmsgtime = MessageCache.a();
        paramString = ConversationDataFactory.a((RecentUser)localObject3, paramQQAppInterface, paramQQAppInterface.a());
        if (i != 8) {
          break label1743;
        }
        localObject1 = paramQQAppInterface.a().a().a((String)localObject1, i);
        if (localObject1 == null) {
          break label1743;
        }
        paramString.L = ((QCallRecent)localObject1).extraType;
        paramString.g = ((QCallRecent)localObject1).phoneNumber;
        break label1743;
        if ((((RecentBaseData)localObject2).a().equals(paramString.a())) && (((RecentBaseData)localObject2).a() == paramString.a()))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          break label1105;
        }
        if ((paramString.a().equals(AppConstants.ar)) && (((RecentBaseData)localObject2).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          break label1105;
        }
        if ((paramString.a().equals(AppConstants.aQ)) && (((RecentBaseData)localObject2).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          break label1105;
        }
        if ((paramString.a().equals(AppConstants.aH)) && (((RecentBaseData)localObject2).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          break label1105;
        }
        if ((!paramString.a().equals(AppConstants.an)) || (!((RecentBaseData)localObject2).a().equals(paramString.a()))) {
          break label1051;
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        break label1105;
        if ((paramBoolean) && (paramString != null) && (!jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser from misscall");
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        }
      }
      label1679:
      return false;
      label1681:
      paramString = null;
      paramInt = 0;
      break label1740;
      label1688:
      paramInt = 0;
      break label1737;
      paramString = null;
      label1695:
      label1726:
      label1732:
      label1734:
      for (;;)
      {
        if ((paramString != null) || (i == 1012) || (i == 7432)) {
          break label1735;
        }
        if (i != 9653) {
          break;
        }
        break label381;
        if (j > 0) {
          break label389;
        }
        break label574;
        break label389;
      }
      label1735:
      break label381;
      label1737:
      break label471;
      label1740:
      continue;
      label1743:
      paramInt = j;
    }
  }
  
  public boolean b()
  {
    long l = System.currentTimeMillis();
    if ((jdField_c_of_type_Long > 0L) && (l - jdField_c_of_type_Long < 5000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "isNeedStart false ,less than 5sec");
      }
      return false;
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof NewFriendMessage)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager new friend update~~~~~ " + Thread.currentThread().getId());
      }
      if (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label77;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun ");
      }
    }
    label77:
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).c();
        } while ((TextUtils.isEmpty(((NewFriendMessage)paramObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || (((NewFriendMessage)paramObject).a == 0L));
        if ((i != 0) && (!f)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + f);
      return;
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369618), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368465), "qqsetting_notify_showcontent_key", true);
    } while ((!Boolean.valueOf(bool1).booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.an, 4000, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\managers\QQLSRecentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */