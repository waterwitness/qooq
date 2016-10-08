package com.tencent.biz.qqstory.model.pendant;

import com.tencent.biz.qqstory.utils.JsonORM.Column;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NewStoryPendantItem$Proxy
{
  @JsonORM.Column(a="pendantVersion")
  public int a;
  @JsonORM.Column(a="pendantId")
  public String a;
  @JsonORM.Column(a="pendantName")
  public String b;
  @JsonORM.Column(a="pendantIcon")
  public String c;
  @JsonORM.Column(a="pendantDownloadUrl")
  public String d;
  @JsonORM.Column(a="pendantMd5")
  public String e;
  
  public NewStoryPendantItem$Proxy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NewStoryPendantItem a(String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str == null) {
      throw new JsonFormatException("id should not be null");
    }
    return new NewStoryPendantItem(str, this.b, this.c, this.d, this.e, this.jdField_a_of_type_Int, paramString, null);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\NewStoryPendantItem$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */