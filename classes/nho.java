import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public final class nho
  implements Runnable
{
  public nho(Context paramContext, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "fav action number is 144");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */