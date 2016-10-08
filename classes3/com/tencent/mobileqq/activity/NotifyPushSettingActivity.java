package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import lxr;
import lxs;
import lxt;
import lxu;
import lxv;
import lxw;
import lxx;
import lxy;
import lxz;
import lya;
import lyb;
import lyc;
import lyd;
import lye;
import lyf;
import lyg;
import lyh;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  private static final int jdField_a_of_type_Int = 10000;
  private static final int jdField_b_of_type_Int = 10001;
  public static final String b = "click_notifylight_count";
  public static final String c = "LED_light";
  public static final String d = "param_ls_setting";
  public BroadcastReceiver a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  private NearbyRelevantObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  
  public NotifyPushSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver = new lxw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new lxx(this);
    this.jdField_a_of_type_AndroidOsHandler = new lxy(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lxz(this);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298547);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298537));
    this.i = ((FormSwitchItem)findViewById(2131298544));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298536);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298539));
    this.c = ((FormSwitchItem)findViewById(2131298540));
    this.d = ((FormSwitchItem)findViewById(2131298541));
    this.e = ((FormSwitchItem)findViewById(2131298542));
    if (((Boolean)NearbySPUtil.a(this.app.getAccount(), "ShowFreshNews", Boolean.valueOf(true))).booleanValue()) {
      this.e.setVisibility(0);
    }
    this.f = ((FormSwitchItem)findViewById(2131298543));
    this.g = ((FormSwitchItem)findViewById(2131298538));
    this.h = ((FormSwitchItem)findViewById(2131298545));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298546));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new lxr(this));
    boolean bool1;
    if (this.app != null)
    {
      if (this.app.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getBoolean("spcial_care_qq_setting", true)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130843324));
      }
      bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131368465), "qqsetting_notify_showcontent_key", true);
      boolean bool5 = SettingCloneUtil.readValue(this, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false);
      boolean bool6 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131368466), "qqsetting_notify_blncontrol_key", true);
      boolean bool7 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool8 = LocalMultiProcConfig.a(getString(2131368470) + this.jdField_a_of_type_JavaLangString, true);
      boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131369617), "qqsetting_receivemsg_whenexit_key", true);
      boolean bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131369618), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool4 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
      SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new lya(this));
      if (AppSetting.j) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
      }
      this.i.setChecked(bool5);
      this.i.setOnCheckedChangeListener(new lyb(this));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool6);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new lyc(this));
      this.c.setChecked(bool7);
      this.c.setOnCheckedChangeListener(new lyd(this));
      if (!BadgeUtils.a(this.app.getApplication())) {
        break label958;
      }
      this.c.setVisibility(0);
      label533:
      this.d.setChecked(bool8);
      this.d.setOnCheckedChangeListener(new lye(this));
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
      bool5 = this.app.a().b();
      this.e.setChecked(bool5);
      this.e.setOnCheckedChangeListener(new lyf(this));
      if (AppSetting.j) {
        this.e.setContentDescription(getString(2131369616));
      }
      this.f.setChecked(bool2);
      this.f.setOnCheckedChangeListener(new lyg(this));
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      CardHandler localCardHandler = (CardHandler)this.app.a(2);
      this.h.setChecked(bool4);
      this.h.setOnCheckedChangeListener(new lyh(this, localCardHandler));
      if (localCardHandler != null) {
        localCardHandler.i();
      }
      if (!SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
        break label970;
      }
      this.h.setVisibility(0);
      label737:
      this.g.setChecked(bool3);
      if (!a()) {
        break label982;
      }
      this.g.setChecked(false);
      this.g.setVisibility(8);
    }
    for (;;)
    {
      this.g.setOnCheckedChangeListener(new lxs(this));
      if (AppSetting.j) {
        this.g.setContentDescription("锁屏显示消息弹框");
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new lxt(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new lxu(this));
      if (AppSetting.j)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription("声音");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知时指示灯闪烁");
        this.d.setContentDescription("与我相关的通知");
        this.f.setContentDescription("退出后仍接收消息通知");
        this.i.setContentDescription("夜间防骚扰模式");
        this.h.setContentDescription("PC离线时自动启动QQ手机版");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131371016));
        this.jdField_a_of_type_AndroidViewView.setContentDescription("群消息设置");
      }
      ((ConfigHandler)this.app.a(4)).c();
      return;
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare");
      break;
      label958:
      this.c.setVisibility(8);
      break label533;
      label970:
      this.h.setVisibility(8);
      break label737;
      label982:
      if (bool1) {
        this.g.setVisibility(0);
      } else {
        this.g.setVisibility(8);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt(paramString + "click_notifylight_count", 0);
    paramContext.putInt(paramString + "LED_light", 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    int j = paramContext.getInt(paramString1, 0);
    paramContext.edit().putInt(paramString1, j + 1).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1 + paramString2;
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putInt(paramString1, paramInt).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new lxv(paramQQAppInterface, paramString));
  }
  
  private void a(String paramString)
  {
    try
    {
      boolean bool = SettingCloneUtil.readValue(this, paramString, null, "qqsetting_pcactive_key", false);
      this.jdField_a_of_type_Boolean = true;
      this.h.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean a()
  {
    return new File(Environment.getRootDirectory() + "/etc/permissions", "com.lenovo.keyguard.xml").exists();
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903422);
    setTitle(2131368323);
    if (this.app != null) {
      this.jdField_a_of_type_JavaLangString = this.app.a();
    }
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.app != null)
    {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    }
    if (BadgeUtils.a(this.app.getApplication())) {
      BadgeUtils.c();
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Intent localIntent = new Intent("tencent.notify.activity.setting");
    this.app.a().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  protected String setLastActivityName()
  {
    return getString(2131368323);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\NotifyPushSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */