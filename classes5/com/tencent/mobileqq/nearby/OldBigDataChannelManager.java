package com.tencent.mobileqq.nearby;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import tin;

public class OldBigDataChannelManager
  implements Manager
{
  public static final String a;
  private static final String jdField_b_of_type_JavaLangString = "_circle_svc";
  private int jdField_a_of_type_Int;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new tin(this);
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = OldBigDataChannelManager.class.getSimpleName();
  }
  
  public OldBigDataChannelManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    c();
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: new 62	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 63	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 65	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 68	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 70	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   23: ifnull +13 -> 36
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 70	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   32: arraylength
    //   33: ifne +127 -> 160
    //   36: aload_2
    //   37: astore_1
    //   38: aload_2
    //   39: iconst_0
    //   40: invokevirtual 74	java/io/ObjectOutputStream:writeInt	(I)V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 76	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   49: ifnull +13 -> 62
    //   52: aload_2
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 76	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   58: arraylength
    //   59: ifne +176 -> 235
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: iconst_0
    //   66: invokevirtual 74	java/io/ObjectOutputStream:writeInt	(I)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 78	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   76: invokevirtual 74	java/io/ObjectOutputStream:writeInt	(I)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_0
    //   83: getfield 80	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   86: invokevirtual 84	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: invokevirtual 87	java/io/ObjectOutputStream:flush	()V
    //   95: aload_2
    //   96: astore_1
    //   97: new 89	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: getfield 46	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   105: invokevirtual 92	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   108: invokevirtual 98	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   111: new 100	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   118: aload_0
    //   119: getfield 46	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   122: invokevirtual 103	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   125: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 11
    //   130: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   139: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   142: aload_3
    //   143: invokevirtual 120	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   146: iconst_0
    //   147: invokestatic 125	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   150: pop
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 128	java/io/ObjectOutputStream:close	()V
    //   159: return
    //   160: aload_2
    //   161: astore_1
    //   162: aload_2
    //   163: aload_0
    //   164: getfield 70	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   167: arraylength
    //   168: invokevirtual 74	java/io/ObjectOutputStream:writeInt	(I)V
    //   171: aload_2
    //   172: astore_1
    //   173: aload_2
    //   174: aload_0
    //   175: getfield 70	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   178: invokevirtual 132	java/io/ObjectOutputStream:write	([B)V
    //   181: goto -138 -> 43
    //   184: astore_3
    //   185: aload_2
    //   186: astore_1
    //   187: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +34 -> 224
    //   193: aload_2
    //   194: astore_1
    //   195: getstatic 32	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   198: iconst_2
    //   199: new 100	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   206: ldc -116
    //   208: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_3
    //   212: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_2
    //   225: ifnull -66 -> 159
    //   228: aload_2
    //   229: invokevirtual 128	java/io/ObjectOutputStream:close	()V
    //   232: return
    //   233: astore_1
    //   234: return
    //   235: aload_2
    //   236: astore_1
    //   237: aload_2
    //   238: aload_0
    //   239: getfield 76	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   242: arraylength
    //   243: invokevirtual 74	java/io/ObjectOutputStream:writeInt	(I)V
    //   246: aload_2
    //   247: astore_1
    //   248: aload_2
    //   249: aload_0
    //   250: getfield 76	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   253: invokevirtual 132	java/io/ObjectOutputStream:write	([B)V
    //   256: goto -187 -> 69
    //   259: astore_3
    //   260: aload_1
    //   261: astore_2
    //   262: aload_3
    //   263: astore_1
    //   264: aload_2
    //   265: ifnull +7 -> 272
    //   268: aload_2
    //   269: invokevirtual 128	java/io/ObjectOutputStream:close	()V
    //   272: aload_1
    //   273: athrow
    //   274: astore_1
    //   275: return
    //   276: astore_2
    //   277: goto -5 -> 272
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_2
    //   283: goto -19 -> 264
    //   286: astore_3
    //   287: aconst_null
    //   288: astore_2
    //   289: goto -104 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	OldBigDataChannelManager
    //   18	177	1	localObject1	Object
    //   233	1	1	localException1	Exception
    //   236	37	1	localObject2	Object
    //   274	1	1	localException2	Exception
    //   280	1	1	localObject3	Object
    //   16	253	2	localObject4	Object
    //   276	1	2	localException3	Exception
    //   282	7	2	localObject5	Object
    //   7	136	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   184	28	3	localException4	Exception
    //   259	4	3	localObject6	Object
    //   286	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   19	26	184	java/lang/Exception
    //   28	36	184	java/lang/Exception
    //   38	43	184	java/lang/Exception
    //   45	52	184	java/lang/Exception
    //   54	62	184	java/lang/Exception
    //   64	69	184	java/lang/Exception
    //   71	79	184	java/lang/Exception
    //   81	89	184	java/lang/Exception
    //   91	95	184	java/lang/Exception
    //   97	151	184	java/lang/Exception
    //   162	171	184	java/lang/Exception
    //   173	181	184	java/lang/Exception
    //   237	246	184	java/lang/Exception
    //   248	256	184	java/lang/Exception
    //   228	232	233	java/lang/Exception
    //   19	26	259	finally
    //   28	36	259	finally
    //   38	43	259	finally
    //   45	52	259	finally
    //   54	62	259	finally
    //   64	69	259	finally
    //   71	79	259	finally
    //   81	89	259	finally
    //   91	95	259	finally
    //   97	151	259	finally
    //   162	171	259	finally
    //   173	181	259	finally
    //   187	193	259	finally
    //   195	224	259	finally
    //   237	246	259	finally
    //   248	256	259	finally
    //   155	159	274	java/lang/Exception
    //   268	272	276	java/lang/Exception
    //   0	17	280	finally
    //   0	17	286	java/lang/Exception
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: new 89	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 46	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   13: invokevirtual 92	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   16: invokevirtual 98	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   19: new 100	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   26: aload_0
    //   27: getfield 46	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 103	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   33: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 11
    //   38: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +358 -> 407
    //   52: aload_2
    //   53: invokevirtual 151	java/io/File:exists	()Z
    //   56: ifeq +351 -> 407
    //   59: aload_2
    //   60: invokestatic 154	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   63: astore_1
    //   64: new 156	java/io/ByteArrayInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 158	java/io/ByteArrayInputStream:<init>	([B)V
    //   72: astore_3
    //   73: new 160	java/io/ObjectInputStream
    //   76: dup
    //   77: aload_3
    //   78: invokespecial 163	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore_2
    //   82: aload_2
    //   83: invokevirtual 167	java/io/ObjectInputStream:readInt	()I
    //   86: istore 5
    //   88: iload 5
    //   90: aload_1
    //   91: arraylength
    //   92: if_icmple +110 -> 202
    //   95: new 169	java/lang/RuntimeException
    //   98: dup
    //   99: new 100	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   106: ldc -85
    //   108: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 5
    //   113: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 177	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: astore_1
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 70	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   129: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +13 -> 145
    //   135: getstatic 32	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   138: iconst_2
    //   139: ldc -77
    //   141: aload_1
    //   142: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 183	java/io/ObjectInputStream:close	()V
    //   153: aload_3
    //   154: ifnull +7 -> 161
    //   157: aload_3
    //   158: invokevirtual 184	java/io/ByteArrayInputStream:close	()V
    //   161: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +32 -> 196
    //   167: getstatic 32	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   170: iconst_2
    //   171: new 100	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   178: ldc -70
    //   180: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: getfield 78	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   187: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: iconst_0
    //   198: putfield 78	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   201: return
    //   202: iload 5
    //   204: ifle +20 -> 224
    //   207: aload_0
    //   208: iload 5
    //   210: newarray <illegal type>
    //   212: putfield 70	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   215: aload_2
    //   216: aload_0
    //   217: getfield 70	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfByte	[B
    //   220: invokevirtual 190	java/io/ObjectInputStream:read	([B)I
    //   223: pop
    //   224: aload_2
    //   225: invokevirtual 167	java/io/ObjectInputStream:readInt	()I
    //   228: istore 5
    //   230: iload 5
    //   232: aload_1
    //   233: arraylength
    //   234: if_icmple +50 -> 284
    //   237: new 169	java/lang/RuntimeException
    //   240: dup
    //   241: new 100	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   248: ldc -64
    //   250: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 5
    //   255: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokespecial 177	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   264: athrow
    //   265: astore_1
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 183	java/io/ObjectInputStream:close	()V
    //   274: aload_3
    //   275: ifnull +7 -> 282
    //   278: aload_3
    //   279: invokevirtual 184	java/io/ByteArrayInputStream:close	()V
    //   282: aload_1
    //   283: athrow
    //   284: iload 5
    //   286: ifle +20 -> 306
    //   289: aload_0
    //   290: iload 5
    //   292: newarray <illegal type>
    //   294: putfield 76	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   297: aload_2
    //   298: aload_0
    //   299: getfield 76	com/tencent/mobileqq/nearby/OldBigDataChannelManager:b	[B
    //   302: invokevirtual 190	java/io/ObjectInputStream:read	([B)I
    //   305: pop
    //   306: aload_0
    //   307: aload_2
    //   308: invokevirtual 167	java/io/ObjectInputStream:readInt	()I
    //   311: putfield 78	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_Int	I
    //   314: aload_0
    //   315: aload_2
    //   316: invokevirtual 196	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   319: checkcast 197	[Ljava/lang/String;
    //   322: checkcast 197	[Ljava/lang/String;
    //   325: putfield 80	com/tencent/mobileqq/nearby/OldBigDataChannelManager:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   328: aload_3
    //   329: astore_1
    //   330: aload_2
    //   331: ifnull +7 -> 338
    //   334: aload_2
    //   335: invokevirtual 183	java/io/ObjectInputStream:close	()V
    //   338: aload_1
    //   339: ifnull -178 -> 161
    //   342: aload_1
    //   343: invokevirtual 184	java/io/ByteArrayInputStream:close	()V
    //   346: goto -185 -> 161
    //   349: astore_1
    //   350: goto -189 -> 161
    //   353: astore_2
    //   354: goto -16 -> 338
    //   357: astore_1
    //   358: goto -205 -> 153
    //   361: astore_1
    //   362: goto -201 -> 161
    //   365: astore_2
    //   366: goto -92 -> 274
    //   369: astore_2
    //   370: goto -88 -> 282
    //   373: astore_1
    //   374: aconst_null
    //   375: astore_3
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -112 -> 266
    //   381: astore_1
    //   382: aconst_null
    //   383: astore_2
    //   384: goto -118 -> 266
    //   387: astore_1
    //   388: goto -122 -> 266
    //   391: astore_1
    //   392: aconst_null
    //   393: astore_3
    //   394: aload 4
    //   396: astore_2
    //   397: goto -273 -> 124
    //   400: astore_1
    //   401: aload 4
    //   403: astore_2
    //   404: goto -280 -> 124
    //   407: aconst_null
    //   408: astore_2
    //   409: goto -79 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	OldBigDataChannelManager
    //   1	90	1	arrayOfByte	byte[]
    //   123	110	1	localException1	Exception
    //   265	18	1	localObject1	Object
    //   329	14	1	localObject2	Object
    //   349	1	1	localIOException1	java.io.IOException
    //   357	1	1	localIOException2	java.io.IOException
    //   361	1	1	localIOException3	java.io.IOException
    //   373	1	1	localObject3	Object
    //   381	1	1	localObject4	Object
    //   387	1	1	localObject5	Object
    //   391	1	1	localException2	Exception
    //   400	1	1	localException3	Exception
    //   47	288	2	localObject6	Object
    //   353	1	2	localIOException4	java.io.IOException
    //   365	1	2	localIOException5	java.io.IOException
    //   369	1	2	localIOException6	java.io.IOException
    //   377	32	2	localObject7	Object
    //   72	322	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   3	399	4	localObject8	Object
    //   86	205	5	i	int
    // Exception table:
    //   from	to	target	type
    //   82	123	123	java/lang/Exception
    //   207	224	123	java/lang/Exception
    //   224	265	123	java/lang/Exception
    //   289	306	123	java/lang/Exception
    //   306	328	123	java/lang/Exception
    //   82	123	265	finally
    //   207	224	265	finally
    //   224	265	265	finally
    //   289	306	265	finally
    //   306	328	265	finally
    //   342	346	349	java/io/IOException
    //   334	338	353	java/io/IOException
    //   149	153	357	java/io/IOException
    //   157	161	361	java/io/IOException
    //   270	274	365	java/io/IOException
    //   278	282	369	java/io/IOException
    //   5	48	373	finally
    //   52	73	373	finally
    //   73	82	381	finally
    //   124	145	387	finally
    //   5	48	391	java/lang/Exception
    //   52	73	391	java/lang/Exception
    //   73	82	400	java/lang/Exception
  }
  
  private void d()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.b = null;
  }
  
  public String a()
  {
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      this.jdField_a_of_type_Int %= arrayOfString.length;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getCircleSrvUrl | usingIndex = " + this.jdField_a_of_type_Int + " | count = " + arrayOfString.length + " | result = " + arrayOfString[this.jdField_a_of_type_Int]);
      }
      return arrayOfString[this.jdField_a_of_type_Int];
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResponseException | current index = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool1 = bool2;
    if (paramArrayOfByte1 != null) {}
    for (bool1 = bool2;; bool1 = bool2) {
      try
      {
        if (paramArrayOfByte1.length > 0)
        {
          this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
          bool1 = true;
        }
        bool2 = bool1;
        if (paramArrayOfByte2 != null)
        {
          bool2 = bool1;
          if (paramArrayOfByte2.length > 0)
          {
            this.b = paramArrayOfByte2;
            bool2 = true;
          }
        }
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
        {
          this.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
          bool1 = bool3;
          if (bool1) {
            b();
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "saveSrvParam | changed = " + bool1 + " | usingIndex = " + this.jdField_a_of_type_Int);
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\OldBigDataChannelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */