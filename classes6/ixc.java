import android.graphics.Matrix;
import android.graphics.Path;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.LinkedList;
import java.util.List;

public class ixc
  implements DoodleItem
{
  public int a;
  public Path a;
  public List a;
  public int b;
  public List b;
  public int c;
  
  public ixc(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
  }
  
  public ixc(ixc paramixc, float paramFloat)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, paramFloat);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramixc.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
    this.jdField_a_of_type_Int = paramixc.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramixc.jdField_b_of_type_Int;
    this.c = ((int)(paramixc.c * paramFloat));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */