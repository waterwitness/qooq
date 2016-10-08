package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;

public class TroopUploadingTask
  extends UploadingTask
{
  public TroopUploadingTask()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Class paramClass, ArrayList paramArrayList, HashMap paramHashMap, String paramString)
  {
    if ((this.a == null) || (this.a.getState() == Thread.State.TERMINATED))
    {
      this.a = ((TroopUploadingThread)UploadingFactory.a(paramClass));
      this.a.a(paramArrayList, paramHashMap, paramString, this);
      this.a.start();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopUploadingTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */