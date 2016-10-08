import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotchat.PttMsgAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class sut
  implements Runnable
{
  public sut(HotChatPttStageControl paramHotChatPttStageControl, List paramList, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.j = false;
    }
    for (;;)
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.get(0);
      int i = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(localMessageForPtt);
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.addAll(0, this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.j);
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Boolean, i, localMessageForPtt));
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.h = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.j = this.jdField_a_of_type_Boolean;
      if (QLog.isColorLevel()) {
        QLog.i("HotChatPttStageControl", 2, "onGetMorePttData is hasMore : " + this.jdField_a_of_type_Boolean + " data: " + this.jdField_a_of_type_JavaUtilList.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */