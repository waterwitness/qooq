package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FilenameFilter;
import org.json.JSONArray;

class ChatFontJsPlugin$1
  implements FilenameFilter
{
  ChatFontJsPlugin$1(ChatFontJsPlugin paramChatFontJsPlugin, JSONArray paramJSONArray)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = new File(paramFile.getAbsolutePath() + File.separatorChar + paramString);
    if (paramFile.isDirectory()) {
      paramFile.listFiles(new ChatFontJsPlugin.1.1(this));
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ChatFontJsPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */