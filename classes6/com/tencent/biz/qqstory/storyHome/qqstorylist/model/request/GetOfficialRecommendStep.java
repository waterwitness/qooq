package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.OfficialRecommendListPageLoader;
import com.tencent.biz.qqstory.network.handler.OfficialRecommendListPageLoader.GetOfficialRecommendListEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import isp;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class GetOfficialRecommendStep
  extends PageLoaderStep
{
  public static final String a = "Q.qqstory.home.Repository.GetOfficialRecommendStep";
  protected Repository a;
  
  public GetOfficialRecommendStep(Repository paramRepository)
  {
    super(paramRepository, new OfficialRecommendListPageLoader());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramRepository;
  }
  
  public int a(OfficialRecommendListPageLoader.GetOfficialRecommendListEvent paramGetOfficialRecommendListEvent)
  {
    SLog.b("Q.qqstory.home.Repository.GetOfficialRecommendStep", "receive recent story list data");
    if (paramGetOfficialRecommendListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      SLog.e("Q.qqstory.home.Repository.GetOfficialRecommendStep", "handleRsponed failed:" + paramGetOfficialRecommendListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      ThreadManager.c().post(new isp(this));
      paramGetOfficialRecommendListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg = a();
      return 2;
    }
    if (paramGetOfficialRecommendListEvent.c) {
      this.a.a().clear();
    }
    if ((paramGetOfficialRecommendListEvent.jdField_a_of_type_JavaUtilList != null) && (paramGetOfficialRecommendListEvent.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.a.a().addAll(paramGetOfficialRecommendListEvent.jdField_a_of_type_JavaUtilList);
    }
    if ((!paramGetOfficialRecommendListEvent.jdField_a_of_type_Boolean) && (paramGetOfficialRecommendListEvent.jdField_a_of_type_JavaUtilList != null) && (paramGetOfficialRecommendListEvent.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return 0;
    }
    return 1;
  }
  
  public String a()
  {
    return "GetOfficialRecommendStep";
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository.GetOfficialRecommendStep");
  }
  
  public void a(OfficialRecommendListPageLoader.GetOfficialRecommendListEvent paramGetOfficialRecommendListEvent)
  {
    a(paramGetOfficialRecommendListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
  
  public Class acceptEventClass()
  {
    return OfficialRecommendListPageLoader.GetOfficialRecommendListEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetOfficialRecommendStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */