import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qqb
  implements Runnable
{
  public qqb(ArkAppCGI paramArkAppCGI, qqh paramqqh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI, this.jdField_a_of_type_Qqh, false, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */