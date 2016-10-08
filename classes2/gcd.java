import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.AITranslator;
import com.rookery.translate.AITranslator.TranslatorType;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.Header;

public class gcd
  extends AsyncHttpResponseHandler
{
  public gcd(AITranslator paramAITranslator, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    if (paramString.equalsIgnoreCase("1"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Translator", 2, "[policy update]: GOOGLE");
      }
      AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, Boolean.valueOf(true));
      AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, AITranslator.TranslatorType.GOOGLE, 0L);
      AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, AITranslator.TranslatorType.MS, 200000L);
    }
    do
    {
      return;
      if (paramString.equals("2"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[policy update]: MS");
        }
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, Boolean.valueOf(true));
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, AITranslator.TranslatorType.MS, 0L);
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, AITranslator.TranslatorType.GOOGLE, 200000L);
        return;
      }
      if (paramString.equals("0"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[policy update]: stop service");
        }
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, Boolean.valueOf(false));
        return;
      }
      if (paramString.equals("3"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[policy update]: decide by Client");
        }
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, Boolean.valueOf(true));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Translator", 2, "[policy update]: Update Failed");
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "update policy error" + paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */