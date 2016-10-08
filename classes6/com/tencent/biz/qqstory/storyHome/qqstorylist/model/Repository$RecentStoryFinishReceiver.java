package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.QQUIEventReceiver;
import isf;

public class Repository$RecentStoryFinishReceiver
  extends QQUIEventReceiver
{
  public Repository$RecentStoryFinishReceiver(Repository paramRepository)
  {
    super(paramRepository);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Repository paramRepository, RecentStoryFinishEvent paramRecentStoryFinishEvent)
  {
    paramRepository.a(new isf(this, paramRepository, paramRecentStoryFinishEvent.a));
  }
  
  public Class acceptEventClass()
  {
    return RecentStoryFinishEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\Repository$RecentStoryFinishReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */