package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.handler.RecentStoryListPagerLoader;
import com.tencent.biz.qqstory.network.handler.RecentStoryListPagerLoader.GetRecentStoryListEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import iss;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class GetRecentStroyStep
  extends PageLoaderStep
{
  public static final String a = "Q.qqstory.home.Repository,GetRecentStroyStep";
  protected Repository a;
  
  public GetRecentStroyStep(Repository paramRepository)
  {
    super(paramRepository, new RecentStoryListPagerLoader());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramRepository;
  }
  
  public int a(RecentStoryListPagerLoader.GetRecentStoryListEvent paramGetRecentStoryListEvent)
  {
    int i = 0;
    SLog.b("Q.qqstory.home.Repository,GetRecentStroyStep", "receive recent story list data");
    if (paramGetRecentStoryListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      SLog.e("Q.qqstory.home.Repository,GetRecentStroyStep", "handleRecentStoryListEvent failed:" + paramGetRecentStoryListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      ThreadManager.c().post(new iss(this));
      paramGetRecentStoryListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg = a();
      i = 2;
    }
    do
    {
      return i;
      if (paramGetRecentStoryListEvent.c) {
        this.a.e();
      }
      if ((paramGetRecentStoryListEvent.jdField_a_of_type_JavaUtilList != null) && (paramGetRecentStoryListEvent.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Iterator localIterator = paramGetRecentStoryListEvent.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          StoryItem localStoryItem = (StoryItem)localIterator.next();
          if (localStoryItem.unReadCount > 0) {
            this.a.a(localStoryItem);
          }
        }
      }
    } while ((!paramGetRecentStoryListEvent.jdField_a_of_type_Boolean) && (paramGetRecentStoryListEvent.jdField_a_of_type_JavaUtilList != null) && (paramGetRecentStoryListEvent.jdField_a_of_type_JavaUtilList.size() > 0));
    paramGetRecentStoryListEvent = new ArrayList(this.a.b().size());
    i = 0;
    while (i < this.a.b().size())
    {
      if (((StoryItem)this.a.b().get(i)).user != null) {
        paramGetRecentStoryListEvent.add(String.valueOf(((StoryItem)this.a.b().get(i)).user.uid));
      }
      i += 1;
    }
    ((StoryManager)SuperManager.a(5)).a().a(IPreloadVideoSource.a, paramGetRecentStoryListEvent);
    ((StoryConfigManager)SuperManager.a(10)).b("recent_story_refresh_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    SLog.d("Q.qqstory.home.Repository,GetRecentStroyStep", "receive recent story count=%s", new Object[] { Integer.valueOf(this.a.b().size()) });
    return 1;
  }
  
  public String a()
  {
    return "GetRecentStroyStep";
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository,GetRecentStroyStep");
  }
  
  public void a(RecentStoryListPagerLoader.GetRecentStoryListEvent paramGetRecentStoryListEvent)
  {
    a(paramGetRecentStoryListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
  
  public Class acceptEventClass()
  {
    return RecentStoryListPagerLoader.GetRecentStoryListEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetRecentStroyStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */