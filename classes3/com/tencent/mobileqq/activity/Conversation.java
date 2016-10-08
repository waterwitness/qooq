package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.InviteStartAudioDialog;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.LocalSearchBar;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.activity.recent.RecentCallObserver;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.activity.recent.RecentReportHelper;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.activity.recent.RecentTroopMenuOption;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.DrawerListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PhoneContactHelper;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.CallTabLightalkConfig;
import com.tencent.mobileqq.jumplightalk.JumpLightalkUtil;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.TraceUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.huangye.C2BUtils;
import cooperation.huangye.HYBridgeActivity;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import lbt;
import lcc;
import lcd;
import lce;
import lcf;
import lcg;
import lch;
import lcm;
import lcn;
import lco;
import lcp;
import lcr;
import lcs;
import lcw;
import lcx;
import lcz;
import lda;
import ldb;
import ldc;
import ldj;
import ldk;
import ldl;
import ldm;
import ldo;
import ldp;
import ldq;
import ldr;
import lds;
import ldt;
import ldu;
import ldv;
import ldw;
import ldx;
import ldy;
import ldz;
import lea;
import leb;
import lec;
import led;
import lee;
import lef;
import leg;
import leh;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class Conversation
  extends Frame
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, RadioGroup.OnCheckedChangeListener, UpgradeTipsDialog.OnPreparedListener, OnRecentUserOpsListener, AppConstants, FrameHelperActivity.DrawerListener, AbsListView.OnScrollListener, OverScrollViewListener, SwipListView.RightIconMenuListener, Observer
{
  public static final int A = 1134042;
  public static final int B = 1010;
  public static final int C = 1013;
  public static final int D = 1014;
  public static final int E = 1016;
  public static final int F = 1017;
  public static final int G = 1019;
  public static final int H = 1020;
  public static final int I = 1021;
  public static final int J = 1022;
  public static final int K = 1023;
  public static final int L = 1024;
  public static final int M = 1025;
  public static final int N = 1026;
  public static final int O = 1029;
  public static final int P = 1030;
  public static final int Q = 1134025;
  public static final int R = 1134026;
  public static final int S = 1031;
  public static final int T = 1032;
  public static final int U = 1033;
  public static final int V = 1035;
  public static final int W = 1048;
  public static final int X = 1042;
  public static final int Y = 1044;
  public static final int Z = 1047;
  public static final int a = 10000;
  protected static final long a = 300000L;
  public static final String a = "conversation";
  private static final int aD = 5;
  private static final int aE = 17;
  public static final int aa = 1040;
  public static final int ab = 1041;
  public static final int ac = 1038;
  public static final int ad = 1039;
  public static final int ae = 9001;
  public static final int af = 16;
  protected static final int ag = 1;
  protected static final int ah = 0;
  protected static final int ai = 1;
  protected static final int aj = 2;
  protected static final int ak = 3;
  public static final int al = 0;
  public static final int am = 1;
  private static final int ar = 12;
  private static final int as = 11;
  private static final int at = 10;
  private static final int au = 9;
  private static final int av = 8;
  private static final int aw = 7;
  private static final int ax = 40001;
  public static final int b = 10001;
  public static final String b = "from";
  public static final int c = 10002;
  public static final String c = "conversation_index";
  public static final int d = 1009;
  private static final String jdField_d_of_type_JavaLangString = "Q.recent";
  public static final int e = 11340003;
  public static final int f = 11340004;
  public static final int g = 11340006;
  public static final int h = 11340007;
  public static final int i = 1134010;
  public static final int j = 1134011;
  public static final int k = 1134012;
  public static final int l = 1134013;
  public static final int m = 1134014;
  public static final int n = 1134015;
  public static final int o = 1134018;
  public static final int p = 1134019;
  public static final int q = 1134020;
  public static final int r = 1134021;
  public static final int s = 1134022;
  public static final int t = 1134024;
  public static final int u = 1134027;
  public static final int v = 1134028;
  public static final int w = 1134029;
  public static final int x = 1134039;
  public static final int y = 1134040;
  public static final int z = 1134041;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  protected Handler.Callback a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver;
  private ConversationHotChatCtrl jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl;
  public QQSettingMe a;
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog;
  public BannerManager a;
  private LocalSearchBar jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private RecentCallHelper jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
  private RecentCallObserver jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver;
  public RecentOptPopBar a;
  private RecentTroopMenuOption jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  protected BizTroopObserver a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  private final ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver;
  private final DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver;
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private final SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver;
  private final TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private final GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver;
  public ConversationHongBao a;
  private PstnObserver jdField_a_of_type_ComTencentMobileqqQcallPstnObserver;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground;
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
  VipGiftManager jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  protected StringBuilder a;
  Comparator jdField_a_of_type_JavaUtilComparator;
  public List a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private lee jdField_a_of_type_Lee;
  private lef jdField_a_of_type_Lef;
  leg jdField_a_of_type_Leg;
  leh jdField_a_of_type_Leh;
  public MqqHandler a;
  public boolean a;
  private int aA;
  private int aB;
  private int aC;
  public int an;
  private int ay;
  private int az;
  public long b;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final List jdField_b_of_type_JavaUtilList;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public boolean b;
  private long jdField_c_of_type_Long;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private MqqHandler jdField_c_of_type_MqqOsMqqHandler;
  public boolean c;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  public boolean d;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  public boolean e;
  private long f;
  public boolean f;
  boolean g;
  boolean h;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  
  public Conversation()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Long = 2000L;
    this.ay = 0;
    this.az = -1;
    this.jdField_b_of_type_JavaUtilList = new ArrayList(40);
    this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = null;
    this.aC = 3;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new lbt(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new leb(this);
    this.jdField_a_of_type_Leg = new leg(this);
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_Leg);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.g = false;
    this.h = false;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new lch(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new lcm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new lcn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new lco(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new lcr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new lcs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new lcw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new lcx(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new lda(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new ldb(this);
    this.jdField_a_of_type_ComTencentAvGaudioAVObserver = new ldc(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new ldj(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ldk(this);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new ldm(this);
    this.jdField_c_of_type_AndroidContentBroadcastReceiver = new ldo(this);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new ldp(this);
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = new ldq(this);
    this.jdField_a_of_type_JavaUtilComparator = new ldu(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver = new ldv(this);
    this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "scrollToTopIfNeccessary: " + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.s());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.s() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
    }
  }
  
  private void B()
  {
    label96:
    int i2;
    if (this.jdField_e_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null)) {
        return;
      }
      int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount();
      int i1 = this.az + 1;
      for (;;)
      {
        if (i1 < i3)
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
          if (!(localObject instanceof RecentBaseData))
          {
            i1 += 1;
          }
          else
          {
            localObject = (RecentBaseData)localObject;
            if (((RecentBaseData)localObject).a())
            {
              i2 = ((RecentBaseData)localObject).b();
              label120:
              if (i2 <= 0) {
                break label234;
              }
              this.az = i1;
            }
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(this.az + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.m(), 0);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "scrollToNextUnreadItem|findUnreadItem:" + bool + ",mCurrentUnreadItem" + this.az);
        return;
        A();
        this.az = -1;
      }
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a();
      return;
      i2 = 0;
      break label120;
      label234:
      break label96;
    }
  }
  
  private void C()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.jdField_f_of_type_Long);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (TimeManager.a().a(str)) {
        this.jdField_f_of_type_Long = l1;
      }
    }
  }
  
  private void D()
  {
    if (LoadingStateManager.a().c()) {
      LoadingStateManager.a().a(3);
    }
  }
  
  private void E()
  {
    if ((!this.i) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.show();
      ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i1 = ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ConfigHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1 + 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void F()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131298442));
    this.jdField_a_of_type_Lee = new lee(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Lee, false);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131296895));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297137));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297785));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297393));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(a().getColor(2131428295));
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297786));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297139));
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper = new RecentCallHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewViewGroup, this, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.h = true;
      c(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297791));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130838317));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837959);
      localObject = a();
      if ((localObject == null) || (!(localObject instanceof SplashActivity))) {
        break label504;
      }
      SplashActivity localSplashActivity = (SplashActivity)localObject;
      localObject = localSplashActivity.jdField_b_of_type_AndroidViewView;
      localSplashActivity.jdField_b_of_type_AndroidViewView = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = new LocalSearchBar(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidWidgetRelativeLayout, a(), (View)localObject, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager = new BannerManager(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 0, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
      localObject = RecentDataListManager.a().jdField_b_of_type_JavaUtilList;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao = new ConversationHongBao(this, this.jdField_a_of_type_AndroidViewViewGroup);
      return;
      c(false);
      break;
      label504:
      localObject = null;
    }
  }
  
  private void G()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    a(1010, 0L, false);
    a(1023, 0L, false);
    E();
    VipBannerInfo.a(this);
    if (!this.jdField_e_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)2);
    }
    H();
  }
  
  private void H()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "removeObservers" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(17);
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
        localObject1 = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (localObject1 != null) {
          ((QCallFacade)localObject1).deleteObserver(this);
        }
        localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
        if (localObject1 != null) {
          ((RedTouchManager)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_Lef != null)
        {
          localObject1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
          if (localObject1 != null) {
            ((PortalManager)localObject1).a(this.jdField_a_of_type_Lef);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
      }
      try
      {
        localObject1 = a();
        ((BaseActivity)localObject1).app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, localException.toString());
          }
        }
      }
    }
  }
  
  private void J()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new lcz(this);
  }
  
  private void K()
  {
    if ((this.l) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks[0] = new lds(this);
  }
  
  private void L()
  {
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()) && (SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sub.uin.all")))
    {
      SubAccountControll localSubAccountControll = (SubAccountControll)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
      if (localSubAccountControll != null)
      {
        ArrayList localArrayList = localSubAccountControll.a("sub.uin.all");
        int i2 = localArrayList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          Pair localPair = (Pair)localArrayList.get(i1);
          localSubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), localPair, new ldt(this, localSubAccountControll, localPair));
          i1 += 1;
        }
      }
    }
  }
  
  private void M()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "checkShowCallTab mCallTabChanged: " + this.q);
    }
    if (this.q)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "checkShowCallTab isCallTabShow: " + bool);
      }
      if (!bool) {
        break label148;
      }
      ((RadioButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297787)).performClick();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a().removeMessages(6);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.i();
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper = null;
      }
      c(false);
    }
    for (;;)
    {
      this.q = false;
      return;
      label148:
      c(true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper = new RecentCallHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewViewGroup, this, this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
      }
      ((RadioButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297787)).performClick();
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.h();
      }
    }
  }
  
  private void N()
  {
    ThreadManager.a(new ldy(this), 5, null, true);
  }
  
  private void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) || (!(paramMessage.obj instanceof UpgradeDetailWrapper))) {}
    do
    {
      return;
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) >= 5)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((ConfigHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.setOnDismissListener(new lec(this));
  }
  
  private boolean a(String paramString, int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt) > 0);
  }
  
  private boolean a(String paramString, List paramList)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramString = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.uin)) && (!paramString.uin.equals("0")))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        InviteBaseData localInviteBaseData = (InviteBaseData)paramList.next();
        if ((localInviteBaseData.jdField_a_of_type_JavaLangString != null) && (localInviteBaseData.jdField_a_of_type_JavaLangString.equals(paramString.uin))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(String paramString)
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      QQToast.a(BaseApplication.getContext(), 2131367256, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
    }
    while (paramString == null) {
      return;
    }
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Intent localIntent = new Intent(a(), MultiVideoEnterPageActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    ArrayList localArrayList = ((DiscussionManager)localObject).a(paramString);
    if (localArrayList != null)
    {
      int i2 = localArrayList.size();
      localObject = new long[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i1);
        if (localDiscussionMemberInfo != null) {
          localObject[i1] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
        }
        i1 += 1;
      }
    }
    for (;;)
    {
      localIntent.putExtra("DiscussUinList", (long[])localObject);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uinType", 3000);
      localIntent.putExtra("Type", 3);
      localIntent.putExtra("GroupId", paramString);
      long l1 = Long.valueOf(paramString).longValue();
      localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l1));
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent);
      a(localIntent);
      a().overridePendingTransition(2130968590, 0);
      return;
      localObject = null;
    }
  }
  
  private void c(long paramLong)
  {
    if (this.jdField_f_of_type_Boolean) {
      a(1016, paramLong, true);
    }
  }
  
  private void d(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation(localTranslateAnimation);
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "addObservers" + paramBoolean + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    AtomicBoolean localAtomicBoolean = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    if (!paramBoolean) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 200L);
      return;
    }
    finally {}
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
    Object localObject2 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    if (localObject2 != null) {
      ((RedTouchManager)localObject2).addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      J();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, ForwardImageProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    try
    {
      localObject2 = new IntentFilter("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      localObject2 = new IntentFilter("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
      a().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      localObject2 = new IntentFilter("android.intent.action.TIME_SET");
      ((IntentFilter)localObject2).addAction("android.intent.action.DATE_CHANGED");
      ((IntentFilter)localObject2).addAction("android.intent.action.TIMEZONE_CHANGED");
      a().registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
        localObject2 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
        if (localObject2 != null)
        {
          if (this.jdField_a_of_type_Lef == null) {
            this.jdField_a_of_type_Lef = new lef(this, null);
          }
          ((PortalManager)localObject2).a(this.jdField_a_of_type_Lef, 3);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
        localObject2 = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (localObject2 != null) {
          ((QCallFacade)localObject2).addObserver(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
        UITools.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, localException.toString());
        }
      }
    }
  }
  
  private void z()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.n);
    }
    if (this.n) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.n = true;
    if (!this.o) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    s();
    BaseApplicationImpl.a.onActivityFocusChanged(a(), true);
  }
  
  public void A_()
  {
    this.k = true;
    if ((!this.n) && (!this.l))
    {
      z();
      StartupTracker.a("Recent_Start", null);
    }
    while (!this.n) {
      return;
    }
    a(1030, 0L, true);
  }
  
  protected int a(String paramString, int paramInt)
  {
    int i1 = 4;
    int i2 = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i2;
    case 1000: 
    case 1004: 
    case 1006: 
    case 1021: 
    case 0: 
      do
      {
        i1 = paramInt;
        return i1;
        paramInt = 1;
      } while (RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
      return 4;
    case 3000: 
      return 2;
    case 1: 
      paramString = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      return 3;
    case 1001: 
    case 1003: 
      return 5;
    case 1005: 
      return 6;
    case 1008: 
    case 1009: 
    case 1012: 
    case 1020: 
    case 1022: 
      return 7;
    case 5000: 
      return 8;
    case 7120: 
    case 7200: 
      return 9;
    case 6000: 
      return 10;
    }
    return 11;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    StartupTracker.a(null, "Recent_Start");
    StartupTracker.a(null, "Recent_CreateView");
    Object localObject1 = a();
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof SplashActivity)))
    {
      localObject2 = (SplashActivity)localObject1;
      localObject1 = ((SplashActivity)localObject2).jdField_a_of_type_AndroidViewView;
      ((SplashActivity)localObject2).jdField_a_of_type_AndroidViewView = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramLayoutInflater.inflate(2130903225, null);
      }
      StartupTracker.a("Recent_CreateView", null);
      return (View)localObject2;
      localObject1 = null;
    }
  }
  
  protected String a()
  {
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i1;
    if (localQQMessageFacade != null)
    {
      i1 = localQQMessageFacade.e();
      if (i1 > 0) {}
    }
    else
    {
      return "消息";
    }
    if (i1 > 99) {
      return "消息" + "(99+)";
    }
    return "消息" + "(" + i1 + ")";
  }
  
  public void a()
  {
    t();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.m();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.j();
    }
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(a().getColor(2131428295));
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(a().getColor(2131428295));
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(paramInt1, paramInt2, paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onActivityResult, [" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    }
    switch (paramInt1)
    {
    }
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
                      } while (a() == null);
                      a().setCanLock(false);
                      return;
                    } while (paramInt2 != 0);
                    y();
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
                    return;
                  } while ((-1 != paramInt2) || (paramIntent == null));
                  paramIntent = paramIntent.getStringExtra("roomId");
                } while (paramIntent == null);
                str1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().getApplicationContext(), paramIntent);
                localObject = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
                ((Intent)localObject).putExtra("uin", paramIntent);
                ((Intent)localObject).putExtra("uintype", 3000);
                ((Intent)localObject).putExtra("uinname", str1);
                RecentUtil.a((Intent)localObject);
                a((Intent)localObject);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
                return;
              } while ((-1 != paramInt2) || (paramIntent == null));
              str1 = paramIntent.getStringExtra("roomId");
              paramIntent = paramIntent.getStringArrayListExtra("qqPhoneUserList");
            } while (str1 == null);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_shortcut_launch", 0, 0, "", "", "", "");
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().put(Long.valueOf(str1), "CREATE_FROM_CALL");
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 3000, str1, true, true, true, null, paramIntent, 4, 6);
            if (this.jdField_c_of_type_Boolean)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 10, 0, "", "", "", "");
              this.jdField_c_of_type_Boolean = false;
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 7, 0, "", "", "", "");
            return;
          } while ((-1 != paramInt2) || (paramIntent == null));
          paramInt1 = paramIntent.getIntExtra("audioType", -1);
          if (paramInt1 == 1)
          {
            paramInt1 = paramIntent.getIntExtra("uinType", 0);
            str1 = paramIntent.getStringExtra("peerUin");
            localObject = paramIntent.getStringExtra("name");
            str2 = paramIntent.getStringExtra("phoneNum");
            paramIntent = paramIntent.getStringExtra("from");
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramInt1, str1, (String)localObject, str2, true, null, true, true, null, paramIntent);
            return;
          }
          if (paramInt1 != 2) {
            break;
          }
          paramInt1 = paramIntent.getIntExtra("uinType", 3000);
          str1 = paramIntent.getStringExtra("roomId");
          localObject = paramIntent.getStringArrayListExtra("qqPhoneUserList");
          paramInt2 = paramIntent.getIntExtra("callType", 2);
          int i1 = paramIntent.getIntExtra("from", 3);
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramInt1, str1, true, true, true, null, (ArrayList)localObject, paramInt2, i1);
          paramInt1 = paramIntent.getIntExtra("reportType", 0);
          if (paramInt1 == 1)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 5, 0, "", "", "", "");
            return;
          }
        } while (paramInt1 != 2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 6, 0, "", "", "", "");
        return;
        if (paramInt1 == 3)
        {
          paramInt1 = paramIntent.getIntExtra("uinType", 0);
          str1 = paramIntent.getStringExtra("peerUin");
          localObject = paramIntent.getStringExtra("name");
          str2 = paramIntent.getStringExtra("phoneNum");
          paramInt2 = paramIntent.getIntExtra("from", 3);
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramInt1, str1, (String)localObject, str2, true, null, true, true, null, null, paramInt2, true);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006406", "0X8006406", 2, 0, "", "", "", "");
          return;
        }
      } while (paramInt1 != 4);
      paramInt1 = paramIntent.getIntExtra("uinType", 0);
      String str1 = paramIntent.getStringExtra("peerUin");
      Object localObject = paramIntent.getStringExtra("name");
      String str2 = paramIntent.getStringExtra("phoneNum");
      String str3 = paramIntent.getStringExtra("selfPhoneNum");
      paramInt2 = paramIntent.getIntExtra("from", 3);
      paramIntent = new PstnSessionInfo();
      paramIntent.jdField_a_of_type_Int = paramInt1;
      paramIntent.jdField_a_of_type_JavaLangString = str1;
      paramIntent.d = ((String)localObject);
      paramIntent.b = str2;
      paramIntent.jdField_c_of_type_JavaLangString = str3;
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramIntent, paramInt2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006406", "0X8006406", 2, 0, "", "", "", "");
      return;
    } while (paramInt2 != -1);
    QQToast.a(a(), 2, a(2131370637), 0).b(a().getTitleBarHeight());
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshRecentList|invalidate to refresh");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt2 <= 10) && (paramInt2 >= 8)) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2);
        return;
        if ((paramInt2 != 10) || ((paramObject instanceof Long))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2 + ", obj: " + paramObject);
      return;
      if (((paramInt2 != 8) && (paramInt2 != 9)) || ((paramObject instanceof String))) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2 + ", obj:" + paramObject);
    return;
    if (!d())
    {
      this.m = false;
      Message localMessage = this.jdField_c_of_type_MqqOsMqqHandler.obtainMessage(11);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramObject;
      this.jdField_c_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    this.m = true;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramInt);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramInt, paramView, paramListView);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    String str;
    RecentUserProxy localRecentUserProxy;
    Object localObject;
    if (paramBoolean)
    {
      str = "1";
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject = paramRecentBaseData.a();
      if ((paramInt != 7000) || (AppConstants.ah.equals(localObject))) {
        break label156;
      }
      SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, paramBoolean);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str, paramString, "");
    }
    for (;;)
    {
      i1 = a(paramRecentBaseData.a(), paramInt);
      paramRecentBaseData = localRecentUserProxy.a(false).iterator();
      paramInt = 0;
      label145:
      while (paramRecentBaseData.hasNext())
      {
        if (((RecentUser)paramRecentBaseData.next()).showUpTime == 0L) {
          break label790;
        }
        paramInt += 1;
      }
      str = "0";
      break;
      label156:
      if (paramInt != 5000) {
        break label216;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData, paramBoolean);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", str, paramString, "");
    }
    label216:
    int i1 = paramRecentBaseData.a();
    if ((localObject == null) || (((String)localObject).length() == 0) || (localRecentUserProxy == null))
    {
      if (QLog.isColorLevel())
      {
        paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
        if (localObject != null) {
          break label305;
        }
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localRecentUserProxy != null) {
          break label311;
        }
      }
      label305:
      label311:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("Q.recent", 2, paramBoolean);
        return;
        paramBoolean = false;
        break;
      }
    }
    paramString = localRecentUserProxy.b((String)localObject, i1);
    if (paramString == null)
    {
      paramString = new RecentUser();
      paramString.uin = ((String)localObject);
      paramString.type = i1;
    }
    for (;;)
    {
      label367:
      int i3;
      if (paramBoolean)
      {
        paramString.showUpTime = (System.currentTimeMillis() / 1000L);
        if (i1 == 1) {
          HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        }
        localRecentUserProxy.a(paramString);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        if ((i1 != 7210) && (i1 != 7120)) {
          break label595;
        }
        i3 = paramRecentBaseData.H;
        paramString = "0X80064C4";
        if (paramBoolean) {
          paramString = "0X80064C3";
        }
        if (i1 != 7120) {
          break label799;
        }
      }
      label461:
      label595:
      label640:
      label790:
      label793:
      label796:
      label799:
      for (int i2 = 1;; i2 = 0)
      {
        localObject = localRecentUserProxy.a(false).iterator();
        i1 = 0;
        if (((Iterator)localObject).hasNext())
        {
          if (((RecentUser)((Iterator)localObject).next()).showUpTime == 0L) {
            break label796;
          }
          i1 += 1;
        }
        for (;;)
        {
          break label461;
          paramString.showUpTime = 0L;
          break label367;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + i2, paramString, paramString, 0, 0, "" + i3, "" + i1, "", "");
          break;
          if (i1 != 1008) {
            break;
          }
          i2 = paramRecentBaseData.H;
          localObject = "0X80064C8";
          if (paramBoolean) {
            localObject = "0X80064C7";
          }
          Iterator localIterator = localRecentUserProxy.a(false).iterator();
          i1 = 0;
          if (localIterator.hasNext())
          {
            if (((RecentUser)localIterator.next()).showUpTime == 0L) {
              break label793;
            }
            i1 += 1;
          }
          for (;;)
          {
            break label640;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramString.uin, (String)localObject, (String)localObject, 0, 0, "" + i2, "" + i1, "", "");
            break;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, str, String.valueOf(paramInt), String.valueOf(i1), "");
            return;
            break label145;
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, RecentUser paramRecentUser)
  {
    if ((paramRecentUser == null) || (paramInt == 0)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshAfterClick|[" + paramRecentUser + "," + paramInt + "]");
      }
    }
    do
    {
      return;
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(paramRecentUser.uin);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.type);
      }
    } while ((paramInt & 0x4) == 0);
    RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, -1);
    QQToast.a(a(), "你已经不在该热聊了", 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    a(0, paramInt1, RecentDataListManager.a(paramString, paramInt2));
  }
  
  public void a(int paramInt, List paramList)
  {
    if (-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a())
    {
      this.jdField_a_of_type_Lee.a(paramInt, paramList);
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(10);
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(9);
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(8);
      if (AppSetting.n) {
        ThreadManager.b().post(new ldz(this));
      }
      return;
    }
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder().append("doRefreshUI|[").append(paramInt).append(",");
      if (paramList != null) {
        break label204;
      }
    }
    label204:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.i("Q.recent", 4, i1 + "]");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        if (paramInt != 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(paramList);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
      }
      if (AppSetting.n) {
        ThreadManager.b().post(new lea(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.aB);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      return;
    }
    if (paramList == null)
    {
      paramInt = 0;
      label221:
      i1 = 0;
      label224:
      if (i1 < paramInt)
      {
        localObject = (RecentBaseData)paramList.get(i1);
        if (localObject != null) {
          break label265;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label224;
      break;
      paramInt = paramList.size();
      break label221;
      label265:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a((RecentBaseData)localObject);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    if (!paramBoolean1)
    {
      D();
      c(800L);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(AVNotifyCenter.class);
    if (localObject != null)
    {
      Message localMessage = ((MqqHandler)localObject).obtainMessage(10010);
      localMessage.obj = Boolean.valueOf(paramBoolean1);
      ((MqqHandler)localObject).sendMessage(localMessage);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(6, 0);
    }
    boolean bool1;
    if (!paramBoolean1)
    {
      bool1 = true;
      LoadingStateManager.a().a(bool1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      if (!bool1) {
        break label300;
      }
    }
    label300:
    for (int i1 = 2;; i1 = 0)
    {
      ((BannerManager)localObject).a(1, i1);
      boolean bool3 = LoadingStateManager.a().e();
      boolean bool2 = bool3;
      if (bool3)
      {
        bool2 = bool3;
        if (paramInt == 1134012) {
          bool2 = false;
        }
      }
      LoadingStateManager.a().b(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      i1 = i2;
      if (bool2) {
        i1 = 2;
      }
      ((BannerManager)localObject).a(7, i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(-1, null);
      d(bool1 | bool2 | paramBoolean2);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(150);
        ((StringBuilder)localObject).append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(LoadingStateManager.a().a()).append(", msg = ").append(paramInt);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(long paramLong)
  {
    a(0, 10, Long.valueOf(paramLong));
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.b();
    }
    super.a(paramConfiguration);
  }
  
  void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "showHongbaoLayer | bitmap is " + paramBitmap);
    }
    if (paramBitmap == null)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_AndroidViewView = null;
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(2130903377, null);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298347);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298346);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new lcd(this));
    }
    Object localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298348);
    ((ImageView)localObject1).setContentDescription("关闭活动提醒");
    ((ImageView)localObject1).setOnClickListener(new lce(this));
    localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298349);
    Object localObject2 = BaseApplicationImpl.a.getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject2).widthPixels;
    int i2 = ((DisplayMetrics)localObject2).heightPixels;
    int i3 = paramBitmap.getWidth();
    int i4 = paramBitmap.getHeight();
    float f1 = i1 / i3;
    float f2 = i2 / i4;
    if (f1 - f2 > 0.0F)
    {
      f1 = f2;
      localObject2 = ((ImageView)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = ((int)(i3 * f1));
      ((ViewGroup.LayoutParams)localObject2).height = ((int)(f1 * i4));
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((ImageView)localObject1).setImageBitmap(paramBitmap);
      paramBitmap = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
      ((ImageView)localObject1).setOnClickListener(new lcf(this, paramBitmap));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
      d(this.jdField_c_of_type_AndroidViewView);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = new StringBuilder().append("");
      if (paramBitmap == null) {
        break label418;
      }
    }
    label418:
    for (i1 = paramBitmap.b();; i1 = -1)
    {
      ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800609F", "0X800609F", 0, 0, i1, "", "", "");
      return;
      break;
    }
  }
  
  public void a(Message paramMessage, boolean paramBoolean)
  {
    if (paramMessage == null) {}
    for (int i1 = 0;; i1 = paramMessage.what)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder(150);
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(LoadingStateManager.a().a()).append(", what = ").append(i1);
        QLog.i("Q.recent", 2, paramMessage.toString());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean) {
        break;
      }
      a(i1, true, paramBoolean);
      return;
    }
    ThreadManager.b().post(new lcp(this, i1, paramBoolean));
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.a()))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!AppConstants.bb.equals(localRecentBaseData.a())));
    int i1;
    int i2;
    if (localRecentBaseData.G == 2)
    {
      i1 = 1;
      if (localRecentBaseData.G != 1) {
        break label194;
      }
      i2 = localRecentBaseData.H;
      label111:
      if (!(paramView.getTag(-1) instanceof Integer)) {
        break label200;
      }
    }
    label194:
    label200:
    for (int i3 = ((Integer)paramView.getTag(-1)).intValue() + 1;; i3 = -1)
    {
      long l1 = ServiceAccountFolderManager.a().b();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8006E12", "0X8006E12", 0, 0, String.valueOf(i1), String.valueOf(i2), String.valueOf(i3), String.valueOf(l1));
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label111;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_e_of_type_Boolean)
    {
      StartupTracker.a(null, "AIO_Click_cost");
      PAStartupTracker.a(null, "pubAcc_aio_open", "");
      ThreadPriorityManager.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "AIOTime onRecentBaseDataClick start");
      }
      paramView = null;
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        localObject2 = (RecentUserBaseData)paramRecentBaseData;
        localObject1 = ((RecentUserBaseData)localObject2).a();
        if ((localObject1 != null) && ((((RecentUser)localObject1).type == 7120) || (((RecentUser)localObject1).type == 7210) || (((RecentUser)localObject1).type == 1008)))
        {
          paramView = "0X80067EC";
          if (((RecentUserBaseData)localObject2).H != 0) {
            break label5029;
          }
          paramView = "0X80067ED";
        }
      }
    }
    label481:
    label515:
    label971:
    label1148:
    label1436:
    label1978:
    label2018:
    label2035:
    label2252:
    label2290:
    label2297:
    label2304:
    label2769:
    label3045:
    label3625:
    label3688:
    label4354:
    label4394:
    label4411:
    label4915:
    label4953:
    label4960:
    label5006:
    label5029:
    for (int i1 = 0;; i1 = 1)
    {
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).type);
      if ((localObject3 != null) && ((localObject3 instanceof MessageForStructing)))
      {
        localObject3 = ((MessageForStructing)localObject3).structingMsg;
        if (localObject3 == null) {}
      }
      for (long l1 = ((AbsStructMsg)localObject3).msgId;; l1 = 0L)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", paramView, paramView, 0, 0, ((RecentUser)localObject1).uin + "", "" + l1, "" + i1, "" + ((RecentUserBaseData)localObject2).H);
        paramView = (View)localObject1;
        RecentReportHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramView);
        a(RecentUtil.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData), paramView);
        if (paramRecentBaseData != null)
        {
          paramRecentBaseData.b();
          this.m = true;
        }
        StartupTracker.a("AIO_Click_cost", null);
        return;
        if ((paramRecentBaseData instanceof RecentCallItem))
        {
          localObject2 = (RecentCallItem)paramRecentBaseData;
          localObject1 = ((RecentCallItem)localObject2).a();
          switch (((RecentCallItem)localObject2).c())
          {
          case 2: 
          default: 
            localObject2 = "99";
          }
        }
        for (;;)
        {
          localObject3 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
          i1 = ((PstnManager)localObject3).a();
          Object localObject5 = ((PstnManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          int i2;
          Object localObject4;
          String str;
          if (localObject1 != null)
          {
            i2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((QCallRecent)localObject1).uin);
            if ((i2 == 2) || (i2 == 4))
            {
              ((QCallRecent)localObject1).isVideo = 1;
              i2 = ((QCallRecent)localObject1).type;
              paramRecentBaseData = null;
              if ((i2 != 1006) && (i2 != 2016)) {
                break label971;
              }
              paramRecentBaseData = ((QCallRecent)localObject1).uin;
              localObject4 = null;
              str = ((QCallRecent)localObject1).troopUin;
              if ((paramView == null) || (paramView.getId() != 2131301466)) {
                break label2304;
              }
              if (i1 != 1) {
                break label1148;
              }
              paramView = new Intent(a(), QCallDetailActivity.class);
              paramView.putExtra("uin", ((QCallRecent)localObject1).uin);
              paramView.putExtra("troop_uin", ((QCallRecent)localObject1).troopUin);
              paramView.putExtra("uintype", i2);
              paramView.putExtra("uinname", paramString);
              paramView.putExtra("bind_type", ((QCallRecent)localObject1).bindType);
              paramView.putExtra("bind_id", ((QCallRecent)localObject1).bindId);
              paramView.putExtra("phonenum", ((QCallRecent)localObject1).phoneNumber);
              paramView.putExtra("extra_type", ((QCallRecent)localObject1).extraType);
              paramView.putExtra("key_huangye_logo_url", ((QCallRecent)localObject1).businessLogo);
              if (!TextUtils.isEmpty(((QCallRecent)localObject1).businessSeId)) {
                paramView.putExtra("key_huangye_business_se_id", ((QCallRecent)localObject1).businessSeId);
              }
              paramView.putExtra("sig", ((QCallRecent)localObject1).lightalkSig);
              paramView.putExtra("entrance", "Conversation");
              if (((QCallRecent)localObject1).type != 3000) {
                break label5006;
              }
              paramBoolean = PstnUtils.a(((QCallRecent)localObject1).troopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              paramView.putExtra("key_from_lightalk_phone_num", paramBoolean);
            }
          }
          for (;;)
          {
            a(paramView);
            if (QLog.isColorLevel()) {
              QLog.d("Q.recent", 2, "sig = " + ((QCallRecent)localObject1).lightalkSig);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_info", 0, 0, "", "", "", "");
            if (((QCallRecent)localObject1).type == 3000) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8E", "0X8004F8E", 0, 0, (String)localObject2, "", "", "");
            }
            for (;;)
            {
              if (((QCallRecent)localObject1).type == 3000)
              {
                if (paramBoolean)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F6", "0X80063F6", 4, 0, "", "", "", "");
                  return;
                  localObject2 = "0";
                  break;
                  localObject2 = "1";
                  break;
                  localObject2 = "2";
                  break;
                  if ((i2 != 1) && (i2 != 3)) {
                    break label481;
                  }
                  ((QCallRecent)localObject1).isVideo = 0;
                  break label481;
                  localObject4 = ((QCallRecent)localObject1).uin;
                  break label515;
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F87", "0X8004F87", 0, 0, (String)localObject2, "", "", "");
                  continue;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F6", "0X80063F6", 3, 0, "", "", "", "");
                return;
              }
            }
            if (((QCallRecent)localObject1).callType == 1)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F6", "0X80063F6", 1, 0, "", "", "", "");
              return;
            }
            if (((QCallRecent)localObject1).callType != 2) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F6", "0X80063F6", 2, 0, "", "", "", "");
            return;
            if (((QCallRecent)localObject1).isVideo()) {}
            for (paramBoolean = false;; paramBoolean = true)
            {
              if (((QCallRecent)localObject1).type == 26)
              {
                OpenSDKUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), ((QCallRecent)localObject1).uin, 0, null, 3);
                return;
              }
              if (((QCallRecent)localObject1).isSystemCall == 1)
              {
                if (((QCallRecent)localObject1).phoneNumber != null)
                {
                  paramRecentBaseData = ((QCallRecent)localObject1).phoneNumber;
                  if (paramRecentBaseData != null)
                  {
                    paramView = PhoneContactHelper.a(paramRecentBaseData);
                    l1 = MessageCache.a();
                    a(new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramView)));
                    paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                    if (i2 != 9502) {
                      break label1436;
                    }
                    if (TextUtils.isEmpty(((QCallRecent)localObject1).phoneNumber)) {
                      ((QCallRecent)localObject1).phoneNumber = ((QCallRecent)localObject1).uin;
                    }
                    v();
                    paramRecentBaseData.a(((QCallRecent)localObject1).uin, paramString, ((QCallRecent)localObject1).businessLogo, ((QCallRecent)localObject1).businessSeId, 9502, l1, ((QCallRecent)localObject1).phoneNumber);
                  }
                }
                for (;;)
                {
                  ReportController.b(null, "CliOper", "", "", "0X8005422", "0X8005422", 0, 0, "", "", "", "");
                  return;
                  if ((i2 == 1006) || (i2 == 56938) || (i2 == 9502))
                  {
                    paramRecentBaseData = ((QCallRecent)localObject1).uin;
                    break;
                  }
                  paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(((QCallRecent)localObject1).uin);
                  if (paramView == null) {
                    break;
                  }
                  paramRecentBaseData = paramView.mobileNo;
                  break;
                  paramRecentBaseData.a(((QCallRecent)localObject1).uin, i2, ((QCallRecent)localObject1).contactId, l1, paramView);
                }
              }
              if (((QCallRecent)localObject1).type == 8)
              {
                i1 = ((QCallRecent)localObject1).extraType;
                paramView = new HashMap();
                paramView.put("dstClient", "Lightalk");
                paramView.put("bindType", String.valueOf(((QCallRecent)localObject1).bindType));
                paramView.put("bindId", ((QCallRecent)localObject1).bindId);
                paramView.put("extraType", String.valueOf(((QCallRecent)localObject1).extraType));
                if (((QCallRecent)localObject1).lightalkSig != null) {
                  paramView.put("sig", HexUtil.a(((QCallRecent)localObject1).lightalkSig));
                }
                if (((QCallRecent)localObject1).extraType == 25) {
                  ReportController.b(null, "CliOper", "", "", "0X8006254", "0X8006254", 0, 0, "", "", "", "");
                }
                for (;;)
                {
                  paramRecentBaseData = ((QCallRecent)localObject1).phoneNumber;
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), i1, (String)localObject4, paramString, paramRecentBaseData, true, ((QCallRecent)localObject1).troopUin, true, true, null, "from_internal", paramView);
                  return;
                  if ((((QCallRecent)localObject1).extraType == 24) || (((QCallRecent)localObject1).bindType == 2) || (((QCallRecent)localObject1).bindType == 3)) {
                    ReportController.b(null, "CliOper", "", "", "0X8006252", "0X8006252", 0, 0, "", "", "", "");
                  }
                }
              }
              long l2;
              if ((((QCallRecent)localObject1).type == 3000) || (((QCallRecent)localObject1).type == 1)) {
                try
                {
                  l1 = Long.parseLong((String)localObject4);
                  i1 = UITools.a(((QCallRecent)localObject1).type);
                  l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1, l1);
                  if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1, l1)) || (l2 == 0L))
                  {
                    paramView = new HashMap();
                    paramView.put("MultiAVType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l1)));
                    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), ((QCallRecent)localObject1).type, (String)localObject4, true, true, null, paramView);
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800486A", "0X800486A", 0, 0, (String)localObject2, "", "", "");
                    return;
                  }
                }
                catch (NumberFormatException paramView)
                {
                  for (;;)
                  {
                    l1 = 0L;
                    continue;
                    b((String)localObject4);
                  }
                }
              }
              if (i2 == 1024) {
                if (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4, i2))
                {
                  CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramString, (String)localObject4, "IvrCallItemEngineFalse");
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049D8", "0X80049D8", 0, 0, "", "", "", "");
                  if (!paramBoolean) {
                    break label2252;
                  }
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004866", "0X8004866", 0, 0, (String)localObject2, "", "", "");
                  paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  if (!((QCallRecent)localObject1).isVideo()) {
                    break label2290;
                  }
                  paramView = "1";
                  ReportController.b(paramRecentBaseData, "CliOper", "", "", "Two_call", "Tc_msg_launch", 0, 0, paramView, (String)localObject2, "", "");
                  paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  if (!((QCallRecent)localObject1).isMissedCall()) {
                    break label2297;
                  }
                }
              }
              for (paramView = "0";; paramView = "1")
              {
                ReportController.b(paramRecentBaseData, "CliOper", "", "", "Msg_tab", "Call_history_dtl", 0, 0, paramView, "", "", "");
                return;
                QQToast.a(paramView.getContext(), 2131363560, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131492908));
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.recent", 2, "Don't support ivr");
                return;
                if (i2 == 1008)
                {
                  v();
                  paramView = new Bundle();
                  paramView.putString("businessName", paramString);
                  paramView.putString("uin", (String)localObject4);
                  paramView.putString("from_where", "callHistoryPage");
                  C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramView);
                  break label1978;
                }
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), i2, (String)localObject4, paramString, paramRecentBaseData, paramBoolean, str, true, true, null, "from_internal");
                break label1978;
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004868", "0X8004868", 0, 0, (String)localObject2, "", "", "");
                break label2018;
                paramView = "0";
                break label2035;
              }
              if (i1 == 0)
              {
                paramView = new Intent(a(), QCallDetailActivity.class);
                paramView.putExtra("uin", ((QCallRecent)localObject1).uin);
                paramView.putExtra("troop_uin", ((QCallRecent)localObject1).troopUin);
                paramView.putExtra("uintype", i2);
                paramView.putExtra("uinname", paramString);
                paramView.putExtra("bind_type", ((QCallRecent)localObject1).bindType);
                paramView.putExtra("bind_id", ((QCallRecent)localObject1).bindId);
                paramView.putExtra("phonenum", ((QCallRecent)localObject1).phoneNumber);
                paramView.putExtra("extra_type", ((QCallRecent)localObject1).extraType);
                paramView.putExtra("key_huangye_logo_url", ((QCallRecent)localObject1).businessLogo);
                if (!TextUtils.isEmpty(((QCallRecent)localObject1).businessSeId)) {
                  paramView.putExtra("key_huangye_business_se_id", ((QCallRecent)localObject1).businessSeId);
                }
                paramView.putExtra("sig", ((QCallRecent)localObject1).lightalkSig);
                paramView.putExtra("entrance", "Conversation");
                a(paramView);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.recent", 2, "sig = " + ((QCallRecent)localObject1).lightalkSig);
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_info", 0, 0, "", "", "", "");
                if (((QCallRecent)localObject1).type == 3000)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8E", "0X8004F8E", 0, 0, (String)localObject2, "", "", "");
                  return;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F87", "0X8004F87", 0, 0, (String)localObject2, "", "", "");
                return;
              }
              paramBoolean = true;
              if (((QCallRecent)localObject1).isVideo()) {
                paramBoolean = false;
              }
              if (((QCallRecent)localObject1).type == 26)
              {
                paramView = new PstnSessionInfo();
                paramView = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, ((QCallRecent)localObject1).uin, ((QCallRecent)localObject1).type);
                if ((paramView.b != null) && (paramView.jdField_c_of_type_JavaLangString != null))
                {
                  i2 = 1;
                  int i3 = 0;
                  i1 = i3;
                  if (localObject5 != null)
                  {
                    i1 = i3;
                    if (i2 != 0)
                    {
                      if (((PstnCardInfo)localObject5).pstn_c2c_call_time <= 0) {
                        break label2769;
                      }
                      i1 = 1;
                    }
                  }
                }
                for (;;)
                {
                  OpenSDKUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), ((QCallRecent)localObject1).uin, i1, paramView, 2);
                  return;
                  i2 = 0;
                  break;
                  if ((((PstnManager)localObject3).b() == 1) && (((PstnCardInfo)localObject5).pstn_c2c_try_status == 0)) {
                    i1 = 2;
                  } else {
                    i1 = 5;
                  }
                }
              }
              if (((QCallRecent)localObject1).isSystemCall == 1)
              {
                if (((QCallRecent)localObject1).phoneNumber != null)
                {
                  paramRecentBaseData = ((QCallRecent)localObject1).phoneNumber;
                  if (paramRecentBaseData != null)
                  {
                    paramView = PhoneContactHelper.a(paramRecentBaseData);
                    l1 = MessageCache.a();
                    a(new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramView)));
                    paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                    if (i2 != 9502) {
                      break label3045;
                    }
                    if (TextUtils.isEmpty(((QCallRecent)localObject1).phoneNumber)) {
                      ((QCallRecent)localObject1).phoneNumber = ((QCallRecent)localObject1).uin;
                    }
                    v();
                    paramRecentBaseData.a(((QCallRecent)localObject1).uin, paramString, ((QCallRecent)localObject1).businessLogo, ((QCallRecent)localObject1).businessSeId, 9502, l1, ((QCallRecent)localObject1).phoneNumber);
                  }
                }
                for (;;)
                {
                  ReportController.b(null, "CliOper", "", "", "0X8005422", "0X8005422", 0, 0, "", "", "", "");
                  return;
                  if ((i2 == 1006) || (i2 == 56938) || (i2 == 9502))
                  {
                    paramRecentBaseData = ((QCallRecent)localObject1).uin;
                    break;
                  }
                  paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(((QCallRecent)localObject1).uin);
                  if (paramView == null) {
                    break;
                  }
                  paramRecentBaseData = paramView.mobileNo;
                  break;
                  paramRecentBaseData.a(((QCallRecent)localObject1).uin, i2, ((QCallRecent)localObject1).contactId, l1, paramView);
                }
              }
              if (((QCallRecent)localObject1).type == 8)
              {
                i1 = ((QCallRecent)localObject1).extraType;
                paramView = new HashMap();
                paramView.put("dstClient", "Lightalk");
                paramView.put("bindType", String.valueOf(((QCallRecent)localObject1).bindType));
                paramView.put("bindId", ((QCallRecent)localObject1).bindId);
                paramView.put("extraType", String.valueOf(((QCallRecent)localObject1).extraType));
                if (((QCallRecent)localObject1).lightalkSig != null) {
                  paramView.put("sig", HexUtil.a(((QCallRecent)localObject1).lightalkSig));
                }
                if (((QCallRecent)localObject1).extraType == 25) {
                  ReportController.b(null, "CliOper", "", "", "0X8006254", "0X8006254", 0, 0, "", "", "", "");
                }
                for (;;)
                {
                  paramRecentBaseData = ((QCallRecent)localObject1).phoneNumber;
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), i1, (String)localObject4, paramString, paramRecentBaseData, true, ((QCallRecent)localObject1).troopUin, true, true, null, "from_internal", paramView);
                  return;
                  if ((((QCallRecent)localObject1).extraType == 24) || (((QCallRecent)localObject1).bindType == 2) || (((QCallRecent)localObject1).bindType == 3)) {
                    ReportController.b(null, "CliOper", "", "", "0X8006252", "0X8006252", 0, 0, "", "", "", "");
                  }
                }
              }
              if ((((QCallRecent)localObject1).type == 3000) || (((QCallRecent)localObject1).type == 1))
              {
                try
                {
                  l1 = Long.parseLong((String)localObject4);
                  i1 = UITools.a(((QCallRecent)localObject1).type);
                  l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1, l1);
                  if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1, l1)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e())) {
                    break label3688;
                  }
                  paramRecentBaseData = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4, ((QCallRecent)localObject1).type);
                  paramView = new ArrayList();
                  if (!TextUtils.isEmpty(paramRecentBaseData))
                  {
                    paramRecentBaseData = PstnUtils.a(paramRecentBaseData);
                    if (paramRecentBaseData != null)
                    {
                      i1 = 0;
                      while (i1 < paramRecentBaseData.size())
                      {
                        paramView.add(((AVPhoneUserInfo)paramRecentBaseData.get(i1)).telInfo.mobile);
                        i1 += 1;
                      }
                    }
                  }
                }
                catch (NumberFormatException paramView)
                {
                  for (;;)
                  {
                    l1 = 0L;
                  }
                  if (paramView.size() > 0)
                  {
                    paramRecentBaseData = PstnUtils.b(paramView);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.recent", 2, "R.id.qq_call_bottom_left --> jsonString = " + paramRecentBaseData);
                    }
                  }
                  if (TextUtils.isEmpty(((QCallRecent)localObject1).pstnInfo)) {
                    break label3625;
                  }
                }
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 3000, ((QCallRecent)localObject1).troopUin, true, true, true, null, paramView, 2, 3);
                for (;;)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800486A", "0X800486A", 0, 0, (String)localObject2, "", "", "");
                  return;
                  ReportController.b(null, "CliOper", "", "", "0X800552A", "0X800552A", 0, 0, "", "", "", "");
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 3000, ((QCallRecent)localObject1).troopUin, true, true, true, null, paramView, 3, 3);
                  continue;
                  if (l2 == 0L)
                  {
                    paramView = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                    if (paramView != null)
                    {
                      paramRecentBaseData = paramView.a((String)localObject4);
                      paramView = new ArrayList();
                      paramRecentBaseData = paramRecentBaseData.iterator();
                      while (paramRecentBaseData.hasNext())
                      {
                        paramString = (DiscussionMemberInfo)paramRecentBaseData.next();
                        if (!paramString.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
                          paramView.add(new InviteBaseData(paramString));
                        }
                      }
                      paramString = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4, ((QCallRecent)localObject1).type);
                      paramRecentBaseData = new ArrayList();
                      if (!TextUtils.isEmpty(paramString))
                      {
                        paramString = PstnUtils.a(paramString);
                        if (paramString != null)
                        {
                          paramString = paramString.iterator();
                          while (paramString.hasNext())
                          {
                            localObject3 = (AVPhoneUserInfo)paramString.next();
                            if (!a(((AVPhoneUserInfo)localObject3).telInfo.mobile, paramView)) {
                              paramView.add(new InviteBaseData((AVPhoneUserInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                            }
                            paramRecentBaseData.add(((AVPhoneUserInfo)localObject3).telInfo.mobile);
                          }
                        }
                      }
                      paramString = a();
                      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      localObject4 = a();
                      localObject5 = ((QCallRecent)localObject1).troopUin;
                      if (TextUtils.isEmpty(((QCallRecent)localObject1).pstnInfo)) {}
                      for (i1 = 2;; i1 = 1)
                      {
                        this.jdField_a_of_type_AndroidAppDialog = new InviteStartAudioDialog(paramString, (QQAppInterface)localObject3, (BaseActivity)localObject4, paramView, paramRecentBaseData, (String)localObject5, i1);
                        this.jdField_a_of_type_AndroidAppDialog.show();
                        break;
                      }
                    }
                  }
                  else
                  {
                    b((String)localObject4);
                  }
                }
              }
              if ((i2 == 1006) || (i2 == 56938) || (i2 == 9502)) {
                localObject3 = ((QCallRecent)localObject1).uin;
              }
              while ((((QCallRecent)localObject1).bindType == 2) || (((QCallRecent)localObject1).bindType == 3) || (((QCallRecent)localObject1).extraType == 25))
              {
                paramView = new HashMap();
                paramView.put("dstClient", "Lightalk");
                paramView.put("bindType", String.valueOf(((QCallRecent)localObject1).bindType));
                paramView.put("bindId", ((QCallRecent)localObject1).bindId);
                paramView.put("extraType", String.valueOf(((QCallRecent)localObject1).extraType));
                if (((QCallRecent)localObject1).lightalkSig != null) {
                  paramView.put("sig", HexUtil.a(((QCallRecent)localObject1).lightalkSig));
                }
                paramRecentBaseData = ((QCallRecent)localObject1).phoneNumber;
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), i2, (String)localObject4, paramString, paramRecentBaseData, paramBoolean, str, true, true, null, "from_internal", paramView);
                return;
                localObject3 = paramRecentBaseData;
                if (i2 == 0)
                {
                  localObject5 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                  localObject3 = paramRecentBaseData;
                  if (localObject5 != null)
                  {
                    localObject5 = ((PhoneContactManager)localObject5).a(((QCallRecent)localObject1).uin);
                    localObject3 = paramRecentBaseData;
                    if (localObject5 != null) {
                      localObject3 = ((PhoneContact)localObject5).mobileNo;
                    }
                  }
                }
              }
              if (((QCallRecent)localObject1).isVideo())
              {
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), i2, (String)localObject4, paramString, (String)localObject3, paramBoolean, str, true, true, null, "from_internal", null);
                return;
              }
              if (i2 == 1024) {
                if (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4, i2))
                {
                  CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramString, (String)localObject4, "IvrCallItemEngineFalse");
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049D8", "0X80049D8", 0, 0, "", "", "", "");
                  if (!paramBoolean) {
                    break label4915;
                  }
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004866", "0X8004866", 0, 0, (String)localObject2, "", "", "");
                  paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  if (!((QCallRecent)localObject1).isVideo()) {
                    break label4953;
                  }
                  paramView = "1";
                  ReportController.b(paramRecentBaseData, "CliOper", "", "", "Two_call", "Tc_msg_launch", 0, 0, paramView, (String)localObject2, "", "");
                  paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  if (!((QCallRecent)localObject1).isMissedCall()) {
                    break label4960;
                  }
                }
              }
              for (paramView = "0";; paramView = "1")
              {
                ReportController.b(paramRecentBaseData, "CliOper", "", "", "Msg_tab", "Call_history_dtl", 0, 0, paramView, "", "", "");
                return;
                QQToast.a(paramView.getContext(), 2131363560, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131492908));
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.recent", 2, "Don't support ivr");
                return;
                if (i2 == 1008)
                {
                  v();
                  paramView = new Bundle();
                  paramView.putString("businessName", paramString);
                  paramView.putString("uin", (String)localObject4);
                  paramView.putString("from_where", "callHistoryPage");
                  C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramView);
                  break label4354;
                }
                if ((((QCallRecent)localObject1).getState(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 5) || (((QCallRecent)localObject1).getState(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 6) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e()))
                {
                  if (((QCallRecent)localObject1).callType == 1)
                  {
                    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), i2, (String)localObject4, paramString, (String)localObject3, true, null, true, true, null, "from_internal");
                    break label4354;
                  }
                  if (((QCallRecent)localObject1).callType == 2)
                  {
                    if (i2 == 2016) {
                      localObject3 = localObject4;
                    }
                    paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
                    paramRecentBaseData = new PstnSessionInfo();
                    paramRecentBaseData.jdField_c_of_type_JavaLangString = (paramView.nationCode + paramView.mobileNo);
                    paramRecentBaseData.b = ((String)localObject3);
                    paramRecentBaseData.d = paramString;
                    paramRecentBaseData.jdField_a_of_type_JavaLangString = ((String)localObject4);
                    paramRecentBaseData.jdField_a_of_type_Int = i2;
                    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramRecentBaseData, 3);
                    break label4354;
                  }
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), i2, (String)localObject4, paramString, (String)localObject3, true, null, true, true, null, null, 3, true);
                  break label4354;
                }
                paramView = new ArrayList();
                paramRecentBaseData = new InviteBaseData();
                paramRecentBaseData.b = paramString;
                paramRecentBaseData.jdField_a_of_type_JavaLangString = ((String)localObject4);
                paramRecentBaseData.jdField_c_of_type_Int = i2;
                paramRecentBaseData.jdField_c_of_type_JavaLangString = ((String)localObject3);
                paramView.add(paramRecentBaseData);
                this.jdField_a_of_type_AndroidAppDialog = new InviteStartAudioDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramView, ((QCallRecent)localObject1).callType);
                this.jdField_a_of_type_AndroidAppDialog.show();
                break label4354;
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004868", "0X8004868", 0, 0, (String)localObject2, "", "", "");
                break label4394;
                paramView = "0";
                break label4411;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.recent", 2, "onRecentBaseDataClick|call is null, data = " + paramRecentBaseData);
              return;
            }
            paramBoolean = false;
          }
          localObject2 = "99";
          localObject1 = null;
        }
      }
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v == null");
      }
    }
    label663:
    do
    {
      do
      {
        return;
        if (paramView.getId() == 2131297818)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
          paramView = new Intent(a(), ForwardRecentActivity.class);
          paramView.putExtra("forward_type", 13);
          a(paramView);
          return;
        }
        if (paramView.getId() == 2131301472)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F82", "0X8004F82", 0, 0, "", "", "", "");
          paramView = a();
          paramObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
          if (!((PhoneContactManagerImp)paramObject).d())
          {
            a(new Intent(paramView, GuideBindPhoneActivity.class));
            return;
          }
          if ((((PhoneContactManagerImp)paramObject).a() != null) && (((PhoneContactManagerImp)paramObject).a().isStopFindMatch))
          {
            paramObject = new Intent(paramView, PhoneLaunchActivity.class);
            ((Intent)paramObject).putExtra("needAlert", true);
            ((Intent)paramObject).putExtra("fromStopAndMatch", true);
            ((Intent)paramObject).putExtra("fromCall", true);
            ((Intent)paramObject).putExtra("leftViewText", "返回");
            paramView.startActivity((Intent)paramObject);
            return;
          }
          paramView = new Intent(a(), PhoneFrameActivity.class);
          paramView.putExtra("key_req_type", 4);
          paramView.putExtra("kSrouce", 6);
          a().startActivity(paramView);
          return;
        }
        if (paramView.getId() == 2131301482)
        {
          paramView = paramView.findViewById(2131297405);
          if ((paramView != null) && (paramView.getVisibility() != 8)) {
            paramView.setVisibility(8);
          }
          paramView = BaseApplicationImpl.getContext().getSharedPreferences("qqhuangye", 0);
          if (paramView.getBoolean("show_reddot", true)) {
            paramView.edit().putBoolean("show_reddot", false).commit();
          }
          paramView = new Intent(a(), HYBridgeActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
          a(paramView);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800521F", "0X800521F", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() == 2131301425)
        {
          paramView = CallTabLightalkConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if (paramView != null)
          {
            if (!JumpLightalkUtil.a(a())) {
              break label663;
            }
            JumpLightalkUtil.a(a(), null, "10001", "com.tencent.mobileqq", "", "0", "0");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8B", "0X8005C8B", 0, 2, "", "", "", "");
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8B", "0X8005C8B", 0, 0, "", "", "", "");
            paramView = BaseApplicationImpl.getContext().getSharedPreferences("call_tab_lightalk_entrance" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
            if (!paramView.getBoolean("show_reddot", true)) {
              break;
            }
            paramView.edit().putBoolean("show_reddot", false).commit();
            return;
            JumpLightalkUtil.a(a(), paramView.h);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8B", "0X8005C8B", 0, 1, "", "", "", "");
          }
        }
        if (paramView.getId() == 2131301492)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C0C", "0X8004C0C", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() == 2131301481)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F85", "0X8004F85", 0, 0, "", "", "", "");
          return;
        }
        if ((paramView.getId() != 2131297720) && (paramView.getId() != 2131297721) && (paramView.getId() != 2131297722) && (paramView.getId() != 2131297723) && (paramView.getId() != 2131297724) && (paramView.getId() != 2131297725) && (paramView.getId() != 2131297726)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, paramView, (String)paramObject, null, true, null, true, true, null, null);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C0D", "0X8004C0D", 0, 0, "", "", "", "");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.b())) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C12", "0X8004C12", 0, 0, "", "", "", "");
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false);
      b(new ldr(this));
      return;
      if (paramView.getId() == 2131301486)
      {
        PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, 17);
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("101300.101301");
        return;
      }
      if (paramView.getId() == 2131301490)
      {
        PhoneContactSelectActivity.a(a(), this.jdField_c_of_type_Boolean, 1400);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F7", "0X80063F7", 0, 0, "", "", "", "");
        return;
      }
    } while (paramView.getId() != 2131301491);
    paramView = new Intent(a(), RecentT9SearchActivity.class);
    paramView.putExtra("key_is_from_try", false);
    a().startActivity(paramView);
    a().overridePendingTransition(2130968592, 2130968589);
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    E();
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    Object localObject;
    if (this.jdField_e_of_type_Boolean)
    {
      paramString = null;
      int i1 = -1;
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        localObject = (RecentUserBaseData)paramRecentBaseData;
        paramString = ((RecentUserBaseData)localObject).a();
        i1 = ((RecentUserBaseData)localObject).O;
      }
      if (paramString != null)
      {
        RecentReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a(paramString);
      }
    }
    for (;;)
    {
      return;
      localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((QCallFacade)localObject).b(paramRecentBaseData.a(), paramRecentBaseData.a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.a() == 3000)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.recent", 2, "delRecentCallByUin Error");
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) && (paramVipGiftDownloadInfo != null) && (paramVipGiftDownloadInfo.jdField_d_of_type_Long == 0L) && (paramVipGiftDownloadInfo.a != 0L)) {
      paramVipGiftManager.a(paramVipGiftDownloadInfo.a);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    label147:
    label232:
    for (;;)
    {
      return;
      this.ay = paramInt;
      if (paramAbsListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
        if ((paramInt == 0) || (paramInt == 1))
        {
          this.az = (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.s() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.m());
          if (this.az < -1) {
            this.az = -1;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
            ThreadPriorityManager.a(false);
          }
          if (paramInt != 0) {
            break label147;
          }
          DynamicFaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          DropFrameMonitor.a().a("list_conv", false);
          ThreadRegulator.a().b(2);
        }
      }
      for (;;)
      {
        if ((paramInt != 0) || (!this.m)) {
          break label232;
        }
        a(100L);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
        ThreadPriorityManager.a(true);
        break;
        DynamicFaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        DropFrameMonitor.a().a("list_conv");
        ThreadRegulator.a().a(2);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramAbsListView, paramInt);
          if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "onScrollStateChanged list idle refresh list");
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(true, true, this.jdField_c_of_type_MqqOsMqqHandler);
          }
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  void a(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "showHongbaoTipsButton | bitmap is null");
      }
      q();
      return;
    }
    o();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131301500));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
      if (this.jdField_a_of_type_Leh == null) {
        this.jdField_a_of_type_Leh = new leh(this, null);
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Leh);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131301501));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.a();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption = new RecentTroopMenuOption(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2]))) {
      a(i1, paramRecentBaseData, paramString2, false);
    }
    do
    {
      while (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[4])))
      {
        if ((paramRecentBaseData instanceof RecentUserBaseData))
        {
          paramString1 = (RecentUserBaseData)paramRecentBaseData;
          RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.a(), true, true);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
        return;
        if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3]))) {
          a(i1, paramRecentBaseData, paramString2, true);
        }
      }
    } while (!Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[5])));
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.uin, paramString1.type, 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
  }
  
  protected void a(List paramList)
  {
    int i1 = 0;
    HotChatManager localHotChatManager;
    label44:
    label50:
    RecentUser localRecentUser;
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null)
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, [");
      }
    }
    else
    {
      localHotChatManager = null;
      if (paramList != null) {
        break label100;
      }
      i1 -= 1;
      if (i1 < 0) {
        break label413;
      }
      localRecentUser = (RecentUser)paramList.get(i1);
      if (localRecentUser != null) {
        break label111;
      }
      paramList.remove(i1);
    }
    label100:
    label111:
    label413:
    label451:
    label454:
    for (;;)
    {
      i1 -= 1;
      break label50;
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      break;
      i1 = paramList.size();
      break label44;
      if ((TextUtils.isEmpty(localRecentUser.uin)) || (TextUtils.isEmpty(localRecentUser.uin.trim())))
      {
        paramList.remove(i1);
        if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel())) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(i1).append(",").append(localRecentUser.type).append(";");
        }
      }
      else if ((localRecentUser.type == 1) && ((localRecentUser.lFlag & 1L) != 0L))
      {
        if ((localHotChatManager != null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label451;
        }
        localHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
      }
      for (;;)
      {
        if ((localHotChatManager == null) || (localHotChatManager.b(localRecentUser.uin))) {
          break label454;
        }
        paramList.remove(i1);
        if ((this.jdField_a_of_type_JavaLangStringBuilder == null) || (!QLog.isDevelopLevel())) {
          break label454;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append("invalide hotchat ").append(i1).append(",").append(localRecentUser.uin).append(";");
        break;
        if ((localRecentUser.type == 3000) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          DiscussionInfo localDiscussionInfo = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(localRecentUser.uin);
          if ((localDiscussionInfo != null) && (localDiscussionInfo.isUIControlFlag_Hidden_RecentUser()))
          {
            paramList.remove(i1);
            if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel())) {
              this.jdField_a_of_type_JavaLangStringBuilder.append("hidden_RecentUser ").append(i1).append(",").append(localRecentUser.uin).append(";");
            }
          }
        }
        break;
        if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel()))
        {
          this.jdField_a_of_type_JavaLangStringBuilder.append("]");
          QLog.i("Q.recent", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        }
        return;
      }
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_f_of_type_Boolean))
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.H();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(16, 0);
    RecentDataListManager.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i2 = 2;
    super.a(paramBoolean);
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    Object localObject = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    if (localObject != null) {
      this.an = ((PstnManager)localObject).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onResume|mLastPstnGaryFlag=" + this.an);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      if (FrameHelperActivity.a()) {
        FrameHelperActivity.n();
      }
      this.jdField_d_of_type_Boolean = false;
    }
    TimeManager.a().d();
    M();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.c();
    }
    if (AppSetting.n) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(true);
    }
    this.k = true;
    a().getWindow().setSoftInputMode(32);
    localObject = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager;
    if (localObject != null)
    {
      VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
      if (localVipGiftDownloadInfo != null)
      {
        a((VipGiftManager)localObject, localVipGiftDownloadInfo);
        if (a((VipGiftManager)localObject, localVipGiftDownloadInfo) == true)
        {
          localObject = a();
          if ((localObject != null) && ((localObject instanceof SplashActivity))) {
            ((SplashActivity)localObject).b();
          }
        }
      }
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      paramBoolean = LoadingStateManager.a().e();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      if (!paramBoolean) {
        break label643;
      }
      i1 = 2;
    }
    for (;;)
    {
      ((BannerManager)localObject).a(7, i1);
      LoadingStateManager.a().b(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != 0)
      {
        i1 = 1;
        label294:
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
        if (i1 == 0) {
          break label655;
        }
        i1 = 2;
        label307:
        ((BannerManager)localObject).a(25, i1);
        if (!FileViewMusicService.a().a()) {
          break label661;
        }
        i1 = 1;
        label327:
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
        if (i1 == 0) {
          break label667;
        }
        i1 = i2;
        label341:
        ((BannerManager)localObject).a(26, i1);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent != null))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent = null;
        }
        this.ay = 0;
        if (!this.n) {
          break label673;
        }
        if (this.jdField_b_of_type_Long != 1000L) {
          this.jdField_b_of_type_Long = 1000L;
        }
        if (!this.o) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
        }
        if ((this.m) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
        }
        a(0L);
        s();
        i();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
        L();
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      try
      {
        ((RedDotRadioButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297788)).performClick();
        if (this.jdField_d_of_type_Boolean)
        {
          if (FrameHelperActivity.a()) {
            FrameHelperActivity.n();
          }
          this.jdField_d_of_type_Boolean = false;
        }
        if (this.g) {
          this.g = false;
        }
        if (AppSetting.j) {
          a().setTitle(a(2131367539));
        }
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new lcc(this), 500L);
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_b_of_type_Boolean = false;
          PhoneContactSelectActivity.a(a(), this.jdField_c_of_type_Boolean, 1400);
        }
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(System.currentTimeMillis());
        ReadInJoyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        label643:
        i1 = 0;
        continue;
        i1 = 0;
        break label294;
        label655:
        i1 = 0;
        break label307;
        label661:
        i1 = 0;
        break label327;
        label667:
        i1 = 0;
        break label341;
        label673:
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1025, 3000L);
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "updateLoadingState, showLoadingCircle = " + paramBoolean1);
    }
    if (paramBoolean1) {
      if (this.jdField_b_of_type_AndroidWidgetImageView == null)
      {
        if (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() != 0) {
          break label193;
        }
        i1 = this.jdField_a_of_type_AndroidWidgetRadioGroup.getId();
        this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(a());
        this.jdField_b_of_type_AndroidWidgetImageView.setId(2131298846);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, i1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(7.0F * DeviceInfoUtil.a()));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      }
    }
    label193:
    while ((this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
      try
      {
        Object localObject = a().getResources().getDrawable(2130838323);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((localObject instanceof Animatable)) {
          ((Animatable)localObject).start();
        }
        if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        return;
        int i1 = this.jdField_a_of_type_AndroidWidgetTextView.getId();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
      if (!this.jdField_f_of_type_Boolean) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null)
    {
      do
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
        if (!((PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78)).c())
        {
          this.jdField_f_of_type_Boolean = true;
          d(true);
          this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(40001, 500L);
          return true;
        }
        this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
        StartupTracker.a("Conversation_PullToRefresh_start", 0L);
        k();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false);
      } while (!QLog.isColorLevel());
      QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      return true;
    }
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(7)) && (!bool)) {
        bool = true;
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramInt, paramView, paramListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqOsMqqHandler, bool);
      bool = false;
      continue;
      bool = NetworkUtil.e(BaseApplication.getContext());
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    if (((!this.k) && (paramMessage.arg1 == 0)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "isRefreshRecentDataNecessary[isForeground:" + this.k + ",msg.arg1:" + paramMessage.arg1 + ",isLogin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin());
      }
      return false;
    }
    return true;
  }
  
  public boolean a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if ((paramVipGiftDownloadInfo == null) || (paramVipGiftManager == null)) {}
    do
    {
      return false;
      if (paramVipGiftDownloadInfo.jdField_d_of_type_Long == 3L) {
        paramVipGiftManager.a(4L, paramVipGiftDownloadInfo.a);
      }
    } while ((paramVipGiftDownloadInfo == null) || (paramVipGiftDownloadInfo.jdField_d_of_type_Long != 2L) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) || (!this.i));
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
      if (!this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.b(paramInt, paramView, paramListView);
  }
  
  public void b(long paramLong)
  {
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramLong);
    }
  }
  
  void b(Bitmap paramBitmap)
  {
    o();
    if (this.jdField_c_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131301502));
      if (this.jdField_a_of_type_Leh == null) {
        this.jdField_a_of_type_Leh = new leh(this, null);
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Leh);
    }
    if (paramBitmap != null)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(a(), paramBitmap, true));
    }
  }
  
  public void b(View paramView) {}
  
  protected void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append("unreadinfo, [");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
        if ((localRecentBaseData != null) && (localRecentBaseData.H > 0)) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentBaseData.a()).append("-").append(localRecentBaseData.a()).append("-").append(localRecentBaseData.H).append(" , ");
        }
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("]");
    QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "updateAccountInfo" + paramBoolean);
    }
    g(false);
    if (paramBoolean)
    {
      LoadingStateManager.a().a();
      RecentDataListManager.a().a();
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
      {
        this.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.J();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog == null) {}
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Message localMessage;
        localException = localException;
        this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = null;
      }
    }
    finally
    {
      localObject = finally;
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = null;
      throw ((Throwable)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(1, 10, Long.valueOf(0L));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_Boolean);
      localMessage = Message.obtain();
      localMessage.what = 16;
      localMessage.arg1 = 1;
      this.jdField_c_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.d();
    }
    if (this.n) {
      this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessage(12);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    a(1035, 100L, false);
    a(1010, 100L, true);
    this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = ((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75));
    this.an = ((PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142)).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "updateAccountInfo|mLastPstnGaryFlag=" + this.an);
    }
    N();
    a(10001, 300L, false);
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (this.n)) {
      a(0L);
    }
    a(1134029, 500L, false);
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public void c()
  {
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    this.aC = 1;
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (int i1 = this.jdField_a_of_type_AndroidWidgetRadioGroup.getId();; i1 = this.jdField_a_of_type_AndroidWidgetTextView.getId())
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.addRule(0, i1);
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public boolean c()
  {
    if (FrameHelperActivity.a())
    {
      FrameHelperActivity.n();
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
      if (localPortalManager != null) {
        localPortalManager.a(a(), false);
      }
      return true;
    }
    return false;
  }
  
  protected void d()
  {
    StartupTracker.a(null, "Recent_OnCreate");
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl = new ConversationHotChatCtrl(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_c_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.c(), this);
    F();
    b(false);
    StartupTracker.a("Recent_OnCreate", null);
    this.aC = 1;
  }
  
  public void d(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(7);
    if (paramBoolean)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(4);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(3);
    }
    if ((bool1) || (bool2)) {
      a(false, true);
    }
    do
    {
      do
      {
        return;
        switch (LoadingStateManager.a().a())
        {
        default: 
          return;
        case 0: 
        case 3: 
          a(false, false);
          return;
        case 1: 
          a(true, false);
        }
      } while (this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(4));
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(4, 180000L);
      return;
      a(true, false);
    } while (this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(3));
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 180000L);
    return;
    a(false, true);
  }
  
  protected boolean d()
  {
    return (this.ay != 0) && (this.ay != 1);
  }
  
  public void e()
  {
    super.e();
    if (AppSetting.n) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
    }
    TimeManager.a().c();
    this.k = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.N();
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.d();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10000);
    this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(10);
    this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(9);
    this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(8);
    this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(16);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.i();
    }
    this.aC = 3;
    ReadInJoyUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void e(boolean paramBoolean) {}
  
  protected void f()
  {
    this.l = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a(null);
    }
    TimeManager.a().a();
    I();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper = null;
    }
    this.jdField_c_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    TroopAssistantManager.a();
    TroopRemindSettingManager.a();
    TroopBarAssistantManager.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.e();
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_Boolean = false;
    super.f();
  }
  
  public void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "notifyCallTabChanged, changed=" + paramBoolean);
    }
    this.q = paramBoolean;
  }
  
  protected void g()
  {
    I();
    p();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.f();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  protected void h()
  {
    super.h();
    B();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onFrameTabClick|mIsChatList:" + this.jdField_e_of_type_Boolean);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.l) || (a() == null) || (a().isFinishing())) {
      return true;
    }
    TraceUtils.a("conv.handleMessage");
    long l1 = System.currentTimeMillis();
    boolean bool1;
    int i1;
    int i2;
    label577:
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
    case 10: 
    case 9: 
    case 8: 
      for (;;)
      {
        TraceUtils.a();
        return true;
        if (!a(paramMessage)) {
          return true;
        }
        TroopAssistantManager.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        C();
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        boolean bool2 = false;
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) {
            bool1 = true;
          }
        }
        Object localObject1 = paramMessage.a(bool1);
        a((List)localObject1);
        paramMessage = RecentDataListManager.a().a;
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject4 = a();
        if (localObject1 != null)
        {
          i1 = ((List)localObject1).size();
          ConversationDataFactory.a((List)localObject1, (QQAppInterface)localObject3, (Context)localObject4, paramMessage, i1);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_JavaUtilComparator);
          r();
          localObject1 = new ArrayList(paramMessage);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject1).sendToTarget();
          b(paramMessage);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {}
          this.jdField_b_of_type_JavaUtilList.clear();
          this.aA = 0;
          this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(10);
          this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          localObject1 = new HashMap();
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          StatisticCollector.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject1, "");
          StartupTracker.a("Conversation_Refresh_global", System.currentTimeMillis() - l1);
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("Q.recent", 4, "REFRESH_FLAG_GLOBAL, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
          continue;
          i1 = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (!a(paramMessage)) {
          return true;
        }
        if (QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        C();
        localObject3 = RecentDataListManager.a().a;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
        a((List)localObject4);
        ((List)localObject3).clear();
        RecentUser localRecentUser;
        String str;
        if (localObject4 == null)
        {
          i1 = 0;
          i2 = 0;
          if (i2 >= i1) {
            break label762;
          }
          localRecentUser = (RecentUser)((List)localObject4).get(i2);
          str = RecentDataListManager.a(localRecentUser.uin, localRecentUser.type);
          localObject2 = RecentDataListManager.a().a(str);
          if (localObject2 != null) {
            break label690;
          }
          localObject2 = ConversationDataFactory.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          paramMessage = (Message)localObject2;
          if (localObject2 != null)
          {
            RecentDataListManager.a().a((RecentBaseData)localObject2, str);
            paramMessage = (Message)localObject2;
          }
        }
        for (;;)
        {
          if (paramMessage != null) {
            ((List)localObject3).add(paramMessage);
          }
          i2 += 1;
          break label577;
          i1 = ((List)localObject4).size();
          break;
          if (!this.jdField_b_of_type_JavaUtilList.contains(str))
          {
            paramMessage = (Message)localObject2;
            if (!this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(localRecentUser.uin, Integer.MIN_VALUE))) {}
          }
          else
          {
            if ((localObject2 instanceof RecentUserBaseData)) {
              ((RecentUserBaseData)localObject2).a(localRecentUser);
            }
            ((RecentBaseData)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
            paramMessage = (Message)localObject2;
          }
        }
        try
        {
          Collections.sort((List)localObject3, this.jdField_a_of_type_JavaUtilComparator);
          r();
          paramMessage = new ArrayList((Collection)localObject3);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
          b((List)localObject3);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.g();
          }
          if (this.aA <= 9) {
            this.aA = 0;
          }
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          paramMessage = new HashMap();
          paramMessage.put(BaseConstants.RDM_NoChangeFailCode, "");
          StatisticCollector.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - l1, ((List)localObject3).size(), paramMessage, "");
          StartupTracker.a("Conversation_Refresh_part", System.currentTimeMillis() - l1);
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("Q.recent", 4, "REFRESH_FLAG_PART, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            paramMessage.printStackTrace();
          }
        }
        if (!a(paramMessage)) {
          return true;
        }
        paramMessage = RecentDataListManager.a().a;
        if (paramMessage == null)
        {
          i1 = 0;
          localObject2 = new ArrayList(i1);
          i2 = 0;
          if (i2 >= i1) {}
        }
        else
        {
          for (;;)
          {
            try
            {
              localObject3 = (RecentBaseData)paramMessage.get(i2);
              if (localObject3 != null) {
                break label1092;
              }
              i2 += 1;
            }
            catch (Exception paramMessage)
            {
              if (!QLog.isDevelopLevel()) {
                continue;
              }
              QLog.e("Q.recent", 4, paramMessage.toString());
              return true;
            }
            i1 = paramMessage.size();
            break;
            localObject4 = RecentDataListManager.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
            if ((this.jdField_b_of_type_JavaUtilList.contains(localObject4)) || (this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(((RecentBaseData)localObject3).a(), Integer.MIN_VALUE))))
            {
              ((RecentBaseData)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
              ((List)localObject2).add(localObject3);
            }
          }
        }
        r();
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1019, 0, 0, localObject2).sendToTarget();
        b(paramMessage);
        if (this.aA <= 8)
        {
          this.aA = 0;
          this.jdField_b_of_type_JavaUtilList.clear();
        }
        this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(8);
        this.jdField_d_of_type_Long = System.currentTimeMillis();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
        StatisticCollector.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject2, "");
        StartupTracker.a("Conversation_Refresh_items", System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
      }
    case 11: 
      label690:
      label762:
      label1092:
      bool1 = a(paramMessage);
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "REFRESH_FLAG_RECENT_ITEMS, [" + paramMessage.arg1 + "," + paramMessage.arg2 + "," + paramMessage.obj + "," + this.n + "," + bool1 + "]");
      }
      if (!bool1) {
        return true;
      }
      i2 = paramMessage.arg2;
      if ((i2 == 8) || (i2 == 9))
      {
        localObject2 = null;
        if ((paramMessage.obj instanceof String)) {
          localObject2 = (String)paramMessage.obj;
        }
        if ((localObject2 != null) && (!this.jdField_b_of_type_JavaUtilList.contains(localObject2))) {
          this.jdField_b_of_type_JavaUtilList.add(localObject2);
        }
        l1 = 0L;
      }
      break;
    }
    for (;;)
    {
      if (i2 >= this.aA)
      {
        i1 = 8;
        for (;;)
        {
          if (i1 < i2)
          {
            this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(i1);
            i1 += 1;
            continue;
            if (!(paramMessage.obj instanceof Long)) {
              break label1875;
            }
            l1 = ((Long)paramMessage.obj).longValue();
            break;
          }
        }
        this.aA = i2;
      }
      if ((!this.n) || (this.jdField_c_of_type_MqqOsMqqHandler.hasMessages(this.aA))) {
        break;
      }
      long l2 = Math.abs(System.currentTimeMillis() - this.jdField_d_of_type_Long);
      l1 = Math.max(this.jdField_b_of_type_Long - l2, l1);
      localObject2 = Message.obtain();
      ((Message)localObject2).arg1 = paramMessage.arg1;
      ((Message)localObject2).what = this.aA;
      this.jdField_c_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject2, l1);
      break;
      TroopAssistantManager.a().i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = ServiceAccountFolderManager.a();
      if (paramMessage != null) {
        paramMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramMessage = TroopBarAssistantManager.a();
      if (paramMessage != null) {
        paramMessage.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
      if (paramMessage != null) {
        paramMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      for (;;)
      {
        paramMessage = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
        if (paramMessage == null) {
          break;
        }
        paramMessage.f();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
        }
      }
      if (!a(paramMessage)) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_MqqOsMqqHandler);
      break;
      g(true);
      u();
      break;
      b(new lcg(this));
      break;
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
      break;
      label1875:
      l1 = 0L;
    }
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "refreshRecentHeadView|mChatAdapter is null.");
      }
      return;
    }
    Message localMessage = this.jdField_c_of_type_MqqOsMqqHandler.obtainMessage(7);
    this.jdField_c_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.jdField_f_of_type_Boolean = true;
      D();
      d(true);
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(7);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
    c(60000L);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void l()
  {
    super.l();
    if (this.jdField_e_of_type_Boolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.d();
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.l();
  }
  
  public void m()
  {
    long l1 = 0L;
    try
    {
      if (!this.p)
      {
        boolean bool = this.l;
        if (!bool) {
          break label26;
        }
      }
    }
    finally
    {
      try
      {
        label26:
        BaseActivity localBaseActivity;
        LayoutInflater localLayoutInflater;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903499, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar = new RecentOptPopBar(localBaseActivity);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new led(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = ((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75));
      }
      catch (Exception localException2)
      {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label313;
        }
      }
      localObject1 = finally;
    }
    return;
    this.p = true;
    localBaseActivity = a();
    localLayoutInflater = LayoutInflater.from(localBaseActivity);
    Object localObject2 = "in main thread ";
    label184:
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, (String)localObject2 + localException2.toString());
    }
    for (;;)
    {
      try
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("device_mode", DeviceInfoUtil.d());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label340;
        }
        localStatisticCollector.a(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
      }
      catch (Exception localException1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, localException1.toString());
      break;
      label313:
      String str1 = "not in main thread ";
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar = null;
      this.p = false;
      break label184;
      label340:
      l1 = 1L;
    }
  }
  
  /* Error */
  public void n()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1328	com/tencent/mobileqq/activity/Conversation:o	Z
    //   6: ifne +14 -> 20
    //   9: aload_0
    //   10: getfield 894	com/tencent/mobileqq/activity/Conversation:l	Z
    //   13: istore 4
    //   15: iload 4
    //   17: ifeq +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 1328	com/tencent/mobileqq/activity/Conversation:o	Z
    //   28: aload_0
    //   29: getfield 3076	com/tencent/mobileqq/activity/Conversation:p	Z
    //   32: ifne +7 -> 39
    //   35: aload_0
    //   36: invokevirtual 3122	com/tencent/mobileqq/activity/Conversation:m	()V
    //   39: aload_0
    //   40: invokevirtual 1381	com/tencent/mobileqq/activity/Conversation:t	()V
    //   43: aload_0
    //   44: aload_0
    //   45: ldc_w 3123
    //   48: invokevirtual 600	com/tencent/mobileqq/activity/Conversation:a	(I)Landroid/view/View;
    //   51: checkcast 1759	android/widget/ImageView
    //   54: putfield 3125	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   57: aload_0
    //   58: invokevirtual 520	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   61: ldc_w 3126
    //   64: invokestatic 3131	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   67: istore_2
    //   68: aload_0
    //   69: invokevirtual 520	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   72: fconst_2
    //   73: invokestatic 3131	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   76: istore_3
    //   77: aload_0
    //   78: new 3133	com/tencent/mobileqq/redtouch/RedTouch
    //   81: dup
    //   82: aload_0
    //   83: invokevirtual 520	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   86: aload_0
    //   87: getfield 3125	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   90: invokespecial 3136	com/tencent/mobileqq/redtouch/RedTouch:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   93: bipush 53
    //   95: invokevirtual 3139	com/tencent/mobileqq/redtouch/RedTouch:a	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   98: iload_3
    //   99: invokevirtual 3141	com/tencent/mobileqq/redtouch/RedTouch:d	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   102: iload_2
    //   103: invokevirtual 3143	com/tencent/mobileqq/redtouch/RedTouch:c	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   106: invokevirtual 3146	com/tencent/mobileqq/redtouch/RedTouch:a	()Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   109: putfield 986	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   112: aload_0
    //   113: invokespecial 2837	com/tencent/mobileqq/activity/Conversation:N	()V
    //   116: aload_0
    //   117: getfield 3125	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   120: aload_0
    //   121: invokevirtual 1772	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   124: aload_0
    //   125: getfield 429	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   128: aload_0
    //   129: getfield 989	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader	Lcom/tencent/mobileqq/widget/PullRefreshHeader;
    //   132: invokevirtual 3149	com/tencent/mobileqq/fpsreport/FPSSwipListView:setOverScrollHeader	(Landroid/view/View;)V
    //   135: aload_0
    //   136: getfield 429	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   139: aload_0
    //   140: invokevirtual 2894	com/tencent/mobileqq/fpsreport/FPSSwipListView:setOverScrollListener	(Lcom/tencent/widget/OverScrollViewListener;)V
    //   143: aload_0
    //   144: getfield 698	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   147: ifnull +17 -> 164
    //   150: aload_0
    //   151: getfield 449	com/tencent/mobileqq/activity/Conversation:jdField_e_of_type_Boolean	Z
    //   154: ifeq +10 -> 164
    //   157: aload_0
    //   158: getfield 698	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   161: invokevirtual 957	com/tencent/mobileqq/activity/recent/BannerManager:h	()V
    //   164: aload_0
    //   165: getfield 698	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   168: ifnull +11 -> 179
    //   171: aload_0
    //   172: getfield 698	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   175: iconst_0
    //   176: invokevirtual 3150	com/tencent/mobileqq/activity/recent/BannerManager:a	(Z)V
    //   179: aload_0
    //   180: sipush 1010
    //   183: lconst_0
    //   184: iconst_0
    //   185: invokevirtual 758	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   188: aload_0
    //   189: sipush 1023
    //   192: lconst_0
    //   193: iconst_0
    //   194: invokevirtual 758	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   197: aload_0
    //   198: invokespecial 760	com/tencent/mobileqq/activity/Conversation:E	()V
    //   201: aload_0
    //   202: getfield 806	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   205: bipush 12
    //   207: invokevirtual 1013	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   210: pop
    //   211: aload_0
    //   212: invokespecial 3152	com/tencent/mobileqq/activity/Conversation:K	()V
    //   215: aload_0
    //   216: getfield 992	com/tencent/mobileqq/activity/Conversation:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   219: ifnonnull +69 -> 288
    //   222: aload_0
    //   223: invokestatic 3157	com/tencent/mobileqq/ar/ARDeviceController:a	()Lcom/tencent/mobileqq/ar/ARDeviceController;
    //   226: invokevirtual 3158	com/tencent/mobileqq/ar/ARDeviceController:a	()Ljava/lang/String;
    //   229: putfield 992	com/tencent/mobileqq/activity/Conversation:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   232: aload_0
    //   233: getfield 992	com/tencent/mobileqq/activity/Conversation:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   236: ifnonnull +52 -> 288
    //   239: aload_0
    //   240: aload_0
    //   241: getfield 604	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   244: ldc_w 3159
    //   247: invokevirtual 606	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   250: checkcast 613	android/widget/RelativeLayout
    //   253: putfield 976	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   256: new 3161	android/opengl/GLSurfaceView
    //   259: dup
    //   260: aload_0
    //   261: invokevirtual 520	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   264: invokespecial 3162	android/opengl/GLSurfaceView:<init>	(Landroid/content/Context;)V
    //   267: astore_1
    //   268: aload_1
    //   269: new 3164	lbz
    //   272: dup
    //   273: aload_0
    //   274: invokespecial 3165	lbz:<init>	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   277: invokevirtual 3169	android/opengl/GLSurfaceView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   280: aload_0
    //   281: getfield 976	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   284: aload_1
    //   285: invokevirtual 3170	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   288: invokestatic 418	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq -271 -> 20
    //   294: ldc_w 3172
    //   297: iconst_2
    //   298: new 420	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 3174
    //   308: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_0
    //   312: getfield 992	com/tencent/mobileqq/activity/Conversation:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   315: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 444	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: goto -304 -> 20
    //   327: astore_1
    //   328: aload_0
    //   329: monitorexit
    //   330: aload_1
    //   331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	Conversation
    //   267	18	1	localGLSurfaceView	android.opengl.GLSurfaceView
    //   327	4	1	localObject	Object
    //   67	36	2	i1	int
    //   76	23	3	i2	int
    //   13	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	327	finally
    //   23	39	327	finally
    //   39	164	327	finally
    //   164	179	327	finally
    //   179	288	327	finally
    //   288	324	327	finally
  }
  
  void o()
  {
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131297794));
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_d_of_type_AndroidViewView = a(2131297159);
    }
    if (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    QQAppInterface localQQAppInterface;
    if (paramInt == 2131297787)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
        paramRadioGroup = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
        if (paramRadioGroup != null) {
          paramRadioGroup.h();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.h = true;
      }
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramRadioGroup = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (paramRadioGroup != null) {
          paramRadioGroup.b(MessageCache.a());
        }
        paramRadioGroup = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
        if (this.g)
        {
          if (paramRadioGroup != null) {
            paramRadioGroup.a(null, 3, false, 0L);
          }
          this.g = false;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.i();
        }
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!this.jdField_e_of_type_Boolean) {
          break label564;
        }
      }
    }
    label564:
    for (paramRadioGroup = "0";; paramRadioGroup = "1")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Msg_tab", "Call_history_tab", 0, 0, paramRadioGroup, "", "", "");
      return;
      if (!this.h) {
        break;
      }
      o();
      this.h = false;
      break;
      if (paramInt != 2131297788) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.N();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
      {
        paramRadioGroup = Message.obtain();
        paramRadioGroup.what = 16;
        this.jdField_c_of_type_MqqOsMqqHandler.sendMessage(paramRadioGroup);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, false);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "Conversation onCheckedChanged is listview scrolling =" + d() + ";mDelayRefresh=" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(true, true, this.jdField_c_of_type_MqqOsMqqHandler);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.h = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.c(false);
      }
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EDB", "0X8004EDB", 0, 0, "", "", "", "");
        if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() != 8))
        {
          this.h = true;
          p();
        }
      }
      paramRadioGroup = BaseApplicationImpl.getContext().getSharedPreferences("call_tab_lightalk_red_dot", 0);
      if (paramRadioGroup.getBoolean("show_reddot", true)) {
        paramRadioGroup.edit().putBoolean("show_reddot", false).commit();
      }
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("101300");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getWidth() - a().getDimensionPixelSize(2131493351) - a().getDimensionPixelSize(2131493355), a().getDimensionPixelSize(2131493356));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_PLUS_REDTOUCH", false);
      N();
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(a(), paramViewStub, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this, this, this);
    }
  }
  
  void p()
  {
    if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131301500));
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          break;
        }
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localQQMessageFacade != null)
        {
          this.aB = localQQMessageFacade.e();
          if (!QLog.isColorLevel()) {
            break;
          }
          NearbyUtils.a("Q.recent", new Object[] { "fetchUnReadCount", Integer.valueOf(this.aB) });
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      this.aB = -1;
    }
  }
  
  public void s()
  {
    RecentCallHelper localRecentCallHelper;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
    {
      if ((!this.k) || (this.jdField_e_of_type_Boolean)) {
        break label51;
      }
      localRecentCallHelper = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
      if (d()) {
        break label46;
      }
    }
    label46:
    for (boolean bool = true;; bool = false)
    {
      localRecentCallHelper.a(bool, true, this.jdField_c_of_type_MqqOsMqqHandler);
      return;
    }
    label51:
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean = true;
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {
      return;
    }
    if (!ThemeBackground.getThemeBackgroundEnable())
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837959);
      this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
    }
    ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground);
    if ((!"null".equals(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path)) && (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837959);
    this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  }
  
  void u()
  {
    b(new ldw(this));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1;
    label32:
    int i1;
    int i2;
    if ((paramObject instanceof MessageRecord))
    {
      localObject1 = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject1).isSendFromLocal()) && (((MessageRecord)localObject1).msgtype == 63534))
      {
        break label32;
        break label32;
      }
      while ((((MessageRecord)localObject1).isSendFromLocal()) && (((MessageRecord)localObject1).msgtype == 63536) && (!this.k)) {
        return;
      }
      if ((((MessageRecord)localObject1).isSendFromLocal()) && ((!this.k) || (TextUtils.equals(((MessageRecord)localObject1).frienduin, AppConstants.aZ)) || (TextUtils.equals(((MessageRecord)localObject1).frienduin, AppConstants.ba))))
      {
        i1 = 9;
        localObject1 = RecentDataListManager.a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
        i2 = 2;
        a(i2, i1, localObject1);
        label125:
        if (!(paramObservable instanceof QCallFacade)) {
          break label580;
        }
        if (!(paramObject instanceof Boolean)) {
          break label464;
        }
        boolean bool = ((Boolean)paramObject).booleanValue();
        if ((!this.jdField_e_of_type_Boolean) && (bool)) {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label663;
          }
        }
      }
    }
    label452:
    label464:
    label541:
    label578:
    label580:
    label658:
    label663:
    for (paramObservable = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);; paramObservable = null)
    {
      if (paramObservable != null) {
        paramObservable.a(false);
      }
      for (;;)
      {
        if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager == null)) {
          break label578;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.h();
        return;
        if ((!this.k) && (RecentUtil.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1024))) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1024, 100L);
        }
        localObject1 = Long.valueOf(0L);
        i1 = 10;
        i2 = 0;
        break;
        if ((paramObject instanceof RecentUser))
        {
          a(200L);
          break label125;
        }
        if ((paramObject instanceof String[]))
        {
          localObject1 = (String[])paramObject;
          if ((localObject1.length != 2) || (!AppConstants.ah.equals(localObject1[0])) || (localObject1[1] == null)) {
            break label125;
          }
          localJSONObject = localObject1[0];
          a(8, localObject1[1], 7000);
          break label125;
        }
        if (!(paramObject instanceof JSONObject)) {
          break label125;
        }
        JSONObject localJSONObject = (JSONObject)paramObject;
        String str;
        for (;;)
        {
          try
          {
            i1 = localJSONObject.getInt("actionType");
            switch (i1)
            {
            }
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              localObject1 = localJSONObject.getString("actionUin");
            }
            catch (JSONException localJSONException2)
            {
              str = null;
            }
            try
            {
              i1 = localJSONObject.getInt("actionUinType");
              if ((-1 != i1) && (localObject1 != null)) {
                break label452;
              }
              a(200L);
            }
            catch (JSONException localJSONException3)
            {
              for (;;)
              {
                continue;
                paramObservable = null;
              }
            }
            localJSONException1 = localJSONException1;
            localJSONException1.printStackTrace();
            i1 = -1;
            continue;
          }
          localJSONException2.printStackTrace();
          i1 = -1;
        }
        a(8, str, i1);
        break label125;
        if (!this.jdField_e_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label658;
          }
          paramObservable = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
          if (paramObservable == null) {}
          for (paramObservable = (Observable)localObject2;; paramObservable = paramObservable.a())
          {
            if ((paramObservable != null) && (paramObservable.size() != 0)) {
              break label541;
            }
            a().runOnUiThread(new ldl(this));
            s();
            break;
          }
          if ((paramObject instanceof Integer))
          {
            if (((Integer)paramObject).intValue() > 0) {
              a().runOnUiThread(new ldx(this));
            }
            s();
          }
        }
      }
      break label32;
      if ((!(paramObservable instanceof RedTouchManager)) || (!(paramObject instanceof BusinessInfoCheckUpdate.AppInfo))) {
        break;
      }
      paramObject = (BusinessInfoCheckUpdate.AppInfo)paramObject;
      paramObservable = ((RedTouchManager)paramObservable).a((BusinessInfoCheckUpdate.AppInfo)paramObject);
      if ((paramObservable == null) || (paramObservable.size() <= 0)) {
        break;
      }
      paramObservable = (VipBannerInfo)paramObservable.get(0);
      if ((paramObservable.e < 1) || (paramObservable.e > 4)) {
        break;
      }
      VipBannerInfo.b(this);
      return;
    }
  }
  
  void v()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("curPageName", "callHistoryPage");
    localHashMap.put("category", "");
    localHashMap.put("businessName", "businessName");
    localHashMap.put("operPosition", "");
    localHashMap.put("operation", "clickAccessBtn");
    localHashMap.put("termType", "1");
    localHashMap.put("termVersion", "6.5.5");
    localHashMap.put("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localHashMap.put("cityName", "");
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actQQYellowpageEvt", true, 0L, 0L, localHashMap, null);
  }
  
  public void w()
  {
    super.w();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\Conversation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */