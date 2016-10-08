package com.tencent.biz.qqstory.model.pendant;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Arrays;

public class NewStoryPendantType
{
  public static final boolean a = true;
  public static final boolean b = true;
  public final String a;
  public final NewStoryPendantItem[] a;
  public final String b;
  public final String c;
  
  private NewStoryPendantType(String paramString1, String paramString2, String paramString3, NewStoryPendantItem[] paramArrayOfNewStoryPendantItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem = paramArrayOfNewStoryPendantItem;
  }
  
  public String toString()
  {
    return "NewStoryPendantType{typeId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", logo='" + this.b + '\'' + ", name='" + this.c + '\'' + ", pendantItemArray=" + Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem) + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\NewStoryPendantType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */