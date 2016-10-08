package common.qzone.component.cache.common;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import xyd;
import xyf;
import xyi;
import xyl;

public final class SoftHashMap
  extends AbstractMap
{
  private static final float jdField_a_of_type_Float = 0.75F;
  private static final int jdField_a_of_type_Int = 16;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int jdField_b_of_type_Int = 1073741824;
  private final ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private volatile transient Collection jdField_a_of_type_JavaUtilCollection;
  private transient Set jdField_a_of_type_JavaUtilSet;
  private xyd[] jdField_a_of_type_ArrayOfXyd;
  private final float jdField_b_of_type_Float;
  private volatile transient Set jdField_b_of_type_JavaUtilSet;
  private int c;
  private int d;
  private volatile int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SoftHashMap()
  {
    this.jdField_b_of_type_Float = 0.75F;
    this.d = 16;
    this.jdField_a_of_type_ArrayOfXyd = new xyd[16];
  }
  
  public SoftHashMap(int paramInt, float paramFloat)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Illegal Initial Capacity: " + paramInt);
    }
    int i = paramInt;
    if (paramInt > 1073741824) {
      i = 1073741824;
    }
    if ((paramFloat <= 0.0F) || (Float.isNaN(paramFloat))) {
      throw new IllegalArgumentException("Illegal Load factor: " + paramFloat);
    }
    paramInt = 1;
    while (paramInt < i) {
      paramInt <<= 1;
    }
    this.jdField_a_of_type_ArrayOfXyd = new xyd[paramInt];
    this.jdField_b_of_type_Float = paramFloat;
    this.d = ((int)(paramInt * paramFloat));
  }
  
  private static int a(int paramInt)
  {
    paramInt = paramInt >>> 20 ^ paramInt >>> 12 ^ paramInt;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt2 - 1 & paramInt1;
  }
  
  private static int a(Object paramObject)
  {
    return a(paramObject.hashCode());
  }
  
  private xyd a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((xyd.a((xyd)paramObject) != i) || (!a(localObject, ((xyd)paramObject).get()))); paramObject = xyd.a((xyd)paramObject)) {}
    return (xyd)paramObject;
  }
  
  private void a()
  {
    xyd localxyd2 = (xyd)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localxyd2 != null)
    {
      int i = a(xyd.a(localxyd2), this.jdField_a_of_type_ArrayOfXyd.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfXyd[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        xyd localxyd1 = xyd.a((xyd)localObject1);
        if (localObject1 == localxyd2)
        {
          if (localObject2 == localxyd2) {
            this.jdField_a_of_type_ArrayOfXyd[i] = localxyd1;
          }
          for (;;)
          {
            xyd.a(localxyd2, null);
            xyd.a(localxyd2, null);
            this.c -= 1;
            break;
            xyd.a((xyd)localObject2, localxyd1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localxyd1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    xyd[] arrayOfxyd1 = a();
    if (arrayOfxyd1.length == 1073741824)
    {
      this.d = Integer.MAX_VALUE;
      return;
    }
    xyd[] arrayOfxyd2 = new xyd[paramInt];
    a(arrayOfxyd1, arrayOfxyd2);
    this.jdField_a_of_type_ArrayOfXyd = arrayOfxyd2;
    if (this.c >= this.d / 2)
    {
      this.d = ((int)(paramInt * this.jdField_b_of_type_Float));
      return;
    }
    a();
    a(arrayOfxyd2, arrayOfxyd1);
    this.jdField_a_of_type_ArrayOfXyd = arrayOfxyd1;
  }
  
  private void a(xyd[] paramArrayOfxyd1, xyd[] paramArrayOfxyd2)
  {
    int i = 0;
    while (i < paramArrayOfxyd1.length)
    {
      Object localObject = paramArrayOfxyd1[i];
      paramArrayOfxyd1[i] = null;
      if (localObject != null)
      {
        xyd localxyd = xyd.a((xyd)localObject);
        if (((xyd)localObject).get() == null)
        {
          xyd.a((xyd)localObject, null);
          xyd.a((xyd)localObject, null);
          this.c -= 1;
        }
        for (;;)
        {
          localObject = localxyd;
          break;
          int j = a(xyd.a((xyd)localObject), paramArrayOfxyd2.length);
          xyd.a((xyd)localObject, paramArrayOfxyd2[j]);
          paramArrayOfxyd2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    xyd[] arrayOfxyd = a();
    int j;
    for (int i = arrayOfxyd.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (xyd localxyd = arrayOfxyd[j]; localxyd != null; localxyd = xyd.a(localxyd)) {
        if (xyd.a(localxyd) == null) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || (paramObject1.equals(paramObject2));
  }
  
  private xyd[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfXyd;
  }
  
  private static Object b(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = jdField_a_of_type_JavaLangObject;
    }
    return localObject;
  }
  
  private xyd b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      xyd[] arrayOfxyd = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOfxyd.length);
      paramObject = arrayOfxyd[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        xyd localxyd = xyd.a((xyd)paramObject);
        if ((i == xyd.a((xyd)paramObject)) && (((xyd)paramObject).equals(localEntry)))
        {
          this.e += 1;
          this.c -= 1;
          if (localObject == paramObject) {
            arrayOfxyd[j] = localxyd;
          }
          for (;;)
          {
            return (xyd)paramObject;
            xyd.a((xyd)localObject, localxyd);
          }
        }
        localObject = paramObject;
        paramObject = localxyd;
      }
    }
  }
  
  private static Object c(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == jdField_a_of_type_JavaLangObject) {
      localObject = null;
    }
    return localObject;
  }
  
  public void clear()
  {
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
    this.e += 1;
    xyd[] arrayOfxyd = this.jdField_a_of_type_ArrayOfXyd;
    int i = 0;
    while (i < arrayOfxyd.length)
    {
      arrayOfxyd[i] = null;
      i += 1;
    }
    this.c = 0;
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
  }
  
  public boolean containsKey(Object paramObject)
  {
    return a(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    xyd[] arrayOfxyd = a();
    int j;
    for (int i = arrayOfxyd.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (xyd localxyd = arrayOfxyd[j]; localxyd != null; localxyd = xyd.a(localxyd)) {
        if (paramObject.equals(xyd.a(localxyd))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Set entrySet()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilSet;
    if (localObject != null) {
      return (Set)localObject;
    }
    localObject = new xyf(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return (Set)localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = xyd.a((xyd)paramObject)) {
      if ((xyd.a((xyd)paramObject) == i) && (a(localObject, ((xyd)paramObject).get()))) {
        return xyd.a((xyd)paramObject);
      }
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public Set keySet()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilSet;
    if (localObject != null) {
      return (Set)localObject;
    }
    localObject = new xyi(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return (Set)localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    xyd[] arrayOfxyd = a();
    int j = a(i, arrayOfxyd.length);
    for (paramObject1 = arrayOfxyd[j]; paramObject1 != null; paramObject1 = xyd.a((xyd)paramObject1)) {
      if ((i == xyd.a((xyd)paramObject1)) && (a(localObject, ((xyd)paramObject1).get())))
      {
        localObject = xyd.a((xyd)paramObject1);
        if (paramObject2 != localObject) {
          xyd.a((xyd)paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.e += 1;
    paramObject1 = arrayOfxyd[j];
    arrayOfxyd[j] = new xyd(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, (xyd)paramObject1);
    i = this.c + 1;
    this.c = i;
    if (i >= this.d) {
      a(arrayOfxyd.length * 2);
    }
    return null;
  }
  
  public void putAll(Map paramMap)
  {
    int i = 1073741824;
    int j = paramMap.size();
    if (j == 0) {
      return;
    }
    if (j > this.d)
    {
      j = (int)(j / this.jdField_b_of_type_Float + 1.0F);
      if (j <= 1073741824) {
        break label135;
      }
    }
    for (;;)
    {
      j = this.jdField_a_of_type_ArrayOfXyd.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfXyd.length) {
        a(j);
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        put(localEntry.getKey(), localEntry.getValue());
      }
      break;
      label135:
      i = j;
    }
  }
  
  public Object remove(Object paramObject)
  {
    Object localObject2 = b(paramObject);
    int i = a(localObject2);
    xyd[] arrayOfxyd = a();
    int j = a(i, arrayOfxyd.length);
    paramObject = arrayOfxyd[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      xyd localxyd = xyd.a((xyd)paramObject);
      if ((i == xyd.a((xyd)paramObject)) && (a(localObject2, ((xyd)paramObject).get())))
      {
        this.e += 1;
        this.c -= 1;
        if (localObject1 == paramObject) {
          arrayOfxyd[j] = localxyd;
        }
        for (;;)
        {
          return xyd.a((xyd)paramObject);
          xyd.a((xyd)localObject1, localxyd);
        }
      }
      localObject1 = paramObject;
      paramObject = localxyd;
    }
    return null;
  }
  
  public int size()
  {
    if (this.c == 0) {
      return 0;
    }
    a();
    return this.c;
  }
  
  public Collection values()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilCollection;
    if (localObject != null) {
      return (Collection)localObject;
    }
    localObject = new xyl(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return (Collection)localObject;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\common\qzone\component\cache\common\SoftHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */