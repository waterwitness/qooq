package com.tencent.biz.qqstory.pgc.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CoverOnlyContentView
  extends BaseContentPagerView
{
  public CoverOnlyContentView(Context paramContext, Story paramStory, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramStory, paramOnClickListener);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a.a.setVisibility(8);
  }
  
  public View a()
  {
    return null;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public boolean b(int paramInt)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\CoverOnlyContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */