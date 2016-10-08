import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lhq
  implements DialogInterface.OnClickListener
{
  public lhq(EditTagActivity paramEditTagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */