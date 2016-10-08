import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.concurrent.atomic.AtomicBoolean;

public class ylb
  extends Handler
{
  public ylb(QZoneVideoDownloadActivity paramQZoneVideoDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1000: 
    case 1004: 
    case 1001: 
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d(QZoneVideoDownloadActivity.jdField_a_of_type_JavaLangString, 4, "mIsUIInited=" + QZoneVideoDownloadActivity.a(this.a));
            }
          } while (QZoneVideoDownloadActivity.a(this.a).get());
          this.a.setContentView(2130905120);
          this.a.a();
          QZoneVideoDownloadActivity.a(this.a).set(true);
          return;
        } while ((this.a.jdField_a_of_type_AndroidWidgetTextView == null) || (this.a.jdField_a_of_type_AndroidWidgetProgressBar == null));
        i = paramMessage.arg1;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载短视频，已完成" + i + "%，请耐心等待");
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
        return;
      } while ((this.a.jdField_a_of_type_AndroidWidgetTextView == null) || (this.a.jdField_a_of_type_AndroidWidgetProgressBar == null));
      int i = paramMessage.arg1;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载短视频组件，已完成" + i + "%，请耐心等待");
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      return;
    case 1002: 
      Toast.makeText(this.a.getApplicationContext(), "短视频下载失败，请检查你的网络环境", 1).show();
      QzoneVideoBeaconReport.a(this.a.c, "qzone_video_recordtrim", "1005", null);
      this.a.finish();
      return;
    }
    Toast.makeText(this.a.getApplicationContext(), "短视频安装出错，请重试", 1).show();
    QzoneVideoBeaconReport.a(this.a.c, "qzone_video_recordtrim", "1006", null);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */