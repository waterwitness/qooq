package com.tencent.device.devicemgr;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.device.qfind.QFindConfig;
import com.tencent.device.qfind.QFindConfigUtil;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.troop.data.TroopCreateUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import jwj;
import jwk;
import jwl;
import jwm;
import jwn;
import jwo;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.DpNotifyMsgBdoy;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.Head;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.NotifyItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.OccupyMicrophoneNotifyMsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.PushBody;

public class SmartDeviceProxyMgr
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "QFind";
  public static final int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "SmartDeviceProxyMgr";
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public static final int l = 1;
  public static final int m = 2154;
  public static final int n = 2108;
  public static final int o = 2201;
  public static final int p = 2251;
  private static final int t = 300000;
  private static final int u = 30000;
  private static final int v = 1001;
  private static final int w = 1002;
  private static final int x = 1003;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QFindBLEScanMgr jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
  private SmartDeviceIPCHost jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
  public ArrayList a;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  jwo jdField_a_of_type_Jwo;
  private boolean jdField_a_of_type_Boolean;
  DeviceInfo[] jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  public int g;
  public int k;
  int q;
  int r;
  private int s;
  
  public SmartDeviceProxyMgr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.s = 0;
    this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Jwo = null;
    this.g = 0;
    this.k = 0;
    this.q = 0;
    this.r = 0;
    try
    {
      Object localObject = ThreadManager.a("smartdevice_check_thread", 0);
      ((HandlerThread)localObject).start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(((HandlerThread)localObject).getLooper(), new jwj(this));
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new jwn(this, ThreadManager.b());
      b("SmartDeviceProxyMgr create");
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.s = SettingCloneUtil.readValueForInt(BaseApplication.getContext(), paramQQAppInterface.a(), null, "qqsetting_deviceplugin_bind_flag", 0);
        this.jdField_a_of_type_Jwo = new jwo(this);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("SmartDevice_devListChang");
        ((IntentFilter)localObject).addAction("onDeviceDisconnected");
        ((IntentFilter)localObject).addAction("onDeviceLogined");
        ((IntentFilter)localObject).addAction("SmartDevice_login");
        ((IntentFilter)localObject).addAction("SmartDevice_clickOnDeviceList");
        ((IntentFilter)localObject).addAction("onQFindLostDeviceList");
        ((IntentFilter)localObject).addAction("SmartDevice_devListChangeUI");
        ((IntentFilter)localObject).addAction("SmartDevice_DeviceBindRst");
        ((IntentFilter)localObject).addAction("mqq.intent.action.LOGOUT");
        ((IntentFilter)localObject).addAction("mqq.intent.action.ACCOUNT_CHANGED");
        ((IntentFilter)localObject).addAction("SmartDevice_receiveDPMsg");
        BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Jwo, (IntentFilter)localObject);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 300000L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 30000L);
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BDHCommonUploadProcessor.class });
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.a();
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        this.jdField_a_of_type_AndroidOsHandler.post(new jwk(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private QFindConfig a()
  {
    Object localObject = BaseApplicationImpl.a().getFilesDir() + "/qfindconfig";
    try
    {
      localObject = FileUtils.a(new File((String)localObject));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = QFindConfigUtil.a((String)localObject);
        return (QFindConfig)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    a(null);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "login");
    localBundle.putInt("iAppID", paramInt);
    localBundle.putLong("uin", paramLong);
    localBundle.putByteArray("a2", paramArrayOfByte);
    localBundle.putBoolean("forceStart", true);
    if (paramString1 != null) {
      localBundle.putString("strOpenId", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("strAccessToken", paramString2);
    }
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  private void a(String paramString1, String paramString2, Boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(131072);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("bFromLightApp", paramBoolean);
    localIntent.putExtra("uintype", 9501);
    localIntent.putExtra("operType", paramInt1);
    localIntent.putExtra("jumpTab", paramInt2);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().startActivity(localIntent);
  }
  
  private void a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = paramArrayOfDeviceInfo;
      return;
    }
    finally
    {
      paramArrayOfDeviceInfo = finally;
      throw paramArrayOfDeviceInfo;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SmartDeviceProxyMgr", 2, paramString);
    }
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 406	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_a_of_type_Boolean	Z
    //   9: ifne +81 -> 90
    //   12: aload_0
    //   13: ldc_w 408
    //   16: invokespecial 139	com/tencent/device/devicemgr/SmartDeviceProxyMgr:b	(Ljava/lang/String;)V
    //   19: invokestatic 414	java/lang/System:currentTimeMillis	()J
    //   22: lstore_2
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 406	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_a_of_type_Boolean	Z
    //   28: aload_0
    //   29: new 334	cooperation/smartdevice/ipc/SmartDeviceIPCHost
    //   32: dup
    //   33: aload_0
    //   34: getfield 348	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokespecial 415	cooperation/smartdevice/ipc/SmartDeviceIPCHost:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   40: putfield 286	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost	Lcooperation/smartdevice/ipc/SmartDeviceIPCHost;
    //   43: aload_0
    //   44: getfield 348	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   47: bipush 49
    //   49: invokevirtual 418	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   52: pop
    //   53: invokestatic 414	java/lang/System:currentTimeMillis	()J
    //   56: lstore 4
    //   58: aload_0
    //   59: new 240	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 420
    //   69: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload 4
    //   74: lload_2
    //   75: lsub
    //   76: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 139	com/tencent/device/devicemgr/SmartDeviceProxyMgr:b	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: monitorexit
    //   87: iload 6
    //   89: ireturn
    //   90: iconst_0
    //   91: istore 6
    //   93: goto -8 -> 85
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	SmartDeviceProxyMgr
    //   96	4	1	localObject	Object
    //   22	53	2	l1	long
    //   56	17	4	l2	long
    //   1	91	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	85	96	finally
  }
  
  private DeviceInfo[] c()
  {
    try
    {
      DeviceInfo[] arrayOfDeviceInfo = this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo;
      return arrayOfDeviceInfo;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int a(long paramLong)
  {
    int i2 = 8;
    int i3 = 0;
    Object localObject = a(paramLong);
    int i1 = i3;
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
      i1 = i3;
      if (localObject != null) {
        if (!((ProductInfo)localObject).isSupportMainMsgType(8)) {
          break label103;
        }
      }
    }
    for (;;)
    {
      i1 = i2;
      if (((ProductInfo)localObject).isSupportMainMsgType(2)) {
        i1 = i2 | 0x1;
      }
      i2 = i1;
      if (((ProductInfo)localObject).isSupportFuncMsgType(1)) {
        i2 = i1 | 0x4;
      }
      if (((ProductInfo)localObject).isSupportFuncMsgType(2))
      {
        i1 = i2 | 0x2;
        return i1;
      }
      return i2;
      label103:
      i2 = 0;
    }
  }
  
  public int a(long paramLong, String paramString, int paramInt)
  {
    b("SmartDeviceProxyMgr::sendAudioMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "sendAudioMsg");
        localBundle.putString("filepath", paramString);
        localBundle.putInt("duration", paramInt);
        localBundle.putLong("din", paramLong);
      } while (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null);
      paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while (paramString == null);
    return paramString.getInt("cookie");
  }
  
  public int a(long paramLong1, String paramString1, long paramLong2, int paramInt, String paramString2)
  {
    b("SmartDeviceProxyMgr::sendVideoMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "sendVideoMsg");
        localBundle.putString("filepath", paramString1);
        localBundle.putString("thumbPath", paramString2);
        localBundle.putLong("din", paramLong1);
        localBundle.putLong("filesize", paramLong2);
        localBundle.putInt("duration", paramInt);
      } while (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null);
      paramString1 = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while (paramString1 == null);
    return paramString1.getInt("cookie");
  }
  
  public int a(long paramLong, String paramString1, String paramString2)
  {
    b("SmartDeviceProxyMgr::sendImageMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "sendImageMsg");
        localBundle.putString("filepath", paramString1);
        localBundle.putString("thumbPath", paramString2);
        localBundle.putLong("din", paramLong);
      } while (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null);
      paramString1 = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while (paramString1 == null);
    return paramString1.getInt("cookie");
  }
  
  public long a()
  {
    b("SmartDeviceProxyMgr::getSelfUin");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return 0L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getselfuin");
    localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    if (localBundle != null) {}
    for (long l1 = localBundle.getLong("selfuin", 0L);; l1 = 0L)
    {
      if (l1 != 0L) {
        this.jdField_a_of_type_Long = l1;
      }
      return this.jdField_a_of_type_Long;
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    b("SmartDeviceProxyMgr::uploadMiniFile");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0L;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "uploadMiniFile");
        localBundle.putString("filepath", paramString);
        localBundle.putInt("filetype", paramInt);
      } while (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null);
      paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while (paramString == null);
    return paramString.getLong("cookie");
  }
  
  public long a(String paramString1, String paramString2, int paramInt)
  {
    b("SmartDeviceProxyMgr::downloadMiniFile");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0L;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "downloadMiniFile");
        localBundle.putString("filekey", paramString1);
        localBundle.putInt("filetype", paramInt);
        localBundle.putString("fileKey2", paramString2);
      } while (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null);
      paramString1 = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while (paramString1 == null);
    return paramString1.getLong("cookie");
  }
  
  public DeviceInfo a(long paramLong)
  {
    int i1 = 0;
    b("SmartDeviceProxyMgr::getDeviceInfoByDin");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return new DeviceInfo();
    }
    Object localObject = c();
    if (localObject != null) {
      while (i1 < localObject.length)
      {
        if (paramLong == localObject[i1].din) {
          return localObject[i1];
        }
        i1 += 1;
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getinfobydin");
    ((Bundle)localObject).putLong("din", paramLong);
    localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
    if (localObject == null) {
      return new DeviceInfo();
    }
    return (DeviceInfo)((Bundle)localObject).getParcelable("deviceinfo");
  }
  
  public DeviceInfo a(String paramString, int paramInt)
  {
    int i1 = 0;
    b("SmartDeviceProxyMgr::getDeviceInfoBySerialNum");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return null;
    }
    Object localObject = c();
    if (localObject != null) {
      while (i1 < localObject.length)
      {
        if ((paramString.compareToIgnoreCase(localObject[i1].serialNum) == 0) && (paramInt == localObject[i1].productId)) {
          return localObject[i1];
        }
        i1 += 1;
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getDeviceInfoBySerialNum");
    ((Bundle)localObject).putString("serialNum", paramString);
    ((Bundle)localObject).putInt("pid", paramInt);
    paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
    if (paramString == null) {
      return null;
    }
    return (DeviceInfo)paramString.getParcelable("deviceinfo");
  }
  
  public ProductInfo a(int paramInt)
  {
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    do
    {
      return null;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        return (ProductInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("notify_cmd", "getProductInfo");
      ((Bundle)localObject).putInt("productId", paramInt);
      localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
    } while (localObject == null);
    Object localObject = (ProductInfo)((Bundle)localObject).getParcelable("productInfo");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
    return (ProductInfo)localObject;
  }
  
  public Boolean a(long paramLong)
  {
    b("SmartDeviceProxyMgr::isVasFlagEnable");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return Boolean.valueOf(false);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "isVasFlagEnable");
    localBundle.putInt("bitIndex", 0);
    localBundle.putLong("din", paramLong);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null)
    {
      localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
      if (localBundle != null) {
        return Boolean.valueOf(localBundle.getBoolean("isVasFlagEnable"));
      }
    }
    return Boolean.valueOf(false);
  }
  
  protected Class a()
  {
    return SmartDeviceObserver.class;
  }
  
  public String a()
  {
    TicketManager localTicketManager = (TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getA2(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    return "";
  }
  
  public ArrayList a()
  {
    b("SmartDeviceProxyMgr::getLiteAppSettingList");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    Bundle localBundle;
    do
    {
      return null;
      localBundle = new Bundle();
      localBundle.putString("notify_cmd", "getLiteAppSettingList");
      localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while (localBundle == null);
    return localBundle.getParcelableArrayList("settinglist");
  }
  
  public void a()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18) {
      localObject = BaseApplication.getContext();
    }
    try
    {
      bool1 = ((Context)localObject).getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      if (bool1)
      {
        String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((str != null) && (!"".equals(str))) {}
      }
      else
      {
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      SharedPreferences localSharedPreferences;
      do
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
          bool1 = false;
        }
        localSharedPreferences = ((Context)localObject).getSharedPreferences("mobileQQ", 4);
      } while ((!localSharedPreferences.getBoolean("qfind_report_gps_bt_stat" + localThrowable2, false)) || (localSharedPreferences.getBoolean("qfind_ble_gps_reported" + localThrowable2, false)));
      localSharedPreferences.edit().putBoolean("qfind_ble_gps_reported" + localThrowable2, true).commit();
    }
    for (;;)
    {
      try
      {
        localBluetoothAdapter = ((BluetoothManager)((Context)localObject).getSystemService("bluetooth")).getAdapter();
        if (localBluetoothAdapter != null) {
          continue;
        }
        i1 = 0;
        SmartDeviceReport.a(null, "QFind_BleState", i1, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.i("QFind", 2, "QFind_BleState bleResult=" + i1);
        }
      }
      catch (Throwable localThrowable3)
      {
        BluetoothAdapter localBluetoothAdapter;
        boolean bool2;
        localThrowable3.printStackTrace();
        continue;
        if (!bool1) {
          continue;
        }
        int i1 = 2;
        continue;
        if (!bool2) {
          continue;
        }
        i1 = 3;
        continue;
        i1 = 0;
        continue;
      }
      try
      {
        localObject = (LocationManager)((Context)localObject).getSystemService("location");
        bool1 = ((LocationManager)localObject).isProviderEnabled("gps");
        bool2 = ((LocationManager)localObject).isProviderEnabled("network");
        if ((!bool1) || (!bool2)) {
          continue;
        }
        i1 = 1;
        SmartDeviceReport.a(null, "QFind_GPSState", i1, 0, 0);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QFind", 2, "QFind_GPSState gps=" + bool1 + ", 2g network=" + bool2 + ", gpsResult=" + i1);
        return;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        return;
      }
      bool1 = localBluetoothAdapter.isEnabled();
      if (!bool1) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  public void a(int paramInt)
  {
    b("SmartDeviceProxyMgr::setHasBindDeviceFlag : " + paramInt);
    this.s = paramInt;
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_deviceplugin_bind_flag", this.s);
    a(false);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(false);
    if (paramInt == 39) {}
    label11:
    int i1;
    long l1;
    do
    {
      do
      {
        do
        {
          break label11;
          do
          {
            return;
          } while (paramInt != 111);
          paramInt = paramBundle.getInt("msgtype", 0);
          i1 = paramBundle.getInt("devtime", 0);
          l1 = paramBundle.getLong("din", 0L);
          if (QLog.isColorLevel()) {
            QLog.d("QFind", 2, "PushLostDevFound msgtype[" + paramInt + "], devtime=[" + i1 + "], din[" + l1 + "].");
          }
          a(false);
          paramBundle = new Bundle();
          paramBundle.putString("notify_cmd", "updateLostStatus");
          if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
            this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(paramBundle);
          }
        } while (paramInt == 2);
        if (paramInt == 6)
        {
          a(l1, i1, "孩子找到了，点击查看位置!");
          return;
        }
      } while (paramInt == 7);
      if (paramInt == 8)
      {
        a(l1, i1, "审核通过，请关注最新的位置推送!");
        return;
      }
    } while (paramInt != 9);
    a(l1, i1, "审核未通过，请核对信息!");
  }
  
  public void a(int paramInt, String paramString)
  {
    b("SmartDeviceProxyMgr::queryIsDeviceHasBeenBinded");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "queryIsDeviceHasBeenBinded");
    localBundle.putInt("productId", paramInt);
    localBundle.putString("serialNum", paramString);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(long paramLong, int paramInt)
  {
    b("SmartDeviceProxyMgr::sendToDealTipCmd");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendDealTipCmd");
    localBundle.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localBundle.putLong("din", paramLong);
    localBundle.putInt("productId", paramInt);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    b("SmartDeviceProxyMgr::setDeviceVasFlag");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = new Bundle();
      localBundle.putString("notify_cmd", "setDeviceVasFlag");
      localBundle.putInt("bitCount", paramInt2);
      localBundle.putInt("beginIndex", paramInt1);
      localBundle.putInt("bitValue", paramInt3);
      localBundle.putLong("din", paramLong);
    } while (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    b("onReceive Push Msg : " + paramString);
    b();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "notifyCmdReceivePush");
    localBundle.putLong("fromUin", paramLong1);
    localBundle.putLong("toUin", paramLong2);
    localBundle.putInt("msgSeq", paramInt1);
    localBundle.putLong("msgUid", paramLong3);
    localBundle.putInt("msgType", paramInt2);
    localBundle.putBoolean("forceStart", true);
    if (paramString != null) {
      localBundle.putString("sServiceCmd", paramString);
    }
    if (paramArrayOfByte != null) {
      localBundle.putByteArray("buffer", paramArrayOfByte);
    }
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString) {}
  
  public void a(long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    b("SmartDeviceProxyMgr::sendStructingShareMsg");
    a(false);
    DataPoint localDataPoint;
    AbsShareMsg localAbsShareMsg;
    if ((paramAbsStructMsg != null) && ((paramAbsStructMsg instanceof AbsShareMsg)))
    {
      localDataPoint = new DataPoint();
      localAbsShareMsg = (AbsShareMsg)paramAbsStructMsg;
      if (paramAbsStructMsg.mMsgServiceID != 2) {
        break label418;
      }
      localDataPoint.mProperityId = 11003;
    }
    for (;;)
    {
      localDataPoint.mApiName = "set_data_point";
      localDataPoint.mDin = paramLong;
      try
      {
        localDataPoint.mValue = new JSONObject().put("msg_time", (int)MessageCache.a()).put("senderDin", paramLong).put("msgUrl", localAbsShareMsg.mMsgUrl).put("contentSrc", localAbsShareMsg.mContentSrc).put("contentCover", localAbsShareMsg.mContentCover).put("contentTitle", localAbsShareMsg.mContentTitle).put("contentSummary", localAbsShareMsg.mContentSummary).put("msgAction", localAbsShareMsg.mMsgAction).put("msgActionData", localAbsShareMsg.mMsgActionData).put("msg_A_ActionData", localAbsShareMsg.mMsg_A_ActionData).put("msg_I_ActionData", localAbsShareMsg.mMsg_I_ActionData).put("sourceAppid", localAbsShareMsg.mSourceAppid).put("sourceUrl", localAbsShareMsg.mSourceUrl).put("sourceAction", localAbsShareMsg.mSourceAction).put("sourceActionData", localAbsShareMsg.mSourceActionData).put("source_A_ActionData", localAbsShareMsg.mSource_A_ActionData).put("source_I_ActionData", localAbsShareMsg.mSource_I_ActionData).put("sourceIcon", localAbsShareMsg.mSourceIcon).put("sourceName", localAbsShareMsg.mSourceName).put("msgBrief", localAbsShareMsg.mMsgBrief).put("fileName", localAbsShareMsg.mFileName).put("fileSize", localAbsShareMsg.mFileSize).put("compatibleText", localAbsShareMsg.mCompatibleText).toString();
        localDataPoint.mValueType = "string";
        paramAbsStructMsg = new Bundle();
        paramAbsStructMsg.putParcelable("datapoint", localDataPoint);
        paramAbsStructMsg.putLong("din", paramLong);
        paramAbsStructMsg.putString("notify_cmd", "sendStructMsg");
        b("SmartDeviceProxyMgr::sendStructingShareMsg dataPoint.mValue = " + localDataPoint.mValue);
        if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
          this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(paramAbsStructMsg);
        }
        return;
        label418:
        if (paramAbsStructMsg.mMsgServiceID == 32)
        {
          localDataPoint.mProperityId = 32;
          continue;
        }
        if (paramAbsStructMsg.mMsgServiceID != 1) {
          continue;
        }
        localDataPoint.mProperityId = 11005;
      }
      catch (JSONException paramAbsStructMsg)
      {
        for (;;)
        {
          paramAbsStructMsg.printStackTrace();
        }
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    b("SmartDeviceProxyMgr::sendCloudPrintCmd");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCloudPrintCmd");
    localBundle.putLong("din", paramLong);
    localBundle.putString("fileIndex", paramString1);
    localBundle.putString("jobId", paramString2);
    localBundle.putString("fileName", paramString3);
    localBundle.putInt("fileType", paramInt1);
    localBundle.putInt("copies", paramInt2);
    localBundle.putInt("duplexMode", paramInt3);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(Activity paramActivity, DeviceInfo paramDeviceInfo, boolean paramBoolean)
  {
    a(paramActivity, paramDeviceInfo, paramBoolean, null);
  }
  
  public void a(Activity paramActivity, DeviceInfo paramDeviceInfo, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPerf", 2, "liteAppEntry:" + System.currentTimeMillis());
    }
    a(false);
    if (paramDeviceInfo == null)
    {
      ToastUtil.a().a("设备信息为空");
      return;
    }
    paramDeviceInfo.displayName = SmartDeviceUtil.a(paramDeviceInfo);
    new LightAppUtil(paramActivity).a(paramDeviceInfo, paramBundle, paramBoolean);
  }
  
  public void a(Bundle paramBundle)
  {
    b("SmartDeviceProxyMgr::InvokeOpenChatMsgActivity");
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBundle == null))
    {
      b("in SmartDeviceProxyMgr InvokeOpenChatMsgActivity app is null or params is null");
      return;
    }
    String str1 = paramBundle.getString("din");
    String str2 = paramBundle.getString("devName");
    Boolean localBoolean = Boolean.valueOf(paramBundle.getBoolean("bFromLightApp", false));
    int i1 = paramBundle.getInt("operType");
    int i2 = paramBundle.getInt("jumpTab");
    paramBundle = Looper.getMainLooper();
    if (Thread.currentThread() != paramBundle.getThread())
    {
      new Handler(paramBundle).post(new jwm(this, str1, str2, localBoolean, i1, i2));
      return;
    }
    a(str1, str2, localBoolean, i1, i2);
  }
  
  public void a(DataPoint paramDataPoint, int paramInt1, int paramInt2, int paramInt3)
  {
    b("SmartDeviceProxyMgr::sendCSDataPointMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCSDataPointMsg");
    localBundle.putParcelable("datapoint", paramDataPoint);
    localBundle.putInt("cookie", paramInt1);
    localBundle.putLong("msgtype", paramInt2);
    localBundle.putLong("msgSubType", paramInt3);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(DataPoint paramDataPoint, int paramInt1, long paramLong, int paramInt2)
  {
    b("SmartDeviceProxyMgr::sendCCDataPointMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCCDataPointMsg");
    localBundle.putParcelable("datapoint", paramDataPoint);
    localBundle.putInt("cookie", paramInt1);
    localBundle.putLong("din", paramLong);
    localBundle.putInt("lifetime", paramInt2);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    ThreadManager.b().post(new jwl(this, paramConfig));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && ("QFindSvc.ReqReportDevs".equals(paramToServiceMsg.getServiceCmd()))) {
      if (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr != null) {
        this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    Bundle localBundle;
    do
    {
      return;
      b("onReceive Ack Msg");
      b();
      localBundle = new Bundle();
      localBundle.putString("notify_cmd", "notifyCmdReceiveData");
      if (paramToServiceMsg != null) {
        localBundle.putParcelable("req", paramToServiceMsg);
      }
      if (paramFromServiceMsg != null) {
        localBundle.putParcelable("res", paramFromServiceMsg);
      }
      if (paramObject != null) {
        localBundle.putByteArray("data", (byte[])paramObject);
      }
      localBundle.putBoolean("forceStart", true);
    } while (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    b("SmartDeviceProxyMgr::unBind");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "unBind");
    if (paramString != null) {
      localBundle.putString("gUID", paramString);
    }
    localBundle.putInt("pid", paramInt);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    b("SmartDeviceProxyMgr::setRemark");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "setRemark");
    if (paramString1 != null) {
      localBundle.putString("serialNum", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("str", paramString2);
    }
    localBundle.putInt("pid", paramInt);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    b("SmartDeviceProxyMgr::bindCloudDevice");
    a(false);
    paramString3 = new Bundle();
    paramString3.putString("notify_cmd", "bindCloudDevice");
    paramString3.putString("serialNum", paramString1);
    paramString3.putInt("productId", paramInt);
    paramString3.putString("licenseMD5", paramString2);
    paramString3.putString("qqVer", DeviceInfoUtil.a(BaseApplication.getContext()));
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(paramString3);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    b("SmartDeviceProxyMgr::sendTextMsg");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendTextMsg");
    localBundle.putLong("din", paramLong1);
    localBundle.putString("text", paramString);
    localBundle.putLong("msg_time", paramLong2);
    localBundle.putLong("msgSeq", paramLong3);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    String str = BaseApplicationImpl.a().getFilesDir() + "/qfindpidlist";
    if (paramBoolean) {
      FileUtils.d(str);
    }
    try
    {
      for (;;)
      {
        paramString = FileUtils.a(new File(str));
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = new JSONObject(paramString).getJSONArray("pidlist");
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        int i1 = 0;
        while (i1 < paramString.length())
        {
          long l1 = paramString.getLong(i1);
          this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(l1));
          i1 += 1;
        }
        if (paramString != null) {
          FileUtils.a(str, paramString);
        }
      }
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label266;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    paramString = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((str == null) || ("".equals(str))) {}
    for (;;)
    {
      return;
      paramString = paramString.getString("qfind_assist" + str, "0");
      if (!TextUtils.isEmpty(paramString)) {}
      try
      {
        this.r = Integer.parseInt(paramString);
        if ((this.r + this.q > 1) && (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr != null))
        {
          paramString = a();
          if (paramString != null) {
            this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a(this.jdField_b_of_type_JavaUtilArrayList, paramString);
          }
        }
        label266:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("QFind", 2, "qfind pid count=" + this.jdField_b_of_type_JavaUtilArrayList.size());
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          this.r = 0;
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    b("SmartDeviceProxyMgr::transferAppSettingList");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "transferLiteAppSettingList");
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localBundle.putParcelableArrayList("settinglist", paramArrayList);
    }
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("SmartDeviceProxyMgr", 2, "startPlugin flag:" + this.s + " ipc:" + this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost);
    if (this.s != 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("SmartDeviceProxyMgr::startPlugin, forceRefresh: ");
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      b(str);
      if (!b()) {
        break;
      }
      b(paramBoolean);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SubMsgType0x90.MsgBody();
    try
    {
      ((SubMsgType0x90.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      switch (((SubMsgType0x90.MsgBody)localObject).msg_head.uint32_cmd.get())
      {
      default: 
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      b("onRecvPush0x210_0x90, parse error");
      return;
    }
    paramArrayOfByte = ((SubMsgType0x90.MsgBody)localObject).msg_body.msg_dp_notify_body;
    localObject = new Intent();
    ((Intent)localObject).setAction("On_DpNotify_Push");
    ((Intent)localObject).putExtra("productid", paramArrayOfByte.uint32_pid.get());
    ((Intent)localObject).putExtra("din", paramArrayOfByte.uint64_din.get());
    ((Intent)localObject).putExtra("extras", paramArrayOfByte.string_extend_info.get());
    int[] arrayOfInt = new int[paramArrayOfByte.rpt_msg_notify_info.size()];
    int i1 = 0;
    while (i1 < paramArrayOfByte.rpt_msg_notify_info.size())
    {
      arrayOfInt[i1] = ((SubMsgType0x90.NotifyItem)paramArrayOfByte.rpt_msg_notify_info.get(i1)).uint32_propertyid.get();
      i1 += 1;
    }
    ((Intent)localObject).putExtra("pids", arrayOfInt);
    BaseApplicationImpl.a().sendBroadcast((Intent)localObject, "com.tencent.smartdevice.permission.broadcast");
    return;
    paramArrayOfByte = ((SubMsgType0x90.MsgBody)localObject).msg_body.msg_occupy_microphone_body;
    localObject = new Intent();
    ((Intent)localObject).setAction("On_OccupyMicrophoneNotify_Push");
    ((Intent)localObject).putExtra("din", paramArrayOfByte.uint64_din.get());
    ((Intent)localObject).putExtra("uin", TroopCreateUtils.a(paramArrayOfByte.uint32_uin.get()));
    BaseApplicationImpl.a().sendBroadcast((Intent)localObject, "com.tencent.smartdevice.permission.broadcast");
  }
  
  public boolean a()
  {
    return this.s == 1;
  }
  
  public boolean a(int paramInt)
  {
    b("SmartDeviceProxyMgr::fetchProductInfo");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "fetchProductInfo");
    localBundle.putInt("productId", paramInt);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    b("SmartDeviceProxyMgr::datalineSendCSMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCSMsg");
    localBundle.putInt("subType", paramInt1);
    localBundle.putInt("cookie", paramInt2);
    localBundle.putByteArray("data", paramArrayOfByte);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = a(paramLong);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((ProductInfo)localObject).deviceType == paramInt) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    b("SmartDeviceProxyMgr::datalineSendCCMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCCMsg");
    localBundle.putLong("din", paramLong);
    localBundle.putInt("sendCookie", paramInt);
    localBundle.putByteArray("bodyContent", paramArrayOfByte);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    return true;
  }
  
  public byte[] a()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      b("device login,a2 len is:" + str.length());
      return HexUtil.a(a());
    }
    return HexUtil.a("");
  }
  
  public DeviceInfo[] a()
  {
    a(false);
    Object localObject;
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      localObject = null;
    }
    DeviceInfo[] arrayOfDeviceInfo;
    do
    {
      return (DeviceInfo[])localObject;
      arrayOfDeviceInfo = c();
      localObject = arrayOfDeviceInfo;
    } while (arrayOfDeviceInfo != null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
    return arrayOfDeviceInfo;
  }
  
  public DeviceInfo b(String paramString, int paramInt)
  {
    b("SmartDeviceProxyMgr::getDeviceInfoBySerialNumInNFCList");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    do
    {
      return null;
      Bundle localBundle = new Bundle();
      localBundle.putString("notify_cmd", "getDeviceInfoBySerialNumInNFCList");
      localBundle.putString("serialNum", paramString);
      localBundle.putInt("pid", paramInt);
      paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while (paramString == null);
    return (DeviceInfo)paramString.getParcelable("deviceinfo");
  }
  
  public void b()
  {
    QLog.i("SmartDeviceProxyMgr", 2, "startPlugin force flag:" + this.s + " ipc:" + this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost);
    if (b()) {
      b(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.q = paramInt;
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_antilost_key", this.q);
    if ((this.r + this.q > 1) && (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr != null))
    {
      QFindConfig localQFindConfig = a();
      this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a(this.jdField_b_of_type_JavaUtilArrayList, localQFindConfig);
    }
    if (QLog.isColorLevel()) {
      QLog.w("QFind", 2, "qfind mQfindAssist=" + this.q);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("LocalPath");
    String str2 = paramBundle.getString("PeerUin");
    long l1 = paramBundle.getLong("Uniseq");
    paramBundle = new TransferRequest();
    paramBundle.jdField_a_of_type_Boolean = true;
    paramBundle.jdField_c_of_type_Int = 7;
    paramBundle.i = str1;
    paramBundle.jdField_c_of_type_JavaLangString = str2;
    paramBundle.jdField_a_of_type_Long = l1;
    paramBundle.b = 24;
    paramBundle.jdField_a_of_type_JavaLangString = "facePicUploadProcess";
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(paramBundle);
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 240	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 1389
    //   12: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: astore_3
    //   16: iload_1
    //   17: ifeq +42 -> 59
    //   20: ldc_w 1192
    //   23: astore_2
    //   24: aload_0
    //   25: aload_3
    //   26: aload_2
    //   27: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 139	com/tencent/device/devicemgr/SmartDeviceProxyMgr:b	(Ljava/lang/String;)V
    //   36: iconst_1
    //   37: aload_0
    //   38: getfield 91	com/tencent/device/devicemgr/SmartDeviceProxyMgr:g	I
    //   41: if_icmpeq +15 -> 56
    //   44: aload_0
    //   45: getfield 93	com/tencent/device/devicemgr/SmartDeviceProxyMgr:k	I
    //   48: istore 4
    //   50: iconst_1
    //   51: iload 4
    //   53: if_icmpne +13 -> 66
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: ldc_w 1198
    //   62: astore_2
    //   63: goto -39 -> 24
    //   66: iload_1
    //   67: ifeq +13 -> 80
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 91	com/tencent/device/devicemgr/SmartDeviceProxyMgr:g	I
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 93	com/tencent/device/devicemgr/SmartDeviceProxyMgr:k	I
    //   80: aload_0
    //   81: getfield 91	com/tencent/device/devicemgr/SmartDeviceProxyMgr:g	I
    //   84: ifeq +11 -> 95
    //   87: iconst_3
    //   88: aload_0
    //   89: getfield 91	com/tencent/device/devicemgr/SmartDeviceProxyMgr:g	I
    //   92: if_icmpne -36 -> 56
    //   95: aload_0
    //   96: getfield 348	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   99: ifnull -43 -> 56
    //   102: aload_0
    //   103: getfield 348	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   106: invokevirtual 150	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   109: ifnull -53 -> 56
    //   112: aload_0
    //   113: ldc_w 1390
    //   116: aload_0
    //   117: getfield 348	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   120: invokevirtual 150	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   123: invokestatic 1393	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   126: aload_0
    //   127: invokevirtual 1395	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	()[B
    //   130: ldc_w 598
    //   133: ldc_w 598
    //   136: invokespecial 1397	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(IJ[BLjava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: iconst_1
    //   141: putfield 91	com/tencent/device/devicemgr/SmartDeviceProxyMgr:g	I
    //   144: goto -88 -> 56
    //   147: astore_2
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_2
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	SmartDeviceProxyMgr
    //   0	152	1	paramBoolean	boolean
    //   23	40	2	str	String
    //   147	4	2	localObject	Object
    //   15	11	3	localStringBuilder	StringBuilder
    //   48	6	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   2	16	147	finally
    //   24	50	147	finally
    //   70	80	147	finally
    //   80	95	147	finally
    //   95	144	147	finally
  }
  
  public boolean b(long paramLong)
  {
    if (a(paramLong).booleanValue()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return true;
          localObject = a(paramLong);
          if (localObject == null) {
            return false;
          }
        } while (((DeviceInfo)localObject).SSOBid_Platform == 1027);
        if (((DeviceInfo)localObject).SSOBid_Version == null) {
          return false;
        }
      } while ((((DeviceInfo)localObject).SSOBid_Platform == 0) && (((DeviceInfo)localObject).SSOBid_Version.equals("")));
      localObject = ((DeviceInfo)localObject).SSOBid_Version.split("\\.");
      if ((localObject == null) || (localObject.length < 2)) {
        return false;
      }
      if (Integer.parseInt(localObject[0]) < 1) {
        return false;
      }
    } while ((Integer.parseInt(localObject[0]) != 1) || (Integer.parseInt(localObject[1]) >= 1));
    return false;
  }
  
  public boolean b(String paramString)
  {
    return b(Long.parseLong(paramString));
  }
  
  public DeviceInfo[] b()
  {
    b("SmartDeviceProxyMgr::getNFCDeviceList");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return null;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getNFCDeviceList");
    localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
    if (localObject == null) {
      return null;
    }
    localObject = ((Bundle)localObject).getParcelableArray("devicelist");
    if (localObject == null) {
      return null;
    }
    DeviceInfo[] arrayOfDeviceInfo = new DeviceInfo[localObject.length];
    int i1 = 0;
    while (i1 < localObject.length)
    {
      arrayOfDeviceInfo[i1] = ((DeviceInfo)localObject[i1]);
      i1 += 1;
    }
    return arrayOfDeviceInfo;
  }
  
  public void c()
  {
    b("SmartDeviceProxyMgr::scanNearByDevice");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "scanNearByDevice");
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public boolean c(long paramLong)
  {
    boolean bool2 = false;
    Object localObject = a(paramLong);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((ProductInfo)localObject).deviceType == 13) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Boolean) && (2 == this.g))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("notify_cmd", "logout");
      if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
        this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
      }
    }
    this.g = 0;
    this.k = 0;
  }
  
  public boolean d(long paramLong)
  {
    Object localObject = a(paramLong);
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
      return (localObject != null) && (((ProductInfo)localObject).uConnectType == 1);
    }
    return false;
  }
  
  public void e()
  {
    b("SmartDeviceProxyMgr::updateServerDeviceList");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "updateServerDeviceList");
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public boolean e(long paramLong)
  {
    Object localObject = a(paramLong);
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(8))) {
        return true;
      }
    }
    return false;
  }
  
  public void f()
  {
    b("SmartDeviceProxyMgr::updateDeviceStatus");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "updateDeviceStatus");
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public boolean f(long paramLong)
  {
    b("SmartDeviceProxyMgr::isDeviceHasUpdate");
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    Bundle localBundle;
    do
    {
      return false;
      localBundle = new Bundle();
      localBundle.putString("notify_cmd", "isDeviceHasUpdate");
      localBundle.putLong("din", paramLong);
      localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while ((localBundle == null) || (!localBundle.getBoolean("hasUpdate", false)));
    return true;
  }
  
  public void g()
  {
    b("SmartDeviceProxyMgr onDestroy");
    super.g();
    if ((BaseApplicationImpl.getContext() != null) && (this.jdField_a_of_type_Jwo != null)) {}
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Jwo);
      this.jdField_a_of_type_Jwo = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler.getLooper().quit();
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = null;
      }
      if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null)
      {
        this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a();
        this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost = null;
      }
      if (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr != null)
      {
        this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.b();
        this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean g(long paramLong)
  {
    boolean bool2 = false;
    DeviceInfo localDeviceInfo = a(paramLong);
    boolean bool1 = bool2;
    if (localDeviceInfo != null)
    {
      bool1 = bool2;
      if (localDeviceInfo.userStatus == 10) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\devicemgr\SmartDeviceProxyMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */