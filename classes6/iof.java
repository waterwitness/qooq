import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes;
import com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class iof
  extends ProtoUtils.TroopProtocolObserver
{
  public iof(long paramLong1, Activity paramActivity, String paramString, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    paramBundle = new qqstory_service.RspGetUserVideoInfo();
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.StoryVideoDes)paramBundle.video_info.get();
        localObject = paramBundle.result.error_desc.get().toStringUtf8();
        paramInt = paramBundle.result.error_code.get();
        if (paramInt != 0) {
          continue;
        }
        paramBundle = new StoryVideoItem();
        paramBundle.id = 0L;
        paramBundle.mVid = paramArrayOfByte.vid.get().toStringUtf8();
        paramBundle.mCreateTime = paramArrayOfByte.create_time.get();
        paramBundle.mLocation = AddressItem.getAddressFromProtoObject((qqstory_struct.Address)paramArrayOfByte.address.get());
        paramBundle.mLabel = paramArrayOfByte.label.get().toStringUtf8();
        paramBundle.mOriginalMaskPicUrl = paramArrayOfByte.doodle_url.get().toStringUtf8();
        paramBundle.mVideoUrl = paramArrayOfByte.video_url.get().toStringUtf8();
        paramBundle.mVideoThumbnailUrl = paramArrayOfByte.video_cover.get().toStringUtf8();
        ((StoryManager)SuperManager.a(5)).a(paramBundle.mVid, paramBundle);
        localObject = new QQUserUIItem();
        ((QQUserUIItem)localObject).convertFrom(paramArrayOfByte.owner);
        ((UserManager)SuperManager.a(2)).a((QQUserUIItem)localObject);
        paramBundle.mOwnerUid = ((QQUserUIItem)localObject).uid;
        StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.b);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "getVideoInfo - onResult, e:" + paramArrayOfByte.getMessage());
        return;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, (CharSequence)localObject, 0).a();
        continue;
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, "拉取视频出错：" + paramInt, 0).a();
        continue;
      }
      StoryReportor.b("story_net", StoryPlayVideoActivity.D, 0, paramInt, new String[] { "", l1 - l2 + "", StoryReportor.a(BaseApplication.getContext()) });
      return;
      if (paramInt != 10100) {
        continue;
      }
      paramArrayOfByte = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryWarningActivity.class);
      paramArrayOfByte.putExtra("tipsResource", 2131366435);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramArrayOfByte);
      QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "video already deleted. vid:" + this.jdField_a_of_type_JavaLangString + ", cmd:StorySvc.get_video_info errCode:" + paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */