package com.tencent.device.qfind;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kbt;

public class BluetoothLeService
  extends Service
{
  public static final int a = 133;
  public static final String a = "com.tencent.device.ble.ACTION_GATT_CONNECTED";
  public static final UUID a;
  private static final int b = 20;
  public static final String b = "com.tencent.device.ble.ACTION_GATT_DISCONNECTED";
  private static final int c = 0;
  public static final String c = "com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED";
  private static final int d = 1;
  public static final String d = "com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED";
  private static final int e = 2;
  public static final String e = "com.tencent.device.ble.ACTION_DATA_AVAILABLE";
  public static final String f = "com.tencent.device.ble.EXTRA_DATA";
  public static final String g = "com.tencent.device.ble.ACTION_GATT_NOT_QQ";
  public static final String h = "com.tencent.device.ble.EXTRA_BLEID";
  public static final String i = "com.tencent.device.ble.ACTION_DATA_READ";
  public static final String j = "com.tencent.device.ble.ACTION_RSSI_READ";
  public static final String k = "com.tencent.device.ble.EXTRA_RSSI";
  public static final String l = "com.tencent.device.ble.ACTION_DATA_WRITE_RST";
  public static final String m = "com.tencent.device.ble.EXRTA_RESULT";
  public static final String n = "com.tencent.device.ble.EXTRA_STATUS";
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  private static final String v = "DeviceBLE_EX";
  private BluetoothAdapter jdField_a_of_type_AndroidBluetoothBluetoothAdapter;
  private final BluetoothGattCallback jdField_a_of_type_AndroidBluetoothBluetoothGattCallback = new kbt(this);
  private BluetoothManager jdField_a_of_type_AndroidBluetoothBluetoothManager;
  BluetoothLeService.LocalBinder jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService$LocalBinder = new BluetoothLeService.LocalBinder(this);
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    o = "0000feba-0000-1000-8000-00805f9b34fb";
    p = "0000fec7-0000-1000-8000-00805f9b34fb";
    q = "0000fec8-0000-1000-8000-00805f9b34fb";
    r = "0000fec9-0000-1000-8000-00805f9b34fb";
    s = "0000fec7-feba-f1f1-99c0-7e0ce07d0c03";
    t = "0000fec8-feba-f1f1-99c0-7e0ce07d0c03";
    u = "0000fec9-feba-f1f1-99c0-7e0ce07d0c03";
    jdField_a_of_type_JavaUtilUUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
  }
  
  private GattInfo a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      GattInfo localGattInfo = (GattInfo)localIterator.next();
      if (localGattInfo.jdField_a_of_type_Int == paramInt) {
        return localGattInfo;
      }
    }
    return null;
  }
  
  private GattInfo a(BluetoothGatt paramBluetoothGatt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      GattInfo localGattInfo = (GattInfo)localIterator.next();
      if (localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt == paramBluetoothGatt) {
        return localGattInfo;
      }
    }
    return null;
  }
  
  private void a(GattInfo paramGattInfo)
  {
    int i1 = 20;
    int i2 = paramGattInfo.jdField_a_of_type_ArrayOfByte.length - paramGattInfo.c;
    if (i2 > 0) {
      if (i2 <= 20) {
        break label174;
      }
    }
    for (;;)
    {
      paramGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setWriteType(2);
      byte[] arrayOfByte = Arrays.copyOfRange(paramGattInfo.jdField_a_of_type_ArrayOfByte, paramGattInfo.c, paramGattInfo.c + i1);
      paramGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setValue(arrayOfByte);
      boolean bool = paramGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt.writeCharacteristic(paramGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "writeCharacteristic result=" + bool + ", len=" + i1 + ",sent=" + paramGattInfo.c + ", toSend=" + paramGattInfo.jdField_a_of_type_ArrayOfByte.length);
      }
      paramGattInfo.c = (i1 + paramGattInfo.c);
      if (paramGattInfo.c >= paramGattInfo.jdField_a_of_type_ArrayOfByte.length)
      {
        paramGattInfo.jdField_a_of_type_ArrayOfByte = null;
        paramGattInfo.c = 0;
      }
      return;
      label174:
      i1 = i2;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new Intent(paramString);
    paramString.putExtra("com.tencent.device.ble.EXTRA_BLEID", paramInt2);
    paramString.putExtra("com.tencent.device.ble.EXTRA_STATUS", paramInt1);
    super.sendBroadcast(paramString);
  }
  
  private void a(String paramString, int paramInt, BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    paramString = new Intent(paramString);
    paramBluetoothGatt = a(paramBluetoothGatt);
    if (paramBluetoothGatt == null) {
      return;
    }
    paramString.putExtra("com.tencent.device.ble.EXTRA_BLEID", paramBluetoothGatt.jdField_a_of_type_Int);
    paramString.putExtra("com.tencent.device.ble.EXTRA_STATUS", paramInt);
    paramString.putExtra("com.tencent.device.ble.EXRTA_RESULT", paramBoolean);
    if ((paramBluetoothGattCharacteristic != null) && (paramBluetoothGattCharacteristic == paramBluetoothGatt.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic)) {
      paramString.putExtra("com.tencent.device.ble.EXTRA_DATA", paramBluetoothGatt.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic.getValue());
    }
    super.sendBroadcast(paramString);
  }
  
  public void a(int paramInt)
  {
    GattInfo localGattInfo = a(paramInt);
    if (localGattInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "gattInfo is null for bleid=" + paramInt);
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) && (localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
    return;
    if (QLog.isColorLevel()) {
      QLog.e("DeviceBLE_EX", 2, "disconnect " + localGattInfo.jdField_a_of_type_JavaLangString + ", bleId=" + paramInt);
    }
    localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt.disconnect();
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null) || (paramBluetoothGatt == null)) {
      if (QLog.isColorLevel()) {
        QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
      }
    }
    do
    {
      return;
      paramBoolean = paramBluetoothGatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "setCharacteristicNotification result=" + paramBoolean);
      }
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getDescriptor(jdField_a_of_type_JavaUtilUUID);
    } while ((paramBluetoothGattCharacteristic == null) || (!paramBluetoothGattCharacteristic.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) || (paramBluetoothGatt.writeDescriptor(paramBluetoothGattCharacteristic)));
    a("com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED", 0, paramBluetoothGatt, null, false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothManager == null)
    {
      this.jdField_a_of_type_AndroidBluetoothBluetoothManager = ((BluetoothManager)super.getSystemService("bluetooth"));
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceBLE_EX", 2, "Unable to initialize BluetoothManager.");
        }
        return false;
      }
    }
    this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = this.jdField_a_of_type_AndroidBluetoothBluetoothManager.getAdapter();
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "Unable to obtain a BluetoothAdapter.");
      }
      return false;
    }
    return true;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null) || (paramString == null) || (!this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized or unspecified address.");
      }
      bool = false;
    }
    do
    {
      return bool;
      GattInfo localGattInfo = a(paramInt);
      if ((localGattInfo != null) && (localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "Trying to use an existing mBluetoothGatt for connection.");
        }
        if (localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt.connect())
        {
          localGattInfo.jdField_b_of_type_Int = 1;
          return true;
        }
        return false;
      }
      localGattInfo = new GattInfo();
      localGattInfo.jdField_a_of_type_Int = paramInt;
      localGattInfo.jdField_a_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.getRemoteDevice(paramString);
      localGattInfo.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(localGattInfo);
      localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt = paramString.connectGatt(this, false, this.jdField_a_of_type_AndroidBluetoothBluetoothGattCallback);
      if (localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt == null)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localGattInfo);
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "connectGatt failed");
        }
        return false;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DeviceBLE_EX", 2, "Trying to create a new connection.");
    return true;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    GattInfo localGattInfo = a(paramInt);
    if (localGattInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "blewrite(" + localGattInfo.jdField_a_of_type_JavaLangString + ")=" + paramArrayOfByte);
      }
      if (localGattInfo.jdField_a_of_type_ArrayOfByte == null) {
        break label79;
      }
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "ble cannot send until the last one finish!");
      }
    }
    return false;
    label79:
    localGattInfo.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    a(localGattInfo);
    return true;
  }
  
  public void b(int paramInt)
  {
    GattInfo localGattInfo = a(paramInt);
    if (localGattInfo != null)
    {
      if (localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
      this.jdField_a_of_type_JavaUtilList.remove(localGattInfo);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceBLE_EX", 2, "close gattInfo failed bleId:" + paramInt);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService$LocalBinder;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      GattInfo localGattInfo = (GattInfo)localIterator.next();
      if (localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    return super.onUnbind(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\qfind\BluetoothLeService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */