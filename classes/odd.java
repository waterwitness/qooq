import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class odd
  implements DialogInterface.OnClickListener
{
  public odd(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.jdField_a_of_type_AndroidContentContext, TroopLowCreditLevelNotifyActivity.class);
    paramDialogInterface.putExtra("troopUin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */