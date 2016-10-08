import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import java.util.ArrayList;
import java.util.List;

public class tko
  extends NearbyObserver
{
  public tko(NearbyVisitorListActivity paramNearbyVisitorListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, byte[] paramArrayOfByte, int paramInt, long paramLong1, String paramString, boolean paramBoolean2, long paramLong2, long paramLong3)
  {
    this.a.jdField_b_of_type_Boolean = false;
    if (paramBoolean2)
    {
      this.a.jdField_b_of_type_Long = paramLong1;
      this.a.c = paramLong2;
      this.a.d = paramLong3;
    }
    if (paramBoolean1)
    {
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      paramString = this.a;
      if (paramInt == 1) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      paramString.jdField_a_of_type_Boolean = bool;
      if (paramBoolean2)
      {
        this.a.f = 0;
        this.a.jdField_a_of_type_JavaUtilList.clear();
      }
      if (paramArrayList != null) {
        this.a.jdField_a_of_type_JavaUtilList.addAll(paramArrayList);
      }
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      this.a.runOnUiThread(new tkp(this, paramBoolean2, paramBoolean1));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */