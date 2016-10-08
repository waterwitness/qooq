import android.content.Intent;
import com.dataline.activities.PrinterActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import java.util.ArrayList;

public class qdc
  implements FMDialogUtil.FMDialogInterface
{
  public qdc(PrinterHandler paramPrinterHandler, BaseActivity paramBaseActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PrinterActivity.class);
    localIntent.putExtra(AlbumConstants.i, 55);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */