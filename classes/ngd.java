import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.PttVoiceChangePreSender;

public class ngd
  implements Runnable
{
  public ngd(ListenChangeVoicePanel paramListenChangeVoicePanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (FriendsManager)ListenChangeVoicePanel.a(this.a).getManager(50);
    int i;
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l())
    {
      localObject = ((FriendsManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int, true);
      if (localObject == null) {
        break label148;
      }
      i = ((NoC2CExtensionInfo)localObject).pttChangeVoiceType;
    }
    for (;;)
    {
      if (i != -1)
      {
        ListenChangeVoicePanel.a(this.a, i);
        ListenChangeVoicePanel.a(this.a)[ListenChangeVoicePanel.a(this.a)] = 1;
      }
      if (ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender == null) {
        ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender = new PttVoiceChangePreSender();
      }
      return;
      localObject = ((FriendsManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, true);
      if (localObject != null) {
        i = ((ExtensionInfo)localObject).pttChangeVoiceType;
      } else {
        label148:
        i = -1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ngd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */