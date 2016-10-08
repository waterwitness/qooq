package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.fragment.BaseFragment;
import com.tencent.mobileqq.fragment.FreshNewsFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.fragment.TitlebarStatus;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsManager.NotifyListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import lwb;
import lwc;
import lwd;
import lwe;
import lwf;
import lwg;
import lwh;
import lwi;
import lwj;
import org.json.JSONObject;

public class NearbyActivity
  extends NearbyTitleBarActivity
  implements Handler.Callback, WebUiUtils.WebviewReportSpeedInterface, TabBarView.OnTabChangeListener
{
  public static final String a = "NearbyActivity";
  static final int[] jdField_a_of_type_ArrayOfInt = { 2131368168, 2131372179, 2131371458, 2131370906 };
  public static final String[] a;
  static final String jdField_b_of_type_JavaLangString = "Meizu_M040";
  static final int[] jdField_b_of_type_ArrayOfInt = { 0, 1, 2, 3 };
  static final int jdField_c_of_type_Int = 1;
  static final String jdField_c_of_type_JavaLangString = "Xiaomi_MI 2";
  static final int d = 2;
  public static final String d = "WebSpeedTrace";
  static final int e = 3;
  int jdField_a_of_type_Int = -1;
  public long a;
  public Handler a;
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new lwd(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public NearbyObserver a;
  public DatingObserver a;
  public FreshNewsManager.NotifyListener a;
  public FreshNewsManager a;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  public TabBarView a;
  public ArrayList a;
  lwj jdField_a_of_type_Lwj;
  boolean jdField_a_of_type_Boolean = false;
  public RedTouch[] a;
  public boolean[] a;
  public int b;
  public long b;
  boolean jdField_b_of_type_Boolean = false;
  public long c;
  int[] jdField_c_of_type_ArrayOfInt = { -1, -1, -1, -1 };
  public long d;
  public long e;
  public int f;
  public long f;
  public long g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "100510.100518", "100510.100522", "100510.100512", "100510.10011" };
  }
  
  public NearbyActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new lwg(this);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new lwh(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$NotifyListener = new lwi(this);
  }
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle());
    setIntent(localIntent);
    return localIntent;
  }
  
  public int a()
  {
    return 2130903415;
  }
  
  public long a()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (long l = 0L;; l = localAbsWebView.jdField_c_of_type_Long)
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getmStartLoadUrlMilliTimeStamp", new Object[] { Long.valueOf(l) });
      }
      return l;
    }
  }
  
  public NearbyBaseFragment a(int paramInt)
  {
    return b(this.jdField_c_of_type_ArrayOfInt[paramInt]);
  }
  
  public AbsWebView a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Lwj != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Lwj.a != null) {
        localObject1 = this.jdField_a_of_type_Lwj.a.a;
      }
    }
    return (AbsWebView)localObject1;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("getMyTabAppinfo start", new Object[0]);
    }
    if (FreshNewsManager.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface)) {}
    for (int j = NearbyMineHelper.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 100519) + 0;; j = 0)
    {
      int i = j;
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(0)) {
        i = j + NearbyMineHelper.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 100511);
      }
      j = i;
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(1)) {
        j = i + NearbyMineHelper.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 100517);
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("NearbyActivity", "getMyTabAppinfo", new Object[] { Integer.valueOf(j) });
      }
      String str = jdField_a_of_type_ArrayOfJavaLangString[3];
      if ((j > 0) && (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b(10011))) {
        return NearbyMineHelper.a(5, 10011, str, String.valueOf(j));
      }
      return this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a();
    }
  }
  
  String a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getId();
    long l = this.jdField_a_of_type_Lwj.getItemId(paramInt);
    return "android:switcher:" + i + ":" + l;
  }
  
  public JSONObject a()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView != null) {
      return localAbsWebView.a;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131298514));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131298513));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setEnableRepeatedClick(true);
    if (this.titleRoot != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131297082).findViewById(2131297392));
      this.centerView = ((TextView)this.titleRoot.findViewById(2131297139));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.titleRoot.findViewById(2131297138));
    }
    b();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[jdField_a_of_type_ArrayOfJavaLangString.length];
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[jdField_b_of_type_ArrayOfInt.length];
    int j = 0;
    int k = 0;
    if (j < jdField_b_of_type_ArrayOfInt.length)
    {
      int m = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (j == 1)
      {
        this.jdField_a_of_type_ArrayOfBoolean[j] = ((Boolean)NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "ShowFreshNews", Boolean.valueOf(true))).booleanValue();
        i = k;
        if (this.jdField_a_of_type_ArrayOfBoolean[j] != 0)
        {
          i = k + 1;
          this.jdField_c_of_type_ArrayOfInt[1] = m;
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (j == 2)
        {
          this.jdField_a_of_type_ArrayOfBoolean[j] = ((Boolean)NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "hotchat_tab_switch", Boolean.valueOf(true))).booleanValue();
          i = k;
          if (this.jdField_a_of_type_ArrayOfBoolean[j] != 0)
          {
            i = k + 1;
            this.jdField_c_of_type_ArrayOfInt[2] = m;
            this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
          }
        }
        else if (j == 0)
        {
          i = k + 1;
          this.jdField_a_of_type_ArrayOfBoolean[j] = true;
          this.jdField_c_of_type_ArrayOfInt[0] = m;
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
        }
        else
        {
          i = k;
          if (j == 3)
          {
            i = k + 1;
            this.jdField_a_of_type_ArrayOfBoolean[j] = true;
            this.jdField_c_of_type_ArrayOfInt[3] = m;
            this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
          }
        }
      }
    }
    Object localObject = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).width = (getResources().getDisplayMetrics().widthPixels / k);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabLayoutParams((LinearLayout.LayoutParams)localObject);
    int i = 0;
    while (i < jdField_b_of_type_ArrayOfInt.length)
    {
      if (this.jdField_a_of_type_ArrayOfBoolean[i] != 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(getString(jdField_a_of_type_ArrayOfInt[i]));
        ((RedDotTextView)localObject).setTag(2131303846, Integer.valueOf(jdField_b_of_type_ArrayOfInt[i]));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i] = new RedTouch(this, (View)localObject).a(48).b(NearbyMineHelper.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getApplication(), (TextView)localObject, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView)).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    this.jdField_a_of_type_Lwj = new lwj(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_Lwj);
    j = getIntent().getIntExtra("TAB", this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int);
    i = j;
    if (j < 0) {
      i = 0;
    }
    NearbyFragment.l = i;
    this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = i;
    j = this.jdField_c_of_type_ArrayOfInt[i];
    if (j >= 0) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(j, false);
      if (QLog.isColorLevel()) {
        NearbyUtils.a("MSG_INIT", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int), Integer.valueOf(NearbyFragment.l) });
      }
      if ((this.jdField_a_of_type_ArrayOfBoolean[1] != 0) || (this.jdField_a_of_type_ArrayOfBoolean[2] != 0) || (this.jdField_a_of_type_ArrayOfBoolean[0] != 0)) {
        ThreadManager.a(new lwc(this), 5, null, false);
      }
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 300L);
      }
      return;
      j = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    NearbyBaseFragment localNearbyBaseFragment;
    if (paramInt2 == this.jdField_f_of_type_Int)
    {
      localNearbyBaseFragment = a(this.jdField_f_of_type_Int);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.b();
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("onTabSelected", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem()), Integer.valueOf(this.jdField_f_of_type_Int) });
    }
    if ((this.jdField_b_of_type_Long == 0L) && (((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2)).intValue() == 2))
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "onTabSelected", Long.valueOf(this.jdField_b_of_type_Long) });
      }
    }
    if (this.jdField_f_of_type_Int >= 0)
    {
      localNearbyBaseFragment = a(this.jdField_f_of_type_Int);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.onHiddenChanged(true);
      }
    }
    this.jdField_f_of_type_Int = paramInt2;
    if ((this.jdField_b_of_type_Int < 0) || (paramInt2 != this.jdField_c_of_type_ArrayOfInt[this.jdField_b_of_type_Int]) || (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt2, false);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.a(false);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 1) {
        b(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "0X8005CEA");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.a(true);
    }
  }
  
  public void a(TitlebarStatus paramTitlebarStatus)
  {
    if (paramTitlebarStatus == null) {}
    Object localObject;
    do
    {
      return;
      localObject = a(NearbyBaseFragment.l);
      if (QLog.isColorLevel()) {
        NearbyUtils.a("NearbyActivity", new Object[] { "updateTitlebar", localObject, paramTitlebarStatus.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment });
      }
    } while (localObject != paramTitlebarStatus.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment);
    if (paramTitlebarStatus.jdField_b_of_type_Boolean)
    {
      if (this.centerView.getVisibility() != 0) {
        this.centerView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (!Utils.a(paramTitlebarStatus.jdField_a_of_type_JavaLangString, getTextTitle())) {
        setTitle(paramTitlebarStatus.jdField_a_of_type_JavaLangString);
      }
      label121:
      if (!paramTitlebarStatus.jdField_a_of_type_Boolean) {
        break label388;
      }
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    for (;;)
    {
      if (!paramTitlebarStatus.jdField_c_of_type_Boolean) {
        break label403;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramTitlebarStatus.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.j) && (paramTitlebarStatus.e != null)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramTitlebarStatus.e);
      }
      if (paramTitlebarStatus.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramTitlebarStatus.jdField_a_of_type_Int);
      }
      if (this.rightViewText.getVisibility() == 8) {
        break;
      }
      this.rightViewText.setVisibility(8);
      return;
      if (this.centerView.getVisibility() != 4) {
        this.centerView.setVisibility(4);
      }
      if (!Utils.a(paramTitlebarStatus.jdField_a_of_type_JavaLangString, getTextTitle())) {
        setTitle(paramTitlebarStatus.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (paramTitlebarStatus.jdField_b_of_type_JavaLangString != null)
      {
        localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297829);
        if (!Utils.a(paramTitlebarStatus.jdField_b_of_type_JavaLangString, ((TextView)localObject).getText())) {
          ((TextView)localObject).setText(paramTitlebarStatus.jdField_b_of_type_JavaLangString);
        }
      }
      if (paramTitlebarStatus.jdField_c_of_type_JavaLangString == null) {
        break label121;
      }
      localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297830);
      if (Utils.a(paramTitlebarStatus.jdField_c_of_type_JavaLangString, ((TextView)localObject).getText())) {
        break label121;
      }
      ((TextView)localObject).setText(paramTitlebarStatus.jdField_c_of_type_JavaLangString);
      break label121;
      label388:
      if (isTitleProgressShowing()) {
        stopTitleProgress();
      }
    }
    label403:
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramTitlebarStatus.d)) {
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!Utils.a(paramTitlebarStatus.d, this.rightViewText.getText())) {
        this.rightViewText.setText(paramTitlebarStatus.d);
      }
      this.rightViewText.setOnClickListener(paramTitlebarStatus.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      if (this.rightViewText.getVisibility() != 0) {
        this.rightViewText.setVisibility(0);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView != null) {
      localAbsWebView.a = paramJSONObject;
    }
  }
  
  public boolean a()
  {
    String str = Build.MANUFACTURER + "_" + Build.MODEL;
    return (Build.VERSION.SDK_INT > 10) && (!"Meizu_M040".equals(str));
  }
  
  public int b()
  {
    if ((ThemeUtil.getUserCurrentThemeId(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface).equals("1000")) && (!ThemeUtil.isInNightMode(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyActivity", 2, "default theme daymode,clear decorview background");
      }
      return 0;
    }
    return 2130837958;
  }
  
  public long b()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getmOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) });
    }
    return this.jdField_a_of_type_Long;
  }
  
  public NearbyBaseFragment b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject1 = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(a(paramInt));
      }
    }
    return (NearbyBaseFragment)localObject1;
  }
  
  void b()
  {
    setTitle(2131369273);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("abp_flag", this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("FROM_WHERE", this.jdField_a_of_type_Int);
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == 0))
    {
      setLeftViewName(2131367562);
      return;
    }
    if (this.jdField_a_of_type_Int == 1003)
    {
      setLeftViewName(2131368291);
      return;
    }
    if (this.jdField_a_of_type_Int == 1004)
    {
      setLeftViewName(2131368676);
      return;
    }
    if (this.jdField_a_of_type_Int == 1002)
    {
      setLeftViewName(2131371386);
      return;
    }
    setLeftViewName(getIntent());
  }
  
  public int c()
  {
    int j = 2;
    int i = j;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[3] != null)
    {
      i = j;
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[3].a()) {
        i = 1;
      }
    }
    return i;
  }
  
  public long c()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getmClickTime", new Object[] { Long.valueOf(this.jdField_b_of_type_Long) });
    }
    return this.jdField_b_of_type_Long;
  }
  
  void c()
  {
    ThreadManager.a(new lwe(this), null, true);
  }
  
  public long d()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (long l = 0L;; l = localAbsWebView.c())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getmTimeBeforeLoadUrl", new Object[] { Long.valueOf(l) });
      }
      return l;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ArrayOfBoolean == null) {
      return;
    }
    ThreadManager.a(new lwf(this), null, true);
  }
  
  public boolean d()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (boolean bool = false;; bool = localAbsWebView.f())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "isMainPageUseLocalFile", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NBase", 2, "doOnActivityResult() NearbyActivity");
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    long l = System.currentTimeMillis();
    boolean bool = super.doOnCreate(paramBundle);
    Object localObject2 = getIntent();
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = a();
    }
    paramBundle.setExtrasClassLoader(DatingFilters.class.getClassLoader());
    if (paramBundle == null)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "http://play.mobile.qq.com/play/mqqplay/hotchat/index.html?_wv=1027&_bid=2152";
      }
      if (!Utils.a(localObject2, "http://play.mobile.qq.com/play/mqqplay/hotchat/index.html?_wv=1027&_bid=2152"))
      {
        this.jdField_a_of_type_Int = 1;
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", URLUtil.guessUrl((String)localObject2));
        startActivity((Intent)localObject1);
        finish();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
        break label229;
      }
    }
    label229:
    for (int i = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int;; i = 0)
    {
      if (paramBundle.getIntExtra("TAB", i) == 2)
      {
        this.jdField_b_of_type_Long = paramBundle.getLongExtra("ENTER_TIME", l);
        this.jdField_a_of_type_Long = l;
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.jdField_b_of_type_Long) });
        }
      }
      return bool;
      try
      {
        localObject2 = paramBundle.getStringExtra("url");
        localObject1 = localObject2;
      }
      catch (Throwable paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyActivity", 2, paramBundle.getMessage(), paramBundle);
        }
        paramBundle = a();
      }
      break;
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
      this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$NotifyListener);
      }
      Object localObject = (NearbyReportManager)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(218);
      if (localObject != null)
      {
        ((NearbyReportManager)localObject).a();
        ((NearbyReportManager)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = ViewExposeUtil.a(getClass(), hashCode());
      if (localObject != null)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_b_of_type_Long;
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, Long.toString(l1 - l2), "", "", "");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_b_of_type_Int == 1)
    {
      NearbyBaseFragment localNearbyBaseFragment = a(1);
      if ((localNearbyBaseFragment != null) && ((localNearbyBaseFragment instanceof FreshNewsFragment))) {
        ((FreshNewsFragment)localNearbyBaseFragment).a(paramIntent);
      }
    }
    b();
    int i = paramIntent.getIntExtra("TAB", this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int);
    if (i >= 0)
    {
      int j = this.jdField_c_of_type_ArrayOfInt[i];
      if (j >= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(j, false);
        if (QLog.isColorLevel()) {
          QLog.i("NBase", 2, "doOnNewIntent setSelectedTab:" + i);
        }
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean) {}
    for (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = this.jdField_b_of_type_Int;; this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = 0)
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("Q.nearby", "doOnPause", new Object[] { Boolean.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int) });
      }
      ((DynamicAvatarManager)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(179)).b();
      return;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("NBase", 2, "doOnSaveInstanceState");
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Boolean) && (this.j) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2))) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 200L);
    }
  }
  
  public long e()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getonCreateTime", new Object[] { Long.valueOf(this.jdField_c_of_type_Long) });
    }
    return this.jdField_c_of_type_Long;
  }
  
  public boolean e()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (boolean bool = false;; bool = localAbsWebView.h())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getmPerfFirstLoadTag", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public long f()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getviewInflateTime", new Object[] { Long.valueOf(this.d) });
    }
    return this.d;
  }
  
  public boolean f()
  {
    boolean bool = WebAccelerateHelper.isWebViewCache;
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getisWebViewCache", new Object[] { Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    super.finish();
    if (this.jdField_b_of_type_Boolean) {
      overridePendingTransition(2130968587, 2130968588);
    }
  }
  
  public long g()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getgetWebViewTime", new Object[] { Long.valueOf(this.e) });
    }
    return this.e;
  }
  
  public boolean g()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (boolean bool = false;; bool = localAbsWebView.g())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getIsReloadUrl", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public long h()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getinitBrowserTime", new Object[] { Long.valueOf(this.g) });
    }
    return this.g;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 3: 
      int i;
      BusinessInfoCheckUpdate.AppInfo localAppInfo;
      do
      {
        do
        {
          return false;
          ThreadManager.a(new lwb(this), 8, null, true);
          try
          {
            i = getIntent().getIntExtra("IS_HAS_ICON", 2);
            ViewExposeUtil.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getClass(), hashCode(), "0X80059D6", i);
            return false;
          }
          catch (Throwable paramMessage)
          {
            paramMessage.printStackTrace();
            return false;
          }
          localAppInfo = (BusinessInfoCheckUpdate.AppInfo)paramMessage.obj;
        } while ((localAppInfo == null) || (this.jdField_a_of_type_ArrayOfBoolean == null));
        i = paramMessage.arg1;
      } while ((i >= jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i] == null));
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i].d(NearbyMineHelper.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getApplication(), localAppInfo)).c(1).a(true).a().a(localAppInfo);
      return false;
    }
    c();
    return false;
  }
  
  public long i()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getinitTime", new Object[] { Long.valueOf(this.jdField_f_of_type_Long) });
    }
    return this.jdField_f_of_type_Long;
  }
  
  public long j()
  {
    return 0L;
  }
  
  public long k()
  {
    return 0L;
  }
  
  public long l()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (long l = 0L;; l = localAbsWebView.a())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getOpenUrlAfterCheckOfflineTime", new Object[] { Long.valueOf(l) });
      }
      return l;
    }
  }
  
  public long m()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (long l = 0L;; l = localAbsWebView.b())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getReadIndexFromOfflineTime", new Object[] { Long.valueOf(l) });
      }
      return l;
    }
  }
  
  public long n()
  {
    return 0L;
  }
  
  protected boolean onBackEvent()
  {
    Object localObject;
    if (this.jdField_f_of_type_Int >= 0)
    {
      localObject = b(this.jdField_f_of_type_Int);
      if ((localObject != null) && (((BaseFragment)localObject).a())) {
        return false;
      }
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 0))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("main_tab_id", 4);
      ((Intent)localObject).setFlags(603979776);
      startActivity((Intent)localObject);
    }
    return super.onBackEvent();
  }
  
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.vg.setLayerType(0, null);
    }
  }
  
  protected String setLastActivityName()
  {
    if (this.jdField_b_of_type_Int == 2) {
      return getString(2131367541);
    }
    return super.setLastActivityName();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\NearbyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */