import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class izj
  extends ExecuteBinResponseCallback
{
  public izj(ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(String paramString)
  {
    String str = "音乐截成功,耗时:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.w("FFmepg", 2, str + '\n' + paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FFmepg", 2, paramString);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegExecuteBinResponseCallback.b(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */