import com.tencent.biz.qqstory.base.StoryBoss;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.FutureListener.SimpleFutureListener;
import com.tribe.async.async.JobController.DoneEvent;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class igx
  extends FutureListener.SimpleFutureListener
{
  public igx(StoryBoss paramStoryBoss, Worker paramWorker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFutureDone(Object paramObject)
  {
    Dispatchers.get().dispatch(new JobController.DoneEvent(this.jdField_a_of_type_ComTribeAsyncAsyncWorker));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\igx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */