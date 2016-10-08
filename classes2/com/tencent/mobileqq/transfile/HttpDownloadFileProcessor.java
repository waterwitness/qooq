package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HttpDownloadFileProcessor
  extends BaseTransProcessor
  implements IHttpCommunicatorListener
{
  protected QQAppInterface a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public HttpDownloadFileProcessor(String paramString1, String paramString2, TransFileController paramTransFileController)
  {
    super(paramTransFileController);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg("", paramString1, 1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(paramString1);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile = new File(paramString2 + ".tmp");
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.getParentFile();
      if ((paramString1 != null) && (!paramString1.exists())) {
        paramString1.mkdirs();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.exists()) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString2 + ".tmp");
      return;
    }
    catch (FileNotFoundException paramString1) {}
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == null)) {
      b(null, null);
    }
    this.jdField_a_of_type_Boolean = false;
    HttpMsg localHttpMsg = new HttpMsg(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k, null, this, true);
    localHttpMsg.b(5);
    localHttpMsg.a(true);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e + ".tmp");
      localHttpMsg.b(false);
      localHttpMsg.a("Accept-Encoding", "identity");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localHttpMsg);
      d(2001);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        b(null, null);
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
            break label68;
          }
          throw new Exception("send or recv mFile==null");
        }
        catch (Exception paramHttpMsg1)
        {
          if (paramHttpMsg1.toString().equals("java.io.IOException: No space left on device")) {
            d(2006);
          }
          b(null, null);
        }
        return;
      }
      label68:
      if (paramHttpMsg1 != this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
        throw new Exception("send or recv req!=mFile.curRequest");
      }
      if ((paramHttpMsg2.c() == 200) || (paramHttpMsg2.c() == 206))
      {
        n();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream != null)
        {
          paramHttpMsg1 = paramHttpMsg2.a();
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream.write(paramHttpMsg1);
          paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
          paramHttpMsg1.f += paramHttpMsg2.a().length;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramHttpMsg2.a();
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f == paramHttpMsg2.a())
          {
            m();
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a();
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = 0L;
            paramHttpMsg1 = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.renameTo(paramHttpMsg1))
            {
              this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.setLastModified(System.currentTimeMillis());
              b(false);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
              d(2003);
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
              d(2004);
            }
          }
          else
          {
            h();
          }
        }
      }
    }
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "HttpDownloadFileProcessor statusChanged(),status is:" + paramInt);
    }
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    j();
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public void j()
  {
    super.j();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a();
    d(2004);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
  }
  
  public void k()
  {
    super.k();
  }
  
  protected void l()
  {
    m();
    j();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\HttpDownloadFileProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */