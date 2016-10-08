import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;

class mnr
  implements DialogInterface.OnClickListener
{
  mnr(mnq parammnq, SubAccountControll paramSubAccountControll, Pair paramPair)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountControll.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!SubAccountControll.a(this.jdField_a_of_type_Mnq.a.app))
    {
      this.jdField_a_of_type_Mnq.a.setTitle("");
      SubAccountAssistantForward.a(this.jdField_a_of_type_Mnq.a.app, this.jdField_a_of_type_Mnq.a, null);
    }
    this.jdField_a_of_type_Mnq.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */