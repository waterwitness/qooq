package com.tencent.av.core;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ghd;

public class DeviceSharpController
{
  public static String a;
  public VideoAppInterface a;
  public AbstractNetChannel a;
  ghd a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "smartdevice::sharp";
  }
  
  public DeviceSharpController(AbstractNetChannel paramAbstractNetChannel, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvCoreAbstractNetChannel = null;
    this.jdField_a_of_type_Ghd = null;
    this.jdField_a_of_type_ComTencentAvCoreAbstractNetChannel = paramAbstractNetChannel;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Ghd = new ghd(this);
    paramAbstractNetChannel = new IntentFilter();
    paramAbstractNetChannel.addAction("SmartDevice_ReceiveSharpMsg");
    paramAbstractNetChannel.addAction("SmartDevice_ReceiveSharpAckMsg");
    paramAbstractNetChannel.addAction("SmartDevice_DeviceUnBindRst");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().registerReceiver(this.jdField_a_of_type_Ghd, paramAbstractNetChannel, "com.tencent.smartdevice.permission.broadcast", null);
  }
  
  void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send broadcast : smartdevice send sharp msg");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("size", paramArrayOfByte.length);
    localBundle.putLong("uin", paramLong);
    localBundle.putByteArray("value", paramArrayOfByte);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("msgData", localBundle);
    paramArrayOfByte.setAction("SmartDevice_SendSharpMsg");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramArrayOfByte, "com.tencent.smartdevice.permission.broadcast");
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    a(paramArrayOfByte, paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\core\DeviceSharpController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */