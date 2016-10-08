import com.tencent.mobileqq.apollo.GLTextureView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class pqx
  extends Thread
{
  private int jdField_a_of_type_Int;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private pqw jdField_a_of_type_Pqw;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  
  public pqx(WeakReference paramWeakReference)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.n = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.l = true;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private boolean b()
  {
    return (!this.d) && (this.e) && (!this.f) && (this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0) && ((this.l) || (this.jdField_c_of_type_Int == 1));
  }
  
  private void h()
  {
    if (this.i)
    {
      this.i = false;
      this.jdField_a_of_type_Pqw.b();
    }
  }
  
  private void i()
  {
    if (this.h)
    {
      this.jdField_a_of_type_Pqw.c();
      this.h = false;
      GLTextureView.a().b(this);
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 67	pqw
    //   4: dup
    //   5: aload_0
    //   6: getfield 50	pqx:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 87	pqw:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 65	pqx:jdField_a_of_type_Pqw	Lpqw;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 71	pqx:h	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 63	pqx:i	Z
    //   25: iconst_0
    //   26: istore 14
    //   28: aconst_null
    //   29: astore_2
    //   30: iconst_0
    //   31: istore 5
    //   33: iconst_0
    //   34: istore 7
    //   36: iconst_0
    //   37: istore 9
    //   39: iconst_0
    //   40: istore 10
    //   42: iconst_0
    //   43: istore 11
    //   45: iconst_0
    //   46: istore 12
    //   48: iconst_0
    //   49: istore 13
    //   51: aconst_null
    //   52: astore_1
    //   53: iconst_0
    //   54: istore 6
    //   56: iconst_0
    //   57: istore 8
    //   59: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   62: astore_3
    //   63: aload_3
    //   64: monitorenter
    //   65: iload 14
    //   67: istore 15
    //   69: iload 11
    //   71: istore 14
    //   73: iload 8
    //   75: istore 18
    //   77: aload_0
    //   78: getfield 89	pqx:jdField_a_of_type_Boolean	Z
    //   81: ifeq +27 -> 108
    //   84: aload_3
    //   85: monitorexit
    //   86: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: invokespecial 91	pqx:h	()V
    //   96: aload_0
    //   97: invokespecial 93	pqx:i	()V
    //   100: aload_1
    //   101: monitorexit
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: monitorexit
    //   106: aload_2
    //   107: athrow
    //   108: aload_0
    //   109: getfield 38	pqx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   112: invokevirtual 96	java/util/ArrayList:isEmpty	()Z
    //   115: ifne +96 -> 211
    //   118: aload_0
    //   119: getfield 38	pqx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   122: iconst_0
    //   123: invokevirtual 100	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   126: checkcast 102	java/lang/Runnable
    //   129: astore_1
    //   130: iload 14
    //   132: istore 11
    //   134: iload 10
    //   136: istore 16
    //   138: iload 5
    //   140: istore 8
    //   142: iload 15
    //   144: istore 14
    //   146: iload 11
    //   148: istore 10
    //   150: iload 16
    //   152: istore 11
    //   154: iload 6
    //   156: istore 5
    //   158: iload 18
    //   160: istore 6
    //   162: aload_3
    //   163: monitorexit
    //   164: aload_1
    //   165: ifnull +618 -> 783
    //   168: aload_1
    //   169: invokeinterface 105 1 0
    //   174: iload 10
    //   176: istore 15
    //   178: aconst_null
    //   179: astore_1
    //   180: iload 5
    //   182: istore 16
    //   184: iload 6
    //   186: istore 10
    //   188: iload 8
    //   190: istore 5
    //   192: iload 16
    //   194: istore 6
    //   196: iload 10
    //   198: istore 8
    //   200: iload 11
    //   202: istore 10
    //   204: iload 15
    //   206: istore 11
    //   208: goto -149 -> 59
    //   211: aload_0
    //   212: getfield 57	pqx:d	Z
    //   215: aload_0
    //   216: getfield 107	pqx:jdField_c_of_type_Boolean	Z
    //   219: if_icmpeq +969 -> 1188
    //   222: aload_0
    //   223: getfield 107	pqx:jdField_c_of_type_Boolean	Z
    //   226: istore 23
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 107	pqx:jdField_c_of_type_Boolean	Z
    //   233: putfield 57	pqx:d	Z
    //   236: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   239: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   242: iload 7
    //   244: istore 8
    //   246: aload_0
    //   247: getfield 114	pqx:k	Z
    //   250: ifeq +19 -> 269
    //   253: aload_0
    //   254: invokespecial 91	pqx:h	()V
    //   257: aload_0
    //   258: invokespecial 93	pqx:i	()V
    //   261: aload_0
    //   262: iconst_0
    //   263: putfield 114	pqx:k	Z
    //   266: iconst_1
    //   267: istore 8
    //   269: iload 14
    //   271: istore 11
    //   273: iload 14
    //   275: ifeq +14 -> 289
    //   278: aload_0
    //   279: invokespecial 91	pqx:h	()V
    //   282: aload_0
    //   283: invokespecial 93	pqx:i	()V
    //   286: iconst_0
    //   287: istore 11
    //   289: iload 23
    //   291: ifeq +14 -> 305
    //   294: aload_0
    //   295: getfield 63	pqx:i	Z
    //   298: ifeq +7 -> 305
    //   301: aload_0
    //   302: invokespecial 91	pqx:h	()V
    //   305: iload 23
    //   307: ifeq +48 -> 355
    //   310: aload_0
    //   311: getfield 71	pqx:h	Z
    //   314: ifeq +41 -> 355
    //   317: aload_0
    //   318: getfield 50	pqx:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   321: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   324: checkcast 75	com/tencent/mobileqq/apollo/GLTextureView
    //   327: astore 4
    //   329: aload 4
    //   331: ifnonnull +321 -> 652
    //   334: iconst_0
    //   335: istore 24
    //   337: iload 24
    //   339: ifeq +12 -> 351
    //   342: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   345: invokevirtual 122	pqy:a	()Z
    //   348: ifeq +7 -> 355
    //   351: aload_0
    //   352: invokespecial 93	pqx:i	()V
    //   355: iload 23
    //   357: ifeq +19 -> 376
    //   360: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   363: invokevirtual 124	pqy:b	()Z
    //   366: ifeq +10 -> 376
    //   369: aload_0
    //   370: getfield 65	pqx:jdField_a_of_type_Pqw	Lpqw;
    //   373: invokevirtual 73	pqw:c	()V
    //   376: aload_0
    //   377: getfield 59	pqx:e	Z
    //   380: ifne +37 -> 417
    //   383: aload_0
    //   384: getfield 126	pqx:g	Z
    //   387: ifne +30 -> 417
    //   390: aload_0
    //   391: getfield 63	pqx:i	Z
    //   394: ifeq +7 -> 401
    //   397: aload_0
    //   398: invokespecial 91	pqx:h	()V
    //   401: aload_0
    //   402: iconst_1
    //   403: putfield 126	pqx:g	Z
    //   406: aload_0
    //   407: iconst_0
    //   408: putfield 61	pqx:f	Z
    //   411: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   414: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   417: aload_0
    //   418: getfield 59	pqx:e	Z
    //   421: ifeq +21 -> 442
    //   424: aload_0
    //   425: getfield 126	pqx:g	Z
    //   428: ifeq +14 -> 442
    //   431: aload_0
    //   432: iconst_0
    //   433: putfield 126	pqx:g	Z
    //   436: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   439: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   442: iload 18
    //   444: istore 16
    //   446: iload 9
    //   448: istore 17
    //   450: iload 18
    //   452: ifeq +20 -> 472
    //   455: iconst_0
    //   456: istore 17
    //   458: iconst_0
    //   459: istore 16
    //   461: aload_0
    //   462: iconst_1
    //   463: putfield 128	pqx:m	Z
    //   466: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   469: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   472: iload 8
    //   474: istore 7
    //   476: iload 10
    //   478: istore 19
    //   480: iload 12
    //   482: istore 20
    //   484: iload 13
    //   486: istore 21
    //   488: iload 15
    //   490: istore 22
    //   492: aload_0
    //   493: invokespecial 129	pqx:b	()Z
    //   496: ifeq +250 -> 746
    //   499: iload 8
    //   501: istore 7
    //   503: iload 15
    //   505: istore 14
    //   507: aload_0
    //   508: getfield 71	pqx:h	Z
    //   511: ifne +15 -> 526
    //   514: iload 8
    //   516: ifeq +146 -> 662
    //   519: iconst_0
    //   520: istore 7
    //   522: iload 15
    //   524: istore 14
    //   526: aload_0
    //   527: getfield 71	pqx:h	Z
    //   530: ifeq +647 -> 1177
    //   533: aload_0
    //   534: getfield 63	pqx:i	Z
    //   537: ifne +640 -> 1177
    //   540: aload_0
    //   541: iconst_1
    //   542: putfield 63	pqx:i	Z
    //   545: iconst_1
    //   546: istore 13
    //   548: iconst_1
    //   549: istore 9
    //   551: iconst_1
    //   552: istore 8
    //   554: aload_0
    //   555: getfield 63	pqx:i	Z
    //   558: ifeq +639 -> 1197
    //   561: aload_0
    //   562: getfield 40	pqx:n	Z
    //   565: ifeq +593 -> 1158
    //   568: iconst_1
    //   569: istore 6
    //   571: aload_0
    //   572: getfield 42	pqx:jdField_a_of_type_Int	I
    //   575: istore 10
    //   577: aload_0
    //   578: getfield 44	pqx:jdField_b_of_type_Int	I
    //   581: istore 5
    //   583: iconst_1
    //   584: istore 12
    //   586: iconst_1
    //   587: istore 9
    //   589: aload_0
    //   590: iconst_0
    //   591: putfield 40	pqx:n	Z
    //   594: aload_0
    //   595: iconst_0
    //   596: putfield 46	pqx:l	Z
    //   599: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   602: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   605: iload 8
    //   607: istore 15
    //   609: iload 16
    //   611: istore 8
    //   613: iload 10
    //   615: istore 16
    //   617: iload 11
    //   619: istore 10
    //   621: iload 6
    //   623: istore 11
    //   625: iload 9
    //   627: istore 13
    //   629: iload 8
    //   631: istore 6
    //   633: iload 5
    //   635: istore 8
    //   637: iload 16
    //   639: istore 5
    //   641: iload 12
    //   643: istore 9
    //   645: iload 15
    //   647: istore 12
    //   649: goto -487 -> 162
    //   652: aload 4
    //   654: invokestatic 132	com/tencent/mobileqq/apollo/GLTextureView:a	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Z
    //   657: istore 24
    //   659: goto -322 -> 337
    //   662: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   665: aload_0
    //   666: invokevirtual 135	pqy:a	(Lpqx;)Z
    //   669: istore 23
    //   671: iload 8
    //   673: istore 7
    //   675: iload 15
    //   677: istore 14
    //   679: iload 23
    //   681: ifeq -155 -> 526
    //   684: aload_0
    //   685: getfield 65	pqx:jdField_a_of_type_Pqw	Lpqw;
    //   688: invokevirtual 137	pqw:a	()V
    //   691: aload_0
    //   692: iconst_1
    //   693: putfield 71	pqx:h	Z
    //   696: iconst_1
    //   697: istore 14
    //   699: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   702: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   705: iload 8
    //   707: istore 7
    //   709: goto -183 -> 526
    //   712: astore_1
    //   713: aload_3
    //   714: monitorexit
    //   715: aload_1
    //   716: athrow
    //   717: astore_2
    //   718: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   721: astore_1
    //   722: aload_1
    //   723: monitorenter
    //   724: aload_0
    //   725: invokespecial 91	pqx:h	()V
    //   728: aload_0
    //   729: invokespecial 93	pqx:i	()V
    //   732: aload_1
    //   733: monitorexit
    //   734: aload_2
    //   735: athrow
    //   736: astore_1
    //   737: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   740: aload_0
    //   741: invokevirtual 83	pqy:b	(Lpqx;)V
    //   744: aload_1
    //   745: athrow
    //   746: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   749: invokevirtual 140	java/lang/Object:wait	()V
    //   752: iload 16
    //   754: istore 18
    //   756: iload 17
    //   758: istore 9
    //   760: iload 19
    //   762: istore 10
    //   764: iload 11
    //   766: istore 14
    //   768: iload 20
    //   770: istore 12
    //   772: iload 21
    //   774: istore 13
    //   776: iload 22
    //   778: istore 15
    //   780: goto -703 -> 77
    //   783: iload 13
    //   785: ifeq +370 -> 1155
    //   788: aload_0
    //   789: getfield 65	pqx:jdField_a_of_type_Pqw	Lpqw;
    //   792: invokevirtual 141	pqw:a	()Z
    //   795: ifeq +277 -> 1072
    //   798: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   801: astore_3
    //   802: aload_3
    //   803: monitorenter
    //   804: aload_0
    //   805: iconst_1
    //   806: putfield 143	pqx:j	Z
    //   809: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   812: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   815: aload_3
    //   816: monitorexit
    //   817: iconst_0
    //   818: istore 13
    //   820: iload 12
    //   822: ifeq +330 -> 1152
    //   825: aload_0
    //   826: getfield 65	pqx:jdField_a_of_type_Pqw	Lpqw;
    //   829: invokevirtual 146	pqw:a	()Ljavax/microedition/khronos/opengles/GL;
    //   832: checkcast 148	javax/microedition/khronos/opengles/GL10
    //   835: astore_2
    //   836: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   839: aload_2
    //   840: invokevirtual 151	pqy:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   843: iconst_0
    //   844: istore 12
    //   846: iload 14
    //   848: istore 15
    //   850: iload 14
    //   852: ifeq +38 -> 890
    //   855: aload_0
    //   856: getfield 50	pqx:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   859: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   862: checkcast 75	com/tencent/mobileqq/apollo/GLTextureView
    //   865: astore_3
    //   866: aload_3
    //   867: ifnull +349 -> 1216
    //   870: aload_3
    //   871: invokestatic 154	com/tencent/mobileqq/apollo/GLTextureView:a	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   874: aload_2
    //   875: aload_0
    //   876: getfield 65	pqx:jdField_a_of_type_Pqw	Lpqw;
    //   879: getfield 157	pqw:a	Ljavax/microedition/khronos/egl/EGLConfig;
    //   882: invokeinterface 163 3 0
    //   887: goto +329 -> 1216
    //   890: iload 11
    //   892: istore 14
    //   894: iload 11
    //   896: ifeq +35 -> 931
    //   899: aload_0
    //   900: getfield 50	pqx:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   903: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   906: checkcast 75	com/tencent/mobileqq/apollo/GLTextureView
    //   909: astore_3
    //   910: aload_3
    //   911: ifnull +311 -> 1222
    //   914: aload_3
    //   915: invokestatic 154	com/tencent/mobileqq/apollo/GLTextureView:a	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   918: aload_2
    //   919: iload 5
    //   921: iload 8
    //   923: invokeinterface 167 4 0
    //   928: goto +294 -> 1222
    //   931: aload_0
    //   932: getfield 50	pqx:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   935: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   938: checkcast 75	com/tencent/mobileqq/apollo/GLTextureView
    //   941: astore_3
    //   942: aload_3
    //   943: ifnull +13 -> 956
    //   946: aload_3
    //   947: invokestatic 154	com/tencent/mobileqq/apollo/GLTextureView:a	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   950: aload_2
    //   951: invokeinterface 170 2 0
    //   956: aload_0
    //   957: getfield 65	pqx:jdField_a_of_type_Pqw	Lpqw;
    //   960: invokevirtual 173	pqw:a	()I
    //   963: istore 16
    //   965: iload 10
    //   967: istore 11
    //   969: iload 16
    //   971: lookupswitch	default:+257->1228, 12288:+57->1028, 12302:+165->1136
    //   996: ldc -81
    //   998: ldc -79
    //   1000: iload 16
    //   1002: invokestatic 180	pqw:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1005: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   1008: astore_3
    //   1009: aload_3
    //   1010: monitorenter
    //   1011: aload_0
    //   1012: iconst_1
    //   1013: putfield 61	pqx:f	Z
    //   1016: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   1019: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   1022: aload_3
    //   1023: monitorexit
    //   1024: iload 10
    //   1026: istore 11
    //   1028: iload 9
    //   1030: ifeq +164 -> 1194
    //   1033: iconst_1
    //   1034: istore 6
    //   1036: iload 5
    //   1038: istore 16
    //   1040: iload 6
    //   1042: istore 10
    //   1044: iload 8
    //   1046: istore 5
    //   1048: iload 16
    //   1050: istore 6
    //   1052: iload 10
    //   1054: istore 8
    //   1056: iload 14
    //   1058: istore 10
    //   1060: iload 15
    //   1062: istore 14
    //   1064: goto -1005 -> 59
    //   1067: astore_1
    //   1068: aload_3
    //   1069: monitorexit
    //   1070: aload_1
    //   1071: athrow
    //   1072: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   1075: astore_3
    //   1076: aload_3
    //   1077: monitorenter
    //   1078: aload_0
    //   1079: iconst_1
    //   1080: putfield 143	pqx:j	Z
    //   1083: aload_0
    //   1084: iconst_1
    //   1085: putfield 61	pqx:f	Z
    //   1088: invokestatic 78	com/tencent/mobileqq/apollo/GLTextureView:a	()Lpqy;
    //   1091: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   1094: aload_3
    //   1095: monitorexit
    //   1096: iload 10
    //   1098: istore 15
    //   1100: iload 5
    //   1102: istore 16
    //   1104: iload 6
    //   1106: istore 10
    //   1108: iload 8
    //   1110: istore 5
    //   1112: iload 16
    //   1114: istore 6
    //   1116: iload 10
    //   1118: istore 8
    //   1120: iload 11
    //   1122: istore 10
    //   1124: iload 15
    //   1126: istore 11
    //   1128: goto -1069 -> 59
    //   1131: astore_1
    //   1132: aload_3
    //   1133: monitorexit
    //   1134: aload_1
    //   1135: athrow
    //   1136: iconst_1
    //   1137: istore 11
    //   1139: goto -111 -> 1028
    //   1142: astore_1
    //   1143: aload_3
    //   1144: monitorexit
    //   1145: aload_1
    //   1146: athrow
    //   1147: astore_2
    //   1148: aload_1
    //   1149: monitorexit
    //   1150: aload_2
    //   1151: athrow
    //   1152: goto -306 -> 846
    //   1155: goto -335 -> 820
    //   1158: iload 17
    //   1160: istore 12
    //   1162: iload 6
    //   1164: istore 10
    //   1166: iload 9
    //   1168: istore 6
    //   1170: iload 13
    //   1172: istore 9
    //   1174: goto -580 -> 594
    //   1177: iload 10
    //   1179: istore 9
    //   1181: iload 12
    //   1183: istore 8
    //   1185: goto -631 -> 554
    //   1188: iconst_0
    //   1189: istore 23
    //   1191: goto -949 -> 242
    //   1194: goto -158 -> 1036
    //   1197: iload 9
    //   1199: istore 19
    //   1201: iload 8
    //   1203: istore 20
    //   1205: iload 13
    //   1207: istore 21
    //   1209: iload 14
    //   1211: istore 22
    //   1213: goto -467 -> 746
    //   1216: iconst_0
    //   1217: istore 15
    //   1219: goto -329 -> 890
    //   1222: iconst_0
    //   1223: istore 14
    //   1225: goto -294 -> 931
    //   1228: goto -232 -> 996
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1231	0	this	pqx
    //   52	128	1	localObject1	Object
    //   712	4	1	localObject2	Object
    //   736	9	1	localRuntimeException	RuntimeException
    //   1067	4	1	localObject3	Object
    //   1131	4	1	localObject4	Object
    //   1142	7	1	localObject5	Object
    //   29	1	2	localObject6	Object
    //   103	4	2	localObject7	Object
    //   717	18	2	localObject8	Object
    //   835	116	2	localGL10	javax.microedition.khronos.opengles.GL10
    //   1147	4	2	localObject9	Object
    //   327	326	4	localGLTextureView	GLTextureView
    //   31	1080	5	i1	int
    //   54	1115	6	i2	int
    //   34	674	7	i3	int
    //   57	1145	8	i4	int
    //   37	1161	9	i5	int
    //   40	1138	10	i6	int
    //   43	1095	11	i7	int
    //   46	1136	12	i8	int
    //   49	1157	13	i9	int
    //   26	1198	14	i10	int
    //   67	1151	15	i11	int
    //   136	977	16	i12	int
    //   448	711	17	i13	int
    //   75	680	18	i14	int
    //   478	722	19	i15	int
    //   482	722	20	i16	int
    //   486	722	21	i17	int
    //   490	722	22	i18	int
    //   226	964	23	bool1	boolean
    //   335	323	24	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   92	102	103	finally
    //   104	106	103	finally
    //   77	86	712	finally
    //   108	130	712	finally
    //   162	164	712	finally
    //   211	242	712	finally
    //   246	266	712	finally
    //   278	286	712	finally
    //   294	305	712	finally
    //   310	329	712	finally
    //   342	351	712	finally
    //   351	355	712	finally
    //   360	376	712	finally
    //   376	401	712	finally
    //   401	417	712	finally
    //   417	442	712	finally
    //   461	472	712	finally
    //   492	499	712	finally
    //   507	514	712	finally
    //   526	545	712	finally
    //   554	568	712	finally
    //   571	583	712	finally
    //   589	594	712	finally
    //   594	605	712	finally
    //   652	659	712	finally
    //   662	671	712	finally
    //   684	691	712	finally
    //   691	696	712	finally
    //   699	705	712	finally
    //   713	715	712	finally
    //   737	746	712	finally
    //   746	752	712	finally
    //   59	65	717	finally
    //   168	174	717	finally
    //   715	717	717	finally
    //   788	804	717	finally
    //   825	843	717	finally
    //   855	866	717	finally
    //   870	887	717	finally
    //   899	910	717	finally
    //   914	928	717	finally
    //   931	942	717	finally
    //   946	956	717	finally
    //   956	965	717	finally
    //   996	1011	717	finally
    //   1070	1072	717	finally
    //   1072	1078	717	finally
    //   1134	1136	717	finally
    //   1145	1147	717	finally
    //   684	691	736	java/lang/RuntimeException
    //   804	817	1067	finally
    //   1068	1070	1067	finally
    //   1078	1096	1131	finally
    //   1132	1134	1131	finally
    //   1011	1024	1142	finally
    //   1143	1145	1142	finally
    //   724	734	1147	finally
    //   1148	1150	1147	finally
  }
  
  public int a()
  {
    synchronized ()
    {
      int i1 = this.jdField_c_of_type_Int;
      return i1;
    }
  }
  
  public void a()
  {
    synchronized ()
    {
      this.l = true;
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("renderMode");
    }
    synchronized (GLTextureView.a())
    {
      this.jdField_c_of_type_Int = paramInt;
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.n = true;
      this.l = true;
      this.m = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if ((!this.jdField_b_of_type_Boolean) && (!this.d) && (!this.m))
        {
          boolean bool = a();
          if (bool) {
            try
            {
              GLTextureView.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("r must not be null");
    }
    synchronized (GLTextureView.a())
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public boolean a()
  {
    return (this.h) && (this.i) && (b());
  }
  
  public void b()
  {
    synchronized ()
    {
      this.e = true;
      this.j = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if ((this.g) && (!this.j))
        {
          boolean bool = this.jdField_b_of_type_Boolean;
          if (!bool) {
            try
            {
              GLTextureView.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void c()
  {
    synchronized ()
    {
      this.e = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if (!this.g)
        {
          boolean bool = this.jdField_b_of_type_Boolean;
          if (!bool) {
            try
            {
              GLTextureView.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void d()
  {
    synchronized ()
    {
      this.jdField_c_of_type_Boolean = true;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          boolean bool = this.d;
          if (!bool) {
            try
            {
              GLTextureView.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void e()
  {
    synchronized ()
    {
      this.jdField_c_of_type_Boolean = false;
      this.l = true;
      this.m = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if ((!this.jdField_b_of_type_Boolean) && (this.d))
        {
          boolean bool = this.m;
          if (!bool) {
            try
            {
              GLTextureView.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void f()
  {
    synchronized ()
    {
      this.jdField_a_of_type_Boolean = true;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        boolean bool = this.jdField_b_of_type_Boolean;
        if (!bool) {
          try
          {
            GLTextureView.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  public void g()
  {
    this.k = true;
    GLTextureView.a().notifyAll();
  }
  
  public void run()
  {
    setName("GLThread " + getId());
    try
    {
      j();
      GLTextureView.a().a(this);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException = localInterruptedException;
      GLTextureView.a().a(this);
      return;
    }
    finally
    {
      localObject = finally;
      GLTextureView.a().a(this);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */