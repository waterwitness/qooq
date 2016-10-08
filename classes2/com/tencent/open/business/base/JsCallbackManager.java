package com.tencent.open.business.base;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class JsCallbackManager
{
  protected static JsCallbackManager a;
  protected ArrayList a;
  
  protected JsCallbackManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static JsCallbackManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager == null)
      {
        jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager = new JsCallbackManager();
        jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      JsCallbackManager localJsCallbackManager = jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager;
      return localJsCallbackManager;
    }
    finally {}
  }
  
  public ArrayList a()
  {
    return jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(IJsCallBack paramIJsCallBack)
  {
    int j = jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((IJsCallBack)jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager.jdField_a_of_type_JavaUtilArrayList.get(i) == paramIJsCallBack) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager.jdField_a_of_type_JavaUtilArrayList.add(paramIJsCallBack);
  }
  
  public void b(IJsCallBack paramIJsCallBack)
  {
    int j = jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((IJsCallBack)jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager.jdField_a_of_type_JavaUtilArrayList.get(i) == paramIJsCallBack) {
          jdField_a_of_type_ComTencentOpenBusinessBaseJsCallbackManager.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\base\JsCallbackManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */