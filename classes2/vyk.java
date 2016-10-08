import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import com.tencent.mobileqq.util.HbThemeConfigManager.LoadHbThemeConfigCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.List;

public class vyk
  implements Runnable
{
  public vyk(HbThemeConfigManager paramHbThemeConfigManager, QQAppInterface paramQQAppInterface, HbThemeConfigManager.LoadHbThemeConfigCallback paramLoadHbThemeConfigCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1;
    synchronized ()
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.clear();
      localObject1 = new File(HbThemeConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "hbThemeConfig.cfg");
      if ((!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$LoadHbThemeConfigCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$LoadHbThemeConfigCallback.a();
        }
        return;
      }
    }
    try
    {
      localObject1 = FileUtils.b((File)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new String(Base64.decode((String)localObject1, 0));
        if (QLog.isColorLevel()) {
          QLog.d("HbThemeConfigManager", 2, "asyncLoadConfig:  " + (String)localObject1);
        }
        localObject1 = HbThemeConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.addAll((Collection)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$LoadHbThemeConfigCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$LoadHbThemeConfigCallback.a();
        }
        return;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HbThemeConfigManager", 2, "load hbTheme config exception: " + localException.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$LoadHbThemeConfigCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$LoadHbThemeConfigCallback.b();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */