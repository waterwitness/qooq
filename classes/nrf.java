import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;

public final class nrf
  implements Runnable
{
  public nrf(EntityManager paramEntityManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	nrf:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 30	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 34	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   12: getstatic 39	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	Ljava/util/List;
    //   15: invokeinterface 45 1 0
    //   20: astore_2
    //   21: aload_2
    //   22: invokeinterface 51 1 0
    //   27: ifeq +39 -> 66
    //   30: aload_2
    //   31: invokeinterface 55 1 0
    //   36: checkcast 57	com/tencent/mobileqq/data/MessageForTroopGift
    //   39: astore_3
    //   40: aload_0
    //   41: getfield 12	nrf:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   44: aload_3
    //   45: invokevirtual 60	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   48: pop
    //   49: goto -28 -> 21
    //   52: astore_2
    //   53: aload_1
    //   54: invokevirtual 63	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   57: getstatic 39	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	Ljava/util/List;
    //   60: invokeinterface 66 1 0
    //   65: return
    //   66: aload_1
    //   67: invokevirtual 69	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   70: aload_1
    //   71: invokevirtual 63	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   74: goto -17 -> 57
    //   77: astore_2
    //   78: aload_1
    //   79: invokevirtual 63	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   82: aload_2
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	nrf
    //   7	72	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   20	11	2	localIterator	java.util.Iterator
    //   52	1	2	localException	Exception
    //   77	6	2	localObject	Object
    //   39	6	3	localMessageForTroopGift	com.tencent.mobileqq.data.MessageForTroopGift
    // Exception table:
    //   from	to	target	type
    //   8	21	52	java/lang/Exception
    //   21	49	52	java/lang/Exception
    //   66	70	52	java/lang/Exception
    //   8	21	77	finally
    //   21	49	77	finally
    //   66	70	77	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */