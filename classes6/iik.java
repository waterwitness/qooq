import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.reactive.SimpleObserver;

public class iik
  extends SimpleObserver
{
  private iik(BasePublishTask paramBasePublishTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      BasePublishTask.b(this.a);
      return;
    }
    this.a.a(3, paramErrorMessage);
  }
  
  public void onCancel() {}
  
  public void onComplete() {}
  
  public void onError(Error paramError)
  {
    if ((paramError instanceof ErrorMessage))
    {
      this.a.a(3, (ErrorMessage)paramError);
      return;
    }
    this.a.a(3, new ErrorMessage(940005, "upload file fail:" + paramError));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */