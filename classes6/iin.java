import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.GenerateVideoSegment;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iin
  implements UploadObject.UploadFinishListener
{
  public iin(StoryVideoUploadTask paramStoryVideoUploadTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(UploadObject paramUploadObject)
  {
    paramUploadObject = (GenerateVideoSegment)paramUploadObject;
    ((StoryVideoTaskInfo)this.a.a).a = paramUploadObject.c;
    if (paramUploadObject.a > 0L)
    {
      SLog.a("Q.qqstory.publish:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((StoryVideoTaskInfo)this.a.a).b), Long.valueOf(paramUploadObject.a));
      ((StoryVideoTaskInfo)this.a.a).b = paramUploadObject.a;
    }
    SLog.a("Q.qqstory.publish:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((StoryVideoTaskInfo)this.a.a).a(), Long.valueOf(((StoryVideoTaskInfo)this.a.a).b), ((StoryVideoTaskInfo)this.a.a).a);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */