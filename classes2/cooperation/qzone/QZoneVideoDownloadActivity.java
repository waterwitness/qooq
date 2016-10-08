package cooperation.qzone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.video.interact.RecordSVInteractActivity;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import ylb;
import ylc;

public class QZoneVideoDownloadActivity
  extends IphoneTitleBarActivity
{
  public static final String a;
  public static final int b = 1003;
  public static final String b = "http://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover_7.png";
  public static final int c = 1002;
  public static final int d = 1000;
  public static final int e = 1001;
  public static final int f = 1004;
  public int a;
  public long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  public Handler a;
  public ProgressBar a;
  public TextView a;
  public URLImageView a;
  public PluginManagerClient a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  private long jdField_b_of_type_Long;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean b;
  private long c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = QZoneVideoDownloadActivity.class.getSimpleName();
  }
  
  public QZoneVideoDownloadActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ylb(this);
  }
  
  private void b()
  {
    if ((getAppRuntime() == null) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "startQZoneVideo, getAppRunime and uin are null");
      }
      QQToast.a(this, "短视频启动失败", 0).a();
      QzoneVideoBeaconReport.a(null, "qzone_video_recordtrim", "1000", null);
      finish();
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      localObject = getAppRuntime().getAccount();
      localUserInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      localObject = getIntent().getStringExtra("refer");
      QLog.i(jdField_a_of_type_JavaLangString, 1, "isSupportRecord=" + this.jdField_a_of_type_Boolean + ",isSupportTrim=" + this.jdField_b_of_type_Boolean + ",isPreviewVideo" + this.jdField_e_of_type_Boolean + ",refer=" + (String)localObject + ",videoRefer=" + this.jdField_e_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean) {
        break label281;
      }
      QZoneHelper.a(this.app, this, localUserInfo, 10009, this.jdField_b_of_type_Boolean, (String)localObject, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
      QzoneVideoBeaconReport.a(localUserInfo.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "0", "record");
    }
    for (;;)
    {
      if ("video_interact".equals(this.jdField_e_of_type_JavaLangString))
      {
        localObject = new Intent(this, RecordSVInteractActivity.class);
        ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        ((Intent)localObject).setFlags(33554432);
        startActivity((Intent)localObject);
        overridePendingTransition(2130968813, 0);
      }
      finish();
      return;
      localObject = this.jdField_c_of_type_JavaLangString;
      break;
      label281:
      if (this.jdField_b_of_type_Boolean)
      {
        QZoneHelper.a(this, localUserInfo, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, 10009, this.jdField_a_of_type_Int, (String)localObject, this.jdField_e_of_type_JavaLangString);
        QzoneVideoBeaconReport.a(localUserInfo.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1", "trim");
      }
      else if (this.jdField_e_of_type_Boolean)
      {
        localObject = new Intent(getApplicationContext(), PreviewVideoActivity.class);
        ((Intent)localObject).putExtra("video_source_path", this.jdField_d_of_type_JavaLangString);
        ((Intent)localObject).putExtra("video_type", this.g);
        ((Intent)localObject).putExtra("start_time", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("end_time", this.jdField_c_of_type_Long);
        ((Intent)localObject).putExtra("encode_video_params", this.jdField_a_of_type_AndroidOsBundle);
        startActivity((Intent)localObject);
        overridePendingTransition(2130968592, 2130968593);
      }
    }
  }
  
  public void a()
  {
    setTitle("短视频");
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131305383));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305382));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131305384));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL("http://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover_7.png");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(-16777216);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      Toast.makeText(getApplicationContext(), "参数错误，无法启动", 1).show();
      QzoneVideoBeaconReport.a(null, "qzone_video_recordtrim", "1002", null);
    }
    do
    {
      return;
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("support_record", false);
      this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("support_trim", false);
      this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("is_qzone_vip", false);
      this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("enable_edit_video", false);
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("uin");
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("file_send_path");
      this.jdField_a_of_type_Long = paramBundle.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
      this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("preview_video", false);
      this.g = paramBundle.getIntExtra("video_type", 0);
      this.jdField_b_of_type_Long = paramBundle.getLongExtra("start_time", 0L);
      this.jdField_c_of_type_Long = paramBundle.getLongExtra("end_time", 0L);
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("video_refer");
      this.jdField_a_of_type_AndroidOsBundle = paramBundle.getBundleExtra("encode_video_params");
      AppRuntime localAppRuntime = getAppRuntime();
      if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {
        break;
      }
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
      for (paramBundle = getAppRuntime().getAccount();; paramBundle = this.jdField_c_of_type_JavaLangString)
      {
        this.jdField_c_of_type_JavaLangString = paramBundle;
        if (!((QQAppInterface)localAppRuntime).d()) {
          break;
        }
        Toast.makeText(getApplicationContext(), "正在通话中，请结束通话后再试", 1).show();
        QzoneVideoBeaconReport.a(this.jdField_c_of_type_JavaLangString, "qzone_video_recordtrim", "1003", null);
        finish();
        return;
      }
      if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
      {
        QzoneVideoBeaconReport.a(this.jdField_c_of_type_JavaLangString, "qzone_video_recordtrim", "1004", null);
        finish();
        return;
      }
      if ((new File(ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext()) + ShortVideoSoLoad.getLibActualName("AVCodec")).exists()) && (VideoEnvironment.d())) {
        break label464;
      }
      setContentView(2130905120);
      a();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      paramBundle = (QQShortVideoHandler)((EarlyDownloadManager)localAppRuntime.getManager(76)).a("qq.android.native.short.video");
    } while (paramBundle == null);
    PtvFilterSoLoad.a(this.app, BaseApplicationImpl.getContext());
    paramBundle.a(new ylc(this));
    paramBundle.a(true);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "app is not QQAppInterface");
    }
    label464:
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneVideoDownloadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */