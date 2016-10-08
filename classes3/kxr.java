import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kxr
  implements Runnable
{
  public kxr(ChatHistoryImageView paramChatHistoryImageView, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject;
    long l;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[onImageListLoad]: ");
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData == null)
      {
        localObject = "null";
        QLog.d("ChatHistoryImageView", 2, localObject);
      }
    }
    else
    {
      l = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() != 0) {
        break label207;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.b.setVisibility(0);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(false)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[onImageListLoad] cost: " + (SystemClock.uptimeMillis() - l));
      }
      return;
      localObject = Integer.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData.length);
      break;
      label207:
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.b.setVisibility(4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */