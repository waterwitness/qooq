import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.activity.bless.BlessResultActivity.VideoInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ofz
  implements Runnable
{
  private long jdField_a_of_type_Long;
  public BlessResultActivity.VideoInfo a;
  private TroopBarShortVideoUploadUtil.OnUploadVideoListener jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private String b;
  private String c;
  private String d;
  
  public ofz(BlessResultActivity paramBlessResultActivity, String paramString1, String paramString2, BlessResultActivity.VideoInfo paramVideoInfo, TroopBarShortVideoUploadUtil.OnUploadVideoListener paramOnUploadVideoListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_Long = -1L;
    this.c = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo = paramVideoInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener = paramOnUploadVideoListener;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = paramBlessResultActivity.getString(2131363752);
    }
    if (this.b == null) {
      this.b = paramBlessResultActivity.getString(2131372390);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoUploadTask stop()");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean b()
  {
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "VideoUploadTask isRunning(),result = " + bool);
      }
      return bool;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   3: lstore 15
    //   5: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +11 -> 19
    //   11: ldc 69
    //   13: iconst_2
    //   14: ldc 111
    //   16: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 36	ofz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_0
    //   24: invokevirtual 77	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: aload_0
    //   28: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   31: ifnonnull +26 -> 57
    //   34: aload_0
    //   35: getfield 36	ofz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: iconst_1
    //   39: invokevirtual 77	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   42: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 113
    //   50: iconst_2
    //   51: ldc 115
    //   53: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: return
    //   57: aload_0
    //   58: getfield 46	ofz:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   61: ifnull +23 -> 84
    //   64: aload_0
    //   65: getfield 42	ofz:c	Ljava/lang/String;
    //   68: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +13 -> 84
    //   74: aload_0
    //   75: getfield 44	ofz:d	Ljava/lang/String;
    //   78: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +92 -> 173
    //   84: aload_0
    //   85: getfield 36	ofz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: iconst_1
    //   89: invokevirtual 77	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   92: aload_0
    //   93: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   96: ldc2_w 37
    //   99: invokeinterface 126 3 0
    //   104: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -51 -> 56
    //   110: aload_0
    //   111: getfield 46	ofz:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   114: ifnonnull +37 -> 151
    //   117: ldc -128
    //   119: astore_1
    //   120: ldc 113
    //   122: iconst_2
    //   123: new 84	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   130: ldc -126
    //   132: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_1
    //   136: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc -124
    //   141: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: return
    //   151: aload_0
    //   152: getfield 42	ofz:c	Ljava/lang/String;
    //   155: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifeq +9 -> 167
    //   161: ldc -122
    //   163: astore_1
    //   164: goto -44 -> 120
    //   167: ldc -120
    //   169: astore_1
    //   170: goto -50 -> 120
    //   173: aload_0
    //   174: getfield 46	ofz:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   177: getfield 139	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   180: astore 4
    //   182: new 141	java/io/File
    //   185: dup
    //   186: aload_0
    //   187: getfield 46	ofz:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   190: getfield 139	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   193: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   196: invokevirtual 147	java/io/File:getName	()Ljava/lang/String;
    //   199: astore_1
    //   200: new 149	android/os/Bundle
    //   203: dup
    //   204: invokespecial 150	android/os/Bundle:<init>	()V
    //   207: astore_2
    //   208: aload_2
    //   209: ldc -104
    //   211: aload_0
    //   212: getfield 50	ofz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   215: invokevirtual 156	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_2
    //   219: ldc -98
    //   221: aload 4
    //   223: invokevirtual 156	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_2
    //   227: ldc -96
    //   229: aload_0
    //   230: getfield 59	ofz:b	Ljava/lang/String;
    //   233: invokevirtual 156	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_2
    //   237: ldc -94
    //   239: aload_1
    //   240: invokevirtual 156	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_2
    //   244: ldc -92
    //   246: aload_0
    //   247: getfield 46	ofz:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   250: getfield 165	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:b	Ljava/lang/String;
    //   253: invokevirtual 156	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: invokestatic 171	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   259: invokestatic 176	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   262: ifeq +1070 -> 1332
    //   265: aload_0
    //   266: getfield 36	ofz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   269: invokevirtual 80	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   272: ifne +1060 -> 1332
    //   275: aload_2
    //   276: aload_0
    //   277: getfield 42	ofz:c	Ljava/lang/String;
    //   280: aload_0
    //   281: getfield 44	ofz:d	Ljava/lang/String;
    //   284: ldc -78
    //   286: iconst_0
    //   287: invokestatic 181	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   290: astore_3
    //   291: aload_3
    //   292: ifnull +1028 -> 1320
    //   295: aload 4
    //   297: invokestatic 186	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   300: lstore 13
    //   302: lload 13
    //   304: ldc2_w 187
    //   307: lcmp
    //   308: ifle +227 -> 535
    //   311: ldc2_w 187
    //   314: lstore 9
    //   316: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +43 -> 362
    //   322: ldc 69
    //   324: iconst_2
    //   325: new 84	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   332: ldc -66
    //   334: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_3
    //   338: getfield 195	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   341: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc -59
    //   346: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_3
    //   350: getfield 198	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:d	Ljava/lang/String;
    //   353: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: ldc -56
    //   364: aload_3
    //   365: getfield 195	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   368: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   371: ifeq +171 -> 542
    //   374: aload_0
    //   375: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   378: lload 9
    //   380: l2d
    //   381: ldc2_w 207
    //   384: dmul
    //   385: d2l
    //   386: invokeinterface 210 3 0
    //   391: aload_0
    //   392: getfield 36	ofz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   395: invokevirtual 80	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   398: ifne +928 -> 1326
    //   401: aload 4
    //   403: aload_0
    //   404: getfield 20	ofz:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   407: getfield 213	com/tencent/mobileqq/activity/bless/BlessResultActivity:i	Ljava/lang/String;
    //   410: aload_0
    //   411: getfield 42	ofz:c	Ljava/lang/String;
    //   414: aload_0
    //   415: getfield 44	ofz:d	Ljava/lang/String;
    //   418: aload_3
    //   419: getfield 216	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   422: aload_3
    //   423: getfield 219	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:g	Ljava/lang/String;
    //   426: ldc -78
    //   428: invokestatic 222	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   431: istore 18
    //   433: iload 18
    //   435: istore 17
    //   437: lload 9
    //   439: ldc2_w 37
    //   442: lcmp
    //   443: ifeq +18 -> 461
    //   446: aload_0
    //   447: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   450: lload 9
    //   452: invokeinterface 210 3 0
    //   457: iload 18
    //   459: istore 17
    //   461: aload_0
    //   462: getfield 20	ofz:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   465: aload_3
    //   466: getfield 216	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   469: putfield 225	com/tencent/mobileqq/activity/bless/BlessResultActivity:k	Ljava/lang/String;
    //   472: aload_0
    //   473: getfield 36	ofz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   476: iconst_0
    //   477: iconst_1
    //   478: invokevirtual 229	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   481: ifeq +754 -> 1235
    //   484: iload 17
    //   486: ifeq +698 -> 1184
    //   489: aload_0
    //   490: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   493: invokeinterface 231 1 0
    //   498: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq -445 -> 56
    //   504: ldc 69
    //   506: iconst_2
    //   507: new 84	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   514: ldc -23
    //   516: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   522: lload 15
    //   524: lsub
    //   525: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   528: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: return
    //   535: lload 13
    //   537: lstore 9
    //   539: goto -223 -> 316
    //   542: aload_3
    //   543: getfield 216	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   546: ifnull +774 -> 1320
    //   549: aload_3
    //   550: getfield 237	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:c	Ljava/lang/String;
    //   553: invokestatic 242	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   556: astore 5
    //   558: aload 4
    //   560: invokestatic 245	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   563: astore 6
    //   565: new 84	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   572: ldc -9
    //   574: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_3
    //   578: getfield 248	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   581: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc -6
    //   586: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_3
    //   590: getfield 251	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:b	Ljava/lang/String;
    //   593: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc -3
    //   598: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: astore 7
    //   606: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq +42 -> 651
    //   612: ldc 69
    //   614: iconst_2
    //   615: new 84	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   622: ldc -1
    //   624: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 7
    //   629: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: ldc_w 257
    //   635: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_3
    //   639: getfield 216	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   642: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: aload_0
    //   652: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   655: invokeinterface 259 1 0
    //   660: new 261	java/io/RandomAccessFile
    //   663: dup
    //   664: aload 4
    //   666: ldc_w 263
    //   669: invokespecial 265	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: astore_2
    //   673: lconst_0
    //   674: lstore 11
    //   676: lload 9
    //   678: lload 11
    //   680: lsub
    //   681: l2i
    //   682: istore 8
    //   684: aload_2
    //   685: astore_1
    //   686: invokestatic 171	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   689: invokestatic 176	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   692: ifeq +316 -> 1008
    //   695: aload_2
    //   696: astore_1
    //   697: aload_0
    //   698: getfield 36	ofz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   701: invokevirtual 80	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   704: ifne +304 -> 1008
    //   707: aload_2
    //   708: astore_1
    //   709: aload 5
    //   711: aload 6
    //   713: aload 7
    //   715: lload 13
    //   717: aload_2
    //   718: lload 11
    //   720: iload 8
    //   722: invokestatic 270	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   725: lstore 11
    //   727: aload_2
    //   728: astore_1
    //   729: aload_0
    //   730: lload 11
    //   732: putfield 40	ofz:jdField_a_of_type_Long	J
    //   735: lload 11
    //   737: ldc2_w 37
    //   740: lcmp
    //   741: ifeq +212 -> 953
    //   744: aload_2
    //   745: astore_1
    //   746: aload_0
    //   747: invokevirtual 82	ofz:a	()Z
    //   750: ifne +587 -> 1337
    //   753: aload_2
    //   754: astore_1
    //   755: aload_0
    //   756: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   759: lload 11
    //   761: l2d
    //   762: ldc2_w 207
    //   765: dmul
    //   766: d2l
    //   767: invokeinterface 210 3 0
    //   772: goto +565 -> 1337
    //   775: aload_2
    //   776: astore_1
    //   777: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   780: ifeq +32 -> 812
    //   783: aload_2
    //   784: astore_1
    //   785: ldc 69
    //   787: iconst_2
    //   788: new 84	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   795: ldc_w 272
    //   798: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: iload 17
    //   803: invokevirtual 94	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   806: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: iload 17
    //   814: ifeq +480 -> 1294
    //   817: aload_2
    //   818: astore_1
    //   819: aload_0
    //   820: getfield 36	ofz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   823: invokevirtual 80	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   826: ifne +468 -> 1294
    //   829: aload_2
    //   830: astore_1
    //   831: aload 4
    //   833: aload_0
    //   834: getfield 20	ofz:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   837: getfield 213	com/tencent/mobileqq/activity/bless/BlessResultActivity:i	Ljava/lang/String;
    //   840: aload_0
    //   841: getfield 42	ofz:c	Ljava/lang/String;
    //   844: aload_0
    //   845: getfield 44	ofz:d	Ljava/lang/String;
    //   848: aload_3
    //   849: getfield 216	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   852: aload_3
    //   853: getfield 219	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:g	Ljava/lang/String;
    //   856: ldc -78
    //   858: invokestatic 222	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   861: istore 17
    //   863: iload 17
    //   865: istore 18
    //   867: lload 9
    //   869: ldc2_w 37
    //   872: lcmp
    //   873: ifeq +20 -> 893
    //   876: aload_2
    //   877: astore_1
    //   878: aload_0
    //   879: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   882: lload 9
    //   884: invokeinterface 210 3 0
    //   889: iload 17
    //   891: istore 18
    //   893: aload_2
    //   894: astore_1
    //   895: aload_0
    //   896: getfield 20	ofz:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   899: aload_3
    //   900: getfield 216	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   903: putfield 225	com/tencent/mobileqq/activity/bless/BlessResultActivity:k	Ljava/lang/String;
    //   906: iload 18
    //   908: istore 17
    //   910: aload_2
    //   911: ifnull -439 -> 472
    //   914: aload_2
    //   915: invokevirtual 275	java/io/RandomAccessFile:close	()V
    //   918: iload 18
    //   920: istore 17
    //   922: goto -450 -> 472
    //   925: astore_1
    //   926: iload 18
    //   928: istore 17
    //   930: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   933: ifeq -461 -> 472
    //   936: ldc 69
    //   938: iconst_2
    //   939: aload_1
    //   940: invokestatic 279	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   943: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: iload 18
    //   948: istore 17
    //   950: goto -478 -> 472
    //   953: iconst_1
    //   954: istore 8
    //   956: aload_2
    //   957: astore_1
    //   958: lload 11
    //   960: lstore 13
    //   962: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   965: ifeq +345 -> 1310
    //   968: aload_2
    //   969: astore_1
    //   970: ldc 69
    //   972: iconst_2
    //   973: new 84	java/lang/StringBuilder
    //   976: dup
    //   977: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   980: ldc_w 281
    //   983: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   989: lload 15
    //   991: lsub
    //   992: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   995: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1001: lload 11
    //   1003: lstore 9
    //   1005: goto +359 -> 1364
    //   1008: iconst_1
    //   1009: istore 8
    //   1011: aload_2
    //   1012: astore_1
    //   1013: lload 9
    //   1015: lstore 13
    //   1017: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1020: ifeq +290 -> 1310
    //   1023: aload_2
    //   1024: astore_1
    //   1025: ldc 69
    //   1027: iconst_2
    //   1028: new 84	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1035: ldc_w 283
    //   1038: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   1044: lload 15
    //   1046: lsub
    //   1047: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1056: goto +308 -> 1364
    //   1059: astore_3
    //   1060: aconst_null
    //   1061: astore_2
    //   1062: iconst_0
    //   1063: istore 18
    //   1065: aload_2
    //   1066: astore_1
    //   1067: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1070: ifeq +34 -> 1104
    //   1073: aload_2
    //   1074: astore_1
    //   1075: ldc 69
    //   1077: iconst_2
    //   1078: new 84	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1085: ldc_w 285
    //   1088: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload_3
    //   1092: invokestatic 279	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1095: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1101: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1104: iload 18
    //   1106: istore 17
    //   1108: aload_2
    //   1109: ifnull -637 -> 472
    //   1112: aload_2
    //   1113: invokevirtual 275	java/io/RandomAccessFile:close	()V
    //   1116: iload 18
    //   1118: istore 17
    //   1120: goto -648 -> 472
    //   1123: astore_1
    //   1124: iload 18
    //   1126: istore 17
    //   1128: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1131: ifeq -659 -> 472
    //   1134: ldc 69
    //   1136: iconst_2
    //   1137: aload_1
    //   1138: invokestatic 279	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1141: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1144: iload 18
    //   1146: istore 17
    //   1148: goto -676 -> 472
    //   1151: astore_2
    //   1152: aconst_null
    //   1153: astore_1
    //   1154: aload_1
    //   1155: ifnull +7 -> 1162
    //   1158: aload_1
    //   1159: invokevirtual 275	java/io/RandomAccessFile:close	()V
    //   1162: aload_2
    //   1163: athrow
    //   1164: astore_1
    //   1165: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1168: ifeq -6 -> 1162
    //   1171: ldc 69
    //   1173: iconst_2
    //   1174: aload_1
    //   1175: invokestatic 279	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1178: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1181: goto -19 -> 1162
    //   1184: aload_0
    //   1185: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1188: aload_0
    //   1189: getfield 40	ofz:jdField_a_of_type_Long	J
    //   1192: invokeinterface 126 3 0
    //   1197: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1200: ifeq -1144 -> 56
    //   1203: ldc 69
    //   1205: iconst_2
    //   1206: new 84	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1213: ldc_w 287
    //   1216: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   1222: lload 15
    //   1224: lsub
    //   1225: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1228: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1231: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1234: return
    //   1235: aload_0
    //   1236: getfield 48	ofz:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1239: aload_0
    //   1240: getfield 40	ofz:jdField_a_of_type_Long	J
    //   1243: invokeinterface 289 3 0
    //   1248: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1251: ifeq -1195 -> 56
    //   1254: ldc 69
    //   1256: iconst_2
    //   1257: new 84	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   1264: ldc_w 291
    //   1267: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   1273: lload 15
    //   1275: lsub
    //   1276: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1279: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1282: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1285: return
    //   1286: astore_2
    //   1287: goto -133 -> 1154
    //   1290: astore_3
    //   1291: goto -229 -> 1062
    //   1294: iload 17
    //   1296: istore 18
    //   1298: goto -405 -> 893
    //   1301: iconst_0
    //   1302: istore 17
    //   1304: goto -529 -> 775
    //   1307: goto -631 -> 676
    //   1310: iconst_1
    //   1311: istore 8
    //   1313: lload 13
    //   1315: lstore 9
    //   1317: goto +47 -> 1364
    //   1320: iconst_0
    //   1321: istore 17
    //   1323: goto -851 -> 472
    //   1326: iconst_1
    //   1327: istore 17
    //   1329: goto -868 -> 461
    //   1332: aconst_null
    //   1333: astore_3
    //   1334: goto -1043 -> 291
    //   1337: ldc2_w 187
    //   1340: lload 11
    //   1342: ladd
    //   1343: lload 13
    //   1345: lcmp
    //   1346: ifle +29 -> 1375
    //   1349: lload 13
    //   1351: lstore 9
    //   1353: lload 11
    //   1355: lload 13
    //   1357: lcmp
    //   1358: iflt -51 -> 1307
    //   1361: iconst_0
    //   1362: istore 8
    //   1364: iload 8
    //   1366: ifne -65 -> 1301
    //   1369: iconst_1
    //   1370: istore 17
    //   1372: goto -597 -> 775
    //   1375: ldc2_w 187
    //   1378: lload 11
    //   1380: ladd
    //   1381: lstore 9
    //   1383: goto -30 -> 1353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1386	0	this	ofz
    //   119	776	1	localObject1	Object
    //   925	15	1	localIOException1	java.io.IOException
    //   957	118	1	localObject2	Object
    //   1123	15	1	localIOException2	java.io.IOException
    //   1153	6	1	localObject3	Object
    //   1164	11	1	localIOException3	java.io.IOException
    //   207	906	2	localObject4	Object
    //   1151	12	2	localObject5	Object
    //   1286	1	2	localObject6	Object
    //   290	610	3	localApplyUploadRsp	com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp
    //   1059	33	3	localException1	Exception
    //   1290	1	3	localException2	Exception
    //   1333	1	3	localObject7	Object
    //   180	652	4	str1	String
    //   556	154	5	arrayOfByte1	byte[]
    //   563	149	6	arrayOfByte2	byte[]
    //   604	110	7	str2	String
    //   682	683	8	i	int
    //   314	1068	9	l1	long
    //   674	705	11	l2	long
    //   300	1056	13	l3	long
    //   3	1271	15	l4	long
    //   435	936	17	bool1	boolean
    //   431	866	18	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   914	918	925	java/io/IOException
    //   651	673	1059	java/lang/Exception
    //   1112	1116	1123	java/io/IOException
    //   651	673	1151	finally
    //   1158	1162	1164	java/io/IOException
    //   686	695	1286	finally
    //   697	707	1286	finally
    //   709	727	1286	finally
    //   729	735	1286	finally
    //   746	753	1286	finally
    //   755	772	1286	finally
    //   777	783	1286	finally
    //   785	812	1286	finally
    //   819	829	1286	finally
    //   831	863	1286	finally
    //   878	889	1286	finally
    //   895	906	1286	finally
    //   962	968	1286	finally
    //   970	1001	1286	finally
    //   1017	1023	1286	finally
    //   1025	1056	1286	finally
    //   1067	1073	1286	finally
    //   1075	1104	1286	finally
    //   686	695	1290	java/lang/Exception
    //   697	707	1290	java/lang/Exception
    //   709	727	1290	java/lang/Exception
    //   729	735	1290	java/lang/Exception
    //   746	753	1290	java/lang/Exception
    //   755	772	1290	java/lang/Exception
    //   777	783	1290	java/lang/Exception
    //   785	812	1290	java/lang/Exception
    //   819	829	1290	java/lang/Exception
    //   831	863	1290	java/lang/Exception
    //   878	889	1290	java/lang/Exception
    //   895	906	1290	java/lang/Exception
    //   962	968	1290	java/lang/Exception
    //   970	1001	1290	java/lang/Exception
    //   1017	1023	1290	java/lang/Exception
    //   1025	1056	1290	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */