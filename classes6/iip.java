import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iip
  implements UploadObject.UploadFinishListener
{
  public iip(StoryVideoUploadTask paramStoryVideoUploadTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(UploadObject paramUploadObject)
  {
    ((StoryVideoTaskInfo)this.a.a).k = ((ImageFileObject)paramUploadObject).c;
    SLog.b("Q.qqstory.publish:StoryVideoUploadTask", "make video thumbnail finish:%s", ((StoryVideoTaskInfo)this.a.a).k);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */