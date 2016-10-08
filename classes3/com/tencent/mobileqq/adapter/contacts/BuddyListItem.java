package com.tencent.mobileqq.adapter.contacts;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import java.util.HashMap;
import java.util.Map;
import ppk;

public abstract class BuddyListItem
{
  public static Map a;
  public static final int d = 1;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = -10;
  Context jdField_a_of_type_AndroidContentContext;
  protected BuddyListAdapter a;
  protected BuddyListItem.BuddyListCallback a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Entity a;
  protected SwipRightMenuBuilder a;
  protected int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilMap = new HashMap(5);
  }
  
  protected BuddyListItem(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = paramEntity;
  }
  
  protected static ColorStateList a(Context paramContext, int paramInt)
  {
    ColorStateList localColorStateList2 = (ColorStateList)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    ColorStateList localColorStateList1 = localColorStateList2;
    if (localColorStateList2 == null)
    {
      localColorStateList1 = paramContext.getResources().getColorStateList(paramInt);
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localColorStateList1);
    }
    return localColorStateList1;
  }
  
  protected int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener);
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131493079);
    int j = a();
    int k = b();
    paramContext = a();
    int[] arrayOfInt1 = b();
    int[] arrayOfInt2 = c();
    return new ppk(this, j, k, new int[] { i }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem) {}
  
  public void a(View paramView, int paramInt, BuddyListItem.ViewTag paramViewTag, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity, paramViewTag, paramOnClickListener);; i = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a != -1))
      {
        if (paramInt != this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  public void a(BuddyListAdapter paramBuddyListAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter = paramBuddyListAdapter;
  }
  
  public void a(BuddyListItem.BuddyListCallback paramBuddyListCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListItem$BuddyListCallback = paramBuddyListCallback;
  }
  
  protected int[] a()
  {
    return null;
  }
  
  protected int b()
  {
    return 1;
  }
  
  protected int[] b()
  {
    return null;
  }
  
  protected int[] c()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\contacts\BuddyListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */