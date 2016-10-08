package com.tencent.mobileqq.rn;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAlumniServlet;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager;

public class BDHttpManager
  extends ReactContextBaseJavaModule
{
  public static final int ERROR_CODE_APP_IS_NULL = -1;
  public static final int ERROR_CODE_UNKNOWN = -10;
  public static final String TAG = BDHttpManager.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BDHttpManager(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  public String getName()
  {
    return "BDHttpManager";
  }
  
  @ReactMethod
  public void sendRequest(String paramString, int paramInt1, int paramInt2, Callback paramCallback)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "sendRequest", new Object[] { String.format("body:%s, cmd:%d, subCmd:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
    }
    NearbyAppInterface localNearbyAppInterface = (NearbyAppInterface)NearbyRNAppManager.a();
    if (localNearbyAppInterface != null)
    {
      NearbyAlumniServlet.a(localNearbyAppInterface, paramInt1, paramInt2, paramString, paramCallback, "");
      return;
    }
    paramCallback.invoke(new Object[] { Integer.valueOf(-1), null });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\BDHttpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */