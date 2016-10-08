package com.tencent.mobileqq.subaccount;

import QQService.BindUin;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.provider.Settings.System;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SubAccountBaseActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import uxi;
import uxk;
import uxl;

public class SubAccountControll
  implements Manager
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 300L;
  public static final String a = "sub.uin.default";
  public static final boolean a = true;
  public static final int b = 1;
  public static final String b = "sub.uin.all";
  public static final int c = 2;
  public static String c = "yyyy-MM-dd";
  public static final int d = 3;
  public static final String d = "param_FailCode";
  public static final int e = 4;
  public static final String e = "fail_step";
  public static final int f = 5;
  public static final String f = "fail_location";
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 2;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = new uxl(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private long jdField_b_of_type_Long = 300L;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SubAccountControll(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    try
    {
      String str = Settings.System.getString(BaseApplication.getContext().getContentResolver(), "date_format");
      if (!TextUtils.isEmpty(str)) {
        c = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "subaccountMsgFreq");
          if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface)))
          {
            this.jdField_b_of_type_Long = Long.parseLong(paramQQAppInterface);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "init msgDelayTime = " + this.jdField_b_of_type_Long);
            }
          }
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.a().getSharedPreferences("acc_info" + paramString, 0).getLong("getProfileStatusNew", 11L);
  }
  
  public static Pair a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool4 = false;
    Object localObject;
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("checkSubAccountLoginStatus() app is null?=>");
        if (paramQQAppInterface != null) {
          break label97;
        }
        bool1 = true;
        paramQQAppInterface = ((StringBuilder)localObject).append(bool1).append(" subUin is null?=>");
        if (paramString != null) {
          break label103;
        }
      }
      label97:
      label103:
      for (bool1 = bool2;; bool1 = false)
      {
        QLog.d("SUB_ACCOUNT", 2, bool1);
        return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
        bool1 = false;
        break;
      }
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getAllAccounts();
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("checkSubAccountLoginStatus() app.getAllAccounts() is null? =>");
        if (paramQQAppInterface != null) {
          break label184;
        }
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, bool1);
        return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
        label184:
        bool1 = false;
      }
    }
    int n = 0;
    if (n < paramQQAppInterface.size())
    {
      localObject = (SimpleAccount)paramQQAppInterface.get(n);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount == null");
        }
      }
      label262:
      do
      {
        for (;;)
        {
          n += 1;
          break;
          if (((SimpleAccount)localObject).getUin() != null) {
            break label262;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount.getUin() == null");
          }
        }
      } while (!((SimpleAccount)localObject).getUin().equalsIgnoreCase(paramString));
      bool1 = bool3;
      bool2 = bool4;
      if (((SimpleAccount)localObject).isLogined())
      {
        bool2 = true;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() hasAccount=" + bool1 + " isLogin=" + bool2);
      }
      return new Pair(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      bool1 = false;
      bool2 = bool4;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = "";
    Object localObject2;
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() return. app=" + String.valueOf(paramQQAppInterface) + " subUin=" + paramString);
        localObject2 = localObject1;
      }
      return (CharSequence)localObject2;
    }
    Object localObject3;
    if (AppConstants.ah.equals(paramString))
    {
      localObject3 = paramQQAppInterface.getApplication().getAllNotSynAccountList();
      if ((localObject3 != null) && (((List)localObject3).size() > 1))
      {
        localObject1 = (SimpleAccount)((List)localObject3).get(0);
        if ((localObject1 == null) || (((SimpleAccount)localObject1).getUin() == null)) {
          break label1122;
        }
        localObject2 = ((SimpleAccount)localObject1).getUin();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equalsIgnoreCase(paramQQAppInterface.getAccount())) {}
        }
      }
    }
    label183:
    label1105:
    label1122:
    for (localObject1 = ((SimpleAccount)((List)localObject3).get(1)).getUin();; localObject1 = null)
    {
      if ((localObject1 == null) || (((String)localObject1).length() < 5))
      {
        paramQQAppInterface = paramQQAppInterface.a().getResources().getString(2131370562);
        localObject2 = paramQQAppInterface;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + paramQQAppInterface);
        return paramQQAppInterface;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject3 = ContactUtils.i(paramQQAppInterface, (String)localObject1);; localObject3 = null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = localObject3;
          if (!((String)localObject3).equals(localObject1)) {}
        }
        else
        {
          localObject2 = ContactUtils.c(paramQQAppInterface, (String)localObject1, true);
        }
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = localObject1;
        }
        paramQQAppInterface = paramQQAppInterface.a().getResources().getString(2131370569, new Object[] { localObject3 });
        break label183;
        paramQQAppInterface = paramQQAppInterface.a().getResources().getString(2131370562);
        break label183;
        localObject1 = ContactUtils.c(paramQQAppInterface, paramString, true);
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          localObject1 = paramString;
        }
        for (;;)
        {
          SubAccountManager localSubAccountManager = (SubAccountManager)paramQQAppInterface.getManager(60);
          int n = localSubAccountManager.a(paramString);
          if (n == 1)
          {
            localObject2 = localSubAccountManager.a(paramString);
            localObject3 = new SpannableStringBuilder();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramQQAppInterface = localSubAccountManager.b(paramString);
              localObject1 = localSubAccountManager.c(paramString);
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
                ((SpannableStringBuilder)localObject3).append(":");
                ((SpannableStringBuilder)localObject3).append((CharSequence)localObject2);
                if (QLog.isColorLevel()) {
                  QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + ((CharSequence)localObject3).charAt(0) + "|" + ((CharSequence)localObject3).length());
                }
                return (CharSequence)localObject3;
              }
              if (paramQQAppInterface == null) {
                paramQQAppInterface = "";
              }
              for (;;)
              {
                ((SpannableStringBuilder)localObject3).append(paramQQAppInterface);
                ((SpannableStringBuilder)localObject3).append(":");
                break;
              }
            }
            if (localSubAccountManager.c(paramString)) {}
            for (paramQQAppInterface = paramQQAppInterface.a().getString(2131370525, new Object[] { localObject1 });; paramQQAppInterface = paramQQAppInterface.a().getString(2131370533))
            {
              localObject2 = paramQQAppInterface;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + paramQQAppInterface);
              return paramQQAppInterface;
            }
          }
          if (n == 2)
          {
            if (localSubAccountManager.c(paramString)) {}
            for (paramQQAppInterface = paramQQAppInterface.a().getString(2131370525, new Object[] { localObject1 });; paramQQAppInterface = paramQQAppInterface.a().getResources().getString(2131370565))
            {
              localObject2 = paramQQAppInterface;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + paramQQAppInterface);
              return paramQQAppInterface;
            }
          }
          if (n == 3)
          {
            localObject1 = localSubAccountManager.a(paramString);
            if (localObject1 == null) {
              break label1105;
            }
            n = ((Integer)((Pair)localObject1).first).intValue();
            localObject2 = (String)((Pair)localObject1).second;
          }
          for (;;)
          {
            if (n != 0) {
              switch (n)
              {
              default: 
                localObject1 = paramQQAppInterface.a().getString(2131370536);
              }
            }
            for (;;)
            {
              localObject2 = localObject1;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + localObject1);
              return (CharSequence)localObject1;
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                if (((String)localObject2).trim().length() != 0) {}
              }
              else
              {
                localObject1 = paramQQAppInterface.a().getString(2131370536);
                continue;
                if (localObject2 != null)
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).trim().length() != 0) {}
                }
                else
                {
                  localObject1 = paramQQAppInterface.a().getString(2131370537);
                  continue;
                  if (localObject2 != null)
                  {
                    localObject1 = localObject2;
                    if (((String)localObject2).trim().length() != 0) {}
                  }
                  else
                  {
                    localObject1 = paramQQAppInterface.a().getString(2131370553);
                    continue;
                    if (localObject2 != null)
                    {
                      localObject1 = localObject2;
                      if (((String)localObject2).trim().length() != 0) {}
                    }
                    else
                    {
                      localObject1 = paramQQAppInterface.a().getString(2131370536);
                      continue;
                      if (localObject2 != null)
                      {
                        localObject1 = localObject2;
                        if (((String)localObject2).trim().length() != 0) {}
                      }
                      else
                      {
                        localObject1 = paramQQAppInterface.a().getString(2131370536);
                        continue;
                        localObject1 = paramQQAppInterface.a().getResources().getString(2131370565);
                      }
                    }
                  }
                }
              }
            }
            paramQQAppInterface = paramQQAppInterface.a().getString(2131370563, new Object[] { localObject1 });
            localObject2 = paramQQAppInterface;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + paramQQAppInterface);
            return paramQQAppInterface;
            localObject2 = null;
            n = 0;
          }
        }
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramString1 = null;
    Object localObject = null;
    BaseApplication localBaseApplication = paramQQAppInterface.a();
    if (SystemMsg.isSystemMessage(paramInt)) {
      switch (paramInt)
      {
      default: 
        paramString1 = (String)localObject;
      }
    }
    for (;;)
    {
      paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramString2, true);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramString2))) {
        break;
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramQQAppInterface).append(paramString1);
      paramString1 = paramString2.toString();
      return paramString1;
      paramString1 = localBaseApplication.getString(2131368863);
      continue;
      paramString1 = localBaseApplication.getString(2131368864);
      continue;
      paramString1 = localBaseApplication.getString(2131368865);
      continue;
      paramString1 = localBaseApplication.getString(2131368872);
      continue;
      paramString1 = localBaseApplication.getString(2131368873);
    }
    return paramString2 + paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() return, app == null");
      }
    }
    label410:
    label461:
    label796:
    do
    {
      SubAccountManager localSubAccountManager;
      do
      {
        return;
        localSubAccountManager = (SubAccountManager)paramQQAppInterface.getManager(60);
      } while (localSubAccountManager == null);
      long l1 = DBUtils.a().a(paramQQAppInterface.a());
      long l2 = ApkUtils.a(paramQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData()..start, historyVersion=" + l1 + " thisApkVersion=" + l2);
      }
      boolean bool;
      Object localObject;
      int n;
      RecentUser localRecentUser;
      SubAccountInfo localSubAccountInfo;
      if (l1 < l2)
      {
        if (l1 == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() need to update (v5.0 or lower) data");
          }
          bool = DBUtils.a().a(paramQQAppInterface.a(), paramQQAppInterface.getAccount());
          localObject = localSubAccountManager.a("sub.uin.default");
          if ((localObject != null) && (((SubAccountInfo)localObject).subuin != null))
          {
            localSubAccountManager.g(((SubAccountInfo)localObject).subuin);
            n = localSubAccountManager.d(((SubAccountInfo)localObject).subuin) - paramQQAppInterface.a().a(((SubAccountInfo)localObject).subuin, 7000);
            if (n != 0)
            {
              paramQQAppInterface.a().c(((SubAccountInfo)localObject).subuin, 7000, n);
              paramQQAppInterface.a().a(new String[] { AppConstants.ah, ((SubAccountInfo)localObject).subuin });
            }
            if (bool)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "initAllData(), setTopInRecentList, isTop=" + bool);
              }
              a(paramQQAppInterface, ((SubAccountInfo)localObject).subuin, true);
            }
          }
          DBUtils.a().a(paramQQAppInterface.a());
        }
      }
      else
      {
        if (!DBUtils.a().b(paramQQAppInterface.a(), paramQQAppInterface.getAccount()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() showedBefore:false, isFirstTime to user SubAccount.");
          }
          DBUtils.a().a(paramQQAppInterface.a(), paramQQAppInterface.getAccount(), true);
          a(paramQQAppInterface, 7);
        }
        localObject = paramQQAppInterface.a().a();
        localRecentUser = ((RecentUserProxy)localObject).b(AppConstants.ah, 7000);
        if (localSubAccountManager.a() <= 0) {
          break label796;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "initAllData() getBindedNumber > 0, go to initAllData");
        }
        ArrayList localArrayList = localSubAccountManager.b();
        int i2 = localArrayList.size();
        n = 0;
        if (n >= i2) {
          break label796;
        }
        localSubAccountInfo = (SubAccountInfo)localArrayList.get(n);
        if (localSubAccountInfo != null) {
          break label461;
        }
      }
      for (;;)
      {
        n += 1;
        break label410;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "initAllData() (v5.1 or later) update..");
        break;
        if (localRecentUser != null)
        {
          paramQQAppInterface.a().c(localRecentUser.uin, localRecentUser.type);
          ((RecentUserProxy)localObject).b(localRecentUser);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() delete defaultRU:" + localRecentUser.uin + " type=" + localRecentUser.type);
          }
        }
        if ((localRecentUser != null) && (l1 == 0L))
        {
          a(paramQQAppInterface, localSubAccountInfo.subuin, 7);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() add RU:" + localSubAccountInfo.subuin);
          }
          int i3 = paramQQAppInterface.a().a(localSubAccountInfo.subuin, 7000);
          int i1 = 0;
          if (localSubAccountManager != null) {
            i1 = localSubAccountManager.d(localSubAccountInfo.subuin);
          }
          int i4 = i1 - i3;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() setReaded subaccount,old:" + i3 + " target:" + i1 + " increase:" + i4);
          }
          if (i4 != 0)
          {
            paramQQAppInterface.a().c(localSubAccountInfo.subuin, 7000, i4);
            paramQQAppInterface.a().a(new String[] { AppConstants.ah, localSubAccountInfo.subuin });
          }
        }
        bool = false;
        Pair localPair = a(paramQQAppInterface, localSubAccountInfo.subuin);
        if (localPair != null) {
          bool = ((Boolean)localPair.second).booleanValue();
        }
        if (bool) {
          paramQQAppInterface.getSubAccountKey(paramQQAppInterface.getAccount(), localSubAccountInfo.subuin, new uxi(paramQQAppInterface));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() end");
      }
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() subUin=" + paramString + " cmd=" + paramByte);
    }
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramQQAppInterface, paramByte, localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte paramByte, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("setBindUinStatus() return, listSubUin:");
        if (paramArrayList != null) {
          break label54;
        }
        paramQQAppInterface = "null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    label54:
    do
    {
      return;
      paramQQAppInterface = "size=0";
      break;
      if ((paramByte == 0) || (paramByte == 1)) {
        break label103;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() return, cmd=" + paramByte);
    return;
    label103:
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    label117:
    if (localIterator.hasNext()) {
      paramArrayList = (String)localIterator.next();
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramArrayList);
        if ((l1 == 0L) || (l1 <= 10000L)) {
          break label117;
        }
        if (paramByte != 1) {
          break label429;
        }
        l2 = paramQQAppInterface.a().getSharedPreferences("acc_info" + paramArrayList, 0).getLong("getProfileStatusNew", 11L);
        Object localObject2 = (SubAccountManager)paramQQAppInterface.getManager(60);
        if (localObject2 == null) {
          break label424;
        }
        paramArrayList = ((SubAccountManager)localObject2).a(paramArrayList);
        if (paramArrayList == null)
        {
          paramArrayList = new byte[0];
          localObject2 = new BindUin();
          ((BindUin)localObject2).lUin = l1;
          ((BindUin)localObject2).iStatus = ((int)l2);
          ((BindUin)localObject2).sKey = paramArrayList;
          ((ArrayList)localObject1).add(localObject2);
          if (!QLog.isColorLevel()) {
            break label117;
          }
          localObject2 = new StringBuilder().append("setBindUinStatus() add<QQService.BindUin>:lUin=").append(l1).append(" cmd=").append(paramByte).append(" status=").append(l2).append(" sKey=");
          if (paramArrayList != null) {
            continue;
          }
          paramArrayList = "null";
          QLog.d("SUB_ACCOUNT", 2, paramArrayList);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        long l1 = 0L;
        continue;
        paramArrayList = HexUtil.a(paramArrayList);
        continue;
        paramArrayList = Integer.valueOf(paramArrayList.length);
        continue;
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.a(paramByte, (ArrayList)localObject1);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() return, ArrayList<QQService.BindUin> list.size=0");
      return;
      label424:
      paramArrayList = null;
      continue;
      label429:
      long l2 = 21L;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unbindAllRecentitem() defAct=" + paramInt);
    }
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    Object localObject = localRecentUserProxy.a(false);
    int n = paramInt;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        n = paramInt;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((localRecentUser != null) && (localRecentUser.type == 7000) && (!AppConstants.ah.equals(localRecentUser.uin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "RecentUserProxy.deleteRecentUserByType, uin=" + localRecentUser.uin + " type=" + localRecentUser.type);
          }
          paramQQAppInterface.a().c(localRecentUser.uin, localRecentUser.type);
          localRecentUserProxy.b(localRecentUser);
          paramInt = 7;
        }
      }
    }
    a(paramQQAppInterface, localRecentUserProxy, AppConstants.ah, n);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("showMaxHintDialog() actCaller=");
      if (paramBaseActivity != null) {
        break label47;
      }
    }
    label47:
    for (Object localObject1 = "null";; localObject1 = paramBaseActivity.getClass().getSimpleName())
    {
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      if (paramBaseActivity != null) {
        break;
      }
      return;
    }
    localObject1 = paramBaseActivity.getString(2131370524);
    Object localObject2 = paramBaseActivity.getString(2131370539, new Object[] { Integer.valueOf(2) });
    localObject1 = DialogUtil.a(paramBaseActivity, 230).setTitle((String)localObject1).setMessage((CharSequence)localObject2);
    ((QQCustomDialog)localObject1).setOwnerActivity(paramBaseActivity);
    ((QQCustomDialog)localObject1).setPositiveButton(paramBaseActivity.getString(2131370504), new uxk(paramQQAppInterface, paramBaseActivity));
    ((QQCustomDialog)localObject1).setCancelable(false);
    ((QQCustomDialog)localObject1).show();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateRecentUser() subUin=" + paramString + " actionType=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramInt == 0)) {
      if (QLog.isColorLevel())
      {
        paramRecentUserProxy = new StringBuilder().append("updateRecentUser() return,");
        if (paramString != null) {
          break label100;
        }
        paramQQAppInterface = "subUin==null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    label100:
    label144:
    do
    {
      do
      {
        return;
        paramQQAppInterface = "subUin.len=0 action=" + paramInt;
        break;
        if (paramRecentUserProxy != null) {
          break label144;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SUB_ACCOUNT", 2, "updateRecentUser() return, ruProxy==null");
      return;
      localRecentUser = paramRecentUserProxy.b(paramString, 7000);
      if (localRecentUser != null) {
        break label422;
      }
    } while ((paramInt == 5) || (paramInt == 0));
    RecentUser localRecentUser = new RecentUser();
    localRecentUser.type = 7000;
    label422:
    for (;;)
    {
      localRecentUser.uin = paramString;
      if (AppConstants.ah.equals(paramString))
      {
        localRecentUser.lastmsgtime = MessageCache.a();
        paramInt = 1;
      }
      while (paramInt != 0)
      {
        paramRecentUserProxy.a(localRecentUser);
        return;
        paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(60);
        long l2 = paramQQAppInterface.a(paramString);
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = MessageCache.a();
        }
        switch (paramInt)
        {
        case 3: 
        default: 
          paramInt = 0;
          break;
        case 1: 
        case 2: 
        case 6: 
        case 7: 
          l2 = MessageCache.a();
          ArrayList localArrayList = (ArrayList)paramQQAppInterface.a.get(paramString);
          l1 = l2;
          if (paramInt == 6)
          {
            l1 = l2;
            if (localArrayList != null)
            {
              l1 = l2;
              if (localArrayList.size() != 0) {
                l1 = ((SubAccountMessage)localArrayList.get(0)).time;
              }
            }
          }
          paramQQAppInterface.a(paramString, l1);
          localRecentUser.lastmsgtime = l1;
          paramInt = 1;
          break;
        case 5: 
          localRecentUser.lastmsgtime = l1;
          localRecentUser.showUpTime = 0L;
          paramInt = 1;
          break;
        case 4: 
          localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
          paramInt = 1;
        }
      }
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "clearAllData() subUin=" + paramString);
    }
    if ("sub.uin.all".equals(paramString))
    {
      paramString = (SubAccountManager)paramQQAppInterface.getManager(60);
      if (paramString == null) {
        break label181;
      }
    }
    label181:
    for (paramString = paramString.a();; paramString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "clearAllData() clear all_sub_uin. list=" + paramString);
      }
      if (paramString != null)
      {
        paramString = paramString.iterator();
        int n = 0;
        while (paramString.hasNext())
        {
          Object localObject = (String)paramString.next();
          if (!"sub.uin.all".equals(localObject))
          {
            n += 1;
            a(paramQQAppInterface, (String)localObject);
            continue;
            if (paramQQAppInterface != null)
            {
              localObject = (SubAccountManager)paramQQAppInterface.getManager(60);
              if (localObject != null)
              {
                ((SubAccountManager)localObject).a(paramString);
                ((SubAccountManager)localObject).c(paramString);
                if (ContactUtils.c(paramQQAppInterface, paramString, false) != null) {
                  break;
                }
              }
            }
          }
        }
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() subUin=" + paramString + " actionType=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() < 5)) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() return, subUin==null || subUin.length()<5");
      }
    }
    do
    {
      return;
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.ah, 7000);
      if (localRecentUser != null)
      {
        paramQQAppInterface.a().c(localRecentUser.uin, localRecentUser.type);
        localRecentUserProxy.b(localRecentUser);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
        }
      }
      a(paramQQAppInterface, localRecentUserProxy, paramString, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("setSBTopInRecentList() return, ");
        if (paramQQAppInterface != null) {
          break label51;
        }
      }
      label51:
      for (paramQQAppInterface = "app==null";; paramQQAppInterface = "subUin==null")
      {
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
        return;
      }
    }
    if (AppConstants.ah.equals(paramString)) {
      if (paramBoolean) {
        a(paramQQAppInterface, paramQQAppInterface.a().a(), AppConstants.ah, 7);
      }
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface.sendEmptyMessage(1009);
      return;
      ((SubAccountManager)paramQQAppInterface.getManager(60)).a(paramString, paramBoolean);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      if (paramBoolean) {
        a(paramQQAppInterface, localRecentUserProxy, paramString, 4);
      } else {
        a(paramQQAppInterface, localRecentUserProxy, paramString, 5);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() list=" + String.valueOf(paramArrayList) + " actionType=" + paramInt);
    }
    Object localObject1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("bindRecentItem() return, list=");
        if (paramArrayList != null) {
          break label99;
        }
        paramQQAppInterface = "null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    for (;;)
    {
      return;
      label99:
      paramQQAppInterface = Integer.valueOf(paramArrayList.size());
      break;
      localObject1 = paramQQAppInterface.a().a();
      Object localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.ah, 7000);
      if (localObject2 != null)
      {
        paramQQAppInterface.a().c(((RecentUser)localObject2).uin, ((RecentUser)localObject2).type);
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (String)paramArrayList.next();
        a(paramQQAppInterface, (RecentUserProxy)localObject1, (String)localObject2, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + (String)localObject2);
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(60);
    if (paramQQAppInterface != null) {}
    for (int n = paramQQAppInterface.a();; n = 0)
    {
      if (n > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "checkAccountBind, bindedNum=" + n + " ret=" + bool);
        }
        return bool;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramString == null)
    {
      bool2 = bool1;
      return bool2;
    }
    bool1 = bool2;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      localObject = (SubAccountManager)paramQQAppInterface.getManager(60);
      if (localObject == null) {
        break label348;
      }
      localObject = ((SubAccountManager)localObject).a();
      label44:
      paramQQAppInterface = (SubAccountControll)paramQQAppInterface.getManager(61);
      bool1 = bool2;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      }
    }
    for (;;)
    {
      int n;
      try
      {
        if ((paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList == null) || (paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
          break label342;
        }
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          n = paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.size() - 1;
          if (n >= 0)
          {
            Pair localPair = (Pair)paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.get(n);
            if (((ArrayList)localObject).contains(localPair.first))
            {
              if (((Integer)localPair.second).intValue() == 1) {
                paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.remove(n);
              }
            }
            else if (((Integer)localPair.second).intValue() == 0) {
              paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.remove(n);
            }
          }
        }
      }
      finally
      {
        paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if ((paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList != null) && (paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        bool1 = "sub.uin.all".equals(paramString);
        if (bool1) {
          bool1 = true;
        }
      }
      for (;;)
      {
        paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "needShowHintDialog() subUin=" + paramString + " bool=" + bool1);
        return bool1;
        localObject = paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            bool1 = paramString.equals(((Pair)((Iterator)localObject).next()).first);
            if (bool1)
            {
              bool1 = true;
              break;
            }
          }
        }
        label342:
        bool1 = false;
      }
      label348:
      localObject = null;
      break label44;
      n -= 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() subUin=" + paramString + " isFromPush=" + paramBoolean);
    }
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning()))
    {
      localObject = (SubAccountManager)paramQQAppInterface.getManager(60);
      if (localObject == null) {
        break label369;
      }
    }
    label369:
    for (Object localObject = ((SubAccountManager)localObject).a(paramString);; localObject = null)
    {
      SubAccountProtocManager localSubAccountProtocManager = (SubAccountProtocManager)paramQQAppInterface.getManager(27);
      if (localSubAccountProtocManager != null)
      {
        paramBoolean = localSubAccountProtocManager.a();
        if (!paramBoolean)
        {
          localObject = new SubAccountBackProtocData();
          ((SubAccountBackProtocData)localObject).a = "";
          ((SubAccountBackProtocData)localObject).b = paramQQAppInterface.getAccount();
          ((SubAccountBackProtocData)localObject).c = paramString;
          ((SubAccountBackProtocData)localObject).p = 1009;
          paramQQAppInterface.a().a(8003, false, localObject);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() return, get bind subaccount isFinish = " + paramBoolean);
          }
          return false;
        }
      }
      if ((paramString == null) || (paramString.length() == 0) || (localObject == null) || (((String)localObject).length() == 0) || (((String)localObject).trim().equals("")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() return, subUin=" + paramString + " a2=" + (String)localObject);
        }
        localObject = new SubAccountBackProtocData();
        ((SubAccountBackProtocData)localObject).a = "";
        ((SubAccountBackProtocData)localObject).b = paramQQAppInterface.getAccount();
        ((SubAccountBackProtocData)localObject).c = paramString;
        ((SubAccountBackProtocData)localObject).p = 1010;
        paramQQAppInterface.a().a(8003, false, localObject);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() lockMsg later really start get subaccount message account = " + paramQQAppInterface.getAccount() + "; sAccount = " + paramString);
      }
      ((MessageHandler)paramQQAppInterface.a(0)).a().a((byte)3, 0, paramString, (String)localObject, null);
      return true;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      c = paramString;
      paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(60);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.d(c);
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(60);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.iterator();
        while (paramQQAppInterface.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)paramQQAppInterface.next();
          if ((localSubAccountInfo != null) && (localSubAccountInfo.isTop)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unbindRecentItem subUin=" + paramString);
    }
    if ((paramString == null) || (paramString.length() < 4)) {}
    do
    {
      RecentUserProxy localRecentUserProxy;
      do
      {
        return;
        paramQQAppInterface.a().c(paramString, 7000);
        localRecentUserProxy = paramQQAppInterface.a().a();
        paramString = localRecentUserProxy.b(paramString, 7000);
        if (paramString != null)
        {
          localRecentUserProxy.b(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "unbindRecentItem() unbind,delete subUin:" + paramString.uin + " type=" + paramString.type);
          }
        }
      } while (((SubAccountManager)paramQQAppInterface.getManager(60)).a() != 0);
      a(paramQQAppInterface, localRecentUserProxy, AppConstants.ah, 7);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() unbind, add default RecentUser");
  }
  
  public Pair a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "addHintPair() subUin=" + paramString + " type=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() < 5) || ((paramInt != 0) && (paramInt != 1))) {
      return null;
    }
    Pair localPair1 = new Pair(paramString, Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaUtilArrayList != null)
        {
          paramInt = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
          if (paramInt >= 0)
          {
            Pair localPair2 = (Pair)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
            if (!paramString.equals(localPair2.first)) {
              break label248;
            }
            this.jdField_b_of_type_JavaUtilArrayList.remove(paramInt);
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.d("SUB_ACCOUNT", 2, "addHintPair() remove old, subUin=" + (String)localPair2.first + " type=" + localPair2.second);
            break label248;
          }
        }
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(localPair1);
        return localPair1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label248:
      paramInt -= 1;
    }
  }
  
  /* Error */
  public ArrayList a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc -124
    //   8: iconst_2
    //   9: new 134	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 849
    //   19: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: new 473	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 537	java/util/ArrayList:<init>	()V
    //   39: astore_2
    //   40: aload_1
    //   41: ifnonnull +5 -> 46
    //   44: aload_2
    //   45: areturn
    //   46: aload_0
    //   47: getfield 70	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   50: invokeinterface 766 1 0
    //   55: aload_0
    //   56: getfield 768	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   59: ifnull +28 -> 87
    //   62: ldc 20
    //   64: aload_1
    //   65: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +30 -> 98
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 768	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: invokevirtual 853	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   79: pop
    //   80: aload_0
    //   81: getfield 768	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   84: invokevirtual 856	java/util/ArrayList:clear	()V
    //   87: aload_0
    //   88: getfield 70	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   91: invokeinterface 777 1 0
    //   96: aload_2
    //   97: areturn
    //   98: aload_0
    //   99: getfield 768	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   102: invokevirtual 474	java/util/ArrayList:size	()I
    //   105: iconst_1
    //   106: isub
    //   107: istore 4
    //   109: iload 4
    //   111: iflt -24 -> 87
    //   114: aload_0
    //   115: getfield 768	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   118: iload 4
    //   120: invokevirtual 475	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   123: checkcast 183	com/tencent/util/Pair
    //   126: astore_3
    //   127: aload_1
    //   128: aload_3
    //   129: getfield 347	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   132: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +19 -> 154
    //   138: aload_2
    //   139: aload_3
    //   140: invokevirtual 540	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: aload_0
    //   145: getfield 768	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   148: iload 4
    //   150: invokevirtual 774	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   153: pop
    //   154: iload 4
    //   156: iconst_1
    //   157: isub
    //   158: istore 4
    //   160: goto -51 -> 109
    //   163: astore_1
    //   164: aload_0
    //   165: getfield 70	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   168: invokeinterface 777 1 0
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	SubAccountControll
    //   0	175	1	paramString	String
    //   39	100	2	localArrayList	ArrayList
    //   126	14	3	localPair	Pair
    //   107	52	4	n	int
    // Exception table:
    //   from	to	target	type
    //   55	87	163	finally
    //   98	109	163	finally
    //   114	154	163	finally
  }
  
  public void a(SubAccountBaseActivity paramSubAccountBaseActivity)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("cancelUnbindDialog() act=");
      if (paramSubAccountBaseActivity == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, (String)localObject);
      }
    }
    else
    {
      if (paramSubAccountBaseActivity != null) {
        break label58;
      }
    }
    label58:
    while (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      return;
      localObject = paramSubAccountBaseActivity.getClass().getSimpleName();
      break;
    }
    int n = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (n >= 0)
    {
      localObject = (QQCustomDialog)this.jdField_a_of_type_JavaUtilArrayList.get(n);
      if ((localObject == null) || (((QQCustomDialog)localObject).getOwnerActivity() != paramSubAccountBaseActivity) || (((QQCustomDialog)localObject).isShowing())) {}
      try
      {
        ((QQCustomDialog)localObject).dismiss();
        this.jdField_a_of_type_JavaUtilArrayList.remove(n);
        for (;;)
        {
          n -= 1;
          break;
          this.jdField_a_of_type_JavaUtilArrayList.remove(n);
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Pair paramPair, android.content.DialogInterface.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +116 -> 119
    //   6: new 134	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 874
    //   16: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore 6
    //   21: aload_3
    //   22: ifnonnull +115 -> 137
    //   25: ldc_w 547
    //   28: astore 5
    //   30: aload 6
    //   32: aload 5
    //   34: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 876
    //   40: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 6
    //   45: aload_2
    //   46: ifnonnull +129 -> 175
    //   49: ldc_w 547
    //   52: astore 5
    //   54: aload 6
    //   56: aload 5
    //   58: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 878
    //   64: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: astore 6
    //   69: aload_1
    //   70: ifnonnull +117 -> 187
    //   73: ldc_w 547
    //   76: astore 5
    //   78: aload 6
    //   80: aload 5
    //   82: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 880
    //   88: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: astore 6
    //   93: aload 4
    //   95: ifnonnull +100 -> 195
    //   98: ldc_w 547
    //   101: astore 5
    //   103: ldc -124
    //   105: iconst_2
    //   106: aload 6
    //   108: aload 5
    //   110: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_1
    //   120: ifnull +16 -> 136
    //   123: aload_2
    //   124: ifnull +12 -> 136
    //   127: aload_3
    //   128: ifnull +8 -> 136
    //   131: aload 4
    //   133: ifnonnull +70 -> 203
    //   136: return
    //   137: new 134	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   144: aload_3
    //   145: getfield 347	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   148: checkcast 225	java/lang/String
    //   151: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 882
    //   157: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_3
    //   161: getfield 355	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   164: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 5
    //   172: goto -142 -> 30
    //   175: aload_2
    //   176: invokevirtual 625	java/lang/Object:getClass	()Ljava/lang/Class;
    //   179: invokevirtual 630	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   182: astore 5
    //   184: goto -130 -> 54
    //   187: ldc_w 884
    //   190: astore 5
    //   192: goto -114 -> 78
    //   195: ldc_w 884
    //   198: astore 5
    //   200: goto -97 -> 103
    //   203: aload_3
    //   204: getfield 347	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   207: checkcast 225	java/lang/String
    //   210: astore 5
    //   212: aload_3
    //   213: getfield 355	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   216: checkcast 349	java/lang/Integer
    //   219: invokevirtual 352	java/lang/Integer:intValue	()I
    //   222: istore 9
    //   224: aload_0
    //   225: getfield 70	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   228: invokeinterface 766 1 0
    //   233: aload_0
    //   234: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   237: ifnull +141 -> 378
    //   240: aload_0
    //   241: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   244: invokevirtual 474	java/util/ArrayList:size	()I
    //   247: iconst_1
    //   248: isub
    //   249: istore 8
    //   251: iload 8
    //   253: iflt +125 -> 378
    //   256: aload_0
    //   257: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   260: iload 8
    //   262: invokevirtual 475	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   265: checkcast 643	com/tencent/mobileqq/utils/QQCustomDialog
    //   268: astore 7
    //   270: aload 7
    //   272: ifnull +298 -> 570
    //   275: aload 7
    //   277: invokevirtual 887	com/tencent/mobileqq/utils/QQCustomDialog:getTag	()Ljava/lang/Object;
    //   280: instanceof 183
    //   283: ifeq +287 -> 570
    //   286: aload 7
    //   288: invokevirtual 887	com/tencent/mobileqq/utils/QQCustomDialog:getTag	()Ljava/lang/Object;
    //   291: checkcast 183	com/tencent/util/Pair
    //   294: astore 6
    //   296: aload 5
    //   298: aload 6
    //   300: getfield 347	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   303: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifeq +264 -> 570
    //   309: aload 7
    //   311: invokevirtual 868	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   314: istore 10
    //   316: iload 10
    //   318: ifeq +8 -> 326
    //   321: aload 7
    //   323: invokevirtual 871	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   326: aload_0
    //   327: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   330: iload 8
    //   332: invokevirtual 774	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   335: pop
    //   336: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +231 -> 570
    //   342: ldc -124
    //   344: iconst_2
    //   345: new 134	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 889
    //   355: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 6
    //   360: getfield 347	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   363: checkcast 225	java/lang/String
    //   366: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto +195 -> 570
    //   378: aload_2
    //   379: ldc_w 631
    //   382: invokevirtual 634	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   385: astore 7
    //   387: aload_1
    //   388: aload 5
    //   390: iconst_0
    //   391: invokestatic 289	com/tencent/mobileqq/utils/ContactUtils:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   394: astore 6
    //   396: aload 6
    //   398: ifnull +181 -> 579
    //   401: aload 6
    //   403: astore_1
    //   404: aload 6
    //   406: invokevirtual 264	java/lang/String:length	()I
    //   409: ifne +6 -> 415
    //   412: goto +167 -> 579
    //   415: iload 9
    //   417: ifne +117 -> 534
    //   420: aload_2
    //   421: ldc_w 336
    //   424: iconst_1
    //   425: anewarray 4	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload_1
    //   431: aastore
    //   432: invokevirtual 636	com/tencent/mobileqq/app/BaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   435: astore_1
    //   436: aload_2
    //   437: sipush 230
    //   440: invokestatic 641	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   443: aload 7
    //   445: invokevirtual 647	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   448: aload_1
    //   449: invokevirtual 651	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   452: astore_1
    //   453: aload_1
    //   454: aload_3
    //   455: invokevirtual 892	com/tencent/mobileqq/utils/QQCustomDialog:setTag	(Ljava/lang/Object;)V
    //   458: aload_1
    //   459: aload_2
    //   460: invokevirtual 655	com/tencent/mobileqq/utils/QQCustomDialog:setOwnerActivity	(Landroid/app/Activity;)V
    //   463: aload_1
    //   464: aload_2
    //   465: ldc_w 656
    //   468: invokevirtual 634	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   471: aload 4
    //   473: invokevirtual 664	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   476: pop
    //   477: aload_1
    //   478: new 894	uxj
    //   481: dup
    //   482: aload_0
    //   483: aload 5
    //   485: iload 9
    //   487: invokespecial 897	uxj:<init>	(Lcom/tencent/mobileqq/subaccount/SubAccountControll;Ljava/lang/String;I)V
    //   490: invokevirtual 901	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   493: aload_1
    //   494: invokevirtual 671	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   497: aload_0
    //   498: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   501: ifnonnull +14 -> 515
    //   504: aload_0
    //   505: new 473	java/util/ArrayList
    //   508: dup
    //   509: invokespecial 537	java/util/ArrayList:<init>	()V
    //   512: putfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   515: aload_0
    //   516: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   519: aload_1
    //   520: invokevirtual 540	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   523: pop
    //   524: aload_0
    //   525: getfield 70	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   528: invokeinterface 777 1 0
    //   533: return
    //   534: aload_2
    //   535: ldc_w 902
    //   538: iconst_1
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: aload_1
    //   545: aastore
    //   546: invokevirtual 636	com/tencent/mobileqq/app/BaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   549: astore_1
    //   550: goto -114 -> 436
    //   553: astore_1
    //   554: aload_0
    //   555: getfield 70	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   558: invokeinterface 777 1 0
    //   563: aload_1
    //   564: athrow
    //   565: astore 7
    //   567: goto -241 -> 326
    //   570: iload 8
    //   572: iconst_1
    //   573: isub
    //   574: istore 8
    //   576: goto -325 -> 251
    //   579: aload 5
    //   581: astore_1
    //   582: goto -167 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	SubAccountControll
    //   0	585	1	paramQQAppInterface	QQAppInterface
    //   0	585	2	paramBaseActivity	BaseActivity
    //   0	585	3	paramPair	Pair
    //   0	585	4	paramOnClickListener	android.content.DialogInterface.OnClickListener
    //   28	552	5	str	String
    //   19	386	6	localObject1	Object
    //   268	176	7	localObject2	Object
    //   565	1	7	localException	Exception
    //   249	326	8	n	int
    //   222	264	9	i1	int
    //   314	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   233	251	553	finally
    //   256	270	553	finally
    //   275	316	553	finally
    //   321	326	553	finally
    //   326	375	553	finally
    //   378	396	553	finally
    //   404	412	553	finally
    //   420	436	553	finally
    //   436	515	553	finally
    //   515	524	553	finally
    //   534	550	553	finally
    //   321	326	565	java/lang/Exception
  }
  
  /* Error */
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc -124
    //   8: iconst_2
    //   9: new 134	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 905
    //   19: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 495
    //   29: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_2
    //   33: invokevirtual 333	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: ifnull +11 -> 54
    //   46: aload_1
    //   47: invokevirtual 264	java/lang/String:length	()I
    //   50: iconst_5
    //   51: if_icmpge +4 -> 55
    //   54: return
    //   55: aload_0
    //   56: getfield 70	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   59: invokeinterface 766 1 0
    //   64: aload_0
    //   65: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   68: ifnull +253 -> 321
    //   71: aload_0
    //   72: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   75: invokevirtual 474	java/util/ArrayList:size	()I
    //   78: iconst_1
    //   79: isub
    //   80: istore 7
    //   82: iload 7
    //   84: iflt +237 -> 321
    //   87: aload_0
    //   88: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   91: iload 7
    //   93: invokevirtual 475	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   96: checkcast 643	com/tencent/mobileqq/utils/QQCustomDialog
    //   99: astore 4
    //   101: aload 4
    //   103: ifnull +162 -> 265
    //   106: aload 4
    //   108: invokevirtual 887	com/tencent/mobileqq/utils/QQCustomDialog:getTag	()Ljava/lang/Object;
    //   111: astore 5
    //   113: aload 5
    //   115: ifnull +193 -> 308
    //   118: aload 5
    //   120: instanceof 183
    //   123: ifeq +185 -> 308
    //   126: aload 5
    //   128: checkcast 183	com/tencent/util/Pair
    //   131: astore 5
    //   133: iload_3
    //   134: ifeq +156 -> 290
    //   137: aload_1
    //   138: aload 5
    //   140: getfield 347	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   143: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +190 -> 336
    //   149: iload_2
    //   150: aload 5
    //   152: getfield 355	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   155: checkcast 349	java/lang/Integer
    //   158: invokevirtual 352	java/lang/Integer:intValue	()I
    //   161: if_icmpne +175 -> 336
    //   164: iconst_1
    //   165: istore 6
    //   167: iload 6
    //   169: ifeq +173 -> 342
    //   172: aload 4
    //   174: invokevirtual 868	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   177: istore 8
    //   179: iload 8
    //   181: ifeq +8 -> 189
    //   184: aload 4
    //   186: invokevirtual 871	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   189: aload_0
    //   190: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   193: iload 7
    //   195: invokevirtual 774	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   198: pop
    //   199: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +140 -> 342
    //   205: ldc -124
    //   207: iconst_2
    //   208: new 134	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 907
    //   218: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 5
    //   223: getfield 347	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   226: checkcast 225	java/lang/String
    //   229: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 495
    //   235: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 5
    //   240: getfield 355	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   243: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: ldc_w 909
    //   249: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_3
    //   253: invokevirtual 179	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   256: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto +80 -> 342
    //   265: aload_0
    //   266: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   269: iload 7
    //   271: invokevirtual 774	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   274: pop
    //   275: goto +67 -> 342
    //   278: astore_1
    //   279: aload_0
    //   280: getfield 70	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   283: invokeinterface 777 1 0
    //   288: aload_1
    //   289: athrow
    //   290: aload_1
    //   291: aload 5
    //   293: getfield 347	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   296: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +37 -> 336
    //   302: iconst_1
    //   303: istore 6
    //   305: goto -138 -> 167
    //   308: aload_0
    //   309: getfield 861	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   312: iload 7
    //   314: invokevirtual 774	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   317: pop
    //   318: goto +24 -> 342
    //   321: aload_0
    //   322: getfield 70	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   325: invokeinterface 777 1 0
    //   330: return
    //   331: astore 4
    //   333: goto -144 -> 189
    //   336: iconst_0
    //   337: istore 6
    //   339: goto -172 -> 167
    //   342: iload 7
    //   344: iconst_1
    //   345: isub
    //   346: istore 7
    //   348: goto -266 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	SubAccountControll
    //   0	351	1	paramString	String
    //   0	351	2	paramInt	int
    //   0	351	3	paramBoolean	boolean
    //   99	86	4	localQQCustomDialog	QQCustomDialog
    //   331	1	4	localException	Exception
    //   111	181	5	localObject	Object
    //   165	173	6	n	int
    //   80	267	7	i1	int
    //   177	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   64	82	278	finally
    //   87	101	278	finally
    //   106	113	278	finally
    //   118	133	278	finally
    //   137	164	278	finally
    //   172	179	278	finally
    //   184	189	278	finally
    //   189	262	278	finally
    //   265	275	278	finally
    //   290	302	278	finally
    //   308	318	278	finally
    //   184	189	331	java/lang/Exception
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("launchTimedMsgTask() app.isRunning=");
      if (paramQQAppInterface == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject);
      }
    }
    else
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning())) {
        break label65;
      }
    }
    label65:
    do
    {
      return;
      localObject = Boolean.valueOf(paramQQAppInterface.isRunning());
      break;
      c(paramQQAppInterface);
      ThreadManager.b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_b_of_type_Long * 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "launchTimedMsgTask() schedule msgTimer after " + this.jdField_b_of_type_Long + "*1000 ms.");
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("cancelTimedMsgTask() app.isRunning=");
      if (paramQQAppInterface != null) {
        break label54;
      }
    }
    label54:
    for (Object localObject = "null";; localObject = Boolean.valueOf(paramQQAppInterface.isRunning()))
    {
      QLog.d("SUB_ACCOUNT", 2, localObject);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning())) {
        break;
      }
      return;
    }
    ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          QQCustomDialog localQQCustomDialog = (QQCustomDialog)localIterator.next();
          try
          {
            if (localQQCustomDialog.isShowing()) {
              localQQCustomDialog.dismiss();
            }
          }
          catch (Exception localException) {}
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_JavaUtilArrayList = null;
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_b_of_type_JavaUtilArrayList = null;
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\subaccount\SubAccountControll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */