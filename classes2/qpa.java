import com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback;
import com.tencent.mobileqq.ar.ARScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qpa
  implements ARNativeBridge.ActionCallback
{
  public qpa(ARScene paramARScene, qpc paramqpc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (this.jdField_a_of_type_Qpc != null) {
      this.jdField_a_of_type_Qpc.a(paramString1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */