import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.NoSelLinkMovementMethod;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;

public class moq
  extends Handler
{
  public moq(TextPreviewActivity paramTextPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqTextQQText != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(this.a.jdField_a_of_type_ComTencentMobileqqTextQQText);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a.setMovementMethod(ContainerView.NoSelLinkMovementMethod.a());
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.a.e));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\moq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */