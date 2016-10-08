import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqi
  implements DialogInterface.OnDismissListener
{
  public lqi(LbsBaseActivity paramLbsBaseActivity, Runnable paramRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */