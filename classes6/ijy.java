import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.GetHotTopicListHandler;
import com.tencent.biz.qqstory.network.handler.GetHotTopicListHandler.HotTopicListEvent;
import com.tencent.biz.qqstory.network.request.GetHotTopicListRequest;
import com.tencent.biz.qqstory.network.response.GetHotTopicListRespond;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class ijy
  implements CmdTaskManger.CommandCallback
{
  public ijy(GetHotTopicListHandler paramGetHotTopicListHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GetHotTopicListRequest paramGetHotTopicListRequest, GetHotTopicListRespond paramGetHotTopicListRespond, ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.home.hot.GetHotTopicListHandler", "get hot topic return %s", paramErrorMessage);
    paramGetHotTopicListRequest = new GetHotTopicListHandler.HotTopicListEvent(this.a, paramErrorMessage);
    if ((paramErrorMessage.isFail()) || (paramGetHotTopicListRespond == null))
    {
      Dispatchers.get().dispatch(paramGetHotTopicListRequest);
      return;
    }
    ((StoryManager)SuperManager.a(5)).a(paramGetHotTopicListRespond.a);
    paramGetHotTopicListRequest.a = paramGetHotTopicListRespond.a;
    Dispatchers.get().dispatch(paramGetHotTopicListRequest);
    SLog.a("Q.qqstory.home.hot.GetHotTopicListHandler", "get hot topic from network %s", paramGetHotTopicListRequest);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */