package sm;

import android.content.Context;
import android.net.Proxy;
import android.os.Environment;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.methods.HttpGet;

public class ae
  extends ad
{
  private Context c;
  private HttpGet d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private int i = 0;
  private boolean j = false;
  private boolean k = false;
  private long l = 0L;
  
  public ae(Context paramContext)
  {
    this.c = paramContext;
    this.j = "mounted".equals(Environment.getExternalStorageState());
    if (this.j) {
      this.e = "/sdcard/qqsecure";
    }
    for (this.f = "/sdcard/qqsecure";; this.f = paramContext.getFilesDir().getAbsolutePath())
    {
      this.d = new HttpGet();
      if (af.c(paramContext) == af.a.b)
      {
        a(Proxy.getDefaultHost(), Proxy.getDefaultPort());
        a(true);
      }
      return;
      this.e = paramContext.getCacheDir().getAbsolutePath();
    }
  }
  
  /* Error */
  private int a(org.apache.http.HttpEntity paramHttpEntity, android.os.Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 15
    //   6: aconst_null
    //   7: astore 16
    //   9: aconst_null
    //   10: astore 17
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 13
    //   18: aconst_null
    //   19: astore 8
    //   21: aconst_null
    //   22: astore 9
    //   24: aconst_null
    //   25: astore 10
    //   27: aconst_null
    //   28: astore 11
    //   30: aconst_null
    //   31: astore 18
    //   33: aconst_null
    //   34: astore 12
    //   36: aconst_null
    //   37: astore 7
    //   39: sipush 8192
    //   42: newarray <illegal type>
    //   44: astore 19
    //   46: aload 18
    //   48: astore 5
    //   50: aload 4
    //   52: astore 6
    //   54: aload_1
    //   55: invokeinterface 123 1 0
    //   60: lstore 25
    //   62: aload 18
    //   64: astore 5
    //   66: aload 4
    //   68: astore 6
    //   70: aload_0
    //   71: getfield 43	sm/ae:l	J
    //   74: lload 25
    //   76: ladd
    //   77: lstore 25
    //   79: aload 18
    //   81: astore 5
    //   83: aload 4
    //   85: astore 6
    //   87: aload_0
    //   88: getfield 43	sm/ae:l	J
    //   91: ldc2_w 124
    //   94: lmul
    //   95: lload 25
    //   97: ldiv
    //   98: l2i
    //   99: istore 21
    //   101: aload 18
    //   103: astore 5
    //   105: aload 4
    //   107: astore 6
    //   109: aload_2
    //   110: ldc 127
    //   112: lload 25
    //   114: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   117: aload 18
    //   119: astore 5
    //   121: aload 4
    //   123: astore 6
    //   125: aload_2
    //   126: ldc -121
    //   128: aload_0
    //   129: getfield 43	sm/ae:l	J
    //   132: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   135: aload 18
    //   137: astore 5
    //   139: aload 4
    //   141: astore 6
    //   143: aload_2
    //   144: ldc -119
    //   146: iload 21
    //   148: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   151: aload 18
    //   153: astore 5
    //   155: aload 4
    //   157: astore 6
    //   159: new 99	java/io/File
    //   162: dup
    //   163: new 142	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   170: aload_0
    //   171: getfield 29	sm/ae:e	Ljava/lang/String;
    //   174: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   180: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: getfield 33	sm/ae:g	Ljava/lang/String;
    //   187: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   196: astore 20
    //   198: aload 18
    //   200: astore 5
    //   202: aload 4
    //   204: astore 6
    //   206: aload 20
    //   208: invokevirtual 160	java/io/File:exists	()Z
    //   211: ifne +34 -> 245
    //   214: aload 18
    //   216: astore 5
    //   218: aload 4
    //   220: astore 6
    //   222: aload 20
    //   224: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   227: invokevirtual 166	java/io/File:mkdirs	()Z
    //   230: pop
    //   231: aload 18
    //   233: astore 5
    //   235: aload 4
    //   237: astore 6
    //   239: aload 20
    //   241: invokevirtual 169	java/io/File:createNewFile	()Z
    //   244: pop
    //   245: aload 18
    //   247: astore 5
    //   249: aload 4
    //   251: astore 6
    //   253: new 171	java/io/FileOutputStream
    //   256: dup
    //   257: aload 20
    //   259: iconst_1
    //   260: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   263: astore 4
    //   265: iload_3
    //   266: ifeq +73 -> 339
    //   269: new 176	java/util/zip/InflaterInputStream
    //   272: dup
    //   273: aload_1
    //   274: invokeinterface 180 1 0
    //   279: invokespecial 183	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   282: astore 5
    //   284: iconst_0
    //   285: istore 22
    //   287: aload 5
    //   289: aload 19
    //   291: invokevirtual 189	java/io/InputStream:read	([B)I
    //   294: istore 24
    //   296: iload 24
    //   298: iconst_m1
    //   299: if_icmpeq +148 -> 447
    //   302: aload_0
    //   303: getfield 41	sm/ae:k	Z
    //   306: istore_3
    //   307: iload_3
    //   308: ifeq +58 -> 366
    //   311: aload 5
    //   313: ifnull +8 -> 321
    //   316: aload 5
    //   318: invokevirtual 192	java/io/InputStream:close	()V
    //   321: aload 4
    //   323: ifnull +8 -> 331
    //   326: aload 4
    //   328: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   331: sipush 60533
    //   334: istore 21
    //   336: iload 21
    //   338: ireturn
    //   339: aload_1
    //   340: invokeinterface 180 1 0
    //   345: astore 5
    //   347: goto -63 -> 284
    //   350: astore_1
    //   351: aload_1
    //   352: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   355: goto -34 -> 321
    //   358: astore_1
    //   359: aload_1
    //   360: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   363: goto -32 -> 331
    //   366: aload_0
    //   367: aload_0
    //   368: getfield 43	sm/ae:l	J
    //   371: iload 24
    //   373: i2l
    //   374: ladd
    //   375: putfield 43	sm/ae:l	J
    //   378: aload_2
    //   379: ldc -121
    //   381: aload_0
    //   382: getfield 43	sm/ae:l	J
    //   385: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   388: aload_0
    //   389: getfield 43	sm/ae:l	J
    //   392: ldc2_w 124
    //   395: lmul
    //   396: lload 25
    //   398: ldiv
    //   399: l2i
    //   400: istore 23
    //   402: iload 23
    //   404: iload 21
    //   406: if_icmpeq +698 -> 1104
    //   409: aload_2
    //   410: ldc -119
    //   412: iload 23
    //   414: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   417: aload_0
    //   418: iconst_2
    //   419: aload_2
    //   420: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   423: iload 23
    //   425: istore 21
    //   427: aload 4
    //   429: aload 19
    //   431: iconst_0
    //   432: iload 24
    //   434: invokevirtual 203	java/io/FileOutputStream:write	([BII)V
    //   437: iload 22
    //   439: iload 24
    //   441: iadd
    //   442: istore 22
    //   444: goto -157 -> 287
    //   447: aload 4
    //   449: invokevirtual 206	java/io/FileOutputStream:flush	()V
    //   452: iload 22
    //   454: i2l
    //   455: lstore 25
    //   457: aload_1
    //   458: invokeinterface 123 1 0
    //   463: lstore 27
    //   465: lload 25
    //   467: lload 27
    //   469: lcmp
    //   470: ifne +50 -> 520
    //   473: iconst_0
    //   474: istore 21
    //   476: iload 21
    //   478: istore 22
    //   480: aload 5
    //   482: ifnull +55 -> 537
    //   485: aload 5
    //   487: invokevirtual 192	java/io/InputStream:close	()V
    //   490: iload 21
    //   492: istore 22
    //   494: iload 22
    //   496: istore 21
    //   498: aload 4
    //   500: ifnull -164 -> 336
    //   503: aload 4
    //   505: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   508: iload 22
    //   510: ireturn
    //   511: astore_1
    //   512: aload_1
    //   513: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   516: sipush 58536
    //   519: ireturn
    //   520: bipush -7
    //   522: istore 21
    //   524: goto -48 -> 476
    //   527: astore_1
    //   528: sipush 58536
    //   531: istore 22
    //   533: aload_1
    //   534: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   537: goto -43 -> 494
    //   540: astore_2
    //   541: aload 13
    //   543: astore_1
    //   544: aload 7
    //   546: astore 4
    //   548: aload 4
    //   550: astore 5
    //   552: aload_1
    //   553: astore 6
    //   555: aload_2
    //   556: invokevirtual 207	java/io/FileNotFoundException:printStackTrace	()V
    //   559: aload 4
    //   561: ifnull +535 -> 1096
    //   564: aload 4
    //   566: invokevirtual 192	java/io/InputStream:close	()V
    //   569: sipush 58535
    //   572: istore 22
    //   574: iload 22
    //   576: istore 21
    //   578: aload_1
    //   579: ifnull -243 -> 336
    //   582: aload_1
    //   583: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   586: iload 22
    //   588: ireturn
    //   589: astore_1
    //   590: aload_1
    //   591: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   594: sipush 58536
    //   597: ireturn
    //   598: astore_2
    //   599: sipush 58536
    //   602: istore 22
    //   604: aload_2
    //   605: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   608: goto -34 -> 574
    //   611: astore_2
    //   612: aload 14
    //   614: astore_1
    //   615: aload 8
    //   617: astore 4
    //   619: aload 4
    //   621: astore 5
    //   623: aload_1
    //   624: astore 6
    //   626: aload_2
    //   627: invokevirtual 208	java/net/SocketException:printStackTrace	()V
    //   630: aload 4
    //   632: ifnull +456 -> 1088
    //   635: aload 4
    //   637: invokevirtual 192	java/io/InputStream:close	()V
    //   640: sipush 60482
    //   643: istore 22
    //   645: iload 22
    //   647: istore 21
    //   649: aload_1
    //   650: ifnull -314 -> 336
    //   653: aload_1
    //   654: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   657: iload 22
    //   659: ireturn
    //   660: astore_1
    //   661: aload_1
    //   662: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   665: sipush 58536
    //   668: ireturn
    //   669: astore_2
    //   670: sipush 58536
    //   673: istore 22
    //   675: aload_2
    //   676: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   679: goto -34 -> 645
    //   682: astore_2
    //   683: aload 15
    //   685: astore_1
    //   686: aload 9
    //   688: astore 4
    //   690: aload 4
    //   692: astore 5
    //   694: aload_1
    //   695: astore 6
    //   697: aload_2
    //   698: invokevirtual 209	java/net/SocketTimeoutException:printStackTrace	()V
    //   701: aload 4
    //   703: ifnull +377 -> 1080
    //   706: aload 4
    //   708: invokevirtual 192	java/io/InputStream:close	()V
    //   711: sipush 60481
    //   714: istore 22
    //   716: iload 22
    //   718: istore 21
    //   720: aload_1
    //   721: ifnull -385 -> 336
    //   724: aload_1
    //   725: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   728: iload 22
    //   730: ireturn
    //   731: astore_1
    //   732: aload_1
    //   733: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   736: sipush 58536
    //   739: ireturn
    //   740: astore_2
    //   741: sipush 58536
    //   744: istore 22
    //   746: aload_2
    //   747: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   750: goto -34 -> 716
    //   753: astore_2
    //   754: aload 16
    //   756: astore_1
    //   757: aload 10
    //   759: astore 4
    //   761: aload 4
    //   763: astore 5
    //   765: aload_1
    //   766: astore 6
    //   768: aload_2
    //   769: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   772: aload 4
    //   774: ifnull +298 -> 1072
    //   777: aload 4
    //   779: invokevirtual 192	java/io/InputStream:close	()V
    //   782: sipush 60480
    //   785: istore 22
    //   787: iload 22
    //   789: istore 21
    //   791: aload_1
    //   792: ifnull -456 -> 336
    //   795: aload_1
    //   796: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   799: iload 22
    //   801: ireturn
    //   802: astore_1
    //   803: aload_1
    //   804: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   807: sipush 58536
    //   810: ireturn
    //   811: astore_2
    //   812: sipush 58536
    //   815: istore 22
    //   817: aload_2
    //   818: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   821: goto -34 -> 787
    //   824: astore_2
    //   825: aload 17
    //   827: astore_1
    //   828: aload 11
    //   830: astore 4
    //   832: aload 4
    //   834: astore 5
    //   836: aload_1
    //   837: astore 6
    //   839: aload_2
    //   840: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   843: aload 4
    //   845: ifnull +219 -> 1064
    //   848: aload 4
    //   850: invokevirtual 192	java/io/InputStream:close	()V
    //   853: sipush 60536
    //   856: istore 22
    //   858: iload 22
    //   860: istore 21
    //   862: aload_1
    //   863: ifnull -527 -> 336
    //   866: aload_1
    //   867: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   870: iload 22
    //   872: ireturn
    //   873: astore_1
    //   874: aload_1
    //   875: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   878: sipush 58536
    //   881: ireturn
    //   882: astore_2
    //   883: sipush 58536
    //   886: istore 22
    //   888: aload_2
    //   889: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   892: goto -34 -> 858
    //   895: astore_1
    //   896: aload 5
    //   898: ifnull +8 -> 906
    //   901: aload 5
    //   903: invokevirtual 192	java/io/InputStream:close	()V
    //   906: aload 6
    //   908: ifnull +8 -> 916
    //   911: aload 6
    //   913: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   916: aload_1
    //   917: athrow
    //   918: astore_2
    //   919: aload_2
    //   920: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   923: goto -17 -> 906
    //   926: astore_2
    //   927: aload_2
    //   928: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   931: goto -15 -> 916
    //   934: astore_1
    //   935: aload 12
    //   937: astore 5
    //   939: aload 4
    //   941: astore 6
    //   943: goto -47 -> 896
    //   946: astore_1
    //   947: aload 4
    //   949: astore 6
    //   951: goto -55 -> 896
    //   954: astore_2
    //   955: aload 4
    //   957: astore_1
    //   958: aload 11
    //   960: astore 4
    //   962: goto -130 -> 832
    //   965: astore_2
    //   966: aload 4
    //   968: astore_1
    //   969: aload 5
    //   971: astore 4
    //   973: goto -141 -> 832
    //   976: astore_2
    //   977: aload 4
    //   979: astore_1
    //   980: aload 10
    //   982: astore 4
    //   984: goto -223 -> 761
    //   987: astore_2
    //   988: aload 4
    //   990: astore_1
    //   991: aload 5
    //   993: astore 4
    //   995: goto -234 -> 761
    //   998: astore_2
    //   999: aload 4
    //   1001: astore_1
    //   1002: aload 9
    //   1004: astore 4
    //   1006: goto -316 -> 690
    //   1009: astore_2
    //   1010: aload 4
    //   1012: astore_1
    //   1013: aload 5
    //   1015: astore 4
    //   1017: goto -327 -> 690
    //   1020: astore_2
    //   1021: aload 4
    //   1023: astore_1
    //   1024: aload 8
    //   1026: astore 4
    //   1028: goto -409 -> 619
    //   1031: astore_2
    //   1032: aload 4
    //   1034: astore_1
    //   1035: aload 5
    //   1037: astore 4
    //   1039: goto -420 -> 619
    //   1042: astore_2
    //   1043: aload 4
    //   1045: astore_1
    //   1046: aload 7
    //   1048: astore 4
    //   1050: goto -502 -> 548
    //   1053: astore_2
    //   1054: aload 4
    //   1056: astore_1
    //   1057: aload 5
    //   1059: astore 4
    //   1061: goto -513 -> 548
    //   1064: sipush 60536
    //   1067: istore 22
    //   1069: goto -211 -> 858
    //   1072: sipush 60480
    //   1075: istore 22
    //   1077: goto -290 -> 787
    //   1080: sipush 60481
    //   1083: istore 22
    //   1085: goto -369 -> 716
    //   1088: sipush 60482
    //   1091: istore 22
    //   1093: goto -448 -> 645
    //   1096: sipush 58535
    //   1099: istore 22
    //   1101: goto -527 -> 574
    //   1104: goto -677 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1107	0	this	ae
    //   0	1107	1	paramHttpEntity	org.apache.http.HttpEntity
    //   0	1107	2	paramBundle	android.os.Bundle
    //   0	1107	3	paramBoolean	boolean
    //   13	1047	4	localObject1	Object
    //   48	1010	5	localObject2	Object
    //   52	898	6	localObject3	Object
    //   37	1010	7	localObject4	Object
    //   19	1006	8	localObject5	Object
    //   22	981	9	localObject6	Object
    //   25	956	10	localObject7	Object
    //   28	931	11	localObject8	Object
    //   34	902	12	localObject9	Object
    //   16	526	13	localObject10	Object
    //   1	612	14	localObject11	Object
    //   4	680	15	localObject12	Object
    //   7	748	16	localObject13	Object
    //   10	816	17	localObject14	Object
    //   31	215	18	localObject15	Object
    //   44	386	19	arrayOfByte	byte[]
    //   196	62	20	localFile	File
    //   99	762	21	m	int
    //   285	815	22	n	int
    //   400	24	23	i1	int
    //   294	148	24	i2	int
    //   60	406	25	l1	long
    //   463	5	27	l2	long
    // Exception table:
    //   from	to	target	type
    //   316	321	350	java/io/IOException
    //   326	331	358	java/io/IOException
    //   503	508	511	java/io/IOException
    //   485	490	527	java/io/IOException
    //   54	62	540	java/io/FileNotFoundException
    //   70	79	540	java/io/FileNotFoundException
    //   87	101	540	java/io/FileNotFoundException
    //   109	117	540	java/io/FileNotFoundException
    //   125	135	540	java/io/FileNotFoundException
    //   143	151	540	java/io/FileNotFoundException
    //   159	198	540	java/io/FileNotFoundException
    //   206	214	540	java/io/FileNotFoundException
    //   222	231	540	java/io/FileNotFoundException
    //   239	245	540	java/io/FileNotFoundException
    //   253	265	540	java/io/FileNotFoundException
    //   582	586	589	java/io/IOException
    //   564	569	598	java/io/IOException
    //   54	62	611	java/net/SocketException
    //   70	79	611	java/net/SocketException
    //   87	101	611	java/net/SocketException
    //   109	117	611	java/net/SocketException
    //   125	135	611	java/net/SocketException
    //   143	151	611	java/net/SocketException
    //   159	198	611	java/net/SocketException
    //   206	214	611	java/net/SocketException
    //   222	231	611	java/net/SocketException
    //   239	245	611	java/net/SocketException
    //   253	265	611	java/net/SocketException
    //   653	657	660	java/io/IOException
    //   635	640	669	java/io/IOException
    //   54	62	682	java/net/SocketTimeoutException
    //   70	79	682	java/net/SocketTimeoutException
    //   87	101	682	java/net/SocketTimeoutException
    //   109	117	682	java/net/SocketTimeoutException
    //   125	135	682	java/net/SocketTimeoutException
    //   143	151	682	java/net/SocketTimeoutException
    //   159	198	682	java/net/SocketTimeoutException
    //   206	214	682	java/net/SocketTimeoutException
    //   222	231	682	java/net/SocketTimeoutException
    //   239	245	682	java/net/SocketTimeoutException
    //   253	265	682	java/net/SocketTimeoutException
    //   724	728	731	java/io/IOException
    //   706	711	740	java/io/IOException
    //   54	62	753	java/io/IOException
    //   70	79	753	java/io/IOException
    //   87	101	753	java/io/IOException
    //   109	117	753	java/io/IOException
    //   125	135	753	java/io/IOException
    //   143	151	753	java/io/IOException
    //   159	198	753	java/io/IOException
    //   206	214	753	java/io/IOException
    //   222	231	753	java/io/IOException
    //   239	245	753	java/io/IOException
    //   253	265	753	java/io/IOException
    //   795	799	802	java/io/IOException
    //   777	782	811	java/io/IOException
    //   54	62	824	java/lang/Exception
    //   70	79	824	java/lang/Exception
    //   87	101	824	java/lang/Exception
    //   109	117	824	java/lang/Exception
    //   125	135	824	java/lang/Exception
    //   143	151	824	java/lang/Exception
    //   159	198	824	java/lang/Exception
    //   206	214	824	java/lang/Exception
    //   222	231	824	java/lang/Exception
    //   239	245	824	java/lang/Exception
    //   253	265	824	java/lang/Exception
    //   866	870	873	java/io/IOException
    //   848	853	882	java/io/IOException
    //   54	62	895	finally
    //   70	79	895	finally
    //   87	101	895	finally
    //   109	117	895	finally
    //   125	135	895	finally
    //   143	151	895	finally
    //   159	198	895	finally
    //   206	214	895	finally
    //   222	231	895	finally
    //   239	245	895	finally
    //   253	265	895	finally
    //   555	559	895	finally
    //   626	630	895	finally
    //   697	701	895	finally
    //   768	772	895	finally
    //   839	843	895	finally
    //   901	906	918	java/io/IOException
    //   911	916	926	java/io/IOException
    //   269	284	934	finally
    //   339	347	934	finally
    //   287	296	946	finally
    //   302	307	946	finally
    //   366	402	946	finally
    //   409	423	946	finally
    //   427	437	946	finally
    //   447	452	946	finally
    //   457	465	946	finally
    //   269	284	954	java/lang/Exception
    //   339	347	954	java/lang/Exception
    //   287	296	965	java/lang/Exception
    //   302	307	965	java/lang/Exception
    //   366	402	965	java/lang/Exception
    //   409	423	965	java/lang/Exception
    //   427	437	965	java/lang/Exception
    //   447	452	965	java/lang/Exception
    //   457	465	965	java/lang/Exception
    //   269	284	976	java/io/IOException
    //   339	347	976	java/io/IOException
    //   287	296	987	java/io/IOException
    //   302	307	987	java/io/IOException
    //   366	402	987	java/io/IOException
    //   409	423	987	java/io/IOException
    //   427	437	987	java/io/IOException
    //   447	452	987	java/io/IOException
    //   457	465	987	java/io/IOException
    //   269	284	998	java/net/SocketTimeoutException
    //   339	347	998	java/net/SocketTimeoutException
    //   287	296	1009	java/net/SocketTimeoutException
    //   302	307	1009	java/net/SocketTimeoutException
    //   366	402	1009	java/net/SocketTimeoutException
    //   409	423	1009	java/net/SocketTimeoutException
    //   427	437	1009	java/net/SocketTimeoutException
    //   447	452	1009	java/net/SocketTimeoutException
    //   457	465	1009	java/net/SocketTimeoutException
    //   269	284	1020	java/net/SocketException
    //   339	347	1020	java/net/SocketException
    //   287	296	1031	java/net/SocketException
    //   302	307	1031	java/net/SocketException
    //   366	402	1031	java/net/SocketException
    //   409	423	1031	java/net/SocketException
    //   427	437	1031	java/net/SocketException
    //   447	452	1031	java/net/SocketException
    //   457	465	1031	java/net/SocketException
    //   269	284	1042	java/io/FileNotFoundException
    //   339	347	1042	java/io/FileNotFoundException
    //   287	296	1053	java/io/FileNotFoundException
    //   302	307	1053	java/io/FileNotFoundException
    //   366	402	1053	java/io/FileNotFoundException
    //   409	423	1053	java/io/FileNotFoundException
    //   427	437	1053	java/io/FileNotFoundException
    //   447	452	1053	java/io/FileNotFoundException
    //   457	465	1053	java/io/FileNotFoundException
  }
  
  /* Error */
  private int b(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 8
    //   18: sipush 58536
    //   21: istore 12
    //   23: new 99	java/io/File
    //   26: dup
    //   27: new 142	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   34: aload_0
    //   35: getfield 29	sm/ae:e	Ljava/lang/String;
    //   38: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   44: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: getfield 33	sm/ae:g	Ljava/lang/String;
    //   51: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual 160	java/io/File:exists	()Z
    //   65: ifeq +333 -> 398
    //   68: aload_0
    //   69: getfield 39	sm/ae:j	Z
    //   72: ifne +162 -> 234
    //   75: aload_0
    //   76: getfield 37	sm/ae:i	I
    //   79: iconst_1
    //   80: if_icmpne +154 -> 234
    //   83: aload_0
    //   84: getfield 45	sm/ae:c	Landroid/content/Context;
    //   87: aload_0
    //   88: getfield 35	sm/ae:h	Ljava/lang/String;
    //   91: iconst_1
    //   92: invokevirtual 215	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   95: astore_2
    //   96: aload_3
    //   97: astore 6
    //   99: aload 4
    //   101: astore 7
    //   103: aload_2
    //   104: astore 5
    //   106: new 217	java/io/FileInputStream
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: astore 4
    //   116: sipush 1024
    //   119: newarray <illegal type>
    //   121: astore 7
    //   123: aload 4
    //   125: aload 7
    //   127: invokevirtual 221	java/io/FileInputStream:read	([B)I
    //   130: istore 14
    //   132: iload 11
    //   134: istore 13
    //   136: aload 4
    //   138: astore 6
    //   140: aload_2
    //   141: astore 5
    //   143: iload 14
    //   145: iconst_m1
    //   146: if_icmpeq +263 -> 409
    //   149: aload_2
    //   150: aload 7
    //   152: iconst_0
    //   153: iload 14
    //   155: invokevirtual 203	java/io/FileOutputStream:write	([BII)V
    //   158: goto -35 -> 123
    //   161: astore 5
    //   163: aload 4
    //   165: astore 7
    //   167: aload 5
    //   169: astore 4
    //   171: aload 4
    //   173: invokevirtual 207	java/io/FileNotFoundException:printStackTrace	()V
    //   176: aload 7
    //   178: ifnull +655 -> 833
    //   181: aload 7
    //   183: invokevirtual 222	java/io/FileInputStream:close	()V
    //   186: sipush 58535
    //   189: istore 11
    //   191: aload_2
    //   192: ifnull +634 -> 826
    //   195: aload_2
    //   196: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   199: iload 11
    //   201: istore 12
    //   203: iload 12
    //   205: istore 11
    //   207: iload_1
    //   208: ifeq +23 -> 231
    //   211: iload 12
    //   213: istore 11
    //   215: aload_3
    //   216: invokevirtual 160	java/io/File:exists	()Z
    //   219: ifeq +12 -> 231
    //   222: aload_3
    //   223: invokevirtual 225	java/io/File:delete	()Z
    //   226: pop
    //   227: iload 12
    //   229: istore 11
    //   231: iload 11
    //   233: ireturn
    //   234: new 99	java/io/File
    //   237: dup
    //   238: new 142	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   245: aload_0
    //   246: getfield 31	sm/ae:f	Ljava/lang/String;
    //   249: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   255: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: getfield 35	sm/ae:h	Ljava/lang/String;
    //   262: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   271: astore_2
    //   272: aload_2
    //   273: invokevirtual 160	java/io/File:exists	()Z
    //   276: ifeq +20 -> 296
    //   279: aload_2
    //   280: invokevirtual 225	java/io/File:delete	()Z
    //   283: pop
    //   284: new 171	java/io/FileOutputStream
    //   287: dup
    //   288: aload_2
    //   289: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   292: astore_2
    //   293: goto -197 -> 96
    //   296: aload_2
    //   297: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   300: invokevirtual 166	java/io/File:mkdirs	()Z
    //   303: pop
    //   304: aload_2
    //   305: invokevirtual 169	java/io/File:createNewFile	()Z
    //   308: pop
    //   309: new 171	java/io/FileOutputStream
    //   312: dup
    //   313: aload_2
    //   314: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   317: astore_2
    //   318: goto -222 -> 96
    //   321: astore 4
    //   323: aconst_null
    //   324: astore_2
    //   325: aload 9
    //   327: astore 8
    //   329: aload_3
    //   330: astore 6
    //   332: aload 8
    //   334: astore 7
    //   336: aload_2
    //   337: astore 5
    //   339: aload 4
    //   341: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   344: aload 8
    //   346: ifnull +472 -> 818
    //   349: aload 8
    //   351: invokevirtual 222	java/io/FileInputStream:close	()V
    //   354: sipush 58480
    //   357: istore 11
    //   359: aload_2
    //   360: ifnull +451 -> 811
    //   363: aload_2
    //   364: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   367: iload 11
    //   369: istore 12
    //   371: iload 12
    //   373: istore 11
    //   375: iload_1
    //   376: ifeq -145 -> 231
    //   379: iload 12
    //   381: istore 11
    //   383: aload_3
    //   384: invokevirtual 160	java/io/File:exists	()Z
    //   387: ifeq -156 -> 231
    //   390: aload_3
    //   391: invokevirtual 225	java/io/File:delete	()Z
    //   394: pop
    //   395: iload 12
    //   397: ireturn
    //   398: aconst_null
    //   399: astore 6
    //   401: aconst_null
    //   402: astore 5
    //   404: sipush 58535
    //   407: istore 13
    //   409: iload 13
    //   411: istore 11
    //   413: aload 6
    //   415: ifnull +12 -> 427
    //   418: aload 6
    //   420: invokevirtual 222	java/io/FileInputStream:close	()V
    //   423: iload 13
    //   425: istore 11
    //   427: aload 5
    //   429: ifnull +412 -> 841
    //   432: aload 5
    //   434: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   437: iload 11
    //   439: istore 12
    //   441: iload 12
    //   443: istore 11
    //   445: iload_1
    //   446: ifeq -215 -> 231
    //   449: iload 12
    //   451: istore 11
    //   453: aload_3
    //   454: invokevirtual 160	java/io/File:exists	()Z
    //   457: ifeq -226 -> 231
    //   460: aload_3
    //   461: invokevirtual 225	java/io/File:delete	()Z
    //   464: pop
    //   465: iload 12
    //   467: ireturn
    //   468: astore_2
    //   469: aload_2
    //   470: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   473: sipush 58536
    //   476: istore 11
    //   478: goto -51 -> 427
    //   481: astore_2
    //   482: aload_2
    //   483: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   486: goto -45 -> 441
    //   489: astore 4
    //   491: aload 4
    //   493: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   496: sipush 58536
    //   499: istore 11
    //   501: goto -310 -> 191
    //   504: astore_2
    //   505: aload_2
    //   506: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   509: goto -306 -> 203
    //   512: astore 4
    //   514: aload 4
    //   516: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   519: sipush 58536
    //   522: istore 11
    //   524: goto -165 -> 359
    //   527: astore_2
    //   528: aload_2
    //   529: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   532: goto -161 -> 371
    //   535: astore 4
    //   537: aconst_null
    //   538: astore_3
    //   539: aconst_null
    //   540: astore_2
    //   541: aload 10
    //   543: astore 8
    //   545: aload_3
    //   546: astore 6
    //   548: aload 8
    //   550: astore 7
    //   552: aload_2
    //   553: astore 5
    //   555: aload 4
    //   557: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   560: aload 8
    //   562: ifnull +8 -> 570
    //   565: aload 8
    //   567: invokevirtual 222	java/io/FileInputStream:close	()V
    //   570: aload_2
    //   571: ifnull +7 -> 578
    //   574: aload_2
    //   575: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   578: iload 12
    //   580: istore 11
    //   582: iload_1
    //   583: ifeq -352 -> 231
    //   586: iload 12
    //   588: istore 11
    //   590: aload_3
    //   591: invokevirtual 160	java/io/File:exists	()Z
    //   594: ifeq -363 -> 231
    //   597: aload_3
    //   598: invokevirtual 225	java/io/File:delete	()Z
    //   601: pop
    //   602: sipush 58536
    //   605: ireturn
    //   606: astore 4
    //   608: aload 4
    //   610: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   613: goto -43 -> 570
    //   616: astore_2
    //   617: aload_2
    //   618: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   621: goto -43 -> 578
    //   624: astore 4
    //   626: aconst_null
    //   627: astore_3
    //   628: aconst_null
    //   629: astore_2
    //   630: aload 7
    //   632: ifnull +8 -> 640
    //   635: aload 7
    //   637: invokevirtual 222	java/io/FileInputStream:close	()V
    //   640: aload_2
    //   641: ifnull +7 -> 648
    //   644: aload_2
    //   645: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   648: iload_1
    //   649: ifeq +15 -> 664
    //   652: aload_3
    //   653: invokevirtual 160	java/io/File:exists	()Z
    //   656: ifeq +8 -> 664
    //   659: aload_3
    //   660: invokevirtual 225	java/io/File:delete	()Z
    //   663: pop
    //   664: aload 4
    //   666: athrow
    //   667: astore 5
    //   669: aload 5
    //   671: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   674: goto -34 -> 640
    //   677: astore_2
    //   678: aload_2
    //   679: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   682: goto -34 -> 648
    //   685: astore 4
    //   687: aconst_null
    //   688: astore_2
    //   689: goto -59 -> 630
    //   692: astore 4
    //   694: aload 6
    //   696: astore_3
    //   697: aload 5
    //   699: astore_2
    //   700: goto -70 -> 630
    //   703: astore 5
    //   705: aload 4
    //   707: astore 7
    //   709: aload 5
    //   711: astore 4
    //   713: goto -83 -> 630
    //   716: astore 4
    //   718: goto -88 -> 630
    //   721: astore 4
    //   723: aconst_null
    //   724: astore_2
    //   725: aload 10
    //   727: astore 8
    //   729: goto -184 -> 545
    //   732: astore 4
    //   734: aload 10
    //   736: astore 8
    //   738: goto -193 -> 545
    //   741: astore 5
    //   743: aload 4
    //   745: astore 8
    //   747: aload 5
    //   749: astore 4
    //   751: goto -206 -> 545
    //   754: astore 4
    //   756: aconst_null
    //   757: astore_3
    //   758: aconst_null
    //   759: astore_2
    //   760: aload 9
    //   762: astore 8
    //   764: goto -435 -> 329
    //   767: astore 4
    //   769: aload 9
    //   771: astore 8
    //   773: goto -444 -> 329
    //   776: astore 5
    //   778: aload 4
    //   780: astore 8
    //   782: aload 5
    //   784: astore 4
    //   786: goto -457 -> 329
    //   789: astore 4
    //   791: aconst_null
    //   792: astore_3
    //   793: aconst_null
    //   794: astore_2
    //   795: aload 8
    //   797: astore 7
    //   799: goto -628 -> 171
    //   802: astore 4
    //   804: aload 8
    //   806: astore 7
    //   808: goto -637 -> 171
    //   811: iload 11
    //   813: istore 12
    //   815: goto -444 -> 371
    //   818: sipush 58480
    //   821: istore 11
    //   823: goto -464 -> 359
    //   826: iload 11
    //   828: istore 12
    //   830: goto -627 -> 203
    //   833: sipush 58535
    //   836: istore 11
    //   838: goto -647 -> 191
    //   841: iload 11
    //   843: istore 12
    //   845: goto -404 -> 441
    //   848: astore 4
    //   850: aconst_null
    //   851: astore_2
    //   852: aload 8
    //   854: astore 7
    //   856: goto -685 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	859	0	this	ae
    //   0	859	1	paramBoolean	boolean
    //   95	269	2	localObject1	Object
    //   468	2	2	localIOException1	java.io.IOException
    //   481	2	2	localIOException2	java.io.IOException
    //   504	2	2	localIOException3	java.io.IOException
    //   527	2	2	localIOException4	java.io.IOException
    //   540	35	2	localObject2	Object
    //   616	2	2	localIOException5	java.io.IOException
    //   629	16	2	localObject3	Object
    //   677	2	2	localIOException6	java.io.IOException
    //   688	164	2	localObject4	Object
    //   60	733	3	localObject5	Object
    //   13	159	4	localObject6	Object
    //   321	19	4	localIOException7	java.io.IOException
    //   489	3	4	localIOException8	java.io.IOException
    //   512	3	4	localIOException9	java.io.IOException
    //   535	21	4	localException1	Exception
    //   606	3	4	localIOException10	java.io.IOException
    //   624	41	4	localObject7	Object
    //   685	1	4	localObject8	Object
    //   692	14	4	localObject9	Object
    //   711	1	4	localObject10	Object
    //   716	1	4	localObject11	Object
    //   721	1	4	localException2	Exception
    //   732	12	4	localException3	Exception
    //   749	1	4	localObject12	Object
    //   754	1	4	localIOException11	java.io.IOException
    //   767	12	4	localIOException12	java.io.IOException
    //   784	1	4	localObject13	Object
    //   789	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   802	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   848	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   104	38	5	localObject14	Object
    //   161	7	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   337	217	5	localObject15	Object
    //   667	31	5	localIOException13	java.io.IOException
    //   703	7	5	localObject16	Object
    //   741	7	5	localException4	Exception
    //   776	7	5	localIOException14	java.io.IOException
    //   97	598	6	localObject17	Object
    //   10	845	7	localObject18	Object
    //   16	837	8	localObject19	Object
    //   4	766	9	localObject20	Object
    //   7	728	10	localObject21	Object
    //   1	841	11	m	int
    //   21	823	12	n	int
    //   134	290	13	i1	int
    //   130	24	14	i2	int
    // Exception table:
    //   from	to	target	type
    //   116	123	161	java/io/FileNotFoundException
    //   123	132	161	java/io/FileNotFoundException
    //   149	158	161	java/io/FileNotFoundException
    //   61	96	321	java/io/IOException
    //   234	293	321	java/io/IOException
    //   296	318	321	java/io/IOException
    //   418	423	468	java/io/IOException
    //   432	437	481	java/io/IOException
    //   181	186	489	java/io/IOException
    //   195	199	504	java/io/IOException
    //   349	354	512	java/io/IOException
    //   363	367	527	java/io/IOException
    //   23	61	535	java/lang/Exception
    //   565	570	606	java/io/IOException
    //   574	578	616	java/io/IOException
    //   23	61	624	finally
    //   635	640	667	java/io/IOException
    //   644	648	677	java/io/IOException
    //   61	96	685	finally
    //   234	293	685	finally
    //   296	318	685	finally
    //   106	116	692	finally
    //   339	344	692	finally
    //   555	560	692	finally
    //   116	123	703	finally
    //   123	132	703	finally
    //   149	158	703	finally
    //   171	176	716	finally
    //   61	96	721	java/lang/Exception
    //   234	293	721	java/lang/Exception
    //   296	318	721	java/lang/Exception
    //   106	116	732	java/lang/Exception
    //   116	123	741	java/lang/Exception
    //   123	132	741	java/lang/Exception
    //   149	158	741	java/lang/Exception
    //   23	61	754	java/io/IOException
    //   106	116	767	java/io/IOException
    //   116	123	776	java/io/IOException
    //   123	132	776	java/io/IOException
    //   149	158	776	java/io/IOException
    //   23	61	789	java/io/FileNotFoundException
    //   106	116	802	java/io/FileNotFoundException
    //   61	96	848	java/io/FileNotFoundException
    //   234	293	848	java/io/FileNotFoundException
    //   296	318	848	java/io/FileNotFoundException
  }
  
  private int c(String paramString)
  {
    localObject = null;
    try
    {
      paramString = new URI(paramString);
      m = 64536;
    }
    catch (URISyntaxException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int m = 64483;
        paramString = (String)localObject;
      }
    }
    if (paramString != null)
    {
      this.d.setURI(paramString);
      m = 0;
    }
    return m;
  }
  
  /* Error */
  public int a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 62536
    //   3: istore 10
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 7
    //   14: new 129	android/os/Bundle
    //   17: dup
    //   18: invokespecial 241	android/os/Bundle:<init>	()V
    //   21: astore 8
    //   23: aload 6
    //   25: astore 4
    //   27: iload 10
    //   29: istore 9
    //   31: aload_0
    //   32: invokevirtual 244	sm/ae:a	()Lorg/apache/http/client/HttpClient;
    //   35: astore_3
    //   36: aload 6
    //   38: astore 4
    //   40: aload_3
    //   41: astore 5
    //   43: iload 10
    //   45: istore 9
    //   47: aload_0
    //   48: aload_1
    //   49: invokespecial 246	sm/ae:c	(Ljava/lang/String;)I
    //   52: istore 10
    //   54: iload 10
    //   56: ifeq +61 -> 117
    //   59: iload 10
    //   61: istore 9
    //   63: aload 7
    //   65: astore_1
    //   66: aload_3
    //   67: ifnull +14 -> 81
    //   70: aload_3
    //   71: invokeinterface 252 1 0
    //   76: invokeinterface 257 1 0
    //   81: aload_1
    //   82: ifnull +3 -> 85
    //   85: iload 9
    //   87: ifeq +27 -> 114
    //   90: iload 9
    //   92: bipush -7
    //   94: if_icmpeq +20 -> 114
    //   97: aload 8
    //   99: ldc_w 259
    //   102: iload 9
    //   104: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   107: aload_0
    //   108: iconst_1
    //   109: aload 8
    //   111: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   114: iload 9
    //   116: ireturn
    //   117: aload 6
    //   119: astore 4
    //   121: aload_3
    //   122: astore 5
    //   124: iload 10
    //   126: istore 9
    //   128: aload_0
    //   129: getfield 41	sm/ae:k	Z
    //   132: ifeq +14 -> 146
    //   135: sipush 62533
    //   138: istore 9
    //   140: aload 7
    //   142: astore_1
    //   143: goto -77 -> 66
    //   146: aload 6
    //   148: astore 4
    //   150: aload_3
    //   151: astore 5
    //   153: iload 10
    //   155: istore 9
    //   157: aload_0
    //   158: getfield 27	sm/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   161: invokevirtual 263	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   164: ifnonnull +14 -> 178
    //   167: sipush 62483
    //   170: istore 9
    //   172: aload 7
    //   174: astore_1
    //   175: goto -109 -> 66
    //   178: aload 6
    //   180: astore 4
    //   182: aload_3
    //   183: astore 5
    //   185: iload 10
    //   187: istore 9
    //   189: aload_1
    //   190: invokestatic 268	sm/az:c	(Ljava/lang/String;)Ljava/lang/String;
    //   193: astore_1
    //   194: aload 6
    //   196: astore 4
    //   198: aload_3
    //   199: astore 5
    //   201: iload 10
    //   203: istore 9
    //   205: aload_0
    //   206: new 142	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   213: aload_1
    //   214: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 270
    //   220: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: putfield 33	sm/ae:g	Ljava/lang/String;
    //   229: aload 6
    //   231: astore 4
    //   233: aload_3
    //   234: astore 5
    //   236: iload 10
    //   238: istore 9
    //   240: aload_0
    //   241: getfield 35	sm/ae:h	Ljava/lang/String;
    //   244: ifnonnull +19 -> 263
    //   247: aload 6
    //   249: astore 4
    //   251: aload_3
    //   252: astore 5
    //   254: iload 10
    //   256: istore 9
    //   258: aload_0
    //   259: aload_1
    //   260: putfield 35	sm/ae:h	Ljava/lang/String;
    //   263: aload 6
    //   265: astore 4
    //   267: aload_3
    //   268: astore 5
    //   270: iload 10
    //   272: istore 9
    //   274: new 99	java/io/File
    //   277: dup
    //   278: new 142	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   285: aload_0
    //   286: getfield 29	sm/ae:e	Ljava/lang/String;
    //   289: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   295: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_0
    //   299: getfield 33	sm/ae:g	Ljava/lang/String;
    //   302: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   311: astore_1
    //   312: aload 6
    //   314: astore 4
    //   316: aload_3
    //   317: astore 5
    //   319: iload 10
    //   321: istore 9
    //   323: aload_1
    //   324: invokevirtual 160	java/io/File:exists	()Z
    //   327: ifeq +72 -> 399
    //   330: aload 6
    //   332: astore 4
    //   334: aload_3
    //   335: astore 5
    //   337: iload 10
    //   339: istore 9
    //   341: aload_0
    //   342: aload_1
    //   343: invokevirtual 273	java/io/File:length	()J
    //   346: putfield 43	sm/ae:l	J
    //   349: aload 6
    //   351: astore 4
    //   353: aload_3
    //   354: astore 5
    //   356: iload 10
    //   358: istore 9
    //   360: aload_0
    //   361: getfield 27	sm/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   364: ldc_w 275
    //   367: new 142	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   374: ldc_w 277
    //   377: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_0
    //   381: getfield 43	sm/ae:l	J
    //   384: invokevirtual 280	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   387: ldc_w 282
    //   390: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokevirtual 286	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload 6
    //   401: astore 4
    //   403: aload_3
    //   404: astore 5
    //   406: iload 10
    //   408: istore 9
    //   410: aload_3
    //   411: aload_0
    //   412: getfield 27	sm/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   415: invokeinterface 290 2 0
    //   420: astore_1
    //   421: aload_1
    //   422: astore 4
    //   424: aload_3
    //   425: astore 5
    //   427: iload 10
    //   429: istore 9
    //   431: aload_1
    //   432: invokeinterface 296 1 0
    //   437: invokeinterface 301 1 0
    //   442: istore 11
    //   444: iload 11
    //   446: sipush 200
    //   449: if_icmpeq +22 -> 471
    //   452: iload 11
    //   454: sipush 206
    //   457: if_icmpeq +14 -> 471
    //   460: sipush 62536
    //   463: iload 11
    //   465: isub
    //   466: istore 9
    //   468: goto -402 -> 66
    //   471: aload_1
    //   472: astore 4
    //   474: aload_3
    //   475: astore 5
    //   477: iload 10
    //   479: istore 9
    //   481: aload_0
    //   482: getfield 41	sm/ae:k	Z
    //   485: ifeq +11 -> 496
    //   488: sipush 62533
    //   491: istore 9
    //   493: goto -427 -> 66
    //   496: aload_1
    //   497: astore 4
    //   499: aload_3
    //   500: astore 5
    //   502: iload 10
    //   504: istore 9
    //   506: aload_1
    //   507: invokeinterface 305 1 0
    //   512: astore 6
    //   514: aload 6
    //   516: ifnonnull +11 -> 527
    //   519: sipush 61536
    //   522: istore 9
    //   524: goto -458 -> 66
    //   527: aload_1
    //   528: astore 4
    //   530: aload_3
    //   531: astore 5
    //   533: iload 10
    //   535: istore 9
    //   537: aload_0
    //   538: aload 6
    //   540: aload 8
    //   542: iload_2
    //   543: invokespecial 307	sm/ae:a	(Lorg/apache/http/HttpEntity;Landroid/os/Bundle;Z)I
    //   546: istore 10
    //   548: iload 10
    //   550: ifeq +17 -> 567
    //   553: iload 10
    //   555: bipush -7
    //   557: if_icmpne +563 -> 1120
    //   560: iload 10
    //   562: istore 9
    //   564: goto -498 -> 66
    //   567: aload_1
    //   568: astore 4
    //   570: aload_3
    //   571: astore 5
    //   573: iload 10
    //   575: istore 9
    //   577: aload_0
    //   578: iconst_1
    //   579: invokespecial 309	sm/ae:b	(Z)I
    //   582: istore 10
    //   584: iload 10
    //   586: ifeq +10 -> 596
    //   589: iload 10
    //   591: istore 9
    //   593: goto -527 -> 66
    //   596: iconst_0
    //   597: istore 9
    //   599: goto -533 -> 66
    //   602: astore 6
    //   604: aconst_null
    //   605: astore 5
    //   607: aconst_null
    //   608: astore 4
    //   610: sipush 62485
    //   613: istore 9
    //   615: aload 4
    //   617: astore_3
    //   618: aload 5
    //   620: astore_1
    //   621: aload 6
    //   623: invokevirtual 310	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   626: aload 5
    //   628: ifnull +15 -> 643
    //   631: aload 5
    //   633: invokeinterface 252 1 0
    //   638: invokeinterface 257 1 0
    //   643: aload 4
    //   645: ifnull +3 -> 648
    //   648: aload 8
    //   650: ldc_w 259
    //   653: sipush 62485
    //   656: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   659: aload_0
    //   660: iconst_1
    //   661: aload 8
    //   663: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   666: sipush 62485
    //   669: ireturn
    //   670: astore 6
    //   672: aconst_null
    //   673: astore 5
    //   675: aconst_null
    //   676: astore 4
    //   678: sipush 62482
    //   681: istore 9
    //   683: aload 4
    //   685: astore_3
    //   686: aload 5
    //   688: astore_1
    //   689: aload 6
    //   691: invokevirtual 208	java/net/SocketException:printStackTrace	()V
    //   694: aload 5
    //   696: ifnull +15 -> 711
    //   699: aload 5
    //   701: invokeinterface 252 1 0
    //   706: invokeinterface 257 1 0
    //   711: aload 4
    //   713: ifnull +3 -> 716
    //   716: aload 8
    //   718: ldc_w 259
    //   721: sipush 62482
    //   724: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   727: aload_0
    //   728: iconst_1
    //   729: aload 8
    //   731: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   734: sipush 62482
    //   737: ireturn
    //   738: astore 6
    //   740: aconst_null
    //   741: astore 5
    //   743: aconst_null
    //   744: astore 4
    //   746: sipush 62481
    //   749: istore 9
    //   751: aload 4
    //   753: astore_3
    //   754: aload 5
    //   756: astore_1
    //   757: aload 6
    //   759: invokevirtual 209	java/net/SocketTimeoutException:printStackTrace	()V
    //   762: aload 5
    //   764: ifnull +15 -> 779
    //   767: aload 5
    //   769: invokeinterface 252 1 0
    //   774: invokeinterface 257 1 0
    //   779: aload 4
    //   781: ifnull +3 -> 784
    //   784: aload 8
    //   786: ldc_w 259
    //   789: sipush 62481
    //   792: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   795: aload_0
    //   796: iconst_1
    //   797: aload 8
    //   799: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   802: sipush 62481
    //   805: ireturn
    //   806: astore 6
    //   808: aconst_null
    //   809: astore 5
    //   811: aconst_null
    //   812: astore 4
    //   814: sipush 62480
    //   817: istore 9
    //   819: aload 4
    //   821: astore_3
    //   822: aload 5
    //   824: astore_1
    //   825: aload 6
    //   827: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   830: aload 5
    //   832: ifnull +15 -> 847
    //   835: aload 5
    //   837: invokeinterface 252 1 0
    //   842: invokeinterface 257 1 0
    //   847: aload 4
    //   849: ifnull +3 -> 852
    //   852: aload 8
    //   854: ldc_w 259
    //   857: sipush 62480
    //   860: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   863: aload_0
    //   864: iconst_1
    //   865: aload 8
    //   867: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   870: sipush 62480
    //   873: ireturn
    //   874: astore 6
    //   876: aconst_null
    //   877: astore 5
    //   879: aconst_null
    //   880: astore 4
    //   882: sipush 62536
    //   885: istore 9
    //   887: aload 4
    //   889: astore_3
    //   890: aload 5
    //   892: astore_1
    //   893: aload 6
    //   895: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   898: aload 5
    //   900: ifnull +15 -> 915
    //   903: aload 5
    //   905: invokeinterface 252 1 0
    //   910: invokeinterface 257 1 0
    //   915: aload 4
    //   917: ifnull +3 -> 920
    //   920: aload 8
    //   922: ldc_w 259
    //   925: sipush 62536
    //   928: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   931: aload_0
    //   932: iconst_1
    //   933: aload 8
    //   935: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   938: sipush 62536
    //   941: ireturn
    //   942: astore 6
    //   944: aload 5
    //   946: astore_1
    //   947: aload 4
    //   949: astore_3
    //   950: aload 6
    //   952: astore 4
    //   954: aload_1
    //   955: ifnull +14 -> 969
    //   958: aload_1
    //   959: invokeinterface 252 1 0
    //   964: invokeinterface 257 1 0
    //   969: aload_3
    //   970: ifnull +3 -> 973
    //   973: iload 9
    //   975: ifeq +27 -> 1002
    //   978: iload 9
    //   980: bipush -7
    //   982: if_icmpeq +20 -> 1002
    //   985: aload 8
    //   987: ldc_w 259
    //   990: iload 9
    //   992: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   995: aload_0
    //   996: iconst_1
    //   997: aload 8
    //   999: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   1002: aload 4
    //   1004: athrow
    //   1005: astore 4
    //   1007: goto -53 -> 954
    //   1010: astore 6
    //   1012: aconst_null
    //   1013: astore 4
    //   1015: aload_3
    //   1016: astore 5
    //   1018: goto -136 -> 882
    //   1021: astore 6
    //   1023: aload_1
    //   1024: astore 4
    //   1026: aload_3
    //   1027: astore 5
    //   1029: goto -147 -> 882
    //   1032: astore 6
    //   1034: aconst_null
    //   1035: astore 4
    //   1037: aload_3
    //   1038: astore 5
    //   1040: goto -226 -> 814
    //   1043: astore 6
    //   1045: aload_1
    //   1046: astore 4
    //   1048: aload_3
    //   1049: astore 5
    //   1051: goto -237 -> 814
    //   1054: astore 6
    //   1056: aconst_null
    //   1057: astore 4
    //   1059: aload_3
    //   1060: astore 5
    //   1062: goto -316 -> 746
    //   1065: astore 6
    //   1067: aload_1
    //   1068: astore 4
    //   1070: aload_3
    //   1071: astore 5
    //   1073: goto -327 -> 746
    //   1076: astore 6
    //   1078: aconst_null
    //   1079: astore 4
    //   1081: aload_3
    //   1082: astore 5
    //   1084: goto -406 -> 678
    //   1087: astore 6
    //   1089: aload_1
    //   1090: astore 4
    //   1092: aload_3
    //   1093: astore 5
    //   1095: goto -417 -> 678
    //   1098: astore 6
    //   1100: aconst_null
    //   1101: astore 4
    //   1103: aload_3
    //   1104: astore 5
    //   1106: goto -496 -> 610
    //   1109: astore 6
    //   1111: aload_1
    //   1112: astore 4
    //   1114: aload_3
    //   1115: astore 5
    //   1117: goto -507 -> 610
    //   1120: iload 10
    //   1122: istore 9
    //   1124: goto -1058 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1127	0	this	ae
    //   0	1127	1	paramString	String
    //   0	1127	2	paramBoolean	boolean
    //   35	1080	3	localObject1	Object
    //   25	978	4	localObject2	Object
    //   1005	1	4	localObject3	Object
    //   1013	100	4	str	String
    //   6	1110	5	localObject4	Object
    //   9	530	6	localHttpEntity	org.apache.http.HttpEntity
    //   602	20	6	localClientProtocolException1	org.apache.http.client.ClientProtocolException
    //   670	20	6	localSocketException1	java.net.SocketException
    //   738	20	6	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   806	20	6	localIOException1	java.io.IOException
    //   874	20	6	localException1	Exception
    //   942	9	6	localObject5	Object
    //   1010	1	6	localException2	Exception
    //   1021	1	6	localException3	Exception
    //   1032	1	6	localIOException2	java.io.IOException
    //   1043	1	6	localIOException3	java.io.IOException
    //   1054	1	6	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1065	1	6	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1076	1	6	localSocketException2	java.net.SocketException
    //   1087	1	6	localSocketException3	java.net.SocketException
    //   1098	1	6	localClientProtocolException2	org.apache.http.client.ClientProtocolException
    //   1109	1	6	localClientProtocolException3	org.apache.http.client.ClientProtocolException
    //   12	161	7	localObject6	Object
    //   21	977	8	localBundle	android.os.Bundle
    //   29	1094	9	m	int
    //   3	1118	10	n	int
    //   442	24	11	i1	int
    // Exception table:
    //   from	to	target	type
    //   31	36	602	org/apache/http/client/ClientProtocolException
    //   31	36	670	java/net/SocketException
    //   31	36	738	java/net/SocketTimeoutException
    //   31	36	806	java/io/IOException
    //   31	36	874	java/lang/Exception
    //   31	36	942	finally
    //   47	54	942	finally
    //   128	135	942	finally
    //   157	167	942	finally
    //   189	194	942	finally
    //   205	229	942	finally
    //   240	247	942	finally
    //   258	263	942	finally
    //   274	312	942	finally
    //   323	330	942	finally
    //   341	349	942	finally
    //   360	399	942	finally
    //   410	421	942	finally
    //   431	444	942	finally
    //   481	488	942	finally
    //   506	514	942	finally
    //   537	548	942	finally
    //   577	584	942	finally
    //   621	626	1005	finally
    //   689	694	1005	finally
    //   757	762	1005	finally
    //   825	830	1005	finally
    //   893	898	1005	finally
    //   47	54	1010	java/lang/Exception
    //   128	135	1010	java/lang/Exception
    //   157	167	1010	java/lang/Exception
    //   189	194	1010	java/lang/Exception
    //   205	229	1010	java/lang/Exception
    //   240	247	1010	java/lang/Exception
    //   258	263	1010	java/lang/Exception
    //   274	312	1010	java/lang/Exception
    //   323	330	1010	java/lang/Exception
    //   341	349	1010	java/lang/Exception
    //   360	399	1010	java/lang/Exception
    //   410	421	1010	java/lang/Exception
    //   431	444	1021	java/lang/Exception
    //   481	488	1021	java/lang/Exception
    //   506	514	1021	java/lang/Exception
    //   537	548	1021	java/lang/Exception
    //   577	584	1021	java/lang/Exception
    //   47	54	1032	java/io/IOException
    //   128	135	1032	java/io/IOException
    //   157	167	1032	java/io/IOException
    //   189	194	1032	java/io/IOException
    //   205	229	1032	java/io/IOException
    //   240	247	1032	java/io/IOException
    //   258	263	1032	java/io/IOException
    //   274	312	1032	java/io/IOException
    //   323	330	1032	java/io/IOException
    //   341	349	1032	java/io/IOException
    //   360	399	1032	java/io/IOException
    //   410	421	1032	java/io/IOException
    //   431	444	1043	java/io/IOException
    //   481	488	1043	java/io/IOException
    //   506	514	1043	java/io/IOException
    //   537	548	1043	java/io/IOException
    //   577	584	1043	java/io/IOException
    //   47	54	1054	java/net/SocketTimeoutException
    //   128	135	1054	java/net/SocketTimeoutException
    //   157	167	1054	java/net/SocketTimeoutException
    //   189	194	1054	java/net/SocketTimeoutException
    //   205	229	1054	java/net/SocketTimeoutException
    //   240	247	1054	java/net/SocketTimeoutException
    //   258	263	1054	java/net/SocketTimeoutException
    //   274	312	1054	java/net/SocketTimeoutException
    //   323	330	1054	java/net/SocketTimeoutException
    //   341	349	1054	java/net/SocketTimeoutException
    //   360	399	1054	java/net/SocketTimeoutException
    //   410	421	1054	java/net/SocketTimeoutException
    //   431	444	1065	java/net/SocketTimeoutException
    //   481	488	1065	java/net/SocketTimeoutException
    //   506	514	1065	java/net/SocketTimeoutException
    //   537	548	1065	java/net/SocketTimeoutException
    //   577	584	1065	java/net/SocketTimeoutException
    //   47	54	1076	java/net/SocketException
    //   128	135	1076	java/net/SocketException
    //   157	167	1076	java/net/SocketException
    //   189	194	1076	java/net/SocketException
    //   205	229	1076	java/net/SocketException
    //   240	247	1076	java/net/SocketException
    //   258	263	1076	java/net/SocketException
    //   274	312	1076	java/net/SocketException
    //   323	330	1076	java/net/SocketException
    //   341	349	1076	java/net/SocketException
    //   360	399	1076	java/net/SocketException
    //   410	421	1076	java/net/SocketException
    //   431	444	1087	java/net/SocketException
    //   481	488	1087	java/net/SocketException
    //   506	514	1087	java/net/SocketException
    //   537	548	1087	java/net/SocketException
    //   577	584	1087	java/net/SocketException
    //   47	54	1098	org/apache/http/client/ClientProtocolException
    //   128	135	1098	org/apache/http/client/ClientProtocolException
    //   157	167	1098	org/apache/http/client/ClientProtocolException
    //   189	194	1098	org/apache/http/client/ClientProtocolException
    //   205	229	1098	org/apache/http/client/ClientProtocolException
    //   240	247	1098	org/apache/http/client/ClientProtocolException
    //   258	263	1098	org/apache/http/client/ClientProtocolException
    //   274	312	1098	org/apache/http/client/ClientProtocolException
    //   323	330	1098	org/apache/http/client/ClientProtocolException
    //   341	349	1098	org/apache/http/client/ClientProtocolException
    //   360	399	1098	org/apache/http/client/ClientProtocolException
    //   410	421	1098	org/apache/http/client/ClientProtocolException
    //   431	444	1109	org/apache/http/client/ClientProtocolException
    //   481	488	1109	org/apache/http/client/ClientProtocolException
    //   506	514	1109	org/apache/http/client/ClientProtocolException
    //   537	548	1109	org/apache/http/client/ClientProtocolException
    //   577	584	1109	org/apache/http/client/ClientProtocolException
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public String b()
  {
    return this.f + File.separator + this.h;
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */