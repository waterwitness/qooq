import android.content.Context;
import android.widget.Toast;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mqq.os.MqqHandler;

public class wnz
  extends Toast
{
  private static final int jdField_a_of_type_Int = 3500;
  private static Class jdField_a_of_type_JavaLangClass;
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static final int jdField_b_of_type_Int = 2000;
  private static Field jdField_b_of_type_JavaLangReflectField;
  private static Method jdField_b_of_type_JavaLangReflectMethod;
  
  public wnz(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void cancel()
  {
    try
    {
      if (!QQToast.a(false))
      {
        super.cancel();
        return;
      }
      Object localObject = jdField_a_of_type_JavaLangReflectField.get(this);
      if (jdField_b_of_type_JavaLangReflectMethod == null)
      {
        jdField_b_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getDeclaredMethod("hide", new Class[0]);
        jdField_b_of_type_JavaLangReflectMethod.setAccessible(true);
      }
      jdField_b_of_type_JavaLangReflectMethod.invoke(localObject, new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "", localThrowable);
      }
    }
  }
  
  public void show()
  {
    try
    {
      if (getView() == null) {
        throw new RuntimeException("setView must have been called");
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "", localThrowable);
      }
      return;
    }
    if (!QQToast.a(false))
    {
      super.show();
      return;
    }
    if (jdField_a_of_type_JavaLangReflectField == null)
    {
      jdField_a_of_type_JavaLangReflectField = Toast.class.getDeclaredField("mTN");
      jdField_a_of_type_JavaLangReflectField.setAccessible(true);
    }
    Object localObject = jdField_a_of_type_JavaLangReflectField.get(this);
    if (jdField_a_of_type_JavaLangClass == null) {
      jdField_a_of_type_JavaLangClass = Class.forName("android.widget.Toast$TN");
    }
    if (jdField_b_of_type_JavaLangReflectField == null)
    {
      jdField_b_of_type_JavaLangReflectField = jdField_a_of_type_JavaLangClass.getDeclaredField("mNextView");
      jdField_b_of_type_JavaLangReflectField.setAccessible(true);
    }
    jdField_b_of_type_JavaLangReflectField.set(localObject, getView());
    if (getDuration() == 1) {}
    for (long l = 3500L;; l = 2000L)
    {
      ThreadManager.c().postDelayed(new woa(this), l);
      if (jdField_a_of_type_JavaLangReflectMethod == null)
      {
        jdField_a_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getDeclaredMethod("show", new Class[0]);
        jdField_a_of_type_JavaLangReflectMethod.setAccessible(true);
      }
      jdField_a_of_type_JavaLangReflectMethod.invoke(localObject, new Object[0]);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wnz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */