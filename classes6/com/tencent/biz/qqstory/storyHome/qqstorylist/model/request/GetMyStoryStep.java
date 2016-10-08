package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.storylist.FirstVideoManager;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.UserVideoListPagerLoader;
import com.tencent.biz.qqstory.network.handler.UserVideoListPagerLoader.GetStoryVideoListEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

public class GetMyStoryStep
  extends PageLoaderStep
{
  public static final String a = "Q.qqstory.home.Repository.GetMyStoryStep";
  protected long a;
  protected Repository a;
  
  public GetMyStoryStep(Repository paramRepository)
  {
    super(paramRepository, new UserVideoListPagerLoader(QQStoryContext.a().a(), 2));
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
    this.jdField_a_of_type_Long = QQStoryContext.a().a();
  }
  
  private void b(UserVideoListPagerLoader.GetStoryVideoListEvent paramGetStoryVideoListEvent) {}
  
  public int a(UserVideoListPagerLoader.GetStoryVideoListEvent paramGetStoryVideoListEvent)
  {
    SLog.b("Q.qqstory.home.Repository.GetMyStoryStep", "receive my story list data");
    if (paramGetStoryVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      SLog.e("Q.qqstory.home.Repository.GetMyStoryStep", "handleGetStoryVideoListEvent uid=" + paramGetStoryVideoListEvent.jdField_a_of_type_Long + ", failed:" + paramGetStoryVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      ThreadManager.c().post(new iso(this));
      paramGetStoryVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg = a();
      return 2;
    }
    if (paramGetStoryVideoListEvent.jdField_a_of_type_Long == 0L)
    {
      SLog.e("Q.qqstory.home.Repository.GetMyStoryStep", "receive my story uid is 0!");
      paramGetStoryVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg = a();
      return 2;
    }
    if (paramGetStoryVideoListEvent.jdField_a_of_type_Long == QQStoryContext.a().a())
    {
      if (paramGetStoryVideoListEvent.c) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a().a();
      }
      if ((paramGetStoryVideoListEvent.jdField_a_of_type_JavaUtilList != null) && (paramGetStoryVideoListEvent.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a().a(paramGetStoryVideoListEvent.jdField_a_of_type_JavaUtilList);
      }
      if ((b()) && (!paramGetStoryVideoListEvent.jdField_a_of_type_Boolean) && (paramGetStoryVideoListEvent.jdField_a_of_type_JavaUtilList != null) && (paramGetStoryVideoListEvent.jdField_a_of_type_JavaUtilList.size() > 0)) {
        return 0;
      }
      Collections.sort(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a().a());
      Object localObject = ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_Long, 0, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a().a(), true);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a().a();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a().a((List)localObject);
      localObject = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a().a());
      Collections.reverse((List)localObject);
      ((StoryManager)SuperManager.a(5)).a().a(IPreloadVideoSource.c, String.valueOf(paramGetStoryVideoListEvent.jdField_a_of_type_Long), (List)localObject, true);
      if (((List)localObject).size() > 0)
      {
        paramGetStoryVideoListEvent = (StoryVideoItem)((List)localObject).get(0);
        ((FirstVideoManager)SuperManager.a(12)).a(IPreloadVideoSource.c, String.valueOf(this.jdField_a_of_type_Long), paramGetStoryVideoListEvent.mVid);
      }
      SLog.d("Q.qqstory.home.Repository.GetMyStoryStep", "receive rsponed count = %s ", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a().a()) });
      return 1;
    }
    b(paramGetStoryVideoListEvent);
    return 1;
  }
  
  public String a()
  {
    return "GetMyStoryStep";
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository.GetMyStoryStep");
  }
  
  public void a(UserVideoListPagerLoader.GetStoryVideoListEvent paramGetStoryVideoListEvent)
  {
    a(paramGetStoryVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
  
  public Class acceptEventClass()
  {
    return UserVideoListPagerLoader.GetStoryVideoListEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetMyStoryStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */