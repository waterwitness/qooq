import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.antiphing.AntiphishingUrlConfig;
import com.tencent.mobileqq.antiphing.DownloadFileHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ppr
  implements Runnable
{
  public ppr(AntiphishingUrlConfig paramAntiphishingUrlConfig, Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (AntiphishingUrlConfig.a() > 3000000L)
    {
      if (new DownloadFileHelper(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, AntiphishingUrlConfig.b(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig), this.b, false))
      {
        QLog.d(AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig), 1, "Successfully Update Config!");
        AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig).sendEmptyMessage(AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig));
      }
    }
    else {
      return;
    }
    AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig).sendEmptyMessage(AntiphishingUrlConfig.b(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig));
    QLog.d(AntiphishingUrlConfig.a(this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig), 1, "Update Config Error!");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ppr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */