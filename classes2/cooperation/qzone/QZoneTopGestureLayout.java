package cooperation.qzone;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import yla;

public class QZoneTopGestureLayout
  extends TopGestureLayout
{
  private static boolean a = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QZoneTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public QZoneTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void setBackEnabled(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  protected void a(Context paramContext)
  {
    a = true;
    this.mTopGestureDetector = new GestureDetector(paramContext, new yla(this, paramContext));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneTopGestureLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */