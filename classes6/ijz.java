import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.GetHotTopicListHandler;
import com.tencent.biz.qqstory.network.handler.GetHotTopicListHandler.HotTopicListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class ijz
  extends SimpleJob
{
  public ijz(GetHotTopicListHandler paramGetHotTopicListHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object a(JobContext paramJobContext, Void... paramVarArgs)
  {
    paramJobContext = new GetHotTopicListHandler.HotTopicListEvent(this.a, new ErrorMessage());
    paramJobContext.a = ((StoryManager)SuperManager.a(5)).a();
    paramJobContext.b = true;
    Dispatchers.get().dispatch(paramJobContext);
    SLog.a("Q.qqstory.home.hot.GetHotTopicListHandler", "get hot topic from cache %s", paramJobContext);
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */