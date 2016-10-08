package com.tencent.mobileqq.antiphing;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.impl.client.DefaultHttpClient;

public class DownloadFileHelper
{
  public static ConnectivityManager a;
  public static DefaultHttpClient a;
  public Context a;
  
  public DownloadFileHelper(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(String paramString1, String paramString2)
  {
    String str3 = paramString2;
    if (!paramString2.endsWith("/")) {
      str3 = paramString2 + "/";
    }
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      try
      {
        localZipFile = new ZipFile(paramString1);
        localEnumeration = localZipFile.entries();
        paramString1 = null;
        str1 = paramString1;
        paramString2 = paramString1;
        str2 = paramString1;
      }
      catch (Exception paramString1)
      {
        ZipFile localZipFile;
        Enumeration localEnumeration;
        String str1;
        String str2;
        Object localObject;
        paramString2 = null;
        continue;
      }
      catch (IOException paramString1)
      {
        paramString2 = null;
        continue;
      }
      try
      {
        if (!localEnumeration.hasMoreElements()) {
          continue;
        }
        str1 = paramString1;
        str2 = paramString1;
        localObject = (ZipEntry)localEnumeration.nextElement();
        str1 = paramString1;
        str2 = paramString1;
        paramString2 = localZipFile.getInputStream((ZipEntry)localObject);
        paramString1 = paramString2;
        str1 = paramString2;
        str2 = paramString2;
        if (((ZipEntry)localObject).getName().contains("..")) {
          continue;
        }
        str1 = paramString2;
        str2 = paramString2;
        paramString1 = new File(str3 + ((ZipEntry)localObject).getName());
        str1 = paramString2;
        str2 = paramString2;
        if (!((ZipEntry)localObject).isDirectory()) {
          continue;
        }
        str1 = paramString2;
        str2 = paramString2;
        paramString1.mkdirs();
      }
      catch (IOException paramString1)
      {
        paramString2 = str1;
        paramString1.printStackTrace();
        if (paramString2 == null) {
          continue;
        }
        try
        {
          paramString2.close();
          return;
        }
        catch (Throwable paramString1)
        {
          paramString1.printStackTrace();
          return;
        }
        str1 = paramString2;
        str2 = paramString2;
        paramString1.close();
        continue;
      }
      catch (Exception paramString1)
      {
        paramString2 = str2;
        continue;
      }
      str1 = paramString2;
      str2 = paramString2;
      paramString2.close();
      paramString1 = null;
    }
    str1 = paramString2;
    str2 = paramString2;
    localObject = paramString1.getParentFile();
    str1 = paramString2;
    str2 = paramString2;
    if (!((File)localObject).exists())
    {
      str1 = paramString2;
      str2 = paramString2;
      ((File)localObject).mkdirs();
    }
    str1 = paramString2;
    str2 = paramString2;
    paramString1 = new FileOutputStream(paramString1);
    for (;;)
    {
      str1 = paramString2;
      str2 = paramString2;
      int i = paramString2.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      str1 = paramString2;
      str2 = paramString2;
      paramString1.write(arrayOfByte, 0, i);
    }
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {}
    while ((paramNetworkInfo.getType() != 0) && (50 != paramNetworkInfo.getType())) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!AppNetConnInfo.isNetSupport()) || (paramString2 == null)) {
      return false;
    }
    try
    {
      paramString1 = new URL(paramString1);
      return a(paramString1, paramString2, paramString3, paramBoolean);
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public boolean a(URL paramURL, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload 4
    //   2: ifne +66 -> 68
    //   5: new 39	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   12: aload_2
    //   13: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc -109
    //   18: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 6
    //   26: new 84	java/io/File
    //   29: dup
    //   30: aload 6
    //   32: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: new 84	java/io/File
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 8
    //   47: aload_2
    //   48: astore 7
    //   50: aload 8
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +8 -> 62
    //   57: aload 5
    //   59: ifnonnull +113 -> 172
    //   62: iconst_0
    //   63: istore 17
    //   65: iload 17
    //   67: ireturn
    //   68: aload_2
    //   69: invokevirtual 150	java/lang/String:trim	()Ljava/lang/String;
    //   72: astore 5
    //   74: aload 5
    //   76: astore_2
    //   77: aload 5
    //   79: ldc 31
    //   81: invokevirtual 37	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   84: ifne +37 -> 121
    //   87: aload 5
    //   89: astore_2
    //   90: aload 5
    //   92: ldc -104
    //   94: invokevirtual 37	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   97: ifne +24 -> 121
    //   100: new 39	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   107: aload 5
    //   109: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 31
    //   114: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore_2
    //   121: new 39	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   128: aload_2
    //   129: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc -102
    //   134: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 6
    //   142: new 84	java/io/File
    //   145: dup
    //   146: aload 6
    //   148: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore 5
    //   153: new 84	java/io/File
    //   156: dup
    //   157: aload_2
    //   158: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: astore 8
    //   163: aload_2
    //   164: astore 7
    //   166: aload 8
    //   168: astore_2
    //   169: goto -116 -> 53
    //   172: aload 5
    //   174: invokevirtual 103	java/io/File:exists	()Z
    //   177: ifeq +13 -> 190
    //   180: aload 5
    //   182: invokevirtual 157	java/io/File:delete	()Z
    //   185: ifne +5 -> 190
    //   188: iconst_0
    //   189: ireturn
    //   190: aload 5
    //   192: invokevirtual 100	java/io/File:getParentFile	()Ljava/io/File;
    //   195: astore 8
    //   197: aload 8
    //   199: ifnull +17 -> 216
    //   202: aload 8
    //   204: invokevirtual 103	java/io/File:exists	()Z
    //   207: ifne +9 -> 216
    //   210: aload 8
    //   212: invokevirtual 91	java/io/File:mkdirs	()Z
    //   215: pop
    //   216: aload_1
    //   217: invokevirtual 158	java/net/URL:toString	()Ljava/lang/String;
    //   220: astore 9
    //   222: new 160	org/apache/http/client/methods/HttpGet
    //   225: dup
    //   226: aload 9
    //   228: invokespecial 161	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   231: astore 8
    //   233: new 163	org/apache/http/params/BasicHttpParams
    //   236: dup
    //   237: invokespecial 164	org/apache/http/params/BasicHttpParams:<init>	()V
    //   240: astore 10
    //   242: invokestatic 169	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   245: astore 11
    //   247: invokestatic 172	android/net/Proxy:getDefaultPort	()I
    //   250: istore 13
    //   252: invokestatic 175	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isMobileConn	()Z
    //   255: istore 15
    //   257: invokestatic 179	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   260: astore 12
    //   262: aconst_null
    //   263: astore 9
    //   265: aload 12
    //   267: ifnull +10 -> 277
    //   270: aload 12
    //   272: invokevirtual 182	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   275: astore 9
    //   277: iload 15
    //   279: ifeq +49 -> 328
    //   282: aload 9
    //   284: ifnull +13 -> 297
    //   287: aload 9
    //   289: ldc -72
    //   291: invokevirtual 37	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   294: ifeq +34 -> 328
    //   297: aload 11
    //   299: ifnull +29 -> 328
    //   302: iload 13
    //   304: ifle +24 -> 328
    //   307: aload 10
    //   309: ldc -70
    //   311: new 188	org/apache/http/HttpHost
    //   314: dup
    //   315: aload 11
    //   317: iload 13
    //   319: invokespecial 191	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   322: invokeinterface 197 3 0
    //   327: pop
    //   328: iload 15
    //   330: ifeq +413 -> 743
    //   333: sipush 20000
    //   336: istore 14
    //   338: ldc -58
    //   340: istore 13
    //   342: aload 10
    //   344: ldc -56
    //   346: sipush 2048
    //   349: invokeinterface 204 3 0
    //   354: pop
    //   355: aload 10
    //   357: ldc -50
    //   359: iload 14
    //   361: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   364: invokeinterface 197 3 0
    //   369: pop
    //   370: aload 10
    //   372: ldc -42
    //   374: iload 13
    //   376: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: invokeinterface 197 3 0
    //   384: pop
    //   385: aload 8
    //   387: aload 10
    //   389: invokevirtual 218	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   392: iconst_0
    //   393: istore 13
    //   395: iconst_0
    //   396: istore 16
    //   398: iload 13
    //   400: iconst_1
    //   401: if_icmpne +20 -> 421
    //   404: aload 10
    //   406: ldc -70
    //   408: invokeinterface 221 2 0
    //   413: pop
    //   414: aload 8
    //   416: aload 10
    //   418: invokevirtual 218	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   421: iload 13
    //   423: iconst_1
    //   424: iadd
    //   425: istore 14
    //   427: new 163	org/apache/http/params/BasicHttpParams
    //   430: dup
    //   431: invokespecial 164	org/apache/http/params/BasicHttpParams:<init>	()V
    //   434: astore 9
    //   436: aload 9
    //   438: getstatic 227	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   441: invokestatic 233	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   444: aload 9
    //   446: ldc -21
    //   448: invokestatic 239	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   451: aload 9
    //   453: iconst_1
    //   454: invokestatic 243	org/apache/http/params/HttpProtocolParams:setUseExpectContinue	(Lorg/apache/http/params/HttpParams;Z)V
    //   457: new 245	org/apache/http/conn/scheme/SchemeRegistry
    //   460: dup
    //   461: invokespecial 246	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   464: astore 11
    //   466: aload 11
    //   468: new 248	org/apache/http/conn/scheme/Scheme
    //   471: dup
    //   472: ldc -6
    //   474: invokestatic 256	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   477: bipush 80
    //   479: invokespecial 259	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   482: invokevirtual 263	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   485: pop
    //   486: new 265	org/apache/http/impl/client/DefaultHttpClient
    //   489: dup
    //   490: new 267	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   493: dup
    //   494: aload 9
    //   496: aload 11
    //   498: invokespecial 270	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   501: aload 9
    //   503: invokespecial 273	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   506: putstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   509: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   512: new 277	org/apache/http/impl/client/DefaultHttpRequestRetryHandler
    //   515: dup
    //   516: invokespecial 278	org/apache/http/impl/client/DefaultHttpRequestRetryHandler:<init>	()V
    //   519: invokevirtual 282	org/apache/http/impl/client/DefaultHttpClient:setHttpRequestRetryHandler	(Lorg/apache/http/client/HttpRequestRetryHandler;)V
    //   522: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   525: new 188	org/apache/http/HttpHost
    //   528: dup
    //   529: aload_1
    //   530: invokevirtual 285	java/net/URL:getHost	()Ljava/lang/String;
    //   533: invokespecial 286	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   536: aload 8
    //   538: invokevirtual 290	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   541: astore 9
    //   543: iload 16
    //   545: istore 15
    //   547: sipush 200
    //   550: aload 9
    //   552: invokeinterface 296 1 0
    //   557: invokeinterface 301 1 0
    //   562: if_icmpne +109 -> 671
    //   565: aload 9
    //   567: invokeinterface 305 1 0
    //   572: astore 9
    //   574: aload 9
    //   576: invokeinterface 311 1 0
    //   581: pop2
    //   582: new 105	java/io/FileOutputStream
    //   585: dup
    //   586: aload 5
    //   588: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   591: astore 11
    //   593: aload 9
    //   595: aload 11
    //   597: invokeinterface 315 2 0
    //   602: aload 5
    //   604: invokevirtual 318	java/io/File:length	()J
    //   607: pop2
    //   608: aload 5
    //   610: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   613: invokevirtual 327	java/io/File:setLastModified	(J)Z
    //   616: pop
    //   617: aload 11
    //   619: invokevirtual 330	java/io/OutputStream:close	()V
    //   622: aload 6
    //   624: invokestatic 335	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   627: aload_3
    //   628: invokevirtual 338	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   631: ifeq +171 -> 802
    //   634: ldc_w 340
    //   637: iconst_1
    //   638: ldc_w 342
    //   641: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: iload 4
    //   646: iconst_1
    //   647: if_icmpne +122 -> 769
    //   650: ldc_w 340
    //   653: iconst_2
    //   654: ldc_w 350
    //   657: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: aload_0
    //   661: aload 6
    //   663: aload 7
    //   665: invokespecial 352	com/tencent/mobileqq/antiphing/DownloadFileHelper:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: iconst_1
    //   669: istore 15
    //   671: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   674: ifnull +18 -> 692
    //   677: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   680: invokevirtual 356	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   683: invokeinterface 361 1 0
    //   688: aconst_null
    //   689: putstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   692: iload 15
    //   694: istore 17
    //   696: iload 15
    //   698: ifne -633 -> 65
    //   701: iload 15
    //   703: istore 16
    //   705: iload 14
    //   707: istore 13
    //   709: iload 14
    //   711: iconst_2
    //   712: if_icmplt -314 -> 398
    //   715: iload 15
    //   717: ireturn
    //   718: astore_1
    //   719: iconst_0
    //   720: ireturn
    //   721: astore 8
    //   723: new 160	org/apache/http/client/methods/HttpGet
    //   726: dup
    //   727: aload 9
    //   729: invokestatic 364	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   732: invokespecial 161	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   735: astore 8
    //   737: goto -504 -> 233
    //   740: astore_1
    //   741: iconst_0
    //   742: ireturn
    //   743: sipush 10000
    //   746: istore 14
    //   748: sipush 30000
    //   751: istore 13
    //   753: aload 10
    //   755: ldc -56
    //   757: sipush 4096
    //   760: invokeinterface 204 3 0
    //   765: pop
    //   766: goto -411 -> 355
    //   769: ldc_w 340
    //   772: iconst_2
    //   773: ldc_w 366
    //   776: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   779: aload_2
    //   780: invokevirtual 103	java/io/File:exists	()Z
    //   783: ifeq +8 -> 791
    //   786: aload_2
    //   787: invokevirtual 157	java/io/File:delete	()Z
    //   790: pop
    //   791: aload 5
    //   793: aload_2
    //   794: invokevirtual 370	java/io/File:renameTo	(Ljava/io/File;)Z
    //   797: istore 15
    //   799: goto -128 -> 671
    //   802: ldc_w 340
    //   805: iconst_1
    //   806: ldc_w 372
    //   809: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: iload 16
    //   814: istore 17
    //   816: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   819: ifnull -754 -> 65
    //   822: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   825: invokevirtual 356	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   828: invokeinterface 361 1 0
    //   833: aconst_null
    //   834: putstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   837: iload 16
    //   839: ireturn
    //   840: astore_1
    //   841: aload_1
    //   842: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   845: iload 16
    //   847: istore 17
    //   849: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   852: ifnull -787 -> 65
    //   855: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   858: invokevirtual 356	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   861: invokeinterface 361 1 0
    //   866: aconst_null
    //   867: putstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   870: iload 16
    //   872: ireturn
    //   873: astore_1
    //   874: aload_1
    //   875: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   878: iload 16
    //   880: istore 17
    //   882: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   885: ifnull -820 -> 65
    //   888: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   891: invokevirtual 356	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   894: invokeinterface 361 1 0
    //   899: aconst_null
    //   900: putstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   903: iload 16
    //   905: ireturn
    //   906: astore_1
    //   907: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   910: ifnull +18 -> 928
    //   913: getstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   916: invokevirtual 356	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   919: invokeinterface 361 1 0
    //   924: aconst_null
    //   925: putstatic 275	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   928: aload_1
    //   929: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	930	0	this	DownloadFileHelper
    //   0	930	1	paramURL	URL
    //   0	930	2	paramString1	String
    //   0	930	3	paramString2	String
    //   0	930	4	paramBoolean	boolean
    //   35	757	5	localObject1	Object
    //   24	638	6	str1	String
    //   48	616	7	str2	String
    //   45	492	8	localObject2	Object
    //   721	1	8	localIllegalArgumentException	IllegalArgumentException
    //   735	1	8	localHttpGet	org.apache.http.client.methods.HttpGet
    //   220	508	9	localObject3	Object
    //   240	514	10	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   245	373	11	localObject4	Object
    //   260	11	12	localNetworkInfo	NetworkInfo
    //   250	502	13	i	int
    //   336	411	14	j	int
    //   255	543	15	bool1	boolean
    //   396	508	16	bool2	boolean
    //   63	818	17	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   190	197	718	java/lang/Exception
    //   202	216	718	java/lang/Exception
    //   222	233	721	java/lang/IllegalArgumentException
    //   723	737	740	java/lang/Exception
    //   582	644	840	java/lang/Exception
    //   650	668	840	java/lang/Exception
    //   769	791	840	java/lang/Exception
    //   791	799	840	java/lang/Exception
    //   802	812	840	java/lang/Exception
    //   427	543	873	java/lang/Exception
    //   547	582	873	java/lang/Exception
    //   841	845	873	java/lang/Exception
    //   427	543	906	finally
    //   547	582	906	finally
    //   582	644	906	finally
    //   650	668	906	finally
    //   769	791	906	finally
    //   791	799	906	finally
    //   802	812	906	finally
    //   841	845	906	finally
    //   874	878	906	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\antiphing\DownloadFileHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */