import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.activity.HotChatAnnounceActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class low
  implements TextWatcher
{
  public low(HotChatAnnounceActivity paramHotChatAnnounceActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    int i = 0;
    if (!TextUtils.isEmpty(paramEditable)) {
      i = paramEditable.getBytes().length / 3;
    }
    if (i <= 40) {
      this.a.a.setTextColor(this.a.getResources().getColor(2131428302));
    }
    for (;;)
    {
      this.a.a.setText("" + (40 - i));
      return;
      this.a.a.setTextColor(-65536);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\low.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */