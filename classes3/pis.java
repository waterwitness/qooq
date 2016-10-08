import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pis
  implements Runnable
{
  pis(pir parampir, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame", 2, "read troop members from database after updating data from server");
      }
      this.jdField_a_of_type_Pir.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences("last_update_time" + this.jdField_a_of_type_Pir.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putLong("key_last_update_time" + this.jdField_a_of_type_Pir.a.b, System.currentTimeMillis()).commit();
      TroopMemberListInnerFrame.a(this.jdField_a_of_type_Pir.a, this.jdField_a_of_type_Pir.a.b, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */