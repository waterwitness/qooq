import android.view.View;
import android.widget.HorizontalScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class uif
  implements TabBarView.OnTabChangeListener
{
  public uif(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    EditActivity.a(this.a).setCurrentItem(paramInt2, false);
    RedDotTextView localRedDotTextView = this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(paramInt2);
    int[] arrayOfInt = new int[2];
    localRedDotTextView.getLocationOnScreen(arrayOfInt);
    if (arrayOfInt[0] + localRedDotTextView.getWidth() > EditActivity.o)
    {
      HorizontalScrollView localHorizontalScrollView = this.a.jdField_a_of_type_AndroidWidgetHorizontalScrollView;
      paramInt1 = arrayOfInt[0];
      localHorizontalScrollView.smoothScrollBy(localRedDotTextView.getWidth() + paramInt1 - EditActivity.o, 0);
    }
    if (arrayOfInt[0] < 0) {
      this.a.jdField_a_of_type_AndroidWidgetHorizontalScrollView.smoothScrollBy(arrayOfInt[0], 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */