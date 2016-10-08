package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.report.AVReport;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import gzu;
import gzv;
import gzw;

public class VideoInviteLock
  extends VideoInviteActivity
{
  public static String i;
  LinearLayout a;
  public ProgressBar a;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = null;
  Runnable jdField_b_of_type_JavaLangRunnable = new gzv(this);
  public TextView c;
  TextView d;
  int m;
  int n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_i_of_type_JavaLangString = "VideoInviteLock";
  }
  
  public VideoInviteLock()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = super.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297997: 
    case 2131299355: 
      this.jdField_d_of_type_Boolean = false;
      super.a(true);
      if (bool)
      {
        ReportController.b(null, "CliOper", "", "", "0X80051FF", "0X80051FF", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_i_of_type_Int), Integer.toString(this.j), "");
        return;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004202", "0X8004202", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_i_of_type_Int), Integer.toString(this.j), "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004206", "0X8004206", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_i_of_type_Int), Integer.toString(this.j), "");
      return;
    case 2131299359: 
      this.jdField_d_of_type_Boolean = true;
      AVReport.a().T = SystemClock.elapsedRealtime();
      super.e();
      return;
    case 2131298000: 
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
      super.e();
      ReportController.b(null, "CliOper", "", "", "0X8004207", "0X8004207", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_i_of_type_Int), Integer.toString(this.j), "");
      return;
    }
    super.a(this, true);
    if (bool) {
      paramView = "0X8005200";
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_i_of_type_Int), Integer.toString(this.j), "");
      return;
      if (this.jdField_b_of_type_Boolean) {
        paramView = "0X800439F";
      } else {
        paramView = "0X80043B1";
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if ((this.n == paramInt) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.n = paramInt;
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363340);
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363339);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363338);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.findViewById(2131299047));
    Object localObject1;
    if (this.jdField_e_of_type_Int == 2800)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(9);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new gzu(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297988));
      localObject1 = BitmapTools.a(super.getApplicationContext(), 2130839128);
      if (localObject1 == null) {
        break label341;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject1);
      label92:
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297991));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297992));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297989));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297994));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297996));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297995));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297993));
      super.a();
      if (!VideoUtils.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.l, this.jdField_a_of_type_ComTencentAvAppSessionInfo.A)) {
        break label353;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363710);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(19, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(23, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(25, 2130839015);
    }
    for (;;)
    {
      super.i();
      super.setTitle(this.jdField_e_of_type_JavaLangString + super.getString(2131363367));
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, null);
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2);
      break;
      label341:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839128);
      break label92;
      label353:
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.l == 9500)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(19, 8);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(23, 8);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.l == 2800)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(25, 2130839202);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
          label477:
          Object localObject2;
          if (UITools.b(super.getApplicationContext()) <= 800)
          {
            j = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 26.0F);
            localObject1 = new TextView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((TextView)localObject1).setId(2131297123);
            ((RelativeLayout.LayoutParams)localObject2).setMargins(0, j, 0, 0);
            ((RelativeLayout.LayoutParams)localObject2).addRule(10);
            ((RelativeLayout.LayoutParams)localObject2).addRule(14);
            ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((TextView)localObject1).setTextColor(-12297620);
            ((TextView)localObject1).setTextSize(1, 22.0F);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
            if (UITools.b(super.getApplicationContext()) > 800) {
              break label836;
            }
          }
          label836:
          for (int j = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 166.0F);; j = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 212.0F))
          {
            Object localObject3 = new RelativeLayout.LayoutParams(j, j);
            ((RelativeLayout.LayoutParams)localObject3).setMargins(0, DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 80.0F), 0, 0);
            ((RelativeLayout.LayoutParams)localObject3).addRule(10);
            ((RelativeLayout.LayoutParams)localObject3).addRule(14);
            ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2);
            localObject3 = new QavPanelSoundWaveView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ((QavPanelSoundWaveView)localObject3).setId(2131297013);
            localLayoutParams.setMargins(0, 0, 0, 0);
            localLayoutParams.addRule(15);
            localLayoutParams.addRule(14);
            ((QavPanelSoundWaveView)localObject3).setLayoutParams(localLayoutParams);
            ((QavPanelSoundWaveView)localObject3).setRoundStyle(true);
            ((RelativeLayout)localObject2).addView((View)localObject3);
            localObject3 = new ImageView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            ((ImageView)localObject3).setId(2131300338);
            localLayoutParams.setMargins(0, 0, 0, 0);
            localLayoutParams.addRule(15);
            localLayoutParams.addRule(14);
            ((ImageView)localObject3).setLayoutParams(localLayoutParams);
            ((RelativeLayout)localObject2).addView((View)localObject3);
            ((TextView)localObject1).setText(2131363622);
            ((ImageView)localObject3).setBackgroundResource(2130839213);
            break;
            j = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 36.0F);
            break label477;
          }
        }
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363549);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(19, 8);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(23, 11);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(23, 2, super.getResources().getDimensionPixelSize(2131493979));
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(25, 2130839015);
          UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, super.getResources().getString(2131363549));
        }
        else
        {
          UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, super.getResources().getString(2131363319));
        }
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e(paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131427779));
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-1291845633, PorterDuff.Mode.MULTIPLY);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131427779));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131427779));
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131427779));
      }
    }
    do
    {
      return;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
  }
  
  void l()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131297991);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int j = UITools.a(this);
    if (j <= 320)
    {
      localLayoutParams.topMargin = super.getResources().getDimensionPixelSize(2131494157);
      localLayoutParams.width = super.getResources().getDimensionPixelSize(2131494160);
      localLayoutParams.height = super.getResources().getDimensionPixelSize(2131494160);
    }
    for (;;)
    {
      localImageView.setLayoutParams(localLayoutParams);
      return;
      if (j <= 480)
      {
        localLayoutParams.topMargin = super.getResources().getDimensionPixelSize(2131494156);
        localLayoutParams.width = super.getResources().getDimensionPixelSize(2131494159);
        localLayoutParams.height = super.getResources().getDimensionPixelSize(2131494159);
      }
      else
      {
        localLayoutParams.topMargin = super.getResources().getDimensionPixelSize(2131494155);
        localLayoutParams.width = super.getResources().getDimensionPixelSize(2131494158);
        localLayoutParams.height = super.getResources().getDimensionPixelSize(2131494158);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onCreate");
    }
    AVReport.a().s = SystemClock.elapsedRealtime();
    super.onCreate(paramBundle);
    int j = UITools.a(super.getApplicationContext());
    this.m = UITools.b(super.getApplicationContext());
    super.setContentView(2130903622);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    if (!this.jdField_c_of_type_Boolean) {
      super.getWindow().addFlags(2097152);
    }
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new gzw(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("tencent.notify.cancel.videorequest");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    super.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_i_of_type_JavaLangString, 2, "onCreate error , mSessionInfo is null");
      }
      return;
    }
    b();
    this.n = 1;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    }
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.h)))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.h);
      UITools.a(this.jdField_d_of_type_AndroidWidgetTextView, this.h);
    }
    paramBundle = super.getResources();
    if (j <= 320)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.topMargin = paramBundle.getDimensionPixelSize(2131494007);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      label306:
      if ((FontSettingManager.a() == 20.0F) || (FontSettingManager.a() == 18.0F) || (FontSettingManager.a() == 17.0F))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (j <= 540)
        {
          localLayoutParams.topMargin = paramBundle.getDimensionPixelSize(2131494005);
          this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        }
        if ((FontSettingManager.a() == 20.0F) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(20, 1, super.getResources().getDimensionPixelSize(2131494027));
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(19, 2, super.getResources().getDimensionPixelSize(2131494027));
        }
        if ((this.m <= 800) || ((e()) && (this.m <= 1280))) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(24, 4, 0);
        }
      }
      if ((NetworkUtil.i(super.getApplicationContext())) || (NetworkUtil.g(super.getApplicationContext()))) {
        break label730;
      }
      if (NetworkUtil.c(super.getApplicationContext()))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363552);
      }
      if (NetworkUtil.d(super.getApplicationContext()))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363551);
      }
      this.n = 2;
      label552:
      if (!this.jdField_b_of_type_Boolean) {
        break label751;
      }
      ReportController.b(null, "CliOper", "", "", "0X800439D", "0X800439D", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_i_of_type_Int), Integer.toString(this.j), "");
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.l == 21) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.l == 1011))
      {
        this.jdField_d_of_type_Boolean = true;
        super.e();
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
          this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
        }
      }
      if (((PowerManager)super.getSystemService("power")).isScreenOn()) {
        super.c();
      }
      l();
      if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
      return;
      if (j > 540) {
        break label306;
      }
      int k = paramBundle.getDimensionPixelSize(2131493998);
      k = k * 2 / 3;
      break label306;
      label730:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363517);
      break label552;
      label751:
      ReportController.b(null, "CliOper", "", "", "0X80043FC", "0X80043FC", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_i_of_type_Int), Integer.toString(this.j), "");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDestroy");
    }
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      super.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
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
      if (this.jdField_b_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_i_of_type_Int), Integer.toString(this.j), "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.jdField_i_of_type_Int), Integer.toString(this.j), "");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      AVReport.a().t = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\VideoInviteLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */