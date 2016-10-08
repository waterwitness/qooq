package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class FileUtil$MyFileCompare
  implements Comparator
{
  public FileUtil$MyFileCompare()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.a()) {
      if (paramFileInfo2.a()) {
        break label25;
      }
    }
    label25:
    while (paramFileInfo1.b() > paramFileInfo2.b())
    {
      return -1;
      if (paramFileInfo2.a()) {
        return 1;
      }
    }
    if (paramFileInfo1.b() == paramFileInfo2.b()) {
      return 0;
    }
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\FileUtil$MyFileCompare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */