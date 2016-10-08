import com.tencent.biz.qqstory.network.handler.GetHotTopicListHandler.HotTopicListEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetHotTopicListStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.FinishCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class ism
  implements Runnable
{
  public ism(GetHotTopicListStep paramGetHotTopicListStep, GetHotTopicListHandler.HotTopicListEvent paramHotTopicListEvent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetHotTopicListStep);
    GetHotTopicListStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetHotTopicListStep, this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotTopicListHandler$HotTopicListEvent);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetHotTopicListStep.a.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetHotTopicListStep.a());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */