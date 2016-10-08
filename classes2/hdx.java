import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.bitapp.cache.BitAppFileCache;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public final class hdx
  implements Runnable
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final String jdField_a_of_type_JavaLangString;
  
  public hdx(Context paramContext, String paramString, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void run()
  {
    BitAppFileCache.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap);
    Object localObject = BitAppFileCache.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString);
    try
    {
      localObject = ((File)localObject).toURL();
      URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
      return;
    }
    catch (MalformedURLException localMalformedURLException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */