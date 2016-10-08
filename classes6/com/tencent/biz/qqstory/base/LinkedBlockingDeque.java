package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import igq;
import igr;
import igs;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque
  extends AbstractQueue
  implements Serializable
{
  protected static final long serialVersionUID = -387911632671998426L;
  private transient int a;
  protected final int capacity;
  public transient igs first;
  public transient igs last;
  public final ReentrantLock lock = new ReentrantLock();
  protected final Condition notEmpty = this.lock.newCondition();
  protected final Condition notFull = this.lock.newCondition();
  
  public LinkedBlockingDeque()
  {
    this(Integer.MAX_VALUE);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LinkedBlockingDeque(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.capacity = paramInt;
  }
  
  public LinkedBlockingDeque(Collection paramCollection)
  {
    this(Integer.MAX_VALUE);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    Object localObject;
    do
    {
      try
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break;
        }
        localObject = paramCollection.next();
        if (localObject == null) {
          throw new NullPointerException();
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
    } while (b(new igs(localObject)));
    throw new IllegalStateException("Deque full");
    localReentrantLock.unlock();
  }
  
  private Object a()
  {
    igs localigs1 = this.first;
    if (localigs1 == null) {
      return null;
    }
    igs localigs2 = localigs1.b;
    Object localObject = localigs1.jdField_a_of_type_JavaLangObject;
    localigs1.jdField_a_of_type_JavaLangObject = null;
    localigs1.b = localigs1;
    this.first = localigs2;
    if (localigs2 == null) {
      this.last = null;
    }
    for (;;)
    {
      this.a -= 1;
      this.notFull.signal();
      return localObject;
      localigs2.jdField_a_of_type_Igs = null;
    }
  }
  
  private boolean a(igs paramigs)
  {
    if (this.a >= this.capacity) {
      return false;
    }
    igs localigs = this.first;
    paramigs.b = localigs;
    this.first = paramigs;
    if (this.last == null) {
      this.last = paramigs;
    }
    for (;;)
    {
      this.a += 1;
      this.notEmpty.signal();
      return true;
      localigs.jdField_a_of_type_Igs = paramigs;
    }
  }
  
  private Object b()
  {
    igs localigs1 = this.last;
    if (localigs1 == null) {
      return null;
    }
    igs localigs2 = localigs1.jdField_a_of_type_Igs;
    Object localObject = localigs1.jdField_a_of_type_JavaLangObject;
    localigs1.jdField_a_of_type_JavaLangObject = null;
    localigs1.jdField_a_of_type_Igs = localigs1;
    this.last = localigs2;
    if (localigs2 == null) {
      this.first = null;
    }
    for (;;)
    {
      this.a -= 1;
      this.notFull.signal();
      return localObject;
      localigs2.b = null;
    }
  }
  
  private boolean b(igs paramigs)
  {
    if (this.a >= this.capacity) {
      return false;
    }
    igs localigs = this.last;
    paramigs.jdField_a_of_type_Igs = localigs;
    this.last = paramigs;
    if (this.first == null) {
      this.first = paramigs;
    }
    for (;;)
    {
      this.a += 1;
      this.notEmpty.signal();
      return true;
      localigs.b = paramigs;
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    this.a = 0;
    this.first = null;
    this.last = null;
    for (;;)
    {
      Object localObject = paramObjectInputStream.readObject();
      if (localObject == null) {
        return;
      }
      add(localObject);
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      paramObjectOutputStream.defaultWriteObject();
      for (igs localigs = this.first; localigs != null; localigs = localigs.b) {
        paramObjectOutputStream.writeObject(localigs.jdField_a_of_type_JavaLangObject);
      }
      paramObjectOutputStream.writeObject(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean add(Object paramObject)
  {
    addLast(paramObject);
    return true;
  }
  
  public void addFirst(Object paramObject)
  {
    if (!offerFirst(paramObject)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public void addLast(Object paramObject)
  {
    if (!offerLast(paramObject)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public void clear()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      igs localigs;
      for (Object localObject1 = this.first; localObject1 != null; localObject1 = localigs)
      {
        ((igs)localObject1).jdField_a_of_type_JavaLangObject = null;
        localigs = ((igs)localObject1).b;
        ((igs)localObject1).jdField_a_of_type_Igs = null;
        ((igs)localObject1).b = null;
      }
      this.last = null;
      this.first = null;
      this.a = 0;
      this.notFull.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (igs localigs = this.first; localigs != null; localigs = localigs.b)
      {
        boolean bool = paramObject.equals(localigs.jdField_a_of_type_JavaLangObject);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Iterator descendingIterator()
  {
    return new igq(this, null);
  }
  
  public int drainTo(Collection paramCollection)
  {
    return drainTo(paramCollection, Integer.MAX_VALUE);
  }
  
  public int drainTo(Collection paramCollection, int paramInt)
  {
    int i = 0;
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (paramCollection == this) {
      throw new IllegalArgumentException();
    }
    if (paramInt <= 0) {
      return 0;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int j = Math.min(paramInt, this.a);
      paramInt = i;
      while (paramInt < j)
      {
        paramCollection.add(this.first.jdField_a_of_type_JavaLangObject);
        a();
        paramInt += 1;
      }
      return j;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object element()
  {
    return getFirst();
  }
  
  public Object getFirst()
  {
    Object localObject = peekFirst();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public Object getLast()
  {
    Object localObject = peekLast();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public Iterator iterator()
  {
    return new igr(this, null);
  }
  
  public boolean offer(Object paramObject)
  {
    return offerLast(paramObject);
  }
  
  public boolean offer(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    return offerLast(paramObject, paramLong, paramTimeUnit);
  }
  
  public boolean offerFirst(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    igs localigs = new igs(paramObject);
    paramObject = this.lock;
    ((ReentrantLock)paramObject).lock();
    try
    {
      boolean bool = a(localigs);
      return bool;
    }
    finally
    {
      ((ReentrantLock)paramObject).unlock();
    }
  }
  
  public boolean offerFirst(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    paramObject = new igs(paramObject);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = a((igs)paramObject);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.notFull.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public boolean offerLast(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    igs localigs = new igs(paramObject);
    paramObject = this.lock;
    ((ReentrantLock)paramObject).lock();
    try
    {
      boolean bool = b(localigs);
      return bool;
    }
    finally
    {
      ((ReentrantLock)paramObject).unlock();
    }
  }
  
  public boolean offerLast(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    paramObject = new igs(paramObject);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = b((igs)paramObject);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.notFull.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public Object peek()
  {
    return peekFirst();
  }
  
  /* Error */
  public Object peekFirst()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/biz/qqstory/base/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 57	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 97	com/tencent/biz/qqstory/base/LinkedBlockingDeque:first	Ligs;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 97	com/tencent/biz/qqstory/base/LinkedBlockingDeque:first	Ligs;
    //   30: getfield 102	igs:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	LinkedBlockingDeque
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  /* Error */
  public Object peekLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/biz/qqstory/base/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 57	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 104	com/tencent/biz/qqstory/base/LinkedBlockingDeque:last	Ligs;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 104	com/tencent/biz/qqstory/base/LinkedBlockingDeque:last	Ligs;
    //   30: getfield 102	igs:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	LinkedBlockingDeque
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  public Object poll()
  {
    return pollFirst();
  }
  
  public Object poll(long paramLong, TimeUnit paramTimeUnit)
  {
    return pollFirst(paramLong, paramTimeUnit);
  }
  
  public Object pollFirst()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = a();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object pollFirst(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = a();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.notEmpty.awaitNanos(paramLong);
      }
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public Object pollLast()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = b();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object pollLast(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = b();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.notEmpty.awaitNanos(paramLong);
      }
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public Object pop()
  {
    return removeFirst();
  }
  
  public void push(Object paramObject)
  {
    addFirst(paramObject);
  }
  
  public void put(Object paramObject)
  {
    putLast(paramObject);
  }
  
  /* Error */
  public void putFirst(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 75	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 76	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 81	igs
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 84	igs:<init>	(Ljava/lang/Object;)V
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 41	com/tencent/biz/qqstory/base/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 57	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 198	com/tencent/biz/qqstory/base/LinkedBlockingDeque:a	(Ligs;)Z
    //   35: ifne +22 -> 57
    //   38: aload_0
    //   39: getfield 49	com/tencent/biz/qqstory/base/LinkedBlockingDeque:notFull	Ljava/util/concurrent/locks/Condition;
    //   42: invokeinterface 236 1 0
    //   47: goto -17 -> 30
    //   50: astore_2
    //   51: aload_1
    //   52: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   55: aload_2
    //   56: athrow
    //   57: aload_1
    //   58: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	LinkedBlockingDeque
    //   0	62	1	paramObject	Object
    //   20	12	2	localigs	igs
    //   50	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	47	50	finally
  }
  
  /* Error */
  public void putLast(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 75	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 76	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 81	igs
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 84	igs:<init>	(Ljava/lang/Object;)V
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 41	com/tencent/biz/qqstory/base/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 57	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 88	com/tencent/biz/qqstory/base/LinkedBlockingDeque:b	(Ligs;)Z
    //   35: ifne +22 -> 57
    //   38: aload_0
    //   39: getfield 49	com/tencent/biz/qqstory/base/LinkedBlockingDeque:notFull	Ljava/util/concurrent/locks/Condition;
    //   42: invokeinterface 236 1 0
    //   47: goto -17 -> 30
    //   50: astore_2
    //   51: aload_1
    //   52: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   55: aload_2
    //   56: athrow
    //   57: aload_1
    //   58: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	LinkedBlockingDeque
    //   0	62	1	paramObject	Object
    //   20	12	2	localigs	igs
    //   50	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	47	50	finally
  }
  
  public int remainingCapacity()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = this.capacity;
      int j = this.a;
      return i - j;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object remove()
  {
    return removeFirst();
  }
  
  public boolean remove(Object paramObject)
  {
    return removeFirstOccurrence(paramObject);
  }
  
  public Object removeFirst()
  {
    Object localObject = pollFirst();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean removeFirstOccurrence(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (igs localigs = this.first; localigs != null; localigs = localigs.b) {
        if (paramObject.equals(localigs.jdField_a_of_type_JavaLangObject))
        {
          unlink(localigs);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object removeLast()
  {
    Object localObject = pollLast();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean removeLastOccurrence(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (igs localigs = this.last; localigs != null; localigs = localigs.jdField_a_of_type_Igs) {
        if (paramObject.equals(localigs.jdField_a_of_type_JavaLangObject))
        {
          unlink(localigs);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public int size()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = this.a;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object take()
  {
    return takeFirst();
  }
  
  public Object takeFirst()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject1 = a();
        if (localObject1 != null) {
          break;
        }
        this.notEmpty.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return localObject2;
  }
  
  public Object takeLast()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject1 = b();
        if (localObject1 != null) {
          break;
        }
        this.notEmpty.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return localObject2;
  }
  
  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[this.a];
      int i = 0;
      igs localigs = this.first;
      while (localigs != null)
      {
        arrayOfObject[i] = localigs.jdField_a_of_type_JavaLangObject;
        localigs = localigs.b;
        i += 1;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    Object[] arrayOfObject = paramArrayOfObject;
    try
    {
      if (paramArrayOfObject.length < this.a) {
        arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), this.a);
      }
      int i = 0;
      paramArrayOfObject = this.first;
      while (paramArrayOfObject != null)
      {
        arrayOfObject[i] = paramArrayOfObject.jdField_a_of_type_JavaLangObject;
        paramArrayOfObject = paramArrayOfObject.b;
        i += 1;
      }
      if (arrayOfObject.length > i) {
        arrayOfObject[i] = null;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/biz/qqstory/base/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 57	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 97	com/tencent/biz/qqstory/base/LinkedBlockingDeque:first	Ligs;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +12 -> 29
    //   20: aload 4
    //   22: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   25: ldc_w 280
    //   28: areturn
    //   29: new 282	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   36: astore 5
    //   38: aload 5
    //   40: bipush 91
    //   42: invokevirtual 287	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: getfield 102	igs:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: astore_2
    //   53: aload_3
    //   54: aload_0
    //   55: if_acmpne +7 -> 62
    //   58: ldc_w 289
    //   61: astore_2
    //   62: aload 5
    //   64: aload_2
    //   65: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_1
    //   70: getfield 99	igs:b	Ligs;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnonnull +21 -> 96
    //   78: aload 5
    //   80: bipush 93
    //   82: invokevirtual 287	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   85: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload_1
    //   95: areturn
    //   96: aload 5
    //   98: bipush 44
    //   100: invokevirtual 287	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   103: bipush 32
    //   105: invokevirtual 287	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: goto -63 -> 46
    //   112: astore_1
    //   113: aload 4
    //   115: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	LinkedBlockingDeque
    //   15	80	1	localObject1	Object
    //   112	7	1	localObject2	Object
    //   52	13	2	localObject3	Object
    //   50	4	3	localObject4	Object
    //   4	110	4	localReentrantLock	ReentrantLock
    //   36	61	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	16	112	finally
    //   29	46	112	finally
    //   46	51	112	finally
    //   62	74	112	finally
    //   78	89	112	finally
    //   96	109	112	finally
  }
  
  public void unlink(igs paramigs)
  {
    igs localigs1 = paramigs.jdField_a_of_type_Igs;
    igs localigs2 = paramigs.b;
    if (localigs1 == null)
    {
      a();
      return;
    }
    if (localigs2 == null)
    {
      b();
      return;
    }
    localigs1.b = localigs2;
    localigs2.jdField_a_of_type_Igs = localigs1;
    paramigs.jdField_a_of_type_JavaLangObject = null;
    this.a -= 1;
    this.notFull.signal();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\LinkedBlockingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */