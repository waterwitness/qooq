import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pgx
  implements ChatActivityUtils.StartVideoListener
{
  public pgx(SelectMemberActivity paramSelectMemberActivity, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.S = 2;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */