package com.tencent.av.smallscreen;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.smallscreen.config.SmallScreenConfigParser;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import got;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class SmallScreenUtils
{
  public static final int a = 200;
  public static final String a = "SmallScreenUtils";
  static String[] a = { "com.qzone.preview.BasePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.QZoneVideoFloatActivity", "com.tencent.mobileqq.activity.FriendProfileImageActivity", "com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity", "com.tencent.mobileqq.activity.photo.PhotoPreviewActivity", "com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity", "com.tencent.av.gaudio.GaInviteDialogActivity", "com.tencent.av.ui.MultiIncomingCallsActivity", "com.tencent.av.ui.VideoInviteActivity", "com.tencent.mobileqq.activity.selectmember.SelectMemberActivity", "cooperation.qzone.QzonePicturePluginProxyActivity", "com.tencent.av.utils.PopupDialog" };
  public static final int b = 400;
  static final String b = "com.tencent.av.smallscreen";
  public static final int c = 24;
  static final String c = "pref_show_dialog_video";
  public static final int d = 0;
  static final String d = "pref_show_dialog_audio";
  public static final int e = 3;
  public static final String e = "com.tencent.av.smallscreen.ACTION_OFF";
  public static final int f = 19;
  public static final String f = "appops";
  static final int g = 5;
  public static final String g = "is_video";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return 2130968706;
    case 1: 
      return 2130968703;
    case 2: 
      return 2130968704;
    case 3: 
      return 2130968702;
    case 4: 
      return 2130968701;
    case 5: 
      return 2130968700;
    case 6: 
      return 2130968708;
    case 7: 
      return 2130968709;
    case 8: 
      return 2130968707;
    }
    return 2130968705;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a(paramString);
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      int i = localSharedPreferences.getInt(paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "WL_DEBUG getPrefShowDialog result = " + i);
      }
      return i;
    }
  }
  
  static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("com.tencent.av.smallscreen" + paramString, 0);
  }
  
  static SmallScreenConfigParser a(Context paramContext)
  {
    paramContext = ConfigInfo.instance();
    if (paramContext != null) {}
    for (paramContext = paramContext.getSharpConfigPayloadFromFile();; paramContext = null)
    {
      if (!TextUtils.isEmpty(paramContext))
      {
        paramContext = new SmallScreenConfigParser(paramContext);
        if (paramContext.a()) {}
      }
      while (!QLog.isColorLevel())
      {
        return null;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SmallScreenUtils", 2, "getSmallScreenConfigParser --> parseConfig fail");
        return paramContext;
      }
      QLog.d("SmallScreenUtils", 2, "getSmallScreenConfigParser --> Can not get PlayLoad Config");
      return null;
      return paramContext;
    }
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: new 170	java/io/BufferedReader
    //   5: dup
    //   6: new 172	java/io/InputStreamReader
    //   9: dup
    //   10: invokestatic 178	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: ldc -76
    //   15: invokevirtual 184	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   18: invokevirtual 190	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   21: invokespecial 193	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: sipush 1024
    //   27: invokespecial 196	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   30: astore_1
    //   31: aload_1
    //   32: astore_0
    //   33: aload_1
    //   34: invokevirtual 199	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore_2
    //   38: aload_1
    //   39: ifnull +7 -> 46
    //   42: aload_1
    //   43: invokevirtual 202	java/io/BufferedReader:close	()V
    //   46: aload_2
    //   47: areturn
    //   48: astore_0
    //   49: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -6 -> 46
    //   55: ldc 10
    //   57: iconst_2
    //   58: aload_0
    //   59: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
    //   62: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_2
    //   66: areturn
    //   67: astore_2
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +15 -> 90
    //   78: aload_1
    //   79: astore_0
    //   80: ldc 10
    //   82: iconst_2
    //   83: aload_2
    //   84: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
    //   87: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 202	java/io/BufferedReader:close	()V
    //   98: ldc -49
    //   100: areturn
    //   101: astore_0
    //   102: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq -7 -> 98
    //   108: ldc 10
    //   110: iconst_2
    //   111: aload_0
    //   112: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
    //   115: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: goto -20 -> 98
    //   121: astore_2
    //   122: aload_0
    //   123: astore_1
    //   124: aload_2
    //   125: astore_0
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 202	java/io/BufferedReader:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_1
    //   137: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq -6 -> 134
    //   143: ldc 10
    //   145: iconst_2
    //   146: aload_1
    //   147: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
    //   150: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: goto -19 -> 134
    //   156: astore_2
    //   157: aload_0
    //   158: astore_1
    //   159: aload_2
    //   160: astore_0
    //   161: goto -35 -> 126
    //   164: astore_2
    //   165: goto -95 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	32	0	localObject1	Object
    //   48	11	0	localIOException1	java.io.IOException
    //   71	9	0	localObject2	Object
    //   101	22	0	localIOException2	java.io.IOException
    //   125	36	0	localObject3	Object
    //   30	101	1	localObject4	Object
    //   136	11	1	localIOException3	java.io.IOException
    //   158	1	1	localObject5	Object
    //   37	29	2	str	String
    //   67	17	2	localIOException4	java.io.IOException
    //   121	4	2	localObject6	Object
    //   156	4	2	localObject7	Object
    //   164	1	2	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   42	46	48	java/io/IOException
    //   2	31	67	java/io/IOException
    //   94	98	101	java/io/IOException
    //   2	31	121	finally
    //   130	134	136	java/io/IOException
    //   33	38	156	finally
    //   72	78	156	finally
    //   80	90	156	finally
    //   33	38	164	java/io/IOException
  }
  
  public static void a()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    String str = "";
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      str = str + "WL_DEBUG ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, str);
    }
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, "WL_DEBUG actionOff");
    }
    paramContext.stopService(new Intent(paramContext, SmallScreenService.class));
  }
  
  public static void a(Context paramContext, SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.f;
    int j = paramSessionInfo.F;
    int k = paramSessionInfo.j;
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenUtils", 2, "WL_DEBUG reportActionOn SessionType = " + i);
      QLog.d("SmallScreenUtils", 2, "WL_DEBUG reportActionOn relationType = " + j);
      QLog.d("SmallScreenUtils", 2, "WL_DEBUG reportActionOn state = " + k);
    }
    if (paramSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b > 0) {
      if (paramSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.a > 0L) {
        paramSessionInfo = "0X8005A49";
      }
    }
    for (;;)
    {
      if ((paramSessionInfo != null) && (c(paramContext))) {
        ReportController.b(null, "CliOper", "", "", paramSessionInfo, paramSessionInfo, 0, 0, "", "", "", "");
      }
      return;
      if (paramSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b == 5)
      {
        paramSessionInfo = "0X8005A48";
      }
      else
      {
        paramSessionInfo = "0X8005A47";
        continue;
        switch (i)
        {
        }
        for (;;)
        {
          paramSessionInfo = null;
          break;
          switch (k)
          {
          case 2: 
          case 3: 
          default: 
            paramSessionInfo = null;
          }
          for (;;)
          {
            break;
            paramSessionInfo = "0X8005A44";
            continue;
            paramSessionInfo = "0X8005A43";
          }
          switch (k)
          {
          case 2: 
          case 3: 
          default: 
            paramSessionInfo = null;
          }
          for (;;)
          {
            break;
            paramSessionInfo = "0X80057DE";
            continue;
            paramSessionInfo = "0X80057DD";
          }
          switch (j)
          {
          default: 
            paramSessionInfo = null;
          }
          for (;;)
          {
            break;
            paramSessionInfo = "0X8005A46";
            continue;
            paramSessionInfo = "0X8005A45";
          }
          switch (j)
          {
          }
        }
        paramSessionInfo = "0X80057E0";
        continue;
        paramSessionInfo = "0X80057DF";
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("isResume", paramBoolean);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, "sendHideSmallScreenBroadcast:" + paramBoolean);
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, "WL_DEBUG actionOn isNeedStartDialog = " + paramBoolean1);
    }
    Intent localIntent = new Intent(paramContext, SmallScreenService.class);
    paramContext.stopService(localIntent);
    paramContext.startService(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, "WL_DEBUG actionOn isFloatWindowOpAllowed : " + c(paramContext) + ", isCalling : " + PhoneStatusTools.e(paramContext) + ", isHome : " + a(paramContext));
    }
    if ((!c(paramContext)) && (!PhoneStatusTools.e(paramContext)) && (!a(paramContext)))
    {
      if (paramBoolean1)
      {
        int i = a(paramString, paramBoolean2);
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "WL_DEBUG actionOn showDialog = " + i);
        }
        if (i < 5)
        {
          paramString = new Intent(paramContext, SmallScreenDialogActivity.class);
          paramString.addFlags(268435456);
          paramString.addFlags(536870912);
          paramString.addFlags(67108864);
          paramString.addFlags(131072);
          paramString.putExtra("is_video", paramBoolean2);
          paramContext.startActivity(paramString);
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenUtils", 2, "WL_DEBUG actionOn start SmallScreenDialogActivity");
          }
        }
      }
      ReportController.b(null, "CliOper", "", "", "0X80057D8", "0X80057D8", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    boolean bool;
    label46:
    label61:
    AnimationSet localAnimationSet;
    if (paramView != null)
    {
      localObject = paramView.getTag(2131296481);
      if (localObject != null) {
        break label184;
      }
      bool = false;
      if ((!paramBoolean2) || (!bool)) {
        break label227;
      }
      localObject = paramView.getTag(2131296480);
      if (localObject != null) {
        break label196;
      }
      bool = false;
      if ((paramView.getVisibility() != 0) || (!bool)) {
        break label208;
      }
      bool = true;
      if (bool != paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "WL_DEBUG startSetVisibleAnimation isVisible = " + paramBoolean1);
        }
        localAnimationSet = new AnimationSet(true);
        if (!paramBoolean1) {
          break label214;
        }
      }
    }
    label184:
    label196:
    label208:
    label214:
    for (Object localObject = new AlphaAnimation(0.0F, 1.0F);; localObject = new AlphaAnimation(1.0F, 0.0F))
    {
      ((AlphaAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setAnimationListener(new got(paramView, paramBoolean1));
      paramView.startAnimation(localAnimationSet);
      paramView.setVisibility(0);
      paramView.setTag(2131296480, Boolean.valueOf(paramBoolean1));
      paramView.setTag(2131296481, Boolean.valueOf(paramBoolean2));
      return;
      bool = ((Boolean)localObject).booleanValue();
      break;
      bool = ((Boolean)localObject).booleanValue();
      break label46;
      bool = false;
      break label61;
    }
    label227:
    paramView.clearAnimation();
    if (paramBoolean1) {}
    for (;;)
    {
      paramView.setVisibility(i);
      break;
      i = 8;
    }
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a(paramString).edit();
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      localEditor.putInt(paramString, paramInt).commit();
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "WL_DEBUG setPrefShowDialog value = " + paramInt);
      }
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {}
    boolean bool1;
    try
    {
      bool1 = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      if (Build.DEVICE.equals("mx2"))
      {
        bool2 = true;
        return bool2;
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            bool1 = false;
          }
          bool2 = bool3;
        } while (Build.DEVICE.equals("mx"));
        bool2 = bool3;
      } while (Build.DEVICE.equals("m9"));
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = paramContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN", null).addCategory("android.intent.category.HOME"), 0);
    localObject = ((ActivityManager)localObject).getRunningTasks(1);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      bool2 = bool1;
      if (((Iterator)localObject).hasNext())
      {
        String str = ((ActivityManager.RunningTaskInfo)((Iterator)localObject).next()).topActivity.getClassName();
        Iterator localIterator = paramContext.iterator();
        while (localIterator.hasNext()) {
          if (((ResolveInfo)localIterator.next()).activityInfo.name.equals(str)) {
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      if (bool1)
      {
        bool2 = bool1;
        return bool2;
      }
      break;
    }
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    boolean bool1 = true;
    Object localObject = paramContext.getSystemService("appops");
    for (;;)
    {
      try
      {
        paramInt = ((Integer)Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localObject, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramContext.getApplicationInfo().uid), paramContext.getPackageName() })).intValue();
        boolean bool2 = QLog.isColorLevel();
        if ((bool2) && ((paramInt != 0) && (3 != paramInt))) {
          continue;
        }
        bool1 = true;
      }
      catch (InvocationTargetException paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenUtils", 2, "checkOp InvocationTargetException e.getCause() = " + paramContext.getCause());
        return false;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenUtils", 2, "WL_DEBUG checkOp e = " + paramContext);
      }
      return bool1;
      bool1 = false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    boolean bool2 = false;
    SmallScreenService.f = false;
    boolean bool1 = bool2;
    if (paramVideoAppInterface != null)
    {
      bool1 = bool2;
      if (paramVideoAppInterface.getApplication() != null)
      {
        bool1 = bool2;
        if (paramVideoAppInterface.a() != null)
        {
          bool1 = bool2;
          if (paramVideoAppInterface.a() != null)
          {
            bool1 = bool2;
            if (paramVideoAppInterface.a().a() != null)
            {
              Object localObject = paramVideoAppInterface.a().a();
              String str = ((SessionInfo)localObject).c;
              if ((((SessionInfo)localObject).f == 3) || (((SessionInfo)localObject).f == 4)) {
                str = ((SessionInfo)localObject).s;
              }
              localObject = new Intent("tencent.video.v2q.SmallScreenState");
              ((Intent)localObject).setPackage(paramVideoAppInterface.getApplication().getPackageName());
              ((Intent)localObject).putExtra("SmallScreenState", paramInt);
              ((Intent)localObject).putExtra("peerUin", str);
              paramVideoAppInterface.a().sendBroadcast((Intent)localObject);
              if (QLog.isDevelopLevel()) {
                QLog.d("SmallScreenUtils", 2, "sendSmallScreenStateBroadcast:" + paramInt);
              }
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    if ((Build.MANUFACTURER.equals("Xiaomi")) && ((Build.MODEL.equals("HM NOTE 1TD")) || (Build.MODEL.equals("MI 3C")))) {}
    for (int i = 1; (bool) && (i == 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    return a(paramContext, 24);
  }
  
  public static boolean d(Context paramContext)
  {
    ConfigInfo localConfigInfo = ConfigInfo.instance();
    paramContext = null;
    if (localConfigInfo != null) {
      paramContext = localConfigInfo.getSharpConfigPayloadFromFile();
    }
    if (!TextUtils.isEmpty(paramContext))
    {
      paramContext = new SmallScreenConfigParser(paramContext);
      if (!paramContext.a()) {}
    }
    for (int i = paramContext.c;; i = -1)
    {
      if ((i == 1) || ((i == -1) && (Build.MODEL.equals("Nexus 6")))) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("SmallScreenUtils", 2, "WL_DEBUG isUseTextureView resultFromServer = " + i);
          QLog.e("SmallScreenUtils", 2, "WL_DEBUG isUseTextureView Build.MODEL = " + Build.MODEL);
          QLog.e("SmallScreenUtils", 2, "WL_DEBUG isUseTextureView result = " + bool);
        }
        return bool;
      }
    }
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!ConfigSystemImpl.c(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreen --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "WL_DEBUG isSupportSmallScreen result = " + bool1);
      }
      return bool1;
      paramContext = a(paramContext);
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.b > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean f(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!ConfigSystemImpl.c(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreenVideo --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "WL_DEBUG isSupportSmallScreenVideo result = " + bool1);
      }
      return bool1;
      paramContext = a(paramContext);
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.d > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean g(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!ConfigSystemImpl.c(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreenAudio --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "WL_DEBUG isSupportSmallScreenAudio result = " + bool1);
      }
      return bool1;
      paramContext = a(paramContext);
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.e > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean h(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    do
    {
      try
      {
        List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
        Object localObject = null;
        paramContext = (Context)localObject;
        if (localList == null) {
          continue;
        }
        paramContext = (Context)localObject;
        if (localList.size() <= 0) {
          continue;
        }
        paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        return false;
      }
      bool = ArrayUtils.a(a, paramContext.getClassName());
      return bool;
    } while (paramContext != null);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */