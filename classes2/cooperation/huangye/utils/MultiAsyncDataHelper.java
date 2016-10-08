package cooperation.huangye.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import ydg;

public class MultiAsyncDataHelper
{
  private static final String jdField_a_of_type_JavaLangString = "MultiAsyncDataHelper";
  private Map jdField_a_of_type_JavaUtilMap;
  ydg jdField_a_of_type_Ydg;
  
  public MultiAsyncDataHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    c();
  }
  
  protected Object a(Object paramObject)
  {
    return null;
  }
  
  protected void a(Object paramObject) {}
  
  public void a(Object paramObject, MultiAsyncDataHelper.DataListener paramDataListener)
  {
    try
    {
      paramObject = (List)this.jdField_a_of_type_JavaUtilMap.get(paramObject);
      if (paramObject == null) {
        return;
      }
      Iterator localIterator = ((List)paramObject).iterator();
      while (localIterator.hasNext())
      {
        MultiAsyncDataHelper.MultiAsyncDataTask localMultiAsyncDataTask = (MultiAsyncDataHelper.MultiAsyncDataTask)localIterator.next();
        if (localMultiAsyncDataTask.jdField_a_of_type_CooperationHuangyeUtilsMultiAsyncDataHelper$DataListener == paramDataListener) {
          ((List)paramObject).remove(localMultiAsyncDataTask);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(Object paramObject, MultiAsyncDataHelper.DataListener paramDataListener, long paramLong)
  {
    if ((paramDataListener == null) || (!a(paramObject, paramDataListener, paramLong))) {
      return;
    }
    if (!a(paramObject))
    {
      a(true, paramObject, a(paramObject));
      return;
    }
    a(paramObject);
  }
  
  public void a(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    try
    {
      Object localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(paramObject1);
      if (localObject == null) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MultiAsyncDataHelper.MultiAsyncDataTask)((Iterator)localObject).next()).jdField_a_of_type_CooperationHuangyeUtilsMultiAsyncDataHelper$DataListener.a(paramBoolean, paramObject1, paramObject2);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramObject1);
    }
    finally {}
  }
  
  protected boolean a(Object paramObject)
  {
    return true;
  }
  
  public boolean a(Object paramObject, MultiAsyncDataHelper.DataListener paramDataListener, long paramLong)
  {
    label157:
    label163:
    for (;;)
    {
      try
      {
        Object localObject1 = (List)this.jdField_a_of_type_JavaUtilMap.get(paramObject);
        if (localObject1 != null) {
          break label163;
        }
        localObject1 = new LinkedList();
        if (((List)localObject1).size() <= 0) {
          break label157;
        }
        bool = false;
        Object localObject2 = ((List)localObject1).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          if (((MultiAsyncDataHelper.MultiAsyncDataTask)((Iterator)localObject2).next()).jdField_a_of_type_CooperationHuangyeUtilsMultiAsyncDataHelper$DataListener != paramDataListener) {
            continue;
          }
          i = 1;
          if (i == 0)
          {
            localObject2 = new MultiAsyncDataHelper.MultiAsyncDataTask(this);
            ((MultiAsyncDataHelper.MultiAsyncDataTask)localObject2).jdField_a_of_type_CooperationHuangyeUtilsMultiAsyncDataHelper$DataListener = paramDataListener;
            ((MultiAsyncDataHelper.MultiAsyncDataTask)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
            ((MultiAsyncDataHelper.MultiAsyncDataTask)localObject2).b = paramLong;
            ((List)localObject1).add(localObject2);
            this.jdField_a_of_type_JavaUtilMap.put(paramObject, localObject1);
          }
          return bool;
        }
      }
      finally {}
      int i = 0;
      continue;
      boolean bool = true;
    }
  }
  
  public void b()
  {
    d();
    try
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
    finally {}
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Ydg == null)
    {
      this.jdField_a_of_type_Ydg = new ydg(this);
      new Timer().schedule(this.jdField_a_of_type_Ydg, 0L, 2000L);
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_Ydg != null)
    {
      this.jdField_a_of_type_Ydg.cancel();
      this.jdField_a_of_type_Ydg = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\utils\MultiAsyncDataHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */