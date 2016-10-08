package com.tencent.upload.network.base;

import com.tencent.upload.a.b;
import com.tencent.upload.common.f;
import com.tencent.upload.uinterface.IUploadEnv;
import java.lang.ref.WeakReference;

public class ConnectionImpl
{
  private static final int MSG_ID_ON_CONNECT = 1;
  private static final int MSG_ID_ON_DISCONNECT = 2;
  private static final int MSG_ID_ON_ERROR = 3;
  private static final int MSG_ID_ON_MSGPROC = 8;
  private static final int MSG_ID_ON_RECV = 5;
  private static final int MSG_ID_ON_SENDBEGIN = 6;
  private static final int MSG_ID_ON_SENDEND = 7;
  private static final int MSG_ID_ON_START = 0;
  private static final int MSG_ID_ON_TIMEOUT = 4;
  private static final String TAG = "NavtieConn";
  private static volatile boolean sIsLibraryPrepared;
  private d mCallback = null;
  private final int mHashCode = hashCode();
  private e mMsgCallback = null;
  private int mNativeContext;
  private final int mType;
  
  static
  {
    boolean bool3 = false;
    sIsLibraryPrepared = false;
    try
    {
      boolean bool2 = f.e().loadLibrary("networkbase");
      boolean bool4 = f.e().loadLibrary("uploadnetwork");
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = f.e().loadLibrary("networkbase");
        }
      }
      native_init();
      bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (bool4) {
          bool2 = true;
        }
      }
      sIsLibraryPrepared = bool2;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      b.e("NavtieConn", localUnsatisfiedLinkError.toString());
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      b.e("NavtieConn", localNullPointerException.toString());
      return;
    }
    catch (Exception localException)
    {
      b.e("NavtieConn", localException.toString());
    }
  }
  
  public ConnectionImpl(int paramInt1, int paramInt2)
  {
    this.mType = paramInt1;
    native_setup(new WeakReference(this), this.mType, paramInt2);
    b.d("NavtieConn", this.mHashCode + " ConnectionImpl");
  }
  
  public static final boolean isLibraryPrepared()
  {
    return sIsLibraryPrepared;
  }
  
  private final native void native_finalize();
  
  private static final native void native_init();
  
  private final native void native_setup(Object paramObject, int paramInt1, int paramInt2);
  
  private void onConnect(boolean paramBoolean, int paramInt, String paramString)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.a(this.mCallback, paramBoolean, paramInt, paramString);
  }
  
  private void onDisconnect()
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.b(this.mCallback);
  }
  
  private void onError(int paramInt)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.a(this.mCallback, paramInt);
  }
  
  private void onMsgProc(int paramInt1, Object paramObject, int paramInt2)
  {
    if (this.mMsgCallback == null) {
      return;
    }
    paramObject = this.mMsgCallback;
    e locale = this.mMsgCallback;
    ((e)paramObject).a(paramInt1, paramInt2);
  }
  
  private void onRecv(byte[] paramArrayOfByte)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.a(this.mCallback, paramArrayOfByte);
  }
  
  private void onSendBegin(int paramInt)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.c(this.mCallback, paramInt);
  }
  
  private void onSendEnd(int paramInt)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.b(this.mCallback, paramInt);
  }
  
  private void onStart()
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.a(this.mCallback);
  }
  
  private void onTimeOut(int paramInt1, int paramInt2)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.a(this.mCallback, paramInt1, paramInt2);
  }
  
  private static void postEventFromNative(Object paramObject1, int paramInt1, int paramInt2, int paramInt3, Object paramObject2)
  {
    if (!(paramObject1 instanceof WeakReference))
    {
      b.d("NavtieConn", "fromNative: !(ConnectionImpl_ref instanceof WeakReference<?>)");
      return;
    }
    paramObject1 = ((WeakReference)paramObject1).get();
    if (!(paramObject1 instanceof ConnectionImpl))
    {
      b.d("NavtieConn", "fromNative: !(ref instanceof ConnectionImpl)");
      return;
    }
    paramObject1 = (ConnectionImpl)paramObject1;
    int i = ((ConnectionImpl)paramObject1).getHashCode();
    b.b("NavtieConn", i + " fromNative:" + print(paramInt1));
    switch (paramInt1)
    {
    default: 
      b.e("NavtieConn", i + " Unknown message type " + paramInt1);
      return;
    case 0: 
      ((ConnectionImpl)paramObject1).onStart();
      return;
    case 1: 
      if (paramInt2 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((ConnectionImpl)paramObject1).onConnect(bool, paramInt3, (String)paramObject2);
        return;
      }
    case 2: 
      ((ConnectionImpl)paramObject1).onDisconnect();
      return;
    case 3: 
      ((ConnectionImpl)paramObject1).onError(paramInt2);
      return;
    case 4: 
      ((ConnectionImpl)paramObject1).onTimeOut(paramInt2, paramInt3);
      return;
    case 6: 
      ((ConnectionImpl)paramObject1).onSendBegin(paramInt2);
      return;
    case 7: 
      ((ConnectionImpl)paramObject1).onSendEnd(paramInt2);
      return;
    case 8: 
      ((ConnectionImpl)paramObject1).onMsgProc(paramInt2, paramObject2, paramInt3);
      return;
    }
    ((ConnectionImpl)paramObject1).onRecv((byte[])paramObject2);
  }
  
  private static final String print(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown msg";
    case 0: 
      return "onStart";
    case 1: 
      return "onConnect";
    case 2: 
      return "onDisconnect";
    case 3: 
      return "onError";
    case 4: 
      return "onTimeout";
    case 5: 
      return "onRecv";
    case 6: 
      return "sendBegin";
    case 7: 
      return "sendEnd";
    }
    return "msgProc";
  }
  
  public static void printLog(int paramInt, String paramString)
  {
    b.b("jni", paramString);
  }
  
  public native boolean PostMessage(int paramInt1, Object paramObject, int paramInt2);
  
  public native boolean SendData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native boolean connect(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4);
  
  public native boolean disconnect();
  
  protected void finalize()
  {
    b.d("NavtieConn", this.mHashCode + " finalize");
    try
    {
      native_finalize();
      super.finalize();
      return;
    }
    catch (Throwable localThrowable) {}catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public final int getHashCode()
  {
    return this.mHashCode;
  }
  
  public native boolean isRunning();
  
  public native boolean isSendDone(int paramInt);
  
  public native void removeAllSendData();
  
  public native void removeSendData(int paramInt);
  
  public void setCallback(d paramd)
  {
    this.mCallback = paramd;
  }
  
  public void setMsgCallback(e parame)
  {
    this.mMsgCallback = parame;
  }
  
  public native boolean start();
  
  public native boolean stop();
  
  public native void wakeUp();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\base\ConnectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */