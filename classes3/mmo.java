import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.SimpleAccount;

class mmo
  implements Runnable
{
  mmo(mmn parammmn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_Mmm.a.a();
    this.a.jdField_a_of_type_Mmm.a.a(this.a.jdField_a_of_type_Mmm.a.getString(2131370540));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Mmm.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    localIntent.putExtra("fromWhere", this.a.jdField_a_of_type_Mmm.a.a);
    this.a.jdField_a_of_type_Mmm.a.startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */