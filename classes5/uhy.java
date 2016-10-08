import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;

public class uhy
  implements DialogInterface.OnClickListener
{
  public uhy(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(3, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */