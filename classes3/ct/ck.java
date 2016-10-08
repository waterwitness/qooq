package ct;

import android.annotation.SuppressLint;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class ck
  extends cn
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = Integer.MAX_VALUE;
  public int h = Integer.MAX_VALUE;
  private final long i = System.currentTimeMillis();
  private List<NeighboringCellInfo> j;
  
  @SuppressLint({"NewApi"})
  @Nullable
  public static ck a(bl parambl, CellInfo paramCellInfo)
  {
    int k = -88;
    Object localObject;
    if ((!parambl.a()) || (paramCellInfo == null)) {
      localObject = null;
    }
    ck localck;
    for (;;)
    {
      return (ck)localObject;
      TelephonyManager localTelephonyManager = parambl.e;
      localck = new ck();
      if ((paramCellInfo instanceof CellInfoCdma)) {}
      try
      {
        paramCellInfo = (CellInfoCdma)paramCellInfo;
        localObject = paramCellInfo.getCellIdentity();
        localck.a = 2;
        localck.a(parambl, localTelephonyManager);
        localck.c = ((CellIdentityCdma)localObject).getSystemId();
        localck.d = ((CellIdentityCdma)localObject).getNetworkId();
        localck.e = ((CellIdentityCdma)localObject).getBasestationId();
        localck.g = ((CellIdentityCdma)localObject).getLatitude();
        localck.h = ((CellIdentityCdma)localObject).getLongitude();
        n = paramCellInfo.getCellSignalStrength().getDbm();
        m = k;
        if (n > -110)
        {
          m = k;
          if (n < -40) {
            m = n;
          }
        }
        localck.f = m;
        return localck;
      }
      catch (Exception parambl)
      {
        int n;
        int m;
        return localck;
        if ((paramCellInfo instanceof CellInfoGsm)) {}
        try
        {
          paramCellInfo = (CellInfoGsm)paramCellInfo;
          localck.a = 1;
          localObject = paramCellInfo.getCellIdentity();
          localck.a(parambl, localTelephonyManager);
          localck.d = ((CellIdentityGsm)localObject).getLac();
          localck.e = ((CellIdentityGsm)localObject).getCid();
          localck.b = ((CellIdentityGsm)localObject).getMcc();
          localck.c = ((CellIdentityGsm)localObject).getMnc();
          n = paramCellInfo.getCellSignalStrength().getDbm();
          m = k;
          if (n > -110)
          {
            m = k;
            if (n < -40) {
              m = n;
            }
          }
          localck.f = m;
          return localck;
        }
        catch (Exception parambl)
        {
          return localck;
          if ((paramCellInfo instanceof CellInfoWcdma)) {}
          try
          {
            paramCellInfo = (CellInfoWcdma)paramCellInfo;
            localck.a = 1;
            localObject = paramCellInfo.getCellIdentity();
            localck.a(parambl, localTelephonyManager);
            localck.d = ((CellIdentityWcdma)localObject).getLac();
            localck.e = ((CellIdentityWcdma)localObject).getCid();
            localck.b = ((CellIdentityWcdma)localObject).getMcc();
            localck.c = ((CellIdentityWcdma)localObject).getMnc();
            n = paramCellInfo.getCellSignalStrength().getDbm();
            m = k;
            if (n > -110)
            {
              m = k;
              if (n < -40) {
                m = n;
              }
            }
            localck.f = m;
            return localck;
          }
          catch (Exception parambl)
          {
            return localck;
            localObject = localck;
            if ((paramCellInfo instanceof CellInfoLte))
            {
              try
              {
                paramCellInfo = (CellInfoLte)paramCellInfo;
                localck.a = 1;
                localObject = paramCellInfo.getCellIdentity();
                localck.a(parambl, localTelephonyManager);
                localck.d = ((CellIdentityLte)localObject).getTac();
                localck.e = ((CellIdentityLte)localObject).getCi();
                localck.b = ((CellIdentityLte)localObject).getMcc();
                localck.c = ((CellIdentityLte)localObject).getMnc();
                k = paramCellInfo.getCellSignalStrength().getDbm();
                if ((k <= -110) || (k >= -40)) {
                  break label459;
                }
              }
              catch (Exception parambl)
              {
                for (;;)
                {
                  return localck;
                  k = -88;
                }
              }
              catch (Error parambl)
              {
                return localck;
              }
              localck.f = k;
              return localck;
            }
          }
          catch (Error parambl)
          {
            return localck;
          }
        }
        catch (Error parambl)
        {
          label459:
          return localck;
        }
      }
      catch (Error parambl) {}
    }
    return localck;
  }
  
  @Nullable
  public static ck a(bl parambl, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    if ((!parambl.a()) || (paramCellLocation == null)) {
      return null;
    }
    TelephonyManager localTelephonyManager = parambl.e;
    ck localck = new ck();
    if ((paramCellLocation instanceof CdmaCellLocation)) {}
    try
    {
      paramCellLocation = (CdmaCellLocation)paramCellLocation;
      localck.a = 2;
      localck.a(parambl, localTelephonyManager);
      localck.c = paramCellLocation.getSystemId();
      localck.d = paramCellLocation.getNetworkId();
      localck.e = paramCellLocation.getBaseStationId();
      localck.g = paramCellLocation.getBaseStationLatitude();
      localck.h = paramCellLocation.getBaseStationLongitude();
      if (paramSignalStrength == null)
      {
        localck.f = -1;
        return localck;
      }
      localck.f = paramSignalStrength.getCdmaDbm();
      return localck;
    }
    catch (Exception parambl)
    {
      try
      {
        paramCellLocation = (GsmCellLocation)paramCellLocation;
        localck.a = 1;
        localck.a(parambl, localTelephonyManager);
        localck.d = paramCellLocation.getLac();
        localck.e = paramCellLocation.getCid();
        if (paramSignalStrength == null)
        {
          localck.f = -1;
          return localck;
        }
        localck.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
        return localck;
      }
      catch (Exception parambl) {}
      parambl = parambl;
      return localck;
    }
    return localck;
  }
  
  private void a(bl parambl, TelephonyManager paramTelephonyManager)
  {
    parambl = parambl.b;
    int k = parambl.j;
    int m = parambl.k;
    if ((k > 0) && (m >= 0))
    {
      this.b = k;
      this.c = m;
      return;
    }
    int[] arrayOfInt = new int[2];
    cx.a(paramTelephonyManager, arrayOfInt);
    parambl.j = arrayOfInt[0];
    parambl.k = arrayOfInt[1];
  }
  
  @NonNull
  public final List<NeighboringCellInfo> a()
  {
    try
    {
      if (this.j == null) {
        this.j = Collections.emptyList();
      }
      List localList = this.j;
      return localList;
    }
    finally {}
  }
  
  public final void a(@Nullable List<NeighboringCellInfo> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        this.j = Collections.unmodifiableList(paramList);
        return;
      }
      finally {}
      this.j = Collections.emptyList();
    }
  }
  
  public final String toString()
  {
    return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */