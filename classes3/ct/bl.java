package ct;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import com.tencent.map.geolocation.internal.TencentHttpClientFactory;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class bl
{
  private static volatile bl k;
  public final Context a;
  public final bm b;
  public final ExecutorService c;
  final PackageManager d;
  public final TelephonyManager e;
  public final WifiManager f;
  public final LocationManager g;
  final TencentHttpClient h;
  private final HashMap<String, bp> i;
  private final CountDownLatch j;
  private List<de> l;
  
  private bl(Context paramContext)
  {
    this.a = paramContext;
    this.d = paramContext.getPackageManager();
    this.e = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.f = ((WifiManager)paramContext.getSystemService("wifi"));
    this.g = ((LocationManager)paramContext.getSystemService("location"));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("channelId", b.c(paramContext.getPackageName()));
    this.h = TencentHttpClientFactory.getInstance().getTencentHttpClient(paramContext, (Bundle)localObject);
    localObject = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    }
    this.c = ((ExecutorService)localObject);
    this.i = new HashMap();
    this.i.put("cell", new bq("cell"));
    this.i.put("so", new br(paramContext, "so"));
    this.b = new bm();
    this.b.g = b(paramContext);
    this.j = new CountDownLatch(1);
    new Thread(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore_3
        //   5: aload_0
        //   6: getfield 16	ct/bl$1:a	Lct/bl;
        //   9: astore 6
        //   11: aload 6
        //   13: getfield 35	ct/bl:b	Lct/bm;
        //   16: astore 5
        //   18: new 37	java/io/FileInputStream
        //   21: dup
        //   22: new 39	java/io/File
        //   25: dup
        //   26: invokestatic 45	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   29: ldc 47
        //   31: invokespecial 50	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   34: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   37: astore_1
        //   38: aload_1
        //   39: ifnonnull +708 -> 747
        //   42: aload 6
        //   44: getfield 56	ct/bl:a	Landroid/content/Context;
        //   47: invokevirtual 62	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
        //   50: ldc 47
        //   52: invokevirtual 68	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
        //   55: astore_2
        //   56: aload 4
        //   58: astore_1
        //   59: aload_2
        //   60: ifnull +35 -> 95
        //   63: sipush 1024
        //   66: newarray <illegal type>
        //   68: astore_1
        //   69: new 70	org/json/JSONObject
        //   72: dup
        //   73: new 72	java/lang/String
        //   76: dup
        //   77: aload_1
        //   78: iconst_0
        //   79: aload_2
        //   80: aload_1
        //   81: invokevirtual 78	java/io/InputStream:read	([B)I
        //   84: invokespecial 81	java/lang/String:<init>	([BII)V
        //   87: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   90: astore_1
        //   91: aload_2
        //   92: invokestatic 89	ct/b:a	(Ljava/io/Closeable;)V
        //   95: aload_1
        //   96: ifnull +133 -> 229
        //   99: aload_1
        //   100: ldc 91
        //   102: iconst_0
        //   103: invokevirtual 95	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
        //   106: pop
        //   107: aload_1
        //   108: ldc 97
        //   110: iconst_0
        //   111: invokevirtual 95	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
        //   114: pop
        //   115: aload_1
        //   116: ldc 99
        //   118: iconst_0
        //   119: invokevirtual 95	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
        //   122: pop
        //   123: aload_1
        //   124: ldc 101
        //   126: iconst_0
        //   127: invokevirtual 95	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
        //   130: pop
        //   131: aload_1
        //   132: ldc 103
        //   134: iconst_0
        //   135: invokevirtual 95	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
        //   138: pop
        //   139: aload_1
        //   140: ldc 105
        //   142: ldc2_w 106
        //   145: invokevirtual 111	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
        //   148: pop2
        //   149: aload_1
        //   150: ldc 113
        //   152: ldc2_w 114
        //   155: invokevirtual 111	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
        //   158: pop2
        //   159: aload 5
        //   161: aload_1
        //   162: ldc 117
        //   164: iconst_1
        //   165: invokevirtual 95	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
        //   168: putfield 123	ct/bm:q	Z
        //   171: aload 5
        //   173: aload_1
        //   174: ldc 125
        //   176: iconst_0
        //   177: invokevirtual 95	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
        //   180: putfield 128	ct/bm:r	Z
        //   183: aload 5
        //   185: aload_1
        //   186: ldc -127
        //   188: iconst_1
        //   189: invokevirtual 95	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
        //   192: putfield 131	ct/bm:s	Z
        //   195: aload_1
        //   196: ldc -123
        //   198: ldc -121
        //   200: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   203: astore_2
        //   204: aload 5
        //   206: aload_2
        //   207: putfield 143	ct/bm:n	Ljava/lang/String;
        //   210: aload 5
        //   212: aload_2
        //   213: putfield 146	ct/bm:p	Ljava/lang/String;
        //   216: aload 5
        //   218: aload_1
        //   219: ldc -108
        //   221: ldc -106
        //   223: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   226: putfield 152	ct/bm:o	Ljava/lang/String;
        //   229: aload 6
        //   231: invokevirtual 155	ct/bl:b	()Landroid/content/pm/PackageInfo;
        //   234: astore_2
        //   235: aload_2
        //   236: getfield 161	android/content/pm/PackageInfo:versionCode	I
        //   239: istore 10
        //   241: aload 5
        //   243: aload_2
        //   244: getfield 164	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
        //   247: putfield 167	ct/bm:h	Ljava/lang/String;
        //   250: aload 6
        //   252: getfield 56	ct/bl:a	Landroid/content/Context;
        //   255: invokevirtual 171	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
        //   258: aload 6
        //   260: getfield 174	ct/bl:d	Landroid/content/pm/PackageManager;
        //   263: invokevirtual 180	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
        //   266: astore_1
        //   267: aload_1
        //   268: ifnull +484 -> 752
        //   271: aload_1
        //   272: invokevirtual 184	java/lang/Object:toString	()Ljava/lang/String;
        //   275: astore_1
        //   276: aload 5
        //   278: aload_1
        //   279: putfield 187	ct/bm:i	Ljava/lang/String;
        //   282: aload 6
        //   284: getfield 191	ct/bl:e	Landroid/telephony/TelephonyManager;
        //   287: astore_3
        //   288: ldc -63
        //   290: astore_1
        //   291: aload_3
        //   292: ifnull +90 -> 382
        //   295: iconst_2
        //   296: newarray <illegal type>
        //   298: astore_1
        //   299: aload_3
        //   300: aload_1
        //   301: invokestatic 198	ct/cx:a	(Landroid/telephony/TelephonyManager;[I)V
        //   304: aload 5
        //   306: aload_1
        //   307: iconst_0
        //   308: iaload
        //   309: putfield 201	ct/bm:j	I
        //   312: aload 5
        //   314: aload_1
        //   315: iconst_1
        //   316: iaload
        //   317: putfield 204	ct/bm:k	I
        //   320: aload 5
        //   322: aload_3
        //   323: invokevirtual 210	android/telephony/TelephonyManager:getPhoneType	()I
        //   326: putfield 212	ct/bm:a	I
        //   329: aload_3
        //   330: invokevirtual 215	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
        //   333: getstatic 220	ct/dc:a	Ljava/util/regex/Pattern;
        //   336: invokestatic 223	ct/dc:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
        //   339: astore_1
        //   340: aload_3
        //   341: invokevirtual 226	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
        //   344: getstatic 228	ct/dc:b	Ljava/util/regex/Pattern;
        //   347: invokestatic 223	ct/dc:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
        //   350: astore 4
        //   352: aload_3
        //   353: invokevirtual 231	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
        //   356: getstatic 234	ct/dc:c	Ljava/util/regex/Pattern;
        //   359: invokestatic 223	ct/dc:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
        //   362: astore_3
        //   363: aload 5
        //   365: aload_1
        //   366: putfield 236	ct/bm:b	Ljava/lang/String;
        //   369: aload 5
        //   371: aload 4
        //   373: putfield 238	ct/bm:c	Ljava/lang/String;
        //   376: aload 5
        //   378: aload_3
        //   379: putfield 240	ct/bm:d	Ljava/lang/String;
        //   382: aload 5
        //   384: aload 6
        //   386: invokestatic 245	ct/dd:c	(Lct/bl;)Ljava/lang/String;
        //   389: ldc -9
        //   391: ldc -7
        //   393: invokevirtual 252	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   396: getstatic 258	java/util/Locale:ENGLISH	Ljava/util/Locale;
        //   399: invokevirtual 262	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
        //   402: getstatic 264	ct/dc:d	Ljava/util/regex/Pattern;
        //   405: invokestatic 223	ct/dc:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
        //   408: putfield 266	ct/bm:e	Ljava/lang/String;
        //   411: aload 6
        //   413: getfield 174	ct/bl:d	Landroid/content/pm/PackageManager;
        //   416: astore_3
        //   417: aload_3
        //   418: ldc_w 268
        //   421: invokevirtual 274	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
        //   424: istore 14
        //   426: aload_3
        //   427: ldc_w 276
        //   430: invokevirtual 274	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
        //   433: istore 15
        //   435: aload_3
        //   436: ldc_w 278
        //   439: invokevirtual 274	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
        //   442: istore 16
        //   444: new 280	java/lang/StringBuilder
        //   447: dup
        //   448: ldc_w 282
        //   451: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   454: iload 14
        //   456: invokevirtual 287	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
        //   459: ldc_w 289
        //   462: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   465: iload 15
        //   467: invokevirtual 287	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
        //   470: ldc_w 294
        //   473: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   476: iload 16
        //   478: invokevirtual 287	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
        //   481: pop
        //   482: invokestatic 300	java/lang/System:currentTimeMillis	()J
        //   485: ldc2_w 301
        //   488: ldiv
        //   489: lstore 12
        //   491: lload 12
        //   493: ldc2_w 303
        //   496: lrem
        //   497: l2i
        //   498: istore 11
        //   500: aload_1
        //   501: iconst_1
        //   502: invokevirtual 308	java/lang/String:substring	(I)Ljava/lang/String;
        //   505: invokestatic 314	java/lang/Long:parseLong	(Ljava/lang/String;)J
        //   508: lstore 12
        //   510: lload 12
        //   512: ldc2_w 303
        //   515: lrem
        //   516: l2i
        //   517: istore 10
        //   519: aload 6
        //   521: getfield 56	ct/bl:a	Landroid/content/Context;
        //   524: ldc_w 316
        //   527: iconst_0
        //   528: invokevirtual 320	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   531: astore_1
        //   532: iload 11
        //   534: iload 10
        //   536: if_icmpne +441 -> 977
        //   539: aload_1
        //   540: ldc_w 322
        //   543: iconst_0
        //   544: invokeinterface 327 3 0
        //   549: ifne +284 -> 833
        //   552: aload_3
        //   553: sipush 8192
        //   556: invokevirtual 331	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
        //   559: astore 7
        //   561: new 280	java/lang/StringBuilder
        //   564: dup
        //   565: invokespecial 332	java/lang/StringBuilder:<init>	()V
        //   568: astore 4
        //   570: aload 7
        //   572: invokeinterface 338 1 0
        //   577: astore 7
        //   579: aload 7
        //   581: invokeinterface 344 1 0
        //   586: ifeq +186 -> 772
        //   589: aload 7
        //   591: invokeinterface 348 1 0
        //   596: checkcast 157	android/content/pm/PackageInfo
        //   599: astore 8
        //   601: aload 8
        //   603: getfield 352	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
        //   606: getfield 355	android/content/pm/ApplicationInfo:flags	I
        //   609: istore 10
        //   611: aload 8
        //   613: getfield 352	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
        //   616: astore 9
        //   618: iload 10
        //   620: iconst_1
        //   621: iand
        //   622: ifgt -43 -> 579
        //   625: aload 8
        //   627: getfield 352	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
        //   630: aload_3
        //   631: invokevirtual 180	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
        //   634: invokevirtual 184	java/lang/Object:toString	()Ljava/lang/String;
        //   637: astore 9
        //   639: aload 9
        //   641: invokevirtual 358	java/lang/String:length	()I
        //   644: bipush 30
        //   646: if_icmpgt +360 -> 1006
        //   649: aload 9
        //   651: ldc_w 360
        //   654: invokevirtual 363	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   657: ifne +349 -> 1006
        //   660: aload 9
        //   662: ldc_w 365
        //   665: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   668: ifne +338 -> 1006
        //   671: aload 9
        //   673: ldc_w 371
        //   676: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   679: ifeq +87 -> 766
        //   682: goto +324 -> 1006
        //   685: iload 10
        //   687: ifne -108 -> 579
        //   690: aload 4
        //   692: aload 9
        //   694: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   697: pop
        //   698: aload 4
        //   700: bipush 95
        //   702: invokevirtual 374	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   705: pop
        //   706: aload 4
        //   708: aload 8
        //   710: getfield 164	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
        //   713: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   716: pop
        //   717: aload 4
        //   719: bipush 124
        //   721: invokevirtual 374	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   724: pop
        //   725: goto -146 -> 579
        //   728: astore_1
        //   729: aload_0
        //   730: getfield 16	ct/bl$1:a	Lct/bl;
        //   733: invokestatic 377	ct/bl:a	(Lct/bl;)Ljava/util/concurrent/CountDownLatch;
        //   736: invokevirtual 382	java/util/concurrent/CountDownLatch:countDown	()V
        //   739: return
        //   740: astore_1
        //   741: aconst_null
        //   742: astore_1
        //   743: goto -705 -> 38
        //   746: astore_2
        //   747: aload_1
        //   748: astore_2
        //   749: goto -693 -> 56
        //   752: ldc_w 384
        //   755: astore_1
        //   756: goto -480 -> 276
        //   759: astore_1
        //   760: iconst_0
        //   761: istore 10
        //   763: goto -244 -> 519
        //   766: iconst_0
        //   767: istore 10
        //   769: goto -84 -> 685
        //   772: aload 6
        //   774: aload 4
        //   776: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   779: invokevirtual 388	ct/bl:b	(Ljava/lang/String;)Ljava/lang/String;
        //   782: ldc_w 390
        //   785: invokevirtual 394	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   788: invokestatic 397	ct/bl:a	([B)[B
        //   791: astore_3
        //   792: aload_3
        //   793: iconst_2
        //   794: invokestatic 402	com/tencent/tencentmap/lbssdk/service/e:o	([BI)I
        //   797: pop
        //   798: aload 6
        //   800: getfield 405	ct/bl:h	Lcom/tencent/map/geolocation/internal/TencentHttpClient;
        //   803: ldc_w 407
        //   806: aload_3
        //   807: invokeinterface 413 3 0
        //   812: pop
        //   813: aload_1
        //   814: invokeinterface 417 1 0
        //   819: ldc_w 322
        //   822: iconst_1
        //   823: invokeinterface 423 3 0
        //   828: invokeinterface 426 1 0
        //   833: new 280	java/lang/StringBuilder
        //   836: dup
        //   837: ldc_w 428
        //   840: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   843: getstatic 433	android/os/Build:MODEL	Ljava/lang/String;
        //   846: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   849: ldc_w 435
        //   852: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   855: getstatic 440	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
        //   858: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   861: ldc_w 435
        //   864: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   867: aload 5
        //   869: invokevirtual 442	ct/bm:a	()Ljava/lang/String;
        //   872: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   875: ldc_w 444
        //   878: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   881: aload 5
        //   883: getfield 201	ct/bm:j	I
        //   886: invokevirtual 447	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   889: ldc_w 435
        //   892: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   895: aload 5
        //   897: getfield 204	ct/bm:k	I
        //   900: invokevirtual 447	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   903: ldc_w 449
        //   906: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   909: aload_2
        //   910: getfield 161	android/content/pm/PackageInfo:versionCode	I
        //   913: invokevirtual 447	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   916: ldc_w 435
        //   919: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   922: aload_2
        //   923: getfield 164	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
        //   926: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   929: ldc_w 451
        //   932: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   935: aload 5
        //   937: invokevirtual 453	ct/bm:d	()Ljava/lang/String;
        //   940: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   943: ldc_w 435
        //   946: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   949: aload 5
        //   951: invokevirtual 455	ct/bm:e	()Ljava/lang/String;
        //   954: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   957: pop
        //   958: goto -229 -> 729
        //   961: astore_3
        //   962: aload_3
        //   963: invokevirtual 458	java/lang/Error:printStackTrace	()V
        //   966: goto -153 -> 813
        //   969: astore_3
        //   970: aload_3
        //   971: invokevirtual 459	java/lang/Exception:printStackTrace	()V
        //   974: goto -161 -> 813
        //   977: aload_1
        //   978: invokeinterface 417 1 0
        //   983: ldc_w 322
        //   986: iconst_0
        //   987: invokeinterface 423 3 0
        //   992: invokeinterface 426 1 0
        //   997: goto -164 -> 833
        //   1000: astore_1
        //   1001: aload_3
        //   1002: astore_1
        //   1003: goto -912 -> 91
        //   1006: iconst_1
        //   1007: istore 10
        //   1009: goto -324 -> 685
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1012	0	this	1
        //   37	503	1	localObject1	Object
        //   728	1	1	localThrowable	Throwable
        //   740	1	1	localFileNotFoundException	java.io.FileNotFoundException
        //   742	14	1	str1	String
        //   759	219	1	localException1	Exception
        //   1000	1	1	localException2	Exception
        //   1002	1	1	localException3	Exception
        //   55	189	2	localObject2	Object
        //   746	1	2	localIOException	IOException
        //   748	175	2	str2	String
        //   4	803	3	localObject3	Object
        //   961	2	3	localError	Error
        //   969	33	3	localException4	Exception
        //   1	774	4	localObject4	Object
        //   16	934	5	localbm	bm
        //   9	790	6	localbl	bl
        //   559	31	7	localObject5	Object
        //   599	110	8	localPackageInfo	PackageInfo
        //   616	77	9	localObject6	Object
        //   239	769	10	i	int
        //   498	39	11	j	int
        //   489	22	12	l	long
        //   424	31	14	bool1	boolean
        //   433	33	15	bool2	boolean
        //   442	35	16	bool3	boolean
        // Exception table:
        //   from	to	target	type
        //   11	18	728	java/lang/Throwable
        //   18	38	728	java/lang/Throwable
        //   42	56	728	java/lang/Throwable
        //   63	69	728	java/lang/Throwable
        //   69	91	728	java/lang/Throwable
        //   91	95	728	java/lang/Throwable
        //   99	229	728	java/lang/Throwable
        //   229	267	728	java/lang/Throwable
        //   271	276	728	java/lang/Throwable
        //   276	288	728	java/lang/Throwable
        //   295	382	728	java/lang/Throwable
        //   382	491	728	java/lang/Throwable
        //   500	510	728	java/lang/Throwable
        //   519	532	728	java/lang/Throwable
        //   539	579	728	java/lang/Throwable
        //   579	618	728	java/lang/Throwable
        //   625	682	728	java/lang/Throwable
        //   690	725	728	java/lang/Throwable
        //   772	813	728	java/lang/Throwable
        //   813	833	728	java/lang/Throwable
        //   833	958	728	java/lang/Throwable
        //   962	966	728	java/lang/Throwable
        //   970	974	728	java/lang/Throwable
        //   977	997	728	java/lang/Throwable
        //   18	38	740	java/io/FileNotFoundException
        //   42	56	746	java/io/IOException
        //   500	510	759	java/lang/Exception
        //   772	813	961	java/lang/Error
        //   772	813	969	java/lang/Exception
        //   69	91	1000	java/lang/Exception
      }
    }).start();
  }
  
  public static bl a(Context paramContext)
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new bl(paramContext);
      }
      return k;
    }
    finally {}
  }
  
  /* Error */
  static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 193	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: aload_0
    //   5: arraylength
    //   6: invokespecial 194	java/io/ByteArrayOutputStream:<init>	(I)V
    //   9: astore_1
    //   10: new 196	java/util/zip/GZIPOutputStream
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 199	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: aload_0
    //   21: invokevirtual 203	java/util/zip/GZIPOutputStream:write	([B)V
    //   24: aload_2
    //   25: invokevirtual 206	java/util/zip/GZIPOutputStream:close	()V
    //   28: aload_1
    //   29: invokevirtual 210	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   32: astore_0
    //   33: aload_1
    //   34: invokevirtual 211	java/io/ByteArrayOutputStream:close	()V
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: aconst_null
    //   41: astore_0
    //   42: aload_1
    //   43: invokevirtual 214	java/lang/Exception:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_1
    //   52: invokevirtual 215	java/lang/Error:printStackTrace	()V
    //   55: aload_0
    //   56: areturn
    //   57: astore_1
    //   58: goto -7 -> 51
    //   61: astore_1
    //   62: goto -20 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramArrayOfByte	byte[]
    //   9	25	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   39	4	1	localException1	Exception
    //   48	4	1	localError1	Error
    //   57	1	1	localError2	Error
    //   61	1	1	localException2	Exception
    //   18	7	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	33	39	java/lang/Exception
    //   0	33	48	java/lang/Error
    //   33	37	57	java/lang/Error
    //   33	37	61	java/lang/Exception
  }
  
  private static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        if (paramContext.containsKey("TencentGeoLocationSDK")) {
          return paramContext.getString("TencentGeoLocationSDK");
        }
        if (paramContext.containsKey("TencentMapSDK"))
        {
          paramContext = paramContext.getString("TencentMapSDK");
          return paramContext;
        }
        return "";
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  private static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public final bm a(long paramLong)
  {
    if (paramLong > 0L) {}
    try
    {
      if (!this.j.await(paramLong, TimeUnit.MILLISECONDS))
      {
        return null;
        this.j.await();
      }
      return this.b;
    }
    catch (InterruptedException localInterruptedException) {}
    return null;
  }
  
  public final bp a(String paramString)
  {
    paramString = (bp)this.i.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return bo.a;
  }
  
  public final String a(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    paramString = this.h.postSync(paramString, paramArrayOfByte);
    paramArrayOfByte = b.b((byte[])paramString.first);
    if (paramArrayOfByte != null) {
      return new String(paramArrayOfByte, (String)paramString.second);
    }
    return "{}";
  }
  
  public final void a(Object paramObject)
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if (this.l == null) {
          this.l = new ArrayList();
        }
        Object localObject1 = this.l.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label186;
        }
        localObject2 = ((de)((Iterator)localObject1).next()).c;
        if (paramObject != localObject2) {
          continue;
        }
        m = 1;
        if (m != 0) {
          return;
        }
        localObject1 = paramObject.getClass().getDeclaredMethods();
        int n = localObject1.length;
        m = 0;
        if (m >= n) {
          continue;
        }
        localObject2 = localObject1[m];
        localObject3 = ((Method)localObject2).getName();
        if ((!((String)localObject3).startsWith("on")) || (!((String)localObject3).endsWith("Event"))) {
          break label177;
        }
        localObject3 = ((Method)localObject2).getParameterTypes();
        if (localObject3.length != 1) {
          throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
        }
      }
      finally {}
      Object localObject2 = new de(localObject3[0], (Method)localObject2, paramObject);
      this.l.add(localObject2);
      label177:
      m += 1;
      continue;
      label186:
      int m = 0;
    }
  }
  
  public final boolean a()
  {
    return this.e != null;
  }
  
  final PackageInfo b()
  {
    try
    {
      PackageInfo localPackageInfo = this.d.getPackageInfo(this.a.getPackageName(), 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return new PackageInfo();
  }
  
  final String b(String paramString)
  {
    bm localbm = this.b;
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", localbm.d());
    localHashMap.put("app_name", c(localbm.h));
    localHashMap.put("app_label", c(localbm.i));
    localHashMap.put("l", paramString);
    try
    {
      paramString = new JSONObject(localHashMap);
      localbm = this.b;
      localHashMap = new HashMap();
      localHashMap.put("imei", c(localbm.a()));
      localHashMap.put("imsi", c(localbm.b()));
      localHashMap.put("n", c(b.a(localbm.d)));
      localHashMap.put("qq", c(b.a(localbm.f)));
      localHashMap.put("mac", c(localbm.c().toLowerCase(Locale.ENGLISH)));
      paramString = paramString.put("attribute", new JSONObject(localHashMap)).toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public final void b(Object paramObject)
  {
    List localList;
    try
    {
      localList = this.l;
      if (localList == null) {
        break label119;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        de localde = (de)localIterator.next();
        Object localObject = localde.c;
        if ((localObject == null) || (localObject == paramObject)) {
          localArrayList.add(localde);
        }
      }
      paramObject = localArrayList.iterator();
    }
    finally {}
    while (((Iterator)paramObject).hasNext()) {
      localList.remove((de)((Iterator)paramObject).next());
    }
    label119:
  }
  
  /* Error */
  public final void c(@org.eclipse.jdt.annotation.Nullable Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 296	ct/bl:l	Ljava/util/List;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -9 -> 6
    //   18: aload_2
    //   19: invokeinterface 305 1 0
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface 311 1 0
    //   31: ifeq -25 -> 6
    //   34: aload_2
    //   35: invokeinterface 315 1 0
    //   40: checkcast 317	ct/de
    //   43: astore_3
    //   44: aload_1
    //   45: invokevirtual 323	java/lang/Object:getClass	()Ljava/lang/Class;
    //   48: aload_3
    //   49: getfield 437	ct/de:a	Ljava/lang/Class;
    //   52: invokevirtual 440	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   55: istore 4
    //   57: iload 4
    //   59: ifeq -34 -> 25
    //   62: aload_3
    //   63: getfield 443	ct/de:b	Ljava/lang/reflect/Method;
    //   66: aload_3
    //   67: getfield 319	ct/de:c	Ljava/lang/Object;
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_1
    //   77: aastore
    //   78: invokevirtual 447	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: goto -57 -> 25
    //   85: astore_3
    //   86: goto -61 -> 25
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	bl
    //   0	94	1	paramObject	Object
    //   13	22	2	localObject	Object
    //   43	24	3	localde	de
    //   85	1	3	localException	Exception
    //   55	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   62	82	85	java/lang/Exception
    //   9	14	89	finally
    //   18	25	89	finally
    //   25	57	89	finally
    //   62	82	89	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */