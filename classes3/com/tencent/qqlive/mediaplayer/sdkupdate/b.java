package com.tencent.qqlive.mediaplayer.sdkupdate;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class b
{
  private static final int[] a = { 5000, 5000, 10000 };
  private static final int[] b = { 15000, 15000, 20000 };
  private Context c;
  private int d = 0;
  private File e = null;
  private File f = null;
  private File g = null;
  private File h = null;
  private File i = null;
  private File j = null;
  private boolean k = false;
  private SDKLocalConfig l;
  private TVK_SDKMgr.InstallListener m = null;
  
  public b(Context paramContext)
  {
    this.c = paramContext;
  }
  
  /* Error */
  private int a(SDKLocalConfig paramSDKLocalConfig, String paramString)
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore 12
    //   3: iload 12
    //   5: iconst_1
    //   6: isub
    //   7: istore 13
    //   9: iload 12
    //   11: ifle +2496 -> 2507
    //   14: aload_0
    //   15: getfield 55	com/tencent/qqlive/mediaplayer/sdkupdate/b:c	Landroid/content/Context;
    //   18: invokestatic 65	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Landroid/content/Context;)Z
    //   21: ifne +28 -> 49
    //   24: iload 13
    //   26: iconst_2
    //   27: if_icmpge +22 -> 49
    //   30: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   33: ldc 72
    //   35: ldc 74
    //   37: ldc 76
    //   39: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   42: bipush 101
    //   44: istore 12
    //   46: iload 12
    //   48: ireturn
    //   49: getstatic 81	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:c	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   52: ldc 72
    //   54: ldc 74
    //   56: new 83	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   63: ldc 86
    //   65: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iconst_2
    //   69: iload 13
    //   71: isub
    //   72: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   81: aconst_null
    //   82: astore 9
    //   84: aconst_null
    //   85: astore 8
    //   87: aconst_null
    //   88: astore_3
    //   89: aconst_null
    //   90: astore 4
    //   92: aconst_null
    //   93: astore 7
    //   95: aload 4
    //   97: astore 6
    //   99: aload 9
    //   101: astore 5
    //   103: new 99	java/io/File
    //   106: dup
    //   107: aload_2
    //   108: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   111: invokestatic 105	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:b	(Ljava/io/File;)V
    //   114: aload 4
    //   116: astore 6
    //   118: aload 9
    //   120: astore 5
    //   122: new 99	java/io/File
    //   125: dup
    //   126: aload_2
    //   127: ldc 107
    //   129: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: astore 11
    //   134: aload 4
    //   136: astore 6
    //   138: aload 9
    //   140: astore 5
    //   142: aload 11
    //   144: invokevirtual 114	java/io/File:getParentFile	()Ljava/io/File;
    //   147: invokevirtual 118	java/io/File:mkdirs	()Z
    //   150: pop
    //   151: aload 4
    //   153: astore 6
    //   155: aload 9
    //   157: astore 5
    //   159: new 120	java/net/URL
    //   162: dup
    //   163: aload_1
    //   164: getfield 126	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:URL	Ljava/lang/String;
    //   167: invokespecial 127	java/net/URL:<init>	(Ljava/lang/String;)V
    //   170: invokevirtual 131	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   173: checkcast 133	java/net/HttpURLConnection
    //   176: astore 10
    //   178: aload 10
    //   180: ifnonnull +228 -> 408
    //   183: aload 4
    //   185: astore 6
    //   187: aload 9
    //   189: astore 5
    //   191: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   194: ldc 72
    //   196: ldc 74
    //   198: ldc -121
    //   200: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   203: iload 13
    //   205: ifne +103 -> 308
    //   208: bipush 101
    //   210: istore 12
    //   212: iconst_0
    //   213: ifeq +11 -> 224
    //   216: new 137	java/lang/NullPointerException
    //   219: dup
    //   220: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   223: athrow
    //   224: iconst_0
    //   225: ifeq -179 -> 46
    //   228: new 137	java/lang/NullPointerException
    //   231: dup
    //   232: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   235: athrow
    //   236: astore_1
    //   237: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   240: ldc 72
    //   242: ldc 74
    //   244: new 83	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   251: ldc -116
    //   253: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_1
    //   257: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   260: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   269: bipush 101
    //   271: ireturn
    //   272: astore_1
    //   273: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   276: ldc 72
    //   278: ldc 74
    //   280: new 83	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   287: ldc -113
    //   289: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_1
    //   293: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   296: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   305: goto -81 -> 224
    //   308: iconst_0
    //   309: ifeq +11 -> 320
    //   312: new 137	java/lang/NullPointerException
    //   315: dup
    //   316: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   319: athrow
    //   320: iconst_0
    //   321: ifeq +2239 -> 2560
    //   324: new 137	java/lang/NullPointerException
    //   327: dup
    //   328: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   331: athrow
    //   332: astore_3
    //   333: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   336: ldc 72
    //   338: ldc 74
    //   340: new 83	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   347: ldc -113
    //   349: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_3
    //   353: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   356: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   365: goto -45 -> 320
    //   368: astore_3
    //   369: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   372: ldc 72
    //   374: ldc 74
    //   376: new 83	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   383: ldc -116
    //   385: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_3
    //   389: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   392: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   401: iload 13
    //   403: istore 12
    //   405: goto -402 -> 3
    //   408: aload 4
    //   410: astore 6
    //   412: aload 9
    //   414: astore 5
    //   416: new 145	java/io/FileOutputStream
    //   419: dup
    //   420: aload 11
    //   422: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   425: astore 4
    //   427: aload 4
    //   429: astore 6
    //   431: aload 8
    //   433: astore 5
    //   435: aload_3
    //   436: astore 7
    //   438: aload 10
    //   440: invokevirtual 151	java/net/HttpURLConnection:getResponseCode	()I
    //   443: istore 12
    //   445: iload 12
    //   447: sipush 300
    //   450: if_icmple +296 -> 746
    //   453: iload 13
    //   455: ifne +145 -> 600
    //   458: aload 4
    //   460: astore 6
    //   462: aload 8
    //   464: astore 5
    //   466: aload_3
    //   467: astore 7
    //   469: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   472: ldc 72
    //   474: ldc 74
    //   476: new 83	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   483: ldc -103
    //   485: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: iload 12
    //   490: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   493: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   499: bipush 102
    //   501: istore 12
    //   503: iconst_0
    //   504: ifeq +11 -> 515
    //   507: new 137	java/lang/NullPointerException
    //   510: dup
    //   511: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   514: athrow
    //   515: aload 4
    //   517: ifnull -471 -> 46
    //   520: aload 4
    //   522: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   525: bipush 102
    //   527: ireturn
    //   528: astore_1
    //   529: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   532: ldc 72
    //   534: ldc 74
    //   536: new 83	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   543: ldc -116
    //   545: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_1
    //   549: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   552: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   561: bipush 102
    //   563: ireturn
    //   564: astore_1
    //   565: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   568: ldc 72
    //   570: ldc 74
    //   572: new 83	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   579: ldc -113
    //   581: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload_1
    //   585: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   588: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   597: goto -82 -> 515
    //   600: aload 4
    //   602: astore 6
    //   604: aload 8
    //   606: astore 5
    //   608: aload_3
    //   609: astore 7
    //   611: getstatic 81	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:c	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   614: ldc 72
    //   616: ldc 74
    //   618: new 83	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   625: ldc -98
    //   627: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: iload 12
    //   632: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   635: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   641: iconst_0
    //   642: ifeq +11 -> 653
    //   645: new 137	java/lang/NullPointerException
    //   648: dup
    //   649: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   652: athrow
    //   653: aload 4
    //   655: ifnull +1905 -> 2560
    //   658: aload 4
    //   660: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   663: iload 13
    //   665: istore 12
    //   667: goto -664 -> 3
    //   670: astore_3
    //   671: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   674: ldc 72
    //   676: ldc 74
    //   678: new 83	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   685: ldc -113
    //   687: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: aload_3
    //   691: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   694: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   703: goto -50 -> 653
    //   706: astore_3
    //   707: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   710: ldc 72
    //   712: ldc 74
    //   714: new 83	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   721: ldc -116
    //   723: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload_3
    //   727: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   730: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   739: iload 13
    //   741: istore 12
    //   743: goto -740 -> 3
    //   746: aload 4
    //   748: astore 6
    //   750: aload 8
    //   752: astore 5
    //   754: aload_3
    //   755: astore 7
    //   757: aload 10
    //   759: ldc -96
    //   761: invokevirtual 164	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   764: invokestatic 170	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   767: i2l
    //   768: lstore 16
    //   770: lload 16
    //   772: lconst_0
    //   773: lcmp
    //   774: ifne +237 -> 1011
    //   777: aload 4
    //   779: astore 6
    //   781: aload 8
    //   783: astore 5
    //   785: aload_3
    //   786: astore 7
    //   788: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   791: ldc 72
    //   793: ldc 74
    //   795: ldc -84
    //   797: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   800: iload 13
    //   802: ifne +104 -> 906
    //   805: bipush 103
    //   807: istore 12
    //   809: iconst_0
    //   810: ifeq +11 -> 821
    //   813: new 137	java/lang/NullPointerException
    //   816: dup
    //   817: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   820: athrow
    //   821: aload 4
    //   823: ifnull -777 -> 46
    //   826: aload 4
    //   828: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   831: bipush 103
    //   833: ireturn
    //   834: astore_1
    //   835: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   838: ldc 72
    //   840: ldc 74
    //   842: new 83	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   849: ldc -116
    //   851: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: aload_1
    //   855: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   858: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   867: bipush 103
    //   869: ireturn
    //   870: astore_1
    //   871: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   874: ldc 72
    //   876: ldc 74
    //   878: new 83	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   885: ldc -113
    //   887: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: aload_1
    //   891: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   894: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   903: goto -82 -> 821
    //   906: iconst_0
    //   907: ifeq +11 -> 918
    //   910: new 137	java/lang/NullPointerException
    //   913: dup
    //   914: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   917: athrow
    //   918: aload 4
    //   920: ifnull +1640 -> 2560
    //   923: aload 4
    //   925: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   928: iload 13
    //   930: istore 12
    //   932: goto -929 -> 3
    //   935: astore_3
    //   936: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   939: ldc 72
    //   941: ldc 74
    //   943: new 83	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   950: ldc -113
    //   952: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: aload_3
    //   956: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   959: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   968: goto -50 -> 918
    //   971: astore_3
    //   972: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   975: ldc 72
    //   977: ldc 74
    //   979: new 83	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   986: ldc -116
    //   988: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload_3
    //   992: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   995: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1004: iload 13
    //   1006: istore 12
    //   1008: goto -1005 -> 3
    //   1011: lconst_0
    //   1012: lstore 14
    //   1014: aload 4
    //   1016: astore 6
    //   1018: aload 8
    //   1020: astore 5
    //   1022: aload_3
    //   1023: astore 7
    //   1025: aload 10
    //   1027: invokevirtual 176	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1030: astore_3
    //   1031: aload_3
    //   1032: ifnonnull +228 -> 1260
    //   1035: iload 13
    //   1037: ifne +122 -> 1159
    //   1040: aload 4
    //   1042: astore 6
    //   1044: aload_3
    //   1045: astore 5
    //   1047: aload_3
    //   1048: astore 7
    //   1050: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1053: ldc 72
    //   1055: ldc 74
    //   1057: ldc -78
    //   1059: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1062: bipush 103
    //   1064: istore 12
    //   1066: aload_3
    //   1067: ifnull +7 -> 1074
    //   1070: aload_3
    //   1071: invokevirtual 181	java/io/InputStream:close	()V
    //   1074: aload 4
    //   1076: ifnull -1030 -> 46
    //   1079: aload 4
    //   1081: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   1084: bipush 103
    //   1086: ireturn
    //   1087: astore_1
    //   1088: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1091: ldc 72
    //   1093: ldc 74
    //   1095: new 83	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1102: ldc -116
    //   1104: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: aload_1
    //   1108: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1111: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1120: bipush 103
    //   1122: ireturn
    //   1123: astore_1
    //   1124: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1127: ldc 72
    //   1129: ldc 74
    //   1131: new 83	java/lang/StringBuilder
    //   1134: dup
    //   1135: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1138: ldc -113
    //   1140: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: aload_1
    //   1144: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1147: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1156: goto -82 -> 1074
    //   1159: aload_3
    //   1160: ifnull +7 -> 1167
    //   1163: aload_3
    //   1164: invokevirtual 181	java/io/InputStream:close	()V
    //   1167: aload 4
    //   1169: ifnull +1391 -> 2560
    //   1172: aload 4
    //   1174: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   1177: iload 13
    //   1179: istore 12
    //   1181: goto -1178 -> 3
    //   1184: astore_3
    //   1185: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1188: ldc 72
    //   1190: ldc 74
    //   1192: new 83	java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1199: ldc -113
    //   1201: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: aload_3
    //   1205: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1208: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1214: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1217: goto -50 -> 1167
    //   1220: astore_3
    //   1221: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1224: ldc 72
    //   1226: ldc 74
    //   1228: new 83	java/lang/StringBuilder
    //   1231: dup
    //   1232: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1235: ldc -116
    //   1237: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload_3
    //   1241: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1244: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1253: iload 13
    //   1255: istore 12
    //   1257: goto -1254 -> 3
    //   1260: aload 4
    //   1262: astore 6
    //   1264: aload_3
    //   1265: astore 5
    //   1267: aload_3
    //   1268: astore 7
    //   1270: sipush 8192
    //   1273: newarray <illegal type>
    //   1275: astore 8
    //   1277: aload 4
    //   1279: astore 6
    //   1281: aload_3
    //   1282: astore 5
    //   1284: aload_3
    //   1285: astore 7
    //   1287: aload_3
    //   1288: aload 8
    //   1290: iconst_0
    //   1291: sipush 8192
    //   1294: invokevirtual 185	java/io/InputStream:read	([BII)I
    //   1297: istore 12
    //   1299: iload 12
    //   1301: iconst_m1
    //   1302: if_icmple +152 -> 1454
    //   1305: aload 4
    //   1307: astore 6
    //   1309: aload_3
    //   1310: astore 5
    //   1312: aload_3
    //   1313: astore 7
    //   1315: aload 4
    //   1317: aload 8
    //   1319: iconst_0
    //   1320: iload 12
    //   1322: invokevirtual 189	java/io/FileOutputStream:write	([BII)V
    //   1325: lload 14
    //   1327: iload 12
    //   1329: i2l
    //   1330: ladd
    //   1331: lstore 14
    //   1333: aload 4
    //   1335: astore 6
    //   1337: aload_3
    //   1338: astore 5
    //   1340: aload_3
    //   1341: astore 7
    //   1343: aload_0
    //   1344: lload 14
    //   1346: l2d
    //   1347: lload 16
    //   1349: l2d
    //   1350: ddiv
    //   1351: d2f
    //   1352: invokevirtual 192	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(F)V
    //   1355: goto -78 -> 1277
    //   1358: astore 5
    //   1360: aload 4
    //   1362: astore 5
    //   1364: aload_3
    //   1365: astore 4
    //   1367: aload 5
    //   1369: astore_3
    //   1370: aload_0
    //   1371: bipush 101
    //   1373: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1376: iload 13
    //   1378: ifne +647 -> 2025
    //   1381: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1384: ldc 72
    //   1386: ldc 74
    //   1388: ldc -62
    //   1390: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1393: bipush 101
    //   1395: istore 12
    //   1397: aload 4
    //   1399: ifnull +8 -> 1407
    //   1402: aload 4
    //   1404: invokevirtual 181	java/io/InputStream:close	()V
    //   1407: aload_3
    //   1408: ifnull -1362 -> 46
    //   1411: aload_3
    //   1412: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   1415: bipush 101
    //   1417: ireturn
    //   1418: astore_1
    //   1419: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1422: ldc 72
    //   1424: ldc 74
    //   1426: new 83	java/lang/StringBuilder
    //   1429: dup
    //   1430: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1433: ldc -116
    //   1435: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: aload_1
    //   1439: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1442: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1448: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1451: bipush 101
    //   1453: ireturn
    //   1454: aload 4
    //   1456: astore 6
    //   1458: aload_3
    //   1459: astore 5
    //   1461: aload_3
    //   1462: astore 7
    //   1464: aload 4
    //   1466: invokevirtual 197	java/io/FileOutputStream:flush	()V
    //   1469: aload 4
    //   1471: astore 6
    //   1473: aload_3
    //   1474: astore 5
    //   1476: aload_3
    //   1477: astore 7
    //   1479: aload 4
    //   1481: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   1484: aconst_null
    //   1485: astore 7
    //   1487: aload_3
    //   1488: astore 6
    //   1490: aload_3
    //   1491: astore 5
    //   1493: aload 10
    //   1495: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1498: aload_3
    //   1499: astore 6
    //   1501: aload_3
    //   1502: astore 5
    //   1504: getstatic 81	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:c	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1507: ldc 72
    //   1509: ldc 74
    //   1511: new 83	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1518: ldc -54
    //   1520: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: lload 16
    //   1525: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1528: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1531: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1534: aload_3
    //   1535: astore 6
    //   1537: aload_3
    //   1538: astore 5
    //   1540: aload_0
    //   1541: aload_0
    //   1542: aload 11
    //   1544: aload_1
    //   1545: aload_2
    //   1546: invokespecial 208	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/io/File;Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;Ljava/lang/String;)I
    //   1549: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1552: aload_3
    //   1553: astore 6
    //   1555: aload_3
    //   1556: astore 5
    //   1558: aload_0
    //   1559: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1562: ifeq +333 -> 1895
    //   1565: iload 13
    //   1567: ifne +117 -> 1684
    //   1570: aload_3
    //   1571: astore 6
    //   1573: aload_3
    //   1574: astore 5
    //   1576: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1579: ldc 72
    //   1581: ldc 74
    //   1583: ldc -46
    //   1585: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1588: bipush 101
    //   1590: istore 12
    //   1592: aload_3
    //   1593: ifnull +7 -> 1600
    //   1596: aload_3
    //   1597: invokevirtual 181	java/io/InputStream:close	()V
    //   1600: iconst_0
    //   1601: ifeq -1555 -> 46
    //   1604: new 137	java/lang/NullPointerException
    //   1607: dup
    //   1608: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   1611: athrow
    //   1612: astore_1
    //   1613: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1616: ldc 72
    //   1618: ldc 74
    //   1620: new 83	java/lang/StringBuilder
    //   1623: dup
    //   1624: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1627: ldc -116
    //   1629: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: aload_1
    //   1633: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1636: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1642: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1645: bipush 101
    //   1647: ireturn
    //   1648: astore_1
    //   1649: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1652: ldc 72
    //   1654: ldc 74
    //   1656: new 83	java/lang/StringBuilder
    //   1659: dup
    //   1660: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1663: ldc -113
    //   1665: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: aload_1
    //   1669: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1672: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1678: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1681: goto -81 -> 1600
    //   1684: aload_3
    //   1685: astore 6
    //   1687: aload_3
    //   1688: astore 5
    //   1690: aload_0
    //   1691: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1694: istore 12
    //   1696: bipush 103
    //   1698: iload 12
    //   1700: if_icmpne +99 -> 1799
    //   1703: bipush 103
    //   1705: istore 12
    //   1707: aload_3
    //   1708: ifnull +7 -> 1715
    //   1711: aload_3
    //   1712: invokevirtual 181	java/io/InputStream:close	()V
    //   1715: iconst_0
    //   1716: ifeq -1670 -> 46
    //   1719: new 137	java/lang/NullPointerException
    //   1722: dup
    //   1723: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   1726: athrow
    //   1727: astore_1
    //   1728: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1731: ldc 72
    //   1733: ldc 74
    //   1735: new 83	java/lang/StringBuilder
    //   1738: dup
    //   1739: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1742: ldc -116
    //   1744: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1747: aload_1
    //   1748: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1751: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1757: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1760: bipush 103
    //   1762: ireturn
    //   1763: astore_1
    //   1764: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1767: ldc 72
    //   1769: ldc 74
    //   1771: new 83	java/lang/StringBuilder
    //   1774: dup
    //   1775: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1778: ldc -113
    //   1780: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: aload_1
    //   1784: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1787: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1793: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1796: goto -81 -> 1715
    //   1799: aload_3
    //   1800: ifnull +7 -> 1807
    //   1803: aload_3
    //   1804: invokevirtual 181	java/io/InputStream:close	()V
    //   1807: iconst_0
    //   1808: ifeq +752 -> 2560
    //   1811: new 137	java/lang/NullPointerException
    //   1814: dup
    //   1815: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   1818: athrow
    //   1819: astore_3
    //   1820: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1823: ldc 72
    //   1825: ldc 74
    //   1827: new 83	java/lang/StringBuilder
    //   1830: dup
    //   1831: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1834: ldc -113
    //   1836: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: aload_3
    //   1840: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1843: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1849: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1852: goto -45 -> 1807
    //   1855: astore_3
    //   1856: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1859: ldc 72
    //   1861: ldc 74
    //   1863: new 83	java/lang/StringBuilder
    //   1866: dup
    //   1867: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1870: ldc -116
    //   1872: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: aload_3
    //   1876: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1879: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1882: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1885: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1888: iload 13
    //   1890: istore 12
    //   1892: goto -1889 -> 3
    //   1895: aload_3
    //   1896: ifnull +7 -> 1903
    //   1899: aload_3
    //   1900: invokevirtual 181	java/io/InputStream:close	()V
    //   1903: iconst_0
    //   1904: ifeq +11 -> 1915
    //   1907: new 137	java/lang/NullPointerException
    //   1910: dup
    //   1911: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   1914: athrow
    //   1915: iconst_0
    //   1916: ireturn
    //   1917: astore_1
    //   1918: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1921: ldc 72
    //   1923: ldc 74
    //   1925: new 83	java/lang/StringBuilder
    //   1928: dup
    //   1929: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1932: ldc -113
    //   1934: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1937: aload_1
    //   1938: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1941: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1947: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1950: goto -47 -> 1903
    //   1953: astore_1
    //   1954: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1957: ldc 72
    //   1959: ldc 74
    //   1961: new 83	java/lang/StringBuilder
    //   1964: dup
    //   1965: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1968: ldc -116
    //   1970: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1973: aload_1
    //   1974: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   1977: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1983: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1986: goto -71 -> 1915
    //   1989: astore_1
    //   1990: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   1993: ldc 72
    //   1995: ldc 74
    //   1997: new 83	java/lang/StringBuilder
    //   2000: dup
    //   2001: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   2004: ldc -113
    //   2006: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: aload_1
    //   2010: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   2013: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2019: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2022: goto -615 -> 1407
    //   2025: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2028: ldc 72
    //   2030: ldc 74
    //   2032: ldc -44
    //   2034: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2037: aload 4
    //   2039: ifnull +8 -> 2047
    //   2042: aload 4
    //   2044: invokevirtual 181	java/io/InputStream:close	()V
    //   2047: aload_3
    //   2048: ifnull +512 -> 2560
    //   2051: aload_3
    //   2052: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   2055: iload 13
    //   2057: istore 12
    //   2059: goto -2056 -> 3
    //   2062: astore 4
    //   2064: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2067: ldc 72
    //   2069: ldc 74
    //   2071: new 83	java/lang/StringBuilder
    //   2074: dup
    //   2075: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   2078: ldc -113
    //   2080: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2083: aload 4
    //   2085: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   2088: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2094: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2097: goto -50 -> 2047
    //   2100: astore_3
    //   2101: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2104: ldc 72
    //   2106: ldc 74
    //   2108: new 83	java/lang/StringBuilder
    //   2111: dup
    //   2112: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   2115: ldc -116
    //   2117: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2120: aload_3
    //   2121: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   2124: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2127: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2130: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2133: iload 13
    //   2135: istore 12
    //   2137: goto -2134 -> 3
    //   2140: astore_3
    //   2141: aconst_null
    //   2142: astore 4
    //   2144: aload 6
    //   2146: astore 7
    //   2148: aload 4
    //   2150: astore 6
    //   2152: aload 7
    //   2154: astore 5
    //   2156: aload_0
    //   2157: bipush 101
    //   2159: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   2162: iload 13
    //   2164: ifne +122 -> 2286
    //   2167: aload 4
    //   2169: astore 6
    //   2171: aload 7
    //   2173: astore 5
    //   2175: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2178: ldc 72
    //   2180: ldc 74
    //   2182: ldc -62
    //   2184: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2187: bipush 101
    //   2189: istore 12
    //   2191: aload 7
    //   2193: ifnull +8 -> 2201
    //   2196: aload 7
    //   2198: invokevirtual 181	java/io/InputStream:close	()V
    //   2201: aload 4
    //   2203: ifnull -2157 -> 46
    //   2206: aload 4
    //   2208: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   2211: bipush 101
    //   2213: ireturn
    //   2214: astore_1
    //   2215: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2218: ldc 72
    //   2220: ldc 74
    //   2222: new 83	java/lang/StringBuilder
    //   2225: dup
    //   2226: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   2229: ldc -116
    //   2231: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: aload_1
    //   2235: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   2238: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2244: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2247: bipush 101
    //   2249: ireturn
    //   2250: astore_1
    //   2251: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2254: ldc 72
    //   2256: ldc 74
    //   2258: new 83	java/lang/StringBuilder
    //   2261: dup
    //   2262: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   2265: ldc -113
    //   2267: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: aload_1
    //   2271: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   2274: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2280: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2283: goto -82 -> 2201
    //   2286: aload 4
    //   2288: astore 6
    //   2290: aload 7
    //   2292: astore 5
    //   2294: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2297: ldc 72
    //   2299: ldc 74
    //   2301: ldc -44
    //   2303: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2306: aload 7
    //   2308: ifnull +8 -> 2316
    //   2311: aload 7
    //   2313: invokevirtual 181	java/io/InputStream:close	()V
    //   2316: aload 4
    //   2318: ifnull +242 -> 2560
    //   2321: aload 4
    //   2323: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   2326: iload 13
    //   2328: istore 12
    //   2330: goto -2327 -> 3
    //   2333: astore_3
    //   2334: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2337: ldc 72
    //   2339: ldc 74
    //   2341: new 83	java/lang/StringBuilder
    //   2344: dup
    //   2345: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   2348: ldc -113
    //   2350: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2353: aload_3
    //   2354: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   2357: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2363: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2366: goto -50 -> 2316
    //   2369: astore_3
    //   2370: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2373: ldc 72
    //   2375: ldc 74
    //   2377: new 83	java/lang/StringBuilder
    //   2380: dup
    //   2381: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   2384: ldc -116
    //   2386: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2389: aload_3
    //   2390: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   2393: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2396: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2399: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2402: iload 13
    //   2404: istore 12
    //   2406: goto -2403 -> 3
    //   2409: astore_1
    //   2410: aconst_null
    //   2411: astore 6
    //   2413: aload 5
    //   2415: ifnull +8 -> 2423
    //   2418: aload 5
    //   2420: invokevirtual 181	java/io/InputStream:close	()V
    //   2423: aload 6
    //   2425: ifnull +8 -> 2433
    //   2428: aload 6
    //   2430: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   2433: aload_1
    //   2434: athrow
    //   2435: astore_2
    //   2436: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2439: ldc 72
    //   2441: ldc 74
    //   2443: new 83	java/lang/StringBuilder
    //   2446: dup
    //   2447: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   2450: ldc -113
    //   2452: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2455: aload_2
    //   2456: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   2459: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2462: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2465: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2468: goto -45 -> 2423
    //   2471: astore_2
    //   2472: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   2475: ldc 72
    //   2477: ldc 74
    //   2479: new 83	java/lang/StringBuilder
    //   2482: dup
    //   2483: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   2486: ldc -116
    //   2488: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2491: aload_2
    //   2492: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   2495: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2498: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2501: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2504: goto -71 -> 2433
    //   2507: bipush 100
    //   2509: ireturn
    //   2510: astore_1
    //   2511: goto -98 -> 2413
    //   2514: astore_1
    //   2515: aload_3
    //   2516: astore 6
    //   2518: aload 4
    //   2520: astore 5
    //   2522: goto -109 -> 2413
    //   2525: astore_3
    //   2526: goto -378 -> 2148
    //   2529: astore_3
    //   2530: aconst_null
    //   2531: astore 4
    //   2533: aload 7
    //   2535: astore_3
    //   2536: goto -1166 -> 1370
    //   2539: astore_3
    //   2540: aload 4
    //   2542: astore_3
    //   2543: aconst_null
    //   2544: astore 4
    //   2546: goto -1176 -> 1370
    //   2549: astore 4
    //   2551: aload_3
    //   2552: astore 4
    //   2554: aload 7
    //   2556: astore_3
    //   2557: goto -1187 -> 1370
    //   2560: iload 13
    //   2562: istore 12
    //   2564: goto -2561 -> 3
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2567	0	this	b
    //   0	2567	1	paramSDKLocalConfig	SDKLocalConfig
    //   0	2567	2	paramString	String
    //   88	1	3	localObject1	Object
    //   332	21	3	localException1	Exception
    //   368	241	3	localException2	Exception
    //   670	21	3	localException3	Exception
    //   706	80	3	localException4	Exception
    //   935	21	3	localException5	Exception
    //   971	52	3	localException6	Exception
    //   1030	134	3	localInputStream	java.io.InputStream
    //   1184	21	3	localException7	Exception
    //   1220	145	3	localException8	Exception
    //   1369	435	3	localObject2	Object
    //   1819	21	3	localException9	Exception
    //   1855	197	3	localException10	Exception
    //   2100	21	3	localException11	Exception
    //   2140	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   2333	21	3	localException12	Exception
    //   2369	147	3	localException13	Exception
    //   2525	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   2529	1	3	localException14	Exception
    //   2535	1	3	localObject3	Object
    //   2539	1	3	localException15	Exception
    //   2542	15	3	localObject4	Object
    //   90	1953	4	localObject5	Object
    //   2062	22	4	localException16	Exception
    //   2142	403	4	localObject6	Object
    //   2549	1	4	localException17	Exception
    //   2552	1	4	localObject7	Object
    //   101	1238	5	localObject8	Object
    //   1358	1	5	localException18	Exception
    //   1362	1159	5	localObject9	Object
    //   97	2420	6	localObject10	Object
    //   93	2462	7	localObject11	Object
    //   85	1233	8	arrayOfByte	byte[]
    //   82	331	9	localObject12	Object
    //   176	1318	10	localHttpURLConnection	java.net.HttpURLConnection
    //   132	1411	11	localFile	File
    //   1	2562	12	n	int
    //   7	2554	13	i1	int
    //   1012	333	14	l1	long
    //   768	756	16	l2	long
    // Exception table:
    //   from	to	target	type
    //   228	236	236	java/lang/Exception
    //   216	224	272	java/lang/Exception
    //   312	320	332	java/lang/Exception
    //   324	332	368	java/lang/Exception
    //   520	525	528	java/lang/Exception
    //   507	515	564	java/lang/Exception
    //   645	653	670	java/lang/Exception
    //   658	663	706	java/lang/Exception
    //   826	831	834	java/lang/Exception
    //   813	821	870	java/lang/Exception
    //   910	918	935	java/lang/Exception
    //   923	928	971	java/lang/Exception
    //   1079	1084	1087	java/lang/Exception
    //   1070	1074	1123	java/lang/Exception
    //   1163	1167	1184	java/lang/Exception
    //   1172	1177	1220	java/lang/Exception
    //   1050	1062	1358	java/lang/Exception
    //   1270	1277	1358	java/lang/Exception
    //   1287	1299	1358	java/lang/Exception
    //   1315	1325	1358	java/lang/Exception
    //   1343	1355	1358	java/lang/Exception
    //   1464	1469	1358	java/lang/Exception
    //   1479	1484	1358	java/lang/Exception
    //   1411	1415	1418	java/lang/Exception
    //   1604	1612	1612	java/lang/Exception
    //   1596	1600	1648	java/lang/Exception
    //   1719	1727	1727	java/lang/Exception
    //   1711	1715	1763	java/lang/Exception
    //   1803	1807	1819	java/lang/Exception
    //   1811	1819	1855	java/lang/Exception
    //   1899	1903	1917	java/lang/Exception
    //   1907	1915	1953	java/lang/Exception
    //   1402	1407	1989	java/lang/Exception
    //   2042	2047	2062	java/lang/Exception
    //   2051	2055	2100	java/lang/Exception
    //   103	114	2140	java/lang/OutOfMemoryError
    //   122	134	2140	java/lang/OutOfMemoryError
    //   142	151	2140	java/lang/OutOfMemoryError
    //   159	178	2140	java/lang/OutOfMemoryError
    //   191	203	2140	java/lang/OutOfMemoryError
    //   416	427	2140	java/lang/OutOfMemoryError
    //   1493	1498	2140	java/lang/OutOfMemoryError
    //   1504	1534	2140	java/lang/OutOfMemoryError
    //   1540	1552	2140	java/lang/OutOfMemoryError
    //   1558	1565	2140	java/lang/OutOfMemoryError
    //   1576	1588	2140	java/lang/OutOfMemoryError
    //   1690	1696	2140	java/lang/OutOfMemoryError
    //   2206	2211	2214	java/lang/Exception
    //   2196	2201	2250	java/lang/Exception
    //   2311	2316	2333	java/lang/Exception
    //   2321	2326	2369	java/lang/Exception
    //   103	114	2409	finally
    //   122	134	2409	finally
    //   142	151	2409	finally
    //   159	178	2409	finally
    //   191	203	2409	finally
    //   416	427	2409	finally
    //   1493	1498	2409	finally
    //   1504	1534	2409	finally
    //   1540	1552	2409	finally
    //   1558	1565	2409	finally
    //   1576	1588	2409	finally
    //   1690	1696	2409	finally
    //   2418	2423	2435	java/lang/Exception
    //   2428	2433	2471	java/lang/Exception
    //   438	445	2510	finally
    //   469	499	2510	finally
    //   611	641	2510	finally
    //   757	770	2510	finally
    //   788	800	2510	finally
    //   1025	1031	2510	finally
    //   1050	1062	2510	finally
    //   1270	1277	2510	finally
    //   1287	1299	2510	finally
    //   1315	1325	2510	finally
    //   1343	1355	2510	finally
    //   1464	1469	2510	finally
    //   1479	1484	2510	finally
    //   2156	2162	2510	finally
    //   2175	2187	2510	finally
    //   2294	2306	2510	finally
    //   1370	1376	2514	finally
    //   1381	1393	2514	finally
    //   2025	2037	2514	finally
    //   438	445	2525	java/lang/OutOfMemoryError
    //   469	499	2525	java/lang/OutOfMemoryError
    //   611	641	2525	java/lang/OutOfMemoryError
    //   757	770	2525	java/lang/OutOfMemoryError
    //   788	800	2525	java/lang/OutOfMemoryError
    //   1025	1031	2525	java/lang/OutOfMemoryError
    //   1050	1062	2525	java/lang/OutOfMemoryError
    //   1270	1277	2525	java/lang/OutOfMemoryError
    //   1287	1299	2525	java/lang/OutOfMemoryError
    //   1315	1325	2525	java/lang/OutOfMemoryError
    //   1343	1355	2525	java/lang/OutOfMemoryError
    //   1464	1469	2525	java/lang/OutOfMemoryError
    //   1479	1484	2525	java/lang/OutOfMemoryError
    //   103	114	2529	java/lang/Exception
    //   122	134	2529	java/lang/Exception
    //   142	151	2529	java/lang/Exception
    //   159	178	2529	java/lang/Exception
    //   191	203	2529	java/lang/Exception
    //   416	427	2529	java/lang/Exception
    //   438	445	2539	java/lang/Exception
    //   469	499	2539	java/lang/Exception
    //   611	641	2539	java/lang/Exception
    //   757	770	2539	java/lang/Exception
    //   788	800	2539	java/lang/Exception
    //   1025	1031	2539	java/lang/Exception
    //   1493	1498	2549	java/lang/Exception
    //   1504	1534	2549	java/lang/Exception
    //   1540	1552	2549	java/lang/Exception
    //   1558	1565	2549	java/lang/Exception
    //   1576	1588	2549	java/lang/Exception
    //   1690	1696	2549	java/lang/Exception
  }
  
  private int a(File paramFile, SDKLocalConfig paramSDKLocalConfig, String paramString)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!a(paramFile, paramSDKLocalConfig.MD5)) {
        UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "Unzip, file md5 error, : " + paramSDKLocalConfig.MD5);
      }
    }
    else {
      return 103;
    }
    if (!a(paramFile.getAbsolutePath(), paramString))
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "Unzip, file unzip error");
      return 103;
    }
    this.k = true;
    Object localObject = a(paramString);
    if (localObject == null)
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "getupdatejar error");
      return 103;
    }
    paramSDKLocalConfig.JARMD5 = UpdateUtils.a((File)localObject);
    try
    {
      localObject = new File(paramString, "TVKConfig.ser");
      paramString = new ByteArrayOutputStream(4096);
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(paramString);
      localObjectOutputStream.writeObject(paramSDKLocalConfig);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localObject = new FileOutputStream((File)localObject);
      paramString.writeTo((OutputStream)localObject);
      paramString.flush();
      paramString.close();
      ((FileOutputStream)localObject).close();
      UpdateUtils.a(UpdateUtils.LogType.c, "SDKUpdateHelper.java", "MediaPlayerMgr", "Unzip, save version: " + paramSDKLocalConfig.version + ", jarmd5: " + paramSDKLocalConfig.JARMD5);
      paramFile.delete();
      return 0;
    }
    catch (IOException paramSDKLocalConfig)
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "unzip, config write error:" + paramSDKLocalConfig.toString());
      paramFile.delete();
    }
    return 104;
  }
  
  private File a(String paramString)
  {
    if (paramString.contains("TencentVideoKitUpdate")) {}
    for (paramString = this.f;; paramString = this.e)
    {
      paramString = b(paramString, "TVK_MediaPlayer");
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      return new File(paramString);
    }
    return null;
  }
  
  private String b(File paramFile, String paramString)
  {
    if (paramFile == null) {}
    for (;;)
    {
      return null;
      paramFile = paramFile.listFiles();
      int i1 = paramFile.length;
      int n = 0;
      while (n < i1)
      {
        Object localObject = paramFile[n];
        if ((((File)localObject).getName().length() >= paramString.length()) && (((File)localObject).getName().substring(0, paramString.length()).equalsIgnoreCase(paramString))) {
          return ((File)localObject).getAbsolutePath();
        }
        n += 1;
      }
    }
  }
  
  private String b(String paramString)
  {
    System.setProperty("http.keepAlive", "false");
    System.setProperty("http.maxConnections", "100");
    UpdateUtils.a(UpdateUtils.LogType.c, "SDKUpdateHelper.java", "MediaPlayerMgr", "request url: " + paramString);
    int n = 3;
    while (n > 0) {
      try
      {
        Object localObject = new HttpGet(paramString);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        localDefaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(a[0]));
        localDefaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(b[0]));
        localObject = localDefaultHttpClient.execute((HttpUriRequest)localObject);
        int i1 = ((HttpResponse)localObject).getStatusLine().getStatusCode();
        UpdateUtils.a(UpdateUtils.LogType.c, "SDKUpdateHelper.java", "MediaPlayerMgr", "response code : " + i1);
        if (i1 > 300)
        {
          this.d = 102;
          return null;
        }
        localObject = EntityUtils.toString(((HttpResponse)localObject).getEntity(), "utf-8");
        UpdateUtils.a(UpdateUtils.LogType.c, "SDKUpdateHelper.java", "MediaPlayerMgr", "fetchResultWithURL, result : " + (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          boolean bool = TextUtils.isEmpty(((String)localObject).trim());
          if (!bool) {
            return (String)localObject;
          }
        }
        n -= 1;
      }
      catch (Throwable paramString)
      {
        this.d = 102;
        return null;
      }
    }
    this.d = 102;
    return null;
  }
  
  private SDKLocalConfig c(String paramString)
  {
    String str1 = paramString;
    String str2;
    String str3;
    try
    {
      if (paramString.startsWith("QZOutputJson=")) {
        str1 = paramString.replace("QZOutputJson=", "");
      }
      localObject = new JSONObject(str1);
      if (((JSONObject)localObject).optString("error_msg").equals("no record"))
      {
        this.d = 102;
        return null;
      }
      paramString = ((JSONObject)localObject).optString("c_so_url");
      str1 = ((JSONObject)localObject).optString("c_so_name");
      str2 = ((JSONObject)localObject).optString("c_so_update_ver");
      str3 = ((JSONObject)localObject).optString("c_so_md5");
      localObject = ((JSONObject)localObject).optString("ret");
      if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        this.d = 102;
        return null;
      }
    }
    catch (Exception paramString)
    {
      this.d = 102;
      return null;
    }
    Object localObject = new SDKLocalConfig();
    ((SDKLocalConfig)localObject).filename = str1;
    ((SDKLocalConfig)localObject).version = str2;
    ((SDKLocalConfig)localObject).MD5 = str3;
    ((SDKLocalConfig)localObject).URL = paramString;
    return (SDKLocalConfig)localObject;
  }
  
  private boolean c(SDKLocalConfig paramSDKLocalConfig)
  {
    if (!TVK_SDKMgr.checkSdkPluginMode()) {}
    String[] arrayOfString1;
    String[] arrayOfString2;
    do
    {
      return true;
      arrayOfString1 = TVK_SDKMgr.SDK_Ver.split("\\.");
      arrayOfString2 = paramSDKLocalConfig.version.split("\\.");
    } while ((arrayOfString1 != null) && (arrayOfString2 != null) && (arrayOfString1.length > 1) && (arrayOfString2.length > 1) && (arrayOfString1[0].equalsIgnoreCase(arrayOfString2[0])) && (arrayOfString1[1].equalsIgnoreCase(arrayOfString2[1])));
    UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "version not match, sdk:" + TVK_SDKMgr.SDK_Ver + ", configver: " + paramSDKLocalConfig.version);
    return false;
  }
  
  private boolean d(SDKLocalConfig paramSDKLocalConfig)
  {
    if (!TVK_SDKMgr.checkSdkPluginMode()) {}
    String[] arrayOfString2;
    int n;
    do
    {
      return true;
      String[] arrayOfString1 = TVK_SDKMgr.SDK_Ver.split("\\.");
      arrayOfString2 = paramSDKLocalConfig.version.split("\\.");
      if ((arrayOfString1 == null) || (arrayOfString2 == null) || (arrayOfString1.length <= 3) || (arrayOfString2.length <= 3)) {
        break;
      }
      n = Integer.valueOf(arrayOfString1[3]).intValue();
    } while (Integer.valueOf(arrayOfString2[3]).intValue() >= n);
    UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "build version not match, sdk:" + TVK_SDKMgr.SDK_Ver + ", configver: " + paramSDKLocalConfig.version);
    return false;
    UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "build version is invalid, sdk:" + TVK_SDKMgr.SDK_Ver + ", configver: " + paramSDKLocalConfig.version);
    return false;
  }
  
  private boolean d(String paramString)
  {
    boolean bool2 = false;
    try
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        return false;
      }
      localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/tencent/TencentVideoSdk/com.tencent.videokit", "TVKConfig.ser");
      bool1 = bool2;
      if (!localFile.exists()) {
        return bool1;
      }
      this.j = new File(paramString, "TVKConfig.ser");
      this.j.getParentFile().mkdirs();
      if (!UpdateUtils.a(localFile, this.j))
      {
        UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, copy SDKConfig fail");
        return false;
      }
    }
    catch (Exception paramString)
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, exception: " + paramString.toString());
      return false;
    }
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/tencent/TencentVideoSdk/com.tencent.videokit", "TvkPlugin.zip");
    boolean bool1 = bool2;
    if (localFile.exists())
    {
      this.i = new File(paramString, "TvkPlugin.zip");
      this.i.getParentFile().mkdirs();
      if (!UpdateUtils.a(localFile, this.i))
      {
        UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, copy SDKZip fail");
        return false;
      }
      if (!a(this.i.getAbsolutePath(), this.i.getParentFile().getAbsolutePath()))
      {
        UpdateUtils.a(UpdateUtils.LogType.c, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, file unzip error");
        return false;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public SDKLocalConfig a(boolean paramBoolean)
  {
    Object localObject2 = new StringBuilder().append("http://mcgi.v.qq.com/commdatav2?cmd=51&so_name=TvkPlugin&so_ver=");
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = this.l.version;
      localObject1 = b((String)localObject1 + "&app_id=" + "000" + "&sdk_version=" + c.a);
      if (localObject1 != null) {
        break label84;
      }
      this.d = 102;
      localObject1 = null;
    }
    label84:
    do
    {
      do
      {
        do
        {
          return (SDKLocalConfig)localObject1;
          localObject1 = "V0.0.0.0";
          break;
          localObject2 = c((String)localObject1);
          localObject1 = localObject2;
        } while (localObject2 == null);
        localObject1 = localObject2;
      } while (c((SDKLocalConfig)localObject2));
      localObject1 = localObject2;
    } while (d((SDKLocalConfig)localObject2));
    this.d = 102;
    return null;
  }
  
  public void a(float paramFloat)
  {
    if (this.m != null) {
      this.m.onInstallProgress(paramFloat);
    }
  }
  
  public void a(TVK_SDKMgr.InstallListener paramInstallListener)
  {
    this.m = paramInstallListener;
  }
  
  public void a(SDKLocalConfig paramSDKLocalConfig, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = this.f.getAbsolutePath();; str = this.e.getAbsolutePath())
    {
      int n = a(paramSDKLocalConfig, str);
      this.d = n;
      if ((n == 0) && (!paramBoolean)) {
        this.l = paramSDKLocalConfig;
      }
      return;
    }
  }
  
  public boolean a()
  {
    Object localObject2 = null;
    try
    {
      Object localObject1;
      if ((this.c.getFilesDir().exists()) && (this.c.getFilesDir().canRead()) && (this.c.getFilesDir().canWrite())) {
        localObject1 = this.c.getFilesDir().getAbsolutePath();
      }
      while (localObject1 != null)
      {
        this.e = new File((String)localObject1, "TencentVideoKit");
        this.f = new File((String)localObject1, "TencentVideoKitUpdate");
        this.g = new File(this.e.getAbsolutePath(), "TVKConfig.ser");
        this.h = new File(this.f.getAbsolutePath(), "TVKConfig.ser");
        b();
        return true;
        localObject1 = localObject2;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          localObject1 = localObject2;
          if (this.c.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) != null) {
            localObject1 = this.c.getFilesDir().getAbsolutePath();
          }
        }
      }
      this.d = 104;
      UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit failed, dir error");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.d = 104;
        UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit failed, " + localException.toString());
      }
    }
    return false;
  }
  
  public boolean a(SDKLocalConfig paramSDKLocalConfig)
  {
    return (paramSDKLocalConfig != null) && (!TextUtils.isEmpty(paramSDKLocalConfig.version)) && (this.l != null) && (paramSDKLocalConfig.version.equals(this.l.version));
  }
  
  public boolean a(File paramFile1, File paramFile2)
  {
    if ((paramFile1 == null) || (!paramFile1.exists()) || (paramFile2 == null) || (!paramFile2.exists())) {
      return false;
    }
    try
    {
      paramFile2 = new ObjectInputStream(new FileInputStream(paramFile2));
      this.l = ((SDKLocalConfig)paramFile2.readObject());
      paramFile2.close();
      if ((this.l == null) || (this.l.MD5 == null) || (this.l.filename == null) || (this.l.version == null) || (this.l.JARMD5 == null))
      {
        UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "checkFileAndConfig info error, : " + paramFile1);
        UpdateUtils.b(paramFile1);
        return false;
      }
    }
    catch (Exception paramFile2)
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "read config failed: " + paramFile2.toString());
      UpdateUtils.b(paramFile1);
      return false;
    }
    paramFile2 = this.l.JARMD5;
    String str = paramFile1.getAbsolutePath();
    int n;
    if ((TextUtils.isEmpty(paramFile2)) || (TextUtils.isEmpty(str)))
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "", "", "checkjarMd5 failed, empty,  md5: " + paramFile2 + ", dirPath: " + str);
      n = 0;
    }
    while (n == 0)
    {
      UpdateUtils.b(paramFile1);
      return false;
      str = UpdateUtils.a(a(str));
      if ((TextUtils.isEmpty(str)) || (!paramFile2.equalsIgnoreCase(str)))
      {
        UpdateUtils.a(UpdateUtils.LogType.e, "", "", "checkjarMd5 failed, localMD5 = " + paramFile2 + ", fileMd5: " + str);
        n = 0;
      }
      else
      {
        n = 1;
      }
    }
    if (!c(this.l))
    {
      UpdateUtils.b(paramFile1);
      return false;
    }
    if (!d(this.l))
    {
      UpdateUtils.b(paramFile1);
      return false;
    }
    return true;
  }
  
  public boolean a(File paramFile, String paramString)
  {
    return paramString.equalsIgnoreCase(UpdateUtils.a(paramFile));
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      UpdateUtils.a(paramString1, paramString2);
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public void b()
  {
    this.k = false;
    if (d()) {
      this.k = true;
    }
    while (!e()) {
      return;
    }
    this.k = true;
  }
  
  /* Error */
  public boolean b(SDKLocalConfig paramSDKLocalConfig)
  {
    // Byte code:
    //   0: invokestatic 467	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: ldc_w 469
    //   6: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: new 99	java/io/File
    //   17: dup
    //   18: new 83	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   25: invokestatic 472	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   28: invokevirtual 228	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   31: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: getstatic 475	java/io/File:separator	Ljava/lang/String;
    //   37: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 477
    //   43: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: ldc -10
    //   51: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 217	java/io/File:exists	()Z
    //   59: ifne +5 -> 64
    //   62: iconst_0
    //   63: ireturn
    //   64: new 99	java/io/File
    //   67: dup
    //   68: new 83	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   75: invokestatic 472	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   78: invokevirtual 228	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   81: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 475	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 477
    //   93: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: ldc 107
    //   101: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: astore_3
    //   105: aload_3
    //   106: invokevirtual 217	java/io/File:exists	()Z
    //   109: ifne +5 -> 114
    //   112: iconst_0
    //   113: ireturn
    //   114: new 549	java/io/ObjectInputStream
    //   117: dup
    //   118: new 551	java/io/FileInputStream
    //   121: dup
    //   122: aload_2
    //   123: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: invokespecial 555	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   129: astore 5
    //   131: aload 5
    //   133: invokevirtual 559	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   136: checkcast 122	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig
    //   139: astore 4
    //   141: aload 5
    //   143: invokevirtual 560	java/io/ObjectInputStream:close	()V
    //   146: aload 4
    //   148: ifnull +35 -> 183
    //   151: aload 4
    //   153: getfield 220	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   156: ifnull +27 -> 183
    //   159: aload 4
    //   161: getfield 433	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:filename	Ljava/lang/String;
    //   164: ifnull +19 -> 183
    //   167: aload 4
    //   169: getfield 272	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   172: ifnull +11 -> 183
    //   175: aload 4
    //   177: getfield 244	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   180: ifnonnull +18 -> 198
    //   183: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   186: ldc 72
    //   188: ldc 74
    //   190: ldc_w 583
    //   193: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   196: iconst_0
    //   197: ireturn
    //   198: aload_3
    //   199: invokestatic 241	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Ljava/io/File;)Ljava/lang/String;
    //   202: astore 5
    //   204: aload 5
    //   206: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifne +16 -> 225
    //   212: aload 5
    //   214: aload 4
    //   216: getfield 220	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   219: invokevirtual 316	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   222: ifne +59 -> 281
    //   225: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   228: ldc_w 401
    //   231: ldc 74
    //   233: new 83	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 585
    //   243: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 4
    //   248: getfield 220	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   251: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc_w 575
    //   257: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 5
    //   262: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_2
    //   272: invokestatic 105	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:b	(Ljava/io/File;)V
    //   275: aload_3
    //   276: invokestatic 105	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:b	(Ljava/io/File;)V
    //   279: iconst_0
    //   280: ireturn
    //   281: getstatic 81	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:c	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   284: ldc 72
    //   286: ldc 74
    //   288: new 83	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 587
    //   298: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 4
    //   303: getfield 272	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   306: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 589
    //   312: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 4
    //   317: getfield 220	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   320: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload 4
    //   331: getfield 272	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   334: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifne +170 -> 507
    //   340: aload 4
    //   342: getfield 272	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   345: aload_1
    //   346: getfield 272	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   349: invokevirtual 316	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   352: ifeq +155 -> 507
    //   355: aload 4
    //   357: getfield 220	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   360: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   363: ifne +144 -> 507
    //   366: aload 4
    //   368: getfield 220	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   371: aload_1
    //   372: getfield 220	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   375: invokevirtual 316	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   378: ifeq +129 -> 507
    //   381: aload_0
    //   382: aload_0
    //   383: getfield 41	com/tencent/qqlive/mediaplayer/sdkupdate/b:f	Ljava/io/File;
    //   386: invokevirtual 228	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   389: invokespecial 591	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	(Ljava/lang/String;)Z
    //   392: ifne +79 -> 471
    //   395: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   398: ldc_w 401
    //   401: ldc 74
    //   403: ldc_w 593
    //   406: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload_0
    //   410: getfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   413: ifnull +26 -> 439
    //   416: aload_0
    //   417: getfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   420: invokevirtual 217	java/io/File:exists	()Z
    //   423: ifeq +16 -> 439
    //   426: aload_0
    //   427: getfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   430: invokevirtual 277	java/io/File:delete	()Z
    //   433: pop
    //   434: aload_0
    //   435: aconst_null
    //   436: putfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   439: aload_0
    //   440: getfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   443: ifnull +26 -> 469
    //   446: aload_0
    //   447: getfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   450: invokevirtual 217	java/io/File:exists	()Z
    //   453: ifeq +16 -> 469
    //   456: aload_0
    //   457: getfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   460: invokevirtual 277	java/io/File:delete	()Z
    //   463: pop
    //   464: aload_0
    //   465: aconst_null
    //   466: putfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   469: iconst_0
    //   470: ireturn
    //   471: iconst_1
    //   472: ireturn
    //   473: astore_1
    //   474: getstatic 70	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   477: ldc 72
    //   479: ldc 74
    //   481: new 83	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 567
    //   491: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_1
    //   495: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   498: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 79	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   507: iconst_0
    //   508: ireturn
    //   509: astore_1
    //   510: goto -41 -> 469
    //   513: astore_1
    //   514: goto -75 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	b
    //   0	517	1	paramSDKLocalConfig	SDKLocalConfig
    //   54	218	2	localFile1	File
    //   104	172	3	localFile2	File
    //   139	228	4	localSDKLocalConfig	SDKLocalConfig
    //   129	132	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	473	java/lang/Exception
    //   14	62	473	java/lang/Exception
    //   64	112	473	java/lang/Exception
    //   114	146	473	java/lang/Exception
    //   151	183	473	java/lang/Exception
    //   183	196	473	java/lang/Exception
    //   198	225	473	java/lang/Exception
    //   225	279	473	java/lang/Exception
    //   281	409	473	java/lang/Exception
    //   409	439	473	java/lang/Exception
    //   439	469	473	java/lang/Exception
    //   439	469	509	java/lang/Throwable
    //   409	439	513	java/lang/Throwable
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public boolean d()
  {
    if (!a(this.f, this.h)) {
      return false;
    }
    UpdateUtils.b(this.e);
    if (!this.f.renameTo(this.e))
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "SDKUpdateHelper.java", "MediaPlayerMgr", "renameTo failed");
      return false;
    }
    return true;
  }
  
  public boolean e()
  {
    return a(this.e, this.g);
  }
  
  public void f()
  {
    if (this.m == null) {
      return;
    }
    if (this.d == 0)
    {
      this.m.onInstalledSuccessed();
      return;
    }
    this.m.onInstalledFailed(this.d);
  }
  
  public String g()
  {
    if (this.k) {
      return b(this.e, "TVK_MediaPlayer");
    }
    return null;
  }
  
  public String h()
  {
    if (this.k) {
      return b(this.e, "armeabi");
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\qqlive\mediaplayer\sdkupdate\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */