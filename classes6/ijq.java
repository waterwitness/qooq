import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import mqq.util.WeakReference;

public class ijq
  extends CmdTaskManger.UIThreadCallback
{
  public ijq(LbsManager paramLbsManager, WeakReference paramWeakReference, LbsManager.POIListRequestSession paramPOIListRequestSession)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(CommonRequest paramCommonRequest, CommonResponse paramCommonResponse, ErrorMessage paramErrorMessage)
  {
    if (paramCommonResponse == null)
    {
      SLog.d("LbsManager", "response is null");
      paramCommonRequest = (LbsManager.POIListRequestCallback)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramCommonRequest != null) {
        paramCommonRequest.a(paramErrorMessage.errorCode, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, Collections.EMPTY_LIST);
      }
    }
    label369:
    label397:
    do
    {
      return;
      paramCommonRequest = new qqstory_service.RspGetPOIList();
      paramCommonResponse = paramCommonResponse.a;
      try
      {
        paramCommonRequest.mergeFrom(paramCommonResponse);
        paramCommonResponse = new ArrayList();
        if (paramCommonRequest.result.error_code.get() == 0)
        {
          paramErrorMessage = paramCommonRequest.poi_list.get();
          SLog.b("LbsManager", "poiListSize = " + paramCommonRequest.poi_list.size());
          SLog.b("LbsManager", "poiList isend = " + paramCommonRequest.is_end.get());
          if (paramErrorMessage.size() > 0) {
            if (paramCommonRequest.is_end.get() > 0)
            {
              i = 1;
              localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession;
              if (i != 0) {
                break label369;
              }
              bool = true;
              ((LbsManager.POIListRequestSession)localObject).jdField_a_of_type_Boolean = bool;
              localObject = paramCommonRequest.next_cookie.get().toStringUtf8();
              if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.jdField_a_of_type_JavaUtilHashSet.contains(localObject)) {
                break label397;
              }
              i = 0;
              while (i < paramErrorMessage.size())
              {
                qqstory_struct.Address localAddress = (qqstory_struct.Address)paramErrorMessage.get(i);
                paramCommonResponse.add(new TroopBarPOI("", localAddress.city.get().toStringUtf8(), localAddress.building.get().toStringUtf8(), localAddress.longitude.get(), localAddress.street.get().toStringUtf8(), localAddress.latitude.get(), localAddress.province.get().toString()));
                i += 1;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramCommonResponse)
      {
        Object localObject;
        for (;;)
        {
          SLog.e("LbsManager", "InvalidProtocolBufferMicroException: " + paramCommonResponse.getMessage());
          continue;
          int i = 0;
          continue;
          boolean bool = false;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.jdField_a_of_type_JavaUtilHashSet.add(localObject);
        this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.jdField_a_of_type_JavaLangString = ((String)localObject);
        paramErrorMessage = (LbsManager.POIListRequestCallback)this.jdField_a_of_type_MqqUtilWeakReference.get();
      }
    } while (paramErrorMessage == null);
    paramErrorMessage.a(paramCommonRequest.result.error_code.get(), this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, paramCommonResponse);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */