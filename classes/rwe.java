import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rwe
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  
  public rwe(FileTransferHandler paramFileTransferHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(false, 0L, null, null, 0);
  }
  
  public rwe(FileTransferHandler paramFileTransferHandler, long paramLong, FileTransferObserver paramFileTransferObserver)
  {
    a(false, paramLong, null, paramFileTransferObserver, 0);
  }
  
  public rwe(FileTransferHandler paramFileTransferHandler, FileTransferObserver paramFileTransferObserver)
  {
    a(false, 0L, null, paramFileTransferObserver, 0);
  }
  
  public rwe(FileTransferHandler paramFileTransferHandler, String paramString)
  {
    a(false, 0L, paramString, null, 0);
  }
  
  public rwe(FileTransferHandler paramFileTransferHandler, boolean paramBoolean, long paramLong)
  {
    a(paramBoolean, paramLong, null, null, 0);
  }
  
  public rwe(FileTransferHandler paramFileTransferHandler, boolean paramBoolean, long paramLong, FileTransferObserver paramFileTransferObserver, int paramInt)
  {
    a(paramBoolean, paramLong, null, paramFileTransferObserver, paramInt);
  }
  
  public rwe(FileTransferHandler paramFileTransferHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, FileTransferObserver paramFileTransferObserver)
  {
    a(false, 0L, null, paramFileTransferObserver, 0);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.c = paramArrayOfByte3;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FileTransferObserver paramFileTransferObserver, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = paramFileTransferObserver;
    this.jdField_a_of_type_JavaLangObject = null;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public FileTransferObserver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */