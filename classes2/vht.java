import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarPublishBarSelectActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishBarSelectActivity.MyBarListAdapter;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;

public class vht
  implements DialogInterface.OnClickListener
{
  public vht(TroopBarPublishBarSelectActivity paramTroopBarPublishBarSelectActivity, TroopBarMyBar paramTroopBarMyBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter.notifyDataSetChanged();
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("key_selected_item", this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar);
    paramDialogInterface.putExtra("key_drop_media_data", this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.b);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */