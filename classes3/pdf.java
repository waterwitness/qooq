import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class pdf
  implements HorizontalListView.OnScrollStateChangedListener
{
  public pdf(PtvTemplateAdapter paramPtvTemplateAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 4097)
    {
      if (QLog.isColorLevel()) {
        QLog.i(PtvTemplateManager.a, 2, "ptv template listview onScrollStateChanged state is idle.");
      }
      this.a.b = this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 400L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */