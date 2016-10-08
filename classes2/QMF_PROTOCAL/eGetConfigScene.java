package QMF_PROTOCAL;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class eGetConfigScene
  implements Serializable
{
  public static final eGetConfigScene SQGetConfigApnChanged;
  public static final eGetConfigScene SQGetConfigAppStart;
  public static final eGetConfigScene SQGetConfigAppTimer;
  public static final eGetConfigScene SQGetConfigFromBackToFront;
  public static final eGetConfigScene SQGetConfigRecvDelPush;
  public static final eGetConfigScene SceneAppActivate;
  public static final eGetConfigScene SceneAppRun;
  public static final eGetConfigScene SceneNetworkChanged;
  public static final eGetConfigScene SceneTimeout;
  public static final int _SQGetConfigApnChanged = 101;
  public static final int _SQGetConfigAppStart = 100;
  public static final int _SQGetConfigAppTimer = 102;
  public static final int _SQGetConfigFromBackToFront = 103;
  public static final int _SQGetConfigRecvDelPush = 104;
  public static final int _SceneAppActivate = 1;
  public static final int _SceneAppRun = 0;
  public static final int _SceneNetworkChanged = 3;
  public static final int _SceneTimeout = 2;
  private static eGetConfigScene[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!eGetConfigScene.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new eGetConfigScene[8];
      SceneAppRun = new eGetConfigScene(0, 0, "SceneAppRun");
      SceneAppActivate = new eGetConfigScene(1, 1, "SceneAppActivate");
      SceneTimeout = new eGetConfigScene(2, 2, "SceneTimeout");
      SceneNetworkChanged = new eGetConfigScene(3, 3, "SceneNetworkChanged");
      SQGetConfigAppStart = new eGetConfigScene(4, 100, "SQGetConfigAppStart");
      SQGetConfigApnChanged = new eGetConfigScene(5, 101, "SQGetConfigApnChanged");
      SQGetConfigAppTimer = new eGetConfigScene(6, 102, "SQGetConfigAppTimer");
      SQGetConfigFromBackToFront = new eGetConfigScene(7, 103, "SQGetConfigFromBackToFront");
      SQGetConfigRecvDelPush = new eGetConfigScene(8, 104, "SQGetConfigRecvDelPush");
      return;
    }
  }
  
  private eGetConfigScene(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static eGetConfigScene convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static eGetConfigScene convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QMF_PROTOCAL\eGetConfigScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */