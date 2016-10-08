import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ujt
{
  public float a;
  public float b;
  public float c;
  
  public ujt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("[latitude = ").append(this.b).append(", longitude = ").append(this.a).append(", altitude = ").append(this.c).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ujt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */