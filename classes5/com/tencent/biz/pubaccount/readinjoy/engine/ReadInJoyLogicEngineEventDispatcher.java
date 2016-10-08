package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyLogicEngineEventDispatcher
{
  private static ReadInJoyLogicEngineEventDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private ReadInJoyLogicEngineEventDispatcher()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static ReadInJoyLogicEngineEventDispatcher a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher = new ReadInJoyLogicEngineEventDispatcher();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).d(paramInt);
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  public void a(ReadInJoyObserver paramReadInJoyObserver)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramReadInJoyObserver)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramReadInJoyObserver);
    }
  }
  
  public void a(List paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).b(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
    }
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramList);
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a();
      }
    }
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).a(paramInt);
    }
  }
  
  public void b(int paramInt, List paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).b(paramInt, paramList);
    }
  }
  
  public void b(ReadInJoyObserver paramReadInJoyObserver)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramReadInJoyObserver);
  }
  
  public void b(List paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).a(paramList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean);
      }
    }
  }
  
  public void b(boolean paramBoolean, List paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).b(paramBoolean, paramList);
    }
  }
  
  public void c(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).b(paramInt);
    }
  }
  
  public void c(boolean paramBoolean, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramBoolean, paramList);
      }
    }
  }
  
  public void d(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).c(paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\engine\ReadInJoyLogicEngineEventDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */