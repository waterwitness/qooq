import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryConfigManager.StoryConfigEvent;
import com.tencent.biz.qqstory.network.request.PublishConfigRequest;
import com.tencent.biz.qqstory.network.response.PublishConfigResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class ijm
  implements CmdTaskManger.CommandCallback
{
  public ijm(StoryConfigManager paramStoryConfigManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PublishConfigRequest paramPublishConfigRequest, PublishConfigResponse paramPublishConfigResponse, ErrorMessage paramErrorMessage)
  {
    if (paramPublishConfigResponse != null)
    {
      this.a.b("show_now_entry", Boolean.valueOf(paramPublishConfigResponse.a));
      this.a.b("publish_picture", Boolean.valueOf(paramPublishConfigResponse.b));
      if (paramPublishConfigResponse.c) {
        this.a.b("first_time_pic", Boolean.valueOf(paramPublishConfigResponse.c));
      }
    }
    Dispatchers.get().dispatch(new StoryConfigManager.StoryConfigEvent());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */