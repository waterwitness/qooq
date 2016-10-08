import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;

public class ojz
  implements Runnable
{
  public ojz(ShowExternalTroopListActivity paramShowExternalTroopListActivity, TextView paramTextView1, TextView paramTextView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.f);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.runOnUiThread(new oka(this, str));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */