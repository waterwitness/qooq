import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.pgc.ShareUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ild
  implements DialogInterface.OnDismissListener
{
  public ild(ShareUtil paramShareUtil, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener.onDismiss(paramDialogInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.a = false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */