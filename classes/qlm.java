import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qlm
  implements Runnable
{
  public qlm(DatalineMessageManager paramDatalineMessageManager, DataLineMsgSet paramDataLineMsgSet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qlm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */