package com.tencent.av.gaudio;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import gij;
import gik;
import gil;

public class GaInviteLockActivity
  extends GaInviteActivity
{
  public static String c;
  KeyguardManager jdField_a_of_type_AndroidAppKeyguardManager = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public QavInOutAnimation a;
  public QavPanel a;
  TextView e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = "GaInviteLockActivity";
  }
  
  public GaInviteLockActivity()
  {
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_e_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "0X8005649", "0X8005649", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      i();
      return;
      ReportController.b(null, "CliOper", "", "", "0X800420D", "0X800420D", 0, 0, "", "", "", "");
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.findViewById(2131299047));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(3);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new gij(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131299149));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299150));
    this.d = ((TextView)super.findViewById(2131299157));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BitmapTools.a(super.getApplicationContext(), 2130839128);
    View localView = super.findViewById(2131299147);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299153));
      if ((!NetworkUtil.i(super.getApplicationContext())) && ((NetworkUtil.d(super.getApplicationContext())) || (NetworkUtil.c(super.getApplicationContext()))))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131363551);
      }
      super.a();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, super.findViewById(2131299156), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.d, null);
      if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
        this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
      }
      return;
      localView.setBackgroundResource(2130839128);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gik(this));
      return;
    }
    super.c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "onCreate");
    }
    this.jdField_a_of_type_Int = UITools.a(getApplicationContext());
    this.b = UITools.b(getApplicationContext());
    super.setContentView(2130903546);
    super.onCreate(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("tencent.notify.cancel.videorequest");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new gil(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(getWindow(), true);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g();
      this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.c();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      ReportController.b(null, "CliOper", "", "", "0X800420F", "0X800420F", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gaudio\GaInviteLockActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */