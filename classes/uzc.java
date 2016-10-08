import android.app.ProgressDialog;
import com.tencent.mfsdk.LeakInspector.DumpMemInfoHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity;
import com.tencent.qphone.base.util.QLog;

public class uzc
  implements Runnable
{
  public uzc(ShareDumpMemoryActivity paramShareDumpMemoryActivity, ProgressDialog paramProgressDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object[] arrayOfObject = DumpMemInfoHandler.a(ShareDumpMemoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity));
    if (((Boolean)arrayOfObject[0]).booleanValue())
    {
      ShareDumpMemoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity, (String)arrayOfObject[1]);
      if (QLog.isColorLevel()) {
        QLog.d("LeakInspector", 2, "leakFlag=true,ZipFile=true,leakName=" + ShareDumpMemoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity) + ",dumpPath=" + ShareDumpMemoryActivity.b(this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity.a();
      this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity.finish();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LeakInspector", 2, "failed dump qq memory");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */