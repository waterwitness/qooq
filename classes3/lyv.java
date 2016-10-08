import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lyv
  implements View.OnClickListener
{
  public lyv(PayBridgeActivity paramPayBridgeActivity, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297844: 
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      paramView = QWalletPushManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity.a);
      PayBridgeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity, paramView);
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    QWalletPushManager.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */