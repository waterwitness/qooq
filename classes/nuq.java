import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nuq
  implements Runnable
{
  public nuq(AIOImageProviderService paramAIOImageProviderService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   4: iconst_1
    //   5: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   8: aload_0
    //   9: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   12: getfield 35	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Int	I
    //   15: bipush 60
    //   17: if_icmpge +27 -> 44
    //   20: aload_0
    //   21: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   24: iconst_0
    //   25: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   28: aload_0
    //   29: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   32: invokevirtual 38	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:b	()V
    //   35: aload_0
    //   36: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   39: iconst_0
    //   40: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   43: return
    //   44: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +11 -> 58
    //   50: ldc 46
    //   52: iconst_2
    //   53: ldc 48
    //   55: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_0
    //   59: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   62: getfield 55	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProviderCallBack;
    //   65: ifnonnull +37 -> 102
    //   68: aload_0
    //   69: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   72: getfield 58	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService$AIOImageProviderListener;
    //   75: ifnonnull +27 -> 102
    //   78: aload_0
    //   79: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   82: iconst_0
    //   83: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   86: aload_0
    //   87: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   90: invokevirtual 38	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:b	()V
    //   93: aload_0
    //   94: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   97: iconst_0
    //   98: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   101: return
    //   102: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   105: lstore 8
    //   107: getstatic 69	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   110: aload_0
    //   111: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   114: getfield 72	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   117: invokevirtual 76	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   120: checkcast 78	com/tencent/mobileqq/app/QQAppInterface
    //   123: astore 5
    //   125: new 80	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 81	java/util/ArrayList:<init>	()V
    //   132: astore_3
    //   133: new 80	java/util/ArrayList
    //   136: dup
    //   137: invokespecial 81	java/util/ArrayList:<init>	()V
    //   140: astore 4
    //   142: aload_0
    //   143: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   146: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Boolean	Z
    //   149: ifne +534 -> 683
    //   152: aload_0
    //   153: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   156: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   159: ifnonnull +27 -> 186
    //   162: aload_0
    //   163: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   166: iconst_0
    //   167: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   170: aload_0
    //   171: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   174: invokevirtual 38	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:b	()V
    //   177: aload_0
    //   178: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   181: iconst_0
    //   182: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   185: return
    //   186: bipush 7
    //   188: newarray <illegal type>
    //   190: astore 6
    //   192: aload 6
    //   194: dup
    //   195: iconst_0
    //   196: sipush 45536
    //   199: iastore
    //   200: dup
    //   201: iconst_1
    //   202: sipush 63536
    //   205: iastore
    //   206: dup
    //   207: iconst_2
    //   208: sipush 64501
    //   211: iastore
    //   212: dup
    //   213: iconst_3
    //   214: sipush 63525
    //   217: iastore
    //   218: dup
    //   219: iconst_4
    //   220: sipush 63514
    //   223: iastore
    //   224: dup
    //   225: iconst_5
    //   226: sipush 63531
    //   229: iastore
    //   230: dup
    //   231: bipush 6
    //   233: sipush 63519
    //   236: iastore
    //   237: pop
    //   238: aload_0
    //   239: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   242: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_Boolean	Z
    //   245: ifne +271 -> 516
    //   248: aload 5
    //   250: aload_0
    //   251: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   254: getfield 89	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Int	I
    //   257: invokevirtual 92	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/message/MsgProxy;
    //   260: aload_0
    //   261: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   264: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   267: aload_0
    //   268: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   271: getfield 89	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Int	I
    //   274: aload 6
    //   276: invokevirtual 97	com/tencent/mobileqq/app/message/MsgProxy:a	(Ljava/lang/String;I[I)Ljava/util/List;
    //   279: astore_2
    //   280: aload_2
    //   281: astore_1
    //   282: aload_2
    //   283: invokeinterface 103 1 0
    //   288: bipush 60
    //   290: if_icmpge +43 -> 333
    //   293: aload 5
    //   295: invokevirtual 106	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   298: aload_0
    //   299: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   302: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   305: aload_0
    //   306: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   309: getfield 89	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Int	I
    //   312: aload 6
    //   314: bipush 60
    //   316: invokevirtual 111	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I[II)Ljava/util/List;
    //   319: astore_1
    //   320: aload_0
    //   321: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   324: aload_1
    //   325: invokeinterface 103 1 0
    //   330: putfield 35	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Int	I
    //   333: aload_0
    //   334: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   337: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_Boolean	Z
    //   340: ifne +404 -> 744
    //   343: aload_3
    //   344: aload_1
    //   345: invokeinterface 115 2 0
    //   350: pop
    //   351: aload 4
    //   353: aload_0
    //   354: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   357: aload 5
    //   359: aload_1
    //   360: invokestatic 118	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:a	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)Ljava/util/List;
    //   363: invokeinterface 115 2 0
    //   368: pop
    //   369: aload_0
    //   370: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   373: iconst_1
    //   374: putfield 87	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_Boolean	Z
    //   377: aload_0
    //   378: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   381: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Boolean	Z
    //   384: ifne +27 -> 411
    //   387: aload 4
    //   389: invokeinterface 103 1 0
    //   394: bipush 30
    //   396: if_icmpge +15 -> 411
    //   399: aload_0
    //   400: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   403: getfield 35	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Int	I
    //   406: bipush 60
    //   408: if_icmpge -266 -> 142
    //   411: aload 4
    //   413: invokeinterface 103 1 0
    //   418: ifle +582 -> 1000
    //   421: aload_0
    //   422: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   425: getfield 55	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProviderCallBack;
    //   428: astore_1
    //   429: aload_1
    //   430: ifnull +435 -> 865
    //   433: new 80	java/util/ArrayList
    //   436: dup
    //   437: invokespecial 81	java/util/ArrayList:<init>	()V
    //   440: astore 5
    //   442: aload_0
    //   443: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   446: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   449: astore_2
    //   450: aload_2
    //   451: monitorenter
    //   452: iconst_0
    //   453: istore 7
    //   455: iload 7
    //   457: aload_0
    //   458: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   461: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   464: invokeinterface 103 1 0
    //   469: if_icmpge +360 -> 829
    //   472: aload_0
    //   473: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   476: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   479: iload 7
    //   481: invokeinterface 125 2 0
    //   486: checkcast 127	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   489: astore 6
    //   491: aload_0
    //   492: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   495: aload 6
    //   497: invokevirtual 130	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:a	(Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;)Z
    //   500: istore 10
    //   502: iload 10
    //   504: ifeq +296 -> 800
    //   507: iload 7
    //   509: iconst_1
    //   510: iadd
    //   511: istore 7
    //   513: goto -58 -> 455
    //   516: aload_0
    //   517: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   520: getfield 89	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Int	I
    //   523: invokestatic 133	com/tencent/mobileqq/app/message/MsgProxy:a	(I)Z
    //   526: ifeq +106 -> 632
    //   529: aload 5
    //   531: invokevirtual 106	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   534: aload_0
    //   535: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   538: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   541: aload_0
    //   542: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   545: getfield 89	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Int	I
    //   548: aload_0
    //   549: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   552: getfield 136	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_Long	J
    //   555: aload_0
    //   556: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   559: getfield 138	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_Int	I
    //   562: aload_0
    //   563: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   566: getfield 140	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Long	J
    //   569: aload 6
    //   571: bipush 60
    //   573: invokevirtual 143	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJIJ[II)Ljava/util/List;
    //   576: astore_1
    //   577: aload_0
    //   578: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   581: aload_1
    //   582: invokeinterface 103 1 0
    //   587: putfield 35	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Int	I
    //   590: aload_0
    //   591: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   594: astore_2
    //   595: aload_2
    //   596: aload_2
    //   597: getfield 145	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_d_of_type_Int	I
    //   600: iconst_1
    //   601: iadd
    //   602: putfield 145	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_d_of_type_Int	I
    //   605: goto -272 -> 333
    //   608: astore_1
    //   609: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   612: ifeq +11 -> 623
    //   615: ldc 46
    //   617: iconst_2
    //   618: ldc -109
    //   620: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: aload_0
    //   624: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   627: iconst_0
    //   628: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   631: return
    //   632: aload 5
    //   634: invokevirtual 106	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   637: aload_0
    //   638: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   641: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   644: aload_0
    //   645: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   648: getfield 89	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Int	I
    //   651: aload_0
    //   652: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   655: getfield 136	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_Long	J
    //   658: aload_0
    //   659: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   662: getfield 138	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_Int	I
    //   665: aload_0
    //   666: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   669: getfield 149	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_d_of_type_Long	J
    //   672: aload 6
    //   674: bipush 60
    //   676: invokevirtual 143	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJIJ[II)Ljava/util/List;
    //   679: astore_1
    //   680: goto -103 -> 577
    //   683: aload 5
    //   685: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/MultiMsgProxy;
    //   688: ifnull +13 -> 701
    //   691: aload_0
    //   692: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   695: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_Boolean	Z
    //   698: ifeq +27 -> 725
    //   701: aload_0
    //   702: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   705: iconst_0
    //   706: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   709: aload_0
    //   710: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   713: invokevirtual 38	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:b	()V
    //   716: aload_0
    //   717: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   720: iconst_0
    //   721: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   724: return
    //   725: aload 5
    //   727: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/MultiMsgProxy;
    //   730: aload_0
    //   731: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   734: getfield 154	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Long	J
    //   737: invokevirtual 159	com/tencent/mobileqq/app/message/MultiMsgProxy:a	(J)Ljava/util/ArrayList;
    //   740: astore_1
    //   741: goto -408 -> 333
    //   744: aload_3
    //   745: iconst_0
    //   746: aload_1
    //   747: invokeinterface 162 3 0
    //   752: pop
    //   753: aload 4
    //   755: iconst_0
    //   756: aload_0
    //   757: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   760: aload 5
    //   762: aload_1
    //   763: invokestatic 118	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:a	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)Ljava/util/List;
    //   766: invokeinterface 162 3 0
    //   771: pop
    //   772: goto -395 -> 377
    //   775: astore_1
    //   776: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +12 -> 791
    //   782: ldc 46
    //   784: iconst_2
    //   785: ldc -92
    //   787: aload_1
    //   788: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   791: aload_0
    //   792: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   795: iconst_0
    //   796: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   799: return
    //   800: aload 5
    //   802: aload 6
    //   804: invokeinterface 171 2 0
    //   809: pop
    //   810: goto -303 -> 507
    //   813: astore_1
    //   814: aload_2
    //   815: monitorexit
    //   816: aload_1
    //   817: athrow
    //   818: astore_1
    //   819: aload_0
    //   820: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   823: iconst_0
    //   824: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   827: aload_1
    //   828: athrow
    //   829: aload_2
    //   830: monitorexit
    //   831: aload 5
    //   833: aload 5
    //   835: invokeinterface 103 1 0
    //   840: anewarray 127	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   843: invokeinterface 175 2 0
    //   848: checkcast 177	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   851: astore_2
    //   852: aload_2
    //   853: arraylength
    //   854: ifle +11 -> 865
    //   857: aload_1
    //   858: aload_2
    //   859: iconst_m1
    //   860: invokeinterface 182 3 0
    //   865: aload_0
    //   866: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   869: getfield 58	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService$AIOImageProviderListener;
    //   872: astore_1
    //   873: aload_1
    //   874: ifnull +37 -> 911
    //   877: aload 4
    //   879: aload 4
    //   881: invokeinterface 103 1 0
    //   886: anewarray 127	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   889: invokeinterface 175 2 0
    //   894: checkcast 177	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   897: astore_2
    //   898: aload_2
    //   899: arraylength
    //   900: ifle +11 -> 911
    //   903: aload_1
    //   904: aload_2
    //   905: iconst_m1
    //   906: invokeinterface 185 3 0
    //   911: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   914: ifeq +77 -> 991
    //   917: ldc 46
    //   919: iconst_2
    //   920: new 187	java/lang/StringBuilder
    //   923: dup
    //   924: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   927: ldc -66
    //   929: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: aload_0
    //   933: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   936: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_Boolean	Z
    //   939: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   942: ldc -57
    //   944: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload_3
    //   948: invokeinterface 103 1 0
    //   953: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   956: ldc -52
    //   958: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: aload 4
    //   963: invokeinterface 103 1 0
    //   968: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   971: ldc -50
    //   973: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   979: lload 8
    //   981: lsub
    //   982: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   985: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: aload_0
    //   992: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   995: iconst_0
    //   996: putfield 32	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_c_of_type_Boolean	Z
    //   999: return
    //   1000: aload_0
    //   1001: getfield 12	nuq:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   1004: invokevirtual 38	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:b	()V
    //   1007: goto -96 -> 911
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1010	0	this	nuq
    //   281	301	1	localObject1	Object
    //   608	1	1	localAccountNotMatchException	mqq.app.AccountNotMatchException
    //   679	84	1	localObject2	Object
    //   775	13	1	localOutOfMemoryError	OutOfMemoryError
    //   813	4	1	localObject3	Object
    //   818	40	1	localObject4	Object
    //   872	32	1	localAIOImageProviderListener	com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.AIOImageProviderListener
    //   279	626	2	localObject5	Object
    //   132	816	3	localArrayList1	java.util.ArrayList
    //   140	822	4	localArrayList2	java.util.ArrayList
    //   123	711	5	localObject6	Object
    //   190	613	6	localObject7	Object
    //   453	59	7	i	int
    //   105	875	8	l	long
    //   500	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	35	608	mqq/app/AccountNotMatchException
    //   44	58	608	mqq/app/AccountNotMatchException
    //   58	93	608	mqq/app/AccountNotMatchException
    //   102	142	608	mqq/app/AccountNotMatchException
    //   142	177	608	mqq/app/AccountNotMatchException
    //   186	280	608	mqq/app/AccountNotMatchException
    //   282	333	608	mqq/app/AccountNotMatchException
    //   333	377	608	mqq/app/AccountNotMatchException
    //   377	411	608	mqq/app/AccountNotMatchException
    //   411	429	608	mqq/app/AccountNotMatchException
    //   433	452	608	mqq/app/AccountNotMatchException
    //   516	577	608	mqq/app/AccountNotMatchException
    //   577	605	608	mqq/app/AccountNotMatchException
    //   632	680	608	mqq/app/AccountNotMatchException
    //   683	701	608	mqq/app/AccountNotMatchException
    //   701	716	608	mqq/app/AccountNotMatchException
    //   725	741	608	mqq/app/AccountNotMatchException
    //   744	772	608	mqq/app/AccountNotMatchException
    //   816	818	608	mqq/app/AccountNotMatchException
    //   831	865	608	mqq/app/AccountNotMatchException
    //   865	873	608	mqq/app/AccountNotMatchException
    //   877	911	608	mqq/app/AccountNotMatchException
    //   911	991	608	mqq/app/AccountNotMatchException
    //   1000	1007	608	mqq/app/AccountNotMatchException
    //   0	35	775	java/lang/OutOfMemoryError
    //   44	58	775	java/lang/OutOfMemoryError
    //   58	93	775	java/lang/OutOfMemoryError
    //   102	142	775	java/lang/OutOfMemoryError
    //   142	177	775	java/lang/OutOfMemoryError
    //   186	280	775	java/lang/OutOfMemoryError
    //   282	333	775	java/lang/OutOfMemoryError
    //   333	377	775	java/lang/OutOfMemoryError
    //   377	411	775	java/lang/OutOfMemoryError
    //   411	429	775	java/lang/OutOfMemoryError
    //   433	452	775	java/lang/OutOfMemoryError
    //   516	577	775	java/lang/OutOfMemoryError
    //   577	605	775	java/lang/OutOfMemoryError
    //   632	680	775	java/lang/OutOfMemoryError
    //   683	701	775	java/lang/OutOfMemoryError
    //   701	716	775	java/lang/OutOfMemoryError
    //   725	741	775	java/lang/OutOfMemoryError
    //   744	772	775	java/lang/OutOfMemoryError
    //   816	818	775	java/lang/OutOfMemoryError
    //   831	865	775	java/lang/OutOfMemoryError
    //   865	873	775	java/lang/OutOfMemoryError
    //   877	911	775	java/lang/OutOfMemoryError
    //   911	991	775	java/lang/OutOfMemoryError
    //   1000	1007	775	java/lang/OutOfMemoryError
    //   455	502	813	finally
    //   800	810	813	finally
    //   814	816	813	finally
    //   829	831	813	finally
    //   0	35	818	finally
    //   44	58	818	finally
    //   58	93	818	finally
    //   102	142	818	finally
    //   142	177	818	finally
    //   186	280	818	finally
    //   282	333	818	finally
    //   333	377	818	finally
    //   377	411	818	finally
    //   411	429	818	finally
    //   433	452	818	finally
    //   516	577	818	finally
    //   577	605	818	finally
    //   609	623	818	finally
    //   632	680	818	finally
    //   683	701	818	finally
    //   701	716	818	finally
    //   725	741	818	finally
    //   744	772	818	finally
    //   776	791	818	finally
    //   816	818	818	finally
    //   831	865	818	finally
    //   865	873	818	finally
    //   877	911	818	finally
    //   911	991	818	finally
    //   1000	1007	818	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nuq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */