package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import wdb;
import wdc;
import wdd;

public class QQUtils
{
  public static final String a = "sid";
  public static final String b = "uin";
  private static String c = "QQUtils";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Dialog a(Activity paramActivity, String paramString1, String paramString2, int paramInt, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Dialog localDialog = new Dialog(paramActivity, 2131558973);
    localDialog.setContentView(2130904225);
    TextView localTextView4 = (TextView)localDialog.findViewById(2131301883);
    TextView localTextView5 = (TextView)localDialog.findViewById(2131301884);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131301887);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131301888);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131301889);
    localTextView4.setText("   " + paramString1 + "   ");
    localTextView5.setText(paramString2);
    paramString1 = (ImageView)localDialog.findViewById(2131301886);
    paramString2 = (TextView)localDialog.findViewById(2131297843);
    localTextView4 = (TextView)localDialog.findViewById(2131297844);
    paramString2.setOnClickListener(paramOnClickListener2);
    paramString2.setTag(localDialog);
    localTextView4.setOnClickListener(paramOnClickListener1);
    localTextView4.setTag(localDialog);
    if (paramInt >= 0)
    {
      paramString1.setImageResource(2130840885);
      localTextView2.setText("+");
      localTextView2.setTextColor(-766649);
      localTextView1.setText(String.valueOf(paramInt));
      localTextView1.setTextColor(-766649);
      localTextView3.setTextColor(-766649);
    }
    while ((paramActivity instanceof NearbyActivity))
    {
      paramString2.setText(2131372138);
      localTextView4.setText(2131369401);
      return localDialog;
      paramString1.setImageDrawable(null);
      localTextView2.setText("-");
      localTextView2.setTextColor(-16734752);
      localTextView1.setText(String.valueOf(0 - paramInt));
      localTextView1.setTextColor(-16734752);
      localTextView3.setTextColor(-16734752);
    }
    if (paramInt >= 0)
    {
      paramString2.setText(2131372138);
      localTextView4.setText(2131369401);
      return localDialog;
    }
    paramString2.setText(2131369401);
    localTextView4.setText(2131369982);
    return localDialog;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, String paramString, Map paramMap)
  {
    Intent localIntent = new Intent("intent.start.shortcut.guide");
    localIntent.setClassName(paramQQAppInterface.a(), ShortcutGuideActivity.class.getName());
    localIntent.addCategory("android.intent.category.LAUNCHER");
    String str = (String)paramMap.get("nickname");
    if (paramString.endsWith("sid"))
    {
      paramQQAppInterface = (String)paramMap.get("starHomeUrl");
      localIntent.putExtra("sid", (String)paramMap.get("starId"));
      localIntent.putExtra("from", "starShortcut");
      localIntent.putExtra("starhomeurl", paramQQAppInterface);
      paramQQAppInterface = str;
    }
    for (;;)
    {
      localIntent.putExtra("uinname", paramQQAppInterface);
      return localIntent;
      paramString = (String)paramMap.get("uin");
      int i = Integer.valueOf(paramMap.get("uinType").toString()).intValue();
      localIntent.putExtra("uin", paramString);
      if (str != null)
      {
        paramQQAppInterface = str;
        if (str.trim().length() != 0) {}
      }
      else
      {
        paramQQAppInterface = paramString;
      }
      if (i == 1024) {
        localIntent.putExtra("uintype", 1024);
      } else {
        localIntent.putExtra("uintype", 0);
      }
    }
  }
  
  /* Error */
  public static Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 200	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: ifne +7 -> 11
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: getstatic 202	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 208	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 214	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   25: aconst_null
    //   26: ldc -40
    //   28: iconst_1
    //   29: anewarray 93	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: aconst_null
    //   37: invokevirtual 222	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +60 -> 102
    //   45: aconst_null
    //   46: astore_2
    //   47: aload_0
    //   48: astore_1
    //   49: aload_0
    //   50: invokeinterface 228 1 0
    //   55: ifeq +33 -> 88
    //   58: aload_0
    //   59: astore_1
    //   60: aload_0
    //   61: aload_0
    //   62: ldc -26
    //   64: invokeinterface 234 2 0
    //   69: invokeinterface 238 2 0
    //   74: astore_2
    //   75: aload_0
    //   76: astore_1
    //   77: aload_2
    //   78: iconst_0
    //   79: aload_2
    //   80: arraylength
    //   81: invokestatic 243	com/tencent/mobileqq/util/BitmapManager:a	([BII)Landroid/graphics/Bitmap;
    //   84: astore_2
    //   85: goto -38 -> 47
    //   88: aload_2
    //   89: astore_1
    //   90: aload_0
    //   91: ifnull -82 -> 9
    //   94: aload_0
    //   95: invokeinterface 246 1 0
    //   100: aload_2
    //   101: areturn
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: aload_0
    //   107: invokeinterface 246 1 0
    //   112: aconst_null
    //   113: areturn
    //   114: astore_2
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: astore_1
    //   119: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +34 -> 156
    //   125: aload_0
    //   126: astore_1
    //   127: getstatic 24	com/tencent/mobileqq/utils/QQUtils:c	Ljava/lang/String;
    //   130: iconst_2
    //   131: new 53	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   138: ldc -3
    //   140: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_2
    //   144: invokevirtual 254	java/lang/Exception:toString	()Ljava/lang/String;
    //   147: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: ifnull -45 -> 112
    //   160: aload_0
    //   161: invokeinterface 246 1 0
    //   166: goto -54 -> 112
    //   169: astore_0
    //   170: aconst_null
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +9 -> 182
    //   176: aload_1
    //   177: invokeinterface 246 1 0
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: goto -13 -> 172
    //   188: astore_2
    //   189: goto -72 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramString	String
    //   14	87	2	localObject	Object
    //   114	30	2	localException1	Exception
    //   188	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   20	41	114	java/lang/Exception
    //   20	41	169	finally
    //   49	58	184	finally
    //   60	75	184	finally
    //   77	85	184	finally
    //   119	125	184	finally
    //   127	156	184	finally
    //   49	58	188	java/lang/Exception
    //   60	75	188	java/lang/Exception
    //   77	85	188	java/lang/Exception
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramString2 = a(paramString2);
    File localFile = new File(paramString2);
    if (!localFile.exists())
    {
      if (paramBoolean) {
        return paramQQAppInterface.a(a(paramQQAppInterface.a(), paramString3), 50, 50);
      }
      if (!HttpDownloadUtil.a(paramQQAppInterface, paramString1, localFile))
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        return null;
      }
    }
    return paramQQAppInterface.a(BitmapManager.a(paramString2), 50, 50);
  }
  
  /* Error */
  public static SparseArray a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 200	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: ifne +7 -> 11
    //   7: aconst_null
    //   8: astore_0
    //   9: aload_0
    //   10: areturn
    //   11: getstatic 202	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 208	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_2
    //   21: invokestatic 214	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: astore_2
    //   25: new 53	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 287
    //   35: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 289
    //   45: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_1
    //   52: aload_0
    //   53: aload_2
    //   54: iconst_2
    //   55: anewarray 93	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc_w 291
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc_w 293
    //   69: aastore
    //   70: aload_1
    //   71: aconst_null
    //   72: aconst_null
    //   73: invokevirtual 222	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +133 -> 211
    //   81: aload_1
    //   82: astore_0
    //   83: new 295	android/util/SparseArray
    //   86: dup
    //   87: invokespecial 296	android/util/SparseArray:<init>	()V
    //   90: astore_2
    //   91: aload_1
    //   92: astore_0
    //   93: aload_1
    //   94: invokeinterface 228 1 0
    //   99: ifeq +98 -> 197
    //   102: aload_1
    //   103: astore_0
    //   104: aload_1
    //   105: aload_1
    //   106: ldc_w 291
    //   109: invokeinterface 234 2 0
    //   114: invokeinterface 299 2 0
    //   119: astore_3
    //   120: aload_1
    //   121: astore_0
    //   122: aload_2
    //   123: aload_1
    //   124: aload_1
    //   125: ldc_w 293
    //   128: invokeinterface 234 2 0
    //   133: invokeinterface 303 2 0
    //   138: aload_3
    //   139: invokevirtual 307	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   142: goto -51 -> 91
    //   145: astore_2
    //   146: aload_1
    //   147: astore_0
    //   148: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +34 -> 185
    //   154: aload_1
    //   155: astore_0
    //   156: getstatic 24	com/tencent/mobileqq/utils/QQUtils:c	Ljava/lang/String;
    //   159: iconst_2
    //   160: new 53	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   167: ldc -3
    //   169: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_2
    //   173: invokevirtual 254	java/lang/Exception:toString	()Ljava/lang/String;
    //   176: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_1
    //   186: ifnull +9 -> 195
    //   189: aload_1
    //   190: invokeinterface 246 1 0
    //   195: aconst_null
    //   196: areturn
    //   197: aload_2
    //   198: astore_0
    //   199: aload_1
    //   200: ifnull -191 -> 9
    //   203: aload_1
    //   204: invokeinterface 246 1 0
    //   209: aload_2
    //   210: areturn
    //   211: aload_1
    //   212: ifnull -17 -> 195
    //   215: aload_1
    //   216: invokeinterface 246 1 0
    //   221: goto -26 -> 195
    //   224: astore_1
    //   225: aconst_null
    //   226: astore_0
    //   227: aload_0
    //   228: ifnull +9 -> 237
    //   231: aload_0
    //   232: invokeinterface 246 1 0
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: goto -13 -> 227
    //   243: astore_2
    //   244: aconst_null
    //   245: astore_1
    //   246: goto -100 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramContext	Context
    //   0	249	1	paramString	String
    //   14	109	2	localObject	Object
    //   145	65	2	localException1	Exception
    //   243	1	2	localException2	Exception
    //   119	20	3	str	String
    // Exception table:
    //   from	to	target	type
    //   83	91	145	java/lang/Exception
    //   93	102	145	java/lang/Exception
    //   104	120	145	java/lang/Exception
    //   122	142	145	java/lang/Exception
    //   20	77	224	finally
    //   83	91	239	finally
    //   93	102	239	finally
    //   104	120	239	finally
    //   122	142	239	finally
    //   148	154	239	finally
    //   156	185	239	finally
    //   20	77	243	java/lang/Exception
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.a();
    }
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramContext = paramContext.getPackageManager().getInstalledPackages(8);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)paramContext.next()).providers;
        if (arrayOfProviderInfo != null)
        {
          int j = arrayOfProviderInfo.length;
          int i = 0;
          while (i < j)
          {
            ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
            if (paramString.equals(localProviderInfo.readPermission)) {
              return localProviderInfo.authority;
            }
            i += 1;
          }
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(AppConstants.bX);
    String str = MD5.toMD5(paramString);
    str = MD5.toMD5(str + paramString);
    localStringBuilder.append(MD5.toMD5(str + paramString));
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static String a(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = BaseApplicationImpl.a();
    if (localObject1 != null) {}
    for (localObject1 = ((BaseApplicationImpl)localObject1).a();; localObject1 = null)
    {
      if (localObject1 == null) {
        paramConfigType = (ServerConfigManager.ConfigType)localObject2;
      }
      StringBuilder localStringBuilder;
      ServerConfigManager localServerConfigManager;
      do
      {
        return paramConfigType;
        if ((localObject1 instanceof QQAppInterface)) {
          return ((QQAppInterface)localObject1).a(paramConfigType, paramString);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getServerConfigValue type=").append(paramConfigType).append(", key=").append(paramString).append(", value=");
        localServerConfigManager = (ServerConfigManager)((AppRuntime)localObject1).getManager(4);
        if (localServerConfigManager == null) {
          break;
        }
        localObject1 = localServerConfigManager.getServerConfig(a(), paramConfigType);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label249;
        }
        String str = "<" + paramString + ">";
        i = ((String)localObject1).indexOf(str);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (-1 == i) {
          break label249;
        }
        i = str.length() + i;
        int j = ((String)localObject1).indexOf("</" + paramString + ">", i);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (-1 == j) {
          break label249;
        }
        paramString = ((String)localObject1).substring(i, j);
        localStringBuilder.append(paramString);
        paramConfigType = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("QQUtils", 2, localStringBuilder.toString());
      return paramString;
      paramConfigType = null;
      label249:
      paramString = new StringBuilder().append("null, configTextSize=");
      if (paramConfigType != null) {}
      for (int i = paramConfigType.length();; i = -1)
      {
        localStringBuilder.append(i).append(", scm=").append(localServerConfigManager);
        paramConfigType = (ServerConfigManager.ConfigType)localObject2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQUtils", 2, localStringBuilder.toString());
        return null;
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    ShortcutUtils.a(paramActivity, paramString);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ShortcutUtils.a(paramContext, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, int paramInt2, Handler paramHandler, int paramInt3)
  {
    if (a(paramQQAppInterface.a(), new String[] { paramString2 }))
    {
      paramString1 = paramQQAppInterface.a().getString(2131369476);
      if (paramString1 != null) {
        QQToast.a(paramQQAppInterface.a(), paramString1, 0).b(paramInt2);
      }
      return;
    }
    Object localObject = new Intent("android.intent.action.MAIN");
    ((Intent)localObject).setClassName(paramQQAppInterface.a(), paramString1);
    ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
    ((Intent)localObject).putExtra("jump_shortcut_dataline", true);
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().a((Intent)localObject);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString2);
    if (2130840317 == paramInt1)
    {
      ((Intent)localObject).putExtra("targetUin", AppConstants.ak);
      ((Intent)localObject).putExtra("device_type", 1);
    }
    for (paramString1 = paramQQAppInterface.a().getApplicationContext();; paramString1 = Bitmap.createScaledBitmap((Bitmap)localObject, paramInt1, paramInt1, false))
    {
      try
      {
        localObject = BitmapFactory.decodeResource(paramString1.getResources(), paramInt1);
        paramInt1 = DisplayUtils.b(paramString1);
        paramString1 = (String)localObject;
        if (((Bitmap)localObject).getWidth() != paramInt1)
        {
          if (MobileIssueSettings.c) {
            continue;
          }
          paramString1 = KapalaiAdapterUtil.a().a((Bitmap)localObject, paramInt1);
        }
        localIntent.putExtra("android.intent.extra.shortcut.ICON", paramString1);
        localIntent.putExtra("duplicate", false);
        localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        paramQQAppInterface.a().sendOrderedBroadcast(localIntent, null);
        paramHandler.postDelayed(new wdd(a(paramQQAppInterface.a(), new String[] { paramString2 }), paramQQAppInterface, paramInt2), paramInt3);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      ((Intent)localObject).putExtra("targetUin", AppConstants.aj);
      ((Intent)localObject).putExtra("device_type", 0);
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().a(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", "QQ");
    localIntent.putExtra("duplicate", false);
    localIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramQQAppInterface.a().sendOrderedBroadcast(localIntent, null);
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "deleteShortcut.finish.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString, Bitmap paramBitmap)
  {
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().a(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    int i = DisplayUtils.b(paramQQAppInterface.a());
    paramIntent = paramBitmap;
    if (i != paramBitmap.getWidth()) {
      if (MobileIssueSettings.c) {
        break label128;
      }
    }
    label128:
    for (paramIntent = KapalaiAdapterUtil.a().a(paramBitmap, i);; paramIntent = Bitmap.createScaledBitmap(paramBitmap, i, i, false))
    {
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramIntent);
      localIntent.putExtra("duplicate", false);
      localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramQQAppInterface.a().sendOrderedBroadcast(localIntent, null);
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "createShortcut.finish.");
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    SparseArray localSparseArray = a(paramQQAppInterface.a(), paramString);
    if (localSparseArray == null) {}
    for (;;)
    {
      return;
      int j = localSparseArray.size();
      int i = 0;
      if (i >= j) {
        continue;
      }
      int k = localSparseArray.keyAt(i);
      Object localObject1 = (String)localSparseArray.get(k);
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = Intent.parseUri((String)localObject1, 0);
          if (localObject1 == null) {
            continue;
          }
          str = ((Intent)localObject1).getStringExtra("uinname");
          if (paramString.endsWith("sid"))
          {
            localBitmap = a(null, ((Intent)localObject1).getStringExtra("sid"), String.valueOf(k), paramQQAppInterface, true);
            a(paramQQAppInterface, (Intent)localObject1);
          }
        }
      }
      catch (URISyntaxException localInterruptedException2)
      {
        for (;;)
        {
          try
          {
            String str;
            Thread.sleep(1000L);
            a(paramQQAppInterface, (Intent)localObject1, str, localBitmap);
          }
          catch (InterruptedException localInterruptedException2)
          {
            try
            {
              Thread.sleep(1000L);
              i += 1;
              break;
              localURISyntaxException = localURISyntaxException;
              if (QLog.isColorLevel()) {
                QLog.d(c, 2, "shortcutIntent parse exception " + localURISyntaxException.getMessage());
              }
              Object localObject2 = null;
              continue;
              Bitmap localBitmap = SkinUtils.a(paramQQAppInterface.b(((Intent)localObject2).getStringExtra("uin")));
              continue;
              localInterruptedException2 = localInterruptedException2;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d(c, 2, "thread sleep exception " + localInterruptedException2.getMessage());
            }
            catch (InterruptedException localInterruptedException1)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d(c, 2, "thread sleep exception " + localInterruptedException1.getMessage());
              continue;
            }
          }
          Object localObject3 = null;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("uin", paramString1);
    ((Map)localObject).put("nickname", paramString2);
    ((Map)localObject).put("uinType", Integer.valueOf(paramInt));
    Intent localIntent = a(paramQQAppInterface, "uin", (Map)localObject);
    localObject = paramQQAppInterface.a(1, paramString1, (byte)3, true, 0);
    paramString1 = (String)localObject;
    if (localObject == null) {
      paramString1 = ImageUtil.a();
    }
    a(paramQQAppInterface, localIntent, paramString2, paramString1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, MqqHandler paramMqqHandler, int paramInt2, String paramString3, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "createShortcutWhihTips.begin.");
    }
    if (a(paramQQAppInterface.a(), new String[] { paramString2 }))
    {
      paramString1 = paramQQAppInterface.a().getString(2131369476);
      if (paramString1 != null) {
        paramMqqHandler.post(new wdb(paramQQAppInterface, paramString1, paramInt1));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "createShortcutWhihTips.no shortcut.");
    }
    a(paramQQAppInterface, paramString1, paramString2, paramInt3);
    paramMqqHandler.postDelayed(new wdc(a(paramQQAppInterface.a(), new String[] { paramString2 }), paramQQAppInterface, paramInt1, paramString3), paramInt2);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append(paramArrayList.get(i)).append(", ");
        i += 1;
      }
    }
    QLog.d(paramString1, paramInt, paramString2 + localStringBuilder.toString());
  }
  
  public static final boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    return ShortcutUtils.a(paramContext, paramArrayOfString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\QQUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */