import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class orj
  implements DialogInterface.OnClickListener
{
  public orj(PhotoListActivity paramPhotoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.setResult(8001);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */