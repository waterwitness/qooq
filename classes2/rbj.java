import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rbj
{
  public static final int a = 0;
  public static final Uri a;
  public static final String[] a;
  public static final int b = 2;
  public static final int c = 3;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidNetUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "data1", "display_name", "contact_id", "raw_contact_id" };
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\rbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */