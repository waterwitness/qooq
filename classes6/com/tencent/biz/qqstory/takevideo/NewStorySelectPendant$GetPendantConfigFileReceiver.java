package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantUpdateEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class NewStorySelectPendant$GetPendantConfigFileReceiver
  extends QQUIEventReceiver
{
  public NewStorySelectPendant$GetPendantConfigFileReceiver(NewStorySelectPendant paramNewStorySelectPendant)
  {
    super(paramNewStorySelectPendant);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NewStorySelectPendant paramNewStorySelectPendant, NewStoryPendantUpdateEvent paramNewStoryPendantUpdateEvent)
  {
    SLog.a(this.TAG, "onEvent : %s", paramNewStoryPendantUpdateEvent);
    if (paramNewStoryPendantUpdateEvent.a.isSuccess()) {
      NewStorySelectPendant.a(paramNewStorySelectPendant, false);
    }
  }
  
  public Class acceptEventClass()
  {
    return NewStoryPendantUpdateEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStorySelectPendant$GetPendantConfigFileReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */