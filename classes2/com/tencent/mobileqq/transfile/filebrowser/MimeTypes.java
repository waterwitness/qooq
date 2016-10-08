package com.tencent.mobileqq.transfile.filebrowser;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public class MimeTypes
{
  private Map a;
  
  public MimeTypes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new HashMap();
  }
  
  public String a(String paramString)
  {
    paramString = FileUtils.a(paramString);
    return (String)this.a.get(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\filebrowser\MimeTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */