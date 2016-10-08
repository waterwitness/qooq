package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import android.view.View;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ChildViewClickListener
{
  public ChildViewClickListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder);
  
  public void b(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\common\ChildViewClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */