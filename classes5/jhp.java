import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class jhp
  implements Runnable
{
  public jhp(OfflinePlugin paramOfflinePlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (OfflinePlugin.jdField_a_of_type_JavaUtilHashMap != null)
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.a(this.a));
      if ((localOfflineUpdateStatus != null) && (localOfflineUpdateStatus.b() == 1))
      {
        if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.a.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        localOfflineUpdateStatus.b(2);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */