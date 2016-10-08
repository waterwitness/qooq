import android.view.View;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Set;

public class omh
  implements AdapterView.OnItemClickListener
{
  public omh(C2CMessageSearchDialog paramC2CMessageSearchDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(C2CMessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onItemClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return;
      paramAdapterView = (MessageItem)this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.i(C2CMessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onItemClick, mRecordCount = " + this.a.j + ",needSearchInCloud:" + this.a.b);
    }
    boolean bool1;
    boolean bool2;
    if (this.a.b)
    {
      bool1 = C2CMessageSearchDialog.a(this.a).contains(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq));
      bool2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a.contains(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq));
      if ((!bool1) || (!bool2)) {
        break label258;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC5", "0X8005FC5", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.a(true);
      this.a.dismiss();
      return;
      label258:
      if (bool1) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC4", "0X8005FC4", 0, 0, "", "", "", "");
      } else if (bool2) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC3", "0X8005FC3", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\omh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */