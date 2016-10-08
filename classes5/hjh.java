import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hjh
  implements TextView.OnEditorActionListener
{
  public hjh(SearchActivity paramSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 84) {}
      }
    }
    else
    {
      if (!TextUtils.isEmpty(this.a.a.getText())) {
        SearchActivity.a(this.a);
      }
      paramTextView = this.a.a.getText().toString();
      this.a.a.setSelection(paramTextView.length());
      this.a.b = false;
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */