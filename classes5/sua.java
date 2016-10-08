import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class sua
  implements Runnable
{
  public sua(HotChatPttStageControl paramHotChatPttStageControl, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1026, 40);
    Object localObject2 = new StringBuilder().append("mHotChatPttControl init in sub thread msgList size=");
    int i;
    if (localObject1 == null)
    {
      i = 0;
      QLog.d("PttShow", 1, i);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject2 = new ArrayList();
        i = ((List)localObject1).size() - 1;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        Object localObject3 = (MessageRecord)((List)localObject1).get(i);
        if ((localObject3 != null) && ((localObject3 instanceof MessageForPtt)))
        {
          localObject3 = (MessageForPtt)localObject3;
          if (!this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(((MessageForPtt)localObject3).uniseq)))
          {
            QLog.d("PttShow", 1, "mHotChatPttControl init in sub thread index=" + i + ", ptt=" + ((MessageForPtt)localObject3).toString() + ", voice length=" + ((MessageForPtt)localObject3).voiceLength);
            if (((MessageForPtt)localObject3).shmsgseq > this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.b) {
              this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.b = ((MessageForPtt)localObject3).shmsgseq;
            }
            if (((MessageForPtt)localObject3).shmsgseq < this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_Long) {
              this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_Long = ((MessageForPtt)localObject3).shmsgseq;
            }
            ((ArrayList)localObject2).add(0, localObject3);
            this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((MessageForPtt)localObject3).uniseq), localObject3);
            if (((ArrayList)localObject2).size() < this.jdField_a_of_type_Int) {}
          }
        }
      }
      else
      {
        QLog.d("PttShow", 1, "mHotChatPttControl init in sub thread leftPttList size=" + ((ArrayList)localObject2).size() + ", mMinPttSeq=" + this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_Long + ", mMaxPttSeq=" + this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.b);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl;
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_Long > 1L) {
          bool = true;
        }
        ((HotChatPttStageControl)localObject1).a((List)localObject2, bool);
        HotChatPttStageControl.a(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl, (List)localObject2);
        return;
        i = ((List)localObject1).size();
        break;
      }
      i -= 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */