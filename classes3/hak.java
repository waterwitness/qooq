import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hak
  implements Runnable
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  int c;
  int d;
  int e;
  int f;
  final int g;
  
  public hak(VideoLayerUI paramVideoLayerUI, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 1;
    this.g = 9;
    this.jdField_a_of_type_Float = ((paramInt4 - paramInt2) / 10.0F);
    this.jdField_b_of_type_Float = ((paramInt5 - paramInt3) / 10.0F);
    this.d = paramInt2;
    this.e = paramInt3;
    this.jdField_b_of_type_Int = paramInt4;
    this.c = paramInt5;
    this.f = paramInt1;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 9) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(this.f);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int > 9) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a.a().postDelayed(this, 10L);
      }
      return;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f = false;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.m);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a.a(new Object[] { Integer.valueOf(121) });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */