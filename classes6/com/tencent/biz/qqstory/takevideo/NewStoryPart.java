package com.tencent.biz.qqstory.takevideo;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.IEventReceiver;

public class NewStoryPart
  implements NewStoryActivityInteractor, IEventReceiver
{
  public Handler a;
  public NewStoryTakeVideoActivity a;
  protected String c;
  
  public NewStoryPart()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "Q.qqstory.record.NewStoryPart";
  }
  
  protected Resources a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getResources();
  }
  
  protected View a(int paramInt)
  {
    View localView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  protected String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getString(paramInt);
  }
  
  public void a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    if (paramNewStoryTakeVideoActivity == null) {
      throw new NullPointerException("activity is null");
    }
    if (paramNewStoryTakeVideoActivity.getBaseContext() == null) {
      throw new NullPointerException("activity is not valid context instance");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity = paramNewStoryTakeVideoActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity, boolean paramBoolean)
  {
    SLog.a(this.c, "onWindowFocusChanged %s", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public boolean a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    SLog.b(this.c, "onBackPressed");
    return false;
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    SLog.a(this.c, "onCreate");
  }
  
  public void c(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    SLog.a(this.c, "onStart");
  }
  
  public void d(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    SLog.a(this.c, "onResume");
  }
  
  public void e(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    SLog.a(this.c, "onPause");
  }
  
  public void f(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    SLog.a(this.c, "onStop");
  }
  
  public void g(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    SLog.a(this.c, "onDestroy");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.isValidate();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */