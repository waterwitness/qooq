package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.OnFaceSelectedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseFaceListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static final String a = "BaseFaceListAdapter";
  public int a;
  protected Context a;
  protected FacePackage a;
  protected FacePanel.OnFaceSelectedListener a;
  
  public BaseFaceListAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected abstract int a();
  
  protected abstract void a(View paramView);
  
  protected abstract void a(View paramView, int paramInt);
  
  public void a(FacePackage paramFacePackage)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage = paramFacePackage;
  }
  
  public void a(FacePanel.OnFaceSelectedListener paramOnFaceSelectedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener = paramOnFaceSelectedListener;
  }
  
  protected abstract void b(View paramView, int paramInt);
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a();
    int j = a();
    if (i % j == 0) {
      return i / j;
    }
    return i / j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null)
    {
      paramViewGroup = paramView;
      return paramViewGroup;
    }
    int i;
    if (paramView == null)
    {
      paramView = new FaceListItem(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth());
      paramView.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a(), this.jdField_a_of_type_Int);
      i = paramInt * paramView.a();
      if (paramInt != getCount() - 1) {
        break label123;
      }
    }
    label123:
    for (paramInt = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a();; paramInt = paramView.a() + i)
    {
      paramView.setEffectiveChildCount(paramInt - i);
      j = i;
      while (j < paramInt)
      {
        b(paramView.a(j - i), j);
        j += 1;
      }
      paramView = (FaceListItem)paramView;
      break;
    }
    int j = i;
    for (;;)
    {
      paramViewGroup = paramView;
      if (j >= paramInt) {
        break;
      }
      a(paramView.a(j - i), j);
      j += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    a(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\adapter\BaseFaceListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */