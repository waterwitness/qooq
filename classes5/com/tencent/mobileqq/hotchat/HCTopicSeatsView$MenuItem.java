package com.tencent.mobileqq.hotchat;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HCTopicSeatsView$MenuItem
{
  public int a;
  public HCSeatInfo a;
  public int b;
  public int c;
  
  protected HCTopicSeatsView$MenuItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static MenuItem a(int paramInt, HCSeatInfo paramHCSeatInfo)
  {
    if ((paramInt < 0) && (paramInt > 4)) {
      return null;
    }
    MenuItem localMenuItem = new MenuItem();
    localMenuItem.c = paramInt;
    localMenuItem.jdField_a_of_type_ComTencentMobileqqHotchatHCSeatInfo = paramHCSeatInfo;
    switch (paramInt)
    {
    default: 
      return localMenuItem;
    case 0: 
      localMenuItem.jdField_a_of_type_Int = 2130840937;
      localMenuItem.b = 2131372439;
      return localMenuItem;
    case 1: 
      localMenuItem.jdField_a_of_type_Int = 2130840935;
      localMenuItem.b = 2131372440;
      return localMenuItem;
    case 2: 
      localMenuItem.jdField_a_of_type_Int = 2130840934;
      localMenuItem.b = 2131372441;
      return localMenuItem;
    case 3: 
      localMenuItem.jdField_a_of_type_Int = 2130840936;
      localMenuItem.b = 2131372442;
      return localMenuItem;
    }
    localMenuItem.jdField_a_of_type_Int = 2130840936;
    localMenuItem.b = 2131372443;
    return localMenuItem;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\HCTopicSeatsView$MenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */