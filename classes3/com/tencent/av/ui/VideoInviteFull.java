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
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
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
import gzr;
import gzs;

public class VideoInviteFull
  extends VideoInviteActivity
{
  static final String i = "VideoInviteFull";
  LinearLayout a;
  public ProgressBar a;
  final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  Runnable jdField_b_of_type_JavaLangRunnable;
  final BroadcastReceiver c;
  public TextView c;
  final BroadcastReceiver jdField_d_of_type_AndroidContentBroadcastReceiver;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  int m;
  int n;
  int o;
  
  public VideoInviteFull()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.m = 0;
    this.n = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_JavaLangRunnable = new gzr(this);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new gzs(this, 0);
    this.jdField_c_of_type_AndroidContentBroadcastReceiver = new gzs(this, 1);
    this.jdField_d_of_type_AndroidContentBroadcastReceiver = new gzs(this, 2);
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = super.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    switch (paramView.getId())
    {
    case 2131299357: 
    default: 
    case 2131299355: 
    case 2131299359: 
    case 2131299358: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(18, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(20, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(19, false);
        return;
        this.jdField_d_of_type_Boolean = false;
        super.a(true);
        if (bool)
        {
          ReportController.b(null, "CliOper", "", "", "0X80051FF", "0X80051FF", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
        }
        else if (this.jdField_b_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004398", "0X8004398", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
        }
        else
        {
          ReportController.b(null, "CliOper", "", "", "0X80043F6", "0X80043F6", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
          continue;
          this.jdField_d_of_type_Boolean = true;
          AVReport.a().T = SystemClock.elapsedRealtime();
          super.e();
          if (bool)
          {
            ReportController.b(null, "CliOper", "", "", "0X80051FE", "0X80051FE", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
          }
          else if (this.jdField_b_of_type_Boolean)
          {
            ReportController.b(null, "CliOper", "", "", "0X8004397", "0X8004397", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
          }
          else
          {
            ReportController.b(null, "CliOper", "", "", "0X80043F5", "0X80043F5", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
            continue;
            this.jdField_a_of_type_Boolean = true;
            this.jdField_d_of_type_Boolean = true;
            super.e();
            ReportController.b(null, "CliOper", "", "", "0X80043F7", "0X80043F7", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
          }
        }
      }
    }
    super.a(this, false);
    if (bool) {
      paramView = "0X8005200";
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
      return;
      if (this.jdField_b_of_type_Boolean) {
        paramView = "0X80043A5";
      } else {
        paramView = "0X80043AB";
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.o == paramInt) {}
    while ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.o = paramInt;
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131299361));
      localObject1 = BitmapTools.a(super.getApplicationContext(), 2130839128);
      if (localObject1 == null) {
        break label501;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject1);
      label76:
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131299478));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299479));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299480));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363319);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297994));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297996));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297995));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297993));
      super.a();
      if (!VideoUtils.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.l, this.jdField_a_of_type_ComTencentAvAppSessionInfo.A)) {
        break label513;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363710);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(19, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(22, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(21, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setAcceptDrawableTop(super.getResources().getDrawable(2130839014));
      label285:
      if (UITools.b(super.getApplicationContext()) <= 480)
      {
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = super.getResources().getDimensionPixelSize(2131494091);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      super.i();
      if (!this.jdField_b_of_type_Boolean) {
        break label1081;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(20, super.getString(2131363369), this.jdField_a_of_type_ComTencentAvAppSessionInfo.D);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(18, super.getString(2131363371), this.jdField_a_of_type_ComTencentAvAppSessionInfo.D);
      localObject1 = this.jdField_e_of_type_JavaLangString + super.getString(2131363367);
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject1);
    }
    for (;;)
    {
      super.setTitle((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFull", 2, "video invite full onCreate OK");
      }
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
      break;
      label501:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839128);
      break label76;
      label513:
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.l == 9500)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(19, 8);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(22, 8);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(21, 8);
        break label285;
      }
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.l == 2800)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
        label635:
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
            break label994;
          }
        }
        label994:
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
          break label635;
        }
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label285;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(19, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(22, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(21, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363549);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setAcceptDrawableTop(super.getResources().getDrawable(2130839014));
      break label285;
      label1081:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(20, super.getString(2131363369));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(18, super.getString(2131363371));
      localObject1 = this.jdField_e_of_type_JavaLangString + super.getString(2131363367);
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject1);
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.d(paramBoolean);
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
    IntentFilter localIntentFilter = new IntentFilter("tencent.notify.cancel.videorequest");
    super.registerReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  void m()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131299478);
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
      QLog.d("VideoInviteFull", 2, "onCreate");
    }
    AVReport.a().u = SystemClock.elapsedRealtime();
    super.onCreate(paramBundle);
    super.setContentView(2130903621);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    this.n = UITools.a(super.getApplicationContext());
    this.m = UITools.b(super.getApplicationContext());
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    super.registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    super.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
    l();
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFull", 2, "onCreate error , mSessionInfo is null");
      }
      return;
    }
    b();
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    }
    paramBundle = super.getResources();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFull", 2, "mScreenWidth = " + this.n + " , mScreenHeight = " + this.m + " , getFontLevel = " + FontSettingManager.a() + ", hasSmartBar = " + super.e());
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.n <= 320) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.topMargin = paramBundle.getDimensionPixelSize(2131494007);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    }
    if (FontSettingManager.a() >= 17.0F)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if (this.n <= 540)
      {
        localLayoutParams.topMargin = paramBundle.getDimensionPixelSize(2131494005);
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      }
      if ((this.m <= 800) || ((e()) && (this.m <= 1280)))
      {
        paramBundle = (RelativeLayout)super.findViewById(2131299353);
        localLayoutParams = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        paramBundle.setLayoutParams(localLayoutParams);
        paramBundle = (RelativeLayout)super.findViewById(2131299357);
        localLayoutParams = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        paramBundle.setLayoutParams(localLayoutParams);
      }
    }
    this.o = 1;
    if ((!NetworkUtil.i(super.getApplicationContext())) && (!NetworkUtil.g(super.getApplicationContext())))
    {
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
      this.o = 2;
      label528:
      if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.h)))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.h);
        UITools.a(this.jdField_d_of_type_AndroidWidgetTextView, this.h);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label717;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004396", "0X8004396", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.l == 21) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.l == 1011))
      {
        this.jdField_d_of_type_Boolean = true;
        super.e();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(20, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(19, false);
      }
      m();
      if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363517);
      break label528;
      label717:
      ReportController.b(null, "CliOper", "", "", "0X80043F4", "0X80043F4", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFull", 2, "onDestroy");
    }
    super.unregisterReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver);
    super.unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
    super.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g();
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.c();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label60;
      }
      ReportController.b(null, "CliOper", "", "", "0X800439A", "0X800439A", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      label60:
      ReportController.b(null, "CliOper", "", "", "0X80043F9", "0X80043F9", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.i), Integer.toString(this.j), "");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFull", 2, "onResume");
    }
    super.c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      AVReport.a().v = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\VideoInviteFull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */