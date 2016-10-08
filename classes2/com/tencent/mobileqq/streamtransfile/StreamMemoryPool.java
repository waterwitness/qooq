package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StreamMemoryPool
{
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static HashMap a()
  {
    return jdField_a_of_type_JavaUtilHashMap;
  }
  
  public static List a()
  {
    return jdField_a_of_type_JavaUtilList;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\streamtransfile\StreamMemoryPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */