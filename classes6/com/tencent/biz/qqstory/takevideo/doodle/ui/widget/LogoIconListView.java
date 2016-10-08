package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.takevideo.doodle.compat.ViewCompat;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LogoIconAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;

public class LogoIconListView
  extends HorizontalListView
  implements FaceViewPager.PageChangedObserver
{
  private int a;
  
  public LogoIconListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
  }
  
  public void b(int paramInt)
  {
    LogoIconAdapter localLogoIconAdapter = (LogoIconAdapter)a();
    if ((paramInt < 0) || (paramInt >= localLogoIconAdapter.getCount())) {
      return;
    }
    Object localObject = (FacePackage)localLogoIconAdapter.getItem(paramInt);
    int i;
    if ((localObject != null) && ("LocationFacePackage".equals(((FacePackage)localObject).a())))
    {
      if (DoodleLayout.a)
      {
        localObject = "2";
        DoodleLayout.a("exp_place", 0, 0, new String[] { localObject });
      }
    }
    else
    {
      localLogoIconAdapter.a(paramInt);
      i = localLogoIconAdapter.a();
      if ((this.a >= getFirstVisiblePosition()) && (this.a <= getLastVisiblePosition())) {
        ViewCompat.a(b(this.a), 0.5F);
      }
      if ((paramInt >= getFirstVisiblePosition()) && (paramInt <= getLastVisiblePosition())) {
        ViewCompat.a(b(paramInt), 1.0F);
      }
      if (paramInt > getFirstVisiblePosition()) {
        break label178;
      }
      i = -i;
      a(getFirstVisiblePosition(), i, 100);
    }
    for (;;)
    {
      this.a = paramInt;
      return;
      localObject = "1";
      break;
      label178:
      if (paramInt >= getLastVisiblePosition()) {
        a(getFirstVisiblePosition(), i, 100);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\widget\LogoIconListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */