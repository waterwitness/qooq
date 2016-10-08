import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public final class izk
  extends ExecuteBinResponseCallback
{
  public izk(ExecuteBinResponseCallback paramExecuteBinResponseCallback, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegExecuteBinResponseCallback.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegExecuteBinResponseCallback.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegExecuteBinResponseCallback.a(paramBoolean);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegExecuteBinResponseCallback.b(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */