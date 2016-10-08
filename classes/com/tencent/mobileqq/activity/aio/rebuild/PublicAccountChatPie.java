package com.tencent.mobileqq.activity.aio.rebuild;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.bitapp.BitAppAbilityUtils;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgFactory;
import com.tencent.bitapp.BitAppMsgItemBuilder;
import com.tencent.bitapp.BitAppMsgNode;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.assistant.PubAccountTipsManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vashealth.StepCounterServlert;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.PublicMenuBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.XPanelContainer;
import cooperation.comic.PluginPreloader;
import cooperation.comic.QQComicPreloadManager;
import cooperation.huangye.C2BUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import nzp;
import nzs;
import nzt;
import nzu;
import nzv;
import nzx;
import nzy;
import nzz;
import oaa;
import oab;
import oae;
import oaf;
import oag;
import oah;
import oai;
import oaj;
import oak;
import oam;
import oao;
import oap;
import oaq;
import oar;
import oas;
import oat;
import oau;
import oav;
import oax;
import oaz;
import oba;
import obb;
import obc;
import obd;
import obe;
import obf;
import obg;
import obh;
import obi;
import obj;
import obm;
import obn;
import obp;
import obq;
import obr;
import obs;
import obu;
import obv;
import obw;
import oby;
import obz;
import ocb;
import occ;
import ocd;
import org.json.JSONObject;

public class PublicAccountChatPie
  extends BaseChatPie
{
  public static final String aA = "jump_from";
  private static final String aG = "2632129500";
  private static final String aH = "3105932915";
  private static final String aJ = "actPublicAccountWebviewPreload";
  public static final String al = "shouldreport";
  public static final String am = "qd_wpa_key";
  public static final String an = "qd_kfuin";
  public static final String ao = "assign_type";
  public static final String ap = "assign_key";
  public static final String aq = "assign_ext";
  public static final String ar = "strurt_msgid";
  public static final String as = "struct_uin";
  public static final String at = "from_web";
  public static final String au = "struct_url";
  public static final String av = "StructingMsgItemBuildertime";
  public static final String aw = "source_puin";
  public static final String az = "has_unread_msg";
  public static final int dP = 1001;
  public static final int dQ = 10;
  public static final int dV = 1;
  public static final int dW = 2;
  public static final int dX = 3;
  public static final int dY = 4;
  private static final int eA = 1;
  private static final int eB = 2;
  public static final int ed = 0;
  public static final int ee = 1;
  public static final int ef = 2;
  private static final int eg = 1;
  private static final int eh = 2;
  private static final int ei = 3;
  private static final int ej = 4;
  private static final int ek = 6;
  private static final int el = 7;
  private static final int em = 9;
  private static final int en = 0;
  private static final int eo = 1;
  private static final int ep = 2;
  private static final int eq = 3;
  private static final int er = 4;
  private static final int es = 5;
  private static final int ez = 0;
  public boolean J;
  public boolean K;
  public boolean L;
  public boolean M;
  public boolean N;
  public boolean O;
  public boolean P;
  public boolean Q;
  public boolean R;
  public boolean S;
  public boolean T;
  public boolean U;
  boolean V;
  public boolean W;
  public boolean X;
  public boolean Y;
  public boolean Z;
  public Handler a;
  protected SpannableString a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public PublicAccountManager a;
  PubAccountTipsManager jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager;
  EcShopObserver jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver;
  public CustomMenuBar a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  protected MessageObserver a;
  public PublicAccountHandler a;
  public PublicAccountObserver a;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  public MessageForPic a;
  public MessageForStructing a;
  public PublicAccountInfo a;
  public AbsStructMsg a;
  public TroopEntranceBar a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  PublicMenuBar jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  public QidianBusinessObserver a;
  public ActionSheet a;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  private ocd jdField_a_of_type_Ocd;
  public int[] a;
  public String aB;
  public String aC;
  public String aD;
  public String aE;
  public String aF;
  private String aI;
  boolean aa;
  boolean ab;
  boolean ac;
  public boolean ad;
  public boolean ae;
  public boolean af;
  public boolean ag;
  public boolean ah;
  public boolean ai;
  public boolean aj;
  private boolean ak;
  private boolean al;
  private boolean am;
  private boolean an;
  private boolean ao;
  private boolean ap;
  private boolean aq;
  private boolean ar;
  public String ax;
  public String ay;
  protected SpannableString b;
  public View.OnClickListener b;
  private PublicMenuBar jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  protected PatchedButton b;
  List jdField_b_of_type_JavaUtilList;
  private NewIntent jdField_b_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  protected PatchedButton c;
  List jdField_c_of_type_JavaUtilList;
  private NewIntent jdField_c_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_c_of_type_MqqObserverBusinessObserver;
  public QQProgressDialog d;
  public int dR;
  public int dS;
  public int dT;
  public int dU;
  public int dZ;
  private int eC;
  private int eD;
  private int eE;
  public int ea;
  public int eb;
  public int ec;
  private int et;
  private int eu;
  private int ev;
  private int ew;
  private int ex;
  private int ey;
  private TextView f;
  public Dialog g;
  private TextView g;
  long jdField_h_of_type_Long;
  private Dialog jdField_h_of_type_AndroidAppDialog;
  public View h;
  long i;
  public View i;
  long jdField_j_of_type_Long;
  View jdField_j_of_type_AndroidViewView;
  protected ImageView j;
  long jdField_k_of_type_Long;
  View jdField_k_of_type_AndroidViewView;
  protected ImageView k;
  private long jdField_l_of_type_Long;
  View jdField_l_of_type_AndroidViewView;
  public ImageView l;
  private long jdField_m_of_type_Long;
  private View jdField_m_of_type_AndroidViewView;
  private ImageView jdField_m_of_type_AndroidWidgetImageView;
  private long jdField_n_of_type_Long;
  private View jdField_n_of_type_AndroidViewView;
  private ImageView jdField_n_of_type_AndroidWidgetImageView;
  private View o;
  private View p;
  
  public PublicAccountChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_h_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = null;
    this.J = false;
    this.K = false;
    this.aI = "";
    this.ax = "";
    this.ay = "";
    this.dS = -1;
    this.dT = 0;
    this.dU = 3;
    this.M = false;
    this.N = false;
    this.O = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_h_of_type_Long = -1L;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_i_of_type_Long = -1L;
    this.jdField_j_of_type_Long = -1L;
    this.jdField_l_of_type_Long = Long.MAX_VALUE;
    this.jdField_k_of_type_Long = 0L;
    this.T = false;
    this.U = false;
    this.ey = -1;
    this.jdField_a_of_type_AndroidOsHandler = new nzp(this);
    this.jdField_b_of_type_MqqObserverBusinessObserver = new oaf(this);
    this.V = false;
    this.W = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new occ(this);
    this.X = false;
    this.Y = false;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new obm(this);
    this.jdField_a_of_type_MqqObserverBusinessObserver = new obn(this);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver = new obp(this);
    this.aa = false;
    this.ab = false;
    this.ac = false;
    this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new obq(this);
    this.af = false;
    this.ag = false;
    this.ah = false;
    this.ai = false;
    this.aj = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new obu(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new obw(this);
  }
  
  private void a(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1)) {
      x(80);
    }
    while (!CustomMenuBar.a()) {
      return;
    }
    x(16);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.addUpdateListener(new nzs(this, paramView, paramInt1, paramInt2));
    localValueAnimator.addListener(paramAnimatorListener);
    localValueAnimator.setDuration(500L).start();
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (localSharedPreferences.getBoolean("firstIntoAIO", true))
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.parseColor("#B3000000"));
      localLinearLayout.setVisibility(0);
      localLinearLayout.setClickable(true);
      localLinearLayout.setOnClickListener(new obj(this, paramRelativeLayout, localLinearLayout));
      Object localObject = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((ImageView)localObject).setImageResource(2130838791);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      Resources localResources = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      localLayoutParams.width = AIOUtils.a(73.0F, localResources);
      localLayoutParams.height = AIOUtils.a(73.0F, localResources);
      localLayoutParams.topMargin = AIOUtils.a(100.0F, localResources);
      localLayoutParams.gravity = 17;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((TextView)localObject).setText("下滑拉取更多消息");
      ((TextView)localObject).setTextSize(2, 18.0F);
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = AIOUtils.a(28.0F, localResources);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      paramRelativeLayout.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
      localSharedPreferences.edit().putBoolean("firstIntoAIO", false).commit();
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    ThreadManager.b().postDelayed(new oak(this, paramAccountDetail), 10L);
  }
  
  private void a(MessageForStructing paramMessageForStructing)
  {
    int i1 = 0;
    if (paramMessageForStructing.structingMsg == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramMessageForStructing.structingMsg;
      this.aI = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
      this.dR = paramMessageForStructing.structingMsg.mPromotionType;
      this.ax = paramMessageForStructing.structingMsg.mPromotionMsg;
      this.ay = paramMessageForStructing.structingMsg.mPromotionMenus;
      this.dS = paramMessageForStructing.structingMsg.mPromotionMenuDestructiveIndex;
      try
      {
        if (this.ay == null) {
          continue;
        }
        this.ar = false;
        paramMessageForStructing = this.ay.split(",");
        if (paramMessageForStructing == null) {
          continue;
        }
        int i2 = paramMessageForStructing.length;
        this.jdField_a_of_type_ArrayOfInt = new int[i2];
        while (i1 < i2)
        {
          paramMessageForStructing[i1] = paramMessageForStructing[i1].trim();
          this.jdField_a_of_type_ArrayOfInt[i1] = Integer.parseInt(paramMessageForStructing[i1]);
          i1 += 1;
        }
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        this.ar = true;
      }
    }
  }
  
  private void a(String paramString, int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("need_report", false))
    {
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
      long l1 = paramIntent.getLongExtra("incoming_msguid", 0L);
      long l2 = paramIntent.getLongExtra("incoming_shmsgseq", 0L);
      if (l1 > 0L) {
        ThreadManager.a(new oau(this, paramString, paramInt, l1, l2), 5, null, true);
      }
    }
    if (paramIntent.hasExtra("need_report")) {
      paramIntent.removeExtra("need_report");
    }
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).b(paramString);; localObject = null)
    {
      if (localObject == null)
      {
        paramQQAppInterface = paramQQAppInterface.a();
        if (paramQQAppInterface != null)
        {
          paramString = paramQQAppInterface.a(paramString, 1008);
          if ((paramString != null) && (paramString.msgtype == 63525))
          {
            paramQQAppInterface = new MessageForStructing();
            MessageForStructing.copyMessageRecordBaseField(paramQQAppInterface, paramString);
            paramQQAppInterface.parse();
            if ((paramQQAppInterface.structingMsg != null) && ((paramQQAppInterface.structingMsg.mPromotionType == 1) || (paramQQAppInterface.structingMsg.mPromotionType == 2))) {
              return true;
            }
          }
        }
      }
      return false;
    }
  }
  
  private void aT()
  {
    ThreadManager.a(new obz(this), null, true);
  }
  
  private void aU()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null) {
      x();
    }
  }
  
  private void aV()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("op", "0");
      localBundle.putString("puin", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      localBundle.putString("Referer", "http://buluo.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
      new HttpWebCgiAsyncTask2("http://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new oah(this), 1000, null).a(localHashMap);
      aE();
      return;
    }
  }
  
  private void aW()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("public_aio_setting", 0);
    String str = "firstOpen_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (localSharedPreferences.getBoolean(str, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.b(new oar(this, localSharedPreferences, str));
  }
  
  private void aX()
  {
    if (this.jdField_n_of_type_Long == 0L) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null) {
      localHashMap.put("uin", localObject);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
      localHashMap.put("puin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    localHashMap.put("menu_click", "" + this.dZ);
    localHashMap.put("menu_to_webview", "" + this.eb);
    localHashMap.put("article_click", "" + this.ea);
    localHashMap.put("article_to_webview", "" + this.ec);
    localHashMap.put("net_type", "" + NetworkCenter.a().a());
    localHashMap.put("unread_count", "" + this.ex);
    long l1 = System.currentTimeMillis() - this.jdField_n_of_type_Long;
    if ((this.ec != 0) || (this.eb != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("public account webview preload data: ");
        ((StringBuilder)localObject).append("duration: ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", entered: ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", exinfo: ");
        ((StringBuilder)localObject).append(localHashMap.toString());
        QLog.d("Q.aio.BaseChatPie", 2, ((StringBuilder)localObject).toString());
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPublicAccountWebviewPreload", bool, l1, 0L, localHashMap, "");
      this.jdField_n_of_type_Long = 0L;
      this.ex = 0;
      this.eb = 0;
      this.dZ = 0;
      this.ea = 0;
      this.ec = 0;
      return;
    }
  }
  
  private void aY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountDataManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      return;
    }
    Object localObject = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), PublicAccountServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("6.5.5,3,2880");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      ((NewIntent)localObject).putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new oav(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void aZ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localPublicAccountDataManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountDataManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      ba();
    }
  }
  
  private void b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.b(paramAccountDetail);
    localEntityManager.a();
  }
  
  private void ba()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    SosoInterface.a(new obe(this, 1, true, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void bb()
  {
    a((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getParent());
  }
  
  private void c(AccountDetail paramAccountDetail)
  {
    if (this.jdField_h_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject1 = (TextView)this.jdField_h_of_type_AndroidViewView.findViewById(2131296999);
    Object localObject2 = (TextView)this.jdField_h_of_type_AndroidViewView.findViewById(2131297000);
    ImageView localImageView = (ImageView)this.jdField_h_of_type_AndroidViewView.findViewById(2131296790);
    if (this.ap) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_h_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0);
        ((TextView)localObject1).setText(localTroopInfo.troopname);
        ((TextView)localObject2).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131364508), new Object[] { paramAccountDetail.name }));
        localImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localTroopInfo.troopuin));
        localObject1 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = ((TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          break label318;
        }
        localObject2 = "";
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "exp_temp", 0, 0, (String)localObject1, "" + (String)localObject2, "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new obb(this, localImageView);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      localObject1 = (ImageView)this.jdField_h_of_type_AndroidViewView.findViewById(2131296793);
      if (paramAccountDetail.certifiedGrade != 0) {
        break label375;
      }
      ((ImageView)localObject1).setVisibility(8);
      return;
      label318:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break;
      ((TextView)localObject1).setText(paramAccountDetail.name);
      if (this.ax != null) {
        ((TextView)localObject2).setText(this.ax);
      }
      localImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().jdField_a_of_type_JavaLangString, (byte)3));
    }
    label375:
    ((ImageView)localObject1).setVisibility(0);
  }
  
  private void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "unfollow");
    }
    w(2131364485);
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "unfollow");
    mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
    localUnFollowRequest.uin.set((int)Long.parseLong(paramString));
    localNewIntent.putExtra("data", localUnFollowRequest.toByteArray());
    this.jdField_c_of_type_MqqObserverBusinessObserver = new oai(this, paramString);
    localNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    this.eD += 1;
    PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "unfollow exit");
    }
  }
  
  private void w(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new oaj(this, paramInt), 500L);
  }
  
  private void x(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams1;
    do
    {
      return;
      localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams1);
      }
      if (localLayoutParams2.gravity != paramInt)
      {
        localLayoutParams2.gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams2);
      }
      localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    } while (localLayoutParams1.gravity == paramInt);
    localLayoutParams1.gravity = paramInt;
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setLayoutParams(localLayoutParams1);
  }
  
  protected void A()
  {
    super.A();
    long l1 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      int i1 = this.jdField_b_of_type_JavaUtilList.size() - 1;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C35", "0X8005C35", 0, 1, 0, (String)this.jdField_b_of_type_JavaUtilList.get(i1), String.valueOf(this.jdField_h_of_type_Long), String.valueOf(l1), (String)this.jdField_c_of_type_JavaUtilList.get(i1));
    }
    if (this.P)
    {
      if (this.Q) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 1, 0, "new", String.valueOf(l1 - this.jdField_j_of_type_Long), "", "");
      }
    }
    else {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 1, 0, "old", String.valueOf(l1 - this.jdField_j_of_type_Long), "", "");
  }
  
  protected void B()
  {
    super.B();
    if (this.aa) {
      BitAppAbilityUtils.a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("bitapp_performance", 2, "PublicaccountChatPie doOnPause, don't contain lolaMsg");
  }
  
  protected void C()
  {
    super.C();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(37, 500L);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.c();
    }
    if ((PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("输城市名查天气");
    }
    if ((!this.al) && (this.am))
    {
      this.am = false;
      ThreadManager.a(new obr(this), null, true);
    }
    this.jdField_j_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    EcShopHandler localEcShopHandler;
    if ((ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localEcShopHandler = (EcShopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(68);
      if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        if (EcShopAssistantManager.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
          break label344;
        }
      }
    }
    label344:
    for (long l1 = ((Long)EcShopAssistantManager.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).longValue();; l1 = 0L)
    {
      if ((TextUtils.isEmpty((String)EcShopAssistantManager.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || (System.currentTimeMillis() - l1 > EcShopAssistantManager.c))
      {
        EcShopAssistantManager.b.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
        localEcShopHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841672);
      return;
    }
  }
  
  protected void D()
  {
    if ((this.ap) && (this.aq)) {
      return;
    }
    super.D();
    if (this.aa) {
      BitAppAbilityUtils.b();
    }
    for (;;)
    {
      this.aq = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.i("bitapp_performance", 2, "PublicaccountChatPie doOnResume, don't contain lolaMsg");
      }
    }
  }
  
  protected void E()
  {
    super.E();
    this.al = false;
    this.am = false;
  }
  
  protected void W()
  {
    if ((this.ao) && (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) > 0)) {
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.W();
    Object localObject;
    if (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(2, new oas(this));
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      if (localObject != null)
      {
        int i2 = ((List)localObject).size();
        int i1 = 0;
        if (i1 >= i2) {
          break label393;
        }
        ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(i1);
        if (localChatMessage == null) {}
        while ((localChatMessage.msgtype != 60528) && (localChatMessage.msgtype != 62530))
        {
          i1 += 1;
          break;
        }
      }
    }
    label393:
    for (boolean bool = false;; bool = true)
    {
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(0, 0, 0, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "first time fetch newest weather :" + bool);
      }
      for (;;)
      {
        localObject = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
        if ((localObject != null) && (((EcShopAssistantManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          ThreadManager.a(new obf(this), 5, null, true);
        }
        localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        if (localObject != null) {
          ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, NetConnInfoCenter.getServerTimeMillis());
        }
        return;
        if (("3026775809".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor")).getDefaultSensor(19) != null))
        {
          localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), StepCounterServlert.class);
          ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_refresh_steps");
          ((NewIntent)localObject).setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        }
      }
    }
  }
  
  protected void Y()
  {
    super.Y();
    if ((ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_b_of_type_AndroidViewView$OnClickListener;
  }
  
  public void a(int paramInt)
  {
    int i1 = 0xFFFF0000 & paramInt;
    super.a(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (((i1 == 196608) || (i1 == 131072)) && (localList.size() > 0))
    {
      i1 = 0;
      int i3 = localList.size() - 1;
      if (i3 >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(i3);
        int i2 = i1;
        if (i1 == 0)
        {
          if ((this.jdField_l_of_type_Long == Long.MAX_VALUE) || (localChatMessage.uniseq == this.jdField_l_of_type_Long)) {
            i1 = 1;
          }
          i2 = i1;
          if (this.jdField_l_of_type_Long == Long.MAX_VALUE) {}
        }
        for (;;)
        {
          i3 -= 1;
          break;
          if (i2 != 0) {
            break label181;
          }
          i1 = i2;
        }
        label181:
        if (((localChatMessage instanceof MessageForStructing)) && (StructLongMessageDownloadProcessor.b(localChatMessage)))
        {
          String str = localChatMessage.getExtInfoFromExtStr("longMsg_State");
          if ((str == null) || (!"3".equals(str))) {
            break label235;
          }
        }
        for (;;)
        {
          this.jdField_l_of_type_Long = localChatMessage.uniseq;
          i1 = i2;
          break;
          label235:
          localChatMessage.saveExtInfoToExtStr("longMsg_State", "1");
          StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localChatMessage);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "REFRESH_FLAG_RELOAD  to load long message");
      }
    }
    if (paramInt != 131072) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(20);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(37);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.am = true;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.P) {
      t(2131364505);
    }
  }
  
  public void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.af) {
      aR();
    }
  }
  
  public void a(View paramView)
  {
    paramView.getLayoutParams().height = 0;
    paramView.requestLayout();
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  protected void a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((TroopInfo)localIterator.next()).troopuin.equals(paramMessage.frienduin));
      }
      for (int i1 = 1; (paramMessage.istroop != 1) || (i1 == 0); i1 = 0)
      {
        super.a(paramMessage);
        return;
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    super.a(paramChatMessage);
    Object localObject = paramChatMessage.frienduin;
    int i1 = paramChatMessage.istroop;
    if (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, i1))
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject = paramChatMessage.a((String)localObject, i1);
      if (localObject != null) {
        paramChatMessage.b((RecentUser)localObject);
      }
    }
  }
  
  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountDataManager localPublicAccountDataManager;
    if (paramPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + paramPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + paramPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + paramPublicAccountInfo.mIsAgreeSyncLbs);
      }
      localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localPublicAccountDataManager == null) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): pam is null");
        }
      }
    }
    for (;;)
    {
      return;
      if ((paramPublicAccountInfo.isSyncLbs) && (!paramPublicAccountInfo.mIsSyncLbsSelected) && (!paramPublicAccountInfo.mIsAgreeSyncLbs) && (!this.an))
      {
        String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131362711);
        String str2 = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131362712), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        this.jdField_g_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, str1, str2, 2131362713, 2131362714, new oax(this, paramPublicAccountInfo, localPublicAccountDataManager), new oaz(this, paramPublicAccountInfo, localPublicAccountDataManager));
        this.jdField_g_of_type_AndroidAppDialog.setOnDismissListener(new oba(this));
        this.jdField_g_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
          this.jdField_g_of_type_AndroidAppDialog.show();
        }
        this.an = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): END");
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  void a(AbsListView paramAbsListView)
  {
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    int i1 = paramAbsListView.s();
    ChatMessage localChatMessage;
    if (i1 <= paramAbsListView.t())
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1);
      if (localChatMessage != null) {}
    }
    for (;;)
    {
      i1 += 1;
      break;
      String str3;
      long l1;
      try
      {
        String str1;
        if ((!localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("")) && (!localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("true")))
        {
          localArrayList5.add(localChatMessage);
          str3 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
          str1 = str3;
          if (TextUtils.isEmpty(str3)) {
            str1 = "0";
          }
          l1 = Long.parseLong(str1);
          if (localChatMessage.getExtInfoFromExtStr("pa_should_report").equals("true"))
          {
            localArrayList4.add(Long.valueOf(l1));
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "Report message at index: " + String.valueOf(i1) + ". MessageId is " + l1);
            }
          }
          localChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
          str3 = localChatMessage.getExtInfoFromExtStr("msg_template_id");
          str1 = str3;
          if (str3 == null) {
            str1 = "";
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80057C4", "0X80057C4", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(l1), str1, "");
        }
        if (!localChatMessage.getExtInfoFromExtStr("ad_msgHasRead").equals("false")) {
          continue;
        }
        localChatMessage.saveExtInfoToExtStr("ad_msgHasRead", "true");
        String str4 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
        String str5 = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        str3 = "0";
        String str6 = localChatMessage.getExtInfoFromExtStr("gdt_view_id");
        try
        {
          JSONObject localJSONObject = new JSONObject(str5);
          str1 = str3;
          if (localJSONObject.has("ad_id")) {
            str1 = localJSONObject.getString("ad_id");
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            String str2 = str3;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.aio.BaseChatPie", 2, " parse ad_id error");
              str2 = str3;
            }
          }
        }
        localArrayList1.add(str4);
        this.jdField_c_of_type_JavaUtilList.add(str1);
        localArrayList2.add(str5);
        localArrayList3.add(str6);
        if (localArrayList5.contains(localChatMessage)) {
          continue;
        }
        localArrayList5.add(localChatMessage);
      }
      catch (Exception localException2) {}
      b(localArrayList5);
      if (!localArrayList4.isEmpty()) {}
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, 0L, l1, l2, 2, localArrayList4);
        paramAbsListView = localArrayList5.iterator();
        while (paramAbsListView.hasNext()) {
          if ("1".equals(((ChatMessage)paramAbsListView.next()).getExtInfoFromExtStr("is_AdArrive_Msg")))
          {
            if (this.jdField_h_of_type_Long == -1L) {
              this.jdField_h_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
            }
            this.jdField_b_of_type_JavaUtilList = localArrayList1;
            PAReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList2, localArrayList1, localArrayList3);
          }
        }
        return;
      }
      catch (Exception paramAbsListView)
      {
        return;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if (paramInt == 0) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(37);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.jdField_h_of_type_AndroidViewView == null) || (this.jdField_n_of_type_AndroidViewView == null) || (this.dU == 5)) {}
    label237:
    label239:
    int i1;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (this.ev > paramInt3)
          {
            this.dU = 4;
            this.ev = paramInt3;
            switch (this.dU)
            {
            }
          }
          for (;;)
          {
            if ((!this.ak) && (!this.N)) {
              break label237;
            }
            if ((!this.X) || (this.N)) {
              break label239;
            }
            this.X = false;
            return;
            if (this.ev >= paramInt3) {
              break;
            }
            this.dU = 3;
            break;
            if ((paramInt3 > paramInt2) && (!this.ak))
            {
              this.eu = this.jdField_n_of_type_AndroidViewView.getLayoutParams().height;
              a(this.jdField_n_of_type_AndroidViewView);
              this.ak = true;
            }
            this.dU = 2;
            this.X = true;
            continue;
            if ((paramInt3 == paramInt2) && (this.ak))
            {
              if (this.eu != 0) {
                a(this.jdField_n_of_type_AndroidViewView, this.eu);
              }
              this.ak = false;
              this.N = true;
            }
            this.dU = 2;
            this.X = true;
          }
        }
        if (this.jdField_h_of_type_AndroidViewView.getHeight() != 0) {
          this.eu = this.jdField_h_of_type_AndroidViewView.getHeight();
        }
        i1 = this.et - i();
        this.et = i();
        if (this.eC * i1 < 0)
        {
          this.eC = i1;
          return;
        }
        this.eC = i1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "Move = " + String.valueOf(i1));
        }
        switch (this.dT)
        {
        default: 
          return;
        }
      } while (((i1 <= 5) || (!this.W)) && ((paramInt1 != this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m()) || (i1 <= 0) || (!this.W) || (this.M)));
      this.M = true;
      paramAbsListView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.eu);
      paramAbsListView.setFillAfter(true);
      paramAbsListView.setDuration(250L);
      paramAbsListView.setAnimationListener(new nzx(this));
      this.jdField_h_of_type_AndroidViewView.startAnimation(paramAbsListView);
      return;
    } while (((i1 >= -5) || (!this.W)) && (((!this.N) && ((paramInt1 + paramInt2 != paramInt3) || (i1 >= 0) || (!this.W))) || (this.M)));
    this.M = true;
    paramAbsListView = new TranslateAnimation(0.0F, 0.0F, -this.eu, 0.0F);
    paramAbsListView.setFillAfter(true);
    paramAbsListView.setDuration(250L);
    paramAbsListView.setAnimationListener(new nzy(this));
    this.jdField_h_of_type_AndroidViewView.startAnimation(paramAbsListView);
  }
  
  protected void a(List paramList, CharSequence paramCharSequence)
  {
    this.ae = true;
    super.a(paramList, paramCharSequence);
    paramCharSequence = null;
    HashMap localHashMap = new HashMap();
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i1);
      if (!MessageForBitApp.class.isInstance(localChatMessage)) {
        break label336;
      }
      localChatMessage.parse();
      if (((MessageForBitApp)localChatMessage).bitAppMsg == null) {
        break label336;
      }
      localHashMap.put(Integer.valueOf(((MessageForBitApp)localChatMessage).bitAppMsg.getModuleId()), Integer.valueOf(i1));
      paramCharSequence = localChatMessage;
    }
    label324:
    label327:
    label336:
    for (;;)
    {
      i1 += 1;
      break;
      if (paramCharSequence != null)
      {
        if (!this.aa) {
          this.aa = true;
        }
        paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.a(paramCharSequence, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
        if ((paramCharSequence instanceof BitAppMsgItemBuilder)) {
          ((BitAppMsgItemBuilder)paramCharSequence).a(localHashMap);
        }
      }
      long l1;
      if (this.u)
      {
        if (paramList.size() <= 0) {
          break label327;
        }
        paramList = (ChatMessage)paramList.get(paramList.size() - 1);
        i1 = paramList.msgtype;
        l1 = paramList.msgseq;
        if (!(paramList instanceof MessageForStructing)) {
          break label324;
        }
        paramList = (MessageForStructing)paramList;
        if (paramList.structingMsg == null) {
          break label324;
        }
        l1 = paramList.structingMsg.msgId;
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D4", "0X80064D4", 0, 0, "", "" + i1, "" + l1, "");
        return;
        continue;
        l1 = 0L;
        i1 = -1;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      PublicAccountManager.a().a(this.jdField_b_of_type_MqqAppNewIntent);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    this.jdField_b_of_type_MqqAppNewIntent = PublicAccountManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt, paramBoolean, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new obc(this));
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!z()) {
        this.ey = 2;
      }
      for (;;)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        super.a(paramBoolean1, paramChatMessage, paramBoolean2);
        return;
        if (!y()) {
          this.ey = 1;
        } else {
          this.ey = 0;
        }
      }
    }
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    switch (this.ey)
    {
    }
    for (;;)
    {
      this.ey = -1;
      return;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        continue;
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
          continue;
          if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (!this.P) {
      return super.a(paramInt, paramView, paramListView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0))
    {
      this.R = true;
      b(System.currentTimeMillis());
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.a).a(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 21, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
    }
    return true;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ocd = new ocd(this, null);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ocd, (IntentFilter)localObject);
    this.F = false;
    this.C = false;
    aU();
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager = PublicAccountManager.a();
    aO();
    super.a(paramBoolean);
    if (this.af) {
      aP();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0) {
      this.Z = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar = new TroopEntranceBar();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.addObserver(this);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    this.jdField_m_of_type_Long = System.currentTimeMillis();
    this.ew = ((Intent)localObject).getIntExtra("red_hot_count", 0);
    String str = ((Intent)localObject).getStringExtra("from");
    this.V = ((Intent)localObject).getBooleanExtra("shouldreport", false);
    this.jdField_n_of_type_Long = System.currentTimeMillis();
    this.ea = 0;
    this.ec = 0;
    this.dZ = 0;
    this.eb = 0;
    this.ex = this.ew;
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localPublicAccountInfo == null) || (PublicAccountUtil.a(localPublicAccountInfo.accountFlag) != -2)) {
        break label555;
      }
      this.ao = true;
      aG();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.f();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_h_of_type_Int > 0) {
        break label427;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
    }
    for (;;)
    {
      PublicAccountHandler.b = null;
      this.T = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("has_unread_msg", false);
      if ((str == null) || (!str.equals("starShortcut"))) {
        break;
      }
      PublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Intent)localObject).getStringExtra("starhomeurl"), ((Intent)localObject).getStringExtra("uin"), str);
      return true;
      label427:
      int i2 = ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (i2 == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
      }
      else
      {
        int i1;
        if ((i2 & 0xF) == 0)
        {
          i1 = 1;
          label493:
          if (i2 >> 4 != 1) {
            break label532;
          }
          i2 = 1;
          label504:
          if ((i1 == 0) || (i2 == 0)) {
            break label538;
          }
          this.ap = true;
        }
        for (;;)
        {
          aT();
          break;
          i1 = 0;
          break label493;
          label532:
          i2 = 0;
          break label504;
          label538:
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.e();
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b();
        }
        label555:
        aT();
      }
    }
    if ((NetworkUtil.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()) == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals("2632129500"))) {
      HtmlOffline.b("108", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new oby(this));
    }
    if ("3105932915".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (QQComicPreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141);
      if (localObject != null) {
        PluginPreloader.a(((QQComicPreloadManager)localObject).a(5));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    this.P = PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "doOnCreate, isMediaAndOtherSubscript = " + this.P);
    }
    this.jdField_i_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "doOnCreate, preload web process");
        }
        ((WebProcessManager)localObject).e();
      }
    }
    if (this.P)
    {
      bb();
      aL();
      aN();
    }
    if (this.P) {
      if (this.Q) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "new", "", "");
      }
    }
    for (;;)
    {
      if (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.L = true;
      }
      return true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "old", "", "");
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
  }
  
  public void aC()
  {
    ChatMessage localChatMessage;
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() >= 1)
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().get(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
      str1 = "0";
      if (localChatMessage != null)
      {
        localObject = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("ad_id")) {
        str1 = ((JSONObject)localObject).getString("ad_id");
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        String str2 = "0";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "old", String.valueOf(l1 - this.jdField_i_of_type_Long), "", "");
    }
    Object localObject = localChatMessage.getExtInfoFromExtStr("pa_msgId");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "" + localChatMessage.frienduin, "0X8005C38", "0X8005C38", 0, 1, 0, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
    if (this.P)
    {
      l1 = NetConnInfoCenter.getServerTime() * 1000L;
      if (this.Q) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "new", String.valueOf(l1 - this.jdField_i_of_type_Long), "", "");
      }
    }
    else
    {
      return;
    }
  }
  
  public void aD()
  {
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void aE()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new nzt(this));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(this.jdField_n_of_type_AndroidViewView);
      this.ak = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    a(this.jdField_n_of_type_AndroidViewView, this.jdField_n_of_type_AndroidViewView.getHeight(), 0, new nzu(this));
    this.jdField_h_of_type_AndroidViewView.setTranslationY(0.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_h_of_type_AndroidViewView.getHeight());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new nzv(this));
    this.jdField_h_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  public void aF()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {}
    do
    {
      do
      {
        return;
        this.jdField_h_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2130903084, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      } while (this.jdField_h_of_type_AndroidViewView == null);
      this.jdField_h_of_type_AndroidViewView.setClickable(true);
      this.jdField_h_of_type_AndroidViewView.findViewById(2131296790).setOnClickListener(new oaa(this));
      if (this.dR != 2) {
        break;
      }
      this.jdField_h_of_type_AndroidViewView.findViewById(2131296998).setVisibility(8);
      this.jdField_h_of_type_AndroidViewView.findViewById(2131297001).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_h_of_type_AndroidViewView);
      this.jdField_n_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2130903083, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    } while (this.jdField_n_of_type_AndroidViewView == null);
    label189:
    Object localObject;
    int i1;
    label337:
    MenuItem localMenuItem1;
    if (this.dR == 2)
    {
      this.jdField_n_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131493455));
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(this.jdField_n_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter((ListAdapter)localObject);
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (this.K))
        {
          c((AccountDetail)localObject);
          this.K = false;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = ((PublicMenuBar)this.jdField_h_of_type_AndroidViewView.findViewById(2131297002));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setOnMenuItemClickListener(new oab(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a();
      if (this.af) {
        break label526;
      }
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      if (!this.ap) {
        break label518;
      }
      i1 = 2131370330;
      localObject = new MenuItem("DO_NOT_FOLLOW", ((FragmentActivity)localObject).getString(i1), a().getResources().getDrawable(2130838894), 0);
      localMenuItem1 = new MenuItem("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131370331), a().getResources().getDrawable(2130838779), 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((MenuItem)localObject, 2130903736);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem1, 2130903736);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setSwitchButtonVisibility(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(0);
      return;
      if (!this.af) {
        break;
      }
      this.jdField_h_of_type_AndroidViewView.findViewById(2131296998).setVisibility(8);
      this.jdField_h_of_type_AndroidViewView.findViewById(2131297001).setVisibility(8);
      break;
      if (!this.af) {
        break label189;
      }
      this.jdField_n_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131493455));
      break label189;
      label518:
      i1 = 2131370332;
      break label337;
      label526:
      localObject = new MenuItem("DO_CANCEL", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131368793), a().getResources().getDrawable(2130838894), 0);
      localMenuItem1 = new MenuItem("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131370331), a().getResources().getDrawable(2130838779), 1);
      MenuItem localMenuItem2 = new MenuItem("DO_NOT_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131370330), a().getResources().getDrawable(2130838894), 0);
      this.jdField_k_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((MenuItem)localObject, 2130903736);
      this.jdField_j_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem2, 2130903736);
      this.jdField_l_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem1, 2130903736);
    }
  }
  
  public void aG()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_f_of_type_AndroidViewView != null) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void aH()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a("确定后你将不再收到通知消息");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a("确定", 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new oae(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new oag(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.Y = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void aI()
  {
    if (this.al) {
      break label7;
    }
    label7:
    label737:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
        this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131296341));
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar);
        }
        if (this.jdField_h_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_h_of_type_AndroidViewView);
        }
        if (this.jdField_n_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(this.jdField_n_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297007));
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130903085, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297007));
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) {
            break label737;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.b(a()));
          if (CustomMenuBar.a())
          {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131427685));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(AIOUtils.a(48.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
          {
            Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
            Object localObject2 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getLayoutParams();
            if ((localObject3 != null) && (localObject2 != null) && ((localObject3 instanceof RelativeLayout.LayoutParams)) && ((localObject2 instanceof RelativeLayout.LayoutParams)))
            {
              localObject3 = (RelativeLayout.LayoutParams)localObject3;
              int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject3).getRules();
              if ((arrayOfInt.length > 2) && (arrayOfInt[2] == 2131297409))
              {
                ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131297007);
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131297409);
                this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          if (this.O)
          {
            localObject1 = new TranslateAnimation(0.0F, 0.0F, AIOUtils.a(34.0F, (Resources)localObject1), 0.0F);
            ((TranslateAnimation)localObject1).setDuration(250L);
            ((TranslateAnimation)localObject1).setFillAfter(true);
            ((TranslateAnimation)localObject1).setAnimationListener(new oam(this));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.startAnimation((Animation)localObject1);
          }
          localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297003);
          ((View)localObject1).setOnClickListener(new oao(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject1);
          this.jdField_m_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297004);
          aW();
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("menuEventSharePre", 0);
          if (!((SharedPreferences)localObject1).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            localObject1 = ((SharedPreferences)localObject1).edit();
            ((SharedPreferences.Editor)localObject1).putInt(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
            ((SharedPreferences.Editor)localObject1).commit();
          }
          this.jdField_m_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new oap(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new oaq(this));
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          c((List)localObject1);
          this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_b_of_type_MqqObserverBusinessObserver, false);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            g(true);
          }
          this.al = true;
          if (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager == null) {
            this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager = new PubAccountTipsManager(this.jdField_a_of_type_AndroidContentContext);
          }
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
          if ((!((Intent)localObject1).hasExtra("pub_account_type")) || (!"type_ecshop_account".equals(((Intent)localObject1).getStringExtra("pub_account_type")))) {
            break;
          }
          localObject1 = ((Intent)localObject1).getStringExtra("ecshop_distance_tip");
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager.a((String)localObject1, this);
          this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (View)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconPv", "Pv_shopnearbyicon", 0, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
      }
    }
  }
  
  public void aJ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      if (C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void aK()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "follow");
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new obd(this);
    this.jdField_c_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "follow exit");
    }
  }
  
  public void aL()
  {
    ThreadManager.a(new obi(this), 8, null, true);
  }
  
  protected void aM()
  {
    if (this.jdField_j_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.jdField_k_of_type_Int != 1) {
        break;
      }
      this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130840537);
      this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_j_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!VersionUtils.e());
    this.jdField_j_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.jdField_k_of_type_Int == 2)
    {
      this.jdField_j_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.e()) {
        this.jdField_j_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130843023);
        }
        for (;;)
        {
          this.jdField_j_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131367646));
          return;
          this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130843232);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130843022);
      }
      for (;;)
      {
        this.jdField_j_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131367645));
        return;
        this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130843233);
      }
    }
    this.jdField_j_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130843023);
      }
      for (;;)
      {
        this.jdField_j_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131367646));
        label246:
        if (!VersionUtils.e()) {
          break;
        }
        this.jdField_j_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130843232);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130843022);
    }
    for (;;)
    {
      this.jdField_j_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131367645));
      break label246;
      break;
      this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130843233);
    }
  }
  
  public void aN()
  {
    this.o = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903488, null);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.o.findViewById(2131298777));
    if (!this.Q) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.o.findViewById(2131298776));
    this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.o.findViewById(2131297449));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.o.findViewById(2131297005));
  }
  
  void aO()
  {
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164));
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.aB = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_wpa_key");
    if (!TextUtils.isEmpty(this.aB))
    {
      this.aC = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_kfuin");
      this.aD = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_type");
      this.aE = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_key");
      this.aF = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_ext");
      this.af = true;
      this.ag = false;
      this.ah = false;
      this.ai = false;
      this.aj = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(str, this.aC);
      return;
    }
    this.aC = this.jdField_a_of_type_ComTencentQidianQidianManager.c(str);
    if (!TextUtils.isEmpty(this.aC))
    {
      this.af = true;
      this.ag = true;
      this.aD = null;
      this.aE = null;
      this.aF = null;
      this.ah = true;
      this.ai = false;
      this.aj = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      return;
    }
    this.af = false;
    this.ag = false;
    this.aD = null;
    this.aE = null;
    this.aF = null;
    this.ah = false;
    this.ai = false;
    this.aj = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  }
  
  public void aP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "checkQDAccountValid ...");
    }
    ThreadManager.a(new obs(this), 8, null, false);
  }
  
  public void aQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "updateHeader ...");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar == null) || (!this.ag)) {
      return;
    }
    if (this.ai)
    {
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_k_of_type_AndroidViewView.setVisibility(8);
    this.jdField_j_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void aR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "updateWpaUiForQidian: mQidianAccountValid = " + this.ag + ", mQidianKefu = " + this.ah + ", mQidianShield: " + this.ai);
    }
    if (this.ag) {
      if (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
        break label277;
      }
    }
    label277:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (this.jdField_m_of_type_AndroidWidgetImageView == null) {
          this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131296341));
        }
        this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(0);
        aI();
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      LinearLayout localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (this.ah) {}
      for (i1 = 0;; i1 = 8)
      {
        localLinearLayout.setVisibility(i1);
        if (this.jdField_m_of_type_AndroidWidgetImageView == null) {
          this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131296341));
        }
        this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_h_of_type_AndroidViewView == null) {
          aF();
        }
        aQ();
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void aS()
  {
    if ((!this.ag) || (!this.aj)) {}
    do
    {
      return;
      if (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {}
      for (int i1 = 1; (this.ai) && (i1 == 0); i1 = 0)
      {
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131361812), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, true);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  }
  
  protected void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
    if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    }
    if (this.af) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
  }
  
  protected void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    }
    if (this.af) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    super.afterTextChanged(paramEditable);
    a(paramEditable);
    PatchedButton localPatchedButton;
    if (this.jdField_k_of_type_Int == 0)
    {
      if (!this.jdField_d_of_type_Boolean) {
        break label75;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131367885);
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() <= 0) {
        break label70;
      }
      bool1 = bool2;
      localPatchedButton.setEnabled(bool1);
    }
    label70:
    label75:
    do
    {
      do
      {
        return;
        bool1 = false;
        break;
      } while ((this.jdField_l_of_type_AndroidWidgetImageView != null) && (this.jdField_l_of_type_AndroidWidgetImageView.getVisibility() == 0));
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() > 0) {
        bool1 = true;
      }
      localPatchedButton.setEnabled(bool1);
    } while (paramEditable.length() <= 0);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131367885);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
  }
  
  public void am()
  {
    super.am();
    if (this.jdField_g_of_type_AndroidViewView != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidViewView.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (!z())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getId());
            return;
          }
          if (!y())
          {
            localLayoutParams.addRule(2, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    aM();
    if (paramInt2 == 8) {
      if (this.jdField_k_of_type_AndroidWidgetImageView != null)
      {
        if (!CustomMenuBar.a()) {
          break label285;
        }
        this.jdField_k_of_type_AndroidWidgetImageView.setImageResource(2130843034);
      }
    }
    for (;;)
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        SpannableString localSpannableString;
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837574);
          localSpannableString = new SpannableString("文字输入");
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837689);
          localSpannableString = new SpannableString("语音输入");
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if ((QLog.isColorLevel()) && (this.jdField_l_of_type_AndroidWidgetImageView != null)) {
          QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_l_of_type_AndroidWidgetImageView.getVisibility());
        }
        if (paramInt2 != 2) {
          break;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(false);
        }
      }
      return;
      label285:
      this.jdField_k_of_type_AndroidWidgetImageView.setImageResource(2130843018);
      continue;
      if (this.jdField_k_of_type_AndroidWidgetImageView != null) {
        if (CustomMenuBar.a()) {
          this.jdField_k_of_type_AndroidWidgetImageView.setImageResource(2130843033);
        } else {
          this.jdField_k_of_type_AndroidWidgetImageView.setImageResource(2130843017);
        }
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject).setSelected(bool);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
        break;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131367885);
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.P) {
      t(2131364506);
    }
  }
  
  public void b(long paramLong)
  {
    try
    {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage) + 1;
    if (i1 <= this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1)
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1);
      if ((localChatMessage != null) && (localChatMessage.msgtype == 64488))
      {
        super.b(paramChatMessage);
        h(localChatMessage);
        return;
      }
    }
    super.b(paramChatMessage);
  }
  
  void b(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "saveReadedToDB");
    }
    ThreadManager.a(new nzz(this, paramList), null, false);
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramIntent);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new oat(this));
    aZ();
  }
  
  public void c(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.b(a()));
      if ((paramList == null) || (paramList.isEmpty()))
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (this.jdField_e_of_type_AndroidViewView != null) {
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        }
        if (this.jdField_f_of_type_AndroidViewView != null) {
          this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        }
        if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
          this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      else
      {
        if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
          this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        int i3 = paramList.size();
        int i1 = 0;
        while ((i1 < i3) && (i1 <= 2))
        {
          Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i1);
          Object localObject1;
          String str;
          label200:
          label221:
          MenuItem localMenuItem;
          label262:
          label283:
          mobileqq_mp.ButtonInfo localButtonInfo;
          if (((mobileqq_mp.ButtonInfo)localObject2).key.has())
          {
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
              break label400;
            }
            str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
              break label406;
            }
            i2 = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
            localMenuItem = new MenuItem((String)localObject1, str, null, i2);
            localMenuItem.a((mobileqq_mp.ButtonInfo)localObject2);
            if (!((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
              break label412;
            }
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
              break label435;
            }
            localObject2 = ((List)localObject1).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label435;
            }
            localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
            if (!localButtonInfo.key.has()) {
              break label417;
            }
            localObject1 = localButtonInfo.key.get();
            label325:
            if (!localButtonInfo.name.has()) {
              break label423;
            }
            str = localButtonInfo.name.get();
            label345:
            if (!localButtonInfo.id.has()) {
              break label429;
            }
          }
          label400:
          label406:
          label412:
          label417:
          label423:
          label429:
          for (int i2 = localButtonInfo.id.get();; i2 = 0)
          {
            localObject1 = new MenuItem((String)localObject1, str, null, i2);
            ((MenuItem)localObject1).a(localButtonInfo);
            localMenuItem.a((MenuItem)localObject1);
            break label283;
            localObject1 = "";
            break;
            str = "";
            break label200;
            i2 = 0;
            break label221;
            localObject1 = null;
            break label262;
            localObject1 = "";
            break label325;
            str = "";
            break label345;
          }
          label435:
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem, a());
          i1 += 1;
        }
      }
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    if (this.P)
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c() == null)
        {
          if (this.o == null) {
            aN();
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.o);
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
      return;
    }
    super.d(paramBoolean);
  }
  
  protected boolean d()
  {
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return (localPublicAccountInfo == null) || ((localPublicAccountInfo.accountFlag & 0x10000000) == 0);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_b_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297413));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setContentDescription("发送");
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297411));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.topMargin = 1;
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.topMargin = 1;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
    if (CustomMenuBar.a()) {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-1);
    }
    for (;;)
    {
      this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131298676));
      this.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131298675));
      this.jdField_k_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131297864));
      this.jdField_j_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130842146);
        this.jdField_k_of_type_AndroidWidgetImageView.setImageResource(2130837560);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130843057);
        if (!CustomMenuBar.a()) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131427685));
      }
      return;
      x(80);
    }
    int i1 = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, i1, 0, i1);
  }
  
  protected void g(Intent paramIntent)
  {
    aU();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)
    {
      localObject = paramIntent.getStringExtra("uin");
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localObject))
      {
        aX();
        this.jdField_n_of_type_Long = System.currentTimeMillis();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0) {
      this.Z = true;
    }
    aO();
    if (this.af)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_f_of_type_AndroidViewView != null) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
    super.g(paramIntent);
    if (this.af)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
      aP();
    }
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (!this.af))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a()))) {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(a());
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      c((List)localObject);
      this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_b_of_type_MqqObserverBusinessObserver, false);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        g(true);
      }
    }
    Object localObject = paramIntent.getStringExtra("from");
    if ((localObject != null) && (((String)localObject).equals("starShortcut"))) {
      PublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("starhomeurl"), paramIntent.getStringExtra("uin"), (String)localObject);
    }
    this.aq = false;
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      }
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(4);
      }
      if (this.jdField_f_of_type_AndroidViewView != null) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(4);
      }
      am();
    }
  }
  
  /* Error */
  public void h(ChatMessage paramChatMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 1401	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   7: aload_1
    //   8: invokevirtual 2553	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)I
    //   11: istore 8
    //   13: invokestatic 920	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +31 -> 47
    //   19: ldc_w 2662
    //   22: iconst_2
    //   23: new 794	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 795	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 2664
    //   33: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 8
    //   38: invokevirtual 884	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: invokevirtual 802	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 940	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: iload 8
    //   49: ifge +4 -> 53
    //   52: return
    //   53: aload_0
    //   54: getfield 1724	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   57: invokevirtual 2665	com/tencent/mobileqq/bubble/ChatXListView:s	()I
    //   60: istore 9
    //   62: iload 8
    //   64: iload 9
    //   66: isub
    //   67: istore 10
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 1724	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   74: iload 10
    //   76: invokevirtual 2668	com/tencent/mobileqq/bubble/ChatXListView:getChildAt	(I)Landroid/view/View;
    //   79: putfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   82: aload_0
    //   83: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   86: ifnonnull +68 -> 154
    //   89: invokestatic 920	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +53 -> 145
    //   95: ldc_w 2662
    //   98: iconst_2
    //   99: new 794	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 795	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 2672
    //   109: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 10
    //   114: invokevirtual 884	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 2674
    //   120: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload 9
    //   125: invokevirtual 884	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc_w 2676
    //   131: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: iload 8
    //   136: invokevirtual 884	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 802	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 940	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_0
    //   146: getfield 1401	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   149: aload_1
    //   150: invokevirtual 2677	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   153: return
    //   154: aload_0
    //   155: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   158: invokevirtual 2680	android/view/View:isDrawingCacheEnabled	()Z
    //   161: istore 11
    //   163: aload_0
    //   164: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   167: invokevirtual 2683	android/view/View:willNotCacheDrawing	()Z
    //   170: istore 12
    //   172: aload_0
    //   173: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   176: iconst_1
    //   177: invokevirtual 2686	android/view/View:setDrawingCacheEnabled	(Z)V
    //   180: aload_0
    //   181: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   184: iconst_0
    //   185: invokevirtual 2689	android/view/View:setWillNotCacheDrawing	(Z)V
    //   188: aload_0
    //   189: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   192: invokevirtual 2693	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   195: astore_2
    //   196: aload 4
    //   198: astore_3
    //   199: aload_2
    //   200: ifnull +8 -> 208
    //   203: aload_2
    //   204: invokestatic 2699	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   207: astore_3
    //   208: invokestatic 920	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +30 -> 241
    //   214: ldc_w 2662
    //   217: iconst_2
    //   218: new 794	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 795	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 2701
    //   228: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_3
    //   232: invokevirtual 2704	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 802	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 940	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload_3
    //   242: ifnull +257 -> 499
    //   245: aload_0
    //   246: getfield 2706	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_c_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   249: ifnull -197 -> 52
    //   252: new 502	android/widget/ImageView
    //   255: dup
    //   256: aload_0
    //   257: getfield 1128	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   260: invokespecial 503	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   263: astore 4
    //   265: aload 4
    //   267: aload_3
    //   268: invokevirtual 2710	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   271: new 2712	android/widget/FrameLayout
    //   274: dup
    //   275: aload_0
    //   276: getfield 1128	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   279: invokespecial 2713	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   282: astore 5
    //   284: new 2715	android/widget/FrameLayout$LayoutParams
    //   287: dup
    //   288: aload_0
    //   289: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   292: invokevirtual 2718	android/view/View:getWidth	()I
    //   295: aload_0
    //   296: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   299: invokevirtual 1713	android/view/View:getHeight	()I
    //   302: invokespecial 2719	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   305: astore_2
    //   306: aload_2
    //   307: bipush 51
    //   309: putfield 2720	android/widget/FrameLayout$LayoutParams:gravity	I
    //   312: aload_2
    //   313: aload_0
    //   314: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   317: invokevirtual 2723	android/view/View:getLeft	()I
    //   320: putfield 2726	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   323: aload_2
    //   324: aload_0
    //   325: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   328: invokevirtual 2729	android/view/View:getTop	()I
    //   331: putfield 2730	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   334: aload_2
    //   335: iconst_0
    //   336: putfield 2733	android/widget/FrameLayout$LayoutParams:rightMargin	I
    //   339: aload_2
    //   340: iconst_0
    //   341: putfield 2734	android/widget/FrameLayout$LayoutParams:bottomMargin	I
    //   344: aload_0
    //   345: getfield 2706	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_c_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   348: aload 5
    //   350: aload_2
    //   351: invokevirtual 2735	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   354: aload 5
    //   356: aload 4
    //   358: new 2715	android/widget/FrameLayout$LayoutParams
    //   361: dup
    //   362: iconst_m1
    //   363: iconst_m1
    //   364: invokespecial 2719	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   367: invokevirtual 2736	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   370: aload_0
    //   371: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   374: iconst_4
    //   375: invokevirtual 2091	android/view/View:setVisibility	(I)V
    //   378: new 2738	android/view/animation/LinearInterpolator
    //   381: dup
    //   382: invokespecial 2739	android/view/animation/LinearInterpolator:<init>	()V
    //   385: astore 6
    //   387: new 2741	android/view/animation/AnimationSet
    //   390: dup
    //   391: iconst_1
    //   392: invokespecial 2742	android/view/animation/AnimationSet:<init>	(Z)V
    //   395: astore 7
    //   397: new 2744	android/view/animation/AlphaAnimation
    //   400: dup
    //   401: fconst_1
    //   402: fconst_0
    //   403: invokespecial 2747	android/view/animation/AlphaAnimation:<init>	(FF)V
    //   406: astore_2
    //   407: aload_2
    //   408: ldc2_w 2748
    //   411: invokevirtual 2750	android/view/animation/AlphaAnimation:setDuration	(J)V
    //   414: aload_2
    //   415: aload 6
    //   417: invokevirtual 2754	android/view/animation/AlphaAnimation:setInterpolator	(Landroid/view/animation/Interpolator;)V
    //   420: aload 7
    //   422: aload_2
    //   423: invokevirtual 2757	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   426: aload_1
    //   427: invokevirtual 2760	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   430: ifeq +124 -> 554
    //   433: new 1730	android/view/animation/TranslateAnimation
    //   436: dup
    //   437: fconst_0
    //   438: aload_0
    //   439: getfield 2762	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   442: invokevirtual 2765	android/view/View:getRight	()I
    //   445: i2f
    //   446: fconst_0
    //   447: fconst_0
    //   448: invokespecial 1733	android/view/animation/TranslateAnimation:<init>	(FFFF)V
    //   451: astore_2
    //   452: aload_2
    //   453: ldc2_w 2748
    //   456: invokevirtual 1741	android/view/animation/TranslateAnimation:setDuration	(J)V
    //   459: aload_2
    //   460: aload 6
    //   462: invokevirtual 2766	android/view/animation/TranslateAnimation:setInterpolator	(Landroid/view/animation/Interpolator;)V
    //   465: aload 7
    //   467: aload_2
    //   468: invokevirtual 2757	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   471: aload 4
    //   473: aload 7
    //   475: invokevirtual 2767	android/widget/ImageView:startAnimation	(Landroid/view/animation/Animation;)V
    //   478: aload_0
    //   479: getfield 387	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   482: new 2769	obk
    //   485: dup
    //   486: aload_0
    //   487: aload 5
    //   489: invokespecial 2772	obk:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie;Landroid/widget/FrameLayout;)V
    //   492: ldc2_w 2748
    //   495: invokevirtual 613	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   498: pop
    //   499: aload_0
    //   500: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   503: iload 11
    //   505: invokevirtual 2686	android/view/View:setDrawingCacheEnabled	(Z)V
    //   508: aload_0
    //   509: getfield 2670	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_i_of_type_AndroidViewView	Landroid/view/View;
    //   512: iload 12
    //   514: invokevirtual 2689	android/view/View:setWillNotCacheDrawing	(Z)V
    //   517: aload_3
    //   518: ifnull +59 -> 577
    //   521: aload_0
    //   522: getfield 387	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   525: new 2774	obl
    //   528: dup
    //   529: aload_0
    //   530: aload_1
    //   531: invokespecial 2777	obl:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   534: ldc2_w 2778
    //   537: invokevirtual 613	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   540: pop
    //   541: return
    //   542: astore_2
    //   543: aconst_null
    //   544: astore_2
    //   545: goto -349 -> 196
    //   548: astore_2
    //   549: aconst_null
    //   550: astore_2
    //   551: goto -355 -> 196
    //   554: new 1730	android/view/animation/TranslateAnimation
    //   557: dup
    //   558: fconst_0
    //   559: aload_0
    //   560: getfield 2762	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   563: invokevirtual 2765	android/view/View:getRight	()I
    //   566: ineg
    //   567: i2f
    //   568: fconst_0
    //   569: fconst_0
    //   570: invokespecial 1733	android/view/animation/TranslateAnimation:<init>	(FFFF)V
    //   573: astore_2
    //   574: goto -122 -> 452
    //   577: aload_0
    //   578: getfield 1401	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   581: aload_1
    //   582: invokevirtual 2677	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   585: return
    //   586: astore_2
    //   587: aload 4
    //   589: astore_3
    //   590: goto -382 -> 208
    //   593: astore_2
    //   594: aload 4
    //   596: astore_3
    //   597: goto -389 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	this	PublicAccountChatPie
    //   0	600	1	paramChatMessage	ChatMessage
    //   195	273	2	localObject1	Object
    //   542	1	2	localException1	Exception
    //   544	1	2	localObject2	Object
    //   548	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   550	24	2	localTranslateAnimation	TranslateAnimation
    //   586	1	2	localException2	Exception
    //   593	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   198	399	3	localObject3	Object
    //   1	594	4	localImageView	ImageView
    //   282	206	5	localFrameLayout	android.widget.FrameLayout
    //   385	76	6	localLinearInterpolator	android.view.animation.LinearInterpolator
    //   395	79	7	localAnimationSet	android.view.animation.AnimationSet
    //   11	124	8	i1	int
    //   60	64	9	i2	int
    //   67	46	10	i3	int
    //   161	343	11	bool1	boolean
    //   170	343	12	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   188	196	542	java/lang/Exception
    //   188	196	548	java/lang/OutOfMemoryError
    //   203	208	586	java/lang/Exception
    //   203	208	593	java/lang/OutOfMemoryError
  }
  
  protected void h(boolean paramBoolean)
  {
    int i2 = 8;
    if (this.jdField_l_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_l_of_type_AndroidWidgetImageView.clearAnimation();
    Object localObject = this.jdField_l_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      i1 = 0;
      label31:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      i1 = i2;
      if (!paramBoolean) {
        i1 = 0;
      }
      ((XEditTextEx)localObject).setVisibility(i1);
      if (this.jdField_e_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
        if (!paramBoolean) {
          break label157;
        }
      }
    }
    label157:
    for (int i1 = 4;; i1 = 0)
    {
      ((PatchedButton)localObject).setVisibility(i1);
      if (!paramBoolean) {
        break;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837574);
        SpannableString localSpannableString = new SpannableString("文字输入");
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
      return;
      i1 = 8;
      break label31;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (this.jdField_m_of_type_AndroidViewView != null)
      {
        this.jdField_m_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
        continue;
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        if ((this.jdField_m_of_type_AndroidViewView != null) && (this.jdField_m_of_type_AndroidViewView.getVisibility() == 0))
        {
          this.jdField_m_of_type_AndroidViewView.setVisibility(8);
          continue;
          a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
          }
          Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
          if (localObject != null)
          {
            localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(((AccountDetail)localObject).name);
              if (this.K)
              {
                c((AccountDetail)localObject);
                this.K = false;
              }
              if (this.jdField_g_of_type_AndroidAppDialog == null) {}
              aJ();
            }
          }
          if (this.J)
          {
            this.J = false;
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            aD();
            continue;
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
          }
        }
      }
    }
  }
  
  public int i()
  {
    int i1 = 0;
    View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((this.p != null) && (localView != this.p))
    {
      this.et = 0;
      this.p = localView;
      return 0;
    }
    if (localView != null) {
      i1 = -localView.getTop();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "ScrollY: " + String.valueOf(i1) + "  OldScrollY: " + String.valueOf(this.et));
    }
    this.p = localView;
    return i1;
  }
  
  public void i()
  {
    if (!this.P) {
      super.i();
    }
  }
  
  protected void j(int paramInt)
  {
    super.j(paramInt);
    ImageSpan localImageSpan;
    SpannableString localSpannableString;
    if (paramInt != this.jdField_k_of_type_Int)
    {
      if (paramInt != 1) {
        break label84;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837574);
        localSpannableString = new SpannableString("文字输入");
        localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
    label84:
    label323:
    for (;;)
    {
      aM();
      return;
      if (paramInt == 2)
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837689);
          localSpannableString = new SpannableString("语音输入");
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        if (VersionUtils.e())
        {
          if (this.jdField_k_of_type_AndroidWidgetImageView != null) {
            this.jdField_k_of_type_AndroidWidgetImageView.setAlpha(0.6F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
        }
      }
      else
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837689);
          localSpannableString = new SpannableString("语音输入");
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131367885);
        }
        for (;;)
        {
          if (!VersionUtils.e()) {
            break label323;
          }
          if (this.jdField_k_of_type_AndroidWidgetImageView != null) {
            this.jdField_k_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
          break;
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        }
      }
    }
  }
  
  protected void n()
  {
    super.n();
    aJ();
  }
  
  public void o()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      localIntent.putExtra("public_account_msg_id", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
    }
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    PublicAccountUtil.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 1);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296341) {
      g(true);
    }
    if (2131297392 == paramView.getId())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
      PAStartupTracker.a(null, "pubAcc_profile_display", "");
    }
    if (paramView.getId() == 2131297413)
    {
      long l1 = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_l_of_type_AndroidWidgetImageView != null)) {
        QLog.d("Q.aio.BaseChatPie", 2, " onClick fun_btn start mInputStat = " + this.jdField_k_of_type_Int + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_l_of_type_AndroidWidgetImageView.getVisibility() + " currentPanel:" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() + " currenttime:" + System.currentTimeMillis());
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) && (this.jdField_l_of_type_AndroidWidgetImageView != null) && (this.jdField_l_of_type_AndroidWidgetImageView.getVisibility() != 0))
      {
        c();
        if (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) && (((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "city_search_click", 0, 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, " onClick fun_btn end mInputStat = " + this.jdField_k_of_type_Int + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800584F", "0X800584F", 0, 0, "", "", "", "");
      }
    }
    if ((paramView.getId() == 2131297864) && (this.jdField_k_of_type_Int != 1))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (paramView.getId() == 2131298675)
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 8) {
          break label893;
        }
        if (this.jdField_k_of_type_AndroidWidgetImageView != null) {
          this.jdField_k_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131371205));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("fastimage", 2, "BaseCHatPie onClick keybordicon removeFastImage");
          }
          a(true);
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      }
      label633:
      if (paramView.getId() == 2131298676)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) {
          break label963;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        if (this.jdField_l_of_type_AndroidWidgetImageView != null)
        {
          this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(this.jdField_h_of_type_Int);
          this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367657));
        }
      }
      label700:
      if (paramView.getId() == 2131296336) {
        ac();
      }
      if ((this.P) && (paramView.getId() == 2131297413)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C9C", "0X8005C9C", 0, 1, 0, "", "", "", "");
      }
      if ((!(paramView.getTag() instanceof String)) || (!PubAccountTipsManager.jdField_a_of_type_JavaLangString.equals((String)paramView.getTag())) || (this.jdField_a_of_type_AndroidContentContext == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label1128;
      }
      if (System.currentTimeMillis() - this.jdField_k_of_type_Long >= 1000L) {
        break label1012;
      }
    }
    label893:
    label963:
    label1012:
    Object localObject1;
    Object localObject2;
    label1128:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      if ((this.jdField_l_of_type_AndroidWidgetImageView != null) && (this.jdField_l_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        h(false);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      X();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
      if ((this.jdField_l_of_type_AndroidWidgetImageView != null) && (this.jdField_l_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        h(false);
      }
      if (this.jdField_k_of_type_AndroidWidgetImageView != null) {
        this.jdField_k_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131371206));
      }
      j(0);
      break label633;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      if (this.jdField_l_of_type_AndroidWidgetImageView == null) {
        break label700;
      }
      this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(this.jdField_i_of_type_Int);
      this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367658));
      break label700;
      this.jdField_k_of_type_Long = System.currentTimeMillis();
      localObject1 = new StringBuilder("http://gouwu.qq.com/m/html/shop_map.html?_wv=1027&shop_uin=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", ((StringBuilder)localObject1).toString());
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconClk", "Clk_shopnearbyicon", 0, 0, "", "", "", "");
      if (paramView.getId() != 2131297404) {
        break label1293;
      }
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (!ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label1361;
      }
      localObject2 = (String)EcShopAssistantManager.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("uin", (String)localObject2);
    localIntent = AIOUtils.a(localIntent, null);
    if (((FriendsManager)localObject1).b((String)localObject2))
    {
      localIntent.putExtra("uintype", 0);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Shop_customservice", "Clk_shopcustomservice", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (;;)
    {
      label1293:
      super.onClick(paramView);
      return;
      localIntent.putExtra("uintype", 1005);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "-客服");
      localIntent.putExtra("key_sub_title_from", "来自\"QQ咨询\"");
      break;
      label1361:
      C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "publicAccountAIOTitle");
      if (QLog.isColorLevel()) {
        QLog.w("Q.aio.BaseChatPie", 2, "c2bcall button :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ", name = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.W = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  protected void r()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843170);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131364570));
    }
  }
  
  public void r(int paramInt)
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      if (!this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  public void s(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  protected boolean s()
  {
    if ((!this.ab) && (this.P))
    {
      this.ab = true;
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
    }
    while ((this.ac) || (!this.P)) {
      return true;
    }
    this.ac = true;
    return false;
  }
  
  public void t(int paramInt)
  {
    try
    {
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramInt);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void u(int paramInt)
  {
    try
    {
      this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        return;
        this.jdField_g_of_type_AndroidWidgetTextView.setText(2131368601);
        continue;
        this.jdField_g_of_type_AndroidWidgetTextView.setText(2131368597);
        continue;
        this.jdField_g_of_type_AndroidWidgetTextView.setText(2131364507);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageRecord))
    {
      localObject = ((MessageRecord)paramObject).getExtInfoFromExtStr("welcome_msg");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("true"))) {
        ThreadManager.a(new obg(this), 8, null, false);
      }
      this.Z = true;
    }
    if ((ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((paramObject instanceof MessageRecord))) {
      ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.update(paramObservable, paramObject);
    int i1;
    if ((paramObservable instanceof TroopEntranceBar)) {
      if ((paramObject instanceof Integer))
      {
        i1 = ((Integer)paramObject).intValue();
        if (i1 != 0) {
          break label152;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b();
      }
    }
    label151:
    label152:
    do
    {
      do
      {
        do
        {
          do
          {
            break label151;
            break label151;
            for (;;)
            {
              aT();
              return;
              if (i1 == 1) {
                this.ap = true;
              }
            }
            if (!(paramObservable instanceof QQMessageFacade)) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar == null);
          paramObject = (TroopManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(51);
          paramObservable = ((QQMessageFacade)paramObservable).a();
        } while (paramObservable == null);
        paramObservable = ((TroopManager)paramObject).b(paramObservable.frienduin);
      } while ((paramObservable == null) || (paramObservable.associatePubAccount != Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue()));
      paramObject = Message.obtain();
      ((Message)paramObject).what = 9;
      localObject = new Bundle();
      ((Bundle)localObject).putString("troopUin", paramObservable.troopuin);
      ((Message)paramObject).setData((Bundle)localObject);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)paramObject);
      return;
    } while (!this.P);
    ThreadManager.a(new obh(this), 5, null, false);
  }
  
  public void v(int paramInt)
  {
    if (this.jdField_h_of_type_AndroidAppDialog == null)
    {
      this.jdField_h_of_type_AndroidAppDialog = new Dialog(a(), 2131558973);
      this.jdField_h_of_type_AndroidAppDialog.setContentView(2130904039);
    }
    TextView localTextView1 = (TextView)this.jdField_h_of_type_AndroidAppDialog.findViewById(2131297123);
    TextView localTextView2 = (TextView)this.jdField_h_of_type_AndroidAppDialog.findViewById(2131297898);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_h_of_type_AndroidAppDialog.setOnCancelListener(new obv(this));
      this.jdField_h_of_type_AndroidAppDialog.show();
      return;
      localTextView1.setText(2131361810);
      localTextView2.setText(2131361811);
      continue;
      localTextView1.setText(2131361807);
      localTextView2.setText(2131361809);
      continue;
      localTextView1.setText(2131361808);
      localTextView2.setText(2131361809);
    }
  }
  
  public boolean v()
  {
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject == null) && (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null))
      {
        PublicAccountUtil.a();
        PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return true;
      }
      return false;
    }
  }
  
  protected void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(null);
    }
    if (this.F) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "hasDestory = true return");
      }
    }
    for (;;)
    {
      return;
      PublicAccountUtil.a();
      if (this.jdField_a_of_type_Ocd != null) {}
      try
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ocd);
        this.jdField_a_of_type_Ocd = null;
        if (this.jdField_b_of_type_MqqAppNewIntent != null) {
          PublicAccountManager.a().a(this.jdField_b_of_type_MqqAppNewIntent);
        }
        if (this.jdField_c_of_type_MqqAppNewIntent != null) {
          this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
        }
        super.w();
        if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(a());
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidContentContext);
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ChatMessage)((Iterator)localObject1).next();
          if (MessageForStructing.class.isInstance(localObject2))
          {
            localObject2 = ((MessageForStructing)localObject2).structingMsg;
            if (StructMsgForGeneralShare.class.isInstance(localObject2)) {
              ((StructMsgForGeneralShare)localObject2).unInitPay();
            }
          }
        }
        if ((this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
        if ((this.jdField_h_of_type_AndroidAppDialog != null) && (this.jdField_h_of_type_AndroidAppDialog.isShowing()))
        {
          this.jdField_h_of_type_AndroidAppDialog.dismiss();
          this.jdField_h_of_type_AndroidAppDialog = null;
        }
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.d();
        }
        aC();
        aX();
        if (this.jdField_m_of_type_Long != 0L)
        {
          this.jdField_m_of_type_Long = (System.currentTimeMillis() - this.jdField_m_of_type_Long);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D5", "0X80064D5", 0, 0, "", "" + this.jdField_m_of_type_Long, "" + this.eE, "");
          this.jdField_m_of_type_Long = 0L;
          this.ew = 0;
        }
        if (this.Z) {
          ThreadManager.b(new ocb(this));
        }
        localObject1 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        if (localObject1 == null) {
          continue;
        }
        ((PublicAccountDataManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, NetConnInfoCenter.getServerTimeMillis());
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public boolean w()
  {
    boolean bool = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1008);
      if (localObject != null) {
        if (((QQMessageFacade.Message)localObject).msgtype == 63525)
        {
          localMessageForStructing = new MessageForStructing();
          MessageForStructing.copyMessageRecordBaseField(localMessageForStructing, (MessageRecord)localObject);
          localMessageForStructing.parse();
          if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mPromotionType == 1) || (localMessageForStructing.structingMsg.mPromotionType == 2))) {
            a(localMessageForStructing);
          }
        }
        else
        {
          while ((((QQMessageFacade.Message)localObject).msgtype == 63527) && (((QQMessageFacade.Message)localObject).isSend()))
          {
            MessageForStructing localMessageForStructing;
            return true;
          }
          if ((((QQMessageFacade.Message)localObject).msgtype == 60528) && (!((QQMessageFacade.Message)localObject).isSend()))
          {
            this.dR = 1;
            return true;
          }
          if (((QQMessageFacade.Message)localObject).msgtype == 60527) {
            try
            {
              localObject = BitAppMsgFactory.a(((QQMessageFacade.Message)localObject).msgData);
              if (localObject != null)
              {
                localObject = ((BitAppMsg)localObject).getNode();
                if (localObject != null)
                {
                  int i1 = Integer.parseInt(((BitAppMsgNode)localObject).a("promotionType"));
                  if ((i1 == 1) || (i1 == 2)) {
                    bool = true;
                  }
                  return bool;
                }
              }
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    return false;
  }
  
  public boolean x()
  {
    return this.L;
  }
  
  public boolean y()
  {
    return (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 8);
  }
  
  public boolean z()
  {
    return (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) || (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getVisibility() == 8);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\rebuild\PublicAccountChatPie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */