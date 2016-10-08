package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarConfig;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.PerfRelativeLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tlg;
import tlh;
import tli;
import tlj;
import tll;
import tlm;
import tlr;
import tlt;
import tlu;
import tlv;
import tlw;
import tlx;
import tlz;
import tma;
import tmb;
import tmc;
import tmd;
import tme;
import tmf;
import tmg;
import tmh;
import tmi;
import tmj;

public class NearbyPeopleProfileActivity
  extends BaseActivity
{
  static final int A = 206;
  public static final String A = "is_from_web";
  static final int B = 207;
  public static final String B = "frome_where";
  public static final int C = 640;
  static final String F = "plus";
  public static final int I = -1;
  public static final int J = -2;
  public static final int K = 0;
  public static final int L = 1;
  public static final int M = 2;
  public static final int N = 3;
  public static final int O = 4;
  public static final int P = 5;
  public static final int Q = 6;
  public static int T = 0;
  static final int W = 1001;
  public static final int a = 1;
  static final long jdField_a_of_type_Long = 20000L;
  public static final String a = "Q.nearby_people_card.";
  public static final int b = 3;
  public static final String b = "param_mode";
  public static final int c = 4;
  public static final String c = "param_tiny_id";
  public static final int d = 5;
  public static final String d = "AllInOne";
  public static final int e = 10;
  public static final String e = "param_dating_id";
  public static final int f = 6;
  public static final String f = "param_dating_subject";
  public static final int g = 7;
  public static final String g = "param_dating_pub";
  public static final int h = 8;
  public static final String h = "param_no_miss";
  public static final int i = 11;
  public static final String i = "param_xuan_yan";
  public static final int j = 12;
  public static final String j = "param_nickname";
  public static final int k = 13;
  public static final String k = "param_gender";
  public static final int l = 1;
  public static final String l = "param_age";
  public static final int m = 2;
  public static final String m = "param_interest_filter_type";
  public static final int n = 3;
  public static final String n = "param_interest";
  public static final int o = -1;
  public static final String o = "param_career";
  public static int p = 0;
  public static final String p = "param_constellation";
  public static int q = 0;
  public static final String q = "param_marital_status";
  public static int r = 0;
  public static final String r = "param_photo_count";
  public static final int s = 100;
  public static final String s = "param_god_flag";
  public static final int t = 101;
  public static final String t = "param_from_interest_test";
  public static final int u = 1000;
  public static final String u = "is_change_head";
  public static final int v = 102;
  public static final String v = "sp_showlove_guide_needshow";
  public static final int w = 202;
  public static final String w = "250";
  public static final int x = 203;
  public static final int y = 204;
  public static final int z = 205;
  public static final String z = "abp_flag";
  public String C;
  public int D;
  String D;
  public int E;
  public String E;
  public int F;
  int G;
  public int H = 0;
  public int R = 0;
  public int S = -1;
  public int U = 18;
  public int V;
  private int X;
  private int Y;
  public float a;
  public Dialog a;
  public Intent a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  public ProfileActivity.AllInOne a;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new tlt(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tlj(this);
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new tll(this);
  private DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback = new tlr(this);
  private DynamicAvatarDownloadManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
  private DynamicAvatarManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = new tmb(this);
  public NearbyCardHandler a;
  public NearbyCardObserver a;
  public PicInfo a;
  private NearbyProfileDisplayPanel jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel;
  private NearbyProfileEditPanel jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public ArrayList a;
  private tmj jdField_a_of_type_Tmj;
  public boolean a;
  public long b;
  public Dialog b;
  private View jdField_b_of_type_AndroidViewView;
  private ConditionSearchManager.IConfigListener jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new tlu(this);
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  public boolean b;
  public boolean c = false;
  boolean d = true;
  boolean e;
  public boolean f = false;
  public boolean g = true;
  boolean h = false;
  boolean i = false;
  public boolean j = true;
  public boolean k;
  public boolean l;
  public volatile boolean m;
  public boolean n;
  boolean o = false;
  public boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  String x;
  String y;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_p_of_type_Int = 18;
    jdField_q_of_type_Int = 12;
    jdField_r_of_type_Int = jdField_q_of_type_Int;
  }
  
  public NearbyPeopleProfileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new tmd(this);
    this.jdField_a_of_type_AndroidAppDialog = null;
    this.jdField_b_of_type_AndroidAppDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new tlm(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
    this.jdField_p_of_type_Boolean = false;
  }
  
  public static void a(Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("frome_where", paramInt1);
      localIntent.addFlags(536870912);
      if (!(paramActivity instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramActivity.startActivityForResult(localIntent, paramInt2);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    a(paramContext, paramAllInOne, paramBundle, 6);
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("frome_where", paramInt);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  private void a(NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.jdField_D_of_type_Int != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a(paramNearbyPeopleCard);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vTempChatSig != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vTempChatSig;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_JavaLangString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
    {
      jdField_r_of_type_Int = jdField_p_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
          break label368;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005286", "0X8005286", 0, 0, "", "", "", "");
      }
      label182:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.isEmpty())) {
        break label418;
      }
      paramNearbyPeopleCard = null;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        paramNearbyPeopleCard = (PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList);
      if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard == this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramNearbyPeopleCard);
      }
      label282:
      if (this.jdField_D_of_type_Int == 3)
      {
        if (!Utils.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
          break label464;
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("param_mode", 2);
        this.jdField_D_of_type_Int = 2;
      }
    }
    for (;;)
    {
      if (this.jdField_D_of_type_Int != 1) {
        break label512;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 1000L);
      return;
      jdField_r_of_type_Int = jdField_q_of_type_Int;
      break;
      label368:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label182;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005287", "0X8005287", 0, 0, "", "", "", "");
      break label182;
      label418:
      if (1 == this.jdField_D_of_type_Int) {
        break label282;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onNearbyCardDownload need to getQzoneCover.");
      }
      this.g = false;
      this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 2);
      break label282;
      label464:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin))
      {
        paramNearbyPeopleCard = (FriendsManager)this.app.getManager(50);
        if (paramNearbyPeopleCard != null) {
          this.f = paramNearbyPeopleCard.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        }
      }
    }
    label512:
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      f();
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004A1C", "0X8004A1C", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_no_miss", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1D", "0X8004A1D", 0, 0, "", "", "", "");
    }
    Intent localIntent = new Intent(this, NearbyActivity.class);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    overridePendingTransition(2130968587, 2130968588);
    finish();
  }
  
  private void e()
  {
    this.jdField_D_of_type_Int = 2;
    InterestGuide.a(this.jdField_D_of_type_Int);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new tli(this));
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  private void f()
  {
    NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
    localNearPeopleFilters.i = -1;
    NearPeopleFilterActivity.NearPeopleFilters.a(this.app.a(), localNearPeopleFilters);
    this.H = 1;
    this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", 1).commit();
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 0, getString(paramInt), 2131371869, 2131371870, new tme(this), new tmf(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void a(int paramInt, Rect paramRect)
  {
    Intent localIntent = new Intent(this, NearbyProfilePicBrowserActivity.class);
    localIntent.putExtra("intent_param_index", paramInt);
    localIntent.putExtra("intent_param_pic_infos", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("report_visited_pic", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    localIntent.addFlags(536870912);
    startActivity(localIntent);
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(this.X);
  }
  
  public void a(long paramLong)
  {
    a(paramLong, -1, -1);
  }
  
  void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_D_of_type_Int = 1;
    InterestGuide.a(this.jdField_D_of_type_Int);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(paramLong);
    localAlphaAnimation.setAnimationListener(new tmi(this));
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    try
    {
      ((ViewGroup)this.jdField_b_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidViewView);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a();
      }
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel = null;
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904248, null);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel = new NearbyProfileEditPanel(this, this.jdField_a_of_type_AndroidViewView);
      ((ViewGroup)this.jdField_b_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidViewView, new RelativeLayout.LayoutParams(-1, -1));
      BounceScrollView localBounceScrollView = (BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302043);
      localBounceScrollView.post(new tlh(this, localBounceScrollView, this.jdField_b_of_type_AndroidViewView.findViewById(2131301967).getScrollY()));
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      g();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(PicInfo paramPicInfo, Rect paramRect)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPicInfo);
    paramPicInfo = new Intent(this, NearbyProfilePicBrowserActivity.class);
    paramPicInfo.putExtra("intent_param_index", 0);
    paramPicInfo.putExtra("intent_param_pic_infos", localArrayList);
    paramPicInfo.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    paramPicInfo.addFlags(536870912);
    startActivity(paramPicInfo);
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (this.jdField_p_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "downloadHDAvatar is updated HDAvatar true");
      }
      return;
    }
    this.jdField_a_of_type_Tmj = new tmj(this, paramString1, paramInt, paramString2, paramBoolean);
    ThreadManager.a(this.jdField_a_of_type_Tmj, 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
    {
      localObject2 = (PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!StringUtil.b(((PicInfo)localObject2).c)) {
        ((ArrayList)localObject1).add(((PicInfo)localObject2).c);
      }
      i1 += 1;
    }
    localObject1 = new Intent(this, PhotoListActivity.class);
    ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
    ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject1).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    ((Intent)localObject1).putExtra("PhotoConst.IS_SINGLE_MODE", true);
    ((Intent)localObject1).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    ((Intent)localObject1).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    ((Intent)localObject1).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject2 = AppConstants.bj + this.app.a() + "/" + "nearby_people_photo/";
    ((Intent)localObject1).putExtra("PhotoConst.TARGET_PATH", (String)localObject2 + System.currentTimeMillis() + ".jpg");
    ((Intent)localObject1).putExtra("PhotoConst.CLIP_WIDTH", 640);
    ((Intent)localObject1).putExtra("PhotoConst.CLIP_HEIGHT", 640);
    ((Intent)localObject1).putExtra("PhotoConst.TARGET_WIDTH", 640);
    ((Intent)localObject1).putExtra("PhotoConst.TARGET_HEIGHT", 640);
    ((Intent)localObject1).putExtra("is_change_head", paramBoolean);
    startActivity((Intent)localObject1);
    AlbumUtil.a(this, false, true);
    ReportController.b(this.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.tinyId != this.jdField_b_of_type_Long) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "editNearbyProfileCardResult|[" + paramBoolean1 + "," + paramNearbyPeopleCard + "]");
    }
    a();
    Object localObject;
    if ((paramBoolean1) && (paramNearbyPeopleCard != null))
    {
      this.jdField_b_of_type_Boolean = false;
      a(2, "资料保存成功");
      if ((paramNearbyPeopleCard.picList != null) && (!paramNearbyPeopleCard.picList.isEmpty()))
      {
        paramString = (PicInfo)paramNearbyPeopleCard.picList.get(0);
        if (!TextUtils.isEmpty(paramString.d))
        {
          if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
            break label717;
          }
          localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          PicInfo localPicInfo;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localPicInfo = (PicInfo)((Iterator)localObject).next();
          } while (!paramString.d.equals(localPicInfo.d));
        }
      }
    }
    label408:
    label611:
    label714:
    label717:
    for (paramBoolean1 = false;; paramBoolean1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "editNearbyProfileCardResult isVideoHeadNewUpload:" + paramBoolean1);
      }
      localObject = this.app;
      int i1;
      if (paramBoolean1)
      {
        paramString = "1";
        ReportController.b((QQAppInterface)localObject, "dc00898", "", "", "0X800711B", "0X800711B", 0, 0, paramString, "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
        if (this.c)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag = false;
          this.c = false;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.isEmpty())) {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList);
        }
        if (paramBoolean2) {
          NearbyCardManager.a(this.app);
        }
        if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0) != 1) {
          break label611;
        }
        c(true);
        paramNearbyPeopleCard = new Intent();
        paramNearbyPeopleCard.putExtra("param_xuan_yan", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
        paramNearbyPeopleCard.putExtra("param_nickname", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
        paramNearbyPeopleCard.putExtra("param_gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
        paramNearbyPeopleCard.putExtra("param_age", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age);
        paramNearbyPeopleCard.putExtra("param_career", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job);
        paramNearbyPeopleCard.putExtra("param_constellation", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation);
        paramNearbyPeopleCard.putExtra("param_marital_status", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus);
        paramNearbyPeopleCard.putExtra("param_god_flag", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag);
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) || (!((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).equals(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo))) {
          break label714;
        }
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      }
      for (;;)
      {
        paramNearbyPeopleCard.putExtra("param_photo_count", i1);
        setResult(-1, paramNearbyPeopleCard);
        return;
        paramString = "0";
        break;
        if (this.H != 1) {
          f();
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
        {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        e();
        ThreadManager.a().post(new tma(this));
        break label408;
        if (TextUtils.isEmpty(paramString)) {
          b("资料保存失败");
        }
        for (;;)
        {
          this.c = false;
          return;
          b(paramString);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String[] arrayOfString = getResources().getStringArray(2131230742);
    ActionSheet localActionSheet = ActionSheet.a(this);
    if (paramBoolean1) {
      localActionSheet.a(arrayOfString[22], 2130841021, 0);
    }
    localActionSheet.c(arrayOfString[25]);
    localActionSheet.c(arrayOfString[26]);
    localActionSheet.d(arrayOfString[16]);
    localActionSheet.a(new tlv(this, paramBoolean1, paramBoolean2, localActionSheet));
    localActionSheet.show();
  }
  
  boolean a(String paramString)
  {
    Setting localSetting = (Setting)this.app.a().createEntityManager().a(Setting.class, paramString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      if ((localSetting.bFaceFlags & 0x20) != 0) {
        this.S = 0;
      }
      for (;;)
      {
        this.C = localSetting.url;
        if (((this.S == 640) || (this.S == 0)) && (!TextUtils.isEmpty(this.C))) {
          a(paramString, this.S, this.C, false);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "get setting info from db, headWidth is: " + this.S + " getHeadUrl is: " + this.C);
        }
        return true;
        if ((localSetting.bFaceFlags & 0x10) != 0) {
          this.S = 640;
        } else if ((localSetting.bFaceFlags & 0x8) != 0) {
          this.S = 140;
        } else if ((localSetting.bFaceFlags & 0x4) != 0) {
          this.S = 100;
        } else {
          this.S = 40;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "get setting info from db null, to get setting info from server.");
    }
    this.app.d(paramString);
    return false;
  }
  
  void b()
  {
    this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 2131371872, getString(2131371873), 2131367262, 2131371874, new tmg(this), new tmh(this));
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void b(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(this.X);
  }
  
  public void b(boolean paramBoolean)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
    localUserInfo.jdField_b_of_type_JavaLangString = this.app.b();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131366976));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    if (paramBoolean) {}
    for (int i1 = 10;; i1 = 5)
    {
      QZoneHelper.a(this, localUserInfo, localBundle, i1);
      ReportController.b(this.app, "CliOper", "", "", "0X800481F", "0X800481F", 2, 0, "", "", "", "");
      return;
    }
  }
  
  public void c()
  {
    InputMethodUtil.a(this);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (this.jdField_b_of_type_Boolean)
    {
      this.d = false;
      this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(new ArrayList());
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0) == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1B", "0X8004A1B", 0, 0, "", "", "", "");
      if (this.l)
      {
        if (this.k)
        {
          Intent localIntent = new Intent(this, NearbyActivity.class);
          localIntent.putExtra("abp_flag", this.k);
          localIntent.setFlags(67108864);
          startActivity(localIntent);
        }
        finish();
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
      c(false);
      continue;
      if ((this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0) == 2) && (this.jdField_D_of_type_Int == 1)) {
        e();
      }
    }
  }
  
  void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.app != null)) {
      ThreadManager.a(new tlw(this, paramString), 5, null, true);
    }
  }
  
  void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_r_of_type_Boolean) || (isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "refreshStangerFace.");
    }
    this.jdField_r_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new tlz(this);
    ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_D_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.b;
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.b()))
    {
      localProfilePerformanceReport.b(0);
      localProfilePerformanceReport.a(1);
    }
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    if ((!this.app.isLogin()) || (this.jdField_a_of_type_AndroidContentIntent == null))
    {
      finish();
      return false;
    }
    super.setContentView(2130904247);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.X = getTitleBarHeight();
    this.E = ((int)(this.jdField_a_of_type_Float * 70.0F + 0.5D));
    this.F = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.app.a(60));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(58));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)this.app.getManager(179));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a();
    this.n = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(4);
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a() != null)
    {
      this.U = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a().e;
      if ((this.U < 0) || (this.U > 30)) {
        this.U = 18;
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("AllInOne"));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.", 2, "passed allinone is null!!");
        }
        finish();
        return true;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.", 2, "getIntent() exception:" + paramBundle.getMessage());
        }
      }
      i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
      if (((i1 == 2) || (i1 == 1)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = this.app.getAccount();
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo = new PicInfo();
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c = "plus";
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.jdField_b_of_type_JavaLangString = "plus";
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo);
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.jdField_a_of_type_JavaLangString = "plus";
      this.jdField_D_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
      this.i = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_from_interest_test", false);
      this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("param_tiny_id", 0L);
      i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131301365);
      if ((this.jdField_b_of_type_AndroidViewView instanceof PerfRelativeLayout)) {
        ((PerfRelativeLayout)this.jdField_b_of_type_AndroidViewView).setOnDrawCompleteListener(this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener);
      }
      if (this.jdField_D_of_type_Int != 1) {
        break label821;
      }
    }
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904248, null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel = new NearbyProfileEditPanel(this, this.jdField_a_of_type_AndroidViewView);
    ((ViewGroup)this.jdField_b_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidViewView, new RelativeLayout.LayoutParams(-1, -1));
    this.R += 1;
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback);
    }
    a("正在加载...");
    ThreadManager.a(new tlg(this), 5, null, false);
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.b())) {
      localProfilePerformanceReport.a(4);
    }
    ThreadManager.a(new tlx(this, localProfilePerformanceReport, i1), 8, null, false);
    paramBundle = (DatingProxyManager)this.app.getManager(70);
    if (paramBundle.a().a() > 0) {
      paramBundle.a().a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 999)) {}
    for (int i1 = 30;; i1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)
    {
      ViewExposeUtil.a(this.app, getClass(), hashCode(), "0X8004CC5", i1, String.valueOf(this.jdField_b_of_type_Long));
      return true;
      label821:
      this.y = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_dating_id");
      this.G = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_dating_subject", 0);
      this.e = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_dating_pub", false);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel = new NearbyProfileDisplayPanel(this, this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.l();
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a();
    }
    if (this.app.a().jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i1 = this.app.a().jdField_a_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      int i2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel != null)
      {
        i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.k();
      }
      for (;;)
      {
        Object localObject = (NearbyPeoplePhotoUploadProcessor)this.app.a().a(null, 0L);
        if (localObject != null) {
          ((NearbyPeoplePhotoUploadProcessor)localObject).g();
        }
        try
        {
          if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -2)
          {
            if (this.Y <= 0) {
              break label353;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X80059BB", "0X80059BB", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel != null) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.m();
            }
            localObject = ViewExposeUtil.a(getClass(), hashCode());
            if (localObject != null)
            {
              ReportController.b(this.app, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, String.valueOf(this.jdField_b_of_type_Long), Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_b_of_type_Long), "", "");
              int i3 = (int)(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_b_of_type_Long) / 1000;
              if (NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, this.jdField_D_of_type_Int)) {
                this.app.a().a(this.jdField_b_of_type_Long, i3, i1, i2);
              }
            }
            return;
            label353:
            ReportController.b(this.app, "CliOper", "", "", "0X80059BC", "0X80059BC", 0, 0, "", "", "", "");
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        i2 = 0;
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    boolean bool;
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_D_of_type_Int == 1)
        {
          localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          bool = paramIntent.getBooleanExtra("is_change_head", false);
          if (QLog.isColorLevel()) {
            QLog.i("Q.nearby_people_card.", 2, "doOnNewIntent isChangeHead: " + bool);
          }
          if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
            break;
          }
          this.jdField_D_of_type_JavaLangString = null;
          if (bool)
          {
            paramIntent = new PicInfo();
            paramIntent.c = ((String)((ArrayList)localObject).get(0));
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a(paramIntent);
            return;
          }
          i1 = 0;
          while (i1 < ((ArrayList)localObject).size())
          {
            if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_r_of_type_Int + 1)
            {
              paramIntent = new PicInfo();
              paramIntent.c = ((String)((ArrayList)localObject).get(i1));
              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a(paramIntent)) {
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 1000L);
              }
            }
            i1 += 1;
          }
        }
      }
    } while (TextUtils.isEmpty(this.jdField_D_of_type_JavaLangString));
    paramIntent = QZoneHelper.UserInfo.a();
    paramIntent.jdField_a_of_type_JavaLangString = this.app.a();
    paramIntent.jdField_b_of_type_JavaLangString = this.app.b();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_title", getString(2131366976));
    ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
    ((Bundle)localObject).putBoolean("show_album", false);
    ((Bundle)localObject).putString("key_jump_album_id", this.jdField_D_of_type_JavaLangString);
    if (bool) {}
    for (int i1 = 10;; i1 = 5)
    {
      QZoneHelper.a(this, paramIntent, (Bundle)localObject, i1);
      return;
    }
  }
  
  protected void doOnPause()
  {
    InputMethodUtil.a(this);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_q_of_type_Boolean) && (this.jdField_D_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
        return;
      }
      ThreadManager.a(new tmc(this), 8, null, false);
    }
    this.jdField_q_of_type_Boolean = false;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.i();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_q_of_type_Boolean = true;
    if ((this.jdField_D_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.b(false);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel != null)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.f();
      }
    }
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.b;
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.a(true))) {
      localProfilePerformanceReport.a(this.app.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.j();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (!this.s)
    {
      this.H = this.app.getPreferences().getInt("nearby_people_profile_ok_new", 0);
      this.l = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_from_web", false);
      this.k = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("abp_flag", false);
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -1)
      {
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("PUSH_CONTENT");
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800524A", "0X800524A", 0, 0, "", "", str1, "");
      }
      this.s = true;
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.k) {
      overridePendingTransition(2130968587, 2130968588);
    }
  }
  
  protected boolean isWrapContent()
  {
    boolean bool = true;
    if (this.jdField_D_of_type_Int == 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean onBackEvent()
  {
    int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
    if (i1 == 1) {
      a(2131371867);
    }
    do
    {
      return true;
      if ((i1 == 2) && (this.jdField_D_of_type_Int == 1))
      {
        if (this.H == 0)
        {
          a(2131371867);
          return true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.b())
        {
          a(2131371868);
          return true;
        }
        c();
        return true;
      }
    } while (InterestGuide.a());
    if (this.k)
    {
      localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.k);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
      localIntent.putExtra("nearby_profile_nickname", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
    }
    if ((getIntent().getBooleanExtra("from_newer_guide", false)) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      Object localObject = this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 1001);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label328;
      }
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ChatMessage)((Iterator)localObject).next()).isSendFromLocal());
    }
    label328:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onBackEvent hasSayHi: " + bool);
      }
      localIntent.putExtra("has_operation", bool);
      localIntent.putExtra("uin", String.valueOf(this.jdField_b_of_type_Long));
      localIntent.putExtra("intent_key_has_ever_vote", this.o);
      setResult(-1, localIntent);
      return super.onBackEvent();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\profilecard\NearbyPeopleProfileActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */