package com.tencent.mobileqq.activity.qwallet.preload;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import ouv;
import ouw;
import oux;
import ouy;
import ouz;
import ova;

public class PreloadManager
  implements INetInfoHandler, Manager
{
  public static final String a = "wallet";
  public static final String b = "wallet_offline";
  public static final String c = "/preloaduni/";
  public static final String d = "preload.config";
  private static final String e = PreloadManager.class.getName();
  public PreloadConfig a;
  public DownloadListener a;
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  public AppRuntime a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PreloadManager(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new ouw(this);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig = new PreloadConfig();
    }
    AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.equalsIgnoreCase("WiFi")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("4G")) {
        return 4;
      }
      if (paramString.equalsIgnoreCase("3G")) {
        return 3;
      }
    } while (!paramString.equalsIgnoreCase("2G"));
    return 2;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    String str = e(paramAppRuntime);
    paramAppRuntime = d(paramAppRuntime);
    if (TextUtils.isEmpty(str)) {
      return paramAppRuntime;
    }
    return str + "preload.config";
  }
  
  private void a(PreloadModule paramPreloadModule)
  {
    paramPreloadModule = paramPreloadModule.preloadResources.iterator();
    while (paramPreloadModule.hasNext()) {
      b(((PreloadResource)paramPreloadModule.next()).url);
    }
  }
  
  private boolean a(PreloadModule paramPreloadModule, boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet(16);
    if ((paramBoolean) || (!paramPreloadModule.isForbidAutoDownload))
    {
      String str2 = paramPreloadModule.baseUrl;
      long l4 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject = new ArrayList();
      ((List)localObject).addAll(paramPreloadModule.preloadResources);
      Iterator localIterator = ((List)localObject).iterator();
      paramBoolean = false;
      while (localIterator.hasNext())
      {
        PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
        long l1 = -1L;
        long l2 = -1L;
        label136:
        label153:
        String str3;
        try
        {
          l3 = this.jdField_a_of_type_JavaTextSimpleDateFormat.parse(localPreloadResource.downloadTime).getTime();
          l1 = l3;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            long l3;
            localException1.printStackTrace();
          }
        }
        try
        {
          l3 = this.jdField_a_of_type_JavaTextSimpleDateFormat.parse(localPreloadResource.invalidTime).getTime();
          l2 = l3;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          break label136;
          str1 = str2 + "/" + localPreloadResource.urlPath;
          break label153;
          if (l1 == -1L) {
            break label265;
          }
        }
        if (!TextUtils.isEmpty(localPreloadResource.url))
        {
          localObject = localPreloadResource.url;
          str3 = b((String)localObject);
          if ((l2 == -1L) || (l2 >= l4)) {
            break label248;
          }
          FileUtils.d(str3);
          paramPreloadModule.preloadResources.remove(localPreloadResource);
          paramBoolean = true;
        }
        String str1;
        label248:
        label265:
        if ((l1 >= l4) || (!a(localPreloadResource.netType)) || ((new File(str3).exists()) && (!localPreloadResource.needReplace))) {
          break label373;
        }
        localHashSet.add(str1);
        if (!localPreloadResource.needReplace) {
          break label373;
        }
        int i = paramPreloadModule.preloadResources.indexOf(localPreloadResource);
        if (i == -1) {
          break label373;
        }
        ((PreloadResource)paramPreloadModule.preloadResources.get(i)).needReplace = false;
        paramBoolean = true;
      }
      label373:
      for (;;)
      {
        break;
        if (!localHashSet.isEmpty()) {
          a(localHashSet);
        }
        return paramBoolean;
      }
    }
    return false;
  }
  
  private void b(String paramString)
  {
    Object localObject = null;
    try
    {
      Uri localUri = Uri.parse(paramString);
      paramString = (String)localObject;
      if (localUri != null)
      {
        paramString = (String)localObject;
        if (localUri.isHierarchical()) {
          paramString = localUri.getQueryParameter("_bid");
        }
      }
      if (!b(paramString)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    HtmlOffline.b(paramString, this.jdField_a_of_type_MqqAppAppRuntime, true, new ova(this));
  }
  
  private boolean b(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private static String d(AppRuntime paramAppRuntime)
  {
    String str = null;
    if (FileUtils.a()) {
      str = Environment.getExternalStorageDirectory().getPath() + "/tencent/QWallet/" + paramAppRuntime.getAccount() + "/preloaduni/";
    }
    return str;
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: monitorenter
    //   7: new 225	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: getfield 58	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   15: invokestatic 292	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   18: invokespecial 226	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 229	java/io/File:exists	()Z
    //   26: istore 8
    //   28: iload 8
    //   30: ifne +67 -> 97
    //   33: iconst_0
    //   34: ifeq +11 -> 45
    //   37: new 294	java/lang/NullPointerException
    //   40: dup
    //   41: invokespecial 295	java/lang/NullPointerException:<init>	()V
    //   44: athrow
    //   45: iconst_0
    //   46: ifeq +11 -> 57
    //   49: new 294	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 295	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: iconst_0
    //   58: ifeq +11 -> 69
    //   61: new 294	java/lang/NullPointerException
    //   64: dup
    //   65: invokespecial 295	java/lang/NullPointerException:<init>	()V
    //   68: athrow
    //   69: iconst_0
    //   70: ifeq +11 -> 81
    //   73: new 294	java/lang/NullPointerException
    //   76: dup
    //   77: invokespecial 295	java/lang/NullPointerException:<init>	()V
    //   80: athrow
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   89: goto -8 -> 81
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: new 298	java/io/FileInputStream
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 301	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: astore 5
    //   107: new 303	java/io/ByteArrayOutputStream
    //   110: dup
    //   111: invokespecial 304	java/io/ByteArrayOutputStream:<init>	()V
    //   114: astore_2
    //   115: sipush 1024
    //   118: newarray <illegal type>
    //   120: astore_1
    //   121: aload 5
    //   123: aload_1
    //   124: invokevirtual 308	java/io/FileInputStream:read	([B)I
    //   127: istore 7
    //   129: iload 7
    //   131: iconst_m1
    //   132: if_icmpeq +79 -> 211
    //   135: aload_2
    //   136: aload_1
    //   137: iconst_0
    //   138: iload 7
    //   140: invokevirtual 312	java/io/ByteArrayOutputStream:write	([BII)V
    //   143: goto -22 -> 121
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_2
    //   150: astore 4
    //   152: aconst_null
    //   153: astore 6
    //   155: aload_1
    //   156: astore_2
    //   157: aload 6
    //   159: astore_1
    //   160: aload_3
    //   161: invokevirtual 213	java/lang/Exception:printStackTrace	()V
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 317	java/io/ObjectInputStream:close	()V
    //   172: aload_1
    //   173: ifnull +7 -> 180
    //   176: aload_1
    //   177: invokevirtual 320	java/io/ByteArrayInputStream:close	()V
    //   180: aload 4
    //   182: ifnull +8 -> 190
    //   185: aload 4
    //   187: invokevirtual 321	java/io/ByteArrayOutputStream:close	()V
    //   190: aload 5
    //   192: ifnull -111 -> 81
    //   195: aload 5
    //   197: invokevirtual 322	java/io/FileInputStream:close	()V
    //   200: goto -119 -> 81
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   208: goto -127 -> 81
    //   211: new 319	java/io/ByteArrayInputStream
    //   214: dup
    //   215: aload_2
    //   216: invokevirtual 326	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   219: invokespecial 329	java/io/ByteArrayInputStream:<init>	([B)V
    //   222: astore_1
    //   223: new 314	java/io/ObjectInputStream
    //   226: dup
    //   227: aload_1
    //   228: invokespecial 332	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   231: astore 6
    //   233: aload_0
    //   234: aload 6
    //   236: invokevirtual 335	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   239: checkcast 73	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig
    //   242: putfield 71	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   245: aload 6
    //   247: ifnull +8 -> 255
    //   250: aload 6
    //   252: invokevirtual 317	java/io/ObjectInputStream:close	()V
    //   255: aload_1
    //   256: ifnull +7 -> 263
    //   259: aload_1
    //   260: invokevirtual 320	java/io/ByteArrayInputStream:close	()V
    //   263: aload_2
    //   264: ifnull +7 -> 271
    //   267: aload_2
    //   268: invokevirtual 321	java/io/ByteArrayOutputStream:close	()V
    //   271: aload 5
    //   273: ifnull -192 -> 81
    //   276: aload 5
    //   278: invokevirtual 322	java/io/FileInputStream:close	()V
    //   281: goto -200 -> 81
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   289: goto -208 -> 81
    //   292: astore_1
    //   293: aconst_null
    //   294: astore 5
    //   296: aconst_null
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_2
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 317	java/io/ObjectInputStream:close	()V
    //   309: aload_3
    //   310: ifnull +7 -> 317
    //   313: aload_3
    //   314: invokevirtual 320	java/io/ByteArrayInputStream:close	()V
    //   317: aload 4
    //   319: ifnull +8 -> 327
    //   322: aload 4
    //   324: invokevirtual 321	java/io/ByteArrayOutputStream:close	()V
    //   327: aload 5
    //   329: ifnull +8 -> 337
    //   332: aload 5
    //   334: invokevirtual 322	java/io/FileInputStream:close	()V
    //   337: aload_1
    //   338: athrow
    //   339: astore_2
    //   340: aload_2
    //   341: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   344: goto -7 -> 337
    //   347: astore_1
    //   348: aconst_null
    //   349: astore 4
    //   351: aconst_null
    //   352: astore_2
    //   353: goto -52 -> 301
    //   356: astore_1
    //   357: aconst_null
    //   358: astore 6
    //   360: aload_2
    //   361: astore 4
    //   363: aload 6
    //   365: astore_2
    //   366: goto -65 -> 301
    //   369: astore 4
    //   371: aconst_null
    //   372: astore 6
    //   374: aload_1
    //   375: astore_3
    //   376: aload 4
    //   378: astore_1
    //   379: aload_2
    //   380: astore 4
    //   382: aload 6
    //   384: astore_2
    //   385: goto -84 -> 301
    //   388: astore 4
    //   390: aload_1
    //   391: astore_3
    //   392: aload 4
    //   394: astore_1
    //   395: aload_2
    //   396: astore 4
    //   398: aload 6
    //   400: astore_2
    //   401: goto -100 -> 301
    //   404: astore 6
    //   406: aload_1
    //   407: astore_3
    //   408: aload 6
    //   410: astore_1
    //   411: goto -110 -> 301
    //   414: astore_3
    //   415: aconst_null
    //   416: astore 5
    //   418: aconst_null
    //   419: astore_1
    //   420: aconst_null
    //   421: astore_2
    //   422: goto -262 -> 160
    //   425: astore_3
    //   426: aconst_null
    //   427: astore_1
    //   428: aconst_null
    //   429: astore_2
    //   430: goto -270 -> 160
    //   433: astore_3
    //   434: aconst_null
    //   435: astore 6
    //   437: aload_2
    //   438: astore 4
    //   440: aload 6
    //   442: astore_2
    //   443: goto -283 -> 160
    //   446: astore_3
    //   447: aload_2
    //   448: astore 4
    //   450: aload 6
    //   452: astore_2
    //   453: goto -293 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	PreloadManager
    //   21	2	1	localFile1	File
    //   84	2	1	localIOException1	java.io.IOException
    //   92	10	1	localFile2	File
    //   120	57	1	localObject1	Object
    //   203	2	1	localIOException2	java.io.IOException
    //   222	38	1	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   284	2	1	localIOException3	java.io.IOException
    //   292	46	1	localObject2	Object
    //   347	1	1	localObject3	Object
    //   356	19	1	localObject4	Object
    //   378	50	1	localObject5	Object
    //   114	192	2	localObject6	Object
    //   339	2	2	localIOException4	java.io.IOException
    //   352	101	2	localObject7	Object
    //   1	1	3	localObject8	Object
    //   146	168	3	localException1	Exception
    //   375	33	3	localObject9	Object
    //   414	1	3	localException2	Exception
    //   425	1	3	localException3	Exception
    //   433	1	3	localException4	Exception
    //   446	1	3	localException5	Exception
    //   3	359	4	localObject10	Object
    //   369	8	4	localObject11	Object
    //   380	1	4	localObject12	Object
    //   388	5	4	localObject13	Object
    //   396	53	4	localObject14	Object
    //   105	312	5	localFileInputStream	java.io.FileInputStream
    //   153	246	6	localObjectInputStream	java.io.ObjectInputStream
    //   404	5	6	localObject15	Object
    //   435	16	6	localObject16	Object
    //   127	12	7	i	int
    //   26	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   37	45	84	java/io/IOException
    //   49	57	84	java/io/IOException
    //   61	69	84	java/io/IOException
    //   73	81	84	java/io/IOException
    //   37	45	92	finally
    //   49	57	92	finally
    //   61	69	92	finally
    //   73	81	92	finally
    //   85	89	92	finally
    //   168	172	92	finally
    //   176	180	92	finally
    //   185	190	92	finally
    //   195	200	92	finally
    //   204	208	92	finally
    //   250	255	92	finally
    //   259	263	92	finally
    //   267	271	92	finally
    //   276	281	92	finally
    //   285	289	92	finally
    //   305	309	92	finally
    //   313	317	92	finally
    //   322	327	92	finally
    //   332	337	92	finally
    //   337	339	92	finally
    //   340	344	92	finally
    //   115	121	146	java/lang/Exception
    //   121	129	146	java/lang/Exception
    //   135	143	146	java/lang/Exception
    //   211	223	146	java/lang/Exception
    //   168	172	203	java/io/IOException
    //   176	180	203	java/io/IOException
    //   185	190	203	java/io/IOException
    //   195	200	203	java/io/IOException
    //   250	255	284	java/io/IOException
    //   259	263	284	java/io/IOException
    //   267	271	284	java/io/IOException
    //   276	281	284	java/io/IOException
    //   7	28	292	finally
    //   97	107	292	finally
    //   305	309	339	java/io/IOException
    //   313	317	339	java/io/IOException
    //   322	327	339	java/io/IOException
    //   332	337	339	java/io/IOException
    //   107	115	347	finally
    //   115	121	356	finally
    //   121	129	356	finally
    //   135	143	356	finally
    //   211	223	356	finally
    //   223	233	369	finally
    //   233	245	388	finally
    //   160	164	404	finally
    //   7	28	414	java/lang/Exception
    //   97	107	414	java/lang/Exception
    //   107	115	425	java/lang/Exception
    //   223	233	433	java/lang/Exception
    //   233	245	446	java/lang/Exception
  }
  
  private static String e(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramAppRuntime.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/QWallet/").append(paramAppRuntime.getAccount()).append("/preloaduni/");
    return localStringBuilder.toString();
  }
  
  public PreloadModule a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModuleByName(paramString);
  }
  
  public String a(String paramString)
  {
    paramString = b(paramString);
    if (new File(paramString).exists()) {
      return paramString;
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.a().post(new ouv(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.parsePreloadConfig(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModuleByName(paramString), paramBoolean);
  }
  
  public void a(Set paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(this.jdField_a_of_type_MqqAppAppRuntime);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1);
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    ThreadManager.a(new oux(this, paramSet, localArrayList, localHashMap), 8, new ouy(this, localArrayList, localHashMap), true);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = NetworkUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication());
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label58;
      }
      if (a(paramString[i]) == j) {
        break;
      }
      i += 1;
    }
    label58:
    return false;
  }
  
  public String b(String paramString)
  {
    String str2 = MD5.toMD5(paramString);
    paramString = e(this.jdField_a_of_type_MqqAppAppRuntime);
    String str1 = d(this.jdField_a_of_type_MqqAppAppRuntime);
    StringBuilder localStringBuilder = new StringBuilder();
    if (TextUtils.isEmpty(str1)) {}
    for (;;)
    {
      return paramString + str2;
      paramString = str1;
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.preloadModules.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      PreloadModule localPreloadModule = (PreloadModule)localIterator.next();
      if (localPreloadModule.name.equals("wallet_offline"))
      {
        a(localPreloadModule);
      }
      else
      {
        if (!a(localPreloadModule, false)) {
          break label77;
        }
        i = 1;
      }
    }
    label77:
    for (;;)
    {
      break;
      if (i != 0) {
        c();
      }
      return;
    }
  }
  
  public void c()
  {
    try
    {
      ThreadManager.a().post(new ouz(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    b();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    b();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    b();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    b();
  }
  
  public void onNetWifi2None() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\preload\PreloadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */