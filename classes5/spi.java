import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class spi
  implements Runnable
{
  public spi(FreshNewsDetailActivity paramFreshNewsDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.d();
    int i;
    if (this.a.p == 0)
    {
      i = this.a.e.getBottom() + AIOUtils.a(10.0F, this.a.getResources());
      j = this.a.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getTop() - i;
      if (QLog.isColorLevel()) {
        QLog.d("FreshNewsDetailActivity", 2, "onInputViewShow.itemHeight=" + i + ", offset=" + j);
      }
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(this.a.p, j);
      return;
    }
    View localView = this.a.a(this.a.jdField_a_of_type_ComTencentWidgetXListView, this.a.p - 1);
    if (localView != null) {}
    for (int j = localView.getMeasuredHeight();; j = this.a.q)
    {
      i = j;
      if (j != 0) {
        break;
      }
      i = AIOUtils.a(50.0F, this.a.getResources());
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */