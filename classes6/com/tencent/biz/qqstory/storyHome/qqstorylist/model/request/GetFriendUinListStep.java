package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.StoryUinListPageLoader;
import com.tencent.biz.qqstory.network.handler.StoryUinListPageLoader.GetStoryUinListEvent;
import com.tencent.biz.qqstory.network.request.GetStoryUinListRequest;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import isj;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class GetFriendUinListStep
  extends PageLoaderStep
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qqstory.home.Repository.GetFriendUinListStep";
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  protected Repository a;
  protected StepExector a;
  public ArrayList a;
  private final int i = ((StoryUinListPageLoader)this.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader).b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetFriendUinListStep(Repository paramRepository)
  {
    super(paramRepository, new StoryUinListPageLoader(StoryListUtils.a(), jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet()));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a(StoryUinListPageLoader.GetStoryUinListEvent paramGetStoryUinListEvent)
  {
    SLog.b("Q.qqstory.home.Repository.GetFriendUinListStep", "receive friend uin list data");
    if (paramGetStoryUinListEvent == null)
    {
      SLog.e("Q.qqstory.home.Repository.GetFriendUinListStep", "handleRecentStoryListEvent event is null!");
      return 2;
    }
    if (paramGetStoryUinListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      SLog.e("Q.qqstory.home.Repository.GetFriendUinListStep", "handleRecentStoryListEvent failed:" + paramGetStoryUinListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      ThreadManager.c().post(new isj(this));
      return 2;
    }
    if (paramGetStoryUinListEvent.c)
    {
      SLog.d("Q.qqstory.home.Repository.GetFriendUinListStep", "it is frist page!");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.f();
    }
    if ((paramGetStoryUinListEvent.jdField_a_of_type_JavaUtilList != null) && (paramGetStoryUinListEvent.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramGetStoryUinListEvent.jdField_a_of_type_JavaUtilList);
    }
    if ((!paramGetStoryUinListEvent.jdField_a_of_type_Boolean) && (paramGetStoryUinListEvent.jdField_a_of_type_JavaUtilList != null) && (paramGetStoryUinListEvent.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return 0;
    }
    a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.f.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.f.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    SLog.d("Q.qqstory.home.Repository.GetFriendUinListStep", "handleRsponed receive uinList size = " + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.f.size());
    return 1;
  }
  
  public String a()
  {
    return "GetFriendUinListStep";
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository.GetFriendUinListStep,uin size= " + this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  public void a(StoryUinListPageLoader.GetStoryUinListEvent paramGetStoryUinListEvent)
  {
    a(paramGetStoryUinListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
  
  protected boolean a(StoryUinListPageLoader.GetStoryUinListEvent paramGetStoryUinListEvent)
  {
    if (paramGetStoryUinListEvent.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestGetStoryUinListRequest.a == this.i)
    {
      if (paramGetStoryUinListEvent.jdField_a_of_type_JavaUtilList == null)
      {
        SLog.b("Q.qqstory.home.Repository.GetFriendUinListStep", "receive event GetFriendUinListStep[" + System.identityHashCode(this) + "], event = " + paramGetStoryUinListEvent + ", uin list size = 0!");
        return true;
      }
      SLog.b("Q.qqstory.home.Repository.GetFriendUinListStep", "receive event GetFriendUinListStep[" + System.identityHashCode(this) + "], event = " + paramGetStoryUinListEvent + ", uin list size = " + paramGetStoryUinListEvent.jdField_a_of_type_JavaUtilList.size());
      return true;
    }
    SLog.d("Q.qqstory.home.Repository.GetFriendUinListStep", "ignore event GetFriendUinListStep[" + System.identityHashCode(this) + "], event cookie = " + paramGetStoryUinListEvent.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestGetStoryUinListRequest.a + ", self cookie = " + this.i);
    return false;
  }
  
  public Class acceptEventClass()
  {
    return StoryUinListPageLoader.GetStoryUinListEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetFriendUinListStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */