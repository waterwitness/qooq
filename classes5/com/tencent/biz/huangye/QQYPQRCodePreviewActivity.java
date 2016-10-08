package com.tencent.biz.huangye;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.BitmapTools;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.huangye.HYBlankActivity;
import hip;
import hiq;
import java.lang.reflect.Field;
import mqq.app.BaseActivity;

public class QQYPQRCodePreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  static String jdField_a_of_type_JavaLangString = "QQYPQRCodePreviewActivity";
  Dialog jdField_a_of_type_AndroidAppDialog;
  Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQYPQRCodePreviewActivity.RefreshHeadRunnable jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable;
  QQYPQRCodePreviewActivity.TimeoutRunnable jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$TimeoutRunnable;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public QQProgressDialog a;
  hiq jdField_a_of_type_Hiq;
  boolean jdField_a_of_type_Boolean = true;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  public String c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQYPQRCodePreviewActivity()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      super.finish();
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
    this.c = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("fromInternal", true);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("error", false);
    if ((this.jdField_b_of_type_JavaLangString == null) || (this.c == null)) {
      this.jdField_b_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
      a(getString(2131372298));
      return;
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable == null) {
        this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable = new QQYPQRCodePreviewActivity.RefreshHeadRunnable(this);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;) {}
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131302682);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302683));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302684));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302680);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302681));
    this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables()[0].setColorFilter(getResources().getColor(2131428127), PorterDuff.Mode.SRC_IN);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131302687));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    if (ImmersiveUtils.isSupporImmersive() == 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.topMargin -= ImmersiveUtils.a(this);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.topMargin -= ImmersiveUtils.a(this);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(super.getApplicationContext(), SplashActivity.class);
      localIntent.setFlags(335544320);
      super.startActivity(localIntent);
    }
    super.finish();
    super.overridePendingTransition(2130968592, 2130968593);
  }
  
  public void a(String paramString)
  {
    Object localObject = new hip(this);
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903236);
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener((DialogInterface.OnDismissListener)localObject);
    }
    localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297840);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852)).setText(paramString);
    paramString = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297843);
    if (paramString != null) {
      paramString.setVisibility(8);
    }
    paramString = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297844);
    if (paramString != null)
    {
      paramString.setText(2131367263);
      paramString.setOnClickListener(this);
    }
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_b_of_type_Boolean) {
      a();
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)) {
      ReportController.b(null, "CliOper", "", "", "0X8005F1F", "0X8005F1F", 0, 0, "", "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label242:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492908));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载，请稍候...");
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        if (this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$TimeoutRunnable != null) {
          break label242;
        }
        this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$TimeoutRunnable = new QQYPQRCodePreviewActivity.TimeoutRunnable(this);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$TimeoutRunnable, 4000L);
        paramView = new Bundle();
        paramView.putString("invoke_cmd", "BusinessHandler_voiceCall");
        paramView.putString("businessName", this.jdField_b_of_type_JavaLangString);
        paramView.putString("uin", this.c);
        paramView.putString("from_where", "qrCodeConfirm");
        Intent localIntent = new Intent(this, HYBlankActivity.class);
        localIntent.putExtra("Bundle", paramView);
        localIntent.addFlags(268435456);
        super.startActivity(localIntent);
        ReportController.b(null, "CliOper", "", "", "0X8005F1E", "0X8005F1E", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$TimeoutRunnable);
      }
      a();
      ReportController.b(null, "CliOper", "", "", "0X8005F1F", "0X8005F1F", 0, 0, "", "", "", "");
      return;
    } while (this.jdField_a_of_type_AndroidAppDialog == null);
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Exception paramView) {}
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.setTheme(2131559171);
    super.onCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    try
    {
      super.getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      super.setContentView(2130904427);
      paramBundle = (RelativeLayout)findViewById(2131302679);
      Drawable localDrawable = BitmapTools.a(super.getApplicationContext(), 2130839128);
      if (localDrawable != null)
      {
        paramBundle.setBackgroundDrawable(localDrawable);
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
        b();
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobile.qq.action.hycontroluiready");
        paramBundle.addAction("com.tencent.mobile.qq.action.voicecall.failed");
        paramBundle.addAction("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
        this.jdField_a_of_type_Hiq = new hiq(this, null);
        super.registerReceiver(this.jdField_a_of_type_Hiq, paramBundle);
        a(getIntent());
        return;
      }
    }
    catch (NoSuchFieldException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "Not exist FLAG_NEEDS_MENU_KEY filed", paramBundle);
        }
      }
    }
    catch (IllegalAccessException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "Could not access FLAG_NEEDS_MENU_KEY", paramBundle);
          continue;
          paramBundle.setBackgroundResource(2130839128);
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Hiq != null) {
      super.unregisterReceiver(this.jdField_a_of_type_Hiq);
    }
    if (this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$TimeoutRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$TimeoutRunnable);
    }
    if (this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\huangye\QQYPQRCodePreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */