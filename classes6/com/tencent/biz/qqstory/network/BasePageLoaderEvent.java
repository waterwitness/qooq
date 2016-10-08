package com.tencent.biz.qqstory.network;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BasePageLoaderEvent
  extends BaseEvent
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public BasePageLoaderEvent(ErrorMessage paramErrorMessage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = true;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
  }
  
  public int a()
  {
    return 0;
  }
  
  public String toString()
  {
    return "{\"_class\":\"BasePageLoaderEvent\", \"errorInfo\":\"" + this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + "\"" + ", " + "\"isEnd\":\"" + this.jdField_a_of_type_Boolean + "\"" + ", " + "\"isLocalData\":\"" + this.b + "\"" + ", " + "\"isFirstPage\":\"" + this.c + "\"" + "}";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\BasePageLoaderEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */