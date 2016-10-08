package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class RecentStoryListPagerLoader$GetRecentStoryListEvent
  extends BasePageLoaderEvent
{
  public List a;
  
  public RecentStoryListPagerLoader$GetRecentStoryListEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "GetRecentStoryListEvent{mUnWatchStoryList=" + this.a + "}";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\RecentStoryListPagerLoader$GetRecentStoryListEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */