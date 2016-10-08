package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.QQUIEventReceiver;
import isg;

public class Repository$ShieldFriendStoryReceiver
  extends QQUIEventReceiver
{
  public Repository$ShieldFriendStoryReceiver(Repository paramRepository)
  {
    super(paramRepository);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Repository paramRepository, ShieldFriendStoryEvent paramShieldFriendStoryEvent)
  {
    paramRepository.a(new isg(this, paramRepository, paramShieldFriendStoryEvent));
  }
  
  public Class acceptEventClass()
  {
    return ShieldFriendStoryEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\Repository$ShieldFriendStoryReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */