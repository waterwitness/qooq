import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeAPInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeApEx;
import cooperation.qqhotspot.WifiNetworkUtil;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeCacheManager;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil.SetOpt;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class yhs
  implements Runnable
{
  yhs(yhr paramyhr, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "stepGeLocaltWiFiList result: wifilist is null or empty");
      }
      this.jdField_a_of_type_Yhr.a.a(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "stepGeLocaltWiFiList result: wifilist size(): " + String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
    }
    List localList2 = HotSpotNodeCacheManager.a().a();
    List localList1 = HotSpotNodeCacheManager.a().b();
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap = new HashMap();
    Map localMap = HotSpotNodeCacheManager.a().a();
    if (QLog.isColorLevel())
    {
      QLog.i("ShowNodeTaskManager", 2, "合作缓存 size(): " + String.valueOf(localList2.size()));
      QLog.i("ShowNodeTaskManager", 2, "非合作缓存 size(): " + String.valueOf(localList1.size()));
    }
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localHashSet.add(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).BSSID);
      if ((!HotSpotNodeUtil.a(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).SignLevel)) || (!ShowNodeTaskManager.a(this.jdField_a_of_type_Yhr.a).contains(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).BSSID))) {}
      label675:
      for (;;)
      {
        i += 1;
        break;
        ArrayList localArrayList2;
        if (localHashMap.get(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).BSSID) == null)
        {
          localArrayList1.add(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).BSSID);
          localArrayList2 = new ArrayList();
          localArrayList2.add(new QQHotSpotHelper.HotSpotNodeApEx(Integer.valueOf(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).SignLevel), ((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).SSID, ((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).BSSID));
          localHashMap.put(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).BSSID, localArrayList2);
        }
        for (;;)
        {
          if (localMap == null) {
            break label675;
          }
          localArrayList2 = (ArrayList)localMap.get(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).BSSID);
          if (localArrayList2 == null) {
            break;
          }
          int j = 0;
          while (j < localArrayList2.size())
          {
            if (WifiNetworkUtil.a(((QQHotSpotHelper.HotSpotNodeAPInfo)localArrayList2.get(j)).mApInfo.SSID, ((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).SSID))
            {
              ((QQHotSpotHelper.HotSpotNodeAPInfo)localArrayList2.get(j)).mApInfo.SignLevel = ((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).SignLevel;
              ShowNodeTaskManager.a(this.jdField_a_of_type_Yhr.a).add(localArrayList2.get(j));
            }
            j += 1;
          }
          break;
          ((ArrayList)localHashMap.get(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).BSSID)).add(new QQHotSpotHelper.HotSpotNodeApEx(Integer.valueOf(((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).SignLevel), ((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).SSID, ((QQHotSpotHelper.APInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).BSSID));
        }
      }
    }
    ShowNodeTaskManager.a(this.jdField_a_of_type_Yhr.a, localHashSet);
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "exist in cooperatApCache size() : " + String.valueOf(ShowNodeTaskManager.a(this.jdField_a_of_type_Yhr.a).size()));
    }
    localList2 = HotSpotNodeUtil.SetOpt.c(localArrayList1, localList2);
    if ((localList2 != null) && (!localList2.isEmpty()))
    {
      localList1 = HotSpotNodeUtil.SetOpt.c(localList2, localList1);
      if ((localList1 != null) && (!localList1.isEmpty()))
      {
        ShowNodeTaskManager.a(this.jdField_a_of_type_Yhr.a, localList1, localHashMap);
        return;
      }
      this.jdField_a_of_type_Yhr.a.a(true);
      return;
    }
    this.jdField_a_of_type_Yhr.a.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */