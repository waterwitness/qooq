package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Toast;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public abstract class PluginProxyActivity
  extends Activity
{
  public static final String ACTION_PLUGIN_DIR_INFO_LOG = "com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG";
  public static final String ACTION_PLUGIN_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED";
  protected static final String INNER_INTENT_EXTRAS = "pluginsdk_inner_intent_extras";
  public static final String READER_ID = "qqreaderplugin.apk";
  private static final String b = "PluginProxyActivity";
  private static final String c = "pluginsdk_inner_bundle";
  private static String m = "";
  public static boolean mAppForground = true;
  public static boolean mGestureLockEnable;
  private static Method p;
  private static Field q;
  Object a;
  private Class d;
  private boolean e;
  private int f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private boolean l;
  public boolean mActNeedImmersive = true;
  protected String mCreateErrorInfo;
  protected FlingHandler mFlingHandler;
  protected boolean mIsShowQQBackgroundIcon = true;
  protected boolean mNeedStatusTrans = true;
  protected IPluginActivity mPluginActivity;
  protected int mStatusColor = 0;
  protected int mStopFlag;
  private boolean n = true;
  private BroadcastReceiver o = new h(this);
  
  private void a()
  {
    if (this.mCreateErrorInfo != null)
    {
      if ((this.mCreateErrorInfo.contains("空间")) || (this.mCreateErrorInfo.contains("Space"))) {
        a(BaseApplication.getContext(), "系统可用内存不足，" + this.h + "启动失败!", 0);
      }
    }
    else {
      return;
    }
    a(BaseApplication.getContext(), this.h + "启动失败!", 0);
  }
  
  private void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext.getMethod("setUinForPlugin", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, paramString });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      Toast.makeText(paramContext, paramString, paramInt).show();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext.getMethod("setAppForground", new Class[] { Context.class, Boolean.TYPE }).invoke(paramContext, new Object[] { this, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void a(Bundle paramBundle, ClassLoader paramClassLoader)
    throws Exception
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      paramBundle.setClassLoader(paramClassLoader);
      Object localObject;
      if ((p == null) || (q == null))
      {
        localObject = paramBundle.getClass();
        p = ((Class)localObject).getDeclaredMethod("unparcel", new Class[0]);
        p.setAccessible(true);
        q = ((Class)localObject).getDeclaredField("mMap");
        q.setAccessible(true);
      }
      p.invoke(paramBundle, new Object[0]);
      paramBundle = (Map)q.get(paramBundle);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.values().iterator();
        while (paramBundle.hasNext())
        {
          localObject = paramBundle.next();
          if ((localObject instanceof Bundle)) {
            a((Bundle)localObject, paramClassLoader);
          }
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("clsUploader");
    localObject = ((Intent)localObject).getStringExtra("pluginsdk_selfuin");
    if (str != null)
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
      localIntent.putExtra("pluginsdk_selfuin", (String)localObject);
      localIntent.putExtra("pluginsdk_pluginName", paramString1);
      localIntent.putExtra("pluginsdk_pluginLocation", paramString2);
      localIntent.putExtra("pluginsdk_pluginpath", this.g);
      localIntent.putExtra("pluginsdk_launchActivity", paramString3);
      localIntent.putExtra("pluginsdk_extraInfo", paramString4);
      localIntent.putExtra("clsUploader", str);
      sendBroadcast(localIntent);
    }
  }
  
  private boolean a(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getAppForground", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  private boolean a(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT")));
        paramIntent = paramIntent.getComponent();
        if (paramIntent == null) {
          break;
        }
        str = paramIntent.getPackageName();
      } while ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone")));
      paramIntent = paramIntent.getClassName();
    } while ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")));
    return false;
  }
  
  private boolean a(Throwable paramThrowable)
  {
    boolean bool2 = false;
    if (((paramThrowable instanceof FileNotFoundException)) || ((paramThrowable.getMessage() != null) && (paramThrowable.getMessage().contains("permission"))))
    {
      QLog.d("plugin_tag", 1, "" + this.g);
      paramThrowable = getApplicationInfo();
      if (paramThrowable != null) {
        if ((paramThrowable.flags & 0x1) <= 0) {
          break label163;
        }
      }
      label163:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramThrowable.flags & 0x80) > 0) {
          bool2 = true;
        }
        QLog.d("plugin_tag", 1, "UID: " + paramThrowable.uid + ", IsSystemApp: " + bool1 + ", IsUpdateSystemApp: " + bool2);
        sendBroadcast(new Intent("com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG"));
        showNeedUninstanllAndInstallDialog();
        return true;
      }
    }
    if ((paramThrowable instanceof Resources.NotFoundException))
    {
      showNeedUninstanllAndInstallDialog();
      return true;
    }
    if (((paramThrowable instanceof ClassNotFoundException)) || ((paramThrowable instanceof PluginUtils.a)))
    {
      float f1 = getAvailableInnernalMemorySize();
      QLog.d("plugin_tag", 1, "" + this.g + ", leftSpace(B) = " + f1);
      PluginRecoverReceiver.a(this, this.i);
      return false;
    }
    return shouldHandleStartPluginFailed(this.mCreateErrorInfo);
  }
  
  private void b()
    throws Exception
  {
    PackageInfo localPackageInfo = (PackageInfo)PluginStatic.d.get(this.g);
    if (localPackageInfo == null)
    {
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start getPackageInfo");
      }
      try
      {
        localPackageInfo = ApkFileParser.getPackageInfoWithException(this, this.g, 129);
        if (DebugHelper.sDebug) {
          DebugHelper.log("PluginProxyActivity.initPlugin end getPackageInfo, " + localPackageInfo);
        }
        if (localPackageInfo == null) {
          throw new PluginUtils.a("Get Package Info Failed!");
        }
      }
      catch (Throwable localThrowable)
      {
        throw new PluginUtils.a("getPackageInfoWithException", localThrowable);
      }
      PluginStatic.d.put(this.g, localThrowable);
    }
    for (;;)
    {
      if ((this.j == null) || (this.j.length() == 0))
      {
        if ((localThrowable.activities == null) || (localThrowable.activities.length == 0)) {
          throw new PluginUtils.b();
        }
        this.j = localThrowable.activities[0].name;
      }
      Object localObject = PluginStatic.a(this, this.i, this.g);
      getIntent().setExtrasClassLoader((ClassLoader)localObject);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.d = ((ClassLoader)localObject).loadClass(this.j);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.mPluginActivity = ((IPluginActivity)this.d.newInstance());
      this.mPluginActivity.IInit(this.i, this.g, this, (ClassLoader)localObject, localThrowable, this.e, this.f);
      Intent localIntent = new Intent(getIntent());
      localObject = localIntent.getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject != null)
      {
        localIntent.putExtras((Bundle)localObject);
        localIntent.removeExtra("pluginsdk_inner_intent_extras");
      }
      this.mPluginActivity.ISetIntent(localIntent);
      return;
    }
  }
  
  private boolean b(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("enableGestureLock", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private String c(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getUinForPlugin", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof String))
      {
        paramContext = (String)paramContext;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private void c()
  {
    Intent localIntent = new Intent("action_launch_completed");
    localIntent.putExtra("plugin_apk", this.i);
    sendBroadcast(localIntent);
  }
  
  private boolean d()
  {
    try
    {
      Object localObject = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      localObject = ((Class)localObject).getMethod("isAppOnForeground", new Class[] { Context.class }).invoke(localObject, new Object[] { this });
      if ((localObject instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return false;
  }
  
  public static float getAvailableInnernalMemorySize()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f1 = ((StatFs)localObject).getAvailableBlocks();
      int i1 = ((StatFs)localObject).getBlockSize();
      return i1 * f1;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  public static void openActivityForResult(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchActivity", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramActivity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.d("plugin_tag", 1, "", paramActivity);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IDispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean enablePatternLock()
  {
    return mGestureLockEnable;
  }
  
  public boolean getGestureLock(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getJumpLock", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, m });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    return false;
  }
  
  public int getIsSupportImmersive()
  {
    try
    {
      Object localObject = Class.forName("com.tencent.widget.immersive.ImmersiveUtils");
      localObject = ((Class)localObject).getMethod("isSupporImmersive", new Class[0]).invoke(localObject, new Object[0]);
      DebugHelper.log("getIsSupportImmersive ret=" + localObject);
      QLog.d("plugintest", 2, "getIsSupportImmersive ret=" + localObject);
      if ((localObject instanceof Integer))
      {
        int i1 = ((Integer)localObject).intValue();
        return i1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("plugintest", 2, "getIsSupportImmersive e=" + localException);
    }
    return 0;
  }
  
  public final String getPluginActivity()
  {
    String str2 = this.j;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      Bundle localBundle = getIntent().getExtras();
      str1 = str2;
      if (localBundle != null) {
        str1 = localBundle.getString("pluginsdk_launchActivity");
      }
    }
    return str1;
  }
  
  public String getPluginID()
  {
    return null;
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return getClass();
  }
  
  public void initImmersive()
  {
    if (this.a != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        Method localMethod = this.a.getClass().getMethod("init", new Class[0]);
        QLog.d("plugintest", 2, "getMethod");
        localMethod.setAccessible(true);
        localMethod.invoke(this.a, new Object[0]);
        return;
      }
      catch (Exception localException)
      {
        do
        {
          localException.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.d("plugintest", 2, "setImmersiveBar e" + localException);
        return;
      }
    }
    QLog.d("plugintest", 2, "initImmersive msystemBar=null");
  }
  
  protected boolean isPatternLockOpened()
  {
    return getGestureLock(this, m);
  }
  
  protected boolean isWrapContent()
  {
    boolean bool = true;
    if (this.mPluginActivity != null) {
      bool = this.mPluginActivity.IIsWrapContent();
    }
    DebugHelper.debug("PluginProxyActivity.isWrapContent: " + bool + ", from = " + this.mPluginActivity);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mPluginActivity != null) {}
    try
    {
      ClassLoader localClassLoader = PluginStatic.b(this.i);
      if ((localClassLoader != null) && (paramIntent != null)) {
        paramIntent.setExtrasClassLoader(localClassLoader);
      }
      this.mPluginActivity.IOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    this.n = false;
  }
  
  public void onBackPressed()
  {
    boolean bool = false;
    if (this.mPluginActivity != null) {
      bool = this.mPluginActivity.IOnBackPressed();
    }
    if (!bool) {}
    try
    {
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnConfigurationChanged(paramConfiguration);
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject3 = null;
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate");
    }
    MobileQQ.sMobileQQ.addOtherTypeActivity(this);
    a.a();
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate.registerAccountReceiverIfNeccessary");
    }
    Object localObject1;
    Object localObject2;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getBundle("pluginsdk_inner_bundle");
      localObject2 = paramBundle;
    }
    while (!PluginStatic.a((Bundle)localObject2))
    {
      super.onCreate(paramBundle);
      finish();
      return;
      localObject2 = getIntent().getExtras();
      localObject1 = null;
    }
    this.h = ((Bundle)localObject2).getString("pluginsdk_pluginName");
    this.i = ((Bundle)localObject2).getString("pluginsdk_pluginLocation");
    this.j = ((Bundle)localObject2).getString("pluginsdk_launchActivity");
    this.e = ((Bundle)localObject2).getBoolean("useSkinEngine", false);
    this.f = ((Bundle)localObject2).getInt("userQqResources", 0);
    this.g = ((Bundle)localObject2).getString("pluginsdk_pluginpath");
    PluginRecoverReceiver.a(this.i);
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate.fetchParams");
    }
    if (TextUtils.isEmpty(this.g)) {}
    try
    {
      this.g = PluginUtils.getInstalledPluginPath(this, this.i).getCanonicalPath();
      this.k = ((Bundle)localObject2).getString("pluginsdk_selfuin");
      if (!TextUtils.isEmpty(this.k))
      {
        m = this.k;
        a(this, this.k);
      }
      for (;;)
      {
        this.l = ((Bundle)localObject2).getBoolean("param_plugin_gesturelock", false);
        if ((this.l) || (b(this))) {
          mGestureLockEnable = true;
        }
        if (DebugHelper.sDebug) {
          DebugHelper.log("PluginProxyActivity onCreate start registerReceiver");
        }
        localObject2 = new IntentFilter();
        ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
        try
        {
          registerReceiver(this.o, (IntentFilter)localObject2);
          if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyActivity.onCreate Params:" + this.i + ", " + this.j);
          }
          if ((this.i == null) || (this.i.length() == 0))
          {
            localObject1 = new IllegalArgumentException("Param mPluingLocation missing!");
            i1 = 0;
            if (i1 == 0) {
              super.onCreate(paramBundle);
            }
            if (localObject1 == null) {
              break label659;
            }
            this.mCreateErrorInfo = PluginUtils.getExceptionInfo((Throwable)localObject1);
            if (DebugHelper.sDebug) {
              DebugHelper.log("PluginProxyActivity.onCreate startPlugin:" + this.h + ", " + this.mCreateErrorInfo);
            }
            if (!a((Throwable)localObject1))
            {
              a();
              finish();
            }
            a(this.h, this.i, this.j, this.mCreateErrorInfo);
            if (DebugHelper.sDebug) {
              DebugHelper.log("plugin_tag", "PluginProxyActivity onCreate start sendLaunchCompletedBroadcast");
            }
            c();
            setStatusTrans();
            return;
            m = c(this);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (DebugHelper.sDebug)
            {
              DebugHelper.log("plugin_tag", "register exception.", localException1);
              continue;
              try
              {
                if (DebugHelper.sDebug) {
                  DebugHelper.log("PluginProxyActivity onCreate start initPlugin");
                }
                b();
                if (DebugHelper.sDebug) {
                  DebugHelper.log("PluginProxyActivity onCreate end initPlugin");
                }
                this.mPluginActivity.IOnSetTheme();
                super.onCreate(paramBundle);
              }
              catch (Throwable localThrowable1)
              {
                try
                {
                  if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate start IOnCreate");
                  }
                  if (localObject1 != null) {
                    ((Bundle)localObject1).setClassLoader(PluginStatic.b(this.i));
                  }
                  this.mPluginActivity.IOnCreate((Bundle)localObject1);
                  if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate end IOnCreate");
                  }
                  i1 = 1;
                  localObject1 = localObject3;
                }
                catch (Throwable localThrowable2)
                {
                  for (;;)
                  {
                    i1 = 1;
                  }
                }
                localThrowable1 = localThrowable1;
                i1 = 0;
              }
              this.mPluginActivity = null;
              localThrowable1.printStackTrace();
              PluginRuntime.handleCrash(localThrowable1, this.i, this);
              continue;
              label659:
              this.mCreateErrorInfo = "success";
              if (DebugHelper.sDebug) {
                DebugHelper.log("PluginProxyActivity.onCreate Success");
              }
              paramBundle = getIntent().getExtras();
              if (paramBundle != null)
              {
                i1 = paramBundle.getInt("fling_action_key");
                if (DebugHelper.sDebug) {
                  DebugHelper.log("PluginProxyActivity.onCreate FLING_ACTION_KEY: " + i1 + ", from: " + paramBundle);
                }
                if ((i1 != 0) && (isWrapContent())) {
                  if (1 == i1) {
                    this.mFlingHandler = new FlingTrackerHandler(this);
                  } else {
                    this.mFlingHandler = new FlingGestureHandler(this);
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException2)
    {
      int i1;
      for (;;) {}
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnCreateOptionsMenu(paramMenu);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mPluginActivity != null) {}
    try
    {
      this.mPluginActivity.IOnDestroy();
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity onDestroy");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        unregisterReceiver(this.o);
        MobileQQ.sMobileQQ.removeOtherTypeActivity(this);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = false;
    if (this.mPluginActivity != null) {
      bool1 = this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
    return bool2;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnMenuItemSelected(paramInt, paramMenuItem);
    }
    return super.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Object localObject = PluginStatic.b(this.i);
    if (localObject != null) {
      paramIntent.setExtrasClassLoader((ClassLoader)localObject);
    }
    if (this.mPluginActivity != null)
    {
      Intent localIntent = new Intent(paramIntent);
      localIntent.setExtrasClassLoader((ClassLoader)localObject);
      localObject = localIntent.getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject != null)
      {
        localIntent.putExtras((Bundle)localObject);
        localIntent.removeExtra("pluginsdk_inner_intent_extras");
      }
      this.mPluginActivity.IOnNewIntent(localIntent);
    }
    if ((this.i != null) && (!this.i.equals("BuscardPlugin.apk")) && (paramIntent != null) && ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))) {
      if (QLog.isDevelopLevel()) {
        QLog.i("PluginProxyActivity", 4, "go buscard plugin");
      }
    }
    try
    {
      ActivityLifecycle.onNewIntent(this, paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.i("PluginProxyActivity", 4, "onNewIntent failed");
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnOptionsItemSelected(paramMenuItem);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnPause();
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.onPause");
    }
    if ((this.i != null) && (!this.i.equals("BuscardPlugin.apk"))) {}
    try
    {
      ActivityLifecycle.onPause(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.i("PluginProxyActivity", 4, "disableNFCEvent failed");
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    ClassLoader localClassLoader = PluginStatic.b(this.i);
    if (localClassLoader != null) {}
    try
    {
      a(paramBundle, localClassLoader);
      super.onRestoreInstanceState(paramBundle);
      if (this.mPluginActivity != null)
      {
        Bundle localBundle = paramBundle.getBundle("pluginsdk_inner_bundle");
        paramBundle = localBundle;
        if (localBundle == null) {
          paramBundle = new Bundle();
        }
        paramBundle.setClassLoader(localClassLoader);
        this.mPluginActivity.IOnRestoreInstanceState(paramBundle);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onResume()
  {
    try
    {
      super.onResume();
      if (this.mPluginActivity != null) {
        this.mPluginActivity.IOnResume();
      }
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.onResume");
      }
      if ((this.mPluginActivity != null) && (this.mPluginActivity.IgetImmersiveConfig().isNeedColor) && (this.mActNeedImmersive)) {
        setImmersiveBar(this, true, this.mPluginActivity.IgetImmersiveConfig().mStatusColor);
      }
      if (enablePatternLock())
      {
        mAppForground = a(this);
        if ((!mAppForground) && (!TextUtils.isEmpty(m)) && (isPatternLockOpened()) && (this.n)) {
          startUnlockActivity(true);
        }
        if (!mAppForground)
        {
          mAppForground = true;
          a(this, mAppForground);
        }
        this.mStopFlag = 0;
        this.n = true;
      }
      if ((this.i != null) && (!this.i.equals("BuscardPlugin.apk"))) {}
      try
      {
        ActivityLifecycle.onResume(this);
        return;
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isDevelopLevel()) {}
        QLog.i("PluginProxyActivity", 4, "registerNFCEvent failed");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.mPluginActivity != null)
    {
      Bundle localBundle2 = paramBundle.getBundle("pluginsdk_inner_bundle");
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null)
      {
        localBundle1 = new Bundle();
        paramBundle.putBundle("pluginsdk_inner_bundle", localBundle1);
      }
      this.mPluginActivity.IOnSaveInstanceState(localBundle1);
    }
    paramBundle.putString("pluginsdk_pluginName", this.h);
    paramBundle.putString("pluginsdk_pluginLocation", this.i);
    paramBundle.putString("pluginsdk_pluginpath", this.g);
    paramBundle.putString("pluginsdk_launchActivity", this.j);
    paramBundle.putBoolean("useSkinEngine", this.e);
    paramBundle.putInt("userQqResources", this.f);
    paramBundle.putString("pluginsdk_selfuin", this.k);
    paramBundle.putBoolean("param_plugin_gesturelock", this.l);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStart();
    }
    if (this.mIsShowQQBackgroundIcon)
    {
      Intent localIntent = new Intent("tencent.notify.foreground");
      localIntent.putExtra("selfuin", "");
      sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStop();
    }
    mAppForground = d();
    if (enablePatternLock())
    {
      if (!mAppForground) {
        a(this, mAppForground);
      }
      this.mStopFlag = 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onUserInteraction()
  {
    if (this.mPluginActivity != null)
    {
      this.mPluginActivity.IOnUserInteraction();
      return;
    }
    super.onUserInteraction();
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    Intent localIntent;
    if (this.mIsShowQQBackgroundIcon)
    {
      localIntent = new Intent("tencent.notify.background");
      localIntent.putExtra("selfuin", "");
      localIntent.putExtra("classname", getClass().getName());
    }
    try
    {
      sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnWindowFocusChanged(paramBoolean);
    }
  }
  
  public void setImmersiveBar(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugintest", 2, "setImmersiveBar");
      }
      Class localClass = Class.forName("com.tencent.widget.immersive.SystemBarCompact");
      QLog.d("plugintest", 2, "setImmersiveBar" + localClass.getClass());
      localClass.getDeclaredConstructors();
      this.a = localClass.getConstructor(new Class[] { Activity.class, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { paramActivity, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      initImmersive();
      return;
    }
    catch (Exception paramActivity)
    {
      do
      {
        paramActivity.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("plugintest", 2, "setImmersiveBar e" + paramActivity);
    }
  }
  
  public void setStatusTrans()
  {
    DebugHelper.log("setStatusTrans getIsSupportImmersive=" + getIsSupportImmersive());
    QLog.d("plugintest", 2, "setStatusTrans getIsSupportImmersive=" + getIsSupportImmersive());
    if ((this.mPluginActivity != null) && (this.mNeedStatusTrans) && (this.mPluginActivity.IgetImmersiveConfig().isTranslate) && (getIsSupportImmersive() == 1)) {
      getWindow().addFlags(67108864);
    }
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    return false;
  }
  
  protected void showNeedUninstanllAndInstallDialog()
  {
    Object localObject = new AlertDialog.Builder(this);
    ((AlertDialog.Builder)localObject).setTitle("温馨提示");
    ((AlertDialog.Builder)localObject).setMessage("启动" + this.h + "失败，请卸载重装~");
    ((AlertDialog.Builder)localObject).setPositiveButton("我知道了", new g(this));
    localObject = ((AlertDialog.Builder)localObject).create();
    try
    {
      if (!isFinishing()) {
        ((Dialog)localObject).show();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (paramIntent.getBooleanExtra("pluginsdk_IsPluginActivity", false))
    {
      String str = null;
      ComponentName localComponentName = paramIntent.getComponent();
      if (localComponentName != null) {
        str = localComponentName.getClassName();
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", false);
      if ((str != null) && (str.length() > 0)) {
        startPluginActivityForResult(this, str, paramIntent, paramInt);
      }
    }
    for (;;)
    {
      this.mStopFlag = 2;
      return;
      startActivityForResult(paramIntent, paramInt, 2);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mStopFlag = 2;
    if (a(paramIntent)) {
      this.n = false;
    }
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    switch (paramInt2)
    {
    default: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 0: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 1: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    }
    startActivityForResultWithGesture(paramIntent, paramInt1);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramIntent.putExtra("preAct", getPluginActivity());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startActivityForResultWithGesture(Intent paramIntent, int paramInt)
  {
    startActivityForResultWithGesture(paramIntent, paramInt, hashCode());
  }
  
  public void startActivityForResultWithGesture(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", paramInt2);
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  public void startActivityForResultWithSnap(Intent paramIntent, int paramInt)
  {
    startActivityForResultWithSnap(paramIntent, paramInt, hashCode());
  }
  
  public void startActivityForResultWithSnap(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.startActivityForResultWithSnap:" + paramInt2);
    }
    String str = ScreenCapture.getSnapPath(this, paramInt2);
    if (str != null)
    {
      ScreenCapture.captureViewToFile(str, getWindow().getDecorView());
      paramIntent.putExtra("fling_action_key", 1);
      paramIntent.putExtra("fling_code_key", paramInt2);
    }
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  protected void startPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, getProxyActivity(paramString));
    localIntent.putExtra("pluginsdk_pluginName", this.h);
    localIntent.putExtra("pluginsdk_pluginLocation", this.i);
    localIntent.putExtra("pluginsdk_pluginpath", this.g);
    localIntent.putExtra("pluginsdk_launchActivity", paramString);
    localIntent.putExtra("useSkinEngine", this.e);
    if ((this.f == 1) || (this.f == -1) || (this.f == 2)) {
      localIntent.putExtra("userQqResources", this.f);
    }
    if (paramIntent != null)
    {
      localIntent.addFlags(paramIntent.getFlags());
      localIntent.putExtra("pluginsdk_inner_intent_extras", new Bundle(paramIntent.getExtras()));
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  protected void startUnlockActivity(boolean paramBoolean)
  {
    try
    {
      startActivity(new Intent(this, Class.forName("com.tencent.mobileqq.activity.GesturePWDUnlockActivity")));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\PluginProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */