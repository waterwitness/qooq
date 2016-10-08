import android.util.Pair;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.net.URL;

public class ibv
{
  public Pair a;
  public URL a;
  
  ibv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static ibv a(URL paramURL, Pair paramPair)
  {
    ibv localibv = new ibv();
    localibv.jdField_a_of_type_JavaNetURL = paramURL;
    localibv.jdField_a_of_type_AndroidUtilPair = paramPair;
    return localibv;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */