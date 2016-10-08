package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.hotchat.HCTopicSeatsView;
import com.tencent.mobileqq.hotchat.HotChatFavoriteHelper;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotchat.anim.HeartBeatAnimator;
import com.tencent.mobileqq.hotchat.ui.HotChatPttStageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyChatFlowerHelper;
import com.tencent.mobileqq.nearby.NearbyChatFlowerHelper.FlowerPlayable;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.Observable;
import mqq.os.MqqHandler;
import nyg;
import nyh;
import nyi;
import nyj;
import nyk;
import nyl;
import nym;
import nyn;
import nyo;
import nyp;
import nyq;
import nys;
import nyt;

public class HotChatPie
  extends BaseTroopChatPie
  implements NearbyChatFlowerHelper.FlowerPlayable
{
  protected static final String[] a;
  public static final String ao = "abp_flag";
  public static final String ap = "is_from_web";
  public static final String aq = "param_newly_created_hot_chat";
  protected static final int ea = 4;
  public boolean M;
  public boolean N;
  boolean O = false;
  boolean P;
  boolean Q = false;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private BaseTroopChatPie.BaseTroopMsgObserver jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie$BaseTroopMsgObserver;
  public HotChatManager a;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new nyq(this);
  public HotChatShare a;
  public HotchatSCHelper a;
  public HotChatInfo a;
  HotChatFavoriteHelper jdField_a_of_type_ComTencentMobileqqHotchatHotChatFavoriteHelper;
  public HotChatPttStageControl a;
  public NearbyChatFlowerHelper a;
  public String ar;
  LinearLayout d;
  public int dY;
  public int dZ;
  int eb = 0;
  public TextView f;
  Dialog g;
  long h;
  public Dialog h;
  public long i;
  public ImageView k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "@all", "@全体成员" };
  }
  
  public HotChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_h_of_type_Long = 0L;
  }
  
  private void aK()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isPttShowRoom())) {
      this.jdField_a_of_type_AndroidViewViewGroup.postDelayed(new nyk(this), 50L);
    }
  }
  
  protected void A()
  {
    super.A();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper.b();
    }
    this.Q = true;
  }
  
  protected void B()
  {
    super.B();
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.a();
    }
    y();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.g();
    }
  }
  
  protected void D()
  {
    super.D();
    this.Q = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isPttShowRoom()))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427720));
      this.jdField_a_of_type_AndroidViewViewGroup.postDelayed(new nyl(this), 300L);
    }
  }
  
  protected void E()
  {
    super.E();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isPttShowRoom())) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void F()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.h();
    }
    super.F();
  }
  
  protected void N()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.b();
    }
    aK();
    if (this.M)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
      }
      HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.M);
      return;
    }
    super.N();
  }
  
  protected void W()
  {
    aH();
    aE();
    super.W();
    this.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
    NearbyTransitActivity.a("AIOShow", 2);
    Object localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    Object localObject1 = ((Intent)localObject2).getStringExtra("uin");
    Object localObject3 = ((Intent)localObject2).getStringExtra("uinname");
    String str = ((Intent)localObject2).getStringExtra("hotnamecode");
    boolean bool = ((Intent)localObject2).getBooleanExtra("param_newly_created_hot_chat", false);
    if ((!this.P) && (bool) && (((Intent)localObject2).getBooleanExtra("param_newly_created_hot_chat", false)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty(str)))
    {
      localObject2 = ShareHotChatGrayTips.makeShareGrayTip("你的热聊房间会被推荐给附近的人和好友，感兴趣的会加入进来哦。你也可以邀请好友加入。分享热聊房间", "分享热聊房间", (String)localObject1, (String)localObject3, HotChatHelper.a(str, 1), str);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.P = true;
        localObject3 = MessageRecordFactory.a(63503);
        long l = MessageCache.a();
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((MessageRecord)localObject3).init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, (String)localObject2, l, 63503, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
        ((MessageRecord)localObject3).isread = true;
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject3, str);
        }
      }
      this.jdField_g_of_type_AndroidAppDialog = HotChatHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new nym(this, (String)localObject1));
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.pkFlag != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper == null)
      {
        ThreadManager.a(new nyn(this), 5, null, true);
        localObject1 = new nyo(this);
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = new HotchatSCHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (HotchatSCHelper.OnShowNoteListener)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.a(10000L);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.subType == 1)) {
      HotChatUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    }
  }
  
  public NearbyChatFlowerHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
        if (paramInt1 == 2000) {
          if (paramInt2 == -1)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a()))
            {
              this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) {
                a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memo, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoUrl);
              }
            }
            if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
              break label439;
            }
          }
        }
        break;
      }
    }
    label430:
    label439:
    for (bool = paramIntent.getExtras().getBoolean("isNeedFinish");; bool = false)
    {
      if ((bool) && (a().getIntent().getBooleanExtra("is_from_web", false))) {
        a().sendBroadcast(new Intent("com.tencent.mobileqq.refresh_hot_chat_list"));
      }
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      Object localObject = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject);
      break;
      if (paramInt2 == 8001)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        break;
      }
      if (paramInt2 != 0) {
        break;
      }
      break;
      if (paramInt1 == 13004)
      {
        if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
          break label430;
        }
        localObject = paramIntent.getStringExtra("SEL_MEMBER_UIN");
      }
      for (int j = paramIntent.getIntExtra("HC_MEMBER_SEATID", 0);; j = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.BaseTroopChatPie", 2, "REQUEST_HCTOPIC_SEL_MEMBER_TO_INVITE, " + (String)localObject);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl == null) {
          break;
        }
        HCTopicSeatsView localHCTopicSeatsView = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.a();
        if (paramInt2 == -1) {
          bool = true;
        }
        localHCTopicSeatsView.a(bool, j, (String)localObject);
        break;
        if ((paramInt1 != 13003) || (paramIntent == null)) {
          break;
        }
        localObject = paramIntent.getExtras().getString("uin");
        j = paramIntent.getExtras().getInt("from", 0);
        NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, j, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        break;
        localObject = null;
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2, double paramDouble)
  {
    HCTopicSeatsView localHCTopicSeatsView;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isPttShowRoom()) && (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null))
    {
      localHCTopicSeatsView = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a();
      if (localHCTopicSeatsView != null)
      {
        if (paramInt1 != 1) {
          break label91;
        }
        localHCTopicSeatsView.setFlag(paramBoolean, 1);
        if (QLog.isColorLevel()) {
          NearbyUtils.a("PttShow", String.format("updateRecordState flag:%d isRecording=%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) }), new Object[0]);
        }
      }
    }
    label91:
    while (paramInt1 != 2) {
      return;
    }
    localHCTopicSeatsView.a(paramInt2, paramDouble);
  }
  
  public void a(long paramLong)
  {
    QLog.d("PttShow", 1, "HotChatPie deletePttInShowRoom uniseq=" + paramLong);
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.c(paramLong);
    }
  }
  
  protected void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) && (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.c) && (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.d)) {
      return;
    }
    super.a(paramContext, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  protected void a(QQMessageFacade.Message paramMessage) {}
  
  public void a(ChatMessage paramChatMessage, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.a(a());
    localActionSheet.c("@他");
    localActionSheet.a("删除成员", 3);
    localActionSheet.d(2131367262);
    localActionSheet.a(new nyt(this, localActionSheet, paramChatMessage, paramString));
    localActionSheet.show();
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    super.a(paramOnQQRecorderListener, paramBoolean, paramRecorderParam);
    a(1, true, 0, 0.0D);
  }
  
  protected void a(CharSequence paramCharSequence)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    super.a(paramCharSequence);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {}
    int j;
    do
    {
      return;
      j = ((Integer)paramObject).intValue();
    } while (j == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    switch (j)
    {
    }
    for (;;)
    {
      super.a(paramObject);
      return;
      if (HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true))
      {
        if (!HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(true))) {
            g(false);
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800657E", "0X800657E", 0, 0, "", "", "", "");
            return;
            g(true);
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800657D", "0X800657D", 0, 0, "", "", "", "");
        continue;
        if ((HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true)) && (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null)) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.l();
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    a(1, false, 0, 0.0D);
    super.a(paramString, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    super.a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    a(2, true, paramInt2, paramDouble);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    super.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isPttShowRoom()) && (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null)) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.n();
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2) || (this.f == null)) {}
    label93:
    for (;;)
    {
      return;
      paramArrayOfInt[1] = 0;
      paramArrayOfInt[0] = 0;
      Object localObject = this.k;
      int j = 0;
      for (;;)
      {
        if (j >= 3) {
          break label93;
        }
        paramArrayOfInt[0] += ((View)localObject).getLeft();
        paramArrayOfInt[1] += ((View)localObject).getTop();
        if (!(((View)localObject).getParent() instanceof View)) {
          break;
        }
        localObject = (View)((View)localObject).getParent();
        if (((View)localObject).getId() == 2131297082) {
          break;
        }
        j += 1;
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    while (this.Q) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed = true;
      ThreadManager.a().post(new nyp(this));
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.L);
        }
        paramString1 = paramString3;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = paramString3;
          if (!paramString3.startsWith("mqqapi"))
          {
            paramString1 = paramString3;
            if (!paramString3.startsWith("http://")) {
              paramString1 = "http://" + paramString3;
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString2, paramString1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b = false;
        }
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    this.C = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie$BaseTroopMsgObserver = new BaseTroopChatPie.BaseTroopMsgObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare = new HotChatShare(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    return super.a(paramBoolean);
  }
  
  void aD()
  {
    super.aD();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131371487));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state != 0)) {
      ThreadManager.a(new nyg(this), 5, null, false);
    }
  }
  
  public void aH()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    HotChatHandler localHotChatHandler;
    if (localHotChatInfo != null)
    {
      if (localHotChatInfo.isPttShowRoom())
      {
        this.i = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.praiseCount;
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl == null) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl = new HotChatPttStageControl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHotChatInfo.uuid);
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a();
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("param_newly_created_hot_chat", false))
      {
        localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
        if (localHotChatInfo.userCreate != 1) {
          break label173;
        }
        localHotChatHandler.b(localHotChatInfo.troopUin);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new nys(this), 200L);
      return;
      label173:
      if (localHotChatInfo.uuid != null) {
        localHotChatHandler.a(localHotChatInfo.uuid.getBytes(), localHotChatInfo.troopUin);
      }
    }
  }
  
  protected void aI()
  {
    Editable localEditable = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if ((localEditable == null) || (localEditable.length() < 4)) {}
    label161:
    for (;;)
    {
      return;
      String str1 = localEditable.toString().toLowerCase();
      Object localObject = jdField_a_of_type_ArrayOfJavaLangString;
      int n = localObject.length;
      int j = -1;
      int m = 0;
      String str2;
      if (m < n)
      {
        str2 = localObject[m];
        j = str1.indexOf(str2);
        if (j < 0) {}
      }
      for (str1 = localEditable.toString().substring(j, str2.length() + j);; str1 = null)
      {
        if ((j < 0) || (str1 == null)) {
          break label161;
        }
        localObject = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", str1.substring(1), true, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
        localEditable.replace(j, str1.length() + j, (CharSequence)localObject);
        return;
        m += 1;
        break;
      }
    }
  }
  
  public void aJ()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(a(), 2131558973);
    localQQCustomDialog.setContentView(2130904163);
    TextView localTextView = (TextView)localQQCustomDialog.findViewById(2131301654);
    ((TextView)localQQCustomDialog.findViewById(2131297123)).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131371507));
    ((TextView)localQQCustomDialog.findViewById(2131296879)).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131371508));
    localTextView.setText(String.valueOf(HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) + "心");
    localQQCustomDialog.setNegativeButton("忽略", new nyh(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton("去看攻略", new nyi(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  public void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie$BaseTroopMsgObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie$BaseTroopMsgObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatFavoriteHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatFavoriteHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatFavoriteHelper = null;
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a(paramInt1, paramInt2);
    }
    this.dY = paramInt2;
    if (this.eb == 2) {
      y();
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    NearbyUtils.a("PttShow", "doPanelChanged", new Object[] { Integer.valueOf(this.eb), this.jdField_a_of_type_AndroidWidgetPopupWindow });
  }
  
  public void b(long paramLong)
  {
    if (paramLong < this.i) {}
    while (this.f == null) {
      return;
    }
    this.f.setText(HotChatUtil.a(paramLong));
  }
  
  public void b(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    a(1, false, 0, 0.0D);
    super.b(paramString, paramInt, paramRecorderParam);
  }
  
  public void c()
  {
    if (x()) {
      aI();
    }
    super.c();
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "HotChatPie_updateSession_business HotChatInfo is null", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
      }
      a(0);
    }
    do
    {
      return;
      this.dZ = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate;
    } while ((paramIntent == null) || (paramIntent.getIntExtra("hot_chat_from", 1) != 2) || (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b()));
    HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  protected void e(Intent paramIntent)
  {
    this.M = paramIntent.getBooleanExtra("abp_flag", false);
    this.N = paramIntent.getBooleanExtra("is_from_web", false);
    if ((this.N) && (!this.M))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366637);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回");
      return;
    }
    if (this.M)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("热聊");
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回热聊");
      return;
    }
    super.e(paramIntent);
  }
  
  protected boolean e()
  {
    boolean bool1 = true;
    if (y()) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
      } while ((this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) && (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.b()));
      bool2 = super.e();
      if ((!this.jdField_h_of_type_Boolean) && (this.M) && (!bool2)) {
        HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.M);
      }
      bool1 = bool2;
    } while (bool2);
    aK();
    return bool2;
  }
  
  protected void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl == null) {}
    for (;;)
    {
      return;
      y();
      Object localObject = null;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.findViewWithTag(Integer.valueOf(2));
        }
        this.eb = 2;
      }
      for (this.jdField_a_of_type_AndroidWidgetPopupWindow = HotChatUtil.a((View)localObject); QLog.isDevelopLevel(); this.jdField_a_of_type_AndroidWidgetPopupWindow = HotChatUtil.a((View)localObject, new nyj(this)))
      {
        NearbyUtils.a("PttShow", "showPttRoomGuideOrTip", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.eb), localObject });
        return;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        }
        localObject = this.jdField_a_of_type_AndroidViewViewGroup;
        this.eb = 1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = super.handleMessage(paramMessage);
    }
    return bool;
  }
  
  protected void l()
  {
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum > 0))
    {
      j = 1;
      b(true);
      if (j == 0) {
        break label456;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131371473), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum) }));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      label84:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isPttShowRoom())) {
        break label468;
      }
      if (!this.O)
      {
        this.O = true;
        ViewGroup localViewGroup = (ViewGroup)this.jdField_c_of_type_AndroidWidgetTextView.getParent();
        localViewGroup.removeView(this.jdField_c_of_type_AndroidWidgetTextView);
        this.d = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.d.setOrientation(0);
        this.d.setGravity(17);
        this.d.addView(this.jdField_c_of_type_AndroidWidgetTextView, new LinearLayout.LayoutParams(-2, -2));
        this.k = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.k.setImageResource(2130840821);
        this.k.setScaleType(ImageView.ScaleType.FIT_CENTER);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(HeartBeatAnimator.b, HeartBeatAnimator.c);
        if (j != 0) {
          localLayoutParams.leftMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
        this.d.addView(this.k, localLayoutParams);
        this.f = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.f.setIncludeFontPadding(false);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setGravity(17);
        this.f.setSingleLine(true);
        this.f.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428260));
        this.f.setTextSize(1, 14.0F);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.leftMargin = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        this.d.addView(this.f, localLayoutParams);
        localViewGroup.addView(this.d, new ViewGroup.LayoutParams(-2, -2));
      }
      b(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.praiseCount);
      if (this.k != null) {
        this.k.setVisibility(0);
      }
      if (this.f != null) {
        this.f.setVisibility(0);
      }
    }
    label456:
    label468:
    do
    {
      return;
      j = 0;
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label84;
      if (this.k != null) {
        this.k.setVisibility(8);
      }
    } while (this.f == null);
    this.f.setVisibility(8);
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatFavoriteHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatFavoriteHelper = new HotChatFavoriteHelper(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void o()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(str))
    {
      ChatSettingForHotChat.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "你已不在该热聊", 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!this.n)) {
      return;
    }
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean q()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.c();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.c())
    {
      aJ();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005DD2", "0X8005DD2", 0, 0, "", "", "", "");
    }
    return bool;
  }
  
  protected void s()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a(paramObservable, paramObject);
    }
  }
  
  protected void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = null;
    }
    long l = SystemClock.elapsedRealtime() - this.jdField_h_of_type_Long;
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.c();
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl = null;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006586", "0X8006586", 0, 0, String.valueOf(l), String.valueOf(this.dZ), "", "");
    }
    for (;;)
    {
      if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("open_chatfragment_fromphoto", false))) || (this.jdField_h_of_type_AndroidAppDialog != null))
      {
        this.jdField_h_of_type_AndroidAppDialog.dismiss();
        this.jdField_h_of_type_AndroidAppDialog = null;
      }
      if (this.jdField_g_of_type_AndroidAppDialog != null)
      {
        this.jdField_g_of_type_AndroidAppDialog.dismiss();
        this.jdField_g_of_type_AndroidAppDialog = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare.a();
      }
      super.w();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l), String.valueOf(this.dZ), "", "");
    }
  }
  
  public boolean w()
  {
    return true;
  }
  
  protected boolean x()
  {
    boolean bool2 = true;
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    boolean bool1;
    if (localHotChatInfo != null)
    {
      bool1 = bool2;
      if (localHotChatInfo.adminLevel != 1)
      {
        if (localHotChatInfo.adminLevel == 2) {
          bool1 = bool2;
        }
      }
      else
      {
        bool2 = bool1;
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.aio.BaseTroopChatPie", 4, "isAbleToSendAtAllMsg, adminLevel = " + localHotChatInfo.adminLevel);
        }
      }
    }
    for (bool2 = bool1;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2)
      {
        bool2 = HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        bool1 = bool2;
        if (QLog.isDevelopLevel())
        {
          QLog.i("Q.aio.BaseTroopChatPie", 4, "isAbleToSendAtAllMsg, isAuth = " + bool2);
          bool1 = bool2;
        }
      }
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public boolean y()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())
      {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
        this.eb = 0;
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\rebuild\HotChatPie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */