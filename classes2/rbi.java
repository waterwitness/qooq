import android.net.Uri;
import android.provider.ContactsContract.Data;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rbi
{
  public static final int a = 0;
  public static final Uri a;
  public static final String a = "raw_contact_id=?";
  public static final String[] a;
  public static final int b = 1;
  public static final String b = "mimetype = ?";
  public static final String[] b = { "raw_contact_id", "data1" };
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidNetUri = ContactsContract.Data.CONTENT_URI;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "mimetype", "data1" };
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\rbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */