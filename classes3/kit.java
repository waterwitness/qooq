import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kit
  implements DialogInterface.OnClickListener
{
  public kit(AddFriendVerifyActivity paramAddFriendVerifyActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */