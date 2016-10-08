import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class glx
  implements Runnable
{
  public glx(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i;
    int j;
    Object localObject;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      i = this.a.b();
      j = this.a.a();
      localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (this.a.jdField_g_of_type_Boolean) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      ((VideoLayerUI)localObject).a(i, j, bool);
      if (this.a.jdField_f_of_type_Boolean) {
        break;
      }
      return;
    }
    if (this.a.jdField_f_of_type_Int > this.a.e) {
      this.a.jdField_f_of_type_Int = this.a.e;
    }
    if (this.a.jdField_f_of_type_Int < 0) {
      this.a.jdField_f_of_type_Int = 0;
    }
    if (this.a.jdField_g_of_type_Boolean) {
      localObject = this.a;
    }
    for (((RandomDoubleActivity)localObject).jdField_f_of_type_Int += 1;; ((RandomDoubleActivity)localObject).jdField_f_of_type_Int -= 1)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, this.a.jdField_g_of_type_Int);
      return;
      localObject = this.a;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */