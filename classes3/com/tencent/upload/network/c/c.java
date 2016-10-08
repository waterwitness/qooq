package com.tencent.upload.network.c;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.b.m;
import com.tencent.upload.uinterface.IUploadEnv;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  implements com.tencent.upload.network.base.d, a
{
  private static final AtomicInteger q = new AtomicInteger(0);
  private com.tencent.upload.network.base.a a;
  private m b;
  private final WeakReference<b> c;
  private ByteBuffer d;
  private volatile int e;
  private com.tencent.upload.network.a.b f;
  private int g;
  private final int h;
  private m i;
  private String j;
  private com.tencent.upload.common.c k;
  private String l;
  private LinkedList<com.tencent.upload.network.a.d> m;
  private SparseArray<a> n;
  private SparseArray<a> o;
  private final int p = hashCode();
  
  public c(boolean paramBoolean, Looper paramLooper, b paramb)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.h = i1;
      this.k = new com.tencent.upload.common.c(paramLooper);
      this.d = ByteBuffer.allocate(128);
      this.m = new LinkedList();
      this.n = new SparseArray();
      this.o = new SparseArray();
      this.c = new WeakReference(paramb);
      b(0);
      return;
    }
  }
  
  private void a(com.tencent.upload.network.a.a parama)
  {
    com.tencent.upload.a.b.b("Session", this.p + " doHandleHandshake");
    if (this.f != null)
    {
      this.f.onResponse(this, parama);
      this.f = null;
      this.g = 0;
    }
    do
    {
      return;
      parama = (b)this.c.get();
    } while (parama == null);
    parama.a(this, 1, false);
  }
  
  private void a(com.tencent.upload.network.base.d paramd, int paramInt, String paramString)
  {
    boolean bool = false;
    if (paramd != this.a) {}
    do
    {
      do
      {
        do
        {
          return;
          com.tencent.upload.a.b.b("Session", this.p + " doError: sessionError:" + paramInt);
          if (this.e != 2) {
            break;
          }
          paramd = (b)this.c.get();
        } while (paramd == null);
        paramd.a(this, paramInt, paramString);
        return;
        if (this.e != 1) {
          break;
        }
        if (this.f != null)
        {
          this.f.onError(this, paramInt, paramString, false);
          this.f = null;
          return;
        }
        paramd = (b)this.c.get();
      } while (paramd == null);
      if (paramInt == 35000) {
        bool = true;
      }
      paramd.a(this, 1, bool);
      return;
    } while (this.e != 0);
    com.tencent.upload.a.b.d("Session", "doError at NO_CONNECTION!");
  }
  
  private void a(a parama, int paramInt)
  {
    if (this.a.hashCode() == parama.d) {}
    for (com.tencent.upload.network.base.a locala = this.a;; locala = null)
    {
      if (locala == null)
      {
        com.tencent.upload.a.b.e("Session", this.p + " doSendRequest no connection, actSeq:" + parama.a.f() + " sendSeq:" + paramInt + " reqSeq:" + parama.a.f());
        parama.d = 0;
        a(null, 31000, "doSendRequest has no connection");
        return;
      }
      b localb = new b((byte)0);
      if (parama.a.c()) {
        a(parama, localb, true);
      }
      while (localb.a != 0)
      {
        com.tencent.upload.a.b.e("Session", this.p + " doSendRequest retrieveResult:" + localb.a + " actSeq:" + parama.a.f() + " reqSeq:" + parama.a.h() + " sendSeq:" + paramInt);
        this.n.delete(paramInt);
        a(locala, localb.a, localb.b);
        return;
        a(parama, localb, false);
      }
      int i3 = localb.c.length;
      boolean bool = com.tencent.upload.common.f.e().isMobile();
      if (bool) {}
      for (int i1 = 120000;; i1 = 60000)
      {
        if (bool) {}
        for (int i2 = 5;; i2 = 20)
        {
          i2 = i3 / i2;
          bool = locala.a(localb.c, paramInt, i2 + i1);
          if (bool) {
            break;
          }
          com.tencent.upload.a.b.e("Session", this.p + " doSendRequest sendAsync:" + bool);
          this.n.delete(paramInt);
          a(locala, 30200, "doSendRequest sendAsync false");
          return;
        }
        locala.c();
        if (localb.e) {
          parama.e = true;
        }
        parama.b += localb.d;
        bool = parama.a();
        com.tencent.upload.a.b.b("Session", this.p + " doSendRequest:" + bool + " sendSeq:" + paramInt + " actSeq:" + parama.a.f() + " reqSeq:" + parama.a.h() + " cmd:" + parama.a.g() + " HeadS:" + parama.c + " fileS:" + parama.b + " totalFileS:" + parama.a.e());
        return;
      }
    }
  }
  
  /* Error */
  private static void a(a parama, b paramb, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   5: aload_1
    //   6: aconst_null
    //   7: putfield 216	com/tencent/upload/network/c/c$b:c	[B
    //   10: aload_0
    //   11: getfield 177	com/tencent/upload/network/c/c$a:a	Lcom/tencent/upload/network/a/d;
    //   14: invokeinterface 274 1 0
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 4
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 177	com/tencent/upload/network/c/c$a:a	Lcom/tencent/upload/network/a/d;
    //   30: invokeinterface 266 1 0
    //   35: istore 8
    //   37: invokestatic 279	com/tencent/upload/common/UploadConfiguration:getNdkSendDataSize	()I
    //   40: istore 7
    //   42: iload 7
    //   44: istore 6
    //   46: aload_0
    //   47: getfield 245	com/tencent/upload/network/c/c$a:e	Z
    //   50: ifne +105 -> 155
    //   53: aload_0
    //   54: getfield 177	com/tencent/upload/network/c/c$a:a	Lcom/tencent/upload/network/a/d;
    //   57: invokeinterface 282 1 0
    //   62: astore 4
    //   64: aload 4
    //   66: ifnonnull +18 -> 84
    //   69: aload_1
    //   70: sipush 30700
    //   73: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   76: aload_1
    //   77: ldc_w 284
    //   80: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   83: return
    //   84: aload_0
    //   85: aload 4
    //   87: arraylength
    //   88: putfield 260	com/tencent/upload/network/c/c$a:c	I
    //   91: iload_2
    //   92: ifeq +18 -> 110
    //   95: aload_0
    //   96: getfield 177	com/tencent/upload/network/c/c$a:a	Lcom/tencent/upload/network/a/d;
    //   99: invokeinterface 266 1 0
    //   104: aload 4
    //   106: arraylength
    //   107: iadd
    //   108: istore 7
    //   110: iload 7
    //   112: aload 4
    //   114: arraylength
    //   115: isub
    //   116: istore 6
    //   118: iload 6
    //   120: ifge +18 -> 138
    //   123: aload_1
    //   124: sipush 30700
    //   127: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   130: aload_1
    //   131: ldc_w 286
    //   134: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   137: return
    //   138: aload 4
    //   140: ifnull +58 -> 198
    //   143: iconst_1
    //   144: istore 18
    //   146: aload_1
    //   147: iload 18
    //   149: putfield 244	com/tencent/upload/network/c/c$b:e	Z
    //   152: aload 4
    //   154: astore_3
    //   155: aload 5
    //   157: ifnull +684 -> 841
    //   160: aload_0
    //   161: getfield 247	com/tencent/upload/network/c/c$a:b	I
    //   164: iload 8
    //   166: if_icmpge +675 -> 841
    //   169: aload 5
    //   171: invokevirtual 292	java/io/File:length	()J
    //   174: lstore 12
    //   176: lload 12
    //   178: lconst_0
    //   179: lcmp
    //   180: ifne +24 -> 204
    //   183: aload_1
    //   184: sipush 30500
    //   187: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   190: aload_1
    //   191: ldc_w 294
    //   194: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   197: return
    //   198: iconst_0
    //   199: istore 18
    //   201: goto -55 -> 146
    //   204: iload 6
    //   206: istore 7
    //   208: iload_2
    //   209: ifeq +14 -> 223
    //   212: aload_0
    //   213: getfield 177	com/tencent/upload/network/c/c$a:a	Lcom/tencent/upload/network/a/d;
    //   216: invokeinterface 266 1 0
    //   221: istore 7
    //   223: iload 7
    //   225: istore 6
    //   227: iload 8
    //   229: aload_0
    //   230: getfield 247	com/tencent/upload/network/c/c$a:b	I
    //   233: iload 7
    //   235: iadd
    //   236: if_icmpge +12 -> 248
    //   239: iload 8
    //   241: aload_0
    //   242: getfield 247	com/tencent/upload/network/c/c$a:b	I
    //   245: isub
    //   246: istore 6
    //   248: iload 6
    //   250: ifge +18 -> 268
    //   253: aload_1
    //   254: sipush 30700
    //   257: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   260: aload_1
    //   261: ldc_w 296
    //   264: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   267: return
    //   268: aload_0
    //   269: getfield 177	com/tencent/upload/network/c/c$a:a	Lcom/tencent/upload/network/a/d;
    //   272: invokeinterface 298 1 0
    //   277: aload_0
    //   278: getfield 247	com/tencent/upload/network/c/c$a:b	I
    //   281: iadd
    //   282: istore 10
    //   284: lload 12
    //   286: iload 10
    //   288: iload 6
    //   290: iadd
    //   291: i2l
    //   292: lcmp
    //   293: ifge +653 -> 946
    //   296: lload 12
    //   298: iload 10
    //   300: i2l
    //   301: lsub
    //   302: l2i
    //   303: istore 7
    //   305: iload 7
    //   307: ifge +55 -> 362
    //   310: aload_1
    //   311: sipush 30700
    //   314: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   317: aload_1
    //   318: new 112	java/lang/StringBuilder
    //   321: dup
    //   322: ldc_w 300
    //   325: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: lload 12
    //   330: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   333: ldc_w 308
    //   336: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload 10
    //   341: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc_w 310
    //   347: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload 7
    //   352: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   361: return
    //   362: iconst_0
    //   363: istore 8
    //   365: aload 4
    //   367: ifnull +237 -> 604
    //   370: aload 4
    //   372: arraylength
    //   373: istore 8
    //   375: iload 8
    //   377: iload 7
    //   379: iadd
    //   380: newarray <illegal type>
    //   382: astore_0
    //   383: aload 4
    //   385: iconst_0
    //   386: aload_0
    //   387: iconst_0
    //   388: iload 8
    //   390: invokestatic 316	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   393: aload_0
    //   394: astore 4
    //   396: new 318	java/io/FileInputStream
    //   399: dup
    //   400: aload 5
    //   402: invokespecial 321	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   405: astore_0
    //   406: lconst_0
    //   407: lstore 12
    //   409: lload 12
    //   411: lstore 14
    //   413: iload 10
    //   415: ifle +538 -> 953
    //   418: iload 10
    //   420: i2l
    //   421: lstore 14
    //   423: aload_0
    //   424: astore_3
    //   425: aload_0
    //   426: lload 14
    //   428: lload 12
    //   430: lsub
    //   431: invokevirtual 325	java/io/FileInputStream:skip	(J)J
    //   434: lstore 16
    //   436: lload 12
    //   438: lstore 14
    //   440: lload 16
    //   442: lconst_0
    //   443: lcmp
    //   444: ifle +509 -> 953
    //   447: lload 12
    //   449: lload 16
    //   451: ladd
    //   452: lstore 14
    //   454: lload 14
    //   456: lstore 12
    //   458: lload 14
    //   460: iload 10
    //   462: i2l
    //   463: lcmp
    //   464: ifne -55 -> 409
    //   467: goto +486 -> 953
    //   470: iload 6
    //   472: istore 9
    //   474: lload 14
    //   476: iload 10
    //   478: i2l
    //   479: lcmp
    //   480: ifne +50 -> 530
    //   483: aload_0
    //   484: astore_3
    //   485: aload_0
    //   486: aload 4
    //   488: iload 8
    //   490: iload 6
    //   492: iadd
    //   493: iload 7
    //   495: iload 6
    //   497: isub
    //   498: invokevirtual 329	java/io/FileInputStream:read	([BII)I
    //   501: istore 11
    //   503: iload 6
    //   505: istore 9
    //   507: iload 11
    //   509: ifle +21 -> 530
    //   512: iload 6
    //   514: iload 11
    //   516: iadd
    //   517: istore 9
    //   519: iload 9
    //   521: istore 6
    //   523: iload 9
    //   525: iload 7
    //   527: if_icmpne -57 -> 470
    //   530: aload_0
    //   531: invokevirtual 332	java/io/FileInputStream:close	()V
    //   534: iload 9
    //   536: iload 7
    //   538: if_icmpeq +277 -> 815
    //   541: aload_1
    //   542: sipush 30700
    //   545: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   548: aload_1
    //   549: new 112	java/lang/StringBuilder
    //   552: dup
    //   553: ldc_w 334
    //   556: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   559: iload 9
    //   561: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: ldc_w 336
    //   567: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: iload 7
    //   572: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   575: ldc_w 338
    //   578: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: lload 14
    //   583: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   586: ldc_w 308
    //   589: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: iload 10
    //   594: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   597: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   603: return
    //   604: iload 7
    //   606: newarray <illegal type>
    //   608: astore 4
    //   610: goto -214 -> 396
    //   613: astore_0
    //   614: ldc 110
    //   616: aload_0
    //   617: invokevirtual 339	java/io/IOException:toString	()Ljava/lang/String;
    //   620: invokestatic 169	com/tencent/upload/a/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: goto -89 -> 534
    //   626: astore_3
    //   627: aconst_null
    //   628: astore_0
    //   629: ldc 110
    //   631: aload_3
    //   632: invokevirtual 340	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   635: invokestatic 169	com/tencent/upload/a/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: aload_1
    //   639: sipush 30500
    //   642: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   645: new 112	java/lang/StringBuilder
    //   648: dup
    //   649: ldc_w 342
    //   652: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   655: astore 4
    //   657: aload 5
    //   659: ifnull +69 -> 728
    //   662: new 112	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   669: aload 5
    //   671: invokevirtual 343	java/io/File:toString	()Ljava/lang/String;
    //   674: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: ldc_w 345
    //   680: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload 5
    //   685: invokevirtual 348	java/io/File:exists	()Z
    //   688: invokevirtual 237	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   691: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: astore_3
    //   695: aload_1
    //   696: aload 4
    //   698: aload_3
    //   699: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   708: aload_0
    //   709: ifnull -626 -> 83
    //   712: aload_0
    //   713: invokevirtual 332	java/io/FileInputStream:close	()V
    //   716: return
    //   717: astore_0
    //   718: ldc 110
    //   720: aload_0
    //   721: invokevirtual 339	java/io/IOException:toString	()Ljava/lang/String;
    //   724: invokestatic 169	com/tencent/upload/a/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: return
    //   728: ldc_w 350
    //   731: astore_3
    //   732: goto -37 -> 695
    //   735: astore 4
    //   737: aconst_null
    //   738: astore_0
    //   739: aload_0
    //   740: astore_3
    //   741: ldc 110
    //   743: aload 4
    //   745: invokevirtual 339	java/io/IOException:toString	()Ljava/lang/String;
    //   748: invokestatic 169	com/tencent/upload/a/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload_0
    //   752: astore_3
    //   753: aload_1
    //   754: sipush 30600
    //   757: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   760: aload_0
    //   761: astore_3
    //   762: aload_1
    //   763: ldc_w 352
    //   766: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   769: aload_0
    //   770: ifnull -687 -> 83
    //   773: aload_0
    //   774: invokevirtual 332	java/io/FileInputStream:close	()V
    //   777: return
    //   778: astore_0
    //   779: ldc 110
    //   781: aload_0
    //   782: invokevirtual 339	java/io/IOException:toString	()Ljava/lang/String;
    //   785: invokestatic 169	com/tencent/upload/a/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   788: return
    //   789: astore_1
    //   790: aconst_null
    //   791: astore_0
    //   792: aload_0
    //   793: ifnull +7 -> 800
    //   796: aload_0
    //   797: invokevirtual 332	java/io/FileInputStream:close	()V
    //   800: aload_1
    //   801: athrow
    //   802: astore_0
    //   803: ldc 110
    //   805: aload_0
    //   806: invokevirtual 339	java/io/IOException:toString	()Ljava/lang/String;
    //   809: invokestatic 169	com/tencent/upload/a/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   812: goto -12 -> 800
    //   815: aload_1
    //   816: iload 7
    //   818: putfield 248	com/tencent/upload/network/c/c$b:d	I
    //   821: aload 4
    //   823: ifnonnull +86 -> 909
    //   826: aload_1
    //   827: sipush 30700
    //   830: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   833: aload_1
    //   834: ldc_w 354
    //   837: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   840: return
    //   841: aload 5
    //   843: ifnonnull +23 -> 866
    //   846: iload 8
    //   848: ifle +18 -> 866
    //   851: aload_1
    //   852: sipush 30500
    //   855: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   858: aload_1
    //   859: ldc_w 356
    //   862: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   865: return
    //   866: aload 5
    //   868: ifnull +72 -> 940
    //   871: iload 8
    //   873: ifgt +67 -> 940
    //   876: aload_1
    //   877: sipush 30500
    //   880: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   883: aload_1
    //   884: new 112	java/lang/StringBuilder
    //   887: dup
    //   888: ldc_w 358
    //   891: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   894: aload 5
    //   896: invokevirtual 343	java/io/File:toString	()Ljava/lang/String;
    //   899: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: putfield 213	com/tencent/upload/network/c/c$b:b	Ljava/lang/String;
    //   908: return
    //   909: aload_1
    //   910: iconst_0
    //   911: putfield 202	com/tencent/upload/network/c/c$b:a	I
    //   914: aload_1
    //   915: aload 4
    //   917: putfield 216	com/tencent/upload/network/c/c$b:c	[B
    //   920: return
    //   921: astore_1
    //   922: aload_3
    //   923: astore_0
    //   924: goto -132 -> 792
    //   927: astore_1
    //   928: goto -136 -> 792
    //   931: astore 4
    //   933: goto -194 -> 739
    //   936: astore_3
    //   937: goto -308 -> 629
    //   940: aload_3
    //   941: astore 4
    //   943: goto -122 -> 821
    //   946: iload 6
    //   948: istore 7
    //   950: goto -645 -> 305
    //   953: iconst_0
    //   954: istore 6
    //   956: goto -486 -> 470
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	959	0	parama	a
    //   0	959	1	paramb	b
    //   0	959	2	paramBoolean	boolean
    //   25	460	3	localObject1	Object
    //   626	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   694	229	3	localObject2	Object
    //   936	5	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   22	675	4	localObject3	Object
    //   735	181	4	localIOException1	java.io.IOException
    //   931	1	4	localIOException2	java.io.IOException
    //   941	1	4	localObject4	Object
    //   19	876	5	localFile	File
    //   44	911	6	i1	int
    //   40	909	7	i2	int
    //   35	837	8	i3	int
    //   472	88	9	i4	int
    //   282	311	10	i5	int
    //   501	16	11	i6	int
    //   174	283	12	l1	long
    //   411	171	14	l2	long
    //   434	16	16	l3	long
    //   144	56	18	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   530	534	613	java/io/IOException
    //   396	406	626	java/io/FileNotFoundException
    //   712	716	717	java/io/IOException
    //   396	406	735	java/io/IOException
    //   773	777	778	java/io/IOException
    //   396	406	789	finally
    //   796	800	802	java/io/IOException
    //   425	436	921	finally
    //   485	503	921	finally
    //   741	751	921	finally
    //   753	760	921	finally
    //   762	769	921	finally
    //   629	657	927	finally
    //   662	695	927	finally
    //   695	708	927	finally
    //   425	436	931	java/io/IOException
    //   485	503	931	java/io/IOException
    //   425	436	936	java/io/FileNotFoundException
    //   485	503	936	java/io/FileNotFoundException
  }
  
  private static final int b(com.tencent.upload.network.a.d paramd)
  {
    int i2 = UploadConfiguration.getDataTimeout();
    boolean bool = com.tencent.upload.common.f.e().isMobile();
    int i1 = i2;
    if (bool) {
      i1 = i2 + i2;
    }
    i2 = i1;
    if (paramd.c()) {
      if (!bool) {
        break label53;
      }
    }
    label53:
    for (i2 = 5;; i2 = 20)
    {
      i2 = i1 + paramd.e() / i2;
      return i2;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.e == paramInt) {
      return;
    }
    this.e = paramInt;
    StringBuilder localStringBuilder = new StringBuilder().append(this.p).append(" doSetSessionState：");
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown";
    }
    for (;;)
    {
      com.tencent.upload.a.b.b("Session", str);
      if (paramInt != 0) {
        break;
      }
      com.tencent.upload.a.b.b("Session", this.p + " doCleanup");
      this.d.clear();
      this.m.clear();
      this.n.clear();
      h();
      return;
      str = "noconnection";
      continue;
      str = "connecting";
      continue;
      str = "established";
    }
  }
  
  private void h()
  {
    int i2 = this.o.size();
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = (a)this.o.valueAt(i1);
      if (locala != null)
      {
        this.k.removeCallbacks(locala.f);
        locala.f = null;
        com.tencent.upload.a.b.b("Session", this.p + " doClearAllTimeout remove: timeout runnable:" + com.tencent.upload.a.b.a(locala.f) + " reqSeq:" + this.o.keyAt(i1));
      }
      i1 += 1;
    }
    this.o.clear();
  }
  
  private void i()
  {
    if (this.m.isEmpty()) {
      return;
    }
    a locala = new a((com.tencent.upload.network.a.d)this.m.removeFirst());
    int i1 = q.incrementAndGet();
    com.tencent.upload.network.base.a locala1 = this.a;
    if (locala1 != null) {
      locala.d = locala1.hashCode();
    }
    com.tencent.upload.a.b.b("Session", this.p + " doSendFirst: mSendingMap put, sendSeq:" + i1 + " actSeq:" + locala.a.f() + " mActionRequests size:" + this.m.size());
    this.n.put(i1, locala);
    a(locala, i1);
  }
  
  public final void a()
  {
    com.tencent.upload.a.b.b("Session", this.p + " close");
    if (this.a != null)
    {
      this.a.b();
      this.a = null;
    }
    b(0);
  }
  
  public final void a(int paramInt)
  {
    int i2 = 0;
    Object localObject1 = this.m.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.upload.network.a.d)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((com.tencent.upload.network.a.d)localObject2).f() == paramInt))
      {
        ((Iterator)localObject1).remove();
        com.tencent.upload.a.b.b("Session", this.p + " cancel: mActionRequests remove: actSeq:" + paramInt + " request:" + com.tencent.upload.a.b.a(localObject2));
      }
    }
    localObject1 = new LinkedList();
    int i3 = this.n.size();
    int i1 = 0;
    while (i1 < i3)
    {
      localObject2 = (a)this.n.valueAt(i1);
      if ((localObject2 != null) && (((a)localObject2).a.f() == paramInt))
      {
        int i4 = this.n.keyAt(i1);
        ((LinkedList)localObject1).add(Integer.valueOf(i4));
        com.tencent.upload.a.b.b("Session", this.p + " cancel: mSendingMap remove: sendSeq:" + i4 + " actSeq:" + ((a)localObject2).a.f() + " reqSeq:" + ((a)localObject2).a.h());
      }
      i1 += 1;
    }
    while (((LinkedList)localObject1).size() > 0) {
      this.n.remove(((Integer)((LinkedList)localObject1).removeFirst()).intValue());
    }
    i3 = this.o.size();
    i1 = i2;
    while (i1 < i3)
    {
      localObject2 = (a)this.o.valueAt(i1);
      if ((localObject2 != null) && (((a)localObject2).a.f() == paramInt))
      {
        i2 = this.o.keyAt(i1);
        ((LinkedList)localObject1).add(Integer.valueOf(i2));
        com.tencent.upload.a.b.b("Session", this.p + " cancel: mTimeoutMap remove runnable:" + com.tencent.upload.a.b.a(((a)localObject2).f) + "reqSeq:" + i2 + " actSeq:" + ((a)localObject2).a.f());
        this.k.removeCallbacks(((a)localObject2).f);
        ((a)localObject2).f = null;
      }
      i1 += 1;
    }
    while (((LinkedList)localObject1).size() > 0) {
      this.o.remove(((Integer)((LinkedList)localObject1).removeFirst()).intValue());
    }
  }
  
  public final void a(com.tencent.upload.network.base.d paramd)
  {
    if (paramd != this.a) {
      return;
    }
    com.tencent.upload.a.b.b("Session", this.p + " onStart");
  }
  
  public final void a(com.tencent.upload.network.base.d paramd, int paramInt)
  {
    this.k.post(new h(this, paramd, paramInt));
  }
  
  public final void a(com.tencent.upload.network.base.d paramd, int paramInt1, int paramInt2)
  {
    this.k.post(new i(this, paramd, paramInt1, paramInt2));
  }
  
  public final void a(com.tencent.upload.network.base.d paramd, boolean paramBoolean, int paramInt, String paramString)
  {
    this.k.post(new f(this, paramd, paramBoolean, paramInt, paramString));
  }
  
  public final void a(com.tencent.upload.network.base.d paramd, byte[] paramArrayOfByte)
  {
    this.k.post(new j(this, paramd, paramArrayOfByte));
  }
  
  public final boolean a(com.tencent.upload.network.a.d paramd)
  {
    if ((this.e != 2) && (this.e != 1))
    {
      com.tencent.upload.a.b.e("Session", this.p + " send return false, state is illegel");
      return false;
    }
    if (paramd == null)
    {
      com.tencent.upload.a.b.e("Session", this.p + " send return false, request is illegel");
      return false;
    }
    this.m.addLast(paramd);
    this.k.post(new d(this));
    com.tencent.upload.a.b.b("Session", this.p + " send: actSeq:" + paramd.f() + " reqSeq:" + paramd.h() + " mActionRequests:" + this.m.size());
    return true;
  }
  
  public final boolean a(m paramm)
  {
    int i2 = UploadConfiguration.getConnectionTimeout();
    if (this.e != 0)
    {
      com.tencent.upload.a.b.d("Session", this.p + " open return false, state is illegel");
      return false;
    }
    if (paramm == null)
    {
      com.tencent.upload.a.b.d("Session", this.p + " open return false, route is illegel");
      return false;
    }
    int i1 = i2;
    if (i2 <= 0) {
      i1 = UploadConfiguration.getConnectionTimeout();
    }
    i2 = paramm.f();
    if ((this.b != null) && (this.b.f() != i2) && (this.a != null)) {
      this.a.b();
    }
    if (i2 == 1) {
      this.a = new com.tencent.upload.network.base.f(this);
    }
    while (this.a == null)
    {
      com.tencent.upload.a.b.d("Session", this.p + " open conn is null");
      return false;
      if (i2 == 2) {
        this.a = new com.tencent.upload.network.base.b(this);
      }
    }
    if (!this.a.a())
    {
      com.tencent.upload.a.b.d("Session", this.p + " open start async failed");
      return false;
    }
    boolean bool = this.a.a(paramm.b(), paramm.c(), paramm.d(), paramm.e(), i1);
    com.tencent.upload.a.b.b("Session", this.p + " mMainConnection open  ip = " + paramm.b() + " port = " + paramm.c());
    if (bool)
    {
      this.b = paramm;
      b(1);
      return bool;
    }
    this.b = null;
    return bool;
  }
  
  public final m b()
  {
    return this.b;
  }
  
  public final void b(com.tencent.upload.network.base.d paramd)
  {
    this.k.post(new g(this, paramd));
  }
  
  public final void b(com.tencent.upload.network.base.d paramd, int paramInt)
  {
    this.k.post(new l(this, paramInt));
  }
  
  public final String c()
  {
    return this.j;
  }
  
  public final void c(com.tencent.upload.network.base.d paramd, int paramInt)
  {
    this.k.post(new k(this, paramInt));
  }
  
  public final String d()
  {
    return this.l;
  }
  
  public final m e()
  {
    return this.i;
  }
  
  public final boolean f()
  {
    return (this.b != null) && (this.b.a() == 2);
  }
  
  public final boolean g()
  {
    return (this.m.size() == 0) && (this.n.size() == 0) && (this.o.size() == 0);
  }
  
  static final class a
  {
    public final com.tencent.upload.network.a.d a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public Runnable f;
    
    public a(com.tencent.upload.network.a.d paramd)
    {
      this.a = paramd;
      this.e = false;
    }
    
    public final boolean a()
    {
      boolean bool2 = false;
      File localFile = this.a.b();
      if (this.b == this.a.e()) {}
      for (int i = 1;; i = 0)
      {
        boolean bool1;
        if ((!this.e) || (localFile != null))
        {
          bool1 = bool2;
          if (this.e)
          {
            bool1 = bool2;
            if (localFile != null)
            {
              bool1 = bool2;
              if (i == 0) {}
            }
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
  }
  
  static final class b
  {
    int a = 0;
    String b = "";
    byte[] c = null;
    int d = 0;
    boolean e = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */