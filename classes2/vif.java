import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import java.util.ArrayList;

public class vif
  implements DialogInterface.OnClickListener
{
  public vif(TroopBarReplyActivity paramTroopBarReplyActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    case 6: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.i();
      return;
    case 2: 
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new vig(this), 200L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.b(4);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.h();
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.b(3);
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new vih(this), 200L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */