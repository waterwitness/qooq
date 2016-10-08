package com.tencent.biz.qqstory.takevideo.rmw;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observable;
import java.util.Observer;

public class RMWClientObserver
  implements Observer
{
  public RMWClientObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(RMWEvent paramRMWEvent) {}
  
  protected void b(int paramInt) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof ServiceStateEvent)) {
      b(((ServiceStateEvent)paramObject).a);
    }
    while (!(paramObject instanceof RMWEvent)) {
      return;
    }
    a((RMWEvent)paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWClientObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */