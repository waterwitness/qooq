import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.model.DoodleEmojiManager.DoodleEmojiItemComparator;
import com.tencent.biz.qqstory.model.DoodleEmojiManager.DoodleEmojiUpdateEvent;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.DoodleEmojiItem;
import com.tencent.biz.qqstory.network.request.GetEmojiPackInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse;
import com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse.EmojiPack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ijj
  implements CmdTaskManger.CommandCallback
{
  public ijj(DoodleEmojiManager paramDoodleEmojiManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GetEmojiPackInfoListRequest paramGetEmojiPackInfoListRequest, GetEmojiPackInfoListResponse paramGetEmojiPackInfoListResponse, ErrorMessage arg3)
  {
    SLog.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramGetEmojiPackInfoListResponse + ", errorMsg = " + ???);
    synchronized (this.a.b)
    {
      if (!TextUtils.equals(paramGetEmojiPackInfoListRequest.a, this.a.g))
      {
        SLog.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramGetEmojiPackInfoListResponse);
        return;
      }
      if ((paramGetEmojiPackInfoListResponse == null) || (???.isFail()))
      {
        SLog.d("DoodleEmojiManager", "get emoji error : " + paramGetEmojiPackInfoListResponse + ", " + ???);
        return;
      }
    }
    this.a.g = paramGetEmojiPackInfoListResponse.b;
    ??? = (StoryConfigManager)SuperManager.a(10);
    for (;;)
    {
      GetEmojiPackInfoListResponse.EmojiPack localEmojiPack;
      synchronized (this.a.jdField_a_of_type_JavaUtilList)
      {
        if (TextUtils.isEmpty(paramGetEmojiPackInfoListRequest.a)) {
          this.a.jdField_a_of_type_JavaUtilList.clear();
        }
        Iterator localIterator = paramGetEmojiPackInfoListResponse.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label409;
        }
        localEmojiPack = (GetEmojiPackInfoListResponse.EmojiPack)localIterator.next();
        if (localEmojiPack.d == 1)
        {
          paramGetEmojiPackInfoListRequest = (DoodleEmojiItem)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localEmojiPack.a);
          if (paramGetEmojiPackInfoListRequest == null) {
            break label487;
          }
          paramGetEmojiPackInfoListRequest = paramGetEmojiPackInfoListRequest.a();
          DoodleEmojiItem localDoodleEmojiItem = new DoodleEmojiItem(localEmojiPack);
          localDoodleEmojiItem.a(paramGetEmojiPackInfoListRequest);
          DoodleEmojiManager.a((StoryConfigManager)???, localDoodleEmojiItem.a, localDoodleEmojiItem.b);
          DoodleEmojiManager.b((StoryConfigManager)???, localDoodleEmojiItem.a, localDoodleEmojiItem.d);
          this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEmojiPack.a, localDoodleEmojiItem);
          this.a.jdField_a_of_type_JavaUtilList.remove(localDoodleEmojiItem);
          this.a.jdField_a_of_type_JavaUtilList.add(localDoodleEmojiItem);
          SLog.a("DoodleEmojiManager", "from network get doodle item : %s", localDoodleEmojiItem);
        }
      }
      DoodleEmojiManager.a((StoryConfigManager)???, localEmojiPack.a, localEmojiPack.b);
      SLog.a("DoodleEmojiManager", "ignore non-emoji pack : %s", localEmojiPack);
      continue;
      label409:
      Collections.sort(this.a.jdField_a_of_type_JavaUtilList, new DoodleEmojiManager.DoodleEmojiItemComparator("1"));
      Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiUpdateEvent());
      if (!paramGetEmojiPackInfoListResponse.jdField_a_of_type_Boolean)
      {
        DoodleEmojiManager.b(this.a);
        return;
      }
      if (TextUtils.isEmpty("1")) {
        break;
      }
      SLog.b("DoodleEmojiManager", "start download default emoji pack if needed : 1");
      this.a.a("1", false);
      return;
      label487:
      paramGetEmojiPackInfoListRequest = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */