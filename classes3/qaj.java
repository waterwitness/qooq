import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class qaj
  extends Thread
{
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  public volatile boolean b;
  
  public qaj(MessageHandler paramMessageHandler, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.notifyAll();
      return;
    }
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 44
    //   8: iconst_2
    //   9: new 46	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   16: ldc 49
    //   18: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 57	qaj:getName	()Ljava/lang/String;
    //   25: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: iconst_0
    //   35: istore 4
    //   37: aload_0
    //   38: getfield 23	qaj:jdField_a_of_type_Boolean	Z
    //   41: ifeq +1119 -> 1160
    //   44: iload 4
    //   46: iconst_2
    //   47: if_icmplt +13 -> 60
    //   50: aload_0
    //   51: getfield 25	qaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   54: invokevirtual 70	java/util/ArrayList:size	()I
    //   57: ifle +1103 -> 1160
    //   60: ldc 72
    //   62: invokestatic 77	com/tencent/widget/TraceUtils:a	(Ljava/lang/String;)V
    //   65: iload 4
    //   67: istore 5
    //   69: aload_0
    //   70: getfield 25	qaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   73: astore_2
    //   74: iload 4
    //   76: istore 5
    //   78: aload_2
    //   79: monitorenter
    //   80: iload 4
    //   82: istore 5
    //   84: aload_0
    //   85: getfield 25	qaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   88: invokevirtual 70	java/util/ArrayList:size	()I
    //   91: ifle +473 -> 564
    //   94: iload 4
    //   96: istore 5
    //   98: aload_0
    //   99: getfield 25	qaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   102: iconst_0
    //   103: invokevirtual 81	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   106: checkcast 83	qak
    //   109: astore_1
    //   110: iconst_0
    //   111: istore 4
    //   113: aload_2
    //   114: monitorexit
    //   115: aload_0
    //   116: iconst_1
    //   117: putfield 34	qaj:b	Z
    //   120: aload_1
    //   121: ifnull +206 -> 327
    //   124: lconst_0
    //   125: lstore 7
    //   127: iconst_0
    //   128: istore 6
    //   130: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +84 -> 217
    //   136: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   139: lstore 9
    //   141: aload_1
    //   142: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   145: ifnull +509 -> 654
    //   148: aload_1
    //   149: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   152: invokevirtual 95	java/lang/Object:hashCode	()I
    //   155: istore 5
    //   157: iload 5
    //   159: istore 6
    //   161: lload 9
    //   163: lstore 7
    //   165: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +49 -> 217
    //   171: ldc 44
    //   173: iconst_2
    //   174: new 46	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   181: ldc 97
    //   183: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: getfield 101	qak:f	I
    //   190: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: ldc 106
    //   195: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload 5
    //   200: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: lload 9
    //   211: lstore 7
    //   213: iload 5
    //   215: istore 6
    //   217: aload_1
    //   218: getfield 101	qak:f	I
    //   221: tableswitch	default:+983->1204, 1:+439->660, 2:+482->703, 3:+510->731, 4:+532->753, 5:+725->946
    //   256: aload_0
    //   257: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   260: getfield 111	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   263: getfield 116	com/tencent/mobileqq/app/QQAppInterface:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   266: invokevirtual 120	com/tencent/mobileqq/app/automator/Automator:d	()V
    //   269: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +55 -> 327
    //   275: ldc 44
    //   277: iconst_2
    //   278: new 46	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   285: ldc 122
    //   287: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_1
    //   291: getfield 101	qak:f	I
    //   294: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: ldc 106
    //   299: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: iload 6
    //   304: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: ldc 124
    //   309: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   315: lload 7
    //   317: lsub
    //   318: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   321: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload_0
    //   328: iconst_0
    //   329: putfield 34	qaj:b	Z
    //   332: aload_0
    //   333: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   336: invokestatic 130	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   339: ifnull +194 -> 533
    //   342: aload_0
    //   343: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   346: invokestatic 133	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   349: ifeq +184 -> 533
    //   352: aload_0
    //   353: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   356: invokestatic 135	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   359: ifeq +174 -> 533
    //   362: aload_0
    //   363: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   366: invokestatic 138	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/lang/Object;
    //   369: astore_1
    //   370: aload_1
    //   371: monitorenter
    //   372: aload_0
    //   373: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   376: invokestatic 130	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   379: ifnull +152 -> 531
    //   382: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +11 -> 396
    //   388: ldc 44
    //   390: iconst_2
    //   391: ldc -116
    //   393: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: iconst_2
    //   397: anewarray 142	java/lang/Long
    //   400: astore_2
    //   401: aload_2
    //   402: iconst_0
    //   403: aload_0
    //   404: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   407: invokestatic 130	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   410: getfield 147	android/util/Pair:first	Ljava/lang/Object;
    //   413: checkcast 149	RegisterProxySvcPack/RegisterPushNotice
    //   416: getfield 153	RegisterProxySvcPack/RegisterPushNotice:ulTimeOutFlag	J
    //   419: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   422: aastore
    //   423: aload_2
    //   424: iconst_1
    //   425: aload_0
    //   426: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   429: invokestatic 130	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   432: getfield 160	android/util/Pair:second	Ljava/lang/Object;
    //   435: checkcast 142	java/lang/Long
    //   438: aastore
    //   439: aload_0
    //   440: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   443: invokestatic 130	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   446: getfield 147	android/util/Pair:first	Ljava/lang/Object;
    //   449: checkcast 149	RegisterProxySvcPack/RegisterPushNotice
    //   452: getfield 163	RegisterProxySvcPack/RegisterPushNotice:uFlag	J
    //   455: lconst_1
    //   456: land
    //   457: lconst_1
    //   458: lcmp
    //   459: ifne +690 -> 1149
    //   462: iconst_1
    //   463: istore 13
    //   465: aload_0
    //   466: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   469: aconst_null
    //   470: invokestatic 166	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;Landroid/util/Pair;)Landroid/util/Pair;
    //   473: pop
    //   474: aload_2
    //   475: iconst_1
    //   476: aaload
    //   477: invokevirtual 169	java/lang/Long:longValue	()J
    //   480: lconst_1
    //   481: lcmp
    //   482: ifeq +29 -> 511
    //   485: aload_0
    //   486: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   489: getfield 172	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   492: invokevirtual 176	com/tencent/mobileqq/service/message/MessageCache:d	()Z
    //   495: ifeq +16 -> 511
    //   498: aload_0
    //   499: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   502: getfield 172	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/service/message/MessageCache;
    //   505: invokevirtual 179	com/tencent/mobileqq/service/message/MessageCache:c	()Z
    //   508: ifne +23 -> 531
    //   511: aload_0
    //   512: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   515: invokevirtual 182	com/tencent/mobileqq/app/MessageHandler:k	()V
    //   518: aload_0
    //   519: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   522: sipush 4013
    //   525: iload 13
    //   527: aload_2
    //   528: invokevirtual 185	com/tencent/mobileqq/app/MessageHandler:a	(IZLjava/lang/Object;)V
    //   531: aload_1
    //   532: monitorexit
    //   533: aload_0
    //   534: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   537: invokestatic 187	com/tencent/mobileqq/app/MessageHandler:c	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   540: ifeq +15 -> 555
    //   543: aload_0
    //   544: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   547: sipush 4017
    //   550: iconst_1
    //   551: aconst_null
    //   552: invokevirtual 185	com/tencent/mobileqq/app/MessageHandler:a	(IZLjava/lang/Object;)V
    //   555: invokestatic 190	qaj:yield	()V
    //   558: invokestatic 192	com/tencent/widget/TraceUtils:a	()V
    //   561: goto -524 -> 37
    //   564: iload 4
    //   566: istore 5
    //   568: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +35 -> 606
    //   574: iload 4
    //   576: istore 5
    //   578: ldc 44
    //   580: iconst_2
    //   581: new 46	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   588: ldc -62
    //   590: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_0
    //   594: invokevirtual 57	qaj:getName	()Ljava/lang/String;
    //   597: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: iload 4
    //   608: istore 5
    //   610: aload_0
    //   611: getfield 25	qaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   614: ldc2_w 195
    //   617: invokevirtual 200	java/lang/Object:wait	(J)V
    //   620: iload 4
    //   622: iconst_1
    //   623: iadd
    //   624: istore 4
    //   626: aconst_null
    //   627: astore_1
    //   628: goto -515 -> 113
    //   631: iload 4
    //   633: istore 5
    //   635: aload_2
    //   636: monitorexit
    //   637: iload 4
    //   639: istore 5
    //   641: aload_1
    //   642: athrow
    //   643: astore_1
    //   644: iload 5
    //   646: istore 4
    //   648: invokestatic 192	com/tencent/widget/TraceUtils:a	()V
    //   651: goto -90 -> 561
    //   654: iconst_0
    //   655: istore 5
    //   657: goto -500 -> 157
    //   660: aload_0
    //   661: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   664: ldc -54
    //   666: invokevirtual 205	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/message/BaseMessageProcessor;
    //   669: sipush 1002
    //   672: iconst_3
    //   673: anewarray 28	java/lang/Object
    //   676: dup
    //   677: iconst_0
    //   678: aload_1
    //   679: getfield 208	qak:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   682: aastore
    //   683: dup
    //   684: iconst_1
    //   685: aload_1
    //   686: getfield 211	qak:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   689: aastore
    //   690: dup
    //   691: iconst_2
    //   692: aload_1
    //   693: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   696: aastore
    //   697: invokevirtual 216	com/tencent/mobileqq/app/message/BaseMessageProcessor:a	(I[Ljava/lang/Object;)V
    //   700: goto -444 -> 256
    //   703: aload_0
    //   704: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   707: aload_1
    //   708: getfield 208	qak:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   711: aload_1
    //   712: getfield 211	qak:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   715: aload_1
    //   716: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   719: invokestatic 219	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V
    //   722: goto -466 -> 256
    //   725: astore_1
    //   726: invokestatic 192	com/tencent/widget/TraceUtils:a	()V
    //   729: aload_1
    //   730: athrow
    //   731: aload_0
    //   732: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   735: aload_1
    //   736: getfield 208	qak:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   739: aload_1
    //   740: getfield 211	qak:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   743: aload_1
    //   744: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   747: invokestatic 221	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V
    //   750: goto -494 -> 256
    //   753: aload_1
    //   754: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   757: ifnull +88 -> 845
    //   760: aload_1
    //   761: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   764: instanceof 223
    //   767: ifeq +78 -> 845
    //   770: aload_1
    //   771: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   774: checkcast 223	MessageSvcPack/GroupInfo
    //   777: astore_2
    //   778: aload_0
    //   779: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   782: getfield 111	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   785: invokevirtual 226	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   788: astore_3
    //   789: aload_2
    //   790: getfield 229	MessageSvcPack/GroupInfo:lGroupCode	J
    //   793: lstore 9
    //   795: aload_2
    //   796: getfield 232	MessageSvcPack/GroupInfo:lMemberSeq	J
    //   799: lstore 11
    //   801: aload_0
    //   802: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   805: getfield 111	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   808: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   811: aload_2
    //   812: getfield 229	MessageSvcPack/GroupInfo:lGroupCode	J
    //   815: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   818: invokevirtual 243	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;)I
    //   821: iconst_2
    //   822: if_icmpne +397 -> 1219
    //   825: iconst_1
    //   826: istore 13
    //   828: aload_3
    //   829: lload 9
    //   831: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   834: iconst_1
    //   835: lload 11
    //   837: iload 13
    //   839: invokevirtual 248	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJZ)V
    //   842: goto -586 -> 256
    //   845: aload_1
    //   846: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   849: ifnull -593 -> 256
    //   852: aload_1
    //   853: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   856: instanceof 250
    //   859: ifeq -603 -> 256
    //   862: aload_1
    //   863: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   866: checkcast 250	msf/registerproxy/register_proxy$GroupList
    //   869: astore_2
    //   870: aload_0
    //   871: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   874: getfield 111	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   877: invokevirtual 226	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   880: astore_3
    //   881: aload_2
    //   882: getfield 254	msf/registerproxy/register_proxy$GroupList:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   885: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   888: lstore 9
    //   890: aload_2
    //   891: getfield 262	msf/registerproxy/register_proxy$GroupList:member_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   894: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   897: lstore 11
    //   899: aload_0
    //   900: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   903: getfield 111	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   906: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   909: aload_2
    //   910: getfield 254	msf/registerproxy/register_proxy$GroupList:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   913: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   916: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   919: invokevirtual 243	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;)I
    //   922: iconst_2
    //   923: if_icmpne +302 -> 1225
    //   926: iconst_1
    //   927: istore 13
    //   929: aload_3
    //   930: lload 9
    //   932: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   935: iconst_1
    //   936: lload 11
    //   938: iload 13
    //   940: invokevirtual 248	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJZ)V
    //   943: goto -687 -> 256
    //   946: aload_1
    //   947: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   950: ifnull +90 -> 1040
    //   953: aload_1
    //   954: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   957: instanceof 264
    //   960: ifeq +80 -> 1040
    //   963: aload_1
    //   964: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   967: checkcast 264	MessageSvcPack/stConfNumInfo
    //   970: astore_2
    //   971: aload_0
    //   972: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   975: getfield 111	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   978: invokevirtual 226	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   981: astore_3
    //   982: aload_2
    //   983: getfield 267	MessageSvcPack/stConfNumInfo:lConfUin	J
    //   986: lstore 9
    //   988: aload_2
    //   989: getfield 270	MessageSvcPack/stConfNumInfo:uMemberMsgSeq	J
    //   992: lstore 11
    //   994: aload_0
    //   995: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   998: getfield 111	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1001: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1004: aload_2
    //   1005: getfield 267	MessageSvcPack/stConfNumInfo:lConfUin	J
    //   1008: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1011: invokevirtual 272	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;)I
    //   1014: iconst_2
    //   1015: if_icmpne +216 -> 1231
    //   1018: iconst_1
    //   1019: istore 13
    //   1021: aload_3
    //   1022: lload 9
    //   1024: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1027: sipush 3000
    //   1030: lload 11
    //   1032: iload 13
    //   1034: invokevirtual 248	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJZ)V
    //   1037: goto -781 -> 256
    //   1040: aload_1
    //   1041: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1044: ifnull -788 -> 256
    //   1047: aload_1
    //   1048: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1051: instanceof 274
    //   1054: ifeq -798 -> 256
    //   1057: aload_1
    //   1058: getfield 92	qak:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1061: checkcast 274	msf/registerproxy/register_proxy$DiscussList
    //   1064: astore_2
    //   1065: aload_0
    //   1066: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1069: getfield 111	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1072: invokevirtual 226	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1075: astore_3
    //   1076: aload_2
    //   1077: getfield 277	msf/registerproxy/register_proxy$DiscussList:discuss_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1080: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1083: lstore 9
    //   1085: aload_2
    //   1086: getfield 278	msf/registerproxy/register_proxy$DiscussList:member_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1089: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1092: lstore 11
    //   1094: aload_0
    //   1095: getfield 13	qaj:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1098: getfield 111	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1101: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1104: aload_2
    //   1105: getfield 277	msf/registerproxy/register_proxy$DiscussList:discuss_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1108: invokevirtual 259	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1111: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1114: invokevirtual 272	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;)I
    //   1117: iconst_2
    //   1118: if_icmpne +25 -> 1143
    //   1121: iconst_1
    //   1122: istore 13
    //   1124: aload_3
    //   1125: lload 9
    //   1127: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1130: sipush 3000
    //   1133: lload 11
    //   1135: iload 13
    //   1137: invokevirtual 248	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJZ)V
    //   1140: goto -884 -> 256
    //   1143: iconst_0
    //   1144: istore 13
    //   1146: goto -22 -> 1124
    //   1149: iconst_0
    //   1150: istore 13
    //   1152: goto -687 -> 465
    //   1155: astore_2
    //   1156: aload_1
    //   1157: monitorexit
    //   1158: aload_2
    //   1159: athrow
    //   1160: aload_0
    //   1161: invokevirtual 279	qaj:a	()V
    //   1164: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1167: ifeq +32 -> 1199
    //   1170: ldc 44
    //   1172: iconst_2
    //   1173: new 46	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 281
    //   1183: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: aload_0
    //   1187: invokevirtual 57	qaj:getName	()Ljava/lang/String;
    //   1190: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1196: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1199: return
    //   1200: astore_1
    //   1201: goto -570 -> 631
    //   1204: goto -948 -> 256
    //   1207: astore_1
    //   1208: iload 5
    //   1210: istore 4
    //   1212: goto -581 -> 631
    //   1215: astore_1
    //   1216: goto -568 -> 648
    //   1219: iconst_0
    //   1220: istore 13
    //   1222: goto -394 -> 828
    //   1225: iconst_0
    //   1226: istore 13
    //   1228: goto -299 -> 929
    //   1231: iconst_0
    //   1232: istore 13
    //   1234: goto -213 -> 1021
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1237	0	this	qaj
    //   643	73	1	localException1	Exception
    //   725	432	1	localObject2	Object
    //   1200	1	1	localObject3	Object
    //   1207	1	1	localObject4	Object
    //   1215	1	1	localException2	Exception
    //   73	1032	2	localObject5	Object
    //   1155	4	2	localObject6	Object
    //   788	337	3	localQQMessageFacade	com.tencent.mobileqq.app.message.QQMessageFacade
    //   35	1176	4	i	int
    //   67	1142	5	j	int
    //   128	175	6	k	int
    //   125	191	7	l1	long
    //   139	987	9	l2	long
    //   799	335	11	l3	long
    //   463	770	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   69	74	643	java/lang/Exception
    //   78	80	643	java/lang/Exception
    //   641	643	643	java/lang/Exception
    //   69	74	725	finally
    //   78	80	725	finally
    //   115	120	725	finally
    //   130	157	725	finally
    //   165	209	725	finally
    //   217	256	725	finally
    //   256	327	725	finally
    //   327	372	725	finally
    //   533	555	725	finally
    //   555	558	725	finally
    //   641	643	725	finally
    //   660	700	725	finally
    //   703	722	725	finally
    //   731	750	725	finally
    //   753	825	725	finally
    //   828	842	725	finally
    //   845	926	725	finally
    //   929	943	725	finally
    //   946	1018	725	finally
    //   1021	1037	725	finally
    //   1040	1121	725	finally
    //   1124	1140	725	finally
    //   1158	1160	725	finally
    //   372	396	1155	finally
    //   396	462	1155	finally
    //   465	511	1155	finally
    //   511	531	1155	finally
    //   531	533	1155	finally
    //   1156	1158	1155	finally
    //   113	115	1200	finally
    //   84	94	1207	finally
    //   98	110	1207	finally
    //   568	574	1207	finally
    //   578	606	1207	finally
    //   610	620	1207	finally
    //   635	637	1207	finally
    //   115	120	1215	java/lang/Exception
    //   130	157	1215	java/lang/Exception
    //   165	209	1215	java/lang/Exception
    //   217	256	1215	java/lang/Exception
    //   256	327	1215	java/lang/Exception
    //   327	372	1215	java/lang/Exception
    //   533	555	1215	java/lang/Exception
    //   555	558	1215	java/lang/Exception
    //   660	700	1215	java/lang/Exception
    //   703	722	1215	java/lang/Exception
    //   731	750	1215	java/lang/Exception
    //   753	825	1215	java/lang/Exception
    //   828	842	1215	java/lang/Exception
    //   845	926	1215	java/lang/Exception
    //   929	943	1215	java/lang/Exception
    //   946	1018	1215	java/lang/Exception
    //   1021	1037	1215	java/lang/Exception
    //   1040	1121	1215	java/lang/Exception
    //   1124	1140	1215	java/lang/Exception
    //   1158	1160	1215	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */