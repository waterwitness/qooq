import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspComment;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ioe
  extends ProtoUtils.TroopProtocolObserver
{
  public ioe(StoryPlayVideoActivity paramStoryPlayVideoActivity, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (paramArrayOfByte == null)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getApplicationContext(), 1, "消息发送失败，请稍后重试", 0).a();
      QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "sendComment - fail, data == null");
      return;
    }
    paramBundle = new qqstory_service.RspComment();
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.result.error_code.get();
        paramArrayOfByte = paramBundle.result.error_desc.get().toStringUtf8();
        if (paramInt != 0) {
          break label194;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getApplicationContext(), 2, "消息已发送", 0).a();
        StoryReportor.b("story_net", StoryPlayVideoActivity.C, 0, paramInt, new String[] { "", l1 - l2 + "", StoryReportor.a(BaseApplication.getContext()) });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "sendComment - onResult, e:" + paramArrayOfByte.getMessage());
      return;
      label194:
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getApplicationContext(), 1, "消息发送失败，请稍后重试", 0).a();
      QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "sendComment - fail, errCode:" + paramInt + ", msg: " + paramArrayOfByte);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ioe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */