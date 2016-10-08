package com.tencent.biz.qqstory.channel;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iit;

public abstract class CmdTaskManger$UIThreadCallback
  implements CmdTaskManger.CommandCallback
{
  public static Handler a = new Handler(Looper.getMainLooper());
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NetworkRequest paramNetworkRequest, BaseResponse paramBaseResponse, ErrorMessage paramErrorMessage)
  {
    if (Thread.currentThread() == a.getLooper().getThread())
    {
      b(paramNetworkRequest, paramBaseResponse, paramErrorMessage);
      return;
    }
    a.post(new iit(this, paramNetworkRequest, paramBaseResponse, paramErrorMessage));
  }
  
  public abstract void b(NetworkRequest paramNetworkRequest, BaseResponse paramBaseResponse, ErrorMessage paramErrorMessage);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\channel\CmdTaskManger$UIThreadCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */