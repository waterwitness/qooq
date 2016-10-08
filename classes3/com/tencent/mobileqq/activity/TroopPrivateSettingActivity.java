package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.vas.ChatBackgroundMarketActivity;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.util.HashMap;
import mwf;
import mwg;
import mwh;
import mwi;
import mwj;
import mwk;

public class TroopPrivateSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  protected static final int a = 0;
  public static final String a = "Q.troopprivatesetting";
  protected static final int b = 1;
  public static final int c = 2;
  public static final String c = "selection";
  protected static final int d = 3;
  protected static final int e = 4;
  protected static final int f = 5;
  protected static final int g = 6;
  protected static final int h = 7;
  protected static final int i = 1;
  protected static final int j = 2;
  protected LinearLayout a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public TroopInfo a;
  protected RoamSettingController a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public QQProgressNotifier a;
  protected XListView a;
  protected View[] a;
  public String b;
  protected int k;
  
  public TroopPrivateSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new mwj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new mwk(this);
  }
  
  private void a(boolean paramBoolean)
  {
    int m = 0;
    if (paramBoolean) {}
    for (Object localObject = "Clk_setcommgrp";; localObject = "Clk_uncommgrp")
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", (String)localObject, 0, 0, this.b, "", "", "");
      if (NetworkUtil.a(this) != 0) {
        break;
      }
      QQToast.a(this, 2131364258, 0).b(getTitleBarHeight());
      a();
      return;
    }
    localObject = (BizTroopHandler)this.app.a(22);
    String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
    if (paramBoolean) {}
    for (;;)
    {
      ((BizTroopHandler)localObject).a(str, m);
      return;
      m = 1;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131364258, 0).b(getTitleBarHeight());
      b();
      return;
    }
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.app.a(22);
    if (!paramBoolean)
    {
      DialogUtil.a(this, 230).setTitle(getString(2131367535)).setMessage(getString(2131364889)).setNegativeButton(getString(2131364890), new mwi(this, localBizTroopHandler)).setPositiveButton(getString(2131364891), new mwh(this)).show();
      return;
    }
    localBizTroopHandler.c(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, paramBoolean);
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "share_set_open", 0, 0, this.b, "", "", "");
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopprivatesetting", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131364853, 0).b(getTitleBarHeight());
      e();
      return;
    }
    ((TroopHandler)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, this.b, paramBoolean, false);
    if (paramBoolean)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.b, "", "", "");
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.b, "", "", "");
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this, ChatBackgroundMarketActivity.class);
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.b);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    localIntent.putExtra("url", IndividuationUrlHelper.a(this, "background", ""));
    String str = String.valueOf(33554432L);
    if (WebViewPluginFactory.a.containsKey(str)) {
      localIntent.putExtra("insertPluginsArray", new String[] { str });
    }
    localIntent.putExtra("business", 33554432L);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult(localIntent, 1);
    ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    boolean bool = ((TroopManager)this.app.getManager(51)).c(this.b);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[3];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131364849));
    }
  }
  
  public void a()
  {
    boolean bool = ((TroopManager)this.app.getManager(51)).a(this.b);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[0];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131364260));
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopprivatesetting", 2, localException.toString());
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      paramFormSimpleItem.setBgType(paramInt2);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      paramFormSimpleItem.setLeftText(str);
      paramFormSimpleItem.setLeftTextColor(0);
      paramFormSimpleItem.b().setEditableFactory(QQTextBuilder.a);
      if (paramCharSequence != null) {
        break label96;
      }
    }
    label96:
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    paramIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    paramIntent.putExtra("uin", this.b);
    paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname);
    paramIntent.putExtra("uintype", 1);
    startActivity(paramIntent);
    setResult(-1);
    finish();
  }
  
  public void b()
  {
    boolean bool = ((TroopInfoManager)this.app.getManager(36)).c(this.b);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[2];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131364888));
    }
  }
  
  protected void b(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.", 2, "ChatSettingActivity|onActivityResult|REQUEST_FOR_TROOP_DISBAND|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if ((TextUtils.isEmpty(paramIntent)) || ((!TextUtils.isEmpty(str)) && (bool)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1000);
        return;
      }
    } while (!bool);
    paramIntent = new Intent();
    paramIntent.putExtra("isNeedFinish", true);
    setResult(-1, paramIntent);
    finish();
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopprivatesetting", 2, localException.toString());
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      a(paramInt2, paramIntent);
      return;
    }
    b(paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    this.b = paramBundle.getString("troop_uin");
    this.k = paramBundle.getInt("selection", -1);
    if (TextUtils.isEmpty(this.b))
    {
      finish();
      return false;
    }
    paramBundle = (TroopManager)this.app.getManager(51);
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController = ((RoamSettingController)this.app.getManager(30));
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.b(this.b);
    Object localObject1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903384, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject1).findViewById(2131297613));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    Object localObject2 = new AbsListView.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject2 = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject2);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837958);
    super.setContentView((View)localObject1);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[7];
    setTitle(getString(2131369486));
    localObject1 = View.inflate(this, 2130904388, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    localObject1 = new FormSimpleItem(this);
    a(1, 2, (FormSimpleItem)localObject1, getString(2131369185), "", true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    localObject1 = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject1).setBgType(2);
    ((FormSwitchItem)localObject1).setText(getResources().getString(2131364888));
    ((FormSwitchItem)localObject1).setFocusable(true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject1;
    localObject2 = ((FormSwitchItem)localObject1).a();
    ((Switch)localObject2).setTag(Integer.valueOf(2));
    ((Switch)localObject2).setOnCheckedChangeListener(null);
    boolean bool = ((TroopInfoManager)this.app.getManager(36)).c(this.b);
    ((Switch)localObject2).setChecked(bool);
    ((Switch)localObject2).setOnCheckedChangeListener(this);
    ((FormSwitchItem)localObject1).setContentDescription(getString(2131364888));
    if (bool) {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "share_save_open", 0, 0, this.b, "", "", "");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    localObject1 = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject1).setBgType(2);
    ((FormSwitchItem)localObject1).setText(getResources().getString(2131369558));
    ((FormSwitchItem)localObject1).setFocusable(true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject1;
    localObject2 = ((FormSwitchItem)localObject1).a();
    ((Switch)localObject2).setTag(Integer.valueOf(0));
    bool = paramBundle.a(this.b);
    ((Switch)localObject2).setOnCheckedChangeListener(null);
    ((Switch)localObject2).setChecked(bool);
    ((Switch)localObject2).setOnCheckedChangeListener(this);
    ((FormSwitchItem)localObject1).setContentDescription(getString(2131364260));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    paramBundle = new FormSwitchItem(this, null);
    paramBundle.setBgType(3);
    paramBundle.setText(getResources().getString(2131364849));
    paramBundle.setFocusable(true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[3] = paramBundle;
    localObject1 = paramBundle.a();
    ((Switch)localObject1).setTag(Integer.valueOf(3));
    bool = ((TroopManager)this.app.getManager(51)).c(this.b);
    ((Switch)localObject1).setOnCheckedChangeListener(null);
    ((Switch)localObject1).setChecked(bool);
    ((Switch)localObject1).setOnCheckedChangeListener(this);
    paramBundle.setContentDescription(getString(2131364849));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isAdmin())
    {
      paramBundle = View.inflate(this, 2130904388, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
      paramBundle = new FormSimpleItem(this);
      a(4, 0, paramBundle, getString(2131364357), "", true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
    }
    paramBundle = View.inflate(this, 2130904388, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
    paramBundle = new Button(this);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    int m = getResources().getDimensionPixelSize(2131493669);
    int n = getResources().getDimensionPixelOffset(2131493668);
    ((LinearLayout.LayoutParams)localObject1).setMargins(n, m, n, 0);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramBundle.setTextSize(2, 18.0F);
    paramBundle.setMinHeight(getResources().getDimensionPixelOffset(2131493674));
    paramBundle.setText(2131368715);
    paramBundle.setTextColor(getResources().getColor(2131428284));
    paramBundle.setBackgroundResource(2130838221);
    paramBundle.setOnClickListener(this);
    paramBundle.setTag(Integer.valueOf(5));
    this.jdField_a_of_type_ArrayOfAndroidViewView[5] = paramBundle;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
    paramBundle = new View(this);
    localObject1 = new LinearLayout.LayoutParams(-1, 0);
    ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
    paramBundle = new TextView(this);
    localObject1 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject1).gravity = 1;
    ((LinearLayout.LayoutParams)localObject1).setMargins(0, DisplayUtil.a(this, 50.0F), 0, DisplayUtil.a(this, 15.0F));
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramBundle.setPadding(0, DisplayUtil.a(this, 15.0F), 0, DisplayUtil.a(this, 15.0F));
    paramBundle.setTextAppearance(this, 2131558577);
    paramBundle.setText(2131368905);
    paramBundle.setOnClickListener(this);
    paramBundle.setTag(Integer.valueOf(6));
    this.jdField_a_of_type_ArrayOfAndroidViewView[6] = paramBundle;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
    return true;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    case 1: 
    default: 
      return;
    case 0: 
      a(paramBoolean);
      return;
    case 3: 
      c(paramBoolean);
      return;
    }
    b(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    int m;
    if ((paramView instanceof Integer))
    {
      int n = ((Integer)paramView).intValue();
      paramView = "2";
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAdditionalFlag & 1L) != 1L) {
        break label93;
      }
      m = 1;
      if (m == 0) {
        break label99;
      }
      paramView = "0";
      label51:
      switch (n)
      {
      }
    }
    label93:
    label99:
    do
    {
      do
      {
        return;
        m = 0;
        break;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isAdmin()) {
          break label51;
        }
        paramView = "1";
        break label51;
        d();
        ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.b, "", "", "");
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isAdmin());
      paramView = "http://qqweb.qq.com/m/business/qunlevel/index.html?gc=" + this.b + "&from=0&_wv=1027";
      Object localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject).putExtra("url", paramView);
      startActivity((Intent)localObject);
      localObject = this.app;
      String str = this.b;
      if (m != 0) {}
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_credit", 0, 0, str, paramView, "0", "");
        return;
      }
      if (m != 0)
      {
        localObject = new Intent(this, TroopDisbandActivity.class);
        ((Intent)localObject).putExtra("troop_uin", this.b);
        ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname);
        ((Intent)localObject).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode);
        ((Intent)localObject).putExtra("leftViewText", 2131369488);
        startActivityForResult((Intent)localObject, 2);
        ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.b, paramView, "", "");
        return;
      }
      str = getString(2131368719);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname == null) {}
      for (localObject = this.b;; localObject = (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname + "(" + this.b + ")").replace("\n", ""))
      {
        localObject = String.format(getString(2131368712), new Object[] { localObject });
        localObject = DialogUtil.a(this, 230).setTitle(str).setMessage((CharSequence)localObject);
        ((QQCustomDialog)localObject).setPositiveButton(getString(2131367774), new mwf(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131362031));
        ((QQCustomDialog)localObject).setNegativeButton(getString(2131367262), new mwg(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).setNegativeButtonContentDescription(getString(2131362032));
        ((QQCustomDialog)localObject).show();
        break;
      }
    } while (isFinishing());
    ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Clk_report", 0, 0, this.b, paramView, "", "");
    ProfileCardUtil.a(this, this.b, null, this.app.getAccount(), 1102);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopPrivateSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */