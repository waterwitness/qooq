package com.tencent.biz.qqstory.model;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaseManger
  implements IManager
{
  protected AtomicBoolean b;
  
  public BaseManger()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new AtomicBoolean(false);
  }
  
  public void a() {}
  
  public boolean a()
  {
    return this.b.get();
  }
  
  public void b()
  {
    this.b.set(true);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\BaseManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */