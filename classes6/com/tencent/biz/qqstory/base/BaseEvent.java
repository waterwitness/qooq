package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher.Event;

public class BaseEvent
  implements Dispatcher.Event
{
  public ErrorMessage a;
  
  public BaseEvent()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ErrorMessage();
  }
  
  public String a()
  {
    return this.a.getErrorMessage();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{\"_class\":\"BaseEvent\", \"errorInfo\":");
    if (this.a == null) {}
    for (String str = "null";; str = "\"" + this.a + "\"") {
      return str + "}";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\BaseEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */