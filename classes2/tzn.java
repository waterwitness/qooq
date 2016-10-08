import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;

public class tzn
  implements Runnable
{
  public tzn(QCallDetailActivity paramQCallDetailActivity, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).jdField_a_of_type_JavaUtilList.clear();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).jdField_a_of_type_JavaUtilList.clear();
      int i = 20;
      int k = 0;
      while ((k < i) && (k < this.jdField_a_of_type_JavaUtilList.size()))
      {
        int j = i;
        if ((this.jdField_a_of_type_JavaUtilList.get(k) instanceof QCallRecord))
        {
          j = i;
          if (((QCallRecord)this.jdField_a_of_type_JavaUtilList.get(k)).type == QCallRecord.TYPE_DATE) {
            j = i + 1;
          }
          QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).jdField_a_of_type_JavaUtilList.add((QCallRecord)this.jdField_a_of_type_JavaUtilList.get(k));
        }
        k += 1;
        i = j;
      }
    }
    if (QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).jdField_a_of_type_JavaUtilList.size() == 0) {
      QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, true);
    }
    for (;;)
    {
      QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).notifyDataSetChanged();
      return;
      QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */