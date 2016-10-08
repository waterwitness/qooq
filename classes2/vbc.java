import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

public final class vbc
  extends DefaultRedirectHandler
{
  public vbc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    URI localURI = super.getLocationURI(paramHttpResponse, paramHttpContext);
    paramHttpResponse = paramHttpContext.getAttribute("mobileqq_report_flag");
    if ((paramHttpResponse != null) && ((paramHttpResponse instanceof Integer)) && (((Integer)paramHttpResponse).intValue() > 0))
    {
      Object localObject = paramHttpContext.getAttribute("mobileqq_direct_url");
      paramHttpResponse = (HttpResponse)localObject;
      if (localObject == null)
      {
        paramHttpResponse = new ArrayList();
        paramHttpContext.setAttribute("mobileqq_direct_url", paramHttpResponse);
      }
      if ((paramHttpResponse != null) && ((paramHttpResponse instanceof List)))
      {
        paramHttpContext = localURI.toString();
        ((List)paramHttpResponse).add(paramHttpContext);
      }
    }
    return localURI;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */