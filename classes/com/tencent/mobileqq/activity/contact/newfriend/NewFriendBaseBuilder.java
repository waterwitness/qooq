package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import oiw;

public abstract class NewFriendBaseBuilder
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "tag_swip_icon_menu_item";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131368306 };
  public static final int b = 15;
  private static final int[] b = { 2130838383 };
  public static final int c = 0;
  private static final int[] c = { 2131301504 };
  public static final int d = 1;
  private static final int e = -2;
  private static final int f = 1;
  private static final int g = 0;
  private static final int h = 0;
  protected Context a;
  public SystemMsgListAdapter a;
  public QQAppInterface a;
  public NewFriendMessage a;
  protected SwipRightMenuBuilder a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NewFriendBaseBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter = paramSystemMsgListAdapter;
    this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage = paramNewFriendMessage;
  }
  
  public int a()
  {
    return 0;
  }
  
  public abstract View a(int paramInt, View paramView);
  
  protected View a(Context paramContext, int paramInt, NewFriendBaseBuilder.NewFriendBaseHolder paramNewFriendBaseHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter != null) {
      return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, localView, paramNewFriendBaseHolder, -1);
    }
    paramNewFriendBaseHolder.e = localView;
    paramNewFriendBaseHolder.a = null;
    return localView;
  }
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131493358);
    int j = paramContext.getResources().getDimensionPixelSize(2131493359);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new oiw(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  protected void a() {}
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);; i = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.f != -1))
      {
        if (paramInt != this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.f) {
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
  
  protected void a(View paramView)
  {
    if (!Utils.a("tag_swip_icon_menu_item", paramView.getTag())) {}
    for (;;)
    {
      return;
      if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367256), 0).b(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a.a());
        return;
      }
      Object localObject1 = paramView.getTag(-1);
      Object localObject2 = paramView.getTag(-2);
      if ((!(localObject1 instanceof Integer)) || (!(localObject2 instanceof Integer)))
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("Q.newfriend", 4, "SystemMsgListAdpater onClick tag is not int");
        return;
      }
      int i = ((Integer)localObject1).intValue();
      int j = ((Integer)localObject2).intValue();
      localObject1 = null;
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriend", 2, "SystemMsgListAdpater onClick position = " + i + "nMenuStrId = " + j + "v.getId() = " + paramView.getId());
      }
      try
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
        if (!Utils.a(paramView, this.jdField_a_of_type_AndroidContentContext.getResources().getString(jdField_a_of_type_ArrayOfInt[0]))) {
          continue;
        }
        a();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramView = (View)localObject1;
          if (QLog.isDevelopLevel())
          {
            QLog.i("Q.newfriend", 4, localException.toString());
            paramView = (View)localObject1;
          }
        }
      }
    }
  }
  
  public void a(NewFriendMessage paramNewFriendMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage = paramNewFriendMessage;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\newfriend\NewFriendBaseBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */