import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.qphone.base.util.QLog;

public class tse
  implements Runnable
{
  public tse(OpenApiManager paramOpenApiManager, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "onRuntimeCreate, app = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + ", current = " + OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager) + ", bg = " + BaseApplicationImpl.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager.c(OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager));
    OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Intent localIntent = new Intent("com.tencent.mobileqq.openapi.ACTION_LOGIN");
    if (BaseApplicationImpl.b) {
      localIntent.putExtra("imm_reg", true);
    }
    BaseApplicationImpl.a.sendBroadcast(localIntent);
    OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager).a(OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager), true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */