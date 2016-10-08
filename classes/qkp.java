import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Map;

class qkp
  implements Runnable
{
  qkp(qko paramqko)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager.a.b.containsKey(MsgProxyUtils.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager.a.b.remove(MsgProxyUtils.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */