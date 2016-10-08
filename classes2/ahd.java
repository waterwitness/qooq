import com.hiar.sdk.HSARToolkit;
import com.hiar.sdk.camera.CameraPreviewHandler;
import com.hiar.sdk.core.HiarqOptions;
import com.hiar.sdk.core.NativeInterface;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.FramePerformanceMonitor.FrameRefreshListener;
import com.tencent.mobileqq.ar.GapDataCollector.RefreshData;
import com.tencent.mobileqq.ar.ReportUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ahd
  implements FramePerformanceMonitor.FrameRefreshListener
{
  public ahd(CameraPreviewHandler paramCameraPreviewHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GapDataCollector.RefreshData arg1)
  {
    if (CameraPreviewHandler.a(this.a).trackingQuality <= 3)
    {
      ARDeviceController.a().a(CameraPreviewHandler.a(this.a).trackingQuality);
      ReportUtil.a("recog_track_quality", CameraPreviewHandler.a(this.a).trackingQuality);
      CameraPreviewHandler.a(this.a).c();
    }
    int j;
    do
    {
      do
      {
        return;
      } while (???.a < 10);
      if (???.a >= 150)
      {
        ARDeviceController.a().a(CameraPreviewHandler.a(this.a).trackingQuality);
        ReportUtil.a("recog_track_quality", CameraPreviewHandler.a(this.a).trackingQuality);
        CameraPreviewHandler.a(this.a).c();
        return;
      }
      j = ARDeviceController.a().a(CameraPreviewHandler.a(this.a).trackingQuality);
      int i = j;
      if (???.a >= 10)
      {
        i = j;
        if (???.a < 20) {
          i = (int)(j * 1.6F);
        }
      }
      j = i;
      if (???.a >= 20)
      {
        j = i;
        if (???.a < 40) {
          j = (int)(i * 1.3F);
        }
      }
    } while (???.b <= j);
    ??? = CameraPreviewHandler.a(this.a);
    ???.trackingQuality -= 1;
    ??? = CameraPreviewHandler.a(this.a);
    ???.recogQuality -= 1;
    HSARToolkit.a().b = CameraPreviewHandler.a(this.a).trackingQuality;
    for (;;)
    {
      try
      {
        if (this.a.jdField_a_of_type_Long <= 0L) {}
      }
      catch (Exception ???)
      {
        ???.printStackTrace();
        continue;
      }
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        NativeInterface.hiarqSetOptions(this.a.jdField_a_of_type_Long, CameraPreviewHandler.a(this.a));
        CameraPreviewHandler.a(this.a).b();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ahd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */