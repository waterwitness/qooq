import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class qqe
  implements Runnable
{
  public qqe(ArkAppCGI paramArkAppCGI, qqh paramqqh, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI))
    {
      ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI).remove(this.jdField_a_of_type_Qqh);
      this.jdField_a_of_type_Qqh.a.a(this.jdField_a_of_type_Qqh, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfByte);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */