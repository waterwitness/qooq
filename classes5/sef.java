import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sef
  extends GestureDetector.SimpleOnGestureListener
{
  public sef(FileBrowserActivity paramFileBrowserActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    do
    {
      return false;
      paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    } while ((paramMotionEvent1.getX() >= this.jdField_a_of_type_Int / 10) || (paramFloat1 > -this.jdField_a_of_type_Int) || (paramFloat2 >= 0.5F) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.a.a()));
    return FileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */