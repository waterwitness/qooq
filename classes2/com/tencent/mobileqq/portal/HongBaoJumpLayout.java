package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HongBaoJumpLayout
  extends View
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public HongBaoJumpLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public HongBaoJumpLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public BitmapDrawable a()
  {
    return null;
  }
  
  public BaseAnimHolder a()
  {
    return new BaseAnimHolder();
  }
  
  public void a()
  {
    this.a = getResources().getDimensionPixelOffset(2131493762);
    this.b = getResources().getDimensionPixelOffset(2131493763);
    this.c = getResources().getDimensionPixelOffset(2131493765);
    this.d = getResources().getDimensionPixelOffset(2131493764);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public BitmapDrawable b()
  {
    return null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\HongBaoJumpLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */