package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import oicq.wlogin_sdk.tools.MD5;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DynamicSplashManager
{
  private static final String a = "DynamicSplashManager";
  
  public DynamicSplashManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() begin");
    }
    for (;;)
    {
      try
      {
        String str1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/" + "dynamicSplash";
        Object localObject1 = new File(str1);
        if (!((File)localObject1).exists())
        {
          ((File)localObject1).mkdirs();
          localObject3 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          if (((Document)localObject3).getElementsByTagName("splash").getLength() < 1) {
            return false;
          }
        }
        else
        {
          if ((localObject1 == null) || (!((File)localObject1).isDirectory())) {
            continue;
          }
          localObject1 = ((File)localObject1).listFiles();
          if (localObject1 == null) {
            continue;
          }
          j = localObject1.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject2 = localObject1[i];
          if ((localObject2 == null) || (!((File)localObject2).exists())) {
            break label1059;
          }
          ((File)localObject2).delete();
          break label1059;
        }
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        paramString = ((Document)localObject3).getElementsByTagName("img").item(0).getFirstChild().getNodeValue();
        String str3 = ((Document)localObject3).getElementsByTagName("begin").item(0).getFirstChild().getNodeValue();
        String str2 = ((Document)localObject3).getElementsByTagName("end").item(0).getFirstChild().getNodeValue();
        localObject1 = ((Document)localObject3).getElementsByTagName("md5").item(0).getFirstChild().getNodeValue();
        int j = Integer.valueOf(((Document)localObject3).getElementsByTagName("download_net").item(0).getFirstChild().getNodeValue()).intValue();
        int k = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_times").item(0).getFirstChild().getNodeValue()).intValue();
        int m = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_interval").item(0).getFirstChild().getNodeValue()).intValue();
        int n = Integer.valueOf(((Document)localObject3).getElementsByTagName("total_show_times").item(0).getFirstChild().getNodeValue()).intValue();
        Object localObject3 = ((SimpleDateFormat)localObject2).parse(str3).getTime() + "|" + ((SimpleDateFormat)localObject2).parse(str2).getTime();
        int i1 = NetworkUtil.a(BaseApplication.getContext());
        i = 0;
        if (i1 == 2)
        {
          if (!QLog.isColorLevel()) {
            break label1068;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G2");
          break label1068;
          if (QLog.isColorLevel()) {
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkValue == " + i);
          }
          if (i < j)
          {
            if (!QLog.isColorLevel()) {
              break label1074;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() user network NOT allow download, return");
            break label1074;
          }
        }
        else
        {
          if (i1 == 3)
          {
            if (!QLog.isColorLevel()) {
              break label1076;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G3");
            break label1076;
          }
          if (i1 == 4)
          {
            if (!QLog.isColorLevel()) {
              break label1083;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G4");
            break label1083;
          }
          if (i1 != 1) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            break label1090;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.WIFI");
          break label1090;
        }
        SharedPreUtils.a(BaseApplicationImpl.getContext(), paramInt, k, m, n, (String)localObject1, (String)localObject3, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() SUCCESS record to SP");
        }
        if (((SimpleDateFormat)localObject2).parse(str2).getTime() < System.currentTimeMillis())
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() the config is out of date, return");
          break;
        }
        localObject2 = new File(str1 + "/" + (String)localObject1 + ".zip");
        if (!a(paramQQAppInterface, paramString, (File)localObject2, (String)localObject1))
        {
          if (!QLog.isColorLevel()) {
            break label1099;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is filed, return");
          break label1099;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is SUCCESS");
        }
        paramQQAppInterface = str1 + "/" + (String)localObject1;
        paramString = new File(paramQQAppInterface);
        if (!FileUtils.c((File)localObject2, paramString))
        {
          if ((paramString != null) && (paramString.exists())) {
            paramString.delete();
          }
          if (!QLog.isColorLevel()) {
            break label1101;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is filed, return");
          break label1101;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is SUCCESS");
        }
        if (!a(paramQQAppInterface + "/md5.txt", paramQQAppInterface))
        {
          if (!QLog.isColorLevel()) {
            break label1103;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is filed, return");
          break label1103;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is SUCCESS");
        }
        if ((paramString != null) && (paramString.isDirectory()))
        {
          long l = paramString.lastModified();
          paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
          paramQQAppInterface.putLong("dynamic_splash_config_folder_modify_time", l);
          paramQQAppInterface.commit();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() the folder path of splash is" + str1);
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() finish");
        }
        return true;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() ERROR = " + paramQQAppInterface.getMessage());
        }
        return false;
      }
      label1059:
      i += 1;
      continue;
      label1068:
      int i = 0;
      continue;
      label1074:
      return false;
      label1076:
      i = 10;
      continue;
      label1083:
      i = 20;
      continue;
      label1090:
      i = 100;
    }
    return true;
    label1099:
    return false;
    label1101:
    return false;
    label1103:
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString1, File paramFile, String paramString2)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      String str = MD5.getFileMD5(paramFile);
      if ((str == null) || (!str.equalsIgnoreCase(paramString2))) {}
    }
    do
    {
      return true;
      paramFile.delete();
      boolean bool = HttpDownloadUtil.a(paramQQAppInterface, paramString1, paramFile);
      if ((paramFile == null) || (!paramFile.exists())) {
        break;
      }
      if (bool != true) {
        break label82;
      }
      paramQQAppInterface = MD5.getFileMD5(paramFile);
    } while ((paramQQAppInterface != null) && (paramQQAppInterface.equalsIgnoreCase(paramString2)));
    return false;
    label82:
    paramFile.delete();
    return false;
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 13
    //   3: iconst_0
    //   4: istore 10
    //   6: iload 10
    //   8: istore 11
    //   10: aload_0
    //   11: invokestatic 307	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +14 -> 28
    //   17: aload_1
    //   18: invokestatic 307	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +10 -> 31
    //   24: iload 10
    //   26: istore 11
    //   28: iload 11
    //   30: ireturn
    //   31: new 51	java/io/File
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: new 51	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 72	java/io/File:exists	()Z
    //   53: ifeq +10 -> 63
    //   56: aload_3
    //   57: invokevirtual 121	java/io/File:isDirectory	()Z
    //   60: ifne +37 -> 97
    //   63: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +12 -> 78
    //   69: ldc 8
    //   71: iconst_2
    //   72: ldc_w 309
    //   75: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload 10
    //   80: istore 11
    //   82: iconst_0
    //   83: ifeq -55 -> 28
    //   86: new 311	java/lang/NullPointerException
    //   89: dup
    //   90: invokespecial 312	java/lang/NullPointerException:<init>	()V
    //   93: athrow
    //   94: astore_0
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_3
    //   98: invokevirtual 125	java/io/File:listFiles	()[Ljava/io/File;
    //   101: astore_3
    //   102: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +89 -> 194
    //   108: aload_3
    //   109: arraylength
    //   110: istore 6
    //   112: iconst_0
    //   113: istore 5
    //   115: iload 5
    //   117: iload 6
    //   119: if_icmpge +48 -> 167
    //   122: aload_3
    //   123: iload 5
    //   125: aaload
    //   126: astore 4
    //   128: ldc 8
    //   130: iconst_2
    //   131: new 36	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 314
    //   141: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 4
    //   146: invokevirtual 317	java/io/File:getName	()Ljava/lang/String;
    //   149: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: iload 5
    //   160: iconst_1
    //   161: iadd
    //   162: istore 5
    //   164: goto -49 -> 115
    //   167: ldc 8
    //   169: iconst_2
    //   170: new 36	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 319
    //   180: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_3
    //   184: arraylength
    //   185: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_3
    //   195: arraylength
    //   196: ifgt +37 -> 233
    //   199: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +12 -> 214
    //   205: ldc 8
    //   207: iconst_2
    //   208: ldc_w 321
    //   211: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: iload 10
    //   216: istore 11
    //   218: iconst_0
    //   219: ifeq -191 -> 28
    //   222: new 311	java/lang/NullPointerException
    //   225: dup
    //   226: invokespecial 312	java/lang/NullPointerException:<init>	()V
    //   229: athrow
    //   230: astore_0
    //   231: iconst_0
    //   232: ireturn
    //   233: aload_2
    //   234: invokevirtual 72	java/io/File:exists	()Z
    //   237: ifne +37 -> 274
    //   240: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +12 -> 255
    //   246: ldc 8
    //   248: iconst_2
    //   249: ldc_w 323
    //   252: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: iload 10
    //   257: istore 11
    //   259: iconst_0
    //   260: ifeq -232 -> 28
    //   263: new 311	java/lang/NullPointerException
    //   266: dup
    //   267: invokespecial 312	java/lang/NullPointerException:<init>	()V
    //   270: athrow
    //   271: astore_0
    //   272: iconst_0
    //   273: ireturn
    //   274: aload_3
    //   275: arraylength
    //   276: iconst_1
    //   277: isub
    //   278: istore 7
    //   280: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +30 -> 313
    //   286: ldc 8
    //   288: iconst_2
    //   289: new 36	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   296: ldc_w 325
    //   299: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: iload 7
    //   304: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: new 327	java/io/BufferedReader
    //   316: dup
    //   317: new 329	java/io/InputStreamReader
    //   320: dup
    //   321: new 331	java/io/FileInputStream
    //   324: dup
    //   325: aload_0
    //   326: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   329: invokespecial 335	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   332: invokespecial 338	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   335: astore_2
    //   336: iconst_0
    //   337: istore 5
    //   339: aload_2
    //   340: astore_0
    //   341: aload_2
    //   342: invokevirtual 341	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   345: astore_3
    //   346: aload_3
    //   347: ifnull +567 -> 914
    //   350: aload_2
    //   351: astore_0
    //   352: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +31 -> 386
    //   358: aload_2
    //   359: astore_0
    //   360: ldc 8
    //   362: iconst_2
    //   363: new 36	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 343
    //   373: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_3
    //   377: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload_2
    //   387: astore_0
    //   388: aload_3
    //   389: invokevirtual 346	java/lang/String:length	()I
    //   392: istore 6
    //   394: iload 6
    //   396: iconst_5
    //   397: if_icmpge +59 -> 456
    //   400: iconst_1
    //   401: istore 10
    //   403: iload 5
    //   405: iload 7
    //   407: if_icmpeq +500 -> 907
    //   410: iload 13
    //   412: istore 12
    //   414: aload_2
    //   415: astore_0
    //   416: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +18 -> 437
    //   422: aload_2
    //   423: astore_0
    //   424: ldc 8
    //   426: iconst_2
    //   427: ldc_w 348
    //   430: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: iload 13
    //   435: istore 12
    //   437: iload 12
    //   439: istore 11
    //   441: aload_2
    //   442: ifnull -414 -> 28
    //   445: aload_2
    //   446: invokevirtual 351	java/io/BufferedReader:close	()V
    //   449: iload 12
    //   451: ireturn
    //   452: astore_0
    //   453: iload 12
    //   455: ireturn
    //   456: aload_2
    //   457: astore_0
    //   458: aload_3
    //   459: ldc_w 353
    //   462: invokevirtual 357	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   465: astore_3
    //   466: aload_2
    //   467: astore_0
    //   468: aload_3
    //   469: arraylength
    //   470: iconst_2
    //   471: if_icmpeq +9 -> 480
    //   474: iconst_0
    //   475: istore 10
    //   477: goto -74 -> 403
    //   480: aload_2
    //   481: astore_0
    //   482: new 36	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   489: aload_1
    //   490: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc 61
    //   495: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_3
    //   499: iconst_0
    //   500: aaload
    //   501: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: astore 4
    //   509: aload_2
    //   510: astore_0
    //   511: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq +32 -> 546
    //   517: aload_2
    //   518: astore_0
    //   519: ldc 8
    //   521: iconst_2
    //   522: new 36	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   529: ldc_w 359
    //   532: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 4
    //   537: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: aload_2
    //   547: astore_0
    //   548: new 51	java/io/File
    //   551: dup
    //   552: aload 4
    //   554: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   557: astore 4
    //   559: aload_2
    //   560: astore_0
    //   561: aload 4
    //   563: invokevirtual 72	java/io/File:exists	()Z
    //   566: ifne +25 -> 591
    //   569: aload_2
    //   570: astore_0
    //   571: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +346 -> 920
    //   577: aload_2
    //   578: astore_0
    //   579: ldc 8
    //   581: iconst_2
    //   582: ldc_w 361
    //   585: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: goto +332 -> 920
    //   591: aload_2
    //   592: astore_0
    //   593: aload 4
    //   595: invokestatic 292	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   598: astore 4
    //   600: aload 4
    //   602: ifnull +87 -> 689
    //   605: aload_2
    //   606: astore_0
    //   607: aload 4
    //   609: invokevirtual 346	java/lang/String:length	()I
    //   612: aload_3
    //   613: iconst_1
    //   614: aaload
    //   615: invokevirtual 346	java/lang/String:length	()I
    //   618: if_icmpeq +71 -> 689
    //   621: aload_2
    //   622: astore_0
    //   623: aload 4
    //   625: invokevirtual 346	java/lang/String:length	()I
    //   628: istore 9
    //   630: aload_2
    //   631: astore_0
    //   632: aload_3
    //   633: iconst_1
    //   634: aaload
    //   635: invokevirtual 346	java/lang/String:length	()I
    //   638: istore 8
    //   640: iconst_0
    //   641: istore 6
    //   643: iload 6
    //   645: iload 9
    //   647: iload 8
    //   649: isub
    //   650: if_icmpge +39 -> 689
    //   653: aload_2
    //   654: astore_0
    //   655: aload_3
    //   656: iconst_1
    //   657: new 36	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 363
    //   667: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_3
    //   671: iconst_1
    //   672: aaload
    //   673: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: aastore
    //   680: iload 6
    //   682: iconst_1
    //   683: iadd
    //   684: istore 6
    //   686: goto -43 -> 643
    //   689: aload 4
    //   691: ifnull +16 -> 707
    //   694: aload_2
    //   695: astore_0
    //   696: aload 4
    //   698: aload_3
    //   699: iconst_1
    //   700: aaload
    //   701: invokevirtual 296	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   704: ifne +61 -> 765
    //   707: aload_2
    //   708: astore_0
    //   709: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq +214 -> 926
    //   715: aload_2
    //   716: astore_0
    //   717: ldc 8
    //   719: iconst_2
    //   720: new 36	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 365
    //   730: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 4
    //   735: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: ldc_w 367
    //   741: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload_3
    //   745: iconst_1
    //   746: aaload
    //   747: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: ldc_w 369
    //   753: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: goto +164 -> 926
    //   765: iload 5
    //   767: iconst_1
    //   768: iadd
    //   769: istore 5
    //   771: aload_2
    //   772: astore_0
    //   773: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   776: ifeq +32 -> 808
    //   779: aload_2
    //   780: astore_0
    //   781: ldc 8
    //   783: iconst_2
    //   784: new 36	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   791: ldc_w 371
    //   794: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: iload 5
    //   799: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   802: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: goto -469 -> 339
    //   811: astore_1
    //   812: aconst_null
    //   813: astore_2
    //   814: iconst_1
    //   815: istore 10
    //   817: aload_2
    //   818: astore_0
    //   819: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   822: ifeq +34 -> 856
    //   825: aload_2
    //   826: astore_0
    //   827: ldc 8
    //   829: iconst_2
    //   830: new 36	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   837: ldc_w 373
    //   840: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: aload_1
    //   844: invokevirtual 283	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   847: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   856: iload 10
    //   858: istore 11
    //   860: aload_2
    //   861: ifnull -833 -> 28
    //   864: aload_2
    //   865: invokevirtual 351	java/io/BufferedReader:close	()V
    //   868: iload 10
    //   870: ireturn
    //   871: astore_0
    //   872: iload 10
    //   874: ireturn
    //   875: astore_1
    //   876: aconst_null
    //   877: astore_0
    //   878: aload_0
    //   879: ifnull +7 -> 886
    //   882: aload_0
    //   883: invokevirtual 351	java/io/BufferedReader:close	()V
    //   886: aload_1
    //   887: athrow
    //   888: astore_0
    //   889: goto -3 -> 886
    //   892: astore_1
    //   893: goto -15 -> 878
    //   896: astore_1
    //   897: iconst_1
    //   898: istore 10
    //   900: goto -83 -> 817
    //   903: astore_1
    //   904: goto -87 -> 817
    //   907: iload 10
    //   909: istore 12
    //   911: goto -474 -> 437
    //   914: iconst_1
    //   915: istore 10
    //   917: goto -514 -> 403
    //   920: iconst_0
    //   921: istore 10
    //   923: goto -520 -> 403
    //   926: iconst_0
    //   927: istore 10
    //   929: goto -526 -> 403
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	932	0	paramString1	String
    //   0	932	1	paramString2	String
    //   39	826	2	localObject1	Object
    //   48	697	3	localObject2	Object
    //   126	608	4	localObject3	Object
    //   113	685	5	i	int
    //   110	575	6	j	int
    //   278	130	7	k	int
    //   638	12	8	m	int
    //   628	22	9	n	int
    //   4	924	10	bool1	boolean
    //   8	851	11	bool2	boolean
    //   412	498	12	bool3	boolean
    //   1	433	13	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   86	94	94	java/lang/Exception
    //   222	230	230	java/lang/Exception
    //   263	271	271	java/lang/Exception
    //   445	449	452	java/lang/Exception
    //   31	63	811	java/lang/Exception
    //   63	78	811	java/lang/Exception
    //   97	112	811	java/lang/Exception
    //   128	158	811	java/lang/Exception
    //   167	194	811	java/lang/Exception
    //   194	214	811	java/lang/Exception
    //   233	255	811	java/lang/Exception
    //   274	313	811	java/lang/Exception
    //   313	336	811	java/lang/Exception
    //   864	868	871	java/lang/Exception
    //   31	63	875	finally
    //   63	78	875	finally
    //   97	112	875	finally
    //   128	158	875	finally
    //   167	194	875	finally
    //   194	214	875	finally
    //   233	255	875	finally
    //   274	313	875	finally
    //   313	336	875	finally
    //   882	886	888	java/lang/Exception
    //   341	346	892	finally
    //   352	358	892	finally
    //   360	386	892	finally
    //   388	394	892	finally
    //   416	422	892	finally
    //   424	433	892	finally
    //   458	466	892	finally
    //   468	474	892	finally
    //   482	509	892	finally
    //   511	517	892	finally
    //   519	546	892	finally
    //   548	559	892	finally
    //   561	569	892	finally
    //   571	577	892	finally
    //   579	588	892	finally
    //   593	600	892	finally
    //   607	621	892	finally
    //   623	630	892	finally
    //   632	640	892	finally
    //   655	680	892	finally
    //   696	707	892	finally
    //   709	715	892	finally
    //   717	762	892	finally
    //   773	779	892	finally
    //   781	808	892	finally
    //   819	825	892	finally
    //   827	856	892	finally
    //   341	346	896	java/lang/Exception
    //   352	358	896	java/lang/Exception
    //   360	386	896	java/lang/Exception
    //   388	394	896	java/lang/Exception
    //   458	466	896	java/lang/Exception
    //   468	474	896	java/lang/Exception
    //   482	509	896	java/lang/Exception
    //   511	517	896	java/lang/Exception
    //   519	546	896	java/lang/Exception
    //   548	559	896	java/lang/Exception
    //   561	569	896	java/lang/Exception
    //   571	577	896	java/lang/Exception
    //   579	588	896	java/lang/Exception
    //   593	600	896	java/lang/Exception
    //   607	621	896	java/lang/Exception
    //   623	630	896	java/lang/Exception
    //   632	640	896	java/lang/Exception
    //   655	680	896	java/lang/Exception
    //   696	707	896	java/lang/Exception
    //   709	715	896	java/lang/Exception
    //   717	762	896	java/lang/Exception
    //   773	779	896	java/lang/Exception
    //   781	808	896	java/lang/Exception
    //   416	422	903	java/lang/Exception
    //   424	433	903	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\DynamicSplashManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */