package com.tencent.biz.qqstory.base;

import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import igt;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class OneObjectCacheList
{
  public static final int a = 300;
  public static final String a = "OneObjectCacheList";
  public static final int b = 50;
  public LruCache a;
  public ConcurrentHashMap a;
  public int c;
  
  public OneObjectCacheList(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new igt(this, paramInt);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  /* Error */
  public static int a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: new 52	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 53	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 4
    //   15: new 55	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload 4
    //   21: invokespecial 58	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: aload_0
    //   29: invokevirtual 62	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: invokevirtual 65	java/io/ObjectOutputStream:flush	()V
    //   38: aload_2
    //   39: ifnull +7 -> 46
    //   42: aload_2
    //   43: invokevirtual 68	java/io/ObjectOutputStream:close	()V
    //   46: aload 4
    //   48: invokevirtual 72	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   51: astore_0
    //   52: aload_0
    //   53: ifnull -49 -> 4
    //   56: aload_0
    //   57: arraylength
    //   58: ireturn
    //   59: astore_3
    //   60: aconst_null
    //   61: astore_0
    //   62: aload_0
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 75	java/io/IOException:printStackTrace	()V
    //   68: aload_0
    //   69: ifnull -23 -> 46
    //   72: aload_0
    //   73: invokevirtual 68	java/io/ObjectOutputStream:close	()V
    //   76: goto -30 -> 46
    //   79: astore_0
    //   80: goto -34 -> 46
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 68	java/io/ObjectOutputStream:close	()V
    //   94: aload_0
    //   95: athrow
    //   96: astore_0
    //   97: goto -51 -> 46
    //   100: astore_1
    //   101: goto -7 -> 94
    //   104: astore_0
    //   105: goto -19 -> 86
    //   108: astore_3
    //   109: aload_2
    //   110: astore_0
    //   111: goto -49 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramObject	Object
    //   26	65	1	localObject	Object
    //   100	1	1	localException	Exception
    //   24	86	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   59	6	3	localIOException1	java.io.IOException
    //   108	1	3	localIOException2	java.io.IOException
    //   13	34	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   15	25	59	java/io/IOException
    //   72	76	79	java/lang/Exception
    //   15	25	83	finally
    //   42	46	96	java/lang/Exception
    //   90	94	100	java/lang/Exception
    //   27	32	104	finally
    //   34	38	104	finally
    //   64	68	104	finally
    //   27	32	108	java/io/IOException
    //   34	38	108	java/io/IOException
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    if (i - this.c > 50)
    {
      c();
      this.c = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      SLog.a("OneObjectCacheList", "evict second cache data count:%d", Integer.valueOf(i - this.c));
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if ((localWeakReference != null) && (localWeakReference.get() == null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
        SLog.b("OneObjectCacheList", String.format("key :%s had been remove by jvm", new Object[] { localObject }));
      }
    }
  }
  
  public long a()
  {
    Iterator localIterator = this.jdField_a_of_type_AndroidSupportV4UtilLruCache.snapshot().values().iterator();
    for (long l = 0L; localIterator.hasNext(); l += a(localIterator.next())) {}
    return l;
  }
  
  public Copyable a(Object paramObject)
  {
    Copyable localCopyable2 = (Copyable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramObject);
    Copyable localCopyable1 = localCopyable2;
    if (localCopyable2 == null)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramObject);
      localCopyable1 = localCopyable2;
      if (localWeakReference != null)
      {
        localCopyable2 = (Copyable)localWeakReference.get();
        localCopyable1 = localCopyable2;
        if (localCopyable2 != null)
        {
          SLog.b("OneObjectCacheList", String.format("revert key %s from second cache", new Object[] { paramObject }));
          a(paramObject, localCopyable2);
          localCopyable1 = localCopyable2;
        }
      }
    }
    return localCopyable1;
  }
  
  public Copyable a(Object paramObject, Copyable paramCopyable)
  {
    Copyable localCopyable = a(paramObject);
    if (localCopyable == null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramObject, paramCopyable);
      return paramCopyable;
    }
    localCopyable.copy(paramCopyable);
    return localCopyable;
  }
  
  public Copyable a(Object paramObject, Copyable paramCopyable, OneObjectCacheList.CustomUpdateItemCallback paramCustomUpdateItemCallback)
  {
    Copyable localCopyable = a(paramObject);
    if (localCopyable == null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramObject, paramCopyable);
      return paramCopyable;
    }
    paramCustomUpdateItemCallback.a(localCopyable, paramCopyable);
    return localCopyable;
  }
  
  public void a()
  {
    SLog.c("OneObjectCacheList", String.format("!!! cache size:%d, first cache size:%s second cache size:%d", new Object[] { Long.valueOf(a()), this.jdField_a_of_type_AndroidSupportV4UtilLruCache, Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()) }));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.trimToSize(paramInt);
  }
  
  public void a(Object paramObject)
  {
    Copyable localCopyable = (Copyable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramObject);
    if (localCopyable != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramObject, new WeakReference(localCopyable));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\OneObjectCacheList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */