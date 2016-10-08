package com.tencent.mobileqq.nearby.rn;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.react.ReactRootView;
import com.tencent.bitapp.bundle.BundleFacade;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.bundle.IBundleListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import java.lang.ref.WeakReference;
import tpj;

public class NearbyBaseRRV
  extends ReactRootView
{
  public static final String TAG = NearbyBaseRRV.class.getSimpleName();
  public com.tencent.bitapp.bundle.Bundle mBundle;
  IBundleListener mBundleListener = null;
  String mFile;
  public String mKey;
  public android.os.Bundle mLaunchOptions = new android.os.Bundle();
  public NearbyBaseRRV.INearbyBaseRRVListener mListener;
  int mModuleId;
  int mModuleVersion;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NearbyBaseRRV(Context paramContext)
  {
    super(paramContext);
  }
  
  public NearbyBaseRRV(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NearbyBaseRRV(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void addLaunchOption(String paramString1, String paramString2)
  {
    this.mLaunchOptions.putString(paramString1, paramString2);
  }
  
  public void initViews(int paramInt1, int paramInt2, String paramString, NearbyBaseRRV.INearbyBaseRRVListener paramINearbyBaseRRVListener)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "initViews", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    this.mModuleId = paramInt1;
    this.mModuleVersion = paramInt2;
    this.mFile = paramString;
    this.mListener = paramINearbyBaseRRVListener;
    this.mKey = String.valueOf(this.mModuleId);
    if (this.mBundleListener == null) {
      this.mBundleListener = new tpj(this);
    }
    paramINearbyBaseRRVListener = BundleStructCache.INSTANCE.get(this.mModuleId);
    paramString = paramINearbyBaseRRVListener;
    if (paramINearbyBaseRRVListener.module_version < this.mModuleVersion)
    {
      paramString = new BundleStruct(this.mModuleId);
      paramString.module_version = this.mModuleVersion;
    }
    if (!TextUtils.isEmpty(this.mFile)) {
      paramString.localFile = this.mFile;
    }
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "initViews", new Object[] { this.mBundleListener, paramString });
    }
    BundleFacade.loadBundle(paramString, new WeakReference(this.mBundleListener));
  }
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyBaseRRV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */