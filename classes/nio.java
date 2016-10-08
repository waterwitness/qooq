import android.view.View;
import com.tencent.mobileqq.activity.aio.item.DeviceFileItemBuilder;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class nio
  implements ActionSheet.OnButtonClickListener
{
  public nio(DeviceFileItemBuilder paramDeviceFileItemBuilder, MessageForDeviceFile paramMessageForDeviceFile, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder.a();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */