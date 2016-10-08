import android.os.CountDownTimer;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.ProgressViewRed;
import com.tencent.mobileqq.portal.ProgressViewYellow;

public class ttr
  extends CountDownTimer
{
  public ttr(ConversationHongBao paramConversationHongBao, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    super(paramLong1, paramLong2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFinish()
  {
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
    if (localPortalManager != null) {
      localPortalManager.a();
    }
  }
  
  public void onTick(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.a(paramLong);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.a(paramLong, this.jdField_a_of_type_ArrayOfLong[0], this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_JavaLangStringBuilder);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.a(paramLong, this.jdField_a_of_type_ArrayOfLong[0]);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentMobileqqPortalFormalView.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.a(paramLong);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.b);
    }
    paramLong = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.e;
    if (paramLong > 2000L) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
    }
    while (paramLong <= 1000L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ttr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */