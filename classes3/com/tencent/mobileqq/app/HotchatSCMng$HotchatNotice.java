package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

public class HotchatSCMng$HotchatNotice
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public HotchatSCMng$HotchatNotice()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public String toString()
  {
    int i = 2000;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size() * 100;
    if (j > 2000) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder(i);
      localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append(",");
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localStringBuilder.append("{");
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localStringBuilder.append((HotchatSCMng.HotchatNote)localIterator.next()).append(",");
            continue;
            if (j >= 100) {
              break label155;
            }
            i = 100;
            break;
          }
        }
        localStringBuilder.append("}");
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      label155:
      i = j;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\HotchatSCMng$HotchatNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */