import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

public class tfg
  implements Runnable
{
  public tfg(EmoticonManager paramEmoticonManager, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean) {
      EmoticonManager.b(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager);
    }
    EmoticonManager.c(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager);
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(false);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "reloadEmoticonKeywords time:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */