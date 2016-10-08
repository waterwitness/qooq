import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import java.util.List;
import mqq.os.MqqHandler;

public class kux
  implements DialogInterface.OnClickListener
{
  public kux(ChatHistory paramChatHistory, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.d, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a);
    if ((paramDialogInterface != null) && (!paramDialogInterface.isEmpty())) {
      if ((1 != this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a) && (3000 != this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a)) {}
    }
    for (long l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).shmsgseq;; l1 = 0L) {
      for (;;)
      {
        ThreadManager.b().post(new kuy(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().f(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.d, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a);
        ApolloActionManager.a().a();
        if (this.jdField_a_of_type_JavaLangString != null) {}
        try
        {
          l2 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.d, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a, l1);
          }
          paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a(Conversation.class);
          Message localMessage = paramDialogInterface.obtainMessage(1017);
          localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.d;
          localMessage.arg1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a;
          paramDialogInterface.sendMessage(localMessage);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.dismiss();
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.setResult(-1);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.finish();
          return;
          if (((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).isSendFromLocal()) {
            l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).time + 2L;
          } else {
            l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).time;
          }
        }
        catch (Exception paramDialogInterface)
        {
          for (;;)
          {
            paramDialogInterface.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kux.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */