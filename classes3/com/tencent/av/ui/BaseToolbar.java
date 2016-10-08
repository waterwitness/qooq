package com.tencent.av.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BaseToolbar
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public VideoAppInterface a;
  
  public BaseToolbar()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    c();
  }
  
  protected void a(Context paramContext, QAVPtvTemplateAdapter.IEffectCallback paramIEffectCallback) {}
  
  public final void a(VideoAppInterface paramVideoAppInterface)
  {
    b(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public final void a(VideoAppInterface paramVideoAppInterface, Context paramContext, RelativeLayout paramRelativeLayout, QAVPtvTemplateAdapter.IEffectCallback paramIEffectCallback)
  {
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("create Toolbar fail, Illegal toolbarLayout id.");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(this.jdField_a_of_type_Int, null);
    paramRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
    a(paramContext, paramIEffectCallback);
  }
  
  public void a(Object[] paramArrayOfObject) {}
  
  public final void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    d();
  }
  
  protected void b(VideoAppInterface paramVideoAppInterface) {}
  
  protected void c() {}
  
  protected void d() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\BaseToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */