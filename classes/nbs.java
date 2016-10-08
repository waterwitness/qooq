import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;

public class nbs
  extends FriendListObserver
{
  public nbs(ActivateFriendGrid paramActivateFriendGrid)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      if (i < ActivateFriendGrid.a(this.a).size())
      {
        String str = String.valueOf(((ActivateFriendItem)ActivateFriendGrid.a(this.a).get(i)).uin);
        if (paramString.equals(str))
        {
          paramString = ContactUtils.b(ActivateFriendGrid.a(this.a), str, false);
          ((ActivateFriendGridItem)ActivateFriendGrid.b(this.a).get(i)).setNickName(paramString);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    while (i < ActivateFriendGrid.a(this.a).size())
    {
      String str = ContactUtils.k(ActivateFriendGrid.a(this.a), String.valueOf(((ActivateFriendItem)ActivateFriendGrid.a(this.a).get(i)).uin));
      ((ActivateFriendGridItem)ActivateFriendGrid.b(this.a).get(i)).setNickName(str);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */