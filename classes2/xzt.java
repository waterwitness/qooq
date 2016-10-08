import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BUploadFileActivity;

public class xzt
  implements DialogInterface.OnCancelListener
{
  public xzt(C2BUploadFileActivity paramC2BUploadFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */