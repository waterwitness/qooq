import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OnGetPhotoWallListener;
import com.tencent.widget.ListView.OnScrollChangeListener;

public class llm
  implements ListView.OnScrollChangeListener
{
  public llm(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 + paramInt2 != paramInt3) || (paramInt3 <= 0) || (this.a.a()) || (!NetworkUtil.e(this.a))) {}
    while ((this.a.a == null) || (!this.a.a.a())) {
      return;
    }
    this.a.a.a();
    this.a.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */