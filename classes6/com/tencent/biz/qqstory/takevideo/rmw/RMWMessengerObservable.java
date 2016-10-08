package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RMWMessengerObservable
{
  Set jdField_a_of_type_JavaUtilSet;
  boolean jdField_a_of_type_Boolean;
  
  public RMWMessengerObservable()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilSet.size();
  }
  
  public int a(Message paramMessage)
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      HashSet localHashSet;
      try
      {
        if (!a()) {
          break label166;
        }
        a();
        localObject1 = new RMWMessengerObserver[this.jdField_a_of_type_JavaUtilSet.size()];
        this.jdField_a_of_type_JavaUtilSet.toArray((Object[])localObject1);
        localHashSet = new HashSet();
        if (localObject1 == null) {
          break label123;
        }
        int m = localObject1.length;
        int j = 0;
        k = i;
        if (j >= m) {
          break label123;
        }
        Object localObject2 = localObject1[j];
        if (!((RMWMessengerObserver)localObject2).a(this, paramMessage))
        {
          localHashSet.add(localObject2);
          j += 1;
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label123:
      paramMessage = localHashSet.iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (RMWMessengerObserver)paramMessage.next();
        this.jdField_a_of_type_JavaUtilSet.remove(localObject1);
      }
      return k;
      label166:
      Object localObject1 = null;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(RMWMessengerObserver paramRMWMessengerObserver)
  {
    if (paramRMWMessengerObserver == null) {
      throw new NullPointerException("observer == null");
    }
    try
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramRMWMessengerObserver)) {
        this.jdField_a_of_type_JavaUtilSet.add(paramRMWMessengerObserver);
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(RMWMessengerObserver paramRMWMessengerObserver)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilSet.remove(paramRMWMessengerObserver);
      return;
    }
    finally
    {
      paramRMWMessengerObserver = finally;
      throw paramRMWMessengerObserver;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWMessengerObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */