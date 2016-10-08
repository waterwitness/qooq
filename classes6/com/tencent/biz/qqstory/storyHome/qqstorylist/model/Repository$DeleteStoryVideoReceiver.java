package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class Repository$DeleteStoryVideoReceiver
  extends QQUIEventReceiver
{
  public Repository$DeleteStoryVideoReceiver(Repository paramRepository)
  {
    super(paramRepository);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Repository paramRepository, DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    Repository.a(paramRepository, paramDeleteStoryVideoEvent);
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\Repository$DeleteStoryVideoReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */