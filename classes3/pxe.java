import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class pxe
{
  public byte a;
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  private pxe(DiscussionIconHelper paramDiscussionIconHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Byte = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(byte paramByte)
  {
    if (paramByte == 3)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Byte = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.c = false;
      this.d = false;
    }
    while (paramByte != 2) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */