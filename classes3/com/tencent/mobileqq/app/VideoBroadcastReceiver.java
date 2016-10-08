package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.ui.SysCallTransparentActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoC2CHandler;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QavGAudioSoundHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandlerV7;
import com.tencent.mobileqq.earlydownload.handler.QavSoRepairHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qcall.PstnHandler;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qcall.QCallStartBrigeActivity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.c2b.C2BLBSHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import qhw;
import qhx;
import qhy;
import qhz;
import qia;
import qib;
import qic;
import qid;

public class VideoBroadcastReceiver
  extends BroadcastReceiver
{
  static VideoBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver;
  public static String a;
  public QQAppInterface a;
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "VideoBroadCastReceiver";
  }
  
  VideoBroadcastReceiver(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a()
  {
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver != null) && (jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver);
        jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_Boolean = false;
        jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver = null;
      }
      return;
    }
    finally {}
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (localQCallFacade != null)
    {
      if ((paramInt != 3) && (paramInt != 4)) {
        break label112;
      }
      localQCallFacade.a(paramString1, paramString2, paramString3, 8);
    }
    for (;;)
    {
      label112:
      try
      {
        paramString2 = MessageRecordFactory.a(61528);
        paramString2.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramString2.frienduin = paramString1;
        paramString2.senderuin = paramString3;
        paramString2.msgtype = 61528;
        paramString2.isread = true;
        paramString2.issend = 1;
        paramString2.istroop = 3000;
        paramString2.time = MessageCache.a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true, paramString2);
        return;
      }
      catch (Exception paramString1) {}
      localQCallFacade.a(paramString1, paramString2, paramString3, 2);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver == null) {
        jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver = new VideoBroadcastReceiver(paramQQAppInterface);
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.video.v2q.AddMsgSig");
      localIntentFilter.addAction("tencent.video.v2q.MeetingMemberManager");
      localIntentFilter.addAction("tencent.video.v2q.AddContactsToDiscuss");
      localIntentFilter.addAction("tencent.video.v2q.AddContactsFromC2C");
      localIntentFilter.addAction("tencent.video.v2q.AddVideoMsg");
      localIntentFilter.addAction("tencent.video.v2q.AddLightalkMsg");
      localIntentFilter.addAction("tencent.av.v2q.AddLightalkSig");
      localIntentFilter.addAction("tencent.av.v2q.CheckChatAbility");
      localIntentFilter.addAction("tencent.video.v2q.VideoFlowSize");
      localIntentFilter.addAction("tencent.av.v2q.MultiVideo");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StartDoubleVideoMeeting");
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.AvSwitch");
      localIntentFilter.addAction("tencent.video.v2q.replyMsg");
      localIntentFilter.addAction("tencent.video.v2q.leaveMsg");
      localIntentFilter.addAction("tencent.av.v2q.AnotherTerChating");
      localIntentFilter.addAction("tencent.video.v2q.AudioEngineReady");
      localIntentFilter.addAction("tencent.video.v2q.GaudioOpenTroopCard");
      localIntentFilter.addAction("tencent.video.v2q.CallingDialog");
      localIntentFilter.addAction("tencent.video.v2q.CallingDialogMulti");
      localIntentFilter.addAction("tencent.video.v2q.BindContact");
      localIntentFilter.addAction("tencent.video.v2q.OpenContactList");
      localIntentFilter.addAction("tencent.video.v2q.AnnimateDownloadStart");
      localIntentFilter.addAction("tencent.video.v2q.commingRingDownload");
      localIntentFilter.addAction("chatbgBroadcast");
      localIntentFilter.addAction("tencent.video.v2q.setChatStatus");
      localIntentFilter.addAction("tencent.video.v2q.updateChatInfo");
      localIntentFilter.addAction("tencent.video.v2q.downloadAvSo");
      localIntentFilter.addAction("tencent.video.v2q.insertSystemCall");
      localIntentFilter.addAction("tencent.video.v2q.upgradeInvite");
      localIntentFilter.addAction("tencent.video.v2q.SmallScreenState");
      localIntentFilter.addAction("tencent.video.v2q.downloadGAudioSound");
      localIntentFilter.addAction("tencent.video.v2q.generalFuncCall");
      localIntentFilter.addAction("tencent.c2b.action.REQUEST_LOCATION");
      localIntentFilter.addAction("qq.process.msg.uploadfile");
      localIntentFilter.addAction("tencent.av.v2q.CancelCallBack");
      localIntentFilter.addAction("tencent.av.v2q.ip2Pstn");
      localIntentFilter.addAction("tencent.av.v2q.multiPsntTryEnd");
      localIntentFilter.addAction("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
      localIntentFilter.addAction("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END");
      localIntentFilter.addAction("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
      localIntentFilter.addAction("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED");
      paramQQAppInterface.a().registerReceiver(jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver, localIntentFilter, "com.tencent.qav.permission.broadcast", null);
      jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_ADD_VIDEO_MSG");
    }
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("msgType", 5);
    int k = paramIntent.getIntExtra("msgDetail", 0);
    paramIntent.getIntExtra("bindType", 0);
    paramIntent.getStringExtra("bindId");
    boolean bool4 = paramIntent.getBooleanExtra("isVideoMsg", true);
    String str1 = paramIntent.getStringExtra("friendUin");
    String str2 = paramIntent.getStringExtra("senderUin");
    String str3 = paramIntent.getStringExtra("selfUin");
    boolean bool5 = paramIntent.getBooleanExtra("isSender", true);
    boolean bool6 = paramIntent.getBooleanExtra("isRead", false);
    paramContext = paramIntent.getStringExtra("extra");
    int m = paramIntent.getIntExtra("MultiAVType", 0);
    paramIntent.getLongExtra("relationId", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_ADD_VIDEO_MSG selfUin = " + str3);
    }
    if ((j == 0) && (str3 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (!str3.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      return;
    }
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (((j == 2) || (j == 24)) && (paramContext == null))
    {
      if (!QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label661;
      }
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369618), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368465), "qqsetting_notify_showcontent_key", true);
      if ((!bool1) || (!bool2)) {
        break label674;
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
      if (paramIntent != null) {
        paramIntent.sendMessage(paramIntent.obtainMessage(16711696));
      }
      bool3 = bool2;
      bool2 = bool1;
      bool1 = bool3;
    }
    for (;;)
    {
      if (j == 17) {
        paramContext = String.valueOf(k);
      }
      if ((m == 2) && (str1 != null)) {}
      try
      {
        long l = Long.parseLong(str1);
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, 2);
        if ((paramIntent != null) && (paramIntent.a > 0) && (j == 13)) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          paramIntent = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (paramIntent != null)
          {
            paramIntent = paramIntent.a(str1);
            if (paramIntent == null) {
              break;
            }
          }
        }
      }
      catch (NumberFormatException paramIntent)
      {
        for (;;) {}
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addVideoMsgWithAvtype");
      }
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, j, bool4, str1, str2, bool5, paramContext, bool6, m, new Object[0]);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addVideoMsgWithAvtype end");
      }
      if ((!bool2) || (!bool1)) {
        break;
      }
      paramContext = (QQLSRecentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(71);
      paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, i, true);
      paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, i, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  videoMsgReceiver");
      return;
      if (((j == 17) || (j == 15) || (j == 16)) && ((i == 3000) || (i == 1)) && (str1 != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(UITools.a(i), Long.valueOf(str1).longValue(), null, 0L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(21, UITools.a(i), Long.valueOf(str1).longValue(), 0L);
      }
      label661:
      bool2 = false;
      bool1 = false;
      continue;
      label674:
      bool3 = bool1;
      bool1 = bool2;
      bool2 = bool3;
    }
  }
  
  void a(boolean paramBoolean)
  {
    long l = UpdateAvSo.a();
    Object localObject2;
    Object localObject1;
    if (l != 0L)
    {
      l /= 1000L;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "qavFirstLauchInterval:" + l);
      }
      localObject2 = new HashMap();
      if (paramBoolean)
      {
        localObject1 = "0";
        ((HashMap)localObject2).put("isSender", localObject1);
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qavFirstLauchInterval", true, l, 0L, (HashMap)localObject2, "");
      }
    }
    else if (!UpdateAvSo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "start videochat  when download so is not ready ");
      }
      localObject1 = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      if (localObject1 != null)
      {
        localObject2 = (QavSoDownloadHandler)((EarlyDownloadManager)localObject1).a("qq.android.qav.so");
        if (localObject2 != null) {
          ((QavSoDownloadHandler)localObject2).a(false);
        }
        localObject1 = (QavSoDownloadHandlerV7)((EarlyDownloadManager)localObject1).a("qq.android.qav.sov7");
        if (localObject1 != null) {
          ((QavSoDownloadHandlerV7)localObject1).a(false);
        }
      }
      if (!paramBoolean) {
        break label354;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C70", "0X8004C70", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!UpdateAvSo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "start videochat  when download so is not integral ");
        }
        localObject1 = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
        if (localObject1 != null)
        {
          localObject1 = (QavSoRepairHandler)((EarlyDownloadManager)localObject1).a("qq.android.qav.sorepair.all");
          if (localObject1 != null) {
            ((QavSoRepairHandler)localObject1).a(false);
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D66", "0X8004D66", 0, 0, "", "", "", "");
      }
      return;
      localObject1 = "1";
      break;
      label354:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C6F", "0X8004C6F", 0, 0, "", "", "", "");
    }
  }
  
  void b(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("type", 20);
    boolean bool1 = paramIntent.getBooleanExtra("isStart", false);
    int j = paramIntent.getIntExtra("MultiAVType", 0);
    paramContext = paramIntent.getStringExtra("from");
    Object localObject = paramIntent.getStringExtra("PLACE");
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, String.format("onMultiMsgV2Q, type[%s], isStart[%s], multiAVType[%s], from[%s], place[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), paramContext, localObject }));
    }
    int k;
    long l1;
    long l2;
    int m;
    if (i == 22)
    {
      k = paramIntent.getIntExtra("relationType", 0);
      l1 = paramIntent.getLongExtra("relationId", 0L);
      l2 = paramIntent.getLongExtra("friendUin", 0L);
      m = paramIntent.getIntExtra("roomUserNum", 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(k, l1, 3);
      if (l2 == Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, Long.valueOf(l1), true, j);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(k, l1, 3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1, j);
        if (m == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1, true, false);
          paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          if (paramContext != null)
          {
            paramIntent = String.valueOf(l1);
            j = UITools.b(k);
            if ((j != -1) && (j != 1011) && (j != 2800) && (!TextUtils.isEmpty(paramIntent)))
            {
              if (j != 1) {
                break label601;
              }
              localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              if ((localObject != null) && (((TroopManager)localObject).a(paramIntent) != null))
              {
                paramIntent = paramContext.a(paramIntent, j);
                if (paramIntent != null)
                {
                  paramIntent.lastmsgtime = MessageCache.a();
                  paramContext.a(paramIntent);
                }
              }
            }
          }
          label379:
          if ((k != 1) && (k != 7) && (k != 9))
          {
            paramContext = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
            if (paramContext != null) {
              paramContext.a(l1, l2, true, -1L, bool1, false);
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == l1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() >= 4) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e()))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
          }
          label496:
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, k, l1, l2);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "member join discussId: " + l1 + ", friendUin: " + l2 + ", roomUserNum:" + m);
          }
        }
      }
    }
    label601:
    label996:
    label1062:
    label1136:
    label1373:
    label1398:
    label1563:
    label1771:
    label1892:
    label1935:
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
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1, false, false);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
                              break;
                              paramIntent = paramContext.a(paramIntent, j);
                              if (paramIntent == null) {
                                break label379;
                              }
                              paramIntent.lastmsgtime = MessageCache.a();
                              paramContext.a(paramIntent);
                              break label379;
                              if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != l1) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e())) {
                                break label496;
                              }
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1, false, false);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
                              break label496;
                              if (i != 23) {
                                break label996;
                              }
                              k = paramIntent.getIntExtra("relationType", 0);
                              l1 = paramIntent.getLongExtra("relationId", 0L);
                              l2 = paramIntent.getLongExtra("friendUin", 0L);
                              m = paramIntent.getIntExtra("roomUserNum", 0);
                              paramIntent.getLongArrayExtra("uinList");
                              if (l2 == Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue())
                              {
                                long l3 = paramIntent.getLongExtra("time", 0L);
                                boolean bool2 = paramIntent.getBooleanExtra("hasPstn", false);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(k, l1, 0);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, Long.valueOf(l1), false);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1, j);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(k, l1, 0);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(false);
                                if (k != 1)
                                {
                                  paramContext = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
                                  if (paramContext != null) {
                                    paramContext.a(l1, l2, false, l3, bool1, Boolean.valueOf(bool2).booleanValue());
                                  }
                                }
                              }
                              if (m == 1) {
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1, true, false);
                              }
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, k, l1, l2);
                            } while (!QLog.isColorLevel());
                            QLog.d(jdField_a_of_type_JavaLangString, 2, "member quit discussId: " + l1 + ", friendUin: " + l2);
                            return;
                            if (i != 32) {
                              break label1062;
                            }
                            l1 = paramIntent.getLongExtra("relationId", -1L);
                            k = paramIntent.getIntExtra("uinType", -1);
                          } while (k != 1);
                          l2 = paramIntent.getIntExtra("closeType", 1);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, k, l1, l2, j);
                          return;
                          if (i != 33) {
                            break label1136;
                          }
                          l1 = paramIntent.getLongExtra("relationId", -1L);
                          j = paramIntent.getIntExtra("uinType", -1);
                          l2 = paramIntent.getLongExtra("info", -1L);
                          paramContext = paramIntent.getStringExtra("strMsg");
                        } while (j != 1);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, j, l1, l2, paramContext);
                        return;
                        if (i != 25) {
                          break label1373;
                        }
                        l1 = paramIntent.getLongExtra("relationId", -1L);
                        i = paramIntent.getIntExtra("relationType", -1);
                        k = paramIntent.getIntExtra("reason", -1);
                        if (QLog.isColorLevel()) {
                          QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_ROOM_DESTROY-->relationid=" + l1 + " relationType=" + i + " reason=" + k + " avtype" + j);
                        }
                        if (k == 4) {
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(32, 1, l1, k, j);
                        }
                        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, l1) > 0L)
                        {
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, l1, null, 0L);
                          paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                          VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 14, false, String.valueOf(l1), paramContext, false, null, false, j, new Object[0]);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(21, i, l1, 0L);
                          return;
                        }
                      } while (!QLog.isColorLevel());
                      QLog.w(jdField_a_of_type_JavaLangString, 2, "MultiRoomMemberNum is 0");
                      return;
                      if (i != 401) {
                        break label1398;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN");
                    return;
                    if (i != 402) {
                      break label1563;
                    }
                    i = paramIntent.getIntExtra("relationType", 0);
                    l1 = paramIntent.getLongExtra("relationId", 0L);
                    l2 = paramIntent.getLongExtra("friendUin", 0L);
                    if (QLog.isColorLevel()) {
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_MEMBER_LEAVE: relationType: " + i + ", relationId:" + l1 + ", friendUin:" + l2);
                    }
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l2), false);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(false);
                    paramContext = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
                  } while (paramContext == null);
                  paramContext.a("" + l2, 0, 0);
                  return;
                  if (i == 403)
                  {
                    i = paramIntent.getIntExtra("relationType", 3);
                    l1 = paramIntent.getLongExtra("relationId", 0L);
                    l2 = paramIntent.getLongExtra("friendUin", 0L);
                    if (QLog.isColorLevel()) {
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_INVITE_DESTORY-->RelationType = " + i + " ,relationId = " + l1 + " ,friendUin = " + l2);
                    }
                    paramContext = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
                    if (paramContext != null) {
                      paramContext.a("" + l2, 0, 0);
                    }
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l2), false);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(false);
                    return;
                  }
                  if (i != 405) {
                    break label1892;
                  }
                  localObject = (ArrayList)paramIntent.getExtras().getSerializable("phoneList");
                  if (localObject != null) {
                    break label1771;
                  }
                } while (!QLog.isColorLevel());
                QLog.e(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_MEMBERS_ADD_PSTN_MEMBERS --> no data");
                return;
                l1 = paramIntent.getLongExtra("relationId", -1L);
                paramContext = paramIntent.getStringExtra("sendUin");
                paramIntent = PstnUtils.a((ArrayList)localObject);
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_MEMBERS_ADD_PSTN_MEMBERS --> JsonObject = " + paramIntent);
                }
                localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
              } while (localObject == null);
              ((QCallFacade)localObject).a(1, l1, paramContext, paramIntent);
              paramContext = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
            } while ((paramContext == null) || (paramContext.a() == null));
            paramContext.a().f(String.valueOf(l1));
            return;
          } while (i != 411);
          paramContext = (ArrayList)paramIntent.getExtras().getSerializable("phoneList");
          if (paramContext != null) {
            break label1935;
          }
        } while (!QLog.isColorLevel());
        QLog.e(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> no data");
        return;
        l1 = paramIntent.getLongExtra("relationId", -1L);
        paramContext = PstnUtils.a(paramContext);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> JsonObject = " + paramContext);
        }
        paramIntent = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      } while (paramIntent == null);
      paramIntent.a(0, l1, "", paramContext);
      paramContext = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
    } while ((paramContext == null) || (paramContext.a() == null));
    paramContext.a().f(String.valueOf(l1));
  }
  
  void c(Context paramContext, Intent paramIntent)
  {
    paramIntent.getIntExtra("sessionType", 0);
    int i = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getStringExtra("peerUin");
    boolean bool2 = paramIntent.getBooleanExtra("isReceiver", false);
    boolean bool1 = paramIntent.getBooleanExtra("updateTime", false);
    boolean bool3 = paramIntent.getBooleanExtra("showTime", false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_START_DOUBLE_VIDEO_MEETING uinType: " + i + ", peerUin: " + paramContext + ", updateTime: " + bool1 + ", showTime: " + bool3);
    }
    if (bool1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, 2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, paramContext, null, bool2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, true);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l = Long.valueOf(paramContext).longValue();
    if (!bool3)
    {
      bool1 = true;
      paramIntent.a(0, l, bool1, true);
      if (i == 0)
      {
        paramIntent = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (!bool3) {
          break label298;
        }
        paramIntent.a(paramContext, i, 6);
      }
    }
    for (;;)
    {
      try
      {
        if ((MsgProxyUtils.a(paramContext, i)) || (!MsgProxyUtils.s(i))) {
          continue;
        }
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramContext, i);
        if (bool1) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        label298:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Recent User Proxy Error-->e=" + paramContext.getMessage());
        continue;
      }
      a(bool2);
      return;
      bool1 = false;
      break;
      paramIntent.a(paramContext, i, 5);
      continue;
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if ((paramIntent != null) && (paramIntent.b(paramContext, i) == null) && (!TextUtils.isEmpty(paramContext)))
      {
        paramContext = paramIntent.a(paramContext, i);
        if (paramContext != null)
        {
          paramContext.lastmsgtime = MessageCache.a();
          paramIntent.a(paramContext);
        }
      }
    }
  }
  
  void d(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sessionType", 0);
    int j = paramIntent.getIntExtra("uinType", 0);
    int k = paramIntent.getIntExtra("bindType", 0);
    String str2 = paramIntent.getStringExtra("bindId");
    paramContext = paramIntent.getStringExtra("peerUin");
    String str1 = paramIntent.getStringExtra("extraUin");
    boolean bool2 = paramIntent.getBooleanExtra("isReceiver", false);
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool4 = paramIntent.getBooleanExtra("updateTime", false);
    boolean bool3 = paramIntent.getBooleanExtra("showTime", false);
    int m = paramIntent.getIntExtra("relationType", 0);
    long l = paramIntent.getLongExtra("relationId", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_START_VIDEO_CHAT uinType: " + j + ", peerUin: " + paramContext + ", extraUin: " + str1 + ", relationType: " + m + ", relationId: " + l + ", bindType: " + k + ", bindId: " + str2 + ", updateTime: " + bool4 + ", showTime: " + bool3 + ", isDouble: " + bool1 + ", isReceiver: " + bool2);
    }
    if (j == -1) {}
    do
    {
      return;
      if (!bool1) {
        break;
      }
    } while (((paramContext == null) || (paramContext.length() <= 2)) && ((str1 == null) || (str1.length() <= 2)));
    if (bool2) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(bool2);
    }
    if (bool4)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
    }
    if (bool1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, paramContext, str1, bool2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, i);
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!bool3)
      {
        bool1 = true;
        label384:
        paramIntent.a(paramContext, bool1, bool2);
        label393:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(28, j, paramContext, str1);
        if ((j != 1) && (j != 9500) && (j != 1011) && (j != 2800))
        {
          if ((TextUtils.isEmpty(str1)) || (j != 1006)) {
            break label823;
          }
          paramIntent = str1;
          if (paramContext != null) {
            if (paramContext.indexOf("+") >= 0) {
              break label823;
            }
          }
        }
      }
    }
    label542:
    label704:
    label823:
    for (paramIntent = str1;; paramIntent = paramContext)
    {
      paramContext = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      try
      {
        paramContext.a().a(paramIntent, j).isSystemCall = 0;
        if (paramContext != null)
        {
          if ((k != 2) && (k != 3) && (j != 25)) {
            break label704;
          }
          if (bool3) {
            paramContext.a(paramIntent, 8, j, k, str2, 6);
          }
        }
        else if (j == 1008) {}
        for (;;)
        {
          try
          {
            if ((MsgProxyUtils.a(paramIntent, j)) || (!MsgProxyUtils.s(j))) {
              continue;
            }
            bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramIntent, j);
            if (bool1) {
              continue;
            }
          }
          catch (Exception paramContext)
          {
            continue;
          }
          a(bool2);
          return;
          if (l >= 100L) {
            break;
          }
          return;
          bool1 = false;
          break label384;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(m, Long.valueOf(l), true);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(m, l, i);
          paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (!bool3)
          {
            bool1 = true;
            paramContext.a(m, l, bool1, bool2);
            paramContext = String.valueOf(l);
            break label393;
          }
          bool1 = false;
          continue;
          paramContext.a(paramIntent, 8, j, k, str2, 5);
          break label542;
          if (bool3)
          {
            paramContext.a(paramIntent, j, 6);
            break label542;
          }
          if (bool2) {
            break label542;
          }
          paramContext.a(paramIntent, j, 5);
          break label542;
          if ((k != 2) && (k != 3) && (j != 25))
          {
            paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            if ((paramContext != null) && (paramContext.b(paramIntent, j) == null) && (!TextUtils.isEmpty(paramIntent)))
            {
              paramIntent = paramContext.a(paramIntent, j);
              if (paramIntent != null)
              {
                paramIntent.lastmsgtime = MessageCache.a();
                paramContext.a(paramIntent);
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  void e(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("bindType", 0);
    String str2 = paramIntent.getStringExtra("bindId");
    paramContext = paramIntent.getStringExtra("peerUin");
    String str1 = paramIntent.getStringExtra("extraUin");
    int k = paramIntent.getIntExtra("stopReason", 0);
    String str4 = paramIntent.getStringExtra("senderUin");
    String str3 = paramIntent.getStringExtra("selfUin");
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool2 = paramIntent.getBooleanExtra("isSystemCalling", false);
    int m = paramIntent.getIntExtra("relationType", 0);
    long l = paramIntent.getLongExtra("relationId", 0L);
    paramIntent.getIntExtra("sessionType", 0);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_STOP_VIDEO_CHAT uinType: " + i + ", peerUin: " + paramContext + ", extraUin: " + str1 + ", relationType: " + m + ", relationId: " + l + ", bindType: " + j + ", bindId: " + str2 + ", stopReason: " + k + ", senderUin: " + str4 + ", isSystemCall: " + bool2 + ", isDouble: " + bool1 + ", selfUin: " + str3);
    }
    if (i == 26) {
      paramContext = str1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(false);
    if ((k == 4) || (k == 6) || (k == 1)) {
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, paramContext, str1, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, 0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(28, i, paramContext, str1);
        if ((i != 1) && (i != 1011) && (i != 2800) && (i != 9500))
        {
          if ((k != 3) && (k != 4) && (k != 5) && (k != 6) && (k != 8)) {
            break label714;
          }
          if (!bool2) {
            break label647;
          }
        }
      }
    }
    label647:
    label714:
    label867:
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(m, Long.valueOf(l), false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(m, l, 0);
      break;
      if ((k == 0) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() == 3) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() == 4)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, paramContext, str1, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, 0);
        break;
      }
      if (bool1)
      {
        if ((str3 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) || (!str3.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, paramContext, str1, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, 0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(false);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(m, Long.valueOf(l), false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(m, l, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(false);
      break;
      if (i != 1008)
      {
        if (i == 0)
        {
          bool1 = false;
          if (!TextUtils.isEmpty(str3)) {
            bool1 = str3.equals(str4);
          }
          VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 1, true, paramContext, str4, bool1, null, true, new Object[0]);
          return;
        }
        a(k, str1, paramContext, str4);
        return;
        if ((k == 0) || (k == 1) || (k == 2))
        {
          if ((!TextUtils.isEmpty(str1)) && (i == 1006) && ((paramContext == null) || (paramContext.indexOf("+") < 0))) {
            paramContext = str1;
          }
          for (;;)
          {
            if ((str3 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (!str3.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
              break label867;
            }
            paramIntent = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramContext)) || (paramIntent == null)) {
              break;
            }
            if ((j == 2) || (j == 3) || (i == 25))
            {
              paramIntent.a(paramContext, 8, i, j, str2, 0);
              return;
            }
            paramIntent.a(paramContext, i, 0);
            return;
          }
        }
      }
    }
  }
  
  void f(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sessionType", 0);
    int j = paramIntent.getIntExtra("uinType", 0);
    long l = paramIntent.getLongExtra("roomId", 0L);
    String str = paramIntent.getStringExtra("peerUin");
    boolean bool = paramIntent.getBooleanExtra("isReceiver", false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_VIDEO_ANOTHER_CHATING uinType: " + j + ", peerUin: " + str + ", roomId: " + l + ", isReceiver: " + bool);
    }
    paramContext = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if ((paramContext != null) && (!paramContext.b(str)) && (i != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "other terminal chating with not friend ,ignore");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "other terminal chating with: " + str + " , sessionType: " + i + " ,uintype: " + j);
    }
    QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (i == 0)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramIntent);
      paramContext = paramIntent;
      if (localQCallFacade != null)
      {
        paramContext = paramIntent;
        if (!TextUtils.isEmpty(paramIntent))
        {
          paramContext = paramIntent;
          if (j != 1)
          {
            paramContext = paramIntent;
            if (localQCallFacade.a(paramIntent, j) == 7)
            {
              localQCallFacade.a(paramIntent, j, 0);
              paramContext = paramIntent;
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(28, j, paramContext, "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, l, i);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.a();
    }
    if ((paramContext != null) && (paramContext.b(str, 0) == null) && (!bool))
    {
      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i != 2) {
        break label463;
      }
    }
    label463:
    for (bool = true;; bool = false)
    {
      VideoMsgTools.a(paramContext, j, 53, bool, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), true, null, true, new Object[0]);
      paramContext = str;
      if (j == 1) {
        break;
      }
      paramContext = str;
      if (localQCallFacade == null) {
        break;
      }
      paramContext = str;
      if (localQCallFacade.a(str, j) == 6) {
        break;
      }
      localQCallFacade.a(str, j, 7);
      paramContext = str;
      break;
    }
  }
  
  void g(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    String str1 = paramIntent.getStringExtra("friendUin");
    String str2 = paramIntent.getStringExtra("friendName");
    String str3 = paramIntent.getStringExtra("extraUin");
    String str4 = paramIntent.getStringExtra("replyMsg");
    boolean bool = paramIntent.getBooleanExtra("isDiyMsg", false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_MSG_REPLY uinType: " + i + ", friendUin: " + str1 + ", friendNick: " + str2 + ", extraUin: " + str3 + ", replyMsg: " + str4 + ", isDiyMsg: " + bool);
    }
    if (bool)
    {
      paramContext = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
      paramContext.putExtra("uintype", i);
      paramContext.putExtra("uinname", str2);
      if (i == 1006)
      {
        paramContext.putExtra("uin", str3);
        if (!QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          break label353;
        }
        paramContext.putExtra("ext_panel_onresume", 2);
      }
      for (;;)
      {
        paramContext.putExtra("enter_ext_panel", 1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().startActivity(paramContext);
        return;
        if (i == 1000)
        {
          paramContext.putExtra("uin", str1);
          paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(str3);
          paramContext.putExtra("troop_uin", paramIntent.troopcode);
          paramContext.putExtra("troop_code", paramIntent.troopuin);
          break;
        }
        if (i == 1004)
        {
          paramContext.putExtra("uin", str1);
          paramContext.putExtra("troop_uin", str3);
          break;
        }
        paramContext.putExtra("uin", str1);
        break;
        label353:
        paramContext.putExtra("ext_panel_onresume", 1);
      }
    }
    new Handler(Looper.getMainLooper()).postDelayed(new qhw(this, i, str2, str3, str1, paramContext, str4), 300L);
  }
  
  void h(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("isPtt", false);
    int i = paramIntent.getIntExtra("uinType", 0);
    Object localObject = paramIntent.getStringExtra("friendUin");
    String str = paramIntent.getStringExtra("friendName");
    paramIntent = paramIntent.getStringExtra("extraUin");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_MSG_LEAVE uinType: " + i + ", friendUin: " + (String)localObject + ", friendNick: " + str + ", extraUin: " + paramIntent + ", isPtt: " + bool);
    }
    paramContext = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
    paramContext.putExtra("uintype", i);
    paramContext.putExtra("uinname", str);
    if (i == 1006)
    {
      paramContext.putExtra("uin", paramIntent);
      if (!QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label366;
      }
      paramContext.putExtra("ext_panel_onresume", 2);
      label200:
      if (!bool) {
        break label378;
      }
      paramContext.putExtra("enter_ext_panel", 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().startActivity(paramContext);
      do
      {
        return;
        if (i != 1000) {
          break label325;
        }
        paramContext.putExtra("uin", (String)localObject);
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramIntent);
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "findTroopInfo fail ,uin : " + paramIntent);
      return;
      paramContext.putExtra("troop_uin", ((TroopInfo)localObject).troopuin);
      paramContext.putExtra("troop_code", ((TroopInfo)localObject).troopcode);
      break;
      label325:
      if (i == 1004)
      {
        paramContext.putExtra("uin", (String)localObject);
        paramContext.putExtra("troop_uin", paramIntent);
        break;
      }
      paramContext.putExtra("uin", (String)localObject);
      break;
      label366:
      paramContext.putExtra("ext_panel_onresume", 1);
      break label200;
      label378:
      paramContext.putExtra("enter_ext_panel", 1);
    }
  }
  
  void i(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("size", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_VIDEO_FLOW_SIZE: " + l);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), new String[] { "param_XGVideoFlow", "param_XGFlow", "param_Flow" }, l);
  }
  
  void j(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getStringExtra("peerUin");
    String str = paramIntent.getStringExtra("extraUin");
    paramIntent = paramIntent.getByteArrayExtra("sig");
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramContext, str, paramIntent);
  }
  
  void k(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("peerUin");
    int i = paramIntent.getIntExtra("sessionType", 0);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_START_VIDEO_AVSWITCH sessionType: " + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, i);
  }
  
  void l(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_CALLING_DIALOG");
    }
    boolean bool1 = paramIntent.getBooleanExtra("isAudio", false);
    String str1 = paramIntent.getStringExtra("friendUin");
    int j = paramIntent.getIntExtra("uinType", 0);
    int k = paramIntent.getIntExtra("type", 0);
    String str2 = paramIntent.getStringExtra("senderUin");
    boolean bool2 = paramIntent.getBooleanExtra("isSender", false);
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363705);
    paramIntent = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
    paramContext = paramIntent;
    if (paramIntent.length() > 10) {
      paramContext = paramIntent.substring(0, 4) + "...";
    }
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (bool1) {}
    for (int i = 2131363706;; i = 2131363707)
    {
      paramContext = String.format(paramIntent.getString(i), new Object[] { paramContext });
      paramContext = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), 230, str3, paramContext, 2131367262, 2131363540, new qhx(this, j, k, bool1, str1, str2, bool2), null);
      paramContext.getWindow().setType(2003);
      paramContext.show();
      DataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause, bool1);
      new Handler(Looper.getMainLooper()).postDelayed(new qhy(this, paramContext, j, bool1, str1, str2, bool2), 10000L);
      return;
    }
  }
  
  void m(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_CALLING_DIALOG_MULTI");
    }
    String str1 = String.valueOf(paramIntent.getLongExtra("friendUin", 0L));
    String str2 = String.valueOf(paramIntent.getLongExtra("discussId", 0L));
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("type", 0);
    String str3 = paramIntent.getStringExtra("realSenderUin");
    paramIntent = paramIntent.getStringExtra("peerUin");
    String str4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363705);
    if (i == 3000) {
      paramContext = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
    }
    for (;;)
    {
      paramContext = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363708), new Object[] { paramContext });
      paramContext = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), 230, str4, paramContext, 2131367262, 2131363540, new qhz(this, i, j, str2, str1, paramIntent, str3), null);
      paramContext.getWindow().setType(2003);
      paramContext.show();
      DataReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause);
      new Handler(Looper.getMainLooper()).postDelayed(new qia(this, paramContext, i, j, str2, str1, paramIntent, str3), 10000L);
      return;
      if (i == 1) {
        paramContext = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, str2);
      } else {
        paramContext = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      }
    }
  }
  
  void n(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("msgType", 5);
    paramIntent.getIntExtra("bindType", 0);
    paramIntent.getStringExtra("bindId");
    boolean bool1 = paramIntent.getBooleanExtra("isVideoMsg", true);
    paramContext = paramIntent.getStringExtra("friendUin");
    String str = paramIntent.getStringExtra("senderUin");
    boolean bool2 = paramIntent.getBooleanExtra("isSender", true);
    boolean bool3 = paramIntent.getBooleanExtra("isRead", false);
    paramIntent = paramIntent.getStringExtra("extra");
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, j, bool1, paramContext, str, bool2, paramIntent, bool3);
    bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368465), "qqsetting_notify_showcontent_key", true);
    if (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
    {
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369618), "qqsetting_lock_screen_whenexit_key", true);
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368465), "qqsetting_notify_showcontent_key", true);
    }
    for (;;)
    {
      if ((bool2) && (bool1))
      {
        ((QQLSRecentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(71)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, 8, true);
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  videoMsgReceiver");
        }
      }
      return;
      bool2 = false;
    }
  }
  
  void o(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("bindType", 0);
    int j = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getByteArrayExtra("sig");
    String str = paramIntent.getStringExtra("peerUin");
    paramIntent = paramIntent.getStringExtra("phoneNum");
    QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if ((localQCallFacade != null) && ((i == 2) || (i == 3) || (j == 25))) {
      localQCallFacade.a(str, 8, paramContext, paramIntent);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName()))) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + (String)localObject1);
      }
    }
    label1831:
    label2254:
    label2338:
    label2345:
    do
    {
      do
      {
        Object localObject3;
        Object localObject2;
        do
        {
          do
          {
            do
            {
              long l;
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
                              do
                              {
                                return;
                                if (((String)localObject1).equals("tencent.video.v2q.AddVideoMsg"))
                                {
                                  a(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.VideoFlowSize"))
                                {
                                  i(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.MultiVideo"))
                                {
                                  b(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.StartDoubleVideoMeeting"))
                                {
                                  c(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.StartVideoChat"))
                                {
                                  d(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.StopVideoChat"))
                                {
                                  e(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.AvSwitch"))
                                {
                                  k(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.AnotherTerChating"))
                                {
                                  f(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.AddMsgSig"))
                                {
                                  j(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.CallingDialog"))
                                {
                                  l(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.CallingDialogMulti"))
                                {
                                  m(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.setChatStatus"))
                                {
                                  p(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.updateChatInfo"))
                                {
                                  q(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.downloadAvSo"))
                                {
                                  r(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.AddLightalkMsg"))
                                {
                                  n(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.AddLightalkSig"))
                                {
                                  o(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.CheckChatAbility"))
                                {
                                  t(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.downloadGAudioSound"))
                                {
                                  s(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.c2b.action.REQUEST_LOCATION"))
                                {
                                  C2BLBSHelper.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("qq.process.msg.uploadfile"))
                                {
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new qid(this, paramContext, paramIntent));
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.AddContactsToDiscuss"))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d(jdField_a_of_type_JavaLangString, 2, "addDiscussMember");
                                  }
                                  localObject3 = paramIntent.getStringExtra("discussUin");
                                  i = paramIntent.getIntExtra("uiFlag", 0);
                                  paramContext = null;
                                  if (paramIntent.getSerializableExtra("notAcceptUserList") != null) {
                                    paramContext = (ArrayList)paramIntent.getSerializableExtra("notAcceptUserList");
                                  }
                                  localObject1 = null;
                                  if (paramIntent.getSerializableExtra("notAcceptPhoneList") != null) {
                                    localObject1 = (ArrayList)paramIntent.getSerializableExtra("notAcceptPhoneList");
                                  }
                                  localObject2 = null;
                                  if (paramIntent.getSerializableExtra("pstnInRoomPhoneList") != null) {
                                    localObject2 = (ArrayList)paramIntent.getSerializableExtra("pstnInRoomPhoneList");
                                  }
                                  boolean bool = paramIntent.getBooleanExtra("selectNotAcceptFlag", false);
                                  VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, i, paramContext, (ArrayList)localObject1, (ArrayList)localObject2, bool);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.MeetingMemberManager"))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d(jdField_a_of_type_JavaLangString, 2, "openMeetingMembers");
                                  }
                                  paramContext = paramIntent.getStringExtra("discussUin");
                                  VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.AddContactsFromC2C"))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d(jdField_a_of_type_JavaLangString, 2, "addDiscussMemberFromC2C");
                                  }
                                  paramContext = paramIntent.getStringExtra("peerUin");
                                  VideoMsgTools.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.replyMsg"))
                                {
                                  g(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.leaveMsg"))
                                {
                                  h(paramContext, paramIntent);
                                  return;
                                }
                                if (!((String)localObject1).equals("tencent.video.v2q.AudioEngineReady")) {
                                  break;
                                }
                                paramContext = paramIntent.getStringExtra("peerUin");
                                l = paramIntent.getLongExtra("roomId", 0L);
                              } while ((l == 0L) || (paramContext == null));
                              if (QLog.isColorLevel()) {
                                QLog.d(jdField_a_of_type_JavaLangString, 2, "<qav printer> message send: cmd[0x211, 0xb]");
                              }
                              paramIntent = (VideoC2CHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(39);
                              paramIntent.b = paramContext;
                              paramIntent.a = l;
                              paramIntent.a();
                              return;
                              if (((String)localObject1).equals("tencent.video.v2q.GaudioOpenTroopCard"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_GAUDIO_TROOP_CARD");
                                }
                                localObject2 = paramIntent.getStringExtra("troopUin");
                                localObject1 = paramIntent.getStringExtra("memberUin");
                                if (paramIntent.getIntExtra("UinType", -1) == 3000)
                                {
                                  if (((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
                                  {
                                    paramIntent = new ProfileActivity.AllInOne((String)localObject1, 0);
                                    paramIntent.jdField_f_of_type_Int = 5;
                                    ProfileActivity.b(paramContext, paramIntent);
                                    return;
                                  }
                                  if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b((String)localObject1))
                                  {
                                    paramIntent = new ProfileActivity.AllInOne((String)localObject1, 1);
                                    paramIntent.h = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, 0);
                                    paramIntent.jdField_f_of_type_Int = 5;
                                    ProfileActivity.b(paramContext, paramIntent);
                                    return;
                                  }
                                  paramIntent = new ProfileActivity.AllInOne((String)localObject1, 46);
                                  paramIntent.h = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, 0);
                                  paramIntent.jdField_f_of_type_JavaLangString = ((String)localObject1);
                                  paramIntent.jdField_e_of_type_Int = 3000;
                                  paramIntent.jdField_e_of_type_JavaLangString = ((String)localObject2);
                                  paramIntent.jdField_f_of_type_Int = 5;
                                  ProfileActivity.b(paramContext, paramIntent);
                                  return;
                                }
                                paramContext = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), TroopMemberCardActivity.class);
                                paramContext.addFlags(268435456);
                                paramContext.putExtra("troopUin", (String)localObject2);
                                paramContext.putExtra("memberUin", (String)localObject1);
                                paramContext.putExtra("fromFlag", 0);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().startActivity(paramContext);
                                return;
                              }
                              if (((String)localObject1).equals("tencent.video.v2q.BindContact"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_BIND_CONTACT from qav");
                                }
                                paramContext = new Intent(paramContext, BindNumberActivity.class);
                                paramContext.putExtra("kNeedUnbind", true);
                                paramContext.addFlags(268435456);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().startActivity(paramContext);
                                return;
                              }
                              if (((String)localObject1).equals("tencent.video.v2q.OpenContactList"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_OPEN_CONTACT_LIST from qav");
                                }
                                paramContext = new Intent(paramContext, PhoneFrameActivity.class);
                                paramContext.putExtra("key_req_type", 0);
                                paramContext.addFlags(268435456);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().startActivity(paramContext);
                                return;
                              }
                              if (!((String)localObject1).equals("tencent.video.v2q.AnnimateDownloadStart")) {
                                break;
                              }
                              i = paramIntent.getIntExtra("callId", 0);
                            } while (i <= 0);
                            paramContext = (VipFunCallManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83);
                          } while (paramContext == null);
                          paramContext.a(i, VipFunCallManager.a(), false, 0);
                          return;
                          if (!((String)localObject1).equals("tencent.video.v2q.commingRingDownload")) {
                            break;
                          }
                          i = paramIntent.getIntExtra("comming_ring_down_key", 0);
                        } while (i <= 0);
                        ((ColorRingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(i, 3, false, 0, "comering");
                        int j = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).h();
                        ReportController.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, 0, "" + j, i + "", "", "");
                        return;
                        if (((String)localObject1).equals("chatbgBroadcast"))
                        {
                          localObject1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                          paramIntent = paramIntent.getStringExtra("friendUin");
                          ChatBackground.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramIntent, (String)localObject1);
                          return;
                        }
                        if (!((String)localObject1).equals("tencent.video.v2q.insertSystemCall")) {
                          break;
                        }
                        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                      } while (localObject1 == null);
                      paramIntent = paramIntent.getStringExtra("phoneNumber");
                      paramContext = paramIntent;
                      if (paramIntent != null)
                      {
                        paramContext = paramIntent;
                        if (!paramIntent.startsWith("+")) {
                          paramContext = "+86" + paramIntent;
                        }
                      }
                      ((QCallFacade)localObject1).b(paramContext);
                      return;
                      if (((String)localObject1).equals("tencent.video.v2q.upgradeInvite"))
                      {
                        paramContext = paramIntent.getStringExtra("peerUin");
                        i = paramIntent.getIntExtra("type", 0);
                        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, i);
                        return;
                      }
                      if (!((String)localObject1).equals("tencent.video.v2q.SmallScreenState")) {
                        break;
                      }
                      i = paramIntent.getIntExtra("SmallScreenState", 0);
                      paramContext = paramIntent.getStringExtra("peerUin");
                      if (QLog.isColorLevel()) {
                        QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_SMALL_SCREEN_STATE smallScreenState : " + i);
                      }
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(i);
                    } while (TextUtils.isEmpty(paramContext));
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramContext);
                    return;
                    if (!((String)localObject1).equals("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO")) {
                      break;
                    }
                    paramContext = new HashMap();
                    paramContext.put("MultiAVType", String.valueOf(2));
                    paramContext.put("enterType", paramIntent.getIntExtra("enterType", 0) + "");
                  } while (BaseActivity.sTopActivity == null);
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseActivity.sTopActivity, 1, paramIntent.getStringExtra("relationId"), true, true, null, paramContext);
                  return;
                  if (!((String)localObject1).equals("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO")) {
                    break label1831;
                  }
                  paramContext = paramIntent.getStringExtra("relationId");
                  l = paramIntent.getLongExtra("friendUin", 0L);
                  if (l != 0L) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO, inviterUin:" + l);
                return;
                localObject1 = paramIntent.getStringExtra("inviteId");
                i = paramIntent.getIntExtra("dealResult", 1);
                ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramContext, l, (String)localObject1, i);
                paramIntent = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              } while (paramIntent == null);
              paramIntent.d(paramContext, l + "");
              return;
              if (!((String)localObject1).equals("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END")) {
                break;
              }
              paramContext = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            } while (paramContext == null);
            paramContext.d(paramIntent.getStringExtra("relationId"), paramIntent.getStringExtra("inviterUin"));
            return;
            if (!((String)localObject1).equals("tencent.video.v2q.generalFuncCall")) {
              break;
            }
          } while (!"SEND_STRUCT_MSG".equals(paramIntent.getStringExtra("func")));
          paramContext = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
        } while (paramContext == null);
        localObject1 = paramIntent.getStringExtra("uin");
        int i = paramIntent.getIntExtra("uintype", -1);
        ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i, paramContext, null);
        return;
        Object localObject4;
        if (((String)localObject1).equals("tencent.av.v2q.CancelCallBack"))
        {
          paramContext = paramIntent.getStringExtra("fromPhone");
          localObject1 = paramIntent.getStringExtra("toPhone");
          localObject2 = paramIntent.getStringExtra("fromUin");
          i = paramIntent.getIntExtra("uinType", 0);
          localObject3 = paramIntent.getStringExtra("toUin");
          paramIntent = paramIntent.getStringExtra("callBackId");
          localObject4 = (PstnHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(82);
          ((PstnHandler)localObject4).a(paramContext, (String)localObject1, (String)localObject2, i, (String)localObject3, paramIntent);
          ((PstnHandler)localObject4).a(6, true, null);
          return;
        }
        if (((String)localObject1).equals("tencent.av.v2q.ip2Pstn"))
        {
          localObject1 = new Intent(paramContext, QCallStartBrigeActivity.class);
          ((Intent)localObject1).putExtras(paramIntent);
          ((Intent)localObject1).putExtra("param_from_type", 2);
          ((Intent)localObject1).addFlags(268435456);
          paramContext.startActivity((Intent)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006406", "0X8006406", 3, 0, "", "", "", "");
          return;
        }
        if (((String)localObject1).equals("tencent.av.v2q.multiPsntTryEnd"))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131372506);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131372507);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131372508);
          localObject4 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
          String str2 = ((PstnManager)localObject4).a("key_pstn_multi_try_over_recharge_title");
          String str1 = ((PstnManager)localObject4).a("key_pstn_multi_try_over_recharge_content");
          localObject4 = ((PstnManager)localObject4).a("key_pstn_multi_try_over_recharge_confirm_text");
          if (TextUtils.isEmpty(str2))
          {
            if (!TextUtils.isEmpty(str1)) {
              break label2338;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              break label2345;
            }
          }
          for (;;)
          {
            localObject4 = new Intent(paramContext, SysCallTransparentActivity.class);
            ((Intent)localObject4).addFlags(268435456);
            ((Intent)localObject4).putExtra("pstn_dialog_type", 3);
            ((Intent)localObject4).putExtra("pstn_guide_title", (String)localObject1);
            ((Intent)localObject4).putExtra("pstn_guide_content", (String)localObject2);
            paramIntent.putExtra("pstn_guide_confirm", (String)localObject3);
            paramContext.startActivity((Intent)localObject4);
            return;
            localObject1 = str2;
            break;
            localObject2 = str1;
            break label2254;
            localObject3 = localObject4;
          }
        }
      } while (!((String)localObject1).equals("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED"));
      paramContext = (NowProxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    } while (paramContext == null);
    paramContext.b();
  }
  
  void p(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("status", 0);
    int j = paramIntent.getIntExtra("type", 0);
    long l = paramIntent.getLongExtra("guild_group_id", -1L);
    int k = paramIntent.getIntExtra("guild_member_num", -1);
    paramContext = paramIntent.getStringExtra("sessionName");
    String str1 = paramIntent.getStringExtra("guild_business_type");
    String str2 = paramIntent.getStringExtra("uin");
    String str3 = paramIntent.getStringExtra("nickName");
    paramIntent = paramIntent.getStringExtra("headUrl");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_RANDOM_SET_CHAT_STATUS status:" + i + ", type" + j);
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(-1L);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(-1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, j);
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext);
      }
      if (!TextUtils.isEmpty(str2)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str2, str3, paramIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str1);
    }
  }
  
  void q(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("uin");
    String str = paramIntent.getStringExtra("nickName");
    paramIntent = paramIntent.getStringExtra("headUrl");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_RANDOM_UPDATE_CHAT_INFO uin:" + paramContext + ", nickName: " + str + ", headUrl: " + paramIntent);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, str, paramIntent);
    }
  }
  
  void r(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "EarlyDownload trigger AV so EarlyDownload");
    }
    paramContext = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    if (paramContext != null)
    {
      paramIntent = (QavSoDownloadHandler)paramContext.a("qq.android.qav.so");
      if (paramIntent != null) {
        paramIntent.a(false);
      }
      paramContext = (QavSoDownloadHandlerV7)paramContext.a("qq.android.qav.sov7");
      if (paramContext != null) {
        paramContext.a(false);
      }
    }
  }
  
  void s(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "EarlyDownload trigger AV so EarlyDownload");
    }
    paramContext = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    if (paramContext != null)
    {
      paramContext = (QavGAudioSoundHandler)paramContext.a("qq.android.qav.muteaudio");
      if (paramContext != null) {
        paramContext.a(false);
      }
    }
  }
  
  void t(Context paramContext, Intent paramIntent)
  {
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363529);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363525);
    paramContext = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), 230, paramIntent, paramContext, 2131367262, 2131363540, new qib(this), null);
    paramContext.getWindow().setType(2003);
    paramContext.show();
    new Handler(Looper.getMainLooper()).postDelayed(new qic(this, paramContext), 5000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\VideoBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */