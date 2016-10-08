package com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import android.util.Log;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWClientControl;
import com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy;
import com.tencent.biz.qqstory.takevideo.rmw.ServiceStateEvent;
import com.tencent.biz.qqstory.takevideo.rmw.Utils;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iwy;
import iwz;
import java.util.Observable;
import java.util.Observer;

public class TakeVideoButtonSubPart
  extends NewStoryPart
  implements Observer
{
  protected static final int a = 200;
  private static final String jdField_a_of_type_JavaLangString = "TakeVideoButtonSubPart";
  private long jdField_a_of_type_Long;
  public View.OnTouchListener a;
  private TakeVideoButtonSubPart.exitRecodeModeRunnable jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart$exitRecodeModeRunnable;
  private RMWClientControl jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl;
  private NeoVideoRecordButton jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton;
  public boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public TakeVideoButtonSubPart()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = true;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new iwz(this);
  }
  
  public void a()
  {
    SLog.b("TakeVideoButtonSubPart", "autoStartTakeVideoIfPressed");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.postDelayed(new iwy(this), 500L);
  }
  
  public void a(float paramFloat)
  {
    if (this.b) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setProgress(paramFloat);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setProgress(paramFloat);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(paramFloat);
    } while (!this.c);
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(4);
  }
  
  public void a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity, boolean paramBoolean)
  {
    SLog.a("TakeVideoButtonSubPart", "onWindowFocusChanged hasFocus %s", Boolean.valueOf(paramBoolean));
    if (this.b) {}
    do
    {
      return;
      this.f = paramBoolean;
      if (paramBoolean)
      {
        if (!this.e)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(true);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(0);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.b(false);
          if (this.c) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(4);
          }
        }
        this.d = false;
        return;
      }
    } while ((this.d) || (!this.c));
    if (!this.e) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(4);
  }
  
  public void b()
  {
    SLog.b("TakeVideoButtonSubPart", "hide");
    this.e = true;
    if (this.b)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(8);
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    this.b = Utils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity);
    SLog.a("TakeVideoButtonSubPart", "onCreate, is black list %s", Boolean.valueOf(this.b));
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton = ((NeoVideoRecordButton)a(2131302942));
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setStubMode(false);
    int i = Utils.a(paramNewStoryTakeVideoActivity, 106.0F);
    int j = Utils.a(paramNewStoryTakeVideoActivity, 10.0F);
    paramNewStoryTakeVideoActivity = this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.getLayoutParams();
    if ((paramNewStoryTakeVideoActivity instanceof ViewGroup.MarginLayoutParams))
    {
      paramNewStoryTakeVideoActivity = (ViewGroup.MarginLayoutParams)paramNewStoryTakeVideoActivity;
      paramNewStoryTakeVideoActivity.width = i;
      paramNewStoryTakeVideoActivity.height = i;
      paramNewStoryTakeVideoActivity.bottomMargin = j;
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setLayoutParams(paramNewStoryTakeVideoActivity);
    }
    while (this.b)
    {
      return;
      SLog.d("TakeVideoButtonSubPart", "strange layout parameter %s", new Object[] { paramNewStoryTakeVideoActivity });
      paramNewStoryTakeVideoActivity = new RelativeLayout.LayoutParams(i, i);
      paramNewStoryTakeVideoActivity.addRule(12);
      paramNewStoryTakeVideoActivity.addRule(14);
      paramNewStoryTakeVideoActivity.bottomMargin = j;
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setLayoutParams(paramNewStoryTakeVideoActivity);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl = new RMWClientControl(RMWServiceProxy.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    RMWServiceProxy.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity).a(this);
    RMWServiceProxy.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity).b();
  }
  
  public void c()
  {
    SLog.b("TakeVideoButtonSubPart", "show");
    this.e = false;
    if (this.b) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
      if (this.f)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(0);
      }
    } while (!this.c);
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(4);
  }
  
  public void c(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    SLog.b("TakeVideoButtonSubPart", "onStart");
  }
  
  public void d()
  {
    SLog.b("TakeVideoButtonSubPart", "startPlayAnimation");
    if (this.b) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.a();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a();
    } while (!this.c);
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(4);
  }
  
  public void d(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    SLog.b("TakeVideoButtonSubPart", "onResume");
    this.d = false;
  }
  
  public void e()
  {
    SLog.b("TakeVideoButtonSubPart", "stopPlayAnimation");
    if (this.b) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.b();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.b();
    } while (!this.c);
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(4);
  }
  
  public void e(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Log.d("TakeVideoButtonSubPart", "onPause, returnMain = " + this.d);
    if (this.b) {}
    do
    {
      return;
      this.f = false;
    } while ((this.d) || (!this.c));
    if (!this.e) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(4);
  }
  
  public void f()
  {
    this.d = true;
  }
  
  public void f(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Log.d("TakeVideoButtonSubPart", "onStop");
    if (this.b) {
      return;
    }
    this.f = false;
    if (!this.e) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(4);
  }
  
  public void g(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Log.d("TakeVideoButtonSubPart", "onDestroy");
    if (this.b) {
      return;
    }
    if (!this.e) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(4);
    RMWServiceProxy.a(paramNewStoryTakeVideoActivity).c();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof ServiceStateEvent))
    {
      paramObservable = (ServiceStateEvent)paramObject;
      if (paramObservable.a != 2) {
        break label41;
      }
      SLog.b("TakeVideoButtonSubPart", "service state CONNECTED");
      this.c = true;
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(4);
    }
    label41:
    while (paramObservable.a != 0) {
      return;
    }
    SLog.b("TakeVideoButtonSubPart", "service disconnected, show local view");
    this.c = false;
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\TakeVideoButtonSubPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */