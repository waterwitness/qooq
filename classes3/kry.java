import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public final class kry
  implements Runnable
{
  public kry(Context paramContext, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    ChatActivityFacade.jdField_a_of_type_ComTencentMobileqqDataChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364614);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.a(str);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131368306, 3);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.a(new krz(this));
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */