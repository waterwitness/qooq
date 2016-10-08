package NearbyGroup;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class REPLYCODE
  implements Serializable
{
  public static final REPLYCODE RC_ERR_EXCEPTION;
  public static final REPLYCODE RC_ERR_LBS_AUTH_FAIL;
  public static final REPLYCODE RC_ERR_LBS_EXCEPTION;
  public static final REPLYCODE RC_ERR_LBS_INPUT_ERROR;
  public static final REPLYCODE RC_ERR_LBS_POSITION_FAIL;
  public static final REPLYCODE RC_ERR_PARAM_ERR;
  public static final REPLYCODE RC_ERR_Session_TimeOut;
  public static final REPLYCODE RC_SUCC;
  public static final int _RC_ERR_EXCEPTION = 1;
  public static final int _RC_ERR_LBS_AUTH_FAIL = 201;
  public static final int _RC_ERR_LBS_EXCEPTION = 101;
  public static final int _RC_ERR_LBS_INPUT_ERROR = 202;
  public static final int _RC_ERR_LBS_POSITION_FAIL = 102;
  public static final int _RC_ERR_PARAM_ERR = 2;
  public static final int _RC_ERR_Session_TimeOut = 3;
  public static final int _RC_SUCC = 0;
  private static REPLYCODE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!REPLYCODE.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new REPLYCODE[8];
      RC_SUCC = new REPLYCODE(0, 0, "RC_SUCC");
      RC_ERR_EXCEPTION = new REPLYCODE(1, 1, "RC_ERR_EXCEPTION");
      RC_ERR_PARAM_ERR = new REPLYCODE(2, 2, "RC_ERR_PARAM_ERR");
      RC_ERR_Session_TimeOut = new REPLYCODE(3, 3, "RC_ERR_Session_TimeOut");
      RC_ERR_LBS_EXCEPTION = new REPLYCODE(4, 101, "RC_ERR_LBS_EXCEPTION");
      RC_ERR_LBS_POSITION_FAIL = new REPLYCODE(5, 102, "RC_ERR_LBS_POSITION_FAIL");
      RC_ERR_LBS_AUTH_FAIL = new REPLYCODE(6, 201, "RC_ERR_LBS_AUTH_FAIL");
      RC_ERR_LBS_INPUT_ERROR = new REPLYCODE(7, 202, "RC_ERR_LBS_INPUT_ERROR");
      return;
    }
  }
  
  private REPLYCODE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static REPLYCODE convert(int paramInt)
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
  
  public static REPLYCODE convert(String paramString)
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\REPLYCODE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */