package com.tencent.mobileqq.activity;

import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class BlessPTVActivity$EncodeTask
  extends AsyncTask
{
  public final int a;
  String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  String b;
  
  public BlessPTVActivity$EncodeTask(BlessPTVActivity paramBlessPTVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBlessPTVActivity);
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 40	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   3: astore_2
    //   4: invokestatic 46	com/tencent/mobileqq/shortvideo/VideoEnvironment:e	()Z
    //   7: ifeq +387 -> 394
    //   10: ldc 48
    //   12: iconst_0
    //   13: invokestatic 53	com/tencent/mobileqq/shortvideo/tools/QzoneHandlerThreadFactory:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/shortvideo/tools/QzoneBaseThread;
    //   16: new 55	krc
    //   19: dup
    //   20: aload_0
    //   21: aload_2
    //   22: invokespecial 58	krc:<init>	(Lcom/tencent/mobileqq/activity/BlessPTVActivity$EncodeTask;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   25: invokevirtual 63	com/tencent/mobileqq/shortvideo/tools/QzoneBaseThread:a	(Ljava/lang/Runnable;)V
    //   28: invokestatic 46	com/tencent/mobileqq/shortvideo/VideoEnvironment:e	()Z
    //   31: ifeq +208 -> 239
    //   34: lconst_0
    //   35: lstore 8
    //   37: aload_2
    //   38: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   41: astore_1
    //   42: aload_1
    //   43: monitorenter
    //   44: aload_2
    //   45: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   48: invokevirtual 71	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   51: istore 10
    //   53: lload 8
    //   55: lstore 6
    //   57: iload 10
    //   59: ifne +108 -> 167
    //   62: lload 8
    //   64: lstore 4
    //   66: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +15 -> 84
    //   72: lload 8
    //   74: lstore 4
    //   76: ldc 78
    //   78: iconst_2
    //   79: ldc 80
    //   81: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: lload 8
    //   86: lstore 4
    //   88: invokestatic 90	android/os/SystemClock:elapsedRealtime	()J
    //   91: lstore 6
    //   93: lload 8
    //   95: lstore 4
    //   97: aload_2
    //   98: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   101: ldc2_w 91
    //   104: invokevirtual 98	java/lang/Object:wait	(J)V
    //   107: lload 8
    //   109: lstore 4
    //   111: invokestatic 90	android/os/SystemClock:elapsedRealtime	()J
    //   114: lload 6
    //   116: lsub
    //   117: lstore 8
    //   119: lload 8
    //   121: lstore 6
    //   123: lload 8
    //   125: lstore 4
    //   127: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +37 -> 167
    //   133: lload 8
    //   135: lstore 4
    //   137: ldc 78
    //   139: iconst_2
    //   140: new 100	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   147: ldc 103
    //   149: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: lload 8
    //   154: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   157: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: lload 8
    //   165: lstore 6
    //   167: aload_1
    //   168: monitorexit
    //   169: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +11 -> 183
    //   175: ldc 78
    //   177: iconst_2
    //   178: ldc 116
    //   180: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: lload 6
    //   185: ldc2_w 117
    //   188: lcmp
    //   189: ifge +50 -> 239
    //   192: bipush 30
    //   194: lload 6
    //   196: l2i
    //   197: isub
    //   198: istore_3
    //   199: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +28 -> 230
    //   205: ldc 78
    //   207: iconst_2
    //   208: new 100	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   215: ldc 120
    //   217: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: iload_3
    //   221: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: iload_3
    //   231: i2l
    //   232: lstore 4
    //   234: lload 4
    //   236: invokestatic 128	java/lang/Thread:sleep	(J)V
    //   239: aload_0
    //   240: getfield 29	com/tencent/mobileqq/activity/BlessPTVActivity$EncodeTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   243: invokevirtual 131	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   246: checkcast 133	com/tencent/mobileqq/activity/BlessPTVActivity
    //   249: astore_1
    //   250: aload_1
    //   251: ifnull +243 -> 494
    //   254: new 135	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   257: dup
    //   258: aconst_null
    //   259: aload_1
    //   260: invokestatic 138	com/tencent/mobileqq/activity/BlessPTVActivity:a	(Lcom/tencent/mobileqq/activity/BlessPTVActivity;)Landroid/os/Handler;
    //   263: aload_0
    //   264: getfield 140	com/tencent/mobileqq/activity/BlessPTVActivity$EncodeTask:b	Ljava/lang/String;
    //   267: aconst_null
    //   268: aconst_null
    //   269: invokespecial 143	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   272: astore_1
    //   273: aload_1
    //   274: iconst_0
    //   275: invokevirtual 146	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(Z)V
    //   278: aload_1
    //   279: iconst_0
    //   280: invokevirtual 148	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:b	(Z)V
    //   283: aload_1
    //   284: invokevirtual 151	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   287: aload_0
    //   288: aload_1
    //   289: getfield 153	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   292: putfield 154	com/tencent/mobileqq/activity/BlessPTVActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   295: aload_0
    //   296: getfield 154	com/tencent/mobileqq/activity/BlessPTVActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   299: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   302: ifne +53 -> 355
    //   305: new 162	java/io/File
    //   308: dup
    //   309: aload_0
    //   310: getfield 154	com/tencent/mobileqq/activity/BlessPTVActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   313: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 168	java/io/File:exists	()Z
    //   321: ifeq +34 -> 355
    //   324: new 100	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   331: aload_1
    //   332: invokevirtual 171	java/io/File:getParent	()Ljava/lang/String;
    //   335: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: getstatic 174	java/io/File:separator	Ljava/lang/String;
    //   341: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc -80
    //   346: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 180	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   355: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +31 -> 389
    //   361: ldc 78
    //   363: iconst_2
    //   364: new 100	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   371: ldc -74
    //   373: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_0
    //   377: getfield 154	com/tencent/mobileqq/activity/BlessPTVActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   380: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: iconst_0
    //   390: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   393: areturn
    //   394: invokestatic 193	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   397: invokevirtual 196	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   400: invokevirtual 202	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   403: pop
    //   404: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq -379 -> 28
    //   410: ldc 78
    //   412: iconst_2
    //   413: ldc -52
    //   415: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -390 -> 28
    //   421: astore_1
    //   422: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +11 -> 436
    //   428: ldc 78
    //   430: iconst_2
    //   431: ldc -50
    //   433: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aload_1
    //   437: invokevirtual 209	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   440: goto -412 -> 28
    //   443: astore_2
    //   444: lload 4
    //   446: lstore 6
    //   448: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq -284 -> 167
    //   454: ldc 78
    //   456: iconst_2
    //   457: new 100	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   464: ldc -45
    //   466: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_2
    //   470: invokevirtual 214	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   473: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: lload 4
    //   484: lstore 6
    //   486: goto -319 -> 167
    //   489: astore_2
    //   490: aload_1
    //   491: monitorexit
    //   492: aload_2
    //   493: athrow
    //   494: iconst_1
    //   495: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: areturn
    //   499: astore_1
    //   500: goto -261 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	EncodeTask
    //   0	503	1	paramVarArgs	Void[]
    //   3	95	2	localRMVideoStateMgr	com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
    //   443	27	2	localInterruptedException	InterruptedException
    //   489	4	2	localObject	Object
    //   198	33	3	i	int
    //   64	419	4	l1	long
    //   55	430	6	l2	long
    //   35	129	8	l3	long
    //   51	7	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   394	418	421	java/lang/UnsatisfiedLinkError
    //   66	72	443	java/lang/InterruptedException
    //   76	84	443	java/lang/InterruptedException
    //   88	93	443	java/lang/InterruptedException
    //   97	107	443	java/lang/InterruptedException
    //   111	119	443	java/lang/InterruptedException
    //   127	133	443	java/lang/InterruptedException
    //   137	163	443	java/lang/InterruptedException
    //   44	53	489	finally
    //   66	72	489	finally
    //   76	84	489	finally
    //   88	93	489	finally
    //   97	107	489	finally
    //   111	119	489	finally
    //   127	133	489	finally
    //   137	163	489	finally
    //   167	169	489	finally
    //   448	482	489	finally
    //   490	492	489	finally
    //   234	239	499	java/lang/InterruptedException
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    BlessPTVActivity localBlessPTVActivity = (BlessPTVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBlessPTVActivity == null) {
      return;
    }
    BlessPTVActivity.c(localBlessPTVActivity);
    switch (paramInteger.intValue())
    {
    default: 
      QQToast.a(localBlessPTVActivity, "对不起，视频处理异常...", 0).a();
      localBlessPTVActivity.a(0, null, 0, 0);
    }
    while (QLog.isColorLevel())
    {
      QLog.i("BlessPTVActivity", 2, "Error code " + paramInteger);
      return;
      if (localBlessPTVActivity != null) {
        localBlessPTVActivity.a(1, this.jdField_a_of_type_JavaLangString, 0, 0);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    BlessPTVActivity localBlessPTVActivity = (BlessPTVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBlessPTVActivity != null) {
      BlessPTVActivity.b(localBlessPTVActivity, "视频处理中...");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\BlessPTVActivity$EncodeTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */