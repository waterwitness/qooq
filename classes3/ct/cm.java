package ct;

import android.location.Location;
import android.net.wifi.ScanResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class cm
{
  public static int a = 0;
  public final cl b;
  private final co c;
  private final ck d;
  
  public cm(co paramco, ck paramck, cl paramcl)
  {
    this.c = paramco;
    this.d = paramck;
    this.b = paramcl;
  }
  
  private String a(int paramInt1, int paramInt2, String paramString, bl parambl)
  {
    if (parambl == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject4;
        bm localbm;
        if (this.d == null)
        {
          bool = true;
          localObject2 = this.c;
          if (localObject2 == null) {
            break label1057;
          }
          if (Collections.unmodifiableList(((co)localObject2).b) == null)
          {
            break label1057;
            localObject4 = b.a(this.d, bool);
            localObject2 = this.b;
            if (localObject2 != null) {
              continue;
            }
            localObject2 = "{}";
            localbm = parambl.b;
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("imei", localbm.a());
            ((HashMap)localObject3).put("imsi", localbm.b());
            ((HashMap)localObject3).put("phonenum", b.a(localbm.d));
            ((HashMap)localObject3).put("qq", b.a(localbm.f));
            ((HashMap)localObject3).put("mac", localbm.c().toLowerCase(Locale.ENGLISH));
            localObject5 = new JSONObject((Map)localObject3).toString();
            if (localbm.m == null)
            {
              localObject3 = new StringBuilder(100);
              ((StringBuilder)localObject3).append(localbm.a()).append("_").append(localbm.b()).append("_").append(localbm.c()).append("_QQGeoLocation");
              localbm.m = b.c(((StringBuilder)localObject3).toString());
            }
            String str2 = localbm.m;
            db.a();
            i = db.a(parambl.a);
            String str1 = dd.d(parambl);
            localObject3 = localbm.i;
            parambl = (bl)localObject3;
            if (localObject3 != null) {
              parambl = ((String)localObject3).replace("\"", "");
            }
            localObject3 = parambl;
            if (parambl != null) {
              localObject3 = parambl.replace("|", "");
            }
            localObject3 = (String)localObject3 + "_" + localbm.h;
            StringBuilder localStringBuilder = new StringBuilder("{\"version\":\"");
            if (localbm.p != null) {
              continue;
            }
            parambl = "None";
            parambl = parambl + "\",\"address\":" + paramInt1;
            parambl = parambl + ",\"source\":203,\"access_token\":\"" + str2 + "\",\"app_name\":\"" + paramString + "\",\"app_label\":\"" + (String)localObject3 + "\",\"bearing\":1";
            paramString = parambl;
            if (paramInt2 >= 0) {
              paramString = parambl + ",\"control\":" + paramInt2;
            }
            paramString = paramString + ",\"pstat\":" + i;
            paramString = paramString + ",\"wlan\":" + str1;
            return paramString + ",\"attribute\":" + (String)localObject5 + ",\"location\":" + (String)localObject2 + ",\"cells\":" + (String)localObject4 + ",\"wifis\":" + (String)localObject1 + "}";
          }
        }
        else
        {
          if (a == this.d.e) {
            break label1065;
          }
          bool = true;
          a = this.d.e;
          continue;
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[");
        if ((Collections.unmodifiableList(((co)localObject2).b) == null) || (Collections.unmodifiableList(((co)localObject2).b).size() <= 0))
        {
          ((StringBuilder)localObject1).append("]");
          localObject1 = ((StringBuilder)localObject1).toString();
          continue;
        }
        Object localObject2 = Collections.unmodifiableList(((co)localObject2).b);
        Object localObject3 = ((List)localObject2).iterator();
        int i = 0;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ScanResult)((Iterator)localObject3).next();
          ((List)localObject2).size();
          if (i > 0) {
            ((StringBuilder)localObject1).append(",");
          }
          ((StringBuilder)localObject1).append("{\"mac\":\"").append(((ScanResult)localObject4).BSSID).append("\",");
          ((StringBuilder)localObject1).append("\"rssi\":").append(((ScanResult)localObject4).level).append("}");
          i += 1;
          continue;
        }
        ((StringBuilder)localObject1).append("]");
        localObject1 = ((StringBuilder)localObject1).toString();
        continue;
        localObject3 = ((cl)localObject2).a;
        Object localObject5 = new StringBuilder();
        double d1 = b.a(((Location)localObject3).getLatitude(), 6);
        double d2 = b.a(((Location)localObject3).getLongitude(), 6);
        double d3 = b.a(((Location)localObject3).getAltitude(), 1);
        double d4 = b.a(((Location)localObject3).getAccuracy(), 1);
        double d5 = b.a(((Location)localObject3).getBearing(), 1);
        double d6 = b.a(((Location)localObject3).getSpeed(), 1);
        ((StringBuilder)localObject5).append("{");
        ((StringBuilder)localObject5).append("\"latitude\":");
        ((StringBuilder)localObject5).append(d1);
        ((StringBuilder)localObject5).append(",\"longitude\":");
        ((StringBuilder)localObject5).append(d2);
        ((StringBuilder)localObject5).append(",\"additional\":");
        ((StringBuilder)localObject5).append("\"" + d3 + "," + d4 + "," + d5 + "," + d6 + "," + ((cl)localObject2).b + "\"");
        ((StringBuilder)localObject5).append("}");
        localObject2 = ((StringBuilder)localObject5).toString();
        continue;
        parambl = localbm.p;
        continue;
        localObject1 = "[]";
      }
      catch (Exception paramString)
      {
        return null;
      }
      label1057:
      continue;
      label1065:
      boolean bool = false;
    }
  }
  
  public final String a(int paramInt, String paramString, bl parambl, boolean paramBoolean)
  {
    if (paramBoolean) {
      return a(paramInt, 1, paramString, parambl);
    }
    return a(paramInt, 0, paramString, parambl);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */