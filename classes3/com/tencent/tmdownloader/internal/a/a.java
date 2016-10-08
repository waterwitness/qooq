package com.tencent.tmdownloader.internal.a;

import android.text.TextUtils;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.network.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a
  implements b
{
  protected static a a = null;
  final ConcurrentHashMap<String, d> b = new ConcurrentHashMap();
  
  public static a b()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  /* Error */
  public int a(String paramString1, int paramInt, String paramString2, String paramString3, java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 33	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   9: ldc 36
    //   11: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 42
    //   20: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_2
    //   24: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 55	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: invokestatic 60	com/tencent/tmdownloader/internal/a/c:c	()Z
    //   36: ifne +12 -> 48
    //   39: ldc 31
    //   41: ldc 62
    //   43: invokestatic 55	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: iconst_1
    //   47: ireturn
    //   48: invokestatic 64	com/tencent/tmdownloader/internal/a/c:b	()Ljava/lang/String;
    //   51: ldc 66
    //   53: invokevirtual 72	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   56: ifne +21 -> 77
    //   59: invokestatic 77	com/tencent/tmdownloader/internal/a/f:a	()Lcom/tencent/tmdownloader/internal/a/f;
    //   62: invokevirtual 79	com/tencent/tmdownloader/internal/a/f:b	()Z
    //   65: ifeq +12 -> 77
    //   68: ldc 31
    //   70: ldc 81
    //   72: invokestatic 55	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: iconst_2
    //   76: ireturn
    //   77: aload_1
    //   78: invokestatic 84	com/tencent/tmdownloader/internal/a/c:g	(Ljava/lang/String;)Z
    //   81: ifne +12 -> 93
    //   84: ldc 31
    //   86: ldc 86
    //   88: invokestatic 55	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: iconst_3
    //   92: ireturn
    //   93: aload_1
    //   94: aload_3
    //   95: invokestatic 89	com/tencent/tmdownloader/internal/a/c:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   98: ifeq +12 -> 110
    //   101: ldc 31
    //   103: ldc 91
    //   105: invokestatic 55	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: iconst_4
    //   109: ireturn
    //   110: aload_0
    //   111: getfield 24	com/tencent/tmdownloader/internal/a/a:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   114: aload_1
    //   115: invokevirtual 95	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 97	com/tencent/tmdownloader/internal/a/d
    //   121: astore 7
    //   123: aload 7
    //   125: ifnonnull +898 -> 1023
    //   128: invokestatic 102	com/tencent/tmdownloader/internal/d/a:a	()Lcom/tencent/tmdownloader/internal/d/a;
    //   131: aload_1
    //   132: invokevirtual 105	com/tencent/tmdownloader/internal/d/a:b	(Ljava/lang/String;)Lcom/tencent/tmdownloader/internal/a/d;
    //   135: astore 6
    //   137: aload 6
    //   139: ifnonnull +833 -> 972
    //   142: new 97	com/tencent/tmdownloader/internal/a/d
    //   145: dup
    //   146: aload_1
    //   147: iload_2
    //   148: aload_3
    //   149: invokespecial 108	com/tencent/tmdownloader/internal/a/d:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: astore 6
    //   154: aload 5
    //   156: ifnull +290 -> 446
    //   159: aload 5
    //   161: getstatic 114	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APPID	Ljava/lang/String;
    //   164: invokeinterface 119 2 0
    //   169: checkcast 68	java/lang/String
    //   172: astore 7
    //   174: aload 7
    //   176: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne +13 -> 192
    //   182: aload 6
    //   184: aload 7
    //   186: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   189: putfield 135	com/tencent/tmdownloader/internal/a/d:t	J
    //   192: aload 6
    //   194: aload 5
    //   196: getstatic 138	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   199: invokeinterface 119 2 0
    //   204: checkcast 68	java/lang/String
    //   207: putfield 141	com/tencent/tmdownloader/internal/a/d:u	Ljava/lang/String;
    //   210: aload 6
    //   212: aload 5
    //   214: getstatic 144	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_VERSION	Ljava/lang/String;
    //   217: invokeinterface 119 2 0
    //   222: checkcast 68	java/lang/String
    //   225: putfield 147	com/tencent/tmdownloader/internal/a/d:v	Ljava/lang/String;
    //   228: aload 6
    //   230: aload 5
    //   232: getstatic 150	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_VIA	Ljava/lang/String;
    //   235: invokeinterface 119 2 0
    //   240: checkcast 68	java/lang/String
    //   243: putfield 153	com/tencent/tmdownloader/internal/a/d:B	Ljava/lang/String;
    //   246: aload 5
    //   248: getstatic 156	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN	Ljava/lang/String;
    //   251: invokeinterface 119 2 0
    //   256: checkcast 68	java/lang/String
    //   259: astore 7
    //   261: aload 7
    //   263: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +13 -> 279
    //   269: aload 6
    //   271: aload 7
    //   273: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   276: putfield 159	com/tencent/tmdownloader/internal/a/d:z	J
    //   279: aload 6
    //   281: aload 5
    //   283: getstatic 162	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN_TYPE	Ljava/lang/String;
    //   286: invokeinterface 119 2 0
    //   291: checkcast 68	java/lang/String
    //   294: putfield 165	com/tencent/tmdownloader/internal/a/d:A	Ljava/lang/String;
    //   297: aload 6
    //   299: aload 5
    //   301: getstatic 168	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_CHANNELID	Ljava/lang/String;
    //   304: invokeinterface 119 2 0
    //   309: checkcast 68	java/lang/String
    //   312: putfield 171	com/tencent/tmdownloader/internal/a/d:C	Ljava/lang/String;
    //   315: aload 6
    //   317: invokestatic 177	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   320: invokevirtual 178	java/util/UUID:toString	()Ljava/lang/String;
    //   323: putfield 181	com/tencent/tmdownloader/internal/a/d:D	Ljava/lang/String;
    //   326: aload 6
    //   328: aload 5
    //   330: getstatic 184	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_EXTRA_DATA	Ljava/lang/String;
    //   333: invokeinterface 119 2 0
    //   338: checkcast 68	java/lang/String
    //   341: putfield 187	com/tencent/tmdownloader/internal/a/d:E	Ljava/lang/String;
    //   344: aload 5
    //   346: getstatic 190	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTYPE	Ljava/lang/String;
    //   349: invokeinterface 119 2 0
    //   354: checkcast 68	java/lang/String
    //   357: astore 7
    //   359: aload 7
    //   361: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   364: ifne +13 -> 377
    //   367: aload 6
    //   369: aload 7
    //   371: invokestatic 196	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   374: putfield 200	com/tencent/tmdownloader/internal/a/d:F	I
    //   377: aload 6
    //   379: aload 5
    //   381: getstatic 203	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_ICON_URL	Ljava/lang/String;
    //   384: invokeinterface 119 2 0
    //   389: checkcast 68	java/lang/String
    //   392: putfield 206	com/tencent/tmdownloader/internal/a/d:H	Ljava/lang/String;
    //   395: aload 6
    //   397: aload 5
    //   399: getstatic 209	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APP_NAME	Ljava/lang/String;
    //   402: invokeinterface 119 2 0
    //   407: checkcast 68	java/lang/String
    //   410: putfield 211	com/tencent/tmdownloader/internal/a/d:I	Ljava/lang/String;
    //   413: aload 5
    //   415: getstatic 214	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_SHOW_NOTIFICATION	Ljava/lang/String;
    //   418: invokeinterface 119 2 0
    //   423: checkcast 68	java/lang/String
    //   426: astore 7
    //   428: aload 7
    //   430: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   433: ifne +13 -> 446
    //   436: aload 6
    //   438: aload 7
    //   440: invokestatic 196	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   443: putfield 216	com/tencent/tmdownloader/internal/a/d:J	I
    //   446: aload 6
    //   448: getfield 218	com/tencent/tmdownloader/internal/a/d:a	Ljava/lang/String;
    //   451: ldc -36
    //   453: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   456: ifeq +655 -> 1111
    //   459: aload 6
    //   461: aload 4
    //   463: putfield 227	com/tencent/tmdownloader/internal/a/d:l	Ljava/lang/String;
    //   466: aload_0
    //   467: getfield 24	com/tencent/tmdownloader/internal/a/a:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   470: aload_1
    //   471: aload 6
    //   473: invokevirtual 231	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: aload 6
    //   479: getfield 218	com/tencent/tmdownloader/internal/a/d:a	Ljava/lang/String;
    //   482: ldc -23
    //   484: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   487: ifeq +560 -> 1047
    //   490: aload_1
    //   491: aload 6
    //   493: getfield 218	com/tencent/tmdownloader/internal/a/d:a	Ljava/lang/String;
    //   496: invokestatic 89	com/tencent/tmdownloader/internal/a/c:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   499: istore 8
    //   501: aload 6
    //   503: astore 7
    //   505: aload 6
    //   507: invokevirtual 235	com/tencent/tmdownloader/internal/a/d:a	()Z
    //   510: ifeq +361 -> 871
    //   513: aload 6
    //   515: astore 7
    //   517: iload 8
    //   519: ifne +352 -> 871
    //   522: aload_0
    //   523: getfield 24	com/tencent/tmdownloader/internal/a/a:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   526: aload_1
    //   527: invokevirtual 236	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   530: pop
    //   531: invokestatic 102	com/tencent/tmdownloader/internal/d/a:a	()Lcom/tencent/tmdownloader/internal/d/a;
    //   534: aload_1
    //   535: invokevirtual 239	com/tencent/tmdownloader/internal/d/a:a	(Ljava/lang/String;)V
    //   538: new 97	com/tencent/tmdownloader/internal/a/d
    //   541: dup
    //   542: aload_1
    //   543: iload_2
    //   544: aload_3
    //   545: invokespecial 108	com/tencent/tmdownloader/internal/a/d:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   548: astore 7
    //   550: aload 5
    //   552: ifnull +278 -> 830
    //   555: aload 5
    //   557: getstatic 114	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APPID	Ljava/lang/String;
    //   560: invokeinterface 119 2 0
    //   565: checkcast 68	java/lang/String
    //   568: astore_3
    //   569: aload_3
    //   570: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   573: ifne +12 -> 585
    //   576: aload 7
    //   578: aload_3
    //   579: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   582: putfield 135	com/tencent/tmdownloader/internal/a/d:t	J
    //   585: aload 7
    //   587: aload 5
    //   589: getstatic 138	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   592: invokeinterface 119 2 0
    //   597: checkcast 68	java/lang/String
    //   600: putfield 141	com/tencent/tmdownloader/internal/a/d:u	Ljava/lang/String;
    //   603: aload 7
    //   605: aload 5
    //   607: getstatic 144	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_VERSION	Ljava/lang/String;
    //   610: invokeinterface 119 2 0
    //   615: checkcast 68	java/lang/String
    //   618: putfield 147	com/tencent/tmdownloader/internal/a/d:v	Ljava/lang/String;
    //   621: aload 7
    //   623: aload 5
    //   625: getstatic 150	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_VIA	Ljava/lang/String;
    //   628: invokeinterface 119 2 0
    //   633: checkcast 68	java/lang/String
    //   636: putfield 153	com/tencent/tmdownloader/internal/a/d:B	Ljava/lang/String;
    //   639: aload 5
    //   641: getstatic 156	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN	Ljava/lang/String;
    //   644: invokeinterface 119 2 0
    //   649: checkcast 68	java/lang/String
    //   652: astore_3
    //   653: aload_3
    //   654: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   657: ifne +12 -> 669
    //   660: aload 7
    //   662: aload_3
    //   663: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   666: putfield 159	com/tencent/tmdownloader/internal/a/d:z	J
    //   669: aload 7
    //   671: aload 5
    //   673: getstatic 162	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN_TYPE	Ljava/lang/String;
    //   676: invokeinterface 119 2 0
    //   681: checkcast 68	java/lang/String
    //   684: putfield 165	com/tencent/tmdownloader/internal/a/d:A	Ljava/lang/String;
    //   687: aload 7
    //   689: aload 5
    //   691: getstatic 168	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_CHANNELID	Ljava/lang/String;
    //   694: invokeinterface 119 2 0
    //   699: checkcast 68	java/lang/String
    //   702: putfield 171	com/tencent/tmdownloader/internal/a/d:C	Ljava/lang/String;
    //   705: aload 7
    //   707: invokestatic 177	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   710: invokevirtual 178	java/util/UUID:toString	()Ljava/lang/String;
    //   713: putfield 181	com/tencent/tmdownloader/internal/a/d:D	Ljava/lang/String;
    //   716: aload 7
    //   718: aload 5
    //   720: getstatic 184	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_EXTRA_DATA	Ljava/lang/String;
    //   723: invokeinterface 119 2 0
    //   728: checkcast 68	java/lang/String
    //   731: putfield 187	com/tencent/tmdownloader/internal/a/d:E	Ljava/lang/String;
    //   734: aload 5
    //   736: getstatic 190	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTYPE	Ljava/lang/String;
    //   739: invokeinterface 119 2 0
    //   744: checkcast 68	java/lang/String
    //   747: astore_3
    //   748: aload_3
    //   749: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   752: ifne +12 -> 764
    //   755: aload 7
    //   757: aload_3
    //   758: invokestatic 196	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   761: putfield 200	com/tencent/tmdownloader/internal/a/d:F	I
    //   764: aload 7
    //   766: aload 5
    //   768: getstatic 203	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_ICON_URL	Ljava/lang/String;
    //   771: invokeinterface 119 2 0
    //   776: checkcast 68	java/lang/String
    //   779: putfield 206	com/tencent/tmdownloader/internal/a/d:H	Ljava/lang/String;
    //   782: aload 7
    //   784: aload 5
    //   786: getstatic 209	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APP_NAME	Ljava/lang/String;
    //   789: invokeinterface 119 2 0
    //   794: checkcast 68	java/lang/String
    //   797: putfield 211	com/tencent/tmdownloader/internal/a/d:I	Ljava/lang/String;
    //   800: aload 5
    //   802: getstatic 214	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_SHOW_NOTIFICATION	Ljava/lang/String;
    //   805: invokeinterface 119 2 0
    //   810: checkcast 68	java/lang/String
    //   813: astore_3
    //   814: aload_3
    //   815: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   818: ifne +12 -> 830
    //   821: aload 7
    //   823: aload_3
    //   824: invokestatic 196	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   827: putfield 216	com/tencent/tmdownloader/internal/a/d:J	I
    //   830: aload 7
    //   832: getfield 218	com/tencent/tmdownloader/internal/a/d:a	Ljava/lang/String;
    //   835: ldc -36
    //   837: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   840: ifeq +10 -> 850
    //   843: aload 7
    //   845: aload 4
    //   847: putfield 227	com/tencent/tmdownloader/internal/a/d:l	Ljava/lang/String;
    //   850: aload 7
    //   852: aload 5
    //   854: checkcast 241	java/util/HashMap
    //   857: invokevirtual 244	com/tencent/tmdownloader/internal/a/d:a	(Ljava/util/HashMap;)V
    //   860: aload_0
    //   861: getfield 24	com/tencent/tmdownloader/internal/a/a:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   864: aload_1
    //   865: aload 7
    //   867: invokevirtual 231	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   870: pop
    //   871: aload 7
    //   873: aload 5
    //   875: checkcast 241	java/util/HashMap
    //   878: invokevirtual 244	com/tencent/tmdownloader/internal/a/d:a	(Ljava/util/HashMap;)V
    //   881: aload 7
    //   883: invokevirtual 248	com/tencent/tmdownloader/internal/a/d:d	()I
    //   886: istore_2
    //   887: ldc 31
    //   889: new 33	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   896: ldc -6
    //   898: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: iload_2
    //   902: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   905: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 55	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   911: iload_2
    //   912: ireturn
    //   913: astore 7
    //   915: ldc 31
    //   917: ldc -4
    //   919: aload 7
    //   921: invokestatic 255	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   924: goto -732 -> 192
    //   927: astore 7
    //   929: ldc 31
    //   931: ldc_w 257
    //   934: aload 7
    //   936: invokestatic 255	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   939: goto -660 -> 279
    //   942: astore 7
    //   944: ldc 31
    //   946: ldc_w 259
    //   949: aload 7
    //   951: invokestatic 255	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   954: goto -577 -> 377
    //   957: astore 7
    //   959: ldc 31
    //   961: ldc_w 261
    //   964: aload 7
    //   966: invokestatic 255	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   969: goto -523 -> 446
    //   972: aload 6
    //   974: getfield 218	com/tencent/tmdownloader/internal/a/d:a	Ljava/lang/String;
    //   977: ldc -23
    //   979: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   982: ifeq +28 -> 1010
    //   985: aload_1
    //   986: aload 6
    //   988: getfield 218	com/tencent/tmdownloader/internal/a/d:a	Ljava/lang/String;
    //   991: invokestatic 89	com/tencent/tmdownloader/internal/a/c:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   994: istore 8
    //   996: iload 8
    //   998: ifeq -532 -> 466
    //   1001: ldc 31
    //   1003: ldc 91
    //   1005: invokestatic 55	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1008: iconst_4
    //   1009: ireturn
    //   1010: aload 6
    //   1012: getfield 227	com/tencent/tmdownloader/internal/a/d:l	Ljava/lang/String;
    //   1015: invokestatic 264	com/tencent/tmdownloader/internal/a/c:h	(Ljava/lang/String;)Z
    //   1018: istore 8
    //   1020: goto -24 -> 996
    //   1023: aload 7
    //   1025: astore 6
    //   1027: aload 7
    //   1029: getfield 227	com/tencent/tmdownloader/internal/a/d:l	Ljava/lang/String;
    //   1032: invokestatic 264	com/tencent/tmdownloader/internal/a/c:h	(Ljava/lang/String;)Z
    //   1035: ifeq -558 -> 477
    //   1038: ldc 31
    //   1040: ldc 91
    //   1042: invokestatic 55	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1045: iconst_4
    //   1046: ireturn
    //   1047: aload 6
    //   1049: getfield 227	com/tencent/tmdownloader/internal/a/d:l	Ljava/lang/String;
    //   1052: invokestatic 264	com/tencent/tmdownloader/internal/a/c:h	(Ljava/lang/String;)Z
    //   1055: istore 8
    //   1057: goto -556 -> 501
    //   1060: astore_3
    //   1061: ldc 31
    //   1063: ldc -4
    //   1065: aload_3
    //   1066: invokestatic 255	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1069: goto -484 -> 585
    //   1072: astore_3
    //   1073: ldc 31
    //   1075: ldc_w 257
    //   1078: aload_3
    //   1079: invokestatic 255	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1082: goto -413 -> 669
    //   1085: astore_3
    //   1086: ldc 31
    //   1088: ldc_w 259
    //   1091: aload_3
    //   1092: invokestatic 255	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1095: goto -331 -> 764
    //   1098: astore_3
    //   1099: ldc 31
    //   1101: ldc_w 261
    //   1104: aload_3
    //   1105: invokestatic 255	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1108: goto -278 -> 830
    //   1111: goto -645 -> 466
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1114	0	this	a
    //   0	1114	1	paramString1	String
    //   0	1114	2	paramInt	int
    //   0	1114	3	paramString2	String
    //   0	1114	4	paramString3	String
    //   0	1114	5	paramMap	java.util.Map<String, String>
    //   135	913	6	localObject1	Object
    //   121	761	7	localObject2	Object
    //   913	7	7	localException1	Exception
    //   927	8	7	localException2	Exception
    //   942	8	7	localException3	Exception
    //   957	71	7	localException4	Exception
    //   499	557	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   182	192	913	java/lang/Exception
    //   269	279	927	java/lang/Exception
    //   367	377	942	java/lang/Exception
    //   436	446	957	java/lang/Exception
    //   576	585	1060	java/lang/Exception
    //   660	669	1072	java/lang/Exception
    //   755	764	1085	java/lang/Exception
    //   821	830	1098	java/lang/Exception
  }
  
  public void a()
  {
    m.c("ApkDownloadManager", "onNetworkChanged");
    if ((c.c()) && (f.a().d()))
    {
      String str = c.b();
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)this.b.get(localIterator.next());
        if ((locald != null) && (!TextUtils.isEmpty(str)) && (f.a().a(locald.p, str)) && ((locald.o == 601) || (locald.o == 602) || (locald.o == 605)) && (System.currentTimeMillis() - locald.q < 120000L)) {
          locald.d();
        }
      }
    }
  }
  
  public void a(l paraml)
  {
    m.c("ApkDownloadManager", "call AddDownloadListener, dl: " + paraml);
    e.a().a(paraml);
  }
  
  public void a(String paramString)
  {
    m.c("ApkDownloadManager", "call pauseDownload, url: " + paramString);
    paramString = (d)this.b.get(paramString);
    if (paramString != null) {
      paramString.e();
    }
  }
  
  public void b(l paraml)
  {
    m.c("ApkDownloadManager", "call RemoveDownloadListener, dl: " + paraml);
    e.a().b(paraml);
  }
  
  public void b(String paramString)
  {
    m.c("ApkDownloadManager", "call cancelDownload, url: " + paramString);
    paramString = (d)this.b.remove(paramString);
    if (paramString != null) {
      paramString.f();
    }
  }
  
  public void c()
  {
    m.c("ApkDownloadManager", "Start to load DownloadInfo list.");
    this.b.clear();
    Object localObject = com.tencent.tmdownloader.internal.d.a.a().b();
    if (localObject != null)
    {
      m.c("ApkDownloadManager", "The size of downloadinfo_list: " + ((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        if (locald != null)
        {
          m.c("ApkDownloadManager", "---------------load download info---------------");
          locald.a("ApkDownloadManager");
          if (!TextUtils.isEmpty(locald.b)) {
            this.b.put(locald.b, locald);
          }
          if (!locald.c()) {
            locald.a(3);
          }
        }
      }
    }
    m.c("ApkDownloadManager", "Add NetworkChangedObserver to NetworkMonitorReceiver");
    NetworkMonitorReceiver.a().a(this);
  }
  
  public void c(String paramString)
  {
    m.c("ApkDownloadManager", "call cotinueDownload, url: " + paramString);
    paramString = (d)this.b.get(paramString);
    if (paramString != null) {
      paramString.d();
    }
  }
  
  public void d()
  {
    NetworkMonitorReceiver.a().b(this);
    ArrayList localArrayList = new ArrayList();
    if (!this.b.isEmpty())
    {
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)this.b.get(localIterator.next());
        if (locald.i == 2) {
          a(locald.b);
        }
        localArrayList.add(locald);
      }
    }
    m.c("ApkDownloadManager", "Start to save DownloadInfo list.");
    com.tencent.tmdownloader.internal.d.a.a().a(localArrayList);
  }
  
  public void d(String paramString)
  {
    m.c("ApkDownloadManager", "call cotinueDownload, url: " + paramString);
    paramString = (d)this.b.get(paramString);
    if (paramString != null) {
      paramString.d();
    }
  }
  
  public Boolean e()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!((d)this.b.get(localIterator.next())).c()) {
        return Boolean.valueOf(false);
      }
    }
    return Boolean.valueOf(true);
  }
  
  public void e(String paramString)
  {
    m.c("ApkDownloadManager", "call deleteDownload, url: " + paramString);
    paramString = (d)this.b.remove(paramString);
    if (paramString != null) {
      paramString.g();
    }
  }
  
  public d f(String paramString)
  {
    m.c("ApkDownloadManager", "call queryDownloadInfo, url: " + paramString);
    Object localObject2 = (d)this.b.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = com.tencent.tmdownloader.internal.d.a.a().b(paramString);
    }
    boolean bool = false;
    if (localObject1 != null) {
      if (!((d)localObject1).a.equals("application/tm.android.apkdiff")) {
        break label122;
      }
    }
    label122:
    for (bool = c.b(paramString, ((d)localObject1).a);; bool = c.h(((d)localObject1).l))
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((d)localObject1).a())
        {
          localObject2 = localObject1;
          if (!bool)
          {
            this.b.remove(paramString);
            com.tencent.tmdownloader.internal.d.a.a().a(paramString);
            localObject2 = null;
          }
        }
      }
      return (d)localObject2;
    }
  }
  
  public List<d> g(String paramString)
  {
    m.b("ApkDownloadManager", "ApkDownloadManager queryDownloadInfoByVia" + paramString);
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (d)this.b.get(((Map.Entry)localObject).getKey());
      if ((localObject != null) && (!TextUtils.isEmpty(((d)localObject).B)) && (((d)localObject).B.contains(paramString)))
      {
        ((d)localObject).a("jimluo");
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */