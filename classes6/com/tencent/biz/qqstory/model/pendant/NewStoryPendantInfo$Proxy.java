package com.tencent.biz.qqstory.model.pendant;

import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM.Column;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NewStoryPendantInfo$Proxy
{
  @JsonORM.Column(a="versionCode")
  public int a;
  @JsonORM.Column(a="key")
  public String a;
  @JsonORM.Column(a="typeList")
  public NewStoryPendantType.Proxy[] a;
  @JsonORM.Column(a="description")
  public String b;
  
  public NewStoryPendantInfo$Proxy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NewStoryPendantInfo a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (TextUtils.equals(str, "qqstory_pendant"))
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantType$Proxy != null) && (this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantType$Proxy.length > 0))
      {
        NewStoryPendantType[] arrayOfNewStoryPendantType = new NewStoryPendantType[this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantType$Proxy.length];
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantType$Proxy.length)
        {
          arrayOfNewStoryPendantType[i] = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantType$Proxy[i].a();
          i += 1;
        }
        return new NewStoryPendantInfo(str, this.jdField_a_of_type_Int, this.b, arrayOfNewStoryPendantType, null);
      }
      return new NewStoryPendantInfo(str, this.jdField_a_of_type_Int, this.b, null, null);
    }
    throw new JsonFormatException("invalid key " + str);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\NewStoryPendantInfo$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */