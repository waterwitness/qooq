import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nvk
  implements Runnable
{
  public nvk(PhotoListPanel.MyAdapter paramMyAdapter, View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getHitRect(localRect);
    localRect.left -= this.jdField_a_of_type_Int;
    localRect.top -= this.jdField_b_of_type_Int;
    localRect.right += this.c;
    localRect.bottom += this.d;
    this.jdField_b_of_type_AndroidViewView.setTouchDelegate(new TouchDelegate(localRect, this.jdField_a_of_type_AndroidViewView));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */