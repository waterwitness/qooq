import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.random.RandomWebProtocol.OnRequestListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class gko
  extends Thread
{
  gkp jdField_a_of_type_Gkp;
  gkt jdField_a_of_type_Gkt;
  List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  
  public gko(RandomWebProtocol paramRandomWebProtocol, gkp paramgkp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramRandomWebProtocol.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Gkp = paramgkp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] quitMatch. result: " + paramInt);
    }
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Gkt != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((RandomWebProtocol.OnRequestListener)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramInt, this.jdField_a_of_type_Gkt);
        i += 1;
      }
    }
    a();
    if (this.jdField_a_of_type_Gkp != null) {
      this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Gkp.d);
    }
  }
  
  public void run()
  {
    this.jdField_a_of_type_Gkt = null;
    if (this.jdField_a_of_type_Gkp != null)
    {
      if (1 != this.jdField_a_of_type_Gkp.e) {
        break label85;
      }
      this.jdField_a_of_type_Gkt = new gku(this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol);
    }
    while ((this.jdField_a_of_type_Gkp == null) || (this.jdField_a_of_type_Gkp.c == null) || (this.jdField_a_of_type_Gkp.c.equals("")) || (this.jdField_a_of_type_Gkt == null))
    {
      a(true, -2);
      return;
      label85:
      if (2 == this.jdField_a_of_type_Gkp.e) {
        this.jdField_a_of_type_Gkt = new gkw(this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol);
      } else if (3 == this.jdField_a_of_type_Gkp.e) {
        this.jdField_a_of_type_Gkt = new gkx(this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol);
      }
    }
    if (this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.jdField_a_of_type_Boolean) {}
    for (String str1 = this.jdField_a_of_type_Gkp.b();; str1 = this.jdField_a_of_type_Gkp.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb] json post:" + str1);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(false, -2);
      return;
    }
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - l < this.jdField_a_of_type_Gkt.u)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(false, -2);
        return;
      }
      String str2 = RandomWebProtocol.a(this.jdField_a_of_type_Gkp.c, str1, null);
      if (QLog.isColorLevel())
      {
        QLog.d("RandomWebProtocol", 2, "[randomWeb] json result:" + str2);
        QLog.d("RandomWebProtocol", 2, "[pullhead] -------- json result:" + str2);
      }
      if (this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Gkt.b(str2);
      }
      label343:
      switch (this.jdField_a_of_type_Gkt.t)
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
      case 1000: 
      case -1002: 
      case -1: 
      case 7: 
        for (int i = 1; i != 0; i = 0)
        {
          try
          {
            Thread.sleep(this.jdField_a_of_type_Gkt.v);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          break;
          this.jdField_a_of_type_Gkt.a(localInterruptedException);
          break label343;
          a(true, 0);
          return;
        }
      case -1003: 
      case -1000: 
      case 4: 
      case 6: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
        a(true, -2);
        return;
      case -1015: 
      case 13: 
        a(true, -3);
        return;
      case -1006: 
        a(true, 100);
        return;
      }
    }
    a(true, -1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */