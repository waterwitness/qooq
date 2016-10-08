package com.tencent.biz.qqstory.model.pendant;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NewStoryPendantDownloadEvent
  extends BaseEvent
{
  public final float a;
  public final int a;
  public final NewStoryPendantItem a;
  public final boolean a;
  
  public NewStoryPendantDownloadEvent(NewStoryPendantItem paramNewStoryPendantItem, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem = paramNewStoryPendantItem;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public NewStoryPendantDownloadEvent(NewStoryPendantItem paramNewStoryPendantItem, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem = paramNewStoryPendantItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramInt, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\NewStoryPendantDownloadEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */