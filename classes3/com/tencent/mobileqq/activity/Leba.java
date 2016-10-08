package com.tencent.mobileqq.activity;

import Wallet.AuthCodeItem;
import Wallet.AuthCodeReq;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyObserver;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.lyric.util.LyricContext;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedPointView;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchUtil;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.sensewhere.SenseWhereManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.util.QZoneLogTags;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import lqm;
import lqn;
import lqo;
import lqq;
import lqr;
import lqs;
import lqt;
import lqu;
import lqv;
import lqw;
import lqx;
import lqz;
import lra;
import lrb;
import lrd;
import lre;
import lrf;
import lrg;
import lri;
import lrj;
import lrk;
import lrn;
import lro;
import lrq;
import lrs;
import lrt;
import lru;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class Leba
  extends Frame
  implements View.OnClickListener, ViewStub.OnInflateListener, LebaIconDownloader.IDownloadListener, CommonLoadingView.OnFirstDrawListener
{
  public static final int a = 11340001;
  public static boolean a = false;
  public static final int b = 11340002;
  static long jdField_b_of_type_Long = 0L;
  private static final String jdField_b_of_type_JavaLangString = "Q.lebatab.leba";
  private static List jdField_b_of_type_JavaUtilList;
  public static final int c = 11340005;
  private static List jdField_c_of_type_JavaUtilList;
  public static final int d = 1134006;
  private static final String jdField_d_of_type_JavaLangString = "has_search_bar";
  public static final int e = 1688001;
  private static final long jdField_e_of_type_Long = 1000L;
  protected final long a;
  public AuthCodeItem a;
  public Intent a;
  Handler jdField_a_of_type_AndroidOsHandler = new lrj(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public LebaListViewAdapter a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new lre(this);
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new lrd(this);
  QWalletAuthObserver jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_AndroidOsHandler);
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver = new lrb(this);
  public DownloadIconsListener a;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new lrs(this);
  public FPSXListView a;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("qzone_leba", "com.tencent.mobileqq:qzone");
  protected TimerTaskManager a;
  private NearbyProxyObserver jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProxyObserver = new lra(this);
  private RedPointView jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointView;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new lqx(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new lqw(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new lqv(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  public AdapterView.OnItemClickListener a;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  protected final String a;
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public AtomicBoolean a;
  public MqqHandler a;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PreloadProcHitSession jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("web_leba", "com.tencent.mobileqq:web");
  private boolean jdField_b_of_type_Boolean;
  public long c;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = true;
  public final int f;
  private boolean f;
  private boolean g = true;
  private final int j = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_c_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList.add("jiankang.qq.com");
    jdField_b_of_type_JavaUtilList.add("guahao.com");
    jdField_b_of_type_JavaUtilList.add("91160.com");
    jdField_c_of_type_JavaUtilList.add("gamecenter.qq.com");
    jdField_c_of_type_JavaUtilList.add("info.gamecenter.qq.com");
    jdField_c_of_type_JavaUtilList.add("gift.gamecenter.qq.com");
    jdField_c_of_type_JavaUtilList.add("youxi.vip.qq.com");
    jdField_c_of_type_JavaUtilList.add("imgcache.gtimg.cn");
  }
  
  public Leba()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = LyricContext.a();
    this.jdField_a_of_type_JavaLangString = ("mobileMP" + System.currentTimeMillis());
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener = new lrq(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new lrt(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new lqo(this);
    this.jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void A()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("100600");
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(10).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointView == null) {
      return;
    }
    RedTouchItem localRedTouchItem2 = ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(100510);
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(String.valueOf(100510));
    RedTouchItem localRedTouchItem1 = null;
    if (localAppInfo != null) {
      localRedTouchItem1 = RedTouchUtil.a(localAppInfo);
    }
    localRedTouchItem1 = RedTouchUtil.a(localRedTouchItem2, localRedTouchItem1);
    if (localRedTouchItem1 == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointView.b();
    }
    for (;;)
    {
      localRedTouchManager.a(localAppInfo);
      if ((localRedTouchItem1 == null) || (!localRedTouchItem1.unReadFlag)) {
        break;
      }
      AccessibilityUtil.a(this.jdField_d_of_type_AndroidViewView, "附近 有更新");
      return;
      if (localRedTouchItem1.redtouchType == 1) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointView.b(19).d(2).a().a(localRedTouchItem1);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointView.b(0).d(5).a().a(localRedTouchItem1);
      }
    }
  }
  
  private void C()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    a(this.jdField_c_of_type_JavaLangString);
  }
  
  private void D()
  {
    Object localObject = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)localObject).a(1);
      if (localRedDotInfo != null) {
        TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
      }
      localObject = ((TroopRedTouchManager)localObject).a(6);
      if (localObject != null) {
        TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
  
  private void E()
  {
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.gamecenter.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.music");
    this.jdField_a_of_type_JavaUtilSet.add("com.qq.yijianfankui");
    this.jdField_a_of_type_JavaUtilSet.add("com.life.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.citylife.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.android.txnews.new2");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.Health");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.ketang");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.zhibojian");
    this.jdField_a_of_type_JavaUtilSet.add("qzone_feedlist");
  }
  
  private void a(ImageView paramImageView, int paramInt, Drawable paramDrawable)
  {
    if (paramInt == 1)
    {
      paramImageView.setImageDrawable(LebaIconDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDrawable));
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if ((paramTextView == null) || (paramInt == 0)) {
      return;
    }
    int i = a().getDimensionPixelSize(2131493348);
    switch (paramInt)
    {
    case 4: 
    default: 
      paramInt = i;
    }
    for (;;)
    {
      paramTextView = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      if ((paramTextView == null) || ((paramTextView.leftMargin == paramInt) && (paramTextView.bottomMargin == paramInt))) {
        break;
      }
      paramTextView.setMargins(paramInt, 0, 0, paramInt);
      return;
      paramInt = a().getDimensionPixelSize(2131493348);
      continue;
      paramInt = a().getDimensionPixelSize(2131493350);
      continue;
      paramInt = a().getDimensionPixelSize(2131493349);
      continue;
      paramInt = a().getDimensionPixelSize(2131493350);
    }
  }
  
  private void a(LebaViewItem paramLebaViewItem, int paramInt, ViewGroup paramViewGroup)
  {
    if ((paramLebaViewItem == null) || (paramLebaViewItem.a == null) || (paramInt == 0) || (paramViewGroup == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "invalid arguments in markNewFeatureUsed");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramLebaViewItem.a.isNew == 0)
        {
          paramLebaViewItem.a.isNew = 1;
          ThreadManager.a(new lqu(this, paramLebaViewItem), 5, null, true);
          try
          {
            paramLebaViewItem = paramViewGroup.findViewById(paramInt);
            if (paramLebaViewItem != null)
            {
              paramLebaViewItem.setVisibility(8);
              return;
            }
          }
          catch (NullPointerException paramLebaViewItem) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba", 2, "markNewFeatureUsed", paramLebaViewItem);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramAppInfo);
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString))) {}
    try
    {
      paramString = new File(this.jdField_a_of_type_ComTencentImageURLImageView.getContext().getFilesDir(), paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == 3042L) || (paramLong == 1058L);
  }
  
  public static boolean b(long paramLong)
  {
    return (paramLong == 1061L) || (paramLong == 3043L);
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null)) {
      return;
    }
    WebProcessManager.c(true);
    Object localObject = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
    if ((localObject != null) && (((WebProcessManager)localObject).d())) {
      ((WebProcessManager)localObject).e();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", "", "");
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
    ResourcePluginInfo localResourcePluginInfo;
    if (localObject != null)
    {
      int i = 0;
      if (i < ((List)localObject).size())
      {
        localResourcePluginInfo = (ResourcePluginInfo)((List)localObject).get(i);
        if (localResourcePluginInfo == null) {}
        while ((TextUtils.isEmpty(localResourcePluginInfo.strPkgName)) || (!localResourcePluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          i += 1;
          break;
        }
      }
    }
    for (long l = localResourcePluginInfo.uiResId;; l = 0L)
    {
      localObject = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if ((localObject != null) && ((((GameCenterManagerImp)localObject).a(601L)) || ((l > 0L) && (((GameCenterManagerImp)localObject).a(l))))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "app_center", "new_exposure", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.d();
      p();
      return;
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131297137));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131296706));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(a().getColor(2131428295));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131297082));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131297139));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131367562);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131297183));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368194);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetTextView).a(53).d(10).a();
    A();
  }
  
  private void s()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131298406));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null) {
        break label669;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter = new LebaListViewAdapter(a(), this.jdField_a_of_type_JavaUtilList, 2130903324, 2130903325, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new lru(this));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) {
        if (this.jdField_b_of_type_AndroidViewView == null)
        {
          this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2130904204, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
          this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301813);
          this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301818);
          this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301822);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301814));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301816));
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301817));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301819));
          this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301821));
          this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointView = new RedPointView(a(), this.jdField_d_of_type_AndroidViewView).a(49).a(true).d(5).a();
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301825));
          this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301826));
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131296895));
          }
          this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131300895));
          this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
          AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetEditText, a(2131362090));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300896));
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301812));
          this.jdField_f_of_type_Boolean = BaseApplicationImpl.a.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (!this.jdField_f_of_type_Boolean) {
            break label694;
          }
        }
      }
    }
    label669:
    label694:
    for (int i = 0;; i = 8)
    {
      ((LinearLayout)localObject).setVisibility(i);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new lqn(this));
      if (AppSetting.j) {
        AccessibilityUtil.c(this.jdField_b_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.a(this.jdField_b_of_type_AndroidViewView);
      localObject = this.jdField_c_of_type_AndroidViewView;
      View localView1 = this.jdField_d_of_type_AndroidViewView;
      View localView2 = this.jdField_e_of_type_AndroidViewView;
      AccessibilityUtil.a(new String[] { "好友动态", "附近", "兴趣部落" }, new View[] { localObject, localView1, localView2 });
      AccessibilityUtil.b(this.jdField_c_of_type_AndroidViewView, Button.class.getName());
      AccessibilityUtil.b(this.jdField_d_of_type_AndroidViewView, Button.class.getName());
      AccessibilityUtil.b(this.jdField_e_of_type_AndroidViewView, Button.class.getName());
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      n();
      return;
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
      break;
    }
  }
  
  private void t()
  {
    if ((a() != null) && (a().app != null))
    {
      QZoneManager localQZoneManager = (QZoneManager)a().app.getManager(9);
      if (localQZoneManager != null)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localQZoneManager.b(3);
        }
        localQZoneManager.a(false);
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void u()
  {
    v();
    B();
    int i;
    if (NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
    {
      long l3 = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(0L))).longValue();
      long l2 = -1L;
      long l4 = System.currentTimeMillis();
      long l1 = l2;
      if (l3 >= 0L)
      {
        l1 = l2;
        if (l4 >= l3) {
          l1 = l4 - l3;
        }
      }
      if ((l1 >= 0L) && (l1 <= 28800000L))
      {
        i = 2130840845;
        this.jdField_c_of_type_Boolean = true;
        jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(i);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134006, 200L);
      z();
      A();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
      }
      return;
      this.jdField_c_of_type_Boolean = false;
      jdField_a_of_type_Boolean = false;
      i = 2130840844;
    }
  }
  
  private void v()
  {
    int k;
    Object localObject;
    label47:
    int i;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      if (localQZoneManagerImp == null) {
        break label273;
      }
      k = localQZoneManagerImp.a(1);
      if (localQZoneManagerImp == null) {
        break label279;
      }
      localObject = localQZoneManagerImp.a();
      if (k > 0) {
        break label396;
      }
      if (localQZoneManagerImp == null) {
        break label286;
      }
      i = localQZoneManagerImp.a(2);
      label62:
      if ((i <= 0) || (((String)localObject).length() <= 3)) {
        break label291;
      }
      if (QLog.isColorLevel()) {
        QLog.d(QZoneLogTags.b + "Q.lebatab.leba", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.latestfriend=" + (String)localObject);
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label391;
      }
      localObject = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject);
      if (localObject == null) {
        break label391;
      }
      if (QLog.isColorLevel()) {
        QLog.d(QZoneLogTags.b + "Q.lebatab.leba", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      AccessibilityUtil.a(this.jdField_c_of_type_AndroidViewView, "好友动态 有更新");
      i = 1;
    }
    for (;;)
    {
      CustomWidgetUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, i, k, 0);
      a(this.jdField_b_of_type_AndroidWidgetTextView, i);
      if ((i == 3) && (k > 0)) {
        AccessibilityUtil.a(this.jdField_c_of_type_AndroidViewView, "好友动态 " + k + "条更新");
      }
      return;
      label273:
      k = 0;
      break;
      label279:
      localObject = "";
      break label47;
      label286:
      i = 0;
      break label62;
      label291:
      if (QLog.isColorLevel()) {
        QLog.d(QZoneLogTags.b + "Q.lebatab.leba", 2, "updateQZoneFlag.noflag count=" + i);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d(QZoneLogTags.b + QZoneLogTags.e + "Q.lebatab.leba", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
      }
      label391:
      i = 0;
      continue;
      label396:
      if (QLog.isColorLevel()) {
        QLog.d(QZoneLogTags.b + "Q.lebatab.leba", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + k);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      i = 3;
    }
  }
  
  private void z()
  {
    TroopRedTouchManager localTroopRedTouchManager;
    Object localObject;
    int i;
    int k;
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_d_of_type_AndroidWidgetTextView != null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("XingquBuluo", 4, "updateXingquBuluoRedFlag");
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      localTroopRedTouchManager = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
      localObject = localTroopRedTouchManager.a(7);
      if ((localObject == null) || (!((oidb_0x791.RedDotInfo)localObject).uint32_number.has()) || (((oidb_0x791.RedDotInfo)localObject).uint32_number.get() <= 0)) {
        break label186;
      }
      i = ((oidb_0x791.RedDotInfo)localObject).uint32_number.get();
      k = 3;
    }
    for (;;)
    {
      CustomWidgetUtil.a(this.jdField_d_of_type_AndroidWidgetTextView, k, i, 0);
      a(this.jdField_d_of_type_AndroidWidgetTextView, k);
      a(1);
      if ((AppSetting.j) && (localObject != null))
      {
        if ((k == 3) && (i > 0)) {
          this.jdField_e_of_type_AndroidViewView.setContentDescription("兴趣部落 " + i + "条更新");
        }
      }
      else
      {
        return;
        label186:
        oidb_0x791.RedDotInfo localRedDotInfo2 = localTroopRedTouchManager.a(1);
        if (localRedDotInfo2 != null)
        {
          if ((localRedDotInfo2.uint64_cmd_uin.has()) && (localRedDotInfo2.uint64_cmd_uin.get() > 0L)) {}
          try
          {
            localObject = a().getDrawable(2130838582);
            ThreadManager.a(new lrg(this, localRedDotInfo2, (Drawable)localObject), 5, null, true);
            localObject = localRedDotInfo2;
            i = 0;
            k = 1;
          }
          catch (EmptyStackException localEmptyStackException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Leba", 2, "EmptyStackException");
              }
              localRedDotInfo1 = null;
            }
          }
        }
        oidb_0x791.RedDotInfo localRedDotInfo1 = localTroopRedTouchManager.a(6);
        if (localRedDotInfo1 == null) {
          break label309;
        }
        i = 0;
        k = 1;
        continue;
      }
      this.jdField_e_of_type_AndroidViewView.setContentDescription("兴趣部落 有更新");
      return;
      label309:
      i = 0;
      k = 0;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130903391, null);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected String a()
  {
    return "动态";
  }
  
  public void a()
  {
    if ((LebaShowListManager.a() == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {}
    for (;;)
    {
      return;
      boolean bool = LebaShowListManager.a().a();
      if (bool) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      while (bool != this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = bool;
        BaseApplicationImpl.a.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("has_search_bar", bool).commit();
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
    if (localObject == null) {
      return;
    }
    int i;
    if (((TroopRedTouchManager)localObject).a(7)) {
      i = 7;
    }
    for (;;)
    {
      label30:
      if (paramInt == 0) {}
      for (localObject = "Clk_tribe";; localObject = "exp_tribe")
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "dynamic", (String)localObject, 0, 0, i + "", "", "", "");
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("xingqubuluo", 4, "reportTroopTribe,action=" + (String)localObject + ", appId=" + i);
        return;
        if (((TroopRedTouchManager)localObject).a(6))
        {
          i = 6;
          break label30;
        }
        if (!((TroopRedTouchManager)localObject).a(1)) {
          break label173;
        }
        i = 1;
        break label30;
        if (paramInt != 1) {
          break;
        }
      }
      label173:
      i = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onIconDownload, status=" + paramInt + ", url=" + paramString);
    }
    if ((paramInt != 2) || (paramDrawable == null) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {}
    while ((paramVarArgs[0] == null) || (!(paramVarArgs[0] instanceof Integer))) {
      return;
    }
    paramInt = ((Integer)paramVarArgs[0]).intValue();
    this.jdField_a_of_type_ComTencentImageURLImageView.post(new lri(this, paramInt, paramDrawable));
  }
  
  public void a(View paramView, int paramInt, LebaViewItem paramLebaViewItem)
  {
    LebaViewItem localLebaViewItem;
    if ((paramInt == -1) && (paramLebaViewItem != null)) {
      localLebaViewItem = paramLebaViewItem;
    }
    for (;;)
    {
      if ((localLebaViewItem == null) || (localLebaViewItem.a == null))
      {
        return;
        if (paramInt >= 0) {
          localLebaViewItem = (LebaViewItem)this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.getItem(paramInt);
        }
      }
      else
      {
        Object localObject1 = localLebaViewItem.a.strGotoUrl;
        String str = localLebaViewItem.a.strResName;
        int k = localLebaViewItem.a.sResSubType;
        boolean bool1 = false;
        boolean bool2 = false;
        boolean bool3 = false;
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str + ",url=" + (String)localObject1);
        }
        RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
        BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(localLebaViewItem.a.uiResId + "");
        label392:
        Object localObject2;
        if ((localLebaViewItem.a != null) && (localLebaViewItem.a.uiResId > 0L))
        {
          if (a(localLebaViewItem.a.uiResId)) {
            com.tencent.mobileqq.app.PublicAccountHandler.jdField_c_of_type_JavaLangString = "";
          }
          if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
          {
            bool1 = bool3;
            if (localAppInfo.type.get() == 0) {
              bool1 = true;
            }
            new ArrayList();
            int i = 0;
            paramInt = i;
            if (localAppInfo.red_display_info != null)
            {
              paramInt = i;
              if (localAppInfo.red_display_info.red_type_info != null)
              {
                paramLebaViewItem = localAppInfo.red_display_info.red_type_info.get();
                paramInt = i;
                if (paramLebaViewItem != null)
                {
                  paramInt = i;
                  if (paramLebaViewItem.size() >= 2) {
                    paramInt = ((BusinessInfoCheckUpdate.RedTypeInfo)paramLebaViewItem.get(1)).red_type.get();
                  }
                }
              }
            }
            paramLebaViewItem = "status=" + paramInt + "&number=" + localAppInfo.num.get() + "&path=" + localAppInfo.path.get();
            localObject2 = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
            if (localObject2 == null) {
              break label1981;
            }
            if (((GameCenterManagerImp)localObject2).a(localLebaViewItem.a.uiResId + "") == -1) {
              break label588;
            }
            bool2 = true;
            label450:
            localRedTouchManager.b(localLebaViewItem.a.uiResId + "");
            bool3 = bool2;
            if (bool2) {
              b(new lqr(this));
            }
          }
        }
        label588:
        label1726:
        label1915:
        label1970:
        label1973:
        label1981:
        for (bool3 = bool2;; bool3 = false)
        {
          bool2 = bool3;
          for (;;)
          {
            if ((localObject1 == null) || ("".equals(localObject1)))
            {
              a(localLebaViewItem, localAppInfo, localRedTouchManager);
              return;
              paramLebaViewItem = "status=" + -1 + "&number=0" + "&path=" + localLebaViewItem.a.uiResId;
              bool1 = false;
              break label392;
              bool2 = false;
              break label450;
              if ((localLebaViewItem.a != null) && (localLebaViewItem.a.strPkgName.equals("qzone_feedlist")))
              {
                paramLebaViewItem = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
                bool2 = bool1;
                if (paramLebaViewItem != null) {
                  if (paramLebaViewItem.a(2) <= 0)
                  {
                    bool2 = bool1;
                    if (paramLebaViewItem.a(1) <= 0) {}
                  }
                  else
                  {
                    bool2 = true;
                  }
                }
                bool1 = false;
                paramLebaViewItem = null;
                continue;
              }
              if (localLebaViewItem.a == null) {
                break label1973;
              }
              if (localLebaViewItem.a.isNew == 0) {}
              for (bool1 = true;; bool1 = false)
              {
                bool2 = bool1;
                paramLebaViewItem = null;
                bool1 = false;
                break;
              }
            }
            if (localLebaViewItem.a.cDataType == 0) {
              a(localLebaViewItem, 2131297587, (ViewGroup)paramView);
            }
            if (k == 0)
            {
              if ((((String)localObject1).indexOf("plg_auth=1") > -1) && (((String)localObject1).indexOf("plg_uin=1") <= -1)) {
                break label1970;
              }
              localObject1 = (String)localObject1 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            }
            for (;;)
            {
              paramView = (View)localObject1;
              if (((String)localObject1).indexOf("plg_vkey=1") > -1) {
                paramView = (String)localObject1 + "&mqqvkey=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
              }
              localObject1 = paramView;
              if (a(localLebaViewItem.a.uiResId)) {
                localObject1 = paramView + "&supportPubAccMpPortal=1";
              }
              paramView = new Intent(a(), QQBrowserActivity.class);
              if (((String)localObject1).indexOf("plg_nld=1") > -1) {
                paramView.putExtra("reportNld", true);
              }
              if (!TextUtils.isEmpty(paramLebaViewItem)) {
                paramView.putExtra("redTouch", paramLebaViewItem);
              }
              this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
              paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              paramView.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
              paramView.putExtra("plugin_start_time", System.nanoTime());
              paramView.putExtra("click_start_time", System.currentTimeMillis());
              paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
              paramView.putExtra("is_from_leba", true);
              paramView.putExtra("has_red_dot", bool1);
              paramView.putExtra("url", (String)localObject1);
              if ((localLebaViewItem.a.uiResId == 3053L) && (((String)localObject1).indexOf("fetchCode=1") > -1))
              {
                long l = System.currentTimeMillis() / 1000L;
                if ((this.jdField_a_of_type_WalletAuthCodeItem != null) && (this.jdField_a_of_type_WalletAuthCodeItem.expireTime > l))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_WalletAuthCodeItem.expireTime);
                  }
                  paramView.putExtra("url", URLUtil.a((String)localObject1, "code", this.jdField_a_of_type_WalletAuthCodeItem.authCode));
                  a(paramView);
                  this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                  q();
                  paramView = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
                  if (paramView == null) {
                    break;
                  }
                  paramView.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
                  return;
                }
                this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
                this.jdField_a_of_type_AndroidContentIntent = paramView;
                q();
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
                return;
              }
              a(paramView);
              do
              {
                a(localLebaViewItem, localAppInfo, localRedTouchManager);
                if ((localLebaViewItem.a.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) || (localLebaViewItem.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369269)))) {
                  StatisticCollector.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
                }
                b(new lqs(this));
                if (localLebaViewItem.a.strPkgName.equals("qzone_feedlist")) {
                  break;
                }
                this.jdField_b_of_type_Boolean = true;
                return;
              } while (k != 2);
              localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
              if (localObject1 != null)
              {
                if ((!localLebaViewItem.a.strPkgName.equals("com.tx.gamecenter.android")) && (!localLebaViewItem.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369269)))) {
                  break label1726;
                }
                ((JumpAction)localObject1).c("platformId=qq_m");
              }
              for (;;)
              {
                ((JumpAction)localObject1).a("from_leba", "fromleba");
                ((JumpAction)localObject1).a("config_res_plugin_item_name", str);
                ((JumpAction)localObject1).a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
                ((JumpAction)localObject1).a(bool2);
                ((JumpAction)localObject1).b(localLebaViewItem.a.strPkgName);
                ((JumpAction)localObject1).d(paramLebaViewItem);
                ((JumpAction)localObject1).b(bool1);
                ((JumpAction)localObject1).a(localAppInfo);
                ((JumpAction)localObject1).b();
                if (this.jdField_a_of_type_JavaUtilSet.contains(localLebaViewItem.a.strPkgName)) {
                  this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
                }
                if (!localLebaViewItem.a.strPkgName.equals("qzone_feedlist")) {
                  break;
                }
                StatisticHitRateCollector.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                StatisticHitRateCollector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
                paramView = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
                if (paramView != null)
                {
                  if (QLog.isDevelopLevel()) {
                    QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
                  }
                  paramView.a(true);
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
                break;
                if (localLebaViewItem.a.strPkgName.equals("com.tx.xingqubuluo.android"))
                {
                  paramView = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
                  localObject2 = new StringBuffer();
                  paramInt = paramView.e();
                  if (paramInt > 0) {
                    ((StringBuffer)localObject2).append("redid=" + paramInt);
                  }
                  if (QLog.isDevelopLevel()) {
                    QLog.d("xingqubuluo", 4, "***redid=" + paramInt);
                  }
                  paramInt = paramView.b();
                  if (paramInt > 0) {
                    if (((StringBuffer)localObject2).length() != 0) {
                      break label1915;
                    }
                  }
                  for (paramView = "";; paramView = "&rpnumber=" + paramInt)
                  {
                    ((StringBuffer)localObject2).append(paramView);
                    if (QLog.isDevelopLevel()) {
                      QLog.d("xingqubuluo", 4, "***rpnumber=" + paramInt);
                    }
                    if (((StringBuffer)localObject2).length() <= 0) {
                      break;
                    }
                    ((JumpAction)localObject1).c(((StringBuffer)localObject2).toString());
                    break;
                  }
                }
                if (localLebaViewItem.a.strPkgName.equals("com.read.android")) {
                  ((JumpAction)localObject1).a("ChannelID", "100020");
                }
              }
            }
            bool1 = false;
            paramLebaViewItem = null;
          }
        }
      }
      localLebaViewItem = null;
    }
  }
  
  protected void a(LebaViewItem paramLebaViewItem, BusinessInfoCheckUpdate.AppInfo paramAppInfo, RedTouchManager paramRedTouchManager)
  {
    if ((paramLebaViewItem.a != null) && (paramLebaViewItem.a.uiResId > 0L))
    {
      paramRedTouchManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
      String str = String.valueOf(paramLebaViewItem.a.uiResId);
      if ((paramAppInfo != null) && (paramRedTouchManager != null) && (paramRedTouchManager.a(str))) {
        ThreadManager.a().post(new lqt(this, str, paramAppInfo));
      }
      if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.icon_type.get() == 1)) {
        a(paramAppInfo.icon_url.get());
      }
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + paramLebaViewItem.a.uiResId, "", "", "");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ThreadManager.a(new lqz(this), 5, null, false);
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(System.currentTimeMillis());
    if ((!this.jdField_d_of_type_Boolean) || ((LebaShowListManager.d & 0x4) != 0)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new lrk(this), 100L);
      if (jdField_a_of_type_Boolean != this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = jdField_a_of_type_Boolean;
        int i = 2130840844;
        if (jdField_a_of_type_Boolean) {
          i = 2130840845;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(i);
      }
      A();
      Object localObject;
      if (AppSetting.j)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(a(2131362099));
        localObject = a(2131367541);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131367541));
      }
      if ((PublicAccountConfigUtil.jdField_f_of_type_Boolean) && (PublicAccountConfigUtil.g)) {
        PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      }
      return;
      if (LebaShowListManager.d > 0)
      {
        localObject = new ArrayList();
        LebaUtil.a((List)localObject, LebaShowListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
            u();
          }
        }
        LebaShowListManager.d = 0;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new lrn(this, paramBoolean), 150L);
  }
  
  public boolean b()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.g;
      if (this.g)
      {
        this.g = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.postDelayed(new lqq(this), 1000L);
        return bool2;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
    return bool2;
  }
  
  public void c()
  {
    s();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProxyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
  }
  
  protected void d()
  {
    super.d();
    r();
    E();
    ((ViewStub)a(2131298405)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131297685)).setOnFirstDrawListener(this);
    this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void e()
  {
    super.e();
    WebProcessManager.c(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    NearbyProcessMonitor.c(0);
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProxyObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
    }
    super.f();
  }
  
  public void i()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new lqm(this));
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.a(new lro(this), 10, null, false);
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.e();
    }
  }
  
  public void m()
  {
    Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    int k;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        k = 0;
        int i = k;
        if (k == -1)
        {
          localAppInfo = ((RedTouchManager)localObject).a("886.100171");
          i = k;
          if (localAppInfo != null)
          {
            i = k;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              i = k;
              if (localAppInfo.type.get() != -1) {
                i = 1;
              }
            }
          }
        }
        k = i;
        if (i == -1)
        {
          localObject = ((RedTouchManager)localObject).a("886.100172");
          k = i;
          if (localObject != null)
          {
            k = i;
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
            {
              k = i;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1) {
                k = 2;
              }
            }
          }
        }
        if (k != -1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, k + "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "ReportTroopAndActivityStatics, redDotFrom=" + k);
      }
      return;
      k = -1;
      break;
      k = -1;
    }
  }
  
  void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null) {}
    label65:
    ThemeBackground localThemeBackground2;
    label131:
    label133:
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getTag() instanceof ThemeBackground)) {}
        for (ThemeBackground localThemeBackground1 = (ThemeBackground)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getTag();; localThemeBackground1 = null)
        {
          if (ThemeBackground.getThemeBackgroundEnable()) {
            break label65;
          }
          if (localThemeBackground1 == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setContentBackground(null, false);
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setTag(null);
          return;
        }
        if (localThemeBackground1 != null) {}
        for (localThemeBackground2 = localThemeBackground1;; localThemeBackground2 = new ThemeBackground())
        {
          if (!ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getContext(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localThemeBackground2)) {
            break label131;
          }
          if (!"null".equals(localThemeBackground2.path)) {
            break label133;
          }
          if (localThemeBackground1 == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setContentBackground(null, false);
          return;
        }
      }
    } while (localThemeBackground2.img == null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setContentBackground(localThemeBackground2.img, false);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setTag(localThemeBackground2);
  }
  
  public void o()
  {
    n();
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(a().getColor(2131428295));
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(a().getColor(2131428295));
    }
  }
  
  public void onClick(View paramView)
  {
    if (!b()) {}
    long l1;
    long l2;
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131297183: 
      case 2131297392: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
        LebaShowListManager.a().jdField_a_of_type_Boolean = true;
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("100600");
        a(new Intent(a(), LebaListMgrActivity.class));
        return;
      case 2131301813: 
        paramView = (LebaViewItem)LebaShowListManager.a().jdField_a_of_type_JavaUtilHashMap.get("qzone_feedlist");
        QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
        ThreadManager.a(new lrf(this, paramView), 8, null, true);
        AccessibilityUtil.a(this.jdField_c_of_type_AndroidViewView, "好友动态");
        return;
      case 2131301818: 
        AccessibilityUtil.a(this.jdField_d_of_type_AndroidViewView, "附近");
        l1 = System.currentTimeMillis();
        l2 = Math.abs(l1 - jdField_b_of_type_Long);
      }
    } while ((l2 >= 0L) && (l2 < 2000L));
    jdField_b_of_type_Long = l1;
    Object localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject1).a(String.valueOf(100510));
    ((RedTouchManager)localObject1).b(String.valueOf(100510));
    ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).b(100510);
    LebaShowListManager.d |= 0x1;
    AccessibilityUtil.a(this.jdField_d_of_type_AndroidViewView, "附近");
    paramView = ((RedTouchManager)localObject1).a("100510.100517");
    int i;
    if (paramView.buffer.has())
    {
      paramView = paramView.buffer.get();
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "god buffer: " + paramView);
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label618;
      }
      i = 1;
    }
    for (;;)
    {
      ((RedTouchManager)localObject1).b("100510.100517");
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localAppInfo.iNewFlag.has())
      {
        bool1 = bool2;
        if (localAppInfo.iNewFlag.get() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
          }
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
          bool1 = true;
        }
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      NearbyProcessMonitor.b(0);
      if (!NearbySPUtil.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
      {
        localObject1 = new Intent(a(), NearbyActivity.class);
        ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
        ((Intent)localObject1).putExtra("IS_HAS_REDTOUCH", bool1);
        ((Intent)localObject1).putExtra("FROM_WHERE", 0);
        ((Intent)localObject1).putExtra("RANK_BANNER_PUSH", paramView);
        ((Intent)localObject1).putExtra("IS_HAS_ICON", i);
        NearbyFakeActivity.a(a(), (Intent)localObject1);
        ((SenseWhereManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125)).e();
        return;
        paramView = "";
        break;
        label618:
        if ((!localAppInfo.red_display_info.has()) || (!localAppInfo.red_display_info.red_type_info.has())) {
          break label880;
        }
        Object localObject2 = localAppInfo.red_display_info.red_type_info.get();
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label880;
        }
        localObject2 = ((List)localObject2).iterator();
        i = 2;
        label680:
        if (!((Iterator)localObject2).hasNext()) {
          break label877;
        }
        if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject2).next()).red_type.get() != 3) {
          break label874;
        }
        i = 1;
      }
      label874:
      for (;;)
      {
        break label680;
        localObject1 = new Intent(a(), NearbyGuideActivity.class);
        ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
        ((Intent)localObject1).putExtra("IS_HAS_REDTOUCH", bool1);
        ((Intent)localObject1).putExtra("FROM_WHERE", 0);
        ((Intent)localObject1).putExtra("RANK_BANNER_PUSH", paramView);
        ((Intent)localObject1).putExtra("IS_HAS_ICON", i);
        a().startActivity((Intent)localObject1);
        break;
        AccessibilityUtil.a(this.jdField_e_of_type_AndroidViewView, "兴趣部落");
        paramView = (LebaViewItem)LebaShowListManager.a().jdField_a_of_type_JavaUtilHashMap.get("com.tx.xingqubuluo.android");
        C();
        a(null, -1, paramView);
        a(0);
        D();
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
        return;
      }
      label877:
      continue;
      label880:
      i = 2;
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    c();
    if (!this.jdField_d_of_type_Boolean) {
      a(true);
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      QZoneManager localQZoneManager = (QZoneManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      if (localQZoneManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localQZoneManager.b(3);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
      }
    }
  }
  
  public void q()
  {
    AuthCodeReq localAuthCodeReq = new AuthCodeReq();
    localAuthCodeReq.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    localAuthCodeReq.skey = "";
    localAuthCodeReq.apps = new ArrayList();
    localAuthCodeReq.apps.add(Long.valueOf(100273020L));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
    ((QWalletAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(42)).a(localAuthCodeReq);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  protected void z_()
  {
    super.z_();
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    LebaShowListManager.a().a();
    u();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\Leba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */