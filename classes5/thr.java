import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.qphone.base.util.QLog;

public class thr
  implements FrameSprite.OnFrameEndListener
{
  public thr(NearbyFlowerAnimationController paramNearbyFlowerAnimationController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(NearbyFlowerAnimationController.jdField_a_of_type_JavaLangString, 2, "onFrameEnd");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.post(new ths(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */