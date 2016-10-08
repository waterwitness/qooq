import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.common.GloableValue;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;

public class pcc
  implements Runnable
{
  public pcc(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getResources().getDisplayMetrics().widthPixels / 6;
    float f = this.jdField_a_of_type_Int * 1.0F / this.b;
    int k;
    int n;
    int m;
    int j;
    if (f <= 1.0F)
    {
      k = (int)(i / f);
      n = (k - i) / 2;
      m = 0;
      j = i;
      if (!TextUtils.isEmpty(NewFlowCameraActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity))) {
        break label131;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "initFramesBar, mTrimVideoPath is null");
      }
      NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).sendEmptyMessage(1001);
    }
    for (;;)
    {
      return;
      j = (int)(f * i);
      m = (j - i) / 2;
      n = 0;
      k = i;
      break;
      label131:
      i = ThumbnailUtils.a(NewFlowCameraActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity), j, k, m, n, i, i);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "init, status1=" + i + ", dstWidth=" + j + ", dstHeight=" + k);
      }
      if (i != 0)
      {
        QzoneVideoBeaconReport.a(NewFlowCameraActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity), "qzone_video_trim", "2", null);
        NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).sendEmptyMessage(1001);
        return;
      }
      NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).a(NewFlowCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity));
      NewFlowCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, (int)NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).a());
      NewFlowCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, (int)NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).b());
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "mStartTime=" + NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) + ", mEndTime=" + NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.setPlayDuration(NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) - NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity));
      NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).sendEmptyMessage(1100);
      if (TextUtils.isEmpty(NewFlowCameraActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity))) {}
      for (i = 64537;; i = ThumbnailUtils.a(NewFlowCameraActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity), this.jdField_a_of_type_Int, this.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "init, status0=" + i);
        }
        if (i == 0) {
          break;
        }
        QzoneVideoBeaconReport.a(NewFlowCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity), "qzone_video_trim", "3", null);
        NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).sendEmptyMessage(1000);
        return;
      }
      try
      {
        Bitmap localBitmap = ThumbnailUtils.a(0L, 1000L);
        if (localBitmap != null)
        {
          String str = GloableValue.a + File.separator + System.currentTimeMillis() + ".jpg";
          if (NewFlowCameraActivity.a(localBitmap, str, 80)) {
            NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).obtainMessage(1102, str).sendToTarget();
          }
          localBitmap.recycle();
          return;
        }
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */