package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RMWClientControl
  extends RMWClientObserver
{
  private static final String jdField_a_of_type_JavaLangString = "RMWClientControl";
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private RMWClientControl.VisibilityChangedListener jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl$VisibilityChangedListener;
  private RMWServiceProxy jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public RMWClientControl(RMWServiceProxy paramRMWServiceProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_Int = -1;
    RMWLog.b("RMWClientControl", "constructor");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy = paramRMWServiceProxy;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 3, 0, 0));
  }
  
  public void a(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      this.jdField_a_of_type_Float = paramFloat;
      Message localMessage = Message.obtain(null, 5);
      localMessage.getData().putFloat("progress", paramFloat);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(localMessage);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 1, paramInt, 0));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if ((paramOnClickListener != null) && (this.jdField_a_of_type_AndroidViewView$OnClickListener == null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 7, 1, 0));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
      return;
      if ((paramOnClickListener == null) && (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 7, 0, 0));
      }
    }
  }
  
  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    if ((paramOnLongClickListener != null) && (this.jdField_a_of_type_AndroidViewView$OnLongClickListener == null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 8, 1, 0));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
      return;
      if ((paramOnLongClickListener == null) && (this.jdField_a_of_type_AndroidViewView$OnLongClickListener != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 8, 0, 0));
      }
    }
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    if ((paramOnTouchListener != null) && (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 9, 1, 0));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
      return;
      if ((paramOnTouchListener == null) && (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 9, 0, 0));
      }
    }
  }
  
  public void a(RMWClientControl.VisibilityChangedListener paramVisibilityChangedListener)
  {
    if ((paramVisibilityChangedListener != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl$VisibilityChangedListener == null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 10, 1, 0));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl$VisibilityChangedListener = paramVisibilityChangedListener;
      return;
      if ((paramVisibilityChangedListener == null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl$VisibilityChangedListener != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 10, 0, 0));
      }
    }
  }
  
  protected void a(RMWEvent paramRMWEvent)
  {
    switch (paramRMWEvent.a.what)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = this.jdField_a_of_type_AndroidViewView$OnTouchListener;
          } while ((localObject == null) || (!(paramRMWEvent.a.obj instanceof MotionEvent)));
          RMWLog.b("RMWClientControl", "from remote onTouch " + paramRMWEvent.a.obj);
          ((View.OnTouchListener)localObject).onTouch(null, (MotionEvent)paramRMWEvent.a.obj);
          return;
          RMWLog.b("RMWClientControl", "from remote onClick");
          paramRMWEvent = this.jdField_a_of_type_AndroidViewView$OnClickListener;
        } while (paramRMWEvent == null);
        paramRMWEvent.onClick(null);
        return;
        RMWLog.b("RMWClientControl", "from remote onLongClick");
        paramRMWEvent = this.jdField_a_of_type_AndroidViewView$OnLongClickListener;
      } while (paramRMWEvent == null);
      paramRMWEvent.onLongClick(null);
      return;
      RMWLog.b("RMWClientControl", "from remote visibility changed : " + paramRMWEvent.a.arg1);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl$VisibilityChangedListener;
    } while (localObject == null);
    ((RMWClientControl.VisibilityChangedListener)localObject).b(paramRMWEvent.a.arg1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    RMWServiceProxy localRMWServiceProxy = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localRMWServiceProxy.a(Message.obtain(null, 2, i, 0));
      return;
    }
  }
  
  public boolean a()
  {
    RMWService localRMWService = RMWService.a();
    if (localRMWService != null) {
      return localRMWService.a().a();
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 4, 0, 0));
  }
  
  protected void b(int paramInt)
  {
    RMWLog.b("RMWClientControl", "handleStateChanged %s", new Object[] { RMWServiceProxy.a(paramInt) });
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 7, 1, 0));
      }
      if (this.jdField_a_of_type_AndroidViewView$OnLongClickListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 8, 1, 0));
      }
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 9, 1, 0));
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWClientControl$VisibilityChangedListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(Message.obtain(null, 10, 1, 0));
      }
      a(this.jdField_a_of_type_Float);
      a(this.jdField_a_of_type_Boolean);
      b(this.b);
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
    RMWServiceProxy localRMWServiceProxy = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localRMWServiceProxy.a(Message.obtain(null, 6, i, 0));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWClientControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */