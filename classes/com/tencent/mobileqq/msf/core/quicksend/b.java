package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.aa;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.e;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class b
{
  public static final String a = "attr_quick_send";
  public static final String b = "attr_quick_send_resend_time";
  public d c = new d();
  Handler d = new c(this);
  private String e = "QuickSendManager";
  private MsfCore f;
  private final int g = 1;
  private HashSet h = new HashSet();
  private ConcurrentHashMap i = new ConcurrentHashMap();
  private AtomicBoolean j = new AtomicBoolean();
  private long k;
  private volatile Handler l;
  
  public b(MsfCore paramMsfCore)
  {
    this.f = paramMsfCore;
    this.i.clear();
    paramMsfCore = new HandlerThread("MsfCoreHttpTimeoutChecker", 5);
    paramMsfCore.start();
    this.l = new Handler(paramMsfCore.getLooper());
    a();
  }
  
  private void f(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    if (!g(paramToServiceMsg))
    {
      h(paramToServiceMsg);
      return;
    }
    this.f.lightSender.a(paramToServiceMsg);
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg)
  {
    if (TextUtils.isEmpty(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.e, 1, "tryResendMsg fail, cmd is null ");
      return false;
    }
    if (!paramToServiceMsg.isNeedCallback())
    {
      QLog.d(this.e, 1, "tryResendMsg fail, request don't need callback ");
      return false;
    }
    if (this.h.contains(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.e, 1, "tryResendMsg fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by blacklist");
      return false;
    }
    if ((!paramToServiceMsg.isQuickSendEnable()) || (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) == null))
    {
      QLog.d(this.e, 1, "tryResendMsg fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by quickSendStrategy error");
      return false;
    }
    if (!this.i.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      QLog.d(this.e, 1, "tryResendMsg fail, sendQueue don't contain msg, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return false;
    }
    if (paramToServiceMsg.getAttributes().containsKey("attr_quick_send_resend_time")) {}
    for (int m = ((Integer)paramToServiceMsg.getAttributes().get("attr_quick_send_resend_time")).intValue();; m = 0)
    {
      a locala = QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy());
      if ((m < 0) || (m > locala.c))
      {
        QLog.d(this.e, 1, "tryResendMsg fail, msg has resend " + m + " times, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + m);
        return false;
      }
      paramToServiceMsg.getAttributes().put("attr_quick_send_resend_time", Integer.valueOf(m + 1));
      long l1 = locala.b;
      if (m < com.tencent.mobileqq.msf.core.a.a.aC()) {
        l1 = com.tencent.mobileqq.msf.core.a.a.aB();
      }
      long l2 = l1;
      if (com.tencent.mobileqq.msf.core.a.a.aD())
      {
        l2 = l1;
        if (m == 0) {
          l2 = locala.a - 1000L;
        }
      }
      Message localMessage = this.d.obtainMessage();
      localMessage.what = 1;
      localMessage.arg1 = paramToServiceMsg.getRequestSsoSeq();
      this.d.sendMessageDelayed(localMessage, l2);
      if (QLog.isColorLevel()) {
        QLog.d(this.e, 2, "tryResendMsg cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq() + " resendIndex: " + (m + 1) + " delayed: " + locala.b);
      }
      return true;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null) {}
    try
    {
      d(paramToServiceMsg);
      if (this.i.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
        this.i.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      }
      return;
    }
    finally
    {
      paramToServiceMsg = finally;
      throw paramToServiceMsg;
    }
  }
  
  public void a()
  {
    String[] arrayOfString = com.tencent.mobileqq.msf.core.a.a.ac();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        String str = arrayOfString[m];
        this.h.add(str);
        m += 1;
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (TextUtils.isEmpty(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.e, 1, "addQuickSendQueue fail, cmd is null ");
      return;
    }
    if (!paramToServiceMsg.isNeedCallback())
    {
      QLog.d(this.e, 1, "addQuickSendQueue fail, request don't need callback ");
      return;
    }
    if (this.h.contains(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.e, 1, "addQuickSendQueue fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by blacklist");
      return;
    }
    if ((!paramToServiceMsg.isQuickSendEnable()) || (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) == null))
    {
      QLog.d(this.e, 1, "addQuickSendQueue fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by quickSendStrategy error");
      return;
    }
    if (this.i.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      QLog.d(this.e, 1, "addQuickSendQueue fail, msg has quick send, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return;
    }
    paramToServiceMsg.getAttributes().put("attr_quick_send", Boolean.valueOf(true));
    paramToServiceMsg.getAttributes().put("light_sender_type", Integer.valueOf(1));
    paramToServiceMsg.getAttributes().put("attr_quick_send_resend_time", Integer.valueOf(0));
    this.i.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
    f(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.isQuickSendEnable())
    {
      QLog.d(this.e, 1, "onRecvNormalResp, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      h(paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {
      QLog.d(this.e, 1, "onRecvResp toMsg is null");
    }
    do
    {
      return;
      if (paramFromServiceMsg == null)
      {
        QLog.d(this.e, 1, "onRecvResp quicksend fail, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " fromMsg is null");
        return;
      }
      if (paramFromServiceMsg.isSuccess()) {
        break;
      }
      QLog.d(this.e, 1, "onRecvResp quicksend fail, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " code: " + paramFromServiceMsg.getBusinessFailCode() + " failmsg: " + paramFromServiceMsg.getBusinessFailMsg());
    } while (paramFromServiceMsg.getBusinessFailCode() != 2901);
    h(paramToServiceMsg);
    return;
    if (this.i.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
      QLog.d(this.e, 1, "onRecvResp quicksend succ, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
    }
    for (;;)
    {
      try
      {
        aa.a(paramToServiceMsg, paramFromServiceMsg, true);
        if (com.tencent.mobileqq.msf.core.a.a.aD())
        {
          if (paramInt != 1) {
            continue;
          }
          bool = true;
          com.tencent.mobileqq.a.a.a.a(paramToServiceMsg, paramFromServiceMsg, bool);
        }
        if ((this.f.quicksender != null) && (this.f.quicksender.b(paramToServiceMsg))) {
          this.f.quicksender.c.b(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        localException.printStackTrace();
        continue;
      }
      h(paramToServiceMsg);
      paramFromServiceMsg.getAttributes().put("_attr_send_by_quickHttp", Boolean.valueOf(true));
      paramFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
      paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
      paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
      this.f.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
      QLog.d(this.e, 1, "onRecvResp quicksend succ occurred 2901, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      continue;
      bool = false;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    long l2 = 0L;
    boolean bool = false;
    long l1 = l2;
    if (paramToServiceMsg != null)
    {
      l1 = l2;
      if (paramToServiceMsg.getAttributes().containsKey("quickSendDetectTime"))
      {
        long l3 = ((Long)paramToServiceMsg.getAttributes().get("quickSendDetectTime")).longValue();
        l1 = l2;
        if (l3 > 0L) {
          l1 = SystemClock.elapsedRealtime() - l3;
        }
      }
    }
    int m;
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.e, 2, "handleQuickHeartbeat wait " + paramToServiceMsg + " timeout.");
      }
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.e, 2, "new conn has created, stop quick detectind");
        }
        this.j.set(false);
        m = 3;
        paramBoolean = bool;
        if (this.f.statReporter != null)
        {
          paramToServiceMsg = new HashMap();
          if (this.f.getAccountCenter() == null) {
            break label494;
          }
          paramToServiceMsg.put("account", this.f.getAccountCenter().i());
        }
      }
    }
    for (;;)
    {
      paramToServiceMsg.put("closeType", "" + m);
      this.f.statReporter.a("dim.Msf.QuickSendDetect", paramBoolean, l1, 0L, paramToServiceMsg, false, false);
      return;
      if (!this.f.sender.a.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.e, 2, "conn is also closed, stop quick detecting");
        }
        this.j.set(false);
        m = 1;
        paramBoolean = bool;
        break;
      }
      l2 = SystemClock.elapsedRealtime();
      if (l2 > this.k + com.tencent.mobileqq.msf.core.a.a.F())
      {
        this.k = l2;
        try
        {
          QLog.d(this.e, 1, "handleQuickHeartbeat disconn: " + System.currentTimeMillis() + " mLastDetectDisconnTime:" + l2);
          this.f.sender.a.a(com.tencent.qphone.base.a.A);
          m = 2;
          this.j.set(false);
          paramBoolean = bool;
          break;
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.d(this.e, 1, "handleQuickHeartbeat disconn error", paramToServiceMsg);
          this.j.set(false);
          m = 0;
          paramBoolean = bool;
          break;
        }
        finally
        {
          this.j.set(false);
        }
      }
      this.j.set(false);
      QLog.d(this.e, 1, "handleQuickHeartbeat stop disconn by too frequency.");
      m = 0;
      paramBoolean = bool;
      break;
      QLog.d(this.e, 1, "recv Quick heart resp.now conn is alive.");
      this.j.set(false);
      paramBoolean = true;
      m = 0;
      break;
      label494:
      paramToServiceMsg.put("account", this.f.sender.e());
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.i.contains(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    if (this.j.get())
    {
      QLog.d(this.e, 1, "quick heart beat has sending, return.");
      return;
    }
    if (this.f.sender.a.b())
    {
      this.j.set(true);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Ping");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_QuickHeartBeat);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.f.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.E());
      localToServiceMsg.getAttributes().put("quickSendDetectTime", Long.valueOf(SystemClock.elapsedRealtime()));
      this.f.sender.a(localToServiceMsg);
      return;
    }
    this.j.set(false);
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return false;
      if (e(paramToServiceMsg)) {
        paramToServiceMsg.setQuickSend(true, 1);
      }
    } while ((this.h.contains(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.isQuickSendEnable()) || (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) == null));
    return true;
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    a locala;
    a locala1;
    if (paramToServiceMsg != null)
    {
      locala = QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy());
      if ((locala != null) && (locala.a >= 1000L))
      {
        locala1 = new a(paramToServiceMsg);
        if (!com.tencent.mobileqq.msf.core.a.a.aD()) {
          break label68;
        }
        this.l.postDelayed(locala1, 1000L);
      }
    }
    for (;;)
    {
      paramToServiceMsg.getAttributes().put("to_msgtimeoutCallbacker", locala1);
      return;
      label68:
      this.l.postDelayed(locala1, locala.a);
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().containsKey("to_msgtimeoutCallbacker")))
    {
      QLog.d(this.e, 1, "remove timoutchecker for msg");
      Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().get("to_msgtimeoutCallbacker");
      this.l.removeCallbacks(localRunnable);
      paramToServiceMsg.getAttributes().remove("to_msgtimeoutCallbacker");
    }
  }
  
  public boolean e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return false;
          localObject = paramToServiceMsg.getServiceCmd();
        } while ((!"MessageSvc.PbSendMsg".equals(localObject)) && (!"ImgStore.GroupPicUp".equals(localObject)) && (!"ImgStore.GroupPicDown".equals(localObject)) && (!"LongConn.OffPicUp".equals(localObject)) && (!"LongConn.OffPicDown".equals(localObject)));
        localObject = QuickSendStrategy.getStragegyArgs(1);
      } while (localObject == null);
      if (((a)localObject).a >= paramToServiceMsg.getTimeout()) {
        break;
      }
    } while (("MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())) && (!paramToServiceMsg.getAttributes().containsKey("normal_msg")));
    return true;
    QLog.d(this.e, 1, "no try quicksend request ssoseq: " + paramToServiceMsg.getRequestSsoSeq() + " by timeout error");
    return false;
  }
  
  class a
    implements Runnable
  {
    private ToServiceMsg b;
    
    public a(ToServiceMsg paramToServiceMsg)
    {
      this.b = paramToServiceMsg;
    }
    
    public void run()
    {
      if (this.b == null) {
        QLog.d(b.b(b.this), 1, "req null, return.");
      }
      for (;;)
      {
        return;
        try
        {
          if ((b.c(b.this).quicksender != null) && (b.c(b.this).quicksender.b(this.b))) {
            b.c(b.this).quicksender.c.b(this.b);
          }
          b.this.a(this.b);
          a locala = QuickSendStrategy.getStragegyArgs(this.b.getQuickSendStrategy());
          if ((com.tencent.mobileqq.msf.core.a.a.bl()) && (locala != null) && (locala.d)) {
            b.this.b();
          }
          if ((!com.tencent.mobileqq.msf.core.a.a.aD()) || (!this.b.getServiceCmd().equals("MessageSvc.PbSendMsg"))) {
            continue;
          }
          com.tencent.mobileqq.a.a.a.a(this.b);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\quicksend\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */