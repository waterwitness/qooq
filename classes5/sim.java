import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class sim
  implements DialogInterface.OnClickListener
{
  public sim(FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b();
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */