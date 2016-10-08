package com.tencent.biz.TroopRedpoint;

import android.content.SharedPreferences;
import android.widget.Toast;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hfq;
import hfr;
import hfs;
import hft;
import hfu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotOpt;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RspBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.SetRedDotOpt;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x69.Submsgtype0x69;

public class TroopRedTouchHandler
  extends BusinessHandler
{
  public static final int a = 105;
  static final String a = "TroopRedTouchHandler";
  static final String b = "OidbSvc.0x791";
  protected BusinessObserver a;
  
  public TroopRedTouchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new hfu(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopRedTouchHandler", 4, "**testPushRedPointInfo type:" + paramInt);
    }
    oidb_0x791.RedDotInfo localRedDotInfo = new oidb_0x791.RedDotInfo();
    localRedDotInfo.bool_display_reddot.set(true);
    switch (paramInt)
    {
    default: 
      if (paramInt == 4) {
        localRedDotInfo.uint32_number.set(111);
      }
      break;
    }
    for (;;)
    {
      if (paramInt > 1) {
        localRedDotInfo.uint64_cmd_uin.set(1125526550L);
      }
      if (paramInt == 3) {
        localRedDotInfo.str_face_url.set(ByteStringMicro.copyFromUtf8("http://www.baidu.com/img/bdlogo.png"));
      }
      ((TroopRedTouchManager)paramQQAppInterface.getManager(69)).a(localRedDotInfo);
      return;
      localRedDotInfo.uint32_appid.set(6);
      break;
      localRedDotInfo.uint32_appid.set(1);
      break;
      localRedDotInfo.uint32_appid.set(1);
      break;
      localRedDotInfo.uint32_appid.set(7);
      break;
      if (paramInt == 5) {
        localRedDotInfo.uint32_number.set(99);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.b().post(new hft(paramQQAppInterface, paramLong));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramQQAppInterface == null) || (paramRedDotInfo == null)) {}
    TroopRedTouchManager localTroopRedTouchManager;
    do
    {
      return;
      localTroopRedTouchManager = (TroopRedTouchManager)paramQQAppInterface.getManager(69);
    } while ((localTroopRedTouchManager == null) || (paramRedDotInfo == null));
    paramRedDotInfo.bool_display_reddot.set(false);
    localTroopRedTouchManager.a(paramRedDotInfo);
    ((TroopRedTouchHandler)paramQQAppInterface.a(43)).a(paramRedDotInfo);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramQQAppInterface != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = new Submsgtype0x69();
        ((Submsgtype0x69)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new oidb_0x791.RedDotInfo();
        paramArrayOfByte.uint32_appid.set(((Submsgtype0x69)localObject).uint32_appid.get());
        paramArrayOfByte.bool_display_reddot.set(((Submsgtype0x69)localObject).bool_display_reddot.get());
        paramArrayOfByte.uint32_number.set(((Submsgtype0x69)localObject).uint32_number.get());
        paramArrayOfByte.uint32_reason.set(((Submsgtype0x69)localObject).uint32_reason.get());
        paramArrayOfByte.uint32_last_time.set(((Submsgtype0x69)localObject).uint32_last_time.get());
        paramArrayOfByte.uint64_cmd_uin.set(((Submsgtype0x69)localObject).uint64_cmd_uin.get());
        paramArrayOfByte.str_face_url.set(((Submsgtype0x69)localObject).str_face_url.get());
        paramArrayOfByte.str_custom_buffer.set(((Submsgtype0x69)localObject).bytes_custom_buffer.get());
        paramArrayOfByte.uint32_expire_time.set(((Submsgtype0x69)localObject).uint32_expire_time.get());
        paramQQAppInterface = (TroopRedTouchManager)paramQQAppInterface.getManager(69);
        if (TroopRedTouchConfigure.a(paramArrayOfByte.uint32_appid.get())) {
          if (paramArrayOfByte.bool_display_reddot.get())
          {
            localObject = (StoryConfigManager)SuperManager.a(10);
            long l1 = NetConnInfoCenter.getServerTimeMillis();
            long l2 = ((StoryConfigManager)localObject).a();
            if (l1 < l2)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "故事红点下发到达时间：" + l1 + "小于最近更新刷新时间：" + l2 + TroopRedTouchManager.a(paramArrayOfByte));
              return false;
            }
          }
          else
          {
            localObject = paramQQAppInterface.a();
            if ((localObject == null) || (((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.get() != paramArrayOfByte.uint64_cmd_uin.get()) || (((oidb_0x791.RedDotInfo)localObject).uint32_last_time.get() != paramArrayOfByte.uint32_last_time.get())) {
              break;
            }
          }
        }
        paramQQAppInterface.a(paramArrayOfByte);
        bool3 = true;
        boolean bool2 = true;
        bool1 = bool2;
        paramQQAppInterface.printStackTrace();
      }
      catch (Exception paramQQAppInterface)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "parsePushRedPointInfo:" + TroopRedTouchManager.a(paramArrayOfByte));
            bool1 = bool2;
          }
          return bool1;
        }
        catch (Exception paramQQAppInterface)
        {
          for (;;)
          {
            boolean bool3;
            bool1 = bool3;
          }
        }
        paramQQAppInterface = paramQQAppInterface;
        bool1 = false;
      }
      continue;
      boolean bool1 = false;
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopRedTouchHandler", 4, "**testPushRedPointInfo appid:" + paramInt);
    }
    oidb_0x791.RedDotInfo localRedDotInfo = new oidb_0x791.RedDotInfo();
    localRedDotInfo.bool_display_reddot.set(true);
    localRedDotInfo.uint32_appid.set(paramInt);
    String str = "";
    if (paramInt == 10)
    {
      localRedDotInfo.uint32_number.set(10);
      str = "数字红点";
    }
    if (paramInt == 8) {
      str = "系统红点";
    }
    if (paramInt == 10) {
      localRedDotInfo.uint64_cmd_uin.set(1125526550L);
    }
    if (9 == paramInt)
    {
      str = "头像红点";
      localRedDotInfo.uint64_cmd_uin.set(1125526550L);
      localRedDotInfo.str_face_url.set(ByteStringMicro.copyFromUtf8("http://www.baidu.com/img/bdlogo.png"));
    }
    if (11 == paramInt)
    {
      str = "文字红点";
      localRedDotInfo.str_custom_buffer.set(ByteStringMicro.copyFromUtf8("新日迹"));
    }
    Toast.makeText(paramQQAppInterface.a().getApplicationContext(), "测试红点类型：" + str, 0).show();
    paramQQAppInterface = (TroopRedTouchManager)paramQQAppInterface.getManager(69);
    paramQQAppInterface.a();
    paramQQAppInterface.a(localRedDotInfo);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
      if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
      {
        a(paramQQAppInterface, 120L);
        return;
      }
      paramArrayOfByte = new oidb_0x791.RspBody();
      paramArrayOfByte.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramArrayOfByte = (oidb_0x791.GetRedDotRes)paramArrayOfByte.msg_get_reddot_res.get();
      if (paramArrayOfByte != null)
      {
        a(paramQQAppInterface, paramArrayOfByte.uint32_interval.get());
        ((TroopRedTouchManager)paramQQAppInterface.getManager(69)).a(paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  private void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopRedTouchHandler", 4, "getRedPointInfo() start getRedPointInfoAsync");
    }
    Object localObject1 = this.b.getApplication().getSharedPreferences(this.b.a() + "RedTouchExManager_GetTime", 0);
    long l1 = ((SharedPreferences)localObject1).getLong("last_get_time", 0L);
    long l2 = ((SharedPreferences)localObject1).getLong("interval_time", 0L);
    if (Math.abs(System.currentTimeMillis() / 1000L - l1) < l2) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopRedTouchHandler", 4, "getRedPointInfo() start");
    }
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(Integer.valueOf(1));
    ((List)localObject2).add(Integer.valueOf(6));
    ((List)localObject2).add(Integer.valueOf(7));
    ((List)localObject2).add(Integer.valueOf(8));
    ((List)localObject2).add(Integer.valueOf(9));
    ((List)localObject2).add(Integer.valueOf(10));
    ((List)localObject2).add(Integer.valueOf(11));
    localObject1 = new oidb_0x791.GetRedDotOpt();
    ((oidb_0x791.GetRedDotOpt)localObject1).uint64_uin.set(Long.parseLong(this.b.a()));
    ((oidb_0x791.GetRedDotOpt)localObject1).rpt_uint32_appid.addAll((Collection)localObject2);
    localObject2 = new oidb_0x791.ReqBody();
    ((oidb_0x791.ReqBody)localObject2).msg_get_reddot.set((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1937);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
    localObject2 = new NewIntent(this.b.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject2).setWithouLogin(true);
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x791_0");
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((NewIntent)localObject2).setObserver(new hfr(this));
    this.b.startServlet((NewIntent)localObject2);
  }
  
  protected Class a()
  {
    return GetRedPointExObserver.class;
  }
  
  public void a()
  {
    ThreadManager.a(new hfq(this), 5, null, true);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return;
    }
    Object localObject1 = new oidb_0x791.SetRedDotOpt();
    ((oidb_0x791.SetRedDotOpt)localObject1).uint64_cmd_uin.set(Long.parseLong(this.b.a()));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.b.a())));
    ((oidb_0x791.SetRedDotOpt)localObject1).rpt_uint64_uin.set((List)localObject2);
    ((oidb_0x791.SetRedDotOpt)localObject1).bool_clear.set(true);
    ((oidb_0x791.SetRedDotOpt)localObject1).bool_push_to_client.set(false);
    localObject2 = new oidb_0x791.ReqBody();
    ((oidb_0x791.ReqBody)localObject2).msg_set_reddot.set((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1937);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(paramRedDotInfo.uint32_appid.get());
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
    localObject2 = new NewIntent(this.b.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x791_" + String.valueOf(paramRedDotInfo.uint32_appid.get()));
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((NewIntent)localObject2).setObserver(new hfs(this));
    this.b.startServlet((NewIntent)localObject2);
  }
  
  public void b()
  {
    this.b.a(this.a);
  }
  
  public void c()
  {
    this.b.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\TroopRedpoint\TroopRedTouchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */