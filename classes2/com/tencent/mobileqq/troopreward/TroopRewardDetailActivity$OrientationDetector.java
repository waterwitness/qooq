package com.tencent.mobileqq.troopreward;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class TroopRewardDetailActivity$OrientationDetector
  extends OrientationEventListener
{
  WeakReference a;
  
  public TroopRewardDetailActivity$OrientationDetector(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  public void a(RewardImageDetailView paramRewardImageDetailView)
  {
    this.a = new WeakReference(paramRewardImageDetailView);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (this.a != null)
    {
      RewardImageDetailView localRewardImageDetailView = (RewardImageDetailView)this.a.get();
      if (localRewardImageDetailView != null) {
        localRewardImageDetailView.a(paramInt);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopreward\TroopRewardDetailActivity$OrientationDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */