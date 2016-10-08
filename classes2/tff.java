import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class tff
  implements Runnable
{
  public tff(EmoticonManager paramEmoticonManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (EmoticonTab)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.a(EmoticonTab.class, this.jdField_a_of_type_JavaLangString);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.b((Entity)localObject);
    }
    localObject = RecentEmotionData.class.getSimpleName();
    localObject = "delete from " + (String)localObject + " where emoIndex = " + this.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, (String)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.c((String)localObject);
    EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */