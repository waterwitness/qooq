package cooperation.qqhotspot.hotspotnode;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotApNodeCheckIpc;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeAPInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeApEx;
import cooperation.qqhotspot.WifiNetworkUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import yhi;

public class QQHotSpotListCacheHandler
{
  private static QQHotSpotListCacheHandler jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListCacheHandler;
  private static final String jdField_a_of_type_JavaLangString = "QQHotSpotListCacheHandler";
  private QQHotSpotListHandler.Callback jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListHandler$Callback;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  
  public QQHotSpotListCacheHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListHandler$Callback = new yhi(this);
  }
  
  public static QQHotSpotListCacheHandler a()
  {
    if (jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListCacheHandler == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListCacheHandler == null) {
        jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListCacheHandler = new QQHotSpotListCacheHandler();
      }
      return jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListCacheHandler;
    }
    finally {}
  }
  
  public void a(String paramString, QQHotSpotHelper.HotSpotNodeApEx paramHotSpotNodeApEx, QQHotSpotListCacheHandler.Callback paramCallback)
  {
    if (paramCallback == null) {}
    do
    {
      return;
      if ((paramString != null) && (paramHotSpotNodeApEx != null)) {
        break;
      }
    } while (paramCallback == null);
    paramCallback.a(false, null, null);
    return;
    Object localObject = (HashMap)HotSpotNodeCacheManager.a().a();
    List localList = HotSpotNodeCacheManager.a().b();
    int i;
    if (((HashMap)localObject).get(paramString) != null)
    {
      localObject = (ArrayList)((HashMap)localObject).get(paramString);
      i = 0;
      label69:
      if (i >= ((ArrayList)localObject).size()) {
        break label443;
      }
      if (!WifiNetworkUtil.a(((QQHotSpotHelper.HotSpotNodeAPInfo)((ArrayList)localObject).get(i)).mApInfo.SSID, paramHotSpotNodeApEx.mSsid)) {}
    }
    label443:
    for (localObject = (QQHotSpotHelper.HotSpotNodeAPInfo)((ArrayList)localObject).get(i);; localObject = null)
    {
      if (localObject != null)
      {
        paramCallback.a(true, (QQHotSpotHelper.HotSpotNodeAPInfo)localObject, paramHotSpotNodeApEx);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QQHotSpotListCacheHandler", 2, "sendAPNodeCheckWithCacheReq()  在缓存的合作列表能找到 BSSID: " + paramString);
        return;
        i += 1;
        break label69;
      }
      paramCallback.a(false, null, paramHotSpotNodeApEx);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QQHotSpotListCacheHandler", 2, "sendAPNodeCheckWithCacheReq()  在缓存的合作列表能找到 BSSID: " + paramString + " 但是不能找到相同的ssid");
      return;
      if (localList.contains(paramString))
      {
        paramCallback.a(false, null, paramHotSpotNodeApEx);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QQHotSpotListCacheHandler", 2, "sendAPNodeCheckWithCacheReq()  在缓存的非合作列表能找到 BSSID: " + paramString);
        return;
      }
      if (!NetworkUtil.h(BaseApplicationImpl.getContext()))
      {
        paramCallback.a(false, null, paramHotSpotNodeApEx);
        if (QLog.isColorLevel()) {
          QLog.i("QQHotSpotListCacheHandler", 2, "sendAPNodeCheckWithCacheReq() 网络不通 直接返回失败");
        }
      }
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      localObject = this.jdField_a_of_type_JavaUtilHashMap;
      if (paramCallback != null) {}
      try
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramCallback);
        paramCallback = (QQAppInterface)BaseApplicationImpl.a().a();
        localObject = new ArrayList();
        ((List)localObject).add(paramString);
        ((QQHotSpotListHandler)paramCallback.a(83)).a(1, (List)localObject, null, this.jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListHandler$Callback, new QQHotSpotHelper.HotSpotApNodeCheckIpc(paramHotSpotNodeApEx, i));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QQHotSpotListCacheHandler", 2, "sendAPNodeCheckWithCacheReq()  在缓存的列表未能能找到 BSSID: " + paramString + " 发往svr查询");
        return;
      }
      finally {}
    }
  }
  
  public void a(String paramString1, String paramString2, QQHotSpotListCacheHandler.Callback_WIFiId paramCallback_WIFiId)
  {
    if (paramCallback_WIFiId == null) {}
    for (;;)
    {
      return;
      if ((paramString1 == null) || (paramString2 == null))
      {
        paramCallback_WIFiId.a(false, null, null);
        return;
      }
      Object localObject = ((HashMap)HotSpotNodeCacheManager.a().a()).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArrayList localArrayList = (ArrayList)((Iterator)localObject).next();
        i = 0;
        while (i < localArrayList.size())
        {
          if ((((QQHotSpotHelper.HotSpotNodeAPInfo)localArrayList.get(i)).mApInfo.WiFiID.equals(paramString1)) && (WifiNetworkUtil.a(((QQHotSpotHelper.HotSpotNodeAPInfo)localArrayList.get(i)).mApInfo.SSID, paramString2)))
          {
            paramCallback_WIFiId.a(true, (QQHotSpotHelper.HotSpotNodeAPInfo)localArrayList.get(i), paramString2);
            return;
          }
          i += 1;
        }
      }
      if (!NetworkUtil.h(BaseApplicationImpl.getContext()))
      {
        paramCallback_WIFiId.a(false, null, paramString2);
        if (QLog.isColorLevel()) {
          QLog.i("QQHotSpotListCacheHandler", 2, "sendAPNodeCheckWithCacheReq_WiFiId() 网络不通 直接返回失败");
        }
      }
      int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      localObject = this.jdField_a_of_type_JavaUtilHashMap;
      if (paramCallback_WIFiId != null) {}
      try
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramCallback_WIFiId);
        ((QQHotSpotListHandler)((QQAppInterface)BaseApplicationImpl.a().a()).a(83)).a(2, null, paramString1, this.jdField_a_of_type_CooperationQqhotspotHotspotnodeQQHotSpotListHandler$Callback, new QQHotSpotHelper.HotSpotApNodeCheckIpc(paramString2, i));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("QQHotSpotListCacheHandler", 2, "sendAPNodeCheckWithCacheReq_WiFiId()  在缓存的列表未能能找到 WiFIID: " + paramString1 + " 发往svr查询");
        return;
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\QQHotSpotListCacheHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */