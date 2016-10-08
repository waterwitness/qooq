package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class NewFlowCameraActivity$EncodeTask
  extends AsyncTask
{
  public final int a;
  Handler jdField_a_of_type_AndroidOsHandler;
  NewFlowCameraActivity.VideoProcessListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  byte[] jdField_a_of_type_ArrayOfByte;
  public final int b;
  String b;
  String c;
  
  public NewFlowCameraActivity$EncodeTask(Activity paramActivity, Handler paramHandler, NewFlowCameraActivity.VideoProcessListener paramVideoProcessListener, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener = paramVideoProcessListener;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 56	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   5: astore_3
    //   6: invokestatic 62	com/tencent/mobileqq/shortvideo/VideoEnvironment:e	()Z
    //   9: ifeq +447 -> 456
    //   12: ldc 64
    //   14: iconst_0
    //   15: invokestatic 69	com/tencent/mobileqq/shortvideo/tools/QzoneHandlerThreadFactory:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/shortvideo/tools/QzoneBaseThread;
    //   18: new 71	pcl
    //   21: dup
    //   22: aload_0
    //   23: aload_3
    //   24: invokespecial 74	pcl:<init>	(Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   27: invokevirtual 79	com/tencent/mobileqq/shortvideo/tools/QzoneBaseThread:a	(Ljava/lang/Runnable;)V
    //   30: invokestatic 62	com/tencent/mobileqq/shortvideo/VideoEnvironment:e	()Z
    //   33: ifeq +211 -> 244
    //   36: lconst_0
    //   37: lstore 9
    //   39: aload_3
    //   40: getfield 82	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   43: astore_2
    //   44: aload_2
    //   45: monitorenter
    //   46: aload_3
    //   47: getfield 82	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   50: invokevirtual 87	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   53: istore 11
    //   55: lload 9
    //   57: lstore 7
    //   59: iload 11
    //   61: ifne +108 -> 169
    //   64: lload 9
    //   66: lstore 5
    //   68: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +15 -> 86
    //   74: lload 9
    //   76: lstore 5
    //   78: ldc 94
    //   80: iconst_2
    //   81: ldc 96
    //   83: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: lload 9
    //   88: lstore 5
    //   90: invokestatic 106	android/os/SystemClock:elapsedRealtime	()J
    //   93: lstore 7
    //   95: lload 9
    //   97: lstore 5
    //   99: aload_3
    //   100: getfield 82	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   103: ldc2_w 107
    //   106: invokevirtual 114	java/lang/Object:wait	(J)V
    //   109: lload 9
    //   111: lstore 5
    //   113: invokestatic 106	android/os/SystemClock:elapsedRealtime	()J
    //   116: lload 7
    //   118: lsub
    //   119: lstore 9
    //   121: lload 9
    //   123: lstore 7
    //   125: lload 9
    //   127: lstore 5
    //   129: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +37 -> 169
    //   135: lload 9
    //   137: lstore 5
    //   139: ldc 94
    //   141: iconst_2
    //   142: new 116	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   149: ldc 119
    //   151: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: lload 9
    //   156: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   159: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: lload 9
    //   167: lstore 7
    //   169: aload_2
    //   170: monitorexit
    //   171: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +11 -> 185
    //   177: ldc 94
    //   179: iconst_2
    //   180: ldc -124
    //   182: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: lload 7
    //   187: ldc2_w 133
    //   190: lcmp
    //   191: ifge +53 -> 244
    //   194: bipush 30
    //   196: lload 7
    //   198: l2i
    //   199: isub
    //   200: istore 4
    //   202: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +29 -> 234
    //   208: ldc 94
    //   210: iconst_2
    //   211: new 116	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   218: ldc -120
    //   220: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload 4
    //   225: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iload 4
    //   236: i2l
    //   237: lstore 5
    //   239: lload 5
    //   241: invokestatic 144	java/lang/Thread:sleep	(J)V
    //   244: aload_0
    //   245: getfield 35	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   248: invokevirtual 147	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   251: ifnull +363 -> 614
    //   254: new 149	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   257: dup
    //   258: aconst_null
    //   259: aload_0
    //   260: getfield 37	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   263: aload_0
    //   264: getfield 41	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   267: aconst_null
    //   268: aconst_null
    //   269: invokespecial 152	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   272: astore_2
    //   273: aload_2
    //   274: iconst_0
    //   275: invokevirtual 155	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(Z)V
    //   278: aload_2
    //   279: iconst_0
    //   280: invokevirtual 157	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:b	(Z)V
    //   283: aload_2
    //   284: iconst_1
    //   285: invokevirtual 159	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:c	(Z)V
    //   288: aload_2
    //   289: invokevirtual 162	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   292: aload_0
    //   293: aload_2
    //   294: getfield 164	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: putfield 165	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   300: aload_0
    //   301: getfield 165	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   304: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifne +96 -> 403
    //   310: new 173	java/io/File
    //   313: dup
    //   314: aload_0
    //   315: getfield 165	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   318: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   321: astore_3
    //   322: aload_3
    //   323: invokevirtual 179	java/io/File:exists	()Z
    //   326: ifeq +77 -> 403
    //   329: new 116	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   336: aload_3
    //   337: invokevirtual 182	java/io/File:getParent	()Ljava/lang/String;
    //   340: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: getstatic 185	java/io/File:separator	Ljava/lang/String;
    //   346: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc -69
    //   351: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 191	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   360: new 193	java/io/FileInputStream
    //   363: dup
    //   364: aload_0
    //   365: getfield 165	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   368: invokespecial 194	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   371: astore_2
    //   372: aload_0
    //   373: aload_2
    //   374: aload_3
    //   375: invokevirtual 197	java/io/File:length	()J
    //   378: invokestatic 203	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   381: putfield 205	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_ArrayOfByte	[B
    //   384: aload_0
    //   385: aload_0
    //   386: getfield 205	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_ArrayOfByte	[B
    //   389: invokestatic 211	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   392: putfield 213	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:c	Ljava/lang/String;
    //   395: aload_2
    //   396: ifnull +7 -> 403
    //   399: aload_2
    //   400: invokevirtual 216	java/io/FileInputStream:close	()V
    //   403: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +43 -> 449
    //   409: ldc 94
    //   411: iconst_2
    //   412: new 116	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   419: ldc -38
    //   421: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 165	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   428: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc -36
    //   433: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload_0
    //   437: getfield 213	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:c	Ljava/lang/String;
    //   440: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: iconst_0
    //   450: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   453: astore_2
    //   454: aload_2
    //   455: areturn
    //   456: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   459: invokevirtual 234	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   462: invokevirtual 240	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   465: pop
    //   466: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq -439 -> 30
    //   472: ldc 94
    //   474: iconst_2
    //   475: ldc -14
    //   477: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: goto -450 -> 30
    //   483: astore_2
    //   484: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   487: ifeq +11 -> 498
    //   490: ldc 94
    //   492: iconst_2
    //   493: ldc -12
    //   495: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_2
    //   499: invokevirtual 247	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   502: goto -472 -> 30
    //   505: astore_3
    //   506: lload 5
    //   508: lstore 7
    //   510: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq -344 -> 169
    //   516: ldc 94
    //   518: iconst_2
    //   519: new 116	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   526: ldc -7
    //   528: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_3
    //   532: invokevirtual 252	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   535: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: lload 5
    //   546: lstore 7
    //   548: goto -379 -> 169
    //   551: astore_1
    //   552: aload_2
    //   553: monitorexit
    //   554: aload_1
    //   555: athrow
    //   556: astore_1
    //   557: aload_1
    //   558: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   561: goto -158 -> 403
    //   564: astore_2
    //   565: aload_2
    //   566: invokevirtual 254	java/io/FileNotFoundException:printStackTrace	()V
    //   569: iconst_1
    //   570: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   573: astore_3
    //   574: aload_3
    //   575: astore_2
    //   576: aload_1
    //   577: ifnull -123 -> 454
    //   580: aload_1
    //   581: invokevirtual 216	java/io/FileInputStream:close	()V
    //   584: aload_3
    //   585: areturn
    //   586: astore_1
    //   587: aload_1
    //   588: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   591: aload_3
    //   592: areturn
    //   593: astore_1
    //   594: aconst_null
    //   595: astore_2
    //   596: aload_2
    //   597: ifnull +7 -> 604
    //   600: aload_2
    //   601: invokevirtual 216	java/io/FileInputStream:close	()V
    //   604: aload_1
    //   605: athrow
    //   606: astore_2
    //   607: aload_2
    //   608: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   611: goto -7 -> 604
    //   614: iconst_1
    //   615: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   618: areturn
    //   619: astore_2
    //   620: goto -376 -> 244
    //   623: astore_1
    //   624: goto -28 -> 596
    //   627: astore_3
    //   628: aload_1
    //   629: astore_2
    //   630: aload_3
    //   631: astore_1
    //   632: goto -36 -> 596
    //   635: astore_3
    //   636: aload_2
    //   637: astore_1
    //   638: aload_3
    //   639: astore_2
    //   640: goto -75 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	this	EncodeTask
    //   0	643	1	paramVarArgs	Void[]
    //   43	412	2	localObject1	Object
    //   483	70	2	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   564	2	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   575	26	2	localInteger1	Integer
    //   606	2	2	localIOException	java.io.IOException
    //   619	1	2	localInterruptedException1	InterruptedException
    //   629	11	2	localObject2	Object
    //   5	370	3	localObject3	Object
    //   505	27	3	localInterruptedException2	InterruptedException
    //   573	19	3	localInteger2	Integer
    //   627	4	3	localObject4	Object
    //   635	4	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   200	35	4	i	int
    //   66	479	5	l1	long
    //   57	490	7	l2	long
    //   37	129	9	l3	long
    //   53	7	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   456	480	483	java/lang/UnsatisfiedLinkError
    //   68	74	505	java/lang/InterruptedException
    //   78	86	505	java/lang/InterruptedException
    //   90	95	505	java/lang/InterruptedException
    //   99	109	505	java/lang/InterruptedException
    //   113	121	505	java/lang/InterruptedException
    //   129	135	505	java/lang/InterruptedException
    //   139	165	505	java/lang/InterruptedException
    //   46	55	551	finally
    //   68	74	551	finally
    //   78	86	551	finally
    //   90	95	551	finally
    //   99	109	551	finally
    //   113	121	551	finally
    //   129	135	551	finally
    //   139	165	551	finally
    //   169	171	551	finally
    //   510	544	551	finally
    //   552	554	551	finally
    //   399	403	556	java/io/IOException
    //   360	372	564	java/io/FileNotFoundException
    //   580	584	586	java/io/IOException
    //   360	372	593	finally
    //   600	604	606	java/io/IOException
    //   239	244	619	java/lang/InterruptedException
    //   372	395	623	finally
    //   565	569	627	finally
    //   372	395	635	java/io/FileNotFoundException
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "generate video result= " + paramInteger);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    switch (paramInteger.intValue())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener.a(false, null, null, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\NewFlowCameraActivity$EncodeTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */