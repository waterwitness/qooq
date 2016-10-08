import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class izh
  extends BroadcastReceiver
{
  public izh(FFmpeg paramFFmpeg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      if ((this.a.jdField_a_of_type_Izi != null) && (!this.a.jdField_a_of_type_Izi.a())) {
        this.a.jdField_a_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.e("FFmepg", 2, "屏幕灭屏了，杀掉FFmpeg的进程与线程");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.a.jdField_a_of_type_Boolean));
      this.a.jdField_a_of_type_Boolean = false;
    } while ((this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit == null) || (this.a.d == 55537) || (this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a == null));
    if (this.a.d == 1)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a.a("灭屏后，FFmpeg任务执行成功");
      this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a.a(true);
    }
    for (;;)
    {
      this.a.d = 55537;
      return;
      this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a.b("灭屏幕，FFmpeg任务执行失败");
      this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a.a(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */