package com.tencent.av.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.C2BUserInfo;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.opengl.GlStringParser;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ghf;
import ghg;
import java.io.UnsupportedEncodingException;

public class VcControllerImpl
{
  public static final int EM_SDK_EVENT_ACCEPT_VIDEO_MODE = 106;
  public static final int EM_SDK_EVENT_CANCEL_VIDEO_MODE = 108;
  public static final int EM_SDK_EVENT_ID_DEVICE_ATTR = 110;
  public static final int EM_SDK_EVENT_ID_DISABLE_C2C_MSG = 103;
  public static final int EM_SDK_EVENT_ID_NOTIFY_STATUS_CHANGE = 102;
  public static final int EM_SDK_EVENT_ID_PSTN_CALL = 95;
  public static final int EM_SDK_EVENT_ID_RECV_AVFUNCHATRMSG = 111;
  public static final int EM_SDK_EVENT_ID_SMARTDEVICE_AUDIO_DATA = 96;
  public static final int EM_SDK_EVENT_REJECT_VIDEO_MODE = 107;
  public static final int EM_SDK_EVENT_REQUEST_VIDEO_MODE = 105;
  public static final int EM_VOIP_AUDIOENGINE_READY = 83;
  public static final int EM_VOIP_SEND_FIRST_AUDIO_DATA = 71;
  public static final int EV_M2MVIDEO_DEC_FRAME_DATA = 15;
  public static final int EV_VOIP_ANOTHERISRING = 25;
  public static final int EV_VOIP_ANOTHERRINGDISCONNECTED = 26;
  public static final int EV_VOIP_ANOTHER_HAVEDACCEPT = 13;
  public static final int EV_VOIP_ANOTHER_HAVEDREJECT = 14;
  public static final int EV_VOIP_AUDIO_REQUEST = 2;
  public static final int EV_VOIP_AUDIO_SWITCH = 50;
  public static final int EV_VOIP_CAN_RECV_AUDIO_DATA = 63;
  public static final int EV_VOIP_CLOSED = 4;
  public static final int EV_VOIP_CLOSED_SWITCH_GROUP = 69;
  public static final int EV_VOIP_CONFIGSYS_DEAL_DONE = 18;
  public static final int EV_VOIP_CONNFAIL = 24;
  public static final int EV_VOIP_DETAIL_NET_STATE_CHECK = 100;
  public static final int EV_VOIP_FRIEND_ACCEPTED = 3;
  public static final int EV_VOIP_HAS_GETTED_SHARP_CONFIG_PAYLOAD = 93;
  public static final int EV_VOIP_HAS_RECV_FIRST_AUDIO_PACKET = 64;
  public static final int EV_VOIP_HAS_RECV_FIRST_VIDEOFRAME = 66;
  public static final int EV_VOIP_InviteReached = 68;
  public static final int EV_VOIP_LOCAL_AUDIO_LESS_DATA = 92;
  public static final int EV_VOIP_LOCAL_AUDIO_NO_DATA = 91;
  public static final int EV_VOIP_MEDIA_CAMERA_NOTIFY = 65;
  public static final int EV_VOIP_MOBILE_AUDIO_REQ = 60;
  public static final int EV_VOIP_MOBILE_VIDEO_REQ = 61;
  public static final int EV_VOIP_NETWORK_BAD = 11;
  public static final int EV_VOIP_NETWORK_GOOD = 12;
  public static final int EV_VOIP_NETWORK_MONITOR_INFO = 16;
  public static final int EV_VOIP_NOT_RECV_AUDIO_DATA = 62;
  public static final int EV_VOIP_OLD_REQUEST_NOT_SUPPORT_SHARP = 30;
  public static final int EV_VOIP_OTHER_TER_CHATING_STAUTS = 72;
  public static final int EV_VOIP_PAUSEAUDIO = 7;
  public static final int EV_VOIP_PAUSEVIDEO = 8;
  public static final int EV_VOIP_PEER_NET_STATE_CHECK = 67;
  public static final int EV_VOIP_PEER_SWITCH_FAIL = 76;
  public static final int EV_VOIP_PEER_SWITCH_TERMINAL = 73;
  public static final int EV_VOIP_RECEIVER_RECEIVED_REQ = 17;
  public static final int EV_VOIP_RECEIVE_RELAYASVR_INFO = 5;
  public static final int EV_VOIP_RELAY_SVR_CONNECTED = 6;
  public static final int EV_VOIP_RESUMEAUDIO = 9;
  public static final int EV_VOIP_RESUMEVIDEO = 10;
  public static final int EV_VOIP_SWITCHAUDIO = 19;
  public static final int EV_VOIP_SWITCHVIDEO = 20;
  public static final int EV_VOIP_SWITCHVIDEOCANCEL = 22;
  public static final int EV_VOIP_SWITCHVIDEOCONFIRM = 21;
  public static final int EV_VOIP_SWITCH_TERMINAL_SUCCESS = 74;
  public static final int EV_VOIP_SYNC_OTHER_TERMINAL_CHAT_STATUS = 75;
  public static final int EV_VOIP_VIDEO_REQUEST = 1;
  public static int NATIVE_ERR_NOT_INI = 0;
  public static int NATIVE_ERR_NO_ENV = 0;
  public static int NATIVE_ERR_NULL_PARA = 0;
  public static int NATIVE_ERR_OUT_MEM = 0;
  private static String SPDEFVALUE = "preview-size-values=320x240,640x480;";
  private static String SPKEY;
  private static String SPNAME;
  public static final int VOIP_REASON_CALL_TYPE_NOT_SUIT = 17;
  public static final int VOIP_REASON_CANCLE_BY_REQUESTER_BEFORECALLING = 18;
  public static final int VOIP_REASON_CAPA_EXCHANGE_FAILED = 15;
  public static final int VOIP_REASON_CLOSED_BY_FRIEND = 1;
  public static final int VOIP_REASON_CLOSED_BY_SELF = 0;
  public static final int VOIP_REASON_CLOSED_BY_SELF_IGNORE = 16;
  public static final int VOIP_REASON_CLOSED_BY_SWITCHTOGROUP = 20;
  public static final int VOIP_REASON_CONFLICT = 6;
  public static final int VOIP_REASON_FRIEND_CONFLICT = 7;
  public static final int VOIP_REASON_FRIEND_OFFLINE = 14;
  public static final int VOIP_REASON_FRIEND_VERSION_NOT_SUPPORT = 5;
  public static final int VOIP_REASON_FRIEND_WAIT_RELAYINFO_TIMEOUT = 10;
  public static final int VOIP_REASON_FRIEND_WAIT_RELAY_CONNECT_TIMEOUT = 11;
  public static final int VOIP_REASON_NETWORK_DISCONNECT = 13;
  public static final int VOIP_REASON_NETWORK_ERROR = 12;
  public static final int VOIP_REASON_OTHERS = 30;
  public static final int VOIP_REASON_REJECT_BY_FRIEND = 2;
  public static final int VOIP_REASON_REJECT_BY_SELF = 3;
  public static final int VOIP_REASON_SELF_OFFLINE = 19;
  public static final int VOIP_REASON_SELF_VERSION_NOT_SUPPORT = 4;
  public static final int VOIP_REASON_SELF_WAIT_RELAYINFO_TIMEOUT = 8;
  public static final int VOIP_REASON_SELF_WAIT_RELAY_CONNECT_TIMEOUT = 9;
  private static String mCameraParameters;
  private final String TAG = "VcControllerImpl";
  private int mColorFmt = -1;
  ghf mEventHandler = null;
  public IVideoEventListener mEventListener;
  GlStringParser mGlStringParser = null;
  public AbstractNetChannel mNetChannel;
  public int mPreviewH = 240;
  public int mPreviewW = 320;
  private boolean mSharpFlag;
  VcSystemInfo mSysInfo;
  private int mVideoHeight = -1;
  private int mVideoWidth = -1;
  private boolean mbBackground;
  public boolean mfAudio2VideoFlag = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    NATIVE_ERR_OUT_MEM = -101;
    NATIVE_ERR_NOT_INI = -102;
    NATIVE_ERR_NO_ENV = -103;
    NATIVE_ERR_NULL_PARA = -104;
    SPNAME = "AV_CameraParameters";
    SPKEY = "CP";
  }
  
  public VcControllerImpl(Context paramContext, String paramString, AbstractNetChannel paramAbstractNetChannel, IVideoEventListener paramIVideoEventListener, int paramInt1, int paramInt2, int paramInt3)
  {
    loadLibrary(paramContext);
    ConfigInfo.instance();
    paramInt3 = AndroidCodec.a(paramContext);
    if (QLog.isColorLevel()) {
      QLog.e("VcControllerImpl", 2, "supportMediaCodec: " + paramInt3);
    }
    init_deviceinfos(paramContext, paramInt1, paramInt2, paramInt3);
    setScreenSize(paramInt1, paramInt2);
    ClientLogReport.instance().init(paramContext, Integer.parseInt(paramString));
    this.mNetChannel = paramAbstractNetChannel;
    this.mNetChannel.a(this);
    this.mEventListener = paramIVideoEventListener;
    if (getSdkVersion() < 18)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VcControllerImpl", 2, "sdk version: " + getSdkVersion());
      }
      throw new UnsatisfiedLinkError();
    }
    cacheMethodIds();
    this.mSysInfo = new VcSystemInfo();
    VcSystemInfo.a();
    mCameraParameters = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).getString(SPKEY, SPDEFVALUE);
  }
  
  private static native void cacheMethodIds();
  
  private void callbackDataTransfered(int paramInt, long paramLong)
  {
    if (this.mEventListener != null) {
      this.mEventListener.a(paramInt, paramLong);
    }
  }
  
  private int callbackGetAPAndGateWayIP()
  {
    if (this.mEventListener != null) {
      return this.mEventListener.e();
    }
    return -1;
  }
  
  private void callbackOnEvent(int paramInt1, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    if (this.mEventListener == null) {}
    while (this.mEventHandler == null) {
      return;
    }
    ghg localghg = new ghg(this);
    localghg.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    localghg.jdField_a_of_type_Long = paramLong1;
    localghg.jdField_b_of_type_Long = paramLong2;
    localghg.c = paramLong3;
    localghg.d = paramLong4;
    localghg.jdField_a_of_type_JavaLangString = paramString;
    localghg.jdField_a_of_type_Int = paramInt2;
    localghg.jdField_b_of_type_Int = paramInt3;
    localghg.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramArrayOfByte1 = this.mEventHandler.obtainMessage(paramInt1, 0, 0, localghg);
    this.mEventHandler.sendMessage(paramArrayOfByte1);
  }
  
  private void callbackSendConfigReq(byte[] paramArrayOfByte)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.a(paramArrayOfByte);
    }
  }
  
  private void callbackTcpSend(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.a(paramArrayOfByte, paramLong);
    }
  }
  
  private void callbackTcpSendM2M(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.b(paramArrayOfByte, paramLong);
    }
  }
  
  private void callbackTcpSendSharpCMD(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.c(paramArrayOfByte, paramLong);
    }
  }
  
  /* Error */
  private void changePreviewSize(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 225	com/tencent/av/core/VcControllerImpl:mGlStringParser	Lcom/tencent/av/opengl/GlStringParser;
    //   6: ifnonnull +18 -> 24
    //   9: aload_0
    //   10: new 421	com/tencent/av/opengl/GlStringParser
    //   13: dup
    //   14: bipush 61
    //   16: bipush 59
    //   18: invokespecial 424	com/tencent/av/opengl/GlStringParser:<init>	(CC)V
    //   21: putfield 225	com/tencent/av/core/VcControllerImpl:mGlStringParser	Lcom/tencent/av/opengl/GlStringParser;
    //   24: aload_0
    //   25: invokespecial 427	com/tencent/av/core/VcControllerImpl:queryCameraParameters	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_0
    //   30: getfield 225	com/tencent/av/core/VcControllerImpl:mGlStringParser	Lcom/tencent/av/opengl/GlStringParser;
    //   33: aload_3
    //   34: invokevirtual 430	com/tencent/av/opengl/GlStringParser:a	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 225	com/tencent/av/core/VcControllerImpl:mGlStringParser	Lcom/tencent/av/opengl/GlStringParser;
    //   41: ldc_w 432
    //   44: invokevirtual 435	com/tencent/av/opengl/GlStringParser:a	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +38 -> 87
    //   52: aload_3
    //   53: new 249	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   60: iload_1
    //   61: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 437
    //   67: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload_2
    //   71: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokevirtual 443	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   80: istore 4
    //   82: iload 4
    //   84: ifne +6 -> 90
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: aload_0
    //   91: iload_1
    //   92: putfield 221	com/tencent/av/core/VcControllerImpl:mPreviewW	I
    //   95: aload_0
    //   96: iload_2
    //   97: putfield 223	com/tencent/av/core/VcControllerImpl:mPreviewH	I
    //   100: aload_0
    //   101: getfield 219	com/tencent/av/core/VcControllerImpl:mEventHandler	Lghf;
    //   104: new 445	ghe
    //   107: dup
    //   108: aload_0
    //   109: invokespecial 446	ghe:<init>	(Lcom/tencent/av/core/VcControllerImpl;)V
    //   112: invokevirtual 450	ghf:post	(Ljava/lang/Runnable;)Z
    //   115: pop
    //   116: goto -29 -> 87
    //   119: astore_3
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_3
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	VcControllerImpl
    //   0	124	1	paramInt1	int
    //   0	124	2	paramInt2	int
    //   28	25	3	str	String
    //   119	4	3	localObject	Object
    //   80	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	119	finally
    //   24	48	119	finally
    //   52	82	119	finally
    //   90	116	119	finally
  }
  
  public static void loadLibrary(Context paramContext)
  {
    try
    {
      SoLoadUtil.a(paramContext, "xplatform", 0, false);
      SoLoadUtil.a(paramContext, "stlport_shared", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          UpdateAvSo.a(paramContext, "VideoCtrl", true);
          return;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          paramContext.printStackTrace();
        }
        localUnsatisfiedLinkError = localUnsatisfiedLinkError;
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  private void onRecvRequest(int paramInt, ghg paramghg)
  {
    byte[] arrayOfByte1 = paramghg.jdField_a_of_type_ArrayOfByte;
    int i = (int)paramghg.c;
    String str3 = paramghg.jdField_a_of_type_JavaLangString;
    int j = paramghg.jdField_a_of_type_Int;
    int k = paramghg.jdField_b_of_type_Int;
    if (k == 3124) {
      i = 26;
    }
    String str4 = CharacterUtil.a(paramghg.jdField_b_of_type_Long);
    String str1 = null;
    switch (i)
    {
    default: 
    case 0: 
    case 10: 
    case 12: 
    case 19: 
    case 4: 
    case 5: 
    case 24: 
    case 25: 
    case 26: 
      while ((paramInt == 2) || (paramInt == 60))
      {
        this.mEventListener.a(i, str4, str1, paramghg.jdField_b_of_type_ArrayOfByte, true, str3, j, k);
        label192:
        if (QLog.isColorLevel()) {
          QLog.d("onRecvRequest", 2, "uinType = " + i + ", extraUin = " + str1 + ", longFronUin = " + paramghg.jdField_b_of_type_Long);
        }
        return;
        str1 = null;
        continue;
        if (arrayOfByte1 != null)
        {
          int m = arrayOfByte1[0];
          str1 = null;
          String str2 = str1;
          if (arrayOfByte1.length > m + 1)
          {
            arrayOfByte2 = new byte[m];
            str2 = str1;
            if (arrayOfByte2 != null)
            {
              System.arraycopy(arrayOfByte1, 1, arrayOfByte2, 0, m);
              str2 = new String(arrayOfByte2);
            }
          }
          int n = arrayOfByte1[(m + 1)];
          if (arrayOfByte1.length <= m + n + 2) {
            break label505;
          }
          byte[] arrayOfByte2 = new byte[n];
          str1 = null;
          if (arrayOfByte2 != null)
          {
            System.arraycopy(arrayOfByte1, m + 2, arrayOfByte2, 0, n);
            str1 = new String(arrayOfByte2);
          }
          if ((str1 == null) || (str2 == null)) {
            break label502;
          }
          str1 = str2 + str1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("onRecvRequest", 2, "uinType = " + i + ", extraUin = " + str1);
      }
      break;
      str1 = String.valueOf(paramghg.d);
      break;
      if ((paramInt != 1) && (paramInt != 61)) {
        break label192;
      }
      this.mEventListener.a(i, str4, str1, paramghg.jdField_b_of_type_ArrayOfByte, false, str3, j, k);
      break label192;
      label502:
      continue;
      label505:
      str1 = null;
    }
  }
  
  /* Error */
  private String queryCameraParameters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 338	com/tencent/av/core/VcControllerImpl:mCameraParameters	Ljava/lang/String;
    //   5: ifnull +11 -> 16
    //   8: getstatic 338	com/tencent/av/core/VcControllerImpl:mCameraParameters	Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: getstatic 200	com/tencent/av/core/VcControllerImpl:SPDEFVALUE	Ljava/lang/String;
    //   19: astore_1
    //   20: goto -8 -> 12
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	VcControllerImpl
    //   11	9	1	str	String
    //   23	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	23	finally
    //   16	20	23	finally
  }
  
  private native void sendTransferMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public static boolean setCameraParameters(String paramString)
  {
    mCameraParameters = paramString;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).edit();
    localEditor.putString(SPKEY, paramString);
    return localEditor.commit();
  }
  
  private native int setupDeviceInfos(String paramString);
  
  public String GetManufacture()
  {
    return Build.MANUFACTURER;
  }
  
  public String GetOsName()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String GetRomInfo()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  public native int PauseVideo(long paramLong);
  
  public int PlayDevGetData(byte[] paramArrayOfByte, int paramInt)
  {
    return outputAudioData(paramArrayOfByte, paramInt);
  }
  
  public int RecDevPutData(byte[] paramArrayOfByte, int paramInt)
  {
    return inputAudioData(paramArrayOfByte, paramInt);
  }
  
  public native int ResumeVideo(long paramLong);
  
  public native void SetAudioDataSendByDefault(boolean paramBoolean);
  
  public native void SetAudioDataSink(boolean paramBoolean);
  
  public int SetAudioInputMute(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    if (str.startsWith("+")) {
      str.substring(1);
    }
    if (paramBoolean) {
      return stopAudioSend();
    }
    return startAudioSend();
  }
  
  public int SetAudioOutput(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    if (str.startsWith("+")) {
      str.substring(1);
    }
    if (paramBoolean) {
      return startAudioRecv();
    }
    return stopAudioRecv();
  }
  
  public int SetNetIPAndPort(String paramString, int paramInt)
  {
    return setNetIpAndPort(paramString, paramInt);
  }
  
  public int UpdateSelfUin(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return setSelfUin(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  native int accept(long paramLong, int paramInt1, int paramInt2);
  
  public int acceptVideo(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      paramLong = CharacterUtil.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, "acceptVideo friendUin = " + paramLong);
      }
      setApType(paramInt1);
      return accept(paramLong, paramInt2, paramInt3);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  native int acceptVideoMode(long paramLong);
  
  public int acceptVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return acceptVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  native int cancelVideoMode(long paramLong);
  
  public int cancelVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return cancelVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  native int close(long paramLong, int paramInt);
  
  public int closeVideo(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return close(l, paramInt);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public byte[] createTLVpackage(long paramLong, String paramString, byte paramByte, int paramInt)
  {
    int i3 = 0;
    try
    {
      paramString = paramString.getBytes("utf-8");
      int i4 = paramString.length;
      i3 = i4;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        int i;
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        paramString = new byte[0];
      }
    }
    arrayOfByte = new byte[6 + (i3 + 12 + 3 + 6)];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    arrayOfByte[2] = 1;
    arrayOfByte[3] = 2;
    arrayOfByte[4] = 1;
    arrayOfByte[5] = 1;
    arrayOfByte[6] = 3;
    arrayOfByte[7] = 8;
    i = (byte)(int)(0xFF & paramLong);
    j = (byte)(int)(paramLong >> 8 & 0xFF);
    k = (byte)(int)(paramLong >> 16 & 0xFF);
    m = (byte)(int)(paramLong >> 24 & 0xFF);
    n = (byte)(int)(paramLong >> 32 & 0xFF);
    i1 = (byte)(int)(paramLong >> 40 & 0xFF);
    i2 = (byte)(int)(paramLong >> 48 & 0xFF);
    System.arraycopy(new byte[] { (byte)(int)(paramLong >> 56 & 0xFF), i2, i1, n, m, k, j, i }, 0, arrayOfByte, 8, 8);
    arrayOfByte[16] = 4;
    arrayOfByte[17] = ((byte)i3);
    if (i3 > 0) {
      System.arraycopy(paramString, 0, arrayOfByte, 18, 8);
    }
    i3 += 18;
    arrayOfByte[i3] = 5;
    i3 += 1;
    arrayOfByte[i3] = 1;
    i3 += 1;
    arrayOfByte[i3] = paramByte;
    i3 += 1;
    arrayOfByte[i3] = 6;
    i3 += 1;
    arrayOfByte[i3] = 4;
    i3 += 1;
    paramByte = (byte)(paramInt & 0xFF);
    i = (byte)(paramInt >> 8 & 0xFF);
    j = (byte)(paramInt >> 16 & 0xFF);
    System.arraycopy(new byte[] { (byte)(paramInt >> 24 & 0xFF), j, i, paramByte }, 0, arrayOfByte, i3, 4);
    return arrayOfByte;
  }
  
  native int doReport(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
  
  public int doReport(int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null) {
      l1 = l2;
    }
    try
    {
      if (paramString.length() > 0) {
        l1 = Long.parseLong(paramString);
      }
      return doReport(paramInt1, paramInt2, paramInt3, l1, paramLong);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        l1 = 0L;
      }
    }
  }
  
  protected void finalize()
  {
    uninit();
    super.finalize();
  }
  
  public native int getAudioParam(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4);
  
  native int getBusiTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  public int getCameraFacing()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.c();
    }
    return 0;
  }
  
  native long getChatRoomID(long paramLong);
  
  public long getChatRoomID(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return getChatRoomID(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1L;
  }
  
  native int getCmdTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  public int getCpuArchitecture()
  {
    if (this.mSysInfo != null)
    {
      VcSystemInfo localVcSystemInfo = this.mSysInfo;
      return VcSystemInfo.f();
    }
    return 0;
  }
  
  public int getCpuMaxFrequency()
  {
    return (int)VcSystemInfo.jdField_a_of_type_Long;
  }
  
  public String getDeviceName()
  {
    return VcSystemInfo.a();
  }
  
  public int getDispHeight()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.p;
    }
    return 0;
  }
  
  public int getDispWidth()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.o;
    }
    return 0;
  }
  
  public native int getEncodeFrameFunctionPtrFunPtr();
  
  native byte[] getInterestingString(long paramLong);
  
  public byte[] getInterestingString(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return getInterestingString(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public int getNumCores()
  {
    return VcSystemInfo.j;
  }
  
  public int getOsType()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.d();
    }
    return 0;
  }
  
  native int getPeerSdkVersion(long paramLong);
  
  public int getPeerSdkVersion(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return getPeerSdkVersion(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  native int getPeerTerminalType(long paramLong);
  
  public int getPeerTerminalType(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return getPeerTerminalType(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int getScreenHeight()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.n;
    }
    return 0;
  }
  
  public int getScreenWidth()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.m;
    }
    return 0;
  }
  
  public native int getSdkVersion();
  
  native long getTrafficSize(long paramLong);
  
  public long getTrafficSize(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return getTrafficSize(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1L;
  }
  
  public native int getVolume();
  
  public native int hasAVShiftAbility(long paramLong);
  
  native int ignore(long paramLong);
  
  public int ignoreVideo(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      setApType(paramInt);
      return ignore(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public native int init(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt);
  
  public void init_deviceinfos(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "PRODUCT=" + Build.PRODUCT + ";";
    str = str + "CPU_ABI=" + Build.CPU_ABI + ";";
    str = str + "TAGS=" + Build.TAGS + ";";
    str = str + "VERSION_CODES_BASE=1;";
    str = str + "MODEL=" + Build.MODEL + ";";
    str = str + "SDK=" + Build.VERSION.SDK_INT + ";";
    str = str + "VERSION_RELEASE=" + Build.VERSION.RELEASE + ";";
    str = str + "DEVICE=" + Build.DEVICE + ";";
    str = str + "DISPLAY=" + Build.DISPLAY + ";";
    str = str + "BRAND=" + Build.BRAND + ";";
    str = str + "BOARD=" + Build.BOARD + ";";
    str = str + "FINGERPRINT=" + Build.FINGERPRINT + ";";
    str = str + "ID=" + Build.ID + ";";
    str = str + "MANUFACTURER=" + Build.MANUFACTURER + ";";
    str = str + "USER=" + Build.USER + ";";
    if (paramInt3 > 0) {
      if ((paramInt3 & 0x1) == 1)
      {
        str = str + "HWAVCDEC=1;";
        if ((paramInt3 & 0x2) != 2) {
          break label780;
        }
        str = str + "HWAVCENC=1;";
        label575:
        paramContext = paramContext.getApplicationInfo();
        str = str + "DATADIR=" + paramContext.dataDir + ";";
        if (Build.VERSION.SDK_INT < 9) {
          break label855;
        }
      }
    }
    label780:
    label855:
    for (paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";; paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib" + ";")
    {
      paramContext = paramContext + "W=" + paramInt1 + ";";
      setupDeviceInfos(paramContext + "H=" + paramInt2 + ";");
      if (this.mEventHandler == null)
      {
        paramContext = Looper.getMainLooper();
        if (paramContext == null) {
          break label899;
        }
        this.mEventHandler = new ghf(this, paramContext);
      }
      return;
      str = str + "HWAVCDEC=0;";
      break;
      str = str + "HWAVCENC=0;";
      break label575;
      str = str + "HWAVCENC=0;";
      str = str + "HWAVCDEC=0;";
      break label575;
    }
    label899:
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.mEventHandler = new ghf(this, paramContext);
      return;
    }
    this.mEventHandler = null;
  }
  
  native int inputAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public native boolean isEngineActive();
  
  public boolean isSharp()
  {
    return ismSharpFlag();
  }
  
  public boolean ismSharpFlag()
  {
    return this.mSharpFlag;
  }
  
  native int notifyAnotherSelfIsRing(long paramLong, boolean paramBoolean);
  
  public int notifyAnotherSelfIsRing(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return notifyAnotherSelfIsRing(l, paramBoolean);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public native int notifyAnotherTerChatStatus(long paramLong, int paramInt);
  
  public void onAudioData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeEventHandler", 2, "receive null audiodata");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("NotifyDataLength", paramArrayOfByte.length);
    localBundle.putByteArray("NotifyDataValue", paramArrayOfByte);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("NotifyData", localBundle);
    paramArrayOfByte.setAction("SmartDevice_AudioData");
    BaseApplicationImpl.a().sendBroadcast(paramArrayOfByte, "com.tencent.smartdevice.permission.broadcast");
  }
  
  public native int onLogOutByKicked();
  
  native int onRecvVideoCallBytes(byte[] paramArrayOfByte);
  
  native int onRecvVideoCallBytesForSharp(byte[] paramArrayOfByte);
  
  native int onRecvVideoCallBytesForSharpC2SACK(byte[] paramArrayOfByte);
  
  native int onRecvVideoCallBytesM2M(byte[] paramArrayOfByte);
  
  native int onRecvVideoCloudConfig(byte[] paramArrayOfByte);
  
  native int onRecvVideoRequest(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public int onRecvVideoRequest(String paramString, byte[] paramArrayOfByte)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return onRecvVideoRequest(l, paramArrayOfByte, 0, 0);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  native int outputAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public int pauseVideo(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    if (str.startsWith("+")) {
      str.substring(1);
    }
    return stopVideoSend();
  }
  
  public native AVPbInfo processQCallPush(byte[] paramArrayOfByte, AVPbInfo paramAVPbInfo);
  
  public VcControllerImpl.DeviceCMDTLV receiveTransferMsg(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, " receiveTransferMsg : uin = " + paramString);
    }
    paramString = unpackTLV(paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, " receiveTransferMsg : tlv = " + paramString.toString());
    }
    return paramString;
  }
  
  native int reject(long paramLong, int paramInt);
  
  public int rejectVideo(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "rejectVideo --> PeerUin = " + paramString + " ,apn = " + paramInt1 + " ,rejectReason = " + paramInt2);
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      setApType(paramInt1);
      return reject(l, paramInt2);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  native int rejectVideoMode(long paramLong);
  
  public int rejectVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return rejectVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  native int request(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  native int requestByMobileNo(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4, int paramInt5);
  
  native int requestFromQQToUnQQ(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, int paramInt3);
  
  native int requestFromTempChat(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6);
  
  native int requestSharp(long paramLong, int paramInt1, int paramInt2);
  
  native int requestSwitchTerminal(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  public native int requestUnQQ(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public int requestVideo(String paramString1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, String paramString2, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "requestVideo-->peerUin=" + paramString1 + " relationType=" + paramInt3 + " businessType" + paramInt2 + " sign" + paramArrayOfByte + " bindId" + paramString2 + " bindType" + paramInt4);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return -1;
    }
    try
    {
      long l = CharacterUtil.a(paramString1);
      setApType(paramInt1);
      return requestFromQQToUnQQ(l, paramInt2, paramInt3, paramArrayOfByte, paramString2, paramInt4);
    }
    catch (NumberFormatException paramString1) {}
    return -1;
  }
  
  public int requestVideo(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, String paramString10)
  {
    String str1 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str1 = "0";
    }
    paramString1 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString1 = "0";
    }
    String str2 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      str2 = "0";
    }
    paramString5 = paramString7;
    if (TextUtils.isEmpty(paramString7)) {
      paramString5 = "";
    }
    paramString6 = paramString8;
    if (TextUtils.isEmpty(paramString8)) {
      paramString6 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "requestVideo funcall buffer:" + paramString5);
    }
    long l1;
    long l2;
    try
    {
      paramLong1 = CharacterUtil.a(str1);
      l1 = Long.parseLong(paramString1);
      l2 = Long.parseLong(str2);
      setApType(paramInt1);
      if (paramLong2 != 0L) {
        return requestSwitchTerminal(paramLong1, paramInt2, paramInt3, paramLong2);
      }
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      return -1;
    }
    if ((paramString4 != null) && (paramString4.length() != 0)) {
      return requestByMobileNo(paramLong1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramInt4, paramString5.getBytes(), paramString9, paramInt5, paramInt6);
    }
    if (4 == paramInt3)
    {
      if (51 == paramInt4)
      {
        paramString1 = null;
        if (paramString10 == null) {}
      }
      try
      {
        paramString1 = paramString10.getBytes();
        return requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString5.getBytes(), paramString6.getBytes("utf-8"), 5119, paramString1, null, null);
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        return -1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return -1;
      }
      paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString5.getBytes(), paramString6.getBytes("utf-8"), 0, null, null, null);
      return paramInt1;
    }
    try
    {
      paramInt1 = request(paramLong1, paramInt2, paramInt3, paramString5.getBytes(), paramString6.getBytes("utf-8"));
      return paramInt1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
      return -1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public int requestVideo(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, String paramString10, C2BUserInfo paramC2BUserInfo)
  {
    String str1 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str1 = "0";
    }
    String str2 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      str2 = "0";
    }
    String str3 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      str3 = "0";
    }
    paramString1 = paramString7;
    if (TextUtils.isEmpty(paramString7)) {
      paramString1 = "";
    }
    paramString5 = paramString8;
    if (TextUtils.isEmpty(paramString8)) {
      paramString5 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "requestVideo funcall buffer:" + paramString1);
    }
    long l1;
    long l2;
    try
    {
      paramLong1 = CharacterUtil.a(str1);
      l1 = Long.parseLong(str2);
      l2 = Long.parseLong(str3);
      setApType(paramInt1);
      if (paramLong2 != 0L) {
        return requestSwitchTerminal(paramLong1, paramInt2, paramInt3, paramLong2);
      }
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      return -1;
    }
    if ((paramString4 != null) && (paramString4.length() != 0)) {
      return requestByMobileNo(paramLong1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramInt4, paramString1.getBytes(), paramString9, paramInt5, paramInt6);
    }
    if (4 == paramInt3)
    {
      if (51 == paramInt4)
      {
        paramString2 = null;
        if (paramString10 == null) {}
      }
      try
      {
        paramString2 = paramString10.getBytes();
        paramString3 = null;
        if (paramC2BUserInfo.d != null) {
          paramString3 = paramC2BUserInfo.d.getBytes();
        }
        paramString4 = null;
        if (paramC2BUserInfo.d != null) {
          paramString4 = paramC2BUserInfo.e.getBytes();
        }
        return requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString1.getBytes(), paramString5.getBytes("utf-8"), 5119, paramString2, paramString3, paramString4);
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        return -1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return -1;
      }
      paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString1.getBytes(), paramString5.getBytes("utf-8"), 0, null, null, null);
      return paramInt1;
    }
    try
    {
      paramInt1 = request(paramLong1, paramInt2, paramInt3, paramString1.getBytes(), paramString5.getBytes("utf-8"));
      return paramInt1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
      return -1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  native int requestVideoMode(long paramLong);
  
  public int requestVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return requestVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int resumeVideo(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    if (str.startsWith("+")) {
      str.substring(1);
    }
    return startVideoSend();
  }
  
  native int sendAVFunChatMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public int sendAVFunChatMsg(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equals(""))) {
      return -1;
    }
    try
    {
      long l = Long.parseLong(paramString1);
      return sendAVFunChatMsg(l, paramInt, paramString2.getBytes());
    }
    catch (NumberFormatException paramString2)
    {
      paramString2.printStackTrace();
      QLog.e("VcControllerImpl", 1, " sendAVFunChatMsg| uin = " + paramString1);
    }
    return -1;
  }
  
  public native int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public native int sendDTMFMessage(long paramLong, char paramChar);
  
  public native int sendQueryRoomInfoRequest(long paramLong1, long paramLong2);
  
  public void sendTransferMsg(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      long l = Long.parseLong(paramString);
      sendTransferMsg(l, paramInt1, createTLVpackage(l, "", (byte)paramInt2, paramInt3));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VcControllerImpl", 2, " sendTransferMsg string parse long error : uin = " + paramString);
    }
  }
  
  public native int setApType(int paramInt);
  
  public native void setAudioOpt(boolean paramBoolean);
  
  native int setAudioOutputMode(int paramInt);
  
  public int setAudioSpeakerVolume(int paramInt)
  {
    return 0;
  }
  
  public void setBackground(boolean paramBoolean)
  {
    this.mbBackground = paramBoolean;
  }
  
  native int setGatewayIp(String paramString);
  
  native int setNetIpAndPort(String paramString, int paramInt);
  
  public native void setProcessDecoderFrameFunctionptr(int paramInt);
  
  native int setProductId(int paramInt);
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    if (this.mSysInfo != null) {
      this.mSysInfo.a(paramInt1, paramInt2);
    }
  }
  
  native int setSelfUin(long paramLong);
  
  public native void setVideoJitterLength(int paramInt);
  
  public void setVideoPara(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mColorFmt = paramInt3;
  }
  
  public native void setVideoReceiver(boolean paramBoolean);
  
  native int startAudioRecv();
  
  native int startAudioSend();
  
  native int startVideoSend();
  
  native int stopAudioRecv();
  
  native int stopAudioSend();
  
  native int stopVideoSend();
  
  native int switchAudio(long paramLong);
  
  public int switchAudio(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      int i = switchAudio(l);
      if (i == -1) {
        this.mfAudio2VideoFlag = false;
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, "switchAudio", paramString);
      }
    }
    return -1;
  }
  
  native int switchVideo(long paramLong);
  
  public int switchVideo(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      int i = switchVideo(l);
      if (i == -1) {
        this.mfAudio2VideoFlag = false;
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, "switchVideo", paramString);
      }
    }
    return -1;
  }
  
  public native int uninit();
  
  public VcControllerImpl.DeviceCMDTLV unpackTLV(byte[] paramArrayOfByte)
  {
    Object localObject = "";
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, 8, arrayOfByte, 0, 8);
    long l1 = arrayOfByte[0];
    long l2 = arrayOfByte[1];
    long l3 = arrayOfByte[2];
    long l4 = arrayOfByte[3];
    long l5 = arrayOfByte[4];
    long l6 = arrayOfByte[5];
    long l7 = arrayOfByte[6];
    long l8 = arrayOfByte[7];
    int j = paramArrayOfByte[17];
    int i = 18;
    if (j > 0)
    {
      localObject = new byte[j];
      System.arraycopy(paramArrayOfByte, 18, localObject, 0, j);
    }
    try
    {
      localObject = new String((byte[])localObject, "utf-8");
      i = j + 18;
      j = i + 2;
      i = paramArrayOfByte[j];
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, j + 1 + 2, arrayOfByte, 0, 4);
      j = arrayOfByte[3];
      int k = arrayOfByte[2];
      int m = arrayOfByte[1];
      int n = arrayOfByte[0];
      paramArrayOfByte = new VcControllerImpl.DeviceCMDTLV(this);
      paramArrayOfByte.jdField_a_of_type_Long = ((l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | (l8 & 0xFF) << 0);
      paramArrayOfByte.jdField_a_of_type_JavaLangString = ((String)localObject);
      paramArrayOfByte.jdField_a_of_type_Int = i;
      paramArrayOfByte.jdField_b_of_type_Int = (j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16 | (n & 0xFF) << 24);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  public native int updateConfigInfo();
  
  public void uploadSharpNode(int paramInt, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    if (str.startsWith("+")) {
      str.substring(1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\core\VcControllerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */