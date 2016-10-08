package com.tencent.av.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VExtensionInfoManager;
import com.tencent.av.utils.VideoWifiLock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import gzd;
import gze;
import gzg;
import gzh;
import gzi;
import gzj;
import gzm;
import gzo;
import gzp;
import gzq;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mqq.app.BaseActivity;

public class VideoInviteActivity
  extends BaseActivity
{
  public static int a = 0;
  static final String jdField_a_of_type_JavaLangString = "VideoInviteActivity";
  public static int b = 0;
  public static int c = 0;
  static final String jdField_g_of_type_JavaLangString = "video wifi lock";
  long jdField_a_of_type_Long = -1L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  public ImageButton a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gzm(this);
  public SessionInfo a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new gzj(this);
  public QavInOutAnimation a;
  public QavPanel a;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  TipsManager jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
  VExtensionInfoManager jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager = null;
  VideoWifiLock jdField_a_of_type_ComTencentAvUtilsVideoWifiLock;
  public VipFullScreenVideoView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new gzi(this);
  public WeakReference a;
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  public ImageButton b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  int jdField_f_of_type_Int = 0;
  public String f;
  boolean jdField_f_of_type_Boolean = true;
  int jdField_g_of_type_Int = 0;
  public boolean g;
  int jdField_h_of_type_Int = 0;
  String jdField_h_of_type_JavaLangString;
  public boolean h;
  public int i;
  public boolean i;
  public int j = 0;
  final int k = 0;
  final int l = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 60000;
    jdField_c_of_type_Int = 1;
  }
  
  public VideoInviteActivity()
  {
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    this.jdField_i_of_type_Boolean = false;
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "WL_DEBUG sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  ActionSheet a(Context paramContext)
  {
    paramContext = new gzp(this, paramContext);
    paramContext.getWindow().setWindowAnimations(2131559022);
    return paramContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {}
    label7:
    int n;
    int m;
    label184:
    do
    {
      do
      {
        break label7;
        break label7;
        break label7;
        do
        {
          return;
        } while (!this.jdField_b_of_type_Boolean);
        n = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 6, false, super.getIntent().getStringExtra("peerUin"));
      } while (n == 0);
      m = NetworkUtil.a(BaseApplicationImpl.getContext());
      if ((m == 4) || (m == 1)) {}
      for (m = 1;; m = 0)
      {
        int i1 = VipFunCallManager.a();
        localObject = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, n, VipFunCallManager.a(), null);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = VipFunCallManager.a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
        }
        File localFile = new File((String)localObject);
        if ((localFile == null) || (!localFile.exists())) {
          break label184;
        }
        if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!VipFunCallManager.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, (String)localObject, i1, null, n, false))) {
          break;
        }
        b(true);
        if (!ImmersiveUtils.a()) {
          break;
        }
        ImmersiveUtils.a(super.getWindow(), false);
        return;
      }
    } while (m == 0);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("tencent.video.v2q.AnnimateDownloadStart");
    ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    ((Intent)localObject).putExtra("callId", n);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
  }
  
  public void a(int paramInt) {}
  
  void a(Context paramContext, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.p) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    if (paramBoolean) {}
    for (paramContext = a(paramContext);; paramContext = ActionSheet.a(paramContext))
    {
      paramContext.c(2131363634);
      paramContext.c(2131363635);
      paramContext.c(2131363636);
      if (d()) {
        paramContext.c(2131363637);
      }
      paramContext.d(2131367262);
      paramContext.a(new gzd(this, paramBoolean));
      paramContext.a(new gze(this, paramContext, paramBoolean));
      paramContext.show();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = false;
    TraeHelper.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) && (!this.jdField_i_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gzg(this, paramBoolean));
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
      if (super.getIntent().getBooleanExtra("isDoubleVideoMeeting", false))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString, 1, true);
        long l1 = CharacterUtil.a(this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAvVideoController.b(3, l1);
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 1);
        this.jdField_e_of_type_Boolean = true;
        super.finish();
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString, 0);
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_d_of_type_JavaLangString, 1);
  }
  
  boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Intent localIntent = super.getIntent();
    if (localIntent != null)
    {
      this.jdField_e_of_type_Int = localIntent.getIntExtra("uinType", 0);
      this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("peerUin");
      this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("extraUin");
      this.jdField_d_of_type_Int = localIntent.getIntExtra("curUserStatus", 0);
      this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("isAudioMode", false);
      this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("powerKey", false);
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label125;
      }
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.e("VideoInviteActivity", 2, "initVideoParam uin is empty!");
      }
    }
    label125:
    for (bool1 = bool2;; bool1 = true)
    {
      this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("isPlayRing", true);
      return bool1;
    }
  }
  
  protected void b() {}
  
  public void b(boolean paramBoolean) {}
  
  boolean b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.l();
      }
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(super.getApplicationContext(), 1, "video wifi lock");
        return bool;
      }
    }
    return false;
  }
  
  public void c()
  {
    if (PhoneStatusTools.c(this)) {
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
      {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null))
        {
          this.jdField_a_of_type_Long = 0L;
          if (this.jdField_a_of_type_Long != 0L) {
            break label120;
          }
          TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165199, -1, null);
        }
      }
      else
      {
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      }
    }
    label120:
    while (!PhoneStatusTools.b(this)) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Long = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 3, false, super.getIntent().getStringExtra("peerUin"));
        continue;
        Object localObject = ColorRingManager.a(this.jdField_a_of_type_Long, 3);
        if (new File((String)localObject).exists())
        {
          TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
          ReportController.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
        }
        else
        {
          TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165199, -1, null);
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null))
          {
            localObject = new Intent();
            ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
            ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
            ((Intent)localObject).putExtra("comming_ring_down_key", this.jdField_a_of_type_Long);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
          }
        }
      }
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock == null) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(super.getApplicationContext(), 1, "video wifi lock");
    }
    if ((PhoneStatusTools.f(super.getApplicationContext())) && (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock.a();
    }
    return true;
  }
  
  public void d()
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
  
  boolean d()
  {
    return (!QQUtils.a(super.getApplicationContext())) || (Build.VERSION.SDK_INT >= 16);
  }
  
  public void e()
  {
    if (!c()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.n()))) {
      j();
    }
    for (;;)
    {
      TraeHelper.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      return;
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (SessionMgr.a().a() != null) && (SessionMgr.a().a().p)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), SessionMgr.a().a().jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
      }
      f();
    }
  }
  
  protected boolean e()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if (Build.DEVICE.equals("mx2")) {
        return true;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9"))) {
        return false;
      }
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "startVideoChatActivity");
    }
    TraeHelper.a().a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.r)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    if (super.getIntent().getBooleanExtra("isDoubleVideoMeeting", false))
    {
      String str = super.getIntent().getStringExtra("peerUin");
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("isDoubleVideoMeeting", true);
      localIntent.putExtra("inviteUin", str);
      localIntent.putExtra("sessionType", 1);
      localIntent.putExtra("isSender", false);
      localIntent.putExtra("isEnter", true);
      localIntent.putExtra("name", this.jdField_e_of_type_JavaLangString);
      super.startActivity(localIntent);
      this.jdField_e_of_type_Boolean = false;
      super.finish();
      super.overridePendingTransition(2130968714, 2130968713);
      return;
    }
    localIntent.putExtra("uinType", this.jdField_e_of_type_Int);
    localIntent.putExtra("bindType", this.jdField_f_of_type_Int);
    localIntent.putExtra("bindId", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uin", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("name", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("extraUin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("receive", true);
    localIntent.putExtra("isAudioMode", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("sig", this.jdField_a_of_type_ArrayOfByte);
    localIntent.putExtra("subServiceType", this.jdField_h_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "startVideoChatActivity: mBindType = " + this.jdField_f_of_type_Int + ",mBindId = " + this.jdField_b_of_type_JavaLangString + ",BindType = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.A);
    }
    if (this.jdField_e_of_type_Int == 0) {
      localIntent.putExtra("isFriend", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_JavaLangString));
    }
    if (this.jdField_b_of_type_Boolean) {
      localIntent.putExtra("sessionType", 1);
    }
    for (;;)
    {
      localIntent.putExtra("shutCamera", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("isSender", false);
      break;
      localIntent.putExtra("sessionType", 2);
    }
  }
  
  void g()
  {
    new AlertDialog.Builder(this).setTitle(2131363299).setMessage(super.getString(2131363300)).setNegativeButton(2131367263, null).create().show();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onVideoRequestTimeout");
    }
    TraeHelper.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gzh(this));
    }
    do
    {
      return;
      this.jdField_d_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
    if (getIntent().getBooleanExtra("isDoubleVideoMeeting", false))
    {
      long l1 = CharacterUtil.a(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvVideoController.b(3, l1);
      if (!this.jdField_g_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 2);
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_d_of_type_JavaLangString, 0);
  }
  
  public void i()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, true, true);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      localObject = UITools.a(super.getApplicationContext(), 2130839128);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        if (localObject == null) {
          break label239;
        }
        long l1 = System.currentTimeMillis();
        localObject = new BitmapDrawable((Bitmap)localObject);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("VideoInviteActivity", 2, "blur time = " + (System.currentTimeMillis() - l1) + "ms");
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
        if ((this.jdField_e_of_type_Int == 25) && (this.jdField_e_of_type_JavaLangString.equals(this.jdField_d_of_type_JavaLangString)))
        {
          this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.g;
          if (QLog.isColorLevel()) {
            QLog.w("VideoInviteActivity", 2, "mPeerName = " + this.jdField_e_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
      }
      return;
      label239:
      localObject = BitmapTools.a(super.getApplicationContext(), 2130839128);
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839128);
      }
    }
  }
  
  void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "showGAudioDialog");
    }
    gzo localgzo1 = new gzo(this, 0);
    gzo localgzo2 = new gzo(this, 1);
    DialogUtil.a(this, 230, null, super.getString(2131363466), 2131363161, 2131363537, localgzo1, localgzo2).show();
  }
  
  void k()
  {
    String str2 = "";
    int m;
    String str1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      m = this.jdField_a_of_type_ComTencentAvAppSessionInfo.l;
      str1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_JavaLangString;
    }
    for (;;)
    {
      switch (m)
      {
      default: 
        this.j = 99;
        str1 = str2;
      }
      for (;;)
      {
        this.jdField_h_of_type_JavaLangString = str1;
        return;
        if (this.jdField_h_of_type_Boolean)
        {
          this.j = 7;
          str1 = super.getString(2131363704);
        }
        else
        {
          this.j = 0;
          str1 = str2;
          continue;
          str1 = super.getString(2131363699) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, str1, null);
          this.j = 1;
          continue;
          str1 = super.getString(2131363698) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, str1, null);
          this.j = 2;
          continue;
          str1 = super.getString(2131363700);
          this.j = 3;
          continue;
          str1 = super.getString(2131363701);
          this.j = 4;
          continue;
          str1 = super.getString(2131363702);
          this.j = 5;
          continue;
          str1 = super.getString(2131363703);
          this.j = 6;
        }
      }
      str1 = null;
      m = 0;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    super.overridePendingTransition(2130968714, 0);
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      super.getWindow().addFlags(67108864);
    }
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(super.getWindow(), true);
    }
    label221:
    label270:
    int m;
    label417:
    label492:
    do
    {
      try
      {
        super.getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
        paramBundle = super.getIntent().getStringExtra("peerUin");
        this.jdField_h_of_type_Boolean = super.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
        if (this.jdField_h_of_type_Boolean)
        {
          paramBundle = SessionMgr.a(10, paramBundle, new int[0]);
          if ((b()) && (a())) {
            break label221;
          }
          if (QLog.isColorLevel()) {
            QLog.w("VideoInviteActivity", 2, "init param failure.");
          }
          this.jdField_e_of_type_Boolean = true;
          super.finish();
        }
      }
      catch (NoSuchFieldException paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoInviteActivity", 2, "Not exist FLAG_NEEDS_MENU_KEY filed", paramBundle);
          }
        }
      }
      catch (IllegalAccessException paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("VideoInviteActivity", 2, "Could not access FLAG_NEEDS_MENU_KEY", paramBundle);
            continue;
            paramBundle = SessionMgr.a(3, paramBundle, new int[0]);
          }
        }
        this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
        this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(paramBundle);
        if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
          break label270;
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) || (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.d()))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder().append("session state error! ");
          if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {
            break;
          }
          m = this.jdField_a_of_type_ComTencentAvAppSessionInfo.j;
          QLog.w("VideoInviteActivity", 2, m);
        }
        if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) || (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.c()) || (!this.jdField_d_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString))) {
          break label698;
        }
        if (QLog.isColorLevel()) {
          QLog.w("VideoInviteActivity", 2, "onCreate mPeerUin.equals(mSessionInfo.peerUin)");
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean != true))
      {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Int != 1) {
          break label732;
        }
        TraeHelper.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        TraeHelper.a().b("DEVICE_SPEAKERPHONE");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentAvVideoController.f() <= 0) {
        break label745;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b(203, this.jdField_d_of_type_JavaLangString);
      this.jdField_i_of_type_Int = PhoneStatusTools.a(this);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.q;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentAvAppSessionInfo.A;
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte;
      this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentAvAppSessionInfo.r;
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new gzq(this);
      super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      k();
    } while (this.jdField_e_of_type_Int != 25);
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getManager(10);
    if ((localPhoneContactManager != null) && (this.jdField_f_of_type_JavaLangString != null)) {}
    for (paramBundle = localPhoneContactManager.c(this.jdField_f_of_type_JavaLangString);; paramBundle = null)
    {
      if (paramBundle != null)
      {
        paramBundle = localPhoneContactManager.a(this.jdField_f_of_type_JavaLangString);
        if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramBundle)))
        {
          ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 1, 0, "", "", "", "");
          return;
          m = -1;
          break;
          label698:
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_d_of_type_JavaLangString, 2);
          this.jdField_e_of_type_Boolean = true;
          super.finish();
          return;
          label732:
          TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
          break label417;
          label745:
          this.jdField_a_of_type_ComTencentAvVideoController.b(202, this.jdField_d_of_type_JavaLangString);
          break label492;
        }
        ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 2, 0, "", "", "", "");
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock.a();
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
      this.jdField_a_of_type_ComTencentAvVideoController = null;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      if (paramInt == 4) {
        a(true);
      }
    }
    else {
      return true;
    }
    if ((paramInt == 25) || (paramInt == 24))
    {
      TraeHelper.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      if (paramInt == 26) {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onPause");
    }
    c(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onResume");
    }
    this.jdField_c_of_type_Boolean = false;
    c(true);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onStart");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onStop");
    }
    if ((PhoneStatusTools.c(this)) && (!this.jdField_d_of_type_Boolean)) {
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.w("VideoInviteActivity", 2, "onStop mSessionInfo is null ");
      }
    }
    while ((this.jdField_e_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.d())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, true, true);
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, localBitmap, null, 45, this.jdField_e_of_type_Int, 1);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, localBitmap, null, 40, this.jdField_e_of_type_Int, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\VideoInviteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */