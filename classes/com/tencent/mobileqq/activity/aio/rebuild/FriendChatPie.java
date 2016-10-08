package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.DoubleVideoGuideActivity;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTips;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.AIOJumpLightalkConfig;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.VipGifObserver;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager;
import com.tencent.mobileqq.servlet.ReduFriendObserver;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import nxs;
import nxt;
import nxu;
import nxv;
import nxw;
import nxx;
import nxy;
import nya;
import nyb;
import nyc;
import nyd;
import nye;

public class FriendChatPie
  extends BaseChatPie
{
  public static final String an = FriendChatPie.class.getSimpleName();
  public boolean J;
  private boolean K;
  private boolean L;
  private boolean M = true;
  private boolean N;
  public FriendHotTipsBar a;
  public GamePartyTipsBar a;
  private GatherContactsTips jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new nxt(this);
  private StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new nyd(this);
  private AIOJumpLightalkConfig jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig;
  protected VipGifObserver a;
  private ReduFriendObserver jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver = new nyc(this);
  public QidianManager a;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new nxv(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new nxu(this);
  Runnable b;
  protected MessageObserver c;
  Runnable c;
  private long h = -1L;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FriendChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_JavaLangRunnable = new nxw(this);
    this.jdField_c_of_type_JavaLangRunnable = new nxx(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver = new nyb(this);
    this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver = new nye(this);
    if (paramQQAppInterface.a(164)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)paramQQAppInterface.getManager(164));
    }
  }
  
  private void b(long paramLong)
  {
    VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
    if ((localVipGiftDownloadInfo != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && (localVipGiftDownloadInfo.b.equalsIgnoreCase(a())) && (localVipGiftDownloadInfo.d == 2L) && (paramLong == localVipGiftDownloadInfo.a)) {
      localVipGiftManager.a(localVipGiftDownloadInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
  }
  
  private void r(int paramInt)
  {
    FriendsManager localFriendsManager;
    String str;
    if (AppSetting.j)
    {
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      str = this.jdField_b_of_type_AndroidWidgetTextView.getContentDescription().toString();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 2130843008: 
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372673, new Object[] { Integer.valueOf(localFriendsManager.d) }));
      return;
    case 2130843005: 
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372676, new Object[] { Integer.valueOf(localFriendsManager.g) }));
      return;
    case 2130843006: 
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372671, new Object[] { Integer.valueOf(localFriendsManager.b) }));
      return;
    case 2130843003: 
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372672, new Object[] { Integer.valueOf(localFriendsManager.c) }));
      return;
    case 2130843007: 
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372675, new Object[] { Integer.valueOf(localFriendsManager.f) }));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372676, new Object[] { Integer.valueOf(localFriendsManager.g) }));
  }
  
  protected void A()
  {
    super.A();
    ApolloActionManager.a().d();
  }
  
  protected void B()
  {
    super.B();
    ((OlympicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a().b();
  }
  
  protected void N()
  {
    if ((this.L) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return;
    }
    super.N();
  }
  
  protected void U()
  {
    StartupTracker.a(null, "AIO_onShow_business");
    super.U();
    this.L = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.K = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_onShow_business", null);
    ThreadManager.a(new nya(this), 8, null, false);
  }
  
  protected void V()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      if (this.M)
      {
        this.M = false;
        ThreadManager.a(this.jdField_c_of_type_JavaLangRunnable, 8, null, true);
      }
      super.V();
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      aA();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(an, 2, "friendchatpie onShow_otherThings, " + localNumberFormatException.toString());
        }
      }
    }
  }
  
  public int a(String paramString)
  {
    int j = -1;
    paramString = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    ExtensionInfo localExtensionInfo = paramString.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    boolean bool = paramString.d();
    int k = paramString.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localExtensionInfo, bool);
    int m = paramString.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localExtensionInfo, bool);
    int n = paramString.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localExtensionInfo, bool);
    int i;
    if (k == 0) {
      if (m == 0)
      {
        if (n <= 0) {
          break label289;
        }
        if (n == 2)
        {
          i = 2130843005;
          j = 2;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(an, 2, "getShowInteractiveType showType=" + j + "closeFriendType=" + k + "interactivetype=" + m + "linkType=" + n);
      }
      r(i);
      return i;
      if (n == 1)
      {
        i = 2130843008;
        j = 2;
        continue;
        if (m == 2)
        {
          i = 2130843003;
          j = 1;
        }
        else if (m == 1)
        {
          i = 2130843006;
          j = 1;
          continue;
          if (k == 1)
          {
            i = 2130843007;
            j = 0;
          }
          else if (k == 2)
          {
            i = 2130843004;
            j = 0;
          }
          else
          {
            i = -1;
            j = 0;
          }
        }
        else
        {
          i = -1;
          j = 1;
        }
      }
      else
      {
        i = -1;
        j = 2;
        continue;
        label289:
        i = -1;
      }
    }
  }
  
  public AIOJumpLightalkConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig;
  }
  
  public QQRecorder.RecorderParam a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      boolean bool = super.n();
      return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
    }
    return new QQRecorder.RecorderParam(RecordParams.f, 0, 0);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(an, 2, "showAddFriendActivity-->uinType=" + paramInt1 + " peerUin=" + paramString1 + " name=" + paramString2 + " phoneNum=" + paramString3 + " srcId=" + paramInt2);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, DoubleVideoGuideActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("uinType", paramInt1);
    localIntent.putExtra("peerUin", paramString1);
    localIntent.putExtra("name", paramString2);
    localIntent.putExtra("phoneNum", paramString3);
    localIntent.putExtra("sourceId", paramInt2);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    super.a(paramEmoticonInfo);
    if (this.K)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.K);
      this.K = false;
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("PREVIOUS_WINDOW");
    if ((str != null) && (str.equals(FriendProfileCardActivity.class.getName()))) {
      this.h = NetConnInfoCenter.getServerTime();
    }
    this.J = true;
    return super.a(paramBoolean);
  }
  
  public void aB()
  {
    if (QLog.isColorLevel()) {
      QLog.d(an, 2, "==refreshTitleReativeIcon==");
    }
    if (!b(2131296642)) {
      c(2130840985, 2131296648);
    }
  }
  
  protected void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if (!b(2131296642)) {
      c(2130840985, 2131296648);
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool = false;
    int i = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (i != -1)
    {
      d(i, paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(2131296648, Boolean.valueOf(false));
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(an, 2, "updateSession_updateInteractive showInteractive=" + bool);
      }
      return bool;
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, this.jdField_b_of_type_AndroidWidgetTextView.getPaddingTop(), 0, this.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramInt, Boolean.valueOf(false));
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(2131296648, Boolean.valueOf(false));
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.K)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.K);
      this.K = false;
    }
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected boolean e()
  {
    if ((this.L) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    return super.e();
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.a = 0L;
  }
  
  protected void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips = new GatherContactsTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
  }
  
  protected void i(int paramInt)
  {
    super.i(paramInt);
    if (BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164));
    }
  }
  
  protected void i(Intent paramIntent)
  {
    super.i(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips.a();
    }
  }
  
  protected void l()
  {
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      this.jdField_a_of_type_Boolean = true;
    }
    v();
  }
  
  protected void n()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new nxy(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131367630));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof MessageForStructing)) && (!((MessageForStructing)paramObject).isread))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramObject;
      if ((localMessageForStructing == null) || (localMessageForStructing.structingMsg == null) || (localMessageForStructing.structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(localMessageForStructing.structingMsg.mResid)) || (!((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75)).a(localMessageForStructing))) {}
    }
    super.update(paramObservable, paramObject);
    if ((paramObject != null) && ((paramObject instanceof MessageForText)))
    {
      paramObservable = (MessageForText)paramObject;
      paramObject = paramObservable.msg;
      AioVipKeywordHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)paramObject, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
    }
    ChatActivityFacade.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
  }
  
  protected void v()
  {
    Object localObject;
    if ((this.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentQidianQidianManager == null) || (!this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))))
    {
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (!k()) {
        break label52;
      }
    }
    label52:
    do
    {
      do
      {
        do
        {
          return;
          localObject = ((FriendsManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((localObject == null) || ((ContactUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) == 0) && ((TextUtils.isEmpty(((Friends)localObject).strTermDesc)) || (!((Friends)localObject).strTermDesc.contains("TIM"))))) {
            break;
          }
          localObject = ContactUtils.b((Friends)localObject);
          b(true);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        } while (!I);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        return;
      } while (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0);
      b(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 5);
    FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  protected void w()
  {
    if (this.h > 0L) {
      ThreadManager.b().post(new nxs(this));
    }
    if (this.F) {
      if (QLog.isColorLevel()) {
        QLog.d(an, 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 61515);
        MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 61514);
      }
      this.J = false;
      super.w();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a.setCallback(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a = null;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips.a()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips.b()))) {
        ThreadManager.b(this.jdField_b_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\rebuild\FriendChatPie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */