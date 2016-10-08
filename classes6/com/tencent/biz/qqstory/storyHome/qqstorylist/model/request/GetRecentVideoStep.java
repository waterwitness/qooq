package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.storylist.FirstVideoManager;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.UserClickManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.UserVideoListPagerLoader;
import com.tencent.biz.qqstory.network.handler.UserVideoListPagerLoader.GetStoryVideoListEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class GetRecentVideoStep
  extends PageLoaderStep
{
  public static final String a = "Q.qqstory.home.Repository,GetRecentVideoStep";
  protected long a;
  protected List a;
  
  public GetRecentVideoStep(Repository paramRepository, long paramLong)
  {
    super(paramRepository, new UserVideoListPagerLoader(paramLong, 3));
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a(UserVideoListPagerLoader.GetStoryVideoListEvent paramGetStoryVideoListEvent)
  {
    if ((paramGetStoryVideoListEvent == null) || (paramGetStoryVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null))
    {
      SLog.e("Q.qqstory.home.Repository,GetRecentVideoStep", "handleRsponed event = null!");
      return 2;
    }
    if (paramGetStoryVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      SLog.e("Q.qqstory.home.Repository,GetRecentVideoStep", "handleRsponed uid=" + paramGetStoryVideoListEvent.jdField_a_of_type_Long + ", failed:" + paramGetStoryVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      return 2;
    }
    if ((paramGetStoryVideoListEvent.jdField_a_of_type_JavaUtilList == null) || (paramGetStoryVideoListEvent.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      SLog.b("Q.qqstory.home.Repository,GetRecentVideoStep", "handleRsponed uid=" + paramGetStoryVideoListEvent.jdField_a_of_type_Long + ", video list is empty!");
      return 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramGetStoryVideoListEvent.jdField_a_of_type_JavaUtilList);
    if ((b()) && (!paramGetStoryVideoListEvent.jdField_a_of_type_Boolean))
    {
      SLog.b("Q.qqstory.home.Repository,GetRecentVideoStep", "handleRsponed uid=" + paramGetStoryVideoListEvent.jdField_a_of_type_Long + ", request next page");
      return 0;
    }
    SLog.a("Q.qqstory.home.Repository,GetRecentVideoStep", "handleRsponed uid=%d,done , cache video list size = %d", Long.valueOf(paramGetStoryVideoListEvent.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    paramGetStoryVideoListEvent = (StoryManager)SuperManager.a(5);
    this.jdField_a_of_type_JavaUtilList = paramGetStoryVideoListEvent.a(this.jdField_a_of_type_Long, 1, this.jdField_a_of_type_JavaUtilList, true);
    Object localObject = paramGetStoryVideoListEvent.a(this.jdField_a_of_type_Long, 1);
    if (localObject != null)
    {
      ((StoryItem)localObject).unReadCount = paramGetStoryVideoListEvent.d(this.jdField_a_of_type_Long).size();
      paramGetStoryVideoListEvent.a(this.jdField_a_of_type_Long, 1, (StoryItem)localObject);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localObject = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(0);
      ((FirstVideoManager)SuperManager.a(12)).a(IPreloadVideoSource.a, String.valueOf(this.jdField_a_of_type_Long), ((StoryVideoItem)localObject).mVid);
      ((PreloadVideoSource)paramGetStoryVideoListEvent.a()).a(IPreloadVideoSource.a, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaUtilList, true);
    }
    paramGetStoryVideoListEvent.a().a().b(IPreloadVideoSource.a, String.valueOf(this.jdField_a_of_type_Long));
    return 1;
  }
  
  public String a()
  {
    return "GetRecentVideoStep";
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.Repository,GetRecentVideoStep", "uin=" + this.jdField_a_of_type_Long);
  }
  
  public void a(UserVideoListPagerLoader.GetStoryVideoListEvent paramGetStoryVideoListEvent)
  {
    a(paramGetStoryVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
  
  protected boolean a(UserVideoListPagerLoader.GetStoryVideoListEvent paramGetStoryVideoListEvent)
  {
    if ((this.jdField_a_of_type_Long == paramGetStoryVideoListEvent.jdField_a_of_type_Long) && (paramGetStoryVideoListEvent.b == 3)) {
      return true;
    }
    SLog.d("Q.qqstory.home.Repository,GetRecentVideoStep", "uin not equal , my uin = " + this.jdField_a_of_type_Long + " , pass uin = " + paramGetStoryVideoListEvent.jdField_a_of_type_Long);
    return false;
  }
  
  public Class acceptEventClass()
  {
    return UserVideoListPagerLoader.GetStoryVideoListEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetRecentVideoStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */