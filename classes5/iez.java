import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class iez
  extends FilterOutputStream
{
  public int a;
  
  public iez(PubAccountHttpDownloader paramPubAccountHttpDownloader, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void write(int paramInt)
  {
    this.jdField_a_of_type_Int += 1;
    this.out.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int += paramInt2;
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */