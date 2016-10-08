import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest;
import com.tencent.biz.qqstory.network.response.PublishStoryVideoRespond;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iiq
  implements CmdTaskManger.CommandCallback
{
  public iiq(StoryVideoUploadTask paramStoryVideoUploadTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PublishStoryVideoRequest paramPublishStoryVideoRequest, PublishStoryVideoRespond paramPublishStoryVideoRespond, ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramPublishStoryVideoRespond == null))
    {
      this.a.a(6, paramErrorMessage);
      SLog.d("Q.qqstory.publish:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.a });
      return;
    }
    ((StoryVideoTaskInfo)this.a.a).d = (paramPublishStoryVideoRespond.a * 1000L);
    this.a.d();
    SLog.d("Q.qqstory.publish:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.a });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iiq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */