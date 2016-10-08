import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.DraftTextManager;
import mqq.os.MqqHandler;

public class kqc
  implements Runnable
{
  public kqc(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DraftTextInfo localDraftTextInfo = BaseChatPie.a(this.a).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    BaseChatPie localBaseChatPie = this.a;
    if (localDraftTextInfo != null) {}
    for (String str = localDraftTextInfo.text;; str = "")
    {
      BaseChatPie.a(localBaseChatPie, str);
      this.a.n = true;
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new kqd(this, localDraftTextInfo));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */