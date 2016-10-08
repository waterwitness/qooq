package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.config.AppSetting;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import kjz;
import kka;
import kkb;
import kkc;
import kkd;
import kke;
import kkf;
import kkg;
import kkh;
import kki;
import kkj;
import kkk;
import kkl;
import kkm;
import kkn;
import kko;
import kkp;
import kkq;
import kkr;
import kks;
import mqq.app.MobileQQ;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
{
  static final int jdField_a_of_type_Int = 1;
  static final int jdField_b_of_type_Int = 1000;
  static final int jdField_c_of_type_Int = 0;
  static final int jdField_d_of_type_Int = 1;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public FormSwitchItem a;
  public QQProgressDialog a;
  private String jdField_a_of_type_JavaLangString;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSwitchItem b;
  private View jdField_c_of_type_AndroidViewView;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_d_of_type_AndroidViewView;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_e_of_type_AndroidViewView;
  FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_f_of_type_AndroidViewView;
  FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchItem g;
  FormSwitchItem h;
  FormSwitchItem i;
  FormSwitchItem j;
  FormSwitchItem k;
  public FormSwitchItem l;
  public FormSwitchItem m;
  FormSwitchItem n;
  FormSwitchItem o;
  
  public AssistantSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new kkj(this);
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new kkl(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131297106));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131297100);
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131297101);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131297097));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131297098));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131297110));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131297111));
    this.i = ((FormSwitchItem)super.findViewById(2131297112));
    this.j = ((FormSwitchItem)super.findViewById(2131297113));
    this.k = ((FormSwitchItem)super.findViewById(2131297114));
    this.g = ((FormSwitchItem)super.findViewById(2131297099));
    this.h = ((FormSwitchItem)super.findViewById(2131297109));
    this.l = ((FormSwitchItem)super.findViewById(2131297115));
    this.m = ((FormSwitchItem)super.findViewById(2131297116));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297095);
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131297096);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297094);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.n = ((FormSwitchItem)super.findViewById(2131297103));
    this.o = ((FormSwitchItem)super.findViewById(2131297104));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297105));
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131297102);
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.font_setting.name(), "-1");
    label326:
    label340:
    boolean bool;
    label911:
    String str;
    if ("1".equals(localObject))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (PredownloadTest.jdField_a_of_type_Boolean) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      if (PreDownloadStrategyBeta.g != 0L) {
        break label1424;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (!MagicfaceViewController.a()) {
        break label1436;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297107));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297108));
      if (QFindBLEScanMgr.a()) {
        break label1448;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      bool = SettingCloneUtil.readValue(this, null, super.getString(2131367835), "qqsetting_screenshot_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new kkk(this));
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(new kkm(this));
      }
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(new kkn(this));
      }
      bool = SettingCloneUtil.readValue(this, null, getString(2131367826), "qqsetting_auto_receive_pic_key", true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new kko(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131367826), "qqsetting_auto_receive_magic_face_key", true);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new kkp(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131367880), "qqsetting_enter_sendmsg_key", false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new kkq(this));
      bool = SettingCloneUtil.readValue(this, this.app.a(), null, "qqsetting_all_contacts_key", false);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new kkr(this));
      bool = SettingCloneUtil.readValue(this, null, null, "qqsetting_clear_memory_key", true);
      this.k.setChecked(bool);
      this.k.setOnCheckedChangeListener(new kks(this));
      bool = ConfigHandler.a(this.app, false);
      this.g.setChecked(bool);
      this.g.setOnCheckedChangeListener(new kka(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131370224), "qqsetting_notify_icon_key", false);
      this.h.setChecked(bool);
      this.h.setOnCheckedChangeListener(new kkb(this));
      if (this.app.a(6) == 1)
      {
        this.l.setVisibility(0);
        this.l.setChecked(this.app.m);
        this.l.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      }
      this.m.setChecked(this.app.a().jdField_a_of_type_Boolean);
      this.m.setText(getText(2131368364));
      this.m.setContentDescription("在底部栏展示日迹功能");
      this.m.setOnCheckedChangeListener(new kkc(this));
      this.m.setBackgroundResource(2130838349);
      this.m.setVisibility(0);
      if ((QQStoryManager.d()) && (this.app.a().jdField_a_of_type_Char != '0') && (this.app.a().jdField_a_of_type_Char != '1')) {
        break label1522;
      }
      this.m.setVisibility(8);
      PstnManager localPstnManager = (PstnManager)this.app.getManager(142);
      if (localPstnManager.a() == 1)
      {
        this.n.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject = this.app.getApplication().getResources().getString(2131372511);
        str = localPstnManager.a("pstn_c2c_trans_setting_wording");
        FormSwitchItem localFormSwitchItem = this.n;
        if (!TextUtils.isEmpty(str)) {
          break label1540;
        }
        label987:
        localFormSwitchItem.setText((CharSequence)localObject);
        this.n.setChecked(localPstnManager.a());
        this.n.setOnCheckedChangeListener(new kkd(this, localPstnManager));
        if (localPstnManager.e() == 1)
        {
          this.o.setVisibility(0);
          localObject = this.app.getApplication().getResources().getString(2131372514);
          str = localPstnManager.a("pstn_multi_trans_setting_wording");
          localFormSwitchItem = this.o;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label1545;
          }
          label1074:
          localFormSwitchItem.setText((CharSequence)localObject);
          this.o.setChecked(localPstnManager.b());
          this.o.setOnCheckedChangeListener(new kke(this, localPstnManager));
        }
      }
      localObject = (OlympicManager)this.app.getManager(166);
      if ((localObject == null) || (!((OlympicManager)localObject).d())) {
        break label1550;
      }
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(new kkf(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new kkg(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new kkh(this));
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(new kki(this));
      if (AppSetting.j)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription("流量统计");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("摇动手机截屏");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("加入寻找丢失儿童项目");
        this.jdField_c_of_type_AndroidViewView.setContentDescription("空间图片浏览模式");
        this.jdField_d_of_type_AndroidViewView.setContentDescription("日迹浏览设置");
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("2G/3G/4G下自动接收图片");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("回车键发送消息");
        this.g.setContentDescription("WiFi下自动在后台下载新版本");
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("联系人列表按字母排列");
        this.h.setContentDescription("系统通知栏显示QQ图标");
        this.j.setContentDescription("有可用QQ WiFi时通知我");
        this.k.setContentDescription("内存低时自动清理内存");
        this.l.setContentDescription("在底部菜单展示通话功能");
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131368325));
        this.l.setContentDescription(getString(2131368361));
      }
      return;
      if ("0".equals(localObject))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        FontSettingManager.b(this);
        break;
      }
      if (FontSettingManager.a())
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      FontSettingManager.b(this);
      break;
      label1424:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label326;
      label1436:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label340;
      label1448:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (SettingCloneUtil.readValueForInt(BaseApplication.getContext(), this.app.a(), null, "qqsetting_antilost_key", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new kjz(this));
        break;
      }
      label1522:
      StoryReportor.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label911;
      label1540:
      localObject = str;
      break label987;
      label1545:
      localObject = str;
      break label1074;
      label1550:
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter == null)
      {
        QQToast.a(this, 2131372304, 100).a();
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localObject = null;
      }
      CardHandler localCardHandler = (CardHandler)this.app.a(2);
      if (paramBoolean) {}
      for (short s = 1;; s = 0)
      {
        localCardHandler.a(s);
        if (!paramBoolean) {
          break;
        }
        if (!((BluetoothAdapter)localObject).isEnabled()) {
          ((BluetoothAdapter)localObject).enable();
        }
        SmartDeviceReport.a(this.app, 0L, "QFIND_BluetoothBtnClick", 1, 0, 0);
        return;
      }
      SmartDeviceReport.a(this.app, 0L, "QFIND_BluetoothBtnClick", 0, 0, 0);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903102);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131367833);
    this.jdField_a_of_type_JavaLangString = this.app.a();
    super.setVolumeControlStream(3);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      super.dismissDialog(1);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131368310));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  protected String setLastActivityName()
  {
    return super.getString(2131367833);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AssistantSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */