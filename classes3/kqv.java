import android.view.View;
import com.tencent.mobileqq.activity.BlessPTVActivity;
import com.tencent.mobileqq.activity.BlessPTVActivity.MusicItemData;
import com.tencent.mobileqq.activity.bless.CountDownView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;

public class kqv
  implements Runnable
{
  public kqv(BlessPTVActivity paramBlessPTVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (BlessPTVActivity.a(this.a).jdField_d_of_type_Int <= 0) {
      BlessPTVActivity.a(this.a).jdField_d_of_type_Int = this.a.b();
    }
    this.a.c.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityBlessCountDownView.a();
    BlessPTVActivity.a(this.a, BlessPTVActivity.a(this.a).jdField_d_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail, false);
    this.a.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */