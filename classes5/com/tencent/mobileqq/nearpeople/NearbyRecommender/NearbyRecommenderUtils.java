package com.tencent.mobileqq.nearpeople.NearbyRecommender;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class NearbyRecommenderUtils
{
  public static final int a = 18;
  public static final String a = "NearbyRecommenderUtils";
  public static final int b = 86400;
  public static final String b = "v5.8.nbr";
  public static final int c = 180;
  public static final String c = "sp_nearbyrecommender";
  public static final int d = 172800;
  public static final String d = "key_login_pull_interval";
  public static final String e = "key_msgbox_pull_interval";
  public static final String f = "key_expiretime";
  public static final String g = "key_login_pull_time";
  public static final String h = "key_msgbox_pull_time";
  public static final String i = "key_nearbyrecommender_title";
  public static final String j = "key_nearbyrecommender_reasontype";
  public static final String k = "key_nearbyrecommender_uins";
  
  public NearbyRecommenderUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Object.class;
    paramString = FileUtils.a(paramString + "v5.8.nbr", arrayOfClass);
    paramQQAppInterface = (QQAppInterface)localObject;
    if (paramString != null)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (paramString.length == arrayOfClass.length) {
        paramQQAppInterface = (List)paramString[0];
      }
    }
    return paramQQAppInterface;
  }
  
  public static void a(Context paramContext, String paramString, List paramList)
  {
    if (paramList == null) {
      return;
    }
    FileUtils.a(paramString + "v5.8.nbr", new Object[] { paramList });
  }
  
  public static void a(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int m;
    int n;
    int i1;
    long l1;
    long l2;
    do
    {
      return;
      SharedPreferences.Editor localEditor = paramAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0).edit();
      m = paramBundle.getInt("key_login_pull_interval", -1);
      if (m != -1) {
        localEditor.putInt(paramAppInterface.a() + "_" + "key_login_pull_interval", m);
      }
      n = paramBundle.getInt("key_msgbox_pull_interval", -1);
      if (n != -1) {
        localEditor.putInt(paramAppInterface.a() + "_" + "key_msgbox_pull_interval", n);
      }
      i1 = paramBundle.getInt("key_expiretime", -1);
      if (i1 != -1) {
        localEditor.putInt(paramAppInterface.a() + "_" + "key_expiretime", i1);
      }
      l1 = paramBundle.getLong("key_login_pull_time", 0L);
      if (l1 != 0L) {
        localEditor.putLong(paramAppInterface.a() + "_" + "key_login_pull_time", l1);
      }
      l2 = paramBundle.getLong("key_msgbox_pull_time", 0L);
      if (l2 != 0L) {
        localEditor.putLong(paramAppInterface.a() + "_" + "key_msgbox_pull_time", l2);
      }
      String str = paramBundle.getString("key_nearbyrecommender_title");
      if (!TextUtils.isEmpty(str)) {
        localEditor.putString("key_nearbyrecommender_title", str);
      }
      int i2 = paramBundle.getInt("key_nearbyrecommender_reasontype", -1);
      if (i2 != -1) {
        localEditor.putInt(paramAppInterface.a() + "_" + "key_nearbyrecommender_reasontype", i2);
      }
      paramBundle = paramBundle.getString("key_nearbyrecommender_uins");
      if (!"".equals(paramBundle)) {
        localEditor.putString(paramAppInterface.a() + "_" + "key_nearbyrecommender_uins", paramBundle);
      }
      localEditor.commit();
    } while (!QLog.isColorLevel());
    QLog.d("NearbyRecommenderUtils", 2, "updateConfigs--->login_pull_interval=" + m + ",msgbox_pull_interval=" + n + ",expiretime=" + i1 + ",login_pull_time=" + l1 + ",msgbox_pull_time=" + l2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "checkExpireTime");
    }
    if (a(paramQQAppInterface))
    {
      int m = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0).getInt("key_expiretime", 172800);
      long l3 = System.currentTimeMillis();
      long l2 = 0L;
      Object localObject = paramQQAppInterface.getApplication().getFileStreamPath(paramQQAppInterface.a() + "v5.8.nbr");
      long l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (((File)localObject).exists()) {
          l1 = ((File)localObject).lastModified();
        }
      }
      if (m <= Math.abs(l3 - l1) / 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyRecommenderUtils", 2, "checkExpireTime-->expire true");
        }
        paramQQAppInterface = paramQQAppInterface.a();
        localObject = paramQQAppInterface.b(AppConstants.ar, 1001).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (localMessageRecord.msgtype == 61525) {
            paramQQAppInterface.a(localMessageRecord, true);
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "addNearbyRecommenderMsg");
    }
    MessageForNearbyRecommenderTips localMessageForNearbyRecommenderTips = (MessageForNearbyRecommenderTips)MessageRecordFactory.a(61525);
    long l = MessageCache.a();
    localMessageForNearbyRecommenderTips.init(paramQQAppInterface.a(), AppConstants.aS, AppConstants.aS, "", l, 61525, 1001, l);
    localMessageForNearbyRecommenderTips.isread = true;
    MsgProxyUtils.a(localMessageForNearbyRecommenderTips, false);
    localMessageForNearbyRecommenderTips.readFlag = false;
    localMessageForNearbyRecommenderTips.strBrief = paramString;
    localMessageForNearbyRecommenderTips.uRecommendTime = paramLong;
    localMessageForNearbyRecommenderTips.serial();
    paramQQAppInterface.a().a(localMessageForNearbyRecommenderTips, localMessageForNearbyRecommenderTips.selfuin);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "-----addGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + Utils.a(paramString3));
    }
    long l = MessageCache.a();
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(60529);
    localMessageForGrayTips.init(paramQQAppInterface.a(), paramString1, paramString2, paramString3, l, 60529, paramInt, l);
    localMessageForGrayTips.isread = paramBoolean2;
    if ((!paramBoolean1) || (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForGrayTips, false))) {
      paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.a());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().b(AppConstants.ar, 1001);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      MessageRecord localMessageRecord;
      do
      {
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)paramQQAppInterface.next();
      } while ((localMessageRecord.msgtype != 61525) || (((MessageForNearbyRecommenderTips)localMessageRecord).readFlag));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyRecommenderUtils", 2, "checkUnreadMsgForNearbyRecommender,resut=" + bool);
      }
      return bool;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool6 = false;
    int n = 0;
    long l3 = 0L;
    long l4 = 0L;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    long l1 = l4;
    long l2 = l3;
    int m = n;
    boolean bool5 = bool6;
    if (paramInt == 1)
    {
      if (paramQQAppInterface.a().a(AppConstants.ar, 1001).msgtype == 61525) {
        bool1 = true;
      }
      if (!bool1) {
        bool2 = a(paramQQAppInterface);
      }
      if (!bool1)
      {
        bool3 = bool2;
        bool4 = bool1;
        l1 = l4;
        l2 = l3;
        m = n;
        bool5 = bool6;
        if (!bool2) {}
      }
      else
      {
        SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
        n = localSharedPreferences.getInt(paramQQAppInterface.a() + "_" + "key_msgbox_pull_interval", 180);
        l3 = localSharedPreferences.getLong(paramQQAppInterface.a() + "_" + "key_msgbox_pull_time", 0L);
        l4 = System.currentTimeMillis();
        if (l3 != 0L)
        {
          bool3 = bool2;
          bool4 = bool1;
          l1 = l4;
          l2 = l3;
          m = n;
          bool5 = bool6;
          if (n > Math.abs(l4 - l3) / 1000L) {}
        }
        else
        {
          bool5 = true;
          m = n;
          l2 = l3;
          l1 = l4;
          bool4 = bool1;
          bool3 = bool2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "isNeedPullNearbyRecommenderData changjing=" + paramInt + ",isLastMessage=" + bool4 + ",hasUnreadMessage=" + bool3 + ",pull_interval=" + m + ",pullTime=" + l2 + ",currentTime=" + l1 + ",result=" + bool5);
    }
    return bool5;
  }
  
  public static String[] a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    int m = localSharedPreferences.getInt(paramQQAppInterface.a() + "_" + "key_nearbyrecommender_reasontype", 0);
    paramQQAppInterface = localSharedPreferences.getString(paramQQAppInterface.a() + "_" + "key_nearbyrecommender_uins", "");
    return new String[] { Integer.toString(m), paramQQAppInterface };
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "setNearbyRecommenderMsgRead");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    QQMessageFacade.Message localMessage = paramQQAppInterface.a(AppConstants.ar, 1001);
    Object localObject1;
    if (localMessage.msgtype == 61525) {
      localObject1 = new MessageForNearbyRecommenderTips();
    }
    for (;;)
    {
      try
      {
        ((MessageForNearbyRecommenderTips)localObject1).msgData = localMessage.msgData;
        ((MessageForNearbyRecommenderTips)localObject1).parse();
        if (((MessageForNearbyRecommenderTips)localObject1).readFlag) {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localObject1 = paramQQAppInterface.b(AppConstants.ar, 1001);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (((MessageRecord)localObject2).msgtype == 61525)
          {
            localObject2 = (MessageForNearbyRecommenderTips)localObject2;
            if (!((MessageForNearbyRecommenderTips)localObject2).readFlag)
            {
              ((MessageForNearbyRecommenderTips)localObject2).readFlag = true;
              ((MessageForNearbyRecommenderTips)localObject2).serial();
              paramQQAppInterface.a(((MessageForNearbyRecommenderTips)localObject2).frienduin, ((MessageForNearbyRecommenderTips)localObject2).istroop, ((MessageForNearbyRecommenderTips)localObject2).uniseq, ((MessageForNearbyRecommenderTips)localObject2).msgData);
            }
          }
        }
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if (paramQQAppInterface.a().a(AppConstants.ar, 1001).msgtype == 61525) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyRecommenderUtils", 2, "checkShowNearbyRecommender,result=" + bool);
      }
      return bool;
      if (!a(paramQQAppInterface)) {
        bool = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearpeople\NearbyRecommender\NearbyRecommenderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */