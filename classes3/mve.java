import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

class mve
  implements Runnable
{
  mve(mvd parammvd, TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Mvd.jdField_a_of_type_Mvb.a.a(this.jdField_a_of_type_Mvd.jdField_a_of_type_JavaLangString);
    synchronized (this.jdField_a_of_type_Mvd.jdField_a_of_type_Mvb.a.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_Mvd.jdField_a_of_type_Mvb.a.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember);
      this.jdField_a_of_type_Mvd.jdField_a_of_type_Mvb.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */