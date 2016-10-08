import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.securitysdk.utils.ApkExternalInfoTool;
import com.tencent.securitysdk.utils.ZipLong;
import com.tencent.securitysdk.utils.ZipShort;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class xqs
{
  public Properties a;
  byte[] a;
  
  private xqs()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilProperties = new Properties();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    ByteBuffer localByteBuffer;
    int i;
    int j;
    do
    {
      do
      {
        int k;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
                  i = ApkExternalInfoTool.a().a().length;
                  arrayOfByte = new byte[i];
                  localByteBuffer.get(arrayOfByte);
                  if (!ApkExternalInfoTool.a().equals(new ZipLong(arrayOfByte))) {
                    break;
                  }
                } while (paramArrayOfByte.length - i <= 2);
                arrayOfByte = new byte[2];
                localByteBuffer.get(arrayOfByte);
                j = new ZipShort(arrayOfByte).a();
              } while (paramArrayOfByte.length - i - 2 < j);
              arrayOfByte = new byte[j];
              localByteBuffer.get(arrayOfByte);
              this.jdField_a_of_type_JavaUtilProperties.load(new ByteArrayInputStream(arrayOfByte));
              i = paramArrayOfByte.length - i - j - 2;
            } while (i <= 0);
            j = ApkExternalInfoTool.b().a().length;
            paramArrayOfByte = new byte[j];
            localByteBuffer.get(paramArrayOfByte);
          } while ((!ApkExternalInfoTool.b().equals(new ZipLong(paramArrayOfByte))) || (i - j <= 2));
          paramArrayOfByte = new byte[2];
          localByteBuffer.get(paramArrayOfByte);
          k = new ZipShort(paramArrayOfByte).a();
        } while (i - j - 2 < k);
        this.jdField_a_of_type_ArrayOfByte = new byte[k];
        localByteBuffer.get(this.jdField_a_of_type_ArrayOfByte);
        return;
        if (!ApkExternalInfoTool.b().equals(new ZipLong(arrayOfByte))) {
          break;
        }
        j = ApkExternalInfoTool.b().a().length;
      } while (paramArrayOfByte.length - i <= 2);
      byte[] arrayOfByte = new byte[2];
      localByteBuffer.get(arrayOfByte);
      i = new ZipShort(arrayOfByte).a();
    } while (paramArrayOfByte.length - j - 2 < i);
    this.jdField_a_of_type_ArrayOfByte = new byte[i];
    localByteBuffer.get(this.jdField_a_of_type_ArrayOfByte);
    return;
    throw new ProtocolException("unknow protocl [" + Arrays.toString(paramArrayOfByte) + "]");
  }
  
  public byte[] a()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (this.jdField_a_of_type_JavaUtilProperties.size() > 0)
    {
      localByteArrayOutputStream.write(ApkExternalInfoTool.a().a());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilProperties.keySet().iterator();
      Object localObject2;
      for (Object localObject1 = ""; localIterator.hasNext(); localObject1 = (String)localObject1 + localObject2 + "=" + this.jdField_a_of_type_JavaUtilProperties.getProperty((String)localObject2) + "\r\n") {
        localObject2 = localIterator.next();
      }
      localObject1 = ((String)localObject1).getBytes();
      localByteArrayOutputStream.write(new ZipShort(localObject1.length).a());
      localByteArrayOutputStream.write((byte[])localObject1);
    }
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      localByteArrayOutputStream.write(ApkExternalInfoTool.b().a());
      localByteArrayOutputStream.write(new ZipShort(this.jdField_a_of_type_ArrayOfByte.length).a());
      localByteArrayOutputStream.write(this.jdField_a_of_type_ArrayOfByte);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */