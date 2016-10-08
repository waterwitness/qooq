import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.profilecard.InterestGuide;
import java.lang.ref.WeakReference;

public final class tle
  implements Runnable
{
  public tle(String paramString, View paramView, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (((Boolean)NearbySPUtil.a(this.jdField_a_of_type_JavaLangString, "interest_guide_key", Boolean.TRUE)).booleanValue())
    {
      InterestGuide.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(new InterestGuide(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int));
      InterestGuide.jdField_a_of_type_JavaLangBoolean = Boolean.TRUE;
      return;
    }
    InterestGuide.jdField_a_of_type_JavaLangBoolean = Boolean.FALSE;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */