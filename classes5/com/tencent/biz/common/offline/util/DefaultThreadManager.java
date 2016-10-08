package com.tencent.biz.common.offline.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DefaultThreadManager
  implements IThreadManager
{
  public DefaultThreadManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Runnable paramRunnable)
  {
    new Thread(paramRunnable).start();
  }
  
  public void b(Runnable paramRunnable)
  {
    new Thread(paramRunnable).start();
  }
  
  public void c(Runnable paramRunnable)
  {
    new Thread(paramRunnable).start();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\offline\util\DefaultThreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */