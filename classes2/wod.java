import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.RectMaskView;

public class wod
  implements Runnable
{
  public wod(RectMaskView paramRectMaskView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRectMaskView.invalidate(this.jdField_a_of_type_Int, this.b, this.c, this.d);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */