import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class qcu
  implements Runnable
{
  private static final long jdField_a_of_type_Long = 20L;
  private static final long jdField_b_of_type_Long = 100L;
  int jdField_a_of_type_Int;
  volatile boolean jdField_a_of_type_Boolean;
  volatile int jdField_b_of_type_Int;
  volatile boolean jdField_b_of_type_Boolean;
  volatile int c;
  
  private qcu(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = 5;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    BaseApplicationImpl.a.postDelayed(this, 100L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "set progress, actual = " + paramInt1 + ", expected = " + paramInt2);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    BaseApplicationImpl.a.removeCallbacks(this);
    BaseApplicationImpl.a.postDelayed(this, 20L);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    BaseApplicationImpl.a.removeCallbacks(this);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "run progress, isCanceled = " + this.jdField_a_of_type_Boolean + ", bindState = " + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int);
    }
    Object localObject;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int == 5) && (this.jdField_a_of_type_Int + 1 < this.c))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      PhoneContactManagerImp.b((PhoneContactManagerImp)localObject, i);
      if (this.jdField_b_of_type_Boolean)
      {
        PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, 7);
        this.jdField_b_of_type_Boolean = false;
      }
      localObject = BaseApplicationImpl.a;
      if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int) {
        break label150;
      }
    }
    label150:
    for (long l = 20L;; l = 100L)
    {
      ((MqqHandler)localObject).postDelayed(this, l);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */