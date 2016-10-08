import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.qphone.base.util.QLog;

public class nav
  implements Runnable
{
  public nav(VisitorsActivity paramVisitorsActivity, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, "updateCardProfileFromDb uin:" + this.jdField_a_of_type_Long);
    }
    CardProfile localCardProfile2 = VoteUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, this.jdField_a_of_type_Long, 2);
    CardProfile localCardProfile1 = localCardProfile2;
    if (localCardProfile2 == null) {
      localCardProfile1 = VoteUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, this.jdField_a_of_type_Long, 3);
    }
    if (localCardProfile1 != null)
    {
      localCardProfile1.updateTime(System.currentTimeMillis() / 1000L);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a.obtainMessage(8, localCardProfile1).sendToTarget();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */