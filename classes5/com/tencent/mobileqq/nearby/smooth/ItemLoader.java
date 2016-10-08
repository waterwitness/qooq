package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tqb;
import tqc;
import tqd;
import tqe;
import tqg;

public abstract class ItemLoader
{
  static final String jdField_a_of_type_JavaLangString = "SmoothieItemLoader";
  static final boolean jdField_a_of_type_Boolean = false;
  public Handler a;
  Map jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  public Map b;
  
  public ItemLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  public abstract Object a(Adapter paramAdapter, int paramInt);
  
  public abstract Object a(Object paramObject, int paramInt);
  
  tqd a(View paramView)
  {
    tqd localtqd2 = (tqd)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    tqd localtqd1 = localtqd2;
    if (localtqd2 == null)
    {
      localtqd1 = new tqd();
      localtqd1.jdField_a_of_type_JavaLangObject = null;
      localtqd1.jdField_a_of_type_Boolean = false;
      localtqd1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localtqd1);
    }
    return localtqd1;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    tqc localtqc = (tqc)this.b.get(str);
    if (localtqc == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localtqc.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localtqc.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  void a(long paramLong)
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      tqc localtqc = (tqc)localIterator.next();
      if (localtqc.jdField_a_of_type_JavaLangLong.longValue() < paramLong)
      {
        if (localtqc.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localtqc.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
        }
        localIterator.remove();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.purge();
  }
  
  void a(Handler paramHandler, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new WeakHashMap());
    this.b = new ConcurrentHashMap(8, 0.9F, 1);
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new tqe(paramInt, paramInt, 60L, TimeUnit.SECONDS, new PriorityBlockingQueue());
  }
  
  void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      tqc localtqc = (tqc)localIterator.next();
      if ((View)localtqc.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localtqc.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localtqc.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
        }
        localIterator.remove();
      }
    }
  }
  
  void a(View paramView1, View paramView2, Adapter paramAdapter, int paramInt, boolean paramBoolean)
  {
    Object localObject = a(paramAdapter, paramInt);
    if (localObject == null) {}
    for (;;)
    {
      return;
      tqd localtqd = a(paramView2);
      localtqd.jdField_a_of_type_JavaLangObject = localObject;
      localtqd.jdField_a_of_type_Int = paramInt;
      localtqd.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localtqd, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  void a(View paramView1, View paramView2, tqd paramtqd, int paramInt, long paramLong)
  {
    int i = paramtqd.jdField_a_of_type_Int;
    Object localObject = paramtqd.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    tqc localtqc = (tqc)this.b.get(str);
    if (localtqc == null)
    {
      paramView1 = new tqc(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramtqd.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new tqb(this, paramView1, true));
      return;
      localtqc.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localtqc.b = new SoftReference(paramView2);
      paramView1 = localtqc;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new tqg(this, paramView1));
  }
  
  void a(View paramView, Adapter paramAdapter, int paramInt, long paramLong)
  {
    Object localObject = a(paramAdapter, paramInt);
    if (localObject == null) {
      return;
    }
    int j = a(paramAdapter, paramInt);
    int i = 0;
    label25:
    if (i < j) {
      if (a(paramAdapter, paramInt, i)) {
        break label52;
      }
    }
    for (;;)
    {
      i += 1;
      break label25;
      break;
      label52:
      a(paramView, localObject, paramAdapter, paramInt, i, SystemClock.uptimeMillis());
    }
  }
  
  void a(View paramView1, Adapter paramAdapter, View paramView2, long paramLong)
  {
    tqd localtqd = a(paramView2);
    if (!localtqd.jdField_a_of_type_Boolean) {
      break label15;
    }
    for (;;)
    {
      label15:
      return;
      if (localtqd.jdField_a_of_type_JavaLangObject != null)
      {
        int i = localtqd.jdField_a_of_type_Int;
        if (i == -1) {
          break;
        }
        int j = a(paramAdapter, i);
        i = 0;
        while (i < j)
        {
          a(paramView1, paramView2, localtqd, i, paramLong);
          i += 1;
        }
      }
    }
  }
  
  public abstract void a(View paramView, Object paramObject, int paramInt, boolean paramBoolean);
  
  void a(View paramView, Object paramObject, Adapter paramAdapter, int paramInt1, int paramInt2, long paramLong)
  {
    if (a(paramObject, paramInt2))
    {
      a(paramInt1, paramInt2);
      return;
    }
    paramAdapter = a(paramInt1, paramInt2);
    tqc localtqc = (tqc)this.b.get(paramAdapter);
    if (localtqc == null)
    {
      paramView = new tqc(paramAdapter, paramView, paramObject, paramInt1, paramInt2, paramLong);
      this.b.put(paramAdapter, paramView);
      paramView.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new tqg(this, paramView));
      return;
    }
    localtqc.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
    localtqc.b = null;
  }
  
  public boolean a(Adapter paramAdapter, int paramInt1, int paramInt2)
  {
    return true;
  }
  
  boolean a(Object paramObject, int paramInt)
  {
    return b(paramObject, paramInt) != null;
  }
  
  public boolean a(tqc paramtqc)
  {
    if (paramtqc.b == null) {
      return false;
    }
    View localView = (View)paramtqc.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramtqc.jdField_a_of_type_Int != i);
  }
  
  public abstract Object b(Object paramObject, int paramInt);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\smooth\ItemLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */