import android.graphics.Rect;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixg
  extends GestureHelper.ZoomItem
{
  public Rect a;
  public String a;
  
  public ixg()
  {
    super(0.0F, 0.0F);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ixg(ixg paramixg, float paramFloat)
  {
    super(paramixg, paramFloat);
    this.jdField_a_of_type_JavaLangString = paramixg.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect((int)(paramixg.jdField_a_of_type_AndroidGraphicsRect.left * paramFloat), (int)(paramixg.jdField_a_of_type_AndroidGraphicsRect.top * paramFloat), (int)(paramixg.jdField_a_of_type_AndroidGraphicsRect.right * paramFloat), (int)(paramixg.jdField_a_of_type_AndroidGraphicsRect.bottom * paramFloat));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */