import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.GridView;

public class nuu
  extends FrameLayout
{
  public nuu(AIOPhotoListAdapter paramAIOPhotoListAdapter, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = AIOPhotoListAdapter.a(this.a).getPaddingLeft() + getPaddingLeft();
    if (i != paramInt1) {
      offsetLeftAndRight(i - paramInt1);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(AIOPhotoListAdapter.a(this.a).getMeasuredWidth() - AIOPhotoListAdapter.a(this.a).getPaddingLeft() - AIOPhotoListAdapter.a(this.a).getPaddingRight(), View.MeasureSpec.getMode(paramInt1)), paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nuu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */