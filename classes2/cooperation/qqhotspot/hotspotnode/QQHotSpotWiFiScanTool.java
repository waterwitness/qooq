package cooperation.qqhotspot.hotspotnode;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import yhj;
import yhk;
import yhl;
import yhm;

public class QQHotSpotWiFiScanTool
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  protected QQHotSpotWiFiScanTool.Callback a;
  public String a;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private BroadcastReceiver b;
  
  public QQHotSpotWiFiScanTool()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yhj(this);
    this.b = new yhk(this);
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    BaseApplication.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    if (!((WifiManager)BaseApplication.getContext().getSystemService("wifi")).startScan()) {
      a(false, null);
    }
  }
  
  private void a(boolean paramBoolean, List paramList)
  {
    try
    {
      if (this.jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotWiFiScanTool$Callback != null)
      {
        this.jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotWiFiScanTool$Callback.a(paramBoolean, paramList);
        this.jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotWiFiScanTool$Callback = null;
      }
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  private void b()
  {
    int i = 0;
    List localList = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getScanResults();
    ArrayList localArrayList = new ArrayList();
    if (localList == null)
    {
      a(false, localArrayList);
      return;
    }
    while (i < localList.size())
    {
      ScanResult localScanResult = (ScanResult)localList.get(i);
      QQHotSpotHelper.APInfo localAPInfo = new QQHotSpotHelper.APInfo();
      if (!TextUtils.isEmpty(localScanResult.BSSID))
      {
        localAPInfo.SSID = localScanResult.SSID;
        localAPInfo.BSSID = localScanResult.BSSID.toUpperCase();
        localAPInfo.SignLevel = localScanResult.level;
        localArrayList.add(localAPInfo);
      }
      i += 1;
    }
    Collections.sort(localArrayList, new yhm(this));
    a(true, localArrayList);
  }
  
  public void a(QQHotSpotWiFiScanTool.Callback paramCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotWiFiScanTool$Callback != null)
        {
          if (paramCallback != null) {
            paramCallback.a(false, null);
          }
          return;
        }
        this.jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotWiFiScanTool$Callback = paramCallback;
        paramCallback = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
        if (paramCallback == null)
        {
          a(false, null);
          continue;
        }
        if (paramCallback.isWifiEnabled()) {
          break label155;
        }
      }
      finally {}
      if (paramBoolean1)
      {
        if (this.jdField_a_of_type_JavaUtilTimer != null)
        {
          a(false, null);
        }
        else
        {
          paramCallback.setWifiEnabled(true);
          paramCallback = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
          BaseApplication.getContext().registerReceiver(this.b, paramCallback);
          this.jdField_a_of_type_JavaUtilTimer = new Timer();
          this.jdField_a_of_type_JavaUtilTimer.schedule(new yhl(this), 15000L);
        }
      }
      else
      {
        a(false, null);
        continue;
        label155:
        if (paramBoolean2) {
          b();
        } else {
          a();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\QQHotSpotWiFiScanTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */