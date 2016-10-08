package com.tencent.mobileqq.servlet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.util.QZoneLogTags;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import upn;

public class QZoneManagerImp
  implements QZoneManager
{
  public static final String h = "QZONE_UNREAD";
  public static final String i = "mine_message_count";
  public static final String j = "notify_type";
  public static final int k = 0;
  private static final String k = "QZoneManagerImp.";
  public static final int l = 1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList a;
  public ConcurrentHashMap a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private int m;
  
  public QZoneManagerImp(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.m = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("QZONE_UNREAD", 4);
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    int n = 0;
    while (n < 33)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = QZoneCountInfo.a(this.jdField_a_of_type_AndroidContentSharedPreferences.getString((String)localObject + "&" + n, ""));
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(n), localObject);
          }
        }
      }
      n += 1;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return LocalMultiProcConfig.a(paramQQAppInterface.a().getApplicationContext().getString(2131368470) + paramQQAppInterface.getAccount(), true);
  }
  
  private void b()
  {
    for (;;)
    {
      int n;
      try
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
            return;
          }
          QZoneCountInfo[] arrayOfQZoneCountInfo = (QZoneCountInfo[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().toArray(new QZoneCountInfo[this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()]);
          Integer[] arrayOfInteger = (Integer[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().toArray(new Integer[this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()]);
          n = 0;
          if (n < arrayOfQZoneCountInfo.length)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break label213;
            }
            String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
            if ((str == null) || (str.length() <= 0)) {
              break label213;
            }
            QZoneCountInfo localQZoneCountInfo = arrayOfQZoneCountInfo[n];
            if (localQZoneCountInfo == null) {
              break label213;
            }
            localEditor.putString(str + "&" + arrayOfInteger[n], localQZoneCountInfo.a());
            break label213;
          }
          if (Build.VERSION.SDK_INT < 9)
          {
            localEditor.commit();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QZoneManagerImp.", 2, localException.toString());
          return;
          localException.apply();
        }
      }
      return;
      label213:
      n += 1;
    }
  }
  
  public int a()
  {
    int i1 = 0;
    int n = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      i1 = n;
    }
    do
    {
      return i1;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      n = i1;
      if (str != null)
      {
        n = i1;
        if (str.length() > 0) {
          n = localSharedPreferences.getInt(str, 0);
        }
      }
      i1 = n;
    } while (!QLog.isColorLevel());
    QLog.d("QZoneManagerImp.", 2, "getGetUndealCountFlag:" + n);
    return n;
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "QZoneManagerImp getFeedCount type :" + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (localQZoneCountInfo != null) {
        return (int)localQZoneCountInfo.a;
      }
    }
    return 0;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(2));
      if (localQZoneCountInfo != null) {
        return String.valueOf(localQZoneCountInfo.jdField_b_of_type_Long);
      }
    }
    return "";
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneManagerImp.", 4, "QZoneManagerImp clearUnReadCount cache arrays.type = " + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localQZoneCountInfo);
      b();
      a(paramInt, 0L, 0L, "", false, "syncQZoneUnreadActionClean");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (l1 > 0L) {
        LocalMultiProcConfig.a("mine_message_count", paramInt2, l1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneManagerImp.", 2, "setPushCount type:" + paramInt1 + ",count" + paramInt2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, Bundle paramBundle)
  {
    paramBundle.putLong("com.tencent.qq.syncQZoneUnreadCount" + paramInt, paramLong2);
    paramBundle.putString("com.tencent.qq.syncQZoneUnreadMessage" + paramInt, paramString1);
    paramBundle.putLong("com.tencent.qq.syncQZoneUnreadUin" + paramInt, paramLong1);
    paramBundle.putInt("com.tencent.qq.syncQZoneUnreadType" + paramInt, paramInt);
    paramBundle.putString("com.tencent.qq.syncQZoneUnreadAction", paramString2);
    if (QLog.isColorLevel()) {
      QLog.d(QZoneLogTags.g, 2, "QZoneManagerImp.notifyQZoneAll type:" + paramInt + ",uin: " + paramLong1 + "count: " + paramLong2 + "message: " + paramString1 + "action: " + paramString2);
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, String paramString1, boolean paramBoolean, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(QZoneLogTags.g, 2, "QZoneManagerImp.notifyQZone type:" + paramInt + ",uin: " + paramLong1 + "count: " + paramLong2 + "message: " + paramString1 + "action: " + paramString2);
    }
    Intent localIntent = new Intent("com.tencent.qq.syncQzoneUnread");
    Bundle localBundle = new Bundle();
    localBundle.putLong("com.tencent.qq.syncQZoneUnreadCount" + paramInt, paramLong2);
    localBundle.putString("com.tencent.qq.syncQZoneUnreadMessage" + paramInt, paramString1);
    localBundle.putLong("com.tencent.qq.syncQZoneUnreadUin" + paramInt, paramLong1);
    localBundle.putInt("com.tencent.qq.syncQZoneUnreadType" + paramInt, paramInt);
    localBundle.putString("com.tencent.qq.syncQZoneUnreadAction", paramString2);
    localBundle.putBoolean("com.tencent.qq.existQzoneDLPush", paramBoolean);
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (this.m != 0)
    {
      paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      paramString1.setAction("Qzone_Get_NewAndUnread_Count");
      paramString1.putExtra("qzone_send_by_time", 1);
      paramString1.putExtra("scene", 100);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "sendGetFeedCount");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(HashMap paramHashMap)
  {
    boolean bool;
    for (;;)
    {
      int i2;
      try
      {
        if (this.b)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(QZoneLogTags.e + "QZoneManagerImp.", 4, "setFeedCount.user enter qzone.dismiss data.");
          }
        }
        else if ((paramHashMap != null) && (paramHashMap.size() != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          int i4 = 0;
          i1 = 0;
          Bundle localBundle = new Bundle();
          int i3 = 0;
          int n = 0;
          paramHashMap = paramHashMap.entrySet().toArray();
          if (paramHashMap != null)
          {
            int i5 = paramHashMap.length;
            i2 = 0;
            i3 = n;
            i4 = i1;
            if (i2 < i5)
            {
              Integer localInteger = paramHashMap[i2];
              if ((localInteger == null) || (!(localInteger instanceof Map.Entry))) {
                continue;
              }
              Object localObject = (Map.Entry)localInteger;
              localInteger = (Integer)((Map.Entry)localObject).getKey();
              localObject = (QZoneCountInfo)((Map.Entry)localObject).getValue();
              if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
              {
                if (QLog.isColorLevel()) {
                  QLog.d(QZoneLogTags.g, 2, "QZoneManagerImp.checkShowQZonePush" + n + "count" + ((QZoneCountInfo)localObject).a);
                }
                if (localInteger.intValue() == 17) {
                  break label409;
                }
              }
              bool = a(localInteger.intValue(), ((QZoneCountInfo)localObject).a, ((QZoneCountInfo)localObject).jdField_b_of_type_Long, "", ((QZoneCountInfo)localObject).jdField_b_of_type_JavaLangString, true, localBundle);
              if (!bool) {
                continue;
              }
              if (QLog.isColorLevel()) {
                QLog.d(QZoneLogTags.g, 2, "QZoneManagerImp.set feedcout map type:" + n + "count change");
              }
              n = localInteger.intValue() | n;
              break;
            }
          }
          if (i4 != 0)
          {
            b();
            d(i3);
            if (QLog.isColorLevel()) {
              QLog.d(QZoneLogTags.g, 2, "QZoneManagerImp.Send notifyQZone broadcast");
            }
            paramHashMap = new Intent("com.tencent.qq.syncQzoneUnread");
            paramHashMap.putExtras(localBundle);
            paramHashMap.putExtras(localBundle);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramHashMap);
            return;
          }
        }
      }
      catch (Exception paramHashMap)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QZoneManagerImp.", 2, paramHashMap.toString());
          return;
          break;
        }
      }
      return;
      label409:
      i2 += 1;
    }
    if ((i1 != 0) || (bool)) {}
    for (int i1 = 1;; i1 = 0) {
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "setEnterQZone.isenter=" + paramBoolean);
    }
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "setFeedCountAll.feedtype=" + paramInt + ",count=" + paramLong1 + ",uin=" + paramLong2);
    }
    if ((paramInt < 1) || (paramInt > 33)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
    localQZoneCountInfo.a = paramLong1;
    localQZoneCountInfo.jdField_b_of_type_Long = paramLong2;
    localQZoneCountInfo.jdField_b_of_type_JavaLangString = paramString2;
    boolean bool = false;
    if (!localQZoneCountInfo.a((QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)))) {
      bool = true;
    }
    if (bool)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localQZoneCountInfo);
      if (paramBoolean) {
        a(paramInt, paramLong2, paramLong1, paramString1, "syncQZoneUnreadActionChange", paramBundle);
      }
    }
    return bool;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "setFeedCount.feedtype=" + paramInt + ",count=" + paramLong1 + ",uin=" + paramLong2);
    }
    if ((paramInt < 1) || (paramInt > 33)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
    localQZoneCountInfo.a = paramLong1;
    localQZoneCountInfo.jdField_b_of_type_Long = paramLong2;
    boolean bool = false;
    if (!localQZoneCountInfo.a((QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)))) {
      bool = true;
    }
    if (bool)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localQZoneCountInfo);
      b();
      d(paramInt);
      if (paramBoolean2) {
        a(paramInt, paramLong2, paramLong1, paramString, paramBoolean1, "syncQZoneUnreadActionChange");
      }
    }
    return bool;
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) || (paramInt <= 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime. by servlet. type:" + paramInt);
          }
          if (paramInt == 2) {
            try
            {
              NewIntent localNewIntent1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
              localNewIntent1.setAction("Qzone_Get_NewAndUnread_Count");
              localNewIntent1.putExtra("qzone_send_by_time", paramInt);
              localNewIntent1.putExtra("scene", 103);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent1);
              if (QLog.isColorLevel())
              {
                QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.switch to forground.");
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
      if (paramInt == 3)
      {
        ThreadManager.a(new upn(this, paramInt), 8, null, true);
        return;
      }
    } while ((paramInt != 5) && (paramInt != 6) && (paramInt != 7) && (paramInt != 8));
    NewIntent localNewIntent2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
    localNewIntent2.setAction("Qzone_Get_NewAndUnread_Count");
    localNewIntent2.putExtra("qzone_send_by_time", paramInt);
    if ((paramInt == 5) || (paramInt == 6)) {
      localNewIntent2.putExtra("scene", 100);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent2);
      return;
      if ((paramInt == 7) || (paramInt == 8)) {
        localNewIntent2.putExtra("scene", 104);
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0).edit();
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((str != null) && (str.length() > 0)) {
        localEditor.putInt(str, paramInt);
      }
      if (Build.VERSION.SDK_INT < 9) {
        localEditor.commit();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("QZoneManagerImp.", 2, "setGetUndealCountFlag:" + paramInt);
        return;
        localEditor.apply();
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
    localNewIntent.setAction("Qzone_Refresh_UI");
    localNewIntent.putExtra("notify_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\QZoneManagerImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */