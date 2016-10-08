package com.tencent.av.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observable;

public class VideoNotifyCenter
  extends Observable
{
  static final String jdField_a_of_type_JavaLangString = "VideoNotifyCenter";
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public VideoNotifyCenter(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
    if (paramVideoAppInterface != null) {
      this.a = paramVideoAppInterface;
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    try
    {
      super.setChanged();
      super.notifyObservers(paramArrayOfObject);
      return;
    }
    finally
    {
      paramArrayOfObject = finally;
      throw paramArrayOfObject;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\app\VideoNotifyCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */