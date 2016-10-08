package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class XExpandableListView
  extends ExpandableListView
{
  public XExpandableListView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public XExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842863);
  }
  
  public XExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a_ = Integer.MAX_VALUE;
    setEdgeEffectEnabled(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\XExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */