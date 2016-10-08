import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnDismissListener;
import cooperation.c2b.C2BUploadImageActivity;

public class xzw
  implements ActionSheet.OnDismissListener
{
  public xzw(C2BUploadImageActivity paramC2BUploadImageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    if (this.a.c) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */