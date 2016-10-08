import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;

public class kxx
  implements Runnable
{
  volatile int jdField_a_of_type_Int;
  public AIORichMediaInfo a;
  final Object jdField_a_of_type_JavaLangObject;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  public volatile boolean c;
  public volatile boolean d;
  volatile boolean e;
  
  public kxx(ChatHistoryImageView paramChatHistoryImageView, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = true;
    this.d = false;
    this.e = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[setDownloadState] " + paramBoolean);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.e = paramBoolean;
      if (!this.e)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(102, (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int) * 60000L);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	kxx:jdField_a_of_type_Boolean	Z
    //   4: ifeq +328 -> 332
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 33	kxx:d	Z
    //   12: aload_0
    //   13: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   16: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   19: bipush 102
    //   21: aload_0
    //   22: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   25: invokevirtual 91	java/util/ArrayList:size	()I
    //   28: i2l
    //   29: ldc2_w 92
    //   32: lmul
    //   33: invokevirtual 99	com/tencent/util/WeakReferenceHandler:sendEmptyMessageDelayed	(IJ)Z
    //   36: pop
    //   37: iconst_0
    //   38: istore 5
    //   40: iload 5
    //   42: aload_0
    //   43: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   46: invokevirtual 91	java/util/ArrayList:size	()I
    //   49: if_icmpge +266 -> 315
    //   52: aload_0
    //   53: getfield 31	kxx:c	Z
    //   56: ifne +17 -> 73
    //   59: aload_0
    //   60: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   63: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   66: bipush 101
    //   68: invokevirtual 110	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   71: pop
    //   72: return
    //   73: aload_0
    //   74: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   77: iload 5
    //   79: invokevirtual 114	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   82: checkcast 116	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo
    //   85: astore_1
    //   86: ldc 118
    //   88: aload_1
    //   89: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   92: invokevirtual 127	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   95: ifeq +145 -> 240
    //   98: aload_1
    //   99: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   102: checkcast 118	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   105: astore_2
    //   106: aload_2
    //   107: getfield 130	com/tencent/mobileqq/activity/aio/photo/AIOImageData:b	Ljava/lang/String;
    //   110: astore_3
    //   111: ldc -124
    //   113: aload_3
    //   114: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifne +76 -> 193
    //   120: new 139	java/io/File
    //   123: dup
    //   124: aload_3
    //   125: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: invokevirtual 145	java/io/File:exists	()Z
    //   131: ifne +62 -> 193
    //   134: aload_0
    //   135: aload_1
    //   136: putfield 147	kxx:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   139: aload_1
    //   140: iconst_1
    //   141: putfield 148	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Boolean	Z
    //   144: aload_0
    //   145: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   148: getfield 151	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   151: aload_2
    //   152: getfield 155	com/tencent/mobileqq/activity/aio/photo/AIOImageData:f	J
    //   155: aload_2
    //   156: getfield 158	com/tencent/mobileqq/activity/aio/photo/AIOImageData:k	I
    //   159: iconst_2
    //   160: invokevirtual 163	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:a	(JII)V
    //   163: aload_0
    //   164: getfield 147	kxx:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   167: astore_1
    //   168: aload_1
    //   169: monitorenter
    //   170: aload_0
    //   171: getfield 147	kxx:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   174: getfield 148	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Boolean	Z
    //   177: istore 12
    //   179: iload 12
    //   181: ifeq +10 -> 191
    //   184: aload_0
    //   185: getfield 147	kxx:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   188: invokevirtual 166	java/lang/Object:wait	()V
    //   191: aload_1
    //   192: monitorexit
    //   193: aload_0
    //   194: getfield 39	kxx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   197: astore_1
    //   198: aload_1
    //   199: monitorenter
    //   200: aload_0
    //   201: getfield 35	kxx:e	Z
    //   204: istore 12
    //   206: iload 12
    //   208: ifeq +30 -> 238
    //   211: aload_0
    //   212: getfield 39	kxx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   215: invokevirtual 166	java/lang/Object:wait	()V
    //   218: goto -18 -> 200
    //   221: astore_2
    //   222: goto -22 -> 200
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 169	java/lang/InterruptedException:printStackTrace	()V
    //   230: goto -39 -> 191
    //   233: astore_2
    //   234: aload_1
    //   235: monitorexit
    //   236: aload_2
    //   237: athrow
    //   238: aload_1
    //   239: monitorexit
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 37	kxx:jdField_a_of_type_Int	I
    //   245: iconst_1
    //   246: iadd
    //   247: putfield 37	kxx:jdField_a_of_type_Int	I
    //   250: aload_0
    //   251: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   254: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   257: bipush 100
    //   259: invokevirtual 173	com/tencent/util/WeakReferenceHandler:obtainMessage	(I)Landroid/os/Message;
    //   262: astore_1
    //   263: aload_1
    //   264: iconst_1
    //   265: putfield 178	android/os/Message:arg1	I
    //   268: aload_1
    //   269: iload 5
    //   271: iconst_1
    //   272: iadd
    //   273: bipush 100
    //   275: imul
    //   276: aload_0
    //   277: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   280: invokevirtual 91	java/util/ArrayList:size	()I
    //   283: idiv
    //   284: iconst_2
    //   285: idiv
    //   286: putfield 181	android/os/Message:arg2	I
    //   289: aload_0
    //   290: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   293: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   296: aload_1
    //   297: invokevirtual 185	com/tencent/util/WeakReferenceHandler:sendMessage	(Landroid/os/Message;)Z
    //   300: pop
    //   301: iload 5
    //   303: iconst_1
    //   304: iadd
    //   305: istore 5
    //   307: goto -267 -> 40
    //   310: astore_2
    //   311: aload_1
    //   312: monitorexit
    //   313: aload_2
    //   314: athrow
    //   315: aload_0
    //   316: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   319: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   322: bipush 102
    //   324: invokevirtual 103	com/tencent/util/WeakReferenceHandler:removeMessages	(I)V
    //   327: aload_0
    //   328: iconst_0
    //   329: putfield 33	kxx:d	Z
    //   332: aload_0
    //   333: getfield 31	kxx:c	Z
    //   336: ifne +17 -> 353
    //   339: aload_0
    //   340: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   343: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   346: bipush 101
    //   348: invokevirtual 110	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   351: pop
    //   352: return
    //   353: new 139	java/io/File
    //   356: dup
    //   357: getstatic 190	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   360: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   363: astore_3
    //   364: aload_3
    //   365: invokevirtual 145	java/io/File:exists	()Z
    //   368: ifne +8 -> 376
    //   371: aload_3
    //   372: invokevirtual 193	java/io/File:mkdirs	()Z
    //   375: pop
    //   376: iconst_0
    //   377: istore 6
    //   379: iconst_0
    //   380: istore 7
    //   382: iconst_0
    //   383: istore 5
    //   385: iload 6
    //   387: aload_0
    //   388: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   391: invokevirtual 91	java/util/ArrayList:size	()I
    //   394: if_icmpge +505 -> 899
    //   397: aload_0
    //   398: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   401: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   404: bipush 100
    //   406: invokevirtual 173	com/tencent/util/WeakReferenceHandler:obtainMessage	(I)Landroid/os/Message;
    //   409: astore_1
    //   410: aload_1
    //   411: iconst_2
    //   412: putfield 178	android/os/Message:arg1	I
    //   415: aload_0
    //   416: getfield 48	kxx:jdField_a_of_type_Boolean	Z
    //   419: ifeq +63 -> 482
    //   422: aload_1
    //   423: aload_0
    //   424: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   427: invokevirtual 91	java/util/ArrayList:size	()I
    //   430: iload 6
    //   432: iadd
    //   433: bipush 100
    //   435: imul
    //   436: aload_0
    //   437: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   440: invokevirtual 91	java/util/ArrayList:size	()I
    //   443: idiv
    //   444: iconst_2
    //   445: idiv
    //   446: putfield 181	android/os/Message:arg2	I
    //   449: aload_0
    //   450: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   453: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   456: aload_1
    //   457: invokevirtual 185	com/tencent/util/WeakReferenceHandler:sendMessage	(Landroid/os/Message;)Z
    //   460: pop
    //   461: aload_0
    //   462: getfield 31	kxx:c	Z
    //   465: ifne +37 -> 502
    //   468: aload_0
    //   469: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   472: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   475: bipush 101
    //   477: invokevirtual 110	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   480: pop
    //   481: return
    //   482: aload_1
    //   483: iload 6
    //   485: bipush 100
    //   487: imul
    //   488: aload_0
    //   489: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   492: invokevirtual 91	java/util/ArrayList:size	()I
    //   495: idiv
    //   496: putfield 181	android/os/Message:arg2	I
    //   499: goto -50 -> 449
    //   502: aload_0
    //   503: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   506: iload 6
    //   508: invokevirtual 114	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   511: checkcast 116	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo
    //   514: astore_1
    //   515: ldc 118
    //   517: aload_1
    //   518: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   521: invokevirtual 127	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   524: ifeq +68 -> 592
    //   527: aload_1
    //   528: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   531: checkcast 118	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   534: iconst_2
    //   535: invokevirtual 196	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   538: astore_2
    //   539: aload_2
    //   540: astore_1
    //   541: aload_2
    //   542: ifnonnull +140 -> 682
    //   545: iload 7
    //   547: istore 8
    //   549: iload 5
    //   551: istore 9
    //   553: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq +19 -> 575
    //   559: ldc 60
    //   561: iconst_2
    //   562: ldc -58
    //   564: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: iload 5
    //   569: istore 9
    //   571: iload 7
    //   573: istore 8
    //   575: iload 6
    //   577: iconst_1
    //   578: iadd
    //   579: istore 6
    //   581: iload 8
    //   583: istore 7
    //   585: iload 9
    //   587: istore 5
    //   589: goto -204 -> 385
    //   592: ldc -54
    //   594: aload_1
    //   595: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   598: invokevirtual 127	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   601: ifeq +462 -> 1063
    //   604: aload_1
    //   605: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   608: checkcast 202	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   611: astore 4
    //   613: aload 4
    //   615: bipush 20
    //   617: invokevirtual 203	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   620: astore_2
    //   621: aload_2
    //   622: astore_1
    //   623: aload_2
    //   624: ifnonnull +58 -> 682
    //   627: aload 4
    //   629: bipush 18
    //   631: invokevirtual 203	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   634: astore_2
    //   635: aload_2
    //   636: astore_1
    //   637: aload_2
    //   638: ifnonnull +44 -> 682
    //   641: aload 4
    //   643: bipush 16
    //   645: invokevirtual 203	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   648: astore_2
    //   649: aload_2
    //   650: astore_1
    //   651: aload_2
    //   652: ifnonnull +30 -> 682
    //   655: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq +11 -> 669
    //   661: ldc 60
    //   663: iconst_2
    //   664: ldc -51
    //   666: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: iload 5
    //   671: iconst_1
    //   672: iadd
    //   673: istore 9
    //   675: iload 7
    //   677: istore 8
    //   679: goto -104 -> 575
    //   682: iload 7
    //   684: istore 8
    //   686: iload 5
    //   688: istore 9
    //   690: aload_1
    //   691: ifnull -116 -> 575
    //   694: invokestatic 211	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   697: invokestatic 217	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   700: lstore 10
    //   702: aload_1
    //   703: invokevirtual 221	java/io/File:length	()J
    //   706: lload 10
    //   708: lcmp
    //   709: ifle +41 -> 750
    //   712: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   715: ifeq +11 -> 726
    //   718: ldc 60
    //   720: iconst_2
    //   721: ldc -33
    //   723: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   726: ldc -31
    //   728: invokestatic 229	com/tencent/mobileqq/filemanager/util/FMToastUtil:a	(Ljava/lang/String;)V
    //   731: aload_0
    //   732: iconst_0
    //   733: putfield 31	kxx:c	Z
    //   736: aload_0
    //   737: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   740: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   743: bipush 101
    //   745: invokevirtual 110	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   748: pop
    //   749: return
    //   750: new 139	java/io/File
    //   753: dup
    //   754: aload_3
    //   755: new 62	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   762: aload_1
    //   763: invokevirtual 232	java/io/File:getName	()Ljava/lang/String;
    //   766: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: ldc -22
    //   771: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: invokespecial 237	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   780: astore_2
    //   781: aload_1
    //   782: aload_2
    //   783: invokestatic 242	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   786: ifne +86 -> 872
    //   789: invokestatic 245	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   792: ldc -9
    //   794: invokevirtual 251	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   797: ifne +41 -> 838
    //   800: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   803: ifeq +11 -> 814
    //   806: ldc 60
    //   808: iconst_2
    //   809: ldc -3
    //   811: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: ldc -1
    //   816: invokestatic 229	com/tencent/mobileqq/filemanager/util/FMToastUtil:a	(Ljava/lang/String;)V
    //   819: aload_0
    //   820: iconst_0
    //   821: putfield 31	kxx:c	Z
    //   824: aload_0
    //   825: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   828: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   831: bipush 101
    //   833: invokevirtual 110	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   836: pop
    //   837: return
    //   838: iload 7
    //   840: istore 8
    //   842: iload 5
    //   844: istore 9
    //   846: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   849: ifeq -274 -> 575
    //   852: ldc 60
    //   854: iconst_2
    //   855: ldc_w 257
    //   858: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   861: iload 7
    //   863: istore 8
    //   865: iload 5
    //   867: istore 9
    //   869: goto -294 -> 575
    //   872: iload 7
    //   874: iconst_1
    //   875: iadd
    //   876: istore 8
    //   878: aload_0
    //   879: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   882: getfield 260	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   885: aload_2
    //   886: invokevirtual 263	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   889: invokestatic 268	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   892: iload 5
    //   894: istore 9
    //   896: goto -321 -> 575
    //   899: iload 7
    //   901: aload_0
    //   902: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   905: invokevirtual 91	java/util/ArrayList:size	()I
    //   908: iload 5
    //   910: isub
    //   911: if_icmpne +60 -> 971
    //   914: new 62	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   921: aload_0
    //   922: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   925: getfield 260	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   928: invokevirtual 274	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   931: ldc_w 275
    //   934: invokevirtual 281	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   937: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: getstatic 190	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   943: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: invokestatic 283	com/tencent/mobileqq/filemanager/util/FMToastUtil:b	(Ljava/lang/String;)V
    //   952: aload_0
    //   953: iconst_0
    //   954: putfield 31	kxx:c	Z
    //   957: aload_0
    //   958: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   961: getfield 87	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   964: bipush 101
    //   966: invokevirtual 110	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   969: pop
    //   970: return
    //   971: iload 7
    //   973: ifle +81 -> 1054
    //   976: new 62	java/lang/StringBuilder
    //   979: dup
    //   980: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   983: getstatic 289	java/util/Locale:CHINA	Ljava/util/Locale;
    //   986: aload_0
    //   987: getfield 21	kxx:jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   990: getfield 260	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   993: invokevirtual 274	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   996: ldc_w 290
    //   999: invokevirtual 281	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1002: iconst_2
    //   1003: anewarray 4	java/lang/Object
    //   1006: dup
    //   1007: iconst_0
    //   1008: iload 7
    //   1010: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1013: aastore
    //   1014: dup
    //   1015: iconst_1
    //   1016: aload_0
    //   1017: getfield 46	kxx:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1020: invokevirtual 91	java/util/ArrayList:size	()I
    //   1023: iload 5
    //   1025: isub
    //   1026: iload 7
    //   1028: isub
    //   1029: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1032: aastore
    //   1033: invokestatic 300	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1036: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: getstatic 190	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   1042: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 283	com/tencent/mobileqq/filemanager/util/FMToastUtil:b	(Ljava/lang/String;)V
    //   1051: goto -99 -> 952
    //   1054: ldc_w 302
    //   1057: invokestatic 229	com/tencent/mobileqq/filemanager/util/FMToastUtil:a	(Ljava/lang/String;)V
    //   1060: goto -108 -> 952
    //   1063: aconst_null
    //   1064: astore_1
    //   1065: goto -383 -> 682
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1068	0	this	kxx
    //   105	51	2	localAIOImageData	com.tencent.mobileqq.activity.aio.photo.AIOImageData
    //   221	1	2	localInterruptedException1	InterruptedException
    //   225	2	2	localInterruptedException2	InterruptedException
    //   233	4	2	localObject2	Object
    //   310	4	2	localObject3	Object
    //   538	348	2	localFile	java.io.File
    //   110	645	3	localObject4	Object
    //   611	31	4	localAIOFilePicData	com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
    //   38	988	5	i	int
    //   377	203	6	j	int
    //   380	649	7	k	int
    //   547	330	8	m	int
    //   551	344	9	n	int
    //   700	7	10	l	long
    //   177	30	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   211	218	221	java/lang/InterruptedException
    //   184	191	225	java/lang/InterruptedException
    //   170	179	233	finally
    //   184	191	233	finally
    //   191	193	233	finally
    //   226	230	233	finally
    //   234	236	233	finally
    //   200	206	310	finally
    //   211	218	310	finally
    //   238	240	310	finally
    //   311	313	310	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */