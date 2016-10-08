import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class tsf
  implements Runnable
{
  public tsf(OpenApiManager paramOpenApiManager, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "onRuntimeDisactive, app = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + ", current = " + OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager) + ", " + this.jdField_a_of_type_Boolean);
    }
    if ((OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager)))
    {
      OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager).b(OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager));
      OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager).clear();
      OpenApiManager.b(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager).clear();
      OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager, 0);
      OpenApiManager.b(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager, 0);
      OpenApiManager.a(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager, null);
      BaseApplicationImpl.a.sendBroadcast(new Intent("com.tencent.mobileqq.openapi.ACTION_LOGOUT"));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tsf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */