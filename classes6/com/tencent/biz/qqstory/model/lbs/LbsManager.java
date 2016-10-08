package com.tencent.biz.qqstory.model.lbs;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import ijq;
import mqq.util.WeakReference;

public class LbsManager
  implements IManager
{
  public static BasicLocation a;
  public static final String a = "LbsManager";
  
  public LbsManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static BasicLocation a()
  {
    return a;
  }
  
  public void a()
  {
    SLog.b("LbsManager", "onInit");
  }
  
  public void a(LbsManager.POIListRequestSession paramPOIListRequestSession, LbsManager.POIListRequestCallback paramPOIListRequestCallback)
  {
    WeakReference localWeakReference = new WeakReference(paramPOIListRequestCallback);
    if (paramPOIListRequestSession == null) {
      paramPOIListRequestCallback = LbsManager.POIListRequestSession.a();
    }
    for (;;)
    {
      SLog.b("LbsManager", "requestPoiList");
      paramPOIListRequestSession = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramPOIListRequestCallback.jdField_a_of_type_JavaLangString)) {
        paramPOIListRequestSession.start_cookie.set(ByteStringMicro.copyFromUtf8(paramPOIListRequestCallback.jdField_a_of_type_JavaLangString));
      }
      paramPOIListRequestSession.coordinate.set(1);
      paramPOIListRequestSession.count.set(paramPOIListRequestCallback.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramPOIListRequestCallback.jdField_b_of_type_JavaLangString)) {
        paramPOIListRequestSession.keyword.set(ByteStringMicro.copyFromUtf8(paramPOIListRequestCallback.jdField_b_of_type_JavaLangString));
      }
      paramPOIListRequestSession.gps.lat.set(a.jdField_a_of_type_Int);
      paramPOIListRequestSession.gps.lng.set(a.b);
      paramPOIListRequestSession.gps.setHasFlag(true);
      Bundle localBundle = new Bundle();
      CmdTaskManger.a().a(new CommonRequest("StorySvc.get_poi_list", paramPOIListRequestSession, localBundle), new ijq(this, localWeakReference, paramPOIListRequestCallback));
      return;
      paramPOIListRequestCallback = paramPOIListRequestSession;
      if (!TextUtils.isEmpty(paramPOIListRequestSession.jdField_a_of_type_JavaLangString))
      {
        paramPOIListRequestSession.jdField_b_of_type_Boolean = false;
        paramPOIListRequestCallback = paramPOIListRequestSession;
      }
    }
  }
  
  public void b()
  {
    SLog.b("LbsManager", "onDestroy");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\lbs\LbsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */