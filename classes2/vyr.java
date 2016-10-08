import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ImageCreator;
import com.tencent.mobileqq.util.ImageWorker;

public class vyr
  implements ImageCreator
{
  String jdField_a_of_type_JavaLangString;
  
  public vyr(ImageWorker paramImageWorker, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */