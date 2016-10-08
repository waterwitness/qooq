import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.QZoneObserver;
import mqq.app.AppRuntime;

public class orx
  extends QZoneObserver
{
  public orx()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof get_albumlist_num_rsp))) {
      PhotoListActivity.d = ((get_albumlist_num_rsp)paramBundle).album_num;
    }
    BaseApplicationImpl.a().a().unRegistObserver(PhotoListActivity.a());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */