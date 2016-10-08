package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class QQCustomContextMenuDialog
  extends QQCustomDialog
{
  private int jdField_a_of_type_Int;
  QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  
  public QQCustomContextMenuDialog(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 2130903238;
  }
  
  public QQCustomContextMenuDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Int = 2130903238;
  }
  
  protected QQCustomContextMenuDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    this.jdField_a_of_type_Int = 2130903238;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramQQCustomMenu == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = paramQQCustomMenu;
      String[] arrayOfString = new String[paramQQCustomMenu.a()];
      int i = 0;
      while (i < paramQQCustomMenu.a())
      {
        arrayOfString[i] = paramQQCustomMenu.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      paramQQCustomMenu = paramQQCustomMenu.a();
    } while (paramQQCustomMenu == null);
    setTitle(paramQQCustomMenu);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    QQCustomMenuItem localQQCustomMenuItem = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(paramInt);
    if (localQQCustomMenuItem != null) {
      return localQQCustomMenuItem.a();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\QQCustomContextMenuDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */