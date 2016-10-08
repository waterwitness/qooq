import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity;

public class uzb
  implements DialogInterface.OnCancelListener
{
  public uzb(ShareDumpMemoryActivity paramShareDumpMemoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */