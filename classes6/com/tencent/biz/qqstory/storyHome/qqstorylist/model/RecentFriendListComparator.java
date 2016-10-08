package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class RecentFriendListComparator
  implements Comparator
{
  public RecentFriendListComparator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(StoryItem paramStoryItem1, StoryItem paramStoryItem2)
  {
    return (int)(paramStoryItem2.updateTime - paramStoryItem1.updateTime);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\RecentFriendListComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */