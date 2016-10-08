import android.os.Handler;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hbn
  implements Runnable
{
  public hbn(QQFrameByFrameAnimation paramQQFrameByFrameAnimation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.d > 0) && (this.a.c >= this.a.d)) {
      this.a.c();
    }
    do
    {
      do
      {
        return;
        if ((this.a.b > 0) && (this.a.c / this.a.jdField_a_of_type_ArrayOfInt.length >= this.a.b))
        {
          this.a.c();
          return;
        }
        this.a.a();
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.a.jdField_a_of_type_Int);
      } while (this.a.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener == null);
      this.a.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.c();
    } while ((this.a.jdField_a_of_type_ArrayOfInt.length <= 0) || (this.a.c % this.a.jdField_a_of_type_ArrayOfInt.length != 0));
    this.a.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */