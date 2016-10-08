package cooperation.huangye;

import android.content.Context;
import android.view.GestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HYTopGestureLayout
  extends TopGestureLayout
{
  public HYTopGestureLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Context paramContext)
  {
    this.mTopGestureDetector = new GestureDetector(paramContext, new HYTopGestureLayout.HYTopGestureDetector(this, paramContext));
    super.setContentDescription("HYTopGestureLayout");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYTopGestureLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */