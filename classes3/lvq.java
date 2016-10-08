import android.content.Intent;
import com.tencent.mobileqq.activity.ModifyTroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lvq
  implements Runnable
{
  lvq(lvp paramlvp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.a();
    Intent localIntent = new Intent();
    localIntent.putExtra("troopmembercardchanged", true);
    this.a.a.setResult(-1, localIntent);
    this.a.a.finish();
    this.a.a.overridePendingTransition(0, 2130968584);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */