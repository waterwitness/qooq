package com.tencent.mqp.app.sec;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static String tag = "downloadfile";
  public static String zipfeaturefilepath = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static String d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 35	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 38	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 42	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 44	java/net/HttpURLConnection
    //   14: astore 4
    //   16: new 46	java/io/BufferedInputStream
    //   19: dup
    //   20: aload 4
    //   22: invokevirtual 50	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore 5
    //   30: new 55	java/io/FileOutputStream
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 56	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   38: astore_2
    //   39: aload_2
    //   40: astore_0
    //   41: sipush 512
    //   44: newarray <illegal type>
    //   46: astore_3
    //   47: aload_2
    //   48: astore_0
    //   49: aload 5
    //   51: aload_3
    //   52: iconst_0
    //   53: sipush 512
    //   56: invokevirtual 60	java/io/BufferedInputStream:read	([BII)I
    //   59: istore 8
    //   61: iload 8
    //   63: iconst_m1
    //   64: if_icmpeq +89 -> 153
    //   67: aload_2
    //   68: astore_0
    //   69: aload_2
    //   70: aload_3
    //   71: iconst_0
    //   72: iload 8
    //   74: invokevirtual 64	java/io/FileOutputStream:write	([BII)V
    //   77: goto -30 -> 47
    //   80: astore_3
    //   81: aload_2
    //   82: astore_0
    //   83: aload_3
    //   84: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   95: aload 5
    //   97: ifnull +8 -> 105
    //   100: aload 5
    //   102: invokevirtual 71	java/io/BufferedInputStream:close	()V
    //   105: aload 4
    //   107: ifnull +8 -> 115
    //   110: aload 4
    //   112: invokevirtual 74	java/net/HttpURLConnection:disconnect	()V
    //   115: new 76	java/io/File
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: invokevirtual 81	java/io/File:exists	()Z
    //   126: ifne +115 -> 241
    //   129: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +12 -> 144
    //   135: getstatic 19	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   138: iconst_2
    //   139: ldc 88
    //   141: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   161: aload 5
    //   163: ifnull +8 -> 171
    //   166: aload 5
    //   168: invokevirtual 71	java/io/BufferedInputStream:close	()V
    //   171: aload 4
    //   173: ifnull -58 -> 115
    //   176: aload 4
    //   178: invokevirtual 74	java/net/HttpURLConnection:disconnect	()V
    //   181: goto -66 -> 115
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   189: goto -74 -> 115
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   197: goto -82 -> 115
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_0
    //   204: ifnull +7 -> 211
    //   207: aload_0
    //   208: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   211: aload 5
    //   213: ifnull +8 -> 221
    //   216: aload 5
    //   218: invokevirtual 71	java/io/BufferedInputStream:close	()V
    //   221: aload 4
    //   223: ifnull +8 -> 231
    //   226: aload 4
    //   228: invokevirtual 74	java/net/HttpURLConnection:disconnect	()V
    //   231: aload_1
    //   232: athrow
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   238: goto -7 -> 231
    //   241: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +12 -> 256
    //   247: getstatic 19	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   250: iconst_2
    //   251: ldc 94
    //   253: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: new 96	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   263: aload_1
    //   264: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 103
    //   269: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: astore_2
    //   276: new 76	java/io/File
    //   279: dup
    //   280: aload_2
    //   281: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   284: astore_0
    //   285: aload_0
    //   286: invokevirtual 81	java/io/File:exists	()Z
    //   289: ifeq +8 -> 297
    //   292: aload_0
    //   293: invokevirtual 110	java/io/File:delete	()Z
    //   296: pop
    //   297: new 112	java/util/zip/ZipFile
    //   300: dup
    //   301: aload_1
    //   302: invokespecial 113	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   305: astore_3
    //   306: aload_3
    //   307: astore_0
    //   308: aload_3
    //   309: invokevirtual 117	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   312: astore 4
    //   314: aload_3
    //   315: astore_0
    //   316: aload 4
    //   318: invokeinterface 122 1 0
    //   323: ifeq +208 -> 531
    //   326: aload_3
    //   327: astore_0
    //   328: aload 4
    //   330: invokeinterface 126 1 0
    //   335: checkcast 128	java/util/zip/ZipEntry
    //   338: astore 5
    //   340: aload_3
    //   341: astore_0
    //   342: aload 5
    //   344: invokevirtual 131	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   347: ldc -123
    //   349: invokevirtual 139	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   352: iconst_m1
    //   353: if_icmpne -39 -> 314
    //   356: aload_3
    //   357: astore_0
    //   358: aload_3
    //   359: aload 5
    //   361: invokevirtual 142	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   364: astore 5
    //   366: aload_3
    //   367: astore_0
    //   368: new 55	java/io/FileOutputStream
    //   371: dup
    //   372: aload_2
    //   373: invokespecial 56	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   376: astore 6
    //   378: aload_3
    //   379: astore_0
    //   380: sipush 8192
    //   383: newarray <illegal type>
    //   385: astore 7
    //   387: aload_3
    //   388: astore_0
    //   389: aload 5
    //   391: aload 7
    //   393: invokevirtual 147	java/io/InputStream:read	([B)I
    //   396: istore 8
    //   398: iload 8
    //   400: ifle +70 -> 470
    //   403: aload_3
    //   404: astore_0
    //   405: aload 6
    //   407: aload 7
    //   409: iconst_0
    //   410: iload 8
    //   412: invokevirtual 150	java/io/OutputStream:write	([BII)V
    //   415: goto -28 -> 387
    //   418: astore_0
    //   419: aload_3
    //   420: astore_2
    //   421: aload_0
    //   422: astore_3
    //   423: aload_2
    //   424: astore_0
    //   425: aload_3
    //   426: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   429: aload_2
    //   430: ifnull +7 -> 437
    //   433: aload_2
    //   434: invokevirtual 151	java/util/zip/ZipFile:close	()V
    //   437: new 76	java/io/File
    //   440: dup
    //   441: aload_1
    //   442: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   445: invokevirtual 110	java/io/File:delete	()Z
    //   448: ifeq +209 -> 657
    //   451: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq +271 -> 725
    //   457: getstatic 19	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   460: iconst_2
    //   461: ldc -103
    //   463: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: aconst_null
    //   467: astore_0
    //   468: aload_0
    //   469: areturn
    //   470: aload_3
    //   471: astore_0
    //   472: aload 5
    //   474: invokevirtual 154	java/io/InputStream:close	()V
    //   477: aload_3
    //   478: astore_0
    //   479: aload 6
    //   481: invokevirtual 155	java/io/OutputStream:close	()V
    //   484: goto -170 -> 314
    //   487: astore_3
    //   488: aload_0
    //   489: astore_2
    //   490: aload_3
    //   491: astore_0
    //   492: aload_2
    //   493: ifnull +7 -> 500
    //   496: aload_2
    //   497: invokevirtual 151	java/util/zip/ZipFile:close	()V
    //   500: new 76	java/io/File
    //   503: dup
    //   504: aload_1
    //   505: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   508: invokevirtual 110	java/io/File:delete	()Z
    //   511: ifeq +174 -> 685
    //   514: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +12 -> 529
    //   520: getstatic 19	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   523: iconst_2
    //   524: ldc -103
    //   526: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_0
    //   530: athrow
    //   531: aload_3
    //   532: astore_0
    //   533: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +14 -> 550
    //   539: aload_3
    //   540: astore_0
    //   541: getstatic 19	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   544: iconst_2
    //   545: ldc -99
    //   547: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: aload_3
    //   551: astore_0
    //   552: new 76	java/io/File
    //   555: dup
    //   556: aload_2
    //   557: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   560: invokevirtual 81	java/io/File:exists	()Z
    //   563: istore 9
    //   565: iload 9
    //   567: ifeq +47 -> 614
    //   570: aload_3
    //   571: ifnull +7 -> 578
    //   574: aload_3
    //   575: invokevirtual 151	java/util/zip/ZipFile:close	()V
    //   578: new 76	java/io/File
    //   581: dup
    //   582: aload_1
    //   583: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   586: invokevirtual 110	java/io/File:delete	()Z
    //   589: ifeq +38 -> 627
    //   592: aload_2
    //   593: astore_0
    //   594: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq -129 -> 468
    //   600: getstatic 19	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   603: iconst_2
    //   604: ldc -103
    //   606: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aload_2
    //   610: astore_0
    //   611: goto -143 -> 468
    //   614: aconst_null
    //   615: astore_2
    //   616: goto -46 -> 570
    //   619: astore_0
    //   620: aload_0
    //   621: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   624: goto -46 -> 578
    //   627: aload_2
    //   628: astore_0
    //   629: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   632: ifeq -164 -> 468
    //   635: getstatic 19	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   638: iconst_2
    //   639: ldc -97
    //   641: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: aload_2
    //   645: astore_0
    //   646: goto -178 -> 468
    //   649: astore_0
    //   650: aload_0
    //   651: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   654: goto -217 -> 437
    //   657: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   660: ifeq +65 -> 725
    //   663: getstatic 19	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   666: iconst_2
    //   667: ldc -97
    //   669: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: aconst_null
    //   673: astore_0
    //   674: goto -206 -> 468
    //   677: astore_2
    //   678: aload_2
    //   679: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   682: goto -182 -> 500
    //   685: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq -159 -> 529
    //   691: getstatic 19	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   694: iconst_2
    //   695: ldc -97
    //   697: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: goto -171 -> 529
    //   703: astore_0
    //   704: aconst_null
    //   705: astore_2
    //   706: goto -214 -> 492
    //   709: astore_3
    //   710: aconst_null
    //   711: astore_2
    //   712: goto -289 -> 423
    //   715: astore_1
    //   716: goto -513 -> 203
    //   719: astore_3
    //   720: aconst_null
    //   721: astore_2
    //   722: goto -641 -> 81
    //   725: aconst_null
    //   726: astore_0
    //   727: goto -259 -> 468
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	730	0	paramString1	String
    //   0	730	1	paramString2	String
    //   38	607	2	localObject1	Object
    //   677	2	2	localIOException1	IOException
    //   705	17	2	localObject2	Object
    //   46	25	3	arrayOfByte1	byte[]
    //   80	4	3	localIOException2	IOException
    //   305	173	3	localObject3	Object
    //   487	88	3	localObject4	Object
    //   709	1	3	localIOException3	IOException
    //   719	1	3	localIOException4	IOException
    //   14	315	4	localObject5	Object
    //   28	445	5	localObject6	Object
    //   376	104	6	localFileOutputStream	FileOutputStream
    //   385	23	7	arrayOfByte2	byte[]
    //   59	352	8	i	int
    //   563	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   41	47	80	java/io/IOException
    //   49	61	80	java/io/IOException
    //   69	77	80	java/io/IOException
    //   0	30	146	java/lang/Exception
    //   157	161	184	java/io/IOException
    //   166	171	184	java/io/IOException
    //   176	181	184	java/io/IOException
    //   91	95	192	java/io/IOException
    //   100	105	192	java/io/IOException
    //   110	115	192	java/io/IOException
    //   30	39	200	finally
    //   207	211	233	java/io/IOException
    //   216	221	233	java/io/IOException
    //   226	231	233	java/io/IOException
    //   308	314	418	java/io/IOException
    //   316	326	418	java/io/IOException
    //   328	340	418	java/io/IOException
    //   342	356	418	java/io/IOException
    //   358	366	418	java/io/IOException
    //   368	378	418	java/io/IOException
    //   380	387	418	java/io/IOException
    //   389	398	418	java/io/IOException
    //   405	415	418	java/io/IOException
    //   472	477	418	java/io/IOException
    //   479	484	418	java/io/IOException
    //   533	539	418	java/io/IOException
    //   541	550	418	java/io/IOException
    //   552	565	418	java/io/IOException
    //   308	314	487	finally
    //   316	326	487	finally
    //   328	340	487	finally
    //   342	356	487	finally
    //   358	366	487	finally
    //   368	378	487	finally
    //   380	387	487	finally
    //   389	398	487	finally
    //   405	415	487	finally
    //   425	429	487	finally
    //   472	477	487	finally
    //   479	484	487	finally
    //   533	539	487	finally
    //   541	550	487	finally
    //   552	565	487	finally
    //   574	578	619	java/io/IOException
    //   433	437	649	java/io/IOException
    //   496	500	677	java/io/IOException
    //   297	306	703	finally
    //   297	306	709	java/io/IOException
    //   41	47	715	finally
    //   49	61	715	finally
    //   69	77	715	finally
    //   83	87	715	finally
    //   30	39	719	java/io/IOException
  }
  
  public static String x(Context paramContext, String paramString)
  {
    i = 1;
    Object localObject = new File(paramContext.getFilesDir(), "EFDfile");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, paramString);
    }
    zipfeaturefilepath = paramContext.getFilesDir() + "/EFDfile/NEWENCRYFILE";
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, zipfeaturefilepath);
    }
    try
    {
      paramContext = new JSONObject(paramString);
      localObject = paramContext.getString("MD5").trim();
      str = paramContext.getString("URL").trim();
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, str);
      }
      paramContext = zipfeaturefilepath + ".bin";
      bool = new File(paramContext).exists();
      if (bool) {
        break label366;
      }
      if (str == null) {
        break label470;
      }
      paramContext = null;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        String str;
        boolean bool;
        label366:
        paramContext = null;
        continue;
        continue;
        i = 0;
        paramContext = null;
      }
    }
    if (i != 0)
    {
      paramString = null;
      i = 2;
      for (;;)
      {
        if (i >= 0) {}
        try
        {
          paramString = d(str, zipfeaturefilepath);
          if (paramString != null)
          {
            if (paramString == null) {
              break label467;
            }
            str = MD5FileUtil.a(paramString);
            if (str == null) {
              break label467;
            }
            bool = str.equalsIgnoreCase((String)localObject);
            if (!bool) {
              break label467;
            }
            paramContext = paramString;
          }
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d(tag, 2, "特征文件更新成功");
              paramContext = paramString;
            }
            if (QLog.isColorLevel()) {
              QLog.d(tag, 2, "retfilepathstr: " + paramContext);
            }
            paramString = paramContext;
            if (paramContext == null)
            {
              paramString = paramContext;
              if (QLog.isColorLevel())
              {
                QLog.d(tag, 2, "文件更新失败了,使用默认配置文件!!!!");
                paramString = zipfeaturefilepath + ".bin";
                localObject = new File(paramString);
                if (((File)localObject).exists()) {
                  ((File)localObject).delete();
                }
              }
            }
          }
          catch (JSONException localJSONException)
          {
            paramContext = paramString;
            paramString = localJSONException;
            break label439;
          }
          try
          {
            localObject = new FileOutputStream(paramString);
            ((OutputStream)localObject).write("i\037\03022220Tqf0(2%>\037\03022220T#0(2I\037\03022222222i\037\0302222222222220F0(2&>\037\0302222222222220\\0(20=vwd=a}qywf=cwgv0\037\03022222222o\037\0302222O>\037\03022220T 0(2I\037\03022222222i\037\0302222222222220F0(2&>\037\0302222222222220\\0(20=vwd=cwgMb{bw0\037\03022222222o\037\0302222O>\037\03022220T!0(2I\037\03022222222i\037\0302222222222220F0(2&>\037\0302222222222220\\0(20=aka=cwgMf`sqw0\037\03022222222o\037\0302222O>\037\03022220T&0(2I\037\03022222222i\037\0302222222222220F0(2%>\037\0302222222222220\\0(20uw|w`{q0\037\03022222222o>\037\030\033\033i\037\0302222222222220F0(2*>\037\0302222222222220\\0(20uw|w`{q0\037\03022222222o\037\0302222O>\037\03022220T'0(2I\037\03022222222i\037\0302222222222220F0(2+>\037\0302222222222220\\0(20avy0\037\03022222222o\037\0302222O>\037\03022220T$0(2I\037\03022222222i\037\0302222222222220F0(2#\">\037\0302222222222220\\0(20avy0\037\03022222222o\037\0302222O>\037\03022220T%0(2I\037\03022222222i\037\0302222222222220F0(2##>\037\0302222222222220\\0(20u}~vt{az0\037\03022222222o\037\0302222O\037\030o".getBytes());
            ((OutputStream)localObject).close();
            return paramString;
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
            return paramContext;
          }
        }
        paramString = MD5FileUtil.a(paramContext);
        if (paramString == null) {
          break label470;
        }
        bool = paramString.equalsIgnoreCase((String)localObject);
        if (!bool)
        {
          paramContext = null;
          break;
        }
        i = 0;
        break;
        i -= 1;
        if (QLog.isColorLevel()) {
          QLog.d(tag, 2, "下载失败，继续尝试");
        }
        try
        {
          Thread.sleep(100L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\sec\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */