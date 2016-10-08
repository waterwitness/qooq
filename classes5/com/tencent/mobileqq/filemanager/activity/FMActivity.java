package com.tencent.mobileqq.filemanager.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import rnf;
import rng;
import rnh;
import rni;
import rnj;
import rnk;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  static long jdField_b_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public View a;
  public LinearLayout a;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  public VerifyPwdView a;
  IBaseTabViewEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent;
  public QfileTabBarView a;
  rnk jdField_a_of_type_Rnk;
  RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  public RelativeLayout b;
  public TextView b;
  long jdField_c_of_type_Long;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public int d;
  int e;
  public final String e;
  int jdField_f_of_type_Int;
  String jdField_f_of_type_JavaLangString;
  public int g;
  public String g;
  int h;
  public boolean h;
  int jdField_i_of_type_Int;
  boolean jdField_i_of_type_Boolean;
  public boolean j;
  
  public FMActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_JavaLangString = "FMActivity<FileAssistant>";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = null;
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = null;
    this.jdField_a_of_type_AndroidWidgetRadioGroup = null;
    this.jdField_a_of_type_AndroidWidgetRadioButton = null;
    this.jdField_b_of_type_AndroidWidgetRadioButton = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_d_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_Rnk = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_i_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != 8) && (paramInt != 1) && (paramInt != 2) && (paramInt != 4))
    {
      this.jdField_i_of_type_Int = 10;
      return;
    }
    if ((paramInt == 8) && (a(8)))
    {
      this.jdField_i_of_type_Int = 10;
      return;
    }
    if ((paramInt == 1) && (a(1)))
    {
      this.jdField_i_of_type_Int = 12;
      return;
    }
    if ((paramInt == 2) && (a(2)))
    {
      this.jdField_i_of_type_Int = 13;
      return;
    }
    if ((paramInt == 4) && (a(4)))
    {
      this.jdField_i_of_type_Int = 9;
      return;
    }
    this.jdField_i_of_type_Int = 10;
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131300948));
    if (c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setMemory(true);
    }
    Object localObject;
    if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from")))
    {
      setLeftViewName(2131362722);
      if ((!c()) || (paramInt == 5) || (this.jdField_e_of_type_Boolean)) {
        break label421;
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131297786));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener == null) {
        n();
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
      this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131300942));
      this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131300941));
      if (FontSettingManager.a() > 17.0F)
      {
        localObject = (RadioButton)findViewById(2131300943);
        float f1 = getResources().getDisplayMetrics().density;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(40.0F * f1), (int)(f1 * 30.0F));
        this.jdField_b_of_type_AndroidWidgetRadioButton.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetRadioButton.setLayoutParams(localLayoutParams);
        ((RadioButton)localObject).setLayoutParams(localLayoutParams);
      }
      if (!this.jdField_i_of_type_Boolean) {
        break label336;
      }
      this.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(true);
      o();
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 0);
      ((SharedPreferences.Editor)localObject).commit();
      if ((this.jdField_g_of_type_Int == 0) && (this.j)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    label336:
    do
    {
      return;
      if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.trim().length() != 0) && (this.jdField_e_of_type_Int != -1))
      {
        setLeftViewName(2131369485);
        break;
      }
      setLeftViewName(2131366637);
      break;
      if ((this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean)) {
        break label421;
      }
      this.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(true);
      p();
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
      ((SharedPreferences.Editor)localObject).commit();
    } while ((this.jdField_g_of_type_Int != 0) || (!this.j));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    return;
    label421:
    g();
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 0: 
    case 6: 
    case 7: 
      if (paramInt == 0) {}
      for (this.jdField_b_of_type_JavaLangString = getString(2131367906);; this.jdField_b_of_type_JavaLangString = getString(2131362731))
      {
        setTitle(this.jdField_b_of_type_JavaLangString);
        if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
          ((RadioButton)findViewById(2131300941)).setSelected(true);
        }
        o();
        return;
      }
    case 2: 
    case 3: 
      this.jdField_b_of_type_JavaLangString = getString(2131362725);
      setTitle(this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        ((RadioButton)findViewById(2131300943)).setSelected(true);
      }
      d(paramInt);
      return;
    case 1: 
      if ((this.jdField_g_of_type_Int == 0) && (this.j)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      break;
    }
    if (this.jdField_c_of_type_JavaLangString == null)
    {
      this.jdField_b_of_type_JavaLangString = getString(2131362723);
      label640:
      setTitle(this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(true);
      }
      p();
      if ((c()) && ((this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Int == 5)))
      {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
        this.jdField_c_of_type_AndroidWidgetTextView.setText("全部");
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
        if (this.jdField_h_of_type_Int <= 0) {
          break label819;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
    }
    for (;;)
    {
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
      ((SharedPreferences.Editor)localObject).commit();
      if (b() != 8) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      break label640;
      label819:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    if (3 == paramInt) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = new VerifyPwdView(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new rni(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.b();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private void l()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.jdField_g_of_type_JavaLangString), 0L, 2, null, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FMActivity<FileAssistant>", 2, localException.toString());
    }
  }
  
  private void m()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(2131364349);
    localQQCustomDialog.setTitle(2131364348);
    localQQCustomDialog.setNegativeButton(getString(2131364351), new rnf(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    if (!isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new rnh(this);
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.jdField_f_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(3, getString(2131362916));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(4, getString(2131362917));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(5, getString(2131362918));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(6, getString(2131362919));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(7, getString(2131362923));
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (this.jdField_d_of_type_Int >= 3) && (this.jdField_d_of_type_Int <= 7)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    if (f())
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300940));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362916);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_h_of_type_Int <= 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        g();
        label96:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
        if (this.jdField_h_of_type_Int > 0) {
          break label363;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, getString(2131362919));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131362918));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131362917));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8, getString(2131362923));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(14, getString(2131362922));
        label190:
        if ((!this.jdField_h_of_type_Boolean) || ((this.jdField_a_of_type_Int != 1) && (this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).getInt("last_select_tab_type", -1) != 1)) || (this.jdField_d_of_type_Int < 8) || (this.jdField_d_of_type_Int > 14)) {
          break label554;
        }
        if (this.jdField_h_of_type_Int > 0) {
          break label540;
        }
        if ((this.jdField_d_of_type_Int != 11) && (this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 10) && (this.jdField_d_of_type_Int != 8) && (this.jdField_d_of_type_Int != 14)) {
          break label528;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_d_of_type_Int);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      break;
      a(this);
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label96;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label96;
      label363:
      ArrayList localArrayList = new ArrayList();
      if (a(8))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131362917));
        localArrayList.add(Integer.valueOf(10));
      }
      if (a(4))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131362918));
        localArrayList.add(Integer.valueOf(9));
      }
      if (a(2))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(13, getString(2131362921));
        localArrayList.add(Integer.valueOf(13));
      }
      if (a(1))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(12, getString(2131362920));
        localArrayList.add(Integer.valueOf(12));
      }
      if (localArrayList.size() != 1) {
        break label190;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
      break label190;
      label528:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
      continue;
      label540:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_i_of_type_Int);
      continue;
      label554:
      if (7 != this.jdField_f_of_type_Int)
      {
        if (this.jdField_h_of_type_Int <= 0) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_i_of_type_Int);
        }
      }
      else if (this.jdField_i_of_type_Int != -1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_i_of_type_Int);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(9);
      }
    }
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FMActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new rnj(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void s()
  {
    ArrayList localArrayList2 = null;
    Object localObject = FMDataCache.b();
    ArrayList localArrayList1 = localArrayList2;
    if (localObject != null)
    {
      localArrayList1 = localArrayList2;
      if (((ArrayList)localObject).size() > 0)
      {
        localArrayList2 = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        for (;;)
        {
          localArrayList1 = localArrayList2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArrayList2.add(((FileInfo)((Iterator)localObject).next()).d());
        }
      }
    }
    this.app.a().a(this, localArrayList1, 15, 0, true, this.jdField_g_of_type_JavaLangString);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void a(IBaseTabViewEvent paramIBaseTabViewEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = paramIBaseTabViewEvent;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(paramArrayList);
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_h_of_type_Int & paramInt) > 0;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(paramArrayList);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return;
    }
    int k = 0;
    if (paramBoolean) {
      k = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.getLayoutParams().height;
    }
    int m = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setTabFrameHeight(m - k);
  }
  
  public void c(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c(paramArrayList);
  }
  
  public void d(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.d(paramArrayList);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.trim().length() != 0))
    {
      if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
      {
        Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
        finish();
      }
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    jdField_b_of_type_Long += 1L;
    this.jdField_c_of_type_Long = jdField_b_of_type_Long;
    FMDataCache.b();
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("tab_tab_type", -1);
    this.jdField_f_of_type_Int = paramBundle.getIntExtra("busiType", -1);
    this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("uintype", -1);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("from_qlink", false);
    this.j = paramBundle.getBooleanExtra("from_aio", false);
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("peerType", -1);
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("smart_device_support_flag", 0);
    if ((this.jdField_h_of_type_Int & 0xF) == 0) {
      this.jdField_h_of_type_Int = 0;
    }
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0);
    if ((c()) && (this.jdField_a_of_type_Int != 5) && (localSharedPreferences.getBoolean("last_select_All", false)) && (localSharedPreferences.getBoolean("last_select_send", false)))
    {
      this.jdField_i_of_type_Boolean = true;
      b(paramBundle.getIntExtra("smart_device_switch_tab_flag", 0));
      paramBundle = localSharedPreferences.edit();
      paramBundle.putBoolean("last_select_All", false);
      paramBundle.putBoolean("last_select_send", false);
      paramBundle.commit();
      this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("targetUin");
      if (QLog.isColorLevel()) {
        QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.jdField_a_of_type_Int + "],select[" + c() + "]");
      }
      if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_e_of_type_Int == -1)) {
        e(true);
      }
      this.jdField_c_of_type_Boolean = false;
      if (AppConstants.aj.equalsIgnoreCase(this.jdField_g_of_type_JavaLangString)) {
        this.jdField_c_of_type_Boolean = true;
      }
      int k = getResources().getDisplayMetrics().heightPixels;
      if ((!c()) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 6) || (this.jdField_e_of_type_Boolean)) {
        break label640;
      }
      a(2130903991);
      ((LinearLayout)findViewById(2131300939)).setLayoutParams(new RelativeLayout.LayoutParams(-1, k));
      if ((ImmersiveUtils.isSupporImmersive() != 1) || (!f())) {}
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297422));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300945));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new rng(this));
      if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_e_of_type_Int == -1))
      {
        setLeftViewName(2131369771);
        if (this.rightViewText != null) {
          this.rightViewText.setVisibility(8);
        }
      }
      c(this.jdField_a_of_type_Int);
      this.app.a().h();
      q();
      return true;
      if ((!this.j) && (this.jdField_a_of_type_Int != 5) && (paramBundle.getIntExtra("approval_attachment_customid", -1) == -1)) {
        break;
      }
      if (this.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_Int = localSharedPreferences.getInt("last_select_tab_type", -1);
      }
      this.jdField_d_of_type_Int = localSharedPreferences.getInt("last_select_tab_view", -1);
      if ((this.jdField_a_of_type_Int == -1) || (this.jdField_d_of_type_Int == -1)) {
        break;
      }
      this.jdField_h_of_type_Boolean = true;
      break;
      label640:
      setContentView(2130903991);
      ((RelativeLayout)findViewById(2131296896)).setVisibility(8);
      paramBundle = (LinearLayout)findViewById(2131300939);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.app.a().b();
    this.app.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    }
    if (this.jdField_c_of_type_Long == jdField_b_of_type_Long) {
      FMDataCache.b();
    }
    r();
    if (this.jdField_d_of_type_Boolean)
    {
      Intent localIntent = new Intent("com.tencent.qlink.selectfileover");
      this.app.a().sendBroadcast(localIntent);
    }
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_Rnk != null) {
      removeObserver(this.jdField_a_of_type_Rnk);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.r();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.jdField_g_of_type_JavaLangString != null))
    {
      ((TroopHandler)this.app.a(20)).m(this.jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_Rnk = new rnk(this);
      addObserver(this.jdField_a_of_type_Rnk);
    }
    super.doOnResume();
  }
  
  public void e(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.e(paramArrayList);
  }
  
  public void f(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.f(paramArrayList);
  }
  
  public void finish()
  {
    super.finish();
    if (c()) {
      overridePendingTransition(2130968583, 2130968584);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (!a()) {}
    Intent localIntent;
    do
    {
      return;
      e();
      localIntent = new Intent(this, FMLocalFileActivity.class);
      localIntent.putExtra("STRING_Show_Music_Category", false);
      localIntent.putExtra("STRING_Show_Video_Category", false);
      localIntent.putExtra("STRING_Show_Apk_Category", false);
      localIntent.putExtra("STRING_Show_Pic_Category", false);
      localIntent.putExtra("STRING_Show_Driver_Category", false);
      localIntent.putExtra("STRING_Show_First_Space", false);
      if ((paramView.getId() == 2131300940) || (paramView.getId() == 2131297083))
      {
        localIntent.putExtra("localSdCardfile", 1408041717);
        localIntent.putExtra("STRING_Show_Download_Category", false);
        localIntent.putExtra("STRING_Show_MyFile_Category", true);
        a().ag();
        startActivityForResult(localIntent, paramView.getId());
        overridePendingTransition(2130968601, 2130968605);
        return;
      }
    } while (paramView.getId() != 2131300980);
    localIntent.putExtra("localSdCardfile", 1408041716);
    localIntent.putExtra("STRING_Show_Download_Category", false);
    a().an();
    startActivityForResult(localIntent, paramView.getId());
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.q();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
  }
  
  protected void onResume()
  {
    if (FMDataCache.a() > 0L) {
      k();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.o();
    }
    super.onResume();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\FMActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */