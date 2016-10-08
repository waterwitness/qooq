import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class mze
  extends ContactBindObserver
{
  public mze(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */