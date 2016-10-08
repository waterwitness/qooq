import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iim
  implements UploadObject.UploadFinishListener
{
  public iim(StoryVideoUploadTask paramStoryVideoUploadTask, StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(UploadObject paramUploadObject)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskStoryVideoTaskInfo.j = ((ImageFileObject)paramUploadObject).c;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskStoryVideoUploadTask.a(1, new ErrorMessage());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */