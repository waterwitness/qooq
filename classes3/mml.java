import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

class mml
  implements DialogInterface.OnClickListener
{
  mml(mmk parammmk, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c)))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_Mmk.a, SubLoginActivity.class);
      paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c);
      paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_Mmk.a.a);
      this.jdField_a_of_type_Mmk.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */