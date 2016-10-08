package com.tencent.mobileqq.freshnews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyFragmentActivity;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SegmentedControlView;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;
import srb;
import src;

public class MyFreshNewsActivity
  extends NearbyFragmentActivity
  implements View.OnClickListener
{
  public static final int a = 10;
  public static final String a = "param_which_fragment";
  public static final int b = 11;
  public static final String b = "parm_mode";
  public static final int c = 10;
  public static final String c = "param_guest_nick";
  public static final int d = 11;
  public static final String d = "param_guest_tinyid";
  public static final int e = 22;
  public static final String e = "param_guest_uin";
  public static final int f = 220;
  long jdField_a_of_type_Long;
  Intent jdField_a_of_type_AndroidContentIntent;
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  public ProgressBar a;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FreshNewsNotifyFragment jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment;
  MyFreshNewsFragment jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment;
  public NearbyAppInterface a;
  RedDotRadioButton jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  SegmentedControlView jdField_a_of_type_ComTencentWidgetSegmentedControlView;
  boolean jdField_a_of_type_Boolean;
  TextView b;
  String f;
  int jdField_g_of_type_Int;
  String jdField_g_of_type_JavaLangString;
  int h;
  
  public MyFreshNewsActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_g_of_type_Int = 10;
    this.h = 10;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment = null;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = ((SegmentedControlView)findViewById(2131301725));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131301726));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)findViewById(2131301727));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301723));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131297446));
    this.b = ((TextView)findViewById(2131301724));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("返回");
    if (this.jdField_g_of_type_Int == 10)
    {
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(0);
      this.b.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(8);
    this.b.setVisibility(0);
    if (!TextUtils.isEmpty(this.f))
    {
      this.b.setText(new QQText(this.f, 3, 16));
      return;
    }
    this.b.setText("Ta的新鲜事");
  }
  
  void a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("MyFreshNewsActivity.setCurrFragment:");
      if (paramInt != 11) {
        break label51;
      }
    }
    label51:
    for (String str = "NOTIFY";; str = "MINE")
    {
      QLog.d("FreshNews", 2, str);
      if (this.h != paramInt) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment = new MyFreshNewsFragment();
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment.a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment = new FreshNewsNotifyFragment();
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 10: 
      a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment, this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment);
      this.h = 10;
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment);
    this.h = 11;
  }
  
  void a(Fragment paramFragment1, Fragment paramFragment2)
  {
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    if (!paramFragment2.isAdded()) {
      localFragmentTransaction.hide(paramFragment1).add(2131297013, paramFragment2);
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("FreshNews", 2, "MyFreshNewsActivity, ft.commit()");
        }
        localFragmentTransaction.commit();
        return;
      }
      catch (Exception paramFragment1)
      {
        paramFragment1.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FreshNews", 2, "MyFreshNewsActivity, ft.commitAllowingStateLoss()");
        localFragmentTransaction.commitAllowingStateLoss();
      }
      localFragmentTransaction.hide(paramFragment1).show(paramFragment2);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews", 2, "MyFreshNewsActivity showJuhua");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FreshNews", 2, paramString.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(paramBoolean);
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment = new MyFreshNewsFragment();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment = new FreshNewsNotifyFragment();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    int i = getIntent().getIntExtra("param_which_fragment", 10);
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    if (10 == i)
    {
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.check(2131301726);
      localFragmentTransaction.add(2131297013, this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsFragment);
      this.h = 10;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X8005CEB", "0X8005CEB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localFragmentTransaction.commit();
      return;
      if (11 == i)
      {
        this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.check(2131301727);
        localFragmentTransaction.add(2131297013, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyFragment);
        this.h = 11;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X8005CEC", "0X8005CEC", 0, 0, "", "", "", "");
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    src localsrc = new src(this, paramBoolean);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      runOnUiThread(localsrc);
      return;
    }
    localsrc.run();
  }
  
  void c()
  {
    ThreadManager.a().post(new srb(this));
  }
  
  public void d()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      View localView = LayoutInflater.from(this).inflate(2130904178, null, false);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.a(this), 0, 0);
      setContentView(localView);
      return;
    }
    setContentView(2130904178);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    d();
    getWindow().getDecorView().getRootView().setBackgroundResource(2130837958);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("parm_mode", 10);
      this.f = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_guest_nick");
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("param_guest_tinyid", -1L);
      this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_guest_uin");
    }
    paramBundle = getAppRuntime();
    if ((paramBundle instanceof NearbyAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramBundle);
      a();
      b();
      if (this.jdField_g_of_type_Int == 10)
      {
        if ((((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211)).a(true) > 0) && (10 == this.h)) {
          a(true);
        }
      }
      else {
        return true;
      }
    }
    else
    {
      throw new NullPointerException("NearbyAppInterface is null, appRuntime = " + paramBundle);
    }
    a(false);
    return true;
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Boolean)) {
      c();
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void e()
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("MyFreshNewsActivity hideJuHua, juHua null?=");
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        break label91;
      }
      bool = true;
    }
    for (;;)
    {
      StringBuilder localStringBuilder = ((StringBuilder)localObject).append(bool).append(", showing=");
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        localObject = "null";
        QLog.d("FreshNews", 2, localObject);
      }
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        return;
        label91:
        bool = false;
        continue;
        localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing());
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("FreshNews", 2, localException.toString());
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131301724: 
    case 2131301725: 
    default: 
      return;
    case 2131301726: 
      a(10);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X8005CEB", "0X8005CEB", 0, 0, "", "", "", "");
      return;
    case 2131301727: 
      this.jdField_a_of_type_Boolean = true;
      a(false);
      a(11);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X8005CEC", "0X8005CEC", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\MyFreshNewsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */