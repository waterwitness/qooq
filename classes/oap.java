import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oap
  implements CustomMenuBar.OnMenuItemClickListener
{
  public oap(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(paramString, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), paramInt1, PublicAccountChatPie.a(this.a), PublicAccountChatPie.b(this.a), paramInt2, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */