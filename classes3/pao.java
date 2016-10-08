import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pao
  extends Handler
{
  public pao(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1000: 
    default: 
    case 1103: 
    case 1102: 
    case 1001: 
    case 1100: 
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "handleMessage, MSG_ON_CONFIRM");
          }
          if (this.a.jdField_a_of_type_AndroidAppProgressDialog != null) {
            this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
          }
          NewFlowCameraActivity.a(this.a, false);
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.isPlaying()) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setPlayDuration(NewFlowCameraActivity.a(this.a), NewFlowCameraActivity.b(this.a) - NewFlowCameraActivity.a(this.a));
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
          NewFlowCameraActivity.a(this.a, true);
          return;
          if (NewFlowCameraActivity.a(this.a) != null) {
            try
            {
              paramMessage = (String)paramMessage.obj;
              int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getWidth();
              int j = this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getHeight();
              if (QLog.isColorLevel()) {
                QLog.d("PTV.NewFlowCameraActivity", 2, "VIDEO_SHOW_COVER, filename=" + paramMessage + ", w=" + i + ", h=" + j);
              }
              NewFlowCameraActivity.a(this.a, this.a.a(paramMessage, i, j, false));
              if (NewFlowCameraActivity.a(this.a) != null)
              {
                ViewGroup.LayoutParams localLayoutParams = NewFlowCameraActivity.a(this.a).getLayoutParams();
                localLayoutParams.height = j;
                localLayoutParams.width = i;
                NewFlowCameraActivity.a(this.a).setLayoutParams(localLayoutParams);
                NewFlowCameraActivity.a(this.a).setImageBitmap(NewFlowCameraActivity.a(this.a));
                if (NewFlowCameraActivity.a(this.a)) {
                  NewFlowCameraActivity.a(this.a).setVisibility(0);
                }
                NewFlowCameraActivity.c(this.a, i);
                NewFlowCameraActivity.d(this.a, j);
                NewFlowCameraActivity.d(this.a, paramMessage);
                return;
              }
            }
            catch (Throwable paramMessage)
            {
              QLog.w("PTV.NewFlowCameraActivity", 2, "VIDEO_SHOW_COVER failed", paramMessage);
              return;
            }
          }
        }
        new AlertDialog.Builder(this.a).setMessage("初始化裁剪组件失败").setNegativeButton(2131362952, new pap(this)).setCancelable(false).create().show();
        return;
      } while (NewFlowCameraActivity.a(this.a) == null);
      NewFlowCameraActivity.a(this.a).requestLayout();
      return;
    case 9999: 
      NewFlowCameraActivity.a(this.a, "play_local_video", "play_local_video_success", "1", Build.MODEL);
      try
      {
        new AlertDialog.Builder(this.a).setMessage("加载视频超时").setNegativeButton(2131362952, new paq(this)).setCancelable(false).create().show();
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("PTV.NewFlowCameraActivity", 2, "LOAD_VIDEO_TIME_OUT showDialog error", paramMessage);
        return;
      }
    }
    Toast.makeText(this.a.getApplicationContext(), "裁剪的视频格式不支持，请重新选择视频", 1).show();
    NewFlowCameraActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */