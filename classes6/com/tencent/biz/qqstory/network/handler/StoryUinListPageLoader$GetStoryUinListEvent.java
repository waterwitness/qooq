package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.biz.qqstory.network.request.GetStoryUinListRequest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class StoryUinListPageLoader$GetStoryUinListEvent
  extends BasePageLoaderEvent
{
  public final GetStoryUinListRequest a;
  public List a;
  
  public StoryUinListPageLoader$GetStoryUinListEvent(ErrorMessage paramErrorMessage, GetStoryUinListRequest paramGetStoryUinListRequest)
  {
    super(paramErrorMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramGetStoryUinListRequest;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\StoryUinListPageLoader$GetStoryUinListEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */