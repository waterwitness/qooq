import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;

public class vcg
  implements Runnable
{
  public vcg(ShortVideoUploadProcessor paramShortVideoUploadProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   4: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   7: getfield 38	com/tencent/mobileqq/transfile/TransferRequest:i	Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: ldc 40
    //   14: invokevirtual 46	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   17: astore_2
    //   18: iconst_4
    //   19: aload_2
    //   20: arraylength
    //   21: if_icmpeq +44 -> 65
    //   24: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +28 -> 55
    //   30: ldc 54
    //   32: iconst_2
    //   33: new 56	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   40: ldc 59
    //   42: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: new 73	java/lang/IllegalArgumentException
    //   58: dup
    //   59: ldc 75
    //   61: invokespecial 78	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   64: athrow
    //   65: aload_0
    //   66: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   69: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   72: aload_2
    //   73: iconst_0
    //   74: aaload
    //   75: putfield 38	com/tencent/mobileqq/transfile/TransferRequest:i	Ljava/lang/String;
    //   78: aload_0
    //   79: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   82: aload_2
    //   83: iconst_1
    //   84: aaload
    //   85: putfield 81	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   92: aload_2
    //   93: iconst_2
    //   94: aaload
    //   95: invokestatic 87	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   98: putfield 91	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:by	I
    //   101: aload_0
    //   102: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   105: aload_2
    //   106: iconst_3
    //   107: aaload
    //   108: invokestatic 97	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   111: putfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   114: aload_0
    //   115: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   118: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   121: aload_0
    //   122: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   125: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   128: getfield 104	com/tencent/mobileqq/transfile/TransferRequest:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   131: checkcast 106	com/tencent/mobileqq/data/MessageForShortVideo
    //   134: checkcast 106	com/tencent/mobileqq/data/MessageForShortVideo
    //   137: getfield 109	com/tencent/mobileqq/data/MessageForShortVideo:mLocalMd5	Ljava/lang/String;
    //   140: putfield 112	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   143: aload_0
    //   144: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   147: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   150: getfield 112	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   153: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne +57 -> 213
    //   159: aload_0
    //   160: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   163: aload_0
    //   164: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   167: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   170: getfield 112	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   173: invokestatic 97	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   176: putfield 120	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   179: aload_0
    //   180: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   183: astore_1
    //   184: aload_0
    //   185: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   188: getfield 123	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   191: astore_2
    //   192: aload_0
    //   193: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   196: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   199: getfield 112	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   202: astore_3
    //   203: aload_2
    //   204: aload_3
    //   205: putfield 128	com/tencent/mobileqq/transfile/FileMsg:h	Ljava/lang/String;
    //   208: aload_1
    //   209: aload_3
    //   210: putfield 131	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:e	Ljava/lang/String;
    //   213: aload_0
    //   214: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   217: getfield 120	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   220: ifnonnull +21 -> 241
    //   223: aload_0
    //   224: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   227: invokevirtual 133	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:f	()Z
    //   230: ifne +11 -> 241
    //   233: aload_0
    //   234: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   237: invokevirtual 135	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   240: return
    //   241: aload_0
    //   242: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   245: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   248: getfield 38	com/tencent/mobileqq/transfile/TransferRequest:i	Ljava/lang/String;
    //   251: invokestatic 140	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   254: ifne +23 -> 277
    //   257: aload_0
    //   258: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   261: sipush 9042
    //   264: ldc -114
    //   266: invokevirtual 145	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   269: aload_0
    //   270: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   273: invokevirtual 135	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   276: return
    //   277: aload_0
    //   278: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   281: getfield 148	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   284: ifnonnull +75 -> 359
    //   287: aload_0
    //   288: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   291: new 150	java/io/RandomAccessFile
    //   294: dup
    //   295: aload_0
    //   296: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   299: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   302: getfield 38	com/tencent/mobileqq/transfile/TransferRequest:i	Ljava/lang/String;
    //   305: ldc -104
    //   307: invokespecial 155	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: putfield 148	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   313: aload_0
    //   314: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   317: getfield 148	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   320: ifnonnull +39 -> 359
    //   323: aload_0
    //   324: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   327: sipush 9303
    //   330: ldc -99
    //   332: invokevirtual 145	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   335: aload_0
    //   336: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   339: invokevirtual 135	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   342: return
    //   343: astore_1
    //   344: aload_1
    //   345: invokevirtual 160	java/io/FileNotFoundException:printStackTrace	()V
    //   348: aload_0
    //   349: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   352: aconst_null
    //   353: putfield 148	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   356: goto -43 -> 313
    //   359: aload_0
    //   360: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   363: getfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   366: ifnonnull +113 -> 479
    //   369: new 162	java/io/FileInputStream
    //   372: dup
    //   373: aload_0
    //   374: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   377: getfield 81	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   380: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   383: astore_2
    //   384: aload_2
    //   385: astore_1
    //   386: aload_0
    //   387: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   390: aload_2
    //   391: lconst_0
    //   392: invokestatic 169	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   395: putfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   398: aload_2
    //   399: astore_1
    //   400: aload_0
    //   401: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   404: getfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   407: ifnonnull +64 -> 471
    //   410: aload_2
    //   411: astore_1
    //   412: aload_0
    //   413: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   416: sipush 9041
    //   419: new 56	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   426: ldc -85
    //   428: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_0
    //   432: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   435: getfield 81	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   438: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokevirtual 145	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   447: aload_2
    //   448: astore_1
    //   449: aload_0
    //   450: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   453: invokevirtual 135	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   456: aload_2
    //   457: ifnull -217 -> 240
    //   460: aload_2
    //   461: invokevirtual 174	java/io/FileInputStream:close	()V
    //   464: return
    //   465: astore_1
    //   466: aload_1
    //   467: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   470: return
    //   471: aload_2
    //   472: ifnull +7 -> 479
    //   475: aload_2
    //   476: invokevirtual 174	java/io/FileInputStream:close	()V
    //   479: aload_0
    //   480: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   483: getfield 177	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   486: ifnonnull +148 -> 634
    //   489: aload_0
    //   490: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   493: new 150	java/io/RandomAccessFile
    //   496: dup
    //   497: aload_0
    //   498: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   501: getfield 81	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   504: ldc -104
    //   506: invokespecial 155	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: putfield 177	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   512: aload_0
    //   513: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   516: getfield 177	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   519: ifnonnull +115 -> 634
    //   522: aload_0
    //   523: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   526: sipush 9303
    //   529: ldc -77
    //   531: invokevirtual 145	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   534: aload_0
    //   535: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   538: invokevirtual 135	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   541: return
    //   542: astore_1
    //   543: aload_1
    //   544: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   547: goto -68 -> 479
    //   550: astore_3
    //   551: aconst_null
    //   552: astore_2
    //   553: aload_2
    //   554: astore_1
    //   555: aload_0
    //   556: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   559: aconst_null
    //   560: putfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   563: aload_2
    //   564: astore_1
    //   565: aload_0
    //   566: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   569: aload_3
    //   570: invokevirtual 182	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/io/IOException;)V
    //   573: aload_2
    //   574: astore_1
    //   575: aload_0
    //   576: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   579: invokevirtual 135	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   582: aload_2
    //   583: ifnull -343 -> 240
    //   586: aload_2
    //   587: invokevirtual 174	java/io/FileInputStream:close	()V
    //   590: return
    //   591: astore_1
    //   592: aload_1
    //   593: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   596: return
    //   597: astore_2
    //   598: aconst_null
    //   599: astore_1
    //   600: aload_1
    //   601: ifnull +7 -> 608
    //   604: aload_1
    //   605: invokevirtual 174	java/io/FileInputStream:close	()V
    //   608: aload_2
    //   609: athrow
    //   610: astore_1
    //   611: aload_1
    //   612: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   615: goto -7 -> 608
    //   618: astore_1
    //   619: aload_1
    //   620: invokevirtual 160	java/io/FileNotFoundException:printStackTrace	()V
    //   623: aload_0
    //   624: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   627: aconst_null
    //   628: putfield 177	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   631: goto -119 -> 512
    //   634: new 184	java/io/File
    //   637: dup
    //   638: aload_0
    //   639: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   642: getfield 81	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   645: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   648: astore_1
    //   649: aload_0
    //   650: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   653: aload_1
    //   654: invokevirtual 189	java/io/File:length	()J
    //   657: putfield 192	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_Long	J
    //   660: aload_0
    //   661: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   664: aload_0
    //   665: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   668: getfield 81	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   671: invokevirtual 194	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(Ljava/lang/String;)V
    //   674: aload_0
    //   675: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   678: invokestatic 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   681: ifnull +35 -> 716
    //   684: aload_0
    //   685: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   688: invokestatic 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   691: arraylength
    //   692: ifeq +24 -> 716
    //   695: aload_0
    //   696: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   699: invokestatic 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   702: ifnull +14 -> 716
    //   705: aload_0
    //   706: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   709: invokestatic 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   712: arraylength
    //   713: ifne +169 -> 882
    //   716: ldc -55
    //   718: monitorenter
    //   719: aload_0
    //   720: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   723: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   726: getfield 203	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   729: invokestatic 207	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   732: invokevirtual 211	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   735: ifnull +64 -> 799
    //   738: aload_0
    //   739: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   742: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   745: getfield 203	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   748: invokestatic 207	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   751: invokevirtual 211	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   754: arraylength
    //   755: istore 4
    //   757: aload_0
    //   758: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   761: iload 4
    //   763: newarray <illegal type>
    //   765: invokestatic 214	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;[B)[B
    //   768: pop
    //   769: aload_0
    //   770: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   773: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   776: getfield 203	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   779: invokestatic 207	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   782: invokevirtual 211	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   785: iconst_0
    //   786: aload_0
    //   787: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   790: invokestatic 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   793: iconst_0
    //   794: iload 4
    //   796: invokestatic 220	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   799: aload_0
    //   800: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   803: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   806: getfield 203	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   809: invokestatic 207	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   812: invokevirtual 223	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   815: ifnull +64 -> 879
    //   818: aload_0
    //   819: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   822: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   825: getfield 203	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   828: invokestatic 207	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   831: invokevirtual 223	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   834: arraylength
    //   835: istore 4
    //   837: aload_0
    //   838: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   841: iload 4
    //   843: newarray <illegal type>
    //   845: invokestatic 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;[B)[B
    //   848: pop
    //   849: aload_0
    //   850: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   853: getfield 32	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   856: getfield 203	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   859: invokestatic 207	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   862: invokevirtual 223	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   865: iconst_0
    //   866: aload_0
    //   867: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   870: invokestatic 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   873: iconst_0
    //   874: iload 4
    //   876: invokestatic 220	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   879: ldc -55
    //   881: monitorexit
    //   882: aload_0
    //   883: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   886: invokestatic 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   889: ifnull +35 -> 924
    //   892: aload_0
    //   893: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   896: invokestatic 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   899: arraylength
    //   900: ifeq +24 -> 924
    //   903: aload_0
    //   904: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   907: invokestatic 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   910: ifnull +14 -> 924
    //   913: aload_0
    //   914: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   917: invokestatic 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   920: arraylength
    //   921: ifne +26 -> 947
    //   924: aload_0
    //   925: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   928: iconst_1
    //   929: invokestatic 228	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;I)I
    //   932: pop
    //   933: aload_0
    //   934: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   937: invokevirtual 231	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:s	()V
    //   940: return
    //   941: astore_1
    //   942: ldc -55
    //   944: monitorexit
    //   945: aload_1
    //   946: athrow
    //   947: aload_0
    //   948: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   951: aload_0
    //   952: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   955: invokestatic 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   958: aload_0
    //   959: getfield 12	vcg:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   962: invokestatic 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   965: invokevirtual 234	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	([B[B)V
    //   968: return
    //   969: astore_2
    //   970: goto -370 -> 600
    //   973: astore_3
    //   974: goto -421 -> 553
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	977	0	this	vcg
    //   10	199	1	localObject1	Object
    //   343	2	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   385	64	1	localObject2	Object
    //   465	2	1	localIOException1	java.io.IOException
    //   542	2	1	localIOException2	java.io.IOException
    //   554	21	1	localObject3	Object
    //   591	2	1	localIOException3	java.io.IOException
    //   599	6	1	localObject4	Object
    //   610	2	1	localIOException4	java.io.IOException
    //   618	2	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   648	6	1	localFile	java.io.File
    //   941	5	1	localObject5	Object
    //   17	570	2	localObject6	Object
    //   597	12	2	localObject7	Object
    //   969	1	2	localObject8	Object
    //   202	8	3	str	String
    //   550	20	3	localIOException5	java.io.IOException
    //   973	1	3	localIOException6	java.io.IOException
    //   755	120	4	i	int
    // Exception table:
    //   from	to	target	type
    //   287	313	343	java/io/FileNotFoundException
    //   460	464	465	java/io/IOException
    //   475	479	542	java/io/IOException
    //   369	384	550	java/io/IOException
    //   586	590	591	java/io/IOException
    //   369	384	597	finally
    //   604	608	610	java/io/IOException
    //   489	512	618	java/io/FileNotFoundException
    //   719	799	941	finally
    //   799	879	941	finally
    //   879	882	941	finally
    //   942	945	941	finally
    //   386	398	969	finally
    //   400	410	969	finally
    //   412	447	969	finally
    //   449	456	969	finally
    //   555	563	969	finally
    //   565	573	969	finally
    //   575	582	969	finally
    //   386	398	973	java/io/IOException
    //   400	410	973	java/io/IOException
    //   412	447	973	java/io/IOException
    //   449	456	973	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */