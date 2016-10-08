import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class lze
  extends CardObserver
{
  public lze(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.a());
    PermisionPrivacyActivity.a(this.a, this.a.c.a(), localCard.allowPeopleSee);
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.a().equals(paramString)) {
      return;
    }
    if (!paramBoolean1) {
      this.a.a(2131370267, 1);
    }
    if (paramBoolean2)
    {
      PermisionPrivacyActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean3);
      return;
    }
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing()))
    {
      if (paramBoolean2) {
        break label103;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已启用");
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        Card localCard = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.a());
        QLog.d("interactive", 2, "PermisionPrivacyActivity onGetCalReactiveDays isAllow= " + paramBoolean2 + "card.allowCalInteractive=" + localCard.allowCalInteractive);
      }
      return;
      label103:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("未启用");
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if ((paramBoolean) && (!this.a.isFinishing()))
    {
      Card localCard = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.a());
      if (localCard.allowCalInteractive) {
        break label105;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已启用");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("PermisionPrivacyActivity onSetCalReactiveDays isAllow= ");
        if (localCard.allowCalInteractive) {
          break label120;
        }
      }
    }
    label105:
    label120:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("interactive", 2, paramBoolean);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("未启用");
      break;
    }
  }
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.a().equals(paramString)) {
      return;
    }
    PermisionPrivacyActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean2);
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean2);
    }
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing())) {
      PermisionPrivacyActivity.a(this.a, this.a.g.a(), paramBoolean2);
    }
  }
  
  protected void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.isFinishing()) {
      PermisionPrivacyActivity.a(this.a, this.a.g.a(), paramBoolean2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */