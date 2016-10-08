package com.tencent.av.gaudio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VExtensionInfoManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gid;
import gie;
import gif;
import gig;
import gih;
import java.io.File;
import java.util.Timer;
import mqq.app.BaseActivity;

public class GaInviteActivity
  extends BaseActivity
{
  public static String a;
  private static final int h = 30000;
  private static final int i = 60000;
  float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  public Handler a;
  public ImageView a;
  public TextView a;
  protected MeetingInfo a;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gid(this);
  public SessionInfo a;
  public VideoAppInterface a;
  public QAVNotification a;
  VExtensionInfoManager jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  Timer jdField_a_of_type_JavaUtilTimer = null;
  public boolean a;
  long[] jdField_a_of_type_ArrayOfLong = null;
  int jdField_b_of_type_Int = 0;
  public long b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  TextView c;
  public boolean c;
  int jdField_d_of_type_Int = -1;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  boolean jdField_d_of_type_Boolean = false;
  final int e;
  public boolean e;
  final int f;
  protected boolean f;
  final int g = 2;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "GaInviteActivity";
  }
  
  public GaInviteActivity()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new gig(this);
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 1;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_Int == 1)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        localObject = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
        ((Intent)localObject).putExtra("relationId", this.jdField_c_of_type_Long + "");
        ((Intent)localObject).putExtra("dealResult", paramInt);
        ((Intent)localObject).putExtra("inviteId", this.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("friendUin", this.jdField_b_of_type_Long);
        ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "sendBroadcast, qav_gaudio_join");
        }
        if (paramInt != 1) {
          break label200;
        }
      }
    }
    label200:
    for (Object localObject = "tip_in";; localObject = "tip_no")
    {
      ReportController.b(null, "dc00899", "Grp_video", "", "invite", (String)localObject, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().s, this.jdField_d_of_type_Int + "", "", "");
      bool1 = true;
      return bool1;
    }
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (!a(0)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(2, this.jdField_c_of_type_Long, paramInt, false);
    }
    super.finish();
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startGActivity");
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.p) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), this.jdField_a_of_type_ComTencentAvAppSessionInfo.c, Boolean.valueOf(true) });
    }
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.jdField_c_of_type_Long));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.jdField_a_of_type_ArrayOfLong);
    localIntent.putExtra("needStartTRAE", true);
    if (this.jdField_e_of_type_Boolean)
    {
      localIntent.putExtra("MultiAVType", 1);
      localIntent.putExtra("uin", String.valueOf(this.jdField_c_of_type_Long));
      localIntent.putExtra("uinType", 3000);
      localIntent.putExtra("HasMeetingFlag", this.jdField_e_of_type_Boolean);
      localIntent.putExtra("isFromInviteDialog", true);
      super.startActivity(localIntent);
      super.finish();
      overridePendingTransition(2130968714, 0);
      if ((!this.jdField_a_of_type_ComTencentAvAppSessionInfo.U) || (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.S)) {
        break label289;
      }
      ReportController.b(null, "CliOper", "", "", "0X800667F", "0X800667F", 0, 0, "", "", "", "");
    }
    label289:
    while ((!this.jdField_a_of_type_ComTencentAvAppSessionInfo.T) || (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.S))
    {
      return;
      localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvAppSessionInfo.D);
      break;
    }
    ReportController.b(null, "CliOper", "", "", "0X8006418", "0X8006418", 0, 0, "", "", "", "");
  }
  
  public void c()
  {
    if (!a(0)) {
      this.jdField_a_of_type_ComTencentAvVideoController.b(2, this.jdField_c_of_type_Long);
    }
    super.finish();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer(true);
    gih localgih = new gih(this);
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (this.jdField_c_of_type_Int == 1) {}
    for (long l = 60000L;; l = 30000L)
    {
      localTimer.schedule(localgih, l);
      return;
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public void f()
  {
    long l = this.jdField_c_of_type_Long;
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Bitmap localBitmap;
    if (this.jdField_c_of_type_Int != 1)
    {
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, String.valueOf(l), null, true, false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838260);
    }
    for (;;)
    {
      String str1 = "";
      String str2 = Long.toString(this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (this.jdField_c_of_type_Int == 1) {
          break label189;
        }
        str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, str2, String.valueOf(this.jdField_c_of_type_Long));
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
        if (localBitmap != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        }
        if (((localBitmap != null) && (!str1.equals(str2))) || (this.jdField_c_of_type_Int == 1)) {
          break;
        }
        this.jdField_a_of_type_JavaLangRunnable = new gif(this);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1500L);
        return;
        label189:
        str1 = getString(2131365269, new Object[] { StringUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, this.jdField_c_of_type_Long + "", null), 0, 14, "...") });
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localBitmap = null;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "quitGAudioDialog");
    }
    gie localgie1 = new gie(this, 0);
    gie localgie2 = new gie(this, 1);
    DialogUtil.a(this, 230, null, getString(2131363466), 2131363161, 2131363537, localgie1, localgie2).show();
  }
  
  public void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "joinGroupVideo");
    }
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
    localIntent.putExtra("relationId", this.jdField_c_of_type_Long + "");
    localIntent.putExtra("enterType", 1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendBroadcast, qav_gaudio_join");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(514), Long.valueOf(this.jdField_c_of_type_Long) });
    a(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate");
    }
    super.onCreate(paramBundle);
    super.getWindow().addFlags(2097152);
    paramBundle = getIntent();
    this.jdField_b_of_type_Long = paramBundle.getLongExtra("friendUin", 0L);
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("inviteId");
    this.jdField_c_of_type_Long = paramBundle.getLongExtra("discussId", 0L);
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("memberType", -1);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("relationType", 0);
    if (this.jdField_c_of_type_Int == 1)
    {
      super.getWindow().addFlags(524288);
      super.getWindow().addFlags(128);
    }
    this.jdField_f_of_type_Boolean = paramBundle.getBooleanExtra("hasGVideoJoined", false);
    QLog.d(jdField_a_of_type_JavaLangString + ".troopgroup_vedio.invite", 2, "mHasGVideoJoined:" + this.jdField_f_of_type_Boolean);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
    String str;
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_f_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      str = SessionMgr.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_c_of_type_Long), new int[] { paramBundle.getIntExtra("MultiAVType", -1) });
      if (!SessionMgr.a().a(str)) {
        break label340;
      }
    }
    label340:
    for (this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(str);; this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a())
    {
      this.jdField_a_of_type_ArrayOfLong = paramBundle.getLongArrayExtra("memberList");
      if ((this.jdField_a_of_type_ArrayOfLong != null) || (this.jdField_c_of_type_Int == 1)) {
        break label353;
      }
      super.finish();
      return;
      if ((this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() != 0) && (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() != 1)) {
        break;
      }
      this.jdField_d_of_type_Boolean = true;
      break;
    }
    label353:
    if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_c_of_type_Long == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mInviterUin == 0 or mGroupID == 0");
      }
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp is null!");
      }
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mVideoController is null!");
      }
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo = ((MeetingInfo)paramBundle.getParcelableExtra("meetingInfo"));
    if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo == null) {}
    for (this.jdField_e_of_type_Boolean = false; (!this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Long != this.jdField_a_of_type_ComTencentAvVideoController.c()); this.jdField_e_of_type_Boolean = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "currnet invite has been canceled!");
      }
      c();
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    d();
    this.jdField_b_of_type_Boolean = true;
    if ((this instanceof GaInviteDialogActivity)) {
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      f();
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_c_of_type_Long, 0);
      return;
      if ((this instanceof GaInviteLockActivity)) {
        this.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      e();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null))
    {
      Intent localIntent = new Intent("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END");
      localIntent.putExtra("relationId", this.jdField_c_of_type_Long + "");
      localIntent.putExtra("inviterUin", this.jdField_b_of_type_Long + "");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendBroadcast, ACTION_GROUP_VEDIO_INVITE_END");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(514), Long.valueOf(this.jdField_c_of_type_Long) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      c();
    }
    for (;;)
    {
      return false;
      if ((paramInt == 26) || (paramInt == 25) || (paramInt == 24))
      {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        TraeHelper.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  protected void onPause()
  {
    if (!this.jdField_d_of_type_Boolean) {
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    TraeHelper.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_b_of_type_Boolean = false;
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject;
    if (!this.jdField_d_of_type_Boolean)
    {
      TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager = new VExtensionInfoManager(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject = this.jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        if (localObject != null)
        {
          this.jdField_a_of_type_Long = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((ExtensionInfo)localObject).uin, 3, true, null);
          if (this.jdField_a_of_type_Long != 0L) {
            break label259;
          }
          TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165199, -1, null);
        }
      }
      else
      {
        label109:
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
        label117:
        if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
          this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (!this.jdField_c_of_type_Boolean) {
            break label438;
          }
          ReportController.b(null, "CliOper", "", "", "Multi_call", "Lock_popup", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_c_of_type_Long)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "GaInvite roomUserNum is 0");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.B();
        this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_Int, this.jdField_c_of_type_Long);
        finish();
      }
      return;
      this.jdField_a_of_type_Long = 0L;
      break;
      label259:
      localObject = ColorRingManager.a(this.jdField_a_of_type_Long, 3);
      if (new File((String)localObject).exists())
      {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
        ReportController.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
        break label109;
      }
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165199, -1, null);
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      ((Intent)localObject).putExtra("comming_ring_down_key", this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
      break label109;
      if (!PhoneStatusTools.b(this)) {
        break label117;
      }
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      break label117;
      label438:
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Popup_force", 0, 0, "", "", "", "");
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (!super.isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      String str1 = String.valueOf(this.jdField_c_of_type_Long);
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, str1, null, true, true);
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, Long.toString(this.jdField_b_of_type_Long), str1);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, str2, localBitmap, str1, 43, 3000, 3);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    float f1;
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        str1 = String.valueOf(this.jdField_c_of_type_Long);
        if (this.jdField_c_of_type_Int != 1) {
          break label230;
        }
        str1 = StringUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, this.jdField_c_of_type_Long + "", this.jdField_b_of_type_Long + ""), 0, 14, "...");
        this.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131365270, new Object[] { str1 }));
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
        break label412;
      }
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, Long.toString(this.jdField_b_of_type_Long), String.valueOf(this.jdField_c_of_type_Long));
      f1 = super.getResources().getDimensionPixelSize(2131493966);
      str1 = UITools.a(super.getApplicationContext(), str1, this.jdField_d_of_type_AndroidWidgetTextView, f1);
      if (!this.jdField_e_of_type_Boolean) {
        break label381;
      }
    }
    label230:
    label375:
    label381:
    for (String str1 = str1 + "预约的QQ电话开始了";; str1 = str1 + super.getApplicationContext().getString(2131363387))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
      findViewById(2131299147).setContentDescription(str1);
      return;
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, str1, null);
      f1 = super.getResources().getDimensionPixelSize(2131493964);
      str2 = UITools.a(super.getApplicationContext(), str2, this.jdField_c_of_type_AndroidWidgetTextView, f1);
      String str3 = super.getApplicationContext().getString(2131363446);
      int k = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str1);
      int j = k;
      if (k == 0) {
        if (this.jdField_a_of_type_ArrayOfLong == null) {
          break label375;
        }
      }
      for (j = this.jdField_a_of_type_ArrayOfLong.length + 1;; j = 1)
      {
        str1 = String.format(str3, new Object[] { Integer.valueOf(j) });
        str1 = str2 + str1;
        this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
        break;
      }
    }
    label412:
    str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, Long.toString(this.jdField_b_of_type_Long), String.valueOf(this.jdField_c_of_type_Long));
    str1 = str1 + super.getApplicationContext().getString(2131363387);
    findViewById(2131299147).setContentDescription(str1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gaudio\GaInviteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */