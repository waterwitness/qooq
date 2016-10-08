import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.downloadnew.MyAppDialog;

public class wsv
  implements Runnable
{
  public wsv(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Resources localResources = this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity.getResources();
    MyAppDialog localMyAppDialog = new MyAppDialog(this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity);
    localMyAppDialog.a(2131363032, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, true);
    localMyAppDialog.b(2131363033, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, true);
    localMyAppDialog.a(localResources.getString(2131363023));
    localMyAppDialog.b(localResources.getString(2131363034));
    localMyAppDialog.setCancelable(false);
    localMyAppDialog.setOnDismissListener(new wsw(this));
    if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity != null) && (!this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity.isFinishing())) {
      localMyAppDialog.show();
    }
    this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog = localMyAppDialog;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */