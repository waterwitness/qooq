import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class vpk
  implements Runnable
{
  public vpk(boolean paramBoolean, Context paramContext, String paramString, int paramInt)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_JavaLangString, 0).b(this.jdField_a_of_type_Int);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2130838454, this.jdField_a_of_type_JavaLangString, 0).b(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */