import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotchat.PttMsgAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class suu
  implements Runnable
{
  public suu(HotChatPttStageControl paramHotChatPttStageControl, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label147;
      }
      MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localMessageForPtt == null) || (localMessageForPtt.uniseq != this.jdField_a_of_type_Long)) {
        break label140;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.remove(i);
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundResource(2130840823);
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList, false);
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.notifyDataSetChanged();
      }
      return;
      label140:
      i += 1;
      break;
      label147:
      i = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\suu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */