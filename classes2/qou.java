import android.view.MotionEvent;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qou
  implements Runnable
{
  public qou(ARGLSurfaceView paramARGLSurfaceView, MotionEvent paramMotionEvent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a(this.jdField_a_of_type_AndroidViewMotionEvent.getRawX(), this.jdField_a_of_type_AndroidViewMotionEvent.getRawY(), 200.0F);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */