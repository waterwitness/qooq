package com.tencent.mobileqq.activity;

import FileUpload.UploadUpsInfoRsp;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qq.jce.wup.UniAttribute;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileGameView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfilePhotoView;
import com.tencent.mobileqq.profile.view.ProfileShoppingView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.PersonalCardUrlInfo;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.OnGetPhotoWallListener;
import com.tencent.mobileqq.widget.PerfRelativeLayout;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.PullToZoomListView;
import com.tencent.widget.XListView.MotionEventInterceptor;
import com.tencent.widget.XSimpleListAdapter;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.CoverCacheData;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;
import ljy;
import ljz;
import lka;
import lkb;
import lkc;
import lke;
import lkf;
import lkg;
import lki;
import lkj;
import lkk;
import lkq;
import lku;
import lkv;
import lkw;
import lkx;
import lky;
import lkz;
import lla;
import llb;
import llc;
import lle;
import llf;
import llg;
import llh;
import lli;
import llj;
import llk;
import lll;
import llm;
import lln;
import llp;
import llr;
import lls;
import llu;
import llv;
import llw;
import lly;
import llz;
import lmf;
import lmh;
import lmi;
import lmk;
import lml;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements XListView.MotionEventInterceptor, Observer
{
  private static final String B = "FriendProfileCardActivity";
  public static final float a = 16.0F;
  public static final int a = 30;
  public static long a = 0L;
  public static final String a = "Vip_SummaryCard";
  public static final float b = 0.125F;
  public static final int b = 5;
  private static final int cA = 1;
  private static final int cB = 0;
  private static final int cC = 1;
  private static final int cD = 2;
  private static final int cE = 3;
  private static final int cF = 4;
  private static final int cG = 5;
  private static final int cH = 6;
  private static final int cI = 7;
  private static final int cJ = 8;
  private static final int cK = 9;
  private static final int cL = 3;
  private static final int cM = 4;
  private static final int cN = 5;
  private static final int cO = 6;
  private static final int cP = 10;
  private static final int cQ = 12;
  private static final int cR = 13;
  private static final int cS = 100;
  private static final int cT = 5;
  private static final int cV = 1;
  private static final int cW = 2;
  private static final int cX = 3;
  private static final int cY = 4;
  private static final int cZ = 5;
  private static final int da = 6;
  private static final int db = 7;
  private static final int dc = 8;
  private static final int dd = 9;
  private static final int de = 10;
  public static final String f = "is_binding_shop";
  static long g = 0L;
  public static final int h = 3;
  public static long h;
  Dialog jdField_a_of_type_AndroidAppDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lke(this);
  public DialogInterface.OnClickListener a;
  public Intent a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Drawable a;
  public Uri a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new llb(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new lkq(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new lkk(this);
  public View a;
  public ViewGroup a;
  public AlphaAnimation a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new lle(this);
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public PstnSessionInfo a;
  public ProfileActivity.CardContactInfo a;
  public ApolloSurfaceView a;
  public ApolloBoxEnterView a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new llz(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ljz(this);
  protected TroopObserver a;
  OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = new lll(this);
  PreloadProcHitPluginSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.a());
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("profile_card", "com.tencent.mobileqq:web");
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new lmh(this);
  public ProfileBusiEntry a;
  public ProfileCardInfo a;
  public ProfileShoppingPhotoInfo a;
  public ProfileHeaderView a;
  public PstnCardInfo a;
  public PstnManager a;
  public RedTouch a;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new lla(this);
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new llp(this);
  protected QQCustomDialog a;
  public TimeTraceUtil a;
  public OnGetPhotoWallListener a;
  public ProfileCardMoreInfoView a;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public BusinessInfoCheckUpdate.AppInfo a;
  public WeakReferenceHandler a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new lln(this);
  public ActionSheet a;
  ListView.OnScrollChangeListener jdField_a_of_type_ComTencentWidgetListView$OnScrollChangeListener = new llm(this);
  public PullToZoomListView a;
  public ImmersiveTitleBar2 a;
  Runnable jdField_a_of_type_JavaLangRunnable = new llw(this);
  public ArrayList a;
  public HashMap a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  private long ar;
  public long b;
  public DialogInterface.OnClickListener b;
  public Uri b;
  private Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new lky(this);
  View jdField_b_of_type_AndroidViewView;
  public AlphaAnimation b;
  public ImageView b;
  public TextView b;
  private CardObserver jdField_b_of_type_ComTencentMobileqqAppCardObserver = new lmf(this);
  protected QQCustomDialog b;
  public QQProgressDialog b;
  public WeakReferenceHandler b;
  public Runnable b;
  public String b;
  public boolean b;
  public int[] b;
  public float c;
  public int c;
  public long c;
  public DialogInterface.OnClickListener c;
  public View c;
  public TextView c;
  public String c;
  public boolean c;
  private int cU;
  public int d;
  public long d;
  public DialogInterface.OnClickListener d;
  View d;
  public TextView d;
  public String d;
  public boolean d;
  public int e;
  long jdField_e_of_type_Long;
  public View e;
  public String e;
  boolean jdField_e_of_type_Boolean = false;
  public int f;
  long jdField_f_of_type_Long;
  private View jdField_f_of_type_AndroidViewView;
  public boolean f;
  public int g;
  public String g;
  protected boolean g;
  public String h;
  public int i;
  long i;
  public int j;
  public int k;
  private boolean k;
  public int l;
  private boolean l;
  protected int m;
  private boolean m;
  public int n;
  private boolean n;
  public int o = 30000;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_h_of_type_Long = 2000L;
  }
  
  public FriendProfileCardActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_g_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "is_binding_shop";
    this.jdField_k_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ljy(this);
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new llf(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new llg(this);
    this.jdField_b_of_type_JavaLangRunnable = new llh(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new lli(this);
    this.jdField_d_of_type_AndroidContentDialogInterface$OnClickListener = new llj(this);
    this.jdField_h_of_type_JavaLangString = null;
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null) {}
    TroopHandler localTroopHandler;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, "requestJoinedTroopThirdPartAppEntrance");
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shouldShowJoinedTroop()));
      localTroopHandler = (TroopHandler)this.app.a(20);
    } while ((localTroopHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null));
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin != null) && (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin) != 0L)) {
          break label141;
        }
        String str1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        localTroopHandler.a(str1, 0, 1);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FriendProfileCardActivity", 2, "NumberFormatException");
      return;
      label141:
      String str2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
  }
  
  private void B()
  {
    if (getIntent().getIntExtra("requestCode", -1) == 1023)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("intent_key_has_ever_vote", this.jdField_e_of_type_Boolean);
      setResult(-1, localIntent);
    }
  }
  
  private void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update buttons");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      a(1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
    {
      a(9);
      return;
    }
    boolean bool1 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool2 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((bool1) && (bool2) && (bool3))
    {
      a(2);
      return;
    }
    if ((bool1) && (bool2))
    {
      a(3);
      return;
    }
    if ((bool2) && (bool3))
    {
      a(4);
      return;
    }
    if ((bool1) && (bool3))
    {
      a(5);
      return;
    }
    if (bool1)
    {
      a(6);
      return;
    }
    if (bool2)
    {
      a(7);
      return;
    }
    if (bool3)
    {
      a(5);
      return;
    }
    a(0);
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localRedTouchManager.a(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    localRedTouchManager.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  private void E()
  {
    if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0))
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      if (localRedTouchManager != null) {
        localRedTouchManager.b(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      }
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
    }
  }
  
  private void F()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardLayoutStart", true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout");
    }
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    int i1 = ((Resources)localObject).getDimensionPixelSize(2131492908);
    this.jdField_e_of_type_Int = (((Resources)localObject).getDimensionPixelSize(2131493097) - i1 - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2130904313, null);
    if ((this.jdField_e_of_type_AndroidViewView instanceof PerfRelativeLayout)) {
      ((PerfRelativeLayout)this.jdField_e_of_type_AndroidViewView).setOnDrawCompleteListener(this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener);
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131302288);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView = ((PullToZoomListView)this.jdField_e_of_type_AndroidViewView.findViewById(2131297613));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOverScrollDistance(0);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnScrollChangeListener(this.jdField_a_of_type_ComTencentWidgetListView$OnScrollChangeListener);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_d_of_type_AndroidViewView = new View(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.b(this.jdField_d_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131302291);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131297083));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131297183));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131428239));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131297392));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131297139));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_e_of_type_AndroidViewView.findViewById(2131297137));
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130904293, null);
      localObject = View.inflate(this, 2130904290, null);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.a((View)localObject);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject).findViewById(2131302202));
      localObject = new DataTag(29, null);
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(localObject);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302203);
      if (localObject != null) {}
      try
      {
        localObject = (Animatable)((ImageView)localObject).getDrawable();
        if (!((Animatable)localObject).isRunning()) {
          ((Animatable)localObject).start();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302215));
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.app, this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.addOnLayoutChangeListener(new lkg(this));
        }
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302216));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302290));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131301066));
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "initContentView add timeout msg");
          }
          localObject = this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(10);
          this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject, 10000L);
        }
        this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setAdapter(new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView));
        super.setContentView(this.jdField_e_of_type_AndroidViewView);
        getWindow().setBackgroundDrawable(null);
        e(null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardLayoutEnd", "initCardLayoutStart", false);
        return;
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void G()
  {
    Object localObject2;
    Object localObject1;
    String str1;
    String str2;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 40) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
    {
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      localObject1 = "qita";
      str1 = "";
      str2 = "0";
      if (ClubContentJsonTask.a != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label492;
        }
        str1 = ClubContentJsonTask.a.jdField_a_of_type_JavaLangString;
      }
      label110:
      if (!this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        str2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(str1)) {
        break label502;
      }
      localObject1 = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&qq=%s&aid=%s&_wv=5123", new Object[] { str2, localObject2 }) + "&adtag=" + (String)localObject1;
      long l1 = System.currentTimeMillis();
      if (ProfileActivity.a(this.jdField_e_of_type_Long, l1))
      {
        this.jdField_e_of_type_Long = l1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQVipWeb() url = " + (String)localObject1);
        }
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.app.a());
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        startActivity((Intent)localObject2);
        localObject1 = this.app;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label631;
        }
      }
    }
    label492:
    label502:
    label631:
    for (int i1 = 23;; i1 = 24)
    {
      ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "vip", "logo_in", i1, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
        localObject1 = "geren";
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
        localObject1 = "qun";
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
        localObject1 = "taolunzu";
        break;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
        localObject1 = "qita";
        break;
      }
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
      localObject1 = "qita";
      break;
      str1 = ClubContentJsonTask.a.jdField_b_of_type_JavaLangString;
      break label110;
      StringBuilder localStringBuilder = new StringBuilder(str1);
      if (str1.contains("?")) {
        localStringBuilder.append("&platform=1");
      }
      for (;;)
      {
        localStringBuilder.append("&qq=" + str2);
        localStringBuilder.append("&adtag=" + (String)localObject1);
        localStringBuilder.append("&aid=" + (String)localObject2);
        localObject1 = localStringBuilder.toString();
        break;
        localStringBuilder.append("?platform=1");
      }
    }
  }
  
  private void H()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
    }
  }
  
  private void I()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 100) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.a()))) {
      startUnlockActivity();
    }
  }
  
  private void J()
  {
    for (;;)
    {
      Object localObject;
      try
      {
        FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
          break;
        }
        localFrameLayout.setForeground(null);
        this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setBackgroundResource(0);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        ProfileCardTemplate.a(this.jdField_a_of_type_AndroidViewView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "background");
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.jdField_h_of_type_Long)
        {
          ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingUserInfoBackground");
          if (Build.VERSION.SDK_INT >= 11)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.jdField_f_of_type_Long) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.jdField_h_of_type_Long)) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)))
            {
              localObject = ((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
              ThreadManager.a(new lmi(this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler, (Bitmap)localObject), 5, null, true);
            }
          }
          else
          {
            localFrameLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            if (!ThemeUtil.isInNightMode(this.app)) {
              break label380;
            }
            if (this.jdField_c_of_type_AndroidViewView != null) {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate)) {
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "update item style");
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
          }
        }
        else
        {
          ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
          continue;
        }
        localObject = localException.getChildAt(0);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateTheme exception msg=" + localException.getMessage());
        }
        localException.printStackTrace();
        return;
      }
      if ((localObject != null) && (((View)localObject).getBackground() != null))
      {
        ((View)localObject).setBackgroundDrawable(null);
        continue;
        label380:
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
    localException.setForeground(getResources().getDrawable(2130843153));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setBackgroundResource(2130837958);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837958);
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
      break;
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    }
  }
  
  private void K()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)))
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      Object localObject = ProfileCardUtil.a(this, this.jdField_b_of_type_JavaLangString);
      localObject = "profilecard:" + (String)localObject;
      localObject = (Pair)BaseApplicationImpl.a.get(localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (localBitmapDrawable.getConstantState() != ((Pair)localObject).first))
      {
        localBitmapDrawable.getBitmap().recycle();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      }
    }
  }
  
  private void L()
  {
    CardHandler localCardHandler = (CardHandler)this.app.a(2);
    if ((localCardHandler != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      localCardHandler.a(Long.valueOf(this.app.a()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.favoriteSource, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), 0);
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Prof_good", 1, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int)), "", this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
  }
  
  private void M()
  {
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        Intent localIntent = new Intent(this, SplashActivity.class);
        localIntent.putExtra("main_tab_id", 1);
        localIntent.setFlags(603979776);
        startActivity(localIntent);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentIntent == null)
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  private void N()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_dynamic_avatar_tips");
    if (localTextView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 16, 0, 16, 0 });
    localValueAnimator.setInterpolator(null);
    localValueAnimator.addUpdateListener(new llr(this, localTextView));
    localValueAnimator.addListener(new lls(this, localTextView));
    localValueAnimator.setDuration(1200L);
    localValueAnimator.start();
  }
  
  private void O()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_dynamic_avatar_tips");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(400L);
    localValueAnimator.setInterpolator(null);
    localValueAnimator.addUpdateListener(new llu(this, localTextView));
    localValueAnimator.addListener(new llv(this, localTextView));
    localValueAnimator.start();
  }
  
  public static ProfileActivity.CardContactInfo a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAllInOne != null)
    {
      localObject1 = localObject2;
      if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)paramAllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return (ProfileActivity.CardContactInfo)localObject1;
  }
  
  public static String a(ProfileCardInfo paramProfileCardInfo)
  {
    int i1 = ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    Object localObject2 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
    }
    String str = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1];
    localObject2 = str;
    if (TextUtils.isEmpty(str)) {
      localObject2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
    }
    if ((i1 == 0) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      return (String)localObject1;
    }
    if (((i1 == 1000) || (i1 == 1020)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      return (String)localObject2;
    }
    if (i1 == 1021) {
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a == null)) {
        break label205;
      }
    }
    label205:
    for (localObject2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject2 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      return paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      localObject2 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      if (ProfileActivity.AllInOne.h(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject2 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      return paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
    }
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      Object localObject = findViewById(2131302289);
      int i1;
      if (paramInt != 0)
      {
        i1 = 0;
        label68:
        ((View)localObject).setVisibility(i1);
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (paramInt == 0) {
          break label2284;
        }
      }
      label2284:
      for (paramInt = 0;; paramInt = 8)
      {
        ((LinearLayout)localObject).setVisibility(paramInt);
        return;
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 23, 2131370868, 0, 2131362071);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 57, 2131369092, 2, 2131369092);
        paramInt = 1;
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131369990, 0, 2131362022);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, 2131370025, 1, 2131362027);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131367902, 2, 2131362023);
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
          break label2290;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131369990, 0, 2131362022);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, 2131370025, 1, 2131362027);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 8, 2131367902, 0, 2131362023);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131367903, 2, 2131362024);
        paramInt = 1;
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131369990, 0, 2131362022);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131367902, 2, 2131362023);
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
          break label2290;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131369990, 0, 2131362022);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 8, 2131367902, 0, 2131362023);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131367903, 2, 2131362024);
        paramInt = 1;
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131370025, 0, 2131362027);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131367902, 2, 2131362023);
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
          break label2290;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131370025, 0, 2131362027);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 8, 2131367902, 0, 2131362023);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131367903, 2, 2131362024);
        paramInt = 1;
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131369990, 0, 2131362022);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, 2131370025, 1, 2131362027);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
          break label2290;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131369990, 0, 2131362022);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, 2131370025, 1, 2131362027);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131367903, 2, 2131362024);
        paramInt = 1;
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131369990, 0, 2131362022);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
          break label2290;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131369990, 0, 2131362022);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131367903, 2, 2131362024);
        paramInt = 1;
        break;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131367902, 2, 2131362023);
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
          break label2290;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 8, 2131367902, 0, 2131362023);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131367903, 2, 2131362024);
        paramInt = 1;
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131370025, 0, 2131362027);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
          break label2290;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131370025, 0, 2131362027);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131367903, 2, 2131362024);
        paramInt = 1;
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131370025, 0, 2131362027);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
          break label2290;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131370025, 0, 2131362027);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) == null)) {
          break label2290;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
        paramInt = 1;
        break;
        i1 = 8;
        break label68;
      }
      label2290:
      paramInt = 1;
    }
  }
  
  private void a(int paramInt, UpsImageUploadResult paramUpsImageUploadResult, String paramString)
  {
    if (paramUpsImageUploadResult == null) {
      break label4;
    }
    label4:
    while (paramUpsImageUploadResult == null) {
      return;
    }
    if (paramUpsImageUploadResult != null) {}
    for (paramString = new UploadUpsInfoRsp(paramUpsImageUploadResult.dataType, paramUpsImageUploadResult.vBusiNessData, paramUpsImageUploadResult.url, paramUpsImageUploadResult.rawWidth, paramUpsImageUploadResult.rawHeight, paramUpsImageUploadResult.photoType, null);; paramString = null)
    {
      UniAttribute localUniAttribute = new UniAttribute();
      localUniAttribute.setEncodeName("utf8");
      int i1;
      if (paramInt == 0)
      {
        i1 = 0;
        label70:
        localUniAttribute.put("ReplyCode", Integer.valueOf(i1));
        if (paramInt != 0) {
          break label122;
        }
      }
      label122:
      for (String str = "success";; str = "fail")
      {
        localUniAttribute.put("StrResult", str);
        if (paramUpsImageUploadResult == null) {
          break;
        }
        localUniAttribute.put("response", paramString);
        return;
        i1 = -1;
        break label70;
      }
    }
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.cU);
    }
    if ((this.cU > 5) && (!paramBoolean)) {}
    CardHandler localCardHandler;
    do
    {
      return;
      localCardHandler = (CardHandler)this.app.a(2);
    } while (localCardHandler == null);
    this.cU += 1;
    byte[] arrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[1];
      arrayOfByte1[0] = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      if (paramArrayOfByte2 == null)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      for (;;)
      {
        int i1 = 12;
        byte b1 = 0;
        paramArrayOfByte1 = (BusinessCardManager)this.app.getManager(111);
        if (paramArrayOfByte1 != null) {}
        for (paramBoolean = paramArrayOfByte1.a(1);; paramBoolean = false)
        {
          long l3 = a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, paramBoolean);
          long l2;
          long l1;
          switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 29: 
          case 33: 
          case 38: 
          case 39: 
          case 43: 
          case 44: 
          case 45: 
          case 48: 
          case 49: 
          case 53: 
          case 54: 
          case 59: 
          case 62: 
          case 63: 
          case 64: 
          case 65: 
          case 66: 
          case 67: 
          case 68: 
          case 69: 
          case 76: 
          case 79: 
          default: 
            return;
          case 0: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 60: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 1: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 78: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 3022, arrayOfByte2);
            return;
          case 40: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 41: 
            i1 = 6;
            paramArrayOfByte1 = "";
            if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
            {
              i1 = 37;
              paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o;
            }
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i1, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2);
            return;
          case 42: 
          case 73: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 36: 
            localCardHandler.a(this.app.a(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne), l3, 3014, arrayOfByte2);
            return;
          case 30: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 31: 
          case 32: 
          case 34: 
          case 50: 
          case 51: 
            i1 = 16;
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) {
              i1 = 17;
            }
            localCardHandler.a(this.app.a(), "0", i1, paramLong, (byte)0, 0L, 0L, arrayOfByte1, b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne), l3, 10004, null);
            return;
          case 80: 
            ((QCallCardHandler)this.app.a(79)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            return;
          case 46: 
          case 47: 
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) {
              break;
            }
            l2 = 0L;
            try
            {
              l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString).longValue();
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
              {
                i1 = 4;
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i1, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
                return;
              }
            }
            catch (Exception paramArrayOfByte1)
            {
              for (;;)
              {
                l1 = l2;
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                  l1 = l2;
                  continue;
                  i1 = 14;
                }
              }
            }
          case 20: 
          case 21: 
          case 22: 
          case 58: 
            l1 = ProfileCardUtil.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
            {
              i1 = 2;
              b1 = 1;
            }
            for (;;)
            {
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i1, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
              {
                i1 = 5;
                b1 = 0;
              }
              else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22)
              {
                i1 = 7;
                b1 = 0;
              }
            }
          case 3: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 2: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 74: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 35: 
          case 37: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2);
            return;
          case 75: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2);
            return;
          case 61: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 70: 
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
          case 25: 
          case 26: 
          case 27: 
          case 28: 
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 3004) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 2004)) {
              if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c)) {}
            }
          case 4: 
          case 77: 
          case 52: 
          case 19: 
          case 23: 
          case 24: 
          case 55: 
          case 56: 
          case 57: 
          case 72: 
          case 71: 
          case 81: 
          case 82: 
          case 83: 
          case 84: 
            label2235:
            for (paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c;; paramArrayOfByte1 = "0")
            {
              paramArrayOfByte2 = paramArrayOfByte1;
              if (paramArrayOfByte1 == null) {}
              for (paramArrayOfByte2 = "0";; paramArrayOfByte2 = "0")
              {
                l2 = 0L;
                try
                {
                  l1 = Long.parseLong(paramArrayOfByte2);
                  i1 = 11;
                  if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27) {
                    i1 = 35;
                  }
                  localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i1, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int, arrayOfByte2);
                  return;
                  if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
                    break label2235;
                  }
                  paramArrayOfByte1 = (TroopInfo)this.app.a().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString });
                  if (paramArrayOfByte1 == null) {
                    break label2235;
                  }
                  paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                  break;
                  if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 3005) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 2005)) {
                    continue;
                  }
                  paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c;
                }
                catch (Exception paramArrayOfByte1)
                {
                  for (;;)
                  {
                    l1 = l2;
                    if (QLog.isColorLevel())
                    {
                      QLog.e("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                      l1 = l2;
                    }
                  }
                }
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
                return;
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
                return;
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
                return;
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
                return;
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
                return;
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
                return;
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
                return;
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
                return;
                localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3045, arrayOfByte2);
                return;
              }
            }
          }
        }
        arrayOfByte2 = paramArrayOfByte2;
      }
      arrayOfByte1 = paramArrayOfByte1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent.putExtra("qzone_uin", this.app.a());
    String str2 = this.app.b();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = ContactUtils.i(this.app, this.app.a());
    }
    paramIntent.putExtra("nickname", str1);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView != null)
    {
      localObject = new DataTag(paramInt1, null);
      paramView.setVisibility(0);
      paramView = (Button)paramView.findViewById(2131301921);
      paramView.setTag(localObject);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      paramView.setText(paramInt2);
      if ((d(paramInt1)) && (!this.jdField_b_of_type_Boolean))
      {
        paramView.setTextColor(getResources().getColor(2131428302));
        paramView.setEnabled(this.jdField_b_of_type_Boolean);
      }
    }
    else
    {
      return;
    }
    Object localObject = getResources();
    if (paramInt3 == 2) {}
    for (paramInt1 = 2131428278;; paramInt1 = 2131428280)
    {
      paramView.setTextColor(((Resources)localObject).getColor(paramInt1));
      break;
    }
  }
  
  private void a(View paramView, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramView != null))
    {
      if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "changeProfileHeaderView success remove timeout msg");
        }
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
      }
      Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302203);
      if (localObject != null) {}
      try
      {
        localObject = (Animatable)((ImageView)localObject).getDrawable();
        if ((localObject != null) && (((Animatable)localObject).isRunning())) {
          ((Animatable)localObject).stop();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i2;
          int i1;
          localException.printStackTrace();
        }
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView);
        this.jdField_l_of_type_Boolean = true;
        this.jdField_c_of_type_Long = paramLong1;
        this.jdField_d_of_type_Long = paramLong2;
      }
      i2 = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i1);
        if ((localObject instanceof ProfileHeaderView)) {
          ((ProfileHeaderView)localObject).d();
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
    if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) && (this.jdField_b_of_type_AndroidViewView != null)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("headerViewLoadingEnd", false);
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    this.jdField_f_of_type_AndroidViewView = null;
    int i1 = getResources().getDimensionPixelSize(2131493668);
    int i2 = getResources().getDimensionPixelSize(2131493668);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2130904315, null);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.rightMargin = i2;
      paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2130904602, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_f_of_type_AndroidViewView).c(30).a();
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          D();
        }
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2130904288, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i1;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2130904315, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2130904288, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2130904315, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2130904288, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    int i1 = ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    String str4 = a(paramProfileCardInfo);
    String str3;
    String str2;
    String str1;
    if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      str3 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      str2 = null;
      if (i1 != 1000) {
        break label294;
      }
      str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      label53:
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Clk_freecall", a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      ChatActivityUtils.a(paramQQAppInterface, paramBaseActivity, i1, str3, str4, str2, true, str1, true, true, null, "from_internal");
      switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        paramBaseActivity = "4";
      }
      for (;;)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, paramBaseActivity, "", "", "");
        return;
        str2 = b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        str3 = null;
        break;
        label294:
        if (i1 != 1004) {
          break label341;
        }
        str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
        break label53;
        paramBaseActivity = "4";
        continue;
        paramBaseActivity = "5";
        continue;
        paramBaseActivity = "6";
        continue;
        paramBaseActivity = "7";
      }
      label341:
      str1 = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, Dialog paramDialog)
  {
    int i4 = 10004;
    int i3 = 0;
    int i1 = i4;
    int i2 = i3;
    switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      i2 = i3;
      i1 = i4;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 26: 
    case 28: 
    case 29: 
    case 30: 
    case 33: 
    case 38: 
    case 39: 
    case 40: 
    case 43: 
    case 44: 
    case 45: 
    case 48: 
    case 49: 
    case 53: 
    case 54: 
    case 55: 
    case 59: 
    case 60: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 73: 
    case 76: 
    case 79: 
    case 80: 
      if ((i1 == 3007) && (!LBSHandler.a(paramQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        localObject1 = paramDialog;
        if (paramDialog == null) {
          localObject1 = LBSHandler.a(paramBaseActivity, paramBaseActivity.getString(2131371566), new lku(paramQQAppInterface, paramBaseActivity, paramProfileCardInfo), new lkv());
        }
        if ((localObject1 != null) && (!((Dialog)localObject1).isShowing()) && (!paramBaseActivity.isFinishing())) {
          ((Dialog)localObject1).show();
        }
      }
      break;
    }
    Object localObject2;
    do
    {
      return;
      i1 = 3004;
      i2 = i3;
      break;
      i1 = 3007;
      i2 = 1;
      break;
      i1 = 3001;
      i2 = 1;
      break;
      i1 = 3020;
      i2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int;
      break;
      i1 = 3017;
      i2 = 1;
      break;
      i1 = 3002;
      i2 = i3;
      break;
      i1 = 3005;
      i2 = 1;
      break;
      i1 = 3007;
      i2 = 2;
      break;
      i1 = 3003;
      i2 = i3;
      break;
      i1 = 3008;
      i2 = i3;
      break;
      i1 = 3008;
      i2 = i3;
      break;
      i1 = 3041;
      i2 = i3;
      break;
      i1 = 3037;
      i2 = 1;
      break;
      i1 = 3042;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int == 10000) {
        i1 = 3037;
      }
      i2 = 1;
      break;
      i1 = 3009;
      i2 = i3;
      break;
      i1 = 3006;
      i2 = i3;
      break;
      i1 = 3009;
      i2 = 1;
      break;
      i1 = 3006;
      i2 = 1;
      break;
      i1 = 3013;
      i2 = i3;
      break;
      i1 = 3003;
      i2 = 1;
      break;
      i1 = 3014;
      i2 = 1;
      break;
      i1 = 3003;
      i2 = 2;
      break;
      i1 = 3022;
      i2 = i3;
      break;
      i1 = 3011;
      i2 = i3;
      break;
      i1 = 3045;
      i2 = 1;
      break;
      i1 = 3045;
      i2 = 2;
      break;
      i1 = 3045;
      i2 = 3;
      break;
      i1 = 3045;
      i2 = 4;
      break;
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
        break label1122;
      }
      localObject2 = a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    } while ((localObject2 == null) || (((ProfileActivity.CardContactInfo)localObject2).c == null) || (((ProfileActivity.CardContactInfo)localObject2).c.length() <= 0));
    Object localObject1 = ((ProfileActivity.CardContactInfo)localObject2).jdField_b_of_type_JavaLangString + ((ProfileActivity.CardContactInfo)localObject2).c;
    paramDialog = ((ProfileActivity.CardContactInfo)localObject2).jdField_a_of_type_JavaLangString;
    paramQQAppInterface = paramDialog;
    if (TextUtils.isEmpty(((ProfileActivity.CardContactInfo)localObject2).jdField_a_of_type_JavaLangString))
    {
      if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])) {
        break label1062;
      }
      paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
    }
    for (;;)
    {
      paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 2, (String)localObject1, null, i1, i2, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131367975), null);
      paramQQAppInterface.putExtra("param_return_profilecard_pa", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
      boolean bool = paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false);
      if (!bool) {
        break;
      }
      paramQQAppInterface.putExtra("from_newer_guide", bool);
      paramQQAppInterface.removeExtra("param_return_addr");
      paramBaseActivity.startActivityForResult(paramQQAppInterface, 1019);
      return;
      label1062:
      if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      else
      {
        paramQQAppInterface = paramDialog;
        if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString)) {
          paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
        }
      }
    }
    paramBaseActivity.startActivity(paramQQAppInterface);
    return;
    label1122:
    paramQQAppInterface = null;
    paramDialog = paramQQAppInterface;
    if (3004 == i1)
    {
      paramDialog = paramQQAppInterface;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null)
      {
        paramDialog = paramQQAppInterface;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString.length() != 0) {
          paramDialog = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
        }
      }
    }
    paramQQAppInterface = null;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72))
    {
      paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break label1440;
      }
      paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    label1433:
    label1440:
    for (;;)
    {
      localObject1 = paramBaseActivity.getIntent().getStringExtra("param_return_addr");
      if (localObject1 != null)
      {
        localObject2 = AddContactsActivity.class.getName();
        if (!((String)localObject1).equals(QidianProfileCardActivity.class.getName())) {
          break label1433;
        }
      }
      for (;;)
      {
        paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, i1, i2, paramQQAppInterface, null, (String)localObject1, paramBaseActivity.getString(2131367975), null);
        paramQQAppInterface.putExtra("param_return_profilecard_pa", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
        paramBaseActivity.startActivity(paramQQAppInterface);
        return;
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 77) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 82) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 81) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 83) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 84)) {
          break;
        }
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5];
        break;
        paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, i1, i2, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131367975), null);
        paramQQAppInterface.putExtra("param_return_profilecard_pa", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
        paramBaseActivity.startActivityForResult(paramQQAppInterface, 1000);
        return;
        localObject1 = localObject2;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, String paramString, int paramInt)
  {
    Object localObject;
    Intent localIntent;
    if (paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false))
    {
      localObject = new Intent(paramBaseActivity, ChatActivity.class);
      localIntent = AIOUtils.a((Intent)localObject, null);
      localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
      localIntent.putExtra("PREVIOUS_UIN", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("cSpecialFlag", paramBaseActivity.getIntent().getExtras().getInt("cSpecialFlag"));
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("aio_msg_source", 3);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 0) {
        localIntent.putExtra("entrance", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int);
      }
      localObject = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
      paramString = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
      }
      String str = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1];
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
      }
      if ((paramInt != 0) || (TextUtils.isEmpty(paramString))) {
        break label497;
      }
      localIntent.putExtra("uinname", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString);
      label228:
      if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
        break label702;
      }
      localIntent.putExtra("troop_uin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c)) {
        localIntent.putExtra("troop_code", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c);
      }
      if (paramInt == 1009) {
        localIntent.putExtra("rich_status_sig", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      }
      if (paramInt == 1001)
      {
        localIntent.putExtra("rich_accost_sig", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "资料卡accost_uin = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "accost_sig = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
      }
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.cSpecialFlag == 1)) {
          localIntent.putExtra("chat_subType", 1);
        }
      }
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 101)) {
        break label734;
      }
      localIntent.putExtra("is_from_manage_stranger", true);
      paramBaseActivity.startActivityForResult(localIntent, 1010);
      return;
      localObject = new Intent(paramBaseActivity, SplashActivity.class);
      break;
      label497:
      if (((paramInt == 1000) || (paramInt == 1020)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localIntent.putExtra("uinname", (String)localObject);
        break label228;
      }
      if ((paramInt == 1021) && (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2])))
      {
        localIntent.putExtra("uinname", paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2]);
        break label228;
      }
      if (paramInt == 1004)
      {
        paramString = null;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null) {
          paramString = ContactUtils.c(paramQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
        localObject = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
        }
        localIntent.putExtra("uinname", (String)localObject);
        break label228;
      }
      paramString = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      if (ProfileActivity.AllInOne.h(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramString = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      localIntent.putExtra("uinname", (String)localObject);
      break label228;
      label702:
      if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
        localIntent.putExtra("troop_uin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
      }
    }
    label734:
    paramBaseActivity.startActivity(localIntent);
  }
  
  /* Error */
  public static void a(QQAppInterface arg0, ProfileCardInfo paramProfileCardInfo)
  {
    // Byte code:
    //   0: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 350
    //   9: iconst_2
    //   10: ldc_w 1589
    //   13: invokestatic 423	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   20: getfield 1166	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 1150	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore_2
    //   33: aload_1
    //   34: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   37: getfield 1152	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   40: astore 7
    //   42: aload_1
    //   43: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   46: getfield 1591	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:l	Ljava/lang/String;
    //   49: astore 12
    //   51: aload_1
    //   52: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   55: getfield 1593	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   58: astore 5
    //   60: aload_1
    //   61: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: getfield 1595	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   67: astore 6
    //   69: aload_1
    //   70: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   73: getfield 1597	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   76: astore 13
    //   78: aload 4
    //   80: astore 8
    //   82: aload 4
    //   84: astore 9
    //   86: aload_1
    //   87: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   90: invokestatic 1599	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   93: ifeq +738 -> 831
    //   96: aload 4
    //   98: astore 8
    //   100: aload 4
    //   102: astore 9
    //   104: aload_0
    //   105: bipush 50
    //   107: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   110: checkcast 1570	com/tencent/mobileqq/app/FriendsManager
    //   113: astore_3
    //   114: aload_3
    //   115: ifnonnull +692 -> 807
    //   118: aconst_null
    //   119: astore 11
    //   121: aload 4
    //   123: astore 10
    //   125: aload 11
    //   127: ifnull +1208 -> 1335
    //   130: aload 4
    //   132: astore_3
    //   133: aload 4
    //   135: astore 8
    //   137: aload 4
    //   139: astore 9
    //   141: aload 11
    //   143: getfield 1602	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   146: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +17 -> 166
    //   152: aload 4
    //   154: astore 8
    //   156: aload 4
    //   158: astore 9
    //   160: aload 11
    //   162: getfield 1602	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   165: astore_3
    //   166: aload_3
    //   167: astore 8
    //   169: aload_3
    //   170: astore 9
    //   172: aload_3
    //   173: astore 10
    //   175: aload 11
    //   177: getfield 1605	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   180: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifne +1152 -> 1335
    //   186: aload_3
    //   187: astore 8
    //   189: aload_3
    //   190: astore 9
    //   192: aload 11
    //   194: getfield 1605	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   197: astore 4
    //   199: aload_3
    //   200: astore_2
    //   201: aload 4
    //   203: astore_3
    //   204: aload 7
    //   206: astore 8
    //   208: aload 7
    //   210: astore 9
    //   212: aload_0
    //   213: bipush 51
    //   215: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   218: checkcast 1607	com/tencent/mobileqq/app/TroopManager
    //   221: astore 11
    //   223: aload 7
    //   225: astore 8
    //   227: aload 7
    //   229: astore 9
    //   231: aload_1
    //   232: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   235: getfield 1265	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:c	Ljava/lang/String;
    //   238: astore 4
    //   240: aload 4
    //   242: astore 10
    //   244: aload 7
    //   246: astore 8
    //   248: aload 7
    //   250: astore 9
    //   252: aload 4
    //   254: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifeq +59 -> 316
    //   260: aload 4
    //   262: astore 10
    //   264: aload 7
    //   266: astore 8
    //   268: aload 7
    //   270: astore 9
    //   272: aload_1
    //   273: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   276: getfield 1267	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   279: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: ifne +34 -> 316
    //   285: aload 4
    //   287: astore 10
    //   289: aload 11
    //   291: ifnull +25 -> 316
    //   294: aload 7
    //   296: astore 8
    //   298: aload 7
    //   300: astore 9
    //   302: aload 11
    //   304: aload_1
    //   305: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   308: getfield 1267	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   311: invokevirtual 1609	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   314: astore 10
    //   316: aload 7
    //   318: astore 4
    //   320: aload 7
    //   322: astore 8
    //   324: aload 7
    //   326: astore 9
    //   328: aload 10
    //   330: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   333: ifne +36 -> 369
    //   336: aload 7
    //   338: astore 4
    //   340: aload 11
    //   342: ifnull +27 -> 369
    //   345: aload 7
    //   347: astore 8
    //   349: aload 7
    //   351: astore 9
    //   353: aload 11
    //   355: aload 10
    //   357: aload_1
    //   358: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   361: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   364: invokevirtual 1612	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   367: astore 4
    //   369: aload 4
    //   371: astore 8
    //   373: aload 4
    //   375: astore 9
    //   377: aload 6
    //   379: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   382: ifeq +939 -> 1321
    //   385: aload 4
    //   387: astore 8
    //   389: aload 4
    //   391: astore 9
    //   393: aload_1
    //   394: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   397: invokestatic 1471	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   400: astore 7
    //   402: aload 7
    //   404: ifnull +917 -> 1321
    //   407: aload 4
    //   409: astore 8
    //   411: aload 4
    //   413: astore 9
    //   415: aload 7
    //   417: getfield 1477	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   420: astore 7
    //   422: aload 7
    //   424: astore 6
    //   426: aload_1
    //   427: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   430: invokestatic 1614	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:j	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   433: ifeq +882 -> 1315
    //   436: aload 5
    //   438: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   441: ifeq +874 -> 1315
    //   444: aload_0
    //   445: bipush 34
    //   447: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   450: checkcast 1616	com/tencent/mobileqq/app/CircleManager
    //   453: astore_0
    //   454: aload_0
    //   455: ifnull +860 -> 1315
    //   458: aload_0
    //   459: aload_1
    //   460: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   463: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   466: invokevirtual 1619	com/tencent/mobileqq/app/CircleManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/CircleBuddy;
    //   469: astore 8
    //   471: aload 8
    //   473: ifnull +842 -> 1315
    //   476: aload 8
    //   478: getfield 1622	com/tencent/mobileqq/data/CircleBuddy:remark	Ljava/lang/String;
    //   481: astore_0
    //   482: aload_0
    //   483: astore 5
    //   485: aload_2
    //   486: astore 7
    //   488: aload 8
    //   490: getfield 1625	com/tencent/mobileqq/data/CircleBuddy:nickName	Ljava/lang/String;
    //   493: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +13 -> 509
    //   499: aload 8
    //   501: getfield 1625	com/tencent/mobileqq/data/CircleBuddy:nickName	Ljava/lang/String;
    //   504: astore 7
    //   506: aload_0
    //   507: astore 5
    //   509: aload_3
    //   510: astore 8
    //   512: aload 4
    //   514: astore 9
    //   516: aload 5
    //   518: astore 10
    //   520: aload 6
    //   522: astore 11
    //   524: aload_1
    //   525: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   528: astore_0
    //   529: aload_0
    //   530: monitorenter
    //   531: aload_1
    //   532: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   535: iconst_0
    //   536: aaload
    //   537: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   540: ifeq +11 -> 551
    //   543: aload_1
    //   544: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   547: iconst_0
    //   548: aload 7
    //   550: aastore
    //   551: aload_1
    //   552: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   555: iconst_4
    //   556: aaload
    //   557: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   560: ifeq +11 -> 571
    //   563: aload_1
    //   564: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   567: iconst_4
    //   568: aload 8
    //   570: aastore
    //   571: aload_1
    //   572: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   575: iconst_3
    //   576: aaload
    //   577: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   580: ifeq +11 -> 591
    //   583: aload_1
    //   584: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   587: iconst_3
    //   588: aload 11
    //   590: aastore
    //   591: aload_1
    //   592: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   595: iconst_2
    //   596: aaload
    //   597: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   600: ifeq +11 -> 611
    //   603: aload_1
    //   604: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   607: iconst_2
    //   608: aload 10
    //   610: aastore
    //   611: aload_1
    //   612: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   615: iconst_5
    //   616: aaload
    //   617: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   620: ifeq +11 -> 631
    //   623: aload_1
    //   624: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   627: iconst_5
    //   628: aload 12
    //   630: aastore
    //   631: aload_1
    //   632: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   635: iconst_1
    //   636: aaload
    //   637: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   640: ifeq +11 -> 651
    //   643: aload_1
    //   644: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   647: iconst_1
    //   648: aload 9
    //   650: aastore
    //   651: aload_1
    //   652: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   655: bipush 6
    //   657: aaload
    //   658: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   661: ifeq +12 -> 673
    //   664: aload_1
    //   665: getfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   668: bipush 6
    //   670: aload 13
    //   672: aastore
    //   673: aload_0
    //   674: monitorexit
    //   675: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   678: ifeq +128 -> 806
    //   681: new 793	java/lang/StringBuilder
    //   684: dup
    //   685: invokespecial 794	java/lang/StringBuilder:<init>	()V
    //   688: astore_0
    //   689: aload_0
    //   690: ldc_w 1627
    //   693: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 1629
    //   699: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 7
    //   704: invokestatic 1633	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   707: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: ldc_w 1635
    //   713: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload 8
    //   718: invokestatic 1633	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   721: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: ldc_w 1637
    //   727: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: aload 11
    //   732: invokestatic 1633	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   735: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: ldc_w 1639
    //   741: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload 10
    //   746: invokestatic 1633	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   749: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: ldc_w 1641
    //   755: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 12
    //   760: invokestatic 1633	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   763: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: ldc_w 1643
    //   769: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: aload 9
    //   774: invokestatic 1633	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   777: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: ldc_w 1645
    //   783: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: aload 12
    //   788: invokestatic 1633	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   791: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: ldc_w 350
    //   798: iconst_2
    //   799: aload_0
    //   800: invokevirtual 805	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 722	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: return
    //   807: aload 4
    //   809: astore 8
    //   811: aload 4
    //   813: astore 9
    //   815: aload_3
    //   816: aload_1
    //   817: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   820: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   823: invokevirtual 1573	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   826: astore 11
    //   828: goto -707 -> 121
    //   831: aload 4
    //   833: astore 8
    //   835: aload 4
    //   837: astore 9
    //   839: aload_1
    //   840: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   843: getfield 425	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   846: ifne +32 -> 878
    //   849: aload 4
    //   851: astore 8
    //   853: aload 4
    //   855: astore 9
    //   857: aload_0
    //   858: aload_1
    //   859: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   862: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   865: invokestatic 1302	com/tencent/mobileqq/utils/ContactUtils:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   868: astore 4
    //   870: aload_2
    //   871: astore_3
    //   872: aload 4
    //   874: astore_2
    //   875: goto -671 -> 204
    //   878: aload 4
    //   880: astore 8
    //   882: aload 4
    //   884: astore 9
    //   886: aload 4
    //   888: astore_3
    //   889: aload 4
    //   891: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   894: ifeq +430 -> 1324
    //   897: aload 4
    //   899: astore 8
    //   901: aload 4
    //   903: astore 9
    //   905: aload 4
    //   907: astore_3
    //   908: aload_1
    //   909: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   912: invokestatic 1412	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:f	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   915: ifeq +409 -> 1324
    //   918: aload 4
    //   920: astore 8
    //   922: aload 4
    //   924: astore 9
    //   926: aload_0
    //   927: aload_1
    //   928: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   931: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   934: iconst_0
    //   935: invokestatic 1648	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   938: astore_3
    //   939: aload_3
    //   940: astore 8
    //   942: aload_3
    //   943: astore 9
    //   945: aload_3
    //   946: aload_1
    //   947: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   950: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   953: invokestatic 1651	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   956: istore 14
    //   958: iload 14
    //   960: ifeq +364 -> 1324
    //   963: aload_2
    //   964: astore_3
    //   965: aconst_null
    //   966: astore_2
    //   967: goto -763 -> 204
    //   970: astore_3
    //   971: aload 6
    //   973: astore_0
    //   974: aload_2
    //   975: astore 4
    //   977: aload 5
    //   979: astore_2
    //   980: aload 8
    //   982: astore 5
    //   984: aload_3
    //   985: astore 6
    //   987: aload 7
    //   989: astore_3
    //   990: aload_0
    //   991: astore 11
    //   993: aload_2
    //   994: astore 10
    //   996: aload_3
    //   997: astore 9
    //   999: aload 4
    //   1001: astore 8
    //   1003: aload 5
    //   1005: astore 7
    //   1007: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1010: ifeq -486 -> 524
    //   1013: ldc_w 350
    //   1016: iconst_2
    //   1017: aload 6
    //   1019: invokevirtual 1258	java/lang/Exception:toString	()Ljava/lang/String;
    //   1022: invokestatic 722	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: aload_0
    //   1026: astore 11
    //   1028: aload_2
    //   1029: astore 10
    //   1031: aload_3
    //   1032: astore 9
    //   1034: aload 4
    //   1036: astore 8
    //   1038: aload 5
    //   1040: astore 7
    //   1042: goto -518 -> 524
    //   1045: astore_3
    //   1046: aload 6
    //   1048: astore_0
    //   1049: aload_2
    //   1050: astore 4
    //   1052: aload 5
    //   1054: astore_2
    //   1055: aload 9
    //   1057: astore 5
    //   1059: aload_3
    //   1060: astore 6
    //   1062: aload 7
    //   1064: astore_3
    //   1065: aload_0
    //   1066: astore 11
    //   1068: aload_2
    //   1069: astore 10
    //   1071: aload_3
    //   1072: astore 9
    //   1074: aload 4
    //   1076: astore 8
    //   1078: aload 5
    //   1080: astore 7
    //   1082: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1085: ifeq -561 -> 524
    //   1088: ldc_w 350
    //   1091: iconst_2
    //   1092: aload 6
    //   1094: invokevirtual 1652	java/lang/Error:toString	()Ljava/lang/String;
    //   1097: invokestatic 722	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1100: aload_0
    //   1101: astore 11
    //   1103: aload_2
    //   1104: astore 10
    //   1106: aload_3
    //   1107: astore 9
    //   1109: aload 4
    //   1111: astore 8
    //   1113: aload 5
    //   1115: astore 7
    //   1117: goto -593 -> 524
    //   1120: astore_1
    //   1121: aload_0
    //   1122: monitorexit
    //   1123: aload_1
    //   1124: athrow
    //   1125: astore 9
    //   1127: aload_2
    //   1128: astore 7
    //   1130: aload 5
    //   1132: astore_2
    //   1133: aload_3
    //   1134: astore 4
    //   1136: aload 6
    //   1138: astore_0
    //   1139: aload 8
    //   1141: astore_3
    //   1142: aload 7
    //   1144: astore 5
    //   1146: aload 9
    //   1148: astore 6
    //   1150: goto -85 -> 1065
    //   1153: astore 7
    //   1155: aload 6
    //   1157: astore_0
    //   1158: aload_2
    //   1159: astore 6
    //   1161: aload 5
    //   1163: astore_2
    //   1164: aload_3
    //   1165: astore 5
    //   1167: aload 4
    //   1169: astore_3
    //   1170: aload 5
    //   1172: astore 4
    //   1174: aload 6
    //   1176: astore 5
    //   1178: aload 7
    //   1180: astore 6
    //   1182: goto -117 -> 1065
    //   1185: astore 7
    //   1187: aload_3
    //   1188: astore 5
    //   1190: aload 6
    //   1192: astore 8
    //   1194: aload 4
    //   1196: astore_3
    //   1197: aload_2
    //   1198: astore 6
    //   1200: aload_0
    //   1201: astore_2
    //   1202: aload 8
    //   1204: astore_0
    //   1205: aload 5
    //   1207: astore 4
    //   1209: aload 6
    //   1211: astore 5
    //   1213: aload 7
    //   1215: astore 6
    //   1217: goto -152 -> 1065
    //   1220: astore 8
    //   1222: aload_2
    //   1223: astore 7
    //   1225: aload 5
    //   1227: astore_2
    //   1228: aload_3
    //   1229: astore 4
    //   1231: aload 6
    //   1233: astore_0
    //   1234: aload 9
    //   1236: astore_3
    //   1237: aload 7
    //   1239: astore 5
    //   1241: aload 8
    //   1243: astore 6
    //   1245: goto -255 -> 990
    //   1248: astore 7
    //   1250: aload 6
    //   1252: astore_0
    //   1253: aload_2
    //   1254: astore 6
    //   1256: aload 5
    //   1258: astore_2
    //   1259: aload_3
    //   1260: astore 5
    //   1262: aload 4
    //   1264: astore_3
    //   1265: aload 5
    //   1267: astore 4
    //   1269: aload 6
    //   1271: astore 5
    //   1273: aload 7
    //   1275: astore 6
    //   1277: goto -287 -> 990
    //   1280: astore 7
    //   1282: aload_3
    //   1283: astore 5
    //   1285: aload 6
    //   1287: astore 8
    //   1289: aload 4
    //   1291: astore_3
    //   1292: aload_2
    //   1293: astore 6
    //   1295: aload_0
    //   1296: astore_2
    //   1297: aload 8
    //   1299: astore_0
    //   1300: aload 5
    //   1302: astore 4
    //   1304: aload 6
    //   1306: astore 5
    //   1308: aload 7
    //   1310: astore 6
    //   1312: goto -322 -> 990
    //   1315: aload_2
    //   1316: astore 7
    //   1318: goto -809 -> 509
    //   1321: goto -895 -> 426
    //   1324: aload_2
    //   1325: astore 4
    //   1327: aload_3
    //   1328: astore_2
    //   1329: aload 4
    //   1331: astore_3
    //   1332: goto -1128 -> 204
    //   1335: aload_2
    //   1336: astore_3
    //   1337: aload 10
    //   1339: astore_2
    //   1340: goto -1136 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1343	1	paramProfileCardInfo	ProfileCardInfo
    //   32	1308	2	localObject1	Object
    //   113	852	3	localObject2	Object
    //   970	15	3	localException1	Exception
    //   989	43	3	localObject3	Object
    //   1045	15	3	localError1	Error
    //   1064	273	3	localObject4	Object
    //   23	1307	4	localObject5	Object
    //   58	1249	5	localObject6	Object
    //   67	1244	6	localObject7	Object
    //   40	1103	7	localObject8	Object
    //   1153	26	7	localError2	Error
    //   1185	29	7	localError3	Error
    //   1223	15	7	localObject9	Object
    //   1248	26	7	localException2	Exception
    //   1280	29	7	localException3	Exception
    //   1316	1	7	localObject10	Object
    //   80	1123	8	localObject11	Object
    //   1220	22	8	localException4	Exception
    //   1287	11	8	localObject12	Object
    //   84	1024	9	localObject13	Object
    //   1125	110	9	localError4	Error
    //   123	1215	10	localObject14	Object
    //   119	983	11	localObject15	Object
    //   49	738	12	str1	String
    //   76	595	13	str2	String
    //   956	3	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   86	96	970	java/lang/Exception
    //   104	114	970	java/lang/Exception
    //   141	152	970	java/lang/Exception
    //   160	166	970	java/lang/Exception
    //   175	186	970	java/lang/Exception
    //   192	199	970	java/lang/Exception
    //   815	828	970	java/lang/Exception
    //   839	849	970	java/lang/Exception
    //   857	870	970	java/lang/Exception
    //   889	897	970	java/lang/Exception
    //   908	918	970	java/lang/Exception
    //   926	939	970	java/lang/Exception
    //   945	958	970	java/lang/Exception
    //   86	96	1045	java/lang/Error
    //   104	114	1045	java/lang/Error
    //   141	152	1045	java/lang/Error
    //   160	166	1045	java/lang/Error
    //   175	186	1045	java/lang/Error
    //   192	199	1045	java/lang/Error
    //   815	828	1045	java/lang/Error
    //   839	849	1045	java/lang/Error
    //   857	870	1045	java/lang/Error
    //   889	897	1045	java/lang/Error
    //   908	918	1045	java/lang/Error
    //   926	939	1045	java/lang/Error
    //   945	958	1045	java/lang/Error
    //   531	551	1120	finally
    //   551	571	1120	finally
    //   571	591	1120	finally
    //   591	611	1120	finally
    //   611	631	1120	finally
    //   631	651	1120	finally
    //   651	673	1120	finally
    //   673	675	1120	finally
    //   1121	1123	1120	finally
    //   212	223	1125	java/lang/Error
    //   231	240	1125	java/lang/Error
    //   252	260	1125	java/lang/Error
    //   272	285	1125	java/lang/Error
    //   302	316	1125	java/lang/Error
    //   328	336	1125	java/lang/Error
    //   353	369	1125	java/lang/Error
    //   377	385	1125	java/lang/Error
    //   393	402	1125	java/lang/Error
    //   415	422	1125	java/lang/Error
    //   426	454	1153	java/lang/Error
    //   458	471	1153	java/lang/Error
    //   476	482	1153	java/lang/Error
    //   488	506	1185	java/lang/Error
    //   212	223	1220	java/lang/Exception
    //   231	240	1220	java/lang/Exception
    //   252	260	1220	java/lang/Exception
    //   272	285	1220	java/lang/Exception
    //   302	316	1220	java/lang/Exception
    //   328	336	1220	java/lang/Exception
    //   353	369	1220	java/lang/Exception
    //   377	385	1220	java/lang/Exception
    //   393	402	1220	java/lang/Exception
    //   415	422	1220	java/lang/Exception
    //   426	454	1248	java/lang/Exception
    //   458	471	1248	java/lang/Exception
    //   476	482	1248	java/lang/Exception
    //   488	506	1280	java/lang/Exception
  }
  
  private void a(ShowExternalTroop paramShowExternalTroop)
  {
    if (paramShowExternalTroop == null) {}
    do
    {
      return;
      this.jdField_g_of_type_JavaLangString = paramShowExternalTroop.troopUin;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_b_of_type_JavaLangString = getString(2131364857);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.c = paramShowExternalTroop.troopName;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = paramShowExternalTroop.strFaceUrl;
    } while (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
    H();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_g_of_type_JavaLangString, "1", "", "");
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_g_of_type_JavaLangString, "0", "", "");
  }
  
  public static void a(ProfileCardInfo paramProfileCardInfo)
  {
    int i4 = 3;
    int i3 = 1;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    int i2 = i3;
    int i1 = i4;
    switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      i1 = 0;
      i2 = i3;
    }
    for (;;)
    {
      MQQProfileNameTranslator.a(i1, i2, paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateProfileName profileName=" + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.toString());
      }
      return;
      i1 = 1;
      i2 = 2;
      continue;
      i2 = 2;
      i1 = 2;
      continue;
      i2 = 2;
      i1 = i4;
      continue;
      i1 = 4;
      i2 = i3;
      continue;
      i2 = 2;
      i1 = 6;
      continue;
      i1 = 6;
      i2 = i3;
      continue;
      i2 = 2;
      i1 = 7;
      continue;
      i1 = 7;
      i2 = i3;
      continue;
      i1 = 8;
      i2 = i3;
      continue;
      i1 = 9;
      i2 = i3;
      continue;
      i1 = 11;
      i2 = i3;
      continue;
      i1 = 10;
      i2 = i3;
      continue;
      i1 = 5;
      i2 = i3;
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by Card");
      }
      return false;
    }
    boolean bool2;
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strNick))) {
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramCard.strNick))
      {
        bool2 = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramCard.strNick;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strReMark)) {}
      }
      else
      {
        if ((!bool2) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4], paramCard.strReMark))) {
          break label554;
        }
        bool1 = true;
        label114:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        bool2 = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6], paramCard.strAutoRemark))) {
          break label559;
        }
        bool2 = true;
        label171:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6] = paramCard.strAutoRemark;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool2;
        if (TextUtils.isEmpty(paramCard.strTroopNick)) {}
      }
      else
      {
        if ((!bool2) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1], paramCard.strTroopNick))) {
          break label565;
        }
        paramBoolean = true;
        label228:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1] = paramCard.strTroopNick;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramCard.strContactName)))
        {
          bool1 = true;
          label278:
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strAutoRemark))) {
            break label575;
          }
        }
      }
      label554:
      label559:
      label565:
      label575:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2] = paramCard.strAutoRemark;
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(paramBoolean).append(", strNick = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0])).append(", strRemark = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4])).append(", strContactName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])).append(", strCircleName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2])).append(", strRecommenName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5])).append(", strTroopNickName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1])).append(", strAutoRemark = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6]));
          QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
        }
        return paramBoolean;
        bool2 = false;
        break;
        bool1 = false;
        break label114;
        bool2 = false;
        break label171;
        paramBoolean = false;
        break label228;
        bool1 = false;
        break label278;
      }
      bool2 = false;
    }
  }
  
  private boolean a(ContactCard paramContactCard, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramContactCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by ContactCard");
      }
      return false;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramContactCard.nickName))) {
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramContactCard.nickName))
      {
        paramBoolean = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramContactCard.nickName;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContactCard.strContactName))
      {
        if (!paramBoolean)
        {
          paramBoolean = bool;
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramContactCard.strContactName)) {}
        }
        else
        {
          paramBoolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramContactCard.strContactName;
        return paramBoolean;
        paramBoolean = false;
        break;
      }
      return paramBoolean;
      paramBoolean = false;
    }
  }
  
  private boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      UinUtils.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int + ", entry = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int);
        }
      }
      for (;;)
      {
        return true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException paramProfileCardInfo) {}
  }
  
  public static boolean a(ProfileCardInfo paramProfileCardInfo, int paramInt, String paramString)
  {
    if ((paramInt < 0) && (paramInt > 6)) {
      return false;
    }
    paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  private boolean a(QCallCardInfo paramQCallCardInfo, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramQCallCardInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQCallCardName by QCallCardInfo");
      }
    }
    while ((!paramBoolean) && (TextUtils.isEmpty(paramQCallCardInfo.nickname))) {
      return false;
    }
    paramBoolean = bool;
    if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo.nickname, paramQCallCardInfo.nickname)) {
      paramBoolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo.nickname = paramQCallCardInfo.nickname;
    return paramBoolean;
  }
  
  private String b()
  {
    try
    {
      String str = ((PhoneContactManagerImp)this.app.getManager(10)).c(b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)).uin;
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
      }
    }
    return null;
  }
  
  private static String b(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject1 = a(paramAllInOne);
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).jdField_b_of_type_JavaLangString + ((ProfileActivity.CardContactInfo)localObject1).c;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramAllInOne.jdField_a_of_type_JavaLangString;
      }
      return (String)localObject2;
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 7)
    {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.post(new lkx(this));
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
    String str = this.app.b();
    Object localObject = str;
    if (StringUtil.b(str)) {
      localObject = this.app.b();
    }
    localUserInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
    QZoneHelper.a(this, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int, -1, 5, this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession);
    localObject = new QZoneClickReport.ReportInfo();
    ((QZoneClickReport.ReportInfo)localObject).c = "1";
    ((QZoneClickReport.ReportInfo)localObject).jdField_d_of_type_JavaLangString = "0";
    ((QZoneClickReport.ReportInfo)localObject).b = 4;
    ((QZoneClickReport.ReportInfo)localObject).jdField_k_of_type_JavaLangString = "3";
    ((QZoneClickReport.ReportInfo)localObject).l = "userSummary";
    ((QZoneClickReport.ReportInfo)localObject).m = "homePage";
    QZoneClickReport.startReportImediately(this.app.getAccount(), (QZoneClickReport.ReportInfo)localObject);
    localObject = new HashMap();
    ((HashMap)localObject).put("source_type", "3");
    ((HashMap)localObject).put("source_from", "userSummary");
    ((HashMap)localObject).put("source_to", "homePage");
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    ThreadPriorityManager.a(true);
    ProfileActivity.AllInOne localAllInOne = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    int i1 = ProfileCardUtil.a(localAllInOne);
    if ((localAllInOne.jdField_f_of_type_JavaLangString != null) && (localAllInOne.jdField_f_of_type_JavaLangString.length() > 0) && (localAllInOne.jdField_e_of_type_Int != 3000) && (localAllInOne.jdField_e_of_type_Int != 1) && (localAllInOne.jdField_e_of_type_Int != 2) && (localAllInOne.jdField_f_of_type_JavaLangString.equals(localAllInOne.jdField_a_of_type_JavaLangString)))
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("finchat", true);
      paramBaseActivity.setResult(0, paramQQAppInterface);
      paramBaseActivity.finish();
      return;
    }
    String str = localAllInOne.jdField_a_of_type_JavaLangString;
    if (ProfileActivity.AllInOne.h(localAllInOne)) {
      str = b(localAllInOne);
    }
    for (;;)
    {
      a(paramQQAppInterface, paramBaseActivity, paramProfileCardInfo, str, i1);
      return;
      if (localAllInOne.jdField_a_of_type_Int == 3) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (localAllInOne.jdField_f_of_type_Int == 102) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (localAllInOne.jdField_f_of_type_Int == 103) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void b(ProfileCardInfo paramProfileCardInfo)
  {
    int i2 = 1;
    Object localObject;
    long l1;
    label151:
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initHeaderViewStart", true);
      if (this.jdField_l_of_type_Boolean != true)
      {
        boolean bool = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0");
        if (!bool) {}
      }
      else
      {
        return;
      }
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        ((CardHandler)this.app.a(2)).a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      }
      localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
      if (localObject == null) {
        break label710;
      }
    }
    finally {}
    try
    {
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
        break label507;
      }
      l1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
      if ((l1 != ProfileCardTemplate.b) && (l1 != ProfileCardTemplate.jdField_c_of_type_Long) && (l1 != ProfileCardTemplate.jdField_d_of_type_Long)) {
        break label461;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileGameView(this, paramProfileCardInfo);
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label503;
      }
      QLog.d("FriendProfileCardActivity", 2, localException.toString());
      localException.printStackTrace();
      i1 = 0;
      break label191;
      if (l1 != ProfileCardTemplate.jdField_f_of_type_Long) {
        break label538;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileTagView(this, paramProfileCardInfo);
      break label151;
      if (l1 != ProfileCardTemplate.jdField_g_of_type_Long) {
        break label563;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new VipProfileSimpleView(this, paramProfileCardInfo);
      break label151;
      if (l1 != ProfileCardTemplate.jdField_h_of_type_Long) {
        break label645;
      }
      if (!getSharedPreferences("is_binding_shop", 1).getBoolean(this.jdField_e_of_type_JavaLangString, true)) {
        break label608;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileShoppingView(this, paramProfileCardInfo);
      break label151;
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomListView, this.jdField_a_of_type_AndroidWidgetTextView);
      break label151;
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomListView, this.jdField_a_of_type_AndroidWidgetTextView);
      break label151;
      i1 = 0;
      break label378;
      localException.setVisibility(8);
      break label439;
      if (localException == null) {
        break label439;
      }
      localException.setVisibility(8);
      break label439;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
    a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId);
    J();
    int i1 = 1;
    label191:
    if (i1 == 0)
    {
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomListView, this.jdField_a_of_type_AndroidWidgetTextView);
      a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
      J();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap != null))
    {
      String str = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_dynamic_avatar_tips");
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.videoHeadFlag) || (this.jdField_d_of_type_Boolean) || (TextUtils.isEmpty(str)) || (!str.equals(this.app.f())) || (localObject == null)) {
        break label697;
      }
      paramProfileCardInfo = this.app.a().getSharedPreferences(this.app.a(), 0);
      int i3 = paramProfileCardInfo.getInt("dynamic_avatar_tips_counts", 0);
      if (Build.VERSION.SDK_INT < 11) {
        break label682;
      }
      i1 = i2;
      label378:
      if ((i1 == 0) || (i3 >= 3)) {
        break label688;
      }
      this.jdField_d_of_type_Boolean = true;
      ((TextView)localObject).setVisibility(0);
      paramProfileCardInfo.edit().putInt("dynamic_avatar_tips_counts", i3 + 1).commit();
      ((TextView)localObject).postDelayed(new lkj(this), 2000L);
    }
    for (;;)
    {
      label439:
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initHeaderViewEnd", "initHeaderViewStart", false);
      break;
      label461:
      if (l1 == ProfileCardTemplate.jdField_e_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfilePhotoView(this, paramProfileCardInfo);
        break label151;
      }
      label503:
      label507:
      label538:
      label563:
      label608:
      label645:
      label682:
      label688:
      label697:
      label710:
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView by contactCard");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomListView, this.jdField_a_of_type_AndroidWidgetTextView);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
        J();
      }
      else if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo != null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView by qCallCardInfo");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomListView, this.jdField_a_of_type_AndroidWidgetTextView);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
        J();
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initCardContactInfoList");
    }
    Object localObject3;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        localObject3 = (PhoneContactManager)this.app.getManager(10);
        if (localObject3 != null) {
          break label200;
        }
      }
    }
    label200:
    label439:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject1 = ((PhoneContactManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject2 = localObject1;
        if (paramBoolean) {
          break label439;
        }
        localObject2 = (FriendListHandler)this.app.a(1);
        if ((!((FriendListHandler)localObject2).b()) && (!((FriendListHandler)localObject2).c())) {
          ((FriendListHandler)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
        }
      }
      while (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
        return;
        localObject2 = ((PhoneContactManager)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ((PhoneContactManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((PhoneContact)localObject2).mobileCode))
            {
              this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject2).mobileCode;
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = (FriendListHandler)this.app.a(1);
          localObject2 = localObject1;
          if (!((FriendListHandler)localObject3).c())
          {
            ((FriendListHandler)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
            localObject2 = localObject1;
          }
        }
        localObject1 = localObject2;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36));
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo("", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
  }
  
  private boolean d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void e(String paramString)
  {
    int i2 = 1;
    label44:
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131369949);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int != 6) {
        break label304;
      }
      o();
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new lkf(this));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label321;
      }
      i1 = 1;
      label74:
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34)) {
        break label723;
      }
      if (!TextUtils.isEmpty(b())) {}
    }
    label304:
    label321:
    label713:
    label723:
    for (i2 = 0;; i2 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramString = new DataTag(16, null);
        this.jdField_c_of_type_AndroidWidgetTextView.setTag(paramString);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(this.jdField_b_of_type_Boolean);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131368747);
        }
      }
      for (;;)
      {
        if (i2 == 0) {
          break label713;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramString = new DataTag(44, null);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(this.jdField_b_of_type_Boolean);
        return;
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131369948);
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367975));
        break label44;
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71))
        {
          i1 = 1;
          break label74;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 70)
        {
          i1 = 1;
          break label74;
        }
        if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          i1 = 1;
          break label74;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22))
        {
          i1 = 1;
          break label74;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47))
        {
          i1 = 1;
          break label74;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42))
        {
          i1 = 1;
          break label74;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57))
        {
          i1 = 1;
          break label74;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
        {
          i1 = 0;
          break label74;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36)
        {
          i1 = 0;
          break label74;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int != 0)
          {
            i1 = 1;
            break label74;
          }
          i1 = 0;
          break label74;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2)
        {
          i1 = 1;
          break label74;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74)
        {
          i1 = 1;
          break label74;
        }
        if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          i1 = 1;
          break label74;
        }
        i1 = 0;
        break label74;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131370906);
        continue;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  public Card a(String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    paramString2 = localFriendsManager.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localFriendsManager.b(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localFriendsManager.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  protected QCallCardInfo a()
  {
    QCallCardInfo localQCallCardInfo = null;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo != null) {
      localQCallCardInfo = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo;
    }
    return localQCallCardInfo;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      return this.jdField_h_of_type_JavaLangString;
    }
    ThreadManager.a(new llk(this), 8, null, true);
    return "-1";
  }
  
  public void a()
  {
    Object localObject;
    if (!this.jdField_k_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "send async message to init card in db");
      }
      localObject = ProfilePerformanceReport.a;
      if ((localObject != null) && (((ProfilePerformanceReport)localObject).b())) {
        ((ProfilePerformanceReport)localObject).a(4);
      }
      this.jdField_k_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        localObject = null;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break label180;
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71)) {
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Network_circle_prof", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int), "", "");
      }
      return;
      label180:
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
      {
        localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        ((Message)localObject).what = 9;
        ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        ((Message)localObject).what = 2;
        ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    v();
    u();
    ProfileCardUtil.a(this.app, paramLong1, paramLong2);
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, this.o);
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      Object localObject = this.app.a().getSharedPreferences(this.app.a(), 0);
      if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("svip_profile_show_newer_guide_flag", false)))
      {
        paramView = (ViewStub)paramView.findViewById(2131300591);
        if (paramView != null)
        {
          View localView = paramView.inflate();
          paramView = new DataTag(57, null);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131303326));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
          localObject = new lki(this, (SharedPreferences)localObject);
          ((Button)localView.findViewById(2131303328)).setOnClickListener((View.OnClickListener)localObject);
          localObject = (TextView)localView.findViewById(2131303330);
          ((TextView)localObject).setTag(paramView);
          ((TextView)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
      }
    }
  }
  
  public void a(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.c;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label152;
      }
      Intent localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramCardContactInfo));
      if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
        KapalaiAdapterUtil.a().a(localIntent);
      }
      startActivity(localIntent);
      this.app.a().b(paramCardContactInfo);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "call", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label152:
      a(2131369993, 1);
    }
  }
  
  public void a(Card paramCard)
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.a())))
    {
      localObject1 = new Intent(this, VisitorsActivity.class);
      localObject2 = new Bundle();
      if (paramCard == null)
      {
        i1 = 0;
        ((Bundle)localObject2).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue());
        ((Bundle)localObject2).putLong("totalVoters", i1);
        ((Bundle)localObject2).putBoolean("isStartedByProfileCard", true);
        ((Bundle)localObject2).putBoolean("votersOnly", true);
        if (i1 <= 0) {
          break label252;
        }
      }
      label252:
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject2).putBoolean("hasVoters", bool);
        ((Bundle)localObject2).putInt("frome_where", 5);
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        startActivity((Intent)localObject1);
        NearbyProxy.a(this.app);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          paramCard = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
          if ((paramCard instanceof VoteView)) {
            ((VoteView)paramCard).a(true, false, i1, 0, null, false);
          }
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800657A", "0X800657A", 1, 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        i1 = (int)paramCard.lVoteCount;
        break;
      }
    }
    Object localObject1 = new HashMap();
    Object localObject2 = this.app.a();
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "card is null,vote failed !");
      }
      a(2131370016, 1);
      ((HashMap)localObject1).put("param_FailCode", "-210");
      StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
      return;
    }
    CardHandler localCardHandler = (CardHandler)this.app.a(2);
    if (QLog.isColorLevel()) {
      QLog.i("FriendProfileCardActivity", 2, "Click Vote View, card.bAvailVoteCnt = " + paramCard.bAvailVoteCnt + ",card.bHaveVotedCnt = " + paramCard.bHaveVotedCnt + ",card.strVoteLimitedNotice = " + paramCard.strVoteLimitedNotice);
    }
    label421:
    int i2;
    if (paramCard.bAvailVoteCnt <= 0)
    {
      i1 = 1;
      if ((paramCard.bHaveVotedCnt > 0) || (paramCard.bAvailVoteCnt > 0)) {
        break label629;
      }
      i2 = 1;
    }
    for (;;)
    {
      if ((i1 == 0) && (i2 == 0))
      {
        if ((localCardHandler != null) && (NetworkUtil.e(BaseApplication.getContext())))
        {
          paramCard.lVoteCount += 1L;
          paramCard.bVoted = 1;
          l1 = paramCard.lVoteCount;
          paramCard.bAvailVoteCnt = ((short)(paramCard.bAvailVoteCnt - 1));
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          this.jdField_e_of_type_Boolean = true;
          if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FriendProfileCardActivity", 4, "reqFavorite| onclick =" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin + "," + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount);
            }
            paramCard = Message.obtain();
            paramCard.what = 10;
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramCard, 2000L);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, l1, true);
          return;
          i1 = 0;
          break label421;
          label629:
          i2 = 0;
          continue;
        }
        if (localCardHandler != null)
        {
          ((HashMap)localObject1).put("param_FailCode", "-203");
          StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
          a(2131369994, 1);
          return;
        }
        ((HashMap)localObject1).put("param_FailCode", "-204");
        StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
        a(2131370016, 1);
        return;
      }
    }
    long l1 = SystemClock.uptimeMillis() - jdField_g_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "toastInterval:" + l1);
    }
    if (paramCard.strVoteLimitedNotice != null)
    {
      if (l1 > jdField_h_of_type_Long)
      {
        a(paramCard.strVoteLimitedNotice, 1);
        jdField_g_of_type_Long = SystemClock.uptimeMillis();
      }
      if (i2 != 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006579", "0X8006579", 1, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int)), "", "", "");
      }
    }
    for (;;)
    {
      StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
      return;
      if (i1 != 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8006578", "0X8006578", 1, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int)), "", "", "");
        continue;
        if (l1 > jdField_h_of_type_Long)
        {
          a(2131370016, 1);
          jdField_g_of_type_Long = SystemClock.uptimeMillis();
        }
        if (i1 != 0) {
          ((HashMap)localObject1).put("param_FailCode", "-230");
        } else if (i2 != 0) {
          ((HashMap)localObject1).put("param_FailCode", "-231");
        } else {
          ((HashMap)localObject1).put("param_FailCode", "-220");
        }
      }
    }
  }
  
  public void a(Card paramCard, String paramString)
  {
    Object localObject = null;
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_qzonecover"))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramString, 1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
        ((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).b();
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
      b(true);
      l1 = 0L;
      if (paramCard == null) {
        break label306;
      }
      l1 = paramCard.feedPreviewTime;
      paramString = paramCard.vSeed;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      a(paramCard, false);
    }
    for (paramCard = paramString;; paramCard = null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56)
      {
        paramString = (String)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57) {}
      }
      else
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
      }
      a(l1, paramCard, paramString, true);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_qzonecover"))) {
        break;
      }
      ProfileHeaderView localProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        i1 = 1;
      }
      localProfileHeaderView.a(str, i1);
      break;
      label306:
      F();
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initUpdateInfoStart", true);
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateInfo Card=");
      if (paramCard != null)
      {
        str = paramCard.getProfileCardDesc();
        QLog.i("Q.profilecard.FrdProfileCard", 2, str + " isNetRet = " + paramBoolean);
      }
    }
    else
    {
      e(null);
      a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
      if ((this.jdField_k_of_type_Int != 1) && (paramBoolean))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry == null) || (paramCard == null)) {
          break label159;
        }
        paramCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramCard, paramBoolean);
      C();
      f();
      a(this.jdField_e_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initUpdateInfoEnd", "initUpdateInfoStart", false);
      return;
      str = "null";
      break;
      label159:
      A();
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean, int paramInt)
  {
    if ((paramCard == null) || ((paramInt == 1) || (paramInt == 8))) {}
    for (;;)
    {
      ProfilePerformanceReport localProfilePerformanceReport;
      boolean bool1;
      long l1;
      int i1;
      Object localObject;
      long l2;
      ProfileCardTemplate localProfileCardTemplate;
      try
      {
        if (paramCard.lCurrentBgId >= 0L) {
          ReportController.b(this.app, "CliOper", "", "", "card_mall", "Prof_in_client", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Long.toString(paramCard.lCurrentBgId), "", "");
        }
        localProfilePerformanceReport = ProfilePerformanceReport.a;
        if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.b())) {
          localProfilePerformanceReport.a(7);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "onCardUpdate isHeaderViewInited=" + this.jdField_l_of_type_Boolean + ",isNetCard=" + paramBoolean + ",msgType=" + paramInt + ",card=" + paramCard.getProfileCardDesc());
        }
        a(paramCard, paramBoolean);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        bool1 = this.jdField_l_of_type_Boolean;
        if (bool1) {}
      }
      finally {}
      try
      {
        l1 = paramCard.lCurrentStyleId;
        i1 = paramCard.templateRet;
        localObject = paramCard.backgroundUrl;
        l2 = paramCard.backgroundColor;
        if (l1 >= 0L) {
          continue;
        }
        bool1 = NetworkUtil.h(this);
        if ((!bool1) || (paramBoolean)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        continue;
        if (!b(localOutOfMemoryError)) {
          break label606;
        }
        ThreadManager.a(new lmk(this, localProfileCardTemplate, localOutOfMemoryError), 5, null, true);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        continue;
        i1 = 0;
      }
    }
    return;
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initValidTemplateStart", true);
    localProfileCardTemplate = ProfileCardUtil.a(this.app, l1, true);
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initValidTemplateEnd", "initValidTemplateStart", false);
    if ((l1 <= 0L) || (localProfileCardTemplate == null) || (TextUtils.isEmpty((CharSequence)localObject)) || (i1 != 0)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;; this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = localProfileCardTemplate)
    {
      localObject = this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
      ((Message)localObject).what = 5;
      ((Message)localObject).obj = paramCard;
      if (!paramBoolean) {
        break label617;
      }
      i1 = 1;
      ((Message)localObject).arg1 = i1;
      ((Message)localObject).arg2 = paramInt;
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
      if ((localProfilePerformanceReport == null) || (!localProfilePerformanceReport.b())) {
        break;
      }
      localProfilePerformanceReport.b(7);
      break;
      bool1 = ProfileCardUtil.a(this.app);
      boolean bool2 = ProfileCardUtil.a(this.app.a(), (String)localObject);
      if ((!bool1) || (!bool2)) {
        break label576;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initTemplateConfigStart", true);
      bool1 = localProfileCardTemplate.a(this.app, l2, l1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initTemplateConfigEnd", "initTemplateConfigStart", false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initTemplateBackgroundStart", true);
      bool2 = a((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initTemplateBackgroundEnd", "initTemplateBackgroundStart", false);
      if ((!bool1) || (!bool2)) {
        break label547;
      }
    }
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo ContactCard card = " + paramContactCard + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    if (a(paramContactCard, paramBoolean)) {
      a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(null, paramBoolean);
    C();
    f();
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0);
    if (((localView instanceof ProfileHeaderView)) && (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView update");
      }
      ((ProfileHeaderView)localView).a(paramProfileCardInfo, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.requestLayout();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView is loading");
      }
      b(paramProfileCardInfo);
    }
  }
  
  public void a(QCallCardInfo paramQCallCardInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo QCallCardInfo card = " + paramQCallCardInfo + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    if (a(paramQCallCardInfo, paramBoolean)) {
      a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(null, paramBoolean);
    C();
    f();
  }
  
  public void a(OnGetPhotoWallListener paramOnGetPhotoWallListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOnGetPhotoWallListener = paramOnGetPhotoWallListener;
  }
  
  public void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (ProfileActivity.a(this.jdField_f_of_type_Long, l1))
    {
      this.jdField_f_of_type_Long = l1;
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        str = b();
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = String.format("http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { str });
      }
      paramString = new Intent(this, MusicGeneQQBrowserActivity.class);
      paramString.putExtra("uin", this.app.a());
      paramString.putExtra("url", (String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label257;
      }
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      startActivity(paramString);
      ReportController.b(this.app, "CliOper", "", "", "0X8004182 ", "0X8004182", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      label257:
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramString, getTitleBarHeight(), 0, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i = NetConnInfoCenter.getServerTime();
      return;
    }
    this.i = 0L;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      String str1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str1 = "http://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      Intent localIntent = new Intent(this, GameCenterActivity.class);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      paramString = str2;
      if (TextUtils.isEmpty(str2)) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      localIntent.putExtra("url", HtmlOffline.a(str1, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.jdField_a_of_type_Int + "&osv=" + Build.VERSION.RELEASE + "&vuin=" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "&vname=" + paramString + "&bn=" + paramBoolean));
      startActivity(localIntent);
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131230742);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    int i1 = 0;
    if (i1 < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i1] == 16) {
        localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[i1]]);
      }
      for (;;)
      {
        if (paramArrayOfInt[i1] == 20) {
          localActionSheet.a(2131371315);
        }
        i1 += 1;
        break;
        if (paramArrayOfInt[i1] == 19)
        {
          localActionSheet.a(2131372446);
          if ((this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time > 0))
          {
            this.jdField_l_of_type_Int = 1;
            localActionSheet.a(getResources().getString(2131372444), getResources().getDrawable(2130839269), 0);
            ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0))
          {
            this.jdField_l_of_type_Int = 2;
            localActionSheet.a(getResources().getString(2131372444), getResources().getDrawable(2130839268), 0);
            ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
          }
          else
          {
            this.jdField_l_of_type_Int = 5;
            localActionSheet.a(getResources().getString(2131372444), getResources().getDrawable(2130839267), 0);
            ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
          }
        }
        else if ((paramArrayOfInt[i1] >= 0) && (paramArrayOfInt[i1] < this.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[i1]], 1);
        }
      }
    }
    localActionSheet.a(new lkc(this, localActionSheet));
    try
    {
      if (!isFinishing()) {
        localActionSheet.show();
      }
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.i != 0L)
    {
      if (Math.abs(this.i - NetConnInfoCenter.getServerTime()) < 60L) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.i = 0L;
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    Card localCard = localFriendsManager.a(this.app.a());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localFriendsManager.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground url=" + paramString + ",thread=" + Thread.currentThread().getName());
    }
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          localObject1 = ProfileCardUtil.a(this, paramString);
          str = "profilecard:" + (String)localObject1;
          localObject2 = (Pair)BaseApplicationImpl.a.get(str);
          if ((localObject2 != null) && (((Pair)localObject2).first != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "get background form sImageCache filePath=" + (String)localObject1);
            }
            localObject1 = ((Drawable.ConstantState)((Pair)localObject2).first).newDrawable();
            this.jdField_b_of_type_JavaLangString = paramString;
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
            return true;
          }
          localObject2 = new File((String)localObject1);
          if ((!((File)localObject2).isFile()) || (!((File)localObject2).exists())) {
            continue;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          localResources = this.app.a().getResources();
          BitmapFactory.decodeFile((String)localObject1, localOptions);
          i1 = localOptions.outHeight;
          i2 = localOptions.outWidth;
          if ((i1 <= 0) || (i2 <= 0))
          {
            ((File)localObject2).delete();
            return false;
          }
          localObject2 = getResources().getDisplayMetrics();
          i3 = Math.min(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
          i4 = Math.max(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
          float f1 = i3 / i4;
          i3 = Math.min(i2, (int)(i1 * f1 + 0.5F));
          i4 = (int)(i3 / f1);
          localObject2 = new BitmapFactory.Options();
          localObject1 = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream((String)localObject1)), null, (BitmapFactory.Options)localObject2);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.FrdProfileCard", 2, "background info imageWidth=" + i3 + ",imageHeight=" + i4);
        }
        catch (Exception paramString)
        {
          String str;
          Object localObject2;
          Resources localResources;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground exception and msg=" + paramString.getMessage());
          paramString.printStackTrace();
          return false;
        }
        catch (OutOfMemoryError paramString)
        {
          Object localObject1;
          int i1;
          int i2;
          int i3;
          int i4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground oom error and msg=" + paramString.getMessage());
          paramString.printStackTrace();
          continue;
          if (localObject1 == null) {
            continue;
          }
          if ((i2 != i3) || (i1 != i4)) {
            continue;
          }
          continue;
        }
        if (localObject1 == null) {
          continue;
        }
        i1 = Utils.a((Bitmap)localObject1);
        localObject1 = new BitmapDrawable(localResources, (Bitmap)localObject1);
        ((BitmapDrawable)localObject1).setTargetDensity(localResources.getDisplayMetrics());
        BaseApplicationImpl.a.put(str, new Pair(((BitmapDrawable)localObject1).getConstantState(), Integer.valueOf(i1)));
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
        if (!QLog.isColorLevel()) {
          break label667;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "background info url=" + paramString + ",backgroundDrawableSize=" + i1);
        break label667;
        localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, i3, i4);
        ((Bitmap)localObject1).recycle();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "Background size not match screen size, create a new one to resize");
        }
        localObject1 = localObject2;
      }
    }
    label667:
    return true;
  }
  
  protected void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.card.modify");
    localIntentFilter.addAction("com.tencent.mobileqq.view.self.album");
    localIntentFilter.setPriority(Integer.MAX_VALUE);
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
  }
  
  public void b(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.c;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label128;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("smsto:" + paramCardContactInfo));
      startActivity(localIntent);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "send_sms", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label128:
      a(2131369993, 1);
    }
  }
  
  public void b(String paramString)
  {
    if (paramString != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)getSystemService("clipboard")).setText(paramString);
      }
    }
    else {
      return;
    }
    ((android.content.ClipboardManager)getSystemService("clipboard")).setText(paramString);
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
      return true;
    }
    int i1 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
    if (i1 > 3) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i1 + 1));
    return true;
  }
  
  public void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131370691);
    localActionSheet.c(2131370040);
    localActionSheet.c(2131370042);
    localActionSheet.c(2131370041);
    localActionSheet.d(2131367262);
    localActionSheet.a(new lka(this, localActionSheet));
    try
    {
      if (!isFinishing()) {
        localActionSheet.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!NetworkUtil.e(BaseApplication.getContext())) {
          break label183;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))) {
          break label172;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
        if (localFriendListHandler == null) {
          break label161;
        }
        localFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramCardContactInfo, false);
        this.jdField_f_of_type_Int |= 0x1;
        c(paramCardContactInfo);
      }
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Edit_name", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.jdField_a_of_type_JavaLangString;
      break;
      label161:
      a(2131370010, 1);
      continue;
      label172:
      a(2131370009, 1);
      continue;
      label183:
      a(2131368804, 1);
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, 4, paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    paramString = (MQQProfileName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.clone();
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    switch (paramString.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName))
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      }
    }
  }
  
  public boolean c(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)) {
      return false;
    }
    return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() > 3;
  }
  
  public void d()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(10);
    Object localObject = localPhoneContactManagerImp.c(b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    if (localObject == null) {
      return;
    }
    boolean bool = ((PhoneContact)localObject).isHiden;
    localObject = (ActionSheet)ActionSheetHelper.a(this, null);
    if (bool)
    {
      i1 = 2131370038;
      label57:
      ((ActionSheet)localObject).a(i1);
      if (!bool) {
        break label124;
      }
    }
    label124:
    for (int i1 = 2131370039;; i1 = 2131370037)
    {
      ((ActionSheet)localObject).c(i1);
      ((ActionSheet)localObject).d(2131367262);
      ((ActionSheet)localObject).a(new lkb(this, localPhoneContactManagerImp, bool, (ActionSheet)localObject));
      try
      {
        if (isFinishing()) {
          break;
        }
        ((ActionSheet)localObject).show();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i1 = 2131370036;
      break label57;
    }
  }
  
  protected void d(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("action_cover_pick_gallery", true);
    localIntent.putExtra("PhotoConst.32_Bit_Config", true);
    PhotoUtils.a(localIntent, this, getClass().getName(), ProfileCardUtil.b(this), ProfileCardUtil.c(this), ProfileCardUtil.b(this), ProfileCardUtil.c(this), paramString, ProfileCardUtil.c());
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    Object localObject1 = (CardHandler)this.app.a(2);
    if ((paramInt2 == -1) && (paramIntent != null)) {
      if (!NetworkUtil.e(BaseApplication.getContext())) {
        a(2131368805, 1);
      }
    }
    label175:
    label221:
    label305:
    label593:
    label613:
    label765:
    label783:
    label1312:
    do
    {
      do
      {
        boolean bool;
        do
        {
          do
          {
            do
            {
              Object localObject2;
              do
              {
                Object localObject3;
                do
                {
                  for (;;)
                  {
                    return;
                    if (paramInt1 == 1019)
                    {
                      localObject3 = paramIntent.getStringArrayListExtra("key_cover_selected_img_path");
                      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("FriendProfileCardActivity", 2, "pick photo from qzone size:" + ((ArrayList)localObject3).size());
                        }
                        ((CardHandler)localObject1).a((ArrayList)localObject3);
                        w();
                      }
                      if (paramInt1 == 1022)
                      {
                        ((CardHandler)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
                        localObject1 = (FriendsManager)this.app.getManager(50);
                        if (localObject1 != null) {
                          break label593;
                        }
                        localObject3 = null;
                        if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)))
                        {
                          this.jdField_k_of_type_Int = paramIntent.getIntExtra("param_joined_group_switch", -1);
                          localObject1 = null;
                          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
                            break label613;
                          }
                          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
                          a(((Card)localObject3).feedPreviewTime, ((Card)localObject3).vSeed, (byte[])localObject1, true);
                        }
                      }
                      if ((paramInt1 == 1021) && (paramInt2 == -1)) {
                        d(ImageUtil.c(this, this.jdField_b_of_type_AndroidNetUri));
                      }
                      if ((paramInt1 == 1015) && (paramIntent != null)) {
                        this.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("isDataChanged", false);
                      }
                      if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
                      {
                        if (!paramIntent.hasExtra("result")) {
                          break label765;
                        }
                        localObject1 = paramIntent.getStringExtra("result");
                        if (QLog.isColorLevel()) {
                          QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultStr : " + (String)localObject1);
                        }
                        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
                      }
                    }
                    for (;;)
                    {
                      try
                      {
                        localObject1 = new JSONObject((String)localObject1);
                        if (localObject1 != null)
                        {
                          localObject1 = ((JSONObject)localObject1).get("payState");
                          if ((localObject1 != null) && ("0".equals(String.valueOf(localObject1)))) {
                            a(0L, null, null, false);
                          }
                        }
                      }
                      catch (JSONException localJSONException)
                      {
                        localJSONException.printStackTrace();
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.e("FriendProfileCardActivity", 2, "onActivityResult, JSONException : " + localJSONException.getMessage());
                        continue;
                      }
                      catch (Exception localException)
                      {
                        localException.printStackTrace();
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.e("FriendProfileCardActivity", 2, "onActivityResult, Exception : " + localException.getMessage());
                        continue;
                      }
                      if ((paramInt1 == 1019) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("has_operation", false))) {
                        this.jdField_a_of_type_AndroidContentIntent = paramIntent;
                      }
                      if (paramInt1 != 1010) {
                        break label783;
                      }
                      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 101) || (paramInt2 != -1)) {
                        break;
                      }
                      finish();
                      return;
                      if (paramInt1 != 1020) {
                        break label175;
                      }
                      localObject3 = paramIntent.getStringExtra("key_cover_selected_img_path");
                      if (TextUtils.isEmpty((CharSequence)localObject3)) {
                        break label175;
                      }
                      d((String)localObject3);
                      break label175;
                      localObject3 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                      break label221;
                      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
                        break label305;
                      }
                      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
                      break label305;
                      if (QLog.isColorLevel()) {
                        QLog.e("FriendProfileCardActivity", 2, "onActivityResult, data contain no result key.");
                      }
                    }
                    if (paramInt1 == 1008)
                    {
                      if ((paramIntent != null) && (paramIntent.getExtras() != null))
                      {
                        bool = paramIntent.getExtras().getBoolean("photowall_updated");
                        paramIntent = (CoverCacheData)paramIntent.getExtras().getParcelable("current_cover");
                        if (((paramInt2 == -1) || (bool)) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
                          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramIntent);
                        }
                        if (paramIntent == null) {
                          continue;
                        }
                        localObject2 = Message.obtain();
                        ((Message)localObject2).what = 3;
                        ((Message)localObject2).obj = paramIntent;
                        if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
                          continue;
                        }
                        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject2);
                        return;
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
                        continue;
                      }
                      try
                      {
                        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
                        if (localObject2 != null)
                        {
                          paramIntent = new CoverCacheData();
                          paramIntent.c = ((CoverCacheData)localObject2).c;
                          paramIntent.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = ((CoverCacheData)localObject2).jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo;
                          paramIntent.jdField_a_of_type_JavaUtilArrayList = ((CoverCacheData)localObject2).jdField_a_of_type_JavaUtilArrayList;
                          paramIntent.jdField_b_of_type_JavaLangString = ((CoverCacheData)localObject2).jdField_b_of_type_JavaLangString;
                          paramIntent.jdField_a_of_type_Long = ((CoverCacheData)localObject2).jdField_a_of_type_Long;
                          paramIntent.jdField_a_of_type_JavaUtilHashMap = ((CoverCacheData)localObject2).jdField_a_of_type_JavaUtilHashMap;
                          paramIntent.jdField_a_of_type_Int = 0;
                          paramIntent.jdField_a_of_type_Int = 0;
                          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramIntent);
                          localObject2 = Message.obtain();
                          ((Message)localObject2).what = 3;
                          ((Message)localObject2).obj = paramIntent;
                          if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
                          {
                            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject2);
                            return;
                          }
                        }
                      }
                      catch (Exception paramIntent)
                      {
                        paramIntent.printStackTrace();
                        return;
                      }
                    }
                  }
                  if (paramInt1 != 1007) {
                    break;
                  }
                } while (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0);
                localObject2 = (FriendsManager)this.app.getManager(50);
                if (localObject2 == null)
                {
                  localObject3 = null;
                  if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject3);
                    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString = ((Card)localObject3).strNick;
                    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = ((Card)localObject3).strNick;
                    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = "";
                    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
                    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
                    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a((Card)localObject3);
                    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(((Card)localObject3).getRichStatus());
                    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
                    if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)))
                    {
                      this.jdField_k_of_type_Int = paramIntent.getIntExtra("param_joined_group_switch", -1);
                      localObject2 = null;
                      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
                        break label1312;
                      }
                    }
                  }
                }
                for (localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) {
                  do
                  {
                    a(((Card)localObject3).feedPreviewTime, ((Card)localObject3).vSeed, (byte[])localObject2, true);
                    setResult(-1, paramIntent);
                    return;
                    localObject3 = ((FriendsManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                    break;
                  } while ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36));
                }
              } while (paramInt2 != -1);
              switch (paramInt1)
              {
              default: 
                return;
              case 5: 
                paramIntent = ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
                paramInt1 = Math.min(482, ProfileCardUtil.a(this));
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("Business_Origin", 100);
                PhotoUtils.a((Intent)localObject2, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.a());
                return;
              }
            } while (paramIntent == null);
            if (paramIntent.getBooleanExtra("finchat", false))
            {
              finish();
              return;
            }
            paramIntent = paramIntent.getStringExtra("remark");
          } while (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, paramIntent));
          c(paramIntent);
          return;
          setResult(-1);
          finish();
          return;
          if (!NetworkUtil.e(BaseApplication.getContext()))
          {
            a(2131368805, 1);
            return;
          }
          bool = false;
          if (paramIntent != null) {
            bool = paramIntent.getBooleanExtra("avatar_changed", false);
          }
        } while (!bool);
        paramIntent = paramIntent.getStringExtra("avatar_filepath");
        if (!ProfileCardUtil.a(this.app, paramIntent)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      return;
      a(2131370143, 1);
      return;
      paramIntent = ((FriendsManager)this.app.getManager(50)).a(this.app.a());
    } while ((paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null));
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.p(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    return;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int = 1;
  }
  
  /* Error */
  protected boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: getstatic 2085	com/tencent/util/ProfilePerformanceReport:a	Lcom/tencent/util/ProfilePerformanceReport;
    //   3: astore_2
    //   4: aload_2
    //   5: ifnull +25 -> 30
    //   8: aload_2
    //   9: invokevirtual 2086	com/tencent/util/ProfilePerformanceReport:b	()Z
    //   12: ifeq +18 -> 30
    //   15: aload_2
    //   16: iconst_0
    //   17: invokevirtual 2409	com/tencent/util/ProfilePerformanceReport:b	(I)V
    //   20: aload_2
    //   21: iconst_1
    //   22: invokevirtual 2087	com/tencent/util/ProfilePerformanceReport:a	(I)V
    //   25: aload_2
    //   26: iconst_2
    //   27: invokevirtual 2087	com/tencent/util/ProfilePerformanceReport:a	(I)V
    //   30: aload_0
    //   31: new 498	com/tencent/mobileqq/utils/TimeTraceUtil
    //   34: dup
    //   35: ldc 12
    //   37: invokespecial 2967	com/tencent/mobileqq/utils/TimeTraceUtil:<init>	(Ljava/lang/String;)V
    //   40: putfield 494	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   43: aload_0
    //   44: invokevirtual 399	com/tencent/mobileqq/activity/FriendProfileCardActivity:getIntent	()Landroid/content/Intent;
    //   47: astore_2
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 2970	com/tencent/mobileqq/activity/FriendProfileCardActivity:mActNeedImmersive	Z
    //   53: aload_0
    //   54: aload_1
    //   55: invokespecial 2972	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   58: pop
    //   59: aload_0
    //   60: getfield 494	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   63: ldc_w 2974
    //   66: iconst_0
    //   67: invokevirtual 501	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Z)V
    //   70: aload_0
    //   71: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   74: invokevirtual 1808	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   77: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +7 -> 87
    //   83: aload_2
    //   84: ifnonnull +9 -> 93
    //   87: aload_0
    //   88: invokevirtual 2896	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_0
    //   94: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   97: aload_0
    //   98: getfield 268	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   101: putfield 2975	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   104: aload_0
    //   105: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   108: aload_0
    //   109: getfield 263	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidViewView$OnLongClickListener	Landroid/view/View$OnLongClickListener;
    //   112: putfield 2976	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_AndroidViewView$OnLongClickListener	Landroid/view/View$OnLongClickListener;
    //   115: aload_0
    //   116: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   119: aload_2
    //   120: ldc_w 2978
    //   123: invokevirtual 2981	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   126: checkcast 388	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   129: putfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   137: invokespecial 2983	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/profile/ProfileCardInfo;)Z
    //   140: ifne +9 -> 149
    //   143: aload_0
    //   144: invokevirtual 2896	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   147: iconst_0
    //   148: ireturn
    //   149: aload_0
    //   150: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   153: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   156: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   159: invokestatic 2987	com/tencent/biz/bmqq/util/BmqqSegmentUtil:c	(Ljava/lang/String;)Z
    //   162: ifeq +41 -> 203
    //   165: new 403	android/content/Intent
    //   168: dup
    //   169: aload_0
    //   170: ldc_w 1509
    //   173: invokespecial 823	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   176: astore_1
    //   177: aload_1
    //   178: ldc_w 2978
    //   181: aload_0
    //   182: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   185: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   188: invokevirtual 2990	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   191: pop
    //   192: aload_0
    //   193: aload_1
    //   194: invokespecial 2991	com/tencent/mobileqq/activity/ProfileActivity:startActivity	(Landroid/content/Intent;)V
    //   197: aload_0
    //   198: invokespecial 2992	com/tencent/mobileqq/activity/ProfileActivity:finish	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: aload_0
    //   204: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   207: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   210: getfield 425	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   213: bipush 41
    //   215: if_icmpne +43 -> 258
    //   218: aload_0
    //   219: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   222: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   225: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   228: invokestatic 791	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifne +27 -> 258
    //   234: aload_0
    //   235: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   238: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   241: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   244: ldc_w 772
    //   247: invokevirtual 782	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq +8 -> 258
    //   253: aload_0
    //   254: iconst_0
    //   255: putfield 177	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Boolean	Z
    //   258: aload_0
    //   259: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   262: invokevirtual 778	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   265: aload_0
    //   266: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   269: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   272: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: invokevirtual 782	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifeq +14 -> 292
    //   281: aload_0
    //   282: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   285: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   288: iconst_0
    //   289: putfield 425	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   292: new 2994	lkp
    //   295: dup
    //   296: aload_0
    //   297: invokespecial 2995	lkp:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   300: iconst_5
    //   301: aconst_null
    //   302: iconst_0
    //   303: invokestatic 948	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   306: aload_0
    //   307: new 724	com/tencent/util/WeakReferenceHandler
    //   310: dup
    //   311: invokestatic 2998	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Looper;
    //   314: aload_0
    //   315: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidOsHandler$Callback	Landroid/os/Handler$Callback;
    //   318: invokespecial 3001	com/tencent/util/WeakReferenceHandler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   321: putfield 2089	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   324: aload_0
    //   325: new 724	com/tencent/util/WeakReferenceHandler
    //   328: dup
    //   329: invokestatic 3006	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   332: aload_0
    //   333: getfield 273	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidOsHandler$Callback	Landroid/os/Handler$Callback;
    //   336: invokespecial 3001	com/tencent/util/WeakReferenceHandler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   339: putfield 718	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   342: aload_0
    //   343: invokevirtual 3007	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	()V
    //   346: aload_0
    //   347: aload_0
    //   348: getfield 238	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqAppCardObserver	Lcom/tencent/mobileqq/app/CardObserver;
    //   351: invokevirtual 3011	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 253	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqAppFriendListObserver	Lcom/tencent/mobileqq/app/FriendListObserver;
    //   359: invokevirtual 3011	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   362: aload_0
    //   363: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   366: aload_0
    //   367: getfield 248	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver	Lcom/tencent/mobileqq/phonecontact/ContactBindObserver;
    //   370: invokevirtual 3015	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   373: aload_0
    //   374: aload_0
    //   375: getfield 199	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqAppTroopObserver	Lcom/tencent/mobileqq/app/TroopObserver;
    //   378: invokevirtual 3011	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   381: aload_0
    //   382: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   385: iconst_2
    //   386: invokevirtual 372	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   389: checkcast 1017	com/tencent/mobileqq/app/CardHandler
    //   392: astore_1
    //   393: aload_1
    //   394: ifnull +15 -> 409
    //   397: aload_1
    //   398: aload_0
    //   399: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: aload_0
    //   403: getfield 337	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler	Lcom/tencent/mobileqq/transfile/TransProcessorHandler;
    //   406: invokevirtual 3018	com/tencent/mobileqq/app/CardHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/transfile/TransProcessorHandler;)V
    //   409: aload_0
    //   410: new 793	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 794	java/lang/StringBuilder:<init>	()V
    //   417: aload_0
    //   418: getfield 181	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   421: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   428: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   431: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   434: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 805	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: putfield 181	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   443: aload_0
    //   444: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   447: bipush 14
    //   449: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   452: checkcast 3020	com/tencent/mobileqq/richstatus/StatusManager
    //   455: astore_1
    //   456: aload_1
    //   457: ifnull +11 -> 468
    //   460: aload_1
    //   461: aload_0
    //   462: getfield 278	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener	Lcom/tencent/mobileqq/richstatus/IIconListener;
    //   465: invokevirtual 3022	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/Object;)V
    //   468: aload_0
    //   469: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   472: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   475: getfield 1039	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_g_of_type_Int	I
    //   478: bipush 6
    //   480: if_icmpne +24 -> 504
    //   483: aload_0
    //   484: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   487: invokevirtual 3025	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   490: ifnull +14 -> 504
    //   493: aload_0
    //   494: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   497: invokevirtual 3025	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   500: aload_0
    //   501: invokevirtual 3030	com/tencent/mobileqq/app/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
    //   504: invokestatic 3035	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	()Lcom/tencent/mobileqq/musicpendant/MusicPendantManager;
    //   507: ifnull +41 -> 548
    //   510: aload_0
    //   511: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   514: ifnull +34 -> 548
    //   517: aload_0
    //   518: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   521: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   524: ifnull +24 -> 548
    //   527: invokestatic 3035	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	()Lcom/tencent/mobileqq/musicpendant/MusicPendantManager;
    //   530: aload_0
    //   531: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   534: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   537: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   540: aload_0
    //   541: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   544: aload_0
    //   545: invokevirtual 3038	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;)V
    //   548: aload_0
    //   549: iconst_0
    //   550: invokespecial 2329	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	(Z)V
    //   553: getstatic 777	com/tencent/mobileqq/vas/ClubContentJsonTask:a	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo;
    //   556: ifnonnull +17 -> 573
    //   559: new 3040	lld
    //   562: dup
    //   563: aload_0
    //   564: invokespecial 3041	lld:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   567: iconst_5
    //   568: aconst_null
    //   569: iconst_1
    //   570: invokestatic 948	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   573: aload_0
    //   574: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   577: bipush 7
    //   579: anewarray 459	java/lang/String
    //   582: putfield 1148	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   585: new 3043	llo
    //   588: dup
    //   589: aload_0
    //   590: invokespecial 3044	llo:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   593: bipush 8
    //   595: aconst_null
    //   596: iconst_1
    //   597: invokestatic 948	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   600: aload_0
    //   601: invokespecial 2340	com/tencent/mobileqq/activity/FriendProfileCardActivity:F	()V
    //   604: aload_0
    //   605: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   608: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   611: getfield 425	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   614: bipush 33
    //   616: if_icmpeq +269 -> 885
    //   619: aload_0
    //   620: invokevirtual 3045	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	()V
    //   623: aload_0
    //   624: invokespecial 3047	com/tencent/mobileqq/activity/FriendProfileCardActivity:I	()V
    //   627: aload_0
    //   628: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   631: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   634: getfield 425	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   637: ifeq +110 -> 747
    //   640: new 2475	java/text/SimpleDateFormat
    //   643: dup
    //   644: ldc_w 3049
    //   647: invokespecial 2478	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   650: new 3051	java/util/Date
    //   653: dup
    //   654: invokestatic 811	java/lang/System:currentTimeMillis	()J
    //   657: invokespecial 3053	java/util/Date:<init>	(J)V
    //   660: invokevirtual 2485	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   663: astore_1
    //   664: aload_0
    //   665: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   668: invokevirtual 3057	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   671: ldc_w 3059
    //   674: ldc -87
    //   676: invokeinterface 3061 3 0
    //   681: astore_2
    //   682: aload_2
    //   683: aload_1
    //   684: invokevirtual 782	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   687: ifne +17 -> 704
    //   690: new 3063	lmj
    //   693: dup
    //   694: aload_0
    //   695: invokespecial 3064	lmj:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   698: iconst_5
    //   699: aconst_null
    //   700: iconst_1
    //   701: invokestatic 948	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   704: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq +40 -> 747
    //   710: ldc_w 350
    //   713: iconst_2
    //   714: new 793	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 794	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 3066
    //   724: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload_1
    //   728: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: ldc_w 3068
    //   734: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: aload_2
    //   738: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 805	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 423	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   747: aload_0
    //   748: getfield 616	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   751: ldc_w 3070
    //   754: invokestatic 3075	com/tencent/mobileqq/util/AccessibilityUtil:a	(Landroid/view/View;Ljava/lang/String;)V
    //   757: aload_0
    //   758: getfield 616	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   761: invokestatic 3076	com/tencent/mobileqq/util/AccessibilityUtil:b	(Landroid/view/View;)V
    //   764: aload_0
    //   765: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   768: getfield 386	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   771: getfield 425	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   774: ifne +173 -> 947
    //   777: aload_0
    //   778: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   781: ldc_w 1679
    //   784: ldc 22
    //   786: ldc -87
    //   788: ldc_w 3078
    //   791: ldc_w 3078
    //   794: iconst_0
    //   795: iconst_0
    //   796: ldc -87
    //   798: ldc -87
    //   800: ldc -87
    //   802: ldc -87
    //   804: invokestatic 846	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   807: aload_0
    //   808: getfield 494	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   811: ldc_w 3079
    //   814: iconst_0
    //   815: invokevirtual 501	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Z)V
    //   818: aload_0
    //   819: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   822: ifnull +38 -> 860
    //   825: aload_0
    //   826: aload_0
    //   827: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   830: sipush 142
    //   833: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   836: checkcast 2564	com/tencent/mobileqq/qcall/PstnManager
    //   839: putfield 2562	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqQcallPstnManager	Lcom/tencent/mobileqq/qcall/PstnManager;
    //   842: aload_0
    //   843: aload_0
    //   844: getfield 2562	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqQcallPstnManager	Lcom/tencent/mobileqq/qcall/PstnManager;
    //   847: aload_0
    //   848: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   851: invokevirtual 778	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   854: invokevirtual 3082	com/tencent/mobileqq/qcall/PstnManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/qcall/PstnCardInfo;
    //   857: putfield 2547	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo	Lcom/tencent/mobileqq/qcall/PstnCardInfo;
    //   860: iconst_1
    //   861: ireturn
    //   862: astore_1
    //   863: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   866: ifeq +13 -> 879
    //   869: ldc_w 350
    //   872: iconst_2
    //   873: ldc -87
    //   875: aload_1
    //   876: invokestatic 3085	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   879: aload_0
    //   880: invokevirtual 2896	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   883: iconst_0
    //   884: ireturn
    //   885: aload_0
    //   886: aload_0
    //   887: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   890: getfield 358	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   893: iconst_0
    //   894: invokevirtual 2338	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/data/Card;Z)V
    //   897: goto -274 -> 623
    //   900: astore_1
    //   901: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   904: ifeq +33 -> 937
    //   907: ldc_w 350
    //   910: iconst_2
    //   911: new 793	java/lang/StringBuilder
    //   914: dup
    //   915: invokespecial 794	java/lang/StringBuilder:<init>	()V
    //   918: ldc_w 3087
    //   921: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: aload_1
    //   925: invokevirtual 1258	java/lang/Exception:toString	()Ljava/lang/String;
    //   928: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: invokevirtual 805	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   934: invokestatic 355	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   937: aload_1
    //   938: invokevirtual 765	java/lang/Exception:printStackTrace	()V
    //   941: aload_0
    //   942: invokevirtual 2896	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   945: iconst_0
    //   946: ireturn
    //   947: aload_0
    //   948: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   951: ldc_w 1679
    //   954: ldc 22
    //   956: ldc -87
    //   958: ldc_w 3089
    //   961: ldc_w 3089
    //   964: iconst_0
    //   965: iconst_0
    //   966: ldc -87
    //   968: ldc -87
    //   970: ldc -87
    //   972: ldc -87
    //   974: invokestatic 846	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   977: goto -170 -> 807
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	980	0	this	FriendProfileCardActivity
    //   0	980	1	paramBundle	Bundle
    //   3	735	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   258	292	862	java/lang/Exception
    //   504	548	900	java/lang/Exception
    //   548	573	900	java/lang/Exception
    //   573	623	900	java/lang/Exception
    //   623	627	900	java/lang/Exception
    //   885	897	900	java/lang/Exception
  }
  
  protected void doOnDestroy()
  {
    int i1 = 0;
    ((CardHandler)this.app.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    }
    super.doOnDestroy();
    if (this.app != null) {
      this.app.a(getClass());
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_Boolean = false;
        }
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
        if (this.app != null)
        {
          Object localObject1 = (StatusManager)this.app.getManager(14);
          if (localObject1 != null) {
            ((StatusManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
          }
          if ((this.app != null) && (this.app.a() != null)) {
            this.app.a().deleteObserver(this);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.d();
          }
          if (this.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            int i2 = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount();
            if (i1 < i2)
            {
              localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i1);
              if ((localObject1 instanceof ProfileHeaderView)) {
                ((ProfileHeaderView)localObject1).d();
              }
              i1 += 1;
              continue;
            }
          }
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        localException.printStackTrace();
        continue;
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
        {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
          this.jdField_a_of_type_AndroidAppDialog = null;
        }
        K();
        if (MusicPendantManager.a() != null) {
          MusicPendantManager.a().e();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession != null) {
          this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.d();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().c();
        }
        return;
      }
      Object localObject2 = null;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      if (!NetworkUtil.e(BaseApplication.getContext())) {
        a(2131368805, 1);
      }
    }
    do
    {
      do
      {
        return;
        CardHandler localCardHandler = (CardHandler)this.app.a(2);
        if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
        {
          localCardHandler.b((String)localArrayList.get(0));
          w();
          this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, this.o);
          return;
        }
        localCardHandler.a(localArrayList);
        w();
        return;
        if (paramIntent.getBooleanExtra("key_back_from_add_friend", false))
        {
          doOnActivityResult(1000, -1, paramIntent);
          return;
        }
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      } while (paramIntent == null);
      if (!ProfileCardUtil.a(this.app, paramIntent)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    return;
    a(2131370143, 1);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c();
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "FriendProfileCardActivity time trace:" + this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.toString());
        }
        StatisticCollector.a(this.app.a()).a(this.app.a(), "profileCardTimeStat", true, 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a(), "", false);
      }
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    QQAppInterface localQQAppInterface = this.app;
    if (localQQAppInterface != null) {
      StatisticHitRateCollector.a().b(localQQAppInterface.a(), "actQZLoadHitRateProfile");
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "friend profile card activity doOnResume");
    }
    super.doOnResume();
    D();
    if (this.ar > 0L)
    {
      long l1 = System.currentTimeMillis() - this.ar;
      if ((QLog.isColorLevel()) && (l1 > 500L)) {
        QLog.i("Q.PerfTrace", 2, "FriendProfileCardActivity Ui render used:" + l1);
      }
      this.ar = 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int == 6) {
      o();
    }
    addObserver(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = null;
      A();
    }
    if (this.app != null)
    {
      WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(12);
      if (localWebProcessManager != null) {
        localWebProcessManager.a(-1, new lly(this));
      }
      QZoneHelper.a(this.app, this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
    {
      View localView = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
      if ((localView instanceof VoteView)) {
        ((VoteView)localView).a(true);
      }
    }
    if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
    Object localObject = ProfilePerformanceReport.a;
    if ((localObject != null) && (((ProfilePerformanceReport)localObject).a(true))) {
      ((ProfilePerformanceReport)localObject).a(this.app.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.d();
      }
      localObject = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
      if ((localObject instanceof VoteView)) {
        ((VoteView)localObject).a(false);
      }
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
      L();
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("doOnWindowFocusChanged", false);
      ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.a;
      if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.b())) {
        localProfilePerformanceReport.b(2);
      }
      if ((!this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean))
      {
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(100);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(100, 100L);
        this.jdField_f_of_type_Boolean = false;
        this.jdField_g_of_type_Boolean = true;
      }
    }
  }
  
  public void e()
  {
    if ((this.app == null) || (this.jdField_e_of_type_AndroidViewView == null) || (!(this.jdField_e_of_type_AndroidViewView instanceof RelativeLayout)) || (!ApolloManager.a(this, Boolean.valueOf(false)))) {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
      }
    }
    do
    {
      return;
      if ((this.app == null) || ((ApolloManager)this.app.getManager(152) == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
        break;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(this.app.a())) && ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.a())))) {
        break label544;
      }
    } while (ApolloManager.a(this.app, "mycard", null) <= 0);
    label162:
    int i1 = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      Object localObject3 = (ApolloManager)this.app.getManager(152);
      localObject2 = ((ApolloManager)localObject3).b((String)localObject1);
      int i2;
      if (localObject2 != null)
      {
        i2 = ((ApolloBaseInfo)localObject2).apolloStatus;
        localObject2 = ((ApolloBaseInfo)localObject2).getApolloDress();
        i1 = i2;
        if (localObject2 != null)
        {
          i1 = ((ApolloDress)localObject2).jdField_a_of_type_Int;
          localObject2 = ((ApolloDress)localObject2).a();
        }
      }
      for (;;)
      {
        this.jdField_n_of_type_Boolean = ((FriendsManager)this.app.getManager(50)).b((String)localObject1);
        if ((ApolloManager.a(this.app) != 1) || (this.jdField_n_of_type_Boolean) || ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(this.app.f())))) {}
        long l1;
        for (boolean bool = true;; bool = false)
        {
          this.jdField_m_of_type_Boolean = bool;
          l1 = Math.max(DeviceInfoUtil.g(), DeviceInfoUtil.f());
          if ((i1 > 0) && (localObject2 != null) && (localObject2.length > 0) && (i2 == 1) && ((i1 <= 0) || (localObject2 == null) || (ApolloActionHelper.a((String)localObject1, i1, (int[])localObject2, this.app)))) {
            break label565;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "roleId->" + i1 + " dressIds->" + localObject2 + " apolloStatus->" + i2);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
          localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131302217);
          i1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getHeight() * 2 / 3;
          if ((localObject1 == null) || (((View)localObject1).getHeight() <= i1) || (i1 == 0)) {
            break;
          }
          ((View)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, ((View)localObject1).getHeight() - i1));
          return;
          label544:
          if (ApolloManager.a(this.app, "friendcard", null) > 0) {
            break label162;
          }
          return;
        }
        label565:
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null)
        {
          this.jdField_m_of_type_Int = i1;
          this.jdField_b_of_type_ArrayOfInt = ((int[])localObject2);
          RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_e_of_type_AndroidViewView;
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(this, null);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getHolder().setFormat(-2);
          localObject2 = new lml(this, i1, (int[])localObject2);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a((OnApolloViewListener)localObject2);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a((IRenderCallback)localObject2);
          }
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(DeviceInfoUtil.f() / 2L), (int)((float)l1 * 0.3F));
          localLayoutParams.addRule(12, -1);
          localLayoutParams.addRule(11, -1);
          localLayoutParams.bottomMargin = AIOUtils.a(56.0F, getResources());
          localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, localLayoutParams);
          if (localObject1 != null)
          {
            if (((String)localObject1).equals(this.app.f())) {
              VipUtils.a(this.app, "cmshow", "Apollo", "file_show", 0, 0, new String[0]);
            }
          }
          else {
            label767:
            if (this.jdField_m_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = new ApolloBoxEnterView(this, null);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setGifData(100, getResources().getDrawable(2130837759), "http://cmshow.gtimg.cn/client/zip/box_gif.zip", QQFrameZipDecoder.a("http://cmshow.gtimg.cn/client/zip/box_gif.zip"), false);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
              localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(60.0F, getResources()), AIOUtils.a(60.0F, getResources()));
              ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
              ((RelativeLayout.LayoutParams)localObject3).addRule(11, -1);
              ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.a(45.0F, getResources());
              ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.a(75.0F, getResources());
              localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, (ViewGroup.LayoutParams)localObject3);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a(this.app, "friendcard", (String)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener((View.OnClickListener)localObject2);
            }
          }
        }
        do
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getVisibility() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(0);
          }
          i1 = (int)((float)l1 * 0.2F);
          localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131302217);
          if ((localObject1 == null) || (((View)localObject1).getHeight() >= i1)) {
            break;
          }
          ((View)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, i1 + ((View)localObject1).getHeight()));
          return;
          localObject3 = ((ApolloManager)localObject3).b(this.app.f());
          if (localObject3 != null) {
            this.jdField_n_of_type_Int = ((ApolloBaseInfo)localObject3).apolloStatus;
          }
          VipUtils.a(this.app, "cmshow", "Apollo", "guest_file_show", this.jdField_n_of_type_Int, 0, new String[] { "" + ApolloManager.a(this.app), "0", "0", localObject1 });
          break label767;
          if (this.jdField_c_of_type_Float <= 0.0F) {
            break;
          }
        } while ((i1 == this.jdField_m_of_type_Int) && (ApolloUtil.a((int[])localObject2, this.jdField_b_of_type_ArrayOfInt)));
        if (i1 != this.jdField_m_of_type_Int)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().g();
          float f1 = (float)l1 * 0.2F / 368.0F;
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(1, i1, f1, this.jdField_c_of_type_Float, 0.0F);
        }
        this.jdField_m_of_type_Int = i1;
        this.jdField_b_of_type_ArrayOfInt = ((int[])localObject2);
        if (i1 == 0) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(1, ApolloResDownloader.a(i1), null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(1000L);
          break;
          if ((i1 > 0) && (localObject2 != null)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(1, (int[])localObject2, null);
          }
        }
        localObject2 = null;
        int i3 = 0;
        i2 = i1;
        i1 = i3;
      }
    }
  }
  
  public void f()
  {
    int i3 = 0;
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    int i4 = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i2;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getHeight();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
        break label276;
      }
      i2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getHeight();
      label57:
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        i3 = ((Resources)localObject).getDimensionPixelOffset(2131493104);
      }
      int i5 = ((Resources)localObject).getDimensionPixelSize(2131493103) + i3;
      i3 = Math.min(Math.max(i4 - i2 - i1, i5), i4 / 3);
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131302217);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updatePlaceHolder mScreenHeight=" + i4 + ",moreInfoViewHeight=" + i1 + ",headerViewHeight=" + i2 + ",minHeight=" + i5 + ",placeHolderViewHeight=" + i3);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {
        break label290;
      }
    }
    label276:
    label290:
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getHeight() * 2 / 3 + i3;; i1 = i3)
    {
      if (localObject != null)
      {
        ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, i1));
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
          ProfileCardTemplate.a((View)localObject, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
        }
      }
      else
      {
        return;
        i1 = 0;
        break;
        i2 = 0;
        break label57;
      }
      ((View)localObject).setBackgroundResource(2130841049);
      return;
    }
  }
  
  public void g()
  {
    long l1 = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_f_of_type_Long, l1))
    {
      this.jdField_f_of_type_Long = l1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label277;
      }
      localObject = (TicketManager)this.app.getManager(2);
      if (localObject != null) {
        break label71;
      }
      localObject = null;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label88;
      }
      a(2131370024, 1);
    }
    label71:
    label88:
    do
    {
      return;
      localObject = ((TicketManager)localObject).getStweb(this.app.a());
      break;
      localObject = String.format("http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localObject, "19", "" });
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQLevelWeb() url = " + (String)localObject);
      }
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", 23, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.FrdProfileCard", 2, "getClientKey() time = " + System.currentTimeMillis());
    return;
    label277:
    Object localObject = String.format("http://m.vip.qq.com/redirect/?go=androidqlevel&qq=%s&aid=mvip.pingtai.mobileqq.androidziliaoka.fromkerentaiQQlevelicon", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString });
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.a());
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("hide_more_button", true);
    startActivity(localIntent);
    ReportController.b(this.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", 24, 0, "", "", "", "");
  }
  
  public void h()
  {
    long l1 = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_f_of_type_Long, l1))
    {
      this.jdField_f_of_type_Long = l1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoXmanWeb() url = " + "http://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297");
        }
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.app.a());
        ((Intent)localObject).putExtra("url", "http://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297");
        ((Intent)localObject).putExtra("hide_more_button", true);
        startActivity((Intent)localObject);
        ReportController.b(this.app, "CliOper", "", "", "0X8004880", "0X8004880", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    Object localObject = String.format("http://ti.qq.com/xman/view.html?_wv=1027&uin=%s&_bid=297", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString });
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.a());
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("hide_more_button", true);
    startActivity(localIntent);
    ReportController.b(this.app, "CliOper", "", "", "0X800489C", "0X800489C", 0, 0, "", "", "", "");
  }
  
  public void i()
  {
    long l1 = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_f_of_type_Long, l1))
    {
      this.jdField_f_of_type_Long = l1;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lightalkNick != null))
      {
        String str = Base64Util.encodeToString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lightalkNick.getBytes(), 0);
        str = String.format("http://ti.qq.com/lightalk/info.html?_wv=1027&uin=%s&nick=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lightalkId, str });
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoLightalkWeb() url = " + str);
        }
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("uin", this.app.a());
        localIntent.putExtra("url", str);
        localIntent.putExtra("hide_more_button", true);
        startActivity(localIntent);
        ReportController.b(this.app, "CliOper", "", "", "0X800510A", "0X800510A", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    Intent localIntent = new Intent(this, QRDisplayActivity.class);
    String str = this.app.a();
    localIntent.putExtra("title", getString(2131364458));
    localIntent.putExtra("nick", ContactUtils.i(this.app, str));
    localIntent.putExtra("uin", str);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("reportFlag", 1);
    startActivity(localIntent);
  }
  
  public void k()
  {
    a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_AndroidAppDialog);
  }
  
  public void l()
  {
    b(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
  }
  
  public void m()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
    String str2 = this.app.b();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = this.app.b();
    }
    localUserInfo.jdField_b_of_type_JavaLangString = str1;
    QZoneHelper.a(this, localUserInfo, Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)), 1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int, -1, this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession);
  }
  
  public void n()
  {
    ThreadManager.a(new lkw(this), 8, null, true);
  }
  
  public void o()
  {
    QQMessageFacade localQQMessageFacade = this.app.a();
    int i1;
    if (localQQMessageFacade != null)
    {
      i1 = localQQMessageFacade.e();
      if (i1 <= 0) {
        break label117;
      }
      if (i1 > 99) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367566) + "(" + "99+" + ")");
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367566) + "(" + i1 + ")");
    return;
    label117:
    getIntent().putExtra("leftViewText", getString(2131367566));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367566));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10000) && (MusicPendantManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {
      MusicPendantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this);
    }
  }
  
  protected boolean onBackEvent()
  {
    M();
    B();
    return super.onBackEvent();
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "friend profile card activity onRestart");
    }
    super.onRestart();
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil = new TimeTraceUtil();
      this.jdField_l_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localMessage.what = 1;
          localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
        }
      }
    }
  }
  
  public void p()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))) {
      ThreadManager.a(new llc(this, ((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap()), 5, null, true);
    }
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheQuality(524288);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(8);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getDrawingCache();
      this.jdField_a_of_type_AndroidViewView.findViewById(2131302217).setVisibility(8);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.destroyDrawingCache();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131302217).setVisibility(0);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  public void s()
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.e(0);
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void u()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131370908);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      runOnUiThread(new lkz(this));
    }
  }
  
  public void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void w()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367900);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void x()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void y()
  {
    String str1;
    if (!isFinishing())
    {
      z();
      if (this.jdField_g_of_type_Int != 1) {
        break label64;
      }
      str1 = getString(2131370878);
    }
    for (String str2 = "成为会员之后，即可使用该名片";; str2 = "成为超级会员之后，即可使用该名片")
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, str1, str2, 2131370891, 2131370892, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_d_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      label64:
      str1 = getString(2131370876);
    }
  }
  
  public void z()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\FriendProfileCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */