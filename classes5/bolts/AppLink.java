package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public class AppLink
{
  private Uri sourceUrl;
  private List<Target> targets;
  private Uri webUrl;
  
  public AppLink(Uri paramUri1, List<Target> paramList, Uri paramUri2)
  {
    this.sourceUrl = paramUri1;
    paramUri1 = paramList;
    if (paramList == null) {
      paramUri1 = Collections.emptyList();
    }
    this.targets = paramUri1;
    this.webUrl = paramUri2;
  }
  
  public Uri getSourceUrl()
  {
    return this.sourceUrl;
  }
  
  public List<Target> getTargets()
  {
    return Collections.unmodifiableList(this.targets);
  }
  
  public Uri getWebUrl()
  {
    return this.webUrl;
  }
  
  public static class Target
  {
    private final String appName;
    private final String className;
    private final String packageName;
    private final Uri url;
    
    public Target(String paramString1, String paramString2, Uri paramUri, String paramString3)
    {
      this.packageName = paramString1;
      this.className = paramString2;
      this.url = paramUri;
      this.appName = paramString3;
    }
    
    public String getAppName()
    {
      return this.appName;
    }
    
    public String getClassName()
    {
      return this.className;
    }
    
    public String getPackageName()
    {
      return this.packageName;
    }
    
    public Uri getUrl()
    {
      return this.url;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\bolts\AppLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */