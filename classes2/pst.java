import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class pst
  implements Runnable
{
  public pst(MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.hasPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage.isPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.msgData = MessagePkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.msgData);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */