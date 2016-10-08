package com.tencent.biz.qqstory.takevideo.publish;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobSegment;

public class PublishVideoSegment
  extends JobSegment
{
  private static final String a = "PublishVideoSegment";
  
  public PublishVideoSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 29	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateThumbResult;
    //   4: astore_3
    //   5: invokestatic 34	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   8: astore 4
    //   10: aload_2
    //   11: invokevirtual 38	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:d	()Ljava/lang/String;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +64 -> 80
    //   19: aload_2
    //   20: invokevirtual 41	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Z
    //   23: ifeq +65 -> 88
    //   26: aload_2
    //   27: invokevirtual 44	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateDoodleArgs;
    //   30: getfield 48	com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleArgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: astore_3
    //   34: aload_2
    //   35: invokevirtual 51	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()J
    //   38: lstore 8
    //   40: lload 8
    //   42: lconst_0
    //   43: lcmp
    //   44: ifgt +49 -> 93
    //   47: aload_0
    //   48: new 53	com/tencent/biz/qqstory/base/ErrorMessage
    //   51: dup
    //   52: iconst_m1
    //   53: new 55	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   60: ldc 58
    //   62: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload 8
    //   67: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 71	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   76: invokespecial 75	com/tribe/async/async/JobSegment:notifyError	(Ljava/lang/Error;)V
    //   79: return
    //   80: aload_3
    //   81: getfield 78	com/tencent/biz/qqstory/takevideo/publish/GenerateThumbResult:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: astore_1
    //   85: goto -66 -> 19
    //   88: aconst_null
    //   89: astore_3
    //   90: goto -56 -> 34
    //   93: invokestatic 83	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   96: astore 5
    //   98: new 85	com/tencent/biz/qqstory/database/PublishVideoEntry
    //   101: dup
    //   102: invokespecial 86	com/tencent/biz/qqstory/database/PublishVideoEntry:<init>	()V
    //   105: astore 6
    //   107: aload 6
    //   109: new 55	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   116: ldc 88
    //   118: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   124: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: putfield 96	com/tencent/biz/qqstory/database/PublishVideoEntry:fakeVid	Ljava/lang/String;
    //   133: aload 6
    //   135: aload_2
    //   136: invokevirtual 99	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs;
    //   139: getfield 102	com/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   142: putfield 105	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   145: aload 6
    //   147: aload_2
    //   148: invokevirtual 99	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs;
    //   151: getfield 108	com/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs:jdField_a_of_type_Double	D
    //   154: putfield 111	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   157: aload 6
    //   159: aload_2
    //   160: invokevirtual 99	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs;
    //   163: getfield 115	com/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs:c	I
    //   166: putfield 118	com/tencent/biz/qqstory/database/PublishVideoEntry:recordFrames	I
    //   169: aload 6
    //   171: aload_2
    //   172: invokevirtual 99	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs;
    //   175: getfield 120	com/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs:d	I
    //   178: putfield 123	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   181: aload 6
    //   183: aload_2
    //   184: invokevirtual 126	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()[B
    //   187: putfield 130	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   190: aload 6
    //   192: aload_2
    //   193: invokevirtual 133	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()I
    //   196: putfield 136	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicSize	I
    //   199: aload 6
    //   201: aload_2
    //   202: invokevirtual 139	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateBackgroundMusicArgs;
    //   205: getfield 143	com/tencent/biz/qqstory/takevideo/publish/GenerateBackgroundMusicArgs:jdField_a_of_type_Boolean	Z
    //   208: putfield 146	com/tencent/biz/qqstory/database/PublishVideoEntry:isMuteRecordVoice	Z
    //   211: aload 6
    //   213: aload_2
    //   214: invokevirtual 139	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateBackgroundMusicArgs;
    //   217: getfield 147	com/tencent/biz/qqstory/takevideo/publish/GenerateBackgroundMusicArgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   220: putfield 150	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   223: aload 6
    //   225: aload_2
    //   226: invokevirtual 139	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateBackgroundMusicArgs;
    //   229: getfield 152	com/tencent/biz/qqstory/takevideo/publish/GenerateBackgroundMusicArgs:jdField_a_of_type_Int	I
    //   232: putfield 155	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicOffset	I
    //   235: aload 6
    //   237: aload_2
    //   238: invokevirtual 139	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateBackgroundMusicArgs;
    //   241: getfield 158	com/tencent/biz/qqstory/takevideo/publish/GenerateBackgroundMusicArgs:b	I
    //   244: putfield 161	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicDuration	I
    //   247: aload 5
    //   249: invokevirtual 164	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   252: invokevirtual 170	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   255: aload 6
    //   257: invokevirtual 175	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   260: aload_2
    //   261: new 177	com/tencent/biz/qqstory/takevideo/publish/PublishParam
    //   264: dup
    //   265: aload 6
    //   267: getfield 96	com/tencent/biz/qqstory/database/PublishVideoEntry:fakeVid	Ljava/lang/String;
    //   270: aload_1
    //   271: aload_3
    //   272: aload_2
    //   273: invokevirtual 179	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:b	()Ljava/lang/String;
    //   276: aload_2
    //   277: invokevirtual 181	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Ljava/lang/String;
    //   280: aload_2
    //   281: invokevirtual 183	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:c	()Ljava/lang/String;
    //   284: aload_2
    //   285: invokevirtual 99	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs;
    //   288: getfield 184	com/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs:jdField_a_of_type_Int	I
    //   291: aload_2
    //   292: invokevirtual 99	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	()Lcom/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs;
    //   295: getfield 185	com/tencent/biz/qqstory/takevideo/publish/GenerateVideoArgs:b	I
    //   298: lload 8
    //   300: invokespecial 188	com/tencent/biz/qqstory/takevideo/publish/PublishParam:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJ)V
    //   303: invokevirtual 191	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:a	(Lcom/tencent/biz/qqstory/takevideo/publish/PublishParam;)V
    //   306: ldc 8
    //   308: ldc -63
    //   310: invokestatic 198	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: invokestatic 203	com/tencent/mobileqq/shortvideo/VideoEnvironment:e	()Z
    //   316: ifeq +247 -> 563
    //   319: ldc -51
    //   321: iconst_0
    //   322: invokestatic 210	com/tencent/mobileqq/shortvideo/tools/QzoneHandlerThreadFactory:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/shortvideo/tools/QzoneBaseThread;
    //   325: new 212	iyn
    //   328: dup
    //   329: aload_0
    //   330: aload 4
    //   332: invokespecial 215	iyn:<init>	(Lcom/tencent/biz/qqstory/takevideo/publish/PublishVideoSegment;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   335: invokevirtual 220	com/tencent/mobileqq/shortvideo/tools/QzoneBaseThread:a	(Ljava/lang/Runnable;)V
    //   338: invokestatic 203	com/tencent/mobileqq/shortvideo/VideoEnvironment:e	()Z
    //   341: ifeq +216 -> 557
    //   344: lconst_0
    //   345: lstore 12
    //   347: aload 4
    //   349: getfield 223	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   352: astore_1
    //   353: aload_1
    //   354: monitorenter
    //   355: aload 4
    //   357: getfield 223	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   360: invokevirtual 228	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   363: istore 14
    //   365: lload 12
    //   367: lstore 10
    //   369: iload 14
    //   371: ifne +109 -> 480
    //   374: lload 12
    //   376: lstore 8
    //   378: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq +15 -> 396
    //   384: lload 12
    //   386: lstore 8
    //   388: ldc 8
    //   390: iconst_2
    //   391: ldc -21
    //   393: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: lload 12
    //   398: lstore 8
    //   400: invokestatic 243	android/os/SystemClock:elapsedRealtime	()J
    //   403: lstore 10
    //   405: lload 12
    //   407: lstore 8
    //   409: aload 4
    //   411: getfield 223	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   414: ldc2_w 244
    //   417: invokevirtual 251	java/lang/Object:wait	(J)V
    //   420: lload 12
    //   422: lstore 8
    //   424: invokestatic 243	android/os/SystemClock:elapsedRealtime	()J
    //   427: lload 10
    //   429: lsub
    //   430: lstore 12
    //   432: lload 12
    //   434: lstore 10
    //   436: lload 12
    //   438: lstore 8
    //   440: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifeq +37 -> 480
    //   446: lload 12
    //   448: lstore 8
    //   450: ldc 8
    //   452: iconst_2
    //   453: new 55	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   460: ldc -3
    //   462: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: lload 12
    //   467: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: lload 12
    //   478: lstore 10
    //   480: aload_1
    //   481: monitorexit
    //   482: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq +12 -> 497
    //   488: ldc -1
    //   490: iconst_2
    //   491: ldc_w 257
    //   494: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: lload 10
    //   499: ldc2_w 258
    //   502: lcmp
    //   503: ifge +54 -> 557
    //   506: bipush 30
    //   508: lload 10
    //   510: l2i
    //   511: isub
    //   512: istore 7
    //   514: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +30 -> 547
    //   520: ldc -1
    //   522: iconst_2
    //   523: new 55	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 261
    //   533: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: iload 7
    //   538: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: iload 7
    //   549: i2l
    //   550: lstore 8
    //   552: lload 8
    //   554: invokestatic 269	java/lang/Thread:sleep	(J)V
    //   557: aload_0
    //   558: aload_2
    //   559: invokespecial 273	com/tribe/async/async/JobSegment:notifyResult	(Ljava/lang/Object;)V
    //   562: return
    //   563: invokestatic 278	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   566: invokevirtual 281	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   569: invokevirtual 286	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   572: pop
    //   573: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq -238 -> 338
    //   579: ldc 8
    //   581: iconst_2
    //   582: ldc_w 288
    //   585: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: goto -250 -> 338
    //   591: astore_1
    //   592: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq +12 -> 607
    //   598: ldc 8
    //   600: iconst_2
    //   601: ldc_w 290
    //   604: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: aload_1
    //   608: invokevirtual 293	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   611: goto -273 -> 338
    //   614: astore_3
    //   615: lload 8
    //   617: lstore 10
    //   619: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq -142 -> 480
    //   625: ldc -1
    //   627: iconst_2
    //   628: new 55	java/lang/StringBuilder
    //   631: dup
    //   632: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   635: ldc_w 295
    //   638: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_3
    //   642: invokevirtual 298	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   645: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: lload 8
    //   656: lstore 10
    //   658: goto -178 -> 480
    //   661: astore_2
    //   662: aload_1
    //   663: monitorexit
    //   664: aload_2
    //   665: athrow
    //   666: astore_1
    //   667: goto -110 -> 557
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	this	PublishVideoSegment
    //   0	670	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	670	2	paramGenerateContext	GenerateContext
    //   4	268	3	localObject	Object
    //   614	28	3	localInterruptedException	InterruptedException
    //   8	402	4	localRMVideoStateMgr	com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
    //   96	152	5	localQQStoryContext	com.tencent.biz.qqstory.app.QQStoryContext
    //   105	161	6	localPublishVideoEntry	com.tencent.biz.qqstory.database.PublishVideoEntry
    //   512	36	7	i	int
    //   38	617	8	l1	long
    //   367	290	10	l2	long
    //   345	132	12	l3	long
    //   363	7	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   563	588	591	java/lang/UnsatisfiedLinkError
    //   378	384	614	java/lang/InterruptedException
    //   388	396	614	java/lang/InterruptedException
    //   400	405	614	java/lang/InterruptedException
    //   409	420	614	java/lang/InterruptedException
    //   424	432	614	java/lang/InterruptedException
    //   440	446	614	java/lang/InterruptedException
    //   450	476	614	java/lang/InterruptedException
    //   355	365	661	finally
    //   378	384	661	finally
    //   388	396	661	finally
    //   400	405	661	finally
    //   409	420	661	finally
    //   424	432	661	finally
    //   440	446	661	finally
    //   450	476	661	finally
    //   480	482	661	finally
    //   619	654	661	finally
    //   662	664	661	finally
    //   552	557	666	java/lang/InterruptedException
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\PublishVideoSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */