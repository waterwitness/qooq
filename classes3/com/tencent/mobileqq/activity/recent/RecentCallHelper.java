package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.config.Common;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.PstnUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.CallRedDotLightalkLis;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.widget.GuideViewBuilder;
import com.tencent.mobileqq.widget.GuideViewBuilder.GuideLayoutParams;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.ListView.FixedViewInfo;
import com.tencent.widget.OverScrollViewListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import oww;
import owx;
import owy;
import owz;
import oxa;
import oxb;
import oxc;
import oxd;
import oxe;
import oxg;
import oxh;
import oxi;
import oxj;
import oxk;
import oxl;
import oxm;
import oxn;
import oxo;
import oxp;

public class RecentCallHelper
{
  public static final int a = 1;
  public static final String a = "RecentCallHelper";
  public static final boolean a = true;
  public static final int b = 2;
  public static final String b = "-";
  public static final int c = 3;
  public static final int d = 4;
  private long jdField_a_of_type_Long;
  protected Handler.Callback a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub.OnInflateListener jdField_a_of_type_AndroidViewViewStub$OnInflateListener;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnonymousEntranceView jdField_a_of_type_ComTencentMobileqqActivityRecentAnonymousEntranceView;
  private LocalSearchBar jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar;
  public RecentAdapter a;
  private RecommendAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter;
  private RecommendCallHelper jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper;
  public BaseActivity a;
  public QQAppInterface a;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private CallRedDotLightalkLis jdField_a_of_type_ComTencentMobileqqJumplightalkCallRedDotLightalkLis;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver;
  private PstnManager jdField_a_of_type_ComTencentMobileqqQcallPstnManager;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground;
  private RedDotRadioButton jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public MqqHandler a;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean;
  boolean g;
  public boolean h;
  public boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  
  public RecentCallHelper(QQAppInterface paramQQAppInterface, View paramView1, View paramView2, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, ViewStub.OnInflateListener paramOnInflateListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
    this.l = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.n = true;
    this.g = false;
    this.jdField_e_of_type_Int = 300;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqJumplightalkCallRedDotLightalkLis = new oww(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new oxi(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new oxj(this);
    this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView1.findViewById(2131297786));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetRadioGroup);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_a_of_type_AndroidWidgetRadioGroup.findViewById(2131297788));
    if (AppSetting.j)
    {
      paramView1 = this.jdField_a_of_type_AndroidWidgetRadioGroup.findViewById(2131297787);
      paramView1.setContentDescription("消息 标签");
      paramView1.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setContentDescription("电话 标签");
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setFocusable(true);
    }
    this.jdField_f_of_type_Int = SharedPreUtils.f(BaseApplication.getContext());
    a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCallRedDotLightalkLis);
    this.i = (BaseApplicationImpl.getContext().getSharedPreferences("call_tab_lightalk_red_dot", 0).getBoolean("show_reddot", true) | this.i);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ThreadManager.a(new oxk(this), 5, null, true);
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView2.findViewById(2131297396));
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewViewStub.setLayoutResource(2130904127);
      this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(paramOnInflateListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      return;
      this.q = true;
      this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener = paramOnInflateListener;
      this.jdField_b_of_type_AndroidViewView = paramView2.findViewById(2131301494);
    }
  }
  
  public RecentCallHelper(QQAppInterface paramQQAppInterface, View paramView, ViewStub.OnInflateListener paramOnInflateListener)
  {
    this.jdField_b_of_type_Boolean = true;
    this.l = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.n = true;
    this.g = false;
    this.jdField_e_of_type_Int = 300;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqJumplightalkCallRedDotLightalkLis = new oww(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new oxi(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new oxj(this);
    this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    this.jdField_f_of_type_Int = SharedPreUtils.f(localBaseApplication);
    this.o = SharedPreUtils.a(localBaseApplication, paramQQAppInterface.a(), this.jdField_f_of_type_Int, "acount_uin_first_use_app");
    this.m = this.o;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131297396));
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewViewStub.setLayoutResource(2130904127);
      this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(paramOnInflateListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      return;
      this.q = true;
      this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener = paramOnInflateListener;
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131301494);
    }
  }
  
  private RecentCallItem a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    return (RecentCallItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      PhoneContactSelectActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false, 1400);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, RecentT9SearchActivity.class);
        localIntent.putExtra("key_is_from_try", false);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130968592, 2130968589);
        return;
      }
    } while (paramInt != 3);
    PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 17);
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.h) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    Object localObject2 = ((PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((localObject2 != null) && ((((PstnCardInfo)localObject2).pstn_ever_c2c_vip == 1) || (((PstnCardInfo)localObject2).pstn_ever_multi_vip == 1))) {}
    for (int i1 = 1;; i1 = 0)
    {
      FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      if ((localObject1 == null) || (((SharedPreferences)localObject1).getBoolean("show_pstn_vip_guide_new_flag", false)) || (i1 == 0) || (FrameHelperActivity.a())) {
        break;
      }
      ((SharedPreferences)localObject1).edit().putBoolean("show_pstn_vip_guide_new_flag", true).commit();
      paramView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localObject1 = new GuideViewBuilder(paramContext);
      ((GuideViewBuilder)localObject1).a(paramView.findViewById(2131301490), 1);
      ((GuideViewBuilder)localObject1).a(1, new owx(this, (GuideViewBuilder)localObject1));
      ((GuideViewBuilder)localObject1).a(paramView.findViewById(2131301491), 2);
      ((GuideViewBuilder)localObject1).a(2, new owy(this, (GuideViewBuilder)localObject1));
      localObject2 = paramContext.getResources().getDisplayMetrics();
      paramContext = View.inflate(paramContext, 2130904130, null);
      Object localObject3 = (Button)paramContext.findViewById(2131301503);
      if (localObject3 != null) {
        ((Button)localObject3).setOnClickListener(new owz(this, (GuideViewBuilder)localObject1));
      }
      localObject3 = new GuideViewBuilder.GuideLayoutParams(-2, -2, 48);
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      ((GuideViewBuilder.GuideLayoutParams)localObject3).c = ((((DisplayMetrics)localObject2).widthPixels - (int)(228.0F * ((DisplayMetrics)localObject2).density)) / 2 - arrayOfInt[0]);
      i1 = paramView.getMeasuredHeight();
      ((GuideViewBuilder.GuideLayoutParams)localObject3).d = ((int)(((DisplayMetrics)localObject2).density * 15.0F) + i1);
      ((GuideViewBuilder)localObject1).a(1, paramContext, (GuideViewBuilder.GuideLayoutParams)localObject3);
      ((GuideViewBuilder)localObject1).a(new oxa(this), false);
      return;
    }
  }
  
  private void a(BaseActivity paramBaseActivity, OverScrollViewListener paramOverScrollViewListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "initDelay");
    }
    if ((paramBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallHelper", 2, "initDelay invalid parameter!");
      }
      return;
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903499, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(paramOverScrollViewListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localLayoutInflater.inflate(2130903159, null));
    paramOverScrollViewListener = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131297399);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new oxd(this, paramBaseActivity));
    paramOverScrollViewListener.setOnClickListener(new oxe(this));
    paramOverScrollViewListener.setContentDescription("关闭");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localLayoutInflater.inflate(2130903160, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramBaseActivity = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297401);
    paramBaseActivity.setOnClickListener(new oxg(this));
    paramBaseActivity.setContentDescription("关闭");
    if (!this.p) {
      f();
    }
    if (QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      b(QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    this.r = true;
  }
  
  private void a(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    if (paramBoolean)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)paramQQAppInterface.a(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.d(paramQQAppInterface.a(), (byte)0);
      }
      a(paramMqqHandler, 60000L);
      return;
    }
    a(paramMqqHandler, 800L);
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap(40);
    }
    for (;;)
    {
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        RecentCallItem localRecentCallItem = (RecentCallItem)paramList.get(i1);
        if (localRecentCallItem != null)
        {
          String str = localRecentCallItem.a() + "-" + localRecentCallItem.a();
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localRecentCallItem);
        }
        i1 += 1;
      }
      break;
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  private void b(Context paramContext, View paramView)
  {
    if (this.h) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    Object localObject2 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    Object localObject3 = ((PstnManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((localObject3 != null) && ((((PstnCardInfo)localObject3).pstn_ever_c2c_vip == 1) || (((PstnCardInfo)localObject3).pstn_ever_multi_vip == 1))) {}
    for (int i1 = 1;; i1 = 0)
    {
      FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      if ((localObject1 == null) || (((SharedPreferences)localObject1).getBoolean("show_pstn_vip_guide_flag", false)) || (i1 != 0) || ((((PstnManager)localObject2).b() != 1) && (((PstnManager)localObject2).c() != 1)) || (FrameHelperActivity.a())) {
        break;
      }
      ((SharedPreferences)localObject1).edit().putBoolean("show_pstn_vip_guide_flag", true).commit();
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      localObject1 = new GuideViewBuilder(paramContext);
      ((GuideViewBuilder)localObject1).a(paramView, 1);
      ((GuideViewBuilder)localObject1).a(1, new oxb(this));
      localObject2 = paramContext.getResources().getDisplayMetrics();
      paramContext = new View(paramContext);
      paramContext.setBackgroundResource(2130839197);
      localObject3 = new GuideViewBuilder.GuideLayoutParams((int)(((DisplayMetrics)localObject2).density * 190.0F), (int)(103.0F * ((DisplayMetrics)localObject2).density), 48);
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      ((GuideViewBuilder.GuideLayoutParams)localObject3).c = ((((DisplayMetrics)localObject2).widthPixels - (int)(((DisplayMetrics)localObject2).density * 190.0F)) / 2 - arrayOfInt[0]);
      i1 = paramView.getMeasuredHeight();
      ((GuideViewBuilder.GuideLayoutParams)localObject3).d = ((int)(((DisplayMetrics)localObject2).density * 5.0F) + i1);
      ((GuideViewBuilder)localObject1).a(1, paramContext, (GuideViewBuilder.GuideLayoutParams)localObject3);
      ((GuideViewBuilder)localObject1).a(new oxc(this));
      return;
    }
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (paramString != null) && (paramString.length() > 0))
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297400);
      if (localTextView != null)
      {
        localTextView.setText(paramString);
        localTextView.setContentDescription(paramString);
      }
      if (!this.k) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.k = true;
    }
  }
  
  private boolean c()
  {
    PstnCardInfo localPstnCardInfo = ((PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localPstnCardInfo != null) {
      if (localPstnCardInfo.pstn_ever_c2c_vip != 1)
      {
        bool1 = bool2;
        if (localPstnCardInfo.pstn_ever_multi_vip != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Animation localAnimation1 = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968608);
      Animation localAnimation2 = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968609);
      Animation localAnimation3 = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968610);
      Animation localAnimation4 = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968606);
      Animation localAnimation5 = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968607);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimation1);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localAnimation2);
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(localAnimation3);
      this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(localAnimation4);
      this.jdField_e_of_type_AndroidWidgetImageView.startAnimation(localAnimation5);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("RecentCallHelper", 2, "playStarAnimation", localException);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_d_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    return;
  }
  
  private void o()
  {
    QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, "");
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.k = false;
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.indexOfChild(this.jdField_a_of_type_AndroidWidgetLinearLayout) != -1))
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup != null) {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.check(2131297787);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(Context paramContext)
  {
    Object localObject1;
    Object localObject2;
    if ((!this.p) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.p = true;
      g();
      localObject1 = LightTalkTipsData.a();
      localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131297398);
      ((TextView)localObject2).setText(((LightTalkTipsData)localObject1).e);
      ((TextView)localObject2).setContentDescription(((LightTalkTipsData)localObject1).e + "点击进入");
      localObject2 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131297397);
    }
    try
    {
      localObject1 = new BitmapDrawable(paramContext.getResources(), BitmapManager.a(LightTalkTipsData.d));
      paramContext = (Context)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext = (BitmapDrawable)paramContext.getResources().getDrawable(2130840542);
      }
    }
    ((ImageView)localObject2).setImageDrawable(paramContext);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    p();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005812", "0X8005812", 0, 0, "", "", "", "");
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (SharedPreUtils.a(paramContext, paramString, this.jdField_f_of_type_Int, "acount_uin_first_use_app")) {
      SharedPreUtils.a(paramContext, paramString, this.jdField_f_of_type_Int, "acount_uin_first_use_app");
    }
  }
  
  public void a(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshCallList|msg: " + paramMessage);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramMessage = (List)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        if (this.m)
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount() - 1);
          this.m = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.post(new oxm(this));
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("RecentCallHelper", 4, "REFRESH_FLAG_CALL_LIST|" + this.jdField_a_of_type_Long);
      }
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.i("RecentCallHelper", 4, "REFRESH_FLAG_CALL_LIST|call adapter is null");
  }
  
  public void a(BaseActivity paramBaseActivity, ViewStub paramViewStub, View paramView1, QQAppInterface paramQQAppInterface, View paramView2, View paramView3, OverScrollViewListener paramOverScrollViewListener, OnRecentUserOpsListener paramOnRecentUserOpsListener, AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if ((paramViewStub.getLayoutResource() == 2130904127) && (paramView1 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramView1.findViewById(2131301495));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      j();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = new LocalSearchBar(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, paramView2, paramView3, paramBaseActivity, null, 10);
      this.jdField_a_of_type_JavaLangRunnable = new oxo(this, paramBaseActivity, paramOverScrollViewListener);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(paramBaseActivity, paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, paramOnRecentUserOpsListener, 4);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(paramOnScrollListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper = new RecommendCallHelper(paramQQAppInterface, paramView2, paramOnRecentUserOpsListener, new oxp(this, paramBaseActivity));
      paramBaseActivity = new Message();
      paramBaseActivity.what = 4;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramBaseActivity);
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallHelper", 2, "onInflate end");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.i = SharedPreUtils.a(paramQQAppInterface.getApplication(), paramQQAppInterface.a(), this.jdField_f_of_type_Int, "acount_uin_first_use_app");
    a(this.i);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "setVisibility|visibility: " + paramInt + ", forceRecommend: " + paramBoolean);
    }
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(paramInt);
      if (!this.l) {
        break label291;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(paramInt);
        if (paramInt == 8) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.N();
        }
      }
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.isChecked()))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004C0B", "0X8004C0B", 0, 0, "", "", "", "");
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
          a(paramQQAppInterface.getApplication(), paramQQAppInterface.a());
        }
        if (paramQQAppInterface.m) {
          a(paramQQAppInterface.getApplication(), paramQQAppInterface.a());
        }
      }
      return;
      if ((this.q) && (this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener != null) && (this.jdField_b_of_type_AndroidViewView != null)) {}
      try
      {
        this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener.onInflate(null, this.jdField_b_of_type_AndroidViewView);
        this.q = false;
        this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener = null;
        if (this.jdField_b_of_type_AndroidViewView == null) {
          break;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("RecentCallHelper", 2, "ViewStub inflate manual error " + localException);
          }
        }
      }
      label291:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a(paramInt);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshData|REFRESH_FLAG_CALL_LIST");
    }
    oxn localoxn;
    if ((paramQQAppInterface != null) && (paramContext != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
    {
      localObject = (QCallFacade)paramQQAppInterface.getManager(37);
      localoxn = new oxn(this, paramQQAppInterface, paramContext, paramMqqHandler);
      if (localObject != null) {
        break label72;
      }
    }
    label72:
    for (Object localObject = null;; localObject = ((QCallFacade)localObject).a(localoxn))
    {
      a(paramQQAppInterface, paramContext, paramMqqHandler, (List)localObject);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, List paramList)
  {
    int i1;
    ArrayList localArrayList;
    int i2;
    label33:
    QCallRecent localQCallRecent;
    RecentCallItem localRecentCallItem;
    if (paramList != null)
    {
      i1 = paramList.size();
      if (i1 <= 0) {
        break label291;
      }
      localArrayList = new ArrayList(30);
      i2 = 0;
      if (i2 >= i1) {
        break label228;
      }
      localQCallRecent = (QCallRecent)paramList.get(i2);
      if ((localQCallRecent != null) && (!TextUtils.isEmpty(localQCallRecent.uin)))
      {
        localRecentCallItem = a(localQCallRecent.uin + "-" + localQCallRecent.type);
        if (localRecentCallItem != null) {
          break label166;
        }
        localRecentCallItem = new RecentCallItem(localQCallRecent);
        label123:
        if (localQCallRecent.type != 1024) {
          break label176;
        }
        if (CrmUtils.b(paramQQAppInterface, localQCallRecent.uin, localQCallRecent.type)) {
          break label198;
        }
      }
    }
    for (;;)
    {
      i2 += 1;
      break label33;
      i1 = 0;
      break;
      label166:
      localRecentCallItem.a(localQCallRecent);
      break label123;
      label176:
      if ((localQCallRecent.type != 9502) || (!TextUtils.isEmpty(localQCallRecent.businessSeId)))
      {
        label198:
        localRecentCallItem.H = localQCallRecent.missedCallCount;
        localRecentCallItem.a(paramQQAppInterface, paramContext);
        localArrayList.add(localRecentCallItem);
      }
    }
    label228:
    a(localArrayList);
    label291:
    for (paramContext = localArrayList;; paramContext = null)
    {
      if ((paramMqqHandler != null) && (paramContext != null) && (paramContext.size() > 0)) {
        paramMqqHandler.obtainMessage(1021, 0, 0, paramContext).sendToTarget();
      }
      do
      {
        return;
        c(paramQQAppInterface);
      } while (paramMqqHandler == null);
      paramMqqHandler.obtainMessage(1021, 0, 0, null).sendToTarget();
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "onAccountChanged");
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.J();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(paramQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a(paramQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.isChecked())) {
      a(paramQQAppInterface);
    }
    this.m = false;
    this.jdField_e_of_type_Int = 300;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if ((paramQQAppInterface != null) && (!paramBoolean))
    {
      this.l = true;
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
        j();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a(8);
      }
    }
    Common.a(BaseApplication.getContext(), "VideoConfigInfo");
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "showRecommendView|visibility: " + paramBoolean1 + ", back: " + paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.l = false;
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.N();
      }
      if (paramQQAppInterface != null)
      {
        QCallFacade localQCallFacade = (QCallFacade)paramQQAppInterface.getManager(37);
        if (localQCallFacade != null) {
          localQCallFacade.a(false);
        }
        c(paramQQAppInterface);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null)
      {
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper;
        if (!paramBoolean1) {
          break label154;
        }
      }
    }
    label154:
    for (int i1 = 0;; i1 = 8)
    {
      paramQQAppInterface.a(i1);
      return;
      this.l = true;
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
      break;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    while ((paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null)) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "updateItem");
    }
    if (this.l) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramString, false);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramString, paramInt);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.H();
    }
  }
  
  protected void a(MqqHandler paramMqqHandler, long paramLong)
  {
    if ((this.jdField_c_of_type_Boolean) && (paramMqqHandler != null))
    {
      paramMqqHandler.removeMessages(1022);
      paramMqqHandler.sendEmptyMessageDelayed(1022, paramLong);
    }
  }
  
  public void a(MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {}
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    a(paramMqqHandler, 800L);
    paramMqqHandler = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 2)
    {
      paramMqqHandler.a(i1);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.a().post(new oxl(this));
    }
    this.m = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "refreshRecommendFriendList isSuccess: " + paramBoolean);
    }
    boolean bool;
    if (!paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a() != null))
      {
        bool = paramBoolean;
        paramString = paramList;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null)
        {
          bool = paramBoolean;
          paramString = paramList;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a())
          {
            bool = true;
            paramString = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a();
          }
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a(bool, paramString);
      }
      return;
      bool = paramBoolean;
      paramString = paramList;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null)
      {
        bool = paramBoolean;
        paramString = paramList;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a())
        {
          bool = paramBoolean;
          paramString = paramList;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
          {
            bool = paramBoolean;
            paramString = paramList;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a() != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a());
              bool = paramBoolean;
              paramString = paramList;
              continue;
              this.jdField_e_of_type_Int = paramInt;
              this.jdField_c_of_type_JavaLangString = paramString;
              if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramList);
              }
              if (this.l)
              {
                bool = paramBoolean;
                paramString = paramList;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
                  bool = paramBoolean;
                  paramString = paramList;
                }
              }
              else
              {
                this.l = false;
                bool = paramBoolean;
                paramString = paramList;
                if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
                  this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.N();
                  bool = paramBoolean;
                  paramString = paramList;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      b(paramString);
      return;
    }
    o();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, MqqHandler paramMqqHandler)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshCallList|mInRecentCallList: " + this.l + ", isListViewIdle: " + paramBoolean1 + ", bImmediate: " + paramBoolean2);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) || (paramMqqHandler == null)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("RecentCallHelper", 4, "refreshCallList|invalidate to refresh");
      }
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        this.jdField_b_of_type_Boolean = false;
        long l1;
        if (paramBoolean2) {
          l1 = 0L;
        }
        while (!paramMqqHandler.hasMessages(16)) {
          if (l1 == 0L)
          {
            paramMqqHandler.sendEmptyMessage(16);
            return;
            l1 = Math.max(2000L - Math.abs(this.jdField_a_of_type_Long - System.currentTimeMillis()), 500L);
          }
          else
          {
            paramMqqHandler.sendEmptyMessageDelayed(16, l1);
            return;
          }
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("RecentCallHelper", 4, "refreshCallList|already has not complete refresh");
      return;
      this.jdField_b_of_type_Boolean = true;
    } while (!QLog.isDevelopLevel());
    QLog.i("RecentCallHelper", 4, "refreshCallList|list scrolling");
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.isShown());
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView, QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    a(paramQQAppInterface, paramMqqHandler, paramBoolean);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup != null) {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.check(2131297788);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {}
    while (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "updateOnlineStatus");
    }
    if ((!this.l) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.d();
    }
  }
  
  void b(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131301513);
    if (paramBoolean)
    {
      this.g = false;
      localView.setBackgroundDrawable(null);
    }
    while (this.g) {
      return;
    }
    this.g = true;
    Drawable localDrawable = BitmapTools.b(BaseApplication.getContext(), 2130838392);
    if (localDrawable != null)
    {
      localView.setBackgroundDrawable(localDrawable);
      return;
    }
    localView.setBackgroundResource(2130838392);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount() == 1);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "onResume|mInRecentCallList: " + this.l);
    }
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {
      QLog.d("lightalktips", 2, "onresume adapter size is " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount());
    }
    if ((!this.l) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.a();
    }
    if (!this.h) {
      c(true);
    }
    if (!this.p) {
      f();
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "send_oidb_0x7d7_0");
    }
    paramQQAppInterface = (RecentCallHandler)paramQQAppInterface.a(45);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int i1;
    do
    {
      return;
      i1 = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).getInt("show_tab_lightalk_tips", 0);
    } while ((i1 < 0) || (i1 >= 3));
    ThreadManager.a(new oxh(this, i1, paramBoolean), 5, null, true);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "onPause|mInRecentCallList: " + this.l);
    }
    if ((!this.l) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.b();
    }
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
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
      try
      {
        Object localObject = Class.forName("com.tencent.widget.ListView").getDeclaredField("mHeaderViewInfos");
        ((Field)localObject).setAccessible(true);
        localObject = ((List)((Field)localObject).get(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)((Iterator)localObject).next();
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(localFixedViewInfo.jdField_a_of_type_AndroidViewView);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper == null) {
          break label178;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentCallHelper", 2, "" + localException);
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.c();
    label178:
    this.jdField_e_of_type_Int = 300;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidViewViewStub = null;
    this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetRadioGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = null;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      break label14;
    }
    label14:
    while (VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 6, true, null) != 0) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    int i1 = ((SharedPreferences)localObject).getInt("funcall_RecentCall_Tipsnum", 0);
    if (i1 < 3)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("funcall_RecentCall_Tipsnum", i1 + 1);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        if (this.j) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.j = true;
        p();
        return;
      }
      if (this.j != true) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.j = false;
      return;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.j = false;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RecentCallHelper", 2, "dismiss funcall bar exception");
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      this.p = false;
    }
  }
  
  public void i()
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.H();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {}
    do
    {
      do
      {
        return;
        if (!ThemeBackground.getThemeBackgroundEnable())
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837959);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (("null".equals(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path)) || (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837959);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void k()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localObject != null) {
        if (localObject == null)
        {
          localObject = null;
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label52;
          }
        }
      }
    }
    label52:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null)
    {
      return;
      localObject = ((QCallFacade)localObject).a();
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.d();
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "WL_DEBUG updateCallRedTouch 1");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallHelper", 2, "WL_DEBUG updateCallRedTouch 2");
      }
      Iterator localIterator = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("101300").red_display_info.red_type_info.get().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((BusinessInfoCheckUpdate.RedTypeInfo)localIterator.next()).red_type.get() != 0);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
      }
      return;
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "WL_DEBUG updatePstnRedTouch 1");
    }
    Object localObject1;
    Object localObject2;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.findViewById(2131301486);
      if (localObject3 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentCallHelper", 2, "WL_DEBUG updatePstnRedTouch 2");
        }
        localObject1 = (RedTouch)((View)localObject3).getTag(2131296482);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject3).a(53).a();
          ((View)localObject3).setTag(2131296482, localObject2);
        }
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentCallHelper", 2, "WL_DEBUG updatePstnRedTouch 3");
          }
          localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("101300.101301");
          str = localAppInfo.buffer.get();
          localObject3 = null;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(str)) {
          continue;
        }
        localObject1 = new JSONObject();
        localObject4 = ((JSONObject)localObject1).optString("_show_mission");
        JSONObject localJSONObject2 = ((JSONObject)localObject1).optJSONObject("msg");
        localObject1 = localObject3;
        if (localJSONObject2 != null) {
          localObject1 = localJSONObject2.optJSONObject((String)localObject4).getString("extinfo");
        }
      }
      catch (Exception localException1)
      {
        Object localObject4;
        localJSONObject1 = null;
        continue;
        localJSONObject1 = new JSONObject(((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.get());
        continue;
      }
      if (localObject1 != null)
      {
        localObject4 = localAppInfo.red_display_info.red_type_info.get().iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject3 = (BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject4).next();
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.get() != 0) {
            continue;
          }
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(4);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set((String)localObject1);
        }
      }
      try
      {
        if (!TextUtils.isEmpty(((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.get())) {
          continue;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("cn", "#fff74c30");
        ((JSONObject)localObject1).put("cr", "white");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set(((JSONObject)localObject1).toString());
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject1;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallHelper", 2, "WL_DEBUG updatePstnRedTouch buffer = " + str);
      }
      ((RedTouch)localObject2).a(localAppInfo);
      return;
      localObject1 = new JSONObject(str);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentCallHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */