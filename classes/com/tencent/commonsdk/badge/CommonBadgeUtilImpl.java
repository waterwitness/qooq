package com.tencent.commonsdk.badge;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class CommonBadgeUtilImpl
{
  public static final String ACTION_APPLICATION_MESSAGE_QUERY = "android.intent.action.APPLICATION_MESSAGE_QUERY";
  public static final String ACTION_APPLICATION_MESSAGE_UPDATE = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
  public static final String ACTION_QQLAUNCHER_BADGE_UPDATE = "com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT";
  public static final String EXTRA_UPDATE_APPLICATION_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
  public static final String EXTRA_UPDATE_APPLICATION_MESSAGE_TEXT = "android.intent.extra.update_application_message_text";
  public static final String LENOVO_PACKAGE_NAME = "com.lenovo.launcher";
  public static final String MANUFACTURER_OF_HARDWARE_HUAWEI = "huawei";
  public static final String MANUFACTURER_OF_HARDWARE_LENOVO = "lenovo";
  public static final String MANUFACTURER_OF_HARDWARE_OPPO = "OPPO";
  public static final String MANUFACTURER_OF_HARDWARE_SANXING = "samsung";
  public static final String MANUFACTURER_OF_HARDWARE_SONY = "Sony Ericsson";
  public static final String MANUFACTURER_OF_HARDWARE_VIVO = "vivo";
  public static final String MANUFACTURER_OF_HARDWARE_XIAOMI = "Xiaomi";
  public static final String MANUFACTURER_OF_HARDWARE_ZUK = "ZUK";
  public static final String MANUFACTURER_OF_LENOVO_LAUNCHER_BADGE = "content://com.lenovo.launcher.badge/lenovo_badges";
  public static int NOTIFICATION_ID_NOTIFYID = 0;
  private static final String OPPO_QQ_BADGE_NUMBER = "com.tencent.mobileqq.badge";
  public static final String TAG = "CommonBadgeUtilImpl";
  public static int haslenovoLanucher;
  private static Boolean haveprovider = null;
  public static String mLauncherClassName;
  public static int mLimitCount;
  private static int miui6Flag = 0;
  public static PackageManager packmag;
  private static int sBadgeAbility;
  private static Context sContext;
  public static String[] sQQLuancherPackageNames;
  
  static
  {
    NOTIFICATION_ID_NOTIFYID = 110234;
    sQQLuancherPackageNames = new String[] { "com.tencent.qlauncher.lite", "com.tencent.qlauncher", "com.tencent.qqlauncher", "com.tencent.launcher" };
    mLauncherClassName = "";
    haslenovoLanucher = -1;
    mLimitCount = -1;
    sBadgeAbility = 0;
  }
  
  public static void changeMI6Badge(Context paramContext, int paramInt, Notification paramNotification)
  {
    int i = paramInt;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
    }
    try
    {
      paramContext = Class.forName("android.app.MiuiNotification").newInstance();
      Field localField = paramContext.getClass().getDeclaredField("messageCount");
      localField.setAccessible(true);
      localField.set(paramContext, Integer.valueOf(i));
      paramNotification.getClass().getField("extraNotification").set(paramNotification, paramContext);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (InstantiationException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void changeMIBadge(Context paramContext, int paramInt)
  {
    if (isMIUI6()) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
    localIntent.putExtra("android.intent.extra.update_application_component_name", "com.tencent.mobileqq/.activity.SplashActivity");
    String str;
    if (paramInt > 0) {
      if (paramInt > mLimitCount) {
        str = "" + mLimitCount;
      }
    }
    for (;;)
    {
      localIntent.putExtra("android.intent.extra.update_application_message_text", str);
      paramContext.sendBroadcast(localIntent);
      return;
      str = paramInt + "";
      continue;
      str = "";
    }
  }
  
  public static void changeOPPOBadge(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("app_badge_count", i);
      paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void changeVivoBadge(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
    }
    String str = getLauncherClassName(paramContext);
    if (str == null) {
      return;
    }
    Intent localIntent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localIntent.putExtra("className", str);
    localIntent.putExtra("notificationNum", i);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void changeZUKBadge(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("app_shortcut_custom_id", null);
      localBundle.putInt("app_badge_count", i);
      if (paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle) != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("CommonBadgeUtilImpl", "changeZUKBadge mcount=" + i + "result=" + bool);
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String getLauncherClassName(Context paramContext)
  {
    if (!TextUtils.isEmpty(mLauncherClassName)) {
      return mLauncherClassName;
    }
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = new Intent("android.intent.action.MAIN");
    ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
    try
    {
      localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResolveInfo)((Iterator)localObject1).next();
        if (((ResolveInfo)localObject2).activityInfo.applicationInfo.packageName.equalsIgnoreCase(paramContext.getPackageName()))
        {
          paramContext = ((ResolveInfo)localObject2).activityInfo.name;
          mLauncherClassName = paramContext;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      return null;
    }
    return null;
  }
  
  /* Error */
  public static boolean isMIUI6()
  {
    // Byte code:
    //   0: getstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   3: ifne +127 -> 130
    //   6: iconst_m1
    //   7: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   10: ldc 93
    //   12: astore_0
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore_2
    //   20: new 347	java/io/BufferedReader
    //   23: dup
    //   24: new 349	java/io/InputStreamReader
    //   27: dup
    //   28: new 351	java/lang/ProcessBuilder
    //   31: dup
    //   32: iconst_2
    //   33: anewarray 81	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 353
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc_w 355
    //   47: aastore
    //   48: invokespecial 358	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   51: invokevirtual 362	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   54: invokevirtual 368	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   57: invokespecial 371	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   60: sipush 1024
    //   63: invokespecial 374	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   66: astore_1
    //   67: aload_0
    //   68: astore_2
    //   69: aload_0
    //   70: astore_3
    //   71: aload_1
    //   72: invokevirtual 377	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 4
    //   77: aload 4
    //   79: astore_2
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: astore_0
    //   86: aload_1
    //   87: invokevirtual 380	java/io/BufferedReader:close	()V
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 380	java/io/BufferedReader:close	()V
    //   98: aload 4
    //   100: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +27 -> 130
    //   106: iconst_0
    //   107: istore 5
    //   109: aload 4
    //   111: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   114: istore 6
    //   116: iload 6
    //   118: istore 5
    //   120: iload 5
    //   122: iconst_3
    //   123: if_icmple +7 -> 130
    //   126: iconst_1
    //   127: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   130: getstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   133: iconst_1
    //   134: if_icmpne +167 -> 301
    //   137: iconst_1
    //   138: ireturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 385	java/lang/NumberFormatException:printStackTrace	()V
    //   144: goto -24 -> 120
    //   147: astore_1
    //   148: aload_2
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 380	java/io/BufferedReader:close	()V
    //   158: aload_0
    //   159: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne -32 -> 130
    //   165: iconst_0
    //   166: istore 5
    //   168: aload_0
    //   169: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   172: istore 6
    //   174: iload 6
    //   176: istore 5
    //   178: iload 5
    //   180: iconst_3
    //   181: if_icmple -51 -> 130
    //   184: iconst_1
    //   185: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   188: goto -58 -> 130
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 385	java/lang/NumberFormatException:printStackTrace	()V
    //   196: goto -18 -> 178
    //   199: astore_1
    //   200: aload 4
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 380	java/io/BufferedReader:close	()V
    //   211: aload_0
    //   212: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne -85 -> 130
    //   218: iconst_0
    //   219: istore 5
    //   221: aload_0
    //   222: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   225: istore 6
    //   227: iload 6
    //   229: istore 5
    //   231: iload 5
    //   233: iconst_3
    //   234: if_icmple -104 -> 130
    //   237: iconst_1
    //   238: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   241: goto -111 -> 130
    //   244: astore_0
    //   245: aload_0
    //   246: invokevirtual 385	java/lang/NumberFormatException:printStackTrace	()V
    //   249: goto -18 -> 231
    //   252: astore_1
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 380	java/io/BufferedReader:close	()V
    //   261: aload_0
    //   262: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifne +26 -> 291
    //   268: iconst_0
    //   269: istore 5
    //   271: aload_0
    //   272: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   275: istore 6
    //   277: iload 6
    //   279: istore 5
    //   281: iload 5
    //   283: iconst_3
    //   284: if_icmple +7 -> 291
    //   287: iconst_1
    //   288: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   291: aload_1
    //   292: athrow
    //   293: astore_0
    //   294: aload_0
    //   295: invokevirtual 385	java/lang/NumberFormatException:printStackTrace	()V
    //   298: goto -17 -> 281
    //   301: iconst_0
    //   302: ireturn
    //   303: astore_0
    //   304: goto -206 -> 98
    //   307: astore_1
    //   308: goto -150 -> 158
    //   311: astore_1
    //   312: goto -101 -> 211
    //   315: astore_2
    //   316: goto -55 -> 261
    //   319: astore 4
    //   321: aload_1
    //   322: astore_3
    //   323: aload_2
    //   324: astore_0
    //   325: aload 4
    //   327: astore_1
    //   328: goto -75 -> 253
    //   331: astore_0
    //   332: aload_3
    //   333: astore_0
    //   334: goto -131 -> 203
    //   337: astore_2
    //   338: goto -188 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	74	0	localObject1	Object
    //   139	30	0	localNumberFormatException1	NumberFormatException
    //   191	31	0	localNumberFormatException2	NumberFormatException
    //   244	28	0	localNumberFormatException3	NumberFormatException
    //   293	2	0	localNumberFormatException4	NumberFormatException
    //   303	1	0	localIOException1	java.io.IOException
    //   324	1	0	localObject2	Object
    //   331	1	0	localException1	Exception
    //   333	1	0	localObject3	Object
    //   66	29	1	localBufferedReader	java.io.BufferedReader
    //   147	1	1	localIOException2	java.io.IOException
    //   149	6	1	localObject4	Object
    //   199	1	1	localException2	Exception
    //   202	6	1	str1	String
    //   252	40	1	localObject5	Object
    //   307	1	1	localIOException3	java.io.IOException
    //   311	11	1	localIOException4	java.io.IOException
    //   327	1	1	localObject6	Object
    //   19	130	2	localObject7	Object
    //   315	9	2	localIOException5	java.io.IOException
    //   337	1	2	localIOException6	java.io.IOException
    //   17	316	3	localObject8	Object
    //   14	187	4	str2	String
    //   319	7	4	localObject9	Object
    //   107	178	5	i	int
    //   114	164	6	j	int
    // Exception table:
    //   from	to	target	type
    //   109	116	139	java/lang/NumberFormatException
    //   20	67	147	java/io/IOException
    //   168	174	191	java/lang/NumberFormatException
    //   20	67	199	java/lang/Exception
    //   221	227	244	java/lang/NumberFormatException
    //   20	67	252	finally
    //   271	277	293	java/lang/NumberFormatException
    //   94	98	303	java/io/IOException
    //   154	158	307	java/io/IOException
    //   207	211	311	java/io/IOException
    //   257	261	315	java/io/IOException
    //   71	77	319	finally
    //   86	90	319	finally
    //   71	77	331	java/lang/Exception
    //   86	90	331	java/lang/Exception
    //   71	77	337	java/io/IOException
    //   86	90	337	java/io/IOException
  }
  
  public static boolean isQQLanucher()
  {
    boolean bool2 = false;
    if (packmag == null) {
      packmag = sContext.getPackageManager();
    }
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < sQQLuancherPackageNames.length) {}
      try
      {
        PackageInfo localPackageInfo = packmag.getPackageInfo(sQQLuancherPackageNames[i], 0);
        if (localPackageInfo != null)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
  
  public static boolean isSupportBadge(Context paramContext)
  {
    int i = 1;
    if (sContext == null) {
      sContext = paramContext;
    }
    if (sBadgeAbility != 0) {
      return sBadgeAbility == 1;
    }
    boolean bool;
    if (Build.MANUFACTURER.equalsIgnoreCase("ZUK"))
    {
      bool = true;
      BadgeController.init(sContext);
      if (BadgeController.isSupport(sContext)) {
        bool = true;
      }
      if (!bool) {
        break label173;
      }
    }
    for (;;)
    {
      sBadgeAbility = i;
      return bool;
      if ((islenovoLanucher("com.lenovo.launcher")) || (isQQLanucher()))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("OPPO"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("vivo"))
      {
        bool = true;
        break;
      }
      bool = false;
      break;
      label173:
      i = 2;
    }
  }
  
  public static boolean islenovoLanucher(String paramString)
  {
    if (Build.VERSION.SDK_INT < 15) {}
    do
    {
      return false;
      if (haslenovoLanucher == -1) {
        break;
      }
    } while (haslenovoLanucher != 1);
    return true;
    try
    {
      if ((packmag == null) && (sContext != null)) {
        packmag = sContext.getPackageManager();
      }
      if (Float.valueOf(Float.parseFloat(packmag.getPackageInfo(paramString, 0).versionName.substring(0, 3))).floatValue() >= 6.7F)
      {
        haslenovoLanucher = 1;
        return true;
      }
      haslenovoLanucher = 0;
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      haslenovoLanucher = 0;
      return false;
    }
    catch (Exception paramString)
    {
      haslenovoLanucher = 0;
    }
    return false;
  }
  
  public static void setBadge(Context paramContext, int paramInt)
  {
    setBadge(paramContext, paramInt, false);
  }
  
  public static void setBadge(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Log.d("CommonBadgeUtilImpl", "setBadge count=" + paramInt + "|forceSet=" + paramBoolean);
    BadgeController.setBadge(paramInt);
    if (isQQLanucher()) {
      setQQLauncherBadges(paramContext, paramInt);
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("ZUK")) {
      changeZUKBadge(paramContext, paramInt);
    }
    if (islenovoLanucher("com.lenovo.launcher")) {
      setLenovoBadge(paramContext, paramInt);
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
      changeMIBadge(paramContext, paramInt);
    }
    do
    {
      return;
      if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
      {
        setSamsungBadge(paramContext, paramInt);
        return;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
      {
        setHuaweiBadge(paramContext, paramInt);
        return;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("OPPO"))
      {
        changeOPPOBadge(paramContext, paramInt);
        return;
      }
    } while (!Build.MANUFACTURER.equalsIgnoreCase("vivo"));
    changeVivoBadge(paramContext, paramInt);
  }
  
  public static void setHuaweiBadge(Context paramContext, int paramInt)
  {
    try
    {
      String str = getLauncherClassName(paramContext);
      if (str == null) {
        return;
      }
      int i = paramInt;
      if (paramInt > mLimitCount) {
        i = mLimitCount;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("package", paramContext.getPackageName());
      localBundle.putString("class", str);
      localBundle.putInt("badgenumber", i);
      paramContext.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void setLenovoBadge(Context paramContext, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    Object localObject3 = getLauncherClassName(paramContext);
    if (localObject3 == null) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      Object localObject1 = localObject2;
      try
      {
        localContentValues.put("package", paramContext.getPackageName());
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localContentValues.put("class", (String)localObject3);
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localContentValues.put("badgecount", Integer.valueOf(paramInt));
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localContentValues.put("extraData", "");
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localObject3 = paramContext.getContentResolver();
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        Uri localUri = Uri.parse("content://com.lenovo.launcher.badge/lenovo_badges");
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        String str = paramContext.getPackageName();
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localCursor2 = ((ContentResolver)localObject3).query(localUri, new String[] { "package", "class", "badgecount", "extraData" }, "package=?", new String[] { str }, null);
        if (localCursor2 != null)
        {
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          if (localCursor2.getCount() > 0)
          {
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            if (localCursor2.moveToFirst())
            {
              localCursor1 = localCursor2;
              localObject1 = localCursor2;
              paramContext.getContentResolver().update(Uri.parse("content://com.lenovo.launcher.badge/lenovo_badges"), localContentValues, "package=?", new String[] { paramContext.getPackageName() });
            }
            if (localCursor2 == null) {
              continue;
            }
            localCursor2.close();
            return;
          }
        }
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        Log.d("lenovo", "setLenovoBadge cur=null");
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        paramContext.getContentResolver().insert(Uri.parse("content://com.lenovo.launcher.badge/lenovo_badges"), localContentValues);
        if (localCursor2 == null) {
          continue;
        }
        localCursor2.close();
        return;
      }
      catch (Throwable paramContext)
      {
        if (localCursor1 == null) {
          continue;
        }
        localCursor1.close();
        return;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
  }
  
  public static void setLimitCount(int paramInt)
  {
    mLimitCount = paramInt;
  }
  
  public static void setMIUI6Badge(Context paramContext, int paramInt, Notification paramNotification)
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (isMIUI6())) {
      changeMI6Badge(paramContext, paramInt, paramNotification);
    }
  }
  
  public static void setQQLauncherBadges(Context paramContext, int paramInt)
  {
    int i;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
    }
    for (;;)
    {
      Intent localIntent = new Intent("com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT");
      localIntent.putExtra("webappId", "20634");
      localIntent.putExtra("info_tips", String.valueOf(i));
      paramContext.sendBroadcast(localIntent);
      return;
      i = paramInt;
      if (paramInt < 1) {
        i = 0;
      }
    }
  }
  
  public static void setSamsungBadge(Context paramContext, int paramInt)
  {
    String str = null;
    Intent localIntent = null;
    Object localObject1 = null;
    localObject2 = str;
    localObject3 = localIntent;
    label94:
    label238:
    do
    {
      do
      {
        try
        {
          if (haveprovider != null) {
            break label94;
          }
          localObject2 = str;
          localObject3 = localIntent;
          localObject1 = Uri.parse("content://com.sec.badge/apps");
          localObject2 = str;
          localObject3 = localIntent;
          localObject1 = paramContext.getContentResolver().query((Uri)localObject1, null, null, null, null);
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            haveprovider = Boolean.valueOf(false);
            return;
          }
        }
        catch (Throwable paramContext)
        {
          int i;
          return;
        }
        finally
        {
          if (localObject3 == null) {
            break label274;
          }
          ((Cursor)localObject3).close();
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        haveprovider = Boolean.valueOf(true);
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!haveprovider.booleanValue()) {
          break label238;
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        str = getLauncherClassName(paramContext);
        if (str != null) {
          break;
        }
      } while (localObject1 == null);
      ((Cursor)localObject1).close();
      return;
      i = paramInt;
      localObject2 = localObject1;
      localObject3 = localObject1;
      if (paramInt > mLimitCount)
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        i = mLimitCount;
      }
      localObject2 = localObject1;
      localObject3 = localObject1;
      localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
      localObject2 = localObject1;
      localObject3 = localObject1;
      localIntent.putExtra("badge_count", i);
      localObject2 = localObject1;
      localObject3 = localObject1;
      localIntent.putExtra("badge_count_package_name", paramContext.getPackageName());
      localObject2 = localObject1;
      localObject3 = localObject1;
      localIntent.putExtra("badge_count_class_name", str);
      localObject2 = localObject1;
      localObject3 = localObject1;
      paramContext.sendBroadcast(localIntent);
    } while (localObject1 == null);
    ((Cursor)localObject1).close();
  }
  
  public static void setSonyBadge(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    String str2 = getLauncherClassName(paramContext);
    if (str2 == null) {
      return;
    }
    if (paramInt < 1)
    {
      str1 = "";
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", false);
      localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", str2);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", str1);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    if (paramInt > mLimitCount) {}
    for (String str1 = "" + mLimitCount;; str1 = paramInt + "")
    {
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", true);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\badge\CommonBadgeUtilImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */