package ct;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.util.Iterator;
import java.util.List;

final class ce
  extends PhoneStateListener
{
  volatile boolean a;
  final bl b;
  CellInfo c = null;
  SignalStrength d = null;
  ServiceState e = null;
  long f;
  HandlerThread g;
  Handler h;
  
  public ce(bl parambl)
  {
    this.b = parambl;
  }
  
  private void a()
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      if (this.c != null)
      {
        long l = System.currentTimeMillis();
        if (l - this.f > 2000L) {}
        for (int i = 1; i != 0; i = 0)
        {
          this.f = l;
          ck localck = ck.a(this.b, this.c);
          try
          {
            if ((this.h != null) && (localck != null))
            {
              b localb = new b(this.b);
              localb.a = localck;
              this.h.post(localb);
            }
            return;
          }
          finally {}
        }
      }
    }
  }
  
  final void a(int paramInt)
  {
    TelephonyManager localTelephonyManager = this.b.e;
    try
    {
      localTelephonyManager.listen(this, paramInt);
      return;
    }
    catch (Exception localException) {}
  }
  
  @SuppressLint({"NewApi"})
  final boolean a(CellInfo paramCellInfo)
  {
    if (paramCellInfo == null) {}
    while ((!cx.a(paramCellInfo)) || (cx.a(this.c, paramCellInfo))) {
      return false;
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  public final void onCellInfoChanged(List<CellInfo> paramList)
  {
    int k = 1;
    Object localObject = null;
    if (paramList == null)
    {
      a();
      return;
    }
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      CellInfo localCellInfo = (CellInfo)localIterator.next();
      if (!localCellInfo.isRegistered()) {
        break label173;
      }
      localObject = localCellInfo;
    }
    label69:
    label78:
    label124:
    label130:
    label168:
    label173:
    for (;;)
    {
      break;
      int i;
      int j;
      if (localObject == null)
      {
        i = 1;
        if (paramList == null) {
          break label124;
        }
        j = 1;
        if (paramList.size() <= 0) {
          break label130;
        }
        if ((j & i & k) == 0) {
          break label168;
        }
      }
      for (paramList = (CellInfo)paramList.get(0);; paramList = (List<CellInfo>)localObject)
      {
        if (a(paramList))
        {
          this.c = paramList;
          a();
          return;
          i = 0;
          break;
          j = 0;
          break label69;
          k = 0;
          break label78;
        }
        localObject = new StringBuilder("onCellInfoChanged: illegal cell or same cell ");
        if (paramList == null) {}
        for (paramList = "null cell";; paramList = paramList.toString())
        {
          ((StringBuilder)localObject).append(paramList);
          return;
        }
      }
    }
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    int j = 1;
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {}
    do
    {
      ServiceState localServiceState;
      do
      {
        return;
        localServiceState = this.e;
      } while ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState()));
      this.e = paramServiceState;
    } while (!this.a);
    int i;
    boolean bool;
    if (this.e != null) {
      if (this.e.getState() == 0)
      {
        i = 1;
        paramServiceState = this.b.e;
        bool = cx.a(this.b.a);
        if (paramServiceState == null) {
          break label171;
        }
        if (paramServiceState.getSimState() != 5) {
          break label165;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (j == 0)) {
        i = 0;
      }
      paramServiceState = new Message();
      paramServiceState.what = 12999;
      paramServiceState.arg1 = 12003;
      paramServiceState.arg2 = i;
      this.b.c(paramServiceState);
      return;
      if (this.e.getState() == 1)
      {
        i = 0;
        break;
      }
      i = -1;
      break;
      label165:
      j = 0;
      continue;
      label171:
      j = 0;
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {}
    SignalStrength localSignalStrength;
    int i;
    do
    {
      return;
      localSignalStrength = this.d;
      i = this.b.b.a;
    } while ((localSignalStrength != null) && (!cx.a(i, localSignalStrength, paramSignalStrength)));
    this.d = paramSignalStrength;
    a();
  }
  
  final class a
    extends Handler
  {
    private a(Looper paramLooper)
    {
      super();
    }
    
    @SuppressLint({"NewApi"})
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!ce.this.a) {
        return;
      }
      sendEmptyMessageDelayed(0, 20000L);
      Object localObject = null;
      TelephonyManager localTelephonyManager = ce.a(ce.this).e;
      paramMessage = (Message)localObject;
      if (localTelephonyManager != null) {}
      try
      {
        paramMessage = localTelephonyManager.getAllCellInfo();
        ce.a(ce.this, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          paramMessage = (Message)localObject;
        }
      }
      catch (Error paramMessage)
      {
        for (;;)
        {
          paramMessage = (Message)localObject;
        }
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    ck a;
    private bl b;
    
    public b(bl parambl)
    {
      this.b = parambl;
    }
    
    public final void run()
    {
      bl localbl = this.b;
      ck localck = this.a;
      if (localck != null)
      {
        localck.a(cx.c(localbl));
        localbl.c(localck);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */