import com.tencent.biz.qqstory.network.handler.GetPreloadVideoHandler.GetPreloadVideoEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetPreloadVideoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.FinishCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class isq
  implements Runnable
{
  public isq(GetPreloadVideoStep paramGetPreloadVideoStep, GetPreloadVideoHandler.GetPreloadVideoEvent paramGetPreloadVideoEvent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository.GetPreloadVideoStepcategory=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetPreloadVideoStep.b + ",is finish!");
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetPreloadVideoStep);
    GetPreloadVideoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetPreloadVideoStep, this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetPreloadVideoHandler$GetPreloadVideoEvent);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetPreloadVideoStep.a.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetPreloadVideoStep.a());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */