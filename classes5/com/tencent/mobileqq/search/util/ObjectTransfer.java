package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectTransfer
{
  public static final long a = Long.MIN_VALUE;
  public static ObjectTransfer a;
  public Map a;
  public long b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqSearchUtilObjectTransfer = new ObjectTransfer();
  }
  
  private ObjectTransfer()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public static ObjectTransfer a()
  {
    return jdField_a_of_type_ComTencentMobileqqSearchUtilObjectTransfer;
  }
  
  /* Error */
  public long a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +11 -> 14
    //   6: ldc2_w 7
    //   9: lstore_2
    //   10: aload_0
    //   11: monitorexit
    //   12: lload_2
    //   13: lreturn
    //   14: aload_0
    //   15: getfield 35	com/tencent/mobileqq/search/util/ObjectTransfer:b	J
    //   18: lstore_2
    //   19: aload_0
    //   20: lconst_1
    //   21: lload_2
    //   22: ladd
    //   23: putfield 35	com/tencent/mobileqq/search/util/ObjectTransfer:b	J
    //   26: aload_0
    //   27: getfield 31	com/tencent/mobileqq/search/util/ObjectTransfer:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   30: lload_2
    //   31: invokestatic 41	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: new 43	java/lang/ref/WeakReference
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 46	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   42: invokeinterface 52 3 0
    //   47: pop
    //   48: goto -38 -> 10
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ObjectTransfer
    //   0	56	1	paramObject	Object
    //   9	22	2	l	long
    // Exception table:
    //   from	to	target	type
    //   14	48	51	finally
  }
  
  /* Error */
  public Object a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/tencent/mobileqq/search/util/ObjectTransfer:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: lload_1
    //   7: invokestatic 41	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokeinterface 57 2 0
    //   15: checkcast 43	java/lang/ref/WeakReference
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +12 -> 32
    //   23: aload_3
    //   24: invokevirtual 60	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: aconst_null
    //   33: astore_3
    //   34: goto -6 -> 28
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	ObjectTransfer
    //   0	42	1	paramLong	long
    //   18	16	3	localObject1	Object
    //   37	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	37	finally
    //   23	28	37	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\util\ObjectTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */