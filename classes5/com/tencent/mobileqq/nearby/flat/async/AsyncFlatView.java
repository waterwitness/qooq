package com.tencent.mobileqq.nearby.flat.async;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.flat.adapter.FreshFeedPresenter;
import com.tencent.mobileqq.nearby.flat.canvas.AbstractUIElement;
import com.tencent.mobileqq.nearby.flat.canvas.ImageElement;
import com.tencent.mobileqq.nearby.flat.canvas.UIElement;
import com.tencent.mobileqq.nearby.flat.canvas.UIElementView;
import com.tencent.mobileqq.nearby.flat.widget.FreshElement;
import java.util.Iterator;
import java.util.List;

public class AsyncFlatView
  extends UIElementView
  implements FreshFeedPresenter
{
  Object a = new Object();
  
  public AsyncFlatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AsyncFlatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(Context arg1, FNDefaultItemData paramFNDefaultItemData, Bitmap paramBitmap, FNDefaultItemBuilder paramFNDefaultItemBuilder)
  {
    paramFNDefaultItemData = AsyncFlatElementFactory.a(getContext(), paramFNDefaultItemData, paramBitmap, paramFNDefaultItemBuilder);
    synchronized (this.a)
    {
      setUIElement(paramFNDefaultItemData);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    FreshElement localFreshElement = (FreshElement)((AsyncFlatElement)a()).a();
    if ((localFreshElement.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement != null) && (localFreshElement.a())) {
      synchronized (this.a)
      {
        localFreshElement.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(paramBitmap);
        return;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (AppSetting.j) {
      return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setChildTag(int paramInt, Object paramObject)
  {
    Iterator localIterator = ((FreshElement)((AsyncFlatElement)a()).a()).jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      UIElement localUIElement = (UIElement)localIterator.next();
      if ((localUIElement instanceof AbstractUIElement)) {
        ((AbstractUIElement)localUIElement).a(paramInt, paramObject);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\async\AsyncFlatView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */