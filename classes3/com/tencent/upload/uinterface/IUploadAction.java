package com.tencent.upload.uinterface;

import com.tencent.upload.network.a.d;
import com.tencent.upload.network.b.b;

public abstract interface IUploadAction
{
  public abstract int getActionSequence();
  
  public abstract int getSendState();
  
  public abstract int getServerCategory();
  
  public abstract void onCancel(int paramInt);
  
  public abstract void onConnecting();
  
  public abstract void onError(com.tencent.upload.network.c.a parama, int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void onRequest(com.tencent.upload.network.c.a parama, d paramd);
  
  public abstract void onResponse(com.tencent.upload.network.c.a parama, com.tencent.upload.network.a.a parama1);
  
  public abstract boolean onSend(com.tencent.upload.network.c.a parama);
  
  public abstract void onTimeout(com.tencent.upload.network.c.a parama, d paramd);
  
  public abstract void setSessionService$191f3d4e(b paramb);
  
  public static final class CancelState
  {
    public static final int UI_CANCEL = 3;
    public static final int UI_PAUSE = 4;
    public static final int UNKNOWN = -1000;
    public static final int UPLOAD_FAIL_CANCEL = 2;
    public static final int UPLOAD_FAIL_PAUSE = 1;
    public static final int UPLOAD_SUCCESS = 0;
  }
  
  public static final class SendState
  {
    public static final int BUSY = 1;
    public static final int FINISH = 3;
    public static final int IDLE = 0;
    public static final int SENT = 2;
  }
  
  public static final class SessionError
  {
    public static final int FILE_IO_ERROR = 30600;
    public static final int FILE_NOT_FOUND_BUT_CAN_RETRY_ERROR = 31500;
    public static final int FILE_NOT_FOUND_ERROR = 30500;
    public static final int FILE_NOT_FOUND_INDEED = 31600;
    public static final int NETWORK_CALL_ASYNC_FUNC_ERROR = 30200;
    public static final int NETWORK_DIVIDE_PACKET_ERROR = 30300;
    public static final int NETWORK_ESTABLISH_FAILED_ERROR = 31000;
    public static final int NETWORK_NDK_SOCKET_ERROR = 30100;
    public static final int NETWORK_NOT_AVAILABLE_ERROR = 35000;
    public static final int NETWORK_SEND_REQUEST_TIMEOUT_ERROR = 30400;
    public static final int RECEIVE_DATA_TIMEOUT_ERROR = 30800;
    public static final int SEND_DATA_PREPARE_ERROR = 30700;
    
    public static final boolean isRetryable(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return false;
      }
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\IUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */