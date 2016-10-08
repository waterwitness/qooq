import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;

public class mnm
  implements DialogInterface.OnClickListener
{
  public mnm(SubAccountMessageActivity paramSubAccountMessageActivity, SubAccountControll paramSubAccountControll, Pair paramPair)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountControll.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.setTitle("");
      SubAccountAssistantForward.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */