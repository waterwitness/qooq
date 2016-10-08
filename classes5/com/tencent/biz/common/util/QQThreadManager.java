package com.tencent.biz.common.util;

import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQThreadManager
  implements IThreadManager
{
  public QQThreadManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.d(paramRunnable);
  }
  
  public void b(Runnable paramRunnable)
  {
    ThreadManager.c(paramRunnable);
  }
  
  public void c(Runnable paramRunnable)
  {
    ThreadManager.a(paramRunnable, 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\util\QQThreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */