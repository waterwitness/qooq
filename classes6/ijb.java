import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetTopicVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetTopicVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.List;

public class ijb
  implements CmdTaskManger.CommandCallback
{
  public ijb(DefaultPlayerVideoListSynchronizer paramDefaultPlayerVideoListSynchronizer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GetTopicVideoListRequest paramGetTopicVideoListRequest, GetTopicVideoListResponse paramGetTopicVideoListResponse, ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "get video list return:" + paramErrorMessage);
    if ((paramGetTopicVideoListResponse == null) || (paramErrorMessage.isFail()))
    {
      this.a.jdField_b_of_type_Boolean = false;
      DefaultPlayerVideoListSynchronizer.a(this.a, paramErrorMessage);
      return;
    }
    paramErrorMessage = (StoryManager)SuperManager.a(5);
    boolean bool = TextUtils.isEmpty(paramGetTopicVideoListRequest.jdField_c_of_type_JavaLangString);
    if (bool) {
      this.a.jdField_a_of_type_JavaUtilList.clear();
    }
    paramGetTopicVideoListResponse.jdField_a_of_type_JavaUtilList = paramErrorMessage.a(this.a.jdField_b_of_type_Long, paramGetTopicVideoListResponse.jdField_a_of_type_JavaUtilList, bool);
    this.a.jdField_a_of_type_JavaUtilList.addAll(paramGetTopicVideoListResponse.jdField_a_of_type_JavaUtilList);
    this.a.jdField_c_of_type_JavaLangString = paramGetTopicVideoListResponse.jdField_c_of_type_JavaLangString;
    this.a.i = this.a.jdField_a_of_type_JavaUtilList.size();
    SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "last load position:%d cookie:%s", Integer.valueOf(this.a.i), this.a.jdField_c_of_type_JavaLangString);
    paramGetTopicVideoListRequest = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent(this.a);
    paramGetTopicVideoListRequest.jdField_a_of_type_JavaLangString = this.a.e;
    paramGetTopicVideoListRequest.jdField_b_of_type_Long = this.a.jdField_b_of_type_Long;
    paramGetTopicVideoListRequest.jdField_a_of_type_Boolean = false;
    paramErrorMessage = this.a;
    bool = paramGetTopicVideoListResponse.jdField_a_of_type_Boolean;
    paramGetTopicVideoListRequest.jdField_b_of_type_Boolean = bool;
    paramErrorMessage.jdField_c_of_type_Boolean = bool;
    paramGetTopicVideoListRequest.c = paramGetTopicVideoListResponse.jdField_a_of_type_Long;
    paramGetTopicVideoListRequest.jdField_a_of_type_JavaUtilList = this.a.jdField_a_of_type_JavaUtilList;
    paramGetTopicVideoListRequest.jdField_a_of_type_Int = paramGetTopicVideoListResponse.b;
    if (paramGetTopicVideoListRequest.jdField_a_of_type_Int < paramGetTopicVideoListRequest.jdField_a_of_type_JavaUtilList.size()) {
      paramGetTopicVideoListRequest.jdField_a_of_type_Int = paramGetTopicVideoListRequest.jdField_a_of_type_JavaUtilList.size();
    }
    Dispatchers.get().dispatch(paramGetTopicVideoListRequest);
    SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "get topic video list return:", paramGetTopicVideoListRequest);
    this.a.jdField_b_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */