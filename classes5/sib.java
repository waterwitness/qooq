import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sib
  implements FMSettingInterface.MoveFileCallback
{
  sib(sia paramsia)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new sie(this));
    FMSettings.a(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings);
    FileManagerReporter.a("0X8005BE2");
    synchronized (BaseApplicationImpl.getContext())
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b = false;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.a.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new sid(this));
    FMSettings.a(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings);
    synchronized (BaseApplicationImpl.getContext())
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b = false;
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new sic(this, paramLong1, paramLong2));
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */