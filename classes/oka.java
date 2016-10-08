import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class oka
  implements Runnable
{
  oka(ojz paramojz, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Ojz.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Ojz.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Ojz.b.setText("我的群标签");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Ojz.b.setText("他的群标签");
        if (this.jdField_a_of_type_Ojz.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.g == null) {
          break;
        }
        localObject = this.jdField_a_of_type_Ojz.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_Ojz.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.g, this.jdField_a_of_type_Ojz.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.f);
      } while (localObject == null);
      if (((TroopMemberCard)localObject).sex == 1) {
        this.jdField_a_of_type_Ojz.b.setText("她的群标签");
      }
      this.jdField_a_of_type_Ojz.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopMemberCard)localObject).nick);
      return;
      localObject = ((FriendsManager)this.jdField_a_of_type_Ojz.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.app.getManager(50)).a(this.jdField_a_of_type_Ojz.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.f);
    } while ((localObject == null) || (((Card)localObject).shGender != 1));
    this.jdField_a_of_type_Ojz.b.setText("她的群标签");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */