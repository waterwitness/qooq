package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DeleteStoryVideoEvent
  extends BaseEvent
{
  public final String a;
  public final boolean a;
  
  public DeleteStoryVideoEvent(ErrorMessage paramErrorMessage, String paramString, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\DeleteStoryVideoEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */