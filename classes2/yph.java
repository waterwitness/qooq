import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.share.QZoneShareActivity;

public class yph
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public yph(QZoneShareActivity paramQZoneShareActivity, RelativeLayout paramRelativeLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    if (QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity) - i > 150) {
      this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity, i);
      return;
      if ((i - QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity) > 150) && (!this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.jdField_c_of_type_AndroidViewView.setVisibility(4);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */