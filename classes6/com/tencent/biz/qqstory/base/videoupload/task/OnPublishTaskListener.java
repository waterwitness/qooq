package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract interface OnPublishTaskListener
{
  public abstract void a(BasePublishTask paramBasePublishTask, int paramInt1, int paramInt2);
  
  public abstract void a(BasePublishTask paramBasePublishTask, ErrorMessage paramErrorMessage);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\task\OnPublishTaskListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */