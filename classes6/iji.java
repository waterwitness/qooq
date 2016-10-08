import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tencent.biz.qqstory.model.item.POIPosterItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.POIPosterData;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;

public class iji
  extends CmdTaskManger.UIThreadCallback
{
  public iji(DoodleEmojiManager paramDoodleEmojiManager, WeakReference paramWeakReference)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(CommonRequest paramCommonRequest, CommonResponse paramCommonResponse, ErrorMessage paramErrorMessage)
  {
    if (paramCommonResponse == null)
    {
      paramCommonRequest = (DoodleEmojiManager.POIPostersRequestCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramCommonRequest != null) {
        paramCommonRequest.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    int i = paramErrorMessage.errorCode;
    paramCommonResponse = paramCommonResponse.a;
    if (i != 0)
    {
      SLog.e("DoodleEmojiManager", "requestPoiFaces cmd StorySvc.video_poi_posters_getfails: " + i);
      return;
    }
    paramCommonRequest = new qqstory_service.RspGetPOIPosters();
    try
    {
      paramCommonRequest.mergeFrom(paramCommonResponse);
      if (paramCommonRequest.result.error_code.get() != 0)
      {
        SLog.e("DoodleEmojiManager", "requestPoiFaces cmd StorySvc.video_poi_posters_getfails: " + paramCommonRequest.result.error_code.get() + "|" + paramCommonRequest.result.error_desc.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramCommonRequest)
    {
      SLog.e("DoodleEmojiManager", "requestPoiFaces cmd StorySvc.video_poi_posters_getfails: " + paramCommonRequest.getMessage());
      return;
    }
    SLog.b("DoodleEmojiManager", "poiPostersList = " + paramCommonRequest.poi_posters.size());
    paramCommonResponse = new ArrayList();
    i = 0;
    while (i < paramCommonRequest.poi_posters.size())
    {
      paramErrorMessage = (qqstory_struct.POIPosterData)paramCommonRequest.poi_posters.get(i);
      paramCommonResponse.add(new POIPosterItem(paramErrorMessage.poster_name.get().toStringUtf8(), paramErrorMessage.name.get().toStringUtf8(), paramErrorMessage.thumb_url.get().toStringUtf8(), paramErrorMessage.poster_url.get().toStringUtf8(), paramErrorMessage.poster_json_layout_desc.get().toStringUtf8()));
      i += 1;
    }
    paramCommonRequest = (DoodleEmojiManager.POIPostersRequestCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramCommonRequest != null)
    {
      paramCommonRequest.a(0, paramCommonResponse);
      return;
    }
    SLog.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */