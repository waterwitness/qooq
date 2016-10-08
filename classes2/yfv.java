import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class yfv
  implements DialogInterface.OnClickListener
{
  public yfv(DatalineRemoteManager paramDatalineRemoteManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b = true;
    DatalineRemoteManager.a(this.a, 1);
    DatalineRemoteManager.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */