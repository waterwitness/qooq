package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import irn;
import iro;

public abstract class AsyncJob
{
  public static Handler a = new Handler(Looper.getMainLooper());
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract Object a(Object... paramVarArgs);
  
  public abstract void a(Object paramObject);
  
  public void a(Object... paramVarArgs)
  {
    paramVarArgs = new irn(this, paramVarArgs);
    Bosses.get().postJob(paramVarArgs, new iro(this), null);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\common\AsyncJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */