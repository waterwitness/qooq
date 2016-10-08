package com.tencent.open.appcommon;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsWebWorker$ReflectClass
{
  public Class a;
  public String a;
  public Map a;
  public Map b;
  
  protected JsWebWorker$ReflectClass(JsWebWorker paramJsWebWorker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    this.jdField_a_of_type_JavaUtilMap = null;
    this.b = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\JsWebWorker$ReflectClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */