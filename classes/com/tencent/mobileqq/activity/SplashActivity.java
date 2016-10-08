package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ProcessStats;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mmc;
import mme;
import mmf;
import mmg;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;

public class SplashActivity
  extends FragmentActivity
{
  public static final int a = 1;
  public static final String a = "SplashActivity";
  private static volatile WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public static final int b = 2;
  public static final String b = "tab_index";
  public static volatile int c = 0;
  public static final String c = "fragment_id";
  public static final String d = "switch_anim";
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public View a;
  public View[] a;
  public View b;
  private String e;
  private String f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c = 1;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("SplashActivity escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.b = str + "\n" + Log.getStackTraceString(localThrowable);
        return;
      }
    }
    BaseApplicationImpl.b = "";
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("open_chatfragment", false))
    {
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      a(false, 0);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    String str2;
    if (GesturePWDUtils.getGestureUnlockFailed(this, this.app.a()))
    {
      str2 = getString(2131370260);
      if (GesturePWDUtils.getGestureUnlockFailedType(this) != 1) {
        break label69;
      }
    }
    label69:
    for (String str1 = getString(2131370261);; str1 = getString(2131370262))
    {
      DialogUtil.a(this, 230, str2, str1, 2131367262, 2131370259, new mmf(this), new mmg(this)).show();
      return;
    }
  }
  
  private void c(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("forward", -1))
    {
    }
    for (;;)
    {
      getIntent().removeExtra("forward");
      return;
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtra("uin", paramIntent.getStringExtra("uin"));
      localIntent.putExtra("uintype", paramIntent.getIntExtra("uintype", 0));
      localIntent.putExtra("yuyin", paramIntent.getBooleanExtra("yuyin", false));
      localIntent.putExtra("uinname", paramIntent.getStringExtra("uinname"));
      localIntent.putExtra("enterchatwin", true);
      startActivity(localIntent);
      getIntent().removeExtra("fromMsgBox");
      continue;
      paramIntent = paramIntent.getParcelableExtra("AllInOne");
      if ((paramIntent instanceof ProfileActivity.AllInOne))
      {
        paramIntent = (ProfileActivity.AllInOne)paramIntent;
        paramIntent.f = 100;
        paramIntent.g = 6;
        ProfileActivity.b(this, paramIntent);
      }
    }
  }
  
  private void d()
  {
    if (AIOUtils.a) {}
    do
    {
      return;
      AIOUtils.b = getIntent().getBooleanExtra("traceviewSwitch", false);
      AIOUtils.c = getIntent().getBooleanExtra("forbidChatFont", false);
      AIOUtils.d = getIntent().getBooleanExtra("forbidHeadPendant", false);
      AIOUtils.f = getIntent().getBooleanExtra("forbidChatBubble", false);
      AIOUtils.g = getIntent().getBooleanExtra("logDBOperation", false);
      ThreadManager.b = getIntent().getBooleanExtra("logBgTaskMonitor", false);
      AIOUtils.a = true;
    } while (!QLog.isColorLevel());
    QLog.d("SplashActivity", 2, "traceviewSwitch: " + AIOUtils.b + " isForbidChatFontFun: " + AIOUtils.c + " isForbidHeadPendantFun: " + AIOUtils.d + " isForbidChatBubbleFun: " + AIOUtils.f + " logcatDBOperation: " + AIOUtils.g + " isEnableAutoDumpLeak: " + AppSetting.k);
  }
  
  public int a()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      return ((MainFragment)localFragment).a();
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 4, "clearAIO");
    }
    AIOPreLoadEngine.a().b();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment1 = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    Fragment localFragment2 = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localFragment2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "clearAIO");
      }
      localObject = ((FragmentManager)localObject).beginTransaction();
      if (localFragment2.isVisible())
      {
        c = 1;
        ((FragmentTransaction)localObject).hide(localFragment2);
        ((FragmentTransaction)localObject).show(localFragment1);
      }
      ((FragmentTransaction)localObject).remove(localFragment2).commitAllowingStateLoss();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).a(paramInt1, paramInt2, paramObject);
    }
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).a(paramInt, paramRedTypeInfo);
    }
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject2 = null;
    int i = paramIntent.getIntExtra("extra_pull_active_push_type", 0);
    if (i == 0) {
      return;
    }
    Object localObject1;
    if (i == 2)
    {
      paramIntent = paramIntent.getStringExtra("extra_pull_active_push_url");
      localObject1 = new Intent(this.app.a(), QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramIntent);
    }
    for (;;)
    {
      if (localObject1 != null) {
        startActivity((Intent)localObject1);
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.a(), "", "", "");
      return;
      localObject1 = localObject2;
      if (i == 1) {
        switch (paramIntent.getIntExtra("extra_pull_active_push_subtype", 0))
        {
        default: 
          localObject1 = localObject2;
          break;
        case 1: 
          new JumpAction(this.app, this).h();
          localObject1 = localObject2;
          break;
        case 2: 
          new JumpAction(this.app, this).i();
          localObject1 = localObject2;
          break;
        case 3: 
          localObject1 = new Intent(this.app.a(), ActivateFriendActivity.class);
          ((Intent)localObject1).putExtra("af_key_from", 4);
          break;
        case 4: 
          localObject1 = new Intent(this.app.a(), NearbyActivity.class);
          ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
          break;
        case 5: 
          localObject1 = new Intent(this.app.a(), NearbyActivity.class);
          ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject1).putExtra("TAB", 2);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    AIOPreLoadEngine.a().b();
    ThreadRegulator.a().a(1);
    StartupTracker.b(null, "AIO_Start_cost");
    if (AIOUtils.a(this, this.app, paramBoolean, getIntent())) {}
    label417:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, paramInt + "|openAIO|" + getIntent().getIntExtra("uintype", -1));
      }
      paramBoolean = getIntent().getBooleanExtra("open_chatfragment_withanim", false);
      Object localObject2 = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject2).beginTransaction();
      Object localObject1 = ((FragmentManager)localObject2).findFragmentByTag(ChatFragment.class.getName());
      localObject2 = ((FragmentManager)localObject2).findFragmentByTag(MainFragment.class.getName());
      if (localObject2 != null)
      {
        ((MainFragment)localObject2).i();
        if (((MainFragment)localObject2).a() != MainFragment.a) {
          ((MainFragment)localObject2).a(MainFragment.a);
        }
      }
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SplashActivity", 2, "openAIO f != null ");
        }
        ((ChatFragment)localObject1).c();
        c = 2;
        if (!((Fragment)localObject1).isVisible())
        {
          if ((paramBoolean) && (ProcessStats.a() > 1)) {
            localFragmentTransaction.setCustomAnimations(2130968626, 2130968631);
          }
          localFragmentTransaction.show((Fragment)localObject1);
          localFragmentTransaction.hide((Fragment)localObject2);
          localFragmentTransaction.commitAllowingStateLoss();
        }
      }
      for (;;)
      {
        if (!getIntent().getBooleanExtra("activepull_push_flag", false)) {
          break label417;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.a(), "", "", "");
        return;
        if (Math.abs(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) < 1000L)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SplashActivity", 2, "openAIO hasOpenedAIO true, renturn ");
          return;
        }
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        if ((paramBoolean) && (ProcessStats.a() > 1)) {
          localFragmentTransaction.setCustomAnimations(2130968626, 2130968631);
        }
        localObject1 = ChatFragment.a();
        c = 2;
        localFragmentTransaction.add(16908290, (Fragment)localObject1, ChatFragment.class.getName());
        localFragmentTransaction.hide((Fragment)localObject2);
        localFragmentTransaction.commitAllowingStateLoss();
        if (QLog.isColorLevel()) {
          QLog.i("SplashActivity", 2, "openAIO f == null ");
        }
      }
    }
  }
  
  public boolean a()
  {
    Object localObject = null;
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {
      localObject = (SplashActivity)jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if ((localObject != null) && (localObject != this) && (!((SplashActivity)localObject).isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "dup, " + localObject + ", " + this);
      }
      return true;
    }
    if ((NotificationActivity.a != null) && (!NotificationActivity.a.isFinishing()))
    {
      localObject = NotificationActivity.a.getIntent();
      NotificationActivity.a.finish();
      startActivity((Intent)localObject);
      return false;
    }
    if (UserguideActivity.a(this)) {
      return true;
    }
    if (!this.app.isLogin())
    {
      startActivity(new Intent(this, LoginActivity.class));
      return true;
    }
    return false;
  }
  
  public void b()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).h();
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SplashActivity", 2, "openMainFragment");
    }
    Object localObject = getSupportFragmentManager();
    MainFragment localMainFragment = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localMainFragment == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "openMainFragment mainfragment is null");
      }
      return;
    }
    if (c != 1)
    {
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localObject = (ChatFragment)((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if (paramIntent.getBooleanExtra("switch_anim", false)) {
        localFragmentTransaction.setCustomAnimations(2130968630, 2130968627);
      }
      c = 1;
      localFragmentTransaction.show(localMainFragment);
      localFragmentTransaction.hide((Fragment)localObject);
      localFragmentTransaction.commitAllowingStateLoss();
      if ((localObject != null) && (((ChatFragment)localObject).a != null)) {
        ((ChatFragment)localObject).a.a(false, 450);
      }
    }
    localMainFragment.a(paramIntent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if ((localFragment != null) && (localFragment.isVisible())) {
      ((ChatFragment)localFragment).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      return;
      localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    } while (localObject == null);
    ((MainFragment)localObject).a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int i;
    if ((BaseApplicationImpl.b != null) && (BaseApplicationImpl.b.length() > 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Intent localIntent = new Intent(getIntent());
        localIntent.addFlags(603979776);
        super.finish();
        super.superStartActivityForResult(localIntent, -1, null);
      }
      try
      {
        Thread.sleep(50L);
        System.exit(-1);
        StartupTracker.a(null, "Main_Start");
        StartupTracker.a(null, "Main_OnCreat");
        StartupTracker.a(null, "Main_super_create");
        this.mActNeedImmersive = false;
        super.doOnCreate(paramBundle);
        StartupTracker.a("Main_super_create", null);
        if (a())
        {
          finish();
          StartupTracker.a("Main_OnCreat", null);
          StartupTracker.a("Main_Start", null);
          return false;
          i = 0;
          continue;
        }
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 2, "doOnCreate killedRestore: ");
          }
          getIntent().putExtra("open_chatfragment", false);
        }
        this.app.isClearTaskBySystem = false;
        d();
        if (getIntent().getExtras() != null) {
          if ((getIntent().getExtras().containsKey("forward")) || (getIntent().getBooleanExtra("k_from_login", false))) {
            this.mCanLock = false;
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          this.e = getIntent().getStringExtra("jump_action_from_h5");
          this.f = getIntent().getStringExtra("package_from_h5");
          if (!a(getIntent()))
          {
            paramBundle = getSupportFragmentManager();
            c = 1;
            paramBundle.beginTransaction().add(16908290, MainFragment.a(), MainFragment.class.getName()).commitAllowingStateLoss();
          }
          ThreadManager.b().postDelayed(new mmc(this), 1000L);
          StartupTracker.a("Main_OnCreat", null);
          return true;
          localException = localException;
        }
        catch (Exception paramBundle)
        {
          for (;;) {}
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("SplashActivity", 1, "", localThrowable);
      }
    }
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject;
    Fragment localFragment;
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "doOnKeyDown");
      }
      localObject = getSupportFragmentManager();
      localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment == null) || (!localFragment.isVisible()))
      {
        localObject = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
        if (localObject != null) {
          return ((MainFragment)localObject).a(paramInt, paramKeyEvent);
        }
      }
      else
      {
        ((ChatFragment)localFragment).a();
        return true;
      }
    }
    if (paramInt == 82)
    {
      localObject = getSupportFragmentManager();
      localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment == null) || (!localFragment.isVisible()))
      {
        localObject = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
        if (localObject != null) {
          return ((MainFragment)localObject).a(paramInt, paramKeyEvent);
        }
      }
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnNewIntent");
    }
    if (a()) {
      finish();
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = paramIntent.getExtras();
          if (localObject == null) {
            break;
          }
        } while (a(paramIntent));
        if (Boolean.valueOf(((Bundle)localObject).getBoolean("EXIT", false)).booleanValue()) {
          finish();
        }
        if (((Bundle)localObject).getBoolean("activepull_push_flag"))
        {
          setIntent(paramIntent);
          a(paramIntent);
          return;
        }
        if ((((Bundle)localObject).getInt("fragment_id") == 1) && (c != 1))
        {
          setIntent(paramIntent);
          b(paramIntent);
          return;
        }
      } while (c != 1);
      localObject = (MainFragment)getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    } while (localObject == null);
    ((MainFragment)localObject).a(paramIntent);
  }
  
  protected void doOnResume()
  {
    boolean bool2 = true;
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnResume");
    }
    c();
    Object localObject1 = getWindow();
    if ((((Window)localObject1).getAttributes().flags & 0x400) != 0) {
      ((Window)localObject1).clearFlags(1024);
    }
    if (this.app.getKickIntent() != null) {
      startActivity(this.app.getKickIntent());
    }
    do
    {
      return;
      c(getIntent());
      Object localObject7 = this.app.getDevLockIntent();
      Object localObject2;
      String str3;
      String str4;
      String str2;
      String str1;
      boolean bool1;
      if (localObject7 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "onResume start push");
        }
        localObject2 = "";
        localObject5 = "";
        str3 = "";
        str4 = "";
        localObject6 = new ArrayList();
        str2 = str4;
        str1 = str3;
        localObject1 = localObject5;
        bool1 = bool2;
      }
      try
      {
        localObject3 = ((Intent)localObject7).getStringExtra("tipMsg");
        str2 = str4;
        str1 = str3;
        localObject1 = localObject5;
        bool1 = bool2;
        localObject2 = localObject3;
        bool2 = ((Intent)localObject7).getBooleanExtra("canCancel", true);
        str2 = str4;
        str1 = str3;
        localObject1 = localObject5;
        bool1 = bool2;
        localObject2 = localObject3;
        localObject5 = ((Intent)localObject7).getStringExtra("title");
        str2 = str4;
        str1 = str3;
        localObject1 = localObject5;
        bool1 = bool2;
        localObject2 = localObject3;
        str3 = ((Intent)localObject7).getStringExtra("secondTitle");
        str2 = str4;
        str1 = str3;
        localObject1 = localObject5;
        bool1 = bool2;
        localObject2 = localObject3;
        str4 = ((Intent)localObject7).getStringExtra("thirdTitle");
        str2 = str4;
        str1 = str3;
        localObject1 = localObject5;
        bool1 = bool2;
        localObject2 = localObject3;
        localObject7 = ((Intent)localObject7).getStringArrayListExtra("wordsList");
        localObject6 = localObject7;
        localObject2 = localObject3;
        bool1 = bool2;
        localObject1 = localObject5;
        str1 = str3;
        str2 = str4;
        localObject3 = localObject6;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3;
          Object localObject4 = localObject6;
        }
      }
      Object localObject5 = new Intent(this, DevlockPushActivity.class);
      ((Intent)localObject5).putExtra("canCancel", bool1);
      ((Intent)localObject5).putExtra("tipMsg", (String)localObject2);
      ((Intent)localObject5).putExtra("title", (String)localObject1);
      ((Intent)localObject5).putExtra("secondTitle", str1);
      ((Intent)localObject5).putExtra("thirdTitle", str2);
      ((Intent)localObject5).putStringArrayListExtra("wordsList", (ArrayList)localObject3);
      startActivity((Intent)localObject5);
      if ((!this.app.isLogin()) || (!this.app.getAccount().equals(BaseApplicationImpl.a().a()))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "onResume start push");
      }
    } while (!isResume());
    localObject1 = BaseApplicationImpl.a().a();
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "Intent is null");
      }
    }
    for (;;)
    {
      StartupTracker.a(null, "Main_Resume_PCActive");
      if ((!TextUtils.isEmpty(this.app.getAccount())) && (!"0".equals(this.app.getAccount()))) {
        ThreadManager.b().postDelayed(new mme(this), 800L);
      }
      StartupTracker.a("Main_Resume_PCActive", null);
      return;
      try
      {
        if ((NotifyPCActiveActivity.a != null) || (!(BaseActivity.sTopActivity instanceof SplashActivity))) {
          continue;
        }
        startActivity((Intent)localObject1);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "", localThrowable);
      }
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnStart");
    }
    if ((this.e != null) && (this.e.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.f)))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, this, this.e);
      localJumpAction.b(this.f);
      localJumpAction.b();
      this.e = null;
      this.f = null;
    }
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "finish()");
    }
    FragmentManager localFragmentManager = getSupportFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "finish clearAIO");
      }
      localFragmentManager.beginTransaction().remove(localFragment).commitAllowingStateLoss();
    }
    super.finish();
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() == this)) {
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  protected String getPreProcess()
  {
    return "com.tencent.mobileqq:peak";
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).b();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).a();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (FrameHelperActivity.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      DrawerFrame localDrawerFrame = (DrawerFrame)FrameHelperActivity.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localDrawerFrame != null) {
        localDrawerFrame.onConfigurationChanged(paramConfiguration);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      return localChatFragment.a(paramInt);
    }
    return null;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() == this)) {
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).a(paramLogoutReason);
    }
    a();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).g();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).e();
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.a(paramInt, paramDialog);
    }
  }
  
  public void preloadUi()
  {
    try
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(BaseApplicationImpl.a);
      this.jdField_a_of_type_ArrayOfAndroidViewView = MainFragment.a(localLayoutInflater);
      this.jdField_a_of_type_AndroidViewView = localLayoutInflater.inflate(2130903225, null);
      FPSSwipListView localFPSSwipListView = (FPSSwipListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297791);
      if (localFPSSwipListView != null) {
        this.b = localLayoutInflater.inflate(2130904933, localFPSSwipListView, false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SplashActivity", 1, "", localThrowable);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.getWindow().setFormat(-3);
  }
  
  protected String setLastActivityName()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      return ((MainFragment)localFragment).a();
    }
    return super.setLastActivityName();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */