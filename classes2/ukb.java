import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ukb
  extends ukc
{
  int jdField_a_of_type_Int;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public ukb(int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
  }
  
  public ukc a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      ukc localukc = (ukc)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      return localukc;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1);
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(ukc paramukc)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramukc.g, paramukc);
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(60);
    localStringBuilder.append("[ReportStage, id=").append(this.g).append(", cost=").append(this.jdField_b_of_type_Long).append(", failCode=").append(this.h).append(", lastStep=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", ");
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ukc localukc = (ukc)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i));
      if (localukc != null)
      {
        if (i > 0) {
          localStringBuilder.append(" , ");
        }
        localStringBuilder.append(localukc.toString());
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ukb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */