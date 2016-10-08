import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.request.GetUserVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetUserVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.List;

public class ija
  implements CmdTaskManger.CommandCallback
{
  public ija(DefaultPlayerVideoListSynchronizer paramDefaultPlayerVideoListSynchronizer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GetUserVideoListRequest paramGetUserVideoListRequest, GetUserVideoListResponse paramGetUserVideoListResponse, ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "get video list return:" + paramErrorMessage);
    if ((paramGetUserVideoListResponse == null) || (paramErrorMessage.isFail()))
    {
      this.a.b = false;
      DefaultPlayerVideoListSynchronizer.a(this.a, paramErrorMessage);
      return;
    }
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    boolean bool = TextUtils.isEmpty(paramGetUserVideoListRequest.jdField_c_of_type_JavaLangString);
    if ((bool) && (paramGetUserVideoListRequest.jdField_a_of_type_Long == QQStoryContext.a().a()))
    {
      paramErrorMessage = new ArrayList();
      paramErrorMessage.addAll(localStoryManager.a());
      paramErrorMessage.addAll(paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList);
      paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList = paramErrorMessage;
    }
    if (this.a.k == 4)
    {
      paramErrorMessage = localStoryManager.a(paramGetUserVideoListRequest.jdField_a_of_type_Long, 1);
      if (paramErrorMessage != null)
      {
        paramErrorMessage.totalTime = paramGetUserVideoListResponse.jdField_a_of_type_Long;
        if (this.a.k == 4)
        {
          if (!bool) {
            break label521;
          }
          this.a.l = paramErrorMessage.videoCount;
        }
        label186:
        paramErrorMessage.videoCount = paramGetUserVideoListResponse.b;
        if (this.a.k != 4) {
          break label535;
        }
        localStoryManager.a(paramGetUserVideoListRequest.jdField_a_of_type_Long, 1, paramErrorMessage);
      }
      label217:
      if (bool) {
        this.a.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.a.k != 4) {
        break label550;
      }
    }
    label521:
    label535:
    label550:
    for (paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList = localStoryManager.a(this.a.jdField_a_of_type_Long, 1, paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList, bool);; paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList = localStoryManager.a(this.a.jdField_a_of_type_Long, 0, paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList, bool))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList);
      this.a.jdField_c_of_type_JavaLangString = paramGetUserVideoListResponse.jdField_c_of_type_JavaLangString;
      this.a.i = this.a.jdField_a_of_type_JavaUtilList.size();
      SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "last load position:%d cookie:%s", Integer.valueOf(this.a.i), this.a.jdField_c_of_type_JavaLangString);
      paramGetUserVideoListRequest = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent(this.a);
      paramGetUserVideoListRequest.jdField_a_of_type_JavaLangString = this.a.e;
      paramGetUserVideoListRequest.jdField_a_of_type_Long = this.a.jdField_a_of_type_Long;
      paramGetUserVideoListRequest.jdField_a_of_type_Boolean = false;
      paramErrorMessage = this.a;
      bool = paramGetUserVideoListResponse.jdField_a_of_type_Boolean;
      paramGetUserVideoListRequest.b = bool;
      paramErrorMessage.jdField_c_of_type_Boolean = bool;
      paramGetUserVideoListRequest.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry = paramGetUserVideoListResponse.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry;
      paramGetUserVideoListRequest.c = paramGetUserVideoListResponse.jdField_a_of_type_Long;
      paramGetUserVideoListRequest.jdField_a_of_type_JavaUtilList = this.a.jdField_a_of_type_JavaUtilList;
      paramGetUserVideoListRequest.jdField_a_of_type_Int = paramGetUserVideoListResponse.b;
      if (paramGetUserVideoListRequest.jdField_a_of_type_Int < paramGetUserVideoListRequest.jdField_a_of_type_JavaUtilList.size()) {
        paramGetUserVideoListRequest.jdField_a_of_type_Int = paramGetUserVideoListRequest.jdField_a_of_type_JavaUtilList.size();
      }
      Dispatchers.get().dispatch(paramGetUserVideoListRequest);
      SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "get video list return:" + paramGetUserVideoListRequest);
      this.a.b = false;
      return;
      paramErrorMessage = localStoryManager.a(paramGetUserVideoListRequest.jdField_a_of_type_Long, 0);
      break;
      paramGetUserVideoListResponse.b = this.a.l;
      break label186;
      localStoryManager.a(paramGetUserVideoListRequest.jdField_a_of_type_Long, 0, paramErrorMessage);
      break label217;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ija.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */