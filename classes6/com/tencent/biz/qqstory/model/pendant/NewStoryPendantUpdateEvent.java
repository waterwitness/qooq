package com.tencent.biz.qqstory.model.pendant;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NewStoryPendantUpdateEvent
  extends BaseEvent
{
  public NewStoryPendantUpdateEvent()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NewStoryPendantUpdateEvent(ErrorMessage paramErrorMessage)
  {
    this.a = paramErrorMessage;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\NewStoryPendantUpdateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */