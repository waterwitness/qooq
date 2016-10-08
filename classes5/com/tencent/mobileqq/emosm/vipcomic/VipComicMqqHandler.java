package com.tencent.mobileqq.emosm.vipcomic;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.mqqcomic.MqqComicHeadPb.ComicReqHead;
import com.tencent.pb.mqqcomic.MqqComicHeadPb.ComicRspHead;
import com.tencent.pb.mqqcomic.MqqComicPb.ComicFavorEmotIcons;
import com.tencent.pb.mqqcomic.MqqComicPb.DelMyComicFavorEmotIconsReqBody;
import com.tencent.pb.mqqcomic.MqqComicPb.DelMyComicFavorEmotIconsRspBody;
import com.tencent.pb.mqqcomic.MqqComicPb.GetMyComicFavorEmotIconsReqBody;
import com.tencent.pb.mqqcomic.MqqComicPb.GetMyComicFavorEmotIconsRspBody;
import com.tencent.pb.mqqcomic.MqqComicPb.SetMyComicFavorEmotIconsReqBody;
import com.tencent.pb.mqqcomic.MqqComicPb.SetMyComicFavorEmotIconsRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.manager.TicketManager;

public class VipComicMqqHandler
  extends BusinessHandler
{
  public static int a = 100;
  public static final String a = "GetMyComicFavorEmotIcons";
  public static final int b = 1;
  public static final String b = "SetMyComicFavorEmotIcons";
  public static final int c = 2;
  public static final String c = "DelMyComicFavorEmotIcons";
  public static final String d = "ComicProtoConvSvr.tunnel";
  public static final String e = "subcmd";
  public static final String f = "requestTime";
  public static final String g = "VipComicMqqHandler";
  public static String h = "1000290";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VipComicMqqHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  public static MqqComicHeadPb.ComicReqHead a(AppInterface paramAppInterface, String paramString1, long paramLong, String paramString2)
  {
    MqqComicHeadPb.ComicReqHead localComicReqHead = new MqqComicHeadPb.ComicReqHead();
    localComicReqHead.src.set(1);
    long l = paramLong;
    if (paramLong == 0L) {
      l = NetConnInfoCenter.getServerTime();
    }
    localComicReqHead.optTs.set(l);
    localComicReqHead.os.set(2);
    PBStringField localPBStringField = localComicReqHead.clientVer;
    if (TextUtils.isEmpty("6.5.5")) {}
    for (String str = "";; str = "6.5.5")
    {
      localPBStringField.set(str);
      localComicReqHead.net.set(HttpUtil.a());
      localComicReqHead.uin.set(Long.valueOf(paramAppInterface.a()).longValue());
      str = b(paramAppInterface);
      if (!TextUtils.isEmpty(str)) {
        localComicReqHead.screenQuality.set(str);
      }
      localComicReqHead.cmd.set(paramString1);
      paramAppInterface = a(paramAppInterface);
      if (!TextUtils.isEmpty(paramAppInterface)) {
        localComicReqHead.skey.set(paramAppInterface);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localComicReqHead.etag.set(paramString2);
      }
      return localComicReqHead;
    }
  }
  
  private static String a(AppInterface paramAppInterface)
  {
    TicketManager localTicketManager = (TicketManager)paramAppInterface.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(paramAppInterface.getAccount());
    }
    return "";
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqHandler", 2, paramString);
    }
  }
  
  public static byte[] a(MqqComicHeadPb.ComicReqHead paramComicReqHead, MessageMicro paramMessageMicro)
  {
    if ((paramComicReqHead == null) || (paramMessageMicro == null)) {
      return null;
    }
    try
    {
      paramComicReqHead = paramComicReqHead.toByteArray();
      int i = paramComicReqHead.length + 4;
      paramMessageMicro = paramMessageMicro.toByteArray();
      int j = paramMessageMicro.length + 4;
      byte[] arrayOfByte = new byte[i + j];
      PkgTools.a(arrayOfByte, 0, i);
      PkgTools.a(arrayOfByte, 4, paramComicReqHead, paramComicReqHead.length);
      PkgTools.a(arrayOfByte, i, j);
      PkgTools.a(arrayOfByte, i + 4, paramMessageMicro, paramMessageMicro.length);
      return arrayOfByte;
    }
    catch (Exception paramComicReqHead)
    {
      paramComicReqHead.printStackTrace();
    }
    return null;
  }
  
  private static String b(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.a().getResources().getDisplayMetrics();
    return Math.min(paramAppInterface.widthPixels, paramAppInterface.heightPixels) + "*" + Math.max(paramAppInterface.widthPixels, paramAppInterface.heightPixels);
  }
  
  protected Class a()
  {
    return VipComicMqqObserver.class;
  }
  
  public void a()
  {
    ToServiceMsg localToServiceMsg = a("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "GetMyComicFavorEmotIcons");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    localToServiceMsg.putWupBuffer(a(a(this.b, "GetMyComicFavorEmotIcons", NetConnInfoCenter.getServerTime(), null), new MqqComicPb.GetMyComicFavorEmotIconsReqBody()));
    b(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    long l3 = paramToServiceMsg.extraData.size();
    long l2 = 0L;
    long l1 = l2;
    if (paramObject != null)
    {
      l1 = l2;
      if ((paramObject instanceof byte[])) {
        l1 = ((byte[])paramObject).length;
      }
    }
    l2 = paramToServiceMsg.extraData.getLong("requestTime");
    String str = paramToServiceMsg.extraData.getString("subcmd");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {}
    label87:
    int j;
    label517:
    do
    {
      do
      {
        break label87;
        break label87;
        break label87;
        break label87;
        for (;;)
        {
          return;
          if ("ComicProtoConvSvr.tunnel".equals(localObject))
          {
            if (!paramFromServiceMsg.isSuccess())
            {
              if ("GetMyComicFavorEmotIcons".equals(str))
              {
                a(1, true, null);
                if (!a()) {
                  break;
                }
                ReportCenter.a().a("GetMyComicFavorEmotIcons", l2, l3, l1, paramFromServiceMsg.getBusinessFailCode(), Long.valueOf(this.b.a()).longValue(), h, "[会员中心].查询我的漫图发送失败", false);
                return;
              }
              if ("SetMyComicFavorEmotIcons".equals(str))
              {
                a(7, true, null);
                if (!a()) {
                  break;
                }
                ReportCenter.a().a("SetMyComicFavorEmotIcons", l2, l3, l1, paramFromServiceMsg.getBusinessFailCode(), Long.valueOf(this.b.a()).longValue(), h, "[会员中心].设置我的漫图发送失败", false);
                return;
              }
              if (!"DelMyComicFavorEmotIcons".equals(str)) {
                break;
              }
              a(10, true, null);
              if (!a()) {
                break;
              }
              ReportCenter.a().a("DelMyComicFavorEmotIcons", l2, l3, l1, paramFromServiceMsg.getBusinessFailCode(), Long.valueOf(this.b.a()).longValue(), h, "[会员中心].删除我的漫图发送失败", false);
              return;
            }
            localObject = (byte[])paramObject;
            int i = a((byte[])localObject, 0);
            paramObject = new byte[i - 4];
            PkgTools.a((byte[])paramObject, 0, (byte[])localObject, 4, paramObject.length);
            paramFromServiceMsg = new MqqComicHeadPb.ComicRspHead();
            try
            {
              paramFromServiceMsg.mergeFrom((byte[])paramObject);
              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.retCode.has()))
              {
                j = paramFromServiceMsg.retCode.get();
                a = paramFromServiceMsg.reportRate.get();
                paramObject = null;
                if (j == 0)
                {
                  paramFromServiceMsg = new byte[a((byte[])localObject, i) - 4];
                  PkgTools.a(paramFromServiceMsg, 0, (byte[])localObject, i + 4, paramFromServiceMsg.length);
                  if (!"GetMyComicFavorEmotIcons".equals(str)) {
                    break label517;
                  }
                  a(paramFromServiceMsg, j);
                  if (!a()) {
                    continue;
                  }
                  ReportCenter.a().a("GetMyComicFavorEmotIcons", l2, l3, l1, j, Long.valueOf(this.b.a()).longValue(), h, "[会员中心].查询我的漫图成功", false);
                }
              }
            }
            catch (Exception paramFromServiceMsg)
            {
              for (;;)
              {
                a("onReceive comicRspHead mergeFrom exception:" + paramFromServiceMsg.getMessage());
                paramFromServiceMsg = null;
                continue;
                paramFromServiceMsg = (FromServiceMsg)paramObject;
                if (j > 0) {
                  paramFromServiceMsg = (FromServiceMsg)paramObject;
                }
              }
              if ("SetMyComicFavorEmotIcons".equals(str))
              {
                a(paramToServiceMsg, paramFromServiceMsg, j);
                if (!a()) {
                  continue;
                }
                ReportCenter.a().a("SetMyComicFavorEmotIcons", l2, l3, l1, j, Long.valueOf(this.b.a()).longValue(), h, "[会员中心].设置我的漫图信息成功", false);
              }
            }
          }
        }
      } while (!"DelMyComicFavorEmotIcons".equals(str));
      b(paramFromServiceMsg, j);
    } while (!a());
    ReportCenter.a().a("DelMyComicFavorEmotIcons", l2, l3, l1, j, Long.valueOf(this.b.a()).longValue(), h, "[会员中心].删除我的漫图信息成功", false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    MqqComicPb.SetMyComicFavorEmotIconsReqBody localSetMyComicFavorEmotIconsReqBody = new MqqComicPb.SetMyComicFavorEmotIconsReqBody();
    try
    {
      paramToServiceMsg = (byte[])paramToServiceMsg.getWupBuffer();
      int j = a(paramToServiceMsg, 4);
      byte[] arrayOfByte = new byte[a(paramToServiceMsg, j + 4) - 4];
      PkgTools.a(arrayOfByte, 0, paramToServiceMsg, j + 8, arrayOfByte.length);
      localSetMyComicFavorEmotIconsReqBody.mergeFrom(arrayOfByte);
      if ((localSetMyComicFavorEmotIconsReqBody != null) && (localSetMyComicFavorEmotIconsReqBody.reqs != null))
      {
        paramToServiceMsg = new ArrayList();
        while (i < localSetMyComicFavorEmotIconsReqBody.reqs.size())
        {
          paramToServiceMsg.add(((MqqComicPb.ComicFavorEmotIcons)localSetMyComicFavorEmotIconsReqBody.reqs.get(i)).md5.get());
          i += 1;
        }
        ((VipComicMqqManager)this.b.getManager(140)).a(paramToServiceMsg);
        a("responseSetMyComicFavorEmotIcons updateComicStructInfo");
      }
    }
    catch (Exception paramToServiceMsg)
    {
      try
      {
        paramToServiceMsg.mergeFrom(paramArrayOfByte);
        if (paramInt != 0) {
          break label250;
        }
        a(2, true, paramToServiceMsg);
        return;
        paramToServiceMsg = paramToServiceMsg;
        a("responseSetMyComicFavorEmotIcons exception:" + paramToServiceMsg.getMessage());
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramToServiceMsg = null;
          a("SetMyComicFavorEmotIconsRspBody mergeFrom exception : " + paramArrayOfByte.getMessage());
        }
        label250:
        a(4, true, paramToServiceMsg);
      }
    }
    paramToServiceMsg = new MqqComicPb.SetMyComicFavorEmotIconsRspBody();
  }
  
  public void a(List paramList)
  {
    ToServiceMsg localToServiceMsg = a("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "SetMyComicFavorEmotIcons");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    MqqComicHeadPb.ComicReqHead localComicReqHead = a(this.b, "SetMyComicFavorEmotIcons", NetConnInfoCenter.getServerTime(), null);
    MqqComicPb.SetMyComicFavorEmotIconsReqBody localSetMyComicFavorEmotIconsReqBody = new MqqComicPb.SetMyComicFavorEmotIconsReqBody();
    localSetMyComicFavorEmotIconsReqBody.reqs.set(paramList);
    localToServiceMsg.putWupBuffer(a(localComicReqHead, localSetMyComicFavorEmotIconsReqBody));
    b(localToServiceMsg);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new MqqComicPb.GetMyComicFavorEmotIconsRspBody();
    if (paramInt == 0)
    {
      try
      {
        ((MqqComicPb.GetMyComicFavorEmotIconsRspBody)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          a("GetMyComicFavorEmotIconsRspBody mergeFrom exception : " + paramArrayOfByte.getMessage());
          paramArrayOfByte = null;
        }
        a(2, true, paramArrayOfByte);
        return;
      }
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.rsps != null)
        {
          localObject = (VipComicMqqManager)this.b.getManager(140);
          if (localObject != null)
          {
            paramInt = 0;
            while (paramInt < paramArrayOfByte.rsps.size())
            {
              VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
              localVipComicFavorEmoStructMsgInfo.picMd5 = ((MqqComicPb.ComicFavorEmotIcons)paramArrayOfByte.rsps.get(paramInt)).md5.get();
              localVipComicFavorEmoStructMsgInfo.actionData = ((MqqComicPb.ComicFavorEmotIcons)paramArrayOfByte.rsps.get(paramInt)).info.get();
              localVipComicFavorEmoStructMsgInfo.status = 2;
              ((VipComicMqqManager)localObject).a(localVipComicFavorEmoStructMsgInfo);
              paramInt += 1;
            }
          }
        }
      }
      a(3, true, paramArrayOfByte);
      return;
    }
    a(4, true, localObject);
  }
  
  public boolean a()
  {
    int i;
    if (a < 0)
    {
      i = 0;
      if (i != 0) {
        break label35;
      }
    }
    label35:
    do
    {
      return false;
      if (a > 100)
      {
        i = 100;
        break;
      }
      i = a;
      break;
      if (i == 100) {
        return true;
      }
    } while (new Random(System.currentTimeMillis()).nextInt(100) + 1 > i);
    return true;
  }
  
  public void b(List paramList)
  {
    ToServiceMsg localToServiceMsg = a("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "DelMyComicFavorEmotIcons");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    MqqComicHeadPb.ComicReqHead localComicReqHead = a(this.b, "DelMyComicFavorEmotIcons", NetConnInfoCenter.getServerTime(), null);
    MqqComicPb.DelMyComicFavorEmotIconsReqBody localDelMyComicFavorEmotIconsReqBody = new MqqComicPb.DelMyComicFavorEmotIconsReqBody();
    localDelMyComicFavorEmotIconsReqBody.md5List.set(paramList);
    localToServiceMsg.putWupBuffer(a(localComicReqHead, localDelMyComicFavorEmotIconsReqBody));
    b(localToServiceMsg);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    MqqComicPb.DelMyComicFavorEmotIconsRspBody localDelMyComicFavorEmotIconsRspBody = new MqqComicPb.DelMyComicFavorEmotIconsRspBody();
    try
    {
      localDelMyComicFavorEmotIconsRspBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localDelMyComicFavorEmotIconsRspBody;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramArrayOfByte = null;
        a("DelMyComicFavorEmotIconsRspBody mergeFrom exception : " + localException.getMessage());
      }
      a(9, true, paramArrayOfByte);
    }
    if (paramInt == 0)
    {
      a(8, true, paramArrayOfByte);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\vipcomic\VipComicMqqHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */