import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public final class qny
  implements TencentLocationListener
{
  public qny()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    boolean bool4;
    long l;
    String str1;
    String str2;
    boolean bool1;
    int k;
    boolean bool5;
    boolean bool6;
    Object localObject9;
    label138:
    Object localObject2;
    Object localObject1;
    label177:
    int i;
    label248:
    boolean bool2;
    Object localObject7;
    Object localObject8;
    Object localObject5;
    Object localObject6;
    Object localObject3;
    Object localObject4;
    Object localObject10;
    if (paramInt == 0)
    {
      bool4 = true;
      com.tencent.mobileqq.app.NearbyHandler.d = paramInt;
      l = SystemClock.elapsedRealtime() - SosoInterface.a() - SosoInterface.a();
      SosoInterface.a(SystemClock.elapsedRealtime());
      SosoInterface.a(2000);
      str1 = paramTencentLocation.getExtra().getString("qq_caller");
      str2 = paramTencentLocation.getExtra().getString("qq_caller_route");
      bool1 = paramTencentLocation.getExtra().getBoolean("qq_goonListener");
      k = paramTencentLocation.getExtra().getInt("qq_level");
      bool5 = paramTencentLocation.getExtra().getBoolean("qq_reqLocation");
      bool6 = paramTencentLocation.getExtra().getBoolean("allow_gps");
      localObject9 = TencentExtraKeys.getRawData(paramTencentLocation);
      if (bool5)
      {
        if (!bool4) {
          break label685;
        }
        SosoInterface.b(0);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("onLocationChanged() err=").append(paramInt);
        if ((paramString != null) && (paramString.length() != 0)) {
          break label692;
        }
        localObject1 = "";
        localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(" detail=").append(paramInt).append(" caller=").append(str1).append(" level=").append(k).append(" reqLocation=").append(bool5).append(" consume=").append(l).append(" rawData=");
        if (localObject9 != null) {
          break label716;
        }
        i = 0;
        QLog.d("SOSO.LBS", 2, i + " isGoonCallback=" + bool1 + " failInt=" + SosoInterface.c() + " caller rote: " + str2);
      }
      bool2 = false;
      bool1 = false;
      localObject7 = null;
      localObject8 = null;
      localObject5 = null;
      localObject1 = null;
      localObject6 = null;
      localObject3 = null;
      localObject4 = null;
      localObject2 = null;
      localObject10 = SosoInterface.a;
      if ((paramInt == 0) && (!bool5)) {}
    }
    boolean bool3;
    for (;;)
    {
      try
      {
        SosoInterface.a(k, paramTencentLocation);
        if ((localObject9 != null) && (localObject9.length > 0)) {
          SosoInterface.a(paramTencentLocation.getProvider(), (byte[])localObject9);
        }
        if (SosoInterface.a().size() <= 0) {
          break label1157;
        }
        if (bool5)
        {
          localSosoLbsInfo = SosoInterface.b();
          i = SosoInterface.a().size() - 1;
          paramTencentLocation = (TencentLocation)localObject8;
          localObject4 = localObject2;
          localObject6 = localObject3;
          localObject5 = localObject1;
          localObject7 = paramTencentLocation;
          bool2 = bool1;
          if (i < 0) {
            break label1157;
          }
          localObject4 = (SosoInterface.OnLocationListener)SosoInterface.a().get(i);
          if (((SosoInterface.OnLocationListener)localObject4).g == bool5) {
            if (((SosoInterface.OnLocationListener)localObject4).g)
            {
              if (((SosoInterface.OnLocationListener)localObject4).jdField_b_of_type_Int != 1) {
                continue;
              }
              if (((SosoInterface.OnLocationListener)localObject4).jdField_b_of_type_Int != k) {}
            }
            else
            {
              if (!((SosoInterface.OnLocationListener)localObject4).e) {
                continue;
              }
              SosoInterface.a((SosoInterface.OnLocationListener)localObject4, paramInt, localSosoLbsInfo);
              if (!((SosoInterface.OnLocationListener)localObject4).f) {
                break label762;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.OnLocationListener)localObject4).jdField_b_of_type_JavaLangString + " goon...");
              }
            }
          }
          localObject9 = localObject2;
          localObject8 = localObject3;
          localObject7 = localObject1;
          localObject6 = paramTencentLocation;
          bool3 = bool1;
          if (SosoInterface.OnLocationListener.a((SosoInterface.OnLocationListener)localObject4)) {
            break label1597;
          }
          if (!((SosoInterface.OnLocationListener)localObject4).f) {
            break label845;
          }
          if (localObject3 != null) {
            break label821;
          }
          localObject5 = localObject4;
          if (SosoInterface.OnLocationListener.b((SosoInterface.OnLocationListener)localObject4)) {
            localObject2 = localObject4;
          }
          localObject9 = localObject2;
          localObject8 = localObject5;
          localObject7 = localObject1;
          localObject6 = paramTencentLocation;
          bool3 = bool1;
          if (SosoInterface.c() <= 0) {
            break label1597;
          }
          ((SosoInterface.OnLocationListener)localObject4).a(paramInt, SosoInterface.c());
          localObject4 = localObject2;
          localObject3 = paramTencentLocation;
          localObject2 = localObject1;
          localObject1 = localObject5;
          paramTencentLocation = (TencentLocation)localObject4;
          i -= 1;
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject2 = paramTencentLocation;
          localObject3 = localObject1;
          localObject1 = localObject5;
          paramTencentLocation = (TencentLocation)localObject4;
          continue;
          bool4 = false;
          break;
          label685:
          SosoInterface.b();
          break label138;
          label692:
          localObject1 = " reason=" + paramString;
          break label177;
          label716:
          i = localObject9.length;
          break label248;
        }
        SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.a();
        continue;
        if (((SosoInterface.OnLocationListener)localObject4).jdField_b_of_type_Int > k) {
          continue;
        }
        continue;
        ((SosoInterface.OnLocationListener)localObject4).a(paramInt, localSosoLbsInfo);
        continue;
        SosoInterface.a().remove(i);
      }
      finally {}
      label762:
      SosoInterface.OnLocationListener.a((SosoInterface.OnLocationListener)localObject4, true);
      if (QLog.isColorLevel())
      {
        QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.OnLocationListener)localObject4).jdField_b_of_type_JavaLangString + " removed normally.");
        continue;
        label821:
        localObject5 = localObject3;
        if (((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_Int < ((SosoInterface.OnLocationListener)localObject4).jdField_b_of_type_Int) {
          localObject5 = localObject4;
        }
      }
    }
    label845:
    label893:
    int j;
    TencentLocation localTencentLocation;
    if (SystemClock.elapsedRealtime() - ((SosoInterface.OnLocationListener)localObject4).d > 30000L)
    {
      SosoInterface.a().remove(i);
      SosoInterface.OnLocationListener.a((SosoInterface.OnLocationListener)localObject4, true);
      if (((SosoInterface.OnLocationListener)localObject4).g)
      {
        localObject5 = SosoInterface.b();
        break label1553;
        ((SosoInterface.OnLocationListener)localObject4).a(j, (SosoInterface.SosoLbsInfo)localObject5);
        if (!QLog.isColorLevel()) {
          break label1566;
        }
        QLog.d("SOSO.LBS", 2, "lis=" + ((SosoInterface.OnLocationListener)localObject4).jdField_b_of_type_JavaLangString + " err_timeout.reqRaw=" + ((SosoInterface.OnLocationListener)localObject4).g + ". Force 2 remove it.");
        break label1566;
      }
      else
      {
        localObject5 = SosoInterface.a();
      }
    }
    else if (((SosoInterface.OnLocationListener)localObject4).g)
    {
      if (localObject1 == null)
      {
        localObject5 = localObject4;
        bool2 = bool1;
        localTencentLocation = paramTencentLocation;
      }
    }
    for (;;)
    {
      localObject9 = localObject2;
      localObject8 = localObject3;
      localObject7 = localObject5;
      localObject6 = localTencentLocation;
      bool3 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.OnLocationListener)localObject4).jdField_b_of_type_JavaLangString + " goon=" + ((SosoInterface.OnLocationListener)localObject4).f + " reqLocation=" + ((SosoInterface.OnLocationListener)localObject4).g + " hasReqRaw=" + bool2);
        localObject9 = localObject2;
        localObject8 = localObject3;
        localObject7 = localObject5;
        localObject6 = localTencentLocation;
        bool3 = bool2;
        break label1597;
        localObject5 = localObject1;
        localTencentLocation = paramTencentLocation;
        bool2 = bool1;
        if (((SosoInterface.OnLocationListener)localObject1).jdField_b_of_type_Int >= ((SosoInterface.OnLocationListener)localObject4).jdField_b_of_type_Int) {
          continue;
        }
        localObject5 = localObject4;
        localTencentLocation = paramTencentLocation;
        bool2 = bool1;
        continue;
        if (paramTencentLocation == null) {
          break label1619;
        }
        if (!((SosoInterface.OnLocationListener)localObject4).h) {
          break label1622;
        }
        break label1619;
        label1157:
        SosoInterface.a().set(0);
        if (SosoInterface.a().size() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SOSO.LBS", 4, "listener is empty.");
          }
          SosoInterface.b();
        }
        for (;;)
        {
          SosoInterface.a(bool4, bool5, l, paramInt, paramInt, str1, paramString, str2, bool6);
          return;
          if (bool2)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("onLocationChanged()");
              if (localObject6 != null) {
                break label1315;
              }
            }
            label1315:
            for (paramTencentLocation = "";; paramTencentLocation = " goonLis been truncated:" + ((SosoInterface.OnLocationListener)localObject6).jdField_b_of_type_JavaLangString)
            {
              QLog.d("SOSO.LBS", 2, paramTencentLocation + " start:reqRawData");
              if (localObject4 != null) {
                SosoInterface.OnLocationListener.b((SosoInterface.OnLocationListener)localObject4, false);
              }
              if (localObject7 != null)
              {
                SosoInterface.a().jdField_b_of_type_JavaLangString = ((SosoInterface.OnLocationListener)localObject7).jdField_b_of_type_JavaLangString;
                SosoInterface.a().h = ((SosoInterface.OnLocationListener)localObject7).h;
              }
              SosoInterface.a(SosoInterface.a());
              break;
            }
          }
          if (localObject5 != null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("onLocationChanged()");
              if (localObject6 != null) {
                break label1426;
              }
            }
            label1426:
            for (paramTencentLocation = "";; paramTencentLocation = " goonLis been truncated:" + ((SosoInterface.OnLocationListener)localObject6).jdField_b_of_type_JavaLangString)
            {
              QLog.d("SOSO.LBS", 2, paramTencentLocation + " start:" + ((SosoInterface.OnLocationListener)localObject5).jdField_b_of_type_JavaLangString);
              if (localObject4 != null) {
                SosoInterface.OnLocationListener.b((SosoInterface.OnLocationListener)localObject4, false);
              }
              SosoInterface.a((SosoInterface.OnLocationListener)localObject5);
              break;
            }
          }
          if (localObject6 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SOSO.LBS", 2, "onLocationChanged() goonLis goon after 1000ms:" + ((SosoInterface.OnLocationListener)localObject6).jdField_b_of_type_JavaLangString);
            }
            if ((localObject4 != null) && (localObject4 != localObject6)) {
              SosoInterface.OnLocationListener.b((SosoInterface.OnLocationListener)localObject4, false);
            }
            if ((!SosoInterface.OnLocationListener.b((SosoInterface.OnLocationListener)localObject6)) && (!SosoInterface.OnLocationListener.a((SosoInterface.OnLocationListener)localObject6))) {
              ThreadManager.b().postDelayed(new qnz(this, (SosoInterface.OnLocationListener)localObject6), 1000L);
            }
          }
        }
        label1553:
        if (localObject5 == null)
        {
          j = 55536;
          break label893;
          label1566:
          localObject4 = localObject1;
          localObject5 = paramTencentLocation;
          paramTencentLocation = (TencentLocation)localObject2;
          localObject1 = localObject3;
          localObject2 = localObject4;
          localObject3 = localObject5;
          break;
        }
        j = 0;
        break label893;
      }
      label1597:
      paramTencentLocation = (TencentLocation)localObject9;
      localObject1 = localObject8;
      localObject2 = localObject7;
      localObject3 = localObject6;
      bool1 = bool3;
      break;
      label1619:
      paramTencentLocation = (TencentLocation)localObject4;
      label1622:
      bool2 = true;
      localObject5 = localObject1;
      localTencentLocation = paramTencentLocation;
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "onStatusUpdate name: " + paramString1 + " status: " + paramInt + " desc: " + paramString2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */