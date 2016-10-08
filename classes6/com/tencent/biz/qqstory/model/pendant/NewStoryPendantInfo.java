package com.tencent.biz.qqstory.model.pendant;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Arrays;

public class NewStoryPendantInfo
{
  public static final String a = "qqstory_pendant";
  public final int a;
  public final NewStoryPendantType[] a;
  public final String b;
  public final String c;
  
  private NewStoryPendantInfo(String paramString1, int paramInt, String paramString2, NewStoryPendantType[] paramArrayOfNewStoryPendantType)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString2;
    this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantType = paramArrayOfNewStoryPendantType;
  }
  
  public String toString()
  {
    return "NewStoryPendantInfo{key='" + this.b + '\'' + ", versionCode=" + this.jdField_a_of_type_Int + ", description='" + this.c + '\'' + ", typeArray=" + Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantType) + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\NewStoryPendantInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */