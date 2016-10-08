import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lrn
  implements Runnable
{
  public lrn(Leba paramLeba, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */