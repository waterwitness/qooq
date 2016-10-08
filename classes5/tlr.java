import android.text.TextUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class tlr
  implements DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback
{
  public tlr(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.a.n)) {
      return;
    }
    this.a.runOnUiThread(new tls(this, paramString, paramBoolean1));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */