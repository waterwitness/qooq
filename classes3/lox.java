import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mobileqq.activity.HotChatAnnounceActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lox
  implements TextWatcher
{
  public lox(HotChatAnnounceActivity paramHotChatAnnounceActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if ((paramEditable != null) && (paramEditable.trim().length() > 0))
    {
      this.a.b.setEnabled(true);
      return;
    }
    this.a.b.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */