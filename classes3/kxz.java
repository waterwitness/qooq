import com.tencent.mobileqq.activity.ChatHistoryStructMsgView;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class kxz
  implements Runnable
{
  public kxz(ChatHistoryStructMsgView paramChatHistoryStructMsgView, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2;
    int i;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject2 = ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView);
      i = ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView);
      j = ChatHistoryStructMsgView.a();
      localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, new int[] { 63525 }, j);
    }
    Object localObject3;
    for (;;)
    {
      if ((localObject1 != null) && (((List)localObject1).size() < ChatHistoryStructMsgView.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_b_of_type_Boolean = true;
      }
      localObject2 = new LinkedHashMap();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break;
      }
      i = ((List)localObject1).size() - 1;
      while (i >= 0)
      {
        localObject3 = (MessageRecord)((List)localObject1).get(i);
        if (ChatHistoryStructAdapter.a((MessageRecord)localObject3))
        {
          if (((MessageRecord)localObject3).shmsgseq < this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_b_of_type_Long) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_b_of_type_Long = ((MessageRecord)localObject3).shmsgseq;
          }
          if (((MessageRecord)localObject3).versionCode < this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_Int) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_Int = ((MessageRecord)localObject3).versionCode;
          }
          if ((((MessageRecord)localObject3).getId() > 0L) && (((MessageRecord)localObject3).getId() < this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_Long)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_Long = ((MessageRecord)localObject3).getId();
          }
          if (((MessageRecord)localObject3).time < this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.c) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.c = ((MessageRecord)localObject3).time;
          }
          String str = QfileTimeUtils.a(((MessageRecord)localObject3).time * 1000L);
          if (!((LinkedHashMap)localObject2).containsKey(str)) {
            ((LinkedHashMap)localObject2).put(str, new ArrayList());
          }
          ((List)((LinkedHashMap)localObject2).get(str)).add(localObject3);
        }
        i -= 1;
      }
      long l1;
      long l2;
      int k;
      if (MsgProxy.a(ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView;
        ((ChatHistoryStructMsgView)localObject1).jdField_b_of_type_Long -= 1L;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView);
        i = ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView);
        l1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_Long;
        j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_Int;
        l2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_b_of_type_Long;
        k = ChatHistoryStructMsgView.a();
        localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, j, l2, new int[] { 63525 }, k);
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView);
        i = ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView);
        l1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_Long;
        j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_Int;
        l2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.c;
        k = ChatHistoryStructMsgView.a();
        localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, j, l2, new int[] { 63525 }, k);
      }
    }
    if (ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView) == null) {
      ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView, new ArrayList());
    }
    Object localObject1 = ((LinkedHashMap)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      if (!ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView).contains(localObject3)) {
        ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView).add(localObject3);
      }
      ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView).addAll((Collection)((LinkedHashMap)localObject2).get(localObject3));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "initEntity, size: " + ChatHistoryStructMsgView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView).size());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */