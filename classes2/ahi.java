import com.hiar.sdk.renderer.HSRenderer;
import com.tencent.mobileqq.ar.ARScene3DScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ahi
  implements Runnable
{
  public ahi(HSRenderer paramHSRenderer, ARScene3DScene paramARScene3DScene1, ARScene3DScene paramARScene3DScene2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene != null) && (this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene != this.b)) {
      this.jdField_a_of_type_ComTencentMobileqqArARScene3DScene.b();
    }
    this.b.f();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ahi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */