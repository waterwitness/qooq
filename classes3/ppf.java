import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;
import java.util.HashMap;

public class ppf
  extends TroopObserver
{
  public ppf(TroopListAdapter2 paramTroopListAdapter2, TroopActivity paramTroopActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.getString(2131364854), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.getTitleBarHeight());
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
      {
        Switch localSwitch = (Switch)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {
          localSwitch.setChecked(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString));
        }
      }
    }
  }
  
  protected void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_AndroidContentContext).runOnUiThread(new ppg(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ppf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */