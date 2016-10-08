import android.text.TextUtils;
import com.hiar.sdk.renderer.HSRenderer;
import com.tencent.mobileqq.ar.ARListener;
import com.tencent.mobileqq.ar.ARScene3DScene;
import com.tencent.mobileqq.ar.ARSceneResConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class qpd
  implements qpc
{
  public qpd(ARScene3DScene paramARScene3DScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "onAnimEnd clipName = " + paramString + ", " + this.a.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_c_of_type_JavaLangString + ", " + this.a.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_c_of_type_JavaUtilArrayList.size());
    }
    int i = this.a.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.a();
    if (i == 3) {
      if (TextUtils.equals(paramString, "ClipBeforeFire"))
      {
        this.a.a(7);
        if (this.a.jdField_a_of_type_ComHiarSdkRendererHSRenderer.a != null) {
          this.a.jdField_a_of_type_ComHiarSdkRendererHSRenderer.a.b(4, this.a.jdField_a_of_type_ComTencentMobileqqArARTarget);
        }
        this.a.a(8);
      }
    }
    while ((i != 2) || (!TextUtils.equals(paramString, "ClipBeforeFire")) || (this.a.jdField_a_of_type_ComHiarSdkRendererHSRenderer.a == null))
    {
      do
      {
        do
        {
          return;
        } while (!TextUtils.equals(paramString, "ClipAfterFire"));
        this.a.a(9);
      } while (this.a.jdField_a_of_type_ComHiarSdkRendererHSRenderer.a == null);
      this.a.jdField_a_of_type_ComHiarSdkRendererHSRenderer.a.b(1, this.a.jdField_a_of_type_ComTencentMobileqqArARTarget);
      return;
    }
    this.a.jdField_a_of_type_ComHiarSdkRendererHSRenderer.a.b(1, this.a.jdField_a_of_type_ComTencentMobileqqArARTarget);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */