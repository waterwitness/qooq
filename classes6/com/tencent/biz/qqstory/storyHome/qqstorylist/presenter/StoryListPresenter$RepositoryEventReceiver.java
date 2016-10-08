package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository.RepositoryUpdateEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.QQUIEventReceiver;
import itm;
import mqq.os.MqqHandler;

public class StoryListPresenter$RepositoryEventReceiver
  extends QQUIEventReceiver
{
  public StoryListPresenter$RepositoryEventReceiver(StoryListPresenter paramStoryListPresenter)
  {
    super(paramStoryListPresenter);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(StoryListPresenter paramStoryListPresenter, Repository.RepositoryUpdateEvent paramRepositoryUpdateEvent)
  {
    ThreadManager.c().post(new itm(this, paramStoryListPresenter, paramRepositoryUpdateEvent));
  }
  
  public Class acceptEventClass()
  {
    return Repository.RepositoryUpdateEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\presenter\StoryListPresenter$RepositoryEventReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */