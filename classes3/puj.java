import com.tencent.mobileqq.app.BoundedPriorityBlockingQueue;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class puj
  implements Iterator
{
  private int jdField_a_of_type_Int;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  private int b;
  
  public puj(BoundedPriorityBlockingQueue paramBoundedPriorityBlockingQueue, Object[] paramArrayOfObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = -1;
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramArrayOfObject;
  }
  
  /* Error */
  private void a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	puj:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   4: invokestatic 35	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)Ljava/util/concurrent/locks/ReentrantLock;
    //   7: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: aload_0
    //   14: getfield 15	puj:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   17: invokestatic 43	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)I
    //   20: if_icmpge +24 -> 44
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 15	puj:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   28: invokestatic 46	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)[Ljava/lang/Object;
    //   31: iload_2
    //   32: aaload
    //   33: if_acmpne +22 -> 55
    //   36: aload_0
    //   37: getfield 15	puj:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   40: iload_2
    //   41: invokestatic 49	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;I)V
    //   44: aload_0
    //   45: getfield 15	puj:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   48: invokestatic 35	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)Ljava/util/concurrent/locks/ReentrantLock;
    //   51: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   54: return
    //   55: iload_2
    //   56: iconst_1
    //   57: iadd
    //   58: istore_2
    //   59: goto -47 -> 12
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 15	puj:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   67: invokestatic 35	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)Ljava/util/concurrent/locks/ReentrantLock;
    //   70: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	puj
    //   0	75	1	paramObject	Object
    //   11	48	2	i	int
    // Exception table:
    //   from	to	target	type
    //   12	44	62	finally
  }
  
  public boolean hasNext()
  {
    return this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaLangObject.length;
  }
  
  public Object next()
  {
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfJavaLangObject.length) {
      throw new NoSuchElementException();
    }
    this.b = this.jdField_a_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    return arrayOfObject[i];
  }
  
  public void remove()
  {
    if (this.b == -1) {
      throw new IllegalStateException();
    }
    a(this.jdField_a_of_type_ArrayOfJavaLangObject[this.b]);
    this.b = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\puj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */