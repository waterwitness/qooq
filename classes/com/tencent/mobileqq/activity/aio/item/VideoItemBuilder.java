package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.C2BUtils;
import java.util.HashMap;
import java.util.Map;
import nsi;
import nsj;
import nsm;
import nsn;
import nso;

public class VideoItemBuilder
  extends BaseBubbleBuilder
{
  private static final int h = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private static final int i = BaseChatItemLayout.l + BaseChatItemLayout.q;
  private static final int j = BaseChatItemLayout.m + BaseChatItemLayout.r;
  private static final int k = BaseChatItemLayout.n + BaseChatItemLayout.s;
  private View.OnClickListener a;
  private boolean d = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nsi(this);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int m = localDrawable.getIntrinsicWidth();
    int n = localDrawable.getIntrinsicHeight();
    switch (this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      paramInt = n;
    }
    for (;;)
    {
      localDrawable.setBounds(0, 0, m, paramInt);
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.u);
      return;
      int i1 = localResources.getDimensionPixelSize(2131493907);
      int i2 = localResources.getDimensionPixelSize(2131493908);
      paramInt = i1;
      if (i1 == 0) {
        paramInt = 1;
      }
      m = m * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int / paramInt;
      paramInt = n * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int / paramInt + i2;
      m += i2;
    }
  }
  
  private void a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    int n = 0;
    Object localObject1 = "";
    if (paramMessageForVideo == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgAccDescription-->message is null");
      }
    }
    do
    {
      return;
      if ((paramMessageForVideo.senderuin != null) && (paramMessageForVideo.selfuin != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgAccDescription-->uin is null");
    return;
    Object localObject2;
    label124:
    int i1;
    int m;
    if (paramMessageForVideo.selfuin.equals(paramMessageForVideo.senderuin))
    {
      if (63520 == paramMessageForVideo.msgtype) {
        localObject1 = "我";
      }
      localObject2 = localObject1;
      if (paramMessageForVideo.msgtype == 63527)
      {
        localObject2 = new StringBuilder().append((String)localObject1);
        if (!paramMessageForVideo.isVideo) {
          break label462;
        }
        localObject1 = "视频电话,";
        localObject2 = (String)localObject1;
      }
      localObject1 = (String)localObject2 + paramMessageForVideo.text;
      if (!paramMessageForVideo.text.contains(paramContext.getResources().getString(2131363323))) {
        break label514;
      }
      localObject2 = paramMessageForVideo.text;
      paramContext = paramContext.getResources().getString(2131363323) + ",";
      localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(':') - 2, ((String)localObject2).lastIndexOf(':') + 3).split(":");
      if (localObject2.length != 3) {
        break label470;
      }
      i1 = Integer.valueOf(localObject2[0]).intValue();
      n = Integer.valueOf(localObject2[1]).intValue();
      m = Integer.valueOf(localObject2[2]).intValue();
    }
    for (;;)
    {
      label286:
      if ((i1 > 0) || (n > 0) || (m > 0)) {
        if (i1 <= 0) {
          break label640;
        }
      }
      label410:
      label462:
      label470:
      label514:
      label640:
      for (localObject1 = paramContext + i1 + "小时,";; localObject1 = paramContext)
      {
        paramContext = (Context)localObject1;
        if (n > 0) {
          paramContext = (String)localObject1 + n + "分,";
        }
        localObject1 = paramContext;
        if (m > 0) {
          localObject1 = paramContext + m + "秒";
        }
        if (paramMessageForVideo.isVideo)
        {
          paramMessageForVideo = "视频电话,";
          localObject1 = paramMessageForVideo + (String)localObject1;
        }
        for (;;)
        {
          paramView.setContentDescription(((String)localObject1).replace("点击", "双击"));
          return;
          localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForVideo.senderuin, 0);
          break;
          localObject1 = "QQ电话,";
          break label124;
          if (localObject2.length != 2) {
            break label646;
          }
          n = Integer.valueOf(localObject2[0]).intValue();
          m = Integer.valueOf(localObject2[1]).intValue();
          i1 = 0;
          break label286;
          paramMessageForVideo = "QQ电话,";
          break label410;
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131363327)))
          {
            paramContext = paramContext.getResources();
            if (paramMessageForVideo.isVideo) {}
            for (m = 2131363421;; m = 2131363357)
            {
              localObject1 = paramContext.getString(m);
              break;
            }
          }
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131363242))) {
            localObject1 = paramContext.getResources().getString(2131363249);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131363248))) {
            localObject1 = paramContext.getResources().getString(2131363249);
          }
        }
      }
      label646:
      m = 0;
      i1 = 0;
    }
  }
  
  private void a(MessageForVideo paramMessageForVideo, VideoActionSheet paramVideoActionSheet)
  {
    paramVideoActionSheet.c(2131363948);
    paramVideoActionSheet.c(2131363949);
    paramVideoActionSheet.d(2131367262);
    paramVideoActionSheet.a(new nsj(this, paramVideoActionSheet, paramMessageForVideo));
    paramVideoActionSheet.show();
  }
  
  private void a(MessageForVideo paramMessageForVideo, boolean paramBoolean, int paramInt)
  {
    if ((!VcSystemInfo.e()) || (!VcSystemInfo.f()) || (VideoActionSheet.a())) {}
    VideoActionSheet localVideoActionSheet;
    do
    {
      return;
      localVideoActionSheet = VideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
      if (!paramBoolean) {
        break;
      }
      if (paramInt == 1)
      {
        a(paramMessageForVideo, localVideoActionSheet);
        return;
      }
    } while (paramInt != 3000);
    b(paramMessageForVideo, localVideoActionSheet);
    return;
    c(paramMessageForVideo, localVideoActionSheet);
  }
  
  private void a(boolean paramBoolean, MessageForVideo paramMessageForVideo)
  {
    Object localObject;
    long l;
    if (paramBoolean)
    {
      localObject = new HashMap();
      ((Map)localObject).put("MultiAVType", String.valueOf(paramMessageForVideo.extInt));
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, (Map)localObject);
      l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != l) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
        }
      }
    }
    label245:
    String str1;
    String str2;
    label388:
    label453:
    label490:
    int m;
    label707:
    label740:
    label751:
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(1, l)));
      if (paramMessageForVideo.extInt == 10)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == 0L)
        {
          paramMessageForVideo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, 10);
          if ((paramMessageForVideo == null) || (paramMessageForVideo.jdField_a_of_type_Int <= 0)) {
            break label245;
          }
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005DC6", "0X8005DC6", 0, 0, "", "", "", "");
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005925", "0X8005925", 0, 0, "", "", "", "");
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046CB", "0X80046CB", 0, 0, "", "", "", "");
      return;
      if (!paramMessageForVideo.isVideo)
      {
        str1 = "Two_call";
        str2 = "Two_call_launch";
        switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
        {
        default: 
          localObject = "0";
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str2, 0, 0, (String)localObject, "", "", "");
          if (paramMessageForVideo.type == 2)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
            if (!paramMessageForVideo.isVideo) {
              break label707;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005643", "0X8005643", 0, 0, "", "", "", "");
            localObject = null;
            str1 = null;
            m = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
            str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
            if (m != 1006) {
              break label740;
            }
            str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          }
          break;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1024) {
          break label796;
        }
        if (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          break label751;
        }
        CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "IvrAIOMessageEngineFalse");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004655", "0X8004655", 0, 0, "", "", "", "");
        return;
        str1 = "Two_video_call";
        str2 = "Two_video_call_launch";
        break;
        localObject = "0";
        break label388;
        localObject = "1";
        break label388;
        localObject = "2";
        break label388;
        localObject = "3";
        break label388;
        localObject = "4";
        break label388;
        if (paramMessageForVideo.type != 0) {
          break label453;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
        break label453;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005244", "0X8005244", 0, 0, "", "", "", "");
        break label490;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131363560, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "Don't support ivr");
    return;
    label796:
    if (m == 1008)
    {
      paramMessageForVideo = new Bundle();
      paramMessageForVideo.putString("businessName", str2);
      paramMessageForVideo.putString("uin", (String)localObject);
      paramMessageForVideo.putString("from_where", "publicAccountAIOMsg");
      C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForVideo);
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if (!paramMessageForVideo.isVideo) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ChatActivityUtils.a(localQQAppInterface, localContext, m, (String)localObject, str2, str1, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
      return;
    }
  }
  
  private void b(MessageForVideo paramMessageForVideo, VideoActionSheet paramVideoActionSheet)
  {
    paramVideoActionSheet.c(2131368097);
    PstnManager localPstnManager = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    PstnCardInfo localPstnCardInfo = localPstnManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    int m;
    if ((localPstnCardInfo != null) && (localPstnManager.a() == 1) && (localPstnManager.a().f == 1))
    {
      paramVideoActionSheet.a(2131372446);
      if (localPstnCardInfo.pstn_multi_call_time > 0)
      {
        paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372444), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839269), 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 1, 0, "", "", "", "");
        m = 3;
      }
    }
    for (;;)
    {
      paramVideoActionSheet.d(2131367262);
      paramVideoActionSheet.a(new nsm(this, paramVideoActionSheet, paramMessageForVideo, m));
      paramVideoActionSheet.show();
      return;
      if ((localPstnManager.c() == 1) && (localPstnCardInfo.pstn_multi_try_status == 0))
      {
        paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372444), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839268), 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 3, 0, "", "", "", "");
        m = 4;
      }
      else
      {
        paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372444), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839267), 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 2, 0, "", "", "", "");
        m = 5;
        continue;
        m = 0;
      }
    }
  }
  
  private void c(MessageForVideo paramMessageForVideo, VideoActionSheet paramVideoActionSheet)
  {
    int m = 0;
    PstnSessionInfo localPstnSessionInfo = new PstnSessionInfo();
    PstnManager localPstnManager = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    PstnCardInfo localPstnCardInfo = localPstnManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (paramMessageForVideo.isVideo) {
      paramVideoActionSheet.c(2131368093);
    }
    for (;;)
    {
      paramVideoActionSheet.d(2131367262);
      paramVideoActionSheet.a(new nsn(this, paramVideoActionSheet, paramMessageForVideo, m, localPstnSessionInfo));
      paramVideoActionSheet.show();
      return;
      paramVideoActionSheet.c(2131368096);
      localPstnSessionInfo = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPstnSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if ((localPstnSessionInfo.jdField_b_of_type_JavaLangString != null) && (localPstnSessionInfo.c != null))
      {
        localPstnSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        if ((localPstnCardInfo != null) && (localPstnManager.a() == 1) && (localPstnManager.a().c == 1))
        {
          paramVideoActionSheet.a(2131372446);
          if (localPstnCardInfo.pstn_c2c_call_time > 0)
          {
            paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372444), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839269), 0);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
            m = 1;
          }
          else if ((localPstnManager.b() == 1) && (localPstnCardInfo.pstn_c2c_try_status == 0))
          {
            paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372444), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839268), 0);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
            m = 2;
          }
          else
          {
            paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372444), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839267), 0);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
            m = 5;
          }
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    nso localnso = (nso)paramViewHolder;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131297486);
      paramViewHolder.setTextColor(localResources.getColorStateList(2131428272));
      paramViewHolder.setTextSize(localResources.getDimensionPixelOffset(2131492882));
      paramViewHolder.setGravity(16);
      localnso.a = paramViewHolder;
    }
    paramView = (MessageForVideo)paramChatMessage;
    int m = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramView.isVideo, paramChatMessage.isSendFromLocal());
    a(localnso.a, m);
    m = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramChatMessage.isSendFromLocal());
    localnso.a.setTextColor(localResources.getColor(m));
    localnso.a.setText(paramView.text);
    if ((paramView.istroop == 1) && (this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363479).equals(paramView.text))) {
      ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, paramView.frienduin, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin), "", "");
    }
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (b) {
      a(paramView, paramBaseChatItemLayout, paramViewHolder);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new nso(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了视频";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131305401)
    {
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131305411)
    {
      super.b(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(k, h, j, i);
      return;
    }
    paramView.setPadding(j, h, k, i);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    nso localnso = (nso)paramViewHolder;
    localnso.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (localnso.a.getText().toString().contains(this.jdField_a_of_type_AndroidContentContext.getString(2131363321)))
      {
        paramViewHolder = paramView.getColorStateList(2131428329);
        localnso.a.setTextColor(paramViewHolder);
        return;
      }
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131428275);
        localnso.a.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label151;
        }
      }
      label151:
      for (paramViewHolder = paramView.getColorStateList(2131428274);; paramViewHolder = paramView.getColorStateList(2131428273))
      {
        localnso.a.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131428272);
        break;
      }
    }
    if (paramBubbleInfo.d == 0) {
      localnso.a.setTextColor(-16777216);
    }
    while (paramBubbleInfo.e == 0)
    {
      localnso.a.setLinkTextColor(paramView.getResources().getColorStateList(2131428273));
      return;
      localnso.a.setTextColor(paramBubbleInfo.d);
    }
    localnso.a.setLinkTextColor(paramBubbleInfo.e);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    AIOUtils.a(paramView);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\VideoItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */