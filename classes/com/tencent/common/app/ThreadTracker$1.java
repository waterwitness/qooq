package com.tencent.common.app;

import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import jko;

final class ThreadTracker$1
  extends ArrayList
{
  ThreadTracker$1(Collection paramCollection)
  {
    super(paramCollection);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean add(WeakReference paramWeakReference)
  {
    boolean bool = super.add(paramWeakReference);
    if (ThreadTracker.a())
    {
      paramWeakReference = (Thread)paramWeakReference.get();
      ThreadTracker.a.add(new jko(paramWeakReference.getId(), paramWeakReference.getName(), SystemClock.uptimeMillis() - ThreadTracker.a(), new Exception()));
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\app\ThreadTracker$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */