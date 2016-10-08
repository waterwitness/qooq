import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;

public class tes
  implements Runnable
{
  public tes(EmoticonManager paramEmoticonManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	tes:jdField_a_of_type_ComTencentMobileqqModelEmoticonManager	Lcom/tencent/mobileqq/model/EmoticonManager;
    //   4: getfield 33	com/tencent/mobileqq/model/EmoticonManager:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: invokevirtual 38	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 42	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   15: aload_0
    //   16: getfield 13	tes:jdField_a_of_type_ComTencentMobileqqModelEmoticonManager	Lcom/tencent/mobileqq/model/EmoticonManager;
    //   19: getfield 33	com/tencent/mobileqq/model/EmoticonManager:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   22: ldc 44
    //   24: ldc 44
    //   26: invokevirtual 50	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   29: iconst_0
    //   30: ldc 52
    //   32: iconst_1
    //   33: anewarray 54	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 15	tes:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aastore
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 57	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +96 -> 148
    //   55: aload_2
    //   56: invokeinterface 63 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 69 1 0
    //   68: ifeq +80 -> 148
    //   71: aload_2
    //   72: invokeinterface 73 1 0
    //   77: checkcast 44	com/tencent/mobileqq/data/EmoticonKeyword
    //   80: astore_3
    //   81: aload_0
    //   82: getfield 13	tes:jdField_a_of_type_ComTencentMobileqqModelEmoticonManager	Lcom/tencent/mobileqq/model/EmoticonManager;
    //   85: getfield 33	com/tencent/mobileqq/model/EmoticonManager:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: aload_3
    //   89: invokevirtual 77	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   92: pop
    //   93: goto -31 -> 62
    //   96: astore_2
    //   97: aload_2
    //   98: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   101: aload_1
    //   102: invokevirtual 82	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   105: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +31 -> 139
    //   111: ldc 89
    //   113: iconst_2
    //   114: new 91	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   121: ldc 94
    //   123: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: getfield 15	tes:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   130: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_0
    //   140: getfield 13	tes:jdField_a_of_type_ComTencentMobileqqModelEmoticonManager	Lcom/tencent/mobileqq/model/EmoticonManager;
    //   143: iconst_1
    //   144: invokestatic 108	com/tencent/mobileqq/model/EmoticonManager:a	(Lcom/tencent/mobileqq/model/EmoticonManager;Z)V
    //   147: return
    //   148: aload_1
    //   149: invokevirtual 111	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   152: aload_1
    //   153: invokevirtual 82	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   156: goto -51 -> 105
    //   159: astore_2
    //   160: aload_1
    //   161: invokevirtual 82	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   164: aload_2
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	tes
    //   10	151	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   50	22	2	localObject1	Object
    //   96	2	2	localException	Exception
    //   159	6	2	localObject2	Object
    //   80	9	3	localEmoticonKeyword	com.tencent.mobileqq.data.EmoticonKeyword
    // Exception table:
    //   from	to	target	type
    //   11	51	96	java/lang/Exception
    //   55	62	96	java/lang/Exception
    //   62	93	96	java/lang/Exception
    //   148	152	96	java/lang/Exception
    //   11	51	159	finally
    //   55	62	159	finally
    //   62	93	159	finally
    //   97	101	159	finally
    //   148	152	159	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */