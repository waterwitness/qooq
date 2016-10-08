package com.sixgod.pluginsdk.component;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.sixgod.pluginsdk.PluginCallback;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.a.f;
import com.sixgod.pluginsdk.b;
import com.sixgod.pluginsdk.exception.SixGodException;
import com.sixgod.pluginsdk.log.SixGodReporter;
import java.util.HashMap;

public class ContainerActivity
  extends Activity
{
  String a = "";
  com.sixgod.pluginsdk.a.a b = null;
  com.sixgod.pluginsdk.apkmanager.a c = null;
  protected PluginLoadParams d = null;
  protected com.sixgod.pluginsdk.c e = null;
  boolean f = false;
  boolean g;
  int h;
  boolean i = false;
  PluginCallback j = new c(this);
  ProgressDialog k;
  protected BroadcastReceiver l;
  Bundle m;
  private Activity n;
  private ActivityInfo o;
  private String p;
  
  private Parcelable a(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBundle != null)
    {
      localObject1 = localObject2;
      if (paramBundle.containsKey("android:fragments"))
      {
        localObject1 = paramBundle.getParcelable("android:fragments");
        paramBundle.remove("android:fragments");
      }
    }
    super.onCreate(paramBundle);
    return (Parcelable)localObject1;
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject = this.c.a(paramActivity.getComponentName());
    com.sixgod.pluginsdk.log.a.a("ContainerActiivty createInnerActivity initUI...");
    setRequestedOrientation(((ActivityInfo)localObject).screenOrientation);
    getWindow().setSoftInputMode(((ActivityInfo)localObject).softInputMode);
    try
    {
      setContentView(paramActivity.getWindow().getDecorView());
      getWindow().setAttributes(this.n.getWindow().getAttributes());
      paramActivity = "start_activity_success class = " + paramActivity.getClass().getName();
      SixGodReporter.reportInfo("StartActivity", 0, 0, this.a, "", SixGodReporter.sDevInfo, paramActivity);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = "";
      if (paramActivity != null) {
        localObject = paramActivity.getClass().getName();
      }
      paramActivity = "setContentView or postCreate failed! class = " + (String)localObject;
      SixGodReporter.reportInfo("StartActivity", 0, 1, this.a, "", SixGodReporter.sDevInfo, paramActivity);
      SixGodReporter.reportException("CreateActivityExp", localException);
      throw new SixGodException("create activity failed!", localException);
    }
  }
  
  protected final void a()
  {
    if ((this.k != null) && (this.k.isShowing()))
    {
      this.k.dismiss();
      this.k = null;
    }
  }
  
  public final void b()
  {
    Intent localIntent = getIntent();
    overridePendingTransition(0, 0);
    localIntent.addFlags(65536);
    finish();
    overridePendingTransition(0, 0);
    startActivity(localIntent);
  }
  
  public void bindPlugin(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.n = paramActivity;
    if (paramBoolean1)
    {
      Bundle localBundle = this.m;
      a(paramActivity);
    }
    if (this.c != null) {
      this.o = this.c.a(this.n.getComponentName());
    }
    this.p = this.n.getPackageName();
    paramActivity = SixGodHelper.getPluginLoader(this.p);
    this.e = paramActivity;
    this.b = paramActivity.d();
    this.c = paramActivity.c();
    this.d = paramActivity.e();
    this.o = this.c.a(this.n.getComponentName());
    if (paramBoolean2) {
      paramActivity.d().t.a(this.n, null);
    }
    if (paramBoolean3) {
      paramActivity.d().u.a(this.n, null);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.n != null) {
      try
      {
        boolean bool = this.n.dispatchKeyEvent(paramKeyEvent);
        return bool;
      }
      catch (Exception localException)
      {
        com.sixgod.pluginsdk.log.a.b("dispacth exp " + localException + " e.msg = " + localException.getMessage());
        com.sixgod.pluginsdk.log.a.b("event = " + paramKeyEvent.toString());
        return super.dispatchKeyEvent(paramKeyEvent);
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void finish()
  {
    if (this.n != null)
    {
      Integer localInteger = (Integer)this.b.aQ.a(this.n);
      Intent localIntent = (Intent)this.b.aR.a(this.n);
      if (localInteger != null) {
        super.setResult(localInteger.intValue(), localIntent);
      }
    }
    super.finish();
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject1;
    Object localObject2;
    if (this.c != null)
    {
      localObject1 = this.c;
      localObject2 = this.p;
      localObject1 = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject1).e.get(localObject2);
      if (localObject1 == null) {
        localObject1 = null;
      }
    }
    for (;;)
    {
      localObject2 = new StringBuilder("getClassLoader mPluginClassLoader == null ? ");
      if (localObject1 == null) {}
      for (boolean bool = true;; bool = false)
      {
        com.sixgod.pluginsdk.log.a.a(bool + " mPkg = " + this.p);
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = super.getClassLoader();
        }
        return (ClassLoader)localObject2;
        localObject1 = ((com.sixgod.pluginsdk.apkmanager.c)localObject1).b;
        break;
      }
      localObject1 = null;
    }
  }
  
  protected boolean isLoadPluginOnCreate()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.n != null)
    {
      if (paramIntent != null)
      {
        localObject = this.c;
        String str = this.o.packageName;
        localObject = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject).e.get(str);
        if (localObject != null) {
          break label93;
        }
      }
      label93:
      for (Object localObject = null;; localObject = ((com.sixgod.pluginsdk.apkmanager.c)localObject).b)
      {
        paramIntent.setExtrasClassLoader((ClassLoader)localObject);
        this.b.I.a(this.n, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
        return;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    super.onApplyThemeResource(paramTheme, paramInt, paramBoolean);
    if (this.n != null) {
      this.b.H.a(this.n, new Object[] { paramTheme, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    }
  }
  
  protected void onChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.n != null) {
      this.n.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onContentChanged()
  {
    super.onContentChanged();
    if (this.n != null) {
      this.n.onContentChanged();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    com.sixgod.pluginsdk.log.a.a("ContainerActiivty onCreate");
    this.m = paramBundle;
    Object localObject = super.getIntent();
    this.d = PluginLoadParams.parseFromJson(((Intent)localObject).getStringExtra("plugin_load_params"));
    this.g = ((Intent)localObject).getBooleanExtra("is_special_activity", false);
    this.h = ((Intent)localObject).getIntExtra("special_type", -1);
    this.p = ((Intent)localObject).getStringExtra("packageName");
    boolean bool = ((Intent)localObject).getBooleanExtra("preload", false);
    this.i = bool;
    if (bool)
    {
      super.onCreate(paramBundle);
      com.sixgod.pluginsdk.log.a.a("SixGod_Now", "ContainerActivity,预加载插件，设置activity属性");
      paramBundle = getWindow();
      localObject = paramBundle.getAttributes();
      ((WindowManager.LayoutParams)localObject).flags |= 0x10;
      ((WindowManager.LayoutParams)localObject).flags |= 0x8;
      paramBundle.addFlags(16);
      paramBundle.addFlags(8);
      ((WindowManager.LayoutParams)localObject).width = 1;
      ((WindowManager.LayoutParams)localObject).height = 1;
      paramBundle.setAttributes((WindowManager.LayoutParams)localObject);
      this.e = SixGodHelper.getPluginLoader(this.d.pkgName);
      if (this.e == null) {
        new Thread(new e(this)).start();
      }
    }
    label503:
    do
    {
      return;
      com.sixgod.pluginsdk.log.a.a("SixGod_Now", "ContainerActivity, 插件已经加载过，直接回调成功");
      this.j.loadPluginSucc(this.d.pkgName, this.d.pluginName);
      finish();
      return;
      if (!isLoadPluginOnCreate()) {
        break;
      }
      this.e = SixGodHelper.getPluginLoader(this.d.pkgName);
      int i1;
      Parcelable localParcelable;
      if (this.e == null)
      {
        i1 = ((Intent)localObject).getIntExtra("load_plugin_retry_idx", 1);
        if (i1 > 2)
        {
          localParcelable = a(paramBundle);
          if (localParcelable != null) {
            paramBundle.putParcelable("android:fragments", localParcelable);
          }
          finish();
          i1 = 0;
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          finish();
        }
        if (this.e == null) {
          break;
        }
        localParcelable = a(paramBundle);
        com.sixgod.pluginsdk.apkmanager.a locala = this.c;
        String str = this.p;
        if ((com.sixgod.pluginsdk.apkmanager.c)locala.e.get(str) != null) {
          break label503;
        }
        com.sixgod.pluginsdk.log.a.b("create Activity Failed! msg = appInfo null, not installed or unLaunched!");
        SixGodReporter.reportInfo("StartActivity", 0, 1, this.a, "", SixGodReporter.sDevInfo, "get PluginAppInfo null");
        finish();
        return;
        ((Intent)localObject).putExtra("load_plugin_retry_idx", i1 + 1);
        setTheme(16973840);
        new Thread(new g(this)).start();
        localParcelable = a(paramBundle);
        if (localParcelable != null) {
          paramBundle.putParcelable("android:fragments", localParcelable);
        }
        i1 = 1;
        continue;
        this.e = SixGodHelper.getPluginLoader(this.d.pkgName);
        if (this.e != null)
        {
          this.b = this.e.d();
          this.c = this.e.c();
          i1 = 1;
        }
        else
        {
          finish();
          i1 = 0;
        }
      }
      if (localParcelable != null) {}
      long l1;
      try
      {
        paramBundle.putParcelable("android:fragments", localParcelable);
        l1 = System.currentTimeMillis();
        this.n = this.e.a(this, getIntent(), paramBundle);
        if (this.n == null)
        {
          SixGodReporter.reportInfo("StartActivity", 0, 1, this.a, "", SixGodReporter.sDevInfo, "create InnerActivity failed");
          finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        com.sixgod.pluginsdk.log.a.b("create Activity Failed! msg = " + paramBundle.getMessage());
        paramBundle.printStackTrace();
        localObject = "create ActivityFailed! msg = " + paramBundle.getMessage();
        SixGodReporter.reportInfo("StartActivity", 0, 1, this.a, "", SixGodReporter.sDevInfo, (String)localObject);
        SixGodReporter.reportException("CreateActivityExp", paramBundle);
        finish();
        throw new SixGodException("Start Container Activity failed!");
      }
      this.o = this.c.a(this.n.getComponentName());
      a(this.n);
      this.e = SixGodHelper.getPluginLoader(this.d.pkgName);
      this.e.q.b(((Intent)localObject).getStringExtra("className"));
      com.sixgod.pluginsdk.log.a.a("ODPerf", "createInnerActivity dTime = " + (System.currentTimeMillis() - l1));
    } while (this.l != null);
    this.l = new i(this);
    paramBundle = new IntentFilter("com.sixgod.pluginsdk.unload_plugin.ACTION");
    registerReceiver(this.l, paramBundle);
    return;
    a(paramBundle);
  }
  
  public CharSequence onCreateDescription()
  {
    if (this.n != null) {
      return this.n.onCreateDescription();
    }
    return super.onCreateDescription();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (this.n != null) {
      return (Dialog)this.b.F.a(this.n, new Object[] { Integer.valueOf(paramInt) });
    }
    return super.onCreateDialog(paramInt);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (this.n != null) {
      return this.n.onCreatePanelMenu(paramInt, paramMenu);
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    if (this.n != null) {
      return this.n.onCreatePanelView(paramInt);
    }
    return super.onCreatePanelView(paramInt);
  }
  
  public boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas)
  {
    if (this.n != null) {
      return this.n.onCreateThumbnail(paramBitmap, paramCanvas);
    }
    return super.onCreateThumbnail(paramBitmap, paramCanvas);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (this.n != null) {
      return this.n.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.l != null) {
      unregisterReceiver(this.l);
    }
    if (this.n != null) {
      this.b.D.a(this.n, null);
    }
    if ((this.g) && (this.h != -1))
    {
      this.e.a(this.h, getClass().getName());
      this.e.b(this.h, this.n.getClass().getName());
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.n != null) {
      this.n.onLowMemory();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    ClassLoader localClassLoader = null;
    com.sixgod.pluginsdk.log.a.a("ContainerActiivty onNewIntent");
    if (paramIntent != null) {}
    for (paramIntent = (Intent)paramIntent.getParcelableExtra("plugin_intent");; paramIntent = null)
    {
      Object localObject;
      if (this.n != null) {
        if (paramIntent != null)
        {
          localObject = this.c;
          String str = this.o.packageName;
          localObject = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject).e.get(str);
          if (localObject != null) {
            break label94;
          }
        }
      }
      for (;;)
      {
        paramIntent.setExtrasClassLoader(localClassLoader);
        this.b.x.a(this.n, new Object[] { paramIntent });
        return;
        label94:
        localClassLoader = ((com.sixgod.pluginsdk.apkmanager.c)localObject).b;
      }
    }
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
    if (this.n != null) {
      this.n.onPanelClosed(paramInt, paramMenu);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.n != null) {
      this.b.A.a(this.n, null);
    }
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (this.n != null) {
      this.b.E.a(this.n, new Object[] { paramBundle });
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    super.onPrepareDialog(paramInt, paramDialog);
    if (this.n != null) {
      this.b.G.a(this.n, new Object[] { Integer.valueOf(paramInt), paramDialog });
    }
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (this.n != null) {
      return this.n.onPreparePanel(paramInt, paramView, paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.n != null) {
      this.b.v.a(this.n, null);
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle.getParcelable("android:fragments") != null)
    {
      com.sixgod.pluginsdk.log.a.a("onRestoreInstanceState fragments has");
      paramBundle.remove("android:fragments");
    }
  }
  
  protected void onResume()
  {
    com.sixgod.pluginsdk.log.a.a("ContainerActiivty onResume");
    super.onResume();
    if (this.n != null) {
      this.b.u.a(this.n, null);
    }
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    if (this.n != null) {
      return this.n.onRetainNonConfigurationInstance();
    }
    return super.onRetainNonConfigurationInstance();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    com.sixgod.pluginsdk.log.a.a("ContainerActiivty onSaveInstanceState");
    if (this.n != null)
    {
      if ((paramBundle != null) && (this.o != null) && (this.c != null))
      {
        localObject = this.c;
        String str = this.o.packageName;
        localObject = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject).e.get(str);
        if (localObject != null) {
          break label91;
        }
      }
      label91:
      for (Object localObject = null;; localObject = ((com.sixgod.pluginsdk.apkmanager.c)localObject).b)
      {
        paramBundle.setClassLoader((ClassLoader)localObject);
        this.b.y.a(this.n, new Object[] { paramBundle });
        return;
      }
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.n != null) {
      this.b.w.a(this.n, null);
    }
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if (this.n != null) {
      return this.n.onTrackballEvent(paramMotionEvent);
    }
    return super.onTrackballEvent(paramMotionEvent);
  }
  
  public void onUserInteraction()
  {
    super.onUserInteraction();
    if (this.n != null) {
      this.n.onUserInteraction();
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    if (this.n != null) {
      this.b.B.a(this.n, null);
    }
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
    if (this.n != null) {
      this.n.onWindowAttributesChanged(paramLayoutParams);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.n != null) {
      this.n.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramIntent = j.a(this, paramIntent);
    if (paramIntent == null)
    {
      com.sixgod.pluginsdk.log.a.b("startActivity from child but intent got null");
      return;
    }
    super.startActivityFromChild(paramActivity, paramIntent, paramInt);
  }
  
  public void unbindPlugin()
  {
    this.n = null;
    this.o = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\component\ContainerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */