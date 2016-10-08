package cooperation.plugin;

import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class IPluginManager$PluginParams
{
  int a;
  public Dialog a;
  public Intent a;
  public ServiceConnection a;
  public PreloadProcHitPluginSession a;
  public Class a;
  public String a;
  public List a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public IPluginManager$PluginParams(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.b = -1;
    this.jdField_a_of_type_Boolean = true;
    this.c = 10000;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\IPluginManager$PluginParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */