package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseIpc
{
  public static final int a = 1;
  protected static SparseArray a;
  public static final String a = "cmd";
  public static final int b = 2;
  protected static SparseArray b;
  public static final String b = "keyResponse";
  public static final int c = 3;
  public static final String c = "redpoint.fromReceiverKey";
  public static final String d = "redpoint.fromReceiverIPCCode";
  public static final String e = "getRedInfo";
  public static final String f = "reportRedInfo";
  public static final String g = "clearRedInfo";
  public static final String h = "redInfoResp";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new SparseArray();
    b = new SparseArray();
    a.put(1, GetRedPointInfoReq.class);
  }
  
  public abstract int a();
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("redpoint.fromReceiverIPCCode", a());
  }
  
  public void b(Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\BaseIpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */