import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qgm
{
  Context jdField_a_of_type_AndroidContentContext;
  Intent jdField_a_of_type_AndroidContentIntent;
  public String a;
  
  public qgm(StartAppCheckHandler paramStartAppCheckHandler, String paramString, Context paramContext, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */