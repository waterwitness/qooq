import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetRelatedVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetRelatedVideoListRespond;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.List;

public class iiz
  implements CmdTaskManger.CommandCallback
{
  public iiz(DefaultPlayerVideoListSynchronizer paramDefaultPlayerVideoListSynchronizer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GetRelatedVideoListRequest paramGetRelatedVideoListRequest, GetRelatedVideoListRespond paramGetRelatedVideoListRespond, ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "get video list return:" + paramErrorMessage);
    if ((paramGetRelatedVideoListRespond == null) || (paramErrorMessage.isFail()))
    {
      this.a.jdField_b_of_type_Boolean = false;
      DefaultPlayerVideoListSynchronizer.a(this.a, paramErrorMessage);
      return;
    }
    paramErrorMessage = (StoryManager)SuperManager.a(5);
    boolean bool = TextUtils.isEmpty(paramGetRelatedVideoListRequest.g);
    if (3 == this.a.k) {}
    for (int i = 4;; i = 1)
    {
      paramGetRelatedVideoListRespond.jdField_a_of_type_JavaUtilList = paramErrorMessage.a(i, DefaultPlayerVideoListSynchronizer.a(this.a, paramGetRelatedVideoListRequest.e), paramGetRelatedVideoListRespond.jdField_a_of_type_JavaUtilList, bool);
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramGetRelatedVideoListRespond.jdField_a_of_type_JavaUtilList);
      this.a.jdField_c_of_type_JavaLangString = paramGetRelatedVideoListRespond.jdField_b_of_type_JavaLangString;
      this.a.i = this.a.jdField_a_of_type_JavaUtilList.size();
      SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "last load position:%d cookie:%s", Integer.valueOf(this.a.i), this.a.jdField_c_of_type_JavaLangString);
      paramErrorMessage = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent(this.a);
      paramErrorMessage.jdField_a_of_type_JavaLangString = this.a.e;
      paramErrorMessage.jdField_b_of_type_JavaLangString = paramGetRelatedVideoListRequest.e;
      paramErrorMessage.jdField_a_of_type_Boolean = false;
      paramGetRelatedVideoListRequest = this.a;
      bool = paramGetRelatedVideoListRespond.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_b_of_type_Boolean = bool;
      paramGetRelatedVideoListRequest.jdField_c_of_type_Boolean = bool;
      paramErrorMessage.c = paramGetRelatedVideoListRespond.jdField_a_of_type_Long;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = this.a.jdField_a_of_type_JavaUtilList;
      paramErrorMessage.jdField_a_of_type_Int = paramGetRelatedVideoListRespond.jdField_b_of_type_Int;
      if (paramErrorMessage.jdField_a_of_type_Int < paramErrorMessage.jdField_a_of_type_JavaUtilList.size()) {
        paramErrorMessage.jdField_a_of_type_Int = paramErrorMessage.jdField_a_of_type_JavaUtilList.size();
      }
      Dispatchers.get().dispatch(paramErrorMessage);
      SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "get video list return:" + paramErrorMessage);
      this.a.jdField_b_of_type_Boolean = false;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iiz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */