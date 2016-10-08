import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class oie
  extends FriendListObserver
{
  public oie(SearchBaseFragment paramSearchBaseFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && (SearchBaseFragment.a(this.a) != null) && (SearchBaseFragment.a(this.a).uin.get() == ((Long)paramObject).longValue())) {
      SearchBaseFragment.a(this.a).relation.set(SearchBaseFragment.a(this.a).relation.get() & 0x10);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */