import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll;

public class szx
  implements Runnable
{
  public szx(LyricViewController paramLyricViewController, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a.a();
    LyricViewController.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController).b(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a.a());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\szx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */