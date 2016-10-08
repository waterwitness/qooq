import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class otv
  implements TextWatcher
{
  public otv(TransactionActivity paramTransactionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TransactionActivity.a(this.a).getVisibility() == 0) {
      if (TransactionActivity.a(this.a).getText().length() > 4) {
        if (!TransactionActivity.a(this.a).isEnabled())
        {
          TransactionActivity.a(this.a).setEnabled(true);
          TransactionActivity.a(this.a).setClickable(true);
          this.a.a(TransactionActivity.a(this.a), 128, "transfer.qqid.enable", "", "", TransactionActivity.a(this.a), "");
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!TransactionActivity.a(this.a).isEnabled());
        TransactionActivity.a(this.a).setClickable(false);
        TransactionActivity.a(this.a).setEnabled(false);
        this.a.a(TransactionActivity.a(this.a), 128, "transfer.qqid.disable", "", "", TransactionActivity.a(this.a), "");
        return;
        if ((TransactionActivity.b(this.a).getText().length() <= 0) || (TransactionActivity.b(this.a).getText().toString().startsWith(".")) || (TransactionActivity.b(this.a).getText().toString().endsWith(".")) || (!TransactionActivity.a(this.a, TransactionActivity.b(this.a).getText().toString()))) {
          break;
        }
      } while (TransactionActivity.b(this.a).isEnabled());
      TransactionActivity.b(this.a).setEnabled(true);
      TransactionActivity.b(this.a).setClickable(true);
      this.a.a(TransactionActivity.a(this.a), 128, "transfer.amount.enable", "", "", TransactionActivity.a(this.a), "");
      return;
    } while (!TransactionActivity.b(this.a).isEnabled());
    TransactionActivity.b(this.a).setClickable(false);
    TransactionActivity.b(this.a).setEnabled(false);
    this.a.a(TransactionActivity.a(this.a), 128, "transfer.amount.disable", "", "", TransactionActivity.a(this.a), "");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */