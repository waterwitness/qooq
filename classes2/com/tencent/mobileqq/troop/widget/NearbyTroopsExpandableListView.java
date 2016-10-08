package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;

public class NearbyTroopsExpandableListView
  extends PinnedHeaderIphoneTreeView
{
  public int a;
  public View a;
  public boolean a;
  
  public NearbyTroopsExpandableListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public NearbyTroopsExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public NearbyTroopsExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Int = 0;
    }
    NearbyTroopsExpandableListViewAdapter localNearbyTroopsExpandableListViewAdapter = (NearbyTroopsExpandableListViewAdapter)a();
    if (localNearbyTroopsExpandableListViewAdapter == null) {
      return;
    }
    int j = localNearbyTroopsExpandableListViewAdapter.getGroupCount();
    int i = this.jdField_a_of_type_Int;
    while (i < j)
    {
      a(i);
      i += 1;
    }
    this.jdField_a_of_type_Int = j;
  }
  
  public void a_(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a(paramView);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      return this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\NearbyTroopsExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */