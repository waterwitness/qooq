import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.XEditTextEx;

public class kmb
  implements Runnable
{
  public kmb(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      if (BaseChatPie.a(this.a) == null) {
        BaseChatPie.a(this.a, DraftTextManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      localObject = BaseChatPie.a(this.a).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if ((!StringUtil.b(BaseChatPie.a(this.a))) || (!StringUtil.b(String.valueOf(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) || (((DraftTextInfo)localObject).sourceMsgSeq != 0L)) {
        break label144;
      }
    }
    label144:
    while ((!StringUtil.b(BaseChatPie.a(this.a))) && (BaseChatPie.a(this.a).equals(String.valueOf(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText())))) {
      return;
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    this.a.a((CharSequence)localObject);
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    DraftSummaryInfo localDraftSummaryInfo = BaseChatPie.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (localDraftSummaryInfo != null)
    {
      ((QQMessageFacade)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, localDraftSummaryInfo.getSummary(), localDraftSummaryInfo.getTime());
      return;
    }
    ((QQMessageFacade)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, "", 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */