import com.tencent.biz.qqstory.network.handler.GetStoryDesHandler.GetStoryDesListEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetStoryDesHandlerStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.FinishCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class isv
  implements Runnable
{
  public isv(GetStoryDesHandlerStep paramGetStoryDesHandlerStep, GetStoryDesHandler.GetStoryDesListEvent paramGetStoryDesListEvent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetStoryDesHandlerStep.d = 2;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetStoryDesHandlerStep.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetStoryDesHandler$GetStoryDesListEvent);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetStoryDesHandlerStep);
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetStoryDesHandlerStep.jdField_a_of_type_Long;
    SLog.a("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "finish %s step and cost time=%d", getClass().getSimpleName(), Long.valueOf(l1 - l2));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetStoryDesHandlerStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetStoryDesHandlerStep.a());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */