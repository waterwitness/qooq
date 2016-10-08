import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.VideoUploadHelper.UploadResult;
import com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iio
  implements UploadObject.UploadFinishListener
{
  public iio(StoryVideoUploadTask paramStoryVideoUploadTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(UploadObject paramUploadObject)
  {
    paramUploadObject = (StoryVideoFileObject)paramUploadObject;
    ((StoryVideoTaskInfo)this.a.a).h = paramUploadObject.a.jdField_a_of_type_JavaLangString;
    ((StoryVideoTaskInfo)this.a.a).i = paramUploadObject.a.c;
    ((StoryVideoTaskInfo)this.a.a).g = paramUploadObject.a.d;
    if (paramUploadObject.a.jdField_a_of_type_Int < ((StoryVideoTaskInfo)this.a.a).e) {
      SLog.d("Q.qqstory.publish:StoryVideoUploadTask", "upload back from %d to %d", new Object[] { Integer.valueOf(((StoryVideoTaskInfo)this.a.a).e), Integer.valueOf(((StoryVideoTaskInfo)this.a.a).e) });
    }
    ((StoryVideoTaskInfo)this.a.a).e = paramUploadObject.a.jdField_a_of_type_Int;
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */