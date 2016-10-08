package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo_tips;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.NearbyTroopMemMgr;
import com.tencent.mobileqq.troop.utils.NearbyTroopMemMgr.RadarInstanceState;
import com.tencent.mobileqq.troop.utils.TroopAioADManager;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicObserver;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaControllerListener;
import com.tencent.mobileqq.troop.widget.TroopUsageTimeReport;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import oci;
import ocj;
import ocl;
import ocm;
import ocn;
import ocp;
import ocq;
import ocy;
import ocz;
import oda;
import odb;
import odc;
import odd;
import ode;
import odg;
import odh;
import odi;
import odj;
import odk;
import odl;
import odm;
import odn;
import odo;
import odp;
import odr;
import ods;
import odt;
import odu;
import odv;
import odw;
import odz;
import oea;
import oeb;
import oec;
import oed;
import oee;
import oef;
import org.json.JSONArray;
import org.json.JSONException;

public class TroopChatPie
  extends BaseTroopChatPie
{
  static final String am = "Q.aio.TroopChatPie";
  static final int dX = 1;
  static final int dY = 2;
  static final int dZ = 3;
  static final int ea = 4;
  static final int eb = 5;
  static final int ec = 6;
  static final int ed = 7;
  public boolean M;
  boolean N;
  protected boolean O;
  protected boolean P;
  boolean Q;
  public boolean R;
  public boolean S;
  boolean T;
  protected AnimationDrawable a;
  Handler jdField_a_of_type_AndroidOsHandler;
  public Toast a;
  AnonymousChatHelper.AnonymousStatusListener jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener;
  public QQAnonymousDialog a;
  TroopCardAppInfoHelper.IGetAppInfoCB jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB;
  TroopCardAppInfoHelper jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper;
  TroopNewGuidePopWindow jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow;
  public TroopGiftAioPanelData a;
  public TroopGiftPanel a;
  public GamePartyTipsBar a;
  public TroopAssistTipsBar a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  protected MessageObserver a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver;
  VideoPlayLogic jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic;
  TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  TroopTopicObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicObserver;
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  MediaControllerX.MediaControllerListener jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener;
  TroopGiftAnimationController jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController;
  protected QQCustomDialog a;
  private Observer jdField_a_of_type_JavaUtilObserver;
  public Handler b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  Runnable jdField_b_of_type_JavaLangRunnable;
  Runnable c;
  QQProgressDialog d;
  public int dV;
  public int dW;
  public int ee;
  public View h;
  View i;
  public View j;
  public View k;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
    this.M = false;
    this.N = false;
    this.dW = 2;
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener = new odn(this);
    this.jdField_c_of_type_JavaLangRunnable = new oed(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicObserver = new ocn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ocp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ocq(this);
    this.jdField_b_of_type_AndroidOsHandler = new ocy(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ode(this);
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = new odg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new odh(this);
    this.ee = 0;
    this.Q = false;
    this.R = true;
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.S = false;
    this.T = false;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new odo(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new odu(this);
    this.jdField_a_of_type_JavaUtilObserver = new odv(this);
  }
  
  protected void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow == null) || (!this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing()))
    {
      TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
      if (localTroopGiftManager != null) {
        localTroopGiftManager.b();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    StructMsgItemLayout13.a();
    aV();
    super.A();
  }
  
  protected void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    super.B();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.c();
    }
    ApolloActionManager.a().d();
    if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow == null) || (!this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing()))
    {
      TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
      if (localTroopGiftManager != null) {
        localTroopGiftManager.b();
      }
    }
  }
  
  protected void C()
  {
    super.C();
    if (this.L)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundResource(2130839791);
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
      a(-16777216, false);
    }
    aM();
  }
  
  protected void D()
  {
    super.D();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 2)
    {
      this.K = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
      if (this.K) {
        aI();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    TroopUsageTimeReport.a().a();
    TroopUsageTimeReport.a().b();
  }
  
  protected void E()
  {
    super.E();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.f();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.j();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
    }
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int m = localIntent.getIntExtra("uintype", -1);
    if ((!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != m)) {}
    for (m = 1;; m = 0)
    {
      if ((m != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.e();
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
      }
      if (m != 0) {
        NearbyTroopMemMgr.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
      {
        TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
      }
      this.jdField_g_of_type_Boolean = true;
      return;
    }
  }
  
  public void F()
  {
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.d();
    }
    super.F();
  }
  
  protected void H()
  {
    TroopUsageTimeReport.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    TroopUsageTimeReport.a().a();
    TroopUsageTimeReport.a().b();
    super.H();
  }
  
  protected void I()
  {
    TroopUsageTimeReport.a().d();
    TroopUsageTimeReport.a().e();
    super.I();
  }
  
  protected void W()
  {
    aE();
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((localObject != null) && (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L)) {
      a(0L, 0L);
    }
    if ((localObject != null) && (QLog.isColorLevel())) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "aio onShow:" + ((TroopInfo)localObject).troopuin + ", sysFlag=" + ((TroopInfo)localObject).cGroupRankSysFlag + ", userFlag=" + ((TroopInfo)localObject).cGroupRankUserFlag);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      aJ();
    }
    super.W();
    if (this.N == true)
    {
      ThreadManager.a(new oee(this), 1, null, true);
      this.N = false;
    }
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("forward_type")) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(((Bundle)localObject).getString("uin")))) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.a(new ocj(this, bool), 8, null, true);
      return;
    }
  }
  
  public TroopGiftAnimationController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = new TroopGiftAnimationController(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController;
  }
  
  public String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int m = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(m + 1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(false);
    super.a(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a()) && (TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (b(true))) {
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      Object localObject1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
      continue;
      Object localObject3 = paramIntent.getExtras();
      localObject1 = Boolean.valueOf(false);
      Object localObject2 = "";
      if (((Bundle)localObject3).containsKey("TroopFile_DeleteFile")) {
        localObject1 = Boolean.valueOf(((Bundle)localObject3).getBoolean("TroopFile_DeleteFile"));
      }
      if (((Bundle)localObject3).containsKey("TroopFile_FileName")) {
        localObject2 = ((Bundle)localObject3).getString("TroopFile_FileName");
      }
      if (((Boolean)localObject1).booleanValue())
      {
        localObject1 = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364217), new Object[] { TroopFileUtils.a((String)localObject2) });
        TroopFileError.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (String)localObject1);
        continue;
        String str = paramIntent.getExtras().getString("member_uin");
        localObject3 = paramIntent.getExtras().getString("member_display_name");
        int m;
        int n;
        if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null))
        {
          if (!"0".equals(str))
          {
            localObject1 = null;
            if (!w()) {
              localObject1 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str);
            }
            localObject2 = localObject1;
            if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = localObject3;
            }
            localObject1 = new StringBuilder("@").append((String)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = str;
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = ((StringBuilder)localObject1).toString();
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
            a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo);
            m = 0;
            if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText))
            {
              n = 2;
              m = n;
              if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b))
              {
                if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d == 0) {
                  m = 6;
                }
              }
              else
              {
                label565:
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                n = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                localObject3 = "" + this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
                str = "655_" + this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_Int;
                if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b)) {
                  break label787;
                }
              }
            }
            label787:
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b)
            {
              VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", m, n, new String[] { localObject3, str, localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin });
              break;
              m = n;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d != 1) {
                break label565;
              }
              m = 7;
              break label565;
              if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b))
              {
                m = 3;
                break label565;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d == 0)
              {
                m = 4;
                break label565;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d != 1) {
                break label565;
              }
              m = 5;
              break label565;
            }
          }
        }
        else
        {
          a(str, (String)localObject3, true, 4);
          continue;
          TroopGiftUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          continue;
          ah();
          m = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
          if (m > 0)
          {
            n = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().charAt(m - 1);
            if ((n == 36) || (n == 65509) || (n == 165) || (n == 65284))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().delete(m - 1, m));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(m - 1);
              continue;
              a(paramIntent.getExtras().getString("member_uin"), paramIntent.getExtras().getString("member_display_name"), false, 3);
              continue;
              localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
              if ((((String)localObject1).length() == 1) && ((((String)localObject1).charAt(0) == '#') || (((String)localObject1).charAt(0) == 65283)))
              {
                this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
                this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
                continue;
                if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null)
                {
                  localObject1 = paramIntent.getStringExtra("member_uin");
                  this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b((String)localObject1);
                  continue;
                  if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null)
                  {
                    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e();
                    continue;
                    if (paramInt2 == 8001)
                    {
                      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
                        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
                      }
                    }
                    else if (paramInt1 == 12005)
                    {
                      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                      if (localObject1 != null)
                      {
                        if (((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
                          m = 0;
                        }
                        for (;;)
                        {
                          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, m + "", "", "");
                          break;
                          if (((TroopInfo)localObject1).isAdmin()) {
                            m = 1;
                          } else {
                            m = 2;
                          }
                        }
                      }
                    }
                    else if (paramInt2 == 0)
                    {
                      switch (paramInt1)
                      {
                      case 12006: 
                      default: 
                        break;
                      case 12007: 
                        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) {
                          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e();
                        }
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog == null) {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = new QQAnonymousDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.show();
    if ((paramInt == 1) || (paramInt == 3)) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new odt(this), 1000L);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).a;
      if (localObject != null) {
        ((SystemBarCompact)localObject).b(paramInt);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong1, paramLong2, new ocm(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      if ((paramLong == 1L) || (paramLong == 2L)) {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog, CreditLevelTipDialog isShowing:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
        }
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      if ((paramLong == 1L) || ((paramLong == 2L) && (!paramBoolean)))
      {
        int m = 2131365165;
        if (paramLong == 1L) {
          m = 2131365166;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131368978)).setMessage(m);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131365167, new oda(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton("", null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    } while ((paramLong != 2L) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131368978)).setMessage(2131365164);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131365167, new odc(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131365168, new odd(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void a(Intent paramIntent)
  {
    if ((this.L) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      i(false);
    }
    String str1;
    String str2;
    int m;
    for (;;)
    {
      if ((this.L) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131364921) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      }
      super.a(paramIntent);
      str1 = paramIntent.getStringExtra("greetingsTitle");
      str2 = paramIntent.getStringExtra("greetingsContent");
      m = paramIntent.getIntExtra("types", 0);
      if (m == 1)
      {
        Object localObject1 = paramIntent.getStringExtra("greetingsMembers");
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            m = 0;
            for (;;)
            {
              if (m < ((JSONArray)localObject1).length())
              {
                Object localObject2 = ((JSONArray)localObject1).getString(m);
                String str4 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2);
                localObject2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, str4, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
                if ((localObject2 != null) && (((SpannableString)localObject2).length() != 0)) {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject2);
                }
                m += 1;
                continue;
                if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                i(true);
                this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundResource(2130839791);
                this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839791);
                this.jdField_h_of_type_AndroidViewView.setVisibility(0);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.aio.TroopChatPie", 2, "TroopChatPie send greetings.get members failed.");
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!android.text.TextUtils.isEmpty(str1)) {
        a("0", str2, str1);
      }
      if (paramIntent.getBooleanExtra("sendGift", false)) {
        a(true, 1);
      }
      return;
      if (m == 2)
      {
        String str3 = paramIntent.getStringExtra("greetingsName");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, "@" + str3 + " ");
      }
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int m = paramIntent.getIntExtra(AlbumConstants.i, -1);
    if (((m == 2) || (m == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramConfiguration);
    }
    super.a(paramConfiguration);
  }
  
  protected void a(QQMessageFacade.Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b())) {
      return;
    }
    super.a(paramMessage);
  }
  
  public void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo)
  {
    if (paramSelfGagInfo.jdField_a_of_type_Boolean) {
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (8 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.jdField_k_of_type_Int != 1) || (this.w != 0)))
      {
        Z();
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramSelfGagInfo.b);
        }
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramSelfGagInfo.jdField_a_of_type_Long * 1000L);
        this.jdField_g_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "updateGagStatus disable fastimage,  mAllowFastImage = " + this.jdField_g_of_type_Boolean);
        }
      }
    }
    do
    {
      return;
      this.P = true;
      break;
      this.P = false;
      aC();
      this.jdField_g_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "updateGagStatus enable fastimage,  mAllowFastImage = " + this.jdField_g_of_type_Boolean);
  }
  
  public void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (paramSelfGagInfo == null) {
        ThreadManager.a(new ocz(this, paramBoolean), 8, null, true);
      }
    }
    else {
      return;
    }
    a(paramSelfGagInfo);
  }
  
  public void a(Object paramObject)
  {
    AIOUtils.l = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int m = ((Integer)paramObject).intValue();
    if (m == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    switch (m)
    {
    }
    for (;;)
    {
      r(m);
      super.a(paramObject);
      return;
      if (this.L)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        continue;
        if (this.L)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          continue;
          if (this.L)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            continue;
            if (this.L)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              continue;
              if (!w()) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              }
              t(0);
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b())) {}
    do
    {
      return;
      ApolloActionManager.a().e();
      ah();
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null)
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(8);
        localLayoutParams.addRule(12);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, localLayoutParams);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = TroopGiftAioPanelData.a(this.jdField_a_of_type_AndroidContentContext);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) {
          t(paramInt);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(paramInt);
          return;
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData, true);
        }
      }
    } while (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8);
    localLayoutParams.addRule(12);
    this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, localLayoutParams);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = a();
    } while ((android.text.TextUtils.isEmpty(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString)) || (paramObject == null));
    for (;;)
    {
      int m;
      try
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        if (Long.parseLong(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString) != l) {
          break;
        }
        paramObject = (TroopMemberCard)paramObject[2];
        m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
        int n = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t();
        if (m > n) {
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a().getItem(m);
        if (!(localObject1 instanceof MessageForQQWalletTips)) {
          break label404;
        }
        localObject1 = (MessageForQQWalletTips)localObject1;
        if ((((MessageForQQWalletTips)localObject1).istroop != 1) || (paramObject == null) || (!((MessageForQQWalletTips)localObject1).memberUin.equals(String.valueOf(((TroopMemberCard)paramObject).memberUin))) || (!((MessageForQQWalletTips)localObject1).frienduin.equals(String.valueOf(l))) || ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51) == null)) {
          break label404;
        }
        Object localObject2 = ((TroopMemberCard)paramObject).nick;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.TroopChatPie", 2, "handGetTroopMemberCard troopUin=" + ((MessageForQQWalletTips)localObject1).frienduin + ", memberUin=" + ((MessageForQQWalletTips)localObject1).memberUin + ",card=" + ((TroopMemberCard)paramObject).card + ",remark=" + ((TroopMemberCard)paramObject).remark + ",nick=" + ((TroopMemberCard)paramObject).nick + ",saveTroopMemberEx succ=" + true);
        }
        localObject2 = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, m);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.TroopChatPie", 2, "handGetTroopMemberCard ref itemView=" + localObject2 + ",index=" + m);
        }
        if (localObject2 == null) {
          break label404;
        }
        localObject2 = (TextView)((View)localObject2).findViewById(2131297668);
        ((MessageForQQWalletTips)localObject1).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TextView)localObject2);
      }
      catch (Throwable paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.aio.TroopChatPie", 2, "handGetTroopMemberCard e=" + paramObject);
      return;
      label404:
      m += 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    int n = 0;
    int m = n;
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null)
    {
      m = n;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b())
      {
        this.jdField_d_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
        m = 1;
      }
    }
    if (m != 0) {
      return true;
    }
    return super.a(paramInt);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return super.a(paramInt, paramView, paramListView);
  }
  
  protected boolean a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    aL();
    s(1);
    return true;
  }
  
  void aD()
  {
    boolean bool = false;
    super.aD();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null)
    {
      oef localoef = new oef(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localoef, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    b(false);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.d();
    }
    d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.L != AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (!this.L) {
        bool = true;
      }
      this.L = bool;
      i(this.L);
    }
    ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131)).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void aE()
  {
    super.aE();
    this.ee = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    new odi(this).execute(new Void[0]);
    ThreadManager.a(new odj(this), 8, null, true);
    aP();
    Object localObject = new odk(this);
    ThreadManager.b().post((Runnable)localObject);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localObject != null)
    {
      String str1 = ((Intent)localObject).getStringExtra("at_member_name");
      String str2 = ((Intent)localObject).getStringExtra("at_member_uin");
      int m = ((Intent)localObject).getIntExtra("at_member_source", 0);
      if ((!android.text.TextUtils.isEmpty(str1)) && (!android.text.TextUtils.isEmpty(str2))) {
        a(str2, str1, false, m);
      }
    }
    if ((!this.Q) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      if (!BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).getBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false)) {}
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, l1, l1, l2, "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, true, false);
        TroopNewGuidePopWindow.b("http://gdynamic.qpic.cn/gdynamic/");
        bool1 = false;
      }
      catch (Exception localException)
      {
        boolean bool2;
        localException.printStackTrace();
        bool1 = false;
        continue;
      }
      if (!bool1)
      {
        if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow != null) && (this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing()))
        {
          bool1 = true;
          localObject = (TroopAioADManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
          ((TroopAioADManager)localObject).addObserver(this);
          if ((!this.T) && (!bool1))
          {
            ((TroopAioADManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            this.T = true;
          }
          bool2 = false;
          localObject = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
          if (localObject != null) {
            bool2 = ((TroopGiftManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
          if ((localObject != null) && (bool2) && (bool1)) {
            ((TroopGiftManager)localObject).b = false;
          }
          if ((!bool1) && (bool2))
          {
            TroopGiftManager.jdField_a_of_type_Boolean = true;
            g(true);
          }
          if ((!bool2) && (!bool1))
          {
            aO();
            this.Q = true;
            return;
            bool1 = y();
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        this.R = false;
        h(false);
      }
      else
      {
        continue;
        bool1 = false;
      }
    }
  }
  
  public void aH()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (((TroopInfo)localObject).associatePubAccount <= 0L)) {
        break label118;
      }
      if (!this.L) {
        break label105;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839769);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131365241));
    }
    for (;;)
    {
      this.O = true;
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new oea(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      label105:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839768);
      break;
      label118:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a()))
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364332));
        if (this.L) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839790);
        } else {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839775);
        }
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364330));
        if (this.L) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839789);
        } else {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839774);
        }
      }
    }
  }
  
  protected void aI()
  {
    d(true);
    oec localoec = new oec(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, localoec);
  }
  
  void aJ()
  {
    ThreadManager.a(new ocl(this), 5, null, true);
  }
  
  public void aK()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.a(this.jdField_c_of_type_JavaLangRunnable, 8, null, true);
    }
  }
  
  void aL() {}
  
  protected void aM()
  {
    boolean bool3 = false;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject = null;
    if (localTroopManager != null) {
      localObject = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, troopInfo==null:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    long l;
    do
    {
      return;
      l = ((TroopInfo)localObject).troopCreditLevel;
      if ((l == 1L) || (l == 2L)) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, normal:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + l);
    return;
    boolean bool1;
    if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
    {
      bool1 = true;
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
        break label355;
      }
    }
    label355:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bool1) || (bool2)) {
        bool3 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + bool1 + ", " + bool2);
      }
      localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, getTroopCreditInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ((TroopHandler)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      a(l, bool3);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void aN()
  {
    TroopBindPublicAccountMgr localTroopBindPublicAccountMgr = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((localObject != null) && (localTroopBindPublicAccountMgr != null))
    {
      localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((TroopInfo)localObject).associatePubAccount > 0L))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.L);
        }
        if (localTroopBindPublicAccountMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.f(true);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "tag_red", 0, 0, ((TroopInfo)localObject).troopuin, "", "", "");
        }
      }
    }
  }
  
  public void aO()
  {
    if (!x()) {}
    for (boolean bool = true;; bool = false)
    {
      Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
      localMessage.obj = Boolean.valueOf(bool);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  void aP()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject != null) {
        break label29;
      }
    }
    label29:
    do
    {
      for (;;)
      {
        return;
        localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && ((((TroopInfo)localObject).wMemberNum == 0) || (android.text.TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)))) {
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l));
            ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d("Q.aio.TroopChatPie", 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.aio.TroopChatPie", 2, "getTroopInfoIfNeed failed");
  }
  
  public void aQ()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, null, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.aio.TroopChatPie", 2, localException.toString());
    }
  }
  
  void aR()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground() != null) {
      k();
    }
    a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131428295), true);
    this.jdField_h_of_type_Int = 2130837539;
    this.jdField_i_of_type_Int = 2130837538;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130843013);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131428260));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843454);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131428258));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843457);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839774);
    if ((this.jdField_a_of_type_JavaLangCharSequence != null) && (!this.jdField_a_of_type_JavaLangCharSequence.toString().startsWith(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131364921)))) {
      e(this.jdField_a_of_type_JavaLangCharSequence.toString());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(false);
      }
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      AnonymousChatHelper.a().b();
      aT();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131427539));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428318));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundResource(2130843028);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131428260));
      b(false);
    }
  }
  
  public void aS()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new odr(this));
    if ((this.jdField_k_of_type_AndroidViewView != null) && (this.j != null))
    {
      this.jdField_k_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      this.j.startAnimation(localAlphaAnimation);
    }
  }
  
  public void aT()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new ods(this));
    this.jdField_k_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    this.j.startAnimation(localAlphaAnimation);
  }
  
  void aU()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Long.parseLong(str));
  }
  
  public void aV()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void aW()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载...");
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void aX()
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
    }
  }
  
  public void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals("0"))) {
      ai();
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    if (paramInt2 == 8) {
      if (!this.L) {}
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (this.L)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(0);
      }
      return;
      if (!this.L) {}
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
      return;
    }
    if (paramLong <= 0L)
    {
      b(false);
      return;
    }
    Object localObject = paramLong + "";
    if (paramLong > 99L) {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364372);
    }
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364368, new Object[] { localObject });
    NearbyTroopMemMgr localNearbyTroopMemMgr = NearbyTroopMemMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (!localNearbyTroopMemMgr.a()) {
      if (localNearbyTroopMemMgr.a().jdField_a_of_type_Int == 0) {
        localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364369, new Object[] { localObject, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364370) });
      }
    }
    for (;;)
    {
      if (this.L)
      {
        this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject);
        return;
        if (localNearbyTroopMemMgr.a().jdField_a_of_type_Int == 1) {
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364369, new Object[] { localObject, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364371) });
        } else {
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364368, new Object[] { localObject });
        }
      }
      else
      {
        b(true);
        e((String)localObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "nearby_mber", "exp_nearby_mber", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
        localObject = str;
      }
    }
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.P)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131364717, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      Z();
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    if (b(true)) {
      return;
    }
    super.c();
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.dW = 2;
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    do
    {
      return;
      if (!((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).c(paramString))
      {
        b(false);
        return;
      }
      NearbyTroopMemMgr localNearbyTroopMemMgr = NearbyTroopMemMgr.a(paramString);
      if (localNearbyTroopMemMgr.a())
      {
        if (NetworkUtil.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
        {
          ThreadManager.b().postDelayed(new odz(this, localNearbyTroopMemMgr, paramString), 5000L);
          return;
        }
        b(false);
        return;
      }
      paramString = localNearbyTroopMemMgr.a().b;
    } while (paramString == null);
    b(paramString.size());
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.w = paramInt;
      if (!this.P) {
        break label133;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      AudioUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), false);
      b(true);
    }
    label133:
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711686);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  protected void e(String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8) || (this.jdField_b_of_type_AndroidViewViewGroup == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130840151));
      Drawable localDrawable = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130843460);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable, null, localDrawable, null);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(43, 5000L);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131428260));
  }
  
  protected boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "troopChatPie_onBackEvent 1");
      }
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a();
    }
    return super.e();
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper = new TroopCardAppInfoHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    this.N = true;
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
    ThreadManager.a(new odb(this), 2, null, true);
  }
  
  public void g(boolean paramBoolean)
  {
    if (((a() instanceof SplashActivity)) && (SplashActivity.c != 2)) {}
    TroopGiftManager localTroopGiftManager;
    do
    {
      return;
      localTroopGiftManager = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
    } while (localTroopGiftManager == null);
    localTroopGiftManager.a(this);
    if (paramBoolean) {
      localTroopGiftManager.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "playTroopGiftAnimationPlayList");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new oci(this));
  }
  
  protected void h()
  {
    super.h();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d()) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a() == 10)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar = new TroopAssistTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.jdField_a_of_type_AndroidWidgetToast);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
  }
  
  protected void h(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
    }
    super.h(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    paramIntent = new oef(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
  }
  
  public void h(boolean paramBoolean)
  {
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) == null) {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (-1 != ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).intValue()) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null);
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.e(true);
      } while (!paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(1005);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.e(false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    while ((paramMessage.what == 60) && (this.L))
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundResource(2130839791);
      return true;
      if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow != null) && (this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing())) {
        this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.dismiss();
      }
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = new TroopNewGuidePopWindow(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      Object localObject = new int[2];
      this.jdField_b_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
      int m = a();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationInWindow(arrayOfInt);
      int n = arrayOfInt[1];
      int i1 = localObject[1];
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.a(m, n - i1);
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.a(paramMessage.arg1);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.L);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(false, true);
      continue;
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.isRunning()))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b()))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
          if (((TroopAioMsgNavigateBar)localObject).a.get()) {
            ((TroopAioMsgNavigateBar)localObject).a.set(false);
          }
        }
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  protected void i(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "troopUin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    try
    {
      AVNotifyCenter.VideoRoomInfo_tips localVideoRoomInfo_tips = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
      if (localVideoRoomInfo_tips != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.TroopChatPie", 2, "avType : " + localVideoRoomInfo_tips.jdField_a_of_type_Int);
        }
        if (localVideoRoomInfo_tips.jdField_a_of_type_Int != 2) {
          break label237;
        }
        if (localVideoRoomInfo_tips.jdField_a_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
        }
      }
      else
      {
        super.i(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label237:
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.TroopChatPie", 2, "onShowFirst : invalid uin!");
          }
          localObject = null;
          continue;
          ReportController.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
        }
      } while (((AVNotifyCenter.VideoRoomInfo_tips)localObject).jdField_a_of_type_Int != 10);
      if (!((AVNotifyCenter.VideoRoomInfo_tips)localObject).jdField_a_of_type_Boolean) {
        break label313;
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
      break;
      label313:
      ReportController.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
    }
  }
  
  protected void i(Intent paramIntent)
  {
    int n = 0;
    Object localObject1 = paramIntent.getExtras();
    Object localObject2 = paramIntent.getStringExtra("uin");
    int m = paramIntent.getIntExtra("uintype", -1);
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    if ((!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != m)) {}
    for (this.E = false; (!this.E) || (((Bundle)localObject1).containsKey("forward_type")); this.E = true)
    {
      c(paramIntent);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (paramIntent.getExtras().containsKey("video_play_url")))
    {
      localObject1 = paramIntent.getStringExtra("video_play_url");
      long l = paramIntent.getLongExtra("video_play_msg", 0L);
      m = n;
      if (paramIntent.getBooleanExtra("video_play_feed", false))
      {
        m = n;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a((String)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a);
          return;
        }
      }
      do
      {
        m += 1;
        if (m >= this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount()) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItemId(m) != l);
    }
    for (;;)
    {
      n = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      if ((m < n) || (m > i1 + n - 1)) {
        break;
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(m - n);
      if (paramIntent == null) {
        break;
      }
      localObject2 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(m);
      if ((localObject2 == null) || (!(localObject2 instanceof MessageForStructing))) {
        break;
      }
      localObject2 = (MessageForStructing)localObject2;
      if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForGeneralShare))) {
        break;
      }
      localObject2 = (StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg;
      if (localObject2 == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a((String)localObject1, (StructMsgForGeneralShare)localObject2, paramIntent);
      return;
      if ((this.jdField_g_of_type_Int != 0) || (bool))
      {
        a(true, false);
        return;
      }
      if (((Bundle)localObject1).getLong("res_share_id", 0L) <= 0L) {
        break;
      }
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      return;
      m = -1;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.L = paramBoolean;
    AnonymousChatHelper.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ApolloActionManager.a().jdField_e_of_type_Boolean = paramBoolean;
    Object localObject = ApolloActionManager.a().a;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {}
    for (boolean bool = ((SharedPreferences)localObject).getBoolean("is_apollo_hide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);; bool = false)
    {
      if (!bool) {
        ApolloActionManager.a().a(paramBoolean, false, f());
      }
      if (this.jdField_h_of_type_AndroidViewView == null)
      {
        this.jdField_h_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_h_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_h_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_k_of_type_AndroidViewView == null)
      {
        this.jdField_k_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_k_of_type_AndroidViewView.setBackgroundResource(2130839791);
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_k_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_k_of_type_AndroidViewView, 0);
      }
      if (this.j == null)
      {
        this.j = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.j.setBackgroundResource(2130839791);
        this.j.setVisibility(8);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.j, 0);
      }
      if (this.jdField_i_of_type_AndroidViewView == null)
      {
        this.jdField_i_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_i_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131297409);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_i_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(paramBoolean);
      }
      if (paramBoolean)
      {
        a(-16777216, false);
        this.jdField_h_of_type_Int = 2130839784;
        this.jdField_i_of_type_Int = 2130839783;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297410).setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839791);
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130839803);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840056);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_a_of_type_JavaLangCharSequence = this.jdField_c_of_type_AndroidWidgetTextView.getText();
        }
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131364921) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        b(true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(true);
        }
        this.jdField_i_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener = new odp(this);
        AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(2131364938);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundColor(-16777216);
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          }
        }
      }
      for (;;)
      {
        r();
        n();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
        return;
        aR();
      }
    }
  }
  
  public void j(boolean paramBoolean)
  {
    a(paramBoolean, 0);
  }
  
  public void k(Intent paramIntent)
  {
    int m = 0;
    String str;
    long l;
    if (paramIntent.getExtras().containsKey("video_play_url"))
    {
      str = paramIntent.getStringExtra("video_play_url");
      l = paramIntent.getLongExtra("video_play_msg", 0L);
      if ((paramIntent.getBooleanExtra("video_play_feed", false)) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(str, null, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a);
      }
    }
    else
    {
      return;
    }
    label136:
    if (m < this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount()) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItemId(m) != l) {}
    }
    for (;;)
    {
      int n = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      if ((m < n) || (m > i1 + n - 1)) {
        break;
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(m - n);
      if (paramIntent == null) {
        break;
      }
      Object localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(m);
      if ((localObject == null) || (!(localObject instanceof MessageForStructing))) {
        break;
      }
      localObject = (MessageForStructing)localObject;
      if ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForGeneralShare))) {
        break;
      }
      localObject = (StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg;
      if (localObject == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(str, (StructMsgForGeneralShare)localObject, paramIntent);
      return;
      m += 1;
      break label136;
      m = -1;
    }
  }
  
  public void l(Intent paramIntent)
  {
    if (paramIntent.getExtras().containsKey("video_play_url"))
    {
      paramIntent = paramIntent.getStringExtra("video_play_url");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramIntent, null, null);
    }
  }
  
  public void n()
  {
    if (!this.O) {
      super.n();
    }
    ThreadManager.a(new oeb(this), 8, null, true);
  }
  
  protected void n(int paramInt)
  {
    if (!this.L) {
      super.n(paramInt);
    }
  }
  
  public void o()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ChatSettingForTroop.class);
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("vistor_type", 1);
    Object localObject2;
    int m;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      if (localObject1 == null) {
        break label232;
      }
      localObject1 = ((TroopManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label232;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((android.text.TextUtils.isEmpty((CharSequence)localObject2)) || (android.text.TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label232;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label219;
      }
      m = 1;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (m != 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
        return;
        label219:
        m = 0;
        break;
      }
      label232:
      m = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131297413) && (b(true))) {}
    do
    {
      return;
      super.onClick(paramView);
    } while ((paramView.getId() != 2131296336) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a()));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    TroopInfo localTroopInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() != 0))
    {
      if ((paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '@') && (paramCharSequence.charAt(paramInt1) != 65312)) || (this.n)) {
        break label299;
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null)
      {
        paramCharSequence = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localTroopInfo.troopuin, 3);
        paramCharSequence.putExtra("param_is_pop_up_style", true);
        paramCharSequence.setFlags(603979776);
        if (!this.L) {
          break label253;
        }
        paramCharSequence.putExtra("param_chat_mode", 1);
      }
    }
    for (;;)
    {
      if (super.f() == 21) {
        paramCharSequence.putExtra("param_troop_send_apollo_msg", true);
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramCharSequence, 6001);
      String str1 = "2";
      try
      {
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((localTroopInfo.troopowneruin != null) && (localTroopInfo.troopowneruin.equals(str2)))
        {
          paramCharSequence = "0";
          label216:
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, localTroopInfo.troopuin, "2", paramCharSequence, "");
        }
        label253:
        label299:
        label438:
        label602:
        do
        {
          do
          {
            do
            {
              return;
              paramCharSequence.putExtra("param_chat_mode", 0);
              break;
              paramCharSequence = str1;
              if (localTroopInfo.Administrator == null) {
                break label216;
              }
              paramCharSequence = str1;
              if (!localTroopInfo.Administrator.contains(str2)) {
                break label216;
              }
              paramCharSequence = "1";
              break label216;
              if ((paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '$') && (paramCharSequence.charAt(paramInt1) != 65509) && (paramCharSequence.charAt(paramInt1) != '¥') && (paramCharSequence.charAt(paramInt1) != 65284)) || (this.n)) {
                break label602;
              }
              paramInt2 = 0;
              for (;;)
              {
                if (paramInt2 >= paramCharSequence.length()) {
                  break label438;
                }
                if ((paramInt2 != paramInt1) && ((paramCharSequence.charAt(paramInt2) == '$') || (paramCharSequence.charAt(paramInt2) == 65509) || (paramCharSequence.charAt(paramInt2) == '¥') || (paramCharSequence.charAt(paramInt2) == 65284))) {
                  break;
                }
                paramInt2 += 1;
              }
              paramCharSequence = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            } while ((paramCharSequence == null) || (!TroopInfo.hasPayPrivilege(paramCharSequence.troopPrivilegeFlag, 32)));
            if (paramCharSequence.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
              paramInt1 = 0;
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, paramCharSequence.troopuin + "", paramInt1 + "", "", "");
              TroopGiftUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramCharSequence.troopuin, "input", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              return;
              if (paramCharSequence.isAdmin()) {
                paramInt1 = 1;
              } else {
                paramInt1 = 2;
              }
            }
          } while ((paramInt1 != 0) || (paramInt3 != 1) || (paramCharSequence.length() != 1) || ((paramCharSequence.charAt(0) != '#') && (paramCharSequence.charAt(0) != 65283)) || (this.n) || ((this.L) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131296537) != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)));
          if (QLog.isColorLevel())
          {
            QLog.d("Q.aio.TroopChatPie", 2, "input # ---------------");
            QLog.d("Q.aio.TroopChatPie", 2, "s = " + paramCharSequence + ", start = " + paramInt1 + ", before = " + paramInt2 + ", count = " + paramInt3);
          }
          paramCharSequence = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
        } while (paramCharSequence == null);
        TroopBarUtils.a.clear();
        paramCharSequence.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "pub_talk", "Clk_call", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
      catch (Exception paramCharSequence) {}
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
      if ((ApolloActionManager.a().a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!ApolloActionManager.a().a.getBoolean("is_apollo_hide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false)) && (1 == ApolloActionManager.a().jdField_e_of_type_Int)) {
        ApolloActionManager.a().a(false, false, f());
      }
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  void r(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, (String)localObject1, "", "", "");
      }
      return;
      localObject1 = "1";
      continue;
      localObject1 = "2";
      continue;
      localObject1 = "3";
      continue;
      localObject1 = "4";
      continue;
      localObject1 = "5";
      continue;
      localObject1 = "7";
    }
  }
  
  public void s(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt, 0);
    }
  }
  
  public void t(int paramInt)
  {
    long l = System.currentTimeMillis();
    TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
    localTroopGiftManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, 2, new odw(this, l, localTroopGiftManager, paramInt));
  }
  
  public boolean u()
  {
    return true;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {}
    label339:
    label374:
    do
    {
      do
      {
        do
        {
          return;
          if (!(paramObject instanceof MessageRecord)) {
            break label374;
          }
          if (!(paramObject instanceof ChatMessage)) {
            break;
          }
          paramObservable = (MessageRecord)paramObject;
        } while ((paramObservable.isSendFromLocal()) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != paramObservable.istroop) && ((!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (!MsgProxyUtils.c(paramObservable.istroop)))) || (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()));
        QQMessageFacade.Message localMessage;
        if ((!SystemMsg.isTroopSystemMessage(paramObservable.msgtype)) && (paramObservable.msgtype != 64523) && (paramObservable.msgtype != 63506) && (paramObservable.msgtype != 64489) && (!"1000000".equalsIgnoreCase(paramObservable.senderuin)) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null))
        {
          localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObservable.frienduin, paramObservable.istroop);
          if (localMessage.uniseq == paramObservable.uniseq)
          {
            paramObservable = localMessage.nickName;
            if ((localMessage.selfuin == null) || (!localMessage.selfuin.equals(localMessage.senderuin))) {
              break label339;
            }
            paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
          }
        }
        for (;;)
        {
          Object localObject = paramObservable;
          if (paramObservable != null)
          {
            localObject = paramObservable;
            if (paramObservable.length() > 12) {
              localObject = paramObservable.substring(0, 11) + "...";
            }
          }
          paramObservable = new MsgSummary();
          MsgUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramObservable, (String)localObject, true, false);
          paramObservable = paramObservable.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a((CharSequence)localObject, paramObservable);
          if (!(paramObject instanceof MessageForDeliverGiftTips)) {
            break;
          }
          g(false);
          return;
          if (AnonymousChatHelper.a(localMessage)) {
            paramObservable = AnonymousChatHelper.a(localMessage).b;
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null);
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.g();
      return;
      if ((paramObject instanceof TroopAioAgent.Message))
      {
        b(paramObject);
        return;
      }
    } while (!(paramObject instanceof Integer));
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(30);
  }
  
  protected void w()
  {
    if (this.F)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "hasDestory = true return");
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.j();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
      ChatFragment.a(false, a());
    }
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper != null) {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a();
    }
    AnonymousChatHelper.a().b();
    TroopMemberLbsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    NearbyTroopMemMgr.a();
    if (this.L) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131428295), true);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.isRunning()) {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
    TroopGiftMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.dismiss();
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = null;
    }
    ((TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((TroopAioADManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).deleteObserver(this);
    TroopBindPublicAccountMgr localTroopBindPublicAccountMgr = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    localTroopBindPublicAccountMgr.f("");
    if (localTroopBindPublicAccountMgr.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      localTroopBindPublicAccountMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    s(0);
    this.dW = 0;
    this.Q = false;
    this.S = false;
    this.T = false;
    super.w();
  }
  
  public boolean w()
  {
    return false;
  }
  
  protected boolean x()
  {
    boolean bool = false;
    Object localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    for (;;)
    {
      try
      {
        localObject = ((TroopInfoManager)localObject).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), true);
        if (localObject != null)
        {
          localObject = ((TroopFeedsDataManager)localObject).a();
          bool = ((LinkedHashMap)localObject).isEmpty();
          if (bool) {
            continue;
          }
          bool = true;
          if (!bool) {}
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        bool = false;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.post(new odl(this));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.TroopChatPie.troop.notification_center.auto_pull_down", 2, "autoPullDownFlags:" + ((LinkedHashMap)localObject).toString());
        }
        return bool;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;) {}
      }
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.aio.TroopChatPie", 2, "handleTroopNotificationCenterAutoPullDownLogic, NumberFormatException");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "BizTechReport", ".troop.notification_center", ".troop.notification_center.auto_pull_down", "", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    return bool;
  }
  
  boolean y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "handleTroopNotificationMsg");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.L);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!TroopNotificationHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      odm localodm = new odm(this);
      ThreadManager.b().post(localodm);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\rebuild\TroopChatPie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */