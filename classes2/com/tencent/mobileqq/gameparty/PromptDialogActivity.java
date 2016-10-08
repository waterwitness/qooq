package com.tencent.mobileqq.gameparty;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PromptDialogActivity
  extends BaseActivity
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = PromptDialogActivity.class.getSimpleName();
  private static final String jdField_b_of_type_JavaLangString = "GamePartyManager";
  private static final String c = "firstTimeLaunch";
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      KeyguardManager localKeyguardManager = (KeyguardManager)super.getSystemService("keyguard");
      if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
      {
        boolean bool = localKeyguardManager.isKeyguardSecure();
        if (bool) {
          return;
        }
      }
      super.startActivity(new Intent(super.getApplicationContext(), QQLSUnlockActivity.class));
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
    j = 268435456;
    try
    {
      k = Integer.parseInt(paramString4);
      if ((k & 0x4000000) != 67108864) {
        break label98;
      }
      j = 335544320;
    }
    catch (Exception paramString4)
    {
      for (;;)
      {
        int k;
        int i;
        continue;
        j = 268435456;
      }
    }
    i = j;
    if ((k & 0x20000000) == 536870912) {
      i = j | 0x20000000;
    }
    j = i;
    if ((k & 0x400000) == 4194304) {
      j = i | 0x400000;
    }
    localAppLaucherHelper.a(this.app, this, paramString1, paramString2, paramString3, j);
  }
  
  private void a(boolean paramBoolean)
  {
    if (a(this, this.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startGame directStart = " + paramBoolean + ", app installed");
      }
      Object localObject = (GamePartyManager)this.app.getManager(155);
      ((GamePartyManager)localObject).b();
      ((GamePartyManager)localObject).a("http://openmobile.qq.com/gameteam/start_game?uin=" + this.app.a(), null);
      if (paramBoolean) {}
      for (localObject = this.g;; localObject = String.format("platform=qq_m&current_uin=$OPID$&launchfrom=&gamedata=%s&platformdata=&openid=$OPID$&atoken=$AT$&ptoken=$PT$", new Object[] { this.f }))
      {
        if (QQUtils.a(super.getApplicationContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "startGame screen is locked, need unlock");
          }
          a();
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "startGame launch Game now");
        }
        a(this.d, (String)localObject, this.e, "0");
        ReportCenter.a().a(this.app.a(), "", "", "2000", "2036", "0", false);
        finish();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startGame directStart = " + paramBoolean + ", app not installed");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(this.app.a().getString(2131372545));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(this.app.a().getString(2131372546));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(this.app.a().getString(2131372548), this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(this.app.a().getString(2131372547), this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    ReportCenter.a().a(this.app.a(), "", "", "2000", "2036", "1", false);
    ReportCenter.a().a(this.app.a(), "", "", "2000", "2039", "0", false);
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString.trim(), 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject = super.getIntent();
    if (localObject == null)
    {
      finish();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnCreate start");
    }
    super.doOnCreate(paramBundle);
    this.d = ((Intent)localObject).getStringExtra("appid");
    paramBundle = ((Intent)localObject).getStringExtra("packageName");
    int i = paramBundle.indexOf('|');
    if ((i < 0) || (i >= paramBundle.length() - 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnCreate split packageName and downloadUrl failed");
      }
      finish();
      return false;
    }
    this.e = paramBundle.substring(0, i);
    this.h = paramBundle.substring(i + 1, paramBundle.length());
    if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnCreate appid or packageName is empty");
      }
      finish();
      return false;
    }
    if (((Intent)localObject).getBooleanExtra("direct_start", false))
    {
      this.g = ((Intent)localObject).getStringExtra("paramsStr");
      a(true);
      return true;
    }
    String str1 = ((Intent)localObject).getStringExtra("title");
    String str2 = ((Intent)localObject).getStringExtra("summary");
    paramBundle = ((Intent)localObject).getStringExtra("picUrl");
    this.f = ((Intent)localObject).getStringExtra("gamedata");
    ((Intent)localObject).getBooleanExtra("leader", false);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(1024);
    setContentView(2130903365);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298285));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131296268));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131296790));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297123));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297439));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str2);
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = super.getResources().getDimensionPixelSize(2131493658);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = super.getResources().getDimensionPixelSize(2131493659);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = super.getResources().getDrawable(2130838155);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = super.getResources().getDrawable(2130838155);
      paramBundle = URLDrawable.getDrawable(paramBundle, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBundle);
      return true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(super.getResources().getDrawable(2130838155));
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface == this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog) {
      if (paramInt == 1)
      {
        a(true);
        paramDialogInterface.dismiss();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt != 0);
        paramDialogInterface.dismiss();
        finish();
        return;
      } while (paramDialogInterface != this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      if (paramInt == 1)
      {
        ReportCenter.a().a(this.app.a(), "", "", "2000", "2041", "0", false);
        if (QQUtils.a(super.getApplicationContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "on click download button, need unlock screen");
          }
          a();
        }
        if (!TextUtils.isEmpty(this.h))
        {
          Intent localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("url", this.h);
          startActivity(localIntent);
        }
        for (;;)
        {
          paramDialogInterface.dismiss();
          finish();
          return;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "on click download button, download url is empty");
          }
        }
      }
    } while (paramInt != 0);
    ReportCenter.a().a(this.app.a(), "", "", "2000", "2040", "0", false);
    paramDialogInterface.dismiss();
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298285: 
      ReportCenter.a().a(this.app.a(), "", "", "2000", "2046", "0", false);
      finish();
      return;
    }
    ReportCenter.a().a(this.app.a(), "", "", "2000", "2045", "0", false);
    a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\gameparty\PromptDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */