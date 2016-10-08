import com.dataline.activities.PrinterSubOptionActivity;
import com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class ch
  extends DataLineObserver
{
  public ch(PrinterSubOptionActivity paramPrinterSubOptionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b()
  {
    this.a.jdField_a_of_type_JavaLangString = this.a.getString(2131362320);
    this.a.jdField_a_of_type_JavaUtilList.clear();
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList != null) {
      this.a.jdField_a_of_type_JavaUtilList.addAll(this.a.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList);
    }
    PrinterStatusHandler localPrinterStatusHandler = (PrinterStatusHandler)this.a.app.a(74);
    this.a.jdField_a_of_type_Boolean = localPrinterStatusHandler.a();
    this.a.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */