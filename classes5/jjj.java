import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jjj
  extends Handler
{
  public jjj(ScannerView paramScannerView, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 36	android/os/Message:what	I
    //   4: tableswitch	default:+24->28, 5:+25->29, 6:+1152->1156
    //   28: return
    //   29: aload_0
    //   30: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   33: astore 6
    //   35: aload 6
    //   37: aload 6
    //   39: getfield 42	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   42: lconst_1
    //   43: ladd
    //   44: putfield 42	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   47: aload_1
    //   48: getfield 46	android/os/Message:obj	Ljava/lang/Object;
    //   51: ifnull +13 -> 64
    //   54: aload_1
    //   55: getfield 46	android/os/Message:obj	Ljava/lang/Object;
    //   58: instanceof 48
    //   61: ifne +16 -> 77
    //   64: aload_0
    //   65: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   68: getfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   71: iconst_2
    //   72: invokevirtual 55	android/os/Handler:sendEmptyMessage	(I)Z
    //   75: pop
    //   76: return
    //   77: aload_1
    //   78: getfield 46	android/os/Message:obj	Ljava/lang/Object;
    //   81: checkcast 48	[B
    //   84: checkcast 48	[B
    //   87: astore 7
    //   89: aload_0
    //   90: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   93: getfield 58	com/tencent/biz/widgets/ScannerView:v	I
    //   96: iconst_3
    //   97: if_icmpge +49 -> 146
    //   100: iconst_0
    //   101: istore 14
    //   103: aload 7
    //   105: arraylength
    //   106: istore 15
    //   108: iconst_0
    //   109: istore 12
    //   111: iload 14
    //   113: istore 13
    //   115: iload 12
    //   117: iload 15
    //   119: if_icmpge +14 -> 133
    //   122: aload 7
    //   124: iload 12
    //   126: baload
    //   127: ifeq +579 -> 706
    //   130: iconst_1
    //   131: istore 13
    //   133: iload 13
    //   135: ifeq +580 -> 715
    //   138: aload_0
    //   139: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   142: iconst_3
    //   143: putfield 58	com/tencent/biz/widgets/ScannerView:v	I
    //   146: aload_0
    //   147: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   150: getfield 61	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   158: getfield 63	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   161: astore 6
    //   163: aload_1
    //   164: ifnonnull +2673 -> 2837
    //   167: aload 6
    //   169: astore_1
    //   170: aload 6
    //   172: ifnonnull +39 -> 211
    //   175: aload_0
    //   176: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   179: astore 6
    //   181: new 65	android/graphics/Rect
    //   184: dup
    //   185: iconst_0
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   191: getfield 68	com/tencent/biz/widgets/ScannerView:s	I
    //   194: aload_0
    //   195: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   198: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   201: invokespecial 74	android/graphics/Rect:<init>	(IIII)V
    //   204: astore_1
    //   205: aload 6
    //   207: aload_1
    //   208: putfield 63	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   211: aload_0
    //   212: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   215: getfield 77	com/tencent/biz/widgets/ScannerView:u	I
    //   218: bipush 90
    //   220: if_icmpne +536 -> 756
    //   223: aload_0
    //   224: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   227: getfield 80	com/tencent/biz/widgets/ScannerView:o	I
    //   230: i2f
    //   231: aload_0
    //   232: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   235: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   238: i2f
    //   239: fdiv
    //   240: fstore 4
    //   242: aload_0
    //   243: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   246: getfield 83	com/tencent/biz/widgets/ScannerView:p	I
    //   249: i2f
    //   250: aload_0
    //   251: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   254: getfield 68	com/tencent/biz/widgets/ScannerView:s	I
    //   257: i2f
    //   258: fdiv
    //   259: fstore 5
    //   261: new 65	android/graphics/Rect
    //   264: dup
    //   265: aload_1
    //   266: getfield 86	android/graphics/Rect:top	I
    //   269: i2f
    //   270: fload 4
    //   272: fmul
    //   273: f2i
    //   274: aload_0
    //   275: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   278: getfield 68	com/tencent/biz/widgets/ScannerView:s	I
    //   281: aload_1
    //   282: getfield 89	android/graphics/Rect:right	I
    //   285: isub
    //   286: i2f
    //   287: fload 5
    //   289: fmul
    //   290: f2i
    //   291: fload 4
    //   293: aload_1
    //   294: getfield 92	android/graphics/Rect:bottom	I
    //   297: i2f
    //   298: fmul
    //   299: f2i
    //   300: aload_0
    //   301: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   304: getfield 68	com/tencent/biz/widgets/ScannerView:s	I
    //   307: aload_1
    //   308: getfield 95	android/graphics/Rect:left	I
    //   311: isub
    //   312: i2f
    //   313: fload 5
    //   315: fmul
    //   316: f2i
    //   317: invokespecial 74	android/graphics/Rect:<init>	(IIII)V
    //   320: astore_1
    //   321: aload_0
    //   322: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   325: aload_1
    //   326: putfield 61	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   329: invokestatic 101	java/lang/System:currentTimeMillis	()J
    //   332: lstore 20
    //   334: iconst_2
    //   335: newarray <illegal type>
    //   337: astore 8
    //   339: aload_1
    //   340: invokevirtual 105	android/graphics/Rect:width	()I
    //   343: aload_1
    //   344: invokevirtual 108	android/graphics/Rect:height	()I
    //   347: imul
    //   348: iconst_3
    //   349: imul
    //   350: iconst_1
    //   351: ishr
    //   352: newarray <illegal type>
    //   354: astore 6
    //   356: aload 6
    //   358: ifnull +2473 -> 2831
    //   361: aload_0
    //   362: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   365: getfield 80	com/tencent/biz/widgets/ScannerView:o	I
    //   368: ifle +2463 -> 2831
    //   371: aload_0
    //   372: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   375: getfield 83	com/tencent/biz/widgets/ScannerView:p	I
    //   378: ifle +2453 -> 2831
    //   381: aload_1
    //   382: getfield 95	android/graphics/Rect:left	I
    //   385: iflt +2446 -> 2831
    //   388: aload_1
    //   389: getfield 86	android/graphics/Rect:top	I
    //   392: iflt +2439 -> 2831
    //   395: aload_1
    //   396: invokevirtual 105	android/graphics/Rect:width	()I
    //   399: ifle +2432 -> 2831
    //   402: aload_1
    //   403: invokevirtual 108	android/graphics/Rect:height	()I
    //   406: ifle +2425 -> 2831
    //   409: aload_1
    //   410: getfield 89	android/graphics/Rect:right	I
    //   413: aload_0
    //   414: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   417: getfield 80	com/tencent/biz/widgets/ScannerView:o	I
    //   420: if_icmpgt +2411 -> 2831
    //   423: aload_1
    //   424: getfield 92	android/graphics/Rect:bottom	I
    //   427: aload_0
    //   428: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   431: getfield 83	com/tencent/biz/widgets/ScannerView:p	I
    //   434: if_icmpgt +2397 -> 2831
    //   437: aload 7
    //   439: arraylength
    //   440: aload_0
    //   441: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   444: getfield 80	com/tencent/biz/widgets/ScannerView:o	I
    //   447: aload_0
    //   448: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   451: getfield 83	com/tencent/biz/widgets/ScannerView:p	I
    //   454: imul
    //   455: iconst_3
    //   456: imul
    //   457: iconst_1
    //   458: ishr
    //   459: if_icmpne +2372 -> 2831
    //   462: aload 6
    //   464: aload 8
    //   466: aload 7
    //   468: aload_0
    //   469: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   472: getfield 80	com/tencent/biz/widgets/ScannerView:o	I
    //   475: aload_0
    //   476: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   479: getfield 83	com/tencent/biz/widgets/ScannerView:p	I
    //   482: aload_1
    //   483: getfield 95	android/graphics/Rect:left	I
    //   486: aload_1
    //   487: getfield 86	android/graphics/Rect:top	I
    //   490: aload_1
    //   491: invokevirtual 105	android/graphics/Rect:width	()I
    //   494: aload_1
    //   495: invokevirtual 108	android/graphics/Rect:height	()I
    //   498: aload_0
    //   499: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   502: getfield 77	com/tencent/biz/widgets/ScannerView:u	I
    //   505: iconst_0
    //   506: invokestatic 113	com/tencent/imageboost/ImgProcessScan:a	([B[I[BIIIIIIII)I
    //   509: iconst_1
    //   510: if_icmpne +2321 -> 2831
    //   513: aload 6
    //   515: aload 8
    //   517: iconst_0
    //   518: iaload
    //   519: aload 8
    //   521: iconst_1
    //   522: iaload
    //   523: iconst_0
    //   524: invokestatic 119	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   527: istore 12
    //   529: invokestatic 101	java/lang/System:currentTimeMillis	()J
    //   532: lload 20
    //   534: lsub
    //   535: l2d
    //   536: dstore_2
    //   537: iload 12
    //   539: istore 13
    //   541: invokestatic 125	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   544: ifeq +33 -> 577
    //   547: getstatic 128	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   550: iconst_4
    //   551: new 130	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   558: ldc -121
    //   560: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: dload_2
    //   564: invokevirtual 142	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   567: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: iload 12
    //   575: istore 13
    //   577: iload 13
    //   579: iconst_1
    //   580: if_icmpne +563 -> 1143
    //   583: new 130	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   590: astore_1
    //   591: new 130	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   598: astore 6
    //   600: aload_1
    //   601: aload 6
    //   603: invokestatic 153	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   606: pop
    //   607: aconst_null
    //   608: ldc -101
    //   610: ldc -99
    //   612: ldc -97
    //   614: ldc -95
    //   616: ldc -93
    //   618: iconst_0
    //   619: iconst_0
    //   620: new 130	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   627: ldc -97
    //   629: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokestatic 101	java/lang/System:currentTimeMillis	()J
    //   635: aload_0
    //   636: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   639: getfield 165	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Long	J
    //   642: lsub
    //   643: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   646: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: new 130	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   656: ldc -97
    //   658: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_0
    //   662: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   665: getfield 42	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   668: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   671: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: ldc -97
    //   676: ldc -97
    //   678: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   681: aload_0
    //   682: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   685: aload_1
    //   686: putfield 176	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   689: aload_0
    //   690: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   693: getfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   696: iconst_1
    //   697: aload 6
    //   699: invokevirtual 180	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   702: invokevirtual 183	android/os/Message:sendToTarget	()V
    //   705: return
    //   706: iload 12
    //   708: iconst_1
    //   709: iadd
    //   710: istore 12
    //   712: goto -601 -> 111
    //   715: aload_0
    //   716: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   719: astore_1
    //   720: aload_1
    //   721: getfield 58	com/tencent/biz/widgets/ScannerView:v	I
    //   724: iconst_1
    //   725: iadd
    //   726: istore 12
    //   728: aload_1
    //   729: iload 12
    //   731: putfield 58	com/tencent/biz/widgets/ScannerView:v	I
    //   734: iload 12
    //   736: iconst_3
    //   737: if_icmpne -591 -> 146
    //   740: aload_0
    //   741: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   744: getfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   747: bipush 9
    //   749: invokevirtual 55	android/os/Handler:sendEmptyMessage	(I)Z
    //   752: pop
    //   753: goto -607 -> 146
    //   756: aload_0
    //   757: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   760: getfield 77	com/tencent/biz/widgets/ScannerView:u	I
    //   763: sipush 180
    //   766: if_icmpne +120 -> 886
    //   769: aload_0
    //   770: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   773: getfield 80	com/tencent/biz/widgets/ScannerView:o	I
    //   776: i2f
    //   777: aload_0
    //   778: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   781: getfield 68	com/tencent/biz/widgets/ScannerView:s	I
    //   784: i2f
    //   785: fdiv
    //   786: fstore 4
    //   788: aload_0
    //   789: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   792: getfield 83	com/tencent/biz/widgets/ScannerView:p	I
    //   795: i2f
    //   796: aload_0
    //   797: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   800: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   803: i2f
    //   804: fdiv
    //   805: fstore 5
    //   807: new 65	android/graphics/Rect
    //   810: dup
    //   811: aload_0
    //   812: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   815: getfield 68	com/tencent/biz/widgets/ScannerView:s	I
    //   818: aload_1
    //   819: getfield 89	android/graphics/Rect:right	I
    //   822: isub
    //   823: i2f
    //   824: fload 4
    //   826: fmul
    //   827: f2i
    //   828: aload_0
    //   829: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   832: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   835: aload_1
    //   836: getfield 92	android/graphics/Rect:bottom	I
    //   839: isub
    //   840: i2f
    //   841: fload 5
    //   843: fmul
    //   844: f2i
    //   845: fload 4
    //   847: aload_0
    //   848: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   851: getfield 68	com/tencent/biz/widgets/ScannerView:s	I
    //   854: aload_1
    //   855: getfield 95	android/graphics/Rect:left	I
    //   858: isub
    //   859: i2f
    //   860: fmul
    //   861: f2i
    //   862: aload_0
    //   863: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   866: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   869: aload_1
    //   870: getfield 86	android/graphics/Rect:top	I
    //   873: isub
    //   874: i2f
    //   875: fload 5
    //   877: fmul
    //   878: f2i
    //   879: invokespecial 74	android/graphics/Rect:<init>	(IIII)V
    //   882: astore_1
    //   883: goto -562 -> 321
    //   886: aload_0
    //   887: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   890: getfield 77	com/tencent/biz/widgets/ScannerView:u	I
    //   893: sipush 270
    //   896: if_icmpne +104 -> 1000
    //   899: aload_0
    //   900: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   903: getfield 80	com/tencent/biz/widgets/ScannerView:o	I
    //   906: i2f
    //   907: aload_0
    //   908: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   911: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   914: i2f
    //   915: fdiv
    //   916: fstore 4
    //   918: aload_0
    //   919: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   922: getfield 83	com/tencent/biz/widgets/ScannerView:p	I
    //   925: i2f
    //   926: aload_0
    //   927: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   930: getfield 68	com/tencent/biz/widgets/ScannerView:s	I
    //   933: i2f
    //   934: fdiv
    //   935: fstore 5
    //   937: new 65	android/graphics/Rect
    //   940: dup
    //   941: aload_0
    //   942: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   945: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   948: aload_1
    //   949: getfield 92	android/graphics/Rect:bottom	I
    //   952: isub
    //   953: i2f
    //   954: fload 4
    //   956: fmul
    //   957: f2i
    //   958: aload_1
    //   959: getfield 95	android/graphics/Rect:left	I
    //   962: i2f
    //   963: fload 5
    //   965: fmul
    //   966: f2i
    //   967: fload 4
    //   969: aload_0
    //   970: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   973: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   976: aload_1
    //   977: getfield 86	android/graphics/Rect:top	I
    //   980: isub
    //   981: i2f
    //   982: fmul
    //   983: f2i
    //   984: aload_1
    //   985: getfield 89	android/graphics/Rect:right	I
    //   988: i2f
    //   989: fload 5
    //   991: fmul
    //   992: f2i
    //   993: invokespecial 74	android/graphics/Rect:<init>	(IIII)V
    //   996: astore_1
    //   997: goto -676 -> 321
    //   1000: aload_0
    //   1001: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1004: getfield 80	com/tencent/biz/widgets/ScannerView:o	I
    //   1007: i2f
    //   1008: aload_0
    //   1009: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1012: getfield 68	com/tencent/biz/widgets/ScannerView:s	I
    //   1015: i2f
    //   1016: fdiv
    //   1017: fstore 4
    //   1019: aload_0
    //   1020: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1023: getfield 83	com/tencent/biz/widgets/ScannerView:p	I
    //   1026: i2f
    //   1027: aload_0
    //   1028: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1031: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   1034: i2f
    //   1035: fdiv
    //   1036: fstore 5
    //   1038: new 65	android/graphics/Rect
    //   1041: dup
    //   1042: aload_1
    //   1043: getfield 95	android/graphics/Rect:left	I
    //   1046: i2f
    //   1047: fload 4
    //   1049: fmul
    //   1050: f2i
    //   1051: aload_1
    //   1052: getfield 86	android/graphics/Rect:top	I
    //   1055: i2f
    //   1056: fload 5
    //   1058: fmul
    //   1059: f2i
    //   1060: fload 4
    //   1062: aload_1
    //   1063: getfield 89	android/graphics/Rect:right	I
    //   1066: i2f
    //   1067: fmul
    //   1068: f2i
    //   1069: aload_1
    //   1070: getfield 92	android/graphics/Rect:bottom	I
    //   1073: i2f
    //   1074: fload 5
    //   1076: fmul
    //   1077: f2i
    //   1078: invokespecial 74	android/graphics/Rect:<init>	(IIII)V
    //   1081: astore_1
    //   1082: goto -761 -> 321
    //   1085: astore 6
    //   1087: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1090: ifeq +15 -> 1105
    //   1093: getstatic 128	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1096: iconst_2
    //   1097: aload 6
    //   1099: invokevirtual 187	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1102: invokestatic 190	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1105: aconst_null
    //   1106: astore 6
    //   1108: goto -752 -> 356
    //   1111: astore_1
    //   1112: iconst_0
    //   1113: istore 12
    //   1115: iload 12
    //   1117: istore 13
    //   1119: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1122: ifeq -545 -> 577
    //   1125: getstatic 128	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1128: iconst_2
    //   1129: aload_1
    //   1130: invokevirtual 191	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   1133: invokestatic 190	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1136: iload 12
    //   1138: istore 13
    //   1140: goto -563 -> 577
    //   1143: aload_0
    //   1144: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1147: getfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1150: iconst_2
    //   1151: invokevirtual 55	android/os/Handler:sendEmptyMessage	(I)Z
    //   1154: pop
    //   1155: return
    //   1156: iconst_m1
    //   1157: istore 12
    //   1159: iload 12
    //   1161: istore 13
    //   1163: iload 12
    //   1165: istore 14
    //   1167: iload 12
    //   1169: istore 15
    //   1171: aload_1
    //   1172: getfield 46	android/os/Message:obj	Ljava/lang/Object;
    //   1175: checkcast 193	android/net/Uri
    //   1178: astore 8
    //   1180: iload 12
    //   1182: istore 13
    //   1184: iload 12
    //   1186: istore 14
    //   1188: iload 12
    //   1190: istore 15
    //   1192: aload_0
    //   1193: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1196: invokevirtual 197	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   1199: invokevirtual 203	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1202: astore 9
    //   1204: iload 12
    //   1206: istore 13
    //   1208: iload 12
    //   1210: istore 14
    //   1212: iload 12
    //   1214: istore 15
    //   1216: new 205	android/graphics/BitmapFactory$Options
    //   1219: dup
    //   1220: invokespecial 206	android/graphics/BitmapFactory$Options:<init>	()V
    //   1223: astore 7
    //   1225: iload 12
    //   1227: istore 13
    //   1229: iload 12
    //   1231: istore 14
    //   1233: iload 12
    //   1235: istore 15
    //   1237: aload 7
    //   1239: iconst_1
    //   1240: putfield 209	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1243: iload 12
    //   1245: istore 13
    //   1247: iload 12
    //   1249: istore 14
    //   1251: iload 12
    //   1253: istore 15
    //   1255: aload 9
    //   1257: aload 8
    //   1259: invokevirtual 215	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1262: astore 6
    //   1264: iload 12
    //   1266: istore 13
    //   1268: iload 12
    //   1270: istore 14
    //   1272: iload 12
    //   1274: istore 15
    //   1276: aload 6
    //   1278: aconst_null
    //   1279: aload 7
    //   1281: invokestatic 221	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1284: pop
    //   1285: iload 12
    //   1287: istore 13
    //   1289: iload 12
    //   1291: istore 14
    //   1293: iload 12
    //   1295: istore 15
    //   1297: aload 6
    //   1299: invokevirtual 226	java/io/InputStream:close	()V
    //   1302: iload 12
    //   1304: istore 13
    //   1306: iload 12
    //   1308: istore 14
    //   1310: iload 12
    //   1312: istore 15
    //   1314: aload 7
    //   1316: getfield 229	android/graphics/BitmapFactory$Options:outWidth	I
    //   1319: istore 18
    //   1321: iload 12
    //   1323: istore 13
    //   1325: iload 12
    //   1327: istore 14
    //   1329: iload 12
    //   1331: istore 15
    //   1333: aload 7
    //   1335: getfield 232	android/graphics/BitmapFactory$Options:outHeight	I
    //   1338: istore 19
    //   1340: iload 12
    //   1342: istore 13
    //   1344: iload 12
    //   1346: istore 14
    //   1348: iload 12
    //   1350: istore 15
    //   1352: aload 7
    //   1354: iconst_0
    //   1355: putfield 209	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1358: iload 18
    //   1360: iload 19
    //   1362: imul
    //   1363: ldc -23
    //   1365: if_icmple +806 -> 2171
    //   1368: iload 12
    //   1370: istore 13
    //   1372: iload 12
    //   1374: istore 14
    //   1376: iload 12
    //   1378: istore 15
    //   1380: aload 7
    //   1382: iload 18
    //   1384: iload 19
    //   1386: imul
    //   1387: i2d
    //   1388: invokestatic 239	java/lang/Math:sqrt	(D)D
    //   1391: ldc2_w 240
    //   1394: ddiv
    //   1395: invokestatic 244	java/lang/Math:ceil	(D)D
    //   1398: d2i
    //   1399: putfield 247	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1402: iload 12
    //   1404: istore 13
    //   1406: iload 12
    //   1408: istore 14
    //   1410: iload 12
    //   1412: istore 15
    //   1414: aload 9
    //   1416: aload 8
    //   1418: invokevirtual 215	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1421: astore_1
    //   1422: iload 12
    //   1424: istore 13
    //   1426: iload 12
    //   1428: istore 14
    //   1430: iload 12
    //   1432: istore 15
    //   1434: aload_1
    //   1435: aconst_null
    //   1436: aload 7
    //   1438: invokestatic 221	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1441: astore 10
    //   1443: iload 12
    //   1445: istore 13
    //   1447: iload 12
    //   1449: istore 14
    //   1451: iload 12
    //   1453: istore 15
    //   1455: aload_1
    //   1456: invokevirtual 226	java/io/InputStream:close	()V
    //   1459: iload 12
    //   1461: istore 13
    //   1463: iload 12
    //   1465: istore 14
    //   1467: iload 12
    //   1469: istore 15
    //   1471: aload 10
    //   1473: invokevirtual 252	android/graphics/Bitmap:getWidth	()I
    //   1476: istore 16
    //   1478: iload 12
    //   1480: istore 13
    //   1482: iload 12
    //   1484: istore 14
    //   1486: iload 12
    //   1488: istore 15
    //   1490: aload 10
    //   1492: invokevirtual 255	android/graphics/Bitmap:getHeight	()I
    //   1495: istore 17
    //   1497: iload 12
    //   1499: istore 13
    //   1501: iload 12
    //   1503: istore 14
    //   1505: iload 12
    //   1507: istore 15
    //   1509: iload 16
    //   1511: iload 17
    //   1513: imul
    //   1514: newarray <illegal type>
    //   1516: astore 6
    //   1518: iload 12
    //   1520: istore 13
    //   1522: iload 12
    //   1524: istore 14
    //   1526: iload 12
    //   1528: istore 15
    //   1530: aload 10
    //   1532: aload 6
    //   1534: iconst_0
    //   1535: iload 16
    //   1537: iconst_0
    //   1538: iconst_0
    //   1539: iload 16
    //   1541: iload 17
    //   1543: invokevirtual 259	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1546: iload 12
    //   1548: istore 13
    //   1550: iload 12
    //   1552: istore 14
    //   1554: iload 12
    //   1556: istore 15
    //   1558: aload 10
    //   1560: invokevirtual 262	android/graphics/Bitmap:recycle	()V
    //   1563: iload 12
    //   1565: istore 13
    //   1567: iload 12
    //   1569: istore 14
    //   1571: iload 12
    //   1573: istore 15
    //   1575: iload 16
    //   1577: iload 17
    //   1579: imul
    //   1580: newarray <illegal type>
    //   1582: astore 10
    //   1584: iload 12
    //   1586: istore 13
    //   1588: iload 12
    //   1590: istore 14
    //   1592: iload 12
    //   1594: istore 15
    //   1596: aload 6
    //   1598: aload 10
    //   1600: iload 16
    //   1602: iload 17
    //   1604: invokestatic 265	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   1607: pop
    //   1608: iload 12
    //   1610: istore 13
    //   1612: iload 12
    //   1614: istore 14
    //   1616: iload 12
    //   1618: istore 15
    //   1620: aload 10
    //   1622: iload 16
    //   1624: iload 17
    //   1626: iconst_0
    //   1627: invokestatic 119	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   1630: istore 16
    //   1632: iload 16
    //   1634: istore 12
    //   1636: aload_1
    //   1637: astore 6
    //   1639: iload 12
    //   1641: istore 13
    //   1643: iload 12
    //   1645: iconst_1
    //   1646: if_icmpeq +1032 -> 2678
    //   1649: iload 18
    //   1651: iconst_2
    //   1652: imul
    //   1653: iload 19
    //   1655: if_icmpgt +639 -> 2294
    //   1658: iload 18
    //   1660: sipush 1024
    //   1663: if_icmpge +631 -> 2294
    //   1666: iload 12
    //   1668: istore 13
    //   1670: iload 12
    //   1672: istore 14
    //   1674: iload 12
    //   1676: istore 15
    //   1678: aload 9
    //   1680: aload 8
    //   1682: invokevirtual 215	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1685: astore 6
    //   1687: iload 12
    //   1689: istore 13
    //   1691: iload 12
    //   1693: istore 14
    //   1695: iload 12
    //   1697: istore 15
    //   1699: iload 12
    //   1701: istore 16
    //   1703: aload 6
    //   1705: invokestatic 268	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1708: astore_1
    //   1709: iload 12
    //   1711: istore 13
    //   1713: iload 12
    //   1715: istore 14
    //   1717: iload 12
    //   1719: istore 15
    //   1721: iload 12
    //   1723: istore 16
    //   1725: aload 6
    //   1727: invokevirtual 226	java/io/InputStream:close	()V
    //   1730: iload 12
    //   1732: istore 13
    //   1734: iload 12
    //   1736: istore 14
    //   1738: iload 12
    //   1740: istore 15
    //   1742: iload 12
    //   1744: istore 16
    //   1746: iload 18
    //   1748: iload 18
    //   1750: imul
    //   1751: newarray <illegal type>
    //   1753: astore 10
    //   1755: iload 12
    //   1757: istore 13
    //   1759: iload 12
    //   1761: istore 14
    //   1763: iload 12
    //   1765: istore 15
    //   1767: iload 12
    //   1769: istore 16
    //   1771: aload_1
    //   1772: aload 10
    //   1774: iconst_0
    //   1775: iload 18
    //   1777: iconst_0
    //   1778: iconst_0
    //   1779: iload 18
    //   1781: iload 18
    //   1783: invokevirtual 259	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1786: iload 12
    //   1788: istore 13
    //   1790: iload 12
    //   1792: istore 14
    //   1794: iload 12
    //   1796: istore 15
    //   1798: iload 12
    //   1800: istore 16
    //   1802: iload 18
    //   1804: iload 18
    //   1806: imul
    //   1807: newarray <illegal type>
    //   1809: astore 11
    //   1811: iload 12
    //   1813: istore 13
    //   1815: iload 12
    //   1817: istore 14
    //   1819: iload 12
    //   1821: istore 15
    //   1823: iload 12
    //   1825: istore 16
    //   1827: aload 10
    //   1829: aload 11
    //   1831: iload 18
    //   1833: iload 18
    //   1835: invokestatic 265	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   1838: pop
    //   1839: iload 12
    //   1841: istore 13
    //   1843: iload 12
    //   1845: istore 14
    //   1847: iload 12
    //   1849: istore 15
    //   1851: iload 12
    //   1853: istore 16
    //   1855: aload 11
    //   1857: iload 18
    //   1859: iload 18
    //   1861: iconst_0
    //   1862: invokestatic 119	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   1865: istore 12
    //   1867: iload 12
    //   1869: iconst_1
    //   1870: if_icmpeq +958 -> 2828
    //   1873: iload 12
    //   1875: istore 13
    //   1877: iload 12
    //   1879: istore 14
    //   1881: iload 12
    //   1883: istore 15
    //   1885: iload 12
    //   1887: istore 16
    //   1889: aload_1
    //   1890: aload 10
    //   1892: iconst_0
    //   1893: iload 18
    //   1895: iconst_0
    //   1896: iload 19
    //   1898: iload 18
    //   1900: isub
    //   1901: iload 18
    //   1903: iload 18
    //   1905: invokevirtual 259	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1908: iload 12
    //   1910: istore 13
    //   1912: iload 12
    //   1914: istore 14
    //   1916: iload 12
    //   1918: istore 15
    //   1920: iload 12
    //   1922: istore 16
    //   1924: aload 10
    //   1926: aload 11
    //   1928: iload 18
    //   1930: iload 18
    //   1932: invokestatic 265	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   1935: pop
    //   1936: iload 12
    //   1938: istore 13
    //   1940: iload 12
    //   1942: istore 14
    //   1944: iload 12
    //   1946: istore 15
    //   1948: iload 12
    //   1950: istore 16
    //   1952: aload 11
    //   1954: iload 18
    //   1956: iload 18
    //   1958: iconst_0
    //   1959: invokestatic 119	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   1962: istore 12
    //   1964: iload 12
    //   1966: istore 13
    //   1968: iload 12
    //   1970: istore 14
    //   1972: iload 12
    //   1974: istore 15
    //   1976: aload_1
    //   1977: invokevirtual 262	android/graphics/Bitmap:recycle	()V
    //   1980: aload 6
    //   1982: astore_1
    //   1983: iload 12
    //   1985: iconst_1
    //   1986: if_icmpeq +708 -> 2694
    //   1989: iload 18
    //   1991: iload 19
    //   1993: invokestatic 272	java/lang/Math:min	(II)I
    //   1996: istore 13
    //   1998: iload 13
    //   2000: sipush 250
    //   2003: if_icmple +691 -> 2694
    //   2006: aload 7
    //   2008: iload 13
    //   2010: i2d
    //   2011: ldc2_w 273
    //   2014: ddiv
    //   2015: invokestatic 244	java/lang/Math:ceil	(D)D
    //   2018: d2i
    //   2019: putfield 247	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2022: aload 9
    //   2024: aload 8
    //   2026: invokevirtual 215	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2029: astore 6
    //   2031: aload 6
    //   2033: aconst_null
    //   2034: aload 7
    //   2036: invokestatic 221	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2039: astore 7
    //   2041: aload 6
    //   2043: invokevirtual 226	java/io/InputStream:close	()V
    //   2046: aload 7
    //   2048: invokevirtual 252	android/graphics/Bitmap:getWidth	()I
    //   2051: istore 13
    //   2053: aload 7
    //   2055: invokevirtual 255	android/graphics/Bitmap:getHeight	()I
    //   2058: istore 14
    //   2060: iload 13
    //   2062: iload 14
    //   2064: imul
    //   2065: newarray <illegal type>
    //   2067: astore_1
    //   2068: aload 7
    //   2070: aload_1
    //   2071: iconst_0
    //   2072: iload 13
    //   2074: iconst_0
    //   2075: iconst_0
    //   2076: iload 13
    //   2078: iload 14
    //   2080: invokevirtual 259	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2083: aload 7
    //   2085: invokevirtual 262	android/graphics/Bitmap:recycle	()V
    //   2088: iload 13
    //   2090: iload 14
    //   2092: imul
    //   2093: newarray <illegal type>
    //   2095: astore 7
    //   2097: aload_1
    //   2098: aload 7
    //   2100: iload 13
    //   2102: iload 14
    //   2104: invokestatic 265	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2107: pop
    //   2108: aload 7
    //   2110: iload 13
    //   2112: iload 14
    //   2114: iconst_0
    //   2115: invokestatic 119	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   2118: istore 13
    //   2120: iload 13
    //   2122: istore 12
    //   2124: iload 12
    //   2126: iconst_1
    //   2127: if_icmpne +599 -> 2726
    //   2130: new 130	java/lang/StringBuilder
    //   2133: dup
    //   2134: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   2137: astore_1
    //   2138: new 130	java/lang/StringBuilder
    //   2141: dup
    //   2142: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   2145: astore 6
    //   2147: aload_1
    //   2148: aload 6
    //   2150: invokestatic 153	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   2153: pop
    //   2154: aload_0
    //   2155: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   2158: getfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2161: iconst_3
    //   2162: aload 6
    //   2164: invokevirtual 180	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   2167: invokevirtual 183	android/os/Message:sendToTarget	()V
    //   2170: return
    //   2171: iload 12
    //   2173: istore 13
    //   2175: iload 12
    //   2177: istore 14
    //   2179: iload 12
    //   2181: istore 15
    //   2183: aload 7
    //   2185: iconst_1
    //   2186: putfield 247	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2189: goto -787 -> 1402
    //   2192: astore_1
    //   2193: iload 13
    //   2195: istore 12
    //   2197: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2200: ifeq -76 -> 2124
    //   2203: getstatic 128	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2206: iconst_2
    //   2207: aload_1
    //   2208: invokevirtual 275	java/io/IOException:toString	()Ljava/lang/String;
    //   2211: invokestatic 190	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2214: iload 13
    //   2216: istore 12
    //   2218: goto -94 -> 2124
    //   2221: astore_1
    //   2222: aload 6
    //   2224: astore_1
    //   2225: iload 12
    //   2227: istore 13
    //   2229: iload 12
    //   2231: istore 14
    //   2233: iload 12
    //   2235: istore 15
    //   2237: aload_1
    //   2238: invokevirtual 226	java/io/InputStream:close	()V
    //   2241: goto -605 -> 1636
    //   2244: astore_1
    //   2245: iload 14
    //   2247: istore 12
    //   2249: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2252: ifeq -128 -> 2124
    //   2255: getstatic 128	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2258: iconst_2
    //   2259: aload_1
    //   2260: invokevirtual 276	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   2263: invokestatic 190	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2266: iload 14
    //   2268: istore 12
    //   2270: goto -146 -> 2124
    //   2273: astore 6
    //   2275: iload 12
    //   2277: istore 13
    //   2279: iload 12
    //   2281: istore 14
    //   2283: iload 12
    //   2285: istore 15
    //   2287: aload_1
    //   2288: invokevirtual 226	java/io/InputStream:close	()V
    //   2291: goto -308 -> 1983
    //   2294: aload_1
    //   2295: astore 6
    //   2297: iload 12
    //   2299: istore 13
    //   2301: iload 18
    //   2303: iload 19
    //   2305: iconst_2
    //   2306: imul
    //   2307: if_icmplt +371 -> 2678
    //   2310: aload_1
    //   2311: astore 6
    //   2313: iload 12
    //   2315: istore 13
    //   2317: iload 19
    //   2319: sipush 1024
    //   2322: if_icmpge +356 -> 2678
    //   2325: iload 12
    //   2327: istore 13
    //   2329: iload 12
    //   2331: istore 14
    //   2333: iload 12
    //   2335: istore 15
    //   2337: aload 9
    //   2339: aload 8
    //   2341: invokevirtual 215	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2344: astore 6
    //   2346: iload 12
    //   2348: istore 13
    //   2350: iload 12
    //   2352: istore 14
    //   2354: iload 12
    //   2356: istore 15
    //   2358: iload 12
    //   2360: istore 17
    //   2362: aload 6
    //   2364: invokestatic 268	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2367: astore_1
    //   2368: iload 12
    //   2370: istore 13
    //   2372: iload 12
    //   2374: istore 14
    //   2376: iload 12
    //   2378: istore 15
    //   2380: iload 12
    //   2382: istore 17
    //   2384: aload 6
    //   2386: invokevirtual 226	java/io/InputStream:close	()V
    //   2389: iload 12
    //   2391: istore 13
    //   2393: iload 12
    //   2395: istore 14
    //   2397: iload 12
    //   2399: istore 15
    //   2401: iload 12
    //   2403: istore 17
    //   2405: iload 19
    //   2407: iload 19
    //   2409: imul
    //   2410: newarray <illegal type>
    //   2412: astore 10
    //   2414: iload 12
    //   2416: istore 13
    //   2418: iload 12
    //   2420: istore 14
    //   2422: iload 12
    //   2424: istore 15
    //   2426: iload 12
    //   2428: istore 17
    //   2430: aload_1
    //   2431: aload 10
    //   2433: iconst_0
    //   2434: iload 19
    //   2436: iconst_0
    //   2437: iconst_0
    //   2438: iload 19
    //   2440: iload 19
    //   2442: invokevirtual 259	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2445: iload 12
    //   2447: istore 13
    //   2449: iload 12
    //   2451: istore 14
    //   2453: iload 12
    //   2455: istore 15
    //   2457: iload 12
    //   2459: istore 17
    //   2461: iload 19
    //   2463: iload 19
    //   2465: imul
    //   2466: newarray <illegal type>
    //   2468: astore 11
    //   2470: iload 12
    //   2472: istore 13
    //   2474: iload 12
    //   2476: istore 14
    //   2478: iload 12
    //   2480: istore 15
    //   2482: iload 12
    //   2484: istore 17
    //   2486: aload 10
    //   2488: aload 11
    //   2490: iload 19
    //   2492: iload 19
    //   2494: invokestatic 265	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2497: pop
    //   2498: iload 12
    //   2500: istore 13
    //   2502: iload 12
    //   2504: istore 14
    //   2506: iload 12
    //   2508: istore 15
    //   2510: iload 12
    //   2512: istore 17
    //   2514: aload 11
    //   2516: iload 19
    //   2518: iload 19
    //   2520: iconst_0
    //   2521: invokestatic 119	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   2524: istore 16
    //   2526: iload 16
    //   2528: istore 12
    //   2530: iload 16
    //   2532: iconst_1
    //   2533: if_icmpeq +94 -> 2627
    //   2536: iload 16
    //   2538: istore 13
    //   2540: iload 16
    //   2542: istore 14
    //   2544: iload 16
    //   2546: istore 15
    //   2548: iload 16
    //   2550: istore 17
    //   2552: aload_1
    //   2553: aload 10
    //   2555: iconst_0
    //   2556: iload 19
    //   2558: iload 18
    //   2560: iload 19
    //   2562: isub
    //   2563: iconst_0
    //   2564: iload 19
    //   2566: iload 19
    //   2568: invokevirtual 259	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2571: iload 16
    //   2573: istore 13
    //   2575: iload 16
    //   2577: istore 14
    //   2579: iload 16
    //   2581: istore 15
    //   2583: iload 16
    //   2585: istore 17
    //   2587: aload 10
    //   2589: aload 11
    //   2591: iload 19
    //   2593: iload 19
    //   2595: invokestatic 265	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2598: pop
    //   2599: iload 16
    //   2601: istore 13
    //   2603: iload 16
    //   2605: istore 14
    //   2607: iload 16
    //   2609: istore 15
    //   2611: iload 16
    //   2613: istore 17
    //   2615: aload 11
    //   2617: iload 19
    //   2619: iload 19
    //   2621: iconst_0
    //   2622: invokestatic 119	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   2625: istore 12
    //   2627: iload 12
    //   2629: istore 13
    //   2631: iload 12
    //   2633: istore 14
    //   2635: iload 12
    //   2637: istore 15
    //   2639: iload 12
    //   2641: istore 17
    //   2643: aload_1
    //   2644: invokevirtual 262	android/graphics/Bitmap:recycle	()V
    //   2647: aload 6
    //   2649: astore_1
    //   2650: goto -667 -> 1983
    //   2653: astore 6
    //   2655: iload 12
    //   2657: istore 13
    //   2659: iload 12
    //   2661: istore 14
    //   2663: iload 12
    //   2665: istore 15
    //   2667: aload_1
    //   2668: invokevirtual 226	java/io/InputStream:close	()V
    //   2671: iload 12
    //   2673: istore 13
    //   2675: aload_1
    //   2676: astore 6
    //   2678: iload 13
    //   2680: istore 12
    //   2682: aload 6
    //   2684: astore_1
    //   2685: goto -702 -> 1983
    //   2688: astore 6
    //   2690: aload_1
    //   2691: invokevirtual 226	java/io/InputStream:close	()V
    //   2694: goto -570 -> 2124
    //   2697: astore_1
    //   2698: iload 15
    //   2700: istore 12
    //   2702: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2705: ifeq -581 -> 2124
    //   2708: getstatic 128	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2711: iconst_2
    //   2712: aload_1
    //   2713: invokevirtual 191	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   2716: invokestatic 190	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2719: iload 15
    //   2721: istore 12
    //   2723: goto -599 -> 2124
    //   2726: aload_0
    //   2727: getfield 10	jjj:a	Lcom/tencent/biz/widgets/ScannerView;
    //   2730: getfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2733: iconst_4
    //   2734: invokevirtual 55	android/os/Handler:sendEmptyMessage	(I)Z
    //   2737: pop
    //   2738: return
    //   2739: astore_1
    //   2740: iload 13
    //   2742: istore 15
    //   2744: goto -46 -> 2698
    //   2747: astore_1
    //   2748: iload 12
    //   2750: istore 15
    //   2752: goto -54 -> 2698
    //   2755: astore_1
    //   2756: goto -511 -> 2245
    //   2759: astore_1
    //   2760: iload 12
    //   2762: istore 14
    //   2764: goto -519 -> 2245
    //   2767: astore_1
    //   2768: iload 15
    //   2770: istore 13
    //   2772: goto -579 -> 2193
    //   2775: astore_1
    //   2776: iload 12
    //   2778: istore 13
    //   2780: goto -587 -> 2193
    //   2783: astore_1
    //   2784: aload 6
    //   2786: astore_1
    //   2787: goto -97 -> 2690
    //   2790: astore_1
    //   2791: aload 6
    //   2793: astore_1
    //   2794: iload 17
    //   2796: istore 12
    //   2798: goto -143 -> 2655
    //   2801: astore_1
    //   2802: aload 6
    //   2804: astore_1
    //   2805: iload 16
    //   2807: istore 12
    //   2809: goto -534 -> 2275
    //   2812: astore_1
    //   2813: aload 6
    //   2815: astore_1
    //   2816: goto -541 -> 2275
    //   2819: astore 6
    //   2821: goto -596 -> 2225
    //   2824: astore_1
    //   2825: goto -1710 -> 1115
    //   2828: goto -864 -> 1964
    //   2831: iconst_0
    //   2832: istore 12
    //   2834: goto -2305 -> 529
    //   2837: goto -2508 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2840	0	this	jjj
    //   0	2840	1	paramMessage	android.os.Message
    //   536	28	2	d	double
    //   240	821	4	f1	float
    //   259	816	5	f2	float
    //   33	665	6	localObject1	Object
    //   1085	13	6	localOutOfMemoryError1	OutOfMemoryError
    //   1106	1117	6	localObject2	Object
    //   2273	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   2295	353	6	localObject3	Object
    //   2653	1	6	localOutOfMemoryError3	OutOfMemoryError
    //   2676	7	6	localMessage	android.os.Message
    //   2688	126	6	localOutOfMemoryError4	OutOfMemoryError
    //   2819	1	6	localOutOfMemoryError5	OutOfMemoryError
    //   87	2097	7	localObject4	Object
    //   337	2003	8	localObject5	Object
    //   1202	1136	9	localContentResolver	android.content.ContentResolver
    //   1441	1147	10	localObject6	Object
    //   1809	807	11	arrayOfByte	byte[]
    //   109	2724	12	i	int
    //   113	2666	13	j	int
    //   101	2662	14	k	int
    //   106	2663	15	m	int
    //   1476	1330	16	n	int
    //   1495	1300	17	i1	int
    //   1319	1244	18	i2	int
    //   1338	1282	19	i3	int
    //   332	201	20	l	long
    // Exception table:
    //   from	to	target	type
    //   339	356	1085	java/lang/OutOfMemoryError
    //   329	339	1111	java/lang/UnsatisfiedLinkError
    //   339	356	1111	java/lang/UnsatisfiedLinkError
    //   361	529	1111	java/lang/UnsatisfiedLinkError
    //   1087	1105	1111	java/lang/UnsatisfiedLinkError
    //   1171	1180	2192	java/io/IOException
    //   1192	1204	2192	java/io/IOException
    //   1216	1225	2192	java/io/IOException
    //   1237	1243	2192	java/io/IOException
    //   1255	1264	2192	java/io/IOException
    //   1276	1285	2192	java/io/IOException
    //   1297	1302	2192	java/io/IOException
    //   1314	1321	2192	java/io/IOException
    //   1333	1340	2192	java/io/IOException
    //   1352	1358	2192	java/io/IOException
    //   1380	1402	2192	java/io/IOException
    //   1414	1422	2192	java/io/IOException
    //   1434	1443	2192	java/io/IOException
    //   1455	1459	2192	java/io/IOException
    //   1471	1478	2192	java/io/IOException
    //   1490	1497	2192	java/io/IOException
    //   1509	1518	2192	java/io/IOException
    //   1530	1546	2192	java/io/IOException
    //   1558	1563	2192	java/io/IOException
    //   1575	1584	2192	java/io/IOException
    //   1596	1608	2192	java/io/IOException
    //   1620	1632	2192	java/io/IOException
    //   1678	1687	2192	java/io/IOException
    //   1703	1709	2192	java/io/IOException
    //   1725	1730	2192	java/io/IOException
    //   1746	1755	2192	java/io/IOException
    //   1771	1786	2192	java/io/IOException
    //   1802	1811	2192	java/io/IOException
    //   1827	1839	2192	java/io/IOException
    //   1855	1867	2192	java/io/IOException
    //   1889	1908	2192	java/io/IOException
    //   1924	1936	2192	java/io/IOException
    //   1952	1964	2192	java/io/IOException
    //   2183	2189	2192	java/io/IOException
    //   2237	2241	2192	java/io/IOException
    //   2337	2346	2192	java/io/IOException
    //   2362	2368	2192	java/io/IOException
    //   2384	2389	2192	java/io/IOException
    //   2405	2414	2192	java/io/IOException
    //   2430	2445	2192	java/io/IOException
    //   2461	2470	2192	java/io/IOException
    //   2486	2498	2192	java/io/IOException
    //   2514	2526	2192	java/io/IOException
    //   2552	2571	2192	java/io/IOException
    //   2587	2599	2192	java/io/IOException
    //   2615	2627	2192	java/io/IOException
    //   2643	2647	2192	java/io/IOException
    //   2667	2671	2192	java/io/IOException
    //   1414	1422	2221	java/lang/OutOfMemoryError
    //   1171	1180	2244	java/lang/RuntimeException
    //   1192	1204	2244	java/lang/RuntimeException
    //   1216	1225	2244	java/lang/RuntimeException
    //   1237	1243	2244	java/lang/RuntimeException
    //   1255	1264	2244	java/lang/RuntimeException
    //   1276	1285	2244	java/lang/RuntimeException
    //   1297	1302	2244	java/lang/RuntimeException
    //   1314	1321	2244	java/lang/RuntimeException
    //   1333	1340	2244	java/lang/RuntimeException
    //   1352	1358	2244	java/lang/RuntimeException
    //   1380	1402	2244	java/lang/RuntimeException
    //   1414	1422	2244	java/lang/RuntimeException
    //   1434	1443	2244	java/lang/RuntimeException
    //   1455	1459	2244	java/lang/RuntimeException
    //   1471	1478	2244	java/lang/RuntimeException
    //   1490	1497	2244	java/lang/RuntimeException
    //   1509	1518	2244	java/lang/RuntimeException
    //   1530	1546	2244	java/lang/RuntimeException
    //   1558	1563	2244	java/lang/RuntimeException
    //   1575	1584	2244	java/lang/RuntimeException
    //   1596	1608	2244	java/lang/RuntimeException
    //   1620	1632	2244	java/lang/RuntimeException
    //   1678	1687	2244	java/lang/RuntimeException
    //   1703	1709	2244	java/lang/RuntimeException
    //   1725	1730	2244	java/lang/RuntimeException
    //   1746	1755	2244	java/lang/RuntimeException
    //   1771	1786	2244	java/lang/RuntimeException
    //   1802	1811	2244	java/lang/RuntimeException
    //   1827	1839	2244	java/lang/RuntimeException
    //   1855	1867	2244	java/lang/RuntimeException
    //   1889	1908	2244	java/lang/RuntimeException
    //   1924	1936	2244	java/lang/RuntimeException
    //   1952	1964	2244	java/lang/RuntimeException
    //   2183	2189	2244	java/lang/RuntimeException
    //   2237	2241	2244	java/lang/RuntimeException
    //   2337	2346	2244	java/lang/RuntimeException
    //   2362	2368	2244	java/lang/RuntimeException
    //   2384	2389	2244	java/lang/RuntimeException
    //   2405	2414	2244	java/lang/RuntimeException
    //   2430	2445	2244	java/lang/RuntimeException
    //   2461	2470	2244	java/lang/RuntimeException
    //   2486	2498	2244	java/lang/RuntimeException
    //   2514	2526	2244	java/lang/RuntimeException
    //   2552	2571	2244	java/lang/RuntimeException
    //   2587	2599	2244	java/lang/RuntimeException
    //   2615	2627	2244	java/lang/RuntimeException
    //   2643	2647	2244	java/lang/RuntimeException
    //   2667	2671	2244	java/lang/RuntimeException
    //   1678	1687	2273	java/lang/OutOfMemoryError
    //   2337	2346	2653	java/lang/OutOfMemoryError
    //   2022	2031	2688	java/lang/OutOfMemoryError
    //   1171	1180	2697	java/lang/UnsatisfiedLinkError
    //   1192	1204	2697	java/lang/UnsatisfiedLinkError
    //   1216	1225	2697	java/lang/UnsatisfiedLinkError
    //   1237	1243	2697	java/lang/UnsatisfiedLinkError
    //   1255	1264	2697	java/lang/UnsatisfiedLinkError
    //   1276	1285	2697	java/lang/UnsatisfiedLinkError
    //   1297	1302	2697	java/lang/UnsatisfiedLinkError
    //   1314	1321	2697	java/lang/UnsatisfiedLinkError
    //   1333	1340	2697	java/lang/UnsatisfiedLinkError
    //   1352	1358	2697	java/lang/UnsatisfiedLinkError
    //   1380	1402	2697	java/lang/UnsatisfiedLinkError
    //   1414	1422	2697	java/lang/UnsatisfiedLinkError
    //   1434	1443	2697	java/lang/UnsatisfiedLinkError
    //   1455	1459	2697	java/lang/UnsatisfiedLinkError
    //   1471	1478	2697	java/lang/UnsatisfiedLinkError
    //   1490	1497	2697	java/lang/UnsatisfiedLinkError
    //   1509	1518	2697	java/lang/UnsatisfiedLinkError
    //   1530	1546	2697	java/lang/UnsatisfiedLinkError
    //   1558	1563	2697	java/lang/UnsatisfiedLinkError
    //   1575	1584	2697	java/lang/UnsatisfiedLinkError
    //   1596	1608	2697	java/lang/UnsatisfiedLinkError
    //   1620	1632	2697	java/lang/UnsatisfiedLinkError
    //   1678	1687	2697	java/lang/UnsatisfiedLinkError
    //   1703	1709	2697	java/lang/UnsatisfiedLinkError
    //   1725	1730	2697	java/lang/UnsatisfiedLinkError
    //   1746	1755	2697	java/lang/UnsatisfiedLinkError
    //   1771	1786	2697	java/lang/UnsatisfiedLinkError
    //   1802	1811	2697	java/lang/UnsatisfiedLinkError
    //   1827	1839	2697	java/lang/UnsatisfiedLinkError
    //   1855	1867	2697	java/lang/UnsatisfiedLinkError
    //   1889	1908	2697	java/lang/UnsatisfiedLinkError
    //   1924	1936	2697	java/lang/UnsatisfiedLinkError
    //   1952	1964	2697	java/lang/UnsatisfiedLinkError
    //   2183	2189	2697	java/lang/UnsatisfiedLinkError
    //   2237	2241	2697	java/lang/UnsatisfiedLinkError
    //   2337	2346	2697	java/lang/UnsatisfiedLinkError
    //   2362	2368	2697	java/lang/UnsatisfiedLinkError
    //   2384	2389	2697	java/lang/UnsatisfiedLinkError
    //   2405	2414	2697	java/lang/UnsatisfiedLinkError
    //   2430	2445	2697	java/lang/UnsatisfiedLinkError
    //   2461	2470	2697	java/lang/UnsatisfiedLinkError
    //   2486	2498	2697	java/lang/UnsatisfiedLinkError
    //   2514	2526	2697	java/lang/UnsatisfiedLinkError
    //   2552	2571	2697	java/lang/UnsatisfiedLinkError
    //   2587	2599	2697	java/lang/UnsatisfiedLinkError
    //   2615	2627	2697	java/lang/UnsatisfiedLinkError
    //   2643	2647	2697	java/lang/UnsatisfiedLinkError
    //   2667	2671	2697	java/lang/UnsatisfiedLinkError
    //   1976	1980	2739	java/lang/UnsatisfiedLinkError
    //   2287	2291	2739	java/lang/UnsatisfiedLinkError
    //   1989	1998	2747	java/lang/UnsatisfiedLinkError
    //   2006	2022	2747	java/lang/UnsatisfiedLinkError
    //   2022	2031	2747	java/lang/UnsatisfiedLinkError
    //   2031	2120	2747	java/lang/UnsatisfiedLinkError
    //   2690	2694	2747	java/lang/UnsatisfiedLinkError
    //   1976	1980	2755	java/lang/RuntimeException
    //   2287	2291	2755	java/lang/RuntimeException
    //   1989	1998	2759	java/lang/RuntimeException
    //   2006	2022	2759	java/lang/RuntimeException
    //   2022	2031	2759	java/lang/RuntimeException
    //   2031	2120	2759	java/lang/RuntimeException
    //   2690	2694	2759	java/lang/RuntimeException
    //   1976	1980	2767	java/io/IOException
    //   2287	2291	2767	java/io/IOException
    //   1989	1998	2775	java/io/IOException
    //   2006	2022	2775	java/io/IOException
    //   2022	2031	2775	java/io/IOException
    //   2031	2120	2775	java/io/IOException
    //   2690	2694	2775	java/io/IOException
    //   2031	2120	2783	java/lang/OutOfMemoryError
    //   2362	2368	2790	java/lang/OutOfMemoryError
    //   2384	2389	2790	java/lang/OutOfMemoryError
    //   2405	2414	2790	java/lang/OutOfMemoryError
    //   2430	2445	2790	java/lang/OutOfMemoryError
    //   2461	2470	2790	java/lang/OutOfMemoryError
    //   2486	2498	2790	java/lang/OutOfMemoryError
    //   2514	2526	2790	java/lang/OutOfMemoryError
    //   2552	2571	2790	java/lang/OutOfMemoryError
    //   2587	2599	2790	java/lang/OutOfMemoryError
    //   2615	2627	2790	java/lang/OutOfMemoryError
    //   2643	2647	2790	java/lang/OutOfMemoryError
    //   1703	1709	2801	java/lang/OutOfMemoryError
    //   1725	1730	2801	java/lang/OutOfMemoryError
    //   1746	1755	2801	java/lang/OutOfMemoryError
    //   1771	1786	2801	java/lang/OutOfMemoryError
    //   1802	1811	2801	java/lang/OutOfMemoryError
    //   1827	1839	2801	java/lang/OutOfMemoryError
    //   1855	1867	2801	java/lang/OutOfMemoryError
    //   1889	1908	2801	java/lang/OutOfMemoryError
    //   1924	1936	2801	java/lang/OutOfMemoryError
    //   1952	1964	2801	java/lang/OutOfMemoryError
    //   1976	1980	2812	java/lang/OutOfMemoryError
    //   1434	1443	2819	java/lang/OutOfMemoryError
    //   1455	1459	2819	java/lang/OutOfMemoryError
    //   1471	1478	2819	java/lang/OutOfMemoryError
    //   1490	1497	2819	java/lang/OutOfMemoryError
    //   1509	1518	2819	java/lang/OutOfMemoryError
    //   1530	1546	2819	java/lang/OutOfMemoryError
    //   1558	1563	2819	java/lang/OutOfMemoryError
    //   1575	1584	2819	java/lang/OutOfMemoryError
    //   1596	1608	2819	java/lang/OutOfMemoryError
    //   1620	1632	2819	java/lang/OutOfMemoryError
    //   529	537	2824	java/lang/UnsatisfiedLinkError
    //   541	573	2824	java/lang/UnsatisfiedLinkError
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */