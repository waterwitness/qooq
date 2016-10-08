import android.content.Intent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class iwo
  extends SimpleObserver
{
  public iwo(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity, GenerateContext paramGenerateContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.e();
    paramGenerateContext = new Intent(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, QQStoryTakeVideoCloseAnimationActivity.class);
    paramGenerateContext.putExtra("path", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.d());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.startActivity(paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.overridePendingTransition(0, 0);
    paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.a();
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "publishParam = " + paramGenerateContext);
    Intent localIntent = new Intent();
    localIntent.putExtra(PublishParam.a, paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.finish();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.overridePendingTransition(0, 0);
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", "PUBLISH cancel !");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.e();
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, "取消发表", 0).a();
  }
  
  public void onError(Error paramError)
  {
    super.onError(paramError);
    SLog.e("Q.qqstory.record.NewStoryTakeVideoActivity", "PUBLISH error ：" + paramError);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.e();
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, "发表失败，请重试 : " + paramError, 0).a();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */