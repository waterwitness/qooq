package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import kgi;
import kgj;
import kgk;
import kgl;
import kgm;
import protocol.KQQConfig.UpgradeInfo;

public class AboutActivity
  extends IphoneTitleBarActivity
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_a_of_type_JavaLangString;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_b_of_type_JavaLangString;
  private FormSimpleItem c;
  private FormSimpleItem d;
  private FormSimpleItem e;
  private FormSimpleItem f;
  
  public AboutActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "http://mobile.qq.com/android/";
    this.jdField_b_of_type_JavaLangString = "http://ti.qq.com/agreement/index.html";
    this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new kgl(this);
  }
  
  private void a(AboutConfig paramAboutConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已是最新版本");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("有新版本可用");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130843324));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new kgj(this));
  }
  
  private void a(AboutConfig paramAboutConfig, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    paramFormSimpleItem.setVisibility(0);
    if (paramResourcePluginInfo.isNew == 0) {
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130843324));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new kgk(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    super.setContentView(2130903040);
    setTitle(2131369792);
    paramBundle = this.app.a();
    ((TextView)findViewById(2131296770)).setText("V 6.5.5.2880");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296778));
    Object localObject = new SpannableString(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new kgm(this, this.jdField_a_of_type_JavaLangString, 2131296778), 0, this.jdField_a_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296779));
    localObject = new SpannableString(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new kgm(this, this.jdField_b_of_type_JavaLangString, 2131296779), 0, this.jdField_b_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296771));
    a(paramBundle);
    localObject = paramBundle.a("com.tx.aboutfunction");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296772));
    if (localObject != null)
    {
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      localObject = paramBundle.a("com.tx.aboutimage");
      this.c = ((FormSimpleItem)findViewById(2131296773));
      if (localObject == null) {
        break label1051;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.c);
      label305:
      localObject = paramBundle.a("com.tencent.Feedback_5_8");
      this.d = ((FormSimpleItem)findViewById(2131296776));
      if (localObject == null) {
        break label1063;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.d);
      label339:
      localObject = paramBundle.a("com.tencent.help_5_8");
      this.e = ((FormSimpleItem)findViewById(2131296775));
      if (localObject == null) {
        break label1075;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.e);
    }
    for (;;)
    {
      this.f = ((FormSimpleItem)findViewById(2131296774));
      this.f.setVisibility(8);
      this.f.setOnClickListener(new kgi(this));
      int i = DeviceInfoUtil.d();
      float f1 = FontSettingManager.a();
      if ((i <= 160) || (f1 > 16.0F))
      {
        paramBundle = (ImageView)findViewById(2131296769);
        localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
        if (i <= 160) {
          ((LinearLayout.LayoutParams)localObject).topMargin -= DisplayUtil.a(this, 5.0F);
        }
        ((LinearLayout.LayoutParams)localObject).topMargin -= DisplayUtil.a(this, (f1 - 16.0F) * 4.0F);
        if (((LinearLayout.LayoutParams)localObject).topMargin <= 0) {
          ((LinearLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this, 1.0F);
        }
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramBundle = "appid: " + String.valueOf(AppSetting.a) + "\n";
      paramBundle = paramBundle + "LC: 403741BF5D66F9D1\n";
      paramBundle = paramBundle + "buildNum: 2880\n";
      paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
      paramBundle = paramBundle + "subVersion: 6.5.5\n";
      paramBundle = paramBundle + "productID: 130\n";
      paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
      paramBundle = paramBundle + "supVersion: 2013\n";
      paramBundle = paramBundle + "revision: 229354\n";
      paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(true) + "\n";
      paramBundle = paramBundle + "reportVersionName: 6.5.5.2880\n";
      paramBundle = paramBundle + "aboutSubVersionName: V 6.5.5.2880\n";
      paramBundle = paramBundle + "aboutSubVersionLog: 6.5.5.2880.2016-09-13.r229354.BaiDu\n";
      paramBundle = paramBundle + "isPublicVersion: true\n";
      paramBundle = paramBundle + "versioncode: " + ApkUtils.a(this) + "\n";
      paramBundle = paramBundle + "amem: " + DeviceInfoUtil.d() / 1024L / 1024L + "\n";
      paramBundle = paramBundle + "qua: " + QUA.a() + "\n";
      paramBundle = paramBundle + "qua_mm: " + QUA.c() + "\n";
      paramBundle = paramBundle + "qua_pic: " + QUA.b() + "\n";
      if (QLog.isColorLevel()) {
        QLog.d("script", 2, paramBundle);
      }
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label1051:
      this.c.setVisibility(8);
      break label305;
      label1063:
      this.d.setVisibility(8);
      break label339;
      label1075:
      this.e.setVisibility(8);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (isFinishing()) {}
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetTextView.invalidate();
    this.jdField_b_of_type_AndroidWidgetTextView.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AboutActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */