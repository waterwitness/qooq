package com.tencent.biz.qqstory.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import izx;
import izy;

public class StoryNewGuideDialog
  extends Dialog
{
  protected TextView a;
  protected AnimationPoint a;
  
  public StoryNewGuideDialog(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.requestWindowFeature(1);
    super.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramContext = LayoutInflater.from(paramContext).inflate(2130904460, null);
    paramContext.setOnClickListener(new izx(this));
    super.setCanceledOnTouchOutside(true);
    super.setContentView(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint = ((AnimationPoint)super.findViewById(2131302812));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131301577));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setDuration(-1L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setOnAnimationListener(new izy(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.b();
    super.dismiss();
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.a();
    super.show();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\StoryNewGuideDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */