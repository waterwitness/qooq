package com.tencent.open.appcommon;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class CallBackEvent
{
  public static final int a = 0;
  protected static volatile CallBackEvent a;
  public static final int b = 1;
  public static final int c = 2;
  protected List a;
  protected boolean a;
  
  public CallBackEvent()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static CallBackEvent a()
  {
    if (jdField_a_of_type_ComTencentOpenAppcommonCallBackEvent == null) {
      jdField_a_of_type_ComTencentOpenAppcommonCallBackEvent = new CallBackEvent();
    }
    return jdField_a_of_type_ComTencentOpenAppcommonCallBackEvent;
  }
  
  public void a(CallBackEvent.CallBackEventListener paramCallBackEventListener)
  {
    if (paramCallBackEventListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramCallBackEventListener)) {
        this.jdField_a_of_type_JavaUtilList.add(paramCallBackEventListener);
      }
      return;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.removeAll(paramArrayList);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      b(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      CallBackEvent.CallBackEventListener[] arrayOfCallBackEventListener = new CallBackEvent.CallBackEventListener[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfCallBackEventListener);
      if (arrayOfCallBackEventListener != null)
      {
        int j = arrayOfCallBackEventListener.length;
        int i = 0;
        if (i < j)
        {
          arrayOfCallBackEventListener[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\CallBackEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */