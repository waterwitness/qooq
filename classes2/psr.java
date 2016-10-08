import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class psr
  implements Runnable
{
  public psr(ApolloDaoManager paramApolloDaoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   6: getfield 32	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: ifnull +226 -> 235
    //   12: aload_0
    //   13: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   16: getfield 32	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: astore_1
    //   23: goto +212 -> 235
    //   26: aload_0
    //   27: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   30: getfield 32	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 40	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   36: invokevirtual 46	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +198 -> 239
    //   44: aload_1
    //   45: ldc 48
    //   47: invokevirtual 53	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +23 -> 75
    //   55: aload_0
    //   56: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   59: getfield 56	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   62: astore_2
    //   63: aload_2
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   69: aload_3
    //   70: putfield 56	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   73: aload_2
    //   74: monitorexit
    //   75: aload_1
    //   76: ldc 58
    //   78: invokevirtual 53	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +23 -> 106
    //   86: aload_0
    //   87: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   90: getfield 61	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   93: astore_2
    //   94: aload_2
    //   95: monitorenter
    //   96: aload_0
    //   97: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   100: aload_3
    //   101: putfield 61	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   104: aload_2
    //   105: monitorexit
    //   106: aload_1
    //   107: ldc 63
    //   109: invokevirtual 53	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   112: astore_3
    //   113: aload_3
    //   114: ifnull +23 -> 137
    //   117: aload_0
    //   118: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   121: getfield 66	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   124: astore_2
    //   125: aload_2
    //   126: monitorenter
    //   127: aload_0
    //   128: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   131: aload_3
    //   132: putfield 66	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   135: aload_2
    //   136: monitorexit
    //   137: aload_1
    //   138: ldc 68
    //   140: invokevirtual 53	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   143: astore_2
    //   144: aload_0
    //   145: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   148: getfield 71	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:d	Ljava/util/List;
    //   151: ifnull +88 -> 239
    //   154: aload_0
    //   155: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   158: getfield 71	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:d	Ljava/util/List;
    //   161: astore_1
    //   162: aload_1
    //   163: monitorenter
    //   164: aload_2
    //   165: ifnull +11 -> 176
    //   168: aload_0
    //   169: getfield 12	psr:a	Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;
    //   172: aload_2
    //   173: putfield 71	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:d	Ljava/util/List;
    //   176: aload_1
    //   177: monitorexit
    //   178: return
    //   179: astore_2
    //   180: aload_1
    //   181: monitorexit
    //   182: aload_2
    //   183: athrow
    //   184: astore_1
    //   185: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +51 -> 239
    //   191: ldc 79
    //   193: iconst_2
    //   194: aload_1
    //   195: invokevirtual 83	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   198: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: return
    //   202: astore_1
    //   203: aload_2
    //   204: monitorexit
    //   205: aload_1
    //   206: athrow
    //   207: astore_1
    //   208: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +28 -> 239
    //   214: ldc 79
    //   216: iconst_2
    //   217: aload_1
    //   218: invokevirtual 87	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: return
    //   225: astore_1
    //   226: aload_2
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    //   230: astore_1
    //   231: aload_2
    //   232: monitorexit
    //   233: aload_1
    //   234: athrow
    //   235: aload_1
    //   236: ifnonnull -210 -> 26
    //   239: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	psr
    //   1	180	1	localObject1	Object
    //   184	11	1	localOutOfMemoryError	OutOfMemoryError
    //   202	4	1	localObject2	Object
    //   207	11	1	localException	Exception
    //   225	4	1	localObject3	Object
    //   230	6	1	localObject4	Object
    //   179	53	2	localObject5	Object
    //   50	82	3	localList2	java.util.List
    // Exception table:
    //   from	to	target	type
    //   168	176	179	finally
    //   176	178	179	finally
    //   180	182	179	finally
    //   2	23	184	java/lang/OutOfMemoryError
    //   26	40	184	java/lang/OutOfMemoryError
    //   44	51	184	java/lang/OutOfMemoryError
    //   55	65	184	java/lang/OutOfMemoryError
    //   75	82	184	java/lang/OutOfMemoryError
    //   86	96	184	java/lang/OutOfMemoryError
    //   106	113	184	java/lang/OutOfMemoryError
    //   117	127	184	java/lang/OutOfMemoryError
    //   137	164	184	java/lang/OutOfMemoryError
    //   182	184	184	java/lang/OutOfMemoryError
    //   205	207	184	java/lang/OutOfMemoryError
    //   228	230	184	java/lang/OutOfMemoryError
    //   233	235	184	java/lang/OutOfMemoryError
    //   65	75	202	finally
    //   203	205	202	finally
    //   2	23	207	java/lang/Exception
    //   26	40	207	java/lang/Exception
    //   44	51	207	java/lang/Exception
    //   55	65	207	java/lang/Exception
    //   75	82	207	java/lang/Exception
    //   86	96	207	java/lang/Exception
    //   106	113	207	java/lang/Exception
    //   117	127	207	java/lang/Exception
    //   137	164	207	java/lang/Exception
    //   182	184	207	java/lang/Exception
    //   205	207	207	java/lang/Exception
    //   228	230	207	java/lang/Exception
    //   233	235	207	java/lang/Exception
    //   96	106	225	finally
    //   226	228	225	finally
    //   127	137	230	finally
    //   231	233	230	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */