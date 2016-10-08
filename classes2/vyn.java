import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ImageCreator;
import com.tencent.mobileqq.util.ImageWorker;

public class vyn
  implements Runnable
{
  public vyn(ImageWorker paramImageWorker, vyq paramvyq, String paramString, ImageCreator paramImageCreator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Vyq.a(new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilImageCreator, Boolean.valueOf(true) });
    ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker).post(new vyo(this, localDrawable));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */