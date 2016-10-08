import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class wdm
  implements wdr
{
  public wdm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Integer a(float paramFloat, Integer paramInteger1, Integer paramInteger2)
  {
    int i = paramInteger1.intValue();
    float f = i;
    return Integer.valueOf((int)((paramInteger2.intValue() - i) * paramFloat + f));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */