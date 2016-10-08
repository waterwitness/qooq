import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rnf
  implements DialogInterface.OnClickListener
{
  public rnf(FMActivity paramFMActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.setResult(8001);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rnf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */