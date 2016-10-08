import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryPoiList;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ivq
  extends LbsManager.OnLocationListener
{
  public ivq(NewStoryPoiList paramNewStoryPoiList, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.a(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.jdField_a_of_type_Double = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      this.a.b = paramSosoLbsInfo.a.b;
      SLog.b("Q.qqstory.record.NewStoryPoiList", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_Double + " longitude=" + this.a.b);
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.c();
      }
      this.a.a();
      return;
    }
    this.a.jdField_a_of_type_Double = 0.0D;
    this.a.b = 0.0D;
    SLog.b("Q.qqstory.record.NewStoryPoiList", "onLocationUpdate() error");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */