import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class izf
  extends ExecuteBinResponseCallback
{
  public izf(FFmpeg paramFFmpeg, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString) {}
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FFmepg", 2, paramString);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.b(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */