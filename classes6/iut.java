import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.ImageLoader.LoadImageCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class iut
  extends ImageLoader.LoadImageCallback
{
  public iut(NewStoryDoodle paramNewStoryDoodle, LocationFacePackage.Item paramItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    super.onLoadCanceled(paramURLDrawable);
    SLog.e("Q.qqstory.record.StoryDoodle", "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a.e();
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a, "加载地理位置贴图失败", 1).a();
    SLog.e("Q.qqstory.record.StoryDoodle", "onLoadFailed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a.e();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item.a = paramURLDrawable;
    NewStoryDoodle.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle).a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item);
    SLog.e("Q.qqstory.record.StoryDoodle", "onLoadSucceed");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */