package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.util.HashMap;
import org.json.JSONObject;

class ThemeDiyStyleLogic$SwitchThemeTask
  extends AsyncTask
{
  int THEME_OPTION_ERROR;
  int THEME_OPTION_SUCCESS;
  QQAppInterface app;
  Context ctx;
  HashMap reportMap;
  ThemeDiyStyleLogic.StyleCallBack swithCallBack;
  
  public ThemeDiyStyleLogic$SwitchThemeTask(Context paramContext, QQAppInterface paramQQAppInterface, ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.THEME_OPTION_ERROR = -1;
    this.THEME_OPTION_SUCCESS = 0;
    this.reportMap = new HashMap();
    this.ctx = paramContext;
    this.app = paramQQAppInterface;
    this.swithCallBack = paramStyleCallBack;
    if (paramHashMap != null) {
      this.reportMap = paramHashMap;
    }
  }
  
  /* Error */
  protected JSONObject doInBackground(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: checkcast 55	java/lang/String
    //   6: astore_3
    //   7: aload_1
    //   8: iconst_1
    //   9: aaload
    //   10: checkcast 55	java/lang/String
    //   13: astore 4
    //   15: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +43 -> 61
    //   21: ldc 63
    //   23: iconst_2
    //   24: new 65	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   31: ldc 68
    //   33: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 74
    //   42: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload 4
    //   47: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 76
    //   52: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 84	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: new 86	org/json/JSONObject
    //   64: dup
    //   65: invokespecial 87	org/json/JSONObject:<init>	()V
    //   68: astore 5
    //   70: iconst_m1
    //   71: istore 12
    //   73: aload_0
    //   74: getfield 35	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:reportMap	Ljava/util/HashMap;
    //   77: new 65	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   84: aload_3
    //   85: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 89
    //   90: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 4
    //   95: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokevirtual 93	java/lang/String:hashCode	()I
    //   104: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokevirtual 103	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   110: ifeq +450 -> 560
    //   113: aload_0
    //   114: getfield 35	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:reportMap	Ljava/util/HashMap;
    //   117: new 65	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   124: aload_3
    //   125: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 89
    //   130: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 4
    //   135: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokevirtual 93	java/lang/String:hashCode	()I
    //   144: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: invokevirtual 107	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   150: checkcast 55	java/lang/String
    //   153: astore_1
    //   154: aload 5
    //   156: ldc 109
    //   158: aload_3
    //   159: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   162: pop
    //   163: aload 5
    //   165: ldc 115
    //   167: aload 4
    //   169: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   172: pop
    //   173: aload 5
    //   175: ldc 117
    //   177: aload_0
    //   178: getfield 28	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:THEME_OPTION_ERROR	I
    //   181: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   184: pop
    //   185: aload 5
    //   187: ldc 122
    //   189: ldc 124
    //   191: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload_0
    //   196: getfield 37	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:ctx	Landroid/content/Context;
    //   199: aload_3
    //   200: aload 4
    //   202: invokestatic 130	com/tencent/mobileqq/theme/ThemeUtil:getThemeResourcePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   205: astore 6
    //   207: new 132	java/io/File
    //   210: dup
    //   211: aload 6
    //   213: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   216: astore 7
    //   218: aload_0
    //   219: getfield 37	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:ctx	Landroid/content/Context;
    //   222: aload_3
    //   223: invokestatic 139	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   226: astore_2
    //   227: iconst_0
    //   228: istore 13
    //   230: iconst_0
    //   231: istore 11
    //   233: iconst_0
    //   234: istore 10
    //   236: aload 7
    //   238: invokevirtual 142	java/io/File:exists	()Z
    //   241: ifne +837 -> 1078
    //   244: ldc -112
    //   246: aload_3
    //   247: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq +317 -> 567
    //   253: aload_0
    //   254: getfield 37	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:ctx	Landroid/content/Context;
    //   257: ldc -107
    //   259: aload 6
    //   261: invokestatic 155	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   264: ldc2_w 156
    //   267: invokestatic 163	java/lang/Thread:sleep	(J)V
    //   270: new 132	java/io/File
    //   273: dup
    //   274: aload 6
    //   276: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   279: astore 7
    //   281: aload 7
    //   283: invokevirtual 142	java/io/File:exists	()Z
    //   286: ifeq +10 -> 296
    //   289: aload 7
    //   291: invokestatic 169	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:getFileNumInFile	(Ljava/io/File;)I
    //   294: istore 10
    //   296: ldc 63
    //   298: iconst_1
    //   299: new 65	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   306: ldc -85
    //   308: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: iload 10
    //   313: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 84	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: iload 10
    //   324: istore 11
    //   326: iload 10
    //   328: ifgt +750 -> 1078
    //   331: ldc 63
    //   333: iconst_1
    //   334: new 65	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   341: ldc -80
    //   343: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 6
    //   348: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: bipush -30
    //   359: istore 12
    //   361: iload 10
    //   363: istore 11
    //   365: iload 12
    //   367: istore 10
    //   369: ldc2_w 180
    //   372: invokestatic 163	java/lang/Thread:sleep	(J)V
    //   375: aload_2
    //   376: ifnonnull +683 -> 1059
    //   379: new 183	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   382: dup
    //   383: invokespecial 184	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   386: astore_2
    //   387: aload_2
    //   388: ldc2_w 185
    //   391: putfield 190	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   394: aload_2
    //   395: ldc2_w 185
    //   398: putfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   401: aload_2
    //   402: aload_3
    //   403: putfield 196	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   406: aload_2
    //   407: aload 4
    //   409: putfield 198	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   412: aload_2
    //   413: ldc -56
    //   415: putfield 203	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   418: aload_2
    //   419: iconst_0
    //   420: putfield 206	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   423: iload 11
    //   425: aload_2
    //   426: getfield 209	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   429: if_icmple +9 -> 438
    //   432: aload_2
    //   433: iload 11
    //   435: putfield 209	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   438: aload_0
    //   439: getfield 37	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:ctx	Landroid/content/Context;
    //   442: aload_2
    //   443: invokestatic 213	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   446: pop
    //   447: aload 5
    //   449: ldc 117
    //   451: aload_0
    //   452: getfield 30	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   455: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   458: pop
    //   459: aload 5
    //   461: ldc -41
    //   463: aload 6
    //   465: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   468: pop
    //   469: aload 5
    //   471: ldc -39
    //   473: iload 10
    //   475: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   478: pop
    //   479: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +32 -> 514
    //   485: ldc 63
    //   487: iconst_2
    //   488: new 65	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   495: ldc -37
    //   497: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload 5
    //   502: invokevirtual 220	org/json/JSONObject:toString	()Ljava/lang/String;
    //   505: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 84	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: iload 10
    //   516: bipush -36
    //   518: if_icmpeq +10 -> 528
    //   521: iload 10
    //   523: bipush -35
    //   525: if_icmpne +32 -> 557
    //   528: aload_0
    //   529: getfield 39	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   532: ldc -34
    //   534: ldc -32
    //   536: sipush 155
    //   539: aconst_null
    //   540: invokestatic 229	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   543: iload 10
    //   545: aload_3
    //   546: aload 4
    //   548: aload_1
    //   549: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   552: ldc -22
    //   554: invokestatic 239	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload 5
    //   559: areturn
    //   560: getstatic 242	com/tencent/mobileqq/theme/ThemeReporter:u	Ljava/lang/String;
    //   563: astore_1
    //   564: goto -410 -> 154
    //   567: aload_0
    //   568: getfield 37	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$SwitchThemeTask:ctx	Landroid/content/Context;
    //   571: aload_3
    //   572: aload 4
    //   574: invokestatic 245	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: astore 7
    //   579: new 132	java/io/File
    //   582: dup
    //   583: aload 7
    //   585: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   588: astore 8
    //   590: aload 8
    //   592: invokevirtual 142	java/io/File:exists	()Z
    //   595: ifeq +430 -> 1025
    //   598: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq +34 -> 635
    //   604: ldc 63
    //   606: iconst_2
    //   607: new 65	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   614: ldc -9
    //   616: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 8
    //   621: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   624: ldc -4
    //   626: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 84	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: aload_3
    //   636: aload 6
    //   638: invokestatic 258	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic:delOldResDir	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: iconst_0
    //   642: istore 10
    //   644: iconst_0
    //   645: istore 14
    //   647: aload 7
    //   649: aload 6
    //   651: iconst_0
    //   652: invokestatic 263	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   655: iconst_1
    //   656: istore 10
    //   658: iload 10
    //   660: ifne +425 -> 1085
    //   663: new 132	java/io/File
    //   666: dup
    //   667: aload 6
    //   669: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   672: astore 8
    //   674: new 132	java/io/File
    //   677: dup
    //   678: aload 7
    //   680: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   683: astore 9
    //   685: ldc 63
    //   687: iconst_1
    //   688: new 65	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   695: ldc_w 265
    //   698: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload 7
    //   703: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aload 9
    //   714: aload 8
    //   716: iconst_0
    //   717: invokestatic 273	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/io/File;Ljava/io/File;Z)Z
    //   720: istore 14
    //   722: goto +363 -> 1085
    //   725: new 132	java/io/File
    //   728: dup
    //   729: aload 6
    //   731: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   734: astore 8
    //   736: aload 8
    //   738: invokevirtual 142	java/io/File:exists	()Z
    //   741: ifeq +191 -> 932
    //   744: aload 8
    //   746: invokestatic 169	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:getFileNumInFile	(Ljava/io/File;)I
    //   749: istore 10
    //   751: ldc 63
    //   753: iconst_1
    //   754: new 65	java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   761: ldc_w 275
    //   764: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: iload 10
    //   769: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   772: ldc_w 277
    //   775: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_3
    //   779: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: ldc_w 279
    //   785: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload 4
    //   790: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokestatic 84	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   799: goto -477 -> 322
    //   802: astore_2
    //   803: ldc 63
    //   805: iconst_1
    //   806: new 65	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   813: ldc_w 281
    //   816: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: aload_2
    //   820: invokevirtual 284	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   823: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   832: bipush -36
    //   834: istore 10
    //   836: goto -357 -> 479
    //   839: astore 8
    //   841: ldc 63
    //   843: iconst_1
    //   844: new 65	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   851: ldc_w 286
    //   854: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload 8
    //   859: invokevirtual 287	java/io/IOException:getMessage	()Ljava/lang/String;
    //   862: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: ldc_w 277
    //   868: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload_3
    //   872: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: ldc_w 279
    //   878: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: aload 4
    //   883: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   892: goto -234 -> 658
    //   895: astore_2
    //   896: ldc 63
    //   898: iconst_1
    //   899: new 65	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 289
    //   909: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload_2
    //   913: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   916: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   925: bipush -35
    //   927: istore 10
    //   929: goto -450 -> 479
    //   932: aload 7
    //   934: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   937: pop
    //   938: ldc 63
    //   940: iconst_1
    //   941: ldc_w 295
    //   944: invokestatic 84	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: iload 13
    //   949: istore 10
    //   951: goto -629 -> 322
    //   954: aload 7
    //   956: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   959: pop
    //   960: iload 13
    //   962: istore 10
    //   964: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   967: ifeq -645 -> 322
    //   970: ldc 63
    //   972: iconst_2
    //   973: new 65	java/lang/StringBuilder
    //   976: dup
    //   977: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   980: ldc_w 297
    //   983: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload 7
    //   988: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: ldc_w 277
    //   994: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: aload_3
    //   998: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: ldc_w 279
    //   1004: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: aload 4
    //   1009: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1018: iload 13
    //   1020: istore 10
    //   1022: goto -700 -> 322
    //   1025: ldc 63
    //   1027: iconst_1
    //   1028: new 65	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1035: ldc_w 299
    //   1038: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload 7
    //   1043: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1052: iload 13
    //   1054: istore 10
    //   1056: goto -734 -> 322
    //   1059: aload_2
    //   1060: ldc -56
    //   1062: putfield 203	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1065: goto -642 -> 423
    //   1068: astore 7
    //   1070: goto -800 -> 270
    //   1073: astore 7
    //   1075: goto -700 -> 375
    //   1078: iload 12
    //   1080: istore 10
    //   1082: goto -713 -> 369
    //   1085: iload 10
    //   1087: ifne -362 -> 725
    //   1090: iload 14
    //   1092: ifeq -138 -> 954
    //   1095: goto -370 -> 725
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1098	0	this	SwitchThemeTask
    //   0	1098	1	paramVarArgs	Object[]
    //   226	217	2	localThemeInfo	com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo
    //   802	18	2	localJSONException	org.json.JSONException
    //   895	165	2	localException1	Exception
    //   6	992	3	str1	String
    //   13	995	4	str2	String
    //   68	490	5	localJSONObject	JSONObject
    //   205	525	6	str3	String
    //   216	826	7	localObject	Object
    //   1068	1	7	localException2	Exception
    //   1073	1	7	localException3	Exception
    //   588	157	8	localFile1	java.io.File
    //   839	19	8	localIOException	java.io.IOException
    //   683	30	9	localFile2	java.io.File
    //   234	852	10	i	int
    //   231	203	11	j	int
    //   71	1008	12	k	int
    //   228	825	13	m	int
    //   645	446	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   154	227	802	org/json/JSONException
    //   236	264	802	org/json/JSONException
    //   264	270	802	org/json/JSONException
    //   270	281	802	org/json/JSONException
    //   281	296	802	org/json/JSONException
    //   296	322	802	org/json/JSONException
    //   331	357	802	org/json/JSONException
    //   369	375	802	org/json/JSONException
    //   379	423	802	org/json/JSONException
    //   423	438	802	org/json/JSONException
    //   438	479	802	org/json/JSONException
    //   567	635	802	org/json/JSONException
    //   635	641	802	org/json/JSONException
    //   647	655	802	org/json/JSONException
    //   663	722	802	org/json/JSONException
    //   725	799	802	org/json/JSONException
    //   841	892	802	org/json/JSONException
    //   932	947	802	org/json/JSONException
    //   954	960	802	org/json/JSONException
    //   964	1018	802	org/json/JSONException
    //   1025	1052	802	org/json/JSONException
    //   1059	1065	802	org/json/JSONException
    //   647	655	839	java/io/IOException
    //   154	227	895	java/lang/Exception
    //   236	264	895	java/lang/Exception
    //   270	281	895	java/lang/Exception
    //   281	296	895	java/lang/Exception
    //   296	322	895	java/lang/Exception
    //   331	357	895	java/lang/Exception
    //   379	423	895	java/lang/Exception
    //   423	438	895	java/lang/Exception
    //   438	479	895	java/lang/Exception
    //   567	635	895	java/lang/Exception
    //   635	641	895	java/lang/Exception
    //   647	655	895	java/lang/Exception
    //   663	722	895	java/lang/Exception
    //   725	799	895	java/lang/Exception
    //   841	892	895	java/lang/Exception
    //   932	947	895	java/lang/Exception
    //   954	960	895	java/lang/Exception
    //   964	1018	895	java/lang/Exception
    //   1025	1052	895	java/lang/Exception
    //   1059	1065	895	java/lang/Exception
    //   264	270	1068	java/lang/Exception
    //   369	375	1073	java/lang/Exception
  }
  
  protected void onPostExecute(JSONObject paramJSONObject)
  {
    int j = 0;
    int k = 0;
    for (;;)
    {
      try
      {
        int m = paramJSONObject.getInt("ret");
        String str2 = paramJSONObject.getString("themeId");
        String str3 = paramJSONObject.getString("version");
        if (!paramJSONObject.has("errCode")) {
          break label560;
        }
        i = paramJSONObject.getInt("errCode");
        String str1;
        if (this.reportMap.containsKey(Integer.valueOf((str2 + "_" + str3).hashCode())))
        {
          str1 = (String)this.reportMap.get(Integer.valueOf((str2 + "_" + str3).hashCode()));
          if (QLog.isColorLevel()) {
            QLog.i("ThemeDiyStyleLogic", 2, "SwitchThemeTask.onPostExecute ret:" + m + ", themeId:" + str2 + ", version:" + str3);
          }
          if (m != this.THEME_OPTION_SUCCESS) {
            continue;
          }
          if (str2.equals("1000"))
          {
            paramJSONObject = null;
            boolean bool = SkinEngine.getInstances().setSkinRootPath(this.ctx, paramJSONObject);
            if (QLog.isColorLevel()) {
              QLog.i("ThemeDiyStyleLogic", 2, "SwitchThemeTask.onPostExecute setSkinSuccess:" + bool);
            }
            if (bool != true) {
              continue;
            }
            ThemeUtil.setCurrentThemeIdVersion(this.app, str2, str3);
            ThemeUtil.setWeekLoopTheme(this.app, null, null, 0L);
            ThemeDIYActivity.themeStatus = 2;
            this.swithCallBack.callback(15, 4, null, null);
            ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Diy_stock", 0, 1, "", "", "B", "");
            j = 1;
            break label557;
            if (j == 0) {
              continue;
            }
            ThemeReporter.a(this.app, "theme_detail", "201", 155, NetworkUtil.a(null), 23, str2, str3, str1, "");
          }
        }
        else
        {
          str1 = ThemeReporter.u;
          continue;
        }
        paramJSONObject = paramJSONObject.getString("themeResPath");
        continue;
        ThemeDIYActivity.themeStatus = -1;
        this.swithCallBack.callback(15, 8, null, null);
        i = -24;
        break label557;
        QLog.e("ThemeDiyStyleLogic", 1, "SwitchThemeTask.onPostExecute ret = false");
        ThemeDIYActivity.themeStatus = -1;
        this.swithCallBack.callback(15, 8, null, null);
        j = k;
        continue;
        ThemeReporter.a(this.app, "theme_detail", "201", 155, NetworkUtil.a(null), i, str2, str3, str1, "");
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ThemeDiyStyleLogic", 1, "SwitchThemeTask.onPostExecute Exception:" + paramJSONObject.getMessage());
        ThemeDIYActivity.themeStatus = -1;
        this.swithCallBack.callback(15, 8, null, null);
        ThemeReporter.a(this.app, "theme_detail", "201", 155, NetworkUtil.a(null), -35, "", "2", ThemeReporter.u, "");
        return;
      }
      label557:
      continue;
      label560:
      int i = -23;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDiyStyleLogic$SwitchThemeTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */