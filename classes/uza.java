import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity;

public class uza
  implements View.OnClickListener
{
  public uza(ShareDumpMemoryActivity paramShareDumpMemoryActivity, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity.b();
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */