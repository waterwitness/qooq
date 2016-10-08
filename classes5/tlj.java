import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.qphone.base.util.QLog;

public class tlj
  extends FriendListObserver
{
  public tlj(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!NearbyPeopleProfileActivity.a(this.a).uin.equals(paramSetting.uin))) {
      return;
    }
    if ((paramSetting.bFaceFlags & 0x20) != 0) {
      this.a.S = 0;
    }
    for (;;)
    {
      this.a.C = paramSetting.url;
      if (NearbyPeopleProfileActivity.a(this.a) != null) {
        NearbyPeopleProfileActivity.a(this.a).h();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.nearby_people_card.", 2, "onGetHeadInfo mheadSize is: " + this.a.S + " mGetHeadUrl is: " + this.a.C);
      return;
      if ((paramSetting.bFaceFlags & 0x10) != 0) {
        this.a.S = 640;
      } else if ((paramSetting.bFaceFlags & 0x8) != 0) {
        this.a.S = 140;
      } else if ((paramSetting.bFaceFlags & 0x4) != 0) {
        this.a.S = 100;
      } else {
        this.a.S = 40;
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((this.a.D != 3) || (this.a.f) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    d();
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onUpdateStangerHead: " + paramBoolean1 + "isStrangerHead: " + paramBoolean2);
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (NearbyPeopleProfileActivity.a(this.a) != null) && (paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin)) && (paramBoolean2) && ((this.a.S == 640) || (this.a.S == 0)) && (!TextUtils.isEmpty(this.a.C)) && (!this.a.g)) {
      this.a.a(paramString, this.a.S, this.a.C, true);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (!paramBoolean2)) {}
    while ((this.a.D != 3) || (NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    d();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3) || (TextUtils.isEmpty(paramString))) {}
    while ((this.a.D != 3) || (this.a.f) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    d();
  }
  
  public void d()
  {
    boolean bool = this.a.f;
    FriendsManager localFriendsManager = (FriendsManager)this.a.app.getManager(50);
    if (localFriendsManager != null) {
      bool = localFriendsManager.b(NearbyPeopleProfileActivity.a(this.a).uin);
    }
    for (;;)
    {
      if (bool != this.a.f)
      {
        this.a.f = bool;
        this.a.runOnUiThread(new tlk(this));
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */