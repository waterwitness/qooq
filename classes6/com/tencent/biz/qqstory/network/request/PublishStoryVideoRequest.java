package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqPublishVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo;
import com.tencent.biz.qqstory.network.response.PublishStoryVideoRespond;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.json.JSONObject;

public class PublishStoryVideoRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory.publish.PublishStoryVideoRequest";
  public static final String b = "StorySvc.video_show_publish";
  public int a;
  public long a;
  public AddressItem a;
  public int b;
  public long b;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public PublishStoryVideoRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspPublishVideo localRspPublishVideo = new qqstory_service.RspPublishVideo();
    try
    {
      localRspPublishVideo.mergeFrom(paramArrayOfByte);
      return new PublishStoryVideoRespond(localRspPublishVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_show_publish";
  }
  
  protected byte[] a()
  {
    if (TextUtils.isEmpty(this.d)) {
      throw new IllegalArgumentException("vid is null");
    }
    if (this.jdField_a_of_type_Long <= 0L) {
      throw new IllegalArgumentException("video duration is " + this.jdField_a_of_type_Long);
    }
    if (TextUtils.isEmpty(this.e)) {
      throw new IllegalArgumentException("video url is " + this.e);
    }
    qqstory_service.ReqPublishVideo localReqPublishVideo = new qqstory_service.ReqPublishVideo();
    localReqPublishVideo.title.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    localReqPublishVideo.vid.set(ByteStringMicro.copyFromUtf8(this.d));
    localReqPublishVideo.video_url.set(ByteStringMicro.copyFromUtf8(this.e));
    localReqPublishVideo.total_time.set(this.jdField_a_of_type_Long);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("video_width", this.jdField_a_of_type_Int);
      localJSONObject.put("video_height", this.jdField_b_of_type_Int);
      localJSONObject.put("video_bytes", this.jdField_c_of_type_Long);
      if (!TextUtils.isEmpty(this.g)) {
        localJSONObject.put("video_doodle_text", this.g);
      }
      localReqPublishVideo.video_attr.set(ByteStringMicro.copyFromUtf8(localJSONObject.toString()));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.b("Q.qqstory.publish.PublishStoryVideoRequest", "encode json fail", localException);
      }
    }
    if (!TextUtils.isEmpty(this.f)) {
      localReqPublishVideo.label.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    if (!TextUtils.isEmpty(this.g)) {
      localReqPublishVideo.doodle_text.set(ByteStringMicro.copyFromUtf8(this.g));
    }
    if (!TextUtils.isEmpty(this.h)) {
      localReqPublishVideo.video_cover.set(ByteStringMicro.copyFromUtf8(this.h));
    }
    if (!TextUtils.isEmpty(this.i)) {
      localReqPublishVideo.doodle_url.set(ByteStringMicro.copyFromUtf8(this.i));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem != null) {
      localReqPublishVideo.address = this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem.convertToProtoObject();
    }
    localReqPublishVideo.create_time.set(this.jdField_b_of_type_Long / 1000L);
    return localReqPublishVideo.toByteArray();
  }
  
  public String toString()
  {
    return "PublishStoryVideoRequest{title='" + this.jdField_c_of_type_JavaLangString + '\'' + ", vid='" + this.d + '\'' + ", videoThumbnailUrl='" + this.h + '\'' + ", mOriginalMaskPicUrl='" + this.i + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\PublishStoryVideoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */