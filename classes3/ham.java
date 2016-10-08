import android.graphics.Rect;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ham
  implements Runnable
{
  static final int c = 9;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  int b;
  
  public ham(VideoLayerUI paramVideoLayerUI, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Int = paramInt;
    paramVideoLayerUI = paramVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.jdField_a_of_type_Int];
    Rect localRect = paramVideoLayerUI.b();
    this.jdField_a_of_type_Float = (localRect.width() / 10.0F);
    paramInt = localRect.right;
    int i = localRect.width();
    paramVideoLayerUI.b(paramInt, localRect.top, i + paramInt, localRect.bottom);
    paramVideoLayerUI.x();
  }
  
  public void run()
  {
    if (this.b == 9) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(false);
    }
    for (;;)
    {
      this.b += 1;
      if (this.b <= 9) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 30L);
      }
      return;
      GLVideoView localGLVideoView = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.jdField_a_of_type_Int];
      Rect localRect = localGLVideoView.b();
      int i = (int)(localRect.left - this.jdField_a_of_type_Float);
      int j = localRect.width();
      localGLVideoView.b(i, localRect.top, j + i, localRect.bottom);
      localGLVideoView.x();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ham.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */