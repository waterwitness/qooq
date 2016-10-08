package com.tencent.widget;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AdapterView$AdapterContextMenuInfo
  implements ContextMenu.ContextMenuInfo
{
  public int a;
  public long a;
  public View a;
  
  public AdapterView$AdapterContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\AdapterView$AdapterContextMenuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */