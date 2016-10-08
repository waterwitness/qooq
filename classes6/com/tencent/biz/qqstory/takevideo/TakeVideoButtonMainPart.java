package com.tencent.biz.qqstory.takevideo;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.rmw.RMWClientControl;
import com.tencent.biz.qqstory.takevideo.rmw.RMWClientControl.VisibilityChangedListener;
import com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy;
import com.tencent.biz.qqstory.takevideo.rmw.ServiceStateEvent;
import com.tencent.biz.qqstory.takevideo.rmw.Utils;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observable;
import java.util.Observer;

public class TakeVideoButtonMainPart
  implements View.OnTouchListener, RMWClientControl.VisibilityChangedListener, Observer
{
  protected static final String a = "TakeVideoButtonMainPart";
  protected long a;
  protected QQStoryMainActivity a;
  protected RMWClientControl a;
  protected NeoVideoRecordButton a;
  protected boolean a;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  
  public TakeVideoButtonMainPart(QQStoryMainActivity paramQQStoryMainActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = true;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity = paramQQStoryMainActivity;
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    if ((l2 > 0L) && (l2 < 2000L)) {
      return true;
    }
    this.jdField_a_of_type_Long = l1;
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = Utils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity);
    SLog.a("TakeVideoButtonMainPart", "onActivityCreate, is black list %s", Boolean.valueOf(this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton = ((NeoVideoRecordButton)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity.findViewById(2131302802));
    int i = Utils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity, 106.0F);
    int j = Utils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity, 10.0F);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).width = i;
      ((ViewGroup.MarginLayoutParams)localObject).height = i;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = j;
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setOnTouchListener(this);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl = new RMWClientControl(RMWServiceProxy.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity));
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(this);
      }
      RMWServiceProxy.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity).a(this);
      RMWServiceProxy.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity).b();
      return;
      SLog.d("TakeVideoButtonMainPart", "strange layout parameter %s", new Object[] { localObject });
      localObject = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = j;
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(int paramInt)
  {
    SLog.d("TakeVideoButtonMainPart", "setVisibility : " + paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b("TakeVideoButtonMainPart", "onWindowFocusChanged : " + paramBoolean);
    this.c = paramBoolean;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (!this.c) {
        break label81;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(0.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(true);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.b(true);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(0);
      this.b = false;
    }
    label81:
    while (this.b) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(8);
  }
  
  public void b()
  {
    SLog.b("TakeVideoButtonMainPart", "onActivityResume");
    this.b = false;
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    SLog.b("TakeVideoButtonMainPart", "remote widget change to visible");
  }
  
  public void c()
  {
    SLog.b("TakeVideoButtonMainPart", "onActivityPause");
    this.c = false;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (!this.c) {
        break label59;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(0.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(true);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.b(true);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(0);
    }
    label59:
    while (this.b) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(8);
  }
  
  public void d()
  {
    SLog.b("TakeVideoButtonMainPart", "onActivityStop");
    this.c = false;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(4);
    }
  }
  
  public void e()
  {
    SLog.b("TakeVideoButtonMainPart", "onActivityDestroy");
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(4);
    }
    RMWServiceProxy.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity).c();
    RMWServiceProxy.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity).b(this);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramView != null) {
            break;
          }
          SLog.a("TakeVideoButtonMainPart", "onClick remote view, isResume : %s", Boolean.valueOf(this.c));
          bool1 = bool2;
        } while (!this.c);
        this.b = true;
        bool1 = bool2;
      } while (a());
      StoryReportor.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity.a(false, true);
      return true;
      SLog.b("TakeVideoButtonMainPart", "onClick local view");
      if (!this.jdField_a_of_type_Boolean) {
        SLog.d("TakeVideoButtonMainPart", "remote button is died, trigger by local view");
      }
      bool1 = bool2;
    } while (a());
    StoryReportor.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity.a(false, true);
    return true;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof ServiceStateEvent))
    {
      paramObservable = (ServiceStateEvent)paramObject;
      if (paramObservable.a != 2) {
        break label66;
      }
      SLog.b("TakeVideoButtonMainPart", "service state CONNECTED");
      if ((!this.jdField_a_of_type_Boolean) && (this.c))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(0.0F);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl.a(0);
      }
    }
    label66:
    while (paramObservable.a != 0) {
      return;
    }
    SLog.b("TakeVideoButtonMainPart", "service disconnected, local view always displaying");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\TakeVideoButtonMainPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */