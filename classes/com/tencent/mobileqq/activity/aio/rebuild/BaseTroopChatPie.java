package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.TroopPrivateSettingActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopMessageManager.UserActionStateInParallelPullPeriod;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import nvy;
import nvz;
import nwa;
import nwb;
import nwc;

public class BaseTroopChatPie
  extends BaseChatPie
{
  static final String al = "Q.aio.BaseTroopChatPie";
  public static final int dP = 200;
  public static final int dQ = 0;
  public static final int dR = 1;
  public static final int dS = 2;
  public static final int dT = 3;
  public static final int dU = 4;
  public boolean J;
  protected boolean K;
  public boolean L;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  ProxyObserver a;
  protected TroopMessageManager.UserActionStateInParallelPullPeriod a;
  public TroopFeedsCenterLogic a;
  
  public BaseTroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new nwa(this);
  }
  
  protected void A()
  {
    Object localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject != null)
    {
      ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
        if (localObject != null) {
          ((TroopAioMsgNavigateBar)localObject).a.set(false);
        }
      }
    }
    super.A();
  }
  
  protected void B()
  {
    super.B();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.h();
    }
  }
  
  protected void D()
  {
    super.D();
    aD();
  }
  
  protected void N()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    super.N();
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130903333, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight(), this.f);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
      }
      if (this.L) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.L);
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    return super.a(paramInt);
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.n();
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie.troop.special_msg", 2, "refreshHeadMessage==>type:" + paramInt1 + "|value:" + paramLong);
    }
    long l2 = 0L;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    long l1 = l2;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        l1 = l2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
      } while (MsgProxyUtils.a((MessageRecord)localObject2));
      l1 = ((ChatMessage)localObject2).shmsgseq;
    }
    localObject1 = new nvz(this);
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() == 9) {
      i = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie.troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + l1 + "|value:" + paramLong);
    }
    if (i == 0)
    {
      if (paramInt1 != 1) {
        break label250;
      }
      if ((int)l1 >= 1L + paramLong)
      {
        if (l1 - paramLong <= 200L) {
          break label1263;
        }
        paramLong = l1 - 200L;
      }
    }
    label250:
    label666:
    label1251:
    label1257:
    label1263:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramLong, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, (Runnable)localObject1);
      do
      {
        do
        {
          return;
          if ((paramInt1 != 15) && (paramInt1 != 8) && (paramInt1 != 4) && (paramInt1 != 13) && (paramInt1 != 17) && (paramInt1 != 11) && (paramInt1 != 12) && (paramInt1 != 3)) {
            break;
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
        } while ((paramMessageRecord == null) || (paramInt2 > 200));
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseTroopChatPie.troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + l1 + ", mr.shmsgseq:" + paramMessageRecord.shmsgseq);
        }
        if ((int)l1 >= paramMessageRecord.shmsgseq + 1L)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramMessageRecord.shmsgseq, false);
          }
          if (paramInt1 == 3) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramMessageRecord.uniseq);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, (Runnable)localObject1);
          return;
        }
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)paramMessageRecord);
      } while (paramInt2 == -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null);
      return;
      if (paramInt1 == 14) {
        if (!(paramMessageRecord instanceof MessageForReplyText)) {
          break label1257;
        }
      }
      for (paramMessageRecord = (MessageForReplyText)paramMessageRecord;; paramMessageRecord = null)
      {
        if (paramInt2 <= 200)
        {
          if ((int)l1 >= 1L + paramLong)
          {
            if (!NetworkUtil.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
            {
              QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131364741, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
              TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, false);
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramLong, false);
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, (Runnable)localObject1);
            TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, true);
            return;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong, 0L);
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label1251;
          }
          paramInt2 = 0;
          if (paramInt2 >= ((List)localObject2).size()) {
            break label1251;
          }
          localObject1 = (MessageRecord)((List)localObject2).get(paramInt2);
          if ((MsgProxyUtils.a((MessageRecord)localObject1)) || ((localObject1 instanceof MessageForSafeGrayTips))) {}
        }
        for (;;)
        {
          if ((localObject1 != null) && (!UniteGrayTipUtil.a((MessageRecord)localObject1)))
          {
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(((MessageRecord)localObject1).uniseq);
            if (paramInt2 == -1) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null);
            TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, true);
            return;
            paramInt2 += 1;
            break label666;
          }
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131365209, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, false);
          return;
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131365208, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, false);
          return;
          if (paramInt1 != 10) {
            break;
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
          if ((paramMessageRecord != null) && (paramInt2 <= 200))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseTroopChatPie.troop.special_msg", 2, "refreshHeadMessage==>unreadMsgCount:" + paramInt2 + ", fistseq:" + l1 + ", mr.shmsgseq:" + paramMessageRecord.shmsgseq);
            }
            if ((int)l1 >= paramMessageRecord.shmsgseq + 1L)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
                this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramMessageRecord.shmsgseq, false);
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, (Runnable)localObject1, this.jdField_a_of_type_MqqOsMqqHandler);
              return;
            }
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.c(paramLong);
            if (paramInt2 == -1) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, this.jdField_a_of_type_MqqOsMqqHandler);
            return;
          }
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseTroopChatPie.trooptroop_pull_msg", 2, "所要定位的消息还没拉回来本地，并发拉取中...mUserActionState create, natvigateSeq:" + paramLong + ",isAioParallelPullMsgDone:" + bool);
          }
          if (bool)
          {
            if ((int)l1 >= 1L + paramLong)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
                this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramLong, false);
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, (Runnable)localObject1, this.jdField_a_of_type_MqqOsMqqHandler);
              return;
            }
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.c(paramLong);
            if (paramInt2 == -1) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, this.jdField_a_of_type_MqqOsMqqHandler);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod = new TroopMessageManager.UserActionStateInParallelPullPeriod();
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.d = TroopMessageManager.UserActionStateInParallelPullPeriod.c;
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a = TroopAioAgent.Message.a(paramInt1, paramLong, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().addObserver(this);
          return;
          localObject1 = null;
        }
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.L)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297410).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(i, false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().a.get()))
    {
      if ((!TroopAioMsgNavigateBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a())) || (paramInt2 <= 0)) {
        break label96;
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().subList(paramInt1, paramInt1 + paramInt2 - 1);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(localList);
    }
    for (;;)
    {
      super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
      label96:
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b(0);
    }
  }
  
  protected void a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramCharSequence = new ArrayList();
      paramCharSequence = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramCharSequence);
    }
    super.a(paramCharSequence);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new nwc(this, paramBoolean, paramString1, paramString2, paramInt), 300L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.a).a(this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.i();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
      if (!this.K)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      this.K = false;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
      if (!this.K)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      this.K = false;
      break;
      d(false);
    }
  }
  
  protected void aC()
  {
    j(0);
  }
  
  void aD()
  {
    this.d = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131367970));
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  protected void aE()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = new TroopAioTips();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.g();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 9)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d();
    }
    aF();
  }
  
  void aF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "handleGrayTipsMsg");
    }
    Object localObject = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseTroopChatPie", 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!((TroopTipsMsgMgr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "troopAIO has unread troopTipMsg");
    }
    localObject = new nwb(this, (TroopTipsMsgMgr)localObject);
    ThreadManager.b().post((Runnable)localObject);
  }
  
  public void aG()
  {
    N();
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.j)
      {
        paramIntent = this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        a().setTitle(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
      return;
      s();
    }
  }
  
  protected void b(Object paramObject)
  {
    paramObject = (TroopAioAgent.Message)paramObject;
    if (paramObject != null)
    {
      if (((TroopAioAgent.Message)paramObject).jdField_a_of_type_Int != TroopAioAgent.jdField_a_of_type_Int) {
        break label37;
      }
      a(((TroopAioAgent.Message)paramObject).c, ((TroopAioAgent.Message)paramObject).a(), ((TroopAioAgent.Message)paramObject).d, null);
    }
    label37:
    do
    {
      do
      {
        return;
        if (((TroopAioAgent.Message)paramObject).jdField_a_of_type_Int != TroopAioAgent.b) {
          break;
        }
      } while (this.jdField_c_of_type_AndroidViewView == null);
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).addRule(2, ((TroopAioAgent.Message)paramObject).b);
      return;
    } while (((TroopAioAgent.Message)paramObject).jdField_a_of_type_Int != TroopAioAgent.c);
    paramObject = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, TroopPrivateSettingActivity.class);
    ((Intent)paramObject).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    ((Intent)paramObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)paramObject).putExtra("vistor_type", 1);
    ((Intent)paramObject).putExtra("selection", 2);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)paramObject, 2000);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
    }
    while ((paramBoolean) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) || (this.L)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 19.0F);
  }
  
  protected void e()
  {
    super.e();
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new nvy(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131428260));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131428260));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131428258));
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b();
  }
  
  protected boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    return super.e();
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void r()
  {
    if (this.L)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839806);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843167);
  }
  
  protected void s()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.d == TroopMessageManager.UserActionStateInParallelPullPeriod.c) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a != null)) {
          a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a.c, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a.a(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a.d, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseTroopChatPie.trooptroop_pull_msg", 2, "update,mUserActionState.actionType" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.d);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod = null;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().deleteObservers();
      }
    }
    while (!(paramObject instanceof TroopAioAgent.Message)) {
      return;
    }
    b(paramObject);
  }
  
  public boolean v()
  {
    return this.F;
  }
  
  protected void w()
  {
    if (this.F)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseTroopChatPie", 2, "hasDestory = true return");
      }
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.e();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label107;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      aC();
      super.w();
      return;
      label107:
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public boolean w()
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\rebuild\BaseTroopChatPie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */