import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class waj
{
  private final int jdField_a_of_type_Int;
  private DataInputStream jdField_a_of_type_JavaIoDataInputStream;
  private DataOutputStream jdField_a_of_type_JavaIoDataOutputStream;
  public FileInputStream a;
  FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private final String jdField_a_of_type_JavaLangString;
  
  public waj(int paramInt, String paramString, FileInputStream paramFileInputStream, FileOutputStream paramFileOutputStream)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFileInputStream = paramFileInputStream;
    this.jdField_a_of_type_JavaIoFileOutputStream = paramFileOutputStream;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public DataInputStream a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaIoFileInputStream != null) {}
      for (this.jdField_a_of_type_JavaIoDataInputStream = new DataInputStream(this.jdField_a_of_type_JavaIoFileInputStream);; this.jdField_a_of_type_JavaIoDataInputStream = null) {
        return this.jdField_a_of_type_JavaIoDataInputStream;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoDataInputStream = null;
      }
    }
  }
  
  public DataOutputStream a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaIoFileOutputStream == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoDataOutputStream != null)
        {
          this.jdField_a_of_type_JavaIoDataOutputStream.close();
          this.jdField_a_of_type_JavaIoDataOutputStream = null;
        }
        if (this.jdField_a_of_type_JavaIoFileOutputStream == null) {
          continue;
        }
        this.jdField_a_of_type_JavaIoDataOutputStream = new DataOutputStream(this.jdField_a_of_type_JavaIoFileOutputStream);
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_JavaIoDataOutputStream = null;
        continue;
      }
      return this.jdField_a_of_type_JavaIoDataOutputStream;
      this.jdField_a_of_type_JavaIoDataOutputStream = null;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaIoDataInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoDataInputStream.close();
      this.jdField_a_of_type_JavaIoDataInputStream = null;
      if (this.jdField_a_of_type_JavaIoDataOutputStream != null) {}
      try
      {
        this.jdField_a_of_type_JavaIoDataOutputStream.close();
        this.jdField_a_of_type_JavaIoDataOutputStream = null;
        if (this.jdField_a_of_type_JavaIoFileInputStream != null) {}
        try
        {
          this.jdField_a_of_type_JavaIoFileInputStream.close();
          this.jdField_a_of_type_JavaIoFileInputStream = null;
          if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
          try
          {
            this.jdField_a_of_type_JavaIoFileOutputStream.close();
            this.jdField_a_of_type_JavaIoFileOutputStream = null;
            return;
          }
          catch (IOException localIOException1)
          {
            for (;;) {}
          }
        }
        catch (IOException localIOException2)
        {
          for (;;) {}
        }
      }
      catch (IOException localIOException3)
      {
        for (;;) {}
      }
    }
    catch (IOException localIOException4)
    {
      for (;;) {}
    }
  }
  
  public String b()
  {
    int i = this.jdField_a_of_type_JavaLangString.lastIndexOf('/');
    return this.jdField_a_of_type_JavaLangString.substring(i + 1, this.jdField_a_of_type_JavaLangString.length());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaIoDataInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoDataInputStream.close();
      this.jdField_a_of_type_JavaIoDataInputStream = null;
      if (this.jdField_a_of_type_JavaIoDataOutputStream != null) {}
      try
      {
        this.jdField_a_of_type_JavaIoDataOutputStream.close();
        this.jdField_a_of_type_JavaIoDataOutputStream = null;
        try
        {
          if (this.jdField_a_of_type_JavaIoFileInputStream != null) {
            this.jdField_a_of_type_JavaIoFileInputStream.close();
          }
          if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
          try
          {
            this.jdField_a_of_type_JavaIoFileOutputStream.close();
            this.jdField_a_of_type_JavaIoFileOutputStream = null;
            return;
          }
          catch (IOException localIOException1)
          {
            for (;;) {}
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
      }
      catch (IOException localIOException2)
      {
        for (;;) {}
      }
    }
    catch (IOException localIOException3)
    {
      for (;;) {}
    }
  }
  
  public String c()
  {
    int i = this.jdField_a_of_type_JavaLangString.lastIndexOf('/');
    String str = this.jdField_a_of_type_JavaLangString.substring(0, i + 1);
    return str.substring("file:///".length(), str.length());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\waj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */