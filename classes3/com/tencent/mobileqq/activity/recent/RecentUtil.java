package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.webviewbase.WebViewJumpAction;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.qqhotspot.WifiConversationManager;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.secmsg.SecMsgHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import org.json.JSONException;
import org.json.JSONObject;
import oyd;
import oye;
import oyf;
import oyg;
import oyh;

public final class RecentUtil
{
  public static final int a = 0;
  public static long a = 0L;
  public static MessageRecord a;
  public static boolean a = false;
  public static final int b = 1;
  public static boolean b = false;
  public static final int c = 2;
  public static final int d = 4;
  public static final int e = 0;
  public static final int f = 1;
  
  public RecentUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean, int paramInt, RecentBaseData paramRecentBaseData)
  {
    int m = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    if ((paramRecentUser == null) || (paramActivity == null) || (paramQQAppInterface == null))
    {
      i = k;
      if (QLog.isDevelopLevel())
      {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser + "," + paramActivity + "," + paramQQAppInterface + "]");
        i = k;
      }
    }
    boolean bool1;
    for (;;)
    {
      return i;
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser.uin + "," + paramRecentUser.type + "]");
      }
      boolean bool3 = false;
      boolean bool2;
      if (paramInt == 0)
      {
        bool1 = true;
        if (((paramRecentUser.uin == null) || (paramRecentUser.uin.length() != 4)) && (!AppConstants.as.equals(paramRecentUser.uin)))
        {
          bool2 = bool3;
          if (!TextUtils.equals(paramRecentUser.uin, AppConstants.aZ)) {
            break label211;
          }
        }
      }
      try
      {
        bool2 = a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
        label211:
        paramInt = m;
        if (!bool2)
        {
          if (paramRecentUser.type == 8999) {
            paramInt = m;
          }
        }
        else
        {
          if (paramRecentUser.msgType != 9) {
            break label1106;
          }
          paramActivity = (TroopInfoManager)paramQQAppInterface.getManager(36);
          long l = 0L;
          if (paramRecentUser.uin != null) {
            l = paramActivity.b(paramRecentUser.uin);
          }
          paramActivity = null;
          if (l != 0L) {
            paramActivity = paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.type, l);
          }
          if (!MessageForQQWalletMsg.isRedPacketMsg(paramActivity)) {
            break label1077;
          }
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_hongbaoSign", 0, 0, paramRecentUser.uin, "", "", "");
          label333:
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
          paramActivity = ".troop.special_msg.special_attention";
          label362:
          i = paramInt;
          if (TextUtils.isEmpty(paramActivity)) {
            continue;
          }
          i = paramInt;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(RecentUtil.class.getSimpleName() + paramActivity, 2, "onRecentUserClick, r.uin:" + paramRecentUser.uin);
          return paramInt;
          bool1 = false;
        }
      }
      catch (JSONException paramRecentBaseData)
      {
        for (;;)
        {
          paramRecentBaseData.printStackTrace();
          bool2 = bool3;
        }
        if (paramRecentUser.type == 7000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "RecentUtil.onRecentUserClick. r.uin=" + paramRecentUser.uin + " r.type=" + paramRecentUser.type);
          }
          SubAccountAssistantForward.a(paramQQAppInterface, paramActivity, paramRecentUser.uin);
          paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.type);
          if (AppConstants.ah.equals(paramRecentUser.uin)) {}
          for (paramActivity = null;; paramActivity = paramRecentUser.uin)
          {
            ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity, "Bind_account", "Clk_bind_account", 0, 0, "", "", "", "");
            paramInt = m;
            break;
          }
        }
        if (paramRecentUser.type == 1000) {
          break label617;
        }
      }
    }
    if ((paramRecentUser.type == 1020) || (paramRecentUser.type == 1004)) {
      label617:
      if (a(paramQQAppInterface, paramRecentUser.uin))
      {
        paramRecentUser.type = 0;
        if (!paramBoolean) {
          break label1219;
        }
      }
    }
    label1077:
    label1106:
    label1219:
    for (paramInt = 2;; paramInt = 0)
    {
      i = paramInt | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString, bool1);
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, "from_enterchat");
      paramInt = i;
      break;
      if ((paramRecentUser.troopUin == null) || (paramRecentUser.troopUin.trim().length() == 0))
      {
        paramRecentBaseData = paramQQAppInterface.a().a().b(paramRecentUser.uin, 1);
        if (paramRecentBaseData != null) {
          paramRecentUser.troopUin = paramRecentBaseData.troopUin;
        }
      }
      a(paramActivity, paramRecentUser.uin, paramRecentUser.troopUin, paramRecentUser.type, paramString, bool1);
      paramInt = m;
      break;
      if ((paramRecentUser.type == 1005) || (paramRecentUser.type == 1023))
      {
        paramInt = i;
        if (a(paramQQAppInterface, paramRecentUser.uin))
        {
          paramRecentUser.type = 0;
          paramInt = i;
          if (paramBoolean) {
            paramInt = 2;
          }
        }
        paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, bool1);
        break;
      }
      if (paramRecentUser.type == 1024)
      {
        paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, bool1);
        break;
      }
      if (paramRecentUser.type == 6002)
      {
        paramString = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
        paramString.a(paramActivity, paramString.a(Long.parseLong(paramRecentUser.uin)), false);
        paramInt = m;
        break;
      }
      if ((paramRecentUser.type == 1) && ((paramRecentUser.lFlag & 1L) != 0L))
      {
        paramRecentBaseData = paramQQAppInterface.a(true);
        if ((paramRecentBaseData != null) && (!paramRecentBaseData.b(paramRecentUser.uin))) {
          return 4;
        }
      }
      if (a(paramQQAppInterface, paramRecentUser.uin))
      {
        paramInt = j;
        if (1 != paramRecentUser.type)
        {
          paramInt = j;
          if (3000 != paramRecentUser.type)
          {
            paramInt = j;
            if (paramRecentUser.type != 0)
            {
              paramRecentUser.type = 0;
              paramInt = j;
              if (paramBoolean) {
                paramInt = 2;
              }
            }
          }
        }
        paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, bool1);
        break;
      }
      paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, bool1);
      break;
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
      break label333;
      if (paramRecentUser.msgType == 14)
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, paramRecentUser.uin, "", "", "");
        paramActivity = ".troop.special_msg.at_msg";
        break label362;
      }
      if (paramRecentUser.msgType == 13)
      {
        i = paramQQAppInterface.b(paramRecentUser.uin);
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_replyMsg", "", "Msglist", "Clk_replySign", 0, 0, paramRecentUser.uin, "" + i, "", "");
      }
      paramActivity = "";
      break label362;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    StartupTracker.a(null, "Recent_clk_enterchat");
    Intent localIntent;
    long l1;
    if (jdField_a_of_type_Boolean)
    {
      localIntent = new Intent(paramContext, ChatActivity.class);
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        if ((jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 1) || (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 3000))
        {
          l1 = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
          localIntent.putExtra("searched_timeorseq", l1);
        }
      }
    }
    label73:
    label147:
    label558:
    label687:
    label796:
    label802:
    label938:
    label958:
    label980:
    for (;;)
    {
      int i;
      if (paramInt == 3000) {
        i = 0;
      }
      boolean bool;
      for (;;)
      {
        localIntent.putExtra("uin", paramString1);
        localIntent.putExtra("uintype", paramInt);
        localIntent.putExtra("uinname", paramString2);
        localIntent.putExtra("entrance", 1);
        a(localIntent);
        if (!paramBoolean) {
          break label958;
        }
        if ((paramContext instanceof SplashActivity)) {
          a(paramContext, localIntent);
        }
        StartupTracker.a("Recent_clk_enterchat", null);
        return i;
        l1 = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        break;
        if (jdField_a_of_type_Long == 0L) {
          break label980;
        }
        localIntent.putExtra("searched_timeorseq", jdField_a_of_type_Long);
        break label73;
        localIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 1 });
        break label73;
        if ((paramInt == 0) || (paramInt == 1024))
        {
          if (paramInt != 1024)
          {
            bool = paramBoolean;
            if (!CrmUtils.c(paramQQAppInterface, paramString1)) {
              break label938;
            }
          }
          StartupTracker.a(null, "Recent_clk_enterchat_cmr");
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
          StartupTracker.a("Recent_clk_enterchat_cmr", null);
          i = 0;
        }
        else
        {
          if (paramInt == 1)
          {
            StartupTracker.a(null, "Recent_clk_enterchat_troop");
            localObject1 = ((HotChatManager)paramQQAppInterface.getManager(59)).a(paramString1);
            if (localObject1 != null) {
              localIntent.putExtra("troop_uin", ((HotChatInfo)localObject1).troopCode);
            }
            for (;;)
            {
              i = 1;
              StartupTracker.a("Recent_clk_enterchat_troop", null);
              break;
              localObject1 = (TroopManager)paramQQAppInterface.getManager(51);
              if (localObject1 != null)
              {
                localObject1 = ((TroopManager)localObject1).a(paramString1 + "");
                if ((localObject1 != null) && (((TroopInfo)localObject1).troopcode != null)) {
                  localIntent.putExtra("troop_uin", ((TroopInfo)localObject1).troopcode);
                }
              }
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
            }
          }
          if (paramInt != 1008) {
            break label802;
          }
          StartupTracker.a(null, "Recent_clk_enterchat_cmr");
          localObject1 = ((PublicAccountDataManager)paramQQAppInterface.getManager(55)).c(String.valueOf(paramString1));
          if ((localObject1 == null) || (((PublicAccountInfo)localObject1).extendType != 2)) {
            break label558;
          }
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
          localIntent.putExtra("chat_subType", 1);
          localIntent.setClass(paramContext, ChatActivity.class);
          paramBoolean = false;
          StartupTracker.a("Recent_clk_enterchat_pub", null);
          i = 0;
        }
      }
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(paramString1, 1008);
      Object localObject1 = "";
      Object localObject3 = localObject1;
      if (localMessage != null)
      {
        localObject3 = XMLMessageUtils.a(localMessage);
        if (localObject3 != null) {
          localObject1 = Long.toString(((PAMessage)localObject3).mMsgId);
        }
        localObject3 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      Object localObject2;
      for (localObject1 = localMessage.getExtInfoFromExtStr("pa_msgId");; localObject2 = localObject3)
      {
        if (localMessage != null) {}
        for (i = paramQQAppInterface.a().a(paramString1, localMessage.istroop);; i = 0)
        {
          PublicAccountHandler.a(paramQQAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_3", "msg_aio", (String)localObject1, String.valueOf(i));
          int j;
          if ("2909288299".equals(paramString1))
          {
            if (i > 0)
            {
              j = 2;
              ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8007055", "0X8007055", 0, 0, "", "", "", ServiceAccountFolderManager.a(j));
            }
          }
          else
          {
            localIntent.putExtra("shouldreport", true);
            if ((paramContext instanceof SplashActivity))
            {
              localIntent.putExtra("start_time", System.currentTimeMillis());
              localIntent.putExtra("red_hot_count", i);
            }
            if (i <= 0) {
              break label796;
            }
          }
          for (paramBoolean = true;; paramBoolean = false)
          {
            localIntent.putExtra("has_unread_msg", paramBoolean);
            localIntent.putExtra("jump_from", 1);
            break;
            j = 1;
            break label687;
          }
          bool = paramBoolean;
          if (paramInt == 9501)
          {
            SmartDeviceReport.a(paramQQAppInterface, "Usr_AIO_Open", 2, 0, 0);
            paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
            l1 = 0L;
          }
          try
          {
            long l2 = Long.parseLong(paramString1);
            l1 = l2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          localIntent.setClass(paramContext, ChatActivity.class);
          paramBoolean = false;
          bool = paramBoolean;
          if (paramQQAppInterface != null)
          {
            bool = paramBoolean;
            if (paramQQAppInterface.a(l1, 9))
            {
              paramQQAppInterface = new Bundle();
              paramQQAppInterface.putString("din", String.valueOf(l1));
              paramQQAppInterface.putString("devName", paramString2);
              paramQQAppInterface.putBoolean("bFromLightApp", false);
              paramQQAppInterface.putInt("operType", 5);
              localIntent.putExtras(paramQQAppInterface);
              bool = paramBoolean;
            }
          }
          i = 0;
          paramBoolean = bool;
          break;
          paramContext.startActivity(localIntent);
          break label147;
        }
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext instanceof SplashActivity))
    {
      paramContext = (SplashActivity)paramContext;
      paramIntent.putExtra("isFromMainTab", true);
      paramIntent.putExtra("isBack2Root", true);
      paramContext.setIntent(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.SpalshActivity", 2, "mainTabToAio-->openAioFragment");
      }
      paramContext.a(false, 1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.SpalshActivity", 2, "start->SpalshActivity-->AIO");
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Intent localIntent;
    long l;
    if (paramContext != null)
    {
      if (!jdField_a_of_type_Boolean) {
        break label146;
      }
      localIntent = new Intent(paramContext, ChatActivity.class);
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label179;
      }
      if ((jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 1) && (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 3000)) {
        break label135;
      }
      l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
      localIntent.putExtra("searched_timeorseq", l);
    }
    label135:
    label146:
    label179:
    for (;;)
    {
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString3);
      a(localIntent);
      if (paramBoolean)
      {
        if ((paramContext instanceof SplashActivity)) {
          a(paramContext, localIntent);
        }
        return;
        l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        break;
        localIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 1 });
        continue;
      }
      paramContext.startActivity(localIntent);
      return;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (jdField_a_of_type_Boolean)
    {
      paramIntent.putExtra("aio_msg_source", 1);
      paramIntent.putExtra("entrance", 7);
      jdField_a_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
      jdField_a_of_type_Long = 0L;
      return;
    }
    paramIntent.putExtra("aio_msg_source", 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.type == 5000) {}
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      return;
      if ((paramRecentUser.type == 7200) || (paramRecentUser.type == 1008))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
        if (paramRecentUser.type == 1008) {
          a(paramQQAppInterface, paramRecentUser.uin, 1);
        }
      }
      else if (String.valueOf(9992L).equals(paramRecentUser.uin))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419F", "0X800419F", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.type == 1001) && (AppConstants.ar.equals(paramRecentUser.uin)))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050FD", "0X80050FD", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.type == 1010) && (AppConstants.aH.equals(paramRecentUser.uin)))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050FF", "0X80050FF", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.type == 1009) && (AppConstants.ag.equals(paramRecentUser.uin)))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A4", "0X80041A4", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label496:
    label608:
    label683:
    label686:
    label732:
    label882:
    label913:
    label994:
    label997:
    label1040:
    do
    {
      for (;;)
      {
        return;
        paramQQAppInterface.a().a().a(paramRecentUser, false);
        Object localObject1;
        int i;
        if (MsgProxyUtils.a(paramRecentUser.uin, paramRecentUser.type))
        {
          if ((AppConstants.aH.equals(paramRecentUser.uin)) || (AppConstants.ar.equals(paramRecentUser.uin)))
          {
            localObject1 = paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.type);
            if (localObject1 != null) {
              paramQQAppInterface.a().a(paramRecentUser.type, ((QQMessageFacade.Message)localObject1).time);
            }
          }
          localObject1 = paramRecentUser.uin;
          i = paramRecentUser.type;
          ThreadManager.a(new oyf((MessageHandler)paramQQAppInterface.a(0), (String)localObject1, i), 8, null, false);
          paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.type, true, true);
          if (paramRecentUser.type == 1) {
            HotChatUtil.a(paramQQAppInterface, paramRecentUser.uin);
          }
          if ((paramRecentUser.type == 9000) && (AppConstants.aC.equals(paramRecentUser.uin)))
          {
            paramQQAppInterface.a().a().c();
            GroupSystemMsgController.a().a(paramQQAppInterface, 0);
            ((RecommendTroopManagerImp)paramQQAppInterface.getManager(21)).a();
          }
          if ((paramRecentUser.type == 7210) && (AppConstants.aI.equals(paramRecentUser.uin)))
          {
            TroopBarAssistantManager.a().g(paramQQAppInterface);
            TroopBarAssistantManager.a().e(paramQQAppInterface);
            paramQQAppInterface.a(true, 0);
          }
          if ((paramRecentUser.type == 7230) && (AppConstants.bb.equals(paramRecentUser.uin)))
          {
            localObject1 = ServiceAccountFolderManager.a();
            i = ((ServiceAccountFolderManager)localObject1).b();
            int j = ((ServiceAccountFolderManager)localObject1).a(paramQQAppInterface);
            long l = ((ServiceAccountFolderManager)localObject1).b();
            if (paramInt != -1) {
              ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EB", "0X80067EB", 0, 0, "" + j, "" + i, String.valueOf(paramInt + 1), "" + l);
            }
            ((ServiceAccountFolderManager)localObject1).d(paramQQAppInterface);
            paramQQAppInterface.a(true, 0);
            if (QLog.isColorLevel()) {
              QLog.d("RecentUtil", 2, "deleteServiceAccountFolderFromMsgTab");
            }
          }
          if (!AppConstants.aI.equals(paramRecentUser.uin)) {
            break label732;
          }
          ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572D", "0X800572D", 0, 0, "", "", "", "");
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800623F", "0X800623F", 0, 0, "", "", "", "");
          SubscriptRecommendController.c(paramQQAppInterface, false);
          paramInt = 0;
          switch (paramRecentUser.type)
          {
          default: 
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, paramInt + "", "", "", "");
            if (paramRecentUser.type != 5000) {
              break label913;
            }
            TroopAssistantManager.a().a(paramQQAppInterface, true);
            paramRecentUser = TroopAssistantManager.a().b(paramQQAppInterface);
            if (paramRecentUser == null)
            {
              paramInt = 0;
              i = 0;
              if (i >= paramInt) {
                continue;
              }
              localObject1 = (TroopAssistantData)paramRecentUser.get(i);
              if (localObject1 != null) {
                break label882;
              }
            }
            break;
          }
        }
        for (;;)
        {
          i += 1;
          break label686;
          b(paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type);
          break;
          if (!AppConstants.aK.equals(paramRecentUser.uin)) {
            break label496;
          }
          if (((EcShopAssistantManager)paramQQAppInterface.getManager(87)).a(paramQQAppInterface) > 0) {}
          for (localObject1 = "havereddot";; localObject1 = "noreddot")
          {
            ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsglist", "Del_shopHelper", 0, 0, "", "", (String)localObject1, "");
            break;
          }
          if (!paramRecentUser.uin.equals(AppConstants.aq)) {
            break label608;
          }
          paramInt = 7;
          break label608;
          paramInt = 1;
          break label608;
          paramInt = 2;
          break label608;
          paramInt = 3;
          a(paramQQAppInterface, paramRecentUser.uin, 2);
          break label608;
          paramInt = 4;
          break label608;
          paramInt = 5;
          break label608;
          paramInt = 6;
          break label608;
          paramInt = 8;
          break label608;
          paramInt = 9;
          break label608;
          paramInt = paramRecentUser.size();
          break label683;
          localObject1 = paramQQAppInterface.a().a(((TroopAssistantData)localObject1).troopUin, 1);
          if (localObject1 != null) {
            TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
          }
        }
        if (paramRecentUser.type == 7210)
        {
          TroopBarAssistantManager.a().a(paramQQAppInterface, true);
          ThreadManager.a(new oyg(paramQQAppInterface), 8, null, false);
          TroopBarAssistantManager.a().j(paramQQAppInterface);
          return;
        }
        if (paramRecentUser.type == 7120)
        {
          paramRecentUser = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
          if (paramRecentUser != null)
          {
            paramRecentUser.a(true);
            localObject1 = paramRecentUser.a();
            Object localObject2;
            if (localObject1 == null)
            {
              paramInt = 0;
              i = 0;
              if (i < paramInt)
              {
                localObject2 = (EcShopData)((List)localObject1).get(i);
                if (localObject2 != null) {
                  break label1040;
                }
              }
            }
            for (;;)
            {
              i += 1;
              break label997;
              break;
              paramInt = ((List)localObject1).size();
              break label994;
              localObject2 = paramQQAppInterface.a().a(((EcShopData)localObject2).mUin, 1008);
              if (localObject2 != null) {
                paramRecentUser.a(((QQMessageFacade.Message)localObject2).time);
              }
            }
          }
        }
        else
        {
          if (paramRecentUser.type != 9002) {
            break;
          }
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004E99", "0X8004E99", 0, 0, "", "", "", "");
          paramRecentUser = paramQQAppInterface.a().b(AppConstants.aJ, 0).iterator();
          while (paramRecentUser.hasNext())
          {
            localObject1 = (MessageRecord)paramRecentUser.next();
            paramQQAppInterface.a().b(AppConstants.aJ, 0, ((MessageRecord)localObject1).uniseq);
          }
        }
      }
    } while (paramRecentUser.type != 9003);
    ((BlessManager)paramQQAppInterface.getManager(137)).c();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label139:
    label164:
    label305:
    label314:
    label316:
    label351:
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        int i;
                        if (MsgProxyUtils.a(paramRecentUser.uin, paramRecentUser.type))
                        {
                          if ((AppConstants.aH.equals(paramRecentUser.uin)) || (AppConstants.ar.equals(paramRecentUser.uin)))
                          {
                            localObject = paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.type);
                            if (localObject != null) {
                              paramQQAppInterface.a().a(paramRecentUser.type, ((QQMessageFacade.Message)localObject).time);
                            }
                          }
                          localObject = paramRecentUser.uin;
                          i = paramRecentUser.type;
                          paramQQAppInterface.a().d((String)localObject, i);
                          ThreadManager.a(new oye((MessageHandler)paramQQAppInterface.a(0), (String)localObject, i), 8, null, false);
                          if (paramRecentUser.type != 5000) {
                            break label351;
                          }
                          paramRecentUser = TroopAssistantManager.a().b(paramQQAppInterface);
                          if (paramRecentUser != null) {
                            break label305;
                          }
                          i = 0;
                          if (j >= i) {
                            break label314;
                          }
                          localObject = (TroopAssistantData)paramRecentUser.get(j);
                          if (localObject != null) {
                            break label316;
                          }
                        }
                        for (;;)
                        {
                          j += 1;
                          break label164;
                          if (paramBoolean1)
                          {
                            localObject = new SessionInfo();
                            ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramRecentUser.uin;
                            ((SessionInfo)localObject).b = paramRecentUser.uin;
                            ((SessionInfo)localObject).jdField_a_of_type_Int = paramRecentUser.type;
                            if (((SessionInfo)localObject).jdField_a_of_type_Int == 1006) {
                              ((SessionInfo)localObject).f = ContactUtils.f(paramQQAppInterface, ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
                            }
                            ChatActivityFacade.a(paramQQAppInterface, (SessionInfo)localObject);
                          }
                          paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.type, true, paramBoolean2);
                          if (paramRecentUser.type != 1) {
                            break label139;
                          }
                          HotChatUtil.a(paramQQAppInterface, paramRecentUser.uin);
                          break label139;
                          i = paramRecentUser.size();
                          break label164;
                          break;
                          localObject = paramQQAppInterface.a().a(((TroopAssistantData)localObject).troopUin, 1);
                          if (localObject != null) {
                            TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject).time);
                          }
                        }
                        if (7000 != paramRecentUser.type) {
                          break;
                        }
                      } while ((paramRecentUser.uin == null) || (paramRecentUser.uin.length() < 5));
                      ((MessageHandler)paramQQAppInterface.a(0)).a().a(paramRecentUser.uin, null);
                      paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(60);
                    } while (paramQQAppInterface == null);
                    paramQQAppInterface.b(paramRecentUser.uin);
                    return;
                    if (AppConstants.an.equals(paramRecentUser.uin))
                    {
                      ((NewFriendManager)paramQQAppInterface.getManager(33)).e();
                      return;
                    }
                    if (String.valueOf(9980L).equals(paramRecentUser.uin))
                    {
                      paramQQAppInterface.a().a().c();
                      GroupSystemMsgController.a().a(paramQQAppInterface, 0);
                      ((RecommendTroopManagerImp)paramQQAppInterface.getManager(21)).a();
                      return;
                    }
                    if (paramRecentUser.type != 7210) {
                      break;
                    }
                    paramRecentUser = TroopBarAssistantManager.a().a(paramQQAppInterface);
                  } while ((paramRecentUser == null) || (paramRecentUser.size() <= 0));
                  paramRecentUser = (TroopBarData)paramRecentUser.get(0);
                } while (paramRecentUser == null);
                paramRecentUser = paramQQAppInterface.a().a(paramRecentUser.mUin, 1008);
              } while (paramRecentUser == null);
              TroopBarAssistantManager.a().a(paramQQAppInterface, paramRecentUser.time);
              return;
              if (paramRecentUser.type != 7120) {
                break;
              }
              paramRecentUser = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
            } while (paramRecentUser == null);
            localObject = paramRecentUser.a();
          } while ((localObject == null) || (((List)localObject).size() <= 0));
          localObject = (EcShopData)((List)localObject).get(0);
        } while (localObject == null);
        paramQQAppInterface = paramQQAppInterface.a().a(((EcShopData)localObject).mUin, 1008);
      } while (paramQQAppInterface == null);
      paramRecentUser.a(paramQQAppInterface.time);
      return;
      if (AppConstants.aT.equals(paramRecentUser.uin))
      {
        ((DingdongPluginManager)paramQQAppInterface.getManager(114)).a(true, paramBoolean2, false);
        return;
      }
    } while (paramRecentUser.type != 7220);
    ((KandianMergeManager)paramQQAppInterface.getManager(161)).a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    ThreadManager.a(new oyh(paramQQAppInterface, paramString, paramInt), 2, null, false);
  }
  
  public static void a(RecentUser paramRecentUser, QQMessageFacade paramQQMessageFacade)
  {
    long l1 = System.currentTimeMillis();
    if ((paramRecentUser == null) || (paramQQMessageFacade == null)) {}
    long l2;
    do
    {
      return;
      if ((paramRecentUser.getStatus() == 1000) && (paramRecentUser.lastmsgdrafttime == 0L))
      {
        paramQQMessageFacade = paramQQMessageFacade.a(paramRecentUser.uin, paramRecentUser.type);
        if (paramQQMessageFacade != null) {
          paramRecentUser.lastmsgdrafttime = paramQQMessageFacade.getTime();
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "updateLastDraftTimeForNewRU| cost = " + (l2 - l1));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    if (AppConstants.ar.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1001, paramRecentUser.uin);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050F5", "0X80050F5", 0, 0, "", "", "", "");
      paramActivity = paramQQAppInterface.a().a(paramRecentUser.uin, 1001);
      if ((paramActivity != null) && (paramActivity.msgtype == 61525))
      {
        paramActivity = NearbyRecommenderUtils.a(paramQQAppInterface);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80055FB", "0X80055FB", 0, 0, paramActivity[0], "", paramActivity[1], "");
      }
      return true;
    }
    if (AppConstants.aH.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1010, paramRecentUser.uin);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004947", "0X8004947", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050F6", "0X80050F6", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.aM.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1001, AppConstants.ar);
      return true;
    }
    if (AppConstants.aN.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1010, AppConstants.aH);
      return true;
    }
    if (String.valueOf(AppConstants.ag).equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1009, paramRecentUser.uin);
      return true;
    }
    if (AppConstants.ao.equals(paramRecentUser.uin))
    {
      paramQQAppInterface.a().c(AppConstants.ao, 0);
      paramRecentUser = new Intent(paramActivity, VisitorsActivity.class);
      paramRecentUser.putExtra("votersOnly", true);
      paramRecentUser.putExtra("toUin", Long.valueOf(paramQQAppInterface.a()));
      paramActivity.startActivity(paramRecentUser);
      return true;
    }
    if (AppConstants.an.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, NewFriendActivity.class);
      paramRecentUser.putExtra("EntranceId", 1);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.am.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, TroopAssistantActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_help", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.as.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, QQBroadcastActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
      return true;
    }
    if (AppConstants.aI.equals(paramRecentUser.uin))
    {
      SubscriptRecommendController.c(paramQQAppInterface, false);
      paramRecentUser = TroopBarAssistantManager.a();
      if (paramRecentUser.f(paramQQAppInterface)) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B70", "0X8005B70", 0, 0, paramQQAppInterface.a(), "", "", "");
      }
      paramRecentUser.e(paramQQAppInterface, false);
      paramRecentUser.d(paramQQAppInterface, false);
      paramInt = TroopBarAssistantManager.a().a(paramQQAppInterface);
      if (paramInt > 0)
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572B", "0X800572B", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006573", "0X8006573", 0, 0, "", "", "", "");
        if (paramInt <= 0) {
          break label3541;
        }
      }
    }
    label866:
    label907:
    label1054:
    label1197:
    label1313:
    label1352:
    label2283:
    label2994:
    label3000:
    label3023:
    label3226:
    label3232:
    label3238:
    label3462:
    label3502:
    label3516:
    label3521:
    label3524:
    label3529:
    label3541:
    for (paramInt = 1;; paramInt = 0)
    {
      ThreadManager.a(new oyd(paramQQAppInterface, paramInt), 8, null, false);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800623E", "0X800623E", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_tribe", "", "Msglist", "Clk_tribeHelper", 0, 0, "", "", "", "");
      if (PublicAccountUtil.a())
      {
        paramQQAppInterface = new Intent(paramActivity, WebViewJumpAction.class);
        paramQQAppInterface.putExtra("targetID", 1);
        paramQQAppInterface.putExtra("come_from", 1);
        paramQQAppInterface.setFlags(67108864);
        paramActivity.startActivity(paramQQAppInterface);
        if (PublicAccountUtil.a()) {
          paramActivity.overridePendingTransition(2130968590, 2130968591);
        }
        return true;
        ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572C", "0X800572C", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006574", "0X8006574", 0, 0, "", "", "", "");
        break;
      }
      if (ReadInJoyHelper.a(paramQQAppInterface))
      {
        paramQQAppInterface = ReadInJoyActivityHelper.a(paramActivity, 0, 1);
        paramQQAppInterface.putExtra("start_time", System.currentTimeMillis());
        if (paramInt == 0) {
          break label907;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramQQAppInterface.putExtra("has_red_hot", bool);
        break;
        paramQQAppInterface = ReadInJoyActivityHelper.a(paramActivity, -1, 1);
        break label866;
      }
      Object localObject1;
      Object localObject2;
      int j;
      int i;
      if (TextUtils.equals(AppConstants.aZ, paramRecentUser.uin))
      {
        if (paramRecentBaseData != null) {
          paramInt = paramRecentBaseData.O;
        }
        for (;;)
        {
          localObject1 = new ArrayList();
          paramRecentBaseData = paramQQAppInterface.a();
          if (paramRecentBaseData == null) {
            break label1313;
          }
          paramRecentBaseData = paramRecentBaseData.a(paramRecentUser.uin, paramRecentUser.type);
          if ((paramRecentBaseData == null) || (!(paramRecentBaseData instanceof MessageForStructing)) || (paramRecentBaseData.extInt != 1)) {
            break label1352;
          }
          paramRecentUser = (MessageForStructing)paramRecentBaseData;
          if (paramRecentUser.structingMsg == null) {
            paramRecentUser.parse();
          }
          if (paramRecentUser.structingMsg == null) {
            break label1197;
          }
          if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mArticleIds))
          {
            localObject2 = paramRecentUser.structingMsg.mArticleIds.split("\\|");
            j = localObject2.length;
            i = 0;
            if (i < j)
            {
              String str1 = localObject2[i];
              try
              {
                ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong(str1)));
                i += 1;
                break label1054;
                paramInt = -1;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  localException2.printStackTrace();
                }
              }
            }
          }
        }
        if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mMsgActionData))
        {
          localObject2 = PublicAccountUtil.a(paramRecentUser.structingMsg.mMsgActionData);
          if (localObject2 == null) {}
        }
      }
      for (;;)
      {
        long l;
        try
        {
          l = Long.parseLong(((JSONObject)localObject2).getString("id"));
          if (l != -1L) {
            ReportController.b(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(paramInt + 1), "", String.valueOf(l), "");
          }
          PublicAccountUtil.a(paramQQAppInterface, paramRecentUser, 1);
          paramQQAppInterface = "";
          paramRecentUser = paramQQAppInterface;
          if (paramRecentBaseData == null) {
            break label3529;
          }
          paramRecentUser = paramQQAppInterface;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        try
        {
          if (!(paramRecentBaseData instanceof MessageForStructing)) {
            break label3529;
          }
          paramRecentBaseData = (MessageForStructing)paramRecentBaseData;
          if (paramRecentBaseData.structingMsg.mStrategyIds != null) {
            paramQQAppInterface = paramRecentBaseData.structingMsg.mStrategyIds.split("\\|")[0];
          }
          paramRecentUser = paramQQAppInterface;
          if (paramRecentBaseData.structingMsg.mAlgorithmIds == null) {
            break label3529;
          }
          paramRecentUser = paramRecentBaseData.structingMsg.mAlgorithmIds.split("\\|")[0];
          ReportController.b(null, "CliOper", "", "", "0X80066F4", "0X80066F4", 0, 0, String.valueOf(paramInt + 1), "", paramQQAppInterface, ReadInJoyUtils.b(paramRecentUser));
        }
        catch (Exception paramQQAppInterface)
        {
          QLog.d("KandianMergeManager", 1, "failed to report new kandian click " + paramQQAppInterface.toString());
          continue;
          l = ((Long)((ArrayList)localObject1).get(0)).longValue();
          continue;
        }
        if (((ArrayList)localObject1).isEmpty())
        {
          l = -1L;
          ReadInJoyActivityHelper.a(paramActivity, (List)localObject1, l, 5);
          return true;
          l = -1L;
          continue;
          ReportController.b(null, "CliOper", "", "", "0X80066F6", "0X80066F6", 0, 0, String.valueOf(paramInt + 1), "", "", "");
        }
        else
        {
          if (AppConstants.aF.equals(paramRecentUser.uin))
          {
            paramRecentUser = (SecMsgManager)paramQQAppInterface.getManager(56);
            paramInt = 0;
            if (paramRecentUser != null)
            {
              paramRecentUser.a("enter_msg_list", null, null, "msgtab", null);
              paramRecentBaseData = new Intent();
              if (paramRecentUser.h != 1) {
                break label3524;
              }
              paramInt = 1;
              paramRecentBaseData.putExtra("extra_tab_mode", 1);
              paramRecentBaseData.putExtra("extra_from_msg_tab", true);
            }
          }
          for (;;)
          {
            paramRecentUser.c();
            SecMsgHelper.a(paramActivity, paramQQAppInterface, 1, paramRecentBaseData);
            ReportController.b(null, "CliOper", "", "", "AnonyDiscuss", "enter_topic_list", paramInt, 0, "", "", "msgtab", "");
            return true;
            if (AppConstants.aU.equals(paramRecentUser.uin))
            {
              paramRecentUser = (BlessManager)paramQQAppInterface.getManager(137);
              if (paramRecentUser != null)
              {
                paramRecentBaseData = new Intent();
                paramRecentBaseData.setClass(paramActivity, BlessActivity.class);
                paramActivity.startActivity(paramRecentBaseData);
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800618B", "0X800618B", 0, 0, "", "", "", "");
                if (paramRecentUser.h()) {
                  ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800632C", "0X800632C", 0, 0, "", "", "", "");
                }
              }
              return true;
            }
            if (AppConstants.aB.equals(paramRecentUser.uin)) {
              return true;
            }
            Object localObject3;
            if (AppConstants.aC.equals(paramRecentUser.uin))
            {
              paramRecentBaseData = "1";
              localObject3 = new Intent();
              ((Intent)localObject3).putExtra("key_tab_mode", 2);
              ((Intent)localObject3).setClass(paramActivity, TroopActivity.class);
              paramInt = GroupSystemMsgController.a().a(paramQQAppInterface);
              if (paramInt > 0)
              {
                localObject1 = "0";
                paramRecentBaseData = "0";
              }
              for (;;)
              {
                paramQQAppInterface.a().c(AppConstants.aC, 9000, -paramInt);
                ((Intent)localObject3).putExtra("_key_mode", paramRecentUser.jumpTabMode);
                paramActivity.startActivity((Intent)localObject3);
                ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "Clk_notice", 0, 0, "", paramRecentBaseData, (String)localObject1, "");
                return true;
                paramInt = RecommendTroopManagerImp.b(paramQQAppInterface);
                if (paramInt > 0)
                {
                  paramRecentBaseData = "0";
                  localObject1 = "1";
                }
                else
                {
                  localObject1 = "0";
                }
              }
            }
            if (AppConstants.aj.equals(paramRecentUser.uin))
            {
              paramRecentUser = new Intent(paramActivity, LiteActivity.class);
              paramRecentUser.putExtra("targetUin", AppConstants.aj);
              paramActivity.startActivity(paramRecentUser);
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800603B", "0X800603B", 0, 0, "", "", "", "");
              return true;
            }
            if (AppConstants.ak.equals(paramRecentUser.uin))
            {
              paramRecentUser = new Intent(paramActivity, LiteActivity.class);
              paramRecentUser.putExtra("targetUin", AppConstants.ak);
              paramActivity.startActivity(paramRecentUser);
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006040", "0X8006040", 0, 0, "", "", "", "");
              return true;
            }
            if (AppConstants.aJ.equals(paramRecentUser.uin))
            {
              paramQQAppInterface = new Intent(paramActivity, ActivateFriendActivity.class);
              paramQQAppInterface.setFlags(67108864);
              if (paramInt == 0) {}
              for (paramInt = 1;; paramInt = 3)
              {
                paramQQAppInterface.putExtra("af_key_from", paramInt);
                paramActivity.startActivity(paramQQAppInterface);
                return true;
              }
            }
            if (AppConstants.aK.equals(paramRecentUser.uin))
            {
              paramRecentUser = new Intent(paramActivity, EcShopAssistantActivity.class);
              paramRecentUser.putExtra("start_time", System.currentTimeMillis());
              paramRecentUser.setFlags(67108864);
              ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Msglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
              paramRecentBaseData = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
              if (paramRecentBaseData != null)
              {
                localObject1 = paramRecentBaseData.a();
                if (localObject1 != null) {
                  break label2283;
                }
                paramInt = 0;
                if (paramInt == 0) {
                  ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_noMsglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
                }
                i = paramRecentBaseData.a(paramQQAppInterface);
                if (i <= 0) {
                  break label3521;
                }
                i = 1;
              }
            }
            for (;;)
            {
              ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064CB", "0X80064CB", 0, 0, "" + i, "" + paramInt, "", "");
              if (i != 0) {}
              for (bool = true;; bool = false)
              {
                paramRecentUser.putExtra("has_red_hot", bool);
                paramActivity.startActivity(paramRecentUser);
                return true;
                paramInt = ((List)localObject1).size();
                break;
              }
              if (1012 == paramRecentUser.msgType)
              {
                paramQQAppInterface = new ProfileActivity.AllInOne(paramQQAppInterface.a(), 0);
                paramRecentUser = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
                paramRecentUser.putExtra("param_mode", 2);
                paramRecentUser.putExtra("AllInOne", paramQQAppInterface);
                paramRecentUser.putExtra("frome_where", -1);
                paramRecentUser.putExtra("abp_flag", true);
                paramRecentUser.addFlags(67108864);
                paramActivity.startActivity(paramRecentUser);
                return true;
              }
              if (AppConstants.aT.equals(paramRecentUser.uin))
              {
                ((DingdongPluginManager)paramQQAppInterface.getManager(114)).a(false, false, true);
                paramRecentUser = new Intent();
                paramRecentUser.putExtra("_current_unread_num", paramQQAppInterface.a().a(AppConstants.aT, 9999));
                paramRecentUser.putExtra("_from_", 2);
                DingdongPluginHelper.a(paramActivity, "com.dingdong.business.base.activity.DingdongUinListActivity", paramRecentUser, -1);
                DingdongPluginHelper.a("0x8005EBA");
                return true;
              }
              if (AppConstants.aV.equals(paramRecentUser.uin))
              {
                WifiConversationManager.a().c();
                return true;
              }
              if (TextUtils.equals(AppConstants.ba, paramRecentUser.uin))
              {
                localObject3 = paramQQAppInterface.a();
                localObject1 = new ArrayList();
                if (localObject3 != null)
                {
                  localObject3 = ((QQMessageFacade)localObject3).a(paramRecentUser.uin, paramRecentUser.type);
                  if ((localObject3 != null) && ((localObject3 instanceof MessageForStructing)) && (((MessageRecord)localObject3).extInt == 1))
                  {
                    paramRecentUser = (MessageForStructing)localObject3;
                    if (paramRecentUser.structingMsg == null) {
                      paramRecentUser.parse();
                    }
                    if (paramRecentUser.structingMsg != null)
                    {
                      if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mArticleIds))
                      {
                        String[] arrayOfString = paramRecentUser.structingMsg.mArticleIds.split("\\|");
                        i = arrayOfString.length;
                        paramInt = 0;
                        for (;;)
                        {
                          if (paramInt < i)
                          {
                            String str2 = arrayOfString[paramInt];
                            try
                            {
                              ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong(str2)));
                              paramInt += 1;
                            }
                            catch (Exception localException3)
                            {
                              for (;;)
                              {
                                localException3.printStackTrace();
                              }
                            }
                          }
                        }
                      }
                      if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mMsgActionData))
                      {
                        paramRecentUser = PublicAccountUtil.a(paramRecentUser.structingMsg.mMsgActionData);
                        if (paramRecentUser == null) {}
                      }
                    }
                  }
                }
              }
              for (;;)
              {
                try
                {
                  l = Long.parseLong(paramRecentUser.getString("id"));
                  if (paramRecentBaseData == null) {
                    break label2994;
                  }
                  i = paramRecentBaseData.O;
                  if (localObject3 == null) {
                    break label3516;
                  }
                  if ((((MessageRecord)localObject3).extInt != 1) && (((MessageRecord)localObject3).extInt != 3)) {
                    break label3000;
                  }
                  paramInt = 0;
                  if ((localObject3 == null) || (!((MessageRecord)localObject3).isread)) {
                    break label3023;
                  }
                  ReadInJoyUtils.a(1);
                  paramRecentUser = "";
                  localObject1 = paramRecentUser;
                  if (localObject3 == null) {
                    break label3502;
                  }
                  localObject1 = paramRecentUser;
                  if (!(localObject3 instanceof MessageForStructing)) {
                    break label3502;
                  }
                  localObject3 = (MessageForStructing)localObject3;
                  localObject1 = paramRecentUser;
                  if (((MessageForStructing)localObject3).structingMsg == null) {
                    break label3502;
                  }
                  if (((MessageForStructing)localObject3).structingMsg.mStrategyIds != null) {
                    paramRecentUser = localObject3.structingMsg.mStrategyIds.split("\\|")[0];
                  }
                  localObject1 = paramRecentUser;
                  if (((MessageForStructing)localObject3).structingMsg.mAlgorithmIds == null) {
                    break label3502;
                  }
                  localObject1 = localObject3.structingMsg.mAlgorithmIds.split("\\|")[0];
                  ReportController.b(null, "CliOper", "", "", "0X80066F4", "0X80066F4", 0, 0, String.valueOf(i + 1), "", paramRecentUser, ReadInJoyUtils.b((String)localObject1));
                  if (paramRecentBaseData == null) {
                    break label3232;
                  }
                  if (paramRecentBaseData.b == null) {
                    break label3226;
                  }
                  paramRecentUser = paramRecentBaseData.b.toString();
                  paramRecentUser = new StringBuilder().append("enter kandianMergeBox, brief : ").append(ReadInJoyUtils.c(paramRecentUser)).append(",isRead : ");
                  if ((paramRecentBaseData == null) || (paramRecentBaseData.H == 0)) {
                    break label3238;
                  }
                  bool = true;
                  QLog.d("KandianMergeManager", 1, bool);
                  ReadInJoyActivityHelper.a(paramQQAppInterface, paramActivity, 5, 0);
                  return true;
                }
                catch (Exception paramRecentUser)
                {
                  paramRecentUser.printStackTrace();
                }
                l = -1L;
                continue;
                i = -1;
                continue;
                if ((((MessageRecord)localObject3).extInt == 2) || (((MessageRecord)localObject3).extInt == 4))
                {
                  paramInt = 1;
                  continue;
                  if (paramInt == 0)
                  {
                    paramRecentUser = (KandianMergeManager)paramQQAppInterface.getManager(161);
                    if ((paramRecentUser != null) && (paramRecentUser.a((MessageRecord)localObject3) == 1)) {
                      ReadInJoyUtils.a(5);
                    }
                    for (;;)
                    {
                      ReportController.b(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(i + 1), "", Long.toString(l), "");
                      break;
                      ReadInJoyUtils.a(3);
                    }
                  }
                  if (paramInt == 1)
                  {
                    if ((!TextUtils.isEmpty(((MessageRecord)localObject3).senderuin)) && (PublicAccountUtil.d(paramQQAppInterface, ((MessageRecord)localObject3).senderuin))) {
                      ReadInJoyUtils.a(4);
                    }
                    for (;;)
                    {
                      ReportController.b(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(i + 1), "", "0", "");
                      break;
                      ReadInJoyUtils.a(2);
                    }
                    if (paramRecentBaseData != null) {}
                    for (paramInt = paramRecentBaseData.O;; paramInt = -1)
                    {
                      ReportController.b(null, "CliOper", "", "", "0X80066F4", "0X80066F4", 0, 0, String.valueOf(paramInt + 1), "", "", ReadInJoyUtils.b(""));
                      break;
                    }
                    paramRecentUser = "";
                    continue;
                    paramRecentUser = "";
                    continue;
                    bool = false;
                    continue;
                    if (AppConstants.bb.equals(paramRecentUser.uin))
                    {
                      paramRecentUser = new Intent(paramActivity, ServiceAccountFolderActivity.class);
                      paramRecentUser.putExtra("from_source", "from_msg_tab");
                      paramRecentUser.setFlags(67108864);
                      paramActivity.startActivity(paramRecentUser);
                      if (QLog.isColorLevel()) {
                        QLog.d("RecentUtil", 2, "enterServiceAccountFolderActivityFromMsgTab");
                      }
                      paramActivity = "0X80067EA";
                      paramRecentUser = ServiceAccountFolderManager.a();
                      i = paramRecentUser.b();
                      j = paramRecentUser.a(paramQQAppInterface);
                      if (j == 1)
                      {
                        paramActivity = "0X80067E8";
                        paramRecentUser.a();
                        l = paramRecentUser.b();
                        if (paramRecentBaseData != null) {
                          break label3462;
                        }
                      }
                      for (paramInt = -1;; paramInt = paramRecentBaseData.O)
                      {
                        ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", paramActivity, paramActivity, 0, 0, "" + l, "" + j, "" + i, String.valueOf(paramInt + 1));
                        PublicTracker.a(null, "SERVICE_FOLDER_COST");
                        return true;
                        if (j != 2) {
                          break;
                        }
                        paramActivity = "0X80067E9";
                        break;
                      }
                    }
                    if (AppConstants.bc.equals(paramRecentUser.uin))
                    {
                      ((ChangeMachineManager)paramQQAppInterface.getManager(182)).a(paramActivity);
                      return true;
                    }
                    return false;
                    localObject3 = "";
                    paramRecentUser = (RecentUser)localObject1;
                    localObject1 = localObject3;
                  }
                }
                else
                {
                  paramInt = 0;
                }
              }
            }
            paramInt = 0;
          }
          paramRecentBaseData = "";
          paramQQAppInterface = paramRecentUser;
          paramRecentUser = paramRecentBaseData;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
        if (paramQQAppInterface != null) {
          break label35;
        }
      }
    }
    label35:
    for (bool1 = false;; bool1 = paramQQAppInterface.b(paramString)) {
      return bool1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      break label8;
      break label8;
    }
    label8:
    label539:
    label545:
    for (;;)
    {
      return;
      if (paramQQAppInterface.a().a(paramString, paramInt) > 0)
      {
        long l2 = paramQQAppInterface.a().b(paramString, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("RecentUtil,uin: %s, uinType: %d, id: %d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(l2) }));
        }
        if (l2 == -1L) {
          break;
        }
        msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
        Object localObject1;
        Object localObject2;
        if (paramInt == 1)
        {
          localObject1 = "troop_processor";
          if (!paramString.matches("^\\d+$")) {
            break;
          }
          localObject2 = new msg_svc.PbGroupReadedReportReq();
          ((msg_svc.PbGroupReadedReportReq)localObject2).group_code.set(Long.valueOf(paramString).longValue());
          ((msg_svc.PbGroupReadedReportReq)localObject2).last_read_seq.set(l2);
          localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject2);
          paramString = (String)localObject1;
        }
        for (;;)
        {
          paramQQAppInterface.a().a(paramString).a(localPbMsgReadedReportReq);
          return;
          if (paramInt == 1026)
          {
            localObject1 = "hctopic_processor";
            localObject2 = new msg_svc.PbGroupReadedReportReq();
            ((msg_svc.PbGroupReadedReportReq)localObject2).group_code.set(Long.valueOf(paramString).longValue());
            ((msg_svc.PbGroupReadedReportReq)localObject2).last_read_seq.set(l2);
            localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject2);
            paramString = (String)localObject1;
          }
          else
          {
            if (paramInt != 3000) {
              break;
            }
            localObject1 = "disc_processor";
            localObject2 = new msg_svc.PbDiscussReadedReportReq();
            ((msg_svc.PbDiscussReadedReportReq)localObject2).conf_uin.set(Long.valueOf(paramString).longValue());
            ((msg_svc.PbDiscussReadedReportReq)localObject2).last_read_seq.set(l2);
            localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject2);
            paramString = (String)localObject1;
          }
        }
        if ((!MsgProxyUtils.c(paramInt)) || (l2 == 0L)) {
          break;
        }
        if (AppConstants.aq.equals(paramString))
        {
          paramQQAppInterface.a().a().a();
          return;
        }
        long l1;
        if (paramInt == 1006)
        {
          localObject1 = ContactUtils.f(paramQQAppInterface, paramString);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label539;
          }
          l1 = Long.valueOf((String)localObject1).longValue();
        }
        for (;;)
        {
          if (l1 == -1L) {
            break label545;
          }
          localObject1 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).peer_uin.set(l1);
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).last_read_time.set((int)l2);
          if (paramInt == 1024)
          {
            paramString = paramQQAppInterface.a().d(paramString);
            if (paramString != null)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + HexUtil.a(paramString) + ",length:" + paramString.length);
              }
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).crm_sig.set(ByteStringMicro.copyFrom(paramString));
            }
          }
          paramString = new msg_svc.PbC2CReadedReportReq();
          paramString.pair_info.add((MessageMicro)localObject1);
          localObject1 = paramQQAppInterface.a().a().a();
          if (localObject1 != null) {
            paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject1));
          }
          localPbMsgReadedReportReq.c2c_read_report.set(paramString);
          paramString = "c2c_processor";
          break;
          l1 = Long.valueOf(paramString).longValue();
          continue;
          l1 = -1L;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */