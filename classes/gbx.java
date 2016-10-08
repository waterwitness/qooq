import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class gbx
  extends HttpEntityWrapper
{
  public gbx(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InputStream getContent()
  {
    return new GZIPInputStream(this.wrappedEntity.getContent());
  }
  
  public long getContentLength()
  {
    return -1L;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\gbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */