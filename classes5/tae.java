import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll.LyricViewScrollListener;
import java.util.Timer;
import java.util.TimerTask;

public class tae
  extends TimerTask
{
  int jdField_a_of_type_Int;
  
  public tae(LyricViewScroll paramLyricViewScroll)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Log.v("LyricViewScroll", "fling detect running");
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.getScrollY())
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.b = this.jdField_a_of_type_Int;
      LyricViewScroll.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll).b(this.jdField_a_of_type_Int);
      Log.d("LyricViewScroll", "fling stop");
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.jdField_a_of_type_Boolean = false;
      LyricViewScroll.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll, false);
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.getScrollY();
    LyricViewScroll.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll).a(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */