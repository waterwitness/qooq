package com.tencent.mobileqq.widget;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class GridListView$GridListAdapter
  extends BaseAdapter
{
  protected int a;
  
  public GridListView$GridListAdapter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 0;
  }
  
  public abstract int a();
  
  public abstract int a(int paramInt);
  
  public abstract int b(int paramInt);
  
  void b(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\GridListView$GridListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */