import android.app.Activity;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oip
  implements AddContactTroopHandler.IGetPopClassAndSearchCB
{
  public oip(TroopView paramTroopView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((this.a.a == null) || (this.a.a.a() == null) || (this.a.a.a().isFinishing())) {
      return;
    }
    TroopView.d(this.a, true);
    TroopView.e(this.a, true);
    TroopView.a(this.a).sendEmptyMessage(4);
  }
  
  public void b()
  {
    if ((this.a.a == null) || (this.a.a.a() == null) || (this.a.a.a().isFinishing())) {
      return;
    }
    TroopView.d(this.a, true);
    TroopView.e(this.a, false);
    TroopView.a(this.a).sendEmptyMessage(5);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */