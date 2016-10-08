import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.BannerConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.EcShopADView;
import com.tencent.mobileqq.widget.WorkSpaceView;
import com.tencent.mobileqq.widget.WorkSpaceView.OnScreenChangeListener;

public class wmb
  implements WorkSpaceView.OnScreenChangeListener
{
  public wmb(EcShopADView paramEcShopADView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = (ViewGroup)this.a.b.getChildAt(0);
    this.a.a = ((WorkSpaceView)((ViewGroup)localObject1).getChildAt(0));
    localObject1 = (LinearLayout)((ViewGroup)localObject1).getChildAt(1);
    Object localObject2 = (ViewGroup)this.a.a.getChildAt(paramInt);
    if ((localObject2 instanceof FrameLayout))
    {
      localObject2 = (ImageView)((ViewGroup)localObject2).findViewById(2131298834);
      if ((localObject2 != null) && ((((ImageView)localObject2).getTag() instanceof EcShopAssistantManager.BannerConfig))) {
        ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_banner", "Pv_shopbanner", 0, 0, "", "", ((EcShopAssistantManager.BannerConfig)((ImageView)localObject2).getTag()).d, "");
      }
    }
    int j = ((LinearLayout)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject2 = ((LinearLayout)localObject1).getChildAt(i);
      if (localObject2 != null) {
        ((View)localObject2).setEnabled(false);
      }
      i += 1;
    }
    if (this.a.e) {
      if (paramInt == -1) {
        i = j - 1;
      }
    }
    for (;;)
    {
      if ((i > -1) && (i < j))
      {
        localObject1 = ((LinearLayout)localObject1).getChildAt(i);
        if (localObject1 != null) {
          ((View)localObject1).setEnabled(true);
        }
      }
      return;
      i = paramInt;
      if (paramInt == j)
      {
        i = 0;
        continue;
        if (paramInt == -1)
        {
          i = 0;
        }
        else
        {
          i = paramInt;
          if (paramInt == j) {
            i = j - 1;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */