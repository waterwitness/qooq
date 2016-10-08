import android.app.Activity;
import com.tencent.mobileqq.activity.UpgradeTipsDialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qoe
  implements Runnable
{
  public qoe(UpgradeController paramUpgradeController, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    new UpgradeTipsDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController), null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qoe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */