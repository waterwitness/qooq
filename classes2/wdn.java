import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class wdn
  implements wdr
{
  public wdn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Float a(float paramFloat, Number paramNumber1, Number paramNumber2)
  {
    float f = paramNumber1.floatValue();
    return Float.valueOf(f + (paramNumber2.floatValue() - f) * paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */