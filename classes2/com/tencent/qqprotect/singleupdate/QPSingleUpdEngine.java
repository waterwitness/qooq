package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msfmqpsdkbridge.MSFEmuDetectWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QPSingleUpdEngine
{
  private static final byte jdField_a_of_type_Byte = 33;
  static final String jdField_a_of_type_JavaLangString = "QPSingleUpdEngine";
  static final String jdField_b_of_type_JavaLangString = "qpsingleupdenginesharedpreference";
  private static final String g = "EmulatorDetect";
  final int jdField_a_of_type_Int;
  QPCheckCanRestartThread jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread;
  QPSingleUpdReportSig jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig;
  QPSingleUpdStateCfg jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg;
  QPSinlgeUpdInfo jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo;
  QPSupportUpdCfg jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg;
  Socket jdField_a_of_type_JavaNetSocket;
  final int jdField_b_of_type_Int;
  final int jdField_c_of_type_Int;
  final String jdField_c_of_type_JavaLangString;
  final int jdField_d_of_type_Int;
  final String jdField_d_of_type_JavaLangString;
  final int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  String f;
  
  public QPSingleUpdEngine(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 10000;
    this.jdField_b_of_type_Int = 60000;
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangString = "qd-up.m.qq.com";
    this.jdField_e_of_type_Int = 14000;
    this.jdField_d_of_type_JavaLangString = "TxSingleUpd.zip";
    this.jdField_e_of_type_JavaLangString = null;
    this.f = null;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg = null;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg = null;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig = null;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread = null;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo = null;
    this.f = paramString;
    paramString = BaseApplication.getContext().getFilesDir();
    this.jdField_e_of_type_JavaLangString = (paramString.getAbsolutePath() + "/TxSingleUpd/");
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg = new QPSupportUpdCfg();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.ReadConfigFile(QPSupportUpdCfg.CFG_FILEPATH);
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg = new QPSingleUpdStateCfg();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo = new QPSinlgeUpdInfo();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig = new QPSingleUpdReportSig();
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      int i = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getIpAddress();
      return i >> 24 & 0xFF | (i & 0xFF) << 24 | (i >> 8 & 0xFF) << 16 | (i >> 16 & 0xFF) << 8;
    }
    catch (Exception paramContext)
    {
      QLog.d("QPSingleUpdEngine", 0, " 获取IP出错!请保证是WiFi,或者请重新打开网络!\n" + paramContext.getMessage());
    }
    return 1;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 24 >>> 8 | paramArrayOfByte[3] << 24;
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    int j = 0;
    while (j < k / 2)
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[(k - 1 - j)];
      paramArrayOfByte[(k - 1 - j)] = i;
      j += 1;
    }
  }
  
  private boolean a(File paramFile)
  {
    return (paramFile.exists()) && (paramFile.canRead()) && (paramFile.length() < 10002432L);
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >>> 24) };
  }
  
  public int a()
  {
    Object localObject1 = BaseApplication.getContext();
    BaseApplication.getContext();
    Object localObject2 = (ConnectivityManager)((BaseApplication)localObject1).getSystemService("connectivity");
    localObject1 = ((ConnectivityManager)localObject2).getNetworkInfo(1);
    localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
    if ((localObject1 != null) && (((NetworkInfo)localObject1).getState() == NetworkInfo.State.CONNECTED)) {
      return 1;
    }
    if ((localObject2 != null) && (((NetworkInfo)localObject2).getState() == NetworkInfo.State.CONNECTED)) {
      return 2;
    }
    return 0;
  }
  
  public void a()
  {
    QLog.d("QPSingleUpdEngine", 0, "Engine started");
    c();
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a())
    {
      QLog.d("QPSingleUpdEngine", 0, "Today is updated");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c())
    {
      QLog.d("QPSingleUpdEngine", 0, "Today is updated");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.f();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Long = new Date().getTime();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.a = true;
      i();
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a()) && (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.b() == true) && (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c == 0L))
    {
      QLog.d("QPSingleUpdEngine", 0, "there is another Update thread is running");
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a()) && (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.b()))
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.d();
    }
    if ((!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a()) && (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c > 0L))
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.d();
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.e();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.updateCfgHash();
    boolean bool1 = false;
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int > 0)
      {
        bool1 = a();
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a();
        if (!bool1) {}
      }
      else
      {
        if (bool1) {
          break;
        }
        i();
        return;
      }
      Thread.sleep(60000L);
      QLog.d("QPSingleUpdEngine", 0, "requestUpdate error !!!");
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.d = true;
    if (!j())
    {
      QLog.d("QPSingleUpdEngine", 0, "the ClientFile is Already the highest version");
      i();
      return;
    }
    QLog.d("QPSingleUpdEngine", 0, "Need to Update");
    bool1 = false;
    int i = 3;
    int k = 0;
    boolean bool2;
    boolean bool3;
    do
    {
      int j;
      do
      {
        bool2 = bool1;
        if (i <= 0) {
          break;
        }
        if (!b())
        {
          this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.n = true;
          i();
          return;
        }
        bool3 = c();
        j = i - 1;
        k = bool3;
        i = j;
      } while (!bool3);
      bool2 = d();
      bool1 = bool2;
      k = bool3;
      i = j;
    } while (!bool2);
    k = bool3;
    if ((k == 0) || (!bool2))
    {
      i();
      return;
    }
    if (!e())
    {
      i();
      return;
    }
    if (!f())
    {
      i();
      return;
    }
    if (!h())
    {
      g();
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread = new QPCheckCanRestartThread();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread.start();
    do
    {
      while (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread.a()) {
        b();
      }
      Thread.sleep(1000L);
    } while ((new Date().getTime() - this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Long) / 3600000L < 22L);
    i();
    QLog.d("QPSingleUpdEngine", 0, "Engine Ended");
  }
  
  public void a(QPSingleUpdateProto.Head paramHead, QPSingleUpdateProto.ReqBody paramReqBody)
  {
    QLog.d("QPSingleUpdEngine", 0, "getBaseInfo");
    paramHead.setHasFlag(true);
    paramHead.uint64_uin.set(Long.parseLong(this.f));
    paramHead.uint32_command.set(0);
    paramHead.uint32_seq.set(0);
    Object localObject1 = new String();
    int i = 0;
    while (i < "6.5.5".length())
    {
      localObject2 = localObject1;
      if ("6.5.5".charAt(i) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("6.5.5".charAt(i)));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmulatorDetect", 2, "SubVer = " + (String)localObject1);
    }
    paramHead.uint32_version.set(Integer.parseInt((String)localObject1));
    paramHead.uint32_retry_times.set(3);
    paramHead.uint32_client_type.set(1);
    localObject1 = String.format("%d", new Object[] { Integer.valueOf(AppSetting.jdField_a_of_type_Int) });
    if (QLog.isColorLevel()) {
      QLog.d("EmulatorDetect", 2, "appID = " + (String)localObject1);
    }
    paramHead.uint32_pubno.set(Integer.parseInt((String)localObject1));
    localObject1 = Locale.getDefault().getLanguage();
    if ((((String)localObject1).endsWith("cn")) || (((String)localObject1).endsWith("zh"))) {
      paramHead.uint32_localid.set(2052);
    }
    if (((String)localObject1).endsWith("en")) {
      paramHead.uint32_localid.set(1033);
    }
    paramHead.msg_login_sig.setHasFlag(true);
    paramHead.msg_login_sig.uint32_type.set(1);
    paramHead.uint32_client_ip.set(0);
    paramHead.uint32_client_port.set(0);
    paramHead.uint32_actual_ip.set(0);
    paramHead.uint32_qdun_ver.set(46);
    localObject1 = ByteStringMicro.copyFrom(Build.MODEL.getBytes());
    paramHead.bytes_phone_model.set((ByteStringMicro)localObject1);
    localObject1 = BaseApplication.getContext();
    BaseApplication.getContext();
    localObject1 = (TelephonyManager)((BaseApplication)localObject1).getSystemService("phone");
    Object localObject2 = ByteStringMicro.copyFrom(((TelephonyManager)localObject1).getDeviceId().getBytes());
    paramHead.bytes_phone_imei.set((ByteStringMicro)localObject2);
    SharedPreferences.Editor localEditor;
    if (paramHead.uint32_subcmd.get() == 0)
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("qpsingleupdenginesharedpreference", 0);
      localEditor = localSharedPreferences.edit();
      i = localSharedPreferences.getInt(this.f + "readphonenumberflag", 0);
      QLog.d("QPSingleUpdEngine", 0, this.f + "read---->readphonenumberflag = " + i);
      if (i != 0)
      {
        localObject2 = ((TelephonyManager)localObject1).getLine1Number();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (1 == i)
        {
          i = localSharedPreferences.getInt(this.f + "whetheruploadflag", 1);
          QLog.d("QPSingleUpdEngine", 0, this.f + "read---->whetheruploadflag = " + i);
          if (i != 0) {
            break label643;
          }
          localObject2 = "";
        }
      }
    }
    for (;;)
    {
      localObject1 = ((String)localObject2).getBytes();
      i = 0;
      for (;;)
      {
        if (i < localObject1.length)
        {
          localObject1[i] = ((byte)(localObject1[i] ^ 0x21));
          i += 1;
          continue;
          label643:
          localEditor.putInt(this.f + "whetheruploadflag", 0);
          localEditor.commit();
          localObject2 = localObject1;
          break;
        }
      }
      localObject2 = ByteStringMicro.copyFrom((byte[])localObject1);
      paramHead.bytes_phone_num.set((ByteStringMicro)localObject2);
      QLog.d("QPSingleUpdEngine", 0, this.f + "read---->encodephonenumber = " + new String((byte[])localObject1));
      i = a();
      if (i == 1) {
        paramHead.uint32_net_type.set(1);
      }
      for (;;)
      {
        try
        {
          i = new MSFEmuDetectWrapper().a("ENCRYPTFILE");
          paramHead.uint32_emulator_flag.set(i);
          if (QLog.isColorLevel()) {
            QLog.d("EmulatorDetect", 2, "detectresult = " + i);
          }
          localObject1 = new Timestamp(new Date().getTime());
          paramHead.uint64_timestampnew.set(((Timestamp)localObject1).getTime());
          localObject1 = new Timestamp(((Timestamp)localObject1).getTime());
          QLog.d("QPSingleUpdEngine", 0, "new = " + String.valueOf(((Timestamp)localObject1).toString()));
          paramHead.uint32_timestamp.set(0);
          paramHead.uint32_result.set(0);
          paramHead.uint32_flag.set(1);
          int j = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.getFileItemCount();
          paramReqBody.setHasFlag(true);
          i = 0;
          if (i < j)
          {
            localObject2 = new QPSingleUpdateProto.FileItem();
            paramHead = QPUpdFileOperation.a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath);
            localObject1 = ByteStringMicro.copyFrom(paramHead.getBytes());
            ((QPSingleUpdateProto.FileItem)localObject2).bytes_name.set((ByteStringMicro)localObject1);
            if (paramHead.equalsIgnoreCase("SupportUpd.cfg"))
            {
              localObject1 = this.jdField_e_of_type_JavaLangString + "SupportUpd.cfg";
              paramHead = (QPSingleUpdateProto.Head)localObject1;
              if (((String)localObject1).length() > 255) {
                paramHead = ((String)localObject1).substring(0, 255);
              }
              if (!a(new File(paramHead))) {
                break label1168;
              }
              paramHead = MD5FileUtil.a(paramHead);
              if (paramHead == null) {
                break label1168;
              }
              paramHead = ByteStringMicro.copyFrom(paramHead.getBytes());
              ((QPSingleUpdateProto.FileItem)localObject2).bytes_hash.set(paramHead);
              ((QPSingleUpdateProto.FileItem)localObject2).setHasFlag(true);
              paramReqBody.rpt_file_item_list.add((MessageMicro)localObject2);
              i += 1;
              continue;
              if (i != 2) {
                continue;
              }
              paramHead.uint32_net_type.set(2);
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          paramHead.uint32_emulator_flag.set(5);
          MSFEmuDetectWrapper.a();
          continue;
          paramHead = QPUpdFileOperation.a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash);
          continue;
          QLog.d("QPSingleUpdEngine", 0, "getBaseInfo___end");
          return;
        }
        label1168:
        paramHead = "00000000000000000000000000000000";
      }
      localObject2 = "";
    }
  }
  
  public boolean a()
  {
    QLog.d("QPSingleUpdEngine", 0, "Begin Request");
    Object localObject4 = new QPSingleUpdateProto.Head();
    Object localObject3 = new QPSingleUpdateProto.ReqBody();
    try
    {
      ((QPSingleUpdateProto.Head)localObject4).uint32_subcmd.set(0);
      a((QPSingleUpdateProto.Head)localObject4, (QPSingleUpdateProto.ReqBody)localObject3);
      Object localObject1 = InetAddress.getByName("qd-up.m.qq.com");
      QLog.d("QPSingleUpdEngine", 0, "Start Create Socket!!!");
      this.jdField_a_of_type_JavaNetSocket = new Socket((InetAddress)localObject1, 14000);
      QLog.d("QPSingleUpdEngine", 0, "Create Socket Success");
      localObject1 = this.jdField_a_of_type_JavaNetSocket.getOutputStream();
      QLog.d("QPSingleUpdEngine", 0, "GetOutputStream Successs");
      Object localObject5 = InetAddress.getLocalHost().getAddress();
      int i = localObject5[0];
      int j = localObject5[1];
      int k = localObject5[2];
      int m = localObject5[3];
      ((QPSingleUpdateProto.Head)localObject4).uint32_client_ip.set(m | i << 24 | j << 16 | k << 8);
      ((QPSingleUpdateProto.Head)localObject4).uint32_client_port.set(this.jdField_a_of_type_JavaNetSocket.getLocalPort());
      localObject4 = ((QPSingleUpdateProto.Head)localObject4).toByteArray();
      localObject3 = ((QPSingleUpdateProto.ReqBody)localObject3).toByteArray();
      localObject5 = new ByteArrayOutputStream(localObject4.length + 10 + localObject3.length);
      Object localObject6 = new DataOutputStream((OutputStream)localObject5);
      ((ByteArrayOutputStream)localObject5).write(2);
      ((DataOutputStream)localObject6).writeInt(localObject4.length);
      ((DataOutputStream)localObject6).writeInt(localObject3.length);
      ((ByteArrayOutputStream)localObject5).write((byte[])localObject4);
      ((ByteArrayOutputStream)localObject5).write((byte[])localObject3);
      ((ByteArrayOutputStream)localObject5).write(3);
      QLog.d("QPSingleUpdEngine", 0, "reqHeadLen = " + localObject4.length);
      QLog.d("QPSingleUpdEngine", 0, "reqBodyLen = " + localObject3.length);
      ((DataOutputStream)localObject6).close();
      ((ByteArrayOutputStream)localObject5).close();
      this.jdField_a_of_type_JavaNetSocket.setSoTimeout(15000);
      ((OutputStream)localObject1).write(((ByteArrayOutputStream)localObject5).toByteArray());
      QLog.d("QPSingleUpdEngine", 0, "Send Request Success");
      localObject3 = this.jdField_a_of_type_JavaNetSocket.getInputStream();
      QLog.d("QPSingleUpdEngine", 0, "GetInputStream Success");
      this.jdField_a_of_type_JavaNetSocket.setSoTimeout(15000);
      i = ((InputStream)localObject3).read();
      QLog.d("QPSingleUpdEngine", 0, "Got STX");
      if (i != 2)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.k = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException1)
        {
          return false;
        }
      }
      localObject4 = new byte[4];
      if (((InputStream)localObject3).read((byte[])localObject4, 0, 4) < 4)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException2)
        {
          return false;
        }
      }
      a((byte[])localObject4);
      i = a((byte[])localObject4);
      QLog.d("QPSingleUpdEngine", 0, "iHeadLen = " + i);
      if (i == 0) {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
      }
      localObject4 = new byte[4];
      if (((InputStream)localObject3).read((byte[])localObject4, 0, 4) < 4)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException3)
        {
          return false;
        }
      }
      a((byte[])localObject4);
      j = a((byte[])localObject4);
      QLog.d("QPSingleUpdEngine", 0, "iBodyLen = " + j);
      if (j == 0)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.i = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return true;
        }
        catch (IOException localIOException4)
        {
          return false;
        }
      }
      localObject5 = new byte[i];
      if (((InputStream)localObject3).read((byte[])localObject5, 0, i) < i)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException5)
        {
          return false;
        }
      }
      localObject6 = new QPSingleUpdateProto.Head();
      localObject4 = new QPSingleUpdateProto.RspBody();
      boolean bool = a((QPSingleUpdateProto.Head)((QPSingleUpdateProto.Head)localObject6).mergeFrom((byte[])localObject5));
      if (!bool) {
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException6)
        {
          return false;
        }
      }
      localObject5 = new byte[j];
      if (((InputStream)localObject3).read((byte[])localObject5, 0, j) < j)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException7)
        {
          return false;
        }
      }
      localObject4 = (QPSingleUpdateProto.RspBody)((QPSingleUpdateProto.RspBody)localObject4).mergeFrom((byte[])localObject5);
      a((QPSingleUpdateProto.RspBody)localObject4);
      QLog.d("QPSingleUpdEngine", 0, "Got Entire Rsp Package");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_Int = ((QPSingleUpdateProto.RspBody)localObject4).uint32_update_vailable.get();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_Int = ((QPSingleUpdateProto.RspBody)localObject4).uint32_force_download.get();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_c_of_type_Int = ((QPSingleUpdateProto.RspBody)localObject4).uint32_download_type.get();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_JavaLangString = new String(((QPSingleUpdateProto.RspBody)localObject4).bytes_packet_url.get().toByteArray());
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_JavaLangString = new String(((QPSingleUpdateProto.RspBody)localObject4).bytes_packet_hash.get().toByteArray());
      localObject5 = BaseApplication.getContext().getSharedPreferences("qpsingleupdenginesharedpreference", 0);
      localObject6 = ((SharedPreferences)localObject5).edit();
      i = ((SharedPreferences)localObject5).getInt(this.f + "readphonenumberflag", 0);
      j = ((QPSingleUpdateProto.RspBody)localObject4).uint32_getphonenumber_flag.get();
      if (1 == (i ^ j))
      {
        ((SharedPreferences.Editor)localObject6).putInt(this.f + "whetheruploadflag", 1);
        ((SharedPreferences.Editor)localObject6).commit();
      }
      ((SharedPreferences.Editor)localObject6).putInt(this.f + "readphonenumberflag", j);
      ((SharedPreferences.Editor)localObject6).commit();
      QLog.d("QPSingleUpdEngine", 0, this.f + "readphonenumberflag = " + ((QPSingleUpdateProto.RspBody)localObject4).uint32_getphonenumber_flag.get());
      QLog.d("QPSingleUpdEngine", 0, "hit test");
      j = ((QPSingleUpdateProto.RspBody)localObject4).rpt_file_item_list.size();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.a(j);
      localObject5 = new QPSingleUpdateProto.FileItem[j];
      localObject4 = (QPSingleUpdateProto.FileItem[])((QPSingleUpdateProto.RspBody)localObject4).rpt_file_item_list.get().toArray((Object[])localObject5);
      QLog.d("QPSingleUpdEngine", 0, "hit test");
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_ArrayOfXhk[i].jdField_a_of_type_JavaLangString = new String(localObject4[i].bytes_name.get().toByteArray());
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_ArrayOfXhk[i].jdField_b_of_type_JavaLangString = new String(localObject4[i].bytes_hash.get().toByteArray());
        i += 1;
      }
      i = ((InputStream)localObject3).read();
      QLog.d("QPSingleUpdEngine", 0, "Got ETX");
      if (i != 3)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.k = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException8)
        {
          return false;
        }
      }
      localIOException8.close();
      ((InputStream)localObject3).close();
      QLog.d("QPSingleUpdEngine", 0, "Request Function Success");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.d = true;
        return true;
      }
      catch (IOException localIOException9)
      {
        return false;
      }
      return false;
    }
    catch (ConnectException localConnectException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.e = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp Connect Exception");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException10)
      {
        return false;
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.e = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp SocketTimeoutException");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException11)
      {
        return false;
      }
    }
    catch (EOFException localEOFException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.f = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp EOFException");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException12)
      {
        return false;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp InvalidProtocolBufferMicroException");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException13)
      {
        return false;
      }
    }
    catch (IOException localIOException14)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.h = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp IOException read or write Error");
      QLog.i("QPSingleUpdEngine", 0, "fuck error!!!");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException15)
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.j = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp Exception");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException16)
      {
        return false;
      }
    }
    finally
    {
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        throw ((Throwable)localObject2);
      }
      catch (IOException localIOException17) {}
    }
  }
  
  public boolean a(QPSingleUpdateProto.Head paramHead)
  {
    int i = paramHead.uint32_result.get();
    if (i == 1) {
      return true;
    }
    if (i == 2) {
      return false;
    }
    return i != 3;
  }
  
  public boolean a(QPSingleUpdateProto.RspBody paramRspBody)
  {
    return true;
  }
  
  public void b()
  {
    QLog.i("QPSingleUpdEngine", 0, "restartQQ");
    System.exit(0);
  }
  
  public boolean b()
  {
    QLog.i("QPSingleUpdEngine", 0, "Try Can Download");
    int i = 7920;
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_Int == 1) {}
    do
    {
      return true;
      while ((i > 0) && (a() != 1))
      {
        Thread.sleep(10000L);
        i -= 1;
      }
    } while (i > 0);
    return false;
  }
  
  public void c()
  {
    int i = 0;
    QLog.i("QPSingleUpdEngine", 0, "updateFileDirInit");
    Object localObject2 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    Object localObject4 = this.jdField_e_of_type_JavaLangString;
    Object localObject5 = this.jdField_e_of_type_JavaLangString + "Download";
    Object localObject3 = this.jdField_e_of_type_JavaLangString + "RollBack";
    Object localObject1 = this.jdField_e_of_type_JavaLangString + "QPLib";
    localObject2 = new File((String)localObject2);
    localObject4 = new File((String)localObject4);
    localObject5 = new File((String)localObject5);
    localObject3 = new File((String)localObject3);
    localObject1 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdir();
    }
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdir();
    }
    if (!((File)localObject5).exists()) {
      ((File)localObject5).mkdir();
    }
    for (;;)
    {
      if (!((File)localObject3).exists()) {
        ((File)localObject3).mkdir();
      }
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdir();
      }
      return;
      localObject2 = ((File)localObject5).listFiles();
      if (localObject2 != null) {
        while (i < localObject2.length)
        {
          localObject2[i].delete();
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo	Lcom/tencent/qqprotect/singleupdate/QPSinlgeUpdInfo;
    //   4: getfield 776	com/tencent/qqprotect/singleupdate/QPSinlgeUpdInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: astore_2
    //   8: new 83	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   15: aload_0
    //   16: getfield 59	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 873
    //   25: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 55
    //   30: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_1
    //   37: new 86	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 593	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_3
    //   46: aload_3
    //   47: invokevirtual 160	java/io/File:exists	()Z
    //   50: ifeq +8 -> 58
    //   53: aload_3
    //   54: invokevirtual 871	java/io/File:delete	()Z
    //   57: pop
    //   58: ldc 10
    //   60: iconst_0
    //   61: ldc_w 875
    //   64: invokestatic 824	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: new 877	java/net/URL
    //   70: dup
    //   71: ldc_w 879
    //   74: aload_2
    //   75: invokestatic 885	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   78: invokespecial 886	java/net/URL:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 890	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   84: astore_2
    //   85: ldc 10
    //   87: iconst_0
    //   88: ldc_w 892
    //   91: invokestatic 824	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: new 894	java/io/BufferedInputStream
    //   97: dup
    //   98: aload_2
    //   99: invokevirtual 897	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   102: invokespecial 900	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   105: astore_2
    //   106: ldc 10
    //   108: iconst_0
    //   109: ldc_w 902
    //   112: invokestatic 824	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: new 904	java/io/FileOutputStream
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 905	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   123: astore_1
    //   124: ldc 10
    //   126: iconst_0
    //   127: ldc_w 907
    //   130: invokestatic 824	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: sipush 512
    //   136: newarray <illegal type>
    //   138: astore_3
    //   139: aload_2
    //   140: aload_3
    //   141: iconst_0
    //   142: sipush 512
    //   145: invokevirtual 908	java/io/BufferedInputStream:read	([BII)I
    //   148: istore 4
    //   150: iload 4
    //   152: iconst_m1
    //   153: if_icmpeq +34 -> 187
    //   156: aload_1
    //   157: aload_3
    //   158: iconst_0
    //   159: iload 4
    //   161: invokevirtual 911	java/io/FileOutputStream:write	([BII)V
    //   164: goto -25 -> 139
    //   167: astore_1
    //   168: aload_0
    //   169: getfield 67	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   172: iconst_1
    //   173: putfield 914	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:m	Z
    //   176: ldc 10
    //   178: iconst_0
    //   179: ldc_w 916
    //   182: invokestatic 824	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: iconst_0
    //   186: ireturn
    //   187: aload_1
    //   188: invokevirtual 917	java/io/FileOutputStream:close	()V
    //   191: aload_2
    //   192: invokevirtual 918	java/io/BufferedInputStream:close	()V
    //   195: aload_0
    //   196: getfield 67	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   199: iconst_1
    //   200: putfield 921	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:l	Z
    //   203: ldc 10
    //   205: iconst_0
    //   206: ldc_w 923
    //   209: invokestatic 824	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_0
    //   213: getfield 67	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   216: iconst_1
    //   217: putfield 921	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:l	Z
    //   220: iconst_1
    //   221: ireturn
    //   222: astore_1
    //   223: aload_0
    //   224: getfield 67	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   227: iconst_1
    //   228: putfield 926	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:q	Z
    //   231: ldc 10
    //   233: iconst_0
    //   234: ldc_w 928
    //   237: invokestatic 824	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: goto -55 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	QPSingleUpdEngine
    //   36	121	1	localObject1	Object
    //   167	21	1	localConnectException	ConnectException
    //   222	1	1	localException	Exception
    //   7	185	2	localObject2	Object
    //   45	113	3	localObject3	Object
    //   148	12	4	i	int
    // Exception table:
    //   from	to	target	type
    //   0	58	167	java/net/ConnectException
    //   58	139	167	java/net/ConnectException
    //   139	150	167	java/net/ConnectException
    //   156	164	167	java/net/ConnectException
    //   187	220	167	java/net/ConnectException
    //   0	58	222	java/lang/Exception
    //   58	139	222	java/lang/Exception
    //   139	150	222	java/lang/Exception
    //   156	164	222	java/lang/Exception
    //   187	220	222	java/lang/Exception
  }
  
  public boolean d()
  {
    String str1 = this.jdField_e_of_type_JavaLangString + "Download/" + "TxSingleUpd.zip";
    File localFile = new File(str1);
    if (!localFile.exists())
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.s = true;
      return false;
    }
    String str2 = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_JavaLangString;
    if (a(localFile))
    {
      str1 = MD5FileUtil.a(str1);
      if (str1 == null) {}
    }
    for (;;)
    {
      if (str2.equalsIgnoreCase(str1))
      {
        QLog.i("QPSingleUpdEngine", 0, "checkDownloadFile Success");
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.r = true;
        return true;
      }
      QLog.i("QPSingleUpdEngine", 0, "checkDownloadFile Failed");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.t = true;
      return false;
      str1 = "00000000000000000000000000000000";
    }
  }
  
  public boolean e()
  {
    String str2 = null;
    QLog.i("QPSingleUpdEngine", 0, "Begin UnzipFile and get files");
    String str3 = this.jdField_e_of_type_JavaLangString + "Download/" + "TxSingleUpd.zip";
    String str4 = this.jdField_e_of_type_JavaLangString + "Download";
    QPUpdFileOperation.a(str3, str4);
    String str1 = str4 + "/SupportUpd.cfg";
    File localFile1 = new File(str1);
    if (!localFile1.exists())
    {
      QLog.i("QPSingleUpdEngine", 0, "getUpdateFile Failed");
      return false;
    }
    File localFile2 = new File(QPSupportUpdCfg.CFG_FILEPATH);
    new QPSupportUpdCfg().ReadConfigFile(str4 + "SupportUpd.cfg");
    if ((a(localFile2)) && (a(localFile1))) {
      str2 = MD5FileUtil.a(QPSupportUpdCfg.CFG_FILEPATH);
    }
    for (str1 = MD5FileUtil.a(str1);; str1 = null)
    {
      if ((str2 != null) && (str1 != null) && (!str2.equalsIgnoreCase(str1)))
      {
        QPUpdFileOperation.b(localFile2, localFile1);
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.ReadConfigFile(QPSupportUpdCfg.CFG_FILEPATH);
      }
      new File(str3).delete();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.u = true;
      return true;
    }
  }
  
  public boolean f()
  {
    int j = 0;
    QLog.i("QPSingleUpdEngine", 0, "Begin backupRollbackFile");
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem == null) {
      return true;
    }
    String str1 = this.jdField_e_of_type_JavaLangString + "RollBack/";
    Object localObject = new File(str1).listFiles();
    if (localObject != null)
    {
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    int k = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.getFileItemCount();
    int i = j;
    if (i < k)
    {
      localObject = new File(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath);
      String str2 = QPUpdFileOperation.a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath);
      if (!((File)localObject).exists()) {}
      for (;;)
      {
        i += 1;
        break;
        QPUpdFileOperation.a(new File(str1 + str2), (File)localObject);
      }
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.v = true;
    return true;
  }
  
  public boolean g()
  {
    QLog.i("QPSingleUpdEngine", 0, "roll Back !!!!!!!!!!!!!!!!!!");
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem == null) {
      return true;
    }
    File[] arrayOfFile = new File(this.jdField_e_of_type_JavaLangString + "Rollback/").listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.IsFileInConfigFile(arrayOfFile[i].getName()))
        {
          String str = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.getFileDstPath(arrayOfFile[i].getName());
          if (!TextUtils.isEmpty(str)) {
            QPUpdFileOperation.a(new File(str), arrayOfFile[i]);
          }
        }
        i += 1;
      }
      i = 0;
      while (i < arrayOfFile.length)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
    QLog.i("QPSingleUpdEngine", 0, "roll Back Success");
    return true;
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    QLog.i("QPSingleUpdEngine", 0, "Begin updateFile");
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem == null)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.B = true;
      bool1 = true;
      return bool1;
    }
    int j = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem.length;
    QLog.i("QPSingleUpdEngine", 0, "listNeedUpdateFile = " + j);
    int i = 0;
    label75:
    Object localObject2;
    Object localObject1;
    if (i < j)
    {
      localObject2 = new String(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath);
      if (QPUpdFileOperation.a((String)localObject2).equalsIgnoreCase("SupportUpd.cfg")) {}
      for (;;)
      {
        i += 1;
        break label75;
        localObject1 = this.jdField_e_of_type_JavaLangString + "Download/" + QPUpdFileOperation.a((String)localObject2);
        localObject2 = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.getFileDstPath((String)localObject2);
        bool1 = bool2;
        if (localObject2 == null) {
          break;
        }
        localObject1 = new File((String)localObject1);
        localObject2 = new File((String)localObject2);
        bool1 = bool2;
        if (!((File)localObject1).exists()) {
          break;
        }
        QPUpdFileOperation.b((File)localObject2, (File)localObject1);
      }
    }
    i = 0;
    if (i < this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem.length)
    {
      localObject1 = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath;
      if (QPUpdFileOperation.a((String)localObject1).equalsIgnoreCase("SupportUpd.cfg")) {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash = "";
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists())
        {
          this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash = "";
        }
        else
        {
          this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash = "00000000000000000000000000000000";
          if (a((File)localObject2))
          {
            localObject1 = MD5FileUtil.a((String)localObject1);
            if (localObject1 != null) {
              this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash = ((String)localObject1);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.WriteConfigFile();
    QLog.i("QPSingleUpdEngine", 0, "updateFile Success");
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.B = true;
    return true;
  }
  
  public boolean i()
  {
    QLog.i("QPSingleUpdEngine", 0, "uploadReport");
    try
    {
      QPSingleUpdateProto.Head localHead = new QPSingleUpdateProto.Head();
      Object localObject1 = new QPSingleUpdateProto.ReqBody();
      localHead.uint32_subcmd.set(1);
      a(localHead, (QPSingleUpdateProto.ReqBody)localObject1);
      this.jdField_a_of_type_JavaNetSocket = new Socket(InetAddress.getByName("qd-up.m.qq.com"), 14000);
      QLog.i("QPSingleUpdEngine", 0, "uploadReport Create Socket Success");
      OutputStream localOutputStream = this.jdField_a_of_type_JavaNetSocket.getOutputStream();
      QLog.i("QPSingleUpdEngine", 0, "uploadReport GetOutputStream Successs");
      localHead.uint32_client_ip.set(a(BaseApplication.getContext()));
      QLog.d("QPSingleUpdEngine", 0, String.valueOf(localHead.uint32_client_ip.get()));
      localHead.uint32_client_port.set(this.jdField_a_of_type_JavaNetSocket.getLocalPort());
      QPSingleUpdateProto.ReqBody localReqBody = new QPSingleUpdateProto.ReqBody();
      Object localObject2 = ByteStringMicro.copyFrom("".getBytes());
      Object localObject4 = ByteStringMicro.copyFrom("".getBytes());
      if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.a)
      {
        localReqBody.msg_report.uint32_suc.set(1);
        localObject1 = localObject4;
        if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.b)
        {
          localObject2 = ByteStringMicro.copyFrom("NotNeedtoUpdate".getBytes());
          localObject1 = localObject4;
        }
      }
      for (;;)
      {
        localReqBody.msg_report.bytes_failed_step.set((ByteStringMicro)localObject2);
        localReqBody.msg_report.bytes_failed_reason.set((ByteStringMicro)localObject1);
        localReqBody.setHasFlag(true);
        localReqBody.msg_report.setHasFlag(true);
        localObject1 = localHead.toByteArray();
        localObject2 = localReqBody.toByteArray();
        Object localObject3 = new ByteArrayOutputStream(localObject1.length + 10 + localObject2.length);
        localObject4 = new DataOutputStream((OutputStream)localObject3);
        ((ByteArrayOutputStream)localObject3).write(2);
        ((DataOutputStream)localObject4).writeInt(localObject1.length);
        ((DataOutputStream)localObject4).writeInt(localObject2.length);
        ((ByteArrayOutputStream)localObject3).write((byte[])localObject1);
        ((ByteArrayOutputStream)localObject3).write((byte[])localObject2);
        ((ByteArrayOutputStream)localObject3).write(3);
        QLog.i("QPSingleUpdEngine", 0, "uploadReport reqHeadLen = " + localObject1.length);
        ((DataOutputStream)localObject4).close();
        ((ByteArrayOutputStream)localObject3).close();
        this.jdField_a_of_type_JavaNetSocket.setSoTimeout(10000);
        localOutputStream.write(((ByteArrayOutputStream)localObject3).toByteArray());
        localOutputStream.close();
        this.jdField_a_of_type_JavaNetSocket.close();
        return true;
        if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.d)
        {
          localObject3 = ByteStringMicro.copyFrom("RequestStep".getBytes());
          if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.e)
          {
            localObject1 = ByteStringMicro.copyFrom("RequestTimeout".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.f)
          {
            localObject1 = ByteStringMicro.copyFrom("RequestNotGetRsp".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g)
          {
            localObject1 = ByteStringMicro.copyFrom("CannotResolvePackage".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.h)
          {
            localObject1 = ByteStringMicro.copyFrom("RequestIOException".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.i)
          {
            localObject1 = ByteStringMicro.copyFrom("RspNoBody".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.j)
          {
            localObject1 = ByteStringMicro.copyFrom("RequestJustException".getBytes());
            localObject2 = localObject3;
          }
          else
          {
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.k)
            {
              localObject1 = ByteStringMicro.copyFrom("RspStxOrEtxError".getBytes());
              localObject2 = localObject3;
            }
          }
        }
        else if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.l)
        {
          localObject3 = ByteStringMicro.copyFrom("DownloadStep".getBytes());
          if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.m)
          {
            localObject1 = ByteStringMicro.copyFrom("ConnectFailed".getBytes());
            localObject2 = localObject3;
          }
          else
          {
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.q)
            {
              localObject1 = ByteStringMicro.copyFrom("DownloadUnknowError".getBytes());
              localObject2 = localObject3;
            }
          }
        }
        else if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.r)
        {
          localObject3 = ByteStringMicro.copyFrom("CheckHashStep".getBytes());
          if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.s)
          {
            localObject1 = ByteStringMicro.copyFrom("CheckHashNotFindFile".getBytes());
            localObject2 = localObject3;
          }
          else
          {
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.t)
            {
              localObject1 = ByteStringMicro.copyFrom("CheckHashNotEqual".getBytes());
              localObject2 = localObject3;
            }
          }
        }
        else if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.u)
        {
          localObject2 = ByteStringMicro.copyFrom("UnZipFileStep".getBytes());
          localObject1 = ByteStringMicro.copyFrom("UnZipFileFailed".getBytes());
        }
        else if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.v)
        {
          localObject2 = ByteStringMicro.copyFrom("RollbackSaveFileStep".getBytes());
          localObject1 = ByteStringMicro.copyFrom("SaveFileFailed".getBytes());
        }
        else
        {
          localObject1 = localObject4;
          if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.B)
          {
            localObject3 = ByteStringMicro.copyFrom("UpdateStep".getBytes());
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.C)
            {
              localObject1 = ByteStringMicro.copyFrom("ReplaceFileFailed".getBytes());
              localObject2 = localObject3;
            }
          }
        }
      }
      return true;
    }
    catch (Exception localException)
    {
      QLog.i("QPSingleUpdEngine", 0, "uploadReport Exception");
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_Int == 1) {
      return true;
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.a = true;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.b = true;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qqprotect\singleupdate\QPSingleUpdEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */