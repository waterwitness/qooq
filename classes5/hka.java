import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hka
  implements DialogInterface.OnClickListener
{
  public hka(int paramInt, BusinessObserver paramBusinessObserver, Context paramContext, TroopMemberApiClient paramTroopMemberApiClient, long paramLong)
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
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.a(17, false, null);
        paramDialogInterface.dismiss();
        return;
      }
      Utils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, this.jdField_a_of_type_Long, false);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      Utils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, this.jdField_a_of_type_Long, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.a(17, false, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */