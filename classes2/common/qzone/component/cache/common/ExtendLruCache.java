package common.qzone.component.cache.common;

import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import xya;
import xyb;

public class ExtendLruCache
{
  private int jdField_a_of_type_Int;
  private final LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue;
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  private int b;
  
  public ExtendLruCache(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new xya(this, paramInt);
  }
  
  private void b()
  {
    for (xyb localxyb = (xyb)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll(); localxyb != null; localxyb = (xyb)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll()) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(localxyb.a);
    }
  }
  
  public final int a()
  {
    try
    {
      int i = this.jdField_a_of_type_AndroidSupportV4UtilLruCache.maxSize();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int a(Object paramObject1, Object paramObject2)
  {
    return 1;
  }
  
  public final Object a(Object paramObject)
  {
    for (;;)
    {
      try
      {
        b();
        Object localObject = this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_Int += 1;
          paramObject = localObject;
          return paramObject;
        }
        paramObject = (xyb)this.jdField_a_of_type_JavaUtilHashMap.get(paramObject);
        if (paramObject != null)
        {
          paramObject = ((xyb)paramObject).get();
          if (paramObject != null)
          {
            this.jdField_a_of_type_Int += 1;
            continue;
          }
        }
        this.b += 1;
      }
      finally {}
      paramObject = null;
    }
  }
  
  public final Object a(Object paramObject, ExtendLruCache.Matcher paramMatcher)
  {
    Object localObject1 = null;
    if (paramObject == null) {
      try
      {
        throw new NullPointerException("key == null");
      }
      finally {}
    }
    if (paramMatcher == null) {
      throw new NullPointerException("keyMatcher == null");
    }
    b();
    Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet();
    if ((localObject2 != null) && (((Set)localObject2).size() > 0))
    {
      Iterator localIterator = ((Set)localObject2).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = localIterator.next();
      } while (!paramMatcher.a(paramObject, localObject2));
    }
    for (paramObject = localObject2;; paramObject = null)
    {
      paramMatcher = (ExtendLruCache.Matcher)localObject1;
      if (paramObject != null) {
        paramMatcher = a(paramObject);
      }
      return paramMatcher;
    }
  }
  
  /* Error */
  public final Object a(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 61	common/qzone/component/cache/common/ExtendLruCache:b	()V
    //   6: aload_0
    //   7: getfield 38	common/qzone/component/cache/common/ExtendLruCache:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   10: aload_1
    //   11: aload_2
    //   12: invokevirtual 115	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_0
    //   17: getfield 26	common/qzone/component/cache/common/ExtendLruCache:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   20: aload_1
    //   21: new 45	xyb
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 31	common/qzone/component/cache/common/ExtendLruCache:jdField_a_of_type_JavaLangRefReferenceQueue	Ljava/lang/ref/ReferenceQueue;
    //   31: invokespecial 118	xyb:<init>	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   34: invokevirtual 119	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 45	xyb
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +9 -> 51
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: aload_1
    //   52: invokevirtual 70	xyb:get	()Ljava/lang/Object;
    //   55: astore_1
    //   56: goto -9 -> 47
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ExtendLruCache
    //   0	64	1	paramObject1	Object
    //   0	64	2	paramObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	41	59	finally
    //   51	56	59	finally
  }
  
  public final void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  /* Error */
  public final Object b(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 61	common/qzone/component/cache/common/ExtendLruCache:b	()V
    //   6: aload_0
    //   7: getfield 38	common/qzone/component/cache/common/ExtendLruCache:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   10: aload_1
    //   11: invokevirtual 127	android/support/v4/util/LruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_0
    //   16: getfield 26	common/qzone/component/cache/common/ExtendLruCache:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: aload_1
    //   20: invokevirtual 52	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 45	xyb
    //   26: astore_1
    //   27: aload_2
    //   28: ifnull +9 -> 37
    //   31: aload_2
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aload_1
    //   38: ifnonnull +8 -> 46
    //   41: aconst_null
    //   42: astore_1
    //   43: goto -10 -> 33
    //   46: aload_1
    //   47: invokevirtual 70	xyb:get	()Ljava/lang/Object;
    //   50: astore_1
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	ExtendLruCache
    //   0	59	1	paramObject	Object
    //   14	18	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	54	finally
    //   46	51	54	finally
  }
  
  public final Object b(Object paramObject, ExtendLruCache.Matcher paramMatcher)
  {
    if (paramObject == null) {
      try
      {
        throw new NullPointerException("key == null");
      }
      finally {}
    }
    if (paramMatcher == null) {
      throw new NullPointerException("keyMatcher == null");
    }
    b();
    int i = 0;
    Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet();
    Object localObject1 = paramObject;
    if (localObject2 != null)
    {
      localObject1 = paramObject;
      if (((Set)localObject2).size() > 0)
      {
        localObject1 = new ArrayList();
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (paramMatcher.a(paramObject, localObject3)) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        localObject2 = ((Collection)localObject1).iterator();
      }
    }
    for (;;)
    {
      localObject1 = paramObject;
      if (((Iterator)localObject2).hasNext())
      {
        paramMatcher = ((Iterator)localObject2).next();
        paramObject = this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramMatcher);
        localObject1 = (xyb)this.jdField_a_of_type_JavaUtilHashMap.remove(paramMatcher);
        if (paramObject == null) {
          if (localObject1 == null) {
            paramObject = null;
          } else {
            paramObject = ((xyb)localObject1).get();
          }
        }
      }
      else
      {
        return localObject1;
      }
      for (;;)
      {
        break;
        if (paramObject != null) {
          i += 1;
        }
      }
      paramObject = paramMatcher;
    }
  }
  
  public Object c(Object paramObject)
  {
    return null;
  }
  
  public String toString()
  {
    float f1 = 0.0F;
    StringBuilder localStringBuilder = new StringBuilder(128);
    float f2 = this.jdField_a_of_type_Int + this.b;
    if (f2 != 0.0F) {
      f1 = this.jdField_a_of_type_Int * 100 / f2;
    }
    String str = String.format("ExtendLruCache[hits=%d,misses=%d,hitRate=%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), String.valueOf(f1) });
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    localStringBuilder.append(str);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.jdField_a_of_type_AndroidSupportV4UtilLruCache.toString());
    int i = this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size() / 1024;
    int j = this.jdField_a_of_type_AndroidSupportV4UtilLruCache.maxSize() / 1024;
    localStringBuilder.append("\n");
    localStringBuilder.append("Lru Size Info:" + String.valueOf(i) + "kb/" + String.valueOf(j) + "kb");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\common\qzone\component\cache\common\ExtendLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */