package com.tencent.widget;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ExpandableListView$ExpandableListContextMenuInfo
  implements ContextMenu.ContextMenuInfo
{
  public long a;
  public View a;
  public long b;
  
  public ExpandableListView$ExpandableListContextMenuInfo(View paramView, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ExpandableListView$ExpandableListContextMenuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */