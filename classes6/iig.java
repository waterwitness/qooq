import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.job.FileUploadRspData;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.reactive.SimpleObserver;

public class iig
  extends SimpleObserver
{
  private iig(ImageFileObject paramImageFileObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(FileUploadRspData paramFileUploadRspData)
  {
    if (paramFileUploadRspData.a == 0)
    {
      this.a.c = paramFileUploadRspData.h;
      ImageFileObject.a(this.a);
      ImageFileObject.a(this.a, new ErrorMessage());
      return;
    }
    onError(new ErrorMessage(paramFileUploadRspData.a, "upload image fail"));
  }
  
  public void onComplete() {}
  
  public void onError(Error paramError)
  {
    ImageFileObject.a(this.a, paramError);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */