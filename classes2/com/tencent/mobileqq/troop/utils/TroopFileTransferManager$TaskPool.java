package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopFileTransferManager$TaskPool
{
  public int a;
  public LinkedList a;
  public AtomicInteger a;
  
  public TroopFileTransferManager$TaskPool(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  public void a(TroopFileTransferManager.Task paramTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: aload_1
    //   7: invokevirtual 37	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield 24	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   15: invokevirtual 41	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   18: aload_0
    //   19: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:jdField_a_of_type_Int	I
    //   22: if_icmple +14 -> 36
    //   25: aload_0
    //   26: getfield 24	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   29: invokevirtual 44	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: new 46	vql
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 49	vql:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool;)V
    //   44: iconst_5
    //   45: aconst_null
    //   46: iconst_0
    //   47: invokestatic 54	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   50: goto -17 -> 33
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	TaskPool
    //   0	58	1	paramTask	TroopFileTransferManager.Task
    // Exception table:
    //   from	to	target	type
    //   2	33	53	finally
    //   36	50	53	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileTransferManager$TaskPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */