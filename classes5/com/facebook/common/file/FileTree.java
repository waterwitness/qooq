package com.facebook.common.file;

import java.io.File;

public class FileTree
{
  public static boolean deleteContents(File paramFile)
  {
    paramFile = paramFile.listFiles();
    boolean bool1 = true;
    boolean bool2 = true;
    int j;
    int i;
    if (paramFile != null)
    {
      j = paramFile.length;
      i = 0;
      bool1 = bool2;
    }
    for (;;)
    {
      if (i >= j) {
        return bool1;
      }
      bool1 &= deleteRecursively(paramFile[i]);
      i += 1;
    }
  }
  
  public static boolean deleteRecursively(File paramFile)
  {
    if (paramFile.isDirectory()) {
      deleteContents(paramFile);
    }
    return paramFile.delete();
  }
  
  public static void walkFileTree(File paramFile, FileTreeVisitor paramFileTreeVisitor)
  {
    paramFileTreeVisitor.preVisitDirectory(paramFile);
    File[] arrayOfFile = paramFile.listFiles();
    int i;
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      i = 0;
      if (i < j) {}
    }
    else
    {
      paramFileTreeVisitor.postVisitDirectory(paramFile);
      return;
    }
    File localFile = arrayOfFile[i];
    if (localFile.isDirectory()) {
      walkFileTree(localFile, paramFileTreeVisitor);
    }
    for (;;)
    {
      i += 1;
      break;
      paramFileTreeVisitor.visitFile(localFile);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\file\FileTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */