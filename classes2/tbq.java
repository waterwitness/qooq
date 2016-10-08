import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceActionListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.qphone.base.util.QLog;

public class tbq
  implements MagicfaceActionManager.MagicfaceActionListener
{
  public tbq(MagicfaceViewController paramMagicfaceViewController, long paramLong, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ActionGlobalData paramActionGlobalData)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d(MagicfaceViewController.jdField_a_of_type_JavaLangString, 2, "【magicface】 cost =" + (l1 - l2) + "ms");
    }
    boolean bool;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c(bool);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_AndroidOsHandler.post(new tbr(this, paramActionGlobalData));
      return;
      bool = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c(bool);
    }
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_AndroidOsHandler.post(new tbs(this, paramActionGlobalData));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */