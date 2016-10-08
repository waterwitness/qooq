import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.OrientationEventListener;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.widget.ActionSheet;

public class hsq
  extends OrientationEventListener
{
  public hsq(VideoUIController paramVideoUIController, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {}
    label292:
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt >= 0) && ((paramInt <= 30) || (paramInt >= 330)) && (this.a.jdField_a_of_type_Int != 0))
          {
            if ((this.a.b != 0) && (this.a.a()) && (this.a.jdField_a_of_type_AndroidAppActivity != null))
            {
              this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
              this.a.a(0);
              return;
            }
            this.a.jdField_a_of_type_Int = -1;
            return;
          }
          if ((paramInt < 60) || (paramInt > 120) || (this.a.jdField_a_of_type_Int == 2)) {
            break label292;
          }
          if ((this.a.b == 2) || (!this.a.a()) || (this.a.jdField_a_of_type_AndroidAppActivity == null)) {
            break;
          }
          this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(8);
          this.a.a(2);
        } while (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
        str = Long.toString(this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
        VideoReporter.a("0X80065F7", this.a.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), 2, this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), str);
        ReportController.b(null, "CliOper", "", "", "0X8006698", "0X8006698", 0, 0, Integer.toString(this.a.s), "2", str, this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        return;
        this.a.jdField_a_of_type_Int = -1;
        return;
      } while ((paramInt < 240) || (paramInt > 300) || (this.a.jdField_a_of_type_Int == 1));
      if ((this.a.b == 1) || (!this.a.a()) || (this.a.jdField_a_of_type_AndroidAppActivity == null)) {
        break;
      }
      this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      this.a.a(1);
    } while (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
    String str = Long.toString(this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    VideoReporter.a("0X80065F7", this.a.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), 2, this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), str);
    ReportController.b(null, "CliOper", "", "", "0X8006698", "0X8006698", 0, 0, Integer.toString(this.a.s), "2", str, this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
    return;
    this.a.jdField_a_of_type_Int = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */