package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import ieg;
import ieh;
import iei;
import iej;
import iek;
import iel;
import ien;
import ieo;
import iep;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

public class SubscriptRecommendController
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  public static final String b = "come_from";
  public static final int c = 0;
  public static final String c = "start_time";
  public static final int d = 1;
  public static final String d = "has_red_hot";
  public static final int e = 2;
  public static final String e = "red_hot_count";
  public static final int f = 3;
  public View a;
  public ViewStub a;
  public ImageButton a;
  private SubscriptObserver jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver = new ieg(this);
  SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  SubscriptRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new ieh(this);
  public QQAppInterface a;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  public WeakReference a;
  public boolean a;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  private int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SubscriptRecommendController.class.getSimpleName();
  }
  
  public SubscriptRecommendController(Activity paramActivity, QQAppInterface paramQQAppInterface, SubscriptPicManager paramSubscriptPicManager)
  {
    this.jdField_a_of_type_AndroidViewViewStub = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = paramSubscriptPicManager;
    this.j = ((int)paramActivity.getResources().getDimension(2131494176));
    i();
    ThreadManager.b().post(new iei(this));
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("subscribe_version" + paramQQAppInterface.a(), 0);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getString("subscirpt_full_recommend_url", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(str, 0).edit();
    paramQQAppInterface.putBoolean("is_show_subscript_recommend" + str, true);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    localEditor.putInt("subscribe_version" + paramQQAppInterface.a(), paramInt);
    localEditor.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    String str = paramQQAppInterface.a();
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences(str, 0).edit();
    localEditor.putBoolean("is_show_subscribe_red_point" + str, true);
    localEditor.putBoolean("is_show_subscribe_folder_red_dot" + str, true);
    localEditor.putInt("pa_subscribe_config_show" + str, paramInt);
    localEditor.putString("pa_subscribe_config_msg" + str, paramString);
    localEditor.commit();
    paramString = TroopBarAssistantManager.a();
    paramString.a(paramQQAppInterface, false);
    paramString.b(paramQQAppInterface, true);
    paramString.c(paramQQAppInterface, true);
    paramString.d(paramQQAppInterface, true);
    paramString.b(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    paramQQAppInterface.putBoolean("subscript_inner_recommend", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    paramAppInterface = paramAppInterface.a().getSharedPreferences(paramAppInterface.a(), 4).edit();
    paramAppInterface.putBoolean("subscript_full_recommend", paramBoolean);
    paramAppInterface.putString("subscirpt_full_recommend_url", paramString);
    return paramAppInterface.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    boolean bool1 = bool2;
    if (paramQQAppInterface.getBoolean("subscript_inner_recommend", false))
    {
      bool1 = bool2;
      if (!paramQQAppInterface.getBoolean("subscript_full_recommend", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("subscript_full_recommend_version" + paramQQAppInterface.a(), -1);
  }
  
  public static String b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getString("pa_subscribe_config_msg" + paramQQAppInterface.a(), "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    localEditor.putInt("subscript_full_recommend_version" + paramQQAppInterface.a(), paramInt);
    localEditor.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    localEditor.putBoolean("is_show_subscribe_red_point" + paramQQAppInterface.a(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("subscript_full_recommend", false);
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("subscript_inner_recommend_version" + paramQQAppInterface.a(), -1);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    localEditor.putInt("subscript_inner_recommend_version" + paramQQAppInterface.a(), paramInt);
    localEditor.commit();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    localEditor.putBoolean("is_show_subscribe_folder_red_dot" + paramQQAppInterface.a(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return (paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("is_show_subscribe_red_point" + paramQQAppInterface.a(), true)) && (f(paramQQAppInterface));
  }
  
  public static void d(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    localEditor.putInt("pa_subscribe_config_show" + paramQQAppInterface.a(), paramInt);
    localEditor.commit();
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    paramQQAppInterface.putBoolean("subscribe_discovery_btn", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("pa_subscribe_config_show" + paramQQAppInterface.a(), 1) != 0;
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("is_show_subscribe_folder_red_dot" + paramQQAppInterface.a(), true);
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("subscribe_discovery_btn", true);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver);
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewViewStub == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968721);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new ieo(this));
    a(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
  }
  
  void a()
  {
    this.g = 1;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewStub == null) {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131299879));
        if (this.jdField_a_of_type_AndroidViewViewStub != null)
        {
          this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(new iej(this));
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          b();
          h();
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
      return;
      e();
      a(this.j);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    View localView;
    do
    {
      return;
      localView = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131297845);
    } while (localView == null);
    localView.setPadding(0, 0, 0, paramInt);
  }
  
  public void a(View paramView)
  {
    this.g = 3;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((SubscriptHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(64)).a(paramString);
    }
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter = new SubscriptRecommendAdapter((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.a();
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.a(paramList);
  }
  
  public boolean a()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null) {
      return false;
    }
    View localView = localActivity.findViewById(2131300556);
    WindowManager localWindowManager = (WindowManager)localActivity.getSystemService("window");
    int k = localWindowManager.getDefaultDisplay().getWidth();
    int m = localWindowManager.getDefaultDisplay().getHeight();
    int n = (int)localActivity.getResources().getDimension(2131492908);
    int i1 = (int)localActivity.getResources().getDimension(2131492910);
    int i2 = this.j;
    int i3 = localView.getHeight();
    int i4 = localView.getWidth();
    int i5 = ImmersiveUtils.a(localActivity);
    if ((k < i4) || (m - (n + i1 + i2) - i5 < i3)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject1 = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources();
    if (bool)
    {
      k = 2131427869;
      k = ((Resources)localObject1).getColor(k);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(k);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new iek(this));
      Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300009);
      if (localObject2 != null)
      {
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label262;
        }
        k = 2131427731;
        label93:
        ((ImageView)localObject2).setBackgroundResource(k);
      }
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297123);
      if (!bool) {
        break label269;
      }
      k = ((Resources)localObject1).getColor(2131427871);
      label125:
      ((TextView)localObject2).setTextColor(k);
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null)
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300010));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth((int)((Resources)localObject1).getDimension(2131494177));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter);
        if (Build.VERSION.SDK_INT >= 9) {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131296906));
        localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
        if (bool) {
          break label280;
        }
      }
    }
    label262:
    label269:
    label280:
    for (int k = 2130839543;; k = 2130839545)
    {
      ((ImageButton)localObject1).setImageResource(k);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new iel(this));
      return;
      k = 2131427864;
      break;
      k = 2131427642;
      break label93;
      k = ((Resources)localObject1).getColor(2131427870);
      break label125;
    }
  }
  
  public void c()
  {
    if (a())
    {
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    int k = DisplayUtil.a((Context)localObject, 100.0F);
    Object localObject = (ImageView)((Activity)localObject).findViewById(2131300557);
    this.h = ((ImageView)localObject).getHeight();
    this.i = ((ImageView)localObject).getWidth();
    ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(k, k));
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewViewStub == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968722);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new ien(this));
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
  }
  
  public void f()
  {
    j();
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.b();
    }
  }
  
  public void g()
  {
    ThreadManager.b().post(new iep(this));
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.notifyDataSetChanged();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "scriptRecommendAdapter is null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptRecommendController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */