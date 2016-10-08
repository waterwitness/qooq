import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;

public class szu
  implements Runnable
{
  public szu(LyricViewController paramLyricViewController, Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null) {
      Log.d("ModuleController", "setLyric -> pronounce is null");
    }
    if (this.b == null)
    {
      Log.d("ModuleController", "setLyric -> qrc is null");
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.b(this.c, this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = this.c;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.b(this.b, this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = this.b;
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.c = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\szu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */