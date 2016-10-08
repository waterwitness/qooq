package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import gwp;
import gwq;
import gwr;
import gws;
import gwt;
import gwu;
import gwv;
import gww;
import gwx;
import gwy;
import gwz;
import java.lang.reflect.Field;
import java.util.Timer;
import mqq.app.BaseActivity;

public class MultiVideoEnterPageActivity
  extends BaseActivity
{
  static final String jdField_a_of_type_JavaLangString = "MultiVideoEnterPage";
  int jdField_a_of_type_Int;
  public long a;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public MeetingInfo a;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver;
  public MultiMembersAudioUI a;
  public Runnable a;
  public boolean a;
  long[] jdField_a_of_type_ArrayOfLong;
  public MultiVideoEnterPageMembersControlUI[] a;
  int jdField_b_of_type_Int;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public TextView b;
  Runnable jdField_b_of_type_JavaLangRunnable;
  public String b;
  public int c;
  public TextView c;
  Runnable jdField_c_of_type_JavaLangRunnable;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  public TextView d;
  public Runnable d;
  String jdField_d_of_type_JavaLangString;
  public int e;
  TextView e;
  public int f;
  public int g;
  final int h;
  final int i;
  
  public MultiVideoEnterPageActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_e_of_type_Int = 0;
    this.f = 0;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Boolean = false;
    this.g = 0;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gwr(this);
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = new gwv(this);
    this.h = 0;
    this.i = 1;
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299327: 
      b(10);
      return;
    }
    if (this.jdField_b_of_type_Int == 1) {
      if (this.f == 10) {
        ReportController.b(null, "CliOper", "", "", "0X8005934", "0X8005934", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      super.finish();
      super.overridePendingTransition(0, 2130968685);
      return;
      ReportController.b(null, "CliOper", "", "", "0X80046DB", "0X80046DB", 0, 0, "", "", "", "");
      continue;
      if (this.jdField_b_of_type_Int == 3000) {
        ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_icon_chatmember", 0, 0, "", "", "", "");
      }
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299316));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299322));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299321));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299326));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299318));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)findViewById(2131299320));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299323));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299327));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131299325));
    this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299319));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131299317));
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label609;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      }
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = new MultiVideoEnterPageMembersControlUI[2];
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0] = new MultiVideoEnterPageMembersControlUI(this);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0], localLayoutParams);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(MultiVideoEnterPageMembersControlUI.jdField_c_of_type_Int);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setLowHeightMode();
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new gwp(this));
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] = new MultiVideoEnterPageMembersControlUI(this);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1], localLayoutParams);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(MultiVideoEnterPageMembersControlUI.jdField_e_of_type_Int);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setLowHeightMode();
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new gwq(this));
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getString(2131363396));
      if (this.jdField_b_of_type_Int != 3000) {
        break label687;
      }
      UITools.a(this.jdField_a_of_type_AndroidWidgetButton, getResources().getString(2131363418));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo != null)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005576", "0X8005576", 0, 0, "", "", "", "");
        e();
        c();
        a(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getShowTimeCount() + 5000L);
      }
      return;
      label609:
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetButton == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break;
      label687:
      if (this.jdField_b_of_type_Int == 1) {
        UITools.a(this.jdField_a_of_type_AndroidWidgetButton, getResources().getString(2131363416), this.f);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "setNetTips-->type=" + paramInt);
    }
    if (this.jdField_b_of_type_JavaLangRunnable == null) {
      this.jdField_b_of_type_JavaLangRunnable = new gwy(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_b_of_type_JavaLangRunnable);
    switch (paramInt)
    {
    default: 
      paramInt = -1;
    }
    while (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      int k = arrayOfMultiVideoEnterPageMembersControlUI.length;
      int j = 0;
      while (j < k)
      {
        MultiVideoEnterPageMembersControlUI localMultiVideoEnterPageMembersControlUI = arrayOfMultiVideoEnterPageMembersControlUI[j];
        if (paramInt != -1)
        {
          localMultiVideoEnterPageMembersControlUI.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
          localMultiVideoEnterPageMembersControlUI.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        j += 1;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gws(this), 1000L);
      paramInt = -1;
      continue;
      paramInt = 2131363339;
      continue;
      paramInt = 2131363338;
    }
    if (paramInt != -1)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramInt);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  void a(long paramLong)
  {
    gwt localgwt = new gwt(this);
    new Timer().schedule(localgwt, paramLong);
  }
  
  boolean a()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoEnterPage", 2, "processExtraData-->can not get intent");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            this.jdField_a_of_type_ArrayOfLong = localIntent.getLongArrayExtra("DiscussUinList");
            this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("creator_nick");
            this.jdField_a_of_type_Int = localIntent.getIntExtra("sessionType", -1);
            if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("MultiVideoEnterPage", 2, "processExtraData-->get the wrong sessionType,Type=" + this.jdField_a_of_type_Int);
          return false;
          this.jdField_d_of_type_Int = localIntent.getIntExtra("Type", -1);
          if (this.jdField_d_of_type_Int == 3) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("MultiVideoEnterPage", 2, "processExtraData-->get the wrong GAudioStatus,Type=" + this.jdField_d_of_type_Int);
        return false;
        this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("uin");
        this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("GroupId");
        if (this.jdField_b_of_type_JavaLangString != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoEnterPage", 2, "processExtraData-->can not get the groupuin");
      return false;
      this.jdField_a_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
      if (this.jdField_a_of_type_Long != 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoEnterPage", 2, "processExtraData-->can not get the groupuin");
    return false;
    int j = localIntent.getIntExtra("MultiAVType", 0);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "Get Intent AVType : " + j);
    }
    this.f = j;
    this.jdField_b_of_type_Int = localIntent.getIntExtra("uinType", -1);
    label329:
    SessionInfo localSessionInfo;
    boolean bool;
    if (this.jdField_b_of_type_Int == 3000)
    {
      this.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo = ((MeetingInfo)localIntent.getParcelableExtra("meetingInfo"));
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo == null) {
        break label484;
      }
      bool = true;
      label361:
      localSessionInfo.S = bool;
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo == null) {
        break label496;
      }
      if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getType() != 2) {
        break label490;
      }
      bool = true;
      label396:
      localSessionInfo.T = bool;
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo == null) {
        break label508;
      }
      if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getType() != 3) {
        break label502;
      }
      bool = true;
    }
    for (;;)
    {
      localSessionInfo.U = bool;
      this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("flag", false);
      return true;
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_c_of_type_Int = 1;
        break label329;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoEnterPage", 2, "processExtraData-->can not get uin Type.");
      return false;
      label484:
      bool = false;
      break label361;
      label490:
      bool = false;
      break label396;
      label496:
      bool = false;
      break label396;
      label502:
      bool = false;
      continue;
      label508:
      bool = false;
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 25);
    localIntent.putExtra("relationId", this.jdField_a_of_type_Long);
    localIntent.putExtra("relationType", this.jdField_c_of_type_Int);
    localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvVideoController.a().D);
    localIntent.putExtra("reason", 5);
    localIntent.putExtra("from", "MultiVideoEnterPageActivity");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    super.sendBroadcast(localIntent);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "onEnterButtonClick --> AVType = " + paramInt);
    }
    c(paramInt);
    if (this.jdField_b_of_type_Int == 1) {
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005935", "0X8005935", 0, 0, "", "", "", "");
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().U) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().S)) {
          break label233;
        }
        ReportController.b(null, "CliOper", "", "", "0X800667F", "0X800667F", 0, 0, "", "", "", "");
      }
    }
    label233:
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().T) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().S))
    {
      return;
      ReportController.b(null, "CliOper", "", "", "0X80046DC", "0X80046DC", 0, 0, "", "", "", "");
      break;
      if (this.jdField_b_of_type_Int != 3000) {
        break;
      }
      if (this.jdField_e_of_type_Int <= 0)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005577", "0X8005577", 0, 0, "", "", "", "");
        break;
      }
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_join_chatmember", 0, 0, "", "", "", "");
      break;
    }
    ReportController.b(null, "CliOper", "", "", "0X8006418", "0X8006418", 0, 0, "", "", "", "");
  }
  
  public void c()
  {
    int j = NetworkUtil.a(super.getApplicationContext());
    if (NetworkUtil.g(super.getApplicationContext())) {
      j = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MultiVideoEnterPage", 2, "setNetTips,netinfo=" + j);
    }
    switch (j)
    {
    default: 
      j = -1;
    }
    while (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      int m = arrayOfMultiVideoEnterPageMembersControlUI.length;
      int k = 0;
      while (k < m)
      {
        MultiVideoEnterPageMembersControlUI localMultiVideoEnterPageMembersControlUI = arrayOfMultiVideoEnterPageMembersControlUI[k];
        if (j != -1) {
          localMultiVideoEnterPageMembersControlUI.jdField_c_of_type_AndroidWidgetTextView.setText(j);
        }
        localMultiVideoEnterPageMembersControlUI.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        k += 1;
      }
      j = 2131363596;
      continue;
      j = 2131363597;
      continue;
      j = 2131363582;
      continue;
      j = -1;
    }
    if (j != -1) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(j);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  void c(int paramInt)
  {
    if (!NetworkUtil.e(super.getApplicationContext()))
    {
      QQToast.a(super.getApplicationContext(), 2131367256, 1).b(super.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j < 7))
    {
      QQToast.a(super.getApplicationContext(), 2131363475, 1).b(super.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "BtnOnClick-->Enter MultiVideoChat-->GroupId = " + this.jdField_a_of_type_Long + " isInMultiVideoChat = " + this.jdField_a_of_type_ComTencentAvVideoController.e + " MultiVideoRoomId=" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.f = paramInt;
    }
    if (((this.jdField_a_of_type_ComTencentAvVideoController.e) && (this.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentAvVideoController.n()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.g()))
    {
      d();
      return;
    }
    d(paramInt);
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "quitGAudioChatDialog");
    }
    gwu localgwu1 = new gwu(this, 0);
    gwu localgwu2 = new gwu(this, 1);
    DialogUtil.a(this, 230, null, super.getResources().getString(2131363466), 2131363161, 2131363537, localgwu1, localgwu2).show();
  }
  
  public void d(int paramInt)
  {
    int j = paramInt;
    if (paramInt == 0) {
      j = this.jdField_a_of_type_ComTencentAvVideoController.a().D;
    }
    paramInt = j;
    if (this.jdField_b_of_type_Int == 3000)
    {
      paramInt = j;
      if (!this.jdField_a_of_type_Boolean) {
        paramInt = 1;
      }
    }
    Intent localIntent;
    if (paramInt == 2)
    {
      localIntent = new Intent(this, JumpActivity.class);
      localIntent.setData(Uri.parse("mqqapi://gvideo/open_plugin?src_type=app"));
    }
    for (;;)
    {
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("GroupId", String.valueOf(this.jdField_a_of_type_Long));
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("DiscussUinList", this.jdField_a_of_type_ArrayOfLong);
      localIntent.putExtra("MultiAVType", paramInt);
      localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
      localIntent.putExtra("uinType", this.jdField_b_of_type_Int);
      localIntent.putExtra("graySwitch", super.getIntent().getIntExtra("graySwitch", 0));
      localIntent.putExtra("ltMultiMembership", super.getIntent().getIntExtra("ltMultiMembership", 5));
      localIntent.putExtra("multiPstnAutoTranTime", super.getIntent().getIntExtra("multiPstnAutoTranTime", 100000));
      localIntent.putExtra("multiPstnMissDelayTime", super.getIntent().getIntExtra("multiPstnMissDelayTime", 20));
      localIntent.putExtra("multiPstnMissShowTime", super.getIntent().getIntExtra("multiPstnMissShowTime", 60));
      localIntent.putExtra("ipPstnEnterType", 2);
      super.startActivity(localIntent);
      super.finish();
      if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        this.jdField_a_of_type_ComTencentAvVideoController.m();
      }
      return;
      localIntent = new Intent(this, AVActivity.class);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      int k = localObject.length;
      int j = 0;
      while (j < k)
      {
        localObject[j].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        j += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("QQ电话");
    Object localObject = this.jdField_d_of_type_JavaLangString + "预约的QQ电话开始了\n";
    localObject = (String)localObject + "时间：" + this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getFormatTime() + "\n主题：" + this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getIntroduction();
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2130903581);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    if (Build.VERSION.SDK_INT >= 19) {
      super.getWindow().addFlags(67108864);
    }
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(getWindow(), true);
    }
    try
    {
      super.getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoEnterPage", 2, "onCreate-->can not get the VideoAppInterface");
        }
        super.finish();
        return;
      }
    }
    catch (NoSuchFieldException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoEnterPage", 2, "Not exist FLAG_NEEDS_MENU_KEY field,Info=" + paramBundle.getMessage());
        }
      }
    }
    catch (IllegalAccessException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoEnterPage", 2, "Could not access FLAG_NEEDS_MENU_KEY,info=" + paramBundle.getMessage());
        }
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoEnterPage", 2, "onCreate-->VideoAppInterface.PROC_STATUS_CAN_CLOSED");
        }
        super.finish();
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoEnterPage", 2, "onCreate-->can not get the VideoController");
        }
        super.finish();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoEnterPage", 2, "can not processExtraData");
        }
        super.finish();
        return;
      }
      this.jdField_a_of_type_JavaLangRunnable = new gwz(this);
      if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo == null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 15000L);
      }
      a();
      ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      if (this.jdField_d_of_type_JavaLangRunnable == null) {
        this.jdField_d_of_type_JavaLangRunnable = new gww(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_d_of_type_JavaLangRunnable);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.r = false;
    }
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoEnterPage", 2, "onResume-->mRelationType=" + this.jdField_c_of_type_Int + " mRelationId=" + this.jdField_a_of_type_Long + " avtype=" + this.jdField_a_of_type_ComTencentAvVideoController.a().D);
      }
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, this.f);
      }
    }
    else
    {
      if (this.jdField_c_of_type_JavaLangRunnable != null) {
        break label178;
      }
      this.jdField_c_of_type_JavaLangRunnable = new gwx(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 10);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 2);
      break;
      label178:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiVideoEnterPageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */