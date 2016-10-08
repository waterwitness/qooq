package com.tencent.mobileqq.msf.core.net;

import java.util.ArrayList;
import java.util.Iterator;

class j
  extends Thread
{
  j(h paramh) {}
  
  public void run()
  {
    Iterator localIterator = this.a.v.iterator();
    while (localIterator.hasNext()) {
      ((h.a)localIterator.next()).a();
    }
    this.a.w.addAll(this.a.v);
    this.a.v.clear();
    this.a.x = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */