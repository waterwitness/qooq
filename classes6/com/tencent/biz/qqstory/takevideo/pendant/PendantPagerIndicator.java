package com.tencent.biz.qqstory.takevideo.pendant;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.Pair;
import com.tencent.biz.qqstory.view.PagerIndicator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class PendantPagerIndicator
  extends PagerIndicator
{
  public PendantPagerIndicator(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PendantPagerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a != null) {}
    for (Object localObject = (PagerAdapter)this.a.get();; localObject = null)
    {
      int i = paramInt1;
      if ((localObject instanceof PendantPageAdapter))
      {
        localObject = ((PendantPageAdapter)localObject).a(paramInt1);
        i = ((Integer)((Pair)localObject).first).intValue();
        paramInt2 = ((Integer)((Pair)localObject).second).intValue();
      }
      super.a(i, paramInt2);
      if (paramInt2 > 1) {
        break;
      }
      setVisibility(4);
      return;
    }
    setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\pendant\PendantPagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */