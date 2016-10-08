import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

public class nnp
  implements Runnable
{
  public nnp(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder.a == null) {}
    while (QWalletHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "preload qwallet process by qqWalletMsg isTroop=" + this.jdField_a_of_type_Int);
    }
    QWalletHelper.a(0, "qwallet_red");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */