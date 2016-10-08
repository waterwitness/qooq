package com.tencent.mqp.app.dbfs;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.ByteArrayOutputStream;

public class DBStoredFile$FileOutputStream
  extends ByteArrayOutputStream
{
  public DBStoredFile$FileOutputStream(DBStoredFile paramDBStoredFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void close()
  {
    flush();
  }
  
  public void flush()
  {
    this.a.a(toByteArray());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\dbfs\DBStoredFile$FileOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */