package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class CallBack
{
  public CallBack()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a(Object paramObject);
  
  public abstract void b(Object paramObject);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\common\CallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */