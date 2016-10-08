import com.tencent.mobileqq.activity.qqcard.QQCardActivity;
import com.tencent.mobileqq.activity.qqcard.QQCardManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class osv
  implements Runnable
{
  public osv(QQCardActivity paramQQCardActivity, List paramList, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = QQCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity).a(this.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "handleChange, result = " + bool);
    }
    if (bool) {
      QQCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity).a("qqcard_sequence_631", this.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */