import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.report.QCameraRuntimeReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qyd
  implements DialogInterface.OnClickListener
{
  public qyd(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQCameraActivity.a(this.a).e(4);
    QQCameraActivity.g(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */