package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import mqq.app.BaseActivity;

public class BasePluginActivity
  extends BaseActivity
  implements IPluginActivity, PluginInterfaceHelper.OnPluginInterfaceLoadedListener, SkinnableActivityProcesser.Callback
{
  private static Boolean d;
  private static boolean e;
  public static int i_support_immersive = -1;
  boolean a = false;
  View b;
  SkinnableActivityProcesser c;
  private Activity f;
  private ClassLoader g;
  private PluginConfig h = new PluginConfig();
  private ImmersiveConfig i = new ImmersiveConfig();
  protected String mApkFilePath = "";
  public View mContentView;
  public Context mContext;
  protected boolean mIsRunInPlugin;
  protected boolean mIsTab;
  protected Activity mOutActivity;
  protected PackageInfo mPackageInfo;
  protected String mPluginID;
  protected int mPluginResourcesType;
  protected boolean mUseSkinEngine;
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    Object localObject;
    if (this.b != null)
    {
      localObject = this.b;
      if (paramBoolean) {
        ((View)localObject).setVisibility(j);
      }
    }
    do
    {
      do
      {
        return;
        j = 8;
        break;
      } while (paramBoolean != true);
      localObject = new ImageView(this);
      ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
      ((ImageView)localObject).setPadding(0, this.h.titleHeight, 0, 0);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.b = ((View)localObject);
    } while (this.b == null);
    getWindow().addContentView(this.b, this.b.getLayoutParams());
  }
  
  public static final Bitmap getDrawableBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
    } while (!(paramDrawable instanceof SkinnableBitmapDrawable));
    return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
  }
  
  public static boolean reflectHasAndIsNull(Object paramObject, String paramString, Class paramClass)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    Class localClass;
    if (paramObject != null)
    {
      bool1 = bool3;
      if (paramString != null)
      {
        localClass = paramClass;
        if (paramClass != null) {}
      }
    }
    try
    {
      localClass = paramObject.getClass();
      paramString = localClass.getDeclaredField(paramString);
      bool1 = bool3;
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramObject = paramString.get(paramObject);
        if (paramObject != null) {
          break label69;
        }
      }
      label69:
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (Exception paramObject) {}
  }
  
  public boolean IDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public void IFinish()
  {
    finish();
  }
  
  public View IGetContentView()
  {
    return this.mContentView;
  }
  
  public Handler IGetInHandler()
  {
    return null;
  }
  
  public Resources IGetResource()
  {
    if (this.mContext != null) {
      return this.mContext.getResources();
    }
    return this.f.getResources();
  }
  
  /* Error */
  public void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: getstatic 218	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   3: ifeq +49 -> 52
    //   6: ldc -36
    //   8: new 222	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   15: ldc -31
    //   17: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc -25
    //   26: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 234	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: ldc -25
    //   36: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 236	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   43: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 247	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 249	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mIsRunInPlugin	Z
    //   57: aload_0
    //   58: aload 4
    //   60: putfield 251	com/tencent/mobileqq/pluginsdk/BasePluginActivity:g	Ljava/lang/ClassLoader;
    //   63: aload_0
    //   64: aload_3
    //   65: putfield 253	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mOutActivity	Landroid/app/Activity;
    //   68: aload_0
    //   69: aload_1
    //   70: putfield 255	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginID	Ljava/lang/String;
    //   73: aload_0
    //   74: aload_2
    //   75: putfield 62	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mApkFilePath	Ljava/lang/String;
    //   78: aload_0
    //   79: aload 5
    //   81: putfield 257	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPackageInfo	Landroid/content/pm/PackageInfo;
    //   84: aload_0
    //   85: iload 7
    //   87: putfield 236	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   90: aload_0
    //   91: getfield 195	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   94: ifnonnull +32 -> 126
    //   97: aload_0
    //   98: new 259	com/tencent/mobileqq/pluginsdk/c
    //   101: dup
    //   102: aload_3
    //   103: iconst_0
    //   104: aload_0
    //   105: getfield 62	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mApkFilePath	Ljava/lang/String;
    //   108: aload_0
    //   109: getfield 251	com/tencent/mobileqq/pluginsdk/BasePluginActivity:g	Ljava/lang/ClassLoader;
    //   112: aload_3
    //   113: invokevirtual 205	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   116: aload_0
    //   117: getfield 236	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   120: invokespecial 262	com/tencent/mobileqq/pluginsdk/c:<init>	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/ClassLoader;Landroid/content/res/Resources;I)V
    //   123: putfield 195	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   126: aload_0
    //   127: aload_0
    //   128: getfield 195	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   131: invokevirtual 265	com/tencent/mobileqq/pluginsdk/BasePluginActivity:attachBaseContext	(Landroid/content/Context;)V
    //   134: aload_0
    //   135: iload 6
    //   137: putfield 267	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mUseSkinEngine	Z
    //   140: getstatic 269	com/tencent/mobileqq/pluginsdk/BasePluginActivity:e	Z
    //   143: ifne +294 -> 437
    //   146: iload 6
    //   148: ifeq +289 -> 437
    //   151: aload_0
    //   152: getfield 236	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   155: iconst_1
    //   156: if_icmpeq +312 -> 468
    //   159: aload_0
    //   160: getfield 236	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   163: iconst_2
    //   164: if_icmpeq +304 -> 468
    //   167: new 222	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   174: aload 5
    //   176: getfield 274	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   179: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc_w 276
    //   185: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore_3
    //   192: aconst_null
    //   193: astore_1
    //   194: aload 4
    //   196: new 222	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   203: aload_3
    //   204: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 278
    //   210: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 284	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   219: astore_2
    //   220: aload_2
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_2
    //   224: aload 4
    //   226: new 222	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   233: aload_3
    //   234: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w 286
    //   240: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 284	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   249: astore_3
    //   250: aload_3
    //   251: astore_2
    //   252: iconst_0
    //   253: istore 9
    //   255: iload 9
    //   257: istore 7
    //   259: aload_1
    //   260: ifnull +77 -> 337
    //   263: aload_1
    //   264: invokevirtual 290	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   267: astore_3
    //   268: aload_3
    //   269: arraylength
    //   270: istore 10
    //   272: iconst_0
    //   273: istore 8
    //   275: iload 9
    //   277: istore 7
    //   279: iload 8
    //   281: iload 10
    //   283: if_icmpge +54 -> 337
    //   286: aload_3
    //   287: iload 8
    //   289: aaload
    //   290: astore 4
    //   292: aload 4
    //   294: invokevirtual 294	java/lang/reflect/Field:getModifiers	()I
    //   297: bipush 25
    //   299: iand
    //   300: bipush 25
    //   302: if_icmpne +138 -> 440
    //   305: aload 4
    //   307: invokevirtual 297	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   310: getstatic 303	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   313: invokevirtual 307	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   316: ifeq +124 -> 440
    //   319: aload 4
    //   321: aconst_null
    //   322: invokevirtual 311	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   325: istore 7
    //   327: iload 7
    //   329: bipush 16
    //   331: ishr
    //   332: bipush 16
    //   334: ishl
    //   335: istore 7
    //   337: iconst_0
    //   338: istore 10
    //   340: iload 10
    //   342: istore 9
    //   344: aload_2
    //   345: ifnull +77 -> 422
    //   348: aload_2
    //   349: invokevirtual 290	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   352: astore_3
    //   353: aload_3
    //   354: arraylength
    //   355: istore 11
    //   357: iconst_0
    //   358: istore 8
    //   360: iload 10
    //   362: istore 9
    //   364: iload 8
    //   366: iload 11
    //   368: if_icmpge +54 -> 422
    //   371: aload_3
    //   372: iload 8
    //   374: aaload
    //   375: astore 4
    //   377: aload 4
    //   379: invokevirtual 294	java/lang/reflect/Field:getModifiers	()I
    //   382: bipush 25
    //   384: iand
    //   385: bipush 25
    //   387: if_icmpne +64 -> 451
    //   390: aload 4
    //   392: invokevirtual 297	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   395: getstatic 303	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   398: invokevirtual 307	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   401: ifeq +50 -> 451
    //   404: aload 4
    //   406: aconst_null
    //   407: invokevirtual 311	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   410: istore 9
    //   412: iload 9
    //   414: bipush 16
    //   416: ishr
    //   417: bipush 16
    //   419: ishl
    //   420: istore 9
    //   422: aload_0
    //   423: aload_1
    //   424: iload 7
    //   426: aload_2
    //   427: iload 9
    //   429: aconst_null
    //   430: invokestatic 317	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   433: iconst_1
    //   434: putstatic 269	com/tencent/mobileqq/pluginsdk/BasePluginActivity:e	Z
    //   437: return
    //   438: astore 4
    //   440: iload 8
    //   442: iconst_1
    //   443: iadd
    //   444: istore 8
    //   446: goto -171 -> 275
    //   449: astore 4
    //   451: iload 8
    //   453: iconst_1
    //   454: iadd
    //   455: istore 8
    //   457: goto -97 -> 360
    //   460: astore_1
    //   461: invokestatic 321	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   464: invokevirtual 324	com/tencent/theme/SkinEngine:unInit	()V
    //   467: return
    //   468: ldc_w 326
    //   471: invokestatic 329	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   474: ldc_w 331
    //   477: iconst_1
    //   478: anewarray 163	java/lang/Class
    //   481: dup
    //   482: iconst_0
    //   483: ldc -59
    //   485: aastore
    //   486: invokevirtual 335	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   489: aconst_null
    //   490: iconst_1
    //   491: anewarray 157	java/lang/Object
    //   494: dup
    //   495: iconst_0
    //   496: aload_0
    //   497: aastore
    //   498: invokevirtual 341	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   501: pop
    //   502: iconst_1
    //   503: putstatic 269	com/tencent/mobileqq/pluginsdk/BasePluginActivity:e	Z
    //   506: return
    //   507: astore_1
    //   508: aload_1
    //   509: invokevirtual 344	java/lang/Exception:printStackTrace	()V
    //   512: return
    //   513: astore 4
    //   515: goto -75 -> 440
    //   518: astore 4
    //   520: goto -69 -> 451
    //   523: astore_3
    //   524: goto -272 -> 252
    //   527: astore_2
    //   528: goto -306 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	BasePluginActivity
    //   0	531	1	paramString1	String
    //   0	531	2	paramString2	String
    //   0	531	3	paramActivity	Activity
    //   0	531	4	paramClassLoader	ClassLoader
    //   0	531	5	paramPackageInfo	PackageInfo
    //   0	531	6	paramBoolean	boolean
    //   0	531	7	paramInt	int
    //   273	183	8	j	int
    //   253	175	9	k	int
    //   270	91	10	m	int
    //   355	14	11	n	int
    // Exception table:
    //   from	to	target	type
    //   319	327	438	java/lang/IllegalArgumentException
    //   404	412	449	java/lang/IllegalArgumentException
    //   422	437	460	java/lang/Exception
    //   468	506	507	java/lang/Exception
    //   319	327	513	java/lang/IllegalAccessException
    //   404	412	518	java/lang/IllegalAccessException
    //   224	250	523	java/lang/ClassNotFoundException
    //   194	220	527	java/lang/ClassNotFoundException
  }
  
  public boolean IIsWrapContent()
  {
    return true;
  }
  
  public void IOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean IOnBackPressed()
  {
    try
    {
      onBackPressed();
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void IOnConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
  }
  
  public void IOnCreate(Bundle paramBundle)
  {
    onCreate(paramBundle);
  }
  
  public boolean IOnCreateOptionsMenu(Menu paramMenu)
  {
    return onCreateOptionsMenu(paramMenu);
  }
  
  public void IOnDestroy()
  {
    onDestroy();
  }
  
  public boolean IOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean IOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean IOnKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean IOnMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public void IOnNewIntent(Intent paramIntent)
  {
    onNewIntent(paramIntent);
  }
  
  public boolean IOnOptionsItemSelected(MenuItem paramMenuItem)
  {
    return onOptionsItemSelected(paramMenuItem);
  }
  
  public void IOnPause()
  {
    onPause();
  }
  
  public boolean IOnPrepareOptionsMenu(Menu paramMenu)
  {
    return onPrepareOptionsMenu(paramMenu);
  }
  
  public void IOnRestart()
  {
    onRestart();
  }
  
  public void IOnRestoreInstanceState(Bundle paramBundle) {}
  
  public void IOnResume()
  {
    onResume();
  }
  
  public void IOnSaveInstanceState(Bundle paramBundle) {}
  
  public void IOnSetTheme() {}
  
  public void IOnStart()
  {
    onStart();
  }
  
  public void IOnStop()
  {
    onStop();
  }
  
  public boolean IOnTouchEvent(MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent);
  }
  
  public void IOnUserInteraction()
  {
    onUserInteraction();
  }
  
  public void IOnWindowFocusChanged(boolean paramBoolean)
  {
    onWindowFocusChanged(paramBoolean);
  }
  
  public void ISetIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
  }
  
  public void ISetIsTab()
  {
    this.mIsTab = true;
  }
  
  public void ISetOutHandler(Handler paramHandler) {}
  
  public void ISetParent(BasePluginActivity paramBasePluginActivity)
  {
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("setParent", new Class[] { Activity.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[] { paramBasePluginActivity });
      return;
    }
    catch (Exception paramBasePluginActivity) {}
  }
  
  public ImmersiveConfig IgetImmersiveConfig()
  {
    return this.i;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (reflectHasAndIsNull(this, "mWindow", Activity.class))
    {
      if (paramMotionEvent.getAction() == 0) {
        onUserInteraction();
      }
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.superDispatchTouchEvent(paramMotionEvent))) {
        return true;
      }
      return onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public View findViewById(int paramInt)
  {
    if ((this.mIsRunInPlugin) && (this.mContentView != null))
    {
      View localView2 = this.mContentView.findViewById(paramInt);
      View localView1 = localView2;
      if (localView2 == null) {
        localView1 = super.findViewById(paramInt);
      }
      return localView1;
    }
    return super.findViewById(paramInt);
  }
  
  public void finish()
  {
    int k;
    int j;
    if (this.mIsRunInPlugin)
    {
      k = 0;
      j = k;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = Activity.class.getDeclaredField("mResultCode");
        j = k;
        ((Field)localObject1).setAccessible(true);
        j = k;
        k = ((Integer)((Field)localObject1).get(this)).intValue();
        j = k;
        localObject1 = Activity.class.getDeclaredField("mResultData");
        j = k;
        ((Field)localObject1).setAccessible(true);
        j = k;
        localObject1 = (Intent)((Field)localObject1).get(this);
        j = k;
        this.mOutActivity.setResult(j, (Intent)localObject1);
        this.mOutActivity.finish();
        this.a = true;
        return;
      }
      catch (Exception localException)
      {
        if (!DebugHelper.sDebug) {
          break label127;
        }
        DebugHelper.log("plugin_tag", "BasePluginActivity.finish", localException);
      }
      finally {}
      super.finish();
      return;
      label127:
      Object localObject3 = null;
    }
  }
  
  public Context getApplicationContext()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getApplicationContext();
    }
    return super.getApplicationContext();
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.applicationInfo;
    }
    return super.getApplicationInfo();
  }
  
  public int getChangingConfigurations()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getChangingConfigurations();
    }
    return super.getChangingConfigurations();
  }
  
  public Resources getHostResources()
  {
    return this.mOutActivity.getResources();
  }
  
  public LayoutInflater getLayoutInflater()
  {
    if (this.mContext != null) {
      return LayoutInflater.from(this.mContext);
    }
    return LayoutInflater.from(this.f);
  }
  
  protected String getModuleId()
  {
    return this.mPluginID;
  }
  
  public Activity getOutActivity()
  {
    return this.mOutActivity;
  }
  
  public Resources getOutResources()
  {
    if (this.mIsRunInPlugin == true) {
      return this.mOutActivity.getResources();
    }
    return this.f.getResources();
  }
  
  public PackageInfo getPackageInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo;
    }
    return null;
  }
  
  public String getPackageName()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.packageName;
    }
    return super.getPackageName();
  }
  
  public Object getSystemService(String paramString)
  {
    if (("window".equals(paramString)) || ("search".equals(paramString)))
    {
      if (this.mIsRunInPlugin) {
        return this.mOutActivity.getSystemService(paramString);
      }
      return super.getSystemService(paramString);
    }
    if (this.mContext != null) {
      return this.mContext.getSystemService(paramString);
    }
    return super.getSystemService(paramString);
  }
  
  public Window getWindow()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getWindow();
    }
    return super.getWindow();
  }
  
  public WindowManager getWindowManager()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getWindowManager();
    }
    return super.getWindowManager();
  }
  
  public boolean isFinishing()
  {
    if (this.mIsRunInPlugin) {
      return this.a;
    }
    return super.isFinishing();
  }
  
  public boolean isShadow()
  {
    return true;
  }
  
  public int isSupportStatus()
  {
    if (i_support_immersive != -1) {
      return i_support_immersive;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      i_support_immersive = 0;
      return i_support_immersive;
    }
    String str = Build.MANUFACTURER.toUpperCase();
    if ((str.endsWith("BBK")) || ((str.endsWith("VIVO")) && (Build.VERSION.SDK_INT < 20))) {}
    for (i_support_immersive = 0;; i_support_immersive = 1) {
      return i_support_immersive;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mIsRunInPlugin) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  protected void onConfig(PluginConfig paramPluginConfig) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    if (this.mIsRunInPlugin)
    {
      this.f = this.mOutActivity;
      onConfig(this.h);
      if (this.c != null) {}
    }
    try
    {
      this.c = new SkinnableActivityProcesser(this, this);
      PluginStatic.a(this);
      super.onCreate(paramBundle);
      if (getIntent().getBooleanExtra("params_remote_connect_at_launch", false)) {
        readyPluginInterface(this.mOutActivity, this);
      }
      return;
      super.onCreate(paramBundle);
      this.f = this;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void onDestroy()
  {
    if (this.mIsRunInPlugin)
    {
      if (this.c != null)
      {
        this.c.destory();
        this.c = null;
      }
      this.g = null;
      PluginStatic.b(this);
      super.onDestroy();
      return;
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (this.mIsRunInPlugin)
    {
      super.onPause();
      return;
    }
    super.onPause();
  }
  
  public void onPluginInterfaceLoaded(PluginInterface paramPluginInterface)
  {
    onPluginInterfaceReady(paramPluginInterface);
  }
  
  protected void onPluginInterfaceReady(PluginInterface paramPluginInterface) {}
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  protected void onRestart()
  {
    if (this.mIsRunInPlugin)
    {
      super.onRestart();
      return;
    }
    super.onRestart();
  }
  
  protected void onResume()
  {
    if (this.mIsRunInPlugin)
    {
      super.onResume();
      return;
    }
    super.onResume();
  }
  
  protected void onStart()
  {
    if (this.mIsRunInPlugin)
    {
      super.onStart();
      if ((IPluginAdapterProxy.getProxy().isNightMode()) && (this.h.enableNight))
      {
        a(true);
        return;
      }
      a(false);
      return;
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.mIsRunInPlugin)
    {
      super.onStop();
      return;
    }
    super.onStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (this.mIsRunInPlugin) {
      return;
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void openOptionsMenu()
  {
    if (this.mIsRunInPlugin)
    {
      this.mOutActivity.openOptionsMenu();
      return;
    }
    super.openOptionsMenu();
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    if (this.mIsRunInPlugin)
    {
      this.f.overridePendingTransition(paramInt1, paramInt2);
      return;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
  }
  
  protected final void readyPluginInterface(Context paramContext, PluginInterfaceHelper.OnPluginInterfaceLoadedListener paramOnPluginInterfaceLoadedListener)
  {
    PluginInterfaceHelper.getPluginInterface(paramContext, paramOnPluginInterfaceLoadedListener);
  }
  
  public void setContentView(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mContentView = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      if (!this.mIsTab) {
        this.f.setContentView(this.mContentView);
      }
      return;
    }
    super.setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    if (this.mIsRunInPlugin)
    {
      this.mContentView = paramView;
      if (!this.mIsTab) {
        this.f.setContentView(this.mContentView);
      }
      return;
    }
    super.setContentView(paramView);
  }
  
  public void setImmersiveConfig(ImmersiveConfig paramImmersiveConfig)
  {
    this.i = paramImmersiveConfig;
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    super.setRequestedOrientation(paramInt);
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mOutActivity.setTheme(paramInt);
      return;
    }
    super.setTheme(paramInt);
  }
  
  public void setTitle(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.f.setTitle(paramInt);
      return;
    }
    super.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.mIsRunInPlugin)
    {
      this.f.setTitle(paramCharSequence);
      return;
    }
    super.setTitle(paramCharSequence);
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      super.startActivity(paramIntent);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      startActivityForResult(paramIntent, -1);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    boolean bool2 = false;
    if (this.mIsRunInPlugin)
    {
      boolean bool1;
      if (paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
        bool1 = paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      }
      while (!bool1)
      {
        this.f.startActivityForResult(paramIntent, paramInt);
        return;
        Object localObject = paramIntent.getComponent();
        bool1 = bool2;
        if (localObject != null) {
          if (this.mOutActivity.getPackageName().equals(((ComponentName)localObject).getPackageName()))
          {
            localObject = this.f.getPackageManager().queryIntentActivities(paramIntent, 65536);
            if (localObject != null)
            {
              bool1 = bool2;
              if (((List)localObject).size() != 0) {}
            }
            else
            {
              bool1 = true;
            }
          }
          else
          {
            bool1 = bool2;
            if (getPackageName().equals(((ComponentName)localObject).getPackageName())) {
              bool1 = true;
            }
          }
        }
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
      this.f.startActivityForResult(paramIntent, paramInt);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public class ImmersiveConfig
  {
    public boolean isNeedColor;
    public boolean isTranslate;
    public int mStatusColor = 0;
    
    public ImmersiveConfig() {}
  }
  
  public static class PluginConfig
  {
    public boolean enableNight = true;
    public int titleHeight;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\BasePluginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */