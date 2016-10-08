import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pkh
  implements DialogInterface.OnClickListener
{
  public pkh(ShortVideoPlayActivity paramShortVideoPlayActivity, VideoInfo paramVideoInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pkh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */