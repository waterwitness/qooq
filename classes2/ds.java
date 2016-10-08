import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ds
  implements DialogInterface.OnClickListener
{
  ds(dr paramdr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.status < 10) {
      this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.a.a(0, this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.uSessionID, true);
    }
    this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.a.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord);
    this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.b();
    this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */