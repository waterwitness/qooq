import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import java.util.List;
import mqq.os.MqqHandler;

class kwz
  implements DialogInterface.OnClickListener
{
  kwz(kwx paramkwx, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new StringBuilder();
    Object localObject = (MessageRoamManager)this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getManager(91);
    paramInt = ((MessageRoamManager)localObject).a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_Int, paramDialogInterface);
    if ((paramDialogInterface != null) && (paramDialogInterface.length() > 0)) {}
    for (paramDialogInterface = paramDialogInterface.toString();; paramDialogInterface = null)
    {
      if (paramInt <= 0)
      {
        this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().getString(2131368681));
        return;
      }
      List localList = this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().b(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_Int);
      long l1;
      if ((localList != null) && (!localList.isEmpty())) {
        if (((MessageRecord)localList.get(localList.size() - 1)).isSendFromLocal()) {
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).time + 2L;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_Int);
        ChatHistoryForC2C.a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).b(null);
        ApolloActionManager.a().a();
        if (1 == this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.i();
          this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_Int);
          ((MessageRoamManager)localObject).m();
          VipUtils.a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app, "chat_history", "ChatHistory", "Clk_deleteCloud", 1, 0, new String[] { ChatHistoryForC2C.a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C) });
        }
        for (;;)
        {
          this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().f(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_Int);
          long l2;
          if (paramDialogInterface != null) {
            l2 = 0L;
          }
          try
          {
            long l3 = Long.parseLong(paramDialogInterface);
            l2 = l3;
          }
          catch (Exception paramDialogInterface)
          {
            for (;;)
            {
              paramDialogInterface.printStackTrace();
            }
          }
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_Int, l1);
          }
          ((MessageRoamManager)localObject).a().f();
          ((MessageRoamManager)localObject).b();
          if (1 == this.jdField_a_of_type_Int) {
            ((MessageRoamManager)localObject).m();
          }
          paramDialogInterface = this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a(Conversation.class);
          if (paramDialogInterface != null)
          {
            localObject = paramDialogInterface.obtainMessage(1017);
            ((Message)localObject).obj = this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_JavaLangString;
            ((Message)localObject).arg1 = this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.jdField_a_of_type_Int;
            paramDialogInterface.sendMessage((Message)localObject);
          }
          this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.setResult(-1);
          this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.finish();
          return;
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).time;
          break;
          VipUtils.a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app, "chat_history", "ChatHistory", "Clk_deleteLocal", 1, 0, new String[] { ChatHistoryForC2C.a(this.jdField_a_of_type_Kwx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C) });
        }
        l1 = 0L;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */