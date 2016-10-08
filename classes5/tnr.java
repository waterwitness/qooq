import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.widget.BounceScrollView;

public class tnr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public tnr(NearbyProfileEditPanel paramNearbyProfileEditPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView().getRootView().getHeight() - ((Rect)localObject).bottom;
    if (i <= 0) {}
    int j;
    do
    {
      return;
      j = this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getScrollY();
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getCurrentFocus();
    } while ((localObject == null) || (!(localObject instanceof EditText)) || (((View)localObject).getParent() == null));
    int k = ((ViewGroup)((View)localObject).getParent()).getBottom();
    int m = this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getMeasuredHeight();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.a(0, k + i - m - j);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */