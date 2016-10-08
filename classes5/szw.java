import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;

public class szw
  implements Runnable
{
  public szw(LyricViewController paramLyricViewController, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a()))
    {
      Log.w("ModuleController", "seek before set lyric");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_b_of_type_Int > 0))
    {
      LyricViewController localLyricViewController = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController;
      localLyricViewController.jdField_a_of_type_Long -= this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_b_of_type_Int;
    }
    LyricViewController.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\szw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */