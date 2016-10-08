package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.WatchVideoRequest;
import com.tencent.biz.qqstory.network.response.WatchVideoResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.List;

public class WatchVideoHandler
  implements CmdTaskManger.CommandCallback
{
  public static final String a = "Q.qqstory.player.WatchVideoHandler";
  
  public WatchVideoHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(WatchVideoRequest paramWatchVideoRequest, WatchVideoResponse paramWatchVideoResponse, ErrorMessage paramErrorMessage)
  {
    WatchVideoHandler.WatchVideoEvent localWatchVideoEvent = new WatchVideoHandler.WatchVideoEvent();
    localWatchVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localWatchVideoEvent.jdField_a_of_type_JavaLangString = paramWatchVideoRequest.c;
    localWatchVideoEvent.jdField_a_of_type_Long = paramWatchVideoRequest.jdField_a_of_type_Long;
    localWatchVideoEvent.jdField_a_of_type_Boolean = paramWatchVideoRequest.jdField_a_of_type_Boolean;
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem = localStoryManager.a(paramWatchVideoRequest.c);
    if (localStoryVideoItem != null)
    {
      localStoryVideoItem.mHasWatched = true;
      localStoryManager.a(localStoryVideoItem.mVid, localStoryVideoItem);
    }
    localWatchVideoEvent.jdField_a_of_type_Int = localStoryManager.d(paramWatchVideoRequest.jdField_a_of_type_Long).size();
    StoryItem localStoryItem = localStoryManager.a(paramWatchVideoRequest.jdField_a_of_type_Long, 1);
    if (localStoryItem != null)
    {
      if (localStoryItem.unReadCount == 0) {
        break label180;
      }
      localStoryItem.unReadCount = localWatchVideoEvent.jdField_a_of_type_Int;
      localStoryManager.a(paramWatchVideoRequest.jdField_a_of_type_Long, 1, localStoryItem);
    }
    while ((paramWatchVideoResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localWatchVideoEvent);
      if (localStoryVideoItem == null)
      {
        return;
        label180:
        localStoryManager.a(paramWatchVideoRequest.jdField_a_of_type_Long, 1);
      }
      else
      {
        ((ReportWatchVideoManager)SuperManager.a(13)).a(paramWatchVideoRequest.c, paramWatchVideoRequest.jdField_a_of_type_Long, paramWatchVideoRequest.jdField_a_of_type_Boolean, localStoryVideoItem.mCreateTime, true);
        return;
      }
    }
    Dispatchers.get().dispatch(localWatchVideoEvent);
  }
  
  public void a(String paramString, long paramLong)
  {
    a(paramString, paramLong, false);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    WatchVideoRequest localWatchVideoRequest = new WatchVideoRequest();
    localWatchVideoRequest.c = paramString;
    localWatchVideoRequest.jdField_a_of_type_Long = paramLong;
    localWatchVideoRequest.jdField_a_of_type_Boolean = paramBoolean;
    CmdTaskManger.a().a(localWatchVideoRequest, this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\WatchVideoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */