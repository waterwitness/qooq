package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public abstract class UIBaseEventReceiver
  extends QQUIEventReceiver
{
  public UIBaseEventReceiver(IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public final void a(IEventReceiver paramIEventReceiver, BaseEvent paramBaseEvent)
  {
    if ((paramBaseEvent.a != null) && (paramBaseEvent.a.isFail()))
    {
      c(paramIEventReceiver, paramBaseEvent);
      return;
    }
    b(paramIEventReceiver, paramBaseEvent);
  }
  
  public abstract void b(IEventReceiver paramIEventReceiver, BaseEvent paramBaseEvent);
  
  public abstract void c(IEventReceiver paramIEventReceiver, BaseEvent paramBaseEvent);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\UIBaseEventReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */