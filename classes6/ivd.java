import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.POIFilterData;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ivd
  extends SosoInterface.OnLocationListener
{
  public ivd(NewStoryFilterViewPagerController paramNewStoryFilterViewPagerController, String paramString)
  {
    super(3, true, false, 60000L, false, false, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      String str1 = paramSosoLbsInfo.a.e;
      String str2 = paramSosoLbsInfo.a.f;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        this.a.a = new NewStoryFilterViewPagerController.POIFilterData(9, str1, str2, "", paramSosoLbsInfo.a.e, paramSosoLbsInfo.a.d, paramSosoLbsInfo.a.i, "", (int)(paramSosoLbsInfo.a.b * 1000000.0D), (int)(paramSosoLbsInfo.a.a * 1000000.0D), 1);
        return;
      }
      SLog.d("Q.qqstory.record.FilterViewPagerController", "onLocationFinish, city = %s, district = %s", new Object[] { str1, str2 });
      return;
    }
    SLog.d("Q.qqstory.record.FilterViewPagerController", "onLocationFinish errorCode = %d", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */