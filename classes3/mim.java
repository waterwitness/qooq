import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.UnsupportedEncodingException;

public class mim
  implements TextWatcher
{
  public mim(RegisterByNicknameAndPwdActivity paramRegisterByNicknameAndPwdActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {}
    for (;;)
    {
      return;
      String str1 = paramEditable.toString();
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = str1.substring(str1.length() - 1, str1.length());
        try
        {
          if (str2.length() < str2.getBytes("utf-8").length)
          {
            paramEditable.delete(str1.length() - 1, str1.length());
            return;
          }
        }
        catch (UnsupportedEncodingException paramEditable)
        {
          paramEditable.printStackTrace();
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */