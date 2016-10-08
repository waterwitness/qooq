import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.view.ApolloMainViewBinder;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class psx
  extends IResDownloadListener
{
  public psx(ApolloPanel paramApolloPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "tab download Done");
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "action res done. action=" + paramApolloActionData.actionId);
    }
    this.a.a(paramApolloActionData);
  }
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null))
      {
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a());
        if (this.a.c != null)
        {
          this.a.c.clear();
          this.a.c(this.a.b(ApolloPanel.jdField_a_of_type_Int));
        }
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder == null) || (this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.k != 3) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "onJsonDone in panel fail refresh panel");
      }
      paramBoolean = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(ChatActivity.class);
    } while (paramBoolean == null);
    paramBoolean.post(new psy(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */