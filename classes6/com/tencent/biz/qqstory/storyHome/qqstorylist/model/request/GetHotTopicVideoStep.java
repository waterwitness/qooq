package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.storylist.FirstVideoManager;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.TopicVideoListPagerLoader;
import com.tencent.biz.qqstory.network.handler.TopicVideoListPagerLoader.GetTopicVideoEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class GetHotTopicVideoStep
  extends PageLoaderStep
{
  public static final String a = "Q.qqstory.home.Repository.GetHotTopicVideoStep";
  protected long a;
  protected List a;
  
  public GetHotTopicVideoStep(Repository paramRepository, long paramLong)
  {
    super(paramRepository, new TopicVideoListPagerLoader(paramLong));
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a(TopicVideoListPagerLoader.GetTopicVideoEvent paramGetTopicVideoEvent)
  {
    if ((paramGetTopicVideoEvent == null) || (paramGetTopicVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null))
    {
      SLog.e("Q.qqstory.home.Repository.GetHotTopicVideoStep", "handleRsponed event = null!");
      return 2;
    }
    if (paramGetTopicVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      SLog.e("Q.qqstory.home.Repository.GetHotTopicVideoStep", "handleRsponed mTopicId=" + this.jdField_a_of_type_Long + ", failed:" + paramGetTopicVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      return 2;
    }
    if ((paramGetTopicVideoEvent.jdField_a_of_type_JavaUtilList == null) || (paramGetTopicVideoEvent.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      SLog.b("Q.qqstory.home.Repository.GetHotTopicVideoStep", "handleRsponed mTopicId=" + this.jdField_a_of_type_Long + ", video list is empty!");
      return 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramGetTopicVideoEvent.jdField_a_of_type_JavaUtilList);
    if ((b()) && (!paramGetTopicVideoEvent.jdField_a_of_type_Boolean))
    {
      SLog.b("Q.qqstory.home.Repository.GetHotTopicVideoStep", "handleRsponed mTopicId=" + this.jdField_a_of_type_Long + ", request next page");
      return 0;
    }
    SLog.a("Q.qqstory.home.Repository.GetHotTopicVideoStep", "handleRsponed uid=%d,done , cache video list size = %d", Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    paramGetTopicVideoEvent = (StoryManager)SuperManager.a(5);
    this.jdField_a_of_type_JavaUtilList = paramGetTopicVideoEvent.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilList, true);
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(0);
      ((FirstVideoManager)SuperManager.a(12)).a(IPreloadVideoSource.d, String.valueOf(this.jdField_a_of_type_Long), localStoryVideoItem.mVid);
      ((PreloadVideoSource)paramGetTopicVideoEvent.a()).a(IPreloadVideoSource.d, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaUtilList, true);
    }
    return 1;
  }
  
  public String a()
  {
    return "GetHotTopicVideoStep";
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.Repository.GetHotTopicVideoStep", "topicId=" + this.jdField_a_of_type_Long);
  }
  
  public void a(TopicVideoListPagerLoader.GetTopicVideoEvent paramGetTopicVideoEvent)
  {
    a(paramGetTopicVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
  
  protected boolean a(TopicVideoListPagerLoader.GetTopicVideoEvent paramGetTopicVideoEvent)
  {
    return paramGetTopicVideoEvent.jdField_a_of_type_Long == this.jdField_a_of_type_Long;
  }
  
  public Class acceptEventClass()
  {
    return TopicVideoListPagerLoader.GetTopicVideoEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetHotTopicVideoStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */