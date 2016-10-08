package com.tencent.av.gaudio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.VideoController;
import com.tencent.av.config.Common;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gin;
import gio;
import java.util.ArrayList;
import java.util.Vector;

public class QQGAudioCtrl
{
  static final int EM_SDK_EVENT_ID_ALL_CAN_GO_ON_STAGE = 103;
  static final int EM_SDK_EVENT_ID_ALL_MEM_UPDATE = 44;
  static final int EM_SDK_EVENT_ID_ALL_ONLINE_NOTICE = 16;
  static final int EM_SDK_EVENT_ID_CHANGE_MIC_ORDER = 151;
  static final int EM_SDK_EVENT_ID_CONN_TIMEOUT = 39;
  static final int EM_SDK_EVENT_ID_CREATE_FAIL = 31;
  static final int EM_SDK_EVENT_ID_CREATE_ROOM_FAILED = 138;
  static final int EM_SDK_EVENT_ID_CREATE_SUC = 30;
  static final int EM_SDK_EVENT_ID_CREATE_TIMEOUT = 32;
  static final int EM_SDK_EVENT_ID_DESTORY = 11;
  static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_HOWLING = 153;
  static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_NOISY = 145;
  static final int EM_SDK_EVENT_ID_ENTER_FAIL = 34;
  static final int EM_SDK_EVENT_ID_ENTER_ROOM_FAILED = 139;
  static final int EM_SDK_EVENT_ID_ENTER_SUC = 33;
  static final int EM_SDK_EVENT_ID_ENTER_TIMEOUT = 35;
  static final int EM_SDK_EVENT_ID_GET_MUL_ROOM_INFO = 9;
  static final int EM_SDK_EVENT_ID_GET_ROOM_INFO = 8;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_FAIL = 94;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_SUC = 93;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_TIMEOUT = 95;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_FAIL = 91;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_SUC = 90;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_TIMEOUT = 92;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_FREE_MODE = 107;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_MIC_ORDER_MODE = 108;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE = 109;
  static final int EM_SDK_EVENT_ID_HAS_GETTED_SHARP_CONFIG_PAYLOAD = 123;
  static final int EM_SDK_EVENT_ID_INSUFFICIENT_FUNDS = 146;
  static final int EM_SDK_EVENT_ID_KickOut_FAIL = 22;
  static final int EM_SDK_EVENT_ID_KickOut_SUC = 21;
  static final int EM_SDK_EVENT_ID_MEETINGCONTROLMODE_CHANGE = 142;
  static final int EM_SDK_EVENT_ID_MEM_AUDIO_IN = 141;
  static final int EM_SDK_EVENT_ID_MEM_AUDIO_OUT = 140;
  static final int EM_SDK_EVENT_ID_MEM_BAN_AUDIO = 74;
  static final int EM_SDK_EVENT_ID_MEM_CANCEL_BAN_AUDIO = 75;
  static final int EM_SDK_EVENT_ID_MEM_GET_OUT = 71;
  static final int EM_SDK_EVENT_ID_MEM_KICKED_OUT = 45;
  static final int EM_SDK_EVENT_ID_MEM_POS_CHANGE = 80;
  static final int EM_SDK_EVENT_ID_MEM_PPT_IN = 76;
  static final int EM_SDK_EVENT_ID_MEM_PPT_OUT = 77;
  static final int EM_SDK_EVENT_ID_MEM_SCREEN_IN = 78;
  static final int EM_SDK_EVENT_ID_MEM_SCREEN_OUT = 79;
  static final int EM_SDK_EVENT_ID_MEM_VIDEO_IN = 72;
  static final int EM_SDK_EVENT_ID_MEM_VIDEO_OUT = 73;
  static final int EM_SDK_EVENT_ID_NEW_GET_IN = 70;
  static final int EM_SDK_EVENT_ID_NEW_SPEAKING = 42;
  static final int EM_SDK_EVENT_ID_OFFLINE_RECV_INVITE = 5;
  static final int EM_SDK_EVENT_ID_OLD_STOP_SPEAKING = 43;
  static final int EM_SDK_EVENT_ID_ONLINE_NOTICE = 13;
  static final int EM_SDK_EVENT_ID_ONLY_MANAGER_CAN_GO_ON_STAGE = 102;
  static final int EM_SDK_EVENT_ID_ONLY_MANAGER_STAGER_CAN_SPEAK = 104;
  static final int EM_SDK_EVENT_ID_OTHER_TERM_ENTER = 12;
  static final int EM_SDK_EVENT_ID_PBInvite_Rsp = 20;
  static final int EM_SDK_EVENT_ID_PBInvite_Rsp_CALL_BACK = 24;
  static final int EM_SDK_EVENT_ID_PBPstnStrategy_Rsp = 23;
  static final int EM_SDK_EVENT_ID_PLAY_MEDIA_FILE = 105;
  static final int EM_SDK_EVENT_ID_PPT_UPLOAD_STATE = 110;
  static final int EM_SDK_EVENT_ID_PROTOCOL_ERR = 7;
  static final int EM_SDK_EVENT_ID_PSTN_ACCOUNT_LIMIT_REACHED = 130;
  static final int EM_SDK_EVENT_ID_PSTN_BILL = 19;
  static final int EM_SDK_EVENT_ID_PSTN_INVITEES_AUTHORITY_FORBIDDEN = 136;
  static final int EM_SDK_EVENT_ID_PSTN_INVITEES_TIMES_LIMIT_REACHED = 137;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_AUTHORITY_FORBIDDEN = 131;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_LOCATION_LIMIT = 135;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_NOT_IN_GRAY = 129;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_P2M_TIMES_LIMIT_REACHED = 134;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_P2P_TIMES_LIMIT_REACHED = 133;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_TIME_UPPER_LIMIT = 132;
  static final int EM_SDK_EVENT_ID_PSTN_INVITE_FAILED = 149;
  static final int EM_SDK_EVENT_ID_PSTN_INVITE_INSUFFICIENT_FUNDS = 147;
  static final int EM_SDK_EVENT_ID_PSTN_INVITE_INSUFFICIENT_FUNDS_ALL = 148;
  static final int EM_SDK_EVENT_ID_QUIT_FAIL = 37;
  static final int EM_SDK_EVENT_ID_QUIT_SUC = 36;
  static final int EM_SDK_EVENT_ID_QUIT_TIMEOUT = 38;
  static final int EM_SDK_EVENT_ID_RECV_INVITE = 6;
  static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PAV = 25;
  static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PSHARE = 26;
  static final int EM_SDK_EVENT_ID_RECV_MEETING_TIME = 124;
  static final int EM_SDK_EVENT_ID_RECV_NET_TRAFFIC_DATA_SIZE = 50;
  static final int EM_SDK_EVENT_ID_REQUEST_MICDATA = 150;
  static final int EM_SDK_EVENT_ID_ROOM_INFO_CHANGE = 10;
  static final int EM_SDK_EVENT_ID_SEND_EMBED_CHNNEL = 152;
  static final int EM_SDK_EVENT_ID_SEND_NET_TRAFFIC_DATA_SIZE = 51;
  static final int EM_SDK_EVENT_ID_SERVER_REFUSED = 46;
  static final int EM_SDK_EVENT_ID_SETMICBYADMIN_NOTIFY = 143;
  static final int EM_SDK_EVENT_ID_SETMICFAIL_NOTIFY = 144;
  static final int EM_SDK_EVENT_ID_SPEAK_MODE_PRESS_SPEAK = 101;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_FAIL = 97;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_SUC = 96;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_TIMEOUT = 98;
  static final int EM_SDK_EVENT_ID_STOP_PLAY_MEDIA_FILE = 106;
  static final int EM_SDK_EVENT_ID_TOTAL_NET_TRAFFIC_DATA_SIZE = 52;
  static final int EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA = 61;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_LESS = 122;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_NULL = 121;
  private static String SPDEFVALUE = "preview-size-values=320x240,640x480;";
  private static String SPKEY;
  private static String SPNAME;
  static final String TAG = "QQGAudioCtrl";
  private static String mCameraParameters;
  static QQGAudioCtrl sQQGAudioCtrl;
  private int appid;
  gin mEventHandler = null;
  long mGroupId = 0L;
  public Vector mInviteGAudioUinList = new Vector();
  public boolean mIsSwitchGroup;
  private VcSystemInfo mSysInfo;
  public VideoController mVideoController = null;
  public int pstnLevel;
  public int pstnOriginal = 3;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    SPNAME = "AV_CameraParameters";
    SPKEY = "CP";
  }
  
  public QQGAudioCtrl()
  {
    regCallbacks();
    int i = AndroidCodec.a(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.e("HWAVC", 2, "supportMediaCodec:" + i);
    }
    init_deviceinfos(BaseApplicationImpl.getContext(), i);
    Looper localLooper;
    if (this.mEventHandler == null)
    {
      localLooper = Looper.getMainLooper();
      if (localLooper == null) {
        break label126;
      }
      this.mEventHandler = new gin(this, localLooper);
    }
    for (;;)
    {
      this.mSysInfo = new VcSystemInfo();
      return;
      label126:
      localLooper = Looper.myLooper();
      if (localLooper != null) {
        this.mEventHandler = new gin(this, localLooper);
      } else {
        this.mEventHandler = null;
      }
    }
  }
  
  private ArrayList getAVInfoListFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "getAVInfoListFromByte--> buf is null");
      }
    }
    int i;
    ArrayList localArrayList;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return null;
          if (paramInt != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQGAudioCtrl", 2, "getAVInfoListFromByte--> structLen is 0");
        return null;
        i = paramArrayOfByte.length;
        if (i % paramInt == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QQGAudioCtrl", 2, "getAVInfoListFromByte--> buf len is incorrect");
      return null;
      int j = i / paramInt;
      localArrayList = new ArrayList();
      i = 0;
      if (i >= j) {
        break label179;
      }
      localObject = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, i * paramInt, localObject, 0, paramInt);
      localObject = getAVInfoFromByte((byte[])localObject, paramInt);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQGAudioCtrl", 2, "Can not get AVUserInfo...Error");
    return null;
    if ((((AVUserInfo)localObject).jdField_a_of_type_Int == 1) && (((AVUserInfo)localObject).jdField_b_of_type_Int != 3)) {}
    for (;;)
    {
      i += 1;
      break;
      localArrayList.add(localObject);
    }
    label179:
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "getAVInfoListFromByte --> length = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private ArrayList getAvPhoneUserInfoFromString(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "getAvPhoneUserInfoFromString --> info = " + paramString);
    }
    paramString = paramString.split("\\|");
    if (paramString.length % 2 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "getAvPhoneUserInfoFromString --> Length is not currect");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length / 2)
    {
      String str1 = paramString[(i * 2 + 0)];
      String str2 = paramString[(i * 2 + 1)];
      AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.accountType = 3;
      localAVPhoneUserInfo.telInfo.mobile = str2;
      localAVPhoneUserInfo.telInfo.nation = str1;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "getAvPhoneUserInfoFromString --> InfoItem = " + localAVPhoneUserInfo.toString());
      }
      localArrayList.add(localAVPhoneUserInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  public static QQGAudioCtrl getGAudioCtrlInstance()
  {
    if (sQQGAudioCtrl == null)
    {
      if (!loadGAEngine()) {
        return null;
      }
      sQQGAudioCtrl = new QQGAudioCtrl();
      mCameraParameters = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).getString(SPKEY, SPDEFVALUE);
    }
    return sQQGAudioCtrl;
  }
  
  private int getIntFromByte(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
  
  private long[] getUinListFromBuf(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong2 = null;
    long[] arrayOfLong1 = arrayOfLong2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length >= 8) {
        break label19;
      }
      arrayOfLong1 = arrayOfLong2;
    }
    label19:
    int i;
    do
    {
      return arrayOfLong1;
      i = paramArrayOfByte.length;
      arrayOfLong1 = arrayOfLong2;
    } while (i % 8 != 0);
    arrayOfLong2 = new long[i / 8];
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    for (;;)
    {
      arrayOfLong1 = arrayOfLong2;
      if (i < 8) {
        break;
      }
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 8);
      long l = getLongFromByte(arrayOfByte);
      if (l == 0L)
      {
        arrayOfLong1 = arrayOfLong2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QQGAudioCtrl", 2, "getUinListFromBuf-->get the wrong uin==0");
        return arrayOfLong2;
      }
      arrayOfLong2[(j / 8)] = l;
      j += 8;
      i -= 8;
    }
  }
  
  protected static boolean loadGAEngine()
  {
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "xplatform", 0, false);
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        UpdateAvSo.a(BaseApplicationImpl.getContext(), "qav_gaudio_engine", true);
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        localUnsatisfiedLinkError2.printStackTrace();
      }
      localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
      localUnsatisfiedLinkError1.printStackTrace();
      return false;
    }
  }
  
  /* Error */
  private String queryCameraParameters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 444	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   5: ifnull +11 -> 16
    //   8: getstatic 444	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: getstatic 241	com/tencent/av/gaudio/QQGAudioCtrl:SPDEFVALUE	Ljava/lang/String;
    //   19: astore_1
    //   20: goto -8 -> 12
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	QQGAudioCtrl
    //   11	9	1	str	String
    //   23	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	23	finally
    //   16	20	23	finally
  }
  
  protected static native void regCallbacks();
  
  public static void setCameraParameters(String paramString, boolean paramBoolean)
  {
    mCameraParameters = paramString;
    if (paramBoolean)
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).edit();
      localEditor.putString(SPKEY, paramString);
      localEditor.commit();
    }
  }
  
  protected static native void setandroidapppath(String paramString);
  
  public byte[] GetConfigInfoFromFile()
  {
    return Common.a(BaseApplicationImpl.getContext(), "VideoConfigInfo");
  }
  
  native int GetInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public String GetSharpConfigPayloadFromFile()
  {
    Object localObject = Common.a(BaseApplicationImpl.getContext(), "SharpConfigPayload");
    if (localObject != null)
    {
      String str = new String((byte[])localObject);
      int i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "GetSharpConfigPayloadFromFile multi version: " + (String)localObject + ". payload: " + str);
      }
      return str;
    }
    return "";
  }
  
  public int GetSharpConfigVersionFromFile()
  {
    int i = 0;
    Object localObject = Common.a(BaseApplicationImpl.getContext(), "SharpConfigPayload");
    if (localObject != null)
    {
      String str = new String((byte[])localObject);
      i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "GetSharpConfigPayloadFromFile multi version: " + (String)localObject + ". payload: " + str);
      }
      i = Integer.parseInt((String)localObject);
    }
    return i;
  }
  
  public native int Invite(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4);
  
  public native int Invite(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4);
  
  public native int InvitePstn(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public native int KickOutPstnUsers();
  
  public native void SetAudioDataSendByDefault(boolean paramBoolean);
  
  public native void SetAudioDataSink(boolean paramBoolean);
  
  public void SetVideoController(VideoController paramVideoController)
  {
    this.mVideoController = paramVideoController;
  }
  
  public native int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public int acceptGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramInt2 == -1) || (paramInt1 == -1) || (paramInt3 == -1)) {
      return -1;
    }
    this.mGroupId = paramLong1;
    if ((paramInt1 == 2) && (paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int i = paramArrayOfLong.length;
      paramInt4 = 0;
      while (paramInt4 < i)
      {
        if (paramArrayOfLong[paramInt4] != paramLong2) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[paramInt4]));
        }
        paramInt4 += 1;
      }
    }
    accept(paramInt1, paramLong1, paramInt2, paramInt3);
    return 0;
  }
  
  public native String getAVGQuality();
  
  public AVUserInfo getAVInfoFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = null;
    if (paramArrayOfByte == null) {}
    long l;
    int i;
    do
    {
      do
      {
        return (AVUserInfo)localObject;
      } while (paramArrayOfByte.length != paramInt);
      localObject = new byte[8];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 8);
      l = getLongFromByte((byte[])localObject);
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 8, localObject, 0, 4);
      paramInt = getIntFromByte((byte[])localObject);
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 12, localObject, 0, 4);
      i = getIntFromByte((byte[])localObject);
      paramArrayOfByte = new AVUserInfo();
      paramArrayOfByte.jdField_a_of_type_Long = l;
      paramArrayOfByte.jdField_a_of_type_Int = paramInt;
      paramArrayOfByte.jdField_b_of_type_Int = i;
      localObject = paramArrayOfByte;
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioCtrl", 2, "AVUserInfo-->Uin = " + l + " ,isPstn = " + paramInt + " ,pstnState = " + i);
    return paramArrayOfByte;
  }
  
  public String getAppId()
  {
    try
    {
      int i = this.appid;
      return String.valueOf(i);
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String getDeviceName()
  {
    return VcSystemInfo.a();
  }
  
  public native int getEncodeFrameFunctionPtrFunPtr();
  
  public int getInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "getInviteStrategy --> QQAccountNum = " + paramInt1 + " , PhoneNum = " + paramInt2);
    }
    return GetInviteStrategy(paramArrayOfLong, paramInt1, paramArrayOfString, paramInt2);
  }
  
  public long getLongFromByte(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
  
  public native int getNetLevel();
  
  public native int getNetState();
  
  public native long getNetTrafficSize(long paramLong);
  
  public String getRELEASEVERSION()
  {
    return Build.VERSION.RELEASE;
  }
  
  public native int getVideoAbilityLevel();
  
  public native int getVolume();
  
  public native int ignore(int paramInt1, long paramLong, int paramInt2);
  
  public native void init(Context paramContext, long paramLong, int paramInt);
  
  public void init_deviceinfos(Context paramContext, int paramInt)
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
    paramContext = paramContext.getApplicationInfo();
    str = str + "DATADIR=" + paramContext.dataDir + ";";
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";
      if (paramInt <= 0) {
        break label775;
      }
      if ((paramInt & 0x1) != 1) {
        break label727;
      }
      paramContext = paramContext + "HWAVCDEC=1;";
      label592:
      if ((paramInt & 0x2) != 2) {
        break label751;
      }
      paramContext = paramContext + "HWAVCENC=1;";
      label620:
      if (VcSystemInfo.d()) {
        break label820;
      }
      paramContext = paramContext + "SHARP_VIDEO=0;";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "init_deviceinfos --> PhoneInfo = " + paramContext);
      }
      setandroidapppath(paramContext);
      return;
      paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib" + ";";
      break;
      label727:
      paramContext = paramContext + "HWAVCDEC=0;";
      break label592;
      label751:
      paramContext = paramContext + "HWAVCENC=0;";
      break label620;
      label775:
      paramContext = paramContext + "HWAVCENC=0;";
      paramContext = paramContext + "HWAVCDEC=0;";
      break label620;
      label820:
      if (VcSystemInfo.f() > 2) {
        paramContext = paramContext + "SHARP_VIDEO=1;";
      } else {
        paramContext = paramContext + "SHARP_VIDEO=2;";
      }
    }
  }
  
  protected native int invite(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3);
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "inviteUser --> uinList = " + paramArrayOfLong + " ,nReason = " + paramInt1 + " ,original = " + paramInt2 + " ,pstnLevel = " + paramInt3);
    }
    return invite(paramArrayOfLong, paramInt1, paramInt2, paramInt3);
  }
  
  public native int modifyGroupAdmin(long paramLong, boolean paramBoolean);
  
  public void onGAudioNativeEvent(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, long paramLong2)
  {
    if (this.mEventHandler != null)
    {
      localgio = new gio(this);
      localgio.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      localgio.jdField_a_of_type_Long = paramLong2;
      localgio.jdField_b_of_type_Long = paramLong1;
      localgio.c = paramInt2;
      localgio.jdField_a_of_type_Int = paramInt3;
      localgio.jdField_b_of_type_Int = paramInt4;
      if (paramArrayOfByte == null)
      {
        paramInt2 = 0;
        localgio.e = paramInt2;
        paramArrayOfByte = this.mEventHandler.obtainMessage();
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.what = paramInt1;
          paramArrayOfByte.obj = localgio;
          this.mEventHandler.sendMessage(paramArrayOfByte);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        gio localgio;
        return;
        paramInt2 = paramArrayOfByte.length;
      }
    }
    QLog.d("QQGAudioCtrl", 2, "mEventHandler == null");
  }
  
  public void onRecvDoubleVideoMeeting(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvDoubleVideoMeeting-->mVideoController is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "onRecvDoubleVideoMeeting-->eventId=" + paramInt1 + " ,relationType=" + paramInt2 + " ,inviteUin=" + paramLong);
      }
      if (paramInt1 == 6)
      {
        this.mVideoController.b(paramLong);
        return;
      }
    } while ((paramInt1 == 44) || (paramInt1 != 5));
  }
  
  public native int onRecvGAudioCMD(int paramInt, byte[] paramArrayOfByte);
  
  public void onRecvUserList(int paramInt1, int paramInt2, long paramLong1, ArrayList paramArrayList, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvUserList --> mVideoController is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "onRecvUserList-->EvtId =" + paramInt1 + " ,relationType = " + paramInt2 + " ,relationId = " + paramLong1 + " ,inviteUin = " + paramLong2 + " ,multiSubType = " + paramInt3 + " ,inviteUinSize = " + paramArrayList.size());
      }
      if (paramInt1 == 44)
      {
        this.mVideoController.a(paramLong1, paramArrayList, paramInt4, paramInt5);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQGAudioCtrl", 2, "onRecvUserList --> WRONG EVTID. evtId = " + paramInt1);
  }
  
  public void onRecvUserList(int paramInt1, int paramInt2, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvUserList-->mVideoController is null");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramArrayOfLong != null) || (paramInt2 != 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QQGAudioCtrl", 2, "onRecvUserList-->userList is null");
      return;
      int i = 0;
      if (paramArrayOfLong != null) {
        i = paramArrayOfLong.length;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "onRecvUserList-->EvtId=" + paramInt1 + " relationType" + paramInt2 + " relationId" + paramLong1 + " inviteUin=" + paramLong2 + " multiAVType=" + paramInt3 + " multiSubType=" + paramInt4 + " inviteUinSize=" + i);
      }
      if (paramInt1 == 44)
      {
        this.mVideoController.a(paramLong1, paramArrayOfLong, paramInt3, paramInt5);
        return;
      }
      if (paramInt1 == 6)
      {
        this.mVideoController.a(paramInt2, paramLong1, paramLong2, paramArrayOfLong, false, paramInt3, paramInt4, null);
        return;
      }
    } while (paramInt1 != 5);
    this.mVideoController.a(paramInt2, paramLong1, paramLong2, paramArrayOfLong, true, paramInt3, paramInt4, null);
  }
  
  public native int quit(int paramInt);
  
  public native int request(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public native int requestCamera(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public native int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public void sendGAudioCMD(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.mVideoController.a(paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public void sendMeetingMessage(MeetingInfo paramMeetingInfo)
  {
    if (this.mEventHandler != null)
    {
      gio localgio = new gio(this);
      localgio.jdField_a_of_type_JavaLangObject = paramMeetingInfo;
      paramMeetingInfo = this.mEventHandler.obtainMessage();
      if (paramMeetingInfo != null)
      {
        paramMeetingInfo.what = 124;
        paramMeetingInfo.obj = localgio;
        this.mEventHandler.sendMessage(paramMeetingInfo);
      }
    }
  }
  
  public native void sendTransferMsg(long[] paramArrayOfLong, byte[] paramArrayOfByte);
  
  public native int setApType(int paramInt);
  
  public void setAppid(int paramInt)
  {
    this.appid = paramInt;
  }
  
  public native boolean setAudioNoiseCtrlParam(int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAudioOutputMode(int paramInt);
  
  public native int setHowlingDetectEnable(boolean paramBoolean);
  
  public void setInviteUserList(long paramLong, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] != paramLong) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[i]));
        }
        i += 1;
      }
    }
  }
  
  public native boolean setMicByAdmin(long paramLong, boolean paramBoolean);
  
  public native boolean setMicMode(int paramInt);
  
  public native int setNetIPAndPort(String paramString, int paramInt);
  
  public native void setProcessDecoderFrameFunctionptr(int paramInt);
  
  public void setPstnInviteInfo(int paramInt1, int paramInt2)
  {
    this.pstnOriginal = paramInt1;
    this.pstnLevel = paramInt2;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "setPstnInviteInfo --> Original = " + paramInt1 + " , pstnLevel = " + paramInt2);
    }
  }
  
  public native void setVideoJitterLength(int paramInt);
  
  public native int startAudioRecv();
  
  public native int startAudioSend();
  
  public int startGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2, boolean paramBoolean)
  {
    if (paramInt1 == 2)
    {
      if (paramArrayOfLong == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioCtrl", 2, "startGAudio uinList == null");
        }
        return -1;
      }
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int i = paramArrayOfLong.length;
      paramInt4 = 0;
      while (paramInt4 < i)
      {
        if (paramArrayOfLong[paramInt4] != paramLong2) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[paramInt4]));
        }
        paramInt4 += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "startGAudio emAVRelationType=" + paramInt1 + " groupId=" + paramLong1 + " emMultiAVType=" + paramInt2 + " emMultiAVSubType=" + paramInt3);
    }
    request(paramInt1, paramLong1, paramInt2, paramInt3);
    this.mGroupId = paramLong1;
    this.mIsSwitchGroup = paramBoolean;
    return 0;
  }
  
  public int startVideoRecv(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return 0;
    }
    int j = paramArrayList.size() * 3;
    long[] arrayOfLong = new long[j];
    String str = new String();
    int i = 0;
    if (i < paramArrayList.size())
    {
      arrayOfLong[(i * 3)] = ((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Long;
      str = str + "uin=" + arrayOfLong[(i * 3)] + " ,";
      arrayOfLong[(i * 3 + 1)] = ((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Int;
      str = str + "videoSrcType=" + arrayOfLong[(i * 3 + 1)] + " ,";
      if (((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Boolean) {
        arrayOfLong[(i * 3 + 2)] = 1L;
      }
      for (;;)
      {
        str = str + "isBig=" + arrayOfLong[(i * 3 + 2)] + " ,";
        i += 1;
        break;
        arrayOfLong[(i * 3 + 2)] = 0L;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "startVideoRecv-->info=" + str);
    }
    return startVideoRecv(arrayOfLong, j);
  }
  
  public native int startVideoRecv(long[] paramArrayOfLong, int paramInt);
  
  public native int startVideoSend();
  
  public native int stopAudioRecv();
  
  public native int stopAudioSend();
  
  public native int stopVideoRecv();
  
  public native int stopVideoSend();
  
  public native int switchToAudioMode();
  
  public native void uninit();
  
  public native int updateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gaudio\QQGAudioCtrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */