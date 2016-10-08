import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.VideoUploadHelper.UploadResult;
import com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.reactive.SimpleObserver;

public class iii
  extends SimpleObserver
{
  private iii(StoryVideoFileObject paramStoryVideoFileObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(VideoUploadHelper.UploadResult paramUploadResult)
  {
    this.a.a = paramUploadResult;
    StoryVideoFileObject.a(this.a);
    if (paramUploadResult.a.isSuccess())
    {
      StoryVideoFileObject.a(this.a, new ErrorMessage());
      return;
    }
    StoryVideoFileObject.b(this.a, paramUploadResult.a);
  }
  
  public void onComplete() {}
  
  public void onError(Error paramError)
  {
    StoryVideoFileObject.a(this.a, paramError);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */