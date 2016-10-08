import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ClearableEditText;

class mon
  implements Runnable
{
  mon(mom parammom)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = SubLoginActivity.a(this.a.a).getText().toString();
    if ((str != null) && (str.equals("!@#ewaGbhkc$!!="))) {
      SubLoginActivity.a(this.a.a).setText("");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */