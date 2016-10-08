import com.hiar.sdk.HSARToolkit;
import com.hiar.sdk.camera.CameraPreviewHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ahf
  extends Thread
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  
  public ahf(CameraPreviewHandler paramCameraPreviewHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfByte = new byte[CameraPreviewHandler.a(this.jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler) * CameraPreviewHandler.b(this.jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler)];
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    setDaemon(true);
    start();
  }
  
  public void a()
  {
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (getState() == Thread.State.WAITING)
    {
      this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
      this.jdField_c_of_type_Long = HSARToolkit.a().jdField_a_of_type_Long;
      this.jdField_b_of_type_Boolean = true;
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 83
    //   5: invokevirtual 87	ahf:setName	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   12: putfield 94	ahf:jdField_a_of_type_Long	J
    //   15: iconst_1
    //   16: anewarray 96	com/hiar/sdk/core/HiarqTargetInfo
    //   19: astore_1
    //   20: aload_1
    //   21: iconst_0
    //   22: new 96	com/hiar/sdk/core/HiarqTargetInfo
    //   25: dup
    //   26: invokespecial 97	com/hiar/sdk/core/HiarqTargetInfo:<init>	()V
    //   29: aastore
    //   30: bipush 12
    //   32: newarray <illegal type>
    //   34: astore_2
    //   35: aload_1
    //   36: iconst_0
    //   37: aaload
    //   38: aload_2
    //   39: putfield 101	com/hiar/sdk/core/HiarqTargetInfo:pose	[F
    //   42: iconst_1
    //   43: anewarray 103	com/hiar/sdk/core/HiarqMarkerInfo
    //   46: astore_3
    //   47: aload_3
    //   48: iconst_0
    //   49: new 103	com/hiar/sdk/core/HiarqMarkerInfo
    //   52: dup
    //   53: invokespecial 104	com/hiar/sdk/core/HiarqMarkerInfo:<init>	()V
    //   56: aastore
    //   57: aload_0
    //   58: getfield 39	ahf:jdField_c_of_type_Boolean	Z
    //   61: ifeq +43 -> 104
    //   64: aload_0
    //   65: getfield 71	ahf:jdField_b_of_type_Boolean	Z
    //   68: ifne +25 -> 93
    //   71: aload_0
    //   72: getfield 39	ahf:jdField_c_of_type_Boolean	Z
    //   75: istore 15
    //   77: iload 15
    //   79: ifeq +14 -> 93
    //   82: aload_0
    //   83: invokevirtual 107	java/lang/Object:wait	()V
    //   86: goto -22 -> 64
    //   89: astore_2
    //   90: goto -26 -> 64
    //   93: aload_0
    //   94: getfield 39	ahf:jdField_c_of_type_Boolean	Z
    //   97: istore 15
    //   99: iload 15
    //   101: ifne +6 -> 107
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: aload_0
    //   108: iconst_0
    //   109: putfield 71	ahf:jdField_b_of_type_Boolean	Z
    //   112: aload_0
    //   113: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   116: invokestatic 110	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Ljava/lang/Object;
    //   119: astore_2
    //   120: aload_2
    //   121: monitorenter
    //   122: aload_0
    //   123: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   126: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   129: ifnull +14 -> 143
    //   132: aload_0
    //   133: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   136: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   139: iconst_1
    //   140: putfield 118	com/hiar/sdk/core/HiarqOptions:viewFinderEnable	Z
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 35	ahf:jdField_a_of_type_Int	I
    //   148: iconst_1
    //   149: iadd
    //   150: putfield 35	ahf:jdField_a_of_type_Int	I
    //   153: aload_0
    //   154: getfield 69	ahf:jdField_c_of_type_Long	J
    //   157: lstore 9
    //   159: aload_0
    //   160: getfield 49	ahf:jdField_b_of_type_ArrayOfByte	[B
    //   163: iconst_0
    //   164: aload_0
    //   165: getfield 33	ahf:jdField_a_of_type_ArrayOfByte	[B
    //   168: iconst_0
    //   169: aload_0
    //   170: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   173: invokestatic 29	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)I
    //   176: aload_0
    //   177: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   180: invokestatic 31	com/hiar/sdk/camera/CameraPreviewHandler:b	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)I
    //   183: imul
    //   184: invokestatic 122	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   187: iconst_m1
    //   188: istore 6
    //   190: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   193: getfield 124	com/hiar/sdk/HSARToolkit:jdField_c_of_type_Int	I
    //   196: istore 8
    //   198: iload 8
    //   200: ifeq +9 -> 209
    //   203: iload 8
    //   205: iconst_1
    //   206: if_icmpne +505 -> 711
    //   209: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   212: lstore 11
    //   214: iload 6
    //   216: istore 7
    //   218: aload_0
    //   219: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   222: getfield 127	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   225: astore 4
    //   227: iload 6
    //   229: istore 7
    //   231: aload 4
    //   233: monitorenter
    //   234: aload_0
    //   235: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   238: getfield 128	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_Long	J
    //   241: aload_0
    //   242: getfield 33	ahf:jdField_a_of_type_ArrayOfByte	[B
    //   245: aload_1
    //   246: invokestatic 134	com/hiar/sdk/core/NativeInterface:hiarqTrack	(J[B[Lcom/hiar/sdk/core/HiarqTargetInfo;)I
    //   249: istore 7
    //   251: iload 7
    //   253: istore 6
    //   255: aload 4
    //   257: monitorexit
    //   258: iload 7
    //   260: istore 6
    //   262: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   265: lstore 13
    //   267: aload_0
    //   268: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   271: invokestatic 137	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/tencent/mobileqq/ar/FramePerformanceMonitor;
    //   274: lload 13
    //   276: lload 11
    //   278: lsub
    //   279: invokevirtual 142	com/tencent/mobileqq/ar/FramePerformanceMonitor:a	(J)Z
    //   282: pop
    //   283: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   286: lload 13
    //   288: lload 11
    //   290: lsub
    //   291: putfield 145	com/hiar/sdk/HSARToolkit:e	J
    //   294: ldc -109
    //   296: aload_0
    //   297: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   300: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   303: getfield 150	com/hiar/sdk/core/HiarqOptions:trackingQuality	I
    //   306: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   309: getfield 145	com/hiar/sdk/HSARToolkit:e	J
    //   312: invokestatic 155	com/tencent/mobileqq/ar/ReportUtil:a	(Ljava/lang/String;IJ)V
    //   315: new 157	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   322: ldc -96
    //   324: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   330: getfield 145	com/hiar/sdk/HSARToolkit:e	J
    //   333: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 175	com/tencent/mobileqq/ar/TraceUtil:b	(Ljava/lang/String;)V
    //   342: iload 6
    //   344: iconst_1
    //   345: if_icmpne +545 -> 890
    //   348: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   351: aload_1
    //   352: iconst_0
    //   353: aaload
    //   354: getfield 178	com/hiar/sdk/core/HiarqTargetInfo:state	I
    //   357: putfield 124	com/hiar/sdk/HSARToolkit:jdField_c_of_type_Int	I
    //   360: aload_0
    //   361: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   364: invokestatic 181	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Landroid/os/Handler;
    //   367: iconst_1
    //   368: invokevirtual 187	android/os/Handler:sendEmptyMessage	(I)Z
    //   371: pop
    //   372: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   375: getfield 124	com/hiar/sdk/HSARToolkit:jdField_c_of_type_Int	I
    //   378: istore 6
    //   380: iload 6
    //   382: iconst_1
    //   383: if_icmpne +692 -> 1075
    //   386: aload_0
    //   387: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   390: getfield 189	com/hiar/sdk/camera/CameraPreviewHandler:jdField_b_of_type_Long	J
    //   393: aload_1
    //   394: iconst_0
    //   395: aaload
    //   396: getfield 192	com/hiar/sdk/core/HiarqTargetInfo:markerIndex	I
    //   399: aload_3
    //   400: invokestatic 196	com/hiar/sdk/core/NativeInterface:hiarqGetMarkerInfo	(JI[Lcom/hiar/sdk/core/HiarqMarkerInfo;)I
    //   403: pop
    //   404: aload_3
    //   405: iconst_0
    //   406: aaload
    //   407: getfield 199	com/hiar/sdk/core/HiarqMarkerInfo:width	I
    //   410: istore 6
    //   412: aload_3
    //   413: iconst_0
    //   414: aaload
    //   415: getfield 202	com/hiar/sdk/core/HiarqMarkerInfo:height	I
    //   418: istore 7
    //   420: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   423: getfield 124	com/hiar/sdk/HSARToolkit:jdField_c_of_type_Int	I
    //   426: iconst_1
    //   427: if_icmpne +566 -> 993
    //   430: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   433: lload 9
    //   435: putfield 203	com/hiar/sdk/HSARToolkit:jdField_c_of_type_Long	J
    //   438: aload_0
    //   439: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   442: invokestatic 206	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Ljava/util/Map;
    //   445: aload_3
    //   446: iconst_0
    //   447: aaload
    //   448: getfield 210	com/hiar/sdk/core/HiarqMarkerInfo:name	Ljava/lang/String;
    //   451: invokeinterface 216 2 0
    //   456: checkcast 218	com/tencent/mobileqq/ar/model/ArResourceInfo
    //   459: astore 4
    //   461: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   464: new 220	com/tencent/mobileqq/ar/ARTarget
    //   467: dup
    //   468: aload 4
    //   470: invokespecial 223	com/tencent/mobileqq/ar/ARTarget:<init>	(Lcom/tencent/mobileqq/ar/model/ArResourceInfo;)V
    //   473: putfield 226	com/hiar/sdk/HSARToolkit:jdField_a_of_type_ComTencentMobileqqArARTarget	Lcom/tencent/mobileqq/ar/ARTarget;
    //   476: aload_0
    //   477: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   480: invokestatic 229	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/tencent/mobileqq/ar/ARGLSurfaceView;
    //   483: invokevirtual 234	com/tencent/mobileqq/ar/ARGLSurfaceView:requestRender	()V
    //   486: iload 8
    //   488: iconst_1
    //   489: if_icmpeq +140 -> 629
    //   492: getstatic 235	com/tencent/mobileqq/ar/ReportUtil:jdField_a_of_type_Int	I
    //   495: iconst_1
    //   496: iadd
    //   497: putstatic 235	com/tencent/mobileqq/ar/ReportUtil:jdField_a_of_type_Int	I
    //   500: aload_0
    //   501: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   504: getfield 238	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   507: invokevirtual 243	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   510: checkcast 245	com/tencent/mobileqq/ar/ARListener
    //   513: astore 4
    //   515: aload 4
    //   517: ifnull +17 -> 534
    //   520: aload 4
    //   522: iconst_1
    //   523: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   526: getfield 226	com/hiar/sdk/HSARToolkit:jdField_a_of_type_ComTencentMobileqqArARTarget	Lcom/tencent/mobileqq/ar/ARTarget;
    //   529: invokeinterface 248 3 0
    //   534: aload_0
    //   535: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   538: invokestatic 229	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/tencent/mobileqq/ar/ARGLSurfaceView;
    //   541: invokevirtual 250	com/tencent/mobileqq/ar/ARGLSurfaceView:c	()V
    //   544: aload_0
    //   545: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   548: invokestatic 253	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/renderer/HSRenderer;
    //   551: iconst_1
    //   552: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   555: getfield 226	com/hiar/sdk/HSARToolkit:jdField_a_of_type_ComTencentMobileqqArARTarget	Lcom/tencent/mobileqq/ar/ARTarget;
    //   558: invokevirtual 256	com/hiar/sdk/renderer/HSRenderer:a	(ILcom/tencent/mobileqq/ar/ARTarget;)V
    //   561: aload_0
    //   562: getfield 37	ahf:jdField_a_of_type_Boolean	Z
    //   565: ifne +369 -> 934
    //   568: aload_0
    //   569: iconst_1
    //   570: putfield 37	ahf:jdField_a_of_type_Boolean	Z
    //   573: new 157	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 258
    //   583: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   589: aload_0
    //   590: getfield 94	ahf:jdField_a_of_type_Long	J
    //   593: lsub
    //   594: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   597: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 175	com/tencent/mobileqq/ar/TraceUtil:b	(Ljava/lang/String;)V
    //   603: new 157	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   610: ldc_w 260
    //   613: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload_0
    //   617: getfield 35	ahf:jdField_a_of_type_Int	I
    //   620: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   623: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 175	com/tencent/mobileqq/ar/TraceUtil:b	(Ljava/lang/String;)V
    //   629: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   632: iload 6
    //   634: iload 7
    //   636: aload_1
    //   637: iconst_0
    //   638: aaload
    //   639: getfield 101	com/hiar/sdk/core/HiarqTargetInfo:pose	[F
    //   642: invokevirtual 266	com/hiar/sdk/HSARToolkit:a	(II[F)Z
    //   645: pop
    //   646: aload_0
    //   647: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   650: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   653: ifnull +14 -> 667
    //   656: aload_0
    //   657: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   660: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   663: iconst_0
    //   664: putfield 118	com/hiar/sdk/core/HiarqOptions:viewFinderEnable	Z
    //   667: invokestatic 269	ahf:yield	()V
    //   670: aload_2
    //   671: monitorexit
    //   672: goto -615 -> 57
    //   675: astore_1
    //   676: aload_2
    //   677: monitorexit
    //   678: aload_1
    //   679: athrow
    //   680: astore_1
    //   681: aload_0
    //   682: monitorexit
    //   683: aload_1
    //   684: athrow
    //   685: astore 5
    //   687: aload 4
    //   689: monitorexit
    //   690: iload 6
    //   692: istore 7
    //   694: aload 5
    //   696: athrow
    //   697: astore 4
    //   699: aload 4
    //   701: invokevirtual 272	java/lang/Exception:printStackTrace	()V
    //   704: iload 7
    //   706: istore 6
    //   708: goto -446 -> 262
    //   711: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   714: lstore 11
    //   716: iload 6
    //   718: istore 7
    //   720: aload_0
    //   721: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   724: getfield 127	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   727: astore 4
    //   729: iload 6
    //   731: istore 7
    //   733: aload 4
    //   735: monitorenter
    //   736: aload_0
    //   737: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   740: getfield 128	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_Long	J
    //   743: aload_0
    //   744: getfield 33	ahf:jdField_a_of_type_ArrayOfByte	[B
    //   747: aload_1
    //   748: invokestatic 275	com/hiar/sdk/core/NativeInterface:hiarqRecognize	(J[B[Lcom/hiar/sdk/core/HiarqTargetInfo;)I
    //   751: istore 7
    //   753: iload 7
    //   755: istore 6
    //   757: aload 4
    //   759: monitorexit
    //   760: iload 7
    //   762: istore 6
    //   764: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   767: lstore 13
    //   769: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   772: lload 13
    //   774: lload 11
    //   776: lsub
    //   777: putfield 278	com/hiar/sdk/HSARToolkit:d	J
    //   780: ldc_w 280
    //   783: aload_0
    //   784: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   787: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   790: getfield 283	com/hiar/sdk/core/HiarqOptions:recogQuality	I
    //   793: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   796: getfield 278	com/hiar/sdk/HSARToolkit:d	J
    //   799: invokestatic 155	com/tencent/mobileqq/ar/ReportUtil:a	(Ljava/lang/String;IJ)V
    //   802: new 157	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   809: ldc_w 285
    //   812: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   818: getfield 278	com/hiar/sdk/HSARToolkit:d	J
    //   821: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   824: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 175	com/tencent/mobileqq/ar/TraceUtil:b	(Ljava/lang/String;)V
    //   830: goto -488 -> 342
    //   833: astore 4
    //   835: aload 4
    //   837: invokevirtual 272	java/lang/Exception:printStackTrace	()V
    //   840: aload_0
    //   841: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   844: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   847: ifnull -180 -> 667
    //   850: aload_0
    //   851: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   854: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   857: iconst_0
    //   858: putfield 118	com/hiar/sdk/core/HiarqOptions:viewFinderEnable	Z
    //   861: goto -194 -> 667
    //   864: astore 5
    //   866: aload 4
    //   868: monitorexit
    //   869: iload 6
    //   871: istore 7
    //   873: aload 5
    //   875: athrow
    //   876: astore 4
    //   878: aload 4
    //   880: invokevirtual 272	java/lang/Exception:printStackTrace	()V
    //   883: iload 7
    //   885: istore 6
    //   887: goto -123 -> 764
    //   890: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   893: iconst_2
    //   894: putfield 124	com/hiar/sdk/HSARToolkit:jdField_c_of_type_Int	I
    //   897: goto -537 -> 360
    //   900: astore_1
    //   901: aload_0
    //   902: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   905: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   908: ifnull +14 -> 922
    //   911: aload_0
    //   912: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   915: invokestatic 113	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   918: iconst_0
    //   919: putfield 118	com/hiar/sdk/core/HiarqOptions:viewFinderEnable	Z
    //   922: aload_1
    //   923: athrow
    //   924: astore 4
    //   926: aload 4
    //   928: invokevirtual 272	java/lang/Exception:printStackTrace	()V
    //   931: goto -527 -> 404
    //   934: new 157	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   941: ldc_w 287
    //   944: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   950: aload_0
    //   951: getfield 288	ahf:jdField_b_of_type_Long	J
    //   954: lsub
    //   955: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   958: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokestatic 175	com/tencent/mobileqq/ar/TraceUtil:b	(Ljava/lang/String;)V
    //   964: new 157	java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   971: ldc_w 290
    //   974: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: aload_0
    //   978: getfield 35	ahf:jdField_a_of_type_Int	I
    //   981: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   984: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 175	com/tencent/mobileqq/ar/TraceUtil:b	(Ljava/lang/String;)V
    //   990: goto -361 -> 629
    //   993: iload 8
    //   995: iconst_2
    //   996: if_icmpeq -367 -> 629
    //   999: aload_0
    //   1000: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   1003: getfield 238	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1006: invokevirtual 243	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1009: checkcast 245	com/tencent/mobileqq/ar/ARListener
    //   1012: astore 4
    //   1014: aload 4
    //   1016: ifnull +17 -> 1033
    //   1019: aload 4
    //   1021: iconst_0
    //   1022: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   1025: getfield 226	com/hiar/sdk/HSARToolkit:jdField_a_of_type_ComTencentMobileqqArARTarget	Lcom/tencent/mobileqq/ar/ARTarget;
    //   1028: invokeinterface 248 3 0
    //   1033: aload_0
    //   1034: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   1037: invokestatic 229	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/tencent/mobileqq/ar/ARGLSurfaceView;
    //   1040: invokevirtual 292	com/tencent/mobileqq/ar/ARGLSurfaceView:d	()V
    //   1043: aload_0
    //   1044: getfield 16	ahf:jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   1047: invokestatic 253	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/renderer/HSRenderer;
    //   1050: iconst_0
    //   1051: invokestatic 65	com/hiar/sdk/HSARToolkit:a	()Lcom/hiar/sdk/HSARToolkit;
    //   1054: getfield 226	com/hiar/sdk/HSARToolkit:jdField_a_of_type_ComTencentMobileqqArARTarget	Lcom/tencent/mobileqq/ar/ARTarget;
    //   1057: invokevirtual 256	com/hiar/sdk/renderer/HSRenderer:a	(ILcom/tencent/mobileqq/ar/ARTarget;)V
    //   1060: aload_0
    //   1061: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   1064: putfield 288	ahf:jdField_b_of_type_Long	J
    //   1067: aload_0
    //   1068: iconst_0
    //   1069: putfield 35	ahf:jdField_a_of_type_Int	I
    //   1072: goto -443 -> 629
    //   1075: iconst_0
    //   1076: istore 6
    //   1078: iconst_0
    //   1079: istore 7
    //   1081: goto -661 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1084	0	this	ahf
    //   19	618	1	arrayOfHiarqTargetInfo1	com.hiar.sdk.core.HiarqTargetInfo[]
    //   675	4	1	localObject1	Object
    //   680	68	1	arrayOfHiarqTargetInfo2	com.hiar.sdk.core.HiarqTargetInfo[]
    //   900	23	1	localObject2	Object
    //   34	5	2	arrayOfFloat	float[]
    //   89	1	2	localInterruptedException	InterruptedException
    //   119	558	2	localObject3	Object
    //   46	400	3	arrayOfHiarqMarkerInfo	com.hiar.sdk.core.HiarqMarkerInfo[]
    //   225	463	4	localObject4	Object
    //   697	3	4	localException1	Exception
    //   727	31	4	localObject5	Object
    //   833	34	4	localException2	Exception
    //   876	3	4	localException3	Exception
    //   924	3	4	localException4	Exception
    //   1012	8	4	localARListener	com.tencent.mobileqq.ar.ARListener
    //   685	10	5	localObject6	Object
    //   864	10	5	localObject7	Object
    //   188	889	6	i	int
    //   216	864	7	j	int
    //   196	801	8	k	int
    //   157	277	9	l1	long
    //   212	563	11	l2	long
    //   265	508	13	l3	long
    //   75	25	15	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   82	86	89	java/lang/InterruptedException
    //   646	667	675	finally
    //   667	672	675	finally
    //   676	678	675	finally
    //   840	861	675	finally
    //   901	922	675	finally
    //   922	924	675	finally
    //   2	57	680	finally
    //   57	64	680	finally
    //   64	77	680	finally
    //   82	86	680	finally
    //   93	99	680	finally
    //   107	122	680	finally
    //   678	680	680	finally
    //   234	251	685	finally
    //   255	258	685	finally
    //   687	690	685	finally
    //   218	227	697	java/lang/Exception
    //   231	234	697	java/lang/Exception
    //   694	697	697	java/lang/Exception
    //   122	143	833	java/lang/Exception
    //   143	187	833	java/lang/Exception
    //   190	198	833	java/lang/Exception
    //   209	214	833	java/lang/Exception
    //   262	342	833	java/lang/Exception
    //   348	360	833	java/lang/Exception
    //   360	380	833	java/lang/Exception
    //   404	420	833	java/lang/Exception
    //   420	486	833	java/lang/Exception
    //   492	515	833	java/lang/Exception
    //   520	534	833	java/lang/Exception
    //   534	629	833	java/lang/Exception
    //   629	646	833	java/lang/Exception
    //   699	704	833	java/lang/Exception
    //   711	716	833	java/lang/Exception
    //   764	830	833	java/lang/Exception
    //   878	883	833	java/lang/Exception
    //   890	897	833	java/lang/Exception
    //   926	931	833	java/lang/Exception
    //   934	990	833	java/lang/Exception
    //   999	1014	833	java/lang/Exception
    //   1019	1033	833	java/lang/Exception
    //   1033	1072	833	java/lang/Exception
    //   736	753	864	finally
    //   757	760	864	finally
    //   866	869	864	finally
    //   720	729	876	java/lang/Exception
    //   733	736	876	java/lang/Exception
    //   873	876	876	java/lang/Exception
    //   122	143	900	finally
    //   143	187	900	finally
    //   190	198	900	finally
    //   209	214	900	finally
    //   218	227	900	finally
    //   231	234	900	finally
    //   262	342	900	finally
    //   348	360	900	finally
    //   360	380	900	finally
    //   386	404	900	finally
    //   404	420	900	finally
    //   420	486	900	finally
    //   492	515	900	finally
    //   520	534	900	finally
    //   534	629	900	finally
    //   629	646	900	finally
    //   694	697	900	finally
    //   699	704	900	finally
    //   711	716	900	finally
    //   720	729	900	finally
    //   733	736	900	finally
    //   764	830	900	finally
    //   835	840	900	finally
    //   873	876	900	finally
    //   878	883	900	finally
    //   890	897	900	finally
    //   926	931	900	finally
    //   934	990	900	finally
    //   999	1014	900	finally
    //   1019	1033	900	finally
    //   1033	1072	900	finally
    //   386	404	924	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ahf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */