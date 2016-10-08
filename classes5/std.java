import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.util.FaceDrawable;

public class std
  extends NearbyCardObserver
{
  public std(HotChatMemberListActivity paramHotChatMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramNearbyPeopleCard != null) && (this.a.app.a().equals(paramNearbyPeopleCard.uin)) && (this.a.e != null))
    {
      paramNearbyPeopleCard = (stz)this.a.e.getTag();
      if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.d != null)) {
        break label64;
      }
    }
    label64:
    do
    {
      return;
      paramNearbyPeopleCard.d.setBackgroundDrawable(FaceDrawable.a(this.a.app, 200, paramNearbyPeopleCard.b, true));
    } while (this.a.a == null);
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\std.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */