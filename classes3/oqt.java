import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oqt
  implements DialogInterface.OnCancelListener
{
  public oqt(CameraPreviewActivity paramCameraPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */