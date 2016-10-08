package com.tencent.mobileqq.activity.richmedia.view;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CameraFilterGLView$SVRecordSessionParam
{
  public int a;
  public boolean a;
  
  public CameraFilterGLView$SVRecordSessionParam()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 90: 
    default: 
      return 0;
    case 0: 
      return 270;
    case 180: 
      return 90;
    }
    return 180;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\view\CameraFilterGLView$SVRecordSessionParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */