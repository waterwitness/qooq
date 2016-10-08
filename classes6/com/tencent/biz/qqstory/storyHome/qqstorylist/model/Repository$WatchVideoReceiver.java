package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.biz.qqstory.network.handler.WatchVideoHandler.WatchVideoEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.QQUIEventReceiver;
import ish;

public class Repository$WatchVideoReceiver
  extends QQUIEventReceiver
{
  public Repository$WatchVideoReceiver(Repository paramRepository)
  {
    super(paramRepository);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Repository paramRepository, WatchVideoHandler.WatchVideoEvent paramWatchVideoEvent)
  {
    paramRepository.a(new ish(this, paramRepository, paramWatchVideoEvent));
  }
  
  public Class acceptEventClass()
  {
    return WatchVideoHandler.WatchVideoEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\Repository$WatchVideoReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */