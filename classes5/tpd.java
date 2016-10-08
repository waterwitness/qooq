import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.View.DragShadowBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class tpd
  extends View.DragShadowBuilder
{
  public int a;
  
  public tpd(NearbyProfileEditPanel paramNearbyProfileEditPanel, View paramView)
  {
    super(paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.E * 1.4D));
  }
  
  public void onDrawShadow(Canvas paramCanvas)
  {
    getView().setDrawingCacheEnabled(false);
    getView().setDrawingCacheEnabled(true);
    Object localObject = new Paint();
    ((Paint)localObject).setShadowLayer(10.0F, 0.0F, 0.0F, -16777216);
    paramCanvas.drawRect(new Rect(10, 10, this.jdField_a_of_type_Int + 10, this.jdField_a_of_type_Int + 10), (Paint)localObject);
    localObject = getView().getDrawingCache();
    Matrix localMatrix = new Matrix();
    float f = this.jdField_a_of_type_Int / ((Bitmap)localObject).getWidth();
    localMatrix.postScale(f, f);
    paramCanvas.drawBitmap(Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true), 10.0F, 10.0F, null);
  }
  
  public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    int i = this.jdField_a_of_type_Int + 20;
    int j = this.jdField_a_of_type_Int + 20;
    paramPoint1.set(i, j);
    paramPoint2.set(i / 2, j / 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */