import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pkw
  implements FMDialogUtil.FMDialogInterface
{
  public pkw(ShortVideoPreviewActivity paramShortVideoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    ShortVideoPreviewActivity.b(this.a);
    this.a.setResult(-1);
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pkw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */