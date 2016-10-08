package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MyStoryListEventListener;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;

public abstract interface IMyStroyPresenter
  extends MyStoryListEventListener, IEventReceiver
{
  public abstract void a();
  
  public abstract void a(long paramLong);
  
  public abstract void a(IMyStoryListView paramIMyStoryListView);
  
  public abstract void a(ArrayList paramArrayList);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract boolean c();
  
  public abstract void d();
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\presenter\IMyStroyPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */