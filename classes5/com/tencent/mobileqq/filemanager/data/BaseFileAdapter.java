package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.MotionViewSetter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class BaseFileAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private MotionViewSetter jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  
  public BaseFileAdapter(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(MotionViewSetter paramMotionViewSetter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = paramMotionViewSetter;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(int paramInt, View paramView, ShaderAnimLayout paramShaderAnimLayout, Button paramButton, Object paramObject)
  {
    boolean bool = false;
    if (paramShaderAnimLayout != null)
    {
      if ((this.jdField_a_of_type_JavaLangObject != null) && (this.jdField_a_of_type_JavaLangObject.equals(paramObject)))
      {
        bool = true;
        paramShaderAnimLayout.a();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter.setMotionView(paramView, paramInt);
        }
        paramButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramButton.setTag(Integer.valueOf(paramInt));
      }
    }
    else {
      return bool;
    }
    paramShaderAnimLayout.c();
    paramButton.setOnClickListener(null);
    paramButton.setTag(null);
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ShaderAnimLayout paramShaderAnimLayout, Button paramButton, String paramString)
  {
    boolean bool = false;
    if (paramShaderAnimLayout != null)
    {
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        bool = true;
        paramShaderAnimLayout.a();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter.setMotionView(paramView, paramInt);
        }
        paramButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramButton.setTag(Integer.valueOf(paramInt));
      }
    }
    else {
      return bool;
    }
    paramShaderAnimLayout.c();
    paramButton.setOnClickListener(null);
    paramButton.setTag(null);
    return false;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\BaseFileAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */