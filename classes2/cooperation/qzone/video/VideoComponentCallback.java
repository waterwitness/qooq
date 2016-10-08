package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class VideoComponentCallback
  implements FlowComponentInterface
{
  public static final int e = 1;
  public static final int f = 1000;
  public static final String k = VideoComponentCallback.class.getName();
  public static final String l = "finish_video_component";
  public static final String m = "support_trim";
  public static final String n = "qzone_uin";
  public static final String o = "nickname";
  private String p;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.publishmood");
    localIntent.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    localIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    localIntent.putExtra("PhotoConst.VIDEO_TYPE", paramInt1);
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("thumbnail_path", paramString2);
    localIntent.putExtra("thumbnail_height", paramInt3);
    localIntent.putExtra("thumbnail_width", paramInt2);
    localIntent.putExtra("need_process", paramBoolean);
    localIntent.putExtra("start_time", paramLong2);
    localIntent.putExtra("total_duration", paramLong1);
    localIntent.putExtra("file_send_duration", paramLong3 - paramLong2);
    localIntent.putExtra("sv_total_frame_count", paramInt4);
    localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLong4);
    localIntent.putExtra("encode_video_params", paramBundle);
    localIntent.putExtra("defaultText", paramString3);
    if (!TextUtils.isEmpty(paramString4)) {
      localIntent.putExtra("refer", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localIntent.putExtra("video_refer", paramString5);
    }
    localIntent.addFlags(603979776);
    paramString1 = BaseApplicationImpl.a().a().getAccount();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, -1);
  }
  
  public String a()
  {
    return this.p;
  }
  
  public void a(int paramInt1, boolean paramBoolean, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString3, String paramString4, String paramString5, int paramInt5, String paramString6, ArrayList paramArrayList)
  {
    paramString3 = new Bundle();
    paramString3.putString("param.content", paramString6);
    paramString3.putInt("param.priv", paramInt5);
    paramString3.putStringArrayList("param.privList", paramArrayList);
    paramString3.putString("param.videoPath", paramString1);
    paramString3.putLong("param.videoSize", paramLong4);
    paramString3.putInt("param.videoType", paramInt1);
    paramString3.putString("param.thumbnailPath", paramString2);
    paramString3.putInt("param.thumbnailHeight", paramInt3);
    paramString3.putInt("param.thumbnailWidth", paramInt2);
    paramString3.putLong("param.startTime", paramLong2);
    paramString3.putLong("param.duration", paramLong1);
    paramString3.putLong("param.totalDuration", paramLong1);
    paramString3.putBoolean("param.needProcess", paramBoolean);
    paramString3.putBundle("param.extras", paramBundle);
    RemoteHandleManager.a().a("cmd.publishVideoMood", paramString3, false);
  }
  
  public void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(k, 2, "localVideoClick");
    }
    if (paramActivity == null) {
      return;
    }
    try
    {
      boolean bool = LocalMultiProcConfig.a("support_trim", false);
      localObject = QZoneHelper.UserInfo.a();
      ((QZoneHelper.UserInfo)localObject).a = BaseApplicationImpl.a().a().getAccount();
      if (!bool) {
        break label295;
      }
      if (((paramActivity instanceof NewFlowCameraActivity)) && (!((NewFlowCameraActivity)paramActivity).g))
      {
        QZoneHelper.a(paramActivity, (QZoneHelper.UserInfo)localObject, "", 0L, 1000, 2, "", a());
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.w(k, 4, "", paramActivity);
      return;
    }
    if ("cover_mall_record_video".equals(a()))
    {
      QZoneHelper.a(paramActivity, (QZoneHelper.UserInfo)localObject, "", 0L, 1000, 2, "", a());
      return;
    }
    Intent localIntent = new Intent(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("qzone_uin", ((QZoneHelper.UserInfo)localObject).a);
    localIntent.putExtra("nickname", ((QZoneHelper.UserInfo)localObject).b);
    Object localObject = QzoneConfig.a().a("MiniVideo", "FileSizeLimit");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (long l1 = 1048576000L;; l1 = Long.valueOf((String)localObject).longValue())
    {
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", l1);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", QzoneConfig.a().a("MiniVideo", "VideoDurationThreshold", 60000));
      localIntent.putExtra("video_refer", a());
      localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramActivity.startActivity(localIntent);
      return;
    }
    label295:
    if ("cover_mall_record_video".equals(a()))
    {
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131492908);
      localObject = paramActivity.getString(2131367100);
      QQToast.a(paramActivity, (CharSequence)localObject, 0).b(i);
      QLog.i(k, 2, "video cover,not support trim," + (String)localObject);
      return;
    }
    localIntent = new Intent("com.tencent.mobileqq.action.publishmood");
    localIntent.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    localIntent.putExtra("key_is_upload_video", true);
    localIntent.putExtra("key_need_load_photo_from_intent", false);
    localIntent.putExtra("key_trim_video_black_list", true);
    localIntent.putExtra("uin", ((QZoneHelper.UserInfo)localObject).a);
    QZoneHelper.b(paramActivity, (QZoneHelper.UserInfo)localObject, localIntent, 1000);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(k, 2, "onActivityResult");
    }
    if (paramActivity == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      bool = paramIntent.getBooleanExtra("finish_video_component", false);
      if (QLog.isColorLevel()) {
        QLog.d(k, 1, "doFinish=" + bool);
      }
    } while ((-1 != paramInt2) || (!bool));
    paramActivity.finish();
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(k, 2, "sendClick");
    }
    if (paramIntent == null) {
      return;
    }
    String str1 = paramIntent.getStringExtra("file_video_source_dir");
    String str2 = paramIntent.getStringExtra("thumbfile_send_path");
    int i = paramIntent.getIntExtra("thumbfile_send_width", -1);
    int j = paramIntent.getIntExtra("thumbfile_send_height", -1);
    int i1 = paramIntent.getIntExtra("sv_total_record_time", -1);
    int i2 = paramIntent.getIntExtra("sv_total_frame_count", -1);
    int i3 = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    int i4 = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    int i5 = paramIntent.getIntExtra("sv_encode_qmax", -1);
    int i6 = paramIntent.getIntExtra("sv_encode_qmin", -1);
    int i7 = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    int i8 = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    int i9 = paramIntent.getIntExtra("sv_encode_smooth", -1);
    int i10 = paramIntent.getIntExtra("video_mood_priv", -1);
    Object localObject2 = paramIntent.getStringExtra("video_mood_content");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = paramIntent.getStringArrayListExtra("video_mood_privUinList");
    boolean bool = paramIntent.getBooleanExtra("enable_edit_video", false);
    paramIntent = new Bundle();
    paramIntent.putInt("sv_encode_max_bitrate", i3);
    paramIntent.putInt("sv_encode_min_bitrate", i4);
    paramIntent.putInt("sv_encode_qmax", i5);
    paramIntent.putInt("sv_encode_qmin", i6);
    paramIntent.putInt("sv_encode_qmaxdiff", i7);
    paramIntent.putInt("sv_total_frame_count", i2);
    paramIntent.putInt("sv_total_record_time", i1);
    if ("cover_mall_record_video".equals(a()))
    {
      QLog.d(k, 2, "record video open video preview activity.");
      paramIntent.putInt("sv_encode_ref_frame", i8);
      paramIntent.putInt("sv_encode_smooth", i9);
      QZoneHelper.a(paramActivity, 0, null, true, str1, str2, i, j, i1, 0L, i1, 0L, i2, paramIntent, "", "", a());
      return;
    }
    if (bool)
    {
      a(0, true, str1, str2, i, j, i1, 0L, i1, 0L, i2, paramIntent, "", "", "", i10, (String)localObject1, (ArrayList)localObject2);
      return;
    }
    a(paramActivity, 0, true, str1, str2, i, j, i1, 0L, i1, 0L, i2, paramIntent, "", "", "");
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\VideoComponentCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */