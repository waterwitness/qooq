package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.os.Environment;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FilesDumperPlugin
  implements DumperPlugin
{
  private static final String NAME = "files";
  private final Context mContext;
  
  public FilesDumperPlugin(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void addFiles(ZipOutputStream paramZipOutputStream, byte[] paramArrayOfByte, File[] paramArrayOfFile)
    throws IOException
  {
    int j = paramArrayOfFile.length;
    int i = 0;
    if (i >= j) {
      return;
    }
    Object localObject = paramArrayOfFile[i];
    if (((File)localObject).isDirectory()) {
      addFiles(paramZipOutputStream, paramArrayOfByte, ((File)localObject).listFiles());
    }
    for (;;)
    {
      i += 1;
      break;
      paramZipOutputStream.putNextEntry(new ZipEntry(relativizePath(getBaseDir(this.mContext).getParentFile(), (File)localObject)));
      localObject = new FileInputStream((File)localObject);
      try
      {
        copy((InputStream)localObject, paramZipOutputStream, paramArrayOfByte);
        ((FileInputStream)localObject).close();
      }
      finally
      {
        ((FileInputStream)localObject).close();
      }
    }
  }
  
  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    for (;;)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i < 0) {
        return;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
  }
  
  private void doDownload(PrintStream paramPrintStream, Iterator<String> paramIterator)
    throws DumpUsageException
  {
    bool = false;
    Object localObject2 = ArgsHelper.nextArg(paramIterator, "Must specify output file or '-'");
    ArrayList localArrayList = new ArrayList();
    if (!paramIterator.hasNext()) {}
    for (;;)
    {
      try
      {
        if ("-".equals(localObject2)) {
          paramIterator = new ZipOutputStream(new BufferedOutputStream(paramPrintStream));
        }
        try
        {
          localObject2 = new byte['ࠀ'];
          if (localArrayList.size() > 0) {
            addFiles(paramIterator, (byte[])localObject2, (File[])localArrayList.toArray(new File[localArrayList.size()]));
          }
        }
        finally {}
      }
      catch (IOException paramPrintStream)
      {
        try
        {
          paramIterator.close();
          throw ((Throwable)localObject1);
        }
        catch (IOException paramIterator)
        {
          if (0 == 0) {
            break label206;
          }
        }
        paramPrintStream = paramPrintStream;
        throw new RuntimeException(paramPrintStream);
      }
      try
      {
        paramIterator.close();
        return;
      }
      catch (IOException paramIterator)
      {
        for (;;)
        {
          if (1 != 0) {
            bool = false;
          }
        }
      }
      localArrayList.add(resolvePossibleAppStoragePath(this.mContext, (String)paramIterator.next()));
      break;
      paramPrintStream = new FileOutputStream(resolvePossibleSdcardPath((String)localObject2));
      continue;
      addFiles(paramIterator, (byte[])localObject2, getBaseDir(this.mContext).listFiles());
    }
    for (;;)
    {
      Util.close(paramPrintStream, bool);
      if (0 != 0)
      {
        throw paramIterator;
        for (;;)
        {
          Util.close(paramPrintStream, bool);
          if (1 == 0) {
            break;
          }
          throw paramIterator;
          bool = true;
        }
        label206:
        bool = true;
      }
    }
  }
  
  private void doLs(PrintStream paramPrintStream)
    throws DumpUsageException
  {
    File localFile = getBaseDir(this.mContext);
    if (localFile.isDirectory()) {
      printDirectoryText(localFile, "", paramPrintStream);
    }
  }
  
  private void doTree(PrintStream paramPrintStream)
    throws DumpUsageException
  {
    printDirectoryVisual(getBaseDir(this.mContext), 0, paramPrintStream);
  }
  
  private void doUsage(PrintStream paramPrintStream)
  {
    paramPrintStream.println("Usage: dumpapp files " + "<command> [command-options]");
    paramPrintStream.println("       dumpapp files " + "ls");
    paramPrintStream.println("       dumpapp files " + "tree");
    paramPrintStream.println("       dumpapp files " + "download <output.zip> [<path>...]");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp files ls: List files similar to the ls command");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp files tree: List files similar to the tree command");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp files download: Fetch internal application storage");
    paramPrintStream.println("    <output.zip>: Output location or '-' for stdout");
    paramPrintStream.println("    <path>: Fetch only those paths named (directories fetch recursively)");
  }
  
  private static File getBaseDir(Context paramContext)
  {
    return paramContext.getFilesDir().getParentFile();
  }
  
  private static void printDirectoryText(File paramFile, String paramString, PrintStream paramPrintStream)
  {
    paramFile = paramFile.listFiles();
    int i = 0;
    if (i >= paramFile.length) {
      return;
    }
    File localFile = paramFile[i];
    if (localFile.isDirectory()) {
      printDirectoryText(localFile, paramString + localFile.getName() + "/", paramPrintStream);
    }
    for (;;)
    {
      i += 1;
      break;
      paramPrintStream.println(paramString + localFile.getName());
    }
  }
  
  private static void printDirectoryVisual(File paramFile, int paramInt, PrintStream paramPrintStream)
  {
    paramFile = paramFile.listFiles();
    int i = 0;
    for (;;)
    {
      if (i >= paramFile.length) {
        return;
      }
      printHeaderVisual(paramInt, paramPrintStream);
      File localFile = paramFile[i];
      paramPrintStream.print("+---");
      paramPrintStream.print(localFile.getName());
      paramPrintStream.println();
      if (localFile.isDirectory()) {
        printDirectoryVisual(localFile, paramInt + 1, paramPrintStream);
      }
      i += 1;
    }
  }
  
  private static void printHeaderVisual(int paramInt, PrintStream paramPrintStream)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return;
      }
      paramPrintStream.print("|   ");
      i += 1;
    }
  }
  
  private static String relativizePath(File paramFile1, File paramFile2)
  {
    String str = paramFile1.getAbsolutePath();
    paramFile2 = paramFile2.getAbsolutePath();
    paramFile1 = paramFile2;
    if (paramFile2.startsWith(str)) {
      paramFile1 = paramFile2.substring(str.length() + 1);
    }
    return paramFile1;
  }
  
  private static File resolvePossibleAppStoragePath(Context paramContext, String paramString)
  {
    if (paramString.startsWith("/")) {
      return new File(paramString);
    }
    return new File(getBaseDir(paramContext), paramString);
  }
  
  private static File resolvePossibleSdcardPath(String paramString)
  {
    if (paramString.startsWith("/")) {
      return new File(paramString);
    }
    return new File(Environment.getExternalStorageDirectory(), paramString);
  }
  
  public void dump(DumperContext paramDumperContext)
    throws DumpException
  {
    Iterator localIterator = paramDumperContext.getArgsAsList().iterator();
    String str = ArgsHelper.nextOptionalArg(localIterator, "");
    if ("ls".equals(str)) {
      doLs(paramDumperContext.getStdout());
    }
    do
    {
      return;
      if ("tree".equals(str))
      {
        doTree(paramDumperContext.getStdout());
        return;
      }
      if ("download".equals(str))
      {
        doDownload(paramDumperContext.getStdout(), localIterator);
        return;
      }
      doUsage(paramDumperContext.getStdout());
    } while ("".equals(str));
    throw new DumpUsageException("Unknown command: " + str);
  }
  
  public String getName()
  {
    return "files";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\dumpapp\plugins\FilesDumperPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */