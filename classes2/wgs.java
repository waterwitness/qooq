import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.PreloadService;
import com.tencent.mobileqq.webprocess.PreloadService.PreloadImpl;
import com.tencent.qphone.base.util.QLog;

public class wgs
  implements Runnable
{
  public wgs(PreloadService.PreloadImpl paramPreloadImpl, AppInterface paramAppInterface, long paramLong, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (((!PreloadService.b) && (PreloadService.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface))) || ((!PreloadService.c) && (PreloadService.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface)))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "asyncPreload start, options = " + this.jdField_a_of_type_Long);
        }
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
        this.jdField_a_of_type_ComTencentMobileqqWebprocessPreloadService$PreloadImpl.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Long);
        if ((!PreloadService.b) && (!PreloadService.c))
        {
          PreloadService.PreloadImpl.a(this.jdField_a_of_type_ComTencentMobileqqWebprocessPreloadService$PreloadImpl, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          PreloadService.PreloadImpl.a(this.jdField_a_of_type_ComTencentMobileqqWebprocessPreloadService$PreloadImpl);
        }
        if (PreloadService.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
          PreloadService.b = true;
        }
        if (PreloadService.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
          PreloadService.c = true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "asyncPreload end");
        }
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("PreloadService", 2, "preload error:" + localException.toString());
        return;
      }
    }
    QLog.d("PreloadService", 2, "async preload:already inited.");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */