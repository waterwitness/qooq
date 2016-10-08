import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.RecommendTroopAdapter;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class vfv
  implements BusinessObserver
{
  public vfv(RecommendTroopAdapter paramRecommendTroopAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopAdapter", 4, "delRecommendTroop");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */