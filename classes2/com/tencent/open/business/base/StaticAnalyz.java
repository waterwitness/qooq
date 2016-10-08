package com.tencent.open.business.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.viareport.OpenSdkStatic;

public class StaticAnalyz
{
  public static final String A = "ANDROIDQQ.INVITE.FS";
  public static final String B = "ANDROIDQQ.REQUEST.FS";
  public static final String C = "ANDROIDQQ.FREEGIFT.FS";
  public static final String D = "ANDROIDQQ.SENDSTORY.FS";
  public static final String E = "ANDROIDQQ.REACTIVE.FS";
  public static final String F = "ANDROIDQQ.BRAG.FS";
  public static final String G = "ANDROIDQQ.PK.FS";
  public static final String H = "ANDROIDQQ.PCPUSH";
  public static final String I = "ANDROIDQQ.PCPUSH.SINGLEDETAIL";
  public static final String J = "ANDROIDQQ.PCPUSH.MUTIDETAIL";
  public static final String K = "ANDROIDQQ.PCPUSH.UNREADPOP";
  public static final String L = "ANDROIDQQ.WIFIDLYYB.STORE";
  public static final String M = "ANDROIDQQ.WIFIDLYYB.STORE.APPDETAIL";
  public static final String N = "ANDROIDQQ.SHAREBAR";
  public static final String O = "ANDROIDQQ.POPUP";
  public static final String P = "ANDROIDQQ.POPUP.YYBDOWNAPP";
  public static final String Q = "ANDROIDQQ.POPUP.SDKDOWNAPP";
  public static final String R = "100";
  public static final String S = "200";
  public static final String T = "202";
  public static final String U = "203";
  public static final String V = "210";
  public static final String W = "300";
  public static final String X = "400";
  public static final String Y = "900";
  public static final String Z = "2000";
  public static final String a = "ANDROIDQQ.PCPUSH.AUTO";
  public static final String aa = "305";
  public static final String ab = "310";
  public static final String ac = "311";
  public static final String ad = "312";
  public static final String ae = "710";
  public static final String af = "720";
  public static final String ag = "201";
  public static final String ah = "500";
  public static final String ai = "3004";
  public static final String aj = "3005";
  public static final String ak = "3006";
  public static final String al = "3007";
  public static final String am = "3008";
  public static final String an = "3009";
  protected static String ao = "";
  public static final String ap = "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG";
  public static final String aq = "yyb_via_info.txt";
  public static final String b = "ANDROIDQQ.INSTALL.FEED";
  public static final String c = "ANDROIDQQ.SENDSTORY.FEED1";
  public static final String d = "ANDROIDQQ.SENDSTORY.FEED2";
  public static final String e = "ANDROIDQQ.UNDOWNLOAD.APPDETAIL";
  public static final String f = "ANDROIDQQ.UNINSTALL.APPDETAIL";
  public static final String g = "ANDROIDQQ.INSTALLED.APPDETAIL";
  public static final String h = "ANDROIDQQ.PCPUSH";
  public static final String i = "ANDROIDQQ.PCPUSH.TIMELINE.NEW";
  public static final String j = "ANDROIDQQ.PCPUSH.MSGPUSH";
  public static final String k = "ANDROIDQQ.PCPUSH.AIOMSG";
  public static final String l = "ANDROIDQQ.INVITE.APPAIO";
  public static final String m = "ANDROIDQQ.REQUEST.APPAIO";
  public static final String n = "ANDROIDQQ.FREEGIFT.APPAIO";
  public static final String o = "ANDROIDQQ.PK.APPAIO";
  public static final String p = "ANDROIDQQ.BRAG.APPAIO";
  public static final String q = "ANDROIDQQ.PCPUSH.AUTO.NEWTIPS";
  public static final String r = "ANDROIDQQ.PCPUSH.AUTO.DOWNLOADED";
  public static final String s = "ANDROIDQQ.PCPUSH.AUTO.DOWNLOADING";
  public static final String t = "ANDROIDQQ.INVITE.ASSISTANT";
  public static final String u = "ANDROIDQQ.REQUEST.ASSISTANT";
  public static final String v = "ANDROIDQQ.FREEGIFT.ASSISTANT";
  public static final String w = "ANDROIDQQ.SENDSTORY.FEED1";
  public static final String x = "ANDROIDQQ.REACTIVE.ASSISTANT";
  public static final String y = "ANDROIDQQ.BRAG.ASSISTANT";
  public static final String z = "ANDROIDQQ.PK.ASSISTANT";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "ANDROIDQQ.FREEGIFT.APPAIO";
    case 50: 
      return "ANDROIDQQ.REQUEST.APPAIO";
    case 100: 
      return "ANDROIDQQ.INVITE.APPAIO";
    case 52: 
      return "ANDROIDQQ.BRAG.APPAIO";
    }
    return "ANDROIDQQ.PK.APPAIO";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 352) {}
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      return "";
    case 1: 
    case 3: 
      return "ANDROIDQQ.INSTALL.FEED";
    case 7: 
    case 8: 
      if ((paramInt3 == 0) || (paramInt3 == 2)) {
        return "ANDROIDQQ.SENDSTORY.FEED1";
      }
      if (paramInt3 == 1) {
        return "ANDROIDQQ.SENDSTORY.FEED2";
      }
      break;
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        int i1 = paramString1.indexOf("ANDROIDQQ");
        if (i1 != -1)
        {
          i1 += "ANDROIDQQ".length();
          paramString1 = new StringBuilder(paramString1);
          paramString1.insert(i1, ".");
          paramString1.insert(i1 + 1, paramString2);
          return paramString1.toString();
        }
        LogUtility.c("VIA", "jointYybVia via dont contain ANDROIDQQ");
        return "";
      }
    }
    catch (Exception paramString1)
    {
      LogUtility.c("VIA", "jointYybVia>>>", paramString1);
    }
    return "";
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 246	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 285	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14: getstatic 294	java/io/File:separator	Ljava/lang/String;
    //   17: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc -121
    //   22: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 4
    //   30: new 299	java/io/BufferedReader
    //   33: dup
    //   34: new 301	java/io/FileReader
    //   37: dup
    //   38: aload 4
    //   40: invokespecial 302	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 305	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokevirtual 308	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 5
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: invokevirtual 308	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore 6
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 308	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore 7
    //   71: aload_3
    //   72: astore_2
    //   73: aload 5
    //   75: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +121 -> 199
    //   81: aload_3
    //   82: astore_2
    //   83: aload 6
    //   85: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +111 -> 199
    //   91: aload_3
    //   92: astore_2
    //   93: aload 7
    //   95: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifne +101 -> 199
    //   101: aload_3
    //   102: astore_2
    //   103: ldc_w 261
    //   106: new 246	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 310
    //   116: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 5
    //   121: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 312
    //   127: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 6
    //   132: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 314
    //   138: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 7
    //   143: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 268	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_3
    //   153: astore_2
    //   154: aload 5
    //   156: aload 6
    //   158: aload_1
    //   159: aload 7
    //   161: invokestatic 317	com/tencent/open/business/base/StaticAnalyz:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_3
    //   165: astore_2
    //   166: new 291	java/io/File
    //   169: dup
    //   170: aload 4
    //   172: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   175: invokevirtual 322	java/io/File:exists	()Z
    //   178: ifeq +12 -> 190
    //   181: aload_3
    //   182: astore_2
    //   183: aload_0
    //   184: ldc -121
    //   186: invokevirtual 326	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   189: pop
    //   190: aload_3
    //   191: ifnull +7 -> 198
    //   194: aload_3
    //   195: invokevirtual 329	java/io/BufferedReader:close	()V
    //   198: return
    //   199: aload_3
    //   200: astore_2
    //   201: ldc_w 261
    //   204: new 246	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 331
    //   214: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 5
    //   219: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 312
    //   225: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 6
    //   230: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 314
    //   236: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 7
    //   241: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 333	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: goto -60 -> 190
    //   253: astore_0
    //   254: aload_3
    //   255: astore_2
    //   256: aload_0
    //   257: invokevirtual 336	java/io/FileNotFoundException:printStackTrace	()V
    //   260: aload_3
    //   261: ifnull -63 -> 198
    //   264: aload_3
    //   265: invokevirtual 329	java/io/BufferedReader:close	()V
    //   268: return
    //   269: astore_0
    //   270: aload_0
    //   271: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   274: return
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   280: return
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_3
    //   284: aload_3
    //   285: astore_2
    //   286: aload_0
    //   287: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   290: aload_3
    //   291: ifnull -93 -> 198
    //   294: aload_3
    //   295: invokevirtual 329	java/io/BufferedReader:close	()V
    //   298: return
    //   299: astore_0
    //   300: aload_0
    //   301: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   304: return
    //   305: astore_0
    //   306: aconst_null
    //   307: astore_2
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 329	java/io/BufferedReader:close	()V
    //   316: aload_0
    //   317: athrow
    //   318: astore_1
    //   319: aload_1
    //   320: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   323: goto -7 -> 316
    //   326: astore_0
    //   327: goto -19 -> 308
    //   330: astore_0
    //   331: goto -47 -> 284
    //   334: astore_0
    //   335: aconst_null
    //   336: astore_3
    //   337: goto -83 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramContext	android.content.Context
    //   0	340	1	paramString	String
    //   48	265	2	localBufferedReader1	java.io.BufferedReader
    //   46	291	3	localBufferedReader2	java.io.BufferedReader
    //   28	143	4	str1	String
    //   53	165	5	str2	String
    //   61	168	6	str3	String
    //   69	171	7	str4	String
    // Exception table:
    //   from	to	target	type
    //   49	55	253	java/io/FileNotFoundException
    //   57	63	253	java/io/FileNotFoundException
    //   65	71	253	java/io/FileNotFoundException
    //   73	81	253	java/io/FileNotFoundException
    //   83	91	253	java/io/FileNotFoundException
    //   93	101	253	java/io/FileNotFoundException
    //   103	152	253	java/io/FileNotFoundException
    //   154	164	253	java/io/FileNotFoundException
    //   166	181	253	java/io/FileNotFoundException
    //   183	190	253	java/io/FileNotFoundException
    //   201	250	253	java/io/FileNotFoundException
    //   264	268	269	java/io/IOException
    //   194	198	275	java/io/IOException
    //   0	47	281	java/io/IOException
    //   294	298	299	java/io/IOException
    //   0	47	305	finally
    //   312	316	318	java/io/IOException
    //   49	55	326	finally
    //   57	63	326	finally
    //   65	71	326	finally
    //   73	81	326	finally
    //   83	91	326	finally
    //   93	101	326	finally
    //   103	152	326	finally
    //   154	164	326	finally
    //   166	181	326	finally
    //   183	190	326	finally
    //   201	250	326	finally
    //   256	260	326	finally
    //   286	290	326	finally
    //   49	55	330	java/io/IOException
    //   57	63	330	java/io/IOException
    //   65	71	330	java/io/IOException
    //   73	81	330	java/io/IOException
    //   83	91	330	java/io/IOException
    //   93	101	330	java/io/IOException
    //   103	152	330	java/io/IOException
    //   154	164	330	java/io/IOException
    //   166	181	330	java/io/IOException
    //   183	190	330	java/io/IOException
    //   201	250	330	java/io/IOException
    //   0	47	334	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +17 -> 21
    //   7: aload_2
    //   8: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +10 -> 21
    //   14: aload_3
    //   15: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +50 -> 68
    //   21: ldc_w 261
    //   24: new 246	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 340
    //   34: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 312
    //   44: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 314
    //   54: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_3
    //   58: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 333	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: return
    //   68: aconst_null
    //   69: astore 4
    //   71: new 246	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   78: aload_0
    //   79: invokevirtual 285	android/content/Context:getFilesDir	()Ljava/io/File;
    //   82: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: getstatic 294	java/io/File:separator	Ljava/lang/String;
    //   88: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc -121
    //   93: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 5
    //   101: new 291	java/io/File
    //   104: dup
    //   105: aload 5
    //   107: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   110: invokevirtual 322	java/io/File:exists	()Z
    //   113: ifeq +10 -> 123
    //   116: aload_0
    //   117: ldc -121
    //   119: invokevirtual 326	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   122: pop
    //   123: new 342	java/io/BufferedWriter
    //   126: dup
    //   127: new 344	java/io/FileWriter
    //   130: dup
    //   131: aload 5
    //   133: invokespecial 345	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   136: invokespecial 348	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   139: astore_0
    //   140: aload_0
    //   141: astore 4
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 351	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   148: aload_0
    //   149: astore 4
    //   151: aload_0
    //   152: invokevirtual 354	java/io/BufferedWriter:newLine	()V
    //   155: aload_0
    //   156: astore 4
    //   158: aload_0
    //   159: aload_2
    //   160: invokevirtual 351	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: astore 4
    //   166: aload_0
    //   167: invokevirtual 354	java/io/BufferedWriter:newLine	()V
    //   170: aload_0
    //   171: astore 4
    //   173: aload_0
    //   174: aload_3
    //   175: invokevirtual 351	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   178: aload_0
    //   179: astore 4
    //   181: aload_0
    //   182: invokevirtual 357	java/io/BufferedWriter:flush	()V
    //   185: aload_0
    //   186: astore 4
    //   188: ldc_w 261
    //   191: new 246	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 359
    //   201: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_1
    //   205: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 312
    //   211: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_2
    //   215: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 314
    //   221: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_3
    //   225: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 268	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: ifnull -168 -> 67
    //   238: aload_0
    //   239: invokevirtual 360	java/io/BufferedWriter:close	()V
    //   242: return
    //   243: astore_0
    //   244: aload_0
    //   245: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   248: return
    //   249: astore_1
    //   250: aload 4
    //   252: astore_0
    //   253: aload_1
    //   254: invokevirtual 336	java/io/FileNotFoundException:printStackTrace	()V
    //   257: aload_0
    //   258: ifnull -191 -> 67
    //   261: aload_0
    //   262: invokevirtual 360	java/io/BufferedWriter:close	()V
    //   265: return
    //   266: astore_0
    //   267: aload_0
    //   268: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   271: return
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_0
    //   275: aload_0
    //   276: astore 4
    //   278: aload_1
    //   279: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   282: aload_0
    //   283: ifnull -216 -> 67
    //   286: aload_0
    //   287: invokevirtual 360	java/io/BufferedWriter:close	()V
    //   290: return
    //   291: astore_0
    //   292: aload_0
    //   293: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   296: return
    //   297: astore_0
    //   298: aconst_null
    //   299: astore 4
    //   301: aload 4
    //   303: ifnull +8 -> 311
    //   306: aload 4
    //   308: invokevirtual 360	java/io/BufferedWriter:close	()V
    //   311: aload_0
    //   312: athrow
    //   313: astore_1
    //   314: aload_1
    //   315: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   318: goto -7 -> 311
    //   321: astore_0
    //   322: goto -21 -> 301
    //   325: astore_1
    //   326: aload_0
    //   327: astore 4
    //   329: aload_1
    //   330: astore_0
    //   331: goto -30 -> 301
    //   334: astore_1
    //   335: goto -60 -> 275
    //   338: astore_1
    //   339: goto -86 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramContext	android.content.Context
    //   0	342	1	paramString1	String
    //   0	342	2	paramString2	String
    //   0	342	3	paramString3	String
    //   69	259	4	localContext	android.content.Context
    //   99	33	5	str	String
    // Exception table:
    //   from	to	target	type
    //   238	242	243	java/io/IOException
    //   71	123	249	java/io/FileNotFoundException
    //   123	140	249	java/io/FileNotFoundException
    //   261	265	266	java/io/IOException
    //   71	123	272	java/io/IOException
    //   123	140	272	java/io/IOException
    //   286	290	291	java/io/IOException
    //   71	123	297	finally
    //   123	140	297	finally
    //   306	311	313	java/io/IOException
    //   143	148	321	finally
    //   151	155	321	finally
    //   158	163	321	finally
    //   166	170	321	finally
    //   173	178	321	finally
    //   181	185	321	finally
    //   188	234	321	finally
    //   278	282	321	finally
    //   253	257	325	finally
    //   143	148	334	java/io/IOException
    //   151	155	334	java/io/IOException
    //   158	163	334	java/io/IOException
    //   166	170	334	java/io/IOException
    //   173	178	334	java/io/IOException
    //   181	185	334	java/io/IOException
    //   188	234	334	java/io/IOException
    //   143	148	338	java/io/FileNotFoundException
    //   151	155	338	java/io/FileNotFoundException
    //   158	163	338	java/io/FileNotFoundException
    //   166	170	338	java/io/FileNotFoundException
    //   173	178	338	java/io/FileNotFoundException
    //   181	185	338	java/io/FileNotFoundException
    //   188	234	338	java/io/FileNotFoundException
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    LogUtility.a("reportForVia", "reportForVia actionType=" + paramString1 + " via=" + paramString2 + ", appid=" + paramString3);
    OpenSdkStatic.a().a(String.valueOf(CommonDataAdapter.a().a()), paramString3, paramString2, paramString1, "", false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    LogUtility.a("reportForVia", "reportForVia actionType=" + paramString1 + " via=" + paramString2 + ", appid=" + paramString3);
    OpenSdkStatic.a().a(String.valueOf(CommonDataAdapter.a().a()), paramString3, paramString2, paramString1, paramString4, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    long l1 = CommonDataAdapter.a().a();
    OpenSdkStatic.a().a(String.valueOf(l1), paramString3, paramString2, paramString1, CommonDataAdapter.a().e(), paramBundle, paramString4, false);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString4 == null)) {
      return;
    }
    LogUtility.a("reportForVia", "reportForVia actionType=" + paramString1 + " via=" + paramString2 + ", appid=" + paramString4);
    OpenSdkStatic.a().a(paramString3, paramString4, paramString2, paramString1, "", false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\base\StaticAnalyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */