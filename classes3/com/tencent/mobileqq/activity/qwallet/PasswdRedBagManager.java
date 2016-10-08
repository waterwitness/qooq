package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletHandler;
import com.tencent.mobileqq.app.QWalletObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgPool;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import osy;
import ota;
import otb;
import otc;
import otd;
import ote;
import otf;
import otg;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletAioElem;
import tencent.im.oidb.cmd0x438.oidb_0x438.RedBagInfo;
import tencent.im.oidb.cmd0x438.oidb_0x438.ReqInfo;

public class PasswdRedBagManager
  implements Manager
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  public static final String b = "sp_passwd_configs";
  public static final int c = 2;
  public static final String c = "key_passwd_configs";
  public static final int d = 3;
  public static final String d = "key_db_update";
  public static final int e = 4;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public Context a;
  Handler jdField_a_of_type_AndroidOsHandler = new osy(this, Looper.getMainLooper());
  private PasswdRedBagDBManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QWalletHandler jdField_a_of_type_ComTencentMobileqqAppQWalletHandler;
  private QWalletObserver jdField_a_of_type_ComTencentMobileqqAppQWalletObserver = new QWalletObserver(this.jdField_a_of_type_AndroidOsHandler);
  public HashMap a;
  public List a;
  public boolean a;
  public HashMap b;
  public List b;
  public boolean b;
  public HashMap c;
  private List jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  public HashMap d;
  private boolean d;
  public String e;
  private HashMap jdField_e_of_type_JavaUtilHashMap;
  private boolean jdField_e_of_type_Boolean;
  private HashMap f;
  public int j = 10;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PasswdRedBagManager.class.getSimpleName();
  }
  
  public PasswdRedBagManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager = new PasswdRedBagDBManager(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQWalletObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletHandler = ((QWalletHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(76));
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    c();
  }
  
  private void a(PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    String str1 = paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString;
    String str2 = paramPasswdRedBagInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPasswdRedBagInfo);
    Object localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(str2);
    if (localObject == null)
    {
      localObject = new LinkedList();
      this.jdField_b_of_type_JavaUtilHashMap.put(str2, localObject);
    }
    for (;;)
    {
      int m = ((List)localObject).size();
      int k = 0;
      if (k < m) {
        if (((PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(((List)localObject).get(k))).jdField_a_of_type_Long >= paramPasswdRedBagInfo.jdField_a_of_type_Long) {}
      }
      for (;;)
      {
        ((List)localObject).add(k, str1);
        return;
        k += 1;
        break;
        k = 0;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    boolean bool2 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    int k = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool3 = false;
    boolean bool12 = false;
    boolean bool13 = false;
    boolean bool1 = false;
    boolean bool7 = bool10;
    boolean bool8 = bool12;
    boolean bool9 = bool2;
    int n = k;
    boolean bool5 = bool11;
    boolean bool6 = bool13;
    boolean bool4 = bool2;
    int m = k;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          bool7 = bool10;
          bool8 = bool12;
          bool9 = bool2;
          n = k;
          paramString = paramString.split("\\|");
          bool5 = bool11;
          bool6 = bool13;
          bool4 = bool2;
          m = k;
          if (paramString != null)
          {
            bool7 = bool10;
            bool8 = bool12;
            bool9 = bool2;
            n = k;
            int i2 = paramString.length;
            i1 = 0;
            bool5 = bool3;
            bool6 = bool1;
            bool4 = bool2;
            m = k;
            if (i1 < i2)
            {
              arrayOfString1 = paramString[i1];
              bool7 = bool3;
              bool8 = bool1;
              bool9 = bool2;
              n = k;
              if (!arrayOfString1.contains("msgfold_switch")) {
                break label593;
              }
              bool7 = bool3;
              bool8 = bool1;
              bool9 = bool2;
              n = k;
              String[] arrayOfString2 = arrayOfString1.split("=");
              if (arrayOfString2 == null) {
                break label593;
              }
              bool7 = bool3;
              bool8 = bool1;
              bool9 = bool2;
              n = k;
              if (arrayOfString2.length != 2) {
                break label593;
              }
              bool7 = bool3;
              bool8 = bool1;
              bool9 = bool2;
              n = k;
              m = Integer.valueOf(arrayOfString2[1].trim()).intValue();
              if ((m != 1) && (m != 0)) {
                break label593;
              }
              if (m == 1)
              {
                bool2 = true;
                bool4 = true;
                bool3 = bool2;
                bool2 = bool4;
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        int i1;
        String[] arrayOfString1;
        k = n;
        bool1 = bool8;
        bool5 = bool7;
        bool6 = bool1;
        bool4 = bool9;
        m = k;
        if (QLog.isColorLevel())
        {
          QLog.e("msgFold", 2, "updatePasswdMsgFodConfig error " + paramString.getMessage());
          m = k;
          bool4 = bool9;
          bool6 = bool1;
          bool5 = bool7;
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("received RedBagFoldMsgConfig remote version: %d, msgFoldSwitch: %s, msgFoldNum: %s, isParseSwitchOK: %s, isParseNumOK: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool4), Integer.valueOf(m), Boolean.valueOf(bool5), Boolean.valueOf(bool6) }));
        }
        if ((!bool6) || (!bool5))
        {
          bool4 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
          m = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
        }
        paramString = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
        paramString.jdField_a_of_type_Boolean = true;
        paramString.jdField_b_of_type_Boolean = bool4;
        paramString.j = m;
        SharedPreUtils.a(paramQQAppInterface.a(), paramQQAppInterface.getAccount(), paramInt, bool4, m);
        return;
      }
      try
      {
        if (!arrayOfString1.contains("msgfold_num")) {
          break label590;
        }
        arrayOfString1 = arrayOfString1.split("=");
        if ((arrayOfString1 == null) || (arrayOfString1.length != 2)) {
          break label590;
        }
        m = Integer.valueOf(arrayOfString1[1].trim()).intValue();
        if (m < 0) {
          break label590;
        }
        bool1 = true;
        k = m;
      }
      catch (Exception paramString)
      {
        bool7 = bool2;
        bool9 = bool3;
        continue;
        continue;
      }
      i1 += 1;
      bool4 = bool3;
      bool3 = bool2;
      bool2 = bool4;
      continue;
      bool2 = false;
      continue;
      label590:
      label593:
      bool4 = bool2;
      bool2 = bool3;
      bool3 = bool4;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
    if (!localPasswdRedBagManager.jdField_a_of_type_Boolean)
    {
      String str = paramQQAppInterface.getAccount();
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.a());
      if (paramQQAppInterface.contains(str + "_" + "redbag_fold_msg_config_version"))
      {
        localPasswdRedBagManager.jdField_b_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_msg_switch", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT);
        localPasswdRedBagManager.j = paramQQAppInterface.getInt(str + "_" + "redbag_fold_msg_num", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("getFoldSwitch, first init, switch: %s, num: %d ", new Object[] { Boolean.valueOf(localPasswdRedBagManager.jdField_b_of_type_Boolean), Integer.valueOf(localPasswdRedBagManager.j) }));
      }
    }
    localPasswdRedBagManager.jdField_a_of_type_Boolean = true;
    return localPasswdRedBagManager.jdField_b_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return (paramInt == 1) && (!((HotChatManager)paramQQAppInterface.getManager(59)).b(paramString));
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        if (a()) {
          d();
        }
        boolean bool = this.jdField_c_of_type_Boolean;
        if (!bool) {
          return;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager.a().iterator();
        if (localIterator.hasNext()) {
          a((PasswdRedBagInfo)localIterator.next());
        } else {
          this.jdField_c_of_type_Boolean = false;
        }
      }
      finally {}
    }
  }
  
  private void g()
  {
    for (;;)
    {
      try
      {
        if (a()) {
          d();
        }
        boolean bool = this.jdField_d_of_type_Boolean;
        if (!bool) {
          return;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager.a().entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          this.jdField_c_of_type_JavaUtilHashMap.put(localEntry.getKey(), localEntry.getValue());
        }
        else
        {
          this.jdField_d_of_type_Boolean = false;
        }
      }
      finally {}
    }
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 0: 
    case 1000: 
    case 1001: 
    case 1004: 
      return 3;
    }
    return 2;
  }
  
  public Bitmap a()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (BaseApplicationImpl.a != null) {}
    label134:
    for (Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.a.get("StatusIcon_HongBaoIcon");; localBitmap1 = null) {
      if (localBitmap1 == null) {
        try
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130841791);
          localObject1 = localBitmap2;
          localObject2 = localObject1;
          if (localObject1 != null) {}
          Object localObject3;
          return localBitmap1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F), true);
              if (localObject2 == null) {
                break label134;
              }
              if (BaseApplicationImpl.a != null) {
                BaseApplicationImpl.a.put("StatusIcon_HongBaoIcon", localObject2);
              }
              return (Bitmap)localObject2;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              continue;
            }
            catch (Exception localException2)
            {
              continue;
            }
            localException1 = localException1;
            localException1.printStackTrace();
            localObject3 = localObject1;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            localObject1 = localObject3;
            localObject3 = localOutOfMemoryError2;
            ((OutOfMemoryError)localObject3).printStackTrace();
            localObject3 = localObject1;
          }
        }
      }
    }
  }
  
  public PasswdRedBagInfo a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    f();
    return (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public MessageRecord a(List paramList, MessageForFoldMsg paramMessageForFoldMsg, LinkedHashSet arg3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_d_of_type_JavaUtilHashMap == null) {
      this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    }
    Object localObject = paramMessageForFoldMsg.frienduin + paramMessageForFoldMsg.istroop + paramMessageForFoldMsg.redBagId;
    if ((paramBoolean1) && (this.jdField_d_of_type_JavaUtilHashMap.containsKey(localObject)))
    {
      paramList = (MessageForFoldMsgGrayTips)this.jdField_d_of_type_JavaUtilHashMap.get(localObject);
      paramList.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, ???, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("update foldmsg graytips, uin: %s, type: %d, redBagId: %s num: %d", new Object[] { paramList.frienduin, Integer.valueOf(paramList.istroop), paramMessageForFoldMsg.redBagId, Integer.valueOf(paramList.foldMsgCount) }));
      }
      paramList = null;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BC", "0X80064BC", 0, 0, "", "", "", "");
      return paramList;
    }
    localObject = (MessageForFoldMsgGrayTips)MessageRecordFactory.a(60525);
    MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
    ((MessageForFoldMsgGrayTips)localObject).shmsgseq = paramMessageForFoldMsg.shmsgseq;
    ((MessageForFoldMsgGrayTips)localObject).time = paramMessageForFoldMsg.time;
    ((MessageForFoldMsgGrayTips)localObject).foldMsgCount = paramInt;
    ((MessageForFoldMsgGrayTips)localObject).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.mPasswdRedBagSender, ???, paramMessageForFoldMsg.redBagId);
    if (paramBoolean2) {}
    for (;;)
    {
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop))
      {
        MsgProxyUtils.c(paramList, (MessageRecord)localObject, true);
        a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramMessageForFoldMsg.redBagId, (MessageForFoldMsgGrayTips)localObject);
        paramList = (List)localObject;
      }
      MsgProxyUtils.c(paramList, (MessageRecord)localObject, true);
    }
  }
  
  public Boolean a(String paramString1, int paramInt, String paramString2)
  {
    int k = 0;
    if (this.j == 0) {
      return Boolean.valueOf(true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt);
    if ((localObject == null) || (paramString2 == null)) {
      return Boolean.valueOf(false);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt);
    paramString1 = (String)localObject;
    if (localList != null)
    {
      paramString1 = (String)localObject;
      if (((List)localObject).size() < localList.size()) {
        paramString1 = localList;
      }
    }
    int m = paramString1.size() - 1;
    while (m > 0)
    {
      localObject = (MessageRecord)paramString1.get(m);
      paramInt = k;
      if ((localObject instanceof MessageForFoldMsg))
      {
        localObject = (MessageForFoldMsg)localObject;
        paramInt = k;
        if (paramString2.equals(((MessageForFoldMsg)localObject).redBagId))
        {
          k += 1;
          if (!((MessageForFoldMsg)localObject).foldFlag)
          {
            paramInt = k;
            if (k < this.j) {}
          }
          else
          {
            return Boolean.valueOf(true);
          }
        }
      }
      m -= 1;
      k = paramInt;
    }
    return Boolean.valueOf(false);
  }
  
  public String a()
  {
    e();
    if (this.jdField_c_of_type_JavaUtilList.size() == 0) {
      return null;
    }
    int k = new Random(System.currentTimeMillis()).nextInt(this.jdField_c_of_type_JavaUtilList.size());
    return (String)this.jdField_c_of_type_JavaUtilList.get(k);
  }
  
  public void a()
  {
    if ((this.jdField_e_of_type_JavaUtilHashMap == null) || (this.jdField_e_of_type_JavaUtilHashMap.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      localArrayList = new ArrayList();
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager.a(1);
      Iterator localIterator = this.jdField_e_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        PasswdRedBagUpdateInfo localPasswdRedBagUpdateInfo = new PasswdRedBagUpdateInfo();
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Long = Long.parseLong((String)localObject);
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Int = 1;
        localPasswdRedBagUpdateInfo.b = Long.parseLong((String)this.jdField_e_of_type_JavaUtilHashMap.get(localObject));
        int k = localList.indexOf(localPasswdRedBagUpdateInfo);
        if (k != -1)
        {
          localObject = (PasswdRedBagUpdateInfo)localList.get(k);
          if (localPasswdRedBagUpdateInfo.b <= ((PasswdRedBagUpdateInfo)localObject).b) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localPasswdRedBagUpdateInfo.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localPasswdRedBagUpdateInfo.b);
          localArrayList.add(localObject);
          this.jdField_a_of_type_JavaUtilList.add(localPasswdRedBagUpdateInfo);
        }
      }
      this.jdField_e_of_type_JavaUtilHashMap.clear();
    } while (this.jdField_a_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletHandler.a(0, localArrayList);
  }
  
  public void a(SessionInfo paramSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong)
  {
    if ((paramSessionInfo == null) || (paramPasswdRedBagInfo == null)) {}
    String str;
    do
    {
      return;
      g();
      str = (String)this.jdField_c_of_type_JavaUtilHashMap.get(a(paramSessionInfo.jdField_a_of_type_Int) + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString + "_" + paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty(str));
    int k;
    Object localObject2;
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 2) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1001))
    {
      k = 1;
      localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localObject2 = String.valueOf(paramPasswdRedBagInfo.jdField_b_of_type_JavaLangString);
      if (k != 0) {
        if (!((String)localObject2).equals(this.jdField_e_of_type_JavaLangString)) {
          break label393;
        }
      }
    }
    label393:
    for (Object localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;; localObject1 = this.jdField_e_of_type_JavaLangString)
    {
      localObject2 = QQWalletMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo);
      k = ((Bundle)localObject2).getInt("groupType");
      localObject2 = ((Bundle)localObject2).getString("name");
      paramPasswdRedBagInfo = paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString;
      paramSessionInfo = QQWalletMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, k, (String)localObject2, paramPasswdRedBagInfo, str, (String)localObject1, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", null);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("json", paramSessionInfo.toString());
      ((Bundle)localObject1).putString("callbackSn", "0");
      paramSessionInfo = paramPasswdRedBagInfo;
      if (paramPasswdRedBagInfo != null)
      {
        paramSessionInfo = paramPasswdRedBagInfo;
        if (paramPasswdRedBagInfo.length() > 4) {
          paramSessionInfo = "****" + paramPasswdRedBagInfo.substring(4);
        }
      }
      VACDReportUtil.a(paramLong, null, "open", "groupType=" + k + "&msgType=6&redId=" + paramSessionInfo, 0, null);
      ((Bundle)localObject1).putLong("vacreport_key_seq", paramLong);
      paramSessionInfo = new Intent(this.jdField_a_of_type_AndroidContentContext, PayBridgeActivity.class);
      paramSessionInfo.putExtras((Bundle)localObject1);
      paramSessionInfo.addFlags(268435456);
      paramSessionInfo.putExtra("pay_requestcode", 5);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramSessionInfo);
      return;
      k = 0;
      break;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    PasswdRedBagInfo localPasswdRedBagInfo;
    do
    {
      return;
      f();
      localPasswdRedBagInfo = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localPasswdRedBagInfo == null) || (localPasswdRedBagInfo.jdField_b_of_type_Boolean));
    localPasswdRedBagInfo.jdField_b_of_type_Boolean = true;
    ThreadManager.a().post(new ote(this, paramString));
  }
  
  public void a(String paramString1, int paramInt, String paramString2, MessageForFoldMsgGrayTips paramMessageForFoldMsgGrayTips)
  {
    String str = paramString1 + paramInt + paramString2;
    if (this.jdField_d_of_type_JavaUtilHashMap == null) {
      this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    }
    if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(str))
    {
      this.jdField_d_of_type_JavaUtilHashMap.put(str, paramMessageForFoldMsgGrayTips);
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagId: %s num: %d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(paramMessageForFoldMsgGrayTips.foldMsgCount) }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1) == null)
    {
      paramString2 = new PasswdRedBagInfo(paramString1, paramString3, paramLong, paramString2, paramBoolean1, paramBoolean2, false);
      a(paramString2);
      ThreadManager.a().post(new otc(this, paramString2));
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString4);
    paramString2.append("_");
    paramString2.append(paramString5);
    paramString2.append("_");
    paramString2.append(paramString1);
    if (TextUtils.isEmpty((String)this.jdField_c_of_type_JavaUtilHashMap.get(paramString2.toString())))
    {
      this.jdField_c_of_type_JavaUtilHashMap.put(paramString2.toString(), paramString6);
      ThreadManager.a().post(new otd(this, paramString4, paramString5, paramString1, paramString6));
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006115", "0X8006115", 0, 0, "", str, paramString, "0");
      return;
    }
  }
  
  public void a(HashMap paramHashMap)
  {
    if (this.jdField_e_of_type_JavaUtilHashMap == null) {
      this.jdField_e_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_e_of_type_JavaUtilHashMap.putAll(paramHashMap);
  }
  
  public void a(HashSet paramHashSet)
  {
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.addAll(paramHashSet);
    a(paramHashSet);
  }
  
  public void a(List paramList, MessageForFoldMsg paramMessageForFoldMsg)
  {
    if ((paramMessageForFoldMsg.isSend()) && (!paramMessageForFoldMsg.foldFlag) && (paramMessageForFoldMsg.msgtype == 63530)) {
      return;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.add(paramMessageForFoldMsg.senderuin);
    a(paramList, paramMessageForFoldMsg, localLinkedHashSet, 1, true, false);
  }
  
  public void a(Set paramSet)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_passwd_configs_" + this.jdField_e_of_type_JavaLangString, 0).edit();
      if (Build.VERSION.SDK_INT >= 11) {
        localEditor.putStringSet("key_passwd_configs", paramSet);
      }
      for (;;)
      {
        localEditor.commit();
        return;
        localEditor.putInt("key_passwd_configs_count", paramSet.size());
        paramSet = paramSet.iterator();
        int k = 0;
        while (paramSet.hasNext())
        {
          String str = (String)paramSet.next();
          localEditor.putString("key_passwd_configs_" + k, str);
          k += 1;
        }
      }
      return;
    }
    catch (Throwable paramSet)
    {
      paramSet.printStackTrace();
    }
  }
  
  public void a(im_msg_body.QQWalletAioBody paramQQWalletAioBody, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    a(paramQQWalletAioBody.bytes_billno.get().toStringUtf8(), paramQQWalletAioBody.receiver.bytes_title.get().toStringUtf8(), String.valueOf(paramLong2), 90000L + paramLong3, String.valueOf(paramInt), String.valueOf(paramLong1), paramQQWalletAioBody.bytes_authkey.get().toStringUtf8(), false, false);
  }
  
  public void a(oidb_0x438.RedBagInfo paramRedBagInfo)
  {
    a(paramRedBagInfo.string_redbag_id.get().toStringUtf8(), paramRedBagInfo.string_password.get().toStringUtf8(), String.valueOf(paramRedBagInfo.uint64_creator_uin.get()), paramRedBagInfo.uint64_expire_time.get(), String.valueOf(paramRedBagInfo.uint32_source.get()), String.valueOf(paramRedBagInfo.uint64_code.get()), paramRedBagInfo.string_authkey.get().toStringUtf8(), false, false);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.jdField_e_of_type_JavaLangString);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = paramString1 + paramInt + paramString2;
    return (this.jdField_d_of_type_JavaUtilHashMap != null) && (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString1));
  }
  
  public Object[] a(SessionInfo paramSessionInfo, String paramString)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Long.valueOf(0L);
    arrayOfObject[2] = null;
    if (paramSessionInfo == null) {
      return arrayOfObject;
    }
    if (TextUtils.isEmpty(paramString)) {
      return arrayOfObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.charAt(0));
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString.length());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "openPasswdRedBagByPassword, passwd = " + ((StringBuilder)localObject).toString());
    }
    long l = SystemClock.uptimeMillis();
    f();
    g();
    paramString = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return arrayOfObject;
    }
    Object localObject = a(paramSessionInfo.jdField_a_of_type_Int) + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString + "_";
    Iterator localIterator = paramString.iterator();
    String str2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        str2 = (String)localObject + str1;
        if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(str2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, "get redbagid, no find passwd redbag auth key in cache, key: " + str2);
          }
        }
        else
        {
          paramString = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
          if (paramString != null)
          {
            arrayOfObject[1] = Long.valueOf(paramString.jdField_b_of_type_JavaLangString);
            if ((!paramString.jdField_c_of_type_Boolean) && (paramString.jdField_a_of_type_Long >= NetConnInfoCenter.getServerTimeMillis() / 1000L)) {
              arrayOfObject[2] = str1;
            }
            if (paramString.jdField_a_of_type_Boolean) {
              continue;
            }
            if (paramString.jdField_b_of_type_Boolean)
            {
              arrayOfObject[0] = Integer.valueOf(2);
              continue;
            }
            if ((paramString.jdField_c_of_type_Boolean) || (paramString.jdField_a_of_type_Long < NetConnInfoCenter.getServerTimeMillis() / 1000L))
            {
              if (!paramString.jdField_c_of_type_Boolean) {
                b(str1);
              }
              arrayOfObject[0] = Integer.valueOf(3);
              continue;
            }
            paramString.jdField_a_of_type_Boolean = true;
            arrayOfObject[0] = Integer.valueOf(1);
          }
        }
      }
    }
    for (;;)
    {
      if (paramString == null)
      {
        return arrayOfObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("msgFold", 2, "get redbagid, no find passwd redbag in cache, key: " + str2);
        break;
      }
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByPwd", "msgType=6", 0, null, l);
      c(paramString.jdField_a_of_type_JavaLangString);
      a(paramSessionInfo, paramString, l);
      return arrayOfObject;
      paramString = null;
    }
  }
  
  public void b()
  {
    if ((this.f == null) || (this.f.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_b_of_type_JavaUtilList.clear();
      localArrayList = new ArrayList();
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager.a(2);
      Iterator localIterator = this.f.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        PasswdRedBagUpdateInfo localPasswdRedBagUpdateInfo = new PasswdRedBagUpdateInfo();
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Long = Long.parseLong((String)localObject);
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Int = 2;
        localPasswdRedBagUpdateInfo.b = Long.parseLong((String)this.f.get(localObject));
        int k = localList.indexOf(localPasswdRedBagUpdateInfo);
        if (k != -1)
        {
          localObject = (PasswdRedBagUpdateInfo)localList.get(k);
          if (localPasswdRedBagUpdateInfo.b <= ((PasswdRedBagUpdateInfo)localObject).b) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localPasswdRedBagUpdateInfo.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localPasswdRedBagUpdateInfo.b);
          localArrayList.add(localObject);
          this.jdField_b_of_type_JavaUtilList.add(localPasswdRedBagUpdateInfo);
        }
      }
      this.f.clear();
    } while (this.jdField_b_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletHandler.a(1, localArrayList);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    PasswdRedBagInfo localPasswdRedBagInfo;
    do
    {
      return;
      f();
      localPasswdRedBagInfo = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localPasswdRedBagInfo == null) || (localPasswdRedBagInfo.jdField_c_of_type_Boolean));
    localPasswdRedBagInfo.jdField_c_of_type_Boolean = true;
    ThreadManager.a().post(new otf(this, paramString));
  }
  
  public void b(HashMap paramHashMap)
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    this.f.putAll(paramHashMap);
  }
  
  public Object[] b(SessionInfo paramSessionInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "openPasswdRedBagById, id = " + paramString);
    }
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Long.valueOf(0L);
    arrayOfObject[2] = null;
    if (paramSessionInfo == null) {
      return arrayOfObject;
    }
    if (TextUtils.isEmpty(paramString)) {
      return arrayOfObject;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendById", "msgType=6", 0, null);
    f();
    g();
    PasswdRedBagInfo localPasswdRedBagInfo = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localPasswdRedBagInfo == null)
    {
      VACDReportUtil.a(l, "pwd.end", "", -1, "no redid");
      return arrayOfObject;
    }
    arrayOfObject[1] = Long.valueOf(localPasswdRedBagInfo.jdField_b_of_type_JavaLangString);
    if ((!localPasswdRedBagInfo.jdField_c_of_type_Boolean) && (localPasswdRedBagInfo.jdField_a_of_type_Long >= NetConnInfoCenter.getServerTimeMillis() / 1000L)) {
      arrayOfObject[2] = paramString;
    }
    if (localPasswdRedBagInfo.jdField_a_of_type_Boolean)
    {
      VACDReportUtil.a(l, "pwd.end", "", -1, "opened");
      return arrayOfObject;
    }
    if (localPasswdRedBagInfo.jdField_b_of_type_Boolean)
    {
      arrayOfObject[0] = Integer.valueOf(2);
      VACDReportUtil.a(l, "pwd.end", "", -1, "finish");
      return arrayOfObject;
    }
    if ((localPasswdRedBagInfo.jdField_c_of_type_Boolean) || (localPasswdRedBagInfo.jdField_a_of_type_Long < NetConnInfoCenter.getServerTimeMillis() / 1000L))
    {
      if (!localPasswdRedBagInfo.jdField_c_of_type_Boolean) {
        b(paramString);
      }
      arrayOfObject[0] = Integer.valueOf(3);
      VACDReportUtil.a(l, "pwd.end", "", -1, "overdue");
      return arrayOfObject;
    }
    c(paramString);
    a(paramSessionInfo, localPasswdRedBagInfo, l);
    arrayOfObject[0] = Integer.valueOf(1);
    return arrayOfObject;
  }
  
  public void c()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_passwd_configs_" + this.jdField_e_of_type_JavaLangString, 0);
      if (localSharedPreferences.getBoolean("key_db_update", true))
      {
        ThreadManager.a().post(new ota(this));
        localSharedPreferences.edit().putBoolean("key_db_update", false);
        localSharedPreferences.edit().commit();
      }
      ThreadManager.a().post(new otb(this));
      return;
    }
    finally {}
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    PasswdRedBagInfo localPasswdRedBagInfo;
    do
    {
      return;
      f();
      localPasswdRedBagInfo = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localPasswdRedBagInfo == null) || (localPasswdRedBagInfo.jdField_a_of_type_Boolean));
    localPasswdRedBagInfo.jdField_a_of_type_Boolean = true;
    ThreadManager.a().post(new otg(this, paramString));
  }
  
  public void d()
  {
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager = new PasswdRedBagDBManager(this);
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void d(String paramString)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006116", "0X8006116", 0, 0, "", "0", paramString, "0");
  }
  
  public void e()
  {
    int k = 0;
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_passwd_configs_" + this.jdField_e_of_type_JavaLangString, 0);
        if (Build.VERSION.SDK_INT < 11) {
          continue;
        }
        localObject = ((SharedPreferences)localObject).getStringSet("key_passwd_configs", new HashSet());
        if ((localObject != null) && (((Set)localObject).size() > 0)) {
          this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int m;
        localThrowable.printStackTrace();
        continue;
      }
      this.jdField_e_of_type_Boolean = true;
      return;
      m = ((SharedPreferences)localObject).getInt("key_passwd_configs_count", 0);
      if (m > 0) {
        if (k < m)
        {
          this.jdField_c_of_type_JavaUtilList.add(((SharedPreferences)localObject).getString("key_passwd_configs_" + k, ""));
          k += 1;
        }
      }
    }
  }
  
  public void e(String paramString)
  {
    ((TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80)).a(paramString, "匿名不能抢口令红包哦", NetConnInfoCenter.getServerTime(), 10000L, 0);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletObserver.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQWalletObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\PasswdRedBagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */