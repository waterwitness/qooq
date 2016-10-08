package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import uud;
import uue;

public class SetSplash
  extends Step
{
  public static final int a = 2200;
  static final long jdField_a_of_type_Long = 86400000L;
  static final String jdField_a_of_type_JavaLangString = "splashshowtime";
  public static final int b = 2201;
  static final int c = 3;
  
  private static int a(String paramString)
  {
    int i = Calendar.getInstance().get(1);
    paramString = i + "-" + paramString;
    Object localObject = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = ((SimpleDateFormat)localObject).parse(paramString);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(paramString);
      ((Calendar)localObject).set(11, 0);
      ((Calendar)localObject).set(12, 0);
      ((Calendar)localObject).set(13, 0);
      ((Calendar)localObject).set(14, 0);
      paramString = ((Calendar)localObject).getTime();
      localObject = Calendar.getInstance();
      ((Calendar)localObject).set(11, 0);
      ((Calendar)localObject).set(12, 0);
      ((Calendar)localObject).set(13, 0);
      ((Calendar)localObject).set(14, 0);
      localObject = ((Calendar)localObject).getTime();
      long l = (paramString.getTime() - ((Date)localObject).getTime()) / 86400000L;
      return (int)l;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  /* Error */
  public static long a(android.app.Activity paramActivity, StartupDirector paramStartupDirector)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 86
    //   4: ifeq +677 -> 681
    //   7: aload_0
    //   8: checkcast 86	com/tencent/mobileqq/app/IphoneTitleBarActivity
    //   11: ldc 87
    //   13: invokevirtual 91	com/tencent/mobileqq/app/IphoneTitleBarActivity:setContentViewNoTitle	(I)V
    //   16: aload_0
    //   17: ldc 92
    //   19: invokevirtual 98	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   22: checkcast 100	android/widget/ImageView
    //   25: astore 6
    //   27: aload_0
    //   28: invokestatic 105	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   31: astore_2
    //   32: aload_0
    //   33: invokevirtual 109	android/app/Activity:getFilesDir	()Ljava/io/File;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +678 -> 716
    //   41: aload_3
    //   42: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: astore 4
    //   47: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +27 -> 77
    //   53: ldc 122
    //   55: iconst_2
    //   56: new 37	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   63: aload_2
    //   64: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 129	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_3
    //   78: ifnull +1078 -> 1156
    //   81: aload_2
    //   82: ldc -125
    //   84: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifne +1069 -> 1156
    //   90: aload_2
    //   91: invokestatic 139	com/tencent/mobileqq/startup/step/SetSplash:a	(Ljava/lang/String;)I
    //   94: ifne +1062 -> 1156
    //   97: new 37	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   104: aload 4
    //   106: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc -115
    //   111: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: invokestatic 143	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   118: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc -115
    //   123: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc -111
    //   128: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: astore_2
    //   135: new 111	java/io/File
    //   138: dup
    //   139: aload_2
    //   140: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore_3
    //   144: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +35 -> 182
    //   150: ldc 122
    //   152: iconst_2
    //   153: new 37	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   160: aload_2
    //   161: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc -108
    //   166: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_3
    //   170: invokevirtual 151	java/io/File:exists	()Z
    //   173: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   176: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_3
    //   183: invokevirtual 151	java/io/File:exists	()Z
    //   186: ifeq +970 -> 1156
    //   189: new 159	android/graphics/drawable/BitmapDrawable
    //   192: dup
    //   193: aload_0
    //   194: invokevirtual 163	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   197: aload_2
    //   198: invokestatic 168	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   201: invokespecial 171	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   204: astore_2
    //   205: aload_1
    //   206: ifnull +10 -> 216
    //   209: aload_1
    //   210: ldc2_w 172
    //   213: putfield 177	com/tencent/mobileqq/startup/director/StartupDirector:b	J
    //   216: aload_2
    //   217: ifnull +934 -> 1151
    //   220: invokestatic 179	com/tencent/mobileqq/startup/step/SetSplash:a	()V
    //   223: aload_2
    //   224: astore_3
    //   225: aload_3
    //   226: astore_2
    //   227: aload_3
    //   228: ifnonnull +22 -> 250
    //   231: aload_3
    //   232: astore_2
    //   233: invokestatic 185	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   236: invokestatic 188	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;)Z
    //   239: ifeq +11 -> 250
    //   242: invokestatic 185	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   245: aload_1
    //   246: invokestatic 191	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;Lcom/tencent/mobileqq/startup/director/StartupDirector;)Landroid/graphics/drawable/AnimationDrawable;
    //   249: astore_2
    //   250: aload_2
    //   251: astore_3
    //   252: aload_2
    //   253: ifnonnull +893 -> 1146
    //   256: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +11 -> 270
    //   262: ldc -63
    //   264: iconst_2
    //   265: ldc -61
    //   267: invokestatic 129	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: new 37	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   277: aload 4
    //   279: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc -115
    //   284: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc -59
    //   289: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc -115
    //   294: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore 7
    //   302: new 111	java/io/File
    //   305: dup
    //   306: new 37	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   313: aload 4
    //   315: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc -115
    //   320: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc -59
    //   325: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   334: astore 8
    //   336: aconst_null
    //   337: astore 5
    //   339: aconst_null
    //   340: astore_3
    //   341: aload 5
    //   343: astore 4
    //   345: aload 8
    //   347: ifnull +478 -> 825
    //   350: aload 5
    //   352: astore 4
    //   354: aload 8
    //   356: invokevirtual 151	java/io/File:exists	()Z
    //   359: ifeq +466 -> 825
    //   362: aload 5
    //   364: astore 4
    //   366: aload 8
    //   368: invokevirtual 200	java/io/File:isDirectory	()Z
    //   371: ifeq +454 -> 825
    //   374: aload 8
    //   376: invokevirtual 204	java/io/File:listFiles	()[Ljava/io/File;
    //   379: astore 8
    //   381: aload 8
    //   383: arraylength
    //   384: istore 13
    //   386: lconst_0
    //   387: lstore 21
    //   389: lconst_0
    //   390: lstore 19
    //   392: iconst_0
    //   393: istore 12
    //   395: aload_3
    //   396: astore 4
    //   398: iload 12
    //   400: iload 13
    //   402: if_icmpge +423 -> 825
    //   405: aload 8
    //   407: iload 12
    //   409: aaload
    //   410: astore 9
    //   412: aload_3
    //   413: astore 5
    //   415: lload 21
    //   417: lstore 23
    //   419: lload 19
    //   421: lstore 25
    //   423: aload 9
    //   425: ifnull +236 -> 661
    //   428: aload 9
    //   430: invokevirtual 207	java/io/File:getName	()Ljava/lang/String;
    //   433: astore 10
    //   435: aload 10
    //   437: ldc -47
    //   439: invokevirtual 213	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   442: astore 11
    //   444: aload_3
    //   445: astore 5
    //   447: lload 21
    //   449: lstore 23
    //   451: lload 19
    //   453: lstore 25
    //   455: aload 11
    //   457: ifnull +204 -> 661
    //   460: aload_3
    //   461: astore 5
    //   463: lload 21
    //   465: lstore 23
    //   467: lload 19
    //   469: lstore 25
    //   471: aload 11
    //   473: arraylength
    //   474: iconst_3
    //   475: if_icmpne +186 -> 661
    //   478: aload 11
    //   480: iconst_0
    //   481: aaload
    //   482: astore 4
    //   484: lload 21
    //   486: lstore 15
    //   488: lload 19
    //   490: lstore 17
    //   492: aload 4
    //   494: ifnull +60 -> 554
    //   497: lload 21
    //   499: lstore 15
    //   501: lload 19
    //   503: lstore 17
    //   505: aload 4
    //   507: invokevirtual 216	java/lang/String:trim	()Ljava/lang/String;
    //   510: ldc -125
    //   512: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   515: ifne +39 -> 554
    //   518: aload 4
    //   520: ldc -38
    //   522: invokevirtual 221	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   525: istore 14
    //   527: aload 4
    //   529: iconst_0
    //   530: iload 14
    //   532: invokevirtual 225	java/lang/String:substring	(II)Ljava/lang/String;
    //   535: invokestatic 231	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   538: lstore 17
    //   540: aload 4
    //   542: iload 14
    //   544: iconst_1
    //   545: iadd
    //   546: invokevirtual 234	java/lang/String:substring	(I)Ljava/lang/String;
    //   549: invokestatic 231	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   552: lstore 15
    //   554: lload 17
    //   556: lload 15
    //   558: invokestatic 239	com/tencent/mobileqq/util/CommonUtil:a	(JJ)Z
    //   561: ifeq +200 -> 761
    //   564: aload_3
    //   565: astore 4
    //   567: aload_3
    //   568: ifnonnull +34 -> 602
    //   571: new 111	java/io/File
    //   574: dup
    //   575: new 37	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   582: aload 7
    //   584: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 11
    //   589: iconst_1
    //   590: aaload
    //   591: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   600: astore 4
    //   602: aload 4
    //   604: astore 5
    //   606: lload 15
    //   608: lstore 23
    //   610: lload 17
    //   612: lstore 25
    //   614: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq +44 -> 661
    //   620: ldc -63
    //   622: iconst_2
    //   623: new 37	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   630: ldc -15
    //   632: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload 9
    //   637: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   640: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokestatic 129	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   649: lload 17
    //   651: lstore 25
    //   653: lload 15
    //   655: lstore 23
    //   657: aload 4
    //   659: astore 5
    //   661: iload 12
    //   663: iconst_1
    //   664: iadd
    //   665: istore 12
    //   667: aload 5
    //   669: astore_3
    //   670: lload 23
    //   672: lstore 21
    //   674: lload 25
    //   676: lstore 19
    //   678: goto -283 -> 395
    //   681: aload_0
    //   682: ldc 87
    //   684: invokevirtual 244	android/app/Activity:setContentView	(I)V
    //   687: goto -671 -> 16
    //   690: astore_1
    //   691: aload_1
    //   692: invokestatic 250	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   695: astore_1
    //   696: ldc -4
    //   698: iconst_1
    //   699: aload_1
    //   700: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: aload_0
    //   704: ldc -2
    //   706: aload_1
    //   707: invokestatic 259	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload_0
    //   711: invokevirtual 262	android/app/Activity:finish	()V
    //   714: lconst_0
    //   715: lreturn
    //   716: ldc_w 264
    //   719: astore 4
    //   721: goto -674 -> 47
    //   724: astore_3
    //   725: aconst_null
    //   726: astore_2
    //   727: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +13 -> 743
    //   733: ldc 122
    //   735: iconst_2
    //   736: ldc_w 266
    //   739: aload_3
    //   740: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   743: aload_3
    //   744: invokevirtual 272	java/lang/Throwable:printStackTrace	()V
    //   747: goto -531 -> 216
    //   750: astore 4
    //   752: lconst_0
    //   753: lstore 17
    //   755: lconst_0
    //   756: lstore 15
    //   758: goto -204 -> 554
    //   761: aload_3
    //   762: astore 4
    //   764: lload 15
    //   766: invokestatic 277	java/lang/System:currentTimeMillis	()J
    //   769: lcmp
    //   770: ifge -168 -> 602
    //   773: new 111	java/io/File
    //   776: dup
    //   777: new 37	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   784: aload 7
    //   786: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: aload 10
    //   791: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   800: astore 5
    //   802: aload_3
    //   803: astore 4
    //   805: aload 5
    //   807: invokevirtual 151	java/io/File:exists	()Z
    //   810: ifeq -208 -> 602
    //   813: aload 5
    //   815: invokevirtual 280	java/io/File:delete	()Z
    //   818: pop
    //   819: aload_3
    //   820: astore 4
    //   822: goto -220 -> 602
    //   825: aload_2
    //   826: astore_3
    //   827: aload 4
    //   829: ifnull +317 -> 1146
    //   832: aload_2
    //   833: astore_3
    //   834: aload 4
    //   836: invokevirtual 151	java/io/File:exists	()Z
    //   839: ifeq +307 -> 1146
    //   842: aload_2
    //   843: astore_3
    //   844: aload 4
    //   846: invokevirtual 283	java/io/File:isFile	()Z
    //   849: ifeq +297 -> 1146
    //   852: new 159	android/graphics/drawable/BitmapDrawable
    //   855: dup
    //   856: aload_0
    //   857: invokevirtual 163	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   860: aload 4
    //   862: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   865: invokestatic 168	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   868: invokespecial 171	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   871: astore_3
    //   872: aload_1
    //   873: ifnull +10 -> 883
    //   876: aload_1
    //   877: ldc2_w 284
    //   880: putfield 177	com/tencent/mobileqq/startup/director/StartupDirector:b	J
    //   883: aload_3
    //   884: astore_1
    //   885: aload_1
    //   886: astore_3
    //   887: aload_1
    //   888: ifnull +258 -> 1146
    //   891: invokestatic 179	com/tencent/mobileqq/startup/step/SetSplash:a	()V
    //   894: aload_1
    //   895: ifnonnull +199 -> 1094
    //   898: new 159	android/graphics/drawable/BitmapDrawable
    //   901: dup
    //   902: aload_0
    //   903: invokevirtual 163	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   906: aload_0
    //   907: invokevirtual 289	android/app/Activity:getAssets	()Landroid/content/res/AssetManager;
    //   910: ldc_w 291
    //   913: invokevirtual 297	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   916: invokespecial 300	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   919: astore_2
    //   920: aload_2
    //   921: astore_1
    //   922: aload_1
    //   923: ifnull +34 -> 957
    //   926: aload 6
    //   928: aload_1
    //   929: invokevirtual 304	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   932: aload_1
    //   933: instanceof 306
    //   936: ifeq +21 -> 957
    //   939: aload_1
    //   940: checkcast 306	android/graphics/drawable/AnimationDrawable
    //   943: astore_1
    //   944: aload_1
    //   945: ifnull +12 -> 957
    //   948: aload_1
    //   949: iconst_0
    //   950: invokevirtual 310	android/graphics/drawable/AnimationDrawable:setOneShot	(Z)V
    //   953: aload_1
    //   954: invokevirtual 313	android/graphics/drawable/AnimationDrawable:start	()V
    //   957: aload 6
    //   959: invokevirtual 317	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   962: astore_1
    //   963: aload_1
    //   964: ifnull +101 -> 1065
    //   967: aload_1
    //   968: instanceof 159
    //   971: ifne +17 -> 988
    //   974: aload_1
    //   975: instanceof 319
    //   978: ifne +10 -> 988
    //   981: aload_1
    //   982: instanceof 306
    //   985: ifeq +80 -> 1065
    //   988: aload_0
    //   989: invokevirtual 163	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   992: invokevirtual 325	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   995: getfield 330	android/util/DisplayMetrics:widthPixels	I
    //   998: istore 12
    //   1000: aload_0
    //   1001: invokevirtual 163	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1004: invokevirtual 325	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1007: getfield 333	android/util/DisplayMetrics:heightPixels	I
    //   1010: istore 13
    //   1012: aload_1
    //   1013: invokevirtual 339	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   1016: iload 12
    //   1018: imul
    //   1019: aload_1
    //   1020: invokevirtual 342	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   1023: idiv
    //   1024: istore 14
    //   1026: aload 6
    //   1028: invokevirtual 346	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1031: astore_0
    //   1032: aload_0
    //   1033: iload 12
    //   1035: putfield 351	android/view/ViewGroup$LayoutParams:width	I
    //   1038: aload_0
    //   1039: iload 14
    //   1041: putfield 354	android/view/ViewGroup$LayoutParams:height	I
    //   1044: aload 6
    //   1046: aload_0
    //   1047: invokevirtual 358	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1050: iload 14
    //   1052: iload 13
    //   1054: if_icmpgt +56 -> 1110
    //   1057: aload 6
    //   1059: getstatic 364	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   1062: invokevirtual 368	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1065: lconst_0
    //   1066: lreturn
    //   1067: astore_3
    //   1068: aload_2
    //   1069: astore_1
    //   1070: aload_3
    //   1071: astore_2
    //   1072: ldc 122
    //   1074: iconst_1
    //   1075: ldc -125
    //   1077: aload_2
    //   1078: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1081: goto -196 -> 885
    //   1084: astore_2
    //   1085: ldc 122
    //   1087: iconst_1
    //   1088: ldc -125
    //   1090: aload_2
    //   1091: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1094: goto -172 -> 922
    //   1097: astore_1
    //   1098: ldc 122
    //   1100: iconst_1
    //   1101: ldc -125
    //   1103: aload_1
    //   1104: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1107: goto -150 -> 957
    //   1110: iload 14
    //   1112: iload 13
    //   1114: if_icmple -49 -> 1065
    //   1117: aload 6
    //   1119: getstatic 371	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1122: invokevirtual 368	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1125: goto -60 -> 1065
    //   1128: astore_0
    //   1129: aload_0
    //   1130: invokevirtual 272	java/lang/Throwable:printStackTrace	()V
    //   1133: goto -68 -> 1065
    //   1136: astore_2
    //   1137: aload_3
    //   1138: astore_1
    //   1139: goto -67 -> 1072
    //   1142: astore_3
    //   1143: goto -416 -> 727
    //   1146: aload_3
    //   1147: astore_1
    //   1148: goto -254 -> 894
    //   1151: aload_2
    //   1152: astore_3
    //   1153: goto -928 -> 225
    //   1156: aconst_null
    //   1157: astore_3
    //   1158: goto -933 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1161	0	paramActivity	android.app.Activity
    //   0	1161	1	paramStartupDirector	StartupDirector
    //   31	1047	2	localObject1	Object
    //   1084	7	2	localThrowable1	Throwable
    //   1136	16	2	localThrowable2	Throwable
    //   36	634	3	localObject2	Object
    //   724	96	3	localThrowable3	Throwable
    //   826	61	3	localObject3	Object
    //   1067	71	3	localThrowable4	Throwable
    //   1142	5	3	localThrowable5	Throwable
    //   1152	6	3	localThrowable6	Throwable
    //   45	675	4	localObject4	Object
    //   750	1	4	localException	Exception
    //   762	99	4	localThrowable7	Throwable
    //   337	477	5	localObject5	Object
    //   25	1093	6	localImageView	android.widget.ImageView
    //   300	485	7	str1	String
    //   334	72	8	localObject6	Object
    //   410	226	9	localObject7	Object
    //   433	357	10	str2	String
    //   442	146	11	arrayOfString	String[]
    //   393	641	12	i	int
    //   384	731	13	j	int
    //   525	590	14	k	int
    //   486	279	15	l1	long
    //   490	264	17	l2	long
    //   390	287	19	l3	long
    //   387	286	21	l4	long
    //   417	254	23	l5	long
    //   421	254	25	l6	long
    // Exception table:
    //   from	to	target	type
    //   0	16	690	android/content/res/Resources$NotFoundException
    //   681	687	690	android/content/res/Resources$NotFoundException
    //   189	205	724	java/lang/Throwable
    //   518	554	750	java/lang/Exception
    //   852	872	1067	java/lang/Throwable
    //   898	920	1084	java/lang/Throwable
    //   939	944	1097	java/lang/Throwable
    //   948	957	1097	java/lang/Throwable
    //   957	963	1128	java/lang/Throwable
    //   967	988	1128	java/lang/Throwable
    //   988	1050	1128	java/lang/Throwable
    //   1057	1065	1128	java/lang/Throwable
    //   1117	1125	1128	java/lang/Throwable
    //   876	883	1136	java/lang/Throwable
    //   209	216	1142	java/lang/Throwable
  }
  
  private static AnimationDrawable a(Context paramContext, StartupDirector paramStartupDirector)
  {
    for (;;)
    {
      int k;
      int m;
      int n;
      try
      {
        Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext);
        String str = ((SharedPreferences)localObject1).getString("dynamic_splash_config_md5", null);
        k = ((SharedPreferences)localObject1).getInt("dynamic_splash_config_play_times", -1);
        m = ((SharedPreferences)localObject1).getInt("dynamic_splash_config_play_internal", -1);
        if ((!TextUtils.isEmpty(str)) && (k > 0) && (m > 0))
        {
          localObject1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/" + "dynamicSplash";
          str = (String)localObject1 + "/" + str;
          localObject1 = new File(str);
          if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
          {
            localObject1 = ((File)localObject1).listFiles();
            if (localObject1 == null) {
              return null;
            }
            n = localObject1.length - 1;
            if (n <= 0) {
              return null;
            }
            localObject1 = new AnimationDrawable();
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
            j = 0;
            i = 1;
            if (i > n) {
              break label433;
            }
            Object localObject2 = new File(str + "/" + String.valueOf(i) + ".png");
            if ((!((File)localObject2).exists()) || (((File)localObject2).length() <= 0L)) {
              break label422;
            }
            localObject2 = BitmapManager.a(((File)localObject2).getAbsolutePath(), localOptions);
            if (localObject2 == null) {
              break label424;
            }
            j = 1;
            ((AnimationDrawable)localObject1).addFrame(new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject2), m);
            break label424;
            if (QLog.isColorLevel()) {
              QLog.d("SetSplash", 2, "getDynamicSplashDrawable() playTimes=" + k + ", playInterval=" + m + ", totalFilesCount=" + n + ", totalPlayTime=" + i);
            }
            ThreadManager.a(new uue(), 5, null, false);
            if (paramStartupDirector != null) {
              paramStartupDirector.b = i;
            }
            return (AnimationDrawable)localObject1;
          }
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SetSplash", 2, "", paramContext);
        }
        return null;
      }
      return null;
      label422:
      return null;
      label424:
      i += 1;
      continue;
      label433:
      if (j == 0) {
        return null;
      }
      int j = k * m * n;
      if (j <= 0) {
        return null;
      }
      int i = j;
      if (j > 5000) {
        i = 5000;
      }
    }
  }
  
  private static void a()
  {
    ThreadManager.a().postDelayed(new uud(), 5000L);
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
      String str2 = localSharedPreferences.getString("dynamic_splash_config_effective_time", null);
      paramContext = localSharedPreferences.getString("dynamic_splash_config_md5", null);
      long l3 = localSharedPreferences.getLong("dynamic_splash_config_folder_modify_time", -1L);
      if (localSharedPreferences.getInt("dynamic_splash_config_show_times", -1) <= 0) {
        return false;
      }
      boolean bool = TextUtils.isEmpty(str2);
      if (!bool) {}
      int i;
      long l2;
      long l1;
      String str1;
      return false;
    }
    catch (Throwable paramContext)
    {
      try
      {
        i = str2.indexOf("|");
        l2 = Long.parseLong(str2.substring(0, i));
        l1 = Long.parseLong(str2.substring(i + 1));
        if (!CommonUtil.a(l2, l1))
        {
          if (!QLog.isColorLevel()) {
            break label302;
          }
          QLog.d("SetSplash", 2, "needShowDynamicSplash() the current time is not effective");
          return false;
          paramContext = paramContext;
          if (!QLog.isColorLevel()) {
            break label302;
          }
          QLog.d("SetSplash", 2, "needShowDynamicSplash() ERROR msg=" + paramContext.getMessage());
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          l1 = 0L;
          l2 = 0L;
        }
        if ((l3 >= 0L) && (!TextUtils.isEmpty(paramContext)))
        {
          str1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/" + "dynamicSplash";
          paramContext = new File(str1 + "/" + paramContext);
          if ((paramContext.exists()) && (paramContext.isDirectory()) && (l3 == paramContext.lastModified()) && (DeviceInfoUtil.c() >= 805306368L)) {
            return true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SetSplash", 2, "needShowDynamicSplash() the folder of splash is modified, NOT show");
          }
        }
      }
    }
  }
  
  public static boolean b()
  {
    long l1 = BaseApplicationImpl.a().getSharedPreferences("banner_and_splash", 0).getLong("splashshowtime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 > l1) && (l2 <= 86400000L + l1)) {
      return false;
    }
    if (l2 > l1 + 86400000L)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      Object localObject1 = localBaseApplicationImpl.getFilesDir();
      int j;
      long l4;
      long l3;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        localObject2 = new File((String)localObject1 + "/" + "splashpic");
        if ((localObject2 != null) && (((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
        {
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 != null)
          {
            j = localObject2.length;
            l4 = 0L;
            l3 = 0L;
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i >= j) {
            break label332;
          }
          Object localObject3 = localObject2[i];
          long l5 = l4;
          long l6 = l3;
          if (localObject3 != null)
          {
            localObject3 = ((File)localObject3).getName().split("_");
            l5 = l4;
            l6 = l3;
            if (localObject3 != null)
            {
              l5 = l4;
              l6 = l3;
              if (localObject3.length == 3)
              {
                localObject3 = localObject3[0];
                l1 = l4;
                l2 = l3;
                if (localObject3 != null)
                {
                  l1 = l4;
                  l2 = l3;
                  if (((String)localObject3).trim().equals("")) {}
                }
                try
                {
                  int k = ((String)localObject3).indexOf("|");
                  l2 = Long.parseLong(((String)localObject3).substring(0, k));
                  l1 = Long.parseLong(((String)localObject3).substring(k + 1));
                  l5 = l1;
                  l6 = l2;
                  if (CommonUtil.a(l2, l1))
                  {
                    return true;
                    localObject1 = "/data/data/com.tencent.mobileqq/files";
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    l2 = 0L;
                    l1 = 0L;
                  }
                }
              }
            }
          }
          i += 1;
          l4 = l5;
          l3 = l6;
        }
      }
      label332:
      Object localObject2 = SharedPreUtils.b(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.i("SetSplash", 2, "bir = " + (String)localObject2);
      }
      if ((!((String)localObject2).equals("")) && (a((String)localObject2) == 0))
      {
        localObject1 = new File((String)localObject1 + "/" + SharedPreUtils.a(localBaseApplicationImpl) + "/" + "birthdayflashlogo.png");
        if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).length() > 1L)) {
          return true;
        }
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SetSplash", 2, "now time less than last show time");
    }
    return false;
  }
  
  protected boolean a()
  {
    AppActivity localAppActivity = this.a.a;
    try
    {
      boolean bool = localAppActivity.showPreview();
      if (!bool) {
        break label35;
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label35:
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("SetSplash", 2, "", localNotFoundException);
        }
      } while (a(localAppActivity, this.a) <= 0L);
      BaseApplicationImpl.jdField_a_of_type_Long = 0L;
      BaseApplicationImpl.b = 0L;
      BaseApplicationImpl.c = 0L;
      this.a.c = 0L;
    }
    return true;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\SetSplash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */