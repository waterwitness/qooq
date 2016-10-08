import com.facebook.react.bridge.UiThreadUtil;
import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.bundle.BundleListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.NearbyBaseRRV;
import com.tencent.mobileqq.nearby.rn.NearbyBaseRRV.INearbyBaseRRVListener;

public class tpj
  extends BundleListener
{
  public tpj(NearbyBaseRRV paramNearbyBaseRRV)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadFail(String paramString, int paramInt)
  {
    super.onLoadFail(paramString, paramInt);
    if (NearbyUtils.a()) {
      NearbyUtils.a(NearbyBaseRRV.TAG, "onLoadFail", new Object[] { String.format("rkey:%s, key:%s errorCode:%d", new Object[] { paramString, this.a.mKey, Integer.valueOf(paramInt) }) });
    }
    if (!NearbyUtils.a(paramString, this.a.mKey)) {}
    while (this.a.mListener == null) {
      return;
    }
    this.a.mListener.a(this.a.mKey, paramInt, null);
  }
  
  public void onLoadSuccess(String paramString, Bundle paramBundle)
  {
    super.onLoadSuccess(paramString, paramBundle);
    if (NearbyUtils.a()) {
      NearbyUtils.a(NearbyBaseRRV.TAG, "onLoadSuccess", new Object[] { String.format("rkey:%s, key:%s", new Object[] { paramString, this.a.mKey }) });
    }
    if (!NearbyUtils.a(paramString, this.a.mKey)) {
      return;
    }
    if (this.a.mListener != null)
    {
      this.a.mListener.d(paramString);
      this.a.mListener.b();
    }
    UiThreadUtil.runOnUiThread(new tpk(this, paramString, paramBundle));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */