import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsVideo;

public class sga
  extends Handler
{
  public sga(OfflineVideoFileView paramOfflineVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing())) {}
    label127:
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startTitleProgress();
          return;
        case 2: 
          this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.stopTitleProgress();
          return;
        case 3: 
          if ((this.a.f != 0) && (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))) {
            break label127;
          }
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("zivonchen", 4, "setCanPreview return, requesting-------------");
      return;
      if (NetworkUtil.i(BaseApplicationImpl.getContext())) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplicationImpl.getContext().getString(2131362849));
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2));
        if (QLog.isDevelopLevel()) {
          QLog.d("zivonchen", 4, "executeOnNetWorkThread setCanPreview true-------------");
        }
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplicationImpl.getContext().getString(2131362850));
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2));
    if (QLog.isDevelopLevel()) {
      QLog.d("zivonchen", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
    for (paramMessage = "0";; paramMessage = "-1")
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramMessage, "-1", "-1");
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2));
    if (QLog.isDevelopLevel()) {
      QLog.d("zivonchen", 4, "executeOnNetWorkThread file not exsit-------------");
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131362871, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */