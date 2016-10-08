package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public abstract class UploadingTask
  extends Observable
{
  protected TroopUploadingThread a;
  
  public UploadingTask()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArrayList a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public abstract void a(Class paramClass, ArrayList paramArrayList, HashMap paramHashMap, String paramString);
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.a(paramString);
    }
  }
  
  public void a(Observer paramObserver)
  {
    super.deleteObserver(paramObserver);
  }
  
  public void notifyObservers(Object paramObject)
  {
    super.setChanged();
    super.notifyObservers(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\UploadingTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */