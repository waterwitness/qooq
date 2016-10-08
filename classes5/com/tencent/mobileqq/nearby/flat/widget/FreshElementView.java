package com.tencent.mobileqq.nearby.flat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.flat.adapter.FreshFeedPresenter;
import com.tencent.mobileqq.nearby.flat.canvas.UIElementView;

public class FreshElementView
  extends UIElementView
  implements FreshFeedPresenter
{
  public FreshElementView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FreshElementView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setUIElement(new FreshElement(this));
  }
  
  public void a(Context paramContext, FNDefaultItemData paramFNDefaultItemData, Bitmap paramBitmap, FNDefaultItemBuilder paramFNDefaultItemBuilder)
  {
    ((FreshElement)a()).a(paramContext, paramFNDefaultItemData, paramBitmap, paramFNDefaultItemBuilder);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\widget\FreshElementView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */