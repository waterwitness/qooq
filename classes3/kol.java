import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kol
  extends CardObserver
{
  public kol(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramObject != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(((Card)paramObject).uin)) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003)) && (((Card)paramObject).strCertificationInfo != null) && (!((Card)paramObject).strCertificationInfo.equals(""))) {
        ChatActivityFacade.d(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if ((paramBoolean) && (paramObject != null)) {}
      switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(((Card)paramObject).uin)))
        {
          this.a.s();
          this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (AppSetting.j)
          {
            paramObject = this.a.b.getText().toString();
            this.a.b.setContentDescription((CharSequence)paramObject);
            this.a.a().setTitle(this.a.b.getText());
          }
          if ((3000 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && ((this.a instanceof DiscussChatPie))) {
            ((DiscussChatPie)this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.b);
          }
        }
        return;
      }
      this.a.a(false, false);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.d != null) && (this.a.d.isShowing())) {
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.dismissDialog(231);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.showDialog(232);
      return;
    }
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.showDialog(233);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.a.aB();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */