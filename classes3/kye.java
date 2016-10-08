import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class kye
  implements IIconListener
{
  public kye(ChatSettingActivity paramChatSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetTextView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId == paramInt1) && (paramBitmap != null) && (paramInt2 == 200)) {
      ChatSettingActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.a.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */