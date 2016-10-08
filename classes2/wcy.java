import android.media.AudioRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.processor.IPttProcessor;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.ptt.processor.IPttProcessorListener;
import com.tencent.mobileqq.ptt.processor.PttAgcAndNsProcessor;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.QLog;

public class wcy
  extends Thread
  implements IPttProcessorListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public String a;
  public volatile boolean a;
  public volatile boolean b;
  private boolean c;
  
  public wcy(QQRecorder paramQQRecorder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.b = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 48
    //   8: iconst_2
    //   9: new 50	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   16: ldc 53
    //   18: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: lconst_0
    //   32: lstore 20
    //   34: lconst_0
    //   35: lstore 18
    //   37: iconst_0
    //   38: istore 11
    //   40: iconst_0
    //   41: istore 12
    //   43: dconst_0
    //   44: dstore_2
    //   45: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   48: lstore 28
    //   50: lconst_0
    //   51: lstore 16
    //   53: lconst_0
    //   54: lstore 22
    //   56: iconst_0
    //   57: istore 15
    //   59: iconst_0
    //   60: istore 13
    //   62: iconst_0
    //   63: istore 10
    //   65: lconst_0
    //   66: lstore 24
    //   68: sipush 250
    //   71: istore 8
    //   73: bipush -19
    //   75: invokestatic 80	android/os/Process:setThreadPriority	(I)V
    //   78: aload_0
    //   79: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   82: invokestatic 85	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   85: iconst_1
    //   86: invokestatic 90	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   89: pop
    //   90: aload_0
    //   91: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   94: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   97: ifnull +23 -> 120
    //   100: aload_0
    //   101: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   104: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   107: aload_1
    //   108: aload_0
    //   109: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   112: getfield 96	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   115: invokeinterface 101 3 0
    //   120: aload_0
    //   121: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   124: invokestatic 104	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   127: newarray <illegal type>
    //   129: astore 6
    //   131: aload_0
    //   132: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   135: invokestatic 106	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   138: aload_0
    //   139: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   142: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   145: ifnull +38 -> 183
    //   148: aload_0
    //   149: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   152: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   155: invokeinterface 109 1 0
    //   160: istore 9
    //   162: iload 9
    //   164: istore 8
    //   166: iload 9
    //   168: ifgt +8 -> 176
    //   171: sipush 250
    //   174: istore 8
    //   176: iload 8
    //   178: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:a	(I)I
    //   181: istore 8
    //   183: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   186: ifeq +34 -> 220
    //   189: ldc 48
    //   191: iconst_4
    //   192: new 50	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   199: ldc 117
    //   201: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokestatic 122	android/os/SystemClock:uptimeMillis	()J
    //   207: getstatic 125	com/tencent/mobileqq/transfile/PttInfoCollector:jdField_a_of_type_Long	J
    //   210: lsub
    //   211: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   224: invokestatic 130	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   227: aload_0
    //   228: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   231: invokestatic 133	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/ptt/processor/PttCompositeProcessor;
    //   234: aload_0
    //   235: invokevirtual 138	com/tencent/mobileqq/ptt/processor/PttCompositeProcessor:a	(Lcom/tencent/mobileqq/ptt/processor/IPttProcessorListener;)V
    //   238: ldc2_w 139
    //   241: invokestatic 144	java/lang/Thread:sleep	(J)V
    //   244: aload_0
    //   245: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   248: getfield 96	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   251: getfield 147	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_Int	I
    //   254: invokestatic 149	com/tencent/mobileqq/utils/QQRecorder:b	(I)I
    //   257: sipush 1000
    //   260: idiv
    //   261: iload 8
    //   263: imul
    //   264: istore 14
    //   266: iconst_0
    //   267: istore 8
    //   269: iload 8
    //   271: iload 14
    //   273: if_icmpge +60 -> 333
    //   276: aload_0
    //   277: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   280: invokestatic 104	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   283: istore 9
    //   285: aload_0
    //   286: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   289: invokestatic 104	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   292: iload 14
    //   294: iload 8
    //   296: isub
    //   297: if_icmple +10 -> 307
    //   300: iload 14
    //   302: iload 8
    //   304: isub
    //   305: istore 9
    //   307: aload_0
    //   308: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   311: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   314: aload 6
    //   316: iconst_0
    //   317: iload 9
    //   319: invokevirtual 158	android/media/AudioRecord:read	([BII)I
    //   322: pop
    //   323: iload 9
    //   325: iload 8
    //   327: iadd
    //   328: istore 8
    //   330: goto -61 -> 269
    //   333: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +39 -> 375
    //   339: ldc 48
    //   341: iconst_2
    //   342: new 50	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   349: ldc -96
    //   351: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: iload 8
    //   356: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc -91
    //   361: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 14
    //   366: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload_0
    //   376: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   379: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   382: ifnull +3724 -> 4106
    //   385: aload_0
    //   386: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   389: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   392: aload_0
    //   393: getfield 167	wcy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   396: aload_0
    //   397: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   400: getfield 96	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   403: invokeinterface 170 3 0
    //   408: istore 14
    //   410: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   413: ifeq +34 -> 447
    //   416: ldc 48
    //   418: iconst_4
    //   419: new 50	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   426: ldc -84
    //   428: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokestatic 122	android/os/SystemClock:uptimeMillis	()J
    //   434: getstatic 125	com/tencent/mobileqq/transfile/PttInfoCollector:jdField_a_of_type_Long	J
    //   437: lsub
    //   438: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   450: lstore 26
    //   452: iconst_0
    //   453: istore 13
    //   455: iconst_0
    //   456: istore 9
    //   458: iconst_0
    //   459: istore 8
    //   461: lconst_0
    //   462: lstore 20
    //   464: lconst_0
    //   465: lstore 18
    //   467: lconst_0
    //   468: lstore 16
    //   470: dconst_0
    //   471: dstore_2
    //   472: aload_0
    //   473: getfield 28	wcy:jdField_a_of_type_Boolean	Z
    //   476: ifeq +1270 -> 1746
    //   479: aload_0
    //   480: getfield 174	wcy:c	Z
    //   483: ifne +1263 -> 1746
    //   486: iload 9
    //   488: istore 11
    //   490: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   493: lload 26
    //   495: lsub
    //   496: ldc2_w 175
    //   499: lcmp
    //   500: ifle +789 -> 1289
    //   503: iload 9
    //   505: istore 11
    //   507: iload 9
    //   509: ifne +780 -> 1289
    //   512: iconst_1
    //   513: istore 11
    //   515: lload 20
    //   517: lconst_0
    //   518: lcmp
    //   519: ifeq +8 -> 527
    //   522: iload 10
    //   524: ifne +765 -> 1289
    //   527: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq +39 -> 569
    //   533: ldc 48
    //   535: iconst_2
    //   536: new 50	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   543: ldc -78
    //   545: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: lload 20
    //   550: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   553: ldc -76
    //   555: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: iload 10
    //   560: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: new 182	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException
    //   572: dup
    //   573: ldc -72
    //   575: invokespecial 186	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException:<init>	(Ljava/lang/String;)V
    //   578: athrow
    //   579: astore 6
    //   581: lload 20
    //   583: lstore 26
    //   585: lload 18
    //   587: lstore 20
    //   589: lload 26
    //   591: lstore 18
    //   593: iload 8
    //   595: istore 9
    //   597: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   600: ifeq +13 -> 613
    //   603: ldc 48
    //   605: iconst_2
    //   606: ldc -68
    //   608: aload 6
    //   610: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   613: aload_0
    //   614: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   617: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   620: ifnull +71 -> 691
    //   623: aload_0
    //   624: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   627: getfield 194	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   630: ifnull +25 -> 655
    //   633: aload_0
    //   634: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   637: invokestatic 196	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   640: iconst_m1
    //   641: if_icmpeq +14 -> 655
    //   644: aload_0
    //   645: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   648: getfield 194	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   651: iconst_0
    //   652: invokevirtual 201	android/media/AudioManager:setMode	(I)V
    //   655: aload 6
    //   657: instanceof 203
    //   660: ifne +11 -> 671
    //   663: aload 6
    //   665: instanceof 205
    //   668: ifeq +2057 -> 2725
    //   671: aload_0
    //   672: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   675: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   678: aload_1
    //   679: aload_0
    //   680: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   683: getfield 96	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   686: invokeinterface 207 3 0
    //   691: aload_0
    //   692: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   695: aload 6
    //   697: invokevirtual 210	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/Throwable;)V
    //   700: aload_0
    //   701: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   704: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   707: ifnull +27 -> 734
    //   710: aload_0
    //   711: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   714: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   717: invokevirtual 213	android/media/AudioRecord:getState	()I
    //   720: iconst_1
    //   721: if_icmpne +13 -> 734
    //   724: aload_0
    //   725: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   728: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   731: invokevirtual 216	android/media/AudioRecord:stop	()V
    //   734: aload_0
    //   735: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   738: invokestatic 218	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   741: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   744: ifeq +84 -> 828
    //   747: ldc 48
    //   749: iconst_2
    //   750: new 50	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   757: ldc -36
    //   759: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_0
    //   763: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: ldc 48
    //   774: iconst_2
    //   775: new 50	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   782: ldc -34
    //   784: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: lload 20
    //   789: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   792: ldc -32
    //   794: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: lload 18
    //   799: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: ldc -30
    //   804: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: lload 16
    //   809: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   812: ldc -28
    //   814: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: iload 9
    //   819: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: aload_0
    //   829: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   832: invokestatic 85	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   835: iconst_0
    //   836: invokestatic 90	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   839: pop
    //   840: lload 16
    //   842: ldc2_w 229
    //   845: lcmp
    //   846: iflt +11 -> 857
    //   849: dload_2
    //   850: ldc2_w 231
    //   853: dcmpg
    //   854: ifge +3 -> 857
    //   857: new 234	java/util/HashMap
    //   860: dup
    //   861: invokespecial 235	java/util/HashMap:<init>	()V
    //   864: astore_1
    //   865: aload_1
    //   866: ldc -19
    //   868: new 50	java/lang/StringBuilder
    //   871: dup
    //   872: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   875: getstatic 242	android/os/Build$VERSION:SDK_INT	I
    //   878: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   881: ldc -12
    //   883: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   892: pop
    //   893: aload_1
    //   894: ldc -6
    //   896: new 50	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   903: getstatic 255	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   906: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: ldc_w 257
    //   912: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: getstatic 260	android/os/Build:MODEL	Ljava/lang/String;
    //   918: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   927: pop
    //   928: aload_1
    //   929: ldc_w 262
    //   932: new 50	java/lang/StringBuilder
    //   935: dup
    //   936: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   939: lload 18
    //   941: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   944: ldc -12
    //   946: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   955: pop
    //   956: aload_1
    //   957: ldc_w 264
    //   960: new 50	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   967: dload_2
    //   968: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   971: ldc -12
    //   973: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   982: pop
    //   983: aload_1
    //   984: ldc_w 269
    //   987: new 50	java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   994: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   997: lload 28
    //   999: lsub
    //   1000: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1003: ldc -12
    //   1005: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1014: pop
    //   1015: aload_1
    //   1016: ldc_w 271
    //   1019: new 50	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1026: iload 10
    //   1028: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1031: ldc -12
    //   1033: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1039: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1042: pop
    //   1043: aload_1
    //   1044: ldc_w 273
    //   1047: new 50	java/lang/StringBuilder
    //   1050: dup
    //   1051: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1054: aload_0
    //   1055: getfield 32	wcy:jdField_a_of_type_Int	I
    //   1058: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1061: ldc -12
    //   1063: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1072: pop
    //   1073: lload 22
    //   1075: lconst_0
    //   1076: lcmp
    //   1077: ifne +2610 -> 3687
    //   1080: ldc2_w 274
    //   1083: lstore 20
    //   1085: goto +3027 -> 4112
    //   1088: lload 20
    //   1090: l2i
    //   1091: istore 8
    //   1093: aload_1
    //   1094: ldc_w 277
    //   1097: new 50	java/lang/StringBuilder
    //   1100: dup
    //   1101: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1104: iload 9
    //   1106: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1109: ldc -12
    //   1111: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1120: pop
    //   1121: aload_1
    //   1122: ldc_w 279
    //   1125: new 50	java/lang/StringBuilder
    //   1128: dup
    //   1129: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1132: iload 8
    //   1134: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1137: ldc -12
    //   1139: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1148: pop
    //   1149: ldc_w 281
    //   1152: iconst_1
    //   1153: aload_1
    //   1154: invokestatic 284	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1157: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1160: ifeq +128 -> 1288
    //   1163: new 50	java/lang/StringBuilder
    //   1166: dup
    //   1167: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1170: astore_1
    //   1171: aload_1
    //   1172: ldc_w 286
    //   1175: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: iload 10
    //   1180: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload_1
    //   1185: ldc_w 288
    //   1188: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: iload 9
    //   1193: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload_1
    //   1198: ldc_w 290
    //   1201: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: iload 8
    //   1206: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: aload_1
    //   1211: ldc_w 292
    //   1214: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: iload 8
    //   1219: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1222: pop
    //   1223: aload_1
    //   1224: ldc_w 294
    //   1227: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: lload 18
    //   1232: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1235: pop
    //   1236: aload_1
    //   1237: ldc_w 296
    //   1240: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: lload 16
    //   1245: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1248: pop
    //   1249: aload_1
    //   1250: ldc_w 298
    //   1253: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: dload_2
    //   1257: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1260: pop
    //   1261: aload_1
    //   1262: ldc_w 300
    //   1265: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   1271: lload 28
    //   1273: lsub
    //   1274: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: ldc 48
    //   1280: iconst_2
    //   1281: aload_1
    //   1282: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1285: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1288: return
    //   1289: iload 13
    //   1291: istore 12
    //   1293: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   1296: lload 26
    //   1298: lsub
    //   1299: ldc2_w 175
    //   1302: lcmp
    //   1303: ifle +99 -> 1402
    //   1306: iload 13
    //   1308: istore 12
    //   1310: iload 13
    //   1312: ifne +90 -> 1402
    //   1315: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1318: ifeq +32 -> 1350
    //   1321: ldc 48
    //   1323: iconst_2
    //   1324: new 50	java/lang/StringBuilder
    //   1327: dup
    //   1328: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1331: ldc_w 302
    //   1334: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: aload_0
    //   1338: getfield 32	wcy:jdField_a_of_type_Int	I
    //   1341: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1344: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1347: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1350: aload_0
    //   1351: getfield 32	wcy:jdField_a_of_type_Int	I
    //   1354: ifle +102 -> 1456
    //   1357: aload_0
    //   1358: getfield 32	wcy:jdField_a_of_type_Int	I
    //   1361: sipush 500
    //   1364: if_icmpge +92 -> 1456
    //   1367: iconst_1
    //   1368: istore 9
    //   1370: iload 9
    //   1372: istore 12
    //   1374: aload_0
    //   1375: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1378: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1381: ifnull +21 -> 1402
    //   1384: aload_0
    //   1385: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1388: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1391: iload 9
    //   1393: invokeinterface 304 2 0
    //   1398: iload 9
    //   1400: istore 12
    //   1402: lload 18
    //   1404: lconst_1
    //   1405: ladd
    //   1406: lstore 18
    //   1408: aload_0
    //   1409: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1412: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1415: aload 6
    //   1417: iconst_0
    //   1418: aload_0
    //   1419: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1422: invokestatic 104	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1425: invokevirtual 158	android/media/AudioRecord:read	([BII)I
    //   1428: istore 13
    //   1430: iload 13
    //   1432: ifgt +30 -> 1462
    //   1435: ldc2_w 305
    //   1438: invokestatic 144	java/lang/Thread:sleep	(J)V
    //   1441: iload 11
    //   1443: istore 9
    //   1445: iload 13
    //   1447: istore 8
    //   1449: iload 12
    //   1451: istore 13
    //   1453: goto -981 -> 472
    //   1456: iconst_2
    //   1457: istore 9
    //   1459: goto -89 -> 1370
    //   1462: lload 22
    //   1464: lconst_1
    //   1465: ladd
    //   1466: lstore 22
    //   1468: lload 20
    //   1470: iload 13
    //   1472: i2l
    //   1473: ladd
    //   1474: lstore 20
    //   1476: aload_0
    //   1477: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1480: invokestatic 85	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   1483: aload 6
    //   1485: iload 13
    //   1487: fconst_1
    //   1488: invokestatic 311	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   1491: l2i
    //   1492: istore 15
    //   1494: iload 10
    //   1496: iload 15
    //   1498: invokestatic 317	java/lang/Math:max	(II)I
    //   1501: istore 9
    //   1503: lload 24
    //   1505: iload 15
    //   1507: i2l
    //   1508: ladd
    //   1509: lstore 24
    //   1511: aload_0
    //   1512: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1515: invokestatic 133	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/ptt/processor/PttCompositeProcessor;
    //   1518: aload 6
    //   1520: iconst_0
    //   1521: iload 13
    //   1523: invokevirtual 320	com/tencent/mobileqq/ptt/processor/PttCompositeProcessor:a	([BII)Lcom/tencent/mobileqq/ptt/processor/IPttProcessor$ProcessData;
    //   1526: astore 7
    //   1528: invokestatic 322	com/tencent/mobileqq/transfile/PttInfoCollector:b	()V
    //   1531: iload 13
    //   1533: i2l
    //   1534: aload_0
    //   1535: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1538: getfield 96	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1541: getfield 147	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_Int	I
    //   1544: invokestatic 325	com/tencent/mobileqq/utils/QQRecorder:a	(JI)D
    //   1547: dstore 4
    //   1549: dload_2
    //   1550: dload 4
    //   1552: dadd
    //   1553: dstore_2
    //   1554: aload_0
    //   1555: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1558: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1561: ifnull +46 -> 1607
    //   1564: aload 7
    //   1566: ifnull +41 -> 1607
    //   1569: aload_0
    //   1570: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1573: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1576: aload_1
    //   1577: aload 7
    //   1579: getfield 330	com/tencent/mobileqq/ptt/processor/IPttProcessor$ProcessData:jdField_a_of_type_ArrayOfByte	[B
    //   1582: aload 7
    //   1584: getfield 331	com/tencent/mobileqq/ptt/processor/IPttProcessor$ProcessData:jdField_a_of_type_Int	I
    //   1587: aload_0
    //   1588: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1591: invokestatic 333	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1594: dload_2
    //   1595: aload_0
    //   1596: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1599: getfield 96	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1602: invokeinterface 336 8 0
    //   1607: aload 7
    //   1609: ifnull +2494 -> 4103
    //   1612: aload 7
    //   1614: getfield 331	com/tencent/mobileqq/ptt/processor/IPttProcessor$ProcessData:jdField_a_of_type_Int	I
    //   1617: istore 10
    //   1619: lload 16
    //   1621: iload 10
    //   1623: i2l
    //   1624: ladd
    //   1625: lstore 16
    //   1627: iload 12
    //   1629: iconst_1
    //   1630: if_icmpne +2466 -> 4096
    //   1633: aload_0
    //   1634: getfield 32	wcy:jdField_a_of_type_Int	I
    //   1637: sipush 500
    //   1640: if_icmple +2456 -> 4096
    //   1643: iconst_2
    //   1644: istore 12
    //   1646: aload_0
    //   1647: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1650: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1653: ifnull +16 -> 1669
    //   1656: aload_0
    //   1657: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1660: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1663: iconst_2
    //   1664: invokeinterface 304 2 0
    //   1669: iload 12
    //   1671: istore 10
    //   1673: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1676: ifeq +36 -> 1712
    //   1679: ldc 48
    //   1681: iconst_2
    //   1682: new 50	java/lang/StringBuilder
    //   1685: dup
    //   1686: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1689: ldc_w 338
    //   1692: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1695: aload_0
    //   1696: getfield 32	wcy:jdField_a_of_type_Int	I
    //   1699: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1702: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1705: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1708: iload 12
    //   1710: istore 10
    //   1712: iload 14
    //   1714: iconst_m1
    //   1715: if_icmpeq +16 -> 1731
    //   1718: dload_2
    //   1719: iload 14
    //   1721: i2d
    //   1722: dcmpl
    //   1723: iflt +8 -> 1731
    //   1726: aload_0
    //   1727: iconst_1
    //   1728: putfield 174	wcy:c	Z
    //   1731: iload 10
    //   1733: istore 13
    //   1735: iload 9
    //   1737: istore 10
    //   1739: iload 11
    //   1741: istore 9
    //   1743: goto -1271 -> 472
    //   1746: aload_0
    //   1747: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1750: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1753: ifnull +56 -> 1809
    //   1756: aload_0
    //   1757: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1760: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1763: aload_1
    //   1764: aload_0
    //   1765: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1768: getfield 96	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1771: dload_2
    //   1772: invokeinterface 341 5 0
    //   1777: aload_0
    //   1778: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1781: getfield 194	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1784: ifnull +25 -> 1809
    //   1787: aload_0
    //   1788: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1791: invokestatic 196	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1794: iconst_m1
    //   1795: if_icmpeq +14 -> 1809
    //   1798: aload_0
    //   1799: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1802: getfield 194	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1805: iconst_0
    //   1806: invokevirtual 201	android/media/AudioManager:setMode	(I)V
    //   1809: aload_0
    //   1810: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1813: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1816: ifnull +27 -> 1843
    //   1819: aload_0
    //   1820: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1823: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1826: invokevirtual 213	android/media/AudioRecord:getState	()I
    //   1829: iconst_1
    //   1830: if_icmpne +13 -> 1843
    //   1833: aload_0
    //   1834: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1837: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1840: invokevirtual 216	android/media/AudioRecord:stop	()V
    //   1843: aload_0
    //   1844: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1847: invokestatic 218	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   1850: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1853: ifeq +84 -> 1937
    //   1856: ldc 48
    //   1858: iconst_2
    //   1859: new 50	java/lang/StringBuilder
    //   1862: dup
    //   1863: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1866: ldc -36
    //   1868: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: aload_0
    //   1872: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1875: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1878: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1881: ldc 48
    //   1883: iconst_2
    //   1884: new 50	java/lang/StringBuilder
    //   1887: dup
    //   1888: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1891: ldc -34
    //   1893: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: lload 18
    //   1898: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1901: ldc -32
    //   1903: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: lload 20
    //   1908: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1911: ldc -30
    //   1913: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: lload 16
    //   1918: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1921: ldc -28
    //   1923: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: iload 8
    //   1928: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1931: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1934: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1937: aload_0
    //   1938: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1941: invokestatic 85	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   1944: iconst_0
    //   1945: invokestatic 90	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   1948: pop
    //   1949: lload 16
    //   1951: ldc2_w 229
    //   1954: lcmp
    //   1955: iflt +11 -> 1966
    //   1958: dload_2
    //   1959: ldc2_w 231
    //   1962: dcmpg
    //   1963: ifge +262 -> 2225
    //   1966: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   1969: lload 28
    //   1971: lsub
    //   1972: ldc2_w 175
    //   1975: lcmp
    //   1976: ifle +249 -> 2225
    //   1979: new 234	java/util/HashMap
    //   1982: dup
    //   1983: invokespecial 235	java/util/HashMap:<init>	()V
    //   1986: astore_1
    //   1987: aload_1
    //   1988: ldc_w 343
    //   1991: ldc_w 345
    //   1994: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1997: pop
    //   1998: aload_1
    //   1999: ldc -19
    //   2001: new 50	java/lang/StringBuilder
    //   2004: dup
    //   2005: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2008: getstatic 242	android/os/Build$VERSION:SDK_INT	I
    //   2011: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2014: ldc -12
    //   2016: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2019: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2022: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2025: pop
    //   2026: aload_1
    //   2027: ldc -6
    //   2029: new 50	java/lang/StringBuilder
    //   2032: dup
    //   2033: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2036: getstatic 255	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2039: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2042: ldc_w 257
    //   2045: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2048: getstatic 260	android/os/Build:MODEL	Ljava/lang/String;
    //   2051: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2057: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2060: pop
    //   2061: aload_1
    //   2062: ldc_w 262
    //   2065: new 50	java/lang/StringBuilder
    //   2068: dup
    //   2069: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2072: lload 20
    //   2074: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2077: ldc -12
    //   2079: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2085: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2088: pop
    //   2089: aload_1
    //   2090: ldc_w 347
    //   2093: new 50	java/lang/StringBuilder
    //   2096: dup
    //   2097: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2100: dload_2
    //   2101: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2104: ldc -12
    //   2106: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2112: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2115: pop
    //   2116: aload_1
    //   2117: ldc_w 269
    //   2120: new 50	java/lang/StringBuilder
    //   2123: dup
    //   2124: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2127: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   2130: lload 28
    //   2132: lsub
    //   2133: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2136: ldc -12
    //   2138: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2141: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2144: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2147: pop
    //   2148: ldc_w 349
    //   2151: iconst_0
    //   2152: aload_1
    //   2153: invokestatic 284	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2156: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2159: ifeq +66 -> 2225
    //   2162: ldc 48
    //   2164: iconst_2
    //   2165: new 50	java/lang/StringBuilder
    //   2168: dup
    //   2169: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2172: ldc_w 351
    //   2175: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: lload 20
    //   2180: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2183: ldc_w 353
    //   2186: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2189: lload 16
    //   2191: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2194: ldc_w 355
    //   2197: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2200: dload_2
    //   2201: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2204: ldc_w 357
    //   2207: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2210: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   2213: lload 28
    //   2215: lsub
    //   2216: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2219: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2222: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2225: new 234	java/util/HashMap
    //   2228: dup
    //   2229: invokespecial 235	java/util/HashMap:<init>	()V
    //   2232: astore_1
    //   2233: aload_1
    //   2234: ldc -19
    //   2236: new 50	java/lang/StringBuilder
    //   2239: dup
    //   2240: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2243: getstatic 242	android/os/Build$VERSION:SDK_INT	I
    //   2246: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2249: ldc -12
    //   2251: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2254: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2257: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2260: pop
    //   2261: aload_1
    //   2262: ldc -6
    //   2264: new 50	java/lang/StringBuilder
    //   2267: dup
    //   2268: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2271: getstatic 255	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2274: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: ldc_w 257
    //   2280: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2283: getstatic 260	android/os/Build:MODEL	Ljava/lang/String;
    //   2286: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2289: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2292: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2295: pop
    //   2296: aload_1
    //   2297: ldc_w 262
    //   2300: new 50	java/lang/StringBuilder
    //   2303: dup
    //   2304: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2307: lload 20
    //   2309: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2312: ldc -12
    //   2314: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2317: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2320: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2323: pop
    //   2324: aload_1
    //   2325: ldc_w 264
    //   2328: new 50	java/lang/StringBuilder
    //   2331: dup
    //   2332: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2335: dload_2
    //   2336: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2339: ldc -12
    //   2341: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2344: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2347: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2350: pop
    //   2351: aload_1
    //   2352: ldc_w 269
    //   2355: new 50	java/lang/StringBuilder
    //   2358: dup
    //   2359: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2362: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   2365: lload 28
    //   2367: lsub
    //   2368: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2371: ldc -12
    //   2373: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2376: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2379: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2382: pop
    //   2383: aload_1
    //   2384: ldc_w 271
    //   2387: new 50	java/lang/StringBuilder
    //   2390: dup
    //   2391: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2394: iload 10
    //   2396: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2399: ldc -12
    //   2401: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2404: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2407: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2410: pop
    //   2411: aload_1
    //   2412: ldc_w 273
    //   2415: new 50	java/lang/StringBuilder
    //   2418: dup
    //   2419: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2422: aload_0
    //   2423: getfield 32	wcy:jdField_a_of_type_Int	I
    //   2426: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2429: ldc -12
    //   2431: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2434: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2437: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2440: pop
    //   2441: lload 22
    //   2443: lconst_0
    //   2444: lcmp
    //   2445: ifne +258 -> 2703
    //   2448: ldc2_w 274
    //   2451: lstore 18
    //   2453: goto +1679 -> 4132
    //   2456: lload 18
    //   2458: l2i
    //   2459: istore 8
    //   2461: aload_1
    //   2462: ldc_w 277
    //   2465: new 50	java/lang/StringBuilder
    //   2468: dup
    //   2469: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2472: iload 9
    //   2474: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2477: ldc -12
    //   2479: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2482: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2485: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2488: pop
    //   2489: aload_1
    //   2490: ldc_w 279
    //   2493: new 50	java/lang/StringBuilder
    //   2496: dup
    //   2497: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2500: iload 8
    //   2502: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2505: ldc -12
    //   2507: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2510: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2513: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2516: pop
    //   2517: ldc_w 281
    //   2520: iconst_1
    //   2521: aload_1
    //   2522: invokestatic 284	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2525: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2528: ifeq -1240 -> 1288
    //   2531: new 50	java/lang/StringBuilder
    //   2534: dup
    //   2535: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2538: astore_1
    //   2539: aload_1
    //   2540: ldc_w 286
    //   2543: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: iload 10
    //   2548: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2551: pop
    //   2552: aload_1
    //   2553: ldc_w 288
    //   2556: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2559: iload 9
    //   2561: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2564: pop
    //   2565: aload_1
    //   2566: ldc_w 290
    //   2569: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2572: iload 8
    //   2574: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2577: pop
    //   2578: aload_1
    //   2579: ldc_w 292
    //   2582: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2585: iload 8
    //   2587: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2590: pop
    //   2591: aload_1
    //   2592: ldc_w 294
    //   2595: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2598: lload 20
    //   2600: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2603: pop
    //   2604: aload_1
    //   2605: ldc_w 296
    //   2608: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2611: lload 16
    //   2613: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2616: pop
    //   2617: aload_1
    //   2618: ldc_w 298
    //   2621: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2624: dload_2
    //   2625: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2628: pop
    //   2629: aload_1
    //   2630: ldc_w 300
    //   2633: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2636: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   2639: lload 28
    //   2641: lsub
    //   2642: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2645: pop
    //   2646: ldc 48
    //   2648: iconst_2
    //   2649: aload_1
    //   2650: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2653: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2656: return
    //   2657: astore_1
    //   2658: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2661: ifeq -1373 -> 1288
    //   2664: ldc 48
    //   2666: iconst_2
    //   2667: ldc_w 359
    //   2670: aload_1
    //   2671: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2674: return
    //   2675: astore_1
    //   2676: aload_1
    //   2677: invokevirtual 362	java/lang/Throwable:printStackTrace	()V
    //   2680: goto -830 -> 1850
    //   2683: astore_1
    //   2684: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2687: ifeq -462 -> 2225
    //   2690: ldc 48
    //   2692: iconst_2
    //   2693: ldc_w 364
    //   2696: aload_1
    //   2697: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2700: goto -475 -> 2225
    //   2703: lload 24
    //   2705: lload 22
    //   2707: ldiv
    //   2708: lstore 18
    //   2710: goto +1422 -> 4132
    //   2713: aload_0
    //   2714: getfield 34	wcy:jdField_a_of_type_Long	J
    //   2717: lload 22
    //   2719: ldiv
    //   2720: lstore 18
    //   2722: goto -266 -> 2456
    //   2725: aload 6
    //   2727: instanceof 182
    //   2730: ifeq +921 -> 3651
    //   2733: aload_0
    //   2734: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2737: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2740: aload_1
    //   2741: aload_0
    //   2742: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2745: getfield 96	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   2748: invokeinterface 366 3 0
    //   2753: goto -2062 -> 691
    //   2756: astore_1
    //   2757: iconst_1
    //   2758: istore 8
    //   2760: lload 20
    //   2762: lstore 26
    //   2764: lload 18
    //   2766: lstore 20
    //   2768: aload_0
    //   2769: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2772: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2775: ifnull +27 -> 2802
    //   2778: aload_0
    //   2779: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2782: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2785: invokevirtual 213	android/media/AudioRecord:getState	()I
    //   2788: iconst_1
    //   2789: if_icmpne +13 -> 2802
    //   2792: aload_0
    //   2793: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2796: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2799: invokevirtual 216	android/media/AudioRecord:stop	()V
    //   2802: aload_0
    //   2803: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2806: invokestatic 218	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2809: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2812: ifeq +84 -> 2896
    //   2815: ldc 48
    //   2817: iconst_2
    //   2818: new 50	java/lang/StringBuilder
    //   2821: dup
    //   2822: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2825: ldc -36
    //   2827: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2830: aload_0
    //   2831: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2834: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2837: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2840: ldc 48
    //   2842: iconst_2
    //   2843: new 50	java/lang/StringBuilder
    //   2846: dup
    //   2847: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2850: ldc -34
    //   2852: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2855: lload 26
    //   2857: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2860: ldc -32
    //   2862: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2865: lload 20
    //   2867: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2870: ldc -30
    //   2872: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2875: lload 16
    //   2877: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2880: ldc -28
    //   2882: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2885: iload 9
    //   2887: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2890: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2893: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2896: aload_0
    //   2897: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2900: invokestatic 85	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   2903: iconst_0
    //   2904: invokestatic 90	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   2907: pop
    //   2908: lload 16
    //   2910: ldc2_w 229
    //   2913: lcmp
    //   2914: iflt +11 -> 2925
    //   2917: dload_2
    //   2918: ldc2_w 231
    //   2921: dcmpg
    //   2922: ifge +275 -> 3197
    //   2925: iload 8
    //   2927: ifne +270 -> 3197
    //   2930: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   2933: lload 28
    //   2935: lsub
    //   2936: ldc2_w 175
    //   2939: lcmp
    //   2940: ifle +257 -> 3197
    //   2943: new 234	java/util/HashMap
    //   2946: dup
    //   2947: invokespecial 235	java/util/HashMap:<init>	()V
    //   2950: astore 6
    //   2952: aload 6
    //   2954: ldc_w 343
    //   2957: ldc_w 345
    //   2960: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2963: pop
    //   2964: aload 6
    //   2966: ldc -19
    //   2968: new 50	java/lang/StringBuilder
    //   2971: dup
    //   2972: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2975: getstatic 242	android/os/Build$VERSION:SDK_INT	I
    //   2978: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2981: ldc -12
    //   2983: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2986: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2989: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2992: pop
    //   2993: aload 6
    //   2995: ldc -6
    //   2997: new 50	java/lang/StringBuilder
    //   3000: dup
    //   3001: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3004: getstatic 255	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3007: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3010: ldc_w 257
    //   3013: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3016: getstatic 260	android/os/Build:MODEL	Ljava/lang/String;
    //   3019: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3022: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3025: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3028: pop
    //   3029: aload 6
    //   3031: ldc_w 262
    //   3034: new 50	java/lang/StringBuilder
    //   3037: dup
    //   3038: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3041: lload 20
    //   3043: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3046: ldc -12
    //   3048: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3051: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3054: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3057: pop
    //   3058: aload 6
    //   3060: ldc_w 347
    //   3063: new 50	java/lang/StringBuilder
    //   3066: dup
    //   3067: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3070: dload_2
    //   3071: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3074: ldc -12
    //   3076: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3079: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3082: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3085: pop
    //   3086: aload 6
    //   3088: ldc_w 269
    //   3091: new 50	java/lang/StringBuilder
    //   3094: dup
    //   3095: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3098: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   3101: lload 28
    //   3103: lsub
    //   3104: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3107: ldc -12
    //   3109: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3112: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3115: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3118: pop
    //   3119: ldc_w 349
    //   3122: iconst_0
    //   3123: aload 6
    //   3125: invokestatic 284	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3128: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3131: ifeq +66 -> 3197
    //   3134: ldc 48
    //   3136: iconst_2
    //   3137: new 50	java/lang/StringBuilder
    //   3140: dup
    //   3141: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3144: ldc_w 351
    //   3147: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3150: lload 20
    //   3152: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3155: ldc_w 353
    //   3158: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3161: lload 16
    //   3163: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3166: ldc_w 355
    //   3169: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3172: dload_2
    //   3173: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3176: ldc_w 357
    //   3179: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3182: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   3185: lload 28
    //   3187: lsub
    //   3188: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3191: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3194: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3197: new 234	java/util/HashMap
    //   3200: dup
    //   3201: invokespecial 235	java/util/HashMap:<init>	()V
    //   3204: astore 6
    //   3206: aload 6
    //   3208: ldc -19
    //   3210: new 50	java/lang/StringBuilder
    //   3213: dup
    //   3214: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3217: getstatic 242	android/os/Build$VERSION:SDK_INT	I
    //   3220: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3223: ldc -12
    //   3225: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3228: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3231: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3234: pop
    //   3235: aload 6
    //   3237: ldc -6
    //   3239: new 50	java/lang/StringBuilder
    //   3242: dup
    //   3243: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3246: getstatic 255	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3249: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3252: ldc_w 257
    //   3255: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3258: getstatic 260	android/os/Build:MODEL	Ljava/lang/String;
    //   3261: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3264: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3267: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3270: pop
    //   3271: aload 6
    //   3273: ldc_w 262
    //   3276: new 50	java/lang/StringBuilder
    //   3279: dup
    //   3280: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3283: lload 20
    //   3285: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3288: ldc -12
    //   3290: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3293: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3296: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3299: pop
    //   3300: aload 6
    //   3302: ldc_w 264
    //   3305: new 50	java/lang/StringBuilder
    //   3308: dup
    //   3309: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3312: dload_2
    //   3313: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3316: ldc -12
    //   3318: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3321: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3324: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3327: pop
    //   3328: aload 6
    //   3330: ldc_w 269
    //   3333: new 50	java/lang/StringBuilder
    //   3336: dup
    //   3337: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3340: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   3343: lload 28
    //   3345: lsub
    //   3346: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3349: ldc -12
    //   3351: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3354: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3357: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3360: pop
    //   3361: aload 6
    //   3363: ldc_w 271
    //   3366: new 50	java/lang/StringBuilder
    //   3369: dup
    //   3370: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3373: iload 10
    //   3375: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3378: ldc -12
    //   3380: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3383: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3386: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3389: pop
    //   3390: aload 6
    //   3392: ldc_w 273
    //   3395: new 50	java/lang/StringBuilder
    //   3398: dup
    //   3399: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3402: aload_0
    //   3403: getfield 32	wcy:jdField_a_of_type_Int	I
    //   3406: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3409: ldc -12
    //   3411: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3414: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3417: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3420: pop
    //   3421: lload 22
    //   3423: lconst_0
    //   3424: lcmp
    //   3425: ifne +334 -> 3759
    //   3428: ldc2_w 274
    //   3431: lstore 18
    //   3433: goto +719 -> 4152
    //   3436: lload 18
    //   3438: l2i
    //   3439: istore 8
    //   3441: aload 6
    //   3443: ldc_w 277
    //   3446: new 50	java/lang/StringBuilder
    //   3449: dup
    //   3450: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3453: iload 9
    //   3455: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3458: ldc -12
    //   3460: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3463: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3466: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3469: pop
    //   3470: aload 6
    //   3472: ldc_w 279
    //   3475: new 50	java/lang/StringBuilder
    //   3478: dup
    //   3479: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3482: iload 8
    //   3484: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3487: ldc -12
    //   3489: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3492: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3495: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3498: pop
    //   3499: ldc_w 281
    //   3502: iconst_1
    //   3503: aload 6
    //   3505: invokestatic 284	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3508: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3511: ifeq +138 -> 3649
    //   3514: new 50	java/lang/StringBuilder
    //   3517: dup
    //   3518: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   3521: astore 6
    //   3523: aload 6
    //   3525: ldc_w 286
    //   3528: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3531: iload 10
    //   3533: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3536: pop
    //   3537: aload 6
    //   3539: ldc_w 288
    //   3542: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3545: iload 9
    //   3547: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3550: pop
    //   3551: aload 6
    //   3553: ldc_w 290
    //   3556: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3559: iload 8
    //   3561: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3564: pop
    //   3565: aload 6
    //   3567: ldc_w 292
    //   3570: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3573: iload 8
    //   3575: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3578: pop
    //   3579: aload 6
    //   3581: ldc_w 294
    //   3584: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3587: lload 20
    //   3589: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3592: pop
    //   3593: aload 6
    //   3595: ldc_w 296
    //   3598: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3601: lload 16
    //   3603: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3606: pop
    //   3607: aload 6
    //   3609: ldc_w 298
    //   3612: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3615: dload_2
    //   3616: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3619: pop
    //   3620: aload 6
    //   3622: ldc_w 300
    //   3625: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3628: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   3631: lload 28
    //   3633: lsub
    //   3634: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3637: pop
    //   3638: ldc 48
    //   3640: iconst_2
    //   3641: aload 6
    //   3643: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3646: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3649: aload_1
    //   3650: athrow
    //   3651: aload_0
    //   3652: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3655: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   3658: aload_1
    //   3659: aload_0
    //   3660: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3663: getfield 96	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   3666: aload 6
    //   3668: invokevirtual 369	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   3671: invokeinterface 372 4 0
    //   3676: goto -2985 -> 691
    //   3679: astore_1
    //   3680: aload_1
    //   3681: invokevirtual 362	java/lang/Throwable:printStackTrace	()V
    //   3684: goto -2943 -> 741
    //   3687: lload 24
    //   3689: lload 22
    //   3691: ldiv
    //   3692: lstore 20
    //   3694: goto +418 -> 4112
    //   3697: aload_0
    //   3698: getfield 34	wcy:jdField_a_of_type_Long	J
    //   3701: lload 22
    //   3703: ldiv
    //   3704: lstore 20
    //   3706: goto -2618 -> 1088
    //   3709: astore_1
    //   3710: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3713: ifeq -2425 -> 1288
    //   3716: ldc 48
    //   3718: iconst_2
    //   3719: ldc_w 359
    //   3722: aload_1
    //   3723: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3726: return
    //   3727: astore 6
    //   3729: aload 6
    //   3731: invokevirtual 362	java/lang/Throwable:printStackTrace	()V
    //   3734: goto -925 -> 2809
    //   3737: astore 6
    //   3739: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3742: ifeq -545 -> 3197
    //   3745: ldc 48
    //   3747: iconst_2
    //   3748: ldc_w 364
    //   3751: aload 6
    //   3753: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3756: goto -559 -> 3197
    //   3759: lload 24
    //   3761: lload 22
    //   3763: ldiv
    //   3764: lstore 18
    //   3766: goto +386 -> 4152
    //   3769: aload_0
    //   3770: getfield 34	wcy:jdField_a_of_type_Long	J
    //   3773: lload 22
    //   3775: ldiv
    //   3776: lstore 18
    //   3778: goto -342 -> 3436
    //   3781: astore 6
    //   3783: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3786: ifeq -137 -> 3649
    //   3789: ldc 48
    //   3791: iconst_2
    //   3792: ldc_w 359
    //   3795: aload 6
    //   3797: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3800: goto -151 -> 3649
    //   3803: astore_1
    //   3804: lconst_0
    //   3805: lstore 26
    //   3807: lconst_0
    //   3808: lstore 16
    //   3810: iconst_0
    //   3811: istore 8
    //   3813: iload 13
    //   3815: istore 10
    //   3817: iload 11
    //   3819: istore 9
    //   3821: lload 18
    //   3823: lstore 20
    //   3825: goto -1057 -> 2768
    //   3828: astore_1
    //   3829: iload 8
    //   3831: istore 9
    //   3833: iconst_0
    //   3834: istore 8
    //   3836: lload 18
    //   3838: lstore 26
    //   3840: goto -1072 -> 2768
    //   3843: astore_1
    //   3844: iload 8
    //   3846: istore 9
    //   3848: iconst_0
    //   3849: istore 8
    //   3851: lload 18
    //   3853: lstore 26
    //   3855: goto -1087 -> 2768
    //   3858: astore_1
    //   3859: iload 13
    //   3861: istore 9
    //   3863: iconst_0
    //   3864: istore 8
    //   3866: lload 18
    //   3868: lstore 26
    //   3870: goto -1102 -> 2768
    //   3873: astore_1
    //   3874: iload 8
    //   3876: istore 9
    //   3878: iconst_0
    //   3879: istore 8
    //   3881: lload 18
    //   3883: lstore 26
    //   3885: goto -1117 -> 2768
    //   3888: astore_1
    //   3889: iload 9
    //   3891: istore 10
    //   3893: iload 8
    //   3895: istore 9
    //   3897: iconst_0
    //   3898: istore 8
    //   3900: lload 18
    //   3902: lstore 26
    //   3904: goto -1136 -> 2768
    //   3907: astore_1
    //   3908: iload 9
    //   3910: istore 10
    //   3912: iload 8
    //   3914: istore 9
    //   3916: iconst_0
    //   3917: istore 8
    //   3919: lload 18
    //   3921: lstore 26
    //   3923: goto -1155 -> 2768
    //   3926: astore_1
    //   3927: iload 9
    //   3929: istore 10
    //   3931: iload 8
    //   3933: istore 9
    //   3935: iconst_0
    //   3936: istore 8
    //   3938: lload 18
    //   3940: lstore 26
    //   3942: goto -1174 -> 2768
    //   3945: astore 6
    //   3947: iload 15
    //   3949: istore 10
    //   3951: iload 12
    //   3953: istore 9
    //   3955: goto -3358 -> 597
    //   3958: astore 6
    //   3960: lload 18
    //   3962: lstore 26
    //   3964: iload 8
    //   3966: istore 9
    //   3968: lload 20
    //   3970: lstore 18
    //   3972: lload 26
    //   3974: lstore 20
    //   3976: goto -3379 -> 597
    //   3979: astore 6
    //   3981: iload 13
    //   3983: istore 9
    //   3985: lload 18
    //   3987: lstore 26
    //   3989: lload 20
    //   3991: lstore 18
    //   3993: lload 26
    //   3995: lstore 20
    //   3997: goto -3400 -> 597
    //   4000: astore 6
    //   4002: lload 18
    //   4004: lstore 26
    //   4006: iload 8
    //   4008: istore 9
    //   4010: lload 20
    //   4012: lstore 18
    //   4014: lload 26
    //   4016: lstore 20
    //   4018: goto -3421 -> 597
    //   4021: astore 6
    //   4023: lload 18
    //   4025: lstore 26
    //   4027: iload 9
    //   4029: istore 10
    //   4031: iload 8
    //   4033: istore 9
    //   4035: lload 20
    //   4037: lstore 18
    //   4039: lload 26
    //   4041: lstore 20
    //   4043: goto -3446 -> 597
    //   4046: astore 6
    //   4048: lload 18
    //   4050: lstore 26
    //   4052: iload 9
    //   4054: istore 10
    //   4056: iload 8
    //   4058: istore 9
    //   4060: lload 20
    //   4062: lstore 18
    //   4064: lload 26
    //   4066: lstore 20
    //   4068: goto -3471 -> 597
    //   4071: astore 6
    //   4073: lload 18
    //   4075: lstore 26
    //   4077: lload 20
    //   4079: lstore 18
    //   4081: iload 9
    //   4083: istore 10
    //   4085: iload 8
    //   4087: istore 9
    //   4089: lload 26
    //   4091: lstore 20
    //   4093: goto -3496 -> 597
    //   4096: iload 12
    //   4098: istore 10
    //   4100: goto -2388 -> 1712
    //   4103: goto -2476 -> 1627
    //   4106: iconst_m1
    //   4107: istore 14
    //   4109: goto -3699 -> 410
    //   4112: lload 20
    //   4114: l2i
    //   4115: istore 9
    //   4117: lload 22
    //   4119: lconst_0
    //   4120: lcmp
    //   4121: ifne -424 -> 3697
    //   4124: ldc2_w 274
    //   4127: lstore 20
    //   4129: goto -3041 -> 1088
    //   4132: lload 18
    //   4134: l2i
    //   4135: istore 9
    //   4137: lload 22
    //   4139: lconst_0
    //   4140: lcmp
    //   4141: ifne -1428 -> 2713
    //   4144: ldc2_w 274
    //   4147: lstore 18
    //   4149: goto -1693 -> 2456
    //   4152: lload 18
    //   4154: l2i
    //   4155: istore 9
    //   4157: lload 22
    //   4159: lconst_0
    //   4160: lcmp
    //   4161: ifne -392 -> 3769
    //   4164: ldc2_w 274
    //   4167: lstore 18
    //   4169: goto -733 -> 3436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4172	0	this	wcy
    //   0	4172	1	paramString	String
    //   44	3572	2	d1	double
    //   1547	4	4	d2	double
    //   129	186	6	arrayOfByte	byte[]
    //   579	2147	6	localThrowable1	Throwable
    //   2950	717	6	localObject	Object
    //   3727	3	6	localThrowable2	Throwable
    //   3737	15	6	localException1	Exception
    //   3781	15	6	localException2	Exception
    //   3945	1	6	localThrowable3	Throwable
    //   3958	1	6	localThrowable4	Throwable
    //   3979	1	6	localThrowable5	Throwable
    //   4000	1	6	localThrowable6	Throwable
    //   4021	1	6	localThrowable7	Throwable
    //   4046	1	6	localThrowable8	Throwable
    //   4071	1	6	localThrowable9	Throwable
    //   1526	87	7	localProcessData	IPttProcessor.ProcessData
    //   71	4015	8	i	int
    //   160	3996	9	j	int
    //   63	4036	10	k	int
    //   38	3780	11	m	int
    //   41	4056	12	n	int
    //   60	3922	13	i1	int
    //   264	3844	14	i2	int
    //   57	3891	15	i3	int
    //   51	3758	16	l1	long
    //   35	4133	18	l2	long
    //   32	4096	20	l3	long
    //   54	4104	22	l4	long
    //   66	3694	24	l5	long
    //   450	3640	26	l6	long
    //   48	3584	28	l7	long
    // Exception table:
    //   from	to	target	type
    //   472	486	579	java/lang/Throwable
    //   490	503	579	java/lang/Throwable
    //   527	569	579	java/lang/Throwable
    //   569	579	579	java/lang/Throwable
    //   1293	1306	579	java/lang/Throwable
    //   1315	1350	579	java/lang/Throwable
    //   1350	1367	579	java/lang/Throwable
    //   1374	1398	579	java/lang/Throwable
    //   1746	1809	579	java/lang/Throwable
    //   2225	2441	2657	java/lang/Exception
    //   2461	2656	2657	java/lang/Exception
    //   2703	2710	2657	java/lang/Exception
    //   2713	2722	2657	java/lang/Exception
    //   1843	1850	2675	java/lang/Throwable
    //   1979	2225	2683	java/lang/Exception
    //   597	613	2756	finally
    //   613	655	2756	finally
    //   655	671	2756	finally
    //   671	691	2756	finally
    //   691	700	2756	finally
    //   2725	2753	2756	finally
    //   3651	3676	2756	finally
    //   734	741	3679	java/lang/Throwable
    //   857	1073	3709	java/lang/Exception
    //   1093	1288	3709	java/lang/Exception
    //   3687	3694	3709	java/lang/Exception
    //   3697	3706	3709	java/lang/Exception
    //   2802	2809	3727	java/lang/Throwable
    //   2943	3197	3737	java/lang/Exception
    //   3197	3421	3781	java/lang/Exception
    //   3441	3649	3781	java/lang/Exception
    //   3759	3766	3781	java/lang/Exception
    //   3769	3778	3781	java/lang/Exception
    //   90	120	3803	finally
    //   120	138	3803	finally
    //   138	162	3803	finally
    //   176	183	3803	finally
    //   183	220	3803	finally
    //   220	266	3803	finally
    //   276	285	3803	finally
    //   285	300	3803	finally
    //   307	323	3803	finally
    //   333	375	3803	finally
    //   375	410	3803	finally
    //   410	447	3803	finally
    //   447	452	3803	finally
    //   472	486	3828	finally
    //   490	503	3828	finally
    //   527	569	3828	finally
    //   569	579	3828	finally
    //   1293	1306	3828	finally
    //   1315	1350	3828	finally
    //   1350	1367	3828	finally
    //   1374	1398	3828	finally
    //   1746	1809	3828	finally
    //   1408	1430	3843	finally
    //   1435	1441	3858	finally
    //   1476	1503	3873	finally
    //   1511	1549	3888	finally
    //   1554	1564	3907	finally
    //   1569	1607	3907	finally
    //   1612	1619	3907	finally
    //   1633	1643	3926	finally
    //   1646	1669	3926	finally
    //   1673	1708	3926	finally
    //   1726	1731	3926	finally
    //   90	120	3945	java/lang/Throwable
    //   120	138	3945	java/lang/Throwable
    //   138	162	3945	java/lang/Throwable
    //   176	183	3945	java/lang/Throwable
    //   183	220	3945	java/lang/Throwable
    //   220	266	3945	java/lang/Throwable
    //   276	285	3945	java/lang/Throwable
    //   285	300	3945	java/lang/Throwable
    //   307	323	3945	java/lang/Throwable
    //   333	375	3945	java/lang/Throwable
    //   375	410	3945	java/lang/Throwable
    //   410	447	3945	java/lang/Throwable
    //   447	452	3945	java/lang/Throwable
    //   1408	1430	3958	java/lang/Throwable
    //   1435	1441	3979	java/lang/Throwable
    //   1476	1503	4000	java/lang/Throwable
    //   1511	1549	4021	java/lang/Throwable
    //   1554	1564	4046	java/lang/Throwable
    //   1569	1607	4046	java/lang/Throwable
    //   1612	1619	4046	java/lang/Throwable
    //   1633	1643	4071	java/lang/Throwable
    //   1646	1669	4071	java/lang/Throwable
    //   1673	1708	4071	java/lang/Throwable
    //   1726	1731	4071	java/lang/Throwable
  }
  
  public void a()
  {
    if (QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "releaseRecorder");
      }
      QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder).release();
      QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder, null);
    }
  }
  
  public void a(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData) {}
  
  public boolean a()
  {
    return (this.b) || (QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder) != null);
  }
  
  public void b(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    if ((paramIPttProcessor instanceof PttAgcAndNsProcessor))
    {
      QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder, (int)AudioHelper.a(QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder), paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.jdField_a_of_type_Int, 1.0F));
      this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, QQRecorder.b(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder));
      this.jdField_a_of_type_Long += QQRecorder.b(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	wcy:b	Z
    //   4: ifeq +116 -> 120
    //   7: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 48
    //   15: iconst_2
    //   16: ldc_w 391
    //   19: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 28	wcy:jdField_a_of_type_Boolean	Z
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 174	wcy:c	Z
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 167	wcy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokespecial 393	wcy:a	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 30	wcy:b	Z
    //   44: ifeq -44 -> 0
    //   47: invokestatic 122	android/os/SystemClock:uptimeMillis	()J
    //   50: lstore_3
    //   51: aload_0
    //   52: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 18	wcy:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   62: getstatic 396	com/tencent/mobileqq/utils/QQRecorder:k	I
    //   65: i2l
    //   66: invokevirtual 401	java/lang/Object:wait	(J)V
    //   69: aload_1
    //   70: monitorexit
    //   71: invokestatic 122	android/os/SystemClock:uptimeMillis	()J
    //   74: lload_3
    //   75: lsub
    //   76: getstatic 396	com/tencent/mobileqq/utils/QQRecorder:k	I
    //   79: i2l
    //   80: lcmp
    //   81: iflt -81 -> 0
    //   84: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +12 -> 99
    //   90: ldc 48
    //   92: iconst_2
    //   93: ldc_w 403
    //   96: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_0
    //   100: monitorenter
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 30	wcy:b	Z
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_0
    //   109: invokevirtual 405	wcy:a	()V
    //   112: goto -112 -> 0
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 406	java/lang/InterruptedException:printStackTrace	()V
    //   120: aload_0
    //   121: invokevirtual 405	wcy:a	()V
    //   124: return
    //   125: astore_2
    //   126: aload_1
    //   127: monitorexit
    //   128: aload_2
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	wcy
    //   115	12	1	localInterruptedException	InterruptedException
    //   130	4	1	localObject1	Object
    //   125	4	2	localObject2	Object
    //   50	25	3	l	long
    // Exception table:
    //   from	to	target	type
    //   47	58	115	java/lang/InterruptedException
    //   71	99	115	java/lang/InterruptedException
    //   99	101	115	java/lang/InterruptedException
    //   108	112	115	java/lang/InterruptedException
    //   128	130	115	java/lang/InterruptedException
    //   133	135	115	java/lang/InterruptedException
    //   58	71	125	finally
    //   126	128	125	finally
    //   101	108	130	finally
    //   131	133	130	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wcy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */