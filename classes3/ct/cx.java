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
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;

public final class cx
{
  public static boolean a = false;
  
  public static int a(CellLocation paramCellLocation)
  {
    if ((paramCellLocation instanceof CdmaCellLocation)) {
      return ((CdmaCellLocation)paramCellLocation).getBaseStationId();
    }
    try
    {
      int i = ((GsmCellLocation)paramCellLocation).getCid();
      return i;
    }
    catch (Exception paramCellLocation) {}
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  public static CellInfo a(bl parambl)
  {
    try
    {
      parambl = parambl.e;
      if (parambl == null) {
        break label95;
      }
      localList = parambl.getAllCellInfo();
      if (localList == null) {
        break label104;
      }
      localIterator = localList.iterator();
      parambl = null;
    }
    catch (Error parambl)
    {
      List localList;
      Iterator localIterator;
      Object localObject;
      return null;
    }
    catch (Exception parambl)
    {
      label95:
      label104:
      label109:
      for (;;)
      {
        continue;
        break label109;
        parambl = null;
        continue;
      }
    }
    if (localIterator.hasNext())
    {
      localObject = (CellInfo)localIterator.next();
      if (((CellInfo)localObject).isRegistered())
      {
        parambl = (bl)localObject;
        break label109;
        localObject = parambl;
        if (parambl == null)
        {
          localObject = parambl;
          if (localList != null)
          {
            localObject = parambl;
            if (localList.size() > 0) {
              localObject = (CellInfo)localList.get(0);
            }
          }
        }
        return (CellInfo)localObject;
      }
    }
  }
  
  public static void a(@NonNull TelephonyManager paramTelephonyManager, @NonNull int[] paramArrayOfInt)
  {
    paramTelephonyManager = paramTelephonyManager.getNetworkOperator();
    if ((paramTelephonyManager != null) && (paramTelephonyManager.length() >= 5)) {}
    try
    {
      paramArrayOfInt[0] = Integer.parseInt(paramTelephonyManager.substring(0, 3));
      paramArrayOfInt[1] = Integer.parseInt(paramTelephonyManager.substring(3, 5));
      return;
    }
    catch (NumberFormatException paramTelephonyManager)
    {
      Arrays.fill(paramArrayOfInt, 0);
      return;
    }
    catch (IndexOutOfBoundsException paramTelephonyManager)
    {
      for (;;) {}
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool2 = true;
    boolean bool1;
    if (b(paramInt1)) {
      if ((paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 >= 0) && (paramInt4 <= 65535) && (paramInt5 >= 0) && (paramInt5 <= 65535))
      {
        bool1 = bool2;
        if (paramInt3 == 0)
        {
          bool1 = bool2;
          if (paramInt4 == 0)
          {
            bool1 = bool2;
            if (paramInt5 != 0) {}
          }
        }
      }
      else
      {
        bool1 = false;
      }
    }
    do
    {
      return bool1;
      if ((paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 <= 0) || (paramInt4 >= 65535)) {
        return false;
      }
      if ((paramInt5 == 268435455) || (paramInt5 == Integer.MAX_VALUE) || (paramInt5 == 50594049) || (paramInt5 == 65535) || (paramInt5 <= 0)) {
        return false;
      }
      if (paramInt5 == 65535) {
        break;
      }
      bool1 = bool2;
    } while (paramInt5 > 0);
    return false;
  }
  
  public static boolean a(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2)
  {
    if ((paramSignalStrength1 == null) || (paramSignalStrength2 == null)) {}
    int i;
    do
    {
      do
      {
        return true;
        i = b(paramInt, paramSignalStrength1, paramSignalStrength2);
        if (!a(paramInt)) {
          break;
        }
      } while (i > 3);
      return false;
      if (!b(paramInt)) {
        break;
      }
    } while (i > 6);
    return false;
    return false;
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  public static boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   7: bipush 17
    //   9: if_icmplt +25 -> 34
    //   12: aload_0
    //   13: invokevirtual 132	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: ldc -122
    //   18: invokestatic 140	android/provider/Settings$Global:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   21: istore_1
    //   22: iload_1
    //   23: iconst_1
    //   24: if_icmpne +5 -> 29
    //   27: iload_2
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_2
    //   31: goto -4 -> 27
    //   34: aload_0
    //   35: invokevirtual 132	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: ldc -122
    //   40: invokestatic 143	android/provider/Settings$System:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_1
    //   46: if_icmpne +7 -> 53
    //   49: iload_3
    //   50: istore_2
    //   51: iload_2
    //   52: ireturn
    //   53: iconst_0
    //   54: istore_2
    //   55: goto -4 -> 51
    //   58: astore_0
    //   59: iconst_0
    //   60: ireturn
    //   61: astore_0
    //   62: iconst_0
    //   63: ireturn
    //   64: astore_0
    //   65: iconst_0
    //   66: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramContext	android.content.Context
    //   21	26	1	i	int
    //   3	52	2	bool1	boolean
    //   1	49	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   34	44	58	java/lang/Exception
    //   12	22	61	java/lang/Error
    //   12	22	64	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public static boolean a(CellInfo paramCellInfo)
  {
    if (paramCellInfo == null) {}
    for (;;)
    {
      return false;
      try
      {
        int i;
        int j;
        int k;
        int m;
        if ((paramCellInfo instanceof CellInfoGsm))
        {
          paramCellInfo = ((CellInfoGsm)paramCellInfo).getCellIdentity();
          i = paramCellInfo.getMcc();
          j = paramCellInfo.getMnc();
          k = paramCellInfo.getLac();
          m = paramCellInfo.getCid();
          if ((i < 0) || (j < 0) || (k <= 0) || (k >= 65535) || (m == 268435455) || (m == Integer.MAX_VALUE) || (m == 50594049) || (m == 65535) || (m == 8) || (m == 10) || (m == 33) || (m <= 0)) {
            continue;
          }
        }
        else if ((paramCellInfo instanceof CellInfoCdma))
        {
          paramCellInfo = ((CellInfoCdma)paramCellInfo).getCellIdentity();
          i = paramCellInfo.getSystemId();
          j = paramCellInfo.getNetworkId();
          k = paramCellInfo.getBasestationId();
          if ((i < 0) || (j < 0) || (j > 65535) || (k < 0) || (k > 65535)) {
            continue;
          }
          if ((i == 0) && (j == 0) && (k == 0)) {
            return false;
          }
        }
        else if ((paramCellInfo instanceof CellInfoWcdma))
        {
          paramCellInfo = ((CellInfoWcdma)paramCellInfo).getCellIdentity();
          i = paramCellInfo.getMcc();
          j = paramCellInfo.getMnc();
          k = paramCellInfo.getLac();
          m = paramCellInfo.getCid();
          if ((i < 0) || (j < 0) || (k <= 0) || (k >= 65535) || (m == 268435455) || (m == Integer.MAX_VALUE) || (m == 50594049) || (m == 65535) || (m == 8) || (m == 10) || (m == 33)) {
            continue;
          }
          if (m <= 0) {
            return false;
          }
        }
        else if ((paramCellInfo instanceof CellInfoLte))
        {
          paramCellInfo = ((CellInfoLte)paramCellInfo).getCellIdentity();
          i = paramCellInfo.getMcc();
          j = paramCellInfo.getMnc();
          k = paramCellInfo.getTac();
          m = paramCellInfo.getCi();
          if ((i < 0) || (j < 0) || (k <= 0) || (k >= 65535) || (m == 268435455) || (m == Integer.MAX_VALUE) || (m == 50594049) || (m == 65535) || (m == 8) || (m == 10) || (m == 33)) {
            continue;
          }
          if (m <= 0) {
            return false;
          }
        }
      }
      catch (Error paramCellInfo)
      {
        return false;
      }
      catch (Exception paramCellInfo)
      {
        return false;
      }
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean a(CellInfo paramCellInfo1, CellInfo paramCellInfo2)
  {
    if (b.a(paramCellInfo1, paramCellInfo2)) {}
    for (;;)
    {
      return false;
      if (paramCellInfo1.getClass() == paramCellInfo2.getClass()) {
        try
        {
          if ((paramCellInfo1 instanceof CellInfoGsm))
          {
            paramCellInfo1 = (CellInfoGsm)paramCellInfo1;
            paramCellInfo2 = (CellInfoGsm)paramCellInfo2;
            paramCellInfo1 = paramCellInfo1.getCellIdentity();
            paramCellInfo2 = paramCellInfo2.getCellIdentity();
            if (paramCellInfo1.getCid() == paramCellInfo2.getCid()) {
              return true;
            }
          }
          else if ((paramCellInfo1 instanceof CellInfoCdma))
          {
            paramCellInfo1 = (CellInfoCdma)paramCellInfo1;
            paramCellInfo2 = (CellInfoCdma)paramCellInfo2;
            paramCellInfo1 = paramCellInfo1.getCellIdentity();
            paramCellInfo2 = paramCellInfo2.getCellIdentity();
            if (paramCellInfo1.getBasestationId() == paramCellInfo2.getBasestationId()) {
              return true;
            }
          }
          else if ((paramCellInfo1 instanceof CellInfoWcdma))
          {
            paramCellInfo1 = (CellInfoWcdma)paramCellInfo1;
            paramCellInfo2 = (CellInfoWcdma)paramCellInfo2;
            paramCellInfo1 = paramCellInfo1.getCellIdentity();
            paramCellInfo2 = paramCellInfo2.getCellIdentity();
            if (paramCellInfo1.getCid() == paramCellInfo2.getCid()) {
              return true;
            }
          }
          else if ((paramCellInfo1 instanceof CellInfoLte))
          {
            paramCellInfo1 = (CellInfoLte)paramCellInfo1;
            paramCellInfo2 = (CellInfoLte)paramCellInfo2;
            paramCellInfo1 = paramCellInfo1.getCellIdentity();
            paramCellInfo2 = paramCellInfo2.getCellIdentity();
            int i = paramCellInfo1.getCi();
            int j = paramCellInfo2.getCi();
            if (i == j) {
              return true;
            }
          }
        }
        catch (Error paramCellInfo1)
        {
          return false;
        }
        catch (Exception paramCellInfo1) {}
      }
    }
    return false;
  }
  
  public static boolean a(CellLocation paramCellLocation1, CellLocation paramCellLocation2)
  {
    if (b.a(paramCellLocation1, paramCellLocation2)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (paramCellLocation1.getClass() != paramCellLocation2.getClass());
          if (!(paramCellLocation1 instanceof GsmCellLocation)) {
            break;
          }
          paramCellLocation1 = (GsmCellLocation)paramCellLocation1;
          paramCellLocation2 = (GsmCellLocation)paramCellLocation2;
        } while (paramCellLocation1.getCid() != paramCellLocation2.getCid());
        return true;
      } while (!(paramCellLocation1 instanceof CdmaCellLocation));
      paramCellLocation1 = (CdmaCellLocation)paramCellLocation1;
      paramCellLocation2 = (CdmaCellLocation)paramCellLocation2;
    } while (paramCellLocation1.getBaseStationId() != paramCellLocation2.getBaseStationId());
    return true;
  }
  
  public static boolean a(ck paramck)
  {
    if (paramck == null) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    return a(paramck.a, paramck.b, paramck.c, paramck.d, paramck.e);
  }
  
  private static int b(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2)
  {
    try
    {
      if (a(paramInt)) {
        return paramSignalStrength1.getGsmSignalStrength() - paramSignalStrength2.getGsmSignalStrength();
      }
      if (b(paramInt))
      {
        paramInt = paramSignalStrength1.getCdmaDbm();
        int i = paramSignalStrength2.getCdmaDbm();
        return paramInt - i;
      }
    }
    catch (NoSuchMethodError paramSignalStrength1) {}
    return 0;
  }
  
  public static CellLocation b(bl parambl)
  {
    boolean bool2 = false;
    TelephonyManager localTelephonyManager = parambl.e;
    if (localTelephonyManager != null) {
      try
      {
        CellLocation localCellLocation = localTelephonyManager.getCellLocation();
        int i = localTelephonyManager.getSimState();
        int j;
        if (i == 5) {
          j = 1;
        }
        for (;;)
        {
          try
          {
            bool1 = TextUtils.isEmpty(localTelephonyManager.getSubscriberId());
            if (bool1) {
              continue;
            }
            i = 1;
          }
          catch (Exception localException)
          {
            boolean bool1;
            i = 1;
            continue;
          }
          if ((j != 0) && (i != 0))
          {
            if ((localCellLocation != null) && (!b(localCellLocation)))
            {
              bool1 = bool2;
              if (a(localCellLocation) >= 0) {}
            }
            else
            {
              bool1 = bool2;
              if (!a(parambl.a)) {
                bool1 = true;
              }
            }
            a = bool1;
          }
          return localCellLocation;
          j = 0;
          continue;
          i = 0;
        }
        return CellLocation.getEmpty();
      }
      catch (Exception parambl)
      {
        a = true;
      }
    }
  }
  
  private static boolean b(int paramInt)
  {
    return paramInt == 2;
  }
  
  private static boolean b(CellLocation paramCellLocation)
  {
    try
    {
      paramCellLocation = (GsmCellLocation)paramCellLocation;
      if (paramCellLocation.getCid() == 0)
      {
        int i = paramCellLocation.getLac();
        if (i == 0) {
          return true;
        }
      }
    }
    catch (ClassCastException paramCellLocation) {}
    return false;
  }
  
  public static List<NeighboringCellInfo> c(bl parambl)
  {
    parambl = parambl.e;
    if (parambl != null) {
      try
      {
        parambl = parambl.getNeighboringCellInfo();
        return parambl;
      }
      catch (Exception parambl) {}
    }
    return Collections.emptyList();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */