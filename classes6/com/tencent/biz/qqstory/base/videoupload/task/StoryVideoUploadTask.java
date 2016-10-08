package com.tencent.biz.qqstory.base.videoupload.task;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.videoupload.meta.GenerateVideoSegment;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iim;
import iin;
import iio;
import iip;
import iiq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class StoryVideoUploadTask
  extends BasePublishTask
{
  public static final String b = "Q.qqstory.publish:StoryVideoUploadTask";
  
  public StoryVideoUploadTask(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    super(paramStoryVideoTaskInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    paramStoryVideoTaskInfo.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((!TextUtils.isEmpty(paramStoryVideoTaskInfo.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(paramStoryVideoTaskInfo.j)))
    {
      ImageFileObject localImageFileObject = new ImageFileObject(true);
      localImageFileObject.jdField_b_of_type_JavaLangString = paramStoryVideoTaskInfo.jdField_c_of_type_JavaLangString;
      localImageFileObject.a(new iim(this, paramStoryVideoTaskInfo));
      paramStoryVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localImageFileObject);
      return;
    }
    SLog.b("Q.qqstory.publish:StoryVideoUploadTask", "mask image had uploaded or null");
  }
  
  protected List a()
  {
    ArrayList localArrayList = new ArrayList(1);
    Object localObject = ((StoryVideoTaskInfo)this.a).a();
    String str = ((PublishVideoEntry)localObject).mLocalRawVideoDir;
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.K = (int)((PublishVideoEntry)localObject).recordTime;
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.L = ((PublishVideoEntry)localObject).recordFrames;
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.R = ((PublishVideoEntry)localObject).saveMode;
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.J = 0;
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.M = 0;
    if ((TextUtils.isEmpty(((StoryVideoTaskInfo)this.a).h)) && (TextUtils.isEmpty(((StoryVideoTaskInfo)this.a).jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str)))
    {
      localObject = new GenerateVideoSegment(str, ((PublishVideoEntry)localObject).mMosaicMask, ((PublishVideoEntry)localObject).mMosaicSize, ((PublishVideoEntry)localObject).backgroundMusicPath, ((PublishVideoEntry)localObject).backgroundMusicOffset, ((PublishVideoEntry)localObject).isMuteRecordVoice);
      ((GenerateVideoSegment)localObject).a(new iin(this));
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  protected List b()
  {
    ArrayList localArrayList = new ArrayList(2);
    Object localObject;
    if ((TextUtils.isEmpty(((StoryVideoTaskInfo)this.a).h)) && (!TextUtils.isEmpty(((StoryVideoTaskInfo)this.a).jdField_a_of_type_JavaLangString)))
    {
      localObject = new StoryVideoFileObject(((StoryVideoTaskInfo)this.a).jdField_a_of_type_JavaLangString, ((StoryVideoTaskInfo)this.a).g, ((StoryVideoTaskInfo)this.a).jdField_e_of_type_Int);
      ((StoryVideoFileObject)localObject).a(new iio(this));
      localArrayList.add(localObject);
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(((StoryVideoTaskInfo)this.a).k)) && (!TextUtils.isEmpty(((StoryVideoTaskInfo)this.a).jdField_b_of_type_JavaLangString)))
      {
        localObject = new ImageFileObject(false);
        ((ImageFileObject)localObject).jdField_b_of_type_JavaLangString = ((StoryVideoTaskInfo)this.a).jdField_b_of_type_JavaLangString;
        ((ImageFileObject)localObject).a(new iip(this));
        localArrayList.add(localObject);
      }
      return localArrayList;
      SLog.b("Q.qqstory.publish:StoryVideoUploadTask", "video had uploaded");
    }
  }
  
  protected void c()
  {
    PublishStoryVideoRequest localPublishStoryVideoRequest = new PublishStoryVideoRequest();
    localPublishStoryVideoRequest.jdField_d_of_type_JavaLangString = ((StoryVideoTaskInfo)this.a).h;
    localPublishStoryVideoRequest.jdField_e_of_type_JavaLangString = ((StoryVideoTaskInfo)this.a).i;
    localPublishStoryVideoRequest.h = ((StoryVideoTaskInfo)this.a).k;
    localPublishStoryVideoRequest.i = ((StoryVideoTaskInfo)this.a).j;
    localPublishStoryVideoRequest.jdField_a_of_type_Long = ((StoryVideoTaskInfo)this.a).jdField_b_of_type_Long;
    localPublishStoryVideoRequest.f = ((StoryVideoTaskInfo)this.a).jdField_d_of_type_JavaLangString;
    localPublishStoryVideoRequest.g = ((StoryVideoTaskInfo)this.a).jdField_e_of_type_JavaLangString;
    localPublishStoryVideoRequest.jdField_b_of_type_Long = ((StoryVideoTaskInfo)this.a).jdField_d_of_type_Long;
    localPublishStoryVideoRequest.jdField_a_of_type_Int = ((StoryVideoTaskInfo)this.a).jdField_c_of_type_Int;
    localPublishStoryVideoRequest.jdField_b_of_type_Int = ((StoryVideoTaskInfo)this.a).jdField_d_of_type_Int;
    localPublishStoryVideoRequest.jdField_c_of_type_Long = ((StoryVideoTaskInfo)this.a).jdField_c_of_type_Long;
    if (!TextUtils.isEmpty(((StoryVideoTaskInfo)this.a).f)) {}
    try
    {
      localPublishStoryVideoRequest.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = AddressItem.convertFromJson(((StoryVideoTaskInfo)this.a).f);
      CmdTaskManger.a().a(localPublishStoryVideoRequest, new iiq(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        SLog.b("Q.qqstory.publish:StoryVideoUploadTask", "addressItem error", localJSONException);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\task\StoryVideoUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */