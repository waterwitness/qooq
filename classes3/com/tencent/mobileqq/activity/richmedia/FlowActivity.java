package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class FlowActivity
  extends PeakActivity
{
  protected ViewGroup a;
  protected boolean a;
  protected int t_;
  
  public FlowActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  protected FlowPanel a()
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.t_ = paramBundle.getInt("flow_camera_height", (int)getResources().getDimension(2131493563));
  }
  
  protected abstract void a(ViewGroup paramViewGroup);
  
  public void a(FlowPanel paramFlowPanel)
  {
    paramFlowPanel.a((ViewGroup)a(2131296893));
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean)
    {
      overridePendingTransition(0, 2130968593);
      return;
    }
    overridePendingTransition(0, 0);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(256);
    getWindow().addFlags(512);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null) {
      this.t_ = ((int)getResources().getDimension(2131493563));
    }
    a(paramBundle);
    setContentView(2130903063);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131296894));
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    paramBundle = a();
    if (paramBundle != null) {
      paramBundle.a((ViewGroup)a(2131296893));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      return super.onTouchEvent(paramMotionEvent);
    }
    View localView = a();
    if (localView == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = localView.getTop();
    if (paramMotionEvent.getY() < i) {
      onBackPressed();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\FlowActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */