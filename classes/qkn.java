import com.tencent.mobileqq.app.message.AccostMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class qkn
{
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  public byte[] a;
  public long b;
  public String b;
  public long c;
  public long d;
  public long e;
  
  public qkn(AccostMessageProcessor paramAccostMessageProcessor, long paramLong1, int paramInt, long paramLong2, long paramLong3, ArrayList paramArrayList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramLong2;
    this.c = paramLong3;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public qkn(AccostMessageProcessor paramAccostMessageProcessor, long paramLong, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */