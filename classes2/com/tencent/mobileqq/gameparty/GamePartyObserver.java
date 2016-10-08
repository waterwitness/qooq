package com.tencent.mobileqq.gameparty;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observable;
import java.util.Observer;

public class GamePartyObserver
  implements Observer
{
  public GamePartyObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  protected void b() {}
  
  protected void c() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
      b();
      return;
    }
    c();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\gameparty\GamePartyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */