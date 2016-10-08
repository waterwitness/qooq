import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.widget.QQToast;

public class vad
  implements Runnable
{
  public vad(C2CPicUploadProcessor paramC2CPicUploadProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.a, "WebP格式的图片不支持原图发送，请使用标清质量来发送。", 1).a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */