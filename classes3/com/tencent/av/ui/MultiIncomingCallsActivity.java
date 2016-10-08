package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AvCustomDialog;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gur;
import gus;
import gut;
import guu;
import guw;
import gux;
import guy;
import guz;
import gva;
import java.util.Timer;
import mqq.app.BaseActivity;

public class MultiIncomingCallsActivity
  extends BaseActivity
{
  public static String a;
  private static final int jdField_e_of_type_Int = 30000;
  private static final int jdField_f_of_type_Int = 60000;
  public static boolean f;
  public int a;
  public long a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  public Handler a;
  public ImageView a;
  public TextView a;
  SessionMgr jdField_a_of_type_ComTencentAvSessionMgr = SessionMgr.a();
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new guw(this);
  public SessionInfo a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new gux(this);
  AvCustomDialog jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = null;
  public QAVNotification a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  Timer jdField_a_of_type_JavaUtilTimer = null;
  public boolean a;
  long[] jdField_a_of_type_ArrayOfLong = null;
  int jdField_b_of_type_Int = 0;
  public long b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 3;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  public String c;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = -1;
  String jdField_d_of_type_JavaLangString = null;
  public boolean d;
  public String e;
  boolean jdField_e_of_type_Boolean = false;
  String jdField_f_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "MultiIncomingCallsActivity";
  }
  
  public MultiIncomingCallsActivity()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new guz(this);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.p) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.jdField_b_of_type_Long));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.jdField_a_of_type_ArrayOfLong);
    localIntent.putExtra("needStartTRAE", true);
    localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvAppSessionInfo.D);
    localIntent.putExtra("uin", String.valueOf(this.jdField_b_of_type_Long));
    localIntent.putExtra("uinType", this.jdField_a_of_type_Int);
    localIntent.putExtra("HasMeetingFlag", this.jdField_d_of_type_Boolean);
    localIntent.putExtra("isFromInviteDialog", true);
    super.startActivity(localIntent);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Long localLong;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "closeSession reason = " + paramInt);
      }
      localLong = Long.valueOf(CharacterUtil.a(this.jdField_c_of_type_JavaLangString));
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(localLong.longValue(), 7);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentAvVideoController.a(localLong.longValue(), 2);
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 0);
  }
  
  void a(int paramInt1, long paramLong, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    for (;;)
    {
      return;
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramInt1, paramLong, 10, false);
      }
      while ((paramBoolean1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(3) });
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramInt1, paramLong, paramInt2, false);
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("peerUin");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("extraUin");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("uinType", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("relationType", 3);
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("memberType", -1);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("hasGVideoJoined", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("isAudioMode", false);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("bindType", 0);
    String str = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    if (this.jdField_a_of_type_Boolean)
    {
      str = SessionMgr.a(10, this.jdField_c_of_type_JavaLangString, new int[0]);
      this.jdField_b_of_type_Boolean = false;
    }
    if (b(this.jdField_a_of_type_Int)) {
      if (paramIntent.getIntExtra("MultiAVType", -1) == 2)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
        this.jdField_b_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
        str = SessionMgr.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_b_of_type_Long), new int[] { paramIntent.getIntExtra("MultiAVType", -1) });
        this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
        if ((MeetingInfo)paramIntent.getParcelableExtra("meetingInfo") != null) {
          break label412;
        }
        this.jdField_d_of_type_Boolean = false;
        label266:
        if (this.jdField_a_of_type_Int != 1) {
          break label420;
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Long));
        ReportController.b(null, "dc00899", "Grp_video", "", "invite", "tip_exp", 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().s, this.jdField_d_of_type_Int + "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str);
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) || (this.jdField_a_of_type_Int == 1)) {
        break label588;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "session info null!");
      }
      b();
      return;
      this.jdField_b_of_type_Boolean = true;
      break;
      label412:
      this.jdField_d_of_type_Boolean = true;
      break label266;
      label420:
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, String.valueOf(this.jdField_b_of_type_Long), null, true, false);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_c_of_type_JavaLangString.equals(Long.valueOf(this.jdField_a_of_type_Long))))
      {
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          this.jdField_a_of_type_JavaLangRunnable = new guy(this);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        continue;
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
      }
    }
    label588:
    b(paramIntent);
  }
  
  public void a(Intent paramIntent, SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptRequest");
    }
    this.jdField_e_of_type_Boolean = true;
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvVideoController.g(true);
    }
    while ((this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) && (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Session already destroyed, id:" + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString + ", status = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.j);
      }
      return;
      if ((paramSessionInfo != null) && (localSessionInfo == paramSessionInfo))
      {
        if (SessionMgr.a().a() >= 2)
        {
          if (paramSessionInfo.d()) {
            a(false, paramSessionInfo);
          }
          for (;;)
          {
            a(paramSessionInfo);
            break;
            this.jdField_a_of_type_ComTencentAvVideoController.a(true, 7, new int[] { localSessionInfo.D });
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "no need to close main session because there is only one session");
        }
      }
      else if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("mainSession invalid when accept 3rd request, currMainSession == mainSessionInfo:");
        if (localSessionInfo == paramSessionInfo) {}
        for (;;)
        {
          QLog.d(str, 2, bool);
          break;
          bool = false;
        }
      }
    }
    if (b(this.jdField_a_of_type_Int))
    {
      a();
      return;
    }
    c(paramIntent);
  }
  
  void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if (this.jdField_a_of_type_Int != 1) {
      paramTextView.setSingleLine();
    }
    if (b(this.jdField_a_of_type_Int))
    {
      float f1 = super.getResources().getDimensionPixelSize(2131494102);
      if (this.jdField_d_of_type_Boolean) {
        f1 = super.getResources().getDimensionPixelSize(2131494103);
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        UITools.a(super.getApplicationContext(), this.jdField_b_of_type_JavaLangString, paramTextView, f1);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        localObject = super.getResources().getString(2131363903);
        if (this.jdField_a_of_type_Int == 1)
        {
          localObject = getString(2131365269, new Object[] { StringUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, this.jdField_b_of_type_Long + "", null), 0, 14, "...") });
          paramTextView.setMaxLines(2);
        }
        paramTextView.setText((CharSequence)localObject);
        return;
      }
      Object localObject = super.getResources();
      if (this.jdField_b_of_type_Boolean) {}
      for (i = 2131363901;; i = 2131363902)
      {
        localObject = ((Resources)localObject).getString(i);
        break;
      }
    }
    if (VideoUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int))
    {
      paramTextView.setText(2131363900);
      return;
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {}
    for (int i = 2131363898;; i = 2131363899)
    {
      paramTextView.setText(i);
      return;
    }
  }
  
  void a(SessionInfo paramSessionInfo)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSessionInfo != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramSessionInfo.jdField_e_of_type_Long);
      localIntent.putExtra("peerUin", paramSessionInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    a(paramBoolean, paramSessionInfo, -1);
  }
  
  public void a(boolean paramBoolean, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramBoolean) {
      this.jdField_e_of_type_Boolean = false;
    }
    TraeHelper.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    Object localObject = this.jdField_c_of_type_JavaLangString;
    boolean bool1 = this.jdField_a_of_type_Boolean;
    int i = this.jdField_c_of_type_Int;
    long l = this.jdField_b_of_type_Long;
    if (!paramBoolean) {
      if (paramSessionInfo != null)
      {
        String str = paramSessionInfo.jdField_c_of_type_JavaLangString;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = paramSessionInfo.t;
        }
        bool1 = paramSessionInfo.z;
        i = paramSessionInfo.F;
        l = paramSessionInfo.jdField_e_of_type_Long;
      }
    }
    for (;;)
    {
      int j = UITools.b(i);
      if ((!paramBoolean) && ((bool1) || (c(j)))) {}
      for (boolean bool2 = true; b(j); bool2 = false)
      {
        a(i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(bool1, (String)localObject, bool2, paramBoolean);
      return;
    }
  }
  
  void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "refuseDoubleCall");
    }
    long l2;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, 1, true);
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = CharacterUtil.a(paramString);
        if (!paramBoolean3)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(3, l1, 10, false);
          this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 23);
          if ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "", localNumberFormatException);
        l1 = l2;
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.b(3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 1);
        continue;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, 0);
      if (!paramBoolean3) {
        this.jdField_a_of_type_ComTencentAvVideoController.c(paramString, 23);
      } else {
        this.jdField_a_of_type_ComTencentAvVideoController.c(paramString, 1);
      }
    }
  }
  
  boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initEnvParam");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.l();
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().g()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().h()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "initEnvParam closeSession");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 2);
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Int == 1)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        localObject = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
        ((Intent)localObject).putExtra("relationId", this.jdField_b_of_type_Long + "");
        ((Intent)localObject).putExtra("dealResult", paramInt);
        ((Intent)localObject).putExtra("inviteId", this.jdField_e_of_type_JavaLangString);
        ((Intent)localObject).putExtra("friendUin", this.jdField_a_of_type_Long);
        ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "sendBroadcast, qav_gaudio_join");
        }
        if (paramInt != 1) {
          break label210;
        }
      }
    }
    label210:
    for (Object localObject = "tip_in";; localObject = "tip_no")
    {
      ReportController.b(null, "dc00899", "Grp_video", "", "invite", (String)localObject, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().s, this.jdField_d_of_type_Int + "", "", "");
      bool1 = true;
      return bool1;
    }
  }
  
  public void b()
  {
    c();
    super.finish();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destroyUI");
    }
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null))
    {
      Intent localIntent = new Intent("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END");
      localIntent.putExtra("relationId", this.jdField_b_of_type_Long + "");
      localIntent.putExtra("inviterUin", this.jdField_a_of_type_Long + "");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendBroadcast, ACTION_GROUP_VEDIO_INVITE_END");
      }
    }
  }
  
  public void b(int paramInt)
  {
    label243:
    label1335:
    for (;;)
    {
      SessionInfo localSessionInfo;
      int i;
      int j;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      Object localObject11;
      synchronized (this.jdField_a_of_type_ComTencentAvSessionMgr)
      {
        localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
        if ((localSessionInfo == null) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a() < 2)) {
          return;
        }
        i = localSessionInfo.j;
        j = localSessionInfo.jdField_e_of_type_Int;
        ??? = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
        localObject7 = null;
        localObject8 = null;
        localObject9 = null;
        localObject10 = null;
        localObject11 = null;
        String str = null;
        if ((localSessionInfo.l != 21) && ((localSessionInfo.l != 1011) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info == null) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int <= 0) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1))) {
          break label243;
        }
        if (paramInt == 0)
        {
          str = "0X8005BB9";
          ??? = str;
          if (!QLog.isColorLevel()) {
            break label1335;
          }
          QLog.d("TAG", 2, "double random chat, action:" + paramInt + ", reportType:" + str);
          ??? = str;
          if (??? == null) {
            break;
          }
          ReportController.b(null, "CliOper", "", "", (String)???, (String)???, 0, 0, "", "", "", "");
          return;
        }
      }
      Object localObject3;
      if (paramInt == 1)
      {
        localObject3 = "0X8005BBA";
      }
      else if (paramInt == 2)
      {
        localObject3 = "0X8005BBB";
        continue;
        if ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int != 0) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L))
        {
          if (paramInt == 0) {
            localObject3 = "0X8005BBF";
          }
          for (;;)
          {
            ??? = localObject3;
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            QLog.d("TAG", 2, "multi gonghui, action:" + paramInt + ", reportType:" + (String)localObject3);
            ??? = localObject3;
            break;
            if (paramInt == 1)
            {
              localObject3 = "0X8005BC0";
            }
            else
            {
              localObject3 = ???;
              if (paramInt == 2) {
                localObject3 = "0X8005BC1";
              }
            }
          }
        }
        if ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info != null) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3))
        {
          if (paramInt == 0) {
            localObject3 = "0X8005BBC";
          }
          for (;;)
          {
            ??? = localObject3;
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            QLog.d("TAG", 2, "multi random chat, action:" + paramInt + ", reportType:" + (String)localObject3);
            ??? = localObject3;
            break;
            if (paramInt == 1)
            {
              localObject3 = "0X8005BBD";
            }
            else
            {
              localObject3 = localObject4;
              if (paramInt == 2) {
                localObject3 = "0X8005BBE";
              }
            }
          }
        }
        if (localSessionInfo.z)
        {
          if (paramInt == 0) {
            localObject3 = "0X8005BAA";
          }
          for (;;)
          {
            ??? = localObject3;
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            QLog.d("TAG", 2, "double share, action:" + paramInt + ", reportType:" + (String)localObject3);
            ??? = localObject3;
            break;
            if (paramInt == 1)
            {
              localObject3 = "0X8005BAB";
            }
            else
            {
              localObject3 = localObject5;
              if (paramInt == 2) {
                localObject3 = "0X8005BAC";
              }
            }
          }
        }
        if ((localSessionInfo.F == 1) && (localSessionInfo.f == 3))
        {
          if (paramInt == 0) {
            localObject3 = "0X8005BB3";
          }
          for (;;)
          {
            ??? = localObject3;
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            QLog.d("TAG", 2, "group audio, action:" + paramInt + ", reportType:" + (String)localObject3);
            ??? = localObject3;
            break;
            if (paramInt == 1)
            {
              localObject3 = "0X8005BB4";
            }
            else
            {
              localObject3 = localObject6;
              if (paramInt == 2) {
                localObject3 = "0X8005BB5";
              }
            }
          }
        }
        if ((localSessionInfo.F == 1) && (localSessionInfo.f == 4))
        {
          if (paramInt == 0) {
            localObject3 = "0X8005BB6";
          }
          for (;;)
          {
            ??? = localObject3;
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            QLog.d("TAG", 2, "group video, action:" + paramInt + ", reportType:" + (String)localObject3);
            ??? = localObject3;
            break;
            if (paramInt == 1)
            {
              localObject3 = "0X8005BB7";
            }
            else
            {
              localObject3 = localObject7;
              if (paramInt == 2) {
                localObject3 = "0X8005BB8";
              }
            }
          }
        }
        if ((localSessionInfo.F == 2) && (localSessionInfo.f == 3))
        {
          if (paramInt == 0) {
            localObject3 = "0X8005BAD";
          }
          for (;;)
          {
            ??? = localObject3;
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            QLog.d("TAG", 2, "discuss audio, action:" + paramInt + ", reportType:" + (String)localObject3);
            ??? = localObject3;
            break;
            if (paramInt == 1)
            {
              localObject3 = "0X8005BAE";
            }
            else
            {
              localObject3 = localObject8;
              if (paramInt == 2) {
                localObject3 = "0X8005BAF";
              }
            }
          }
        }
        if ((localSessionInfo.F == 2) && (localSessionInfo.f == 4))
        {
          if (paramInt == 0) {
            localObject3 = "0X8005BB0";
          }
          for (;;)
          {
            ??? = localObject3;
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            QLog.d("TAG", 2, "discuss video, action:" + paramInt + ", reportType:" + (String)localObject3);
            ??? = localObject3;
            break;
            if (paramInt == 1)
            {
              localObject3 = "0X8005BB1";
            }
            else
            {
              localObject3 = localObject9;
              if (paramInt == 2) {
                localObject3 = "0X8005BB2";
              }
            }
          }
        }
        if ((localSessionInfo.f == 2) || ((localSessionInfo.h == 2) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject3 = "0X8005BA7";
          }
          for (;;)
          {
            ??? = localObject3;
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "double video, action:" + paramInt + ", reportType:" + (String)localObject3);
            ??? = localObject3;
            break;
            if (paramInt == 1)
            {
              localObject3 = "0X8005BA8";
            }
            else
            {
              localObject3 = localObject10;
              if (paramInt == 2) {
                localObject3 = "0X8005BA9";
              }
            }
          }
        }
        if ((localSessionInfo.f == 1) || ((localSessionInfo.h == 1) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject3 = "0X8005BA4";
          }
          for (;;)
          {
            ??? = localObject3;
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "double audio, action:" + paramInt + ", reportType:" + (String)localObject3);
            ??? = localObject3;
            break;
            if (paramInt == 1)
            {
              localObject3 = "0X8005BA5";
            }
            else
            {
              localObject3 = localObject11;
              if (paramInt == 2) {
                localObject3 = "0X8005BA6";
              }
            }
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "nothing, action:" + paramInt + ", reportType:" + null);
          QLog.d(jdField_a_of_type_JavaLangString, 2, "reportType:" + null + "SessionType:" + localSessionInfo.f + ", BeginSessionType:" + localSessionInfo.h + ", sessionStatus:" + j + ", state:" + i);
        }
        ??? = null;
      }
    }
  }
  
  void b(Intent paramIntent)
  {
    c();
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = new AvCustomDialog(this);
    Object localObject = LayoutInflater.from(this).inflate(2130903538, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131299096));
    if (this.jdField_a_of_type_Int != 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838260);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131299097));
    if (this.jdField_a_of_type_Int != 1) {
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131299098));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131299099));
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_Int != 1)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    b(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.a((View)localObject, false);
    Button localButton = (Button)((View)localObject).findViewById(2131299101);
    localButton.setOnClickListener(new gur(this));
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.setOnCancelListener(new gus(this));
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.setOnDismissListener(new gut(this));
    localObject = (Button)((View)localObject).findViewById(2131299102);
    ((Button)localObject).setOnClickListener(new guu(this, paramIntent, SessionMgr.a().a()));
    if (b(this.jdField_a_of_type_Int))
    {
      ((Button)localObject).setText(2131363895);
      localButton.setText(2131363894);
    }
    for (;;)
    {
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        ((Button)localObject).setCompoundDrawablesWithIntrinsicBounds(super.getResources().getDrawable(2130839222), null, null, null);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839162);
        localButton.setCompoundDrawables(null, null, null, null);
        localButton.setTextColor(getResources().getColor(2131427796));
        ((Button)localObject).setCompoundDrawables(null, null, null, null);
        ((Button)localObject).setText("加入");
      }
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.show();
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165195, null, 0, null);
      return;
      ((Button)localObject).setText(2131363895);
      localButton.setText(2131363893);
    }
  }
  
  void b(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    float f1 = super.getResources().getDimensionPixelSize(2131494099);
    String str1;
    if (b(this.jdField_a_of_type_Int)) {
      if (this.jdField_c_of_type_Int == 1)
      {
        str1 = StringUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, this.jdField_b_of_type_Long + "", this.jdField_a_of_type_Long + ""), 0, 14, "...");
        paramTextView.setMaxLines(2);
        str1 = getString(2131365270, new Object[] { str1 });
      }
    }
    for (;;)
    {
      paramTextView.setText(str1);
      return;
      String str2 = String.valueOf(this.jdField_b_of_type_Long);
      str1 = super.getApplicationContext().getString(2131363446);
      int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str2);
      int i = j;
      if (j == 0)
      {
        if (this.jdField_a_of_type_ArrayOfLong != null) {
          i = this.jdField_a_of_type_ArrayOfLong.length + 1;
        }
      }
      else
      {
        label181:
        if (i <= 99) {
          break label274;
        }
        f1 = super.getResources().getDimensionPixelSize(2131494100);
      }
      for (;;)
      {
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, str2, null);
        str2 = UITools.a(super.getApplicationContext(), str2, paramTextView, f1);
        str1 = String.format(str1, new Object[] { Integer.valueOf(i) });
        str1 = str2 + str1;
        break;
        i = 1;
        break label181;
        label274:
        if (i > 999) {
          f1 = super.getResources().getDimensionPixelSize(2131494101);
        }
      }
      str1 = this.jdField_b_of_type_JavaLangString;
    }
  }
  
  boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  void c(Intent paramIntent)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startVideoChatActivity");
    }
    TraeHelper.a().a();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.r)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.q;
      i = this.jdField_a_of_type_ComTencentAvAppSessionInfo.A;
      localObject2 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte;
    }
    for (;;)
    {
      int j = paramIntent.getIntExtra("uinType", -1);
      boolean bool = paramIntent.getBooleanExtra("isAudioMode", false);
      if (this.jdField_a_of_type_Boolean)
      {
        paramIntent = super.getIntent().getStringExtra("peerUin");
        localIntent.putExtra("sessionType", 3);
        localIntent.putExtra("Type", 1);
        localIntent.putExtra("uin", paramIntent);
        localIntent.putExtra("uinType", 0);
        localIntent.putExtra("isDoubleVideoMeeting", true);
        localIntent.putExtra("inviteUin", paramIntent);
        localIntent.putExtra("sessionType", 1);
        localIntent.putExtra("isSender", false);
        localIntent.putExtra("isEnter", true);
        localIntent.putExtra("name", this.jdField_b_of_type_JavaLangString);
        super.startActivity(localIntent);
        super.overridePendingTransition(2130968714, 2130968713);
        return;
      }
      localIntent.putExtra("uinType", j);
      localIntent.putExtra("bindType", i);
      localIntent.putExtra("bindId", (String)localObject1);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("name", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("extraUin", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("receive", true);
      localIntent.putExtra("isAudioMode", bool);
      localIntent.putExtra("sig", (byte[])localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder().append("startVideoChatActivity: bindType = ").append(i).append(",bindId = ").append((String)localObject1).append(",BindType = ");
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
        {
          paramIntent = "session info null";
          label424:
          QLog.d((String)localObject2, 2, paramIntent);
        }
      }
      else
      {
        if (j == 0) {
          localIntent.putExtra("isFriend", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString));
        }
        if (!bool) {
          break label503;
        }
        localIntent.putExtra("sessionType", 1);
      }
      for (;;)
      {
        localIntent.putExtra("isSender", false);
        break;
        paramIntent = Integer.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.A);
        break label424;
        label503:
        localIntent.putExtra("sessionType", 2);
      }
      i = -1;
      localObject1 = null;
    }
  }
  
  boolean c(int paramInt)
  {
    return paramInt == 3000;
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (!b(this.jdField_a_of_type_Int))
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_a_of_type_Int, 2);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_a_of_type_Int, 1);
      return;
    }
    Object localObject = String.valueOf(this.jdField_b_of_type_Long);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject, null, true, true);
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, Long.toString(this.jdField_a_of_type_Long), (String)localObject);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, 3000, 3);
  }
  
  protected void e()
  {
    gva localgva;
    Timer localTimer;
    if (b(this.jdField_a_of_type_Int))
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null) {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
      }
      this.jdField_a_of_type_JavaUtilTimer = new Timer(true);
      localgva = new gva(this);
      localTimer = this.jdField_a_of_type_JavaUtilTimer;
      if (this.jdField_c_of_type_Int != 1) {
        break label70;
      }
    }
    label70:
    for (long l = 60000L;; l = 30000L)
    {
      localTimer.schedule(localgva, l);
      return;
    }
  }
  
  protected void f()
  {
    if (b(this.jdField_a_of_type_Int))
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
    }
  }
  
  public void g()
  {
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
    localIntent.putExtra("relationId", this.jdField_b_of_type_Long + "");
    localIntent.putExtra("enterType", 1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString + ".troopgroup_vedio.invite", 2, "sendBroadcast, qav_gaudio_answer");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(514), Long.valueOf(this.jdField_b_of_type_Long) });
    a(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate");
    }
    super.onCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2130843567);
    super.getWindow().addFlags(128);
    a();
    TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(super.getIntent());
    if (this.jdField_c_of_type_Int == 1)
    {
      super.getWindow().addFlags(2097152);
      super.getWindow().addFlags(524288);
      super.getWindow().addFlags(128);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (!b(this.jdField_a_of_type_Int)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    e();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy");
    }
    c();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
    {
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.b(this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    }
    f();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "call CheckEngineActive");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(707) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.jdField_e_of_type_Boolean) && (paramInt == 4))
    {
      b(2);
      a(true, null);
      b();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNewIntent");
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause");
    }
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    jdField_f_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResume");
    }
    a(true);
    b(0);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    } while ((this.jdField_a_of_type_ComTencentAvSessionMgr.a() == null) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString)));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString);
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString;
  }
  
  protected void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onStop");
    }
    if (!super.isFinishing())
    {
      d();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(true, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiIncomingCallsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */