import com.dataline.activities.DLRouterSessionInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.XListView;

public class r
  implements Runnable
{
  public r(DLRouterSessionInfoActivity paramDLRouterSessionInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetXListView.d_() > 2) {
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    }
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, null);
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setTranscriptMode(1);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */