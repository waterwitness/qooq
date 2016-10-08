package ct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

final class bv
  extends PhoneStateListener
{
  volatile boolean a;
  final bl b;
  CellLocation c = null;
  SignalStrength d = null;
  ServiceState e = null;
  long f;
  HandlerThread g;
  Handler h;
  
  public bv(bl parambl)
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
          ck localck = ck.a(this.b, this.c, this.d);
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
  
  final boolean a(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return false;
    }
    try
    {
      GsmCellLocation localGsmCellLocation = (GsmCellLocation)paramCellLocation;
      if (localGsmCellLocation.getCid() == 0)
      {
        int i = localGsmCellLocation.getLac();
        if (i == 0) {
          return false;
        }
      }
    }
    catch (ClassCastException localClassCastException)
    {
      if (cx.a(paramCellLocation) < 0) {
        return false;
      }
      if (cx.a(this.c, paramCellLocation)) {
        return false;
      }
      paramCellLocation = ck.a(this.b, paramCellLocation, null);
      if (paramCellLocation == null) {}
      for (boolean bool = true; bool; bool = cx.a(paramCellLocation)) {
        return true;
      }
    }
    return false;
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    if (a(paramCellLocation))
    {
      this.c = paramCellLocation;
      a();
      return;
    }
    new StringBuilder("onCellLocationChanged: illegal cell or same cell ").append(paramCellLocation);
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
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!bv.this.a) {
        return;
      }
      sendEmptyMessageDelayed(0, 20000L);
      paramMessage = cx.b(bv.a(bv.this));
      bv.a(bv.this, paramMessage);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */