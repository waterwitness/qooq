package com.tencent.mobileqq.structmsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter.HistoryStructItemHolder;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.NearbyFlowerInfoActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12.ViewHolder;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.TroopCommentBrowser;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class StructMsgForGeneralShare$GeneralClickHandler
  extends StructMsgClickHandler
{
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  StructMsgForGeneralShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
  
  public StructMsgForGeneralShare$GeneralClickHandler(View paramView)
  {
    super(paramView);
  }
  
  public StructMsgForGeneralShare$GeneralClickHandler(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramQQAppInterface, paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StructMsgForGeneralShare$GeneralClickHandler(QQAppInterface paramQQAppInterface, View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    super(paramQQAppInterface, paramView);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare = paramStructMsgForGeneralShare;
    paramQQAppInterface = paramView.getTag();
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructingMsgItemBuilder.StructingMsgViewHolder)))
    {
      paramQQAppInterface = (StructingMsgItemBuilder.StructingMsgViewHolder)paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    }
    while ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof ChatHistoryStructAdapter.HistoryStructItemHolder))) {
      return;
    }
    paramQQAppInterface = (ChatHistoryStructAdapter.HistoryStructItemHolder)paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)paramQQAppInterface.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramQQAppInterface.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a(View paramView, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramView = (StructMsgItemLayout12.ViewHolder)paramView.findViewById(2131296514).getTag();
    if (paramView == null) {
      return false;
    }
    paramView = paramView.a;
    String str;
    boolean bool2;
    if ((paramView != null) && (paramView.size() > 0))
    {
      str = paramView.getString("groupCode");
      boolean bool1 = paramView.getBoolean("isSend");
      bool2 = paramView.getBoolean("isReceive");
      if ((!bool1) && (!TextUtils.isEmpty(str)) && (str.equals(paramString)) && (!bool2))
      {
        paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if (paramView != null) {}
        for (paramView = paramView.a(paramString);; paramView = null)
        {
          if (paramView != null) {
            ChatSettingForHotChat.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, 1);
          }
          return true;
        }
      }
      paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyFlowerInfoActivity.class);
      paramString.putExtra("data", paramView);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      if (!bool1) {
        break label214;
      }
      if (TextUtils.isEmpty(str)) {
        break label202;
      }
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006390");
    }
    for (;;)
    {
      return true;
      label202:
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80060B3");
      continue;
      label214:
      if (bool2) {
        if (!TextUtils.isEmpty(str)) {
          NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006391");
        } else {
          NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80060B4");
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickWebMsg url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    StructMsgForGeneralShare localStructMsgForGeneralShare = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
    Object localObject1 = paramString.trim();
    boolean bool = ((String)localObject1).startsWith("http://gamecenter.qq.com");
    long l = AppShareIDUtil.a(localStructMsgForGeneralShare.mSourceAppid);
    Object localObject2 = localQQAppInterface.a();
    if ((localContext instanceof FragmentActivity))
    {
      localObject3 = ((FragmentActivity)localContext).getChatFragment();
      if (localObject3 != null)
      {
        localObject3 = ((ChatFragment)localObject3).a();
        if ((localObject3 instanceof PublicAccountChatPie))
        {
          PublicAccountChatPie localPublicAccountChatPie = (PublicAccountChatPie)localObject3;
          localPublicAccountChatPie.ec += 1;
          localObject3 = (PublicAccountChatPie)localObject3;
          ((PublicAccountChatPie)localObject3).ea += 1;
        }
      }
    }
    if (StructingMsgItemBuilder.a(localQQAppInterface, (ChatMessage)localStructMsgForGeneralShare.message))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopCommentBrowser.class);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).putExtra("url", paramString);
      ((Intent)localObject1).putExtra("troopUin", localStructMsgForGeneralShare.message.frienduin);
      ((Intent)localObject1).putExtra("articalChannelId", 3);
      if ((localStructMsgForGeneralShare.message instanceof MessageForStructing)) {
        ((Intent)localObject1).putExtra("msgseq", ((MessageForStructing)localStructMsgForGeneralShare.message).shmsgseq);
      }
      localObject2 = ((TroopTopicMgr)localQQAppInterface.getManager(97)).a((ChatMessage)localStructMsgForGeneralShare.message);
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("is_zan", ((TroopTopicDetailInfo)localObject2).mIsZan);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      try
      {
        localObject1 = new URL(paramString).getHost();
        ReportController.b(localQQAppInterface, "dc00899", "Grp_talk", "", "obj", "link_detail", 0, 0, "" + localStructMsgForGeneralShare.message.frienduin, (String)localObject1, "", URLEncoder.encode(paramString, "utf-8"));
        return true;
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(StructMsgForGeneralShare.access$000(), 2, "isDomainInWhiteList exception: " + paramString.getMessage());
          }
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(StructMsgForGeneralShare.access$000(), 2, "isDomainInWhiteList exception: " + paramString.getMessage());
          }
        }
      }
    }
    Object localObject3 = new Intent(localContext, QQBrowserDelegationActivity.class);
    ((Intent)localObject3).putExtra("param_force_internal_browser", true);
    if (bool) {}
    for (paramString = HtmlOffline.a((String)localObject1, "platformId=qq_m");; paramString = (String)localObject1)
    {
      paramString = paramString.trim();
      ((Intent)localObject3).putExtra("injectrecommend", false);
      ((Intent)localObject3).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject3).putExtra("url", paramString);
      ((Intent)localObject3).putExtra("friendUin", localStructMsgForGeneralShare.uin);
      ((Intent)localObject3).putExtra("isAppShare", true);
      ((Intent)localObject3).putExtra("appShareID", l);
      ((Intent)localObject3).putExtra("uin_type", localStructMsgForGeneralShare.uinType);
      ((Intent)localObject3).putExtra("msg_id", Long.toString(localStructMsgForGeneralShare.msgId));
      ((Intent)localObject3).putExtra("puin", localStructMsgForGeneralShare.uin);
      ((Intent)localObject3).putExtra("self_uin", (String)localObject2);
      ((Intent)localObject3).putExtra("source_puin", localStructMsgForGeneralShare.source_puin);
      if (localStructMsgForGeneralShare.uinType == 0)
      {
        ((Intent)localObject3).putExtra("articalChannelId", 2);
        AIOOpenWebMonitor.a((Intent)localObject3, localQQAppInterface, localStructMsgForGeneralShare.message);
        if ((PublicAccountUtil.a(localQQAppInterface, localStructMsgForGeneralShare.uin) != -1) || (paramString.startsWith("http://browserApp.p.qq.com/")))
        {
          ((Intent)localObject3).setClass(localContext, PublicAccountBrowser.class);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("uin", localStructMsgForGeneralShare.uin);
          ((Bundle)localObject1).putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          ((Bundle)localObject1).putString("uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          ((Bundle)localObject1).putBoolean("switch_msg_btn", PublicAccountUtil.a());
          ((Intent)localObject3).putExtras((Bundle)localObject1);
        }
        if (localStructMsgForGeneralShare.mSourceAppid == 1101244924L)
        {
          ((Intent)localObject3).putExtra("BUDNLE_KEY_IS_MY_PROFILE", paramString.contains("gene/index.html?uin=" + localStructMsgForGeneralShare.currentAccountUin));
          ((Intent)localObject3).setClass(localContext, MusicGeneQQBrowserActivity.class);
        }
        PublicAccountUtil.a(localStructMsgForGeneralShare.message, (Intent)localObject3, paramString);
        WebAccelerator.a(localContext, (Intent)localObject3, paramString);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString, "", "", "");
        ReportController.b(null, "CliOper", "", "", "0X80061B0", "0X80061B0", 0, 0, "", "", "", "");
        if (!bool) {
          break label1071;
        }
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, (String)localObject2, "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(localStructMsgForGeneralShare.mSourceAppid), null, null, null);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.istroop == 1008)) {
          PublicAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
        }
        return true;
        if (localStructMsgForGeneralShare.uinType == 1)
        {
          ((Intent)localObject3).putExtra("articalChannelId", 3);
          break;
        }
        if (localStructMsgForGeneralShare.uinType == 3000)
        {
          ((Intent)localObject3).putExtra("articalChannelId", 4);
          break;
        }
        if (localStructMsgForGeneralShare.uinType != 1008) {
          break;
        }
        ((Intent)localObject3).putExtra("articalChannelId", 1);
        ((Intent)localObject3).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
        break;
        label1071:
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, "sha_click", 1, "", "", String.valueOf(localStructMsgForGeneralShare.mSourceAppid));
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
          if (52 == localStructMsgForGeneralShare.mMsgServiceID) {
            if (paramString.equals(localObject2)) {
              ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80052BB", "0X80052BB", 0, 0, "", "", "", "");
            } else {
              ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80052BC", "0X80052BC", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {}
    paramString2 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
    int i = paramString2.getChatFragment().a().b();
    paramString3 = paramString2.getChatFragment().a().b();
    String str = paramString2.getChatFragment().a().a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("open_chatfragment", true);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", paramString3);
    localIntent.putExtra("video_play_url", paramString1);
    localIntent.putExtra("video_play_msg", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uniseq);
    ((TroopChatPie)paramString2.getChatFragment().a()).k(localIntent);
    if (i == 1008) {
      PublicAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
    }
    return true;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickPluginMsg actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString1 = JumpParser.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.istroop == 1008)) {
        PublicAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
      }
      return true;
      paramString1 = paramString2;
    }
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralShareMsg _ACTION_PLUGIN_ mContentOnClickListener: JumpAction is null.");
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgForGeneralShare$GeneralClickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */