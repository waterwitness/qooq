package cooperation.huangye.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import ydh;

public class SingleAsyncDataHelper
{
  private static final String jdField_a_of_type_JavaLangString = "SingleAsyncDataHelper";
  private List jdField_a_of_type_JavaUtilList;
  ydh jdField_a_of_type_Ydh;
  private boolean jdField_a_of_type_Boolean;
  
  public SingleAsyncDataHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    c();
  }
  
  public Object a()
  {
    return null;
  }
  
  protected void a() {}
  
  public void a(SingleAsyncDataHelper.DataListener paramDataListener, long paramLong)
  {
    if ((paramDataListener == null) || (!a(paramDataListener, paramLong))) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    if (!a())
    {
      a(true, a());
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((SingleAsyncDataHelper.SingleAsyncDataTask)localIterator.next()).jdField_a_of_type_CooperationHuangyeUtilsSingleAsyncDataHelper$DataListener.a(paramBoolean, paramObject);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    finally {}
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(SingleAsyncDataHelper.DataListener paramDataListener, long paramLong)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((SingleAsyncDataHelper.SingleAsyncDataTask)((Iterator)localObject).next()).jdField_a_of_type_CooperationHuangyeUtilsSingleAsyncDataHelper$DataListener == paramDataListener) {
          return false;
        }
      }
      localObject = new SingleAsyncDataHelper.SingleAsyncDataTask(this);
      ((SingleAsyncDataHelper.SingleAsyncDataTask)localObject).jdField_a_of_type_CooperationHuangyeUtilsSingleAsyncDataHelper$DataListener = paramDataListener;
      ((SingleAsyncDataHelper.SingleAsyncDataTask)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
      ((SingleAsyncDataHelper.SingleAsyncDataTask)localObject).b = paramLong;
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      return true;
    }
    finally {}
  }
  
  public void b()
  {
    d();
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
    finally {}
  }
  
  public void b(SingleAsyncDataHelper.DataListener paramDataListener)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        SingleAsyncDataHelper.SingleAsyncDataTask localSingleAsyncDataTask = (SingleAsyncDataHelper.SingleAsyncDataTask)localIterator.next();
        if (localSingleAsyncDataTask.jdField_a_of_type_CooperationHuangyeUtilsSingleAsyncDataHelper$DataListener == paramDataListener) {
          this.jdField_a_of_type_JavaUtilList.remove(localSingleAsyncDataTask);
        }
      }
      return;
    }
    finally {}
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Ydh == null)
    {
      this.jdField_a_of_type_Ydh = new ydh(this);
      new Timer().schedule(this.jdField_a_of_type_Ydh, 0L, 2000L);
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_Ydh != null)
    {
      this.jdField_a_of_type_Ydh.cancel();
      this.jdField_a_of_type_Ydh = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\utils\SingleAsyncDataHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */