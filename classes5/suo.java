import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotchat.PttMsgAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class suo
  implements Runnable
{
  public suo(HotChatPttStageControl paramHotChatPttStageControl, List paramList, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 0;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatPttStageControl", 2, "onGetInitedPttData isHasMore: " + this.jdField_a_of_type_Boolean + "data: " + this.jdField_a_of_type_JavaUtilList.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundResource(2130840823);
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.j = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.j);
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.f)
      {
        int m = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.b(10);
        if (QLog.isColorLevel()) {
          QLog.i("HotChatPttStageControl", 2, "onGetInitedPttData autoPlayFirstSelection: " + m + " total size: " + this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_a_of_type_JavaUtilList.size());
        }
        if ((m < 0) || (m >= this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_a_of_type_JavaUtilList.size()))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a() - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
          if (i > 0) {
            this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
          }
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.f = false;
          return;
        }
        int n = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.d(m);
        i = PttMsgAdapter.jdField_a_of_type_Int;
        int i1 = (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i) / 2;
        int k = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a() - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
        if (k <= 0) {
          i = j;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new sup(this, m), 2300L);
          return;
          i = j;
          if (n - i1 > 0) {
            if (n - i1 <= k)
            {
              i = n - i1;
            }
            else
            {
              i = j;
              if (n - i1 > k) {
                i = k;
              }
            }
          }
        }
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a() - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
      if (i > 0) {
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
      }
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.notifyDataSetChanged();
      return;
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidContentContext).inflate(2130904196, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, -2));
    this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(localView);
    this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.f = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\suo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */