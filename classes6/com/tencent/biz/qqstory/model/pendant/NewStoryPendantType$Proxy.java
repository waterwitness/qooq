package com.tencent.biz.qqstory.model.pendant;

import com.tencent.biz.qqstory.takevideo.pendant.PendantPageAdapter;
import com.tencent.biz.qqstory.utils.JsonORM.Column;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NewStoryPendantType$Proxy
{
  @JsonORM.Column(a="typeId")
  public String a;
  @JsonORM.Column(a="pendantList")
  public NewStoryPendantItem.Proxy[] a;
  @JsonORM.Column(a="typeLogo")
  public String b;
  @JsonORM.Column(a="typeName")
  public String c;
  
  public NewStoryPendantType$Proxy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NewStoryPendantType a()
  {
    int i = 0;
    String str = this.jdField_a_of_type_JavaLangString;
    if (str == null) {
      throw new JsonFormatException("typeId should not be null");
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem$Proxy != null) && (this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem$Proxy.length > 0))
    {
      int k = (this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem$Proxy.length - 1) / (PendantPageAdapter.a.length - 1) + 1;
      NewStoryPendantItem[] arrayOfNewStoryPendantItem = new NewStoryPendantItem[this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem$Proxy.length + k];
      int j = 0;
      if (i < this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem$Proxy.length + k)
      {
        if (i % PendantPageAdapter.a.length == 0)
        {
          arrayOfNewStoryPendantItem[i] = NewStoryPendantItem.a;
          j += 1;
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfNewStoryPendantItem[i] = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem$Proxy[(i - j)].a(str);
        }
      }
      return new NewStoryPendantType(str, this.b, this.c, arrayOfNewStoryPendantItem, null);
    }
    return new NewStoryPendantType(str, this.b, this.c, null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\NewStoryPendantType$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */