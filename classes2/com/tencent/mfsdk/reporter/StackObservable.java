package com.tencent.mfsdk.reporter;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Observable;

public class StackObservable
  extends Observable
{
  private static StackObservable a;
  public int a;
  public HashMap a;
  
  private StackObservable()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static StackObservable a()
  {
    if (jdField_a_of_type_ComTencentMfsdkReporterStackObservable == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkReporterStackObservable == null) {
        jdField_a_of_type_ComTencentMfsdkReporterStackObservable = new StackObservable();
      }
      return jdField_a_of_type_ComTencentMfsdkReporterStackObservable;
    }
    finally {}
  }
  
  public void a(HashMap paramHashMap, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Int = paramInt;
    setChanged();
    notifyObservers();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\reporter\StackObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */