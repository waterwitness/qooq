import com.hiar.sdk.HSARToolkit;
import com.hiar.sdk.renderer.HSRenderer;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARFragment;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.FramePerformanceMonitor.FrameRefreshListener;
import com.tencent.mobileqq.ar.GapDataCollector.RefreshData;
import com.tencent.mobileqq.ar.ReportUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ahh
  implements FramePerformanceMonitor.FrameRefreshListener
{
  public ahh(HSRenderer paramHSRenderer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GapDataCollector.RefreshData paramRefreshData)
  {
    if (paramRefreshData.a < 10) {}
    int j;
    do
    {
      return;
      if (paramRefreshData.a >= 150)
      {
        ARDeviceController.a().b(HSARToolkit.a().a);
        ReportUtil.a("render_quality", HSARToolkit.a().a);
        this.a.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.c();
        return;
      }
      j = ARDeviceController.a().b(HSARToolkit.a().a);
      int i = j;
      if (paramRefreshData.a >= 10)
      {
        i = j;
        if (paramRefreshData.a < 20) {
          i = (int)(j * 1.6F);
        }
      }
      j = i;
      if (paramRefreshData.a >= 20)
      {
        j = i;
        if (paramRefreshData.a < 40) {
          j = (int)(i * 1.3F);
        }
      }
    } while ((paramRefreshData.b <= j) || (HSARToolkit.a().a != 1));
    HSARToolkit.a().a = 0;
    this.a.jdField_a_of_type_ComTencentMobileqqArARFragment.a("config_light", "0");
    this.a.jdField_a_of_type_ComTencentMobileqqArARFragment.a("config_shadow", "0");
    ARDeviceController.a().b(HSARToolkit.a().a);
    ReportUtil.a("render_quality", HSARToolkit.a().a);
    this.a.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.c();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ahh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */