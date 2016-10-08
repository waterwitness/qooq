import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class koj
  extends MessageObserver
{
  public koj(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(267387140);
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice chatlist=" + ((List)localObject1).size());
    }
    if (paramBoolean1)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(267387139);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        MultiMsgManager.a().a((List)localObject1);
        ChatActivityFacade.a((List)localObject1);
        ChatActivityFacade.b((List)localObject1);
        localObject2 = (ChatMessage)((List)localObject1).get(0);
        if (!(localObject2 instanceof MessageForPtt)) {
          break label352;
        }
        localObject1 = (MessageForPtt)((List)localObject1).get(0);
        localObject2 = MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
        if ((localObject2 == localObject1) || (((localObject2 instanceof MessageForPtt)) && (((ChatMessage)localObject2).frienduin != null) && (((ChatMessage)localObject2).frienduin.equals(((MessageForPtt)localObject1).frienduin)) && (((ChatMessage)localObject2).uniseq == ((MessageForPtt)localObject1).uniseq))) {
          MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
        }
      }
      if (paramBoolean2) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B2", "0X80056B2", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      super.a(paramBoolean1, paramList, paramBoolean2);
      return;
      label352:
      if ((localObject2 instanceof MessageForShortVideo))
      {
        localObject1 = (MessageForShortVideo)((List)localObject1).get(0);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
        this.a.a(131072);
        ShortVideoPTVItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
        break;
      }
      if ((localObject2 instanceof MessageForStructing))
      {
        localObject1 = ((MessageForStructing)((List)localObject1).get(0)).structingMsg;
        if ((localObject1 == null) || (!(localObject1 instanceof StructMsgForAudioShare)) || (!QQPlayerService.a((StructMsgForAudioShare)localObject1))) {
          break;
        }
        QQPlayerService.c(this.a.jdField_a_of_type_AndroidContentContext);
        break;
      }
      if (!(localObject2 instanceof MessageForApollo)) {
        break;
      }
      localObject1 = (MessageForApollo)((List)localObject1).get(0);
      if (localObject1 == null) {
        break;
      }
      ApolloActionManager.a().a(((MessageForApollo)localObject1).uniseq);
      if (((MessageForApollo)localObject1).mApolloMessage == null) {
        break;
      }
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "withdraw_success", ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { Integer.toString(((MessageForApollo)localObject1).mApolloMessage.id) });
      break;
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(267387140);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\koj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */