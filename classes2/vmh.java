import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import java.util.List;

public class vmh
  extends FriendListObserver
{
  public vmh(TroopEntranceBar paramTroopEntranceBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.a != null) && (this.a.a.size() > 0) && (paramString.equals(((TroopInfo)this.a.a.get(0)).troopuin))) {
      this.a.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */