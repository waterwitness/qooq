import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hag
  implements Runnable
{
  long jdField_a_of_type_Long;
  
  public hag(VideoLayerUI paramVideoLayerUI, long paramLong, GLVideoView paramGLVideoView, float paramFloat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void run()
  {
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = (1L + l);
    if (l < this.b)
    {
      this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(this.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f);
      this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(this, 10L);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(0, 0, true);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e = -1;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */