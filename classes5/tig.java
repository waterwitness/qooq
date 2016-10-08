import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;

public final class tig
  implements Runnable
{
  public tig(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2 = this.a.a().createEntityManager();
    Object localObject1 = (Card)((EntityManager)localObject2).a(Card.class, this.a.a());
    if ((localObject1 != null) && (((Card)localObject1).iVoteIncrement > 0))
    {
      ((Card)localObject1).iVoteIncrement = 0;
      ((EntityManager)localObject2).a((Entity)localObject1);
    }
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject2).a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.a() });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.likeCountInc > 0))
    {
      localNearbyPeopleCard.likeCountInc = 0;
      ((EntityManager)localObject2).a(localNearbyPeopleCard);
    }
    ((EntityManager)localObject2).a();
    localObject2 = this.a.getAccount();
    long l;
    if (localObject1 == null)
    {
      l = 0L;
      NearbySPUtil.a((String)localObject2, l, 0);
      this.a.a().getSharedPreferences(this.a.a(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", 0).commit();
      if (!ConnectNearbyProcService.a()) {
        break label192;
      }
      NearbyProxy.a(this.a.a(), 4119);
    }
    label192:
    do
    {
      return;
      l = ((Card)localObject1).lVoteCount;
      break;
      localObject1 = NearbyMineHelper.a(this.a);
    } while (localObject1 == null);
    ((NearbyMyTabCard)localObject1).newLikeNum = 0;
    NearbyMineHelper.a(this.a, (NearbyMyTabCard)localObject1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */