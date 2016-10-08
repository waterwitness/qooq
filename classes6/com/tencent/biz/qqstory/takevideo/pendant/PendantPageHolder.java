package com.tencent.biz.qqstory.takevideo.pendant;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PendantPageHolder
  implements OnPendantItemClickListener
{
  int jdField_a_of_type_Int;
  final View jdField_a_of_type_AndroidViewView;
  private OnPendantItemClickListener jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener;
  final PendantItemHolder[] jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder;
  
  public PendantPageHolder(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder = new PendantItemHolder[PendantPageAdapter.a.length];
    int i = 0;
    while (i < PendantPageAdapter.a.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder[i] = new PendantItemHolder((ViewGroup)paramView.findViewById(PendantPageAdapter.a[i]));
      this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder[i].a(this);
      i += 1;
    }
  }
  
  public void a()
  {
    PendantItemHolder[] arrayOfPendantItemHolder = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder;
    int j = arrayOfPendantItemHolder.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendantItemHolder[i].a();
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 != 0)
    {
      i = paramInt2;
      if (this.jdField_a_of_type_Int != paramInt1) {
        i = -1;
      }
    }
    paramInt1 = 0;
    if (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder.length)
    {
      PendantItemHolder localPendantItemHolder = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder[paramInt1];
      if (paramInt1 == i) {}
      for (boolean bool = true;; bool = false)
      {
        localPendantItemHolder.a(bool);
        paramInt1 += 1;
        break;
      }
    }
  }
  
  public void a(NewStoryPendantItem paramNewStoryPendantItem, int paramInt1, int paramInt2)
  {
    OnPendantItemClickListener localOnPendantItemClickListener = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener;
    if (localOnPendantItemClickListener != null) {
      localOnPendantItemClickListener.a(paramNewStoryPendantItem, this.jdField_a_of_type_Int, paramInt2);
    }
  }
  
  public void a(OnPendantItemClickListener paramOnPendantItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener = paramOnPendantItemClickListener;
  }
  
  public void a(NewStoryPendantItem[] paramArrayOfNewStoryPendantItem, NewStoryPendantItem paramNewStoryPendantItem, int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder.length)
    {
      if (i < paramArrayOfNewStoryPendantItem.length) {
        this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder[i].a(paramArrayOfNewStoryPendantItem[i], i);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder[i].a(paramNewStoryPendantItem, i);
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    PendantItemHolder[] arrayOfPendantItemHolder = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoPendantPendantItemHolder;
    int j = arrayOfPendantItemHolder.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendantItemHolder[i].b();
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\pendant\PendantPageHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */