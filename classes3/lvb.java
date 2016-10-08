import android.app.Dialog;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class lvb
  implements Runnable
{
  lvb(lva paramlva)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.a, 230).setTitle(this.a.a.getString(2131369387)).setMessage(String.format(this.a.a.getString(2131369388), new Object[] { this.a.a.b })).setPositiveButton(2131367774, new lvc(this));
    localQQCustomDialog.setOnDismissListener(new lvd(this));
    localQQCustomDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */