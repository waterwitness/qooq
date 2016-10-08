import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rxm
  implements Runnable
{
  public rxm(OfflineSendWorker paramOfflineSendWorker, String paramString, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 49	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara
    //   7: dup
    //   8: invokespecial 50	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:<init>	()V
    //   11: astore 4
    //   13: aload 4
    //   15: aload_0
    //   16: getfield 20	rxm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: putfield 51	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: aload 4
    //   24: aload_0
    //   25: getfield 22	rxm:jdField_a_of_type_Long	J
    //   28: putfield 52	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:jdField_a_of_type_Long	J
    //   31: aload 4
    //   33: aload_0
    //   34: getfield 24	rxm:jdField_a_of_type_ArrayOfByte	[B
    //   37: putfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:c	[B
    //   40: aload 4
    //   42: aload_0
    //   43: getfield 26	rxm:b	[B
    //   46: putfield 56	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:e	[B
    //   49: aload 4
    //   51: aload_0
    //   52: getfield 28	rxm:c	[B
    //   55: putfield 57	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:b	[B
    //   58: aload 4
    //   60: aload_0
    //   61: getfield 30	rxm:d	[B
    //   64: putfield 58	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:jdField_a_of_type_ArrayOfByte	[B
    //   67: new 60	java/io/BufferedInputStream
    //   70: dup
    //   71: new 62	java/io/FileInputStream
    //   74: dup
    //   75: new 64	java/lang/String
    //   78: dup
    //   79: aload_0
    //   80: getfield 30	rxm:d	[B
    //   83: invokespecial 67	java/lang/String:<init>	([B)V
    //   86: invokespecial 70	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   89: invokespecial 73	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore_1
    //   93: sipush 10240
    //   96: newarray <illegal type>
    //   98: astore 5
    //   100: ldc 75
    //   102: invokestatic 81	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   105: astore_3
    //   106: aload_3
    //   107: astore_2
    //   108: aload_0
    //   109: getfield 18	rxm:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   112: invokestatic 86	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Z
    //   115: ifne +58 -> 173
    //   118: aload_1
    //   119: aload 5
    //   121: invokevirtual 92	java/io/InputStream:read	([B)I
    //   124: istore 6
    //   126: iload 6
    //   128: ifle +45 -> 173
    //   131: aload_2
    //   132: aload 5
    //   134: iconst_0
    //   135: iload 6
    //   137: invokevirtual 96	java/security/MessageDigest:update	([BII)V
    //   140: goto -32 -> 108
    //   143: astore_2
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 99	java/io/InputStream:close	()V
    //   152: return
    //   153: astore_3
    //   154: aload_3
    //   155: invokevirtual 102	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   158: goto -50 -> 108
    //   161: astore_2
    //   162: aload_1
    //   163: ifnull -11 -> 152
    //   166: aload_1
    //   167: invokevirtual 99	java/io/InputStream:close	()V
    //   170: return
    //   171: astore_1
    //   172: return
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 99	java/io/InputStream:close	()V
    //   181: aload_0
    //   182: getfield 18	rxm:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   185: invokestatic 86	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Z
    //   188: ifne +16 -> 204
    //   191: aload_2
    //   192: ifnull +12 -> 204
    //   195: aload 4
    //   197: aload_2
    //   198: invokevirtual 106	java/security/MessageDigest:digest	()[B
    //   201: putfield 107	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:d	[B
    //   204: aload_0
    //   205: getfield 18	rxm:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   208: invokestatic 86	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Z
    //   211: ifne +32 -> 243
    //   214: aload_0
    //   215: getfield 18	rxm:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   218: invokestatic 110	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   221: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   224: aload 4
    //   226: aload_0
    //   227: getfield 18	rxm:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   230: invokestatic 118	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   233: aload_0
    //   234: getfield 18	rxm:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   237: invokestatic 121	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   240: invokevirtual 126	com/tencent/mobileqq/filemanager/app/FileTransferHandler:b	(Lcom/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   243: aload_1
    //   244: ifnull -92 -> 152
    //   247: aload_1
    //   248: invokevirtual 99	java/io/InputStream:close	()V
    //   251: return
    //   252: astore_1
    //   253: return
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 99	java/io/InputStream:close	()V
    //   265: aload_2
    //   266: athrow
    //   267: astore_3
    //   268: goto -87 -> 181
    //   271: astore_1
    //   272: return
    //   273: astore_1
    //   274: goto -9 -> 265
    //   277: astore_2
    //   278: goto -21 -> 257
    //   281: astore_1
    //   282: aconst_null
    //   283: astore_1
    //   284: goto -122 -> 162
    //   287: astore_1
    //   288: aload_3
    //   289: astore_1
    //   290: goto -146 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	rxm
    //   92	75	1	localBufferedInputStream	java.io.BufferedInputStream
    //   171	77	1	localIOException1	java.io.IOException
    //   252	1	1	localIOException2	java.io.IOException
    //   256	6	1	localObject1	Object
    //   271	1	1	localIOException3	java.io.IOException
    //   273	1	1	localIOException4	java.io.IOException
    //   281	1	1	localIOException5	java.io.IOException
    //   283	1	1	localObject2	Object
    //   287	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   289	1	1	localIOException6	java.io.IOException
    //   3	129	2	localMessageDigest1	java.security.MessageDigest
    //   143	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   161	37	2	localIOException7	java.io.IOException
    //   254	12	2	localObject3	Object
    //   277	1	2	localObject4	Object
    //   1	106	3	localMessageDigest2	java.security.MessageDigest
    //   153	2	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   267	22	3	localIOException8	java.io.IOException
    //   11	214	4	localOfflineFileUploadPara	com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara
    //   98	35	5	arrayOfByte	byte[]
    //   124	12	6	i	int
    // Exception table:
    //   from	to	target	type
    //   93	100	143	java/io/FileNotFoundException
    //   100	106	143	java/io/FileNotFoundException
    //   108	126	143	java/io/FileNotFoundException
    //   131	140	143	java/io/FileNotFoundException
    //   154	158	143	java/io/FileNotFoundException
    //   177	181	143	java/io/FileNotFoundException
    //   181	191	143	java/io/FileNotFoundException
    //   195	204	143	java/io/FileNotFoundException
    //   204	243	143	java/io/FileNotFoundException
    //   100	106	153	java/security/NoSuchAlgorithmException
    //   93	100	161	java/io/IOException
    //   100	106	161	java/io/IOException
    //   108	126	161	java/io/IOException
    //   131	140	161	java/io/IOException
    //   154	158	161	java/io/IOException
    //   181	191	161	java/io/IOException
    //   195	204	161	java/io/IOException
    //   204	243	161	java/io/IOException
    //   166	170	171	java/io/IOException
    //   247	251	252	java/io/IOException
    //   67	93	254	finally
    //   177	181	267	java/io/IOException
    //   148	152	271	java/io/IOException
    //   261	265	273	java/io/IOException
    //   93	100	277	finally
    //   100	106	277	finally
    //   108	126	277	finally
    //   131	140	277	finally
    //   154	158	277	finally
    //   177	181	277	finally
    //   181	191	277	finally
    //   195	204	277	finally
    //   204	243	277	finally
    //   67	93	281	java/io/IOException
    //   67	93	287	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */