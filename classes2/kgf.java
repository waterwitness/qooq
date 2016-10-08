import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kgf
  implements Runnable
{
  private static final int jdField_a_of_type_Int = 3600000;
  
  private kgf(ReporterMachine paramReporterMachine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 30
    //   2: iconst_4
    //   3: ldc 32
    //   5: invokestatic 38	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: getstatic 44	com/tencent/mfsdk/reporter/ReporterMachine:b	Lcom/tencent/mfsdk/collector/ResultObject;
    //   11: astore_1
    //   12: getstatic 46	com/tencent/mfsdk/reporter/ReporterMachine:jdField_a_of_type_ComTencentMfsdkCollectorResultObject	Lcom/tencent/mfsdk/collector/ResultObject;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +10 -> 27
    //   20: aload_2
    //   21: getfield 52	com/tencent/mfsdk/collector/ResultObject:params	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: ifnonnull +19 -> 43
    //   27: aload_0
    //   28: getfield 14	kgf:a	Lcom/tencent/mfsdk/reporter/ReporterMachine;
    //   31: invokestatic 55	com/tencent/mfsdk/reporter/ReporterMachine:a	(Lcom/tencent/mfsdk/reporter/ReporterMachine;)Lmqq/os/MqqHandler;
    //   34: aload_0
    //   35: ldc2_w 56
    //   38: invokevirtual 63	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   41: pop
    //   42: return
    //   43: aload_2
    //   44: getfield 52	com/tencent/mfsdk/collector/ResultObject:params	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: ldc 65
    //   49: invokevirtual 71	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: checkcast 73	java/util/HashMap
    //   55: ldc 75
    //   57: ldc 77
    //   59: invokevirtual 81	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload_2
    //   64: getfield 52	com/tencent/mfsdk/collector/ResultObject:params	Ljava/util/concurrent/ConcurrentHashMap;
    //   67: ldc 65
    //   69: invokevirtual 71	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 73	java/util/HashMap
    //   75: ldc 83
    //   77: getstatic 88	com/tencent/mfsdk/MagnifierSDK:a	Ljava/lang/String;
    //   80: invokevirtual 81	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload_2
    //   85: getfield 52	com/tencent/mfsdk/collector/ResultObject:params	Ljava/util/concurrent/ConcurrentHashMap;
    //   88: ldc 65
    //   90: invokevirtual 71	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 73	java/util/HashMap
    //   96: ldc 90
    //   98: aload_2
    //   99: getfield 93	com/tencent/mfsdk/collector/ResultObject:uin	J
    //   102: invokestatic 99	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   105: invokevirtual 81	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload_2
    //   110: getfield 52	com/tencent/mfsdk/collector/ResultObject:params	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: ldc 65
    //   115: invokevirtual 71	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 73	java/util/HashMap
    //   121: ldc 101
    //   123: getstatic 106	android/os/Build:MODEL	Ljava/lang/String;
    //   126: invokevirtual 81	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: pop
    //   130: aload_2
    //   131: getfield 52	com/tencent/mfsdk/collector/ResultObject:params	Ljava/util/concurrent/ConcurrentHashMap;
    //   134: ldc 65
    //   136: invokevirtual 71	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 73	java/util/HashMap
    //   142: ldc 108
    //   144: getstatic 113	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   147: invokevirtual 81	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_2
    //   152: getfield 52	com/tencent/mfsdk/collector/ResultObject:params	Ljava/util/concurrent/ConcurrentHashMap;
    //   155: ldc 65
    //   157: invokevirtual 71	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   160: checkcast 73	java/util/HashMap
    //   163: ldc 115
    //   165: invokestatic 118	com/tencent/mfsdk/reporter/ReporterMachine:a	()Ljava/lang/String;
    //   168: invokevirtual 81	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: pop
    //   172: getstatic 121	com/tencent/mfsdk/reporter/ReporterMachine:jdField_a_of_type_ComTencentMfsdkReporterIReporter	Lcom/tencent/mfsdk/reporter/IReporter;
    //   175: aload_2
    //   176: invokeinterface 126 2 0
    //   181: pop
    //   182: aload_2
    //   183: invokevirtual 130	com/tencent/mfsdk/collector/ResultObject:getNext	()Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   186: checkcast 48	com/tencent/mfsdk/collector/ResultObject
    //   189: astore_3
    //   190: aload_2
    //   191: aload_1
    //   192: if_acmpne +24 -> 216
    //   195: ldc 40
    //   197: monitorenter
    //   198: aload_2
    //   199: getstatic 44	com/tencent/mfsdk/reporter/ReporterMachine:b	Lcom/tencent/mfsdk/collector/ResultObject;
    //   202: if_acmpne +37 -> 239
    //   205: aconst_null
    //   206: putstatic 44	com/tencent/mfsdk/reporter/ReporterMachine:b	Lcom/tencent/mfsdk/collector/ResultObject;
    //   209: aconst_null
    //   210: putstatic 46	com/tencent/mfsdk/reporter/ReporterMachine:jdField_a_of_type_ComTencentMfsdkCollectorResultObject	Lcom/tencent/mfsdk/collector/ResultObject;
    //   213: ldc 40
    //   215: monitorexit
    //   216: getstatic 133	com/tencent/mfsdk/reporter/ReporterMachine:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   219: aload_2
    //   220: invokevirtual 139	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   223: aload_0
    //   224: getfield 14	kgf:a	Lcom/tencent/mfsdk/reporter/ReporterMachine;
    //   227: invokestatic 55	com/tencent/mfsdk/reporter/ReporterMachine:a	(Lcom/tencent/mfsdk/reporter/ReporterMachine;)Lmqq/os/MqqHandler;
    //   230: aload_0
    //   231: ldc2_w 140
    //   234: invokevirtual 63	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   237: pop
    //   238: return
    //   239: aload_1
    //   240: invokevirtual 130	com/tencent/mfsdk/collector/ResultObject:getNext	()Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   243: checkcast 48	com/tencent/mfsdk/collector/ResultObject
    //   246: putstatic 46	com/tencent/mfsdk/reporter/ReporterMachine:jdField_a_of_type_ComTencentMfsdkCollectorResultObject	Lcom/tencent/mfsdk/collector/ResultObject;
    //   249: goto -36 -> 213
    //   252: astore_1
    //   253: ldc 40
    //   255: monitorexit
    //   256: aload_1
    //   257: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	kgf
    //   11	229	1	localResultObject1	com.tencent.mfsdk.collector.ResultObject
    //   252	5	1	localObject	Object
    //   15	205	2	localResultObject2	com.tencent.mfsdk.collector.ResultObject
    //   189	1	3	localResultObject3	com.tencent.mfsdk.collector.ResultObject
    // Exception table:
    //   from	to	target	type
    //   198	213	252	finally
    //   213	216	252	finally
    //   239	249	252	finally
    //   253	256	252	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */