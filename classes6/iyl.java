import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.CheckPublishTextRequest;
import com.tencent.biz.qqstory.takevideo.publish.CheckDirtyContentSegment;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyl
  implements CmdTaskManger.CommandCallback
{
  public iyl(CheckDirtyContentSegment paramCheckDirtyContentSegment, GenerateContext paramGenerateContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(CheckPublishTextRequest paramCheckPublishTextRequest, BaseResponse paramBaseResponse, ErrorMessage paramErrorMessage)
  {
    if ((paramBaseResponse == null) || (paramErrorMessage.isFail()))
    {
      CheckDirtyContentSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishCheckDirtyContentSegment, new ErrorMessage(paramErrorMessage.errorCode, paramErrorMessage.getErrorMessage()));
      return;
    }
    CheckDirtyContentSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishCheckDirtyContentSegment, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */