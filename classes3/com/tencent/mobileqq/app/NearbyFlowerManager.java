package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.GrayTipsInfo;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController.OnCleanAnimationListener;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout7;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import qbb;
import qbc;
import qbe;
import qbf;
import qbg;
import qbh;
import qbi;
import qbj;

public class NearbyFlowerManager
  implements Handler.Callback, Manager
{
  public static final String a;
  public static int b = 0;
  public static int c = 0;
  public static final int d = 0;
  public static final int e = 2;
  public static final int f = 3;
  public static final String f = "鲜花代表了你什么样的心意？快去告诉Ta吧。";
  public static final int g = 4;
  public static final String g = "Ta送了你XX朵YY，快和Ta说声谢谢吧。";
  public static final int h = 5;
  public static final String h = "鲜花可以兑换多种购物卡。立即兑换";
  public static final int i = 0;
  public static final String i = "立即兑换";
  public static final int j = 1;
  public static final String j = "sp_file_nearby_flower_tip";
  public static final int k = 2;
  public static final String k = "sd_file_nearby_flower_list";
  public int a;
  public Handler a;
  public BaseChatPie a;
  public NearbyFlowerManager.NearbyFlowerListener a;
  public QQAppInterface a;
  public NearbyFlowerAnimationController.OnCleanAnimationListener a;
  public NearbyFlowerAnimationController a;
  FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = new qbi(this);
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new qbc(this);
  public HashMap a;
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  public Handler b;
  public String b;
  public HashMap b;
  Map b;
  public boolean b;
  public String c;
  public HashMap c;
  public String d;
  public HashMap d;
  public String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyFlowerManager.class.getSimpleName();
    jdField_c_of_type_Int = 60;
  }
  
  public NearbyFlowerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController$OnCleanAnimationListener = new qbh(this);
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.a(), this);
    g();
    ThreadManager.a(new qbb(this), null, true);
  }
  
  private SharedPreferences a()
  {
    return BaseApplicationImpl.a.getSharedPreferences("nearby_flower_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
  }
  
  public static final NearbyFlowerManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (NearbyFlowerManager)paramQQAppInterface.getManager(123);
  }
  
  private GrayTipsInfo a(String paramString1, String paramString2, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "shouldShowTip start");
    }
    int n = 0;
    int m = 0;
    Object localObject6 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      long l = MessageCache.a();
      if (!bool) {
        if (((Boolean)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "sp_file_nearby_flower_tip", 0, "nearby_flower_tip_first_flag", Boolean.valueOf(true))).booleanValue())
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "shouldShowTip first rec");
          }
          localObject1 = this.jdField_d_of_type_JavaLangString;
          localObject4 = this.e;
          localObject3 = localObject2;
          if (Friends.isValidUin(paramString1)) {
            localObject3 = String.format("http://imgcache.qq.com/club/client/flower/release/html/gift_mall.html?ADTAG=%s&_bid=2050&sourceType=%d&_handle=1&_wv=2147347&platId=1&qqVersion=%s", new Object[] { "aio.m.xiaohuitiao", Integer.valueOf(1), "6.5.5" });
          }
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "sp_file_nearby_flower_tip", 0, "nearby_flower_tip_first_flag", Boolean.valueOf(false));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B6", "0X80060B6", 0, 0, "", "", "", "");
          localObject2 = localObject4;
          m = 1;
        }
      }
      for (;;)
      {
        localObject4 = null;
        if (m != 0)
        {
          localObject1 = a(bool, (String)localObject1, paramAbsStructMsg);
          paramAbsStructMsg = new GrayTipsInfo();
          paramAbsStructMsg.text = ((String)localObject1);
          localObject4 = paramAbsStructMsg;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject4 = paramAbsStructMsg;
            if (((String)localObject1).contains((CharSequence)localObject2))
            {
              m = ((String)localObject1).indexOf((String)localObject2);
              localObject1 = new GrayTipsSpan(m, ((String)localObject2).length() + m, (String)localObject3);
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).add(localObject1);
              paramAbsStructMsg.spans = ((ArrayList)localObject2);
              localObject4 = paramAbsStructMsg;
            }
          }
        }
        paramAbsStructMsg = this.jdField_a_of_type_JavaUtilHashMap;
        if (bool) {}
        for (;;)
        {
          paramAbsStructMsg.put(paramString2, Long.valueOf(l));
          return (GrayTipsInfo)localObject4;
          localObject2 = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
          if ((localObject2 != null) && (l - ((Long)localObject2).longValue() <= jdField_c_of_type_Int)) {
            break label598;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "shouldShowTip rec >60s");
          }
          localObject1 = a(paramAbsStructMsg);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label592;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B8", "0X80060B8", 0, 0, "", "", "", "");
          localObject2 = null;
          m = 1;
          break;
          Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
          if (localLong != null)
          {
            localObject1 = localObject6;
            m = n;
            localObject3 = localObject5;
            localObject2 = localObject4;
            if (l - localLong.longValue() <= jdField_c_of_type_Int) {
              break;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "shouldShowTip send >60s");
          }
          localObject1 = this.jdField_b_of_type_JavaLangString;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B5", "0X80060B5", 0, 0, "", "", "", "");
          m = 1;
          localObject3 = localObject5;
          localObject2 = localObject4;
          break;
          paramString2 = paramString1;
        }
        label592:
        localObject2 = null;
        continue;
        label598:
        localObject2 = null;
      }
    }
  }
  
  private String a(AbsStructMsg paramAbsStructMsg)
  {
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getFlowerFlorid");
    }
    Object localObject = str;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = (StructMsgForGeneralShare)paramAbsStructMsg;
      localObject = str;
      if (paramAbsStructMsg.getItemCount() > 0)
      {
        paramAbsStructMsg = paramAbsStructMsg.getItemByIndex(0);
        if (!(paramAbsStructMsg instanceof StructMsgItemLayout12)) {
          break label149;
        }
        paramAbsStructMsg = ((StructMsgItemLayout12)paramAbsStructMsg).a.getString("cMean");
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramAbsStructMsg)) && (this.jdField_c_of_type_JavaLangString.contains("XX朵YY")))
      {
        str = this.jdField_c_of_type_JavaLangString.replace("XX朵YY", paramAbsStructMsg);
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "getFlowerFlorid,cMean:" + paramAbsStructMsg + " wording:" + str);
          localObject = str;
        }
      }
      label149:
      do
      {
        return (String)localObject;
        if (!(paramAbsStructMsg instanceof StructMsgItemLayout7)) {
          break label251;
        }
        paramAbsStructMsg = ((StructMsgItemLayout7)paramAbsStructMsg).a.iterator();
        do
        {
          if (!paramAbsStructMsg.hasNext()) {
            break;
          }
          localObject = (AbsStructMsgElement)paramAbsStructMsg.next();
        } while (!(localObject instanceof StructMsgItemTitle));
        paramAbsStructMsg = ((StructMsgItemTitle)localObject).b();
        break;
        localObject = str;
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getFlowerFlorid,cMean:" + paramAbsStructMsg + " wording:" + null);
      return null;
      label251:
      paramAbsStructMsg = null;
    }
  }
  
  private String a(boolean paramBoolean, String paramString, AbsStructMsg paramAbsStructMsg)
  {
    String str = paramString;
    if (paramString.contains("Ta"))
    {
      str = paramString;
      if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
      {
        paramAbsStructMsg = (StructMsgForGeneralShare)paramAbsStructMsg;
        str = paramString;
        if (paramAbsStructMsg.getItemCount() > 0)
        {
          AbsStructMsgElement localAbsStructMsgElement = paramAbsStructMsg.getItemByIndex(0);
          str = paramString;
          if ((localAbsStructMsgElement instanceof StructMsgItemLayout12))
          {
            if (!paramBoolean) {
              break label115;
            }
            paramAbsStructMsg = "rSex";
            paramAbsStructMsg = ((StructMsgItemLayout12)localAbsStructMsgElement).a.getString(paramAbsStructMsg);
            str = paramString;
            if (!TextUtils.isEmpty(paramAbsStructMsg)) {
              if (Integer.valueOf(paramAbsStructMsg).intValue() != 2) {
                break label122;
              }
            }
          }
        }
      }
    }
    label115:
    label122:
    for (paramAbsStructMsg = "她";; paramAbsStructMsg = "他")
    {
      str = paramString.replace("Ta", paramAbsStructMsg);
      return str;
      paramAbsStructMsg = "sSex";
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.a(new qbj(paramQQAppInterface, paramString), null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, Context paramContext, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    String str1 = null;
    String str2;
    switch (paramInt)
    {
    default: 
      str1 = "0X8006392";
      str2 = "aio.hotchat.plus.s";
    }
    for (;;)
    {
      if (str1 != null) {
        a(paramQQAppInterface, str1);
      }
      paramQQAppInterface = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { NearbyURLSafeUtil.a(paramString1), "", Integer.valueOf(3), str2, paramString2 });
      paramString1 = new Intent(paramContext, QQBrowserActivity.class);
      paramString1.putExtra("url", paramQQAppInterface);
      paramContext.startActivity(paramString1);
      return;
      str2 = "aio.hotchat.name.s";
      continue;
      str2 = "aio.hotchat.m_other.s";
      str1 = "0X8006393";
    }
  }
  
  private void a(String paramString, NearbyFlowerMessage paramNearbyFlowerMessage)
  {
    if ((!this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(paramString)).intValue() == 4))
    {
      Object localObject = new File(NearbyFlowerUtil.b(paramString));
      Bundle localBundle = new Bundle();
      localBundle.putString("nearby_flower_task_id", paramString);
      localObject = new DownloadTask(NearbyFlowerUtil.a(paramNearbyFlowerMessage), (File)localObject);
      ((DownloadTask)localObject).A = 2;
      NearbyFlowerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "start Download PackageId:" + paramNearbyFlowerMessage.pID);
      }
      this.jdField_c_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(2));
    }
  }
  
  private boolean a(NearbyFlowerMessage paramNearbyFlowerMessage)
  {
    return true;
  }
  
  private boolean a(NearbyFlowerMessage paramNearbyFlowerMessage, boolean paramBoolean)
  {
    if (paramNearbyFlowerMessage == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "addFlowerMessage ruin: " + paramNearbyFlowerMessage.rUin + ", suin: " + paramNearbyFlowerMessage.sUin + ", addOrReplace: " + paramBoolean);
    }
    Object localObject1;
    Object localObject2;
    if ("4".equals(paramNearbyFlowerMessage.version))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
      localObject2 = (List)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1);
      if (localObject2 != null) {
        break label351;
      }
      localObject2 = new ArrayList();
    }
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaUtilHashMap)
      {
        this.jdField_d_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        localObject1 = localObject2;
        if (paramBoolean)
        {
          try
          {
            ((List)localObject1).add(paramNearbyFlowerMessage);
            return true;
          }
          finally {}
          localObject1 = paramNearbyFlowerMessage.frienduin;
        }
      }
      if (((List)localObject1).size() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((Collection)localObject1);
        int m = 0;
        for (localObject2 = paramNearbyFlowerMessage; m < localArrayList.size(); localObject2 = ???)
        {
          NearbyFlowerMessage localNearbyFlowerMessage = (NearbyFlowerMessage)localArrayList.get(m);
          if (((NearbyFlowerMessage)localObject2).score >= localNearbyFlowerMessage.score)
          {
            ??? = localObject2;
            if (((NearbyFlowerMessage)localObject2).score == localNearbyFlowerMessage.score)
            {
              ??? = localObject2;
              if (((NearbyFlowerMessage)localObject2).time >= localNearbyFlowerMessage.time) {}
            }
          }
          else
          {
            ??? = localNearbyFlowerMessage;
          }
          m += 1;
        }
        try
        {
          ((List)localObject1).clear();
          ((List)localObject1).add(localObject2);
          if (localObject2 != paramNearbyFlowerMessage) {
            break;
          }
          return true;
        }
        finally {}
      }
      try
      {
        ((List)localObject1).add(paramNearbyFlowerMessage);
        return true;
      }
      finally {}
      label351:
      localObject1 = localObject2;
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = (List)this.jdField_d_of_type_JavaUtilHashMap.get(paramString1);
    if ((paramString2 == null) || (paramString1 == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramString1.size());
    localArrayList.addAll(paramString1);
    int m = localArrayList.size() - 1;
    while (m >= 0)
    {
      if (paramString2.equals(String.valueOf(((NearbyFlowerMessage)localArrayList.get(m)).pID))) {
        localArrayList.remove(m);
      }
      m -= 1;
    }
    try
    {
      paramString1.clear();
      paramString1.addAll(localArrayList);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 500L);
      return;
    }
    finally {}
  }
  
  private boolean b(NearbyFlowerMessage paramNearbyFlowerMessage, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramNearbyFlowerMessage == null) || (TextUtils.isEmpty(paramNearbyFlowerMessage.pID)) || ("0".equals(paramNearbyFlowerMessage.pID)) || (TextUtils.isEmpty(paramNearbyFlowerMessage.pURL)) || (TextUtils.isEmpty(paramNearbyFlowerMessage.fCount)) || (TextUtils.isEmpty(paramNearbyFlowerMessage.sUin)) || (TextUtils.isEmpty(paramNearbyFlowerMessage.rUin))) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (paramNearbyFlowerMessage.serviceID == 52) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMessage false. serviceId:" + paramNearbyFlowerMessage.serviceID);
        return false;
        if ((paramBoolean) || (!paramNearbyFlowerMessage.isRead)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMessage false. msgIsReaded");
      return false;
      if (paramBoolean) {
        return true;
      }
      if (paramNearbyFlowerMessage.score >= this.jdField_a_of_type_Int) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMessage false. score:" + paramNearbyFlowerMessage.score + " threashold:" + this.jdField_a_of_type_Int);
    return false;
    long l = a(paramNearbyFlowerMessage.frienduin);
    int m;
    if (l > 0L)
    {
      m = 1;
      if (m == 0) {
        break label324;
      }
      if (paramNearbyFlowerMessage.msgTime < l) {
        break label319;
      }
    }
    label319:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMessage inAio. flowerMessage.msgTime:" + paramNearbyFlowerMessage.msgTime + " enterAioTime:" + l + " check:" + paramBoolean);
      }
      return paramBoolean;
      m = 0;
      break;
    }
    label324:
    l = b(paramNearbyFlowerMessage.frienduin);
    if (paramNearbyFlowerMessage.msgTime >= l) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMessage not inAio. flowerMessage.msgTime:" + paramNearbyFlowerMessage.msgTime + " joinAioTime:" + l + " check:" + paramBoolean);
      }
      return paramBoolean;
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "saveAnimListToPlay");
    }
    FileUtils.a("sd_file_nearby_flower_list", this.jdField_d_of_type_JavaUtilHashMap);
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "senderGrayTip", "鲜花代表了你什么样的心意？快去告诉Ta吧。"));
    this.jdField_c_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "receiverGrayTip", "Ta送了你XX朵YY，快和Ta说声谢谢吧。"));
    this.jdField_d_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeGrayTip", "鲜花可以兑换多种购物卡。立即兑换"));
    this.e = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeHighLight", "立即兑换"));
    jdField_b_of_type_Int = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "openFlag", Integer.valueOf(jdField_b_of_type_Int))).intValue();
    this.jdField_a_of_type_Int = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "scoreThreshold", Integer.valueOf(0))).intValue();
  }
  
  public long a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return 0L;
    }
    return ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
  }
  
  public MessageRecord a(String paramString1, String paramString2, int paramInt, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "insertFlowerTipMsg start");
    }
    paramString2 = a(paramString1, paramString2, paramAbsStructMsg);
    if (paramString2 != null)
    {
      paramAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      long l = MessageCache.a();
      MessageForNewGrayTips localMessageForNewGrayTips = (MessageForNewGrayTips)MessageRecordFactory.a(63499);
      localMessageForNewGrayTips.init(paramAbsStructMsg, paramString1, paramAbsStructMsg, paramString2.text, l, 63499, paramInt, l);
      localMessageForNewGrayTips.isread = true;
      localMessageForNewGrayTips.spans = paramString2.spans;
      localMessageForNewGrayTips.updateMsgData();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "insertFlowerTipMsg has grayTip");
      }
      return localMessageForNewGrayTips;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return paramString + "_key_time_joinhotchat";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager$NearbyFlowerListener = null;
  }
  
  public void a(BaseChatPie paramBaseChatPie, NearbyFlowerAnimationController paramNearbyFlowerAnimationController)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setChatPieAndController");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController = paramNearbyFlowerAnimationController;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(NearbyFlowerManager.NearbyFlowerListener paramNearbyFlowerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager$NearbyFlowerListener = paramNearbyFlowerListener;
  }
  
  public void a(NearbyFlowerMessage paramNearbyFlowerMessage, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onNewMessage isUser: " + paramBoolean);
    }
    if (!b(paramNearbyFlowerMessage, paramBoolean)) {}
    Object localObject;
    do
    {
      return;
      if ((paramNearbyFlowerMessage == null) || (TextUtils.isEmpty(paramNearbyFlowerMessage.sID)) || (!"4".equals(paramNearbyFlowerMessage.version))) {
        break label177;
      }
      if (this.jdField_b_of_type_JavaUtilHashMap == null) {
        this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
      }
      localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramNearbyFlowerMessage.sID);
      str = paramNearbyFlowerMessage.sUin + "_" + paramNearbyFlowerMessage.rUin;
      if (localObject == null) {
        break label246;
      }
      if (!((List)localObject).contains(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onNewMessage received the same flower message!");
    return;
    ((List)localObject).add(str);
    label177:
    if (paramNearbyFlowerMessage != null) {
      ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105)).a(paramNearbyFlowerMessage.rUin);
    }
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager$NearbyFlowerListener != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (a(paramNearbyFlowerMessage, paramBoolean)) {
        break label286;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onNewMessage:addFlowerMessage false");
      return;
      label246:
      localObject = new ArrayList();
      ((List)localObject).add(str);
      this.jdField_b_of_type_JavaUtilHashMap.put(paramNearbyFlowerMessage.sID, localObject);
      break label177;
    }
    label286:
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 500L);
    String str = paramNearbyFlowerMessage.pID;
    int m;
    if ((this.jdField_c_of_type_JavaUtilHashMap.containsKey(str)) && (((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(str)).intValue() == 3)) {
      if (!NearbyFlowerUtil.a(str))
      {
        m = 5;
        this.jdField_c_of_type_JavaUtilHashMap.remove(str);
        a(str, paramNearbyFlowerMessage);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNewMessage: id:" + str + ", state:" + m);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager$NearbyFlowerListener == null) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new qbe(this, paramNearbyFlowerMessage));
      return;
      m = 3;
      continue;
      a(str, paramNearbyFlowerMessage);
      m = 4;
    }
  }
  
  public void a(String paramString)
  {
    long l = MessageCache.a();
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetNewConfig:" + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        if (!localJSONObject.has("senderGrayTip")) {
          break label450;
        }
        paramString2 = localJSONObject.getString("senderGrayTip");
        if (!localJSONObject.has("receiverGrayTip")) {
          break label473;
        }
        str1 = localJSONObject.getString("receiverGrayTip");
        if (!localJSONObject.has("exchangeGrayTip")) {
          break label479;
        }
        str2 = localJSONObject.getString("exchangeGrayTip");
        if (!localJSONObject.has("exchangeHighLight")) {
          break label486;
        }
        str3 = localJSONObject.getString("exchangeHighLight");
        if (!localJSONObject.has("openFlag")) {
          break label456;
        }
        m = localJSONObject.getInt("openFlag");
        if (!localJSONObject.has("groupAnimationScore")) {
          break label464;
        }
        n = localJSONObject.getInt("groupAnimationScore");
        if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(this.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_JavaLangString = paramString2;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "senderGrayTip", this.jdField_b_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(str1)) && (!paramString2.equals(this.jdField_c_of_type_JavaLangString)))
        {
          this.jdField_c_of_type_JavaLangString = str1;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "receiverGrayTip", this.jdField_c_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(str2)) && (!paramString2.equals(this.jdField_d_of_type_JavaLangString)))
        {
          this.jdField_d_of_type_JavaLangString = str2;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "exchangeGrayTip", this.jdField_d_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(str3)) && (!paramString2.equals(this.e)))
        {
          this.e = str3;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "exchangeHighLight", this.e);
        }
        if (m != jdField_b_of_type_Int)
        {
          jdField_b_of_type_Int = m;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "openFlag", Integer.valueOf(jdField_b_of_type_Int));
        }
        if (n != this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_Int = n;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "scoreThreshold", Integer.valueOf(this.jdField_a_of_type_Int));
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetNewConfig parse success");
        return;
      }
      catch (JSONException paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetNewConfig parse exception:" + paramString1);
      paramString1.printStackTrace();
      return;
      label450:
      paramString2 = "";
      continue;
      label456:
      int m = jdField_b_of_type_Int;
      continue;
      label464:
      int n = this.jdField_a_of_type_Int;
      continue;
      label473:
      String str1 = "";
      continue;
      label479:
      String str2 = "";
      continue;
      label486:
      String str3 = "";
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGetJoinedHotchats:" + paramList.size());
    }
    Object localObject1 = a();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    try
    {
      localObject1 = ((SharedPreferences)localObject1).getAll();
      if (localObject1 == null) {
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    catch (Exception localException)
    {
      String str;
      for (;;)
      {
        str = null;
      }
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localHashSet.add(((HotChatInfo)paramList.next()).troopUin);
      }
      paramList = str.entrySet().iterator();
      while (paramList.hasNext())
      {
        str = (String)((Map.Entry)paramList.next()).getKey();
        if (!localHashSet.contains(str))
        {
          localEditor.remove(str);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "onGetJoinedHotchats.remove:" + str);
          }
        }
      }
      localEditor.commit();
    }
  }
  
  public long b(String paramString)
  {
    if (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramString))
    {
      Long localLong = Long.valueOf(a().getLong(a(paramString), 0L));
      this.jdField_b_of_type_JavaUtilMap.put(paramString, localLong);
      return localLong.longValue();
    }
    return ((Long)this.jdField_b_of_type_JavaUtilMap.get(paramString)).longValue();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "initAnim");
    }
    Object localObject = (HashMap)FileUtils.a("sd_file_nearby_flower_list");
    if (localObject != null)
    {
      ((HashMap)localObject).remove(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
      this.jdField_d_of_type_JavaUtilHashMap.putAll((Map)localObject);
      localObject = this.jdField_d_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        List localList = (List)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localList.size() > 1) {
          a((NearbyFlowerMessage)localList.get(0), false);
        }
      }
    }
    NearbyFlowerUtil.a(this.jdField_c_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "release releaseChatPieAndController, friend uin:" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaUtilHashMap)
      {
        this.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 500L);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController = null;
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "release releaseChatPieAndController, friend uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.a();
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController = null;
      }
    }
  }
  
  public void c(String paramString)
  {
    long l = MessageCache.a();
    a().edit().putLong(a(paramString), l);
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "removeCurrentSessionAnimation");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaUtilHashMap)
      {
        this.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.a();
          this.jdField_b_of_type_Boolean = false;
        }
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 500L);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController == null) {}
    }
  }
  
  public void d(String paramString)
  {
    a().edit().remove(a(paramString));
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Long.valueOf(0L));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "playFlowerAnimation");
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController == null)) || (this.jdField_b_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "playFlowerAnimation isPlaying: " + this.jdField_b_of_type_Boolean);
      }
    }
    Object localObject;
    label278:
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_Boolean) {
          b();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
        NearbyFlowerMessage localNearbyFlowerMessage;
        for (String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString;; str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f())
        {
          localObject = (List)this.jdField_d_of_type_JavaUtilHashMap.get(str1);
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController == null) || (localObject == null) || (((List)localObject).isEmpty())) {
            break;
          }
          this.jdField_b_of_type_Boolean = true;
          localNearbyFlowerMessage = (NearbyFlowerMessage)((List)localObject).get(0);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "playFlowerAnimation message = " + localNearbyFlowerMessage.toString());
          }
          if ((!"4".equals(localNearbyFlowerMessage.version)) || (System.currentTimeMillis() - localNearbyFlowerMessage.time <= 8000L)) {
            break label278;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "playFlowerAnimation random flower message time > 8s, skip");
          }
          try
          {
            ((List)localObject).remove(localNearbyFlowerMessage);
            this.jdField_b_of_type_Boolean = false;
            if (((List)localObject).size() == 0) {
              break;
            }
            e();
            return;
          }
          finally {}
        }
        localObject = localNearbyFlowerMessage.pID;
        if ((this.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject)) && (((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(localObject)).intValue() == 3))
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "playFlowerAnimation Playing! packageId=" + (String)localObject);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a.a()))
          {
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new qbf(this), 500L);
            return;
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new qbg(this, localNearbyFlowerMessage));
          return;
        }
        if ((!this.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject)) || (((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(localObject)).intValue() != 4)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "playFlowerAnimation download failed id:" + (String)localObject);
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController == null));
      b(str2, (String)localObject);
      this.jdField_b_of_type_Boolean = false;
      e();
      return;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "playFlowerAnimation downloading, id:" + (String)localObject);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      f();
    }
  }
  
  public void onDestroy()
  {
    f();
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearbyFlowerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */