package com.tencent.biz.qqstory.takevideo.rmw;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observable;

public class SimpleObservable
  extends Observable
{
  public SimpleObservable()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void notifyObservers()
  {
    setChanged();
    super.notifyObservers();
  }
  
  public void notifyObservers(Object paramObject)
  {
    setChanged();
    super.notifyObservers(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\SimpleObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */