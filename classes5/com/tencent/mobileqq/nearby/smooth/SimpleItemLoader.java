package com.tencent.mobileqq.nearby.smooth;

import android.view.View;
import android.widget.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class SimpleItemLoader
  extends ItemLoader
{
  public SimpleItemLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public final int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  public abstract Object a(Object paramObject);
  
  public final Object a(Object paramObject, int paramInt)
  {
    return b(paramObject);
  }
  
  public final void a(View paramView, Object paramObject, int paramInt, boolean paramBoolean)
  {
    a(paramView, paramObject, paramBoolean);
  }
  
  public abstract void a(View paramView, Object paramObject, boolean paramBoolean);
  
  public final boolean a(Adapter paramAdapter, int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public abstract Object b(Object paramObject);
  
  public final Object b(Object paramObject, int paramInt)
  {
    return a(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\smooth\SimpleItemLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */