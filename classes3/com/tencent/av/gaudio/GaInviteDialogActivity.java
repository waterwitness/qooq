package com.tencent.av.gaudio;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import gii;

public class GaInviteDialogActivity
  extends GaInviteActivity
{
  static String c;
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  Button b;
  TextView e;
  boolean g = true;
  int h = 0;
  int i = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = "GaInviteDialogActivity";
  }
  
  public GaInviteDialogActivity()
  {
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "WL_DEBUG sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131299154: 
      do
      {
        return;
        super.c();
      } while (this.jdField_c_of_type_Int == 1);
      if (this.jdField_e_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005574", "0X8005574", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_ignore ", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      paramView = new gii(this);
      if (this.f)
      {
        sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(paramView, 500L);
        return;
      }
      paramView.run();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.n())) {
      g();
    }
    while (this.jdField_e_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005573", "0X8005573", 0, 0, "", "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY:" + this.jdField_a_of_type_ComTencentAvAppSessionInfo.e);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.f)
      {
        paramView = SessionMgr.a().a();
        if (paramView != null) {
          paramView.b();
        }
        this.jdField_a_of_type_ComTencentAvVideoController.g(true);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(308), Long.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.e) });
      super.b();
    }
    ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_join", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    if ((!NetworkUtil.i(super.getApplicationContext())) && ((NetworkUtil.d(super.getApplicationContext())) || (NetworkUtil.c(super.getApplicationContext())))) {
      this.g = false;
    }
    this.jdField_a_of_type_Int = UITools.a(super.getApplicationContext());
    this.jdField_b_of_type_Int = UITools.b(super.getApplicationContext());
    this.i = super.getResources().getDimensionPixelSize(2131493956);
    this.h = super.getResources().getDimensionPixelSize(2131493959);
    RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(2131299148);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    localLayoutParams.width = this.i;
    localLayoutParams.height = this.h;
    int k;
    int j;
    if (this.jdField_b_of_type_Int > this.jdField_a_of_type_Int)
    {
      k = this.jdField_b_of_type_Int;
      j = this.jdField_a_of_type_Int;
      localLayoutParams.setMargins((j - this.i) / 2, (k - this.h) / 3, 0, 0);
      localRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299151));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299152));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299150));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131299149));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299154));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299155));
      if (this.jdField_c_of_type_Int != 1) {
        break label490;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839162);
      this.jdField_b_of_type_AndroidWidgetButton.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131427796));
      this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_AndroidWidgetButton.setText("进入");
      ReportController.b(null, "dc00899", "Grp_video", "", "invite", "tip_exp", 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().s, TroopMemberUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.jdField_a_of_type_ComTencentAvVideoController.a().s) + "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297841);
      if (!this.g)
      {
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299153));
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      super.a();
      if (this.jdField_e_of_type_Boolean)
      {
        ((TextView)super.findViewById(2131299152)).setText(2131363903);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131363302));
      }
      return;
      k = this.jdField_a_of_type_Int;
      j = this.jdField_b_of_type_Int;
      break;
      label490:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838260);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "onCreate");
    }
    super.setTheme(2131559051);
    super.setContentView(2130903545);
    super.onCreate(paramBundle);
  }
  
  protected void onPause()
  {
    super.onPause();
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gaudio\GaInviteDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */