import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qyh
  implements DialogInterface.OnClickListener
{
  public qyh(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQCameraActivity.g(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */