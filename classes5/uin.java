import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;

public class uin
  implements DialogInterface.OnClickListener
{
  public uin(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditActivity.b(this.a);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */