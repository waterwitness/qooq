package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import tqh;
import tqj;
import tqk;
import tql;
import tqm;

public final class ItemManager
{
  static final int jdField_a_of_type_Int = 1;
  static final int b = 550;
  long jdField_a_of_type_Long;
  public final Handler a;
  final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  public tqh a;
  final boolean jdField_a_of_type_Boolean;
  public boolean b;
  final int c;
  public boolean c;
  public int d;
  
  private ItemManager(ItemLoader paramItemLoader, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Tqh = null;
    this.jdField_a_of_type_AndroidOsHandler = new tqk(null);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_AndroidOsHandler, paramInt2);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.c = paramInt1;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.d = 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Tqh == null) {}
    AbsListView localAbsListView;
    ListAdapter localListAdapter;
    do
    {
      return;
      localAbsListView = this.jdField_a_of_type_Tqh.a();
      localListAdapter = this.jdField_a_of_type_Tqh.a();
      this.b = false;
    } while (localListAdapter == null);
    long l1 = SystemClock.uptimeMillis();
    int j = localAbsListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localAbsListView.getChildAt(i);
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localAbsListView, localListAdapter, localView, l1);
      i += 1;
      l1 += 1L;
    }
    long l3 = l1;
    if (this.jdField_a_of_type_Boolean)
    {
      j = localAbsListView.t() + 1;
      long l2 = l1;
      if (j > 0)
      {
        int k = localListAdapter.getCount();
        i = j;
        for (;;)
        {
          l2 = l1;
          if (i >= this.c + j) {
            break;
          }
          l2 = l1;
          if (i >= k) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localAbsListView, localListAdapter, i, l1);
          i += 1;
          l1 += 1L;
        }
      }
      j = localAbsListView.s();
      l3 = l2;
      if (j >= this.c)
      {
        i = j - 1;
        for (;;)
        {
          l3 = l2;
          if (i < j - this.c) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localAbsListView, localListAdapter, i, l2);
          i -= 1;
          l2 += 1L;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = l3;
    localAbsListView.invalidate();
  }
  
  public void a(View paramView1, View paramView2, int paramInt)
  {
    this.jdField_a_of_type_Tqh.a();
    ListAdapter localListAdapter = this.jdField_a_of_type_Tqh.a();
    if ((this.d != 2) && (!this.b)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(paramView1, paramView2, localListAdapter, paramInt, bool);
      return;
    }
  }
  
  public void a(tqh paramtqh)
  {
    this.jdField_a_of_type_Tqh = paramtqh;
    if (this.jdField_a_of_type_Tqh != null)
    {
      paramtqh = this.jdField_a_of_type_Tqh.a();
      paramtqh.setOnScrollListener(new tql(this, null));
      paramtqh.setOnTouchListener(new tqj(this, null));
      paramtqh.setOnItemSelectedListener(new tqm(this, null));
    }
  }
  
  public void b()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, this);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.b = true;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Tqh == null) {
      throw new IllegalStateException("Cannot cancel requests with no managed view");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Tqh.a());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\smooth\ItemManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */