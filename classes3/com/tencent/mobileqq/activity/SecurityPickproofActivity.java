package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HttpDownloadUtil.DownloadInfoListener;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mkc;
import mkd;
import org.json.JSONException;
import org.json.JSONObject;

public class SecurityPickproofActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpDownloadUtil.DownloadInfoListener
{
  public static final String a = "http://qqwx.qq.com/s?aid=index&g_f=436";
  public static final String b = "http://qqwx.qq.com/s?aid=index&g_f=442";
  public static final String c = "http://qqwx.qq.com/s?aid=index&g_f=460";
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public Long a;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  public String d;
  private boolean d;
  public String e;
  private String f;
  
  public SecurityPickproofActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=436";
    this.e = "腾讯手机管家";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    this.f = "";
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isSecurityPayOpen", JumpQqPimSecureUtil.f(this));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a()
  {
    if (getIntent().hasExtra("fromSecurityPay")) {
      this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("fromSecurityPay", false);
    }
    String str;
    if (getIntent().hasExtra("options"))
    {
      str = getIntent().getStringExtra("options");
      if (str == null) {}
    }
    try
    {
      this.jdField_d_of_type_Boolean = new JSONObject(str).getBoolean("fromSecurityPay");
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=442";
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jump_securityPay", 0, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPickproofActivity", 2, "fromSecurityPay = " + this.jdField_d_of_type_Boolean);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_d_of_type_Boolean) {
      setTitle(2131371619);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131304894));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131304895);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304893));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302295));
      return;
      setTitle(2131371609);
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131371623);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371620);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371614);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131371623);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371620);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371614);
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramDownloadInfo.e);
      if ((NetworkUtil.e(this)) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", this.e);
        paramDownloadInfo.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        UniformDownloadMgr.a().b(this.jdField_d_of_type_JavaLangString, paramDownloadInfo);
        return true;
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    }
    runOnUiThread(new mkd(this));
    return true;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904961);
    a();
    b();
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.c)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_Boolean = JumpQqPimSecureUtil.a(this);
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_d_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=460";
    }
    this.jdField_b_of_type_Boolean = JumpQqPimSecureUtil.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (UniformDownloadMgr.a().a(this.jdField_d_of_type_JavaLangString))
      {
        this.c = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131370809);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371620);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131369625);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371612);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131371615);
      }
    }
    if ((JumpQqPimSecureUtil.c(this)) || ((this.jdField_d_of_type_Boolean) && (!JumpQqPimSecureUtil.e(this))))
    {
      if (UniformDownloadMgr.a().a(this.jdField_d_of_type_JavaLangString))
      {
        this.c = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131370809);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_d_of_type_Boolean)
      {
        if (JumpQqPimSecureUtil.d(this))
        {
          c();
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371620);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131371624);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371625);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131371615);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371613);
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131371616);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371614);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.c == true) {
      finish();
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result", a().toString());
      setResult(-1, localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      this.f = this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
      if ((this.jdField_a_of_type_Boolean) && (!JumpQqPimSecureUtil.c(this)) && ((!this.jdField_d_of_type_Boolean) || (JumpQqPimSecureUtil.e(this)))) {
        break label317;
      }
      if ((this.jdField_d_of_type_Boolean) && (JumpQqPimSecureUtil.d(this)))
      {
        JumpQqPimSecureUtil.a(this, "mobileqq", 11862017);
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
        return;
      }
      ThreadManager.d(new mkc(this));
      this.c = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131370809);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      if ("http://qqwx.qq.com/s?aid=index&g_f=442".equals(this.jdField_d_of_type_JavaLangString))
      {
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
        return;
      }
    } while (!"http://qqwx.qq.com/s?aid=index&g_f=460".equals(this.jdField_d_of_type_JavaLangString));
    ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_not_install", 0, 0, "", "", "", "");
    return;
    if (JumpQqPimSecureUtil.c(this))
    {
      ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_update_mini", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_not_install", 0, 0, "", "", "", "");
    return;
    label317:
    if (this.jdField_d_of_type_Boolean)
    {
      JumpQqPimSecureUtil.a(this, "mobileqq", 11862017);
      ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      return;
    }
    JumpQqPimSecureUtil.a(this, "mobileqq", 9109505);
    ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_jumpPimsecure", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\SecurityPickproofActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */