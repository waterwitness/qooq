import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.io.UnsupportedEncodingException;

public class rlz
  implements TextWatcher
{
  public rlz(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      if (paramString.length % 3 == 0) {
        return paramString.length / 3;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
    return paramString.length / 3 + 1;
  }
  
  private String a(String paramString)
  {
    while (a(paramString) > 32)
    {
      int i = paramString.length();
      if ((i >= 2) && (Character.isHighSurrogate(paramString.charAt(i - 2)))) {
        paramString = paramString.substring(0, i - 2);
      } else {
        paramString = paramString.substring(0, i - 1);
      }
    }
    return paramString;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.a.getText().toString();
    if (a(paramEditable) > 32)
    {
      int i = this.a.a.getSelectionStart();
      paramEditable = a(paramEditable);
      this.a.a.setText(paramEditable);
      if (i >= paramEditable.length()) {
        this.a.a.setSelection(paramEditable.length());
      }
    }
    if (this.a.h)
    {
      ReportController.b(null, "CliOper", "", "", "0X80050F0", "0X80050F0", 0, 0, "", "", "", "");
      this.a.h = false;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rlz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */