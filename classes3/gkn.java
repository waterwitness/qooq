import android.text.TextUtils;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.random.RandomWebProtocol.OnRequestListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class gkn
  extends Thread
{
  public gkn(RandomWebProtocol paramRandomWebProtocol, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    gkv localgkv = new gkv(this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "null"))) {
      localgkv.a = this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.b, this.jdField_a_of_type_JavaLangString);
    }
    if (localgkv.a != null) {}
    for (int i = 0;; i = -1)
    {
      int j = 0;
      while (j < this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a.size())
      {
        ((RandomWebProtocol.OnRequestListener)this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a.get(j)).a(i, localgkv);
        j += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */