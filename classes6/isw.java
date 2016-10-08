import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.PageLoaderStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.FinishCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;

public class isw
  implements Runnable
{
  public isw(PageLoaderStep paramPageLoaderStep, Dispatcher.Dispatchable paramDispatchable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SLog.b("Q.qqstory.home.qqstory_step", "finish step plz reference below dump");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.g = 2;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.a(this.jdField_a_of_type_ComTribeAsyncDispatchDispatcher$Dispatchable);
    if ((i == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.b()))
    {
      PageLoaderStep localPageLoaderStep = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep;
      localPageLoaderStep.h -= 1;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader.c();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.g = 1;
    }
    do
    {
      return;
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.a(this.jdField_a_of_type_ComTribeAsyncDispatchDispatcher$Dispatchable);
        Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep);
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.b;
      SLog.b("Q.qqstory.home.Repository.PageLoaderStep", "finish " + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.a() + " step and cost time=" + (l1 - l2));
      SLog.a("Q.qqstory.home.Repository.PageLoaderStep", "unRegisterSubscriber %s", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep);
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep);
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack == null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestPageLoaderStep.a());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */