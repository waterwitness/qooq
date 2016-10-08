import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotchat.PttMsgAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class suq
  implements Runnable
{
  public suq(HotChatPttStageControl paramHotChatPttStageControl, ArrayList paramArrayList, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatPttStageControl", 2, "onPublishedOrGetPushedPttData: " + this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundResource(2130840823);
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.j);
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) || (!((MessageForPtt)this.jdField_a_of_type_JavaUtilArrayList.get(0)).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
        break label977;
      }
    }
    label977:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (bool)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatPttStageControl", 2, "onPublishedOrGetPushedPttData: isSelfPub and isAdd.");
          }
          i = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a() - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
          if (i > 0) {
            this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.c = 0L;
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
        j = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.d(i);
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0) != null) {
          i = j - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0).getLeft();
        }
        if (i > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
          continue;
          if ((bool) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 1))
          {
            if (QLog.isColorLevel()) {
              QLog.i("HotChatPttStageControl", 2, "onPublishedOrGetPushedPttData: push");
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) || (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.f))
            {
              if (QLog.isColorLevel()) {
                QLog.i("HotChatPttStageControl", 2, "onPublishedOrGetPushedPttData: push isPlaying or isAutoPlay.");
              }
              i = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
              j = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.d(i);
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0) != null) {
                i = j - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0).getLeft();
              }
              if (i > 0) {
                this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.i("HotChatPttStageControl", 2, "onPublishedOrGetPushedPttData: push not isPlaying or isAutoPlay.");
              }
              i = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a() - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
              if (i > 0) {
                this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
              }
              this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.b(1);
              if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_i_of_type_Int != -1)
              {
                this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.f = true;
                this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_i_of_type_Boolean = false;
                this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new sur(this), 1300L);
              }
            }
          }
          else
          {
            if ((!this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) && (!this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.f)) {
              break;
            }
            i = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
            j = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.d(i);
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0) != null) {
              i = j - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0).getLeft();
            }
            if (i > 0) {
              this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
            }
          }
        }
      }
      int k = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.b(10);
      if (QLog.isColorLevel()) {
        QLog.i("HotChatPttStageControl", 2, "onPublishedOrGetPushedPttData autoPlayFirstSelection: " + k + " total size: " + this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_a_of_type_JavaUtilList.size());
      }
      if ((k < 0) || (k >= this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_a_of_type_JavaUtilList.size()))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a() - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
        if (i > 0) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.notifyDataSetChanged();
        return;
      }
      int m = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.d(k);
      i = PttMsgAdapter.jdField_a_of_type_Int;
      int n = (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i) / 2;
      int j = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a() - this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
      if (j <= 0) {
        i = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(i);
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.f = true;
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_i_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new sus(this, k), 1300L);
        break;
        if (m - n <= 0)
        {
          i = 0;
        }
        else if (m - n <= j)
        {
          i = m - n;
        }
        else
        {
          i = j;
          if (m - n <= j) {
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\suq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */