package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceInfo;

public class FaceObserver
  implements BusinessObserver
{
  public FaceObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (paramObject == null)
      {
        paramObject = null;
        a(paramBoolean, (FaceInfo)paramObject);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        return;
        paramObject = (FaceInfo)paramObject;
      }
    }
    if (paramObject == null) {}
    for (paramObject = localObject;; paramObject = (FaceInfo)paramObject)
    {
      b(paramBoolean, (FaceInfo)paramObject);
      return;
    }
  }
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo) {}
  
  public void b(boolean paramBoolean, FaceInfo paramFaceInfo) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FaceObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */