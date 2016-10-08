import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class rgl
  extends FriendListObserver
{
  public rgl(StrangerHdHeadUrlFetcher paramStrangerHdHeadUrlFetcher)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Setting paramSetting)
  {
    localObject3 = null;
    String str1;
    if ((paramBoolean) && (paramSetting != null))
    {
      str1 = paramSetting.uin;
      if ((str1 != null) && (str1.startsWith("stranger_")) && (this.a.jdField_a_of_type_JavaUtilSet.contains(str1))) {
        if (TextUtils.isEmpty(paramSetting.url)) {
          break label180;
        }
      }
    }
    for (paramSetting = StrangerHdHeadUrlFetcher.a(32, paramSetting.url, paramSetting.bHeadType, paramSetting.bFaceFlags);; paramSetting = null)
    {
      if (!TextUtils.isEmpty(paramSetting)) {
        this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, paramSetting);
      }
      try
      {
        i = str1.indexOf('_');
        j = str1.indexOf('_', i + 1);
        i = Integer.parseInt(str1.substring(i + 1, j));
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          int j;
          String str2;
          i = 0;
          DatingUtil.b("StrangerHdHeadUrlFetcher", new Object[] { localNumberFormatException1.toString() });
          Object localObject1 = localObject3;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          label180:
          int i = 0;
          DatingUtil.b("StrangerHdHeadUrlFetcher", new Object[] { localException1.toString() });
          Object localObject2 = localObject3;
        }
      }
      try
      {
        str2 = str1.substring(j + 1);
        ConnectNearbyProcService.a(4108, new Object[] { str2, Integer.valueOf(i), paramSetting });
        StrangerHdHeadUrlFetcher.a(this.a, str1);
        return;
      }
      catch (Exception localException2)
      {
        break label233;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        break label204;
      }
      str1 = null;
      break;
      DatingUtil.b("StrangerHdHeadUrlFetcher", new Object[] { "setting.url is null" });
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      String str1 = StrangerHdHeadUrlFetcher.a(32, paramInt, paramString);
      if (this.a.jdField_a_of_type_JavaUtilSet.contains(str1))
      {
        String str2 = this.a.a(paramString, paramInt, false);
        if (!TextUtils.isEmpty(str2)) {
          ConnectNearbyProcService.a(4108, new Object[] { paramString, Integer.valueOf(paramInt), str2 });
        }
        StrangerHdHeadUrlFetcher.a(this.a, str1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */