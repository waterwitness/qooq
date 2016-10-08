package com.tencent.device.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.SmartDeviceServlet;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import tencent.im.cs.smart_device_proxy.smart_device_proxy.CgiReq;
import tencent.im.cs.smart_device_proxy.smart_device_proxy.CommonHead;
import tencent.im.cs.smart_device_proxy.smart_device_proxy.ReqBody;

public class SmartDeviceUtil
{
  private static final String a = SmartDeviceUtil.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(DeviceInfo paramDeviceInfo)
  {
    if (paramDeviceInfo == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramDeviceInfo.remark)) {
      return paramDeviceInfo.remark;
    }
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((SmartDeviceProxyMgr)((QQAppInterface)localObject).a(51)).a(paramDeviceInfo.productId);
      if ((localObject != null) && (!TextUtils.isEmpty(((ProductInfo)localObject).deviceName))) {
        return ((ProductInfo)localObject).deviceName;
      }
    }
    if (!TextUtils.isEmpty(paramDeviceInfo.name)) {
      return paramDeviceInfo.name;
    }
    if (paramDeviceInfo.din > 0L) {
      return String.valueOf(paramDeviceInfo.din);
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, DeviceInfo paramDeviceInfo, String paramString, Bundle paramBundle)
  {
    try
    {
      paramString = new String(Base64Util.decode(paramString, 0));
      if (paramString == null) {
        return;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        for (;;)
        {
          paramString = null;
        }
        localObject = URLUtil.a(paramString);
      } while (localObject == null);
      paramString = (String)((Map)localObject).get("hash");
      String str1 = (String)((Map)localObject).get("param");
      String str2 = (String)((Map)localObject).get("script");
      Object localObject = (String)((Map)localObject).get("din");
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(paramString)) {
          localJSONObject.put("hash", URLDecoder.decode(paramString, "UTF-8"));
        }
        if (!TextUtils.isEmpty(str1)) {
          localJSONObject.put("param", URLDecoder.decode(str1, "UTF-8"));
        }
        if (!TextUtils.isEmpty(str2)) {
          localJSONObject.put("script", URLDecoder.decode(str2, "UTF-8"));
        }
        paramString = paramBundle;
        if (paramBundle == null) {
          paramString = new Bundle();
        }
        paramBundle = localJSONObject.toString();
        if (!TextUtils.isEmpty(paramBundle)) {
          paramString.putString("lightapp_init", paramBundle);
        }
        paramBundle = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
        paramQQAppInterface = paramDeviceInfo;
        if (paramDeviceInfo == null) {
          paramQQAppInterface = paramBundle.a(Long.parseLong((String)localObject));
        }
        paramBundle.a((Activity)paramContext, paramQQAppInterface, false, paramString);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        LogUtility.c(a, "jumpLightApp, Exception >>>", paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = new Bundle();
    try
    {
      String str1 = paramJSONObject.getString("summary");
      String str2 = paramJSONObject.getString("icon");
      String str3 = paramJSONObject.getString("title");
      String str4 = paramJSONObject.getString("cover");
      String str5 = paramJSONObject.getString("url");
      paramJSONObject = paramJSONObject.getString("name");
      ((Bundle)localObject).putString("detail_url", str5);
      ((Bundle)localObject).putString("image_url_remote", str4);
      ((Bundle)localObject).putString("title", str3);
      ((Bundle)localObject).putString("desc", str1);
      ((Bundle)localObject).putString("struct_share_key_content_action", "web");
      ((Bundle)localObject).putString("struct_share_key_source_icon", str2);
      ((Bundle)localObject).putString("app_name", paramJSONObject);
      ((Bundle)localObject).putString("brief_key", str3);
      paramJSONObject = (StructMsgForGeneralShare)StructMsgFactory.a((Bundle)localObject);
      localObject = (MessageForStructing)MessageRecordFactory.a(63525);
      ((MessageForStructing)localObject).msgtype = 63525;
      ((MessageForStructing)localObject).istroop = 9501;
      ((MessageForStructing)localObject).issend = 0;
      ((MessageForStructing)localObject).isread = false;
      ((MessageForStructing)localObject).selfuin = paramQQAppInterface.a();
      ((MessageForStructing)localObject).senderuin = paramString;
      ((MessageForStructing)localObject).frienduin = paramString;
      ((MessageForStructing)localObject).mIsParsed = true;
      ((MessageForStructing)localObject).structingMsg = paramJSONObject;
      ((MessageForStructing)localObject).msgData = paramJSONObject.getBytes();
      paramQQAppInterface.a().a((MessageRecord)localObject, paramQQAppInterface.a());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(String paramString1, Bundle paramBundle, int paramInt, String paramString2, AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramAppRuntime.getAccount(), "smart_device_proxy.cgi");
    paramBundle.putString("skey", ((TicketManager)paramAppRuntime.getManager(2)).getSkey(paramAppRuntime.getAccount()));
    paramBundle.putString("version", "6.5.5");
    Object localObject = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramBundle.get(str) == null) {
        return;
      }
      if (((StringBuilder)localObject).length() != 0) {
        ((StringBuilder)localObject).append("&");
      }
      ((StringBuilder)localObject).append(str).append("=").append(URLEncoder.encode(String.valueOf(paramBundle.get(str))));
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "url2=" + paramString1 + "?" + ((StringBuilder)localObject).toString());
    }
    paramBundle = new smart_device_proxy.CgiReq();
    paramBundle.str_cgiName.set(paramString1);
    paramBundle.bytes_param.set(ByteStringMicro.copyFromUtf8(((StringBuilder)localObject).toString()));
    if (!TextUtils.isEmpty(paramString2)) {
      paramBundle.bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    paramString1 = new smart_device_proxy.CommonHead();
    paramString1.uint32_uin.set(Long.parseLong(paramAppRuntime.getAccount()));
    paramString2 = new smart_device_proxy.ReqBody();
    localObject = paramString2.int32_cmd;
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((PBInt32Field)localObject).set(i);
    paramString2.msg_header.set(paramString1);
    paramString2.bytes_body.set(ByteStringMicro.copyFrom(paramBundle.toByteArray()));
    localToServiceMsg.putWupBuffer(paramString2.toByteArray());
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), SmartDeviceServlet.class);
    paramString1.putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
    paramString1.setObserver(paramBusinessObserver);
    paramAppRuntime.startServlet(paramString1);
  }
  
  public static void a(String paramString, Bundle paramBundle, AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver)
  {
    a(paramString, paramBundle, 0, null, paramAppRuntime, paramBusinessObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\utils\SmartDeviceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */