package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class FileCompare
  implements Comparator
{
  public FileCompare()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.a())
    {
      if (!paramFileInfo2.a()) {
        return 64536;
      }
    }
    else if (paramFileInfo2.a()) {
      return 1000;
    }
    return paramFileInfo1.e().compareToIgnoreCase(paramFileInfo2.e());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\FileCompare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */