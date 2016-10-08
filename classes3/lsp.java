import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CustomSafeEditText;

class lsp
  implements Runnable
{
  lsp(lso paramlso)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = this.a.a.a.getText().toString();
    if ((str != null) && (str.equals("!@#ewaGbhkc$!!="))) {
      this.a.a.a.setText("");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */