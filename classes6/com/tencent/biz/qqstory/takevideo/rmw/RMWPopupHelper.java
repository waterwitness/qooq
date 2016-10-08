package com.tencent.biz.qqstory.takevideo.rmw;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RMWPopupHelper
{
  private static final String jdField_a_of_type_JavaLangString = "RMWPopup";
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private NeoVideoRecordButton jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton;
  private boolean jdField_a_of_type_Boolean;
  
  public RMWPopupHelper(Context paramContext, WindowManager paramWindowManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    this.jdField_a_of_type_AndroidViewWindowManager = paramWindowManager;
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton = new NeoVideoRecordButton(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setLayoutParams(new ViewGroup.LayoutParams(Utils.a(paramContext, 106.0F), Utils.a(paramContext, 106.0F)));
    paramWindowManager = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    if (Build.VERSION.SDK_INT < 19) {}
    for (int i = 2003;; i = 2005)
    {
      paramWindowManager.type = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
      paramWindowManager = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      paramWindowManager.flags |= 0x8;
      paramWindowManager = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      paramWindowManager.flags |= 0x20;
      paramWindowManager = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      paramWindowManager.flags &= 0xFFFFFFEF;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = Utils.a(paramContext, 106.0F);
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = Utils.a(paramContext, 106.0F);
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 81;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = Utils.a(paramContext, 10.0F);
      return;
    }
  }
  
  public NeoVideoRecordButton a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.a();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setProgress(paramFloat);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setOnClickListener(paramOnClickListener);
  }
  
  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setOnTouchListener(paramOnTouchListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setStubMode(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.b();
  }
  
  public void c()
  {
    RMWLog.b("RMWPopup", "tearDown");
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton);
    }
  }
  
  public void d()
  {
    RMWLog.b("RMWPopup", "HIDE added=" + this.jdField_a_of_type_Boolean + ", view=" + this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(8);
    }
  }
  
  public void e()
  {
    RMWLog.b("RMWPopup", "SHOW added=" + this.jdField_a_of_type_Boolean + ", view=" + this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWPopupHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */