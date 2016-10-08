import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class hri
  extends PublicAccountObserver
{
  public hri(VideoListView paramVideoListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoListView", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      paramString = (TextView)this.a.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298766);
      paramString.setText("已关注");
      paramString.setTextColor(872415231);
      paramString.setBackgroundDrawable(null);
      ReportController.b(null, "CliOper", "", "", "0X8006762", "0X8006762", 0, 0, "", this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_BIZ_SOURCE_DYH"), "", this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */