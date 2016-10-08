package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iye;
import java.util.ArrayList;
import java.util.List;

public class FaceViewPager
  extends ViewPager
{
  private List a;
  
  public FaceViewPager(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b();
  }
  
  public FaceViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    this.a = new ArrayList();
    setOnPageChangeListener(new iye(this));
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(FaceViewPager.PageChangedObserver paramPageChangedObserver)
  {
    if (!this.a.contains(paramPageChangedObserver)) {
      this.a.add(paramPageChangedObserver);
    }
  }
  
  public void b(FaceViewPager.PageChangedObserver paramPageChangedObserver)
  {
    if (this.a.contains(paramPageChangedObserver)) {
      this.a.remove(paramPageChangedObserver);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\widget\FaceViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */