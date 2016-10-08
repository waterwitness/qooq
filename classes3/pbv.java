import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pbv
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public pbv(NewFlowCameraActivity paramNewFlowCameraActivity, RelativeLayout paramRelativeLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWindowVisibleDisplayFrame(localRect);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getRootView().getHeight() - localRect.bottom > 150)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.d.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */