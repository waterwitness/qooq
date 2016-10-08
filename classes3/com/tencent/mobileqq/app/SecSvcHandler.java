package com.tencent.mobileqq.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.device_lock_query_status.ReqBody;
import com.tencent.ims.device_lock_query_status.RspBody;
import com.tencent.ims.get_config.ReqBody;
import com.tencent.ims.get_config.RspBody;
import com.tencent.ims.wx_msg_opt.ReqBody;
import com.tencent.ims.wx_msg_opt.RspBody;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mqp.app.sec.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Apn;
import java.nio.ByteBuffer;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x614.Oidb_0x614.DeviceManageHead;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReNameDeviceNameReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReqBody;
import tencent.im.oidb.cmd0x6de.Oidb_0x6de.DevInfo;
import tencent.im.oidb.cmd0x6de.Oidb_0x6de.PhoneInfo;
import tencent.im.oidb.cmd0x6de.Oidb_0x6de.ReqBody;
import tencent.im.oidb.cmd0x6de.Oidb_0x6de.RspBody;
import tencent.im.oidb.cmd0x6df.Oidb_0x6df.DevInfo;
import tencent.im.oidb.cmd0x6df.Oidb_0x6df.PhoneInfo;
import tencent.im.oidb.cmd0x6df.Oidb_0x6df.ReqBody;
import tencent.im.oidb.cmd0x6df.Oidb_0x6df.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SecSvcHandler
  extends BusinessHandler
{
  public static final String A = "dev_info";
  public static final String B = "binding_time";
  public static final String C = "need_unify";
  public static final String D = "phone_info";
  public static final String E = "skip_url";
  public static final String F = "status";
  public static final String G = "vaskey";
  public static final String H = "ret_code";
  public static final String I = "err_msg";
  public static final int a = 0;
  public static final String a = "SecSvcHandler";
  public static final int b = 1;
  public static final String b = "SecuritySvc.GetConfig";
  public static final int c = 2;
  public static final String c = "DevLockAuthSvc.WxMsgOpt";
  public static final int d = 3;
  public static final String d = "DevLockSecSvc.DevLockQuery";
  public static final int e = 4;
  public static final String e = "OidbSvc.0x614_1";
  public static final int f = 5;
  public static final String f = "OidbSvc.0x6de";
  public static final int g = 6;
  public static final String g = "OidbSvc.0x6df";
  public static final int h = 7;
  public static final String h = "OidbSvc.0xa13";
  public static final int i = 8;
  public static final String i = "OidbSvc.0x4ad";
  public static final int j = 9;
  public static final String j = "proto_version";
  public static final int k = 1;
  public static final String k = "config_name";
  public static final String l = "config_version";
  public static final String m = "effect_time";
  public static final String n = "md5";
  public static final String o = "download_url";
  public static final String p = "cmd";
  public static final String q = "ret";
  public static final String r = "opt";
  public static final String s = "wording";
  public static final String t = "status";
  public static final String u = "wording";
  public static final String v = "sso_result";
  public static final String w = "src";
  public static final String x = "phone_type";
  public static final String y = "country_code";
  public static final String z = "phone";
  private int l;
  
  SecSvcHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.l = 1;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 0;
    int i1 = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(1, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new get_config.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = new Bundle();
        if (paramFromServiceMsg.u32_proto_version.has()) {
          i1 = paramFromServiceMsg.u32_proto_version.get();
        }
        ((Bundle)paramObject).putInt("proto_version", i1);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_config_name.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_config_name.get();
        }
        ((Bundle)paramObject).putString("config_name", paramToServiceMsg);
        if (!paramFromServiceMsg.u32_config_version.has()) {
          break label266;
        }
        i1 = paramFromServiceMsg.u32_config_version.get();
        ((Bundle)paramObject).putInt("config_version", i1);
        i1 = i2;
        if (paramFromServiceMsg.u32_effect_time.has()) {
          i1 = paramFromServiceMsg.u32_effect_time.get();
        }
        ((Bundle)paramObject).putInt("effect_time", i1);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_md5.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_md5.get();
        }
        ((Bundle)paramObject).putString("md5", paramToServiceMsg);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_download_link.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_download_link.get();
        }
        ((Bundle)paramObject).putString("download_url", paramToServiceMsg);
        a(1, true, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onGetAntiFraudConfig error:" + paramToServiceMsg.getMessage());
      return;
      label266:
      i1 = 0;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(2, false, null);
      return;
    }
    paramObject = new wx_msg_opt.RspBody();
    for (;;)
    {
      try
      {
        ((wx_msg_opt.RspBody)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (((wx_msg_opt.RspBody)paramObject).uint32_cmd.has()) {
          i1 = ((wx_msg_opt.RspBody)paramObject).uint32_cmd.get();
        }
        paramFromServiceMsg.putInt("cmd", i1);
        i1 = -1;
        if (((wx_msg_opt.RspBody)paramObject).uint32_ret.has()) {
          i1 = ((wx_msg_opt.RspBody)paramObject).uint32_ret.get();
        }
        paramFromServiceMsg.putInt("ret", i1);
        if (!((wx_msg_opt.RspBody)paramObject).uint32_opt.has()) {
          break label203;
        }
        i1 = ((wx_msg_opt.RspBody)paramObject).uint32_opt.get();
        paramFromServiceMsg.putInt("opt", i1);
        paramToServiceMsg = "";
        if (((wx_msg_opt.RspBody)paramObject).str_wording.has()) {
          paramToServiceMsg = ((wx_msg_opt.RspBody)paramObject).str_wording.get();
        }
        paramFromServiceMsg.putString("wording", paramToServiceMsg);
        a(2, true, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onWXSyncQQMsgOption error:" + paramToServiceMsg.getMessage());
      return;
      label203:
      i1 = 2;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(3, false, null);
      return;
    }
    paramObject = new device_lock_query_status.RspBody();
    for (;;)
    {
      try
      {
        ((device_lock_query_status.RspBody)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (!((device_lock_query_status.RspBody)paramObject).u32_status.has()) {
          break label179;
        }
        i1 = ((device_lock_query_status.RspBody)paramObject).u32_status.get();
        paramFromServiceMsg.putInt("status", i1);
        paramToServiceMsg = "";
        if (((device_lock_query_status.RspBody)paramObject).str_wording.has()) {
          paramToServiceMsg = ((device_lock_query_status.RspBody)paramObject).str_wording.get();
        }
        paramFromServiceMsg.putString("wording", paramToServiceMsg);
        boolean bool1 = bool2;
        if (((device_lock_query_status.RspBody)paramObject).u32_ret.has())
        {
          bool1 = bool2;
          if (((device_lock_query_status.RspBody)paramObject).u32_ret.get() == 0) {
            bool1 = true;
          }
        }
        a(3, bool1, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onQueryDevLockStatus error:" + paramToServiceMsg.getMessage());
      return;
      label179:
      int i1 = 0;
    }
  }
  
  /* Error */
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +252 -> 253
    //   4: aload_2
    //   5: invokevirtual 138	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifeq +245 -> 253
    //   11: new 260	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   14: dup
    //   15: invokespecial 261	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_2
    //   21: invokevirtual 230	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   24: invokevirtual 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: pop
    //   28: aload_3
    //   29: getfield 266	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   32: invokevirtual 269	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   35: ifeq +218 -> 253
    //   38: new 271	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody
    //   41: dup
    //   42: invokespecial 272	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_3
    //   48: getfield 266	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 275	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   57: invokevirtual 281	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_2
    //   62: getfield 285	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:msg_dm_head	Ltencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead;
    //   65: invokevirtual 288	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:has	()Z
    //   68: ifeq +185 -> 253
    //   71: aload_2
    //   72: getfield 285	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:msg_dm_head	Ltencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead;
    //   75: astore_2
    //   76: aload_2
    //   77: getfield 291	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   80: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   83: ifeq +170 -> 253
    //   86: aload_2
    //   87: getfield 291	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   90: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   93: istore 4
    //   95: iload 4
    //   97: ifne +156 -> 253
    //   100: new 154	android/os/Bundle
    //   103: dup
    //   104: invokespecial 155	android/os/Bundle:<init>	()V
    //   107: astore_3
    //   108: aload_1
    //   109: getfield 297	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   112: getstatic 301	com/tencent/mobileqq/activity/AuthDevRenameActivity:i	Ljava/lang/String;
    //   115: invokevirtual 305	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   118: istore 4
    //   120: aload_3
    //   121: getstatic 301	com/tencent/mobileqq/activity/AuthDevRenameActivity:i	Ljava/lang/String;
    //   124: iload 4
    //   126: invokevirtual 172	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   129: aload_1
    //   130: getfield 297	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   133: getstatic 307	com/tencent/mobileqq/activity/AuthDevRenameActivity:f	Ljava/lang/String;
    //   136: invokevirtual 311	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_2
    //   140: aload_3
    //   141: getstatic 307	com/tencent/mobileqq/activity/AuthDevRenameActivity:f	Ljava/lang/String;
    //   144: aload_2
    //   145: invokevirtual 188	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_1
    //   149: getfield 297	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   152: getstatic 313	com/tencent/mobileqq/activity/AuthDevRenameActivity:h	Ljava/lang/String;
    //   155: invokevirtual 317	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   158: astore_1
    //   159: aload_3
    //   160: getstatic 313	com/tencent/mobileqq/activity/AuthDevRenameActivity:h	Ljava/lang/String;
    //   163: aload_1
    //   164: invokevirtual 321	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   167: iconst_1
    //   168: istore 6
    //   170: aload_0
    //   171: iconst_4
    //   172: iload 6
    //   174: aload_3
    //   175: invokevirtual 141	com/tencent/mobileqq/app/SecSvcHandler:a	(IZLjava/lang/Object;)V
    //   178: return
    //   179: astore_2
    //   180: iconst_0
    //   181: istore 5
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: astore_3
    //   187: iload 5
    //   189: istore 6
    //   191: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq -24 -> 170
    //   197: ldc 36
    //   199: iconst_2
    //   200: new 207	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 323
    //   210: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_2
    //   214: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_1
    //   227: astore_3
    //   228: iload 5
    //   230: istore 6
    //   232: goto -62 -> 170
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_1
    //   238: iconst_1
    //   239: istore 5
    //   241: goto -56 -> 185
    //   244: astore_2
    //   245: iconst_1
    //   246: istore 5
    //   248: aload_3
    //   249: astore_1
    //   250: goto -65 -> 185
    //   253: iconst_0
    //   254: istore 6
    //   256: aconst_null
    //   257: astore_3
    //   258: goto -88 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	SecSvcHandler
    //   0	261	1	paramToServiceMsg	ToServiceMsg
    //   0	261	2	paramFromServiceMsg	FromServiceMsg
    //   0	261	3	paramObject	Object
    //   93	32	4	i1	int
    //   181	66	5	bool1	boolean
    //   168	87	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	95	179	java/lang/Exception
    //   100	108	235	java/lang/Exception
    //   108	167	244	java/lang/Exception
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 0;
    paramToServiceMsg = null;
    Oidb_0x6de.PhoneInfo localPhoneInfo = null;
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label577;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) {
          break label577;
        }
        paramFromServiceMsg = new Oidb_0x6de.RspBody();
        paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray());
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label577;
        }
        int i2 = paramFromServiceMsg.uint32_result.get();
        if (i2 != 0) {
          break label594;
        }
        bool1 = true;
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = false;
        paramToServiceMsg = localPhoneInfo;
        continue;
      }
      try
      {
        paramToServiceMsg = new Bundle();
        try
        {
          if (paramFromServiceMsg.uint32_src.has()) {
            paramToServiceMsg.putInt("src", paramFromServiceMsg.uint32_src.get());
          }
          if (paramFromServiceMsg.str_country_code.has()) {
            paramToServiceMsg.putString("country_code", paramFromServiceMsg.str_country_code.get());
          }
          if (paramFromServiceMsg.str_binding_phone.has()) {
            paramToServiceMsg.putString("phone", paramFromServiceMsg.str_binding_phone.get());
          }
          if (paramFromServiceMsg.uint32_binding_time.has()) {
            paramToServiceMsg.putInt("binding_time", paramFromServiceMsg.uint32_binding_time.get());
          }
          if (paramFromServiceMsg.uint32_need_unify.has()) {
            paramToServiceMsg.putInt("need_unify", paramFromServiceMsg.uint32_need_unify.get());
          }
          if (paramFromServiceMsg.uint32_phone_type.has()) {
            paramToServiceMsg.putInt("phone_type", paramFromServiceMsg.uint32_phone_type.get());
          }
          if (!paramFromServiceMsg.phone_info.has()) {
            continue;
          }
          paramObject = new Bundle[paramFromServiceMsg.phone_info.size()];
          if (i1 >= paramFromServiceMsg.phone_info.size()) {
            continue;
          }
          localPhoneInfo = (Oidb_0x6de.PhoneInfo)paramFromServiceMsg.phone_info.get(i1);
          if (localPhoneInfo == null) {
            break label585;
          }
          Bundle localBundle = new Bundle();
          if (localPhoneInfo.uint32_type.has()) {
            localBundle.putInt("phone_type", localPhoneInfo.uint32_type.get());
          }
          if (localPhoneInfo.str_country_code.has()) {
            localBundle.putString("country_code", localPhoneInfo.str_country_code.get());
          }
          if (localPhoneInfo.str_phone.has()) {
            localBundle.putString("phone", localPhoneInfo.str_phone.get());
          }
          if (localPhoneInfo.uint32_bu_status.has()) {
            localBundle.putInt("status", localPhoneInfo.uint32_bu_status.get());
          }
          paramObject[i1] = localBundle;
        }
        catch (Exception paramFromServiceMsg) {}
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg = localPhoneInfo;
        continue;
      }
      paramObject = paramToServiceMsg;
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onGetPhoneBindInfo error:" + paramFromServiceMsg.getMessage());
        bool2 = bool1;
        paramObject = paramToServiceMsg;
      }
      a(5, bool2, paramObject);
      return;
      paramToServiceMsg.putParcelableArray("phone_info", (Parcelable[])paramObject);
      if (paramFromServiceMsg.bytes_skip_url.has()) {
        paramToServiceMsg.putString("skip_url", paramFromServiceMsg.bytes_skip_url.get().toStringUtf8());
      }
      if (paramFromServiceMsg.bytes_vas_result.has()) {
        paramToServiceMsg.putByteArray("vaskey", paramFromServiceMsg.bytes_vas_result.get().toByteArray());
      }
      ((PhoneUnityManager)this.b.getManager(101)).a(paramToServiceMsg);
      paramObject = paramToServiceMsg;
      bool2 = bool1;
      continue;
      label577:
      bool2 = false;
      paramObject = paramToServiceMsg;
      continue;
      label585:
      i1 += 1;
      continue;
      label594:
      boolean bool1 = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 0;
    paramToServiceMsg = null;
    Oidb_0x6df.PhoneInfo localPhoneInfo = null;
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label609;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (!((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.has()) {
          break label626;
        }
        i1 = ((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get();
        if (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) {
          break label609;
        }
        paramFromServiceMsg = new Oidb_0x6df.RspBody();
        paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray());
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label609;
        }
        int i3 = paramFromServiceMsg.uint32_result.get();
        if (i3 != 0) {
          break label632;
        }
        bool1 = true;
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = false;
        paramToServiceMsg = localPhoneInfo;
        continue;
      }
      try
      {
        paramToServiceMsg = new Bundle();
        try
        {
          paramToServiceMsg.putInt("sso_result", i1);
          if (paramFromServiceMsg.uint32_src.has()) {
            paramToServiceMsg.putInt("src", paramFromServiceMsg.uint32_src.get());
          }
          if (paramFromServiceMsg.str_country_code.has()) {
            paramToServiceMsg.putString("country_code", paramFromServiceMsg.str_country_code.get());
          }
          if (paramFromServiceMsg.str_binding_phone.has()) {
            paramToServiceMsg.putString("phone", paramFromServiceMsg.str_binding_phone.get());
          }
          if (paramFromServiceMsg.uint32_binding_time.has()) {
            paramToServiceMsg.putInt("binding_time", paramFromServiceMsg.uint32_binding_time.get());
          }
          if (paramFromServiceMsg.uint32_need_unify.has()) {
            paramToServiceMsg.putInt("need_unify", paramFromServiceMsg.uint32_need_unify.get());
          }
          if (paramFromServiceMsg.uint32_phone_type.has()) {
            paramToServiceMsg.putInt("phone_type", paramFromServiceMsg.uint32_phone_type.get());
          }
          if (!paramFromServiceMsg.phone_info.has()) {
            continue;
          }
          paramObject = new Bundle[paramFromServiceMsg.phone_info.size()];
          i1 = i2;
          if (i1 >= paramFromServiceMsg.phone_info.size()) {
            continue;
          }
          localPhoneInfo = (Oidb_0x6df.PhoneInfo)paramFromServiceMsg.phone_info.get(i1);
          if (localPhoneInfo == null) {
            break label617;
          }
          Bundle localBundle = new Bundle();
          if (localPhoneInfo.uint32_type.has()) {
            localBundle.putInt("phone_type", localPhoneInfo.uint32_type.get());
          }
          if (localPhoneInfo.str_country_code.has()) {
            localBundle.putString("country_code", localPhoneInfo.str_country_code.get());
          }
          if (localPhoneInfo.str_phone.has()) {
            localBundle.putString("phone", localPhoneInfo.str_phone.get());
          }
          if (localPhoneInfo.uint32_bu_status.has()) {
            localBundle.putInt("status", localPhoneInfo.uint32_bu_status.get());
          }
          paramObject[i1] = localBundle;
        }
        catch (Exception paramFromServiceMsg) {}
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg = localPhoneInfo;
        continue;
      }
      paramObject = paramToServiceMsg;
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onSetPhoneBindInfo error:" + paramFromServiceMsg.getMessage());
        bool2 = bool1;
        paramObject = paramToServiceMsg;
      }
      a(6, bool2, paramObject);
      return;
      paramToServiceMsg.putParcelableArray("phone_info", (Parcelable[])paramObject);
      if (paramFromServiceMsg.bytes_skip_url.has()) {
        paramToServiceMsg.putString("skip_url", paramFromServiceMsg.bytes_skip_url.get().toStringUtf8());
      }
      if (paramFromServiceMsg.bytes_vas_result.has()) {
        paramToServiceMsg.putByteArray("vaskey", paramFromServiceMsg.bytes_vas_result.get().toByteArray());
      }
      ((PhoneUnityManager)this.b.getManager(101)).a(paramToServiceMsg);
      paramObject = paramToServiceMsg;
      bool2 = bool1;
      continue;
      label609:
      bool2 = false;
      paramObject = paramToServiceMsg;
      continue;
      label617:
      i1 += 1;
      continue;
      label626:
      int i1 = -1;
      continue;
      label632:
      boolean bool1 = false;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label210;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        bool2 = bool3;
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramObject)
      {
        try
        {
          if (((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.has())
          {
            bool1 = bool4;
            bool2 = bool3;
            if (((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get() == 0) {
              bool1 = true;
            }
            bool2 = bool1;
            paramFromServiceMsg.putInt("ret_code", ((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get());
          }
          paramToServiceMsg = paramFromServiceMsg;
          bool2 = bool1;
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            bool1 = bool2;
          }
        }
        try
        {
          if (((oidb_sso.OIDBSSOPkg)paramObject).str_error_msg.has())
          {
            paramFromServiceMsg.putString("err_msg", ((oidb_sso.OIDBSSOPkg)paramObject).str_error_msg.get());
            bool2 = bool1;
            paramToServiceMsg = paramFromServiceMsg;
          }
          a(7, bool2, paramToServiceMsg);
          return;
        }
        catch (Exception paramObject)
        {
          break label148;
        }
        paramObject = paramObject;
        paramFromServiceMsg = null;
        bool1 = false;
      }
      label148:
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onBindPhoneNumLogin error:" + ((Exception)paramObject).getMessage());
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = bool1;
        continue;
        label210:
        paramToServiceMsg = null;
        bool2 = false;
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label210;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        bool2 = bool3;
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramObject)
      {
        try
        {
          if (((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.has())
          {
            bool1 = bool4;
            bool2 = bool3;
            if (((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get() == 0) {
              bool1 = true;
            }
            bool2 = bool1;
            paramFromServiceMsg.putInt("ret_code", ((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get());
          }
          paramToServiceMsg = paramFromServiceMsg;
          bool2 = bool1;
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            bool1 = bool2;
          }
        }
        try
        {
          if (((oidb_sso.OIDBSSOPkg)paramObject).str_error_msg.has())
          {
            paramFromServiceMsg.putString("err_msg", ((oidb_sso.OIDBSSOPkg)paramObject).str_error_msg.get());
            bool2 = bool1;
            paramToServiceMsg = paramFromServiceMsg;
          }
          a(8, bool2, paramToServiceMsg);
          return;
        }
        catch (Exception paramObject)
        {
          break label148;
        }
        paramObject = paramObject;
        paramFromServiceMsg = null;
        bool1 = false;
      }
      label148:
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onUnbindPhoneNumLogin error:" + ((Exception)paramObject).getMessage());
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = bool1;
        continue;
        label210:
        paramToServiceMsg = null;
        bool2 = false;
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      d.e(3, d.x(), paramFromServiceMsg.getWupBuffer());
      return;
    }
    catch (Throwable paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
  
  protected Class a()
  {
    return SecSvcObserver.class;
  }
  
  public void a()
  {
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.b.getLongAccountUin());
    localReqBody.uint32_cmd.set(1);
    Object localObject = localReqBody.uint32_seq;
    int i1 = this.l;
    this.l = (i1 + 1);
    ((PBUInt32Field)localObject).set(i1);
    localReqBody.uint32_opt.set(1);
    localObject = a("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        localObject1 = new Oidb_0x6de.DevInfo();
      }
      catch (Exception localException1)
      {
        Object localObject2;
        Object localObject4;
        int i1;
        label206:
        localObject1 = null;
      }
      for (;;)
      {
        try
        {
          localObject2 = this.b.getApplication().getApplicationContext();
          ((Oidb_0x6de.DevInfo)localObject1).uint32_appid.set(AppSetting.a);
          ((Oidb_0x6de.DevInfo)localObject1).bytes_imei.set(ByteStringMicro.copyFromUtf8(DeviceInfoUtil.a()));
          ((Oidb_0x6de.DevInfo)localObject1).bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
          localObject4 = Settings.Secure.getString(((Context)localObject2).getContentResolver(), "android_id");
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            ((Oidb_0x6de.DevInfo)localObject1).bytes_androidid.set(ByteStringMicro.copyFromUtf8((String)localObject4));
          }
          localObject4 = ((Oidb_0x6de.DevInfo)localObject1).uint32_wifi;
          if (Apn.getApnType((Context)localObject2) == 3)
          {
            i1 = 1;
            ((PBUInt32Field)localObject4).set(i1);
            localObject2 = localObject1;
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          continue;
        }
        try
        {
          localObject1 = new Oidb_0x6de.ReqBody();
        }
        catch (Exception paramString2)
        {
          paramString1 = null;
          paramString2.printStackTrace();
          break label206;
        }
      }
      try
      {
        ((Oidb_0x6de.ReqBody)localObject1).uint32_src.set(paramInt1);
        ((Oidb_0x6de.ReqBody)localObject1).uint32_phone_type.set(paramInt2);
        if (!TextUtils.isEmpty(paramString1)) {
          ((Oidb_0x6de.ReqBody)localObject1).str_country_code.set(paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          ((Oidb_0x6de.ReqBody)localObject1).str_phone.set(paramString2);
        }
        paramString1 = (String)localObject1;
        if (localObject2 != null)
        {
          ((Oidb_0x6de.ReqBody)localObject1).dev_info.set((MessageMicro)localObject2);
          paramString1 = (String)localObject1;
        }
        paramString2 = new oidb_sso.OIDBSSOPkg();
        paramString2.uint32_command.set(1758);
        paramString2.uint32_service_type.set(0);
        paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
        paramString1 = new ToServiceMsg("mobileqq.service", this.b.a(), "OidbSvc.0x6de");
        paramString1.putWupBuffer(paramString2.toByteArray());
        b(paramString1);
        return;
      }
      catch (Exception paramString2)
      {
        paramString1 = (String)localObject1;
        break;
      }
      i1 = 0;
      continue;
      localException1.printStackTrace();
      localObject3 = localObject1;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        localObject1 = new Oidb_0x6df.DevInfo();
      }
      catch (Exception localException1)
      {
        Object localObject2;
        Object localObject4;
        int i1;
        label195:
        localObject1 = null;
      }
      for (;;)
      {
        try
        {
          localObject2 = this.b.getApplication().getApplicationContext();
          ((Oidb_0x6df.DevInfo)localObject1).uint32_appid.set(AppSetting.a);
          ((Oidb_0x6df.DevInfo)localObject1).bytes_imei.set(ByteStringMicro.copyFromUtf8(DeviceInfoUtil.a()));
          ((Oidb_0x6df.DevInfo)localObject1).bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
          localObject4 = Settings.Secure.getString(((Context)localObject2).getContentResolver(), "android_id");
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            ((Oidb_0x6df.DevInfo)localObject1).bytes_androidid.set(ByteStringMicro.copyFromUtf8((String)localObject4));
          }
          localObject4 = ((Oidb_0x6df.DevInfo)localObject1).uint32_wifi;
          if (Apn.getApnType((Context)localObject2) == 3)
          {
            i1 = 1;
            ((PBUInt32Field)localObject4).set(i1);
            localObject2 = localObject1;
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          continue;
        }
        try
        {
          localObject1 = new Oidb_0x6df.ReqBody();
        }
        catch (Exception paramString2)
        {
          paramString1 = null;
          paramString2.printStackTrace();
          break label195;
        }
      }
      try
      {
        ((Oidb_0x6df.ReqBody)localObject1).uint32_src.set(paramInt);
        if (!TextUtils.isEmpty(paramString1)) {
          ((Oidb_0x6df.ReqBody)localObject1).str_country_code.set(paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          ((Oidb_0x6df.ReqBody)localObject1).str_phone.set(paramString2);
        }
        paramString1 = (String)localObject1;
        if (localObject2 != null)
        {
          ((Oidb_0x6df.ReqBody)localObject1).dev_info.set((MessageMicro)localObject2);
          paramString1 = (String)localObject1;
        }
        paramString2 = new oidb_sso.OIDBSSOPkg();
        paramString2.uint32_command.set(1759);
        paramString2.uint32_service_type.set(0);
        paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
        paramString1 = new ToServiceMsg("mobileqq.service", this.b.a(), "OidbSvc.0x6df");
        paramString1.putWupBuffer(paramString2.toByteArray());
        b(paramString1);
        return;
      }
      catch (Exception paramString2)
      {
        paramString1 = (String)localObject1;
        break;
      }
      i1 = 0;
      continue;
      localException1.printStackTrace();
      localObject3 = localObject1;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    Object localObject1 = paramBundle.getString(AuthDevRenameActivity.a);
    Object localObject2 = paramBundle.getString(AuthDevRenameActivity.b);
    long l3 = paramBundle.getLong(AuthDevRenameActivity.c);
    long l4 = paramBundle.getLong(AuthDevRenameActivity.d);
    byte[] arrayOfByte2 = paramBundle.getByteArray(AuthDevRenameActivity.e);
    String str = paramBundle.getString(AuthDevRenameActivity.f);
    byte[] arrayOfByte1 = paramBundle.getByteArray(AuthDevRenameActivity.h);
    int i1 = paramBundle.getInt(AuthDevRenameActivity.i);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong((String)localObject1);
      l1 = l2;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        Oidb_0x614.ReNameDeviceNameReqBody localReNameDeviceNameReqBody;
        paramBundle.printStackTrace();
      }
    }
    paramBundle = new Oidb_0x614.DeviceManageHead();
    paramBundle.uint32_cmd.set(0);
    paramBundle.uint32_result.set(0);
    paramBundle.uint64_uin.set(l1);
    paramBundle.bytes_guid.set(ByteStringMicro.copyFrom(arrayOfByte2));
    paramBundle.uint32_appid.set((int)l3);
    paramBundle.uint32_subappid.set((int)l4);
    paramBundle.bytes_appname.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localReNameDeviceNameReqBody = new Oidb_0x614.ReNameDeviceNameReqBody();
    localReNameDeviceNameReqBody.bytes_guid.set(ByteStringMicro.copyFrom(arrayOfByte2));
    localReNameDeviceNameReqBody.uint32_appid.set((int)l3);
    localReNameDeviceNameReqBody.uint32_subappid.set((int)l4);
    localReNameDeviceNameReqBody.bytes_appname.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localReNameDeviceNameReqBody.bytes_device_des.set(ByteStringMicro.copyFrom(arrayOfByte1));
    localReNameDeviceNameReqBody.bytes_rename_device_name.set(ByteStringMicro.copyFromUtf8(str));
    localObject2 = new Oidb_0x614.ReqBody();
    ((Oidb_0x614.ReqBody)localObject2).msg_dm_head.set(paramBundle);
    ((Oidb_0x614.ReqBody)localObject2).msg_mdn_req_body.set(localReNameDeviceNameReqBody);
    paramBundle = new oidb_sso.OIDBSSOPkg();
    paramBundle.uint32_command.set(1556);
    paramBundle.uint32_service_type.set(1);
    paramBundle.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x614.ReqBody)localObject2).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "OidbSvc.0x614_1");
    ((ToServiceMsg)localObject1).putWupBuffer(paramBundle.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong(AuthDevRenameActivity.a, l1);
    ((ToServiceMsg)localObject1).extraData.putString(AuthDevRenameActivity.f, str);
    ((ToServiceMsg)localObject1).extraData.putByteArray(AuthDevRenameActivity.h, arrayOfByte1);
    ((ToServiceMsg)localObject1).extraData.putInt(AuthDevRenameActivity.i, i1);
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str.equalsIgnoreCase("SecuritySvc.GetConfig")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (str.equalsIgnoreCase("DevLockAuthSvc.WxMsgOpt"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("DevLockSecSvc.DevLockQuery"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("OidbSvc.0x614_1"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("OidbSvc.0x6de"))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("OidbSvc.0x6df"))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("OidbSvc.0xa13"))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("OidbSvc.0x4ad"))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!str.equalsIgnoreCase("MamonoSvc.Pa"));
    j(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "getAntiFraudConfig");
    }
    get_config.ReqBody localReqBody = new get_config.ReqBody();
    localReqBody.u64_uin.set(this.b.getLongAccountUin());
    localReqBody.u32_appid.set(AppSetting.a);
    localReqBody.u32_proto_version.set(1);
    PBUInt32Field localPBUInt32Field = localReqBody.u32_seq;
    int i1 = this.l;
    this.l = (i1 + 1);
    localPBUInt32Field.set(i1);
    localReqBody.str_config_name.set(paramString);
    paramString = AntiFraudConfigFileUtil.a().a(paramString, "Version");
    int i2 = 0;
    i1 = i2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i1 = Integer.parseInt(paramString);
      localReqBody.u32_config_version.set(i1);
      paramString = a("SecuritySvc.GetConfig");
      paramString.putWupBuffer(localReqBody.toByteArray());
      b(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i1 = i2;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "setWXSyncQQMsgOption");
    }
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.b.getLongAccountUin());
    localReqBody.uint32_cmd.set(2);
    Object localObject = localReqBody.uint32_seq;
    int i2 = this.l;
    this.l = (i2 + 1);
    ((PBUInt32Field)localObject).set(i2);
    localObject = localReqBody.uint32_opt;
    if (paramBoolean) {
      i1 = 1;
    }
    ((PBUInt32Field)localObject).set(i1);
    localObject = a("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      a(7, false, null);
      return;
    }
    Object localObject = ByteBuffer.allocate(paramArrayOfByte.length + 19);
    ((ByteBuffer)localObject).putShort((short)3);
    ((ByteBuffer)localObject).putInt((int)this.b.getLongAccountUin());
    ((ByteBuffer)localObject).put((byte)paramArrayOfByte.length);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    ((ByteBuffer)localObject).putShort((short)2);
    ((ByteBuffer)localObject).putShort((short)1);
    ((ByteBuffer)localObject).putShort((short)1);
    ((ByteBuffer)localObject).put((byte)0);
    ((ByteBuffer)localObject).putShort((short)2);
    ((ByteBuffer)localObject).putShort((short)1);
    ((ByteBuffer)localObject).put((byte)1);
    paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
    paramArrayOfByte.uint32_command.set(2579);
    paramArrayOfByte.uint32_service_type.set(16);
    paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = new ToServiceMsg("mobileqq.service", this.b.a(), "OidbSvc.0xa13");
    ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    device_lock_query_status.ReqBody localReqBody = new device_lock_query_status.ReqBody();
    Object localObject = localReqBody.u32_seq;
    int i1 = this.l;
    this.l = (i1 + 1);
    ((PBUInt32Field)localObject).set(i1);
    localReqBody.u32_sys_type.set(1);
    localReqBody.u32_app_id.set(AppSetting.a);
    localObject = a("DevLockSecSvc.DevLockQuery");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      a(8, false, Integer.valueOf(-1));
      return;
    }
    Object localObject = ByteBuffer.allocate(paramArrayOfByte.length + 7);
    ((ByteBuffer)localObject).putShort((short)3);
    ((ByteBuffer)localObject).putInt((int)this.b.getLongAccountUin());
    ((ByteBuffer)localObject).put((byte)paramArrayOfByte.length);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
    paramArrayOfByte.uint32_command.set(1197);
    paramArrayOfByte.uint32_service_type.set(11);
    paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = new ToServiceMsg("mobileqq.service", this.b.a(), "OidbSvc.0x4ad");
    ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
    b((ToServiceMsg)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SecSvcHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */