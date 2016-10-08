import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.qphone.base.util.QLog;

public class tll
  extends HotChatObserver
{
  public tll(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onDismissHotChat.isSuccess=" + paramBoolean + ",groupcode=" + paramString1 + ",result=" + paramInt + ",strError=" + paramString2);
    }
    if ((paramBoolean) && (paramInt == 0) && (NearbyPeopleProfileActivity.a(this.a) != null) && (NearbyPeopleProfileActivity.a(this.a).hotInfo != null) && (paramString1 != null) && (paramString1.equals(NearbyPeopleProfileActivity.a(this.a).hotInfo.troopUin)) && (NearbyPeopleProfileActivity.a(this.a) != null))
    {
      NearbyPeopleProfileActivity.a(this.a).a(null);
      NearbyPeopleProfileActivity.a(this.a).strHotChatInfo = "";
      NearbyPeopleProfileActivity.a(this.a).hotInfo = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */