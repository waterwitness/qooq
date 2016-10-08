package com.tencent.upload.other;

public class UploadException
  extends RuntimeException
{
  public static final int A2FAILURE_RETCODE = -6;
  public static final int A2_ENCRYPT_FAIL_RETCODE = 505;
  public static final int ACTION_STATE_ERROR = 503;
  public static final int ALBUM_DELETED = -207;
  public static final int ALL_IP_FAILED = -18;
  public static final int ASYNC_CONNECT_FAILED_RETCODE = -31;
  public static final int ASYNC_SEND_FAILED_RETCODE = -30;
  public static final int CHANGE_IP_SERVER = -17;
  public static final int CHANNEL_END_RETCODE = -21;
  public static final int CLOSE_CHANNEL_RETCODE = -14;
  public static final int CMD_ERROR = 502;
  public static final int CONNECT_ERROR_RETCODE = -9;
  public static final int DATA_PACK_ERROR = 499;
  public static final int DATA_UNPACK_FAILED_RETCODE = 500;
  public static final int DECODE_ERROR_RETCODE = -8;
  public static final int ERROR_DESC_MD5_ERROR = -305;
  public static final int ERROR_NONE = 0;
  public static final int ERROR_PRE_UPLOAD_HIT = -55555;
  public static final int ERROR_SERVER_NOT_RETRY = -4000;
  public static final int FILEOFFSET_ERROR_RETCODE = -10;
  public static final int FILE_NOT_EXIST_RETCODE = -7;
  public static final int FILE_OFFSET_ERROR = 501;
  public static final int HTTP_ERROR_RETCODE = -13;
  public static final int IO_ERROR_RETCODE = -15;
  public static final int LOAD_SO_FAILED = -70;
  public static final int NEED_RELOGIN_RETCODE = -5;
  public static final int NETWORK_NOT_AVALIABLE_RETCODE = -50;
  public static final int NOT_CHANGE_IP_SERVER = -19;
  public static final int NO_AVALIABLE_ROUTE_RETCODE = -32;
  public static final int NULL_CTLPK_RETCODE = -12;
  public static final int OTHER_ERROR_RETCODE = -16;
  public static final int REQUEST_CANCELED_RETCODE = -3;
  public static final int REQUEST_TIMEOUT_RETCODE = -4;
  public static final int SERVER_ERROR_CLIENT_RETRY = -3000;
  public static final int SERVER_ERROR_RETCODE = -2;
  public static final int SESSION_SEND_FAIL = 504;
  public static final int SOCKET_ERROR_RETCODE = -1;
  public static final int SOKCET_END_FIX_RETCODE = -65;
  public static final int SOKCET_END_RETCODE = -60;
  public static final int TIMEOUT_RETCODE = -11;
  public static final int UI_A2_B2_NULL_RETCODE = 702;
  public static final int UI_FILE_INVALID_RETCODE = 701;
  public static final int UI_FILE_NOT_EXIST_RETCODE = 700;
  public static final int UI_UIN_0_RETCODE = 703;
  public static final int USER_CANCEL = -20;
  private final int a;
  
  public UploadException(int paramInt, Exception paramException)
  {
    super(paramException);
    this.a = paramInt;
  }
  
  public UploadException(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public int getRetCode()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\other\UploadException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */