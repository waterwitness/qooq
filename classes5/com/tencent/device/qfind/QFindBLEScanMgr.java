package com.tencent.device.qfind;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.ble.QFindGattManager;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import kca;
import kcb;
import kcc;
import kcf;
import kcg;
import kch;
import mqq.os.MqqHandler;
import tencent.im.oidb.qfind.QFind.DeviceInfo;
import tencent.im.oidb.qfind.QFind.DeviceLoc;
import tencent.im.oidb.qfind.QFind.HistoryData;
import tencent.im.oidb.qfind.QFind.HistoryDetail;
import tencent.im.oidb.qfind.QFind.ReqReportDevs;
import tencent.im.oidb.qfind.QFind.RspReportDevs;

public class QFindBLEScanMgr
{
  private static QFindBLEScanMgr jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr;
  public static final String a = "QFIND_BLE_CONNECT_ERROR";
  private static final String jdField_b_of_type_JavaLangString = "QFIND_SETTING_LAST_REPORT_PERIOD_START";
  private static final String jdField_c_of_type_JavaLangString = "QFIND_SETTING_LAST_REPORT_COUNT";
  private static final String jdField_d_of_type_JavaLangString = "QFIND_SETTING_REPORT_OFTEN_PERIOD";
  private static final String jdField_e_of_type_JavaLangString = "QFIND_SETTING_REPORT_OFTEN_FREQUENCE";
  private static final String jdField_f_of_type_JavaLangString = "QFIND_SETTING_REPORT_SAME_DEVICE_INTERVAL";
  private static final String jdField_g_of_type_JavaLangString = "QFIND_SETTING_REPORT_ANY_DEVICE_INTERVAL";
  private static final String h = "QFIND_SETTING_REPORT_SAME_LOST_DEVS_INTERVAL";
  private static final String i = "QFIND_SETTING_REPORT_FORCE_REPORT_LBS_PERIOD";
  private static String j;
  private static final int jdField_k_of_type_Int = 300000;
  private static String jdField_k_of_type_JavaLangString;
  private static final int jdField_l_of_type_Int = 300000;
  private static final String jdField_l_of_type_JavaLangString = "QFindBLE";
  private static final int m = 3600000;
  private static final int n = 10;
  private static final int o = 300000;
  private static final int p = 3600000;
  private static final int q = 300000;
  private static final int r = 20000;
  int jdField_a_of_type_Int = 300000;
  long jdField_a_of_type_Long = 0L;
  public BluetoothAdapter.LeScanCallback a;
  public BluetoothAdapter a;
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private QFindBLEScanMgr.NotifyReceiver jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver;
  public QQAppInterface a;
  public ArrayList a;
  private Dictionary jdField_a_of_type_JavaUtilDictionary = new Hashtable();
  public HashMap a;
  private kch jdField_a_of_type_Kch;
  public MqqHandler a;
  public volatile boolean a;
  int jdField_b_of_type_Int = 300000;
  long jdField_b_of_type_Long = 0L;
  public ArrayList b;
  public HashMap b;
  public boolean b;
  int jdField_c_of_type_Int = 3600000;
  private long jdField_c_of_type_Long;
  public HashMap c;
  int jdField_d_of_type_Int;
  int jdField_e_of_type_Int;
  int jdField_f_of_type_Int;
  int jdField_g_of_type_Int;
  public int h;
  public int i;
  public int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    j = "Q_Find_Scan_Intent";
    k = "com.tencent.mobileqq.msf.wakeup";
  }
  
  public QFindBLEScanMgr()
  {
    this.d = 10;
    this.e = 300000;
    this.f = 3600000;
    this.g = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    if (a()) {
      ThreadManager.b().post(new kcf(this));
    }
    if (!a()) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
      try
      {
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = ((BluetoothManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("bluetooth")).getAdapter();
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null) {
          continue;
        }
        localObject = BaseApplicationImpl.a().a();
        if ((localObject instanceof QQAppInterface)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          d();
          this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver = new QFindBLEScanMgr.NotifyReceiver(this);
          Object localObject = new IntentFilter();
          ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED");
          ((IntentFilter)localObject).addAction("onDeviceVerifyRsp");
          ((IntentFilter)localObject).addAction("QFIND_BLE_CONNECT_ERROR");
          this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver, (IntentFilter)localObject);
          return;
          localThrowable = localThrowable;
          localThrowable.printStackTrace();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr releaseWakeLock:" + paramInt);
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    paramString = "" + paramInt + "|" + paramString;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      SosoInterface.a(new kca(this, 0, true, true, 0L, false, false, "smartdevice:lightapp", paramString));
    }
  }
  
  private void a(BlePeerInfo paramBlePeerInfo, SosoInterface.SosoLbsInfo paramSosoLbsInfo, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        l1 = NetConnInfoCenter.getServerTimeMillis();
        if (this.jdField_b_of_type_Long > 0L)
        {
          long l2 = this.jdField_b_of_type_Long;
          if (l1 - l2 <= 600000L) {
            continue;
          }
        }
      }
      catch (Throwable paramBlePeerInfo)
      {
        long l1;
        paramBlePeerInfo.printStackTrace();
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("QFindBLE", 2, "SendReqReportAroundDevs  report exception :   " + paramBlePeerInfo.toString());
        return;
        QLog.i("QFindBLE", 1, "report lost dev sn=" + paramBlePeerInfo.a() + ", pid=" + paramBlePeerInfo.jdField_a_of_type_Int + " has loc(" + paramSosoLbsInfo.a.jdField_a_of_type_Double + "," + paramSosoLbsInfo.a.b + ", " + paramSosoLbsInfo.a.jdField_a_of_type_Float + ")" + ", ble_id = " + paramBlePeerInfo.jdField_c_of_type_Int + ", lastreportcount=" + this.g + ", run = " + paramBlePeerInfo.f + " , walk = " + paramBlePeerInfo.e);
        continue;
      }
      try
      {
        c();
        if (paramSosoLbsInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QFindBLE", 2, "start to report dev sn=" + paramBlePeerInfo.a() + ", pid=" + paramBlePeerInfo.jdField_a_of_type_Int + ", ble_id = " + paramBlePeerInfo.jdField_c_of_type_Int + ", lastreportcount=" + this.g + ", run = " + paramBlePeerInfo.f + " , walk = " + paramBlePeerInfo.e);
          }
          QFind.ReqReportDevs localReqReportDevs = new QFind.ReqReportDevs();
          ArrayList localArrayList1 = new ArrayList();
          QFind.DeviceInfo localDeviceInfo = new QFind.DeviceInfo();
          localDeviceInfo.pid.set(paramBlePeerInfo.jdField_a_of_type_Int);
          localDeviceInfo.service_uuid.set(2L);
          localDeviceInfo.sn.set(ByteStringMicro.copyFromUtf8(paramBlePeerInfo.a()));
          if (paramBoolean) {
            localDeviceInfo.bytes_sig.set(ByteStringMicro.copyFrom(paramBlePeerInfo.jdField_b_of_type_ArrayOfByte));
          }
          localDeviceInfo.timestamp.set((int)(l1 / 1000L));
          ArrayList localArrayList2 = new ArrayList();
          QFind.HistoryDetail localHistoryDetail = new QFind.HistoryDetail();
          localHistoryDetail.run.set(paramBlePeerInfo.f);
          localHistoryDetail.walk.set(paramBlePeerInfo.e);
          localArrayList2.add(localHistoryDetail);
          paramBlePeerInfo = new QFind.HistoryData();
          paramBlePeerInfo.details.set(localArrayList2);
          localDeviceInfo.msg_walking_history.set(paramBlePeerInfo);
          localArrayList1.add(localDeviceInfo);
          localReqReportDevs.dev_infos.set(localArrayList1);
          if (paramSosoLbsInfo != null)
          {
            paramBlePeerInfo = new QFind.DeviceLoc();
            paramBlePeerInfo.lat.set(Double.valueOf(paramSosoLbsInfo.a.jdField_a_of_type_Double * 1000000.0D).intValue());
            paramBlePeerInfo.lon.set(Double.valueOf(paramSosoLbsInfo.a.b * 1000000.0D).intValue());
            paramBlePeerInfo.gps_type.set(1);
            paramBlePeerInfo.uint32_precision.set((int)paramSosoLbsInfo.a.jdField_a_of_type_Float);
            localReqReportDevs.dev_loc.set(paramBlePeerInfo);
          }
          paramSosoLbsInfo = (QQAppInterface)BaseApplicationImpl.a().a();
          paramBlePeerInfo = (SmartDeviceProxyMgr)paramSosoLbsInfo.a(51);
          paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", paramSosoLbsInfo.a(), "QFindSvc.ReqReportDevs");
          paramSosoLbsInfo.putWupBuffer(localReqReportDevs.toByteArray());
          paramBlePeerInfo.b(paramSosoLbsInfo);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      kcg localkcg = new kcg(this);
      if ((Long)this.jdField_a_of_type_JavaUtilDictionary.get(localkcg) == null) {
        this.jdField_a_of_type_JavaUtilDictionary.put(localkcg, Long.valueOf(new Date().getTime()));
      }
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private boolean a(BlePeerInfo paramBlePeerInfo)
  {
    paramBlePeerInfo = "" + paramBlePeerInfo.jdField_a_of_type_Int + "|" + paramBlePeerInfo.a();
    return this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramBlePeerInfo);
  }
  
  private boolean a(BlePeerInfo paramBlePeerInfo, boolean paramBoolean)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if ((this.jdField_a_of_type_Long <= 0L) || (l1 - this.jdField_a_of_type_Long > this.jdField_c_of_type_Int))
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      this.g = 0;
    }
    if ((this.g > this.d) && (!paramBoolean)) {
      return false;
    }
    Object localObject = "" + paramBlePeerInfo.jdField_a_of_type_Int + "|" + paramBlePeerInfo.a();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject))
    {
      BlePeerInfo localBlePeerInfo = (BlePeerInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      localBlePeerInfo.f = paramBlePeerInfo.f;
      localBlePeerInfo.e = paramBlePeerInfo.e;
      if ((!paramBoolean) && (l1 - localBlePeerInfo.jdField_a_of_type_Long < this.jdField_a_of_type_Int)) {
        return false;
      }
      if ((paramBoolean) && (l1 - localBlePeerInfo.jdField_b_of_type_Long < this.e)) {
        return false;
      }
      if ((paramBoolean) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject)) && (l1 - ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(localObject)).longValue() > this.f) && (l1 - localBlePeerInfo.jdField_b_of_type_Long < this.jdField_a_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "report lost dev reach the period: " + this.f);
        }
        return false;
      }
      localBlePeerInfo.jdField_a_of_type_Long = l1;
      if (paramBoolean) {
        localBlePeerInfo.jdField_b_of_type_Long = l1;
      }
    }
    for (;;)
    {
      localObject = (BlePeerInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (!((BlePeerInfo)localObject).jdField_b_of_type_Boolean)
      {
        ((BlePeerInfo)localObject).jdField_c_of_type_Int = paramBlePeerInfo.jdField_c_of_type_Int;
        ((BlePeerInfo)localObject).jdField_a_of_type_Boolean = false;
      }
      this.g += 1;
      return true;
      paramBlePeerInfo.jdField_a_of_type_Long = l1;
      if (paramBoolean) {
        paramBlePeerInfo.jdField_b_of_type_Long = l1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject, paramBlePeerInfo);
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      try
      {
        if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) && (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QFindBLE", 2, "call native mBluetoothAdapter.startLeScan with cb=" + this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback + ", mScanning=" + this.jdField_a_of_type_Boolean);
          }
          this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.startLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
          if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
            this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new kcb(this), this.i);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      if (this.jdField_a_of_type_Boolean) {}
      return this.jdField_a_of_type_Boolean;
      g();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        try
        {
          if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QFindBLE", 2, "call native mBluetoothAdapter.stopLeScan with cb=" + this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback + ", mScanning=" + this.jdField_a_of_type_Boolean);
            }
            this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.stopLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
            return true;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return true;
  }
  
  private void c()
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((str == null) || ("".equals(str))) {
      return;
    }
    localEditor.putInt("QFIND_SETTING_REPORT_SAME_DEVICE_INTERVAL" + str, this.jdField_a_of_type_Int);
    localEditor.putInt("QFIND_SETTING_REPORT_ANY_DEVICE_INTERVAL" + str, this.jdField_b_of_type_Int);
    localEditor.putInt("QFIND_SETTING_REPORT_OFTEN_FREQUENCE" + str, this.d);
    localEditor.putInt("QFIND_SETTING_REPORT_OFTEN_PERIOD" + str, this.jdField_c_of_type_Int);
    localEditor.putLong("QFIND_SETTING_LAST_REPORT_PERIOD_START" + str, this.jdField_a_of_type_Long);
    localEditor.putInt("QFIND_SETTING_LAST_REPORT_COUNT" + str, this.g);
    localEditor.putInt("QFIND_SETTING_REPORT_SAME_LOST_DEVS_INTERVAL" + str, this.e);
    localEditor.putInt("QFIND_SETTING_REPORT_FORCE_REPORT_LBS_PERIOD" + str, this.f);
    localEditor.commit();
  }
  
  private void d()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((str == null) || ("".equals(str))) {
      return;
    }
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("QFIND_SETTING_REPORT_SAME_DEVICE_INTERVAL" + str, 300000);
    this.jdField_b_of_type_Int = localSharedPreferences.getInt("QFIND_SETTING_REPORT_ANY_DEVICE_INTERVAL" + str, 300000);
    this.jdField_c_of_type_Int = localSharedPreferences.getInt("QFIND_SETTING_REPORT_OFTEN_PERIOD" + str, 3600000);
    this.d = localSharedPreferences.getInt("QFIND_SETTING_REPORT_OFTEN_FREQUENCE" + str, 3600000);
    this.g = localSharedPreferences.getInt("QFIND_SETTING_LAST_REPORT_COUNT" + str, 0);
    this.jdField_a_of_type_Long = localSharedPreferences.getLong("QFIND_SETTING_LAST_REPORT_PERIOD_START" + str, 0L);
    this.e = localSharedPreferences.getInt("QFIND_SETTING_REPORT_SAME_LOST_DEVS_INTERVAL" + str, 300000);
    this.f = localSharedPreferences.getInt("QFIND_SETTING_REPORT_FORCE_REPORT_LBS_PERIOD" + str, 3600000);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("power")).newWakeLock(536870913, "QFindBLE");
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr acquireWakeLock");
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_Kch = new kch(this, null);
      this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
      this.jdField_a_of_type_AndroidContentIntentFilter.addAction(j);
      this.jdField_a_of_type_AndroidContentIntentFilter.addAction(k);
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Kch, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr cancelReceiver");
    }
    a(2);
    if (this.jdField_a_of_type_Kch != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Kch);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.a("ble_scan_task", 0);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback = new kcc(this);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public PeerInfo a(BlePeerInfo paramBlePeerInfo)
  {
    PeerInfo localPeerInfo = new PeerInfo();
    localPeerInfo.jdField_a_of_type_Int = paramBlePeerInfo.jdField_c_of_type_Int;
    localPeerInfo.jdField_a_of_type_JavaLangString = paramBlePeerInfo.jdField_b_of_type_JavaLangString;
    localPeerInfo.jdField_b_of_type_JavaLangString = paramBlePeerInfo.jdField_c_of_type_JavaLangString;
    localPeerInfo.jdField_a_of_type_ArrayOfByte = paramBlePeerInfo.jdField_a_of_type_ArrayOfByte;
    localPeerInfo.jdField_a_of_type_JavaUtilList = paramBlePeerInfo.jdField_a_of_type_JavaUtilList;
    localPeerInfo.jdField_b_of_type_Int = paramBlePeerInfo.jdField_a_of_type_Int;
    return localPeerInfo;
  }
  
  public void a()
  {
    if (!a()) {
      return;
    }
    a(false);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!a()) {
      return;
    }
    QLog.i("QFindBLE", 1, "assist scan interval=" + paramInt1 + ", period=" + paramInt2);
    a(false);
    this.jdField_b_of_type_Boolean = true;
    this.h = paramInt1;
    this.i = paramInt2;
    if (paramInt1 <= 0) {
      this.h = 300000;
    }
    if (paramInt2 <= 0) {
      this.i = 20000;
    }
    f();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1;
    try
    {
      localObject1 = new QFind.ReqReportDevs();
      ((QFind.ReqReportDevs)localObject1).mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      paramObject = new QFind.RspReportDevs();
      ((QFind.RspReportDevs)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
      int i1 = paramToServiceMsg.getAppSeq();
      paramToServiceMsg = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while ((paramToServiceMsg.hasNext()) && (i1 != ((BlePeerInfo)paramToServiceMsg.next()).jdField_b_of_type_Int)) {}
      if (((QFind.RspReportDevs)paramObject).result.get() != 0) {
        break label691;
      }
      paramFromServiceMsg = new ArrayList();
      paramToServiceMsg = new ArrayList();
      Iterator localIterator = ((QFind.ReqReportDevs)localObject1).dev_infos.get().iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (QFind.DeviceInfo)localIterator.next();
        localObject2 = "" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8();
        paramFromServiceMsg.add(localObject2);
        this.jdField_c_of_type_JavaUtilHashMap.remove(localObject2);
      }
      String str;
      paramFromServiceMsg = paramFromServiceMsg.iterator();
    }
    catch (Throwable paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      return;
      localIterator = ((QFind.RspReportDevs)paramObject).lost_devs.get().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (QFind.DeviceInfo)localIterator.next();
        str = "" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8();
        if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(str)) {
          this.jdField_c_of_type_JavaUtilHashMap.remove(str);
        }
        this.jdField_c_of_type_JavaUtilHashMap.put(str, localObject2);
        paramToServiceMsg.add("" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8());
        paramFromServiceMsg.remove("" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8());
        if (!((QFind.ReqReportDevs)localObject1).dev_loc.has()) {
          a(((QFind.DeviceInfo)localObject2).pid.get(), ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8());
        }
      }
    }
    finally
    {
      a(3);
    }
    while (paramFromServiceMsg.hasNext())
    {
      localObject1 = (String)paramFromServiceMsg.next();
      this.jdField_b_of_type_JavaUtilHashMap.remove(localObject1);
    }
    paramToServiceMsg = paramToServiceMsg.iterator();
    while (paramToServiceMsg.hasNext())
    {
      paramFromServiceMsg = (String)paramToServiceMsg.next();
      if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramFromServiceMsg)) {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramFromServiceMsg, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      }
    }
    this.jdField_a_of_type_Int = Math.max(((QFind.RspReportDevs)paramObject).report_same_dev_interval.get() * 1000, 300000);
    this.jdField_b_of_type_Int = Math.max(((QFind.RspReportDevs)paramObject).report_any_devs_interval.get() * 1000, 300000);
    this.jdField_c_of_type_Int = Math.max(((QFind.RspReportDevs)paramObject).report_often_period.get() * 1000, 3600000);
    this.d = Math.max(((QFind.RspReportDevs)paramObject).report_often_frequence.get(), 10);
    this.f = Math.max(((QFind.RspReportDevs)paramObject).force_report_lbs_period.get(), 3600000);
    this.e = Math.max(((QFind.RspReportDevs)paramObject).report_same_lost_devs_interval.get(), 300000);
    label691:
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuffer();
      paramToServiceMsg.append(", result=" + ((QFind.RspReportDevs)paramObject).result.get());
      paramToServiceMsg.append(", report_same_dev_interval=" + ((QFind.RspReportDevs)paramObject).report_same_dev_interval.get());
      paramToServiceMsg.append(", report_any_devs_interval=" + ((QFind.RspReportDevs)paramObject).report_any_devs_interval.get());
      paramToServiceMsg.append(", report_often_period=" + ((QFind.RspReportDevs)paramObject).report_often_period.get());
      paramToServiceMsg.append(", report_often_frequence=" + ((QFind.RspReportDevs)paramObject).report_often_frequence.get());
      paramToServiceMsg.append(", freq_limit_report_any_devs_interval=" + ((QFind.RspReportDevs)paramObject).freq_limit_report_any_devs_interval.get());
      paramToServiceMsg.append(", force_report_lbs=" + ((QFind.RspReportDevs)paramObject).force_report_lbs.get());
      paramToServiceMsg.append(", force_report_lbs_period=" + ((QFind.RspReportDevs)paramObject).force_report_lbs_period.get());
      paramToServiceMsg.append(", report_same_lost_devs_interval=" + ((QFind.RspReportDevs)paramObject).report_same_lost_devs_interval.get());
      paramToServiceMsg.append(", report_max_dev_num=" + ((QFind.RspReportDevs)paramObject).report_max_dev_num.get());
      paramToServiceMsg.append(", lost_devs=[");
      paramFromServiceMsg = ((QFind.RspReportDevs)paramObject).lost_devs.get().iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (QFind.DeviceInfo)paramFromServiceMsg.next();
        paramToServiceMsg.append(((QFind.DeviceInfo)paramObject).pid.get() + "|" + ((QFind.DeviceInfo)paramObject).sn.get().toStringUtf8() + "|" + ((QFind.DeviceInfo)paramObject).timestamp.get() + ",");
      }
      paramToServiceMsg.append("]");
      QLog.w("QFindBLE", 2, "get report dev result " + paramToServiceMsg);
    }
    a(3);
  }
  
  public void a(ArrayList paramArrayList, QFindConfig paramQFindConfig)
  {
    if (!a()) {}
    while ((paramArrayList.size() <= 0) || (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    if ((paramQFindConfig != null) && (paramQFindConfig.jdField_c_of_type_Int > 0) && (paramQFindConfig.d > 0))
    {
      a(paramQFindConfig.jdField_c_of_type_Int, paramQFindConfig.d);
      return;
    }
    a(60000, 20000);
  }
  
  public void b()
  {
    a();
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_MqqOsMqqHandler.getLooper().quit();
    }
    if (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver);
      this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver = null;
    }
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
    {
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.stopLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    QFindGattManager.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\qfind\QFindBLEScanMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */