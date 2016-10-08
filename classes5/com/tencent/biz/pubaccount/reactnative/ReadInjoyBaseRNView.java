package com.tencent.biz.pubaccount.reactnative;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.react.ReactRootView;
import com.tencent.bitapp.bundle.BundleFacade;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.bundle.IBundleListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import hvy;
import java.lang.ref.WeakReference;

public class ReadInjoyBaseRNView
  extends ReactRootView
{
  public static final String TAG = ReadInjoyBaseRNView.class.getSimpleName();
  public com.tencent.bitapp.bundle.Bundle mBundle;
  IBundleListener mBundleListener = null;
  String mFile;
  public String mKey;
  public android.os.Bundle mLaunchOptions = new android.os.Bundle();
  int mModuleId;
  int mModuleVersion;
  private long mTimeStamp;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReadInjoyBaseRNView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInjoyBaseRNView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInjoyBaseRNView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void addLaunchOption(String paramString1, String paramString2)
  {
    this.mLaunchOptions.putString(paramString1, paramString2);
  }
  
  public void initViews(int paramInt1, int paramInt2, String paramString)
  {
    this.mTimeStamp = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "initViews moduleId" + paramInt1 + ";moduleVersion" + paramInt2 + ";file" + paramString);
    }
    this.mModuleId = paramInt1;
    this.mModuleVersion = paramInt2;
    this.mFile = paramString;
    this.mKey = String.valueOf(this.mModuleId);
    if (this.mBundleListener == null) {
      this.mBundleListener = new hvy(this);
    }
    paramString = BundleStructCache.INSTANCE.get(this.mModuleId);
    if (paramString.module_version < this.mModuleVersion)
    {
      paramString = new BundleStruct(this.mModuleId);
      paramString.module_version = this.mModuleVersion;
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X8007139", "0X8007139", 0, 0, "1", "0", "BundleStructCache", "");
      ReportController.b(null, "CliOper", "", "", "0X800713A", "0X800713A", 0, 0, "1", "0", "BundleStructCache", Long.toString(System.currentTimeMillis() - this.mTimeStamp));
      if (!TextUtils.isEmpty(this.mFile)) {
        paramString.localFile = this.mFile;
      }
      BundleFacade.loadBundle(paramString, new WeakReference(this.mBundleListener));
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\reactnative\ReadInjoyBaseRNView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */