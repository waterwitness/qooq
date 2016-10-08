package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.Constants.LogoutReason;
import pxo;

public class FrameFragment
  extends Fragment
  implements TabHost.OnTabChangeListener, TabHost.TabContentFactory, OnDrawCompleteListener
{
  private static final String jdField_a_of_type_JavaLangString = "FrameActivity";
  long jdField_a_of_type_Long;
  protected View a;
  private Frame jdField_a_of_type_ComTencentMobileqqAppFrame;
  protected QQTabHost a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private final Map jdField_a_of_type_JavaUtilMap;
  protected boolean e;
  String n;
  
  public FrameFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap(4);
    this.jdField_a_of_type_Long = -1L;
    this.n = null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
  }
  
  protected Frame a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrame;
  }
  
  protected Frame a(Class paramClass)
  {
    Frame localFrame = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localFrame = (Frame)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
    }
    return localFrame;
  }
  
  public String a()
  {
    Frame localFrame = b();
    if (localFrame != null) {
      return localFrame.a();
    }
    return null;
  }
  
  public void a()
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    Log.i("AutoMonitor", this.n + "TabSwitch, cost=" + l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, this.n + "TabSwitch, cost=" + l);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(QQUtils.a(), "actSwitch" + this.n, true, l, 0L, null, null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Frame localFrame = b();
    if (localFrame != null) {
      localFrame.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTabTag();
      if (str != null) {
        paramBundle.putString("currentTab", str);
      }
    }
  }
  
  protected void a(View paramView1, Class paramClass, View paramView2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost = ((QQTabHost)paramView1.findViewById(16908306));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setup();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabSelectionListener(new pxo(this));
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    }
    String str = paramClass.getName();
    paramClass = (TabHost.TabSpec)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    paramView1 = paramClass;
    if (paramClass == null)
    {
      paramView1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.newTabSpec(str).setIndicator(paramView2).setContent(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramView1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.addTab(paramView1);
  }
  
  protected void a(Class paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Frame localFrame = a(paramClass);
      if (localFrame != null) {
        localFrame.f();
      }
      paramClass = paramClass.getName();
      this.jdField_a_of_type_JavaUtilMap.remove(paramClass);
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramClass);
      }
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramLogoutReason);
    }
  }
  
  public int b()
  {
    return getResources().getDimensionPixelSize(2131492908);
  }
  
  public Frame b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameActivity", 2, "mTabHost=null");
      }
      return null;
    }
    return (Frame)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTabTag());
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameActivity", 2, "onAccountChanged");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).z_();
    }
  }
  
  protected void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("currentTab");
    String str;
    if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTabTag();
      if (str.endsWith(paramBundle)) {
        break label43;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTabByTag(paramBundle);
    }
    label43:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FrameActivity", 2, "onRestoreInstanceState restoreTag:" + paramBundle + "|curTag：" + str);
  }
  
  public View createTabContent(String paramString)
  {
    Object localObject = null;
    if (getActivity() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MainFragment", 2, "FrameFragment.createTabContent getActivity == null");
      }
      return null;
    }
    if (paramString.equals(Conversation.class.getName())) {
      localObject = new Conversation();
    }
    for (;;)
    {
      ((Frame)localObject).a(getActivity());
      View localView = ((Frame)localObject).a(getActivity().getLayoutInflater());
      ((Frame)localObject).c(localView);
      ((Frame)localObject).d();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      return localView;
      if (paramString.equals(Contacts.class.getName())) {
        localObject = new Contacts();
      } else if (paramString.equals(Call.class.getName())) {
        localObject = new Call();
      } else if (paramString.equals(Leba.class.getName())) {
        localObject = new Leba();
      } else if (paramString.equals(Now.class.getName())) {
        localObject = new Now();
      }
    }
  }
  
  public void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).f();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramConfiguration);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903399, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).f();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.c != 1) && (!this.e)) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = b();
    } while (localFrame == null);
    localFrame.e();
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.c != 1) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = b();
    } while ((localFrame == null) || (!localFrame.a()));
    localFrame.a(false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.c != 1) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = b();
    } while (localFrame == null);
    localFrame.x();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.c != 1) && (!this.e)) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = b();
    } while (localFrame == null);
    localFrame.w();
  }
  
  public void onTabChanged(String paramString)
  {
    if (paramString != null)
    {
      this.n = paramString;
      int i = paramString.lastIndexOf(".");
      if (i >= 0) {
        this.n = paramString.substring(i + 1, paramString.length());
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost instanceof QQTabHost)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setFirstDrawTrue();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrame != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.e();
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.l();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrame = b();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrame.a())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.a(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FrameFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */