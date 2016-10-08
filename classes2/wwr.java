import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.InstallParams;

public class wwr
  implements Runnable
{
  public wwr(MyAppApi paramMyAppApi, Activity paramActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LogUtility.c("MyAppApi", "---isAutoInstall:" + ControlPolicyUtil.c() + " url:" + ControlPolicyUtil.a() + " interval:" + ControlPolicyUtil.a());
    if ((APNUtil.b(this.jdField_a_of_type_AndroidAppActivity)) && (APNUtil.c(this.jdField_a_of_type_AndroidAppActivity)))
    {
      boolean bool1 = ControlPolicyUtil.b();
      boolean bool2 = ControlPolicyUtil.i();
      if ((!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b()) && (bool1) && (bool2))
      {
        LogUtility.c("MyAppApi", "---startDownloadYYB---");
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a = new MyAppApi.InstallParams(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi);
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.b = false;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidOsBundle = null;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */