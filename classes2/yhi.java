import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotApNodeCheckIpc;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeAPInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeApEx;
import cooperation.qqhotspot.WifiNetworkUtil;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListCacheHandler;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListCacheHandler.Callback;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListCacheHandler.Callback_WIFiId;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListHandler.Callback;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheckResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class yhi
  implements QQHotSpotListHandler.Callback
{
  public yhi(QQHotSpotListCacheHandler paramQQHotSpotListCacheHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, APNodeCheckResult paramAPNodeCheckResult, Serializable paramSerializable)
  {
    QQHotSpotHelper.HotSpotNodeApEx localHotSpotNodeApEx = null;
    Object localObject1 = null;
    int j = ((QQHotSpotHelper.HotSpotApNodeCheckIpc)paramSerializable).mObj2;
    Object localObject2;
    int i;
    for (;;)
    {
      synchronized (QQHotSpotListCacheHandler.a(this.a))
      {
        if (QQHotSpotListCacheHandler.a(this.a).get(Integer.valueOf(j)) != null)
        {
          localObject2 = ((QQHotSpotHelper.HotSpotApNodeCheckIpc)paramSerializable).mObj1;
          if (!(QQHotSpotListCacheHandler.a(this.a).get(Integer.valueOf(j)) instanceof QQHotSpotListCacheHandler.Callback)) {
            break label275;
          }
          localHotSpotNodeApEx = (QQHotSpotHelper.HotSpotNodeApEx)localObject2;
          paramSerializable = new HashMap();
          localObject2 = new ArrayList();
          ((List)localObject2).add(localHotSpotNodeApEx);
          paramSerializable.put(localHotSpotNodeApEx.mBssid, localObject2);
          HotSpotNodeUtil.a(paramAPNodeCheckResult, paramSerializable);
          i = 0;
          paramSerializable = (Serializable)localObject1;
          if (i < paramAPNodeCheckResult.arrApInfo.size())
          {
            if (!WifiNetworkUtil.a(((QQHotSpotHelper.HotSpotNodeAPInfo)paramAPNodeCheckResult.arrApInfo.get(i)).mApInfo.SSID, localHotSpotNodeApEx.mSsid)) {
              break;
            }
            paramSerializable = (QQHotSpotHelper.HotSpotNodeAPInfo)paramAPNodeCheckResult.arrApInfo.get(i);
          }
          if (paramSerializable != null)
          {
            ((QQHotSpotListCacheHandler.Callback)QQHotSpotListCacheHandler.a(this.a).get(Integer.valueOf(j))).a(true, paramSerializable, localHotSpotNodeApEx);
            label219:
            QQHotSpotListCacheHandler.a(this.a).remove(Integer.valueOf(j));
          }
        }
        else
        {
          return;
        }
        ((QQHotSpotListCacheHandler.Callback)QQHotSpotListCacheHandler.a(this.a).get(Integer.valueOf(j))).a(false, null, localHotSpotNodeApEx);
      }
      label275:
      if ((QQHotSpotListCacheHandler.a(this.a).get(Integer.valueOf(j)) instanceof QQHotSpotListCacheHandler.Callback_WIFiId)) {
        i = 0;
      }
    }
    for (;;)
    {
      paramSerializable = localHotSpotNodeApEx;
      if (i < paramAPNodeCheckResult.arrApInfo.size())
      {
        if (WifiNetworkUtil.a(((QQHotSpotHelper.HotSpotNodeAPInfo)paramAPNodeCheckResult.arrApInfo.get(i)).mApInfo.SSID, (String)localObject2)) {
          paramSerializable = (QQHotSpotHelper.HotSpotNodeAPInfo)paramAPNodeCheckResult.arrApInfo.get(i);
        }
      }
      else
      {
        if (paramSerializable != null)
        {
          ((QQHotSpotListCacheHandler.Callback_WIFiId)QQHotSpotListCacheHandler.a(this.a).get(Integer.valueOf(j))).a(true, paramSerializable, (String)localObject2);
          break label219;
        }
        ((QQHotSpotListCacheHandler.Callback_WIFiId)QQHotSpotListCacheHandler.a(this.a).get(Integer.valueOf(j))).a(false, null, (String)localObject2);
        break label219;
        i += 1;
        break;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */