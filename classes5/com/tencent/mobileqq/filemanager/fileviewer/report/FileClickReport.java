package com.tencent.mobileqq.filemanager.fileviewer.report;

import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewReport;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FileClickReport
  implements BaseActionBar.IActionBarClickEvent, IFileViewReport
{
  private boolean a;
  
  public FileClickReport(boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBoolean;
  }
  
  public void a()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BBE");
      return;
    }
    FileManagerReporter.a("0X8004BD4");
  }
  
  public void b()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC2");
      return;
    }
    FileManagerReporter.a("0X8004BD8");
  }
  
  public void b(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (str != null) {
        FileManagerReporter.a(str);
      }
      return;
      if (this.a)
      {
        str = "0X8004BB5";
      }
      else
      {
        str = "0X8004BCA";
        continue;
        if (this.a) {
          str = "0X8004BB4";
        } else {
          str = "0X8004BC9";
        }
      }
    }
  }
  
  public void c()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BBF");
      return;
    }
    FileManagerReporter.a("0X8004BD5");
  }
  
  public void d()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC0");
      return;
    }
    FileManagerReporter.a("0X8004BD6");
  }
  
  public void e()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC6");
      return;
    }
    FileManagerReporter.a("0X8004BDC");
  }
  
  public void f()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC3");
      return;
    }
    FileManagerReporter.a("0X8004BD9");
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC5");
      return;
    }
    FileManagerReporter.a("0X8004BDB");
  }
  
  public void j()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC4");
      return;
    }
    FileManagerReporter.a("0X8004BDA");
  }
  
  public void k()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BBD");
      return;
    }
    FileManagerReporter.a("0X8004BD3");
  }
  
  public void l()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC1");
      return;
    }
    FileManagerReporter.a("0X8004BD7");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\report\FileClickReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */