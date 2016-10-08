package com.tencent.mobileqq.nearby.flat.async;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.flat.adapter.FreshFeedPresenter;
import com.tencent.mobileqq.nearby.flat.canvas.UIElementWrapper;
import com.tencent.mobileqq.nearby.flat.widget.FreshElement;

public class AsyncFlatElement
  extends UIElementWrapper
  implements FreshFeedPresenter
{
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  
  public AsyncFlatElement(FreshElement paramFreshElement)
  {
    super(paramFreshElement);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(Context paramContext, FNDefaultItemData paramFNDefaultItemData, Bitmap paramBitmap, FNDefaultItemBuilder paramFNDefaultItemBuilder) {}
  
  public void a(Canvas paramCanvas)
  {
    super.a(paramCanvas);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\async\AsyncFlatElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */