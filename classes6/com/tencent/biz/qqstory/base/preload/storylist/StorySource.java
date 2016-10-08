package com.tencent.biz.qqstory.base.preload.storylist;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class StorySource
  implements ISource
{
  public static final int a = 3;
  public final String a;
  public List a;
  protected boolean a;
  protected int b;
  protected String b;
  
  public StorySource(String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 3;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      paramList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    do
    {
      do
      {
        return;
        if (paramBoolean)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          if (paramList.size() > this.jdField_b_of_type_Int) {
            this.jdField_a_of_type_JavaUtilList = paramList.subList(0, this.jdField_b_of_type_Int);
          }
          for (;;)
          {
            this.jdField_a_of_type_Boolean = true;
            return;
            this.jdField_a_of_type_JavaUtilList.addAll(paramList);
          }
        }
      } while (paramList.size() <= 0);
      this.jdField_b_of_type_Int = paramList.size();
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void b(int paramInt, List paramList)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    do
    {
      return;
      if ((paramInt == 0) && ((this.jdField_b_of_type_JavaLangString.equals(IPreloadVideoSource.jdField_a_of_type_JavaLangString)) || (this.jdField_b_of_type_JavaLangString.equals(IPreloadVideoSource.jdField_b_of_type_JavaLangString))))
      {
        paramList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
        return;
      }
    } while ((paramInt >= 5) || (!this.jdField_b_of_type_JavaLangString.equals(IPreloadVideoSource.c)));
    paramList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\StorySource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */