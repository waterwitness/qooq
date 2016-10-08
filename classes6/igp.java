import com.tencent.biz.qqstory.base.LinkedBlockingDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

public abstract class igp
  implements Iterator
{
  igs jdField_a_of_type_Igs;
  Object jdField_a_of_type_JavaLangObject;
  private igs b;
  
  /* Error */
  igp(LinkedBlockingDeque paramLinkedBlockingDeque)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 15	igp:jdField_a_of_type_ComTencentBizQqstoryBaseLinkedBlockingDeque	Lcom/tencent/biz/qqstory/base/LinkedBlockingDeque;
    //   5: aload_0
    //   6: invokespecial 18	java/lang/Object:<init>	()V
    //   9: getstatic 24	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   12: istore_3
    //   13: aload_1
    //   14: getfield 30	com/tencent/biz/qqstory/base/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 34	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   22: aload_0
    //   23: aload_0
    //   24: invokevirtual 37	igp:a	()Ligs;
    //   27: putfield 39	igp:jdField_a_of_type_Igs	Ligs;
    //   30: aload_0
    //   31: getfield 39	igp:jdField_a_of_type_Igs	Ligs;
    //   34: ifnonnull +15 -> 49
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: putfield 41	igp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   44: aload_2
    //   45: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   48: return
    //   49: aload_0
    //   50: getfield 39	igp:jdField_a_of_type_Igs	Ligs;
    //   53: getfield 47	igs:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   56: astore_1
    //   57: goto -18 -> 39
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	igp
    //   0	67	1	paramLinkedBlockingDeque	LinkedBlockingDeque
    //   17	45	2	localReentrantLock	ReentrantLock
    //   12	1	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   22	37	60	finally
    //   39	44	60	finally
    //   49	57	60	finally
  }
  
  private igs b(igs paramigs)
  {
    for (;;)
    {
      igs localigs1 = a(paramigs);
      igs localigs2;
      if (localigs1 == null) {
        localigs2 = null;
      }
      do
      {
        return localigs2;
        localigs2 = localigs1;
      } while (localigs1.jdField_a_of_type_JavaLangObject != null);
      if (localigs1 == paramigs) {
        return a();
      }
      paramigs = localigs1;
    }
  }
  
  abstract igs a();
  
  abstract igs a(igs paramigs);
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	igp:jdField_a_of_type_ComTencentBizQqstoryBaseLinkedBlockingDeque	Lcom/tencent/biz/qqstory/base/LinkedBlockingDeque;
    //   4: getfield 30	com/tencent/biz/qqstory/base/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 34	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   12: aload_0
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 39	igp:jdField_a_of_type_Igs	Ligs;
    //   18: invokespecial 53	igp:b	(Ligs;)Ligs;
    //   21: putfield 39	igp:jdField_a_of_type_Igs	Ligs;
    //   24: aload_0
    //   25: getfield 39	igp:jdField_a_of_type_Igs	Ligs;
    //   28: ifnonnull +15 -> 43
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 41	igp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   38: aload_2
    //   39: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: return
    //   43: aload_0
    //   44: getfield 39	igp:jdField_a_of_type_Igs	Ligs;
    //   47: getfield 47	igs:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   50: astore_1
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_2
    //   56: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	igp
    //   32	19	1	localObject1	Object
    //   54	6	1	localObject2	Object
    //   7	49	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   12	31	54	finally
    //   33	38	54	finally
    //   43	51	54	finally
  }
  
  public boolean hasNext()
  {
    return this.jdField_a_of_type_Igs != null;
  }
  
  public Object next()
  {
    if (this.jdField_a_of_type_Igs == null) {
      throw new NoSuchElementException();
    }
    this.b = this.jdField_a_of_type_Igs;
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    a();
    return localObject;
  }
  
  public void remove()
  {
    igs localigs = this.b;
    if (localigs == null) {
      throw new IllegalStateException();
    }
    this.b = null;
    ReentrantLock localReentrantLock = this.jdField_a_of_type_ComTencentBizQqstoryBaseLinkedBlockingDeque.lock;
    localReentrantLock.lock();
    try
    {
      if (localigs.jdField_a_of_type_JavaLangObject != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseLinkedBlockingDeque.unlink(localigs);
      }
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\igp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */