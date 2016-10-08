package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class WatcherListPagerLoader$GetWatcherListEvent
  extends BasePageLoaderEvent
{
  public List a;
  
  public WatcherListPagerLoader$GetWatcherListEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "GetWatcherListEvent{mWatchers=" + this.a + "}";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\WatcherListPagerLoader$GetWatcherListEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */